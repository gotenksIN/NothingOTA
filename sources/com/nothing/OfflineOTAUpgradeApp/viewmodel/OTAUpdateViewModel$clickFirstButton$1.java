package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickFirstButton$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {518, 522}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$clickFirstButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$clickFirstButton$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$clickFirstButton$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$clickFirstButton$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$clickFirstButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediatorLiveData mediatorLiveData;
        String str;
        MutableLiveData mutableLiveData;
        MediatorLiveData mediatorLiveData2;
        MediatorLiveData mediatorLiveData3;
        MediatorLiveData mediatorLiveData4;
        MediatorLiveData mediatorLiveData5;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
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
            LogUtil.d$default(logUtil, str, "clickFirstButton.launch+, _lockButtons: " + booleanValue, null, 4, null);
            if (!booleanValue) {
                mutableLiveData = this.this$0._handlingActionLive;
                mutableLiveData.setValue(boxing.boxBoolean(true));
                mediatorLiveData2 = this.this$0._updateStageLive;
                UpdateStage updateStage = (UpdateStage) mediatorLiveData2.getValue();
                if (updateStage instanceof UpdateStage.StageCurrentVersion ? true : updateStage instanceof UpdateStage.StageReadyInstallOTA) {
                    this.this$0.queryOTAUpdateInfo();
                } else if (updateStage instanceof UpdateStage.StageInstallingRunning) {
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new C16761(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (updateStage instanceof UpdateStage.StageInstallingPaused) {
                    mutableLiveData2 = this.this$0._engineErrorCodeLive;
                    mutableLiveData2.setValue(boxing.boxInt(-1));
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new C16772(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (updateStage instanceof UpdateStage.StageReadyToDownload) {
                    mediatorLiveData5 = this.this$0._checkNetworkLive;
                    mediatorLiveData5.setValue(new Event(boxing.boxBoolean(true)));
                } else if (updateStage instanceof UpdateStage.StageDownloading) {
                    this.this$0.remoteRepository.pauseDownload();
                } else if (updateStage instanceof UpdateStage.StageDownloadPaused) {
                    mediatorLiveData4 = this.this$0._checkNetworkLive;
                    mediatorLiveData4.setValue(new Event(boxing.boxBoolean(true)));
                } else if (!(updateStage instanceof UpdateStage.StageReadyInstallDownloaded)) {
                    mediatorLiveData3 = this.this$0._showToastEventLive;
                    mediatorLiveData3.setValue(new Event(new ToastBundle(0, "Coming soon....", null, 5, null)));
                } else {
                    this.this$0.installOTAFile();
                    this.this$0.remoteRepository.resetDownloadStatus();
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData3 = this.this$0._handlingActionLive;
        mutableLiveData3.setValue(boxing.boxBoolean(false));
        LogUtil logUtil2 = LogUtil.INSTANCE;
        str2 = OTAUpdateViewModel.TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
        LogUtil.d$default(logUtil2, str2, "clickFirstButton.launch-", null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTAUpdateViewModel.kt */
    @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
    @DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickFirstButton$1$1", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickFirstButton$1$1 */
    /* loaded from: classes2.dex */
    public static final class C16761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OTAUpdateViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16761(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super C16761> continuation) {
            super(2, continuation);
            this.this$0 = oTAUpdateViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16761(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdateManager updateManager;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                updateManager = this.this$0.updateManager;
                updateManager.suspend();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTAUpdateViewModel.kt */
    @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
    @DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickFirstButton$1$2", m30f = "OTAUpdateViewModel.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$clickFirstButton$1$2 */
    /* loaded from: classes2.dex */
    public static final class C16772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OTAUpdateViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16772(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super C16772> continuation) {
            super(2, continuation);
            this.this$0 = oTAUpdateViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16772(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdateManager updateManager;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                updateManager = this.this$0.updateManager;
                updateManager.resume();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
