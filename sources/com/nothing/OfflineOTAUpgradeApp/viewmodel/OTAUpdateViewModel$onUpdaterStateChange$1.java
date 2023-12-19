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
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onUpdaterStateChange$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {662}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$onUpdaterStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$onUpdaterStateChange$1(OTAUpdateViewModel oTAUpdateViewModel, int i, Continuation<? super OTAUpdateViewModel$onUpdaterStateChange$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$state = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$onUpdaterStateChange$1(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$onUpdaterStateChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            mutableLiveData = this.this$0._handleUpdaterStateChangeLive;
            mutableLiveData.setValue(boxing.boxBoolean(true));
            mutableLiveData2 = this.this$0._updaterStateLive;
            mutableLiveData2.setValue(boxing.boxInt(this.$state));
            if (this.$state == 5) {
                updateUtils = this.this$0.updateUtils;
                updateUtils.releaseWakeLock();
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new OTAUpdateViewModel$onUpdaterStateChange$1$deleteOtaFile$1(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            mutableLiveData3 = this.this$0._handleUpdaterStateChangeLive;
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
        mutableLiveData3 = this.this$0._handleUpdaterStateChangeLive;
        mutableLiveData3.setValue(boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
