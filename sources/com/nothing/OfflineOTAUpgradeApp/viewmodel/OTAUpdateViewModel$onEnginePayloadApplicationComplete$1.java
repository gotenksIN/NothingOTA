package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onEnginePayloadApplicationComplete$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {722}, m27m = "invokeSuspend", m26n = {}, m25s = {})
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
            mutableLiveData = this.this$0._handleEnginePayloadLive;
            mutableLiveData.setValue(boxing.boxBoolean(true));
            mutableLiveData2 = this.this$0._engineErrorCodeLive;
            mutableLiveData2.setValue(boxing.boxInt(this.$errorCode));
            if (this.$errorCode == 0) {
                updateUtils = this.this$0.updateUtils;
                updateUtils.releaseWakeLock();
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new C1679x15c70844(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            mutableLiveData3 = this.this$0._handleEnginePayloadLive;
            mutableLiveData3.setValue(boxing.boxBoolean(false));
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
        mutableLiveData4.setValue(boxing.boxBoolean(true));
        mutableLiveData3 = this.this$0._handleEnginePayloadLive;
        mutableLiveData3.setValue(boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
