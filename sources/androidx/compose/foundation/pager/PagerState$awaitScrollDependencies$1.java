package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerState.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.pager.PagerState", m30f = "PagerState.kt", m29i = {0}, m28l = {334, 335}, m27m = "awaitScrollDependencies", m26n = {"this"}, m25s = {"L$0"})
/* loaded from: classes.dex */
public final class PagerState$awaitScrollDependencies$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$awaitScrollDependencies$1(PagerState pagerState, Continuation<? super PagerState$awaitScrollDependencies$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitScrollDependencies;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitScrollDependencies = this.this$0.awaitScrollDependencies(this);
        return awaitScrollDependencies;
    }
}
