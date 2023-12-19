package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel", f = "OTAUpdateViewModel.kt", i = {0, 0}, l = {518}, m = "verifyOTAFileSuspend", n = {"this", "otaFileId"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$verifyOTAFileSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OTAUpdateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateViewModel$verifyOTAFileSuspend$1(OTAUpdateViewModel oTAUpdateViewModel, Continuation<? super OTAUpdateViewModel$verifyOTAFileSuspend$1> continuation) {
        super(continuation);
        this.this$0 = oTAUpdateViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.verifyOTAFileSuspend(null, this);
    }
}
