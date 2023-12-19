package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListItemPlacementAnimator.kt */
@Metadata(m41d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0002J;\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0019ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J4\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(J\u0018\u00100\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002J\u0014\u00102\u001a\u00020\u0005*\u00020\r2\u0006\u00103\u001a\u00020\bH\u0002J\u001c\u00104\u001a\u00020\u0019*\u00020\bH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000fj\b\u0012\u0004\u0012\u00020\u0001`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\b*\u00020\u00198BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, m40d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "firstVisibleIndex", "", "keyToIndexMap", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "movingInFromStartBound", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "createItemInfo", "item", "mainAxisOffset", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "itemInfo", "isWithinBounds", "mainAxisLayoutSize", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final LinkedHashSet<Object> movingAwayKeys;
    private final List<LazyMeasuredItem> movingAwayToEndBound;
    private final List<LazyMeasuredItem> movingAwayToStartBound;
    private final List<LazyListPositionedItem> movingInFromEndBound;
    private final List<LazyListPositionedItem> movingInFromStartBound;
    private final CoroutineScope scope;

    public LazyListItemPlacementAnimator(CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isVertical = z;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.movingAwayKeys = new LinkedHashSet<>();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m821getAnimatedOffsetYT5a7pE(Object key, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long m5478unboximpl = placeableInfo.getAnimatedOffset().getValue().m5478unboximpl();
        long m817getNotAnimatableDeltanOccac = itemInfo.m817getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m5478unboximpl) + IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac), IntOffset.m5470getYimpl(m5478unboximpl) + IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac));
        long m839getTargetOffsetnOccac = placeableInfo.m839getTargetOffsetnOccac();
        long m817getNotAnimatableDeltanOccac2 = itemInfo.m817getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m839getTargetOffsetnOccac) + IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac2), IntOffset.m5470getYimpl(m839getTargetOffsetnOccac) + IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m819getMainAxisgyyYBs(IntOffset2) <= i2 && m819getMainAxisgyyYBs(IntOffset) <= i2) || (m819getMainAxisgyyYBs(IntOffset2) >= i3 && m819getMainAxisgyyYBs(IntOffset) >= i3))) {
            BuildersKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return IntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListPositionedItem lazyListPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyListItemPlacementAnimator.m819getMainAxisgyyYBs(lazyListPositionedItem.m830getOffsetBjo55l4(0));
        }
        return lazyListItemPlacementAnimator.createItemInfo(lazyListPositionedItem, i);
    }

    private final ItemInfo createItemInfo(LazyListPositionedItem lazyListPositionedItem, int i) {
        long m5465copyiSbpLlY$default;
        ItemInfo itemInfo = new ItemInfo();
        long m830getOffsetBjo55l4 = lazyListPositionedItem.m830getOffsetBjo55l4(0);
        if (this.isVertical) {
            m5465copyiSbpLlY$default = IntOffset.m5465copyiSbpLlY$default(m830getOffsetBjo55l4, 0, i, 1, null);
        } else {
            m5465copyiSbpLlY$default = IntOffset.m5465copyiSbpLlY$default(m830getOffsetBjo55l4, i, 0, 2, null);
        }
        int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            long m830getOffsetBjo55l42 = lazyListPositionedItem.m830getOffsetBjo55l4(i2);
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m830getOffsetBjo55l42) - IntOffset.m5469getXimpl(m830getOffsetBjo55l4), IntOffset.m5470getYimpl(m830getOffsetBjo55l42) - IntOffset.m5470getYimpl(m830getOffsetBjo55l4));
            itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m5465copyiSbpLlY$default) + IntOffset.m5469getXimpl(IntOffset), IntOffset.m5470getYimpl(m5465copyiSbpLlY$default) + IntOffset.m5470getYimpl(IntOffset)), lazyListPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyListPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long m830getOffsetBjo55l4 = lazyListPositionedItem.m830getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long m817getNotAnimatableDeltanOccac = itemInfo.m817getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m830getOffsetBjo55l4) - IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac), IntOffset.m5470getYimpl(m830getOffsetBjo55l4) - IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac)), lazyListPositionedItem.getMainAxisSize(size), null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long m839getTargetOffsetnOccac = placeableInfo.m839getTargetOffsetnOccac();
            long m817getNotAnimatableDeltanOccac2 = itemInfo.m817getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m839getTargetOffsetnOccac) + IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac2), IntOffset.m5470getYimpl(m839getTargetOffsetnOccac) + IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac2));
            long m830getOffsetBjo55l42 = lazyListPositionedItem.m830getOffsetBjo55l4(i);
            placeableInfo.setMainAxisSize(lazyListPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m5468equalsimpl0(IntOffset, m830getOffsetBjo55l42)) {
                long m817getNotAnimatableDeltanOccac3 = itemInfo.m817getNotAnimatableDeltanOccac();
                placeableInfo.m840setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m830getOffsetBjo55l42) - IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac3), IntOffset.m5470getYimpl(m830getOffsetBjo55l42) - IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    BuildersKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
        }
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List<PlaceableInfo> placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = placeables.get(i2);
            long m839getTargetOffsetnOccac = placeableInfo.m839getTargetOffsetnOccac();
            long m817getNotAnimatableDeltanOccac = itemInfo.m817getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m839getTargetOffsetnOccac) + IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac), IntOffset.m5470getYimpl(m839getTargetOffsetnOccac) + IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac));
            if (m819getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m819getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m820toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m819getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5470getYimpl(j) : IntOffset.m5469getXimpl(j);
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyListPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider) {
        boolean z;
        boolean z2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        int size = positionedItems.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                z = false;
                break;
            } else if (positionedItems.get(i6).getHasAnimations()) {
                z = true;
                break;
            } else {
                i6++;
            }
        }
        if (!z && this.keyToItemInfoMap.isEmpty()) {
            reset();
            return;
        }
        int i7 = this.firstVisibleIndex;
        LazyListPositionedItem lazyListPositionedItem = (LazyListPositionedItem) CollectionsKt.firstOrNull((List<? extends Object>) positionedItems);
        this.firstVisibleIndex = lazyListPositionedItem != null ? lazyListPositionedItem.getIndex() : 0;
        final Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = itemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m820toOffsetBjo55l4 = m820toOffsetBjo55l4(i);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = positionedItems.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyListPositionedItem lazyListPositionedItem2 = positionedItems.get(i9);
            this.movingAwayKeys.remove(lazyListPositionedItem2.getKey());
            if (lazyListPositionedItem2.getHasAnimations()) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyListPositionedItem2.getKey());
                if (itemInfo == null) {
                    Integer num = map.get(lazyListPositionedItem2.getKey());
                    if (num != null && lazyListPositionedItem2.getIndex() != num.intValue()) {
                        if (num.intValue() < i7) {
                            this.movingInFromStartBound.add(lazyListPositionedItem2);
                        } else {
                            this.movingInFromEndBound.add(lazyListPositionedItem2);
                        }
                        i4 = i7;
                        i5 = size2;
                    } else {
                        i4 = i7;
                        i5 = size2;
                        this.keyToItemInfoMap.put(lazyListPositionedItem2.getKey(), createItemInfo$default(this, lazyListPositionedItem2, 0, 2, null));
                    }
                } else {
                    i4 = i7;
                    i5 = size2;
                    long m817getNotAnimatableDeltanOccac = itemInfo.m817getNotAnimatableDeltanOccac();
                    itemInfo.m818setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m817getNotAnimatableDeltanOccac) + IntOffset.m5469getXimpl(m820toOffsetBjo55l4), IntOffset.m5470getYimpl(m817getNotAnimatableDeltanOccac) + IntOffset.m5470getYimpl(m820toOffsetBjo55l4)));
                    startAnimationsIfNeeded(lazyListPositionedItem2, itemInfo);
                }
            } else {
                i4 = i7;
                i5 = size2;
                this.keyToItemInfoMap.remove(lazyListPositionedItem2.getKey());
            }
            i9++;
            size2 = i5;
            i7 = i4;
        }
        int i10 = 0;
        List<LazyListPositionedItem> list = this.movingInFromStartBound;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyListPositionedItem) t2).getKey()), (Integer) map.get(((LazyListPositionedItem) t).getKey()));
                }
            });
        }
        List<LazyListPositionedItem> list2 = this.movingInFromStartBound;
        int size3 = list2.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size3; i12++) {
            LazyListPositionedItem lazyListPositionedItem3 = list2.get(i12);
            int size4 = (0 - i11) - lazyListPositionedItem3.getSize();
            i11 += lazyListPositionedItem3.getSize();
            ItemInfo createItemInfo = createItemInfo(lazyListPositionedItem3, size4);
            this.keyToItemInfoMap.put(lazyListPositionedItem3.getKey(), createItemInfo);
            startAnimationsIfNeeded(lazyListPositionedItem3, createItemInfo);
        }
        List<LazyListPositionedItem> list3 = this.movingInFromEndBound;
        if (list3.size() > 1) {
            CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyListPositionedItem) t).getKey()), (Integer) map.get(((LazyListPositionedItem) t2).getKey()));
                }
            });
        }
        List<LazyListPositionedItem> list4 = this.movingInFromEndBound;
        int size5 = list4.size();
        int i13 = 0;
        for (int i14 = 0; i14 < size5; i14++) {
            LazyListPositionedItem lazyListPositionedItem4 = list4.get(i14);
            int i15 = i8 + i13;
            i13 += lazyListPositionedItem4.getSize();
            ItemInfo createItemInfo2 = createItemInfo(lazyListPositionedItem4, i15);
            this.keyToItemInfoMap.put(lazyListPositionedItem4.getKey(), createItemInfo2);
            startAnimationsIfNeeded(lazyListPositionedItem4, createItemInfo2);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            Integer num2 = this.keyToIndexMap.get(obj);
            List<PlaceableInfo> placeables = itemInfo2.getPlaceables();
            int size6 = placeables.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size6) {
                    z2 = false;
                    break;
                } else if (placeables.get(i16).getInProgress()) {
                    z2 = true;
                    break;
                } else {
                    i16++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || (!z2 && !isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyMeasuredItem m837getAndMeasureZjPyQlc = itemProvider.m837getAndMeasureZjPyQlc(DataIndex.m805constructorimpl(num2.intValue()));
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m837getAndMeasureZjPyQlc);
                } else {
                    this.movingAwayToEndBound.add(m837getAndMeasureZjPyQlc);
                }
            }
        }
        List<LazyMeasuredItem> list5 = this.movingAwayToStartBound;
        if (list5.size() > 1) {
            CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    map3 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues((Integer) map2.get(((LazyMeasuredItem) t2).getKey()), (Integer) map3.get(((LazyMeasuredItem) t).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list6 = this.movingAwayToStartBound;
        int size7 = list6.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size7; i18++) {
            LazyMeasuredItem lazyMeasuredItem = list6.get(i18);
            int size8 = (0 - i17) - lazyMeasuredItem.getSize();
            i17 += lazyMeasuredItem.getSize();
            LazyListPositionedItem position = lazyMeasuredItem.position(size8, i2, i3);
            positionedItems.add(position);
            startAnimationsIfNeeded(position, (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem.getKey()));
        }
        List<LazyMeasuredItem> list7 = this.movingAwayToEndBound;
        if (list7.size() > 1) {
            CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    map3 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues((Integer) map2.get(((LazyMeasuredItem) t).getKey()), (Integer) map3.get(((LazyMeasuredItem) t2).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list8 = this.movingAwayToEndBound;
        int size9 = list8.size();
        for (int i19 = 0; i19 < size9; i19++) {
            LazyMeasuredItem lazyMeasuredItem2 = list8.get(i19);
            int i20 = i8 + i10;
            i10 += lazyMeasuredItem2.getSize();
            LazyListPositionedItem position2 = lazyMeasuredItem2.position(i20, i2, i3);
            positionedItems.add(position2);
            startAnimationsIfNeeded(position2, (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem2.getKey()));
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }
}
