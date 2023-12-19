package com.nothing.OfflineOTAUpgradeApp.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugRepository.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "(Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;)V", "_isEnableDebugModeLive", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_isPrintDebugLogLive", "_mockBuildNumberLive", "", "_showScreenStateLive", "isEnableDebugModeLive", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isPrintDebugLogLive", "mockBuildNumberLive", "getMockBuildNumberLive", "showScreenStateLive", "getShowScreenStateLive", "getMockBuildNumber", "isEnableDebugMode", "isPrintDebugLog", "isShowScreenState", "setEnableDebugMode", "", "enable", "setMockBuildNumber", "buildNumber", "setPrintDebugLog", "print", "setShowScreenState", "show", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugRepository {
    public static final boolean DEBUG_BUILD = false;
    private final MutableLiveData<Boolean> _isEnableDebugModeLive;
    private final MutableLiveData<Boolean> _isPrintDebugLogLive;
    private final MutableLiveData<String> _mockBuildNumberLive;
    private final MutableLiveData<Boolean> _showScreenStateLive;
    private final LiveData<Boolean> isEnableDebugModeLive;
    private final LiveData<Boolean> isPrintDebugLogLive;
    private final LiveData<String> mockBuildNumberLive;
    private final OTAPrefs otaPrefs;
    private final LiveData<Boolean> showScreenStateLive;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final boolean isEnableDebugMode() {
        return false;
    }

    public DebugRepository(OTAPrefs otaPrefs) {
        Intrinsics.checkNotNullParameter(otaPrefs, "otaPrefs");
        this.otaPrefs = otaPrefs;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.valueOf(isEnableDebugMode()));
        this._isEnableDebugModeLive = mutableLiveData;
        this.isEnableDebugModeLive = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>(getMockBuildNumber());
        this._mockBuildNumberLive = mutableLiveData2;
        this.mockBuildNumberLive = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.valueOf(isPrintDebugLog()));
        this._isPrintDebugLogLive = mutableLiveData3;
        this.isPrintDebugLogLive = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(Boolean.valueOf(isShowScreenState()));
        this._showScreenStateLive = mutableLiveData4;
        this.showScreenStateLive = mutableLiveData4;
    }

    /* compiled from: DebugRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository$Companion;", "", "()V", "DEBUG_BUILD", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final LiveData<Boolean> isEnableDebugModeLive() {
        return this.isEnableDebugModeLive;
    }

    public final LiveData<String> getMockBuildNumberLive() {
        return this.mockBuildNumberLive;
    }

    public final LiveData<Boolean> isPrintDebugLogLive() {
        return this.isPrintDebugLogLive;
    }

    public final LiveData<Boolean> getShowScreenStateLive() {
        return this.showScreenStateLive;
    }

    public final void setEnableDebugMode(boolean z) {
        this.otaPrefs.setEnableDebugMode(z);
        this._isEnableDebugModeLive.setValue(Boolean.valueOf(z));
    }

    public final String getMockBuildNumber() {
        return this.otaPrefs.getMockBuildNumber();
    }

    public final void setMockBuildNumber(String buildNumber) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        this.otaPrefs.setMockBuildNumber(buildNumber);
        this._mockBuildNumberLive.setValue(buildNumber);
    }

    public final boolean isPrintDebugLog() {
        return this.otaPrefs.isPrintDebugLog();
    }

    public final void setPrintDebugLog(boolean z) {
        this.otaPrefs.setPrintDebugLog(z);
        this._isPrintDebugLogLive.setValue(Boolean.valueOf(z));
    }

    public final boolean isShowScreenState() {
        return this.otaPrefs.isShowScreenState();
    }

    public final void setShowScreenState(boolean z) {
        this.otaPrefs.setShowScreenState(z);
        this._showScreenStateLive.setValue(Boolean.valueOf(z));
    }
}
