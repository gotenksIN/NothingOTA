package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import com.nothing.OfflineOTAUpgradeApp.remote.RemoteFetchResult;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
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
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$queryOTAUpdateInfo$1", f = "OTAUpdateViewModel.kt", i = {}, l = {739}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$queryOTAUpdateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        RemoteFetchResult remoteFetchResult = (RemoteFetchResult) obj;
        if (remoteFetchResult instanceof RemoteFetchResult.Success) {
            RemoteFetchResult.Success success = (RemoteFetchResult.Success) remoteFetchResult;
            this.this$0._downloadStateLive.setValue(new DownloadState.Fetched(success.getData()));
            this.this$0._remoteOTAUpdateInfo = success.getData();
        } else if (remoteFetchResult instanceof RemoteFetchResult.Failure) {
            this.this$0.showCheckUpdateFailDialog(true);
            this.this$0._downloadStateLive.setValue(new DownloadState.FetchError(((RemoteFetchResult.Failure) remoteFetchResult).getErrorMessage()));
        }
        return Unit.INSTANCE;
    }
}
