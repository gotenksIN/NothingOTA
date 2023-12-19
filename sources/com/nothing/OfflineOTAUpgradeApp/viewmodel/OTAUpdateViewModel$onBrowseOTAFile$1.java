package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$onBrowseOTAFile$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {591}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$onBrowseOTAFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $otaFileId;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$onBrowseOTAFile$1(OTAUpdateViewModel oTAUpdateViewModel, String str, Continuation<? super OTAUpdateViewModel$onBrowseOTAFile$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$otaFileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$onBrowseOTAFile$1(this.this$0, this.$otaFileId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$onBrowseOTAFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogUtil logUtil = LogUtil.INSTANCE;
            str = OTAUpdateViewModel.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            LogUtil.d$default(logUtil, str, "verifyOTAFile.launch+", null, 4, null);
            mutableLiveData = this.this$0._handleBrowseOTALive;
            mutableLiveData.setValue(boxing.boxBoolean(true));
            this.label = 1;
            obj = this.this$0.verifyOTAFileSuspend(this.$otaFileId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        UpdateUtils.OTAApplyMetadata oTAApplyMetadata = (UpdateUtils.OTAApplyMetadata) obj;
        this.this$0._readyToInstallOtaFileId = oTAApplyMetadata.getVerifyState() == 0 ? this.$otaFileId : "";
        this.this$0._otaApplyMetadataLive.setValue(oTAApplyMetadata);
        if (oTAApplyMetadata.getVerifyState() == 0) {
            this.this$0._downloadStateLive.setValue(DownloadState.Idle.INSTANCE);
        }
        mutableLiveData2 = this.this$0._handleBrowseOTALive;
        mutableLiveData2.setValue(boxing.boxBoolean(false));
        LogUtil logUtil2 = LogUtil.INSTANCE;
        str2 = OTAUpdateViewModel.TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
        LogUtil.d$default(logUtil2, str2, "verifyOTAFile.launch-", null, 4, null);
        return Unit.INSTANCE;
    }
}
