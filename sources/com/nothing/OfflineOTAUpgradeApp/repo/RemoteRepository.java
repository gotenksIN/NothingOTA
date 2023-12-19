package com.nothing.OfflineOTAUpgradeApp.repo;

import android.content.Context;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteServiceHost;
import com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: RemoteRepository.kt */
@Metadata(m41d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020&J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u0013\u0010-\u001a\u0004\u0018\u00010.H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\f\u00103\u001a\b\u0012\u0004\u0012\u00020(01J\u0006\u00104\u001a\u00020&J\u0011\u00105\u001a\u000206H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0006\u00107\u001a\u00020&J\u0006\u00108\u001a\u00020&J\u000e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;", "", "appContext", "Landroid/content/Context;", "repoScope", "Lkotlinx/coroutines/CoroutineScope;", "remoteContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "remoteHost", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteServiceHost;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "encryptUtil", "Lcom/nothing/OfflineOTAUpgradeApp/util/EncryptUtil;", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteServiceHost;Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/util/EncryptUtil;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "getAppContext", "()Landroid/content/Context;", "getDebugRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "downloadResource", "Lcom/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource;", "getDownloadResource", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/resource/OTADownloadResource;", "downloadResource$delegate", "Lkotlin/Lazy;", "getEncryptUtil", "()Lcom/nothing/OfflineOTAUpgradeApp/util/EncryptUtil;", "getRemoteContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getRemoteHost", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteServiceHost;", "getRepoScope", "()Lkotlinx/coroutines/CoroutineScope;", "getUtils", "()Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "allowDownloadWithMeteredNetwork", "", "allow", "", "cancelDownload", "formatBuildNumberDate", "", "buildDate", "generateQueryRequestBody", "Lcom/nothing/OfflineOTAUpgradeApp/remote/request/FetchOTAUpdateInfoRequestBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "getIsDownloadResourceProcessing", "pauseDownload", "queryAvailableUpdate", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult;", "resetDownloadStatus", "resumeDownload", "startDownload", "remoteUpdateInfo", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class RemoteRepository {
    private static final int BETA_OTA_REQUEST_DATA_VERSION = 1;
    private final Context appContext;
    private final DebugRepository debugRepository;
    private final Lazy downloadResource$delegate;
    private final EncryptUtil encryptUtil;
    private final CoroutineDispatcher remoteContext;
    private final RemoteServiceHost remoteHost;
    private final CoroutineScope repoScope;
    private final Utils utils;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "RemoteRepository";
    private static final long MIN_QUERY_DURATION = TimeUnit.SECONDS.toMillis(2);

    public RemoteRepository(Context appContext, CoroutineScope repoScope, CoroutineDispatcher remoteContext, RemoteServiceHost remoteHost, Utils utils, EncryptUtil encryptUtil, DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(repoScope, "repoScope");
        Intrinsics.checkNotNullParameter(remoteContext, "remoteContext");
        Intrinsics.checkNotNullParameter(remoteHost, "remoteHost");
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(encryptUtil, "encryptUtil");
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.appContext = appContext;
        this.repoScope = repoScope;
        this.remoteContext = remoteContext;
        this.remoteHost = remoteHost;
        this.utils = utils;
        this.encryptUtil = encryptUtil;
        this.debugRepository = debugRepository;
        this.downloadResource$delegate = LazyKt.lazy(new Functions<OTADownloadResource>() { // from class: com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository$downloadResource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final OTADownloadResource invoke() {
                return new OTADownloadResource(RemoteRepository.this.getAppContext(), RemoteRepository.this.getRepoScope(), RemoteRepository.this.getUtils(), RemoteRepository.this.getRemoteHost(), RemoteRepository.this.getEncryptUtil());
            }
        });
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final CoroutineScope getRepoScope() {
        return this.repoScope;
    }

    public /* synthetic */ RemoteRepository(Context context, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, RemoteServiceHost remoteServiceHost, Utils utils, EncryptUtil encryptUtil, DebugRepository debugRepository, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, coroutineScope, (i & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher, remoteServiceHost, utils, encryptUtil, debugRepository);
    }

    public final CoroutineDispatcher getRemoteContext() {
        return this.remoteContext;
    }

    public final RemoteServiceHost getRemoteHost() {
        return this.remoteHost;
    }

    public final Utils getUtils() {
        return this.utils;
    }

    public final EncryptUtil getEncryptUtil() {
        return this.encryptUtil;
    }

    public final DebugRepository getDebugRepository() {
        return this.debugRepository;
    }

    /* compiled from: RemoteRepository.kt */
    @Metadata(m41d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository$Companion;", "", "()V", "BETA_OTA_REQUEST_DATA_VERSION", "", "MIN_QUERY_DURATION", "", "TAG", "", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final OTADownloadResource getDownloadResource() {
        return (OTADownloadResource) this.downloadResource$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:17:0x004e, B:34:0x009f, B:36:0x00a7, B:38:0x00af, B:40:0x00b5, B:41:0x00c3, B:42:0x00f0, B:43:0x0102), top: B:59:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0102 A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #1 {Exception -> 0x0052, blocks: (B:17:0x004e, B:34:0x009f, B:36:0x00a7, B:38:0x00af, B:40:0x00b5, B:41:0x00c3, B:42:0x00f0, B:43:0x0102), top: B:59:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queryAvailableUpdate(kotlin.coroutines.Continuation<? super com.nothing.OfflineOTAUpgradeApp.remote.RemoteFetchResult> r18) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository.queryAvailableUpdate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object generateQueryRequestBody(kotlin.coroutines.Continuation<? super com.nothing.OfflineOTAUpgradeApp.remote.request.FetchOTAUpdateInfoRequestBody> r20) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository.generateQueryRequestBody(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String formatBuildNumberDate(String str) {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyMMdd-HHmm").parse(str));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logUtil.m43w(TAG2, "Fail to parse the build date: " + str, e);
            return "";
        }
    }

    public final StateFlow<DownloadState> getDownloadStateFlow() {
        return getDownloadResource().getStateFlow();
    }

    public final void startDownload(RemoteOTAUpdateInfo remoteUpdateInfo) {
        Intrinsics.checkNotNullParameter(remoteUpdateInfo, "remoteUpdateInfo");
        getDownloadResource().startDownload(remoteUpdateInfo);
    }

    public final void resumeDownload() {
        getDownloadResource().resumeDownload();
    }

    public final void pauseDownload() {
        OTADownloadResource.pauseDownload$default(getDownloadResource(), false, 1, null);
    }

    public final void cancelDownload() {
        getDownloadResource().cancelDownload();
    }

    public final void resetDownloadStatus() {
        getDownloadResource().resetStatus();
    }

    public final void allowDownloadWithMeteredNetwork(boolean z) {
        getDownloadResource().setAllowMeteredNetwork(z);
    }

    public final StateFlow<Boolean> getIsDownloadResourceProcessing() {
        return getDownloadResource().getIsProcessingFlow();
    }
}
