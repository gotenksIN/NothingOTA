package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraints;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Padding;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.ConstraintsKt;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.IntOffsetKt;
import androidx.compose.p002ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u001d\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0001¢\u0006\u0002\b\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u0018\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a,\u0010\u001c\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a$\u0010\u001d\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, m40d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "slotSizesSums", "Landroidx/compose/ui/unit/Density;", "", "rememberStaggeredGridMeasurePolicy-nbWgWpA", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt */
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicy {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$WhenMappings */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: rememberStaggeredGridMeasurePolicy-nbWgWpA  reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m939rememberStaggeredGridMeasurePolicynbWgWpA(final LazyStaggeredGridState state, final LazyStaggeredGridItemProvider itemProvider, final PaddingValues contentPadding, final boolean z, final Orientation orientation, final float f, final float f2, final Function2<? super Density, ? super Constraints, int[]> slotSizesSums, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        composer.startReplaceableGroup(1305398815);
        ComposerKt.sourceInformation(composer, "C(rememberStaggeredGridMeasurePolicy)P(7,2!1,5,4,3:c#ui.unit.Dp,1:c#ui.unit.Dp)46@1947L2573:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1305398815, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:37)");
        }
        Object[] objArr = {state, itemProvider, contentPadding, Boolean.valueOf(z), orientation, C0780Dp.m5349boximpl(f), C0780Dp.m5349boximpl(f2), slotSizesSums};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i2 = 0; i2 < 8; i2++) {
            z2 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m940invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m5313unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m940invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                    float beforePadding;
                    float afterPadding;
                    float startPadding;
                    long IntOffset;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraints.m473checkScrollableContainerConstraintsK40F9xA(j, Orientation.this);
                    int[] invoke = slotSizesSums.invoke(lazyLayoutMeasureScope, Constraints.m5295boximpl(j));
                    boolean z3 = Orientation.this == Orientation.Vertical;
                    state.setLaneWidthsPrefixSum$foundation_release(invoke);
                    state.setVertical$foundation_release(z3);
                    state.setSpanProvider$foundation_release(itemProvider.getSpanProvider());
                    beforePadding = LazyStaggeredGridMeasurePolicy.beforePadding(contentPadding, Orientation.this, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i3 = lazyLayoutMeasureScope.mo597roundToPx0680j_4(beforePadding);
                    afterPadding = LazyStaggeredGridMeasurePolicy.afterPadding(contentPadding, Orientation.this, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i4 = lazyLayoutMeasureScope.mo597roundToPx0680j_4(afterPadding);
                    startPadding = LazyStaggeredGridMeasurePolicy.startPadding(contentPadding, Orientation.this, lazyLayoutMeasureScope.getLayoutDirection());
                    int i5 = lazyLayoutMeasureScope.mo597roundToPx0680j_4(startPadding);
                    int m5306getMaxHeightimpl = ((z3 ? Constraints.m5306getMaxHeightimpl(j) : Constraints.m5307getMaxWidthimpl(j)) - i3) - i4;
                    if (z3) {
                        IntOffset = IntOffsetKt.IntOffset(i5, i3);
                    } else {
                        IntOffset = IntOffsetKt.IntOffset(i3, i5);
                    }
                    long j2 = IntOffset;
                    PaddingValues paddingValues = contentPadding;
                    int i6 = lazyLayoutMeasureScope.mo597roundToPx0680j_4(C0780Dp.m5351constructorimpl(Padding.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()) + Padding.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection())));
                    PaddingValues paddingValues2 = contentPadding;
                    LazyStaggeredGridMeasureResult m938measureStaggeredGridBTfHGGE = LazyStaggeredGridMeasureKt.m938measureStaggeredGridBTfHGGE(lazyLayoutMeasureScope, state, itemProvider, invoke, Constraints.m5298copyZbe2FdA$default(j, ConstraintsKt.m5321constrainWidthK40F9xA(j, i6), 0, ConstraintsKt.m5320constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo597roundToPx0680j_4(C0780Dp.m5351constructorimpl(paddingValues2.mo699calculateTopPaddingD9Ej5fM() + paddingValues2.mo696calculateBottomPaddingD9Ej5fM()))), 0, 10, null), z3, z, j2, m5306getMaxHeightimpl, lazyLayoutMeasureScope.mo597roundToPx0680j_4(f), lazyLayoutMeasureScope.mo597roundToPx0680j_4(f2), i3, i4);
                    state.applyMeasureResult$foundation_release(m938measureStaggeredGridBTfHGGE);
                    return m938measureStaggeredGridBTfHGGE;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return paddingValues.mo699calculateTopPaddingD9Ej5fM();
            }
            throw new NoWhenBranchMatchedException();
        }
        return Padding.calculateStartPadding(paddingValues, layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.mo696calculateBottomPaddingD9Ej5fM() : paddingValues.mo699calculateTopPaddingD9Ej5fM();
        } else if (i == 2) {
            if (z) {
                return Padding.calculateEndPadding(paddingValues, layoutDirection);
            }
            return Padding.calculateStartPadding(paddingValues, layoutDirection);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.mo699calculateTopPaddingD9Ej5fM() : paddingValues.mo696calculateBottomPaddingD9Ej5fM();
        } else if (i == 2) {
            if (z) {
                return Padding.calculateStartPadding(paddingValues, layoutDirection);
            }
            return Padding.calculateEndPadding(paddingValues, layoutDirection);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
