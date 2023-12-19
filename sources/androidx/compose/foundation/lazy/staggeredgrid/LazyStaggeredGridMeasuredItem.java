package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ&\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "", "index", "", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "(ILjava/lang/Object;Ljava/util/List;ZIII)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "()Ljava/lang/Object;", "getLane", "mainAxisSize", "getMainAxisSize", "getPlaceables", "()Ljava/util/List;", "sizeWithSpacings", "getSizeWithSpacings", "getSpacing", "getSpan", "position", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "mainAxis", "crossAxis", "mainAxisLayoutSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LazyStaggeredGridMeasuredItem {
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private final int mainAxisSize;
    private final List<Placeable> placeables;
    private final int sizeWithSpacings;
    private final int spacing;
    private final int span;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridMeasuredItem(int i, Object key, List<? extends Placeable> placeables, boolean z, int i2, int i3, int i4) {
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.index = i;
        this.key = key;
        this.placeables = placeables;
        this.isVertical = z;
        this.spacing = i2;
        this.lane = i3;
        this.span = i4;
        int i5 = 1;
        this.isVisible = true;
        int i6 = 0;
        int size = placeables.size();
        for (int i7 = 0; i7 < size; i7++) {
            Placeable placeable = (Placeable) placeables.get(i7);
            i6 = Integer.valueOf(i6.intValue() + (this.isVertical ? placeable.getHeight() : placeable.getWidth()));
        }
        int intValue = i6.intValue();
        this.mainAxisSize = intValue;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(intValue + this.spacing, 0);
        List<Placeable> list = this.placeables;
        if (list.isEmpty()) {
            num = null;
        } else {
            Placeable placeable2 = list.get(0);
            Integer valueOf = Integer.valueOf(this.isVertical ? placeable2.getWidth() : placeable2.getHeight());
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                while (true) {
                    Placeable placeable3 = list.get(i5);
                    Integer valueOf2 = Integer.valueOf(this.isVertical ? placeable3.getWidth() : placeable3.getHeight());
                    valueOf = valueOf2.compareTo(valueOf) > 0 ? valueOf2 : valueOf;
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        this.crossAxisSize = num2 != null ? num2.intValue() : 0;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final LazyStaggeredGridPositionedItem position(int i, int i2, int i3, int i4) {
        long IntOffset;
        long IntSize;
        if (this.isVertical) {
            IntOffset = IntOffsetKt.IntOffset(i3, i2);
        } else {
            IntOffset = IntOffsetKt.IntOffset(i2, i3);
        }
        long j = IntOffset;
        int i5 = this.index;
        Object obj = this.key;
        if (this.isVertical) {
            IntSize = IntSizeKt.IntSize(this.crossAxisSize, this.sizeWithSpacings);
        } else {
            IntSize = IntSizeKt.IntSize(this.sizeWithSpacings, this.crossAxisSize);
        }
        return new LazyStaggeredGridPositionedItem(j, i5, i, obj, IntSize, this.placeables, this.isVertical, i4, null);
    }
}
