package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVectors;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(m41d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, m40d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "getDelayMillis", "()I", "getDurationMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "value", "(Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVectors> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final Map<Integer, Tuples<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorizedKeyframesSpec(Map<Integer, ? extends Tuples<? extends V, ? extends Easing>> keyframes, int i, int i2) {
        Intrinsics.checkNotNullParameter(keyframes, "keyframes");
        this.keyframes = keyframes;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        long clampPlayTime;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        int i = (int) clampPlayTime;
        if (this.keyframes.containsKey(Integer.valueOf(i))) {
            return (V) ((Tuples) MapsKt.getValue(this.keyframes, Integer.valueOf(i))).getFirst();
        }
        if (i >= getDurationMillis()) {
            return targetValue;
        }
        if (i <= 0) {
            return initialValue;
        }
        int durationMillis = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i2 = 0;
        V v = initialValue;
        int i3 = 0;
        for (Map.Entry<Integer, Tuples<V, Easing>> entry : this.keyframes.entrySet()) {
            int intValue = entry.getKey().intValue();
            Tuples<V, Easing> value = entry.getValue();
            if (i > intValue && intValue >= i3) {
                v = value.getFirst();
                linearEasing = value.getSecond();
                i3 = intValue;
            } else if (i < intValue && intValue <= durationMillis) {
                targetValue = value.getFirst();
                durationMillis = intValue;
            }
        }
        float transform = linearEasing.transform((i - i3) / (durationMillis - i3));
        init(initialValue);
        int size$animation_core_release = v.getSize$animation_core_release();
        while (true) {
            V v2 = null;
            if (i2 >= size$animation_core_release) {
                break;
            }
            V v3 = this.valueVector;
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            } else {
                v2 = v3;
            }
            v2.set$animation_core_release(i2, VectorConvertersKt.lerp(v.get$animation_core_release(i2), targetValue.get$animation_core_release(i2), transform));
            i2++;
        }
        V v4 = this.valueVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        return v4;
    }

    private final void init(V v) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        long clampPlayTime;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime <= 0) {
            return initialVelocity;
        }
        VectorizedKeyframesSpec<V> vectorizedKeyframesSpec = this;
        AnimationVectors valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedKeyframesSpec, clampPlayTime - 1, initialValue, targetValue, initialVelocity);
        AnimationVectors valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedKeyframesSpec, clampPlayTime, initialValue, targetValue, initialVelocity);
        init(initialValue);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i = 0;
        while (true) {
            V v = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v2 = this.velocityVector;
            if (v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                v = v2;
            }
            v.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return v3;
    }
}
