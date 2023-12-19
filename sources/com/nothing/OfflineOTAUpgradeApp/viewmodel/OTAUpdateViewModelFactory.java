package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTAUpdateViewModelFactory.kt */
@Metadata(m41d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "updateManager", "Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;", "updateUtils", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "remoteRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class OTAUpdateViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final DebugRepository debugRepository;
    private final OTAPrefs otaPrefs;
    private final RemoteRepository remoteRepository;
    private final UpdateManager updateManager;
    private final UpdateUtils updateUtils;
    private final Utils utils;

    public OTAUpdateViewModelFactory(UpdateManager updateManager, UpdateUtils updateUtils, Utils utils, OTAPrefs otaPrefs, RemoteRepository remoteRepository, DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(updateManager, "updateManager");
        Intrinsics.checkNotNullParameter(updateUtils, "updateUtils");
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(otaPrefs, "otaPrefs");
        Intrinsics.checkNotNullParameter(remoteRepository, "remoteRepository");
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.updateManager = updateManager;
        this.updateUtils = updateUtils;
        this.utils = utils;
        this.otaPrefs = otaPrefs;
        this.remoteRepository = remoteRepository;
        this.debugRepository = debugRepository;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new OTAUpdateViewModel(this.updateManager, this.updateUtils, this.utils, this.otaPrefs, this.remoteRepository, this.debugRepository);
    }
}
