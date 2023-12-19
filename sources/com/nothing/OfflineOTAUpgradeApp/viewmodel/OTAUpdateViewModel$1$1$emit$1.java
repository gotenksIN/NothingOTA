package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1", f = "OTAUpdateViewModel.kt", i = {0, 0}, l = {350}, m = "emit", n = {"this", "downloadState"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OTAUpdateViewModel.AnonymousClass1.C00841<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OTAUpdateViewModel$1$1$emit$1(OTAUpdateViewModel.AnonymousClass1.C00841<? super T> c00841, Continuation<? super OTAUpdateViewModel$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00841;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((DownloadState) null, (Continuation<? super Unit>) this);
    }
}
