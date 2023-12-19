package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapFlingBehavior.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.material3.SnapFlingBehavior", m30f = "SnapFlingBehavior.kt", m29i = {0}, m28l = {154}, m27m = "runApproach", m26n = {"this"}, m25s = {"L$0"})
/* loaded from: classes.dex */
public final class SnapFlingBehavior$runApproach$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$runApproach$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$runApproach$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runApproach;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runApproach = this.this$0.runApproach(null, 0.0f, 0.0f, this);
        return runApproach;
    }
}
