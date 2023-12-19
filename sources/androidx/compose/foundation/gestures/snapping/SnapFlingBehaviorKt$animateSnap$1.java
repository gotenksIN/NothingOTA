package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapFlingBehavior.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", m30f = "SnapFlingBehavior.kt", m29i = {0, 0, 0, 0}, m28l = {451}, m27m = "animateSnap", m26n = {"animationState", "consumedUpToNow", "targetOffset", "initialVelocity"}, m25s = {"L$0", "L$1", "F$0", "F$1"})
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt$animateSnap$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapFlingBehaviorKt$animateSnap$1(Continuation<? super SnapFlingBehaviorKt$animateSnap$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object animateSnap;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        animateSnap = SnapFlingBehaviorKt.animateSnap(null, 0.0f, 0.0f, null, null, null, this);
        return animateSnap;
    }
}
