package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;

/* compiled from: SharingStarted.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m40d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, m39k = 3, m38mv = {1, 6, 0}, m36xi = 48)
@DebugMetadata(m31c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", m30f = "SharingStarted.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
final class StartedWhileSubscribed$command$2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartedWhileSubscribed$command$2(Continuation<? super StartedWhileSubscribed$command$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(continuation);
        startedWhileSubscribed$command$2.L$0 = obj;
        return startedWhileSubscribed$command$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SharingCommand sharingCommand, Continuation<? super Boolean> continuation) {
        return ((StartedWhileSubscribed$command$2) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return boxing.boxBoolean(((SharingCommand) this.L$0) != SharingCommand.START);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
