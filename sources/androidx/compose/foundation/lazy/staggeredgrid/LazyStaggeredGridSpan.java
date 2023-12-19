package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m40d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "isFullSpan", "", "itemIndex", "", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider */
/* loaded from: classes.dex */
public final class LazyStaggeredGridSpan {
    private final IntervalList<LazyStaggeredGridIntervalContent> intervals;

    public LazyStaggeredGridSpan(IntervalList<LazyStaggeredGridIntervalContent> intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.intervals = intervals;
    }

    public final IntervalList<LazyStaggeredGridIntervalContent> getIntervals() {
        return this.intervals;
    }

    public final boolean isFullSpan(int i) {
        if (i >= 0 && i < this.intervals.getSize()) {
            IntervalList.Interval<LazyStaggeredGridIntervalContent> interval = this.intervals.get(i);
            Function1<Integer, StaggeredGridItemSpan> span = interval.getValue().getSpan();
            return span != null && span.invoke(Integer.valueOf(i - interval.getStartIndex())) == StaggeredGridItemSpan.Companion.getFullLine();
        }
        return false;
    }
}
