package androidx.compose.p002ui.input.pointer;

import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine", m30f = "SuspendingPointerInputFilter.kt", m29i = {}, m28l = {600}, m27m = "withTimeoutOrNull", m26n = {}, m25s = {})
/* renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 */
/* loaded from: classes.dex */
public final class C0697x7456dd52<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0697x7456dd52(SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super C0697x7456dd52> continuation) {
        super(continuation);
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.withTimeoutOrNull(0L, null, this);
    }
}
