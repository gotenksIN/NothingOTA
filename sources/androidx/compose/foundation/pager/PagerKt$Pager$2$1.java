package androidx.compose.foundation.pager;

import androidx.compose.p002ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.pager.PagerKt$Pager$2$1", m30f = "Pager.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes.dex */
final class PagerKt$Pager$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ PagerState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerKt$Pager$2$1(Density density, PagerState pagerState, float f, Continuation<? super PagerKt$Pager$2$1> continuation) {
        super(2, continuation);
        this.$density = density;
        this.$state = pagerState;
        this.$pageSpacing = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerKt$Pager$2$1(this.$density, this.$state, this.$pageSpacing, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagerKt$Pager$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$state.setPageSpacing$foundation_release(this.$density.mo597roundToPx0680j_4(this.$pageSpacing));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
