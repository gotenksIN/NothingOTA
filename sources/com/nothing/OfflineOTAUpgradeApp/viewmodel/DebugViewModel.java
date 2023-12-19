package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DebugViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModel;", "Landroidx/lifecycle/ViewModel;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "_mockBuildNumberLive", "Landroidx/lifecycle/MutableLiveData;", "", "isEnableDebugModeLive", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "mockBuildNumberLive", "getMockBuildNumberLive", "printDebugLogLive", "getPrintDebugLogLive", "showScreenStateLive", "getShowScreenStateLive", "setEnableDebugMode", "", "enable", "setMockBuildNumber", "buildNumber", "setPrintDebugLog", "print", "setShowScreenState", "show", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<String> _mockBuildNumberLive;
    private final DebugRepository debugRepository;
    private final LiveData<Boolean> isEnableDebugModeLive;
    private final LiveData<String> mockBuildNumberLive;
    private final LiveData<Boolean> printDebugLogLive;
    private final LiveData<Boolean> showScreenStateLive;
    private final Utils utils;

    public DebugViewModel(Utils utils, DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.utils = utils;
        this.debugRepository = debugRepository;
        this.isEnableDebugModeLive = debugRepository.isEnableDebugModeLive();
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._mockBuildNumberLive = mutableLiveData;
        this.mockBuildNumberLive = mutableLiveData;
        this.printDebugLogLive = debugRepository.isPrintDebugLogLive();
        this.showScreenStateLive = debugRepository.getShowScreenStateLive();
        String mockBuildNumber = debugRepository.getMockBuildNumber();
        mutableLiveData.setValue(StringsKt.isBlank(mockBuildNumber) ? utils.getBuildNumber() : mockBuildNumber);
    }

    public final LiveData<Boolean> isEnableDebugModeLive() {
        return this.isEnableDebugModeLive;
    }

    public final LiveData<String> getMockBuildNumberLive() {
        return this.mockBuildNumberLive;
    }

    public final LiveData<Boolean> getPrintDebugLogLive() {
        return this.printDebugLogLive;
    }

    public final LiveData<Boolean> getShowScreenStateLive() {
        return this.showScreenStateLive;
    }

    public final void setEnableDebugMode(boolean z) {
        this.debugRepository.setEnableDebugMode(z);
    }

    public final void setMockBuildNumber(String buildNumber) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        this.debugRepository.setMockBuildNumber(buildNumber);
    }

    public final void setPrintDebugLog(boolean z) {
        this.debugRepository.setPrintDebugLog(z);
    }

    public final void setShowScreenState(boolean z) {
        this.debugRepository.setShowScreenState(z);
    }
}
