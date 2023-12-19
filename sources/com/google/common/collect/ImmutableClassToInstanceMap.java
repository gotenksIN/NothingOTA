package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"B"})
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.m192of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* renamed from: of */
    public static <B> ImmutableClassToInstanceMap<B> m213of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* renamed from: of */
    public static <B, T extends B> ImmutableClassToInstanceMap<B> m212of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.m191of(cls, t));
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        public <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.mapBuilder.put(cls, t);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.mapBuilder.put(key, cast(key, entry.getValue()));
            }
            return this;
        }

        private static <B, T extends B> T cast(Class<T> cls, B b) {
            return (T) Primitives.wrap(cls).cast(b);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> buildOrThrow = this.mapBuilder.buildOrThrow();
            if (buildOrThrow.isEmpty()) {
                return ImmutableClassToInstanceMap.m213of();
            }
            return new ImmutableClassToInstanceMap<>(buildOrThrow);
        }
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new Builder().putAll(map).build();
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T extends B, java.lang.Object] */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(Preconditions.checkNotNull(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        return isEmpty() ? m213of() : this;
    }
}
