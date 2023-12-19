package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.p002ui.MotionDurationScale;
import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(m41d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016JK\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102JS\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0002J(\u00108\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J(\u0010=\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J)\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@J)\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001d\u0010B\u001a\u00020\u0006*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJ)\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010)\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m40d2 = {"Landroidx/compose/material3/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;)V", "DefaultScrollMotionDurationScaleFactor", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "F", "itemSize", "getItemSize", "()F", "motionScaleDuration", "androidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1", "Landroidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1;", "velocityThreshold", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateDistanceToDesiredSnapPosition", "layoutInfo", "item", "equals", "", "other", "", "findClosestOffset", "velocity", "hashCode", "animateDecay", "Landroidx/compose/material3/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "fling", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longSnap", "performFling", "runApproach", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    private final float DefaultScrollMotionDurationScaleFactor;
    private final float MinFlingVelocityDp;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final LazyListState lazyListState;
    private SnapFlingBehavior$motionScaleDuration$1 motionScaleDuration;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final float velocityThreshold;

    private static final boolean findClosestOffset$isValidDistance(float f) {
        if (!(f == Float.POSITIVE_INFINITY)) {
            if (!(f == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1] */
    public SnapFlingBehavior(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec, Density density) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(snapAnimationSpec, "snapAnimationSpec");
        Intrinsics.checkNotNullParameter(density, "density");
        this.lazyListState = lazyListState;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = snapAnimationSpec;
        this.density = density;
        this.velocityThreshold = density.mo603toPx0680j_4(this.MinFlingVelocityDp);
        this.motionScaleDuration = new MotionDurationScale() { // from class: androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1
            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
                return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
                return (E) MotionDurationScale.DefaultImpls.get(this, key);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
                return MotionDurationScale.DefaultImpls.minusKey(this, key);
            }

            @Override // kotlin.coroutines.CoroutineContext
            public CoroutineContext plus(CoroutineContext coroutineContext) {
                return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
            }

            @Override // androidx.compose.p002ui.MotionDurationScale
            public float getScaleFactor() {
                float f;
                f = SnapFlingBehavior.this.DefaultScrollMotionDurationScaleFactor;
                return f;
            }
        };
        this.DefaultScrollMotionDurationScaleFactor = 1.0f;
        this.MinFlingVelocityDp = C0780Dp.m5351constructorimpl(400);
    }

    private final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
    }

    private final float getItemSize() {
        if (!getVisibleItemsInfo().isEmpty()) {
            List<LazyListItemInfo> visibleItemsInfo = getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += visibleItemsInfo.get(i2).getSize();
            }
            return i / getVisibleItemsInfo().size();
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$performFling$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.label = r3
            java.lang.Object r7 = r4.fling(r5, r6, r0)
            if (r7 != r1) goto L3e
            return r1
        L3e:
            androidx.compose.material3.AnimationResult r7 = (androidx.compose.material3.AnimationResult) r7
            java.lang.Object r5 = r7.component1()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.animation.core.AnimationState r6 = r7.component2()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L54
            goto L55
        L54:
            r3 = 0
        L55:
            if (r3 == 0) goto L58
            goto L62
        L58:
            java.lang.Object r5 = r6.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = r5.floatValue()
        L62:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollScope r6, float r7, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.material3.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$fling$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1 r8 = r5.motionScaleDuration
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            androidx.compose.material3.SnapFlingBehavior$fling$result$1 r2 = new androidx.compose.material3.SnapFlingBehavior$fling$result$1
            r4 = 0
            r2.<init>(r7, r5, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            androidx.compose.material3.AnimationResult r8 = (androidx.compose.material3.AnimationResult) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope scrollScope, float f, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        float findClosestOffset = findClosestOffset(0.0f, this.lazyListState);
        return animateSnap(scrollScope, findClosestOffset, findClosestOffset, AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null), this.snapAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2 A[PHI: r3 
      PHI: (r3v13 java.lang.Object) = (r3v12 java.lang.Object), (r3v1 java.lang.Object) binds: [B:28:0x00af, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object longSnap(androidx.compose.foundation.gestures.ScrollScope r23, float r24, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            boolean r4 = r3 instanceof androidx.compose.material3.SnapFlingBehavior$longSnap$1
            if (r4 == 0) goto L1c
            r4 = r3
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r4 = (androidx.compose.material3.SnapFlingBehavior$longSnap$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L1c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L21
        L1c:
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r4 = new androidx.compose.material3.SnapFlingBehavior$longSnap$1
            r4.<init>(r0, r3)
        L21:
            r11 = r4
            java.lang.Object r3 = r11.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r11.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L4c
            if (r5 == r7) goto L3f
            if (r5 != r6) goto L37
            kotlin.ResultKt.throwOnFailure(r3)
            goto Lb2
        L37:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3f:
            java.lang.Object r1 = r11.L$1
            androidx.compose.foundation.gestures.ScrollScope r1 = (androidx.compose.foundation.gestures.ScrollScope) r1
            java.lang.Object r2 = r11.L$0
            androidx.compose.material3.SnapFlingBehavior r2 = (androidx.compose.material3.SnapFlingBehavior) r2
            kotlin.ResultKt.throwOnFailure(r3)
            r5 = r2
            goto L80
        L4c:
            kotlin.ResultKt.throwOnFailure(r3)
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r3 = r0.decayAnimationSpec
            r5 = 0
            float r3 = androidx.compose.animation.core.DecayAnimationSpecKt.calculateTargetValue(r3, r5, r2)
            float r3 = java.lang.Math.abs(r3)
            float r8 = r22.getItemSize()
            float r3 = r3 - r8
            float r3 = kotlin.ranges.RangesKt.coerceAtLeast(r3, r5)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L69
            r5 = r7
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 == 0) goto L6d
            goto L72
        L6d:
            float r5 = java.lang.Math.signum(r24)
            float r3 = r3 * r5
        L72:
            r11.L$0 = r0
            r11.L$1 = r1
            r11.label = r7
            java.lang.Object r3 = r0.runApproach(r1, r3, r2, r11)
            if (r3 != r4) goto L7f
            return r4
        L7f:
            r5 = r0
        L80:
            androidx.compose.material3.AnimationResult r3 = (androidx.compose.material3.AnimationResult) r3
            java.lang.Object r2 = r3.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            float r8 = r2.floatValue()
            androidx.compose.animation.core.AnimationState r12 = r3.component2()
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            androidx.compose.animation.core.AnimationState r9 = androidx.compose.animation.core.AnimationStateKt.copy$default(r12, r13, r14, r15, r17, r19, r20, r21)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r10 = r5.snapAnimationSpec
            r2 = 0
            r11.L$0 = r2
            r11.L$1 = r2
            r11.label = r6
            r6 = r1
            r7 = r8
            java.lang.Object r3 = r5.animateSnap(r6, r7, r8, r9, r10, r11)
            if (r3 != r4) goto Lb2
            return r4
        Lb2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.longSnap(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object runApproach(androidx.compose.foundation.gestures.ScrollScope r18, float r19, float r20, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r21) {
        /*
            r17 = this;
            r6 = r17
            r0 = r21
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$runApproach$1
            if (r1 == 0) goto L18
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = (androidx.compose.material3.SnapFlingBehavior$runApproach$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1d
        L18:
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = new androidx.compose.material3.SnapFlingBehavior$runApproach$1
            r1.<init>(r6, r0)
        L1d:
            r5 = r1
            java.lang.Object r0 = r5.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r1 = r5.L$0
            androidx.compose.material3.SnapFlingBehavior r1 = (androidx.compose.material3.SnapFlingBehavior) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L62
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 28
            r16 = 0
            r9 = r20
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r8, r9, r10, r12, r14, r15, r16)
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r4 = r6.decayAnimationSpec
            r5.L$0 = r6
            r5.label = r2
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r0 = r0.animateDecay(r1, r2, r3, r4, r5)
            if (r0 != r7) goto L61
            return r7
        L61:
            r1 = r6
        L62:
            androidx.compose.material3.AnimationResult r0 = (androidx.compose.material3.AnimationResult) r0
            androidx.compose.animation.core.AnimationState r0 = r0.component2()
            java.lang.Object r2 = r0.getVelocity()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.foundation.lazy.LazyListState r3 = r1.lazyListState
            float r1 = r1.findClosestOffset(r2, r3)
            androidx.compose.material3.AnimationResult r2 = new androidx.compose.material3.AnimationResult
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r1)
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.runApproach(androidx.compose.foundation.gestures.ScrollScope, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            return Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.lazyListState, this.lazyListState) && Intrinsics.areEqual(snapFlingBehavior.density, this.density);
        }
        return false;
    }

    public int hashCode() {
        return ((((((0 + this.snapAnimationSpec.hashCode()) * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.lazyListState.hashCode()) * 31) + this.density.hashCode();
    }

    private final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getStart();
    }

    private final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getEndInclusive();
    }

    private static final ClosedFloatingPointRange<Float> findClosestOffset$calculateSnappingOffsetBounds(LazyListState lazyListState, SnapFlingBehavior snapFlingBehavior) {
        LazyListLayoutInfo layoutInfo = lazyListState.getLayoutInfo();
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            float calculateDistanceToDesiredSnapPosition = snapFlingBehavior.calculateDistanceToDesiredSnapPosition(layoutInfo, visibleItemsInfo.get(i));
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f) {
                f = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return RangesKt.rangeTo(f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (java.lang.Math.abs(r7) <= java.lang.Math.abs(r0)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final float findClosestOffset(float r6, androidx.compose.foundation.lazy.LazyListState r7) {
        /*
            r5 = this;
            kotlin.ranges.ClosedFloatingPointRange r7 = findClosestOffset$calculateSnappingOffsetBounds(r7, r5)
            java.lang.Comparable r0 = r5.component1(r7)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r7 = r5.component2(r7)
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r6 = java.lang.Math.signum(r6)
            r1 = 0
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L25
            r2 = r3
            goto L26
        L25:
            r2 = r4
        L26:
            if (r2 == 0) goto L35
            float r6 = java.lang.Math.abs(r7)
            float r2 = java.lang.Math.abs(r0)
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 > 0) goto L4e
            goto L40
        L35:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 != 0) goto L3d
            r2 = r3
            goto L3e
        L3d:
            r2 = r4
        L3e:
            if (r2 == 0) goto L42
        L40:
            r0 = r7
            goto L4e
        L42:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L49
            goto L4a
        L49:
            r3 = r4
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r1
        L4e:
            boolean r6 = findClosestOffset$isValidDistance(r0)
            if (r6 == 0) goto L55
            r1 = r0
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.findClosestOffset(float, androidx.compose.foundation.lazy.LazyListState):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateDecay(final androidx.compose.foundation.gestures.ScrollScope r6, final float r7, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r8, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r9, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = (androidx.compose.material3.SnapFlingBehavior$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            r0.<init>(r5, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            float r7 = r0.F$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r6 = (kotlin.jvm.internal.Ref.FloatRef) r6
            java.lang.Object r8 = r0.L$0
            androidx.compose.animation.core.AnimationState r8 = (androidx.compose.animation.core.AnimationState) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6e
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            java.lang.Object r2 = r8.getVelocity()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L55
            r2 = r3
            goto L56
        L55:
            r2 = 0
        L56:
            r2 = r2 ^ r3
            androidx.compose.material3.SnapFlingBehavior$animateDecay$2 r4 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$2
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r0.L$0 = r8
            r0.L$1 = r10
            r0.F$0 = r7
            r0.label = r3
            java.lang.Object r6 = androidx.compose.animation.core.SuspendAnimation.animateDecay(r8, r9, r2, r4, r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            r6 = r10
        L6e:
            androidx.compose.material3.AnimationResult r9 = new androidx.compose.material3.AnimationResult
            float r6 = r6.element
            float r7 = r7 - r6
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r7)
            r9.<init>(r6, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, float f) {
        if (Math.abs(f - scrollScope.scrollBy(f)) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateSnap(final androidx.compose.foundation.gestures.ScrollScope r14, float r15, final float r16, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r17, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r18, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r19) {
        /*
            r13 = this;
            r0 = r13
            r1 = r19
            boolean r2 = r1 instanceof androidx.compose.material3.SnapFlingBehavior$animateSnap$1
            if (r2 == 0) goto L17
            r2 = r1
            androidx.compose.material3.SnapFlingBehavior$animateSnap$1 r2 = (androidx.compose.material3.SnapFlingBehavior$animateSnap$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L17
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1c
        L17:
            androidx.compose.material3.SnapFlingBehavior$animateSnap$1 r2 = new androidx.compose.material3.SnapFlingBehavior$animateSnap$1
            r2.<init>(r13, r1)
        L1c:
            r8 = r2
            java.lang.Object r1 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 1
            if (r3 == 0) goto L48
            if (r3 != r4) goto L40
            float r2 = r8.F$1
            float r3 = r8.F$0
            java.lang.Object r4 = r8.L$2
            kotlin.jvm.internal.Ref$FloatRef r4 = (kotlin.jvm.internal.Ref.FloatRef) r4
            java.lang.Object r5 = r8.L$1
            androidx.compose.animation.core.AnimationState r5 = (androidx.compose.animation.core.AnimationState) r5
            java.lang.Object r6 = r8.L$0
            androidx.compose.material3.SnapFlingBehavior r6 = (androidx.compose.material3.SnapFlingBehavior) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r11 = r3
            r1 = r5
            goto L9c
        L40:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L48:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            java.lang.Object r3 = r17.getVelocity()
            java.lang.Number r3 = (java.lang.Number) r3
            float r9 = r3.floatValue()
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r15)
            java.lang.Object r3 = r17.getVelocity()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            r6 = 0
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L6f
            r3 = r4
            goto L70
        L6f:
            r3 = 0
        L70:
            r6 = r3 ^ 1
            androidx.compose.material3.SnapFlingBehavior$animateSnap$2 r3 = new androidx.compose.material3.SnapFlingBehavior$animateSnap$2
            r7 = r14
            r10 = r16
            r3.<init>()
            r7 = r3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8.L$0 = r0
            r10 = r17
            r8.L$1 = r10
            r8.L$2 = r1
            r11 = r15
            r8.F$0 = r11
            r8.F$1 = r9
            r8.label = r4
            r3 = r17
            r4 = r5
            r5 = r18
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimation.animateTo(r3, r4, r5, r6, r7, r8)
            if (r3 != r2) goto L98
            return r2
        L98:
            r6 = r0
            r4 = r1
            r2 = r9
            r1 = r10
        L9c:
            java.lang.Object r3 = r1.getVelocity()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r3 = r6.coerceToTarget(r3, r2)
            androidx.compose.material3.AnimationResult r12 = new androidx.compose.material3.AnimationResult
            float r2 = r4.element
            float r11 = r11 - r2
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r11)
            r2 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 29
            r10 = 0
            androidx.compose.animation.core.AnimationState r1 = androidx.compose.animation.core.AnimationStateKt.copy$default(r1, r2, r3, r4, r6, r8, r9, r10)
            r12.<init>(r11, r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    private final float calculateDistanceToDesiredSnapPosition(LazyListLayoutInfo lazyListLayoutInfo, LazyListItemInfo lazyListItemInfo) {
        float f = 2;
        return lazyListItemInfo.getOffset() - ((((getSingleAxisViewportSize(lazyListLayoutInfo) - lazyListLayoutInfo.getBeforeContentPadding()) - lazyListLayoutInfo.getAfterContentPadding()) / f) - (lazyListItemInfo.getSize() / f));
    }

    private final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        return lazyListLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m5510getHeightimpl(lazyListLayoutInfo.mo816getViewportSizeYbymL2g()) : IntSize.m5511getWidthimpl(lazyListLayoutInfo.mo816getViewportSizeYbymL2g());
    }
}
