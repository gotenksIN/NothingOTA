package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1", f = "OTAUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $show;
    int label;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1(OTAUpdateViewModel oTAUpdateViewModel, boolean z, Continuation<? super OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = oTAUpdateViewModel;
        this.$show = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1(this.this$0, this.$show, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._showCheckDownloadWithCellularLive;
            mutableLiveData.setValue(Boxing.boxBoolean(this.$show));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
