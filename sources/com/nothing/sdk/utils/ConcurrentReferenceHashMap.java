package com.nothing.sdk.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class ConcurrentReferenceHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final ReferenceType DEFAULT_REFERENCE_TYPE = ReferenceType.SOFT;
    private static final int MAXIMUM_CONCURRENCY_LEVEL = 65536;
    private static final int MAXIMUM_SEGMENT_SIZE = 1073741824;
    private Set<Map.Entry<K, V>> entrySet;
    private final float loadFactor;
    private final ReferenceType referenceType;
    private final ConcurrentReferenceHashMap<K, V>.Segment[] segments;
    private final int shift;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface Reference<K, V> {
        Entry<K, V> get();

        int getHash();

        Reference<K, V> getNext();

        void release();
    }

    /* loaded from: classes2.dex */
    public enum ReferenceType {
        SOFT,
        WEAK
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum Restructure {
        WHEN_NECESSARY,
        NEVER
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TaskOption {
        RESTRUCTURE_BEFORE,
        RESTRUCTURE_AFTER,
        SKIP_IF_EMPTY,
        RESIZE
    }

    protected static int calculateShift(int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        while (i4 < i && i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    public ConcurrentReferenceHashMap() {
        this(16, 0.75f, 16, DEFAULT_REFERENCE_TYPE);
    }

    public ConcurrentReferenceHashMap(int i) {
        this(i, 0.75f, 16, DEFAULT_REFERENCE_TYPE);
    }

    public ConcurrentReferenceHashMap(int i, float f) {
        this(i, f, 16, DEFAULT_REFERENCE_TYPE);
    }

    public ConcurrentReferenceHashMap(int i, int i2) {
        this(i, 0.75f, i2, DEFAULT_REFERENCE_TYPE);
    }

    public ConcurrentReferenceHashMap(int i, ReferenceType referenceType) {
        this(i, 0.75f, 16, referenceType);
    }

    public ConcurrentReferenceHashMap(int i, float f, int i2) {
        this(i, f, i2, DEFAULT_REFERENCE_TYPE);
    }

    public ConcurrentReferenceHashMap(int i, float f, int i2, ReferenceType referenceType) {
        int i3 = 0;
        Assert.isTrue(i >= 0, "Initial capacity must not be negative");
        Assert.isTrue(f > 0.0f, "Load factor must be positive");
        Assert.isTrue(i2 > 0, "Concurrency level must be positive");
        Assert.notNull(referenceType, "Reference type must not be null");
        this.loadFactor = f;
        int calculateShift = calculateShift(i2, 65536);
        this.shift = calculateShift;
        int i4 = 1 << calculateShift;
        this.referenceType = referenceType;
        int i5 = (int) (((i + i4) - 1) / i4);
        this.segments = (Segment[]) Array.newInstance(Segment.class, i4);
        while (true) {
            ConcurrentReferenceHashMap<K, V>.Segment[] segmentArr = this.segments;
            if (i3 >= segmentArr.length) {
                return;
            }
            segmentArr[i3] = new Segment(i5);
            i3++;
        }
    }

    protected final float getLoadFactor() {
        return this.loadFactor;
    }

    protected final int getSegmentsSize() {
        return this.segments.length;
    }

    protected final ConcurrentReferenceHashMap<K, V>.Segment getSegment(int i) {
        return this.segments[i];
    }

    protected ConcurrentReferenceHashMap<K, V>.ReferenceManager createReferenceManager() {
        return new ReferenceManager();
    }

    protected int getHash(Object obj) {
        int hashCode = obj == null ? 0 : obj.hashCode();
        int i = hashCode + ((hashCode << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (i4 << 2) + (i4 << 14);
        return i5 ^ (i5 >>> 16);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Reference<K, V> reference = getReference(obj, Restructure.WHEN_NECESSARY);
        Entry<K, V> entry = reference != null ? reference.get() : null;
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Reference<K, V> reference = getReference(obj, Restructure.WHEN_NECESSARY);
        Entry<K, V> entry = reference != null ? reference.get() : null;
        return entry != null && ObjectUtils.nullSafeEquals(entry.getKey(), obj);
    }

    protected final Reference<K, V> getReference(Object obj, Restructure restructure) {
        int hash = getHash(obj);
        return getSegmentForHash(hash).getReference(obj, hash, restructure);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return put(k, v, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return put(k, v, false);
    }

    private V put(K k, final V v, final boolean z) {
        return (V) doTask(k, (ConcurrentReferenceHashMap<K, V>.Task<V>) new ConcurrentReferenceHashMap<K, V>.Task<V>(new TaskOption[]{TaskOption.RESTRUCTURE_BEFORE, TaskOption.RESIZE}) { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Task
            protected V execute(Reference<K, V> reference, Entry<K, V> entry, ConcurrentReferenceHashMap<K, V>.Entries entries) {
                if (entry != 0) {
                    V v2 = (V) entry.getValue();
                    if (z) {
                        entry.setValue(v);
                    }
                    return v2;
                }
                entries.add(v);
                return null;
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) doTask(obj, (ConcurrentReferenceHashMap<K, V>.Task<V>) new ConcurrentReferenceHashMap<K, V>.Task<V>(TaskOption.RESTRUCTURE_AFTER, TaskOption.SKIP_IF_EMPTY) { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.2
            @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Task
            protected V execute(Reference<K, V> reference, Entry<K, V> entry) {
                if (entry != null) {
                    reference.release();
                    return (V) ((Entry) entry).value;
                }
                return null;
            }
        });
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, final Object obj2) {
        return ((Boolean) doTask(obj, (ConcurrentReferenceHashMap<K, V>.Task<Boolean>) new ConcurrentReferenceHashMap<K, V>.Task<Boolean>(new TaskOption[]{TaskOption.RESTRUCTURE_AFTER, TaskOption.SKIP_IF_EMPTY}) { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Task
            public Boolean execute(Reference<K, V> reference, Entry<K, V> entry) {
                if (entry != null && ObjectUtils.nullSafeEquals(entry.getValue(), obj2)) {
                    reference.release();
                    return true;
                }
                return false;
            }
        })).booleanValue();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, final V v, final V v2) {
        return ((Boolean) doTask(k, (ConcurrentReferenceHashMap<K, V>.Task<Boolean>) new ConcurrentReferenceHashMap<K, V>.Task<Boolean>(new TaskOption[]{TaskOption.RESTRUCTURE_BEFORE, TaskOption.SKIP_IF_EMPTY}) { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Task
            public Boolean execute(Reference<K, V> reference, Entry<K, V> entry) {
                if (entry != 0 && ObjectUtils.nullSafeEquals(entry.getValue(), v)) {
                    entry.setValue(v2);
                    return true;
                }
                return false;
            }
        })).booleanValue();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, final V v) {
        return (V) doTask(k, (ConcurrentReferenceHashMap<K, V>.Task<V>) new ConcurrentReferenceHashMap<K, V>.Task<V>(new TaskOption[]{TaskOption.RESTRUCTURE_BEFORE, TaskOption.SKIP_IF_EMPTY}) { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Task
            protected V execute(Reference<K, V> reference, Entry<K, V> entry) {
                if (entry != 0) {
                    V v2 = (V) entry.getValue();
                    entry.setValue(v);
                    return v2;
                }
                return null;
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (ConcurrentReferenceHashMap<K, V>.Segment segment : this.segments) {
            segment.clear();
        }
    }

    public void purgeUnreferencedEntries() {
        for (ConcurrentReferenceHashMap<K, V>.Segment segment : this.segments) {
            segment.restructureIfNecessary(false);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        int i = 0;
        for (ConcurrentReferenceHashMap<K, V>.Segment segment : this.segments) {
            i += segment.getCount();
        }
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    private <T> T doTask(Object obj, ConcurrentReferenceHashMap<K, V>.Task<T> task) {
        int hash = getHash(obj);
        return (T) getSegmentForHash(hash).doTask(hash, obj, task);
    }

    private ConcurrentReferenceHashMap<K, V>.Segment getSegmentForHash(int i) {
        ConcurrentReferenceHashMap<K, V>.Segment[] segmentArr = this.segments;
        return segmentArr[(i >>> (32 - this.shift)) & (segmentArr.length - 1)];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class Segment extends ReentrantLock {
        private volatile int count = 0;
        private final int initialSize;
        private final ConcurrentReferenceHashMap<K, V>.ReferenceManager referenceManager;
        private volatile Reference<K, V>[] references;
        private int resizeThreshold;

        public Segment(int i) {
            this.referenceManager = ConcurrentReferenceHashMap.this.createReferenceManager();
            int calculateShift = 1 << ConcurrentReferenceHashMap.calculateShift(i, 1073741824);
            this.initialSize = calculateShift;
            setReferences(createReferenceArray(calculateShift));
        }

        public Reference<K, V> getReference(Object obj, int i, Restructure restructure) {
            if (restructure == Restructure.WHEN_NECESSARY) {
                restructureIfNecessary(false);
            }
            if (this.count == 0) {
                return null;
            }
            Reference<K, V>[] referenceArr = this.references;
            return findInChain(referenceArr[getIndex(i, referenceArr)], obj, i);
        }

        public <T> T doTask(final int i, final Object obj, ConcurrentReferenceHashMap<K, V>.Task<T> task) {
            boolean hasOption = task.hasOption(TaskOption.RESIZE);
            if (task.hasOption(TaskOption.RESTRUCTURE_BEFORE)) {
                restructureIfNecessary(hasOption);
            }
            if (task.hasOption(TaskOption.SKIP_IF_EMPTY) && this.count == 0) {
                return task.execute(null, null, null);
            }
            lock();
            try {
                final int index = getIndex(i, this.references);
                final Reference<K, V> reference = this.references[index];
                Reference<K, V> findInChain = findInChain(reference, obj, i);
                return task.execute(findInChain, findInChain != null ? findInChain.get() : null, new ConcurrentReferenceHashMap<K, V>.Entries() { // from class: com.nothing.sdk.utils.ConcurrentReferenceHashMap.Segment.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Entries
                    public void add(V v) {
                        Segment.this.references[index] = Segment.this.referenceManager.createReference(new Entry<>(obj, v), i, reference);
                        Segment.this.count++;
                    }
                });
            } finally {
                unlock();
                if (task.hasOption(TaskOption.RESTRUCTURE_AFTER)) {
                    restructureIfNecessary(hasOption);
                }
            }
        }

        public void clear() {
            if (this.count == 0) {
                return;
            }
            lock();
            try {
                setReferences(createReferenceArray(this.initialSize));
                this.count = 0;
            } finally {
                unlock();
            }
        }

        protected final void restructureIfNecessary(boolean z) {
            boolean z2 = true;
            boolean z3 = this.count > 0 && this.count >= this.resizeThreshold;
            Reference<K, V> pollForPurge = this.referenceManager.pollForPurge();
            if (pollForPurge != null || (z3 && z)) {
                lock();
                try {
                    int i = this.count;
                    Set emptySet = Collections.emptySet();
                    if (pollForPurge != null) {
                        emptySet = new HashSet();
                        while (pollForPurge != null) {
                            emptySet.add(pollForPurge);
                            pollForPurge = this.referenceManager.pollForPurge();
                        }
                    }
                    int size = i - emptySet.size();
                    boolean z4 = size > 0 && size >= this.resizeThreshold;
                    int length = this.references.length;
                    if (z && z4 && length < 1073741824) {
                        length <<= 1;
                    } else {
                        z2 = false;
                    }
                    Reference<K, V>[] createReferenceArray = z2 ? createReferenceArray(length) : this.references;
                    for (int i2 = 0; i2 < this.references.length; i2++) {
                        if (!z2) {
                            createReferenceArray[i2] = null;
                        }
                        for (Reference<K, V> reference = this.references[i2]; reference != null; reference = reference.getNext()) {
                            if (!emptySet.contains(reference) && reference.get() != null) {
                                int index = getIndex(reference.getHash(), createReferenceArray);
                                createReferenceArray[index] = this.referenceManager.createReference(reference.get(), reference.getHash(), createReferenceArray[index]);
                            }
                        }
                    }
                    if (z2) {
                        setReferences(createReferenceArray);
                    }
                    this.count = Math.max(size, 0);
                } finally {
                    unlock();
                }
            }
        }

        private Reference<K, V> findInChain(Reference<K, V> reference, Object obj, int i) {
            Entry<K, V> entry;
            K key;
            while (reference != null) {
                if (reference.getHash() == i && (entry = reference.get()) != null && ((key = entry.getKey()) == obj || key.equals(obj))) {
                    return reference;
                }
                reference = reference.getNext();
            }
            return null;
        }

        private Reference<K, V>[] createReferenceArray(int i) {
            return (Reference[]) Array.newInstance(Reference.class, i);
        }

        private int getIndex(int i, Reference<K, V>[] referenceArr) {
            return i & (referenceArr.length - 1);
        }

        private void setReferences(Reference<K, V>[] referenceArr) {
            this.references = referenceArr;
            this.resizeThreshold = (int) (referenceArr.length * ConcurrentReferenceHashMap.this.getLoadFactor());
        }

        public final int getSize() {
            return this.references.length;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private volatile V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return ObjectUtils.nullSafeEquals(getKey(), entry.getKey()) && ObjectUtils.nullSafeEquals(getValue(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return ObjectUtils.nullSafeHashCode(this.key) ^ ObjectUtils.nullSafeHashCode(this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class Task<T> {
        private final EnumSet<TaskOption> options;

        protected T execute(Reference<K, V> reference, Entry<K, V> entry) {
            return null;
        }

        public Task(TaskOption... taskOptionArr) {
            this.options = taskOptionArr.length == 0 ? EnumSet.noneOf(TaskOption.class) : EnumSet.of(taskOptionArr[0], taskOptionArr);
        }

        public boolean hasOption(TaskOption taskOption) {
            return this.options.contains(taskOption);
        }

        protected T execute(Reference<K, V> reference, Entry<K, V> entry, ConcurrentReferenceHashMap<K, V>.Entries entries) {
            return execute(reference, entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class Entries {
        public abstract void add(V v);

        private Entries() {
        }
    }

    /* loaded from: classes2.dex */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Reference<K, V> reference = ConcurrentReferenceHashMap.this.getReference(entry.getKey(), Restructure.NEVER);
            Entry<K, V> entry2 = reference != null ? reference.get() : null;
            if (entry2 != null) {
                return ObjectUtils.nullSafeEquals(entry.getValue(), entry2.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return ConcurrentReferenceHashMap.this.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentReferenceHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentReferenceHashMap.this.clear();
        }
    }

    /* loaded from: classes2.dex */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Entry<K, V> last;
        private Entry<K, V> next;
        private Reference<K, V> reference;
        private int referenceIndex;
        private Reference<K, V>[] references;
        private int segmentIndex;

        public EntryIterator() {
            moveToNextSegment();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            getNextIfNecessary();
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Entry<K, V> next() {
            getNextIfNecessary();
            Entry<K, V> entry = this.next;
            if (entry == null) {
                throw new NoSuchElementException();
            }
            this.last = entry;
            this.next = null;
            return entry;
        }

        private void getNextIfNecessary() {
            while (this.next == null) {
                moveToNextReference();
                Reference<K, V> reference = this.reference;
                if (reference == null) {
                    return;
                }
                this.next = reference.get();
            }
        }

        private void moveToNextReference() {
            Reference<K, V>[] referenceArr;
            Reference<K, V> reference = this.reference;
            if (reference != null) {
                this.reference = reference.getNext();
            }
            while (this.reference == null && (referenceArr = this.references) != null) {
                int i = this.referenceIndex;
                if (i >= referenceArr.length) {
                    moveToNextSegment();
                    this.referenceIndex = 0;
                } else {
                    this.reference = referenceArr[i];
                    this.referenceIndex = i + 1;
                }
            }
        }

        private void moveToNextSegment() {
            this.reference = null;
            this.references = null;
            if (this.segmentIndex < ConcurrentReferenceHashMap.this.segments.length) {
                this.references = ConcurrentReferenceHashMap.this.segments[this.segmentIndex].references;
                this.segmentIndex++;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Assert.state(this.last != null);
            ConcurrentReferenceHashMap.this.remove(this.last.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class ReferenceManager {
        private final ReferenceQueue<Entry<K, V>> queue = new ReferenceQueue<>();

        protected ReferenceManager() {
        }

        public Reference<K, V> createReference(Entry<K, V> entry, int i, Reference<K, V> reference) {
            if (ConcurrentReferenceHashMap.this.referenceType == ReferenceType.WEAK) {
                return new WeakEntryReference(entry, i, reference, this.queue);
            }
            return new SoftEntryReference(entry, i, reference, this.queue);
        }

        public Reference<K, V> pollForPurge() {
            return (Reference) this.queue.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SoftEntryReference<K, V> extends SoftReference<Entry<K, V>> implements Reference<K, V> {
        private final int hash;
        private final Reference<K, V> nextReference;

        @Override // java.lang.ref.SoftReference, java.lang.ref.Reference, com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public /* bridge */ /* synthetic */ Entry get() {
            return (Entry) super.get();
        }

        public SoftEntryReference(Entry<K, V> entry, int i, Reference<K, V> reference, ReferenceQueue<Entry<K, V>> referenceQueue) {
            super(entry, referenceQueue);
            this.hash = i;
            this.nextReference = reference;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public int getHash() {
            return this.hash;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public Reference<K, V> getNext() {
            return this.nextReference;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public void release() {
            enqueue();
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class WeakEntryReference<K, V> extends WeakReference<Entry<K, V>> implements Reference<K, V> {
        private final int hash;
        private final Reference<K, V> nextReference;

        @Override // java.lang.ref.Reference, com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public /* bridge */ /* synthetic */ Entry get() {
            return (Entry) super.get();
        }

        public WeakEntryReference(Entry<K, V> entry, int i, Reference<K, V> reference, ReferenceQueue<Entry<K, V>> referenceQueue) {
            super(entry, referenceQueue);
            this.hash = i;
            this.nextReference = reference;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public int getHash() {
            return this.hash;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public Reference<K, V> getNext() {
            return this.nextReference;
        }

        @Override // com.nothing.sdk.utils.ConcurrentReferenceHashMap.Reference
        public void release() {
            enqueue();
            clear();
        }
    }
}
