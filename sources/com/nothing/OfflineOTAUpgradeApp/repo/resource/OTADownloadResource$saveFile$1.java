package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource", f = "OTADownloadResource.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {194, 197, 211, 228, 237}, m = "saveFile", n = {"this", "inputStream", "outputStream", "buffer", "this", "inputStream", "outputStream", "buffer", "this"}, s = {"L$0", "L$2", "L$4", "L$5", "L$0", "L$2", "L$4", "L$5", "L$0"})
/* loaded from: classes2.dex */
public final class OTADownloadResource$saveFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OTADownloadResource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTADownloadResource$saveFile$1(OTADownloadResource oTADownloadResource, Continuation<? super OTADownloadResource$saveFile$1> continuation) {
        super(continuation);
        this.this$0 = oTADownloadResource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object saveFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        saveFile = this.this$0.saveFile(null, null, null, false, this);
        return saveFile;
    }
}
