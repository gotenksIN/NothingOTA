package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Elevation.kt */
@Metadata(m41d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0007\u001a\u00020\b*\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m40d2 = {"DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "OutgoingSpecEasing", "Landroidx/compose/animation/core/Easing;", "animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class ElevationKt {
    private static final TweenSpec<C0780Dp> DefaultIncomingSpec;
    private static final TweenSpec<C0780Dp> DefaultOutgoingSpec;
    private static final TweenSpec<C0780Dp> HoveredOutgoingSpec;
    private static final Easing OutgoingSpecEasing;

    /* renamed from: animateElevation-rAjV9yQ$default  reason: not valid java name */
    public static /* synthetic */ Object m1423animateElevationrAjV9yQ$default(Animatable animatable, float f, Interaction interaction, Interaction interaction2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            interaction = null;
        }
        if ((i & 4) != 0) {
            interaction2 = null;
        }
        return m1422animateElevationrAjV9yQ(animatable, f, interaction, interaction2, continuation);
    }

    /* renamed from: animateElevation-rAjV9yQ  reason: not valid java name */
    public static final Object m1422animateElevationrAjV9yQ(Animatable<C0780Dp, ?> animatable, float f, Interaction interaction, Interaction interaction2, Continuation<? super Unit> continuation) {
        AnimationSpec<C0780Dp> outgoingAnimationSpecForInteraction;
        if (interaction2 != null) {
            outgoingAnimationSpecForInteraction = Elevation.INSTANCE.incomingAnimationSpecForInteraction(interaction2);
        } else {
            outgoingAnimationSpecForInteraction = interaction != null ? Elevation.INSTANCE.outgoingAnimationSpecForInteraction(interaction) : null;
        }
        AnimationSpec<C0780Dp> animationSpec = outgoingAnimationSpecForInteraction;
        if (animationSpec != null) {
            Object animateTo$default = Animatable.animateTo$default(animatable, C0780Dp.m5349boximpl(f), animationSpec, null, null, continuation, 12, null);
            return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
        }
        Object snapTo = animatable.snapTo(C0780Dp.m5349boximpl(f), continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    static {
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f);
        OutgoingSpecEasing = cubicBezierEasing;
        DefaultIncomingSpec = new TweenSpec<>(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        DefaultOutgoingSpec = new TweenSpec<>(150, 0, cubicBezierEasing, 2, null);
        HoveredOutgoingSpec = new TweenSpec<>(120, 0, cubicBezierEasing, 2, null);
    }
}
