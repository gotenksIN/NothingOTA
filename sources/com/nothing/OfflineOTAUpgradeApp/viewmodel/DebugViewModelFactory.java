package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugViewModelFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "mockUtil", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final DebugRepository mockUtil;
    private final Utils utils;

    public DebugViewModelFactory(Utils utils, DebugRepository mockUtil) {
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(mockUtil, "mockUtil");
        this.utils = utils;
        this.mockUtil = mockUtil;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new DebugViewModel(this.utils, this.mockUtil);
    }
}
