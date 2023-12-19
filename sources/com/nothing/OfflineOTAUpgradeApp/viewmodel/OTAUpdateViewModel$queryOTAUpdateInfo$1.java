package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import com.nothing.OfflineOTAUpgradeApp.remote.RemoteFetchResult;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$queryOTAUpdateInfo$1", m30f = "OTAUpdateViewModel.kt", m29i = {1, 1}, m28l = {811, 816}, m27m = "invokeSuspend", m26n = {"result", "downloadedOTAFileId"}, m25s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$queryOTAUpdateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$queryOTAUpdateInfo$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$queryOTAUpdateInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$queryOTAUpdateInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$queryOTAUpdateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RemoteFetchResult remoteFetchResult;
        String str;
        UpdateUtils.OTAApplyMetadata oTAApplyMetadata;
        Utils unused;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._downloadStateLive.setValue(DownloadState.Fetching.INSTANCE);
            this.label = 1;
            obj = this.this$0.remoteRepository.queryAvailableUpdate(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                str = (String) this.L$1;
                remoteFetchResult = (RemoteFetchResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                oTAApplyMetadata = (UpdateUtils.OTAApplyMetadata) obj;
                if (oTAApplyMetadata.getVerifyState() == 0 || !Intrinsics.areEqual(oTAApplyMetadata.getBuildNumber(), ((RemoteFetchResult.Success) remoteFetchResult).getData().getBuildNumber())) {
                    this.this$0._downloadStateLive.setValue(new DownloadState.Fetched(((RemoteFetchResult.Success) remoteFetchResult).getData()));
                } else {
                    this.this$0._readyToInstallOtaFileId = str;
                    this.this$0._otaApplyMetadataLive.setValue(oTAApplyMetadata);
                    this.this$0._downloadStateLive.setValue(DownloadState.Idle.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        remoteFetchResult = (RemoteFetchResult) obj;
        if (remoteFetchResult instanceof RemoteFetchResult.Success) {
            unused = this.this$0.utils;
            this.L$0 = remoteFetchResult;
            this.L$1 = Utils.DOWNLOADED_OTA_FILE_ID;
            this.label = 2;
            obj = this.this$0.verifyOTAFileSuspend(Utils.DOWNLOADED_OTA_FILE_ID, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = Utils.DOWNLOADED_OTA_FILE_ID;
            oTAApplyMetadata = (UpdateUtils.OTAApplyMetadata) obj;
            if (oTAApplyMetadata.getVerifyState() == 0) {
            }
            this.this$0._downloadStateLive.setValue(new DownloadState.Fetched(((RemoteFetchResult.Success) remoteFetchResult).getData()));
            return Unit.INSTANCE;
        }
        if (remoteFetchResult instanceof RemoteFetchResult.Failure) {
            this.this$0.showCheckUpdateFailDialog(true);
            this.this$0._downloadStateLive.setValue(new DownloadState.FetchError(((RemoteFetchResult.Failure) remoteFetchResult).getErrorMessage()));
        }
        return Unit.INSTANCE;
    }
}
