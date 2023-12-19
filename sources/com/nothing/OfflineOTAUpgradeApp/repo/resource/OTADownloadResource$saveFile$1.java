package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource", m30f = "OTADownloadResource.kt", m29i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2}, m28l = {195, 198, 215, 233, 242}, m27m = "saveFile", m26n = {"this", "$this$saveFile", "inputStream", "outputStream", "buffer", "this", "$this$saveFile", "inputStream", "outputStream", "buffer", "this"}, m25s = {"L$0", "L$1", "L$3", "L$5", "L$6", "L$0", "L$1", "L$3", "L$5", "L$6", "L$0"})
/* loaded from: classes2.dex */
public final class OTADownloadResource$saveFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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
