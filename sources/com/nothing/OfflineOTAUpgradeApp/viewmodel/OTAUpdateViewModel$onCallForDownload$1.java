package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onCallForDownload$1", f = "OTAUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$onCallForDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowMeteredNetwork;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$onCallForDownload$1(OTAUpdateViewModel oTAUpdateViewModel, boolean z, Continuation<? super OTAUpdateViewModel$onCallForDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$allowMeteredNetwork = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$onCallForDownload$1(this.this$0, this.$allowMeteredNetwork, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$onCallForDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediatorLiveData mediatorLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mediatorLiveData = this.this$0._updateStageLive;
            UpdateStage updateStage = (UpdateStage) mediatorLiveData.getValue();
            if (updateStage instanceof UpdateStage.StageReadyToDownload) {
                DownloadState downloadState = (DownloadState) this.this$0._downloadStateLive.getValue();
                if (downloadState != null) {
                    OTAUpdateViewModel oTAUpdateViewModel = this.this$0;
                    boolean z = this.$allowMeteredNetwork;
                    if (downloadState instanceof DownloadState.Fetched) {
                        RemoteOTAUpdateInfo info = ((DownloadState.Fetched) downloadState).getInfo();
                        oTAUpdateViewModel.remoteRepository.allowDownloadWithMeteredNetwork(z);
                        oTAUpdateViewModel.remoteRepository.startDownload(info);
                    }
                }
            } else if (updateStage instanceof UpdateStage.StageDownloadPaused) {
                this.this$0.remoteRepository.allowDownloadWithMeteredNetwork(this.$allowMeteredNetwork);
                this.this$0.remoteRepository.resumeDownload();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
