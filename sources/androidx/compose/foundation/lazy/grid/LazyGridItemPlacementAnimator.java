package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
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

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\bH\u0002J;\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J<\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u0010 \u001a\u00020\u00162\u0006\u00106\u001a\u00020\rH\u0002J\u0014\u00107\u001a\u00020\u0005*\u00020\r2\u0006\u00108\u001a\u00020\bH\u0002J\u001c\u00109\u001a\u00020\u001c*\u00020\bH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000fj\b\u0012\u0004\u0012\u00020\u0001`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\b*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\b*\u00020\u001c8BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "firstVisibleIndex", "", "keyToIndexMap", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "movingInFromStartBound", "line", "getLine", "(Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;)I", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "createItemInfo", "item", "mainAxisOffset", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "reset", "startAnimationsIfNeeded", "itemInfo", "isWithinBounds", "mainAxisLayoutSize", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final LinkedHashSet<Object> movingAwayKeys;
    private final List<LazyGridMeasuredItem> movingAwayToEndBound;
    private final List<LazyGridMeasuredItem> movingAwayToStartBound;
    private final List<LazyGridPositionedItem> movingInFromEndBound;
    private final List<LazyGridPositionedItem> movingInFromStartBound;
    private final CoroutineScope scope;

    public LazyGridItemPlacementAnimator(CoroutineScope scope, boolean z) {
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
    public final long m574getAnimatedOffsetYT5a7pE(Object key, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long m5177unboximpl = placeableInfo.getAnimatedOffset().getValue().m5177unboximpl();
        long m562getNotAnimatableDeltanOccac = itemInfo.m562getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(m5177unboximpl) + IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac), IntOffset.m5169getYimpl(m5177unboximpl) + IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac));
        long m610getTargetOffsetnOccac = placeableInfo.m610getTargetOffsetnOccac();
        long m562getNotAnimatableDeltanOccac2 = itemInfo.m562getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(m610getTargetOffsetnOccac) + IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac2), IntOffset.m5169getYimpl(m610getTargetOffsetnOccac) + IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m572getMainAxisgyyYBs(IntOffset2) <= i2 && m572getMainAxisgyyYBs(IntOffset) < i2) || (m572getMainAxisgyyYBs(IntOffset2) >= i3 && m572getMainAxisgyyYBs(IntOffset) > i3))) {
            BuildersKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return IntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridPositionedItem lazyGridPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyGridItemPlacementAnimator.m572getMainAxisgyyYBs(lazyGridPositionedItem.mo570getOffsetnOccac());
        }
        return lazyGridItemPlacementAnimator.createItemInfo(lazyGridPositionedItem, i);
    }

    private final ItemInfo createItemInfo(LazyGridPositionedItem lazyGridPositionedItem, int i) {
        long m5164copyiSbpLlY$default;
        ItemInfo itemInfo = new ItemInfo(lazyGridPositionedItem.getCrossAxisSize(), lazyGridPositionedItem.getCrossAxisOffset());
        if (this.isVertical) {
            m5164copyiSbpLlY$default = IntOffset.m5164copyiSbpLlY$default(lazyGridPositionedItem.mo570getOffsetnOccac(), 0, i, 1, null);
        } else {
            m5164copyiSbpLlY$default = IntOffset.m5164copyiSbpLlY$default(lazyGridPositionedItem.mo570getOffsetnOccac(), i, 0, 2, null);
        }
        int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            itemInfo.getPlaceables().add(new PlaceableInfo(m5164copyiSbpLlY$default, lazyGridPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem lazyGridPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyGridPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyGridPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long mo570getOffsetnOccac = lazyGridPositionedItem.mo570getOffsetnOccac();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long m562getNotAnimatableDeltanOccac = itemInfo.m562getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(mo570getOffsetnOccac) - IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac), IntOffset.m5169getYimpl(mo570getOffsetnOccac) - IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac)), lazyGridPositionedItem.getMainAxisSize(size), null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long m610getTargetOffsetnOccac = placeableInfo.m610getTargetOffsetnOccac();
            long m562getNotAnimatableDeltanOccac2 = itemInfo.m562getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(m610getTargetOffsetnOccac) + IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac2), IntOffset.m5169getYimpl(m610getTargetOffsetnOccac) + IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac2));
            long mo570getOffsetnOccac2 = lazyGridPositionedItem.mo570getOffsetnOccac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyGridPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m5167equalsimpl0(IntOffset, mo570getOffsetnOccac2)) {
                long m562getNotAnimatableDeltanOccac3 = itemInfo.m562getNotAnimatableDeltanOccac();
                placeableInfo.m611setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(mo570getOffsetnOccac2) - IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac3), IntOffset.m5169getYimpl(mo570getOffsetnOccac2) - IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    BuildersKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
        }
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List<PlaceableInfo> placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = placeables.get(i2);
            long m610getTargetOffsetnOccac = placeableInfo.m610getTargetOffsetnOccac();
            long m562getNotAnimatableDeltanOccac = itemInfo.m562getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(m610getTargetOffsetnOccac) + IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac), IntOffset.m5169getYimpl(m610getTargetOffsetnOccac) + IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac));
            if (m572getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m572getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m573toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m572getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5169getYimpl(j) : IntOffset.m5168getXimpl(j);
    }

    private final int getLine(LazyGridPositionedItem lazyGridPositionedItem) {
        return this.isVertical ? lazyGridPositionedItem.getRow() : lazyGridPositionedItem.getColumn();
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyGridPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider) {
        boolean z;
        boolean z2;
        long m5015fixedHeightOenEA2s;
        int i4;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        int size = positionedItems.size();
        int i5 = 0;
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
        LazyGridPositionedItem lazyGridPositionedItem = (LazyGridPositionedItem) CollectionsKt.firstOrNull((List<? extends Object>) positionedItems);
        this.firstVisibleIndex = lazyGridPositionedItem != null ? lazyGridPositionedItem.getIndex() : 0;
        final Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = itemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m573toOffsetBjo55l4 = m573toOffsetBjo55l4(i);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = positionedItems.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyGridPositionedItem lazyGridPositionedItem2 = positionedItems.get(i9);
            this.movingAwayKeys.remove(lazyGridPositionedItem2.getKey());
            if (lazyGridPositionedItem2.getHasAnimations()) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridPositionedItem2.getKey());
                if (itemInfo == null) {
                    Integer num = map.get(lazyGridPositionedItem2.getKey());
                    if (num != null && lazyGridPositionedItem2.getIndex() != num.intValue()) {
                        if (num.intValue() < i7) {
                            this.movingInFromStartBound.add(lazyGridPositionedItem2);
                        } else {
                            this.movingInFromEndBound.add(lazyGridPositionedItem2);
                        }
                        i4 = i7;
                    } else {
                        i4 = i7;
                        this.keyToItemInfoMap.put(lazyGridPositionedItem2.getKey(), createItemInfo$default(this, lazyGridPositionedItem2, i5, 2, null));
                    }
                } else {
                    i4 = i7;
                    long m562getNotAnimatableDeltanOccac = itemInfo.m562getNotAnimatableDeltanOccac();
                    itemInfo.m563setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5168getXimpl(m562getNotAnimatableDeltanOccac) + IntOffset.m5168getXimpl(m573toOffsetBjo55l4), IntOffset.m5169getYimpl(m562getNotAnimatableDeltanOccac) + IntOffset.m5169getYimpl(m573toOffsetBjo55l4)));
                    itemInfo.setCrossAxisSize(lazyGridPositionedItem2.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(lazyGridPositionedItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyGridPositionedItem2, itemInfo);
                }
            } else {
                i4 = i7;
                this.keyToItemInfoMap.remove(lazyGridPositionedItem2.getKey());
            }
            i9++;
            i7 = i4;
            i5 = 0;
        }
        List<LazyGridPositionedItem> list = this.movingInFromStartBound;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyGridPositionedItem) t2).getKey()), (Integer) map.get(((LazyGridPositionedItem) t).getKey()));
                }
            });
        }
        List<LazyGridPositionedItem> list2 = this.movingInFromStartBound;
        int size3 = list2.size();
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < size3) {
            LazyGridPositionedItem lazyGridPositionedItem3 = list2.get(i12);
            int line = getLine(lazyGridPositionedItem3);
            if (line != i10 && line == i11) {
                i14 = Math.max(i14, lazyGridPositionedItem3.getMainAxisSize());
            } else {
                i13 += i14;
                i14 = lazyGridPositionedItem3.getMainAxisSize();
                i11 = line;
            }
            ItemInfo createItemInfo = createItemInfo(lazyGridPositionedItem3, (0 - i13) - lazyGridPositionedItem3.getMainAxisSize());
            this.keyToItemInfoMap.put(lazyGridPositionedItem3.getKey(), createItemInfo);
            startAnimationsIfNeeded(lazyGridPositionedItem3, createItemInfo);
            i12++;
            i10 = -1;
        }
        List<LazyGridPositionedItem> list3 = this.movingInFromEndBound;
        if (list3.size() > 1) {
            CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyGridPositionedItem) t).getKey()), (Integer) map.get(((LazyGridPositionedItem) t2).getKey()));
                }
            });
        }
        List<LazyGridPositionedItem> list4 = this.movingInFromEndBound;
        int size4 = list4.size();
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size4; i18++) {
            LazyGridPositionedItem lazyGridPositionedItem4 = list4.get(i18);
            int line2 = getLine(lazyGridPositionedItem4);
            if (line2 != -1 && line2 == i15) {
                i17 = Math.max(i17, lazyGridPositionedItem4.getMainAxisSize());
            } else {
                i16 += i17;
                i17 = lazyGridPositionedItem4.getMainAxisSize();
                i15 = line2;
            }
            ItemInfo createItemInfo2 = createItemInfo(lazyGridPositionedItem4, i8 + i16);
            this.keyToItemInfoMap.put(lazyGridPositionedItem4.getKey(), createItemInfo2);
            startAnimationsIfNeeded(lazyGridPositionedItem4, createItemInfo2);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            Integer num2 = this.keyToIndexMap.get(obj);
            List<PlaceableInfo> placeables = itemInfo2.getPlaceables();
            int size5 = placeables.size();
            int i19 = 0;
            while (true) {
                if (i19 >= size5) {
                    z2 = false;
                    break;
                } else if (placeables.get(i19).getInProgress()) {
                    z2 = true;
                    break;
                } else {
                    i19++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || (!z2 && !isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                int m551constructorimpl = ItemIndex.m551constructorimpl(num2.intValue());
                if (this.isVertical) {
                    m5015fixedHeightOenEA2s = Constraints.Companion.m5016fixedWidthOenEA2s(itemInfo2.getCrossAxisSize());
                } else {
                    m5015fixedHeightOenEA2s = Constraints.Companion.m5015fixedHeightOenEA2s(itemInfo2.getCrossAxisSize());
                }
                LazyGridMeasuredItem m592getAndMeasureednRnyU$default = LazyMeasuredItemProvider.m592getAndMeasureednRnyU$default(itemProvider, m551constructorimpl, 0, m5015fixedHeightOenEA2s, 2, null);
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m592getAndMeasureednRnyU$default);
                } else {
                    this.movingAwayToEndBound.add(m592getAndMeasureednRnyU$default);
                }
            }
        }
        List<LazyGridMeasuredItem> list5 = this.movingAwayToStartBound;
        if (list5.size() > 1) {
            CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    map3 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues((Integer) map2.get(((LazyGridMeasuredItem) t2).getKey()), (Integer) map3.get(((LazyGridMeasuredItem) t).getKey()));
                }
            });
        }
        List<LazyGridMeasuredItem> list6 = this.movingAwayToStartBound;
        int size6 = list6.size();
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        for (int i23 = 0; i23 < size6; i23++) {
            LazyGridMeasuredItem lazyGridMeasuredItem = list6.get(i23);
            int m590getLineIndexOfItem_Ze7BM = spanLayoutProvider.m590getLineIndexOfItem_Ze7BM(lazyGridMeasuredItem.m581getIndexVZbfaAc());
            if (m590getLineIndexOfItem_Ze7BM != -1 && m590getLineIndexOfItem_Ze7BM == i22) {
                i21 = Math.max(i21, lazyGridMeasuredItem.getMainAxisSize());
            } else {
                i20 += i21;
                i21 = lazyGridMeasuredItem.getMainAxisSize();
                i22 = m590getLineIndexOfItem_Ze7BM;
            }
            int mainAxisSize = (0 - i20) - lazyGridMeasuredItem.getMainAxisSize();
            ItemInfo itemInfo3 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyGridMeasuredItem.getKey());
            LazyGridPositionedItem position = lazyGridMeasuredItem.position(mainAxisSize, itemInfo3.getCrossAxisOffset(), i2, i3, -1, -1);
            positionedItems.add(position);
            startAnimationsIfNeeded(position, itemInfo3);
        }
        List<LazyGridMeasuredItem> list7 = this.movingAwayToEndBound;
        if (list7.size() > 1) {
            CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    map3 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues((Integer) map2.get(((LazyGridMeasuredItem) t).getKey()), (Integer) map3.get(((LazyGridMeasuredItem) t2).getKey()));
                }
            });
        }
        List<LazyGridMeasuredItem> list8 = this.movingAwayToEndBound;
        int size7 = list8.size();
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < size7; i27++) {
            LazyGridMeasuredItem lazyGridMeasuredItem2 = list8.get(i27);
            int m590getLineIndexOfItem_Ze7BM2 = spanLayoutProvider.m590getLineIndexOfItem_Ze7BM(lazyGridMeasuredItem2.m581getIndexVZbfaAc());
            if (m590getLineIndexOfItem_Ze7BM2 != -1 && m590getLineIndexOfItem_Ze7BM2 == i24) {
                i25 = Math.max(i25, lazyGridMeasuredItem2.getMainAxisSize());
            } else {
                i26 += i25;
                i25 = lazyGridMeasuredItem2.getMainAxisSize();
                i24 = m590getLineIndexOfItem_Ze7BM2;
            }
            ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyGridMeasuredItem2.getKey());
            LazyGridPositionedItem position2 = lazyGridMeasuredItem2.position(i8 + i26, itemInfo4.getCrossAxisOffset(), i2, i3, -1, -1);
            positionedItems.add(position2);
            startAnimationsIfNeeded(position2, itemInfo4);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }
}
