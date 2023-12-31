package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p002ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(m41d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0018ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, m40d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlotSums", "", "crossAxisSpacing", "", "measuredItemFactory", "Landroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;", "(ZLandroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;[IILandroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "span", "childConstraints-JhjzzOo", "(II)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
final class LazyStaggeredGridMeasureProvider {
    private final int crossAxisSpacing;
    private final boolean isVertical;
    private final LazyLayoutItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final MeasuredItemFactory measuredItemFactory;
    private final int[] resolvedSlotSums;

    public LazyStaggeredGridMeasureProvider(boolean z, LazyLayoutItemProvider itemProvider, LazyLayoutMeasureScope measureScope, int[] resolvedSlotSums, int i, MeasuredItemFactory measuredItemFactory) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(resolvedSlotSums, "resolvedSlotSums");
        Intrinsics.checkNotNullParameter(measuredItemFactory, "measuredItemFactory");
        this.isVertical = z;
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.resolvedSlotSums = resolvedSlotSums;
        this.crossAxisSpacing = i;
        this.measuredItemFactory = measuredItemFactory;
    }

    /* renamed from: childConstraints-JhjzzOo  reason: not valid java name */
    private final long m941childConstraintsJhjzzOo(int i, int i2) {
        int i3 = (this.resolvedSlotSums[(i + i2) - 1] - (i == 0 ? 0 : this.resolvedSlotSums[i - 1])) + (this.crossAxisSpacing * (i2 - 1));
        if (this.isVertical) {
            return Constraints.Companion.m5317fixedWidthOenEA2s(i3);
        }
        return Constraints.Companion.m5316fixedHeightOenEA2s(i3);
    }

    /* renamed from: getAndMeasure-jy6DScQ  reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m942getAndMeasurejy6DScQ(int i, long j) {
        int i2 = (int) (j >> 32);
        int i3 = ((int) (j & 4294967295L)) - i2;
        return this.measuredItemFactory.createItem(i, i2, i3, this.itemProvider.getKey(i), this.measureScope.mo919measure0kLqBqw(i, m941childConstraintsJhjzzOo(i2, i3)));
    }
}
