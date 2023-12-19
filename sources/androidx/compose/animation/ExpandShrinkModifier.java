package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntOffsetKt;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import androidx.compose.p002ui.unit.LayoutDirection;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(m41d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Bt\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010(J)\u0010+\u001a\u00020,*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R*\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR1\u0010\u001d\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001e¢\u0006\u0002\b!ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, m40d2 = {"Landroidx/compose/animation/ExpandShrinkModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getAlignment", "()Landroidx/compose/runtime/State;", "currentAlignment", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getExpand", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getShrink", "getSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final State<Alignment> alignment;
    private Alignment currentAlignment;
    private final State<EnterExitTransition> expand;
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private final State<EnterExitTransition> shrink;
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec;

    /* compiled from: EnterExitTransition.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final State<EnterExitTransition> getExpand() {
        return this.expand;
    }

    public final State<EnterExitTransition> getShrink() {
        return this.shrink;
    }

    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandShrinkModifier(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation, State<EnterExitTransition> expand, State<EnterExitTransition> shrink, State<? extends Alignment> alignment) {
        Intrinsics.checkNotNullParameter(sizeAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(offsetAnimation, "offsetAnimation");
        Intrinsics.checkNotNullParameter(expand, "expand");
        Intrinsics.checkNotNullParameter(shrink, "shrink");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.sizeAnimation = sizeAnimation;
        this.offsetAnimation = offsetAnimation;
        this.expand = expand;
        this.shrink = shrink;
        this.alignment = alignment;
        this.sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$sizeTransitionSpec$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                SpringSpec springSpec3 = null;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    EnterExitTransition value = ExpandShrinkModifier.this.getExpand().getValue();
                    if (value != null) {
                        springSpec3 = value.getAnimationSpec();
                    }
                } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    springSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                    springSpec3 = springSpec;
                } else {
                    EnterExitTransition value2 = ExpandShrinkModifier.this.getShrink().getValue();
                    if (value2 != null) {
                        springSpec3 = value2.getAnimationSpec();
                    }
                }
                if (springSpec3 == null) {
                    springSpec2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                    return springSpec2;
                }
                return springSpec3;
            }
        };
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    public final long m360sizeByStateUzc_VyU(EnterExitState targetState, long j) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        EnterExitTransition value = this.expand.getValue();
        long m5515unboximpl = value != null ? value.getSize().invoke(IntSize.m5503boximpl(j)).m5515unboximpl() : j;
        EnterExitTransition value2 = this.shrink.getValue();
        long m5515unboximpl2 = value2 != null ? value2.getSize().invoke(IntSize.m5503boximpl(j)).m5515unboximpl() : j;
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return m5515unboximpl2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return m5515unboximpl;
        }
        return j;
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m361targetOffsetByStateoFUgxo0(EnterExitState targetState, long j) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        if (this.currentAlignment != null && this.alignment.getValue() != null && !Intrinsics.areEqual(this.currentAlignment, this.alignment.getValue())) {
            int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        EnterExitTransition value = this.shrink.getValue();
                        if (value != null) {
                            long m5515unboximpl = value.getSize().invoke(IntSize.m5503boximpl(j)).m5515unboximpl();
                            Alignment value2 = this.alignment.getValue();
                            Intrinsics.checkNotNull(value2);
                            long mo2513alignKFBX0sM = value2.mo2513alignKFBX0sM(j, m5515unboximpl, LayoutDirection.Ltr);
                            Alignment alignment = this.currentAlignment;
                            Intrinsics.checkNotNull(alignment);
                            long mo2513alignKFBX0sM2 = alignment.mo2513alignKFBX0sM(j, m5515unboximpl, LayoutDirection.Ltr);
                            return IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(mo2513alignKFBX0sM) - IntOffset.m5469getXimpl(mo2513alignKFBX0sM2), IntOffset.m5470getYimpl(mo2513alignKFBX0sM) - IntOffset.m5470getYimpl(mo2513alignKFBX0sM2));
                        }
                        return IntOffset.Companion.m5479getZeronOccac();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return IntOffset.Companion.m5479getZeronOccac();
            }
            return IntOffset.Companion.m5479getZeronOccac();
        }
        return IntOffset.Companion.m5479getZeronOccac();
    }

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo326measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo4376measureBRTryo0.getWidth(), mo4376measureBRTryo0.getHeight());
        long m5515unboximpl = this.sizeAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$currentSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(EnterExitState enterExitState) {
                return IntSize.m5503boximpl(m362invokeYEO4UFw(enterExitState));
            }

            /* renamed from: invoke-YEO4UFw  reason: not valid java name */
            public final long m362invokeYEO4UFw(EnterExitState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ExpandShrinkModifier.this.m360sizeByStateUzc_VyU(it, IntSize);
            }
        }).getValue().m5515unboximpl();
        final long m5478unboximpl = this.offsetAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> animate) {
                SpringSpec springSpec;
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                springSpec = EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                return springSpec;
            }
        }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                return IntOffset.m5460boximpl(m363invokeBjo55l4(enterExitState));
            }

            /* renamed from: invoke-Bjo55l4  reason: not valid java name */
            public final long m363invokeBjo55l4(EnterExitState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ExpandShrinkModifier.this.m361targetOffsetByStateoFUgxo0(it, IntSize);
            }
        }).getValue().m5478unboximpl();
        Alignment alignment = this.currentAlignment;
        final long mo2513alignKFBX0sM = alignment != null ? alignment.mo2513alignKFBX0sM(IntSize, m5515unboximpl, LayoutDirection.Ltr) : IntOffset.Companion.m5479getZeronOccac();
        return MeasureScope.layout$default(measure, IntSize.m5511getWidthimpl(m5515unboximpl), IntSize.m5510getHeightimpl(m5515unboximpl), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place$default(layout, Placeable.this, IntOffset.m5469getXimpl(mo2513alignKFBX0sM) + IntOffset.m5469getXimpl(m5478unboximpl), IntOffset.m5470getYimpl(mo2513alignKFBX0sM) + IntOffset.m5470getYimpl(m5478unboximpl), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
