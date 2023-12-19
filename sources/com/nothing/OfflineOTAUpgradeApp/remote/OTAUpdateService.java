package com.nothing.OfflineOTAUpgradeApp.remote;

import com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService;
import com.nothing.OfflineOTAUpgradeApp.remote.request.FetchOTAUpdateInfoRequestBody;
import com.nothing.OfflineOTAUpgradeApp.remote.response.FetchOTAUpdateInfoResponse;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* compiled from: OTAUpdateService.kt */
@Metadata(m41d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u000b\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;", "", "downloadFile", "Lokhttp3/ResponseBody;", "fileUrl", "", "range", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOTAUpdateInfo", "Lretrofit2/Response;", "Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoResponse;", "requestBody", "Lcom/nothing/OfflineOTAUpgradeApp/remote/request/FetchOTAUpdateInfoRequestBody;", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/request/FetchOTAUpdateInfoRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public interface OTAUpdateService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Streaming
    @GET
    Object downloadFile(@Url String str, @Header("Range") String str2, Continuation<? super ResponseBody> continuation);

    @POST("/beta-ota/fullOrDiffCheck")
    Object fetchOTAUpdateInfo(@Body FetchOTAUpdateInfoRequestBody fetchOTAUpdateInfoRequestBody, Continuation<? super Response<FetchOTAUpdateInfoResponse>> continuation);

    /* compiled from: OTAUpdateService.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\f¨\u0006\u001f"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService$Companion;", "", "()V", "BASE_URL_PRODUCTION", "", "BASE_URL_TEST", "CONNECTION_TIMEOUT_SECONDS", "", "READ_TIMEOUT_SECONDS", "_devOtaAPIService", "Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;", "get_devOtaAPIService", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;", "_devOtaAPIService$delegate", "Lkotlin/Lazy;", "_devOtaDownloadService", "get_devOtaDownloadService", "_devOtaDownloadService$delegate", "_otaAPIService", "get_otaAPIService", "_otaAPIService$delegate", "_otaDownloadService", "get_otaDownloadService", "_otaDownloadService$delegate", "createAPIService", "baseUrl", "createDownloadAPIService", "getAPIService", "getDevAPIService", "getDevDownloadService", "getDownloadService", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static final String BASE_URL_PRODUCTION = "https://dc-api.nothingtech.link";
        private static final String BASE_URL_TEST = "https://gn9g0h8093.execute-api.ap-northeast-1.amazonaws.com";
        private static final long CONNECTION_TIMEOUT_SECONDS = 20;
        private static final long READ_TIMEOUT_SECONDS = 40;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<OTAUpdateService> _devOtaAPIService$delegate = LazyKt.lazy(new Functions<OTAUpdateService>() { // from class: com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService$Companion$_devOtaAPIService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final OTAUpdateService invoke() {
                OTAUpdateService createAPIService;
                createAPIService = OTAUpdateService.Companion.$$INSTANCE.createAPIService("https://gn9g0h8093.execute-api.ap-northeast-1.amazonaws.com");
                return createAPIService;
            }
        });
        private static final Lazy<OTAUpdateService> _otaAPIService$delegate = LazyKt.lazy(new Functions<OTAUpdateService>() { // from class: com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService$Companion$_otaAPIService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final OTAUpdateService invoke() {
                OTAUpdateService createAPIService;
                createAPIService = OTAUpdateService.Companion.$$INSTANCE.createAPIService("https://dc-api.nothingtech.link");
                return createAPIService;
            }
        });
        private static final Lazy<OTAUpdateService> _devOtaDownloadService$delegate = LazyKt.lazy(new Functions<OTAUpdateService>() { // from class: com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService$Companion$_devOtaDownloadService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final OTAUpdateService invoke() {
                OTAUpdateService createDownloadAPIService;
                createDownloadAPIService = OTAUpdateService.Companion.$$INSTANCE.createDownloadAPIService("https://gn9g0h8093.execute-api.ap-northeast-1.amazonaws.com");
                return createDownloadAPIService;
            }
        });
        private static final Lazy<OTAUpdateService> _otaDownloadService$delegate = LazyKt.lazy(new Functions<OTAUpdateService>() { // from class: com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService$Companion$_otaDownloadService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final OTAUpdateService invoke() {
                OTAUpdateService createDownloadAPIService;
                createDownloadAPIService = OTAUpdateService.Companion.$$INSTANCE.createDownloadAPIService("https://dc-api.nothingtech.link");
                return createDownloadAPIService;
            }
        });

        private Companion() {
        }

        private final OTAUpdateService get_devOtaAPIService() {
            return _devOtaAPIService$delegate.getValue();
        }

        private final OTAUpdateService get_otaAPIService() {
            return _otaAPIService$delegate.getValue();
        }

        private final OTAUpdateService get_devOtaDownloadService() {
            return _devOtaDownloadService$delegate.getValue();
        }

        private final OTAUpdateService get_otaDownloadService() {
            return _otaDownloadService$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OTAUpdateService createAPIService(String str) {
            OkHttpClient.Builder readTimeout = new OkHttpClient.Builder().connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS).readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            Object create = new Retrofit.Builder().baseUrl(str).client(readTimeout.addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create()).build().create(OTAUpdateService.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (OTAUpdateService) create;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OTAUpdateService createDownloadAPIService(String str) {
            OkHttpClient.Builder readTimeout = new OkHttpClient.Builder().connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS).readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            Object create = new Retrofit.Builder().baseUrl(str).client(readTimeout.addInterceptor(httpLoggingInterceptor).build()).build().create(OTAUpdateService.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (OTAUpdateService) create;
        }

        public final OTAUpdateService getDevAPIService() {
            return get_devOtaAPIService();
        }

        public final OTAUpdateService getAPIService() {
            return get_otaAPIService();
        }

        public final OTAUpdateService getDevDownloadService() {
            return get_devOtaDownloadService();
        }

        public final OTAUpdateService getDownloadService() {
            return get_otaDownloadService();
        }
    }

    /* compiled from: OTAUpdateService.kt */
    @Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object downloadFile$default(OTAUpdateService oTAUpdateService, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "bytes=0-";
                }
                return oTAUpdateService.downloadFile(str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
        }
    }
}
