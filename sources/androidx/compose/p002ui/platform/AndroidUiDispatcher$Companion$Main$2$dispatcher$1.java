package androidx.compose.p002ui.platform;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidUiDispatcher.android.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, m40d2 = {"<anonymous>", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2$dispatcher$1", m30f = "AndroidUiDispatcher.android.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* renamed from: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2$dispatcher$1 */
/* loaded from: classes.dex */
public final class AndroidUiDispatcher$Companion$Main$2$dispatcher$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Choreographer>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidUiDispatcher$Companion$Main$2$dispatcher$1(Continuation<? super AndroidUiDispatcher$Companion$Main$2$dispatcher$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Choreographer> continuation) {
        return ((AndroidUiDispatcher$Companion$Main$2$dispatcher$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Choreographer.getInstance();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
