package com.nothing.OfflineOTAUpgradeApp.remote;

import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteServiceHost.kt */
@Metadata(m41d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteServiceHost;", "", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "getDebugRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "getApiService", "Lcom/nothing/OfflineOTAUpgradeApp/remote/OTAUpdateService;", "getDownloadService", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class RemoteServiceHost {
    public static final int $stable = DebugRepository.$stable;
    private final DebugRepository debugRepository;

    public RemoteServiceHost(DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.debugRepository = debugRepository;
    }

    public final DebugRepository getDebugRepository() {
        return this.debugRepository;
    }

    public final OTAUpdateService getApiService() {
        if (this.debugRepository.isEnableDebugMode() && this.debugRepository.isApplyDevEnvironment()) {
            return OTAUpdateService.Companion.getDevAPIService();
        }
        return OTAUpdateService.Companion.getAPIService();
    }

    public final OTAUpdateService getDownloadService() {
        if (this.debugRepository.isEnableDebugMode() && this.debugRepository.isApplyDevEnvironment()) {
            return OTAUpdateService.Companion.getDevDownloadService();
        }
        return OTAUpdateService.Companion.getDownloadService();
    }
}
