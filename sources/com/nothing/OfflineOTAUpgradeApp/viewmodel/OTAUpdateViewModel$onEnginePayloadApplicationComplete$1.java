package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onEnginePayloadApplicationComplete$1", f = "OTAUpdateViewModel.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$onEnginePayloadApplicationComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$onEnginePayloadApplicationComplete$1(OTAUpdateViewModel oTAUpdateViewModel, int i, Continuation<? super OTAUpdateViewModel$onEnginePayloadApplicationComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$errorCode = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$onEnginePayloadApplicationComplete$1(this.this$0, this.$errorCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$onEnginePayloadApplicationComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        UpdateUtils updateUtils;
        MutableLiveData mutableLiveData3;
        OTAPrefs oTAPrefs;
        OTAPrefs oTAPrefs2;
        MutableLiveData mutableLiveData4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._handlingActionLive;
            mutableLiveData.setValue(Boxing.boxBoolean(true));
            mutableLiveData2 = this.this$0._engineErrorCodeLive;
            mutableLiveData2.setValue(Boxing.boxInt(this.$errorCode));
            if (this.$errorCode == 0) {
                updateUtils = this.this$0.updateUtils;
                updateUtils.releaseWakeLock();
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new OTAUpdateViewModel$onEnginePayloadApplicationComplete$1$deleteOtaFile$1(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            mutableLiveData3 = this.this$0._handlingActionLive;
            mutableLiveData3.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ((Boolean) obj).booleanValue();
        oTAPrefs = this.this$0.otaPrefs;
        oTAPrefs.resetOtaFilePath();
        oTAPrefs2 = this.this$0.otaPrefs;
        oTAPrefs2.resetUpdatingBuildNumber();
        this.this$0._readyToInstallOtaFileId = "";
        mutableLiveData4 = this.this$0._showInstallSuccessLive;
        mutableLiveData4.setValue(Boxing.boxBoolean(true));
        mutableLiveData3 = this.this$0._handlingActionLive;
        mutableLiveData3.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
