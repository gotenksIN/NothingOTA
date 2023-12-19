package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m41d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m40d2 = {"Landroidx/compose/material3/ElevationDefaults;", "", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.material3.ElevationDefaults */
/* loaded from: classes.dex */
public final class Elevation {
    public static final Elevation INSTANCE = new Elevation();

    private Elevation() {
    }

    public final AnimationSpec<C0780Dp> incomingAnimationSpecForInteraction(Interaction interaction) {
        TweenSpec tweenSpec;
        TweenSpec tweenSpec2;
        TweenSpec tweenSpec3;
        TweenSpec tweenSpec4;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction.Press) {
            tweenSpec4 = ElevationKt.DefaultIncomingSpec;
            return tweenSpec4;
        } else if (interaction instanceof DragInteraction.Start) {
            tweenSpec3 = ElevationKt.DefaultIncomingSpec;
            return tweenSpec3;
        } else if (interaction instanceof HoverInteraction.Enter) {
            tweenSpec2 = ElevationKt.DefaultIncomingSpec;
            return tweenSpec2;
        } else if (interaction instanceof FocusInteraction.Focus) {
            tweenSpec = ElevationKt.DefaultIncomingSpec;
            return tweenSpec;
        } else {
            return null;
        }
    }

    public final AnimationSpec<C0780Dp> outgoingAnimationSpecForInteraction(Interaction interaction) {
        TweenSpec tweenSpec;
        TweenSpec tweenSpec2;
        TweenSpec tweenSpec3;
        TweenSpec tweenSpec4;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (interaction instanceof PressInteraction.Press) {
            tweenSpec4 = ElevationKt.DefaultOutgoingSpec;
            return tweenSpec4;
        } else if (interaction instanceof DragInteraction.Start) {
            tweenSpec3 = ElevationKt.DefaultOutgoingSpec;
            return tweenSpec3;
        } else if (interaction instanceof HoverInteraction.Enter) {
            tweenSpec2 = ElevationKt.HoveredOutgoingSpec;
            return tweenSpec2;
        } else if (interaction instanceof FocusInteraction.Focus) {
            tweenSpec = ElevationKt.DefaultOutgoingSpec;
            return tweenSpec;
        } else {
            return null;
        }
    }
}
