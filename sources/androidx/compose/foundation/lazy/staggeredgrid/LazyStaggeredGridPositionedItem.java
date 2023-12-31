package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(m41d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0016J.\u0010&\u001a\u00020\u0003*\u00020\u00032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050(H\u0082\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00020\nX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\u0005*\u00020\r8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m40d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "index", "", "lane", "key", "", "size", "Landroidx/compose/ui/unit/IntSize;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "mainAxisLayoutSize", "(JIILjava/lang/Object;JLjava/util/List;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getLane", "getOffset-nOcc-ac", "()J", "J", "getSize-YbymL2g", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
final class LazyStaggeredGridPositionedItem implements LazyStaggeredGridItemInfo {
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final int mainAxisLayoutSize;
    private final long offset;
    private final List<Placeable> placeables;
    private final long size;

    public /* synthetic */ LazyStaggeredGridPositionedItem(long j, int i, int i2, Object obj, long j2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, i2, obj, j2, list, z, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridPositionedItem(long j, int i, int i2, Object obj, long j2, List<? extends Placeable> list, boolean z, int i3) {
        this.offset = j;
        this.index = i;
        this.lane = i2;
        this.key = obj;
        this.size = j2;
        this.placeables = list;
        this.isVertical = z;
        this.mainAxisLayoutSize = i3;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getOffset-nOcc-ac */
    public long mo928getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getSize-YbymL2g */
    public long mo929getSizeYbymL2g() {
        return this.size;
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasure context) {
        long mo928getOffsetnOccac;
        int m5469getXimpl;
        int m5470getYimpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            if (context.getReverseLayout()) {
                long mo928getOffsetnOccac2 = mo928getOffsetnOccac();
                if (this.isVertical) {
                    m5469getXimpl = IntOffset.m5469getXimpl(mo928getOffsetnOccac2);
                } else {
                    m5469getXimpl = (this.mainAxisLayoutSize - IntOffset.m5469getXimpl(mo928getOffsetnOccac2)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                }
                if (!this.isVertical) {
                    m5470getYimpl = IntOffset.m5470getYimpl(mo928getOffsetnOccac2);
                } else {
                    m5470getYimpl = (this.mainAxisLayoutSize - IntOffset.m5470getYimpl(mo928getOffsetnOccac2)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                }
                mo928getOffsetnOccac = IntOffsetKt.IntOffset(m5469getXimpl, m5470getYimpl);
            } else {
                mo928getOffsetnOccac = mo928getOffsetnOccac();
            }
            long m932getContentOffsetnOccac = context.m932getContentOffsetnOccac();
            Placeable.PlacementScope.m4426placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(mo928getOffsetnOccac) + IntOffset.m5469getXimpl(m932getContentOffsetnOccac), IntOffset.m5470getYimpl(mo928getOffsetnOccac) + IntOffset.m5470getYimpl(m932getContentOffsetnOccac)), 0.0f, null, 6, null);
        }
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m943copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int m5469getXimpl = this.isVertical ? IntOffset.m5469getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m5469getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int m5470getYimpl = IntOffset.m5470getYimpl(j);
        if (z) {
            m5470getYimpl = function1.invoke(Integer.valueOf(m5470getYimpl)).intValue();
        }
        return IntOffsetKt.IntOffset(m5469getXimpl, m5470getYimpl);
    }

    public String toString() {
        return super.toString();
    }
}
