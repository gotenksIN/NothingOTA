package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.state.ToastBundle;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.util.Event;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickSecondButton$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$clickSecondButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$clickSecondButton$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$clickSecondButton$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$clickSecondButton$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$clickSecondButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediatorLiveData mediatorLiveData;
        String str;
        MutableLiveData mutableLiveData;
        MediatorLiveData mediatorLiveData2;
        MediatorLiveData mediatorLiveData3;
        MutableLiveData mutableLiveData2;
        String str2;
        MutableLiveData mutableLiveData3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mediatorLiveData = this.this$0._lockActionsLive;
            Boolean bool = (Boolean) mediatorLiveData.getValue();
            if (bool == null) {
                bool = boxing.boxBoolean(false);
            }
            boolean booleanValue = bool.booleanValue();
            LogUtil logUtil = LogUtil.INSTANCE;
            str = OTAUpdateViewModel.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            LogUtil.d$default(logUtil, str, "clickSecondButton.launch+, lockActions: " + booleanValue, null, 4, null);
            if (!booleanValue) {
                mutableLiveData = this.this$0._handlingActionLive;
                mutableLiveData.setValue(boxing.boxBoolean(true));
                mediatorLiveData2 = this.this$0._updateStageLive;
                UpdateStage updateStage = (UpdateStage) mediatorLiveData2.getValue();
                if (updateStage instanceof UpdateStage.StageCurrentVersion ? true : updateStage instanceof UpdateStage.StageReadyInstallOTA ? true : updateStage instanceof UpdateStage.StageReadyToDownload) {
                    mutableLiveData3 = this.this$0._launchBrowseEventLive;
                    mutableLiveData3.setValue(new Event(boxing.boxBoolean(true)));
                } else {
                    if (updateStage instanceof UpdateStage.StageInstallingRunning ? true : updateStage instanceof UpdateStage.StageInstallingPaused) {
                        this.this$0.showCancelInstallConfirmation(true);
                    } else if (updateStage instanceof UpdateStage.StageReadyInstallDownloaded) {
                        this.this$0.remoteRepository.resetDownloadStatus();
                    } else {
                        if (!(updateStage instanceof UpdateStage.StageDownloading ? true : updateStage instanceof UpdateStage.StageDownloadPaused)) {
                            mediatorLiveData3 = this.this$0._showToastEventLive;
                            mediatorLiveData3.setValue(new Event(new ToastBundle(0, "Coming soon....", null, 5, null)));
                        } else {
                            this.this$0.showCancelDownloadConfirmationDialog(true);
                        }
                    }
                }
                mutableLiveData2 = this.this$0._handlingActionLive;
                mutableLiveData2.setValue(boxing.boxBoolean(false));
                LogUtil logUtil2 = LogUtil.INSTANCE;
                str2 = OTAUpdateViewModel.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LogUtil.d$default(logUtil2, str2, "clickSecondButton.launch-", null, 4, null);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
