package com.nothing.OfflineOTAUpgradeApp.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteFetchResult.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult;", "", "Failure", "Success", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult$Failure;", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult$Success;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RemoteFetchResult {

    /* compiled from: RemoteFetchResult.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult$Success;", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult;", "data", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;)V", "getData", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Success implements RemoteFetchResult {
        public static final int $stable = 0;
        private final RemoteOTAUpdateInfo data;

        public Success(RemoteOTAUpdateInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final RemoteOTAUpdateInfo getData() {
            return this.data;
        }
    }

    /* compiled from: RemoteFetchResult.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult$Failure;", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteFetchResult;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Failure implements RemoteFetchResult {
        public static final int $stable = 0;
        private final String errorMessage;

        public Failure(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }
}
