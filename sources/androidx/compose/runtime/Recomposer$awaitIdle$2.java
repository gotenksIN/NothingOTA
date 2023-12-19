package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;

/* compiled from: Recomposer.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m40d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.runtime.Recomposer$awaitIdle$2", m30f = "Recomposer.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes.dex */
final class Recomposer$awaitIdle$2 extends SuspendLambda implements Function2<Recomposer.State, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Recomposer$awaitIdle$2(Continuation<? super Recomposer$awaitIdle$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$awaitIdle$2 recomposer$awaitIdle$2 = new Recomposer$awaitIdle$2(continuation);
        recomposer$awaitIdle$2.L$0 = obj;
        return recomposer$awaitIdle$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Recomposer.State state, Continuation<? super Boolean> continuation) {
        return ((Recomposer$awaitIdle$2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return boxing.boxBoolean(((Recomposer.State) this.L$0).compareTo(Recomposer.State.Idle) > 0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
