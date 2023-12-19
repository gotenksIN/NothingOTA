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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$showMainPage$1", f = "OTAUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$showMainPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$showMainPage$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$showMainPage$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$showMainPage$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$showMainPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Utils utils;
        DebugRepository debugRepository;
        MutableLiveData mutableLiveData;
        MediatorLiveData mediatorLiveData;
        UpdateStage stageReadyInstallOTA;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LogUtil logUtil = LogUtil.INSTANCE;
        str = OTAUpdateViewModel.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
        LogUtil.d$default(logUtil, str, "showMainPage.launch+", null, 4, null);
        utils = this.this$0.utils;
        debugRepository = this.this$0.debugRepository;
        String buildNumber = utils.getBuildNumber(debugRepository);
        mutableLiveData = this.this$0._otaApplyMetadataLive;
        UpdateUtils.OTAApplyMetadata oTAApplyMetadata = (UpdateUtils.OTAApplyMetadata) mutableLiveData.getValue();
        mediatorLiveData = this.this$0._updateStageLive;
        if (oTAApplyMetadata == null) {
            stageReadyInstallOTA = new UpdateStage.StageCurrentVersion(buildNumber);
        } else {
            stageReadyInstallOTA = new UpdateStage.StageReadyInstallOTA(buildNumber, oTAApplyMetadata.getBuildNumber());
        }
        mediatorLiveData.setValue(stageReadyInstallOTA);
        LogUtil logUtil2 = LogUtil.INSTANCE;
        str2 = OTAUpdateViewModel.TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
        LogUtil.d$default(logUtil2, str2, "showMainPage.launch-", null, 4, null);
        return Unit.INSTANCE;
    }
}
