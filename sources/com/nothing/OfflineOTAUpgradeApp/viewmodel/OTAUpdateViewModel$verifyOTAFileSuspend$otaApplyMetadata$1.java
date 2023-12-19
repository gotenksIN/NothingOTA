package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
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
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$OTAApplyMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1", f = "OTAUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpdateUtils.OTAApplyMetadata>, Object> {
    final /* synthetic */ String $otaFileId;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1(OTAUpdateViewModel oTAUpdateViewModel, String str, Continuation<? super OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$otaFileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1(this.this$0, this.$otaFileId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UpdateUtils.OTAApplyMetadata> continuation) {
        return ((OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UpdateUtils updateUtils;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            updateUtils = this.this$0.updateUtils;
            return updateUtils.verifyOTAFile(this.$otaFileId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
