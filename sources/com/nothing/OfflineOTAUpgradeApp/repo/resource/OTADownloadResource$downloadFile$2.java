package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import android.content.Context;
import android.util.Log;
import com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import java.io.File;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.ResponseBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$downloadFile$2", m30f = "OTADownloadResource.kt", m29i = {0}, m28l = {149, 150, 160, 169}, m27m = "invokeSuspend", m26n = {"$this$withContext"}, m25s = {"L$0"})
/* loaded from: classes2.dex */
public final class OTADownloadResource$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $append;
    final /* synthetic */ File $file;
    final /* synthetic */ String $fileUrl;
    final /* synthetic */ String $range;
    final /* synthetic */ OTAUpdateService $this_downloadFile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OTADownloadResource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTADownloadResource$downloadFile$2(OTAUpdateService oTAUpdateService, String str, String str2, OTADownloadResource oTADownloadResource, File file, boolean z, Continuation<? super OTADownloadResource$downloadFile$2> continuation) {
        super(2, continuation);
        this.$this_downloadFile = oTAUpdateService;
        this.$fileUrl = str;
        this.$range = str2;
        this.this$0 = oTADownloadResource;
        this.$file = file;
        this.$append = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OTADownloadResource$downloadFile$2 oTADownloadResource$downloadFile$2 = new OTADownloadResource$downloadFile$2(this.$this_downloadFile, this.$fileUrl, this.$range, this.this$0, this.$file, this.$append, continuation);
        oTADownloadResource$downloadFile$2.L$0 = obj;
        return oTADownloadResource$downloadFile$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTADownloadResource$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        MutableStateFlow mutableStateFlow;
        String str2;
        Utils utils;
        Context context;
        MutableStateFlow mutableStateFlow2;
        CoroutineScope coroutineScope;
        Object saveFile;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            str = OTADownloadResource.TAG;
            Log.w(str, "Fail to download file", e);
            if (e instanceof SocketException ? true : e instanceof UnknownHostException) {
                utils = this.this$0.utils;
                context = this.this$0.appContext;
                if (utils.isNetworkAvailable(context)) {
                    mutableStateFlow2 = this.this$0._downloadStateFlow;
                    String message = e.getMessage();
                    str2 = message != null ? message : "Fail to download OTA package";
                    this.L$0 = null;
                    this.label = 3;
                    if (mutableStateFlow2.emit(new DownloadState.DownloadFail(str2), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.this$0.pauseDownload(true);
                }
            } else if (!(e instanceof CancellationException)) {
                mutableStateFlow = this.this$0._downloadStateFlow;
                String message2 = e.getMessage();
                str2 = message2 != null ? message2 : "Fail to download OTA package";
                this.L$0 = null;
                this.label = 4;
                if (mutableStateFlow.emit(new DownloadState.DownloadFail(str2), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = this.$this_downloadFile.downloadFile(this.$fileUrl, this.$range, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else if (i != 3 && i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } else {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        OTADownloadResource oTADownloadResource = this.this$0;
        this.L$0 = null;
        this.label = 2;
        saveFile = oTADownloadResource.saveFile(coroutineScope2, (ResponseBody) obj, this.$file, this.$append, this);
        if (saveFile == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
