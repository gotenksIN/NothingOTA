package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Environment;
import com.nothing.OfflineOTAUpgradeApp.BuildConfig;
import com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$networkCallback$2;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: OTADownloadResource.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\fH\u0002J\u0012\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\fH\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110$J\u0010\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\fJ\u0019\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0013J5\u00106\u001a\u00020\u001f*\u00020\t2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u0002082\u0006\u0010\"\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010;J-\u0010<\u001a\u00020\u001f*\u00020\u00052\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020&2\u0006\u0010\"\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource;", "", "appContext", "Landroid/content/Context;", "resourceScope", "Lkotlinx/coroutines/CoroutineScope;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "client", "Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;)V", "_allowMeteredNetwork", "", "_downloadJob", "Lkotlinx/coroutines/Job;", "_downloadStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "_downloadingInfo", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "_isProcessingFlow", "_maxProgress", "", "_progress", "networkCallback", "com/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource$networkCallback$2$1", "getNetworkCallback", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource$networkCallback$2$1;", "networkCallback$delegate", "Lkotlin/Lazy;", "cancelDownload", "", "download", "info", "append", "getIsProcessingFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOTAFile", "Ljava/io/File;", "getProgressPercentage", "", "getStateFlow", "pauseDownload", "byNetworkIssue", BuildConfig.BUILD_TYPE, "resetStatus", "resumeDownload", "setAllowMeteredNetwork", "allow", "setIsProcessingSuspend", "processing", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDownload", "remoteOTAUpdateInfo", "downloadFile", "fileUrl", "", "file", "range", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFile", "responseBody", "Lokhttp3/ResponseBody;", "destFile", "(Lkotlinx/coroutines/CoroutineScope;Lokhttp3/ResponseBody;Ljava/io/File;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OTADownloadResource {
    private static final int BUFFER_SIZE = 4096;
    public static final String DOWNLOADED_OTA_FILE_ID = "Documents/3225226e-5852-11ee-8c99-0242ac120002.zip";
    private static final long RETRY_DELAY_INTERVAL = 5000;
    private boolean _allowMeteredNetwork;
    private Job _downloadJob;
    private final MutableStateFlow<DownloadState> _downloadStateFlow;
    private RemoteOTAUpdateInfo _downloadingInfo;
    private final MutableStateFlow<Boolean> _isProcessingFlow;
    private long _maxProgress;
    private long _progress;
    private final Context appContext;
    private final OTAUpdateService client;
    private final Lazy networkCallback$delegate;
    private final CoroutineScope resourceScope;
    private final Utils utils;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "OTADownloadResource";

    public OTADownloadResource(Context appContext, CoroutineScope resourceScope, Utils utils, OTAUpdateService client) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(resourceScope, "resourceScope");
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(client, "client");
        this.appContext = appContext;
        this.resourceScope = resourceScope;
        this.utils = utils;
        this.client = client;
        this._downloadStateFlow = StateFlowKt.MutableStateFlow(DownloadState.Idle.INSTANCE);
        this._isProcessingFlow = StateFlowKt.MutableStateFlow(false);
        this.networkCallback$delegate = LazyKt.lazy(new Function0<OTADownloadResource$networkCallback$2.AnonymousClass1>() { // from class: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$networkCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$networkCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final OTADownloadResource oTADownloadResource = OTADownloadResource.this;
                return new ConnectivityManager.NetworkCallback() { // from class: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$networkCallback$2.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        Job job;
                        boolean z;
                        Intrinsics.checkNotNullParameter(network, "network");
                        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                        job = OTADownloadResource.this._downloadJob;
                        boolean z2 = false;
                        if (job != null && job.isActive()) {
                            z2 = true;
                        }
                        if (!z2 || networkCapabilities.hasCapability(11)) {
                            return;
                        }
                        z = OTADownloadResource.this._allowMeteredNetwork;
                        if (z) {
                            return;
                        }
                        OTADownloadResource.this.pauseDownload(true);
                    }
                };
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity");
        if (connectivityManager != null) {
            connectivityManager.registerDefaultNetworkCallback(getNetworkCallback());
        }
    }

    /* compiled from: OTADownloadResource.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource$Companion;", "", "()V", "BUFFER_SIZE", "", "DOWNLOADED_OTA_FILE_ID", "", "RETRY_DELAY_INTERVAL", "", "TAG", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final OTADownloadResource$networkCallback$2.AnonymousClass1 getNetworkCallback() {
        return (OTADownloadResource$networkCallback$2.AnonymousClass1) this.networkCallback$delegate.getValue();
    }

    public final void release() {
        cancelDownload();
    }

    public final void startDownload(RemoteOTAUpdateInfo remoteOTAUpdateInfo) {
        Intrinsics.checkNotNullParameter(remoteOTAUpdateInfo, "remoteOTAUpdateInfo");
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "startDownload", null, 4, null);
        Job job = this._downloadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._downloadJob = null;
        this._maxProgress = 0L;
        this._progress = 0L;
        this._downloadingInfo = remoteOTAUpdateInfo;
        download(false);
    }

    public final void resumeDownload() {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "resumeDownload", null, 4, null);
        download(true);
    }

    static /* synthetic */ void download$default(OTADownloadResource oTADownloadResource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        oTADownloadResource.download(z);
    }

    private final void download(boolean z) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "download, append: " + z + ", _downloadingInfo: " + this._downloadingInfo, null, 4, null);
        RemoteOTAUpdateInfo remoteOTAUpdateInfo = this._downloadingInfo;
        if (remoteOTAUpdateInfo != null) {
            download(remoteOTAUpdateInfo, z);
        }
    }

    private final void download(RemoteOTAUpdateInfo remoteOTAUpdateInfo, boolean z) {
        Job launch$default;
        Job job = this._downloadJob;
        boolean z2 = false;
        if (job != null && job.isActive()) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.resourceScope, null, null, new OTADownloadResource$download$2(this, remoteOTAUpdateInfo, z, null), 3, null);
        this._downloadJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(OTAUpdateService oTAUpdateService, String str, File file, String str2, boolean z, Continuation<? super Unit> continuation) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "downloadFile, fileUrl: " + str + ", range: " + str2 + ", append: " + z, null, 4, null);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OTADownloadResource$downloadFile$2(oTAUpdateService, str, str2, this, file, z, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(3:(2:3|(6:5|6|7|(1:(1:(3:(1:(1:17)(2:14|15))(2:20|21)|18|19)(8:22|23|24|25|26|27|28|(2:30|(1:32)(7:33|34|(2:36|(1:38))|26|27|28|(9:40|41|42|43|45|46|(2:48|(1:50))|18|19)(0)))(0)))(10:96|97|98|99|34|(0)|26|27|28|(0)(0)))(13:103|104|105|106|107|(1:109)(1:121)|110|112|113|(1:115)|116|117|(0)(0))|83|84))|83|84)|128|6|7|(0)(0)|(2:(0)|(1:91))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[Catch: all -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x011c, blocks: (B:57:0x0115, B:47:0x00cd, B:60:0x0120), top: B:127:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #11 {all -> 0x006f, blocks: (B:25:0x0069, B:51:0x00ee, B:53:0x00f2), top: B:135:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120 A[Catch: all -> 0x011c, TRY_LEAVE, TryCatch #7 {all -> 0x011c, blocks: (B:57:0x0115, B:47:0x00cd, B:60:0x0120), top: B:127:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018d  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00f0 -> B:56:0x0112). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x010f -> B:56:0x0112). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object saveFile(kotlinx.coroutines.CoroutineScope r17, okhttp3.ResponseBody r18, java.io.File r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.saveFile(kotlinx.coroutines.CoroutineScope, okhttp3.ResponseBody, java.io.File, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void pauseDownload$default(OTADownloadResource oTADownloadResource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        oTADownloadResource.pauseDownload(z);
    }

    public final void pauseDownload(boolean z) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "pauseDownload", null, 4, null);
        Job job = this._downloadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._downloadJob = null;
        BuildersKt__Builders_commonKt.launch$default(this.resourceScope, null, null, new OTADownloadResource$pauseDownload$1(this, z, null), 3, null);
    }

    public final void cancelDownload() {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "cancelDownload", null, 4, null);
        Job job = this._downloadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._downloadJob = null;
        setAllowMeteredNetwork(false);
        BuildersKt__Builders_commonKt.launch$default(this.resourceScope, null, null, new OTADownloadResource$cancelDownload$1(this, null), 3, null);
    }

    public final void resetStatus() {
        BuildersKt__Builders_commonKt.launch$default(this.resourceScope, null, null, new OTADownloadResource$resetStatus$1(this, null), 3, null);
    }

    public final void setAllowMeteredNetwork(boolean z) {
        this._allowMeteredNetwork = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getOTAFile() {
        return new File(Environment.getExternalStorageDirectory(), DOWNLOADED_OTA_FILE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getProgressPercentage() {
        long j = this._maxProgress;
        if (j == 0) {
            return 0.0d;
        }
        return this._progress / j;
    }

    public final StateFlow<DownloadState> getStateFlow() {
        return this._downloadStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setIsProcessingSuspend(boolean z, Continuation<? super Unit> continuation) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "setIsProcessingSuspend: " + z, null, 4, null);
        Object emit = this._isProcessingFlow.emit(Boxing.boxBoolean(z), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final StateFlow<Boolean> getIsProcessingFlow() {
        return this._isProcessingFlow;
    }
}
