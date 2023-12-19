package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.R;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyLayoutItemProvider.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B^\u0012A\u0010\u0004\u001a=\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\b\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0002\u0010!J*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0003J\u0012\u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\nH\u0016JT\u0010'\u001a\u0002H(\"\u0004\b\u0001\u0010(2\u0006\u0010\u000b\u001a\u00020\n26\u0010)\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H(0\u0005H\u0082\b¢\u0006\u0002\u0010,R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014RN\u0010\u0004\u001a=\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\b\r¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyLayoutItemsProvider;", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemContentProvider", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "interval", "", "index", "", "Landroidx/compose/runtime/Composable;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getItemContentProvider", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "itemCount", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "(ILandroidx/compose/runtime/Composer;I)V", "generateKeyToIndexMap", "range", "list", "getContentType", "getKey", "withLocalIntervalIndex", "T", "block", "localIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {
    private final IntervalList<IntervalContent> intervals;
    private final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> itemContentProvider;
    private final Map<Object, Integer> keyToIndexMap;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultLazyLayoutItemsProvider(Function4<? super IntervalList.Interval<? extends IntervalContent>, ? super Integer, ? super Composer, ? super Integer, Unit> itemContentProvider, IntervalList<? extends IntervalContent> intervals, IntRange nearestItemsRange) {
        Intrinsics.checkNotNullParameter(itemContentProvider, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        this.itemContentProvider = itemContentProvider;
        this.intervals = intervals;
        this.keyToIndexMap = generateKeyToIndexMap(nearestItemsRange, intervals);
    }

    public final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervals.getSize();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(final int i, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1877726744);
        ComposerKt.sourceInformation(startRestartGroup, "C(Item)117@4181L44:LazyLayoutItemProvider.kt#wow0x6");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877726744, i3, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:116)");
            }
            this.itemContentProvider.invoke(this.intervals.get(i), Integer.valueOf(i), startRestartGroup, Integer.valueOf((i3 << 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider$Item$1
            final /* synthetic */ DefaultLazyLayoutItemsProvider<IntervalContent> $tmp0_rcvr;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$tmp0_rcvr = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                this.$tmp0_rcvr.Item(i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }

    private final <T> T withLocalIntervalIndex(int i, Function2<? super Integer, ? super IntervalContent, ? extends T> function2) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
        return function2.invoke(Integer.valueOf(i - interval.getStartIndex()), interval.getValue());
    }

    private final Map<Object, Integer> generateKeyToIndexMap(IntRange intRange, IntervalList<? extends LazyLayoutIntervalContent> intervalList) {
        final int first = intRange.getFirst();
        if (!(first >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        final int min = Math.min(intRange.getLast(), intervalList.getSize() - 1);
        if (min < first) {
            return MapsKt.emptyMap();
        }
        final HashMap hashMap = new HashMap();
        intervalList.forEach(first, min, new Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntervalList.Interval<? extends LazyLayoutIntervalContent> interval) {
                invoke2(interval);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(IntervalList.Interval<? extends LazyLayoutIntervalContent> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getValue().getKey() == null) {
                    return;
                }
                Function1<Integer, Object> key = it.getValue().getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                int max = Math.max(first, it.getStartIndex());
                int min2 = Math.min(min, (it.getStartIndex() + it.getSize()) - 1);
                if (max > min2) {
                    return;
                }
                while (true) {
                    hashMap.put(key.invoke(Integer.valueOf(max - it.getStartIndex())), Integer.valueOf(max));
                    if (max == min2) {
                        return;
                    }
                    max++;
                }
            }
        });
        return hashMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int i) {
        Object invoke;
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
        int startIndex = i - interval.getStartIndex();
        Function1<Integer, Object> key = interval.getValue().getKey();
        return (key == null || (invoke = key.invoke(Integer.valueOf(startIndex))) == null) ? Lazy_androidKt.getDefaultLazyLayoutKey(i) : invoke;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getContentType(int i) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
        return interval.getValue().getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }
}
