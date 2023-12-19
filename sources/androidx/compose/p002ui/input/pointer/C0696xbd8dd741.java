package androidx.compose.p002ui.input.pointer;

import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(m41d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, m40d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1", m30f = "SuspendingPointerInputFilter.kt", m29i = {}, m28l = {620, 621}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 */
/* loaded from: classes.dex */
public final class C0696xbd8dd741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0696xbd8dd741(long j, SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super C0696xbd8dd741> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0696xbd8dd741(this.$timeMillis, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0696xbd8dd741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L20
            if (r1 == r5) goto L1c
            if (r1 != r4) goto L14
            kotlin.ResultKt.throwOnFailure(r9)
            goto L3e
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L32
        L20:
            kotlin.ResultKt.throwOnFailure(r9)
            long r6 = r8.$timeMillis
            long r6 = r6 - r2
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r5
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r9 != r0) goto L32
            return r0
        L32:
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r9)
            if (r9 != r0) goto L3e
            return r0
        L3e:
            androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine<R> r9 = r8.this$0
            kotlinx.coroutines.CancellableContinuation r9 = androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.access$getPointerAwaiter$p(r9)
            if (r9 == 0) goto L5e
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r0 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
            long r1 = r8.$timeMillis
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m5649constructorimpl(r0)
            r9.resumeWith(r0)
        L5e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.input.pointer.C0696xbd8dd741.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
