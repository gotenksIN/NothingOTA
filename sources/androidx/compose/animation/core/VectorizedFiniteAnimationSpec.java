package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVectors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, m40d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public interface VectorizedFiniteAnimationSpec<V extends AnimationVectors> extends VectorizedAnimationSpec<V> {
    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    default boolean isInfinite() {
        return false;
    }

    /* compiled from: VectorizedAnimationSpec.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVectors> V getEndVelocity(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, V initialValue, V targetValue, V initialVelocity) {
            Intrinsics.checkNotNullParameter(initialValue, "initialValue");
            Intrinsics.checkNotNullParameter(targetValue, "targetValue");
            Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
            return (V) VectorizedFiniteAnimationSpec.super.getEndVelocity(initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends AnimationVectors> boolean isInfinite(VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
            return VectorizedFiniteAnimationSpec.super.isInfinite();
        }
    }
}
