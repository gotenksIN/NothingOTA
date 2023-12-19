package com.nothing.OfflineOTAUpgradeApp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.UpdateEngine;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.repo.RepoContainer;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainApplication.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/MainApplication;", "Landroid/app/Application;", "()V", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "getDebugRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "setDebugRepository", "(Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "getOtaPrefs", "()Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "setOtaPrefs", "(Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;)V", "repoContainer", "Lcom/nothing/OfflineOTAUpgradeApp/repo/RepoContainer;", "getRepoContainer", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/RepoContainer;", "setRepoContainer", "(Lcom/nothing/OfflineOTAUpgradeApp/repo/RepoContainer;)V", "updateManager", "Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;", "getUpdateManager", "()Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;", "updateUtils", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;", "getUpdateUtils", "()Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;", "setUpdateUtils", "(Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;)V", "onCreate", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainApplication extends Application {
    public static final int $stable = 8;
    public DebugRepository debugRepository;
    public OTAPrefs otaPrefs;
    public RepoContainer repoContainer;
    private final UpdateManager updateManager = new UpdateManager(new UpdateEngine(), new Handler(Looper.getMainLooper()));
    public UpdateUtils updateUtils;

    public final OTAPrefs getOtaPrefs() {
        OTAPrefs oTAPrefs = this.otaPrefs;
        if (oTAPrefs != null) {
            return oTAPrefs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("otaPrefs");
        return null;
    }

    public final void setOtaPrefs(OTAPrefs oTAPrefs) {
        Intrinsics.checkNotNullParameter(oTAPrefs, "<set-?>");
        this.otaPrefs = oTAPrefs;
    }

    public final DebugRepository getDebugRepository() {
        DebugRepository debugRepository = this.debugRepository;
        if (debugRepository != null) {
            return debugRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("debugRepository");
        return null;
    }

    public final void setDebugRepository(DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(debugRepository, "<set-?>");
        this.debugRepository = debugRepository;
    }

    public final UpdateUtils getUpdateUtils() {
        UpdateUtils updateUtils = this.updateUtils;
        if (updateUtils != null) {
            return updateUtils;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateUtils");
        return null;
    }

    public final void setUpdateUtils(UpdateUtils updateUtils) {
        Intrinsics.checkNotNullParameter(updateUtils, "<set-?>");
        this.updateUtils = updateUtils;
    }

    public final UpdateManager getUpdateManager() {
        return this.updateManager;
    }

    public final RepoContainer getRepoContainer() {
        RepoContainer repoContainer = this.repoContainer;
        if (repoContainer != null) {
            return repoContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("repoContainer");
        return null;
    }

    public final void setRepoContainer(RepoContainer repoContainer) {
        Intrinsics.checkNotNullParameter(repoContainer, "<set-?>");
        this.repoContainer = repoContainer;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        MainApplication mainApplication = this;
        setOtaPrefs(new OTAPrefs(mainApplication));
        setDebugRepository(new DebugRepository(getOtaPrefs()));
        setUpdateUtils(new UpdateUtils(mainApplication, this.updateManager, getOtaPrefs()));
        setRepoContainer(new RepoContainer(this));
        LogUtil.INSTANCE.setDebugRepository(getRepoContainer().getDebugRepository());
    }
}
