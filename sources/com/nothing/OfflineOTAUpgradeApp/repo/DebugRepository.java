package com.nothing.OfflineOTAUpgradeApp.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugRepository.kt */
@Metadata(m41d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0007J\u001e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fJ\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u00064"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "(Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;)V", "_applyDevEnvironmentLive", "Landroidx/lifecycle/MutableLiveData;", "", "_isEnableDebugModeLive", "kotlin.jvm.PlatformType", "_isPrintDebugLogLive", "_mockDeviceLive", "", "_mockDisplayLive", "_mockSkuLive", "_showScreenStateLive", "applyDevEnvironmentLive", "Landroidx/lifecycle/LiveData;", "getApplyDevEnvironmentLive", "()Landroidx/lifecycle/LiveData;", "isEnableDebugModeLive", "isPrintDebugLogLive", "mockDeviceLive", "getMockDeviceLive", "mockDisplayLive", "getMockDisplayLive", "mockSkuLive", "getMockSkuLive", "showScreenStateLive", "getShowScreenStateLive", "getMockBuildDevice", "getMockBuildDisplay", "getMockBuildSku", "isApplyDevEnvironment", "isEnableDebugMode", "isPrintDebugLog", "isShowScreenState", "resetMockBuildNumber", "", "setApplyDevEnvironment", "apply", "setEnableDebugMode", "enable", "setMockBuildNumber", "device", "display", "sku", "setPrintDebugLog", "print", "setShowScreenState", "show", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class DebugRepository {
    public static final boolean DEBUG_BUILD = false;
    private final MutableLiveData<Boolean> _applyDevEnvironmentLive;
    private final MutableLiveData<Boolean> _isEnableDebugModeLive;
    private final MutableLiveData<Boolean> _isPrintDebugLogLive;
    private final MutableLiveData<String> _mockDeviceLive;
    private final MutableLiveData<String> _mockDisplayLive;
    private final MutableLiveData<String> _mockSkuLive;
    private final MutableLiveData<Boolean> _showScreenStateLive;
    private final LiveData<Boolean> applyDevEnvironmentLive;
    private final LiveData<Boolean> isEnableDebugModeLive;
    private final LiveData<Boolean> isPrintDebugLogLive;
    private final LiveData<String> mockDeviceLive;
    private final LiveData<String> mockDisplayLive;
    private final LiveData<String> mockSkuLive;
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
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>(getMockBuildDevice());
        this._mockDeviceLive = mutableLiveData2;
        this.mockDeviceLive = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>(getMockBuildDisplay());
        this._mockDisplayLive = mutableLiveData3;
        this.mockDisplayLive = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>(getMockBuildSku());
        this._mockSkuLive = mutableLiveData4;
        this.mockSkuLive = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(Boolean.valueOf(isPrintDebugLog()));
        this._isPrintDebugLogLive = mutableLiveData5;
        this.isPrintDebugLogLive = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(Boolean.valueOf(isShowScreenState()));
        this._showScreenStateLive = mutableLiveData6;
        this.showScreenStateLive = mutableLiveData6;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>(Boolean.valueOf(isApplyDevEnvironment()));
        this._applyDevEnvironmentLive = mutableLiveData7;
        this.applyDevEnvironmentLive = mutableLiveData7;
    }

    /* compiled from: DebugRepository.kt */
    @Metadata(m41d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository$Companion;", "", "()V", "DEBUG_BUILD", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
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

    public final LiveData<String> getMockDeviceLive() {
        return this.mockDeviceLive;
    }

    public final LiveData<String> getMockDisplayLive() {
        return this.mockDisplayLive;
    }

    public final LiveData<String> getMockSkuLive() {
        return this.mockSkuLive;
    }

    public final LiveData<Boolean> isPrintDebugLogLive() {
        return this.isPrintDebugLogLive;
    }

    public final LiveData<Boolean> getShowScreenStateLive() {
        return this.showScreenStateLive;
    }

    public final LiveData<Boolean> getApplyDevEnvironmentLive() {
        return this.applyDevEnvironmentLive;
    }

    public final void setEnableDebugMode(boolean z) {
        this.otaPrefs.setEnableDebugMode(z);
        this._isEnableDebugModeLive.setValue(Boolean.valueOf(z));
    }

    public final String getMockBuildDevice() {
        return this.otaPrefs.getMockBuildDevice();
    }

    public final String getMockBuildDisplay() {
        return this.otaPrefs.getMockBuildDisplay();
    }

    public final String getMockBuildSku() {
        return this.otaPrefs.getMockBuildSku();
    }

    public final void setMockBuildNumber(String device, String display, String sku) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(sku, "sku");
        this.otaPrefs.setMockBuildNumber(device, display, sku);
        this._mockDeviceLive.setValue(device);
        this._mockDisplayLive.setValue(display);
        this._mockSkuLive.setValue(sku);
    }

    public final void resetMockBuildNumber() {
        this.otaPrefs.resetMockBuildNumber();
        this._mockDeviceLive.setValue(getMockBuildDevice());
        this._mockDisplayLive.setValue(getMockBuildDisplay());
        this._mockSkuLive.setValue(getMockBuildSku());
    }

    public final boolean isPrintDebugLog() {
        return this.otaPrefs.isPrintDebugLog();
    }

    public final void setPrintDebugLog(boolean z) {
        this.otaPrefs.setPrintDebugLog(z);
        this._isPrintDebugLogLive.setValue(Boolean.valueOf(z));
    }

    public final boolean isApplyDevEnvironment() {
        return this.otaPrefs.isApplyDevEnvironment();
    }

    public final void setApplyDevEnvironment(boolean z) {
        this.otaPrefs.setApplyDevEnvironment(z);
        this._applyDevEnvironmentLive.setValue(Boolean.valueOf(z));
    }

    public final boolean isShowScreenState() {
        return this.otaPrefs.isShowScreenState();
    }

    public final void setShowScreenState(boolean z) {
        this.otaPrefs.setShowScreenState(z);
        this._showScreenStateLive.setValue(Boolean.valueOf(z));
    }
}
