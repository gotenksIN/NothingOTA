package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFile$1", f = "OTAUpdateViewModel.kt", i = {}, l = {498}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$verifyOTAFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $otaFileId;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$verifyOTAFile$1(OTAUpdateViewModel oTAUpdateViewModel, String str, Continuation<? super OTAUpdateViewModel$verifyOTAFile$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$otaFileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$verifyOTAFile$1(this.this$0, this.$otaFileId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$verifyOTAFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        MutableLiveData mutableLiveData;
        Utils utils;
        DebugRepository debugRepository;
        MediatorLiveData mediatorLiveData;
        UpdateStage stageCurrentVersion;
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
            mutableLiveData = this.this$0._handlingActionLive;
            mutableLiveData.setValue(Boxing.boxBoolean(true));
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
        utils = this.this$0.utils;
        debugRepository = this.this$0.debugRepository;
        String buildNumber = utils.getBuildNumber(debugRepository);
        mediatorLiveData = this.this$0._updateStageLive;
        if (oTAApplyMetadata.getVerifyState() == 0) {
            stageCurrentVersion = new UpdateStage.StageReadyInstallOTA(buildNumber, oTAApplyMetadata.getBuildNumber());
        } else {
            stageCurrentVersion = new UpdateStage.StageCurrentVersion(buildNumber);
        }
        mediatorLiveData.setValue(stageCurrentVersion);
        mutableLiveData2 = this.this$0._handlingActionLive;
        mutableLiveData2.setValue(Boxing.boxBoolean(false));
        LogUtil logUtil2 = LogUtil.INSTANCE;
        str2 = OTAUpdateViewModel.TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
        LogUtil.d$default(logUtil2, str2, "verifyOTAFile.launch-", null, 4, null);
        return Unit.INSTANCE;
    }
}
