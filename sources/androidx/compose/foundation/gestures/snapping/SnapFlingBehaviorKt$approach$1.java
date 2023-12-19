package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapFlingBehavior.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", m30f = "SnapFlingBehavior.kt", m29i = {0, 0}, m28l = {311}, m27m = "approach", m26n = {"snapLayoutInfoProvider", "density"}, m25s = {"L$0", "L$1"})
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapFlingBehaviorKt$approach$1(Continuation<? super SnapFlingBehaviorKt$approach$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object approach;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        approach = SnapFlingBehaviorKt.approach(null, 0.0f, 0.0f, null, null, null, null, this);
        return approach;
    }
}
