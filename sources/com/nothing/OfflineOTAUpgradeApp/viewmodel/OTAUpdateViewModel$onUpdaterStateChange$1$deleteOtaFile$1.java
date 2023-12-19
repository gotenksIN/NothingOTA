package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1", f = "OTAUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UpdateUtils updateUtils;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            updateUtils = this.this$0.updateUtils;
            return Boxing.boxBoolean(updateUtils.deleteOtaFile());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
