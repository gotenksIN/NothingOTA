package androidx.compose.p002ui.viewinterop;

import androidx.compose.p002ui.input.nestedscroll.NestedScrollDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", m30f = "AndroidViewHolder.android.kt", m29i = {}, m28l = {541}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1 */
/* loaded from: classes.dex */
final class AndroidViewHolder$onNestedPreFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $toBeConsumed;
    int label;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedPreFling$1(AndroidViewHolder androidViewHolder, long j, Continuation<? super AndroidViewHolder$onNestedPreFling$1> continuation) {
        super(2, continuation);
        this.this$0 = androidViewHolder;
        this.$toBeConsumed = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedPreFling$1(this.this$0, this.$toBeConsumed, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedPreFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            nestedScrollDispatcher = this.this$0.dispatcher;
            this.label = 1;
            if (nestedScrollDispatcher.m4147dispatchPreFlingQWom1Mo(this.$toBeConsumed, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
