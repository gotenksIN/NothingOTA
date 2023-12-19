package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DebugViewModel.kt */
@Metadata(m41d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eJ\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000eJ\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModel;", "Landroidx/lifecycle/ViewModel;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "_mockBuildDeviceLive", "Landroidx/lifecycle/MediatorLiveData;", "", "_mockBuildDisplayLive", "_mockBuildSkuLive", "applyDevEnvironmentLive", "Landroidx/lifecycle/LiveData;", "", "getApplyDevEnvironmentLive", "()Landroidx/lifecycle/LiveData;", "isEnableDebugModeLive", "mockBuildDeviceLive", "getMockBuildDeviceLive", "mockBuildDisplayLive", "getMockBuildDisplayLive", "mockBuildSkuLive", "getMockBuildSkuLive", "printDebugLogLive", "getPrintDebugLogLive", "showScreenStateLive", "getShowScreenStateLive", "applyMockBuildNumber", "", "resetBuildNumber", "setApplyDevEnvironment", "apply", "setEnableDebugMode", "enable", "setMockBuildNumber", "device", "display", "sku", "setPrintDebugLog", "print", "setShowScreenState", "show", "updateBuildDevice", "updateBuildDisplay", "updateBuildSku", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class DebugViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MediatorLiveData<String> _mockBuildDeviceLive;
    private final MediatorLiveData<String> _mockBuildDisplayLive;
    private final MediatorLiveData<String> _mockBuildSkuLive;
    private final LiveData<Boolean> applyDevEnvironmentLive;
    private final DebugRepository debugRepository;
    private final LiveData<Boolean> isEnableDebugModeLive;
    private final LiveData<String> mockBuildDeviceLive;
    private final LiveData<String> mockBuildDisplayLive;
    private final LiveData<String> mockBuildSkuLive;
    private final LiveData<Boolean> printDebugLogLive;
    private final LiveData<Boolean> showScreenStateLive;
    private final Utils utils;

    public DebugViewModel(Utils utils, DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.utils = utils;
        this.debugRepository = debugRepository;
        this.isEnableDebugModeLive = debugRepository.isEnableDebugModeLive();
        this.applyDevEnvironmentLive = debugRepository.getApplyDevEnvironmentLive();
        final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(debugRepository.getMockDeviceLive(), new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DebugViewModel._mockBuildDeviceLive$lambda$2$lambda$1(MediatorLiveData.this, this, (String) obj);
            }
        });
        this._mockBuildDeviceLive = mediatorLiveData;
        this.mockBuildDeviceLive = mediatorLiveData;
        final MediatorLiveData<String> mediatorLiveData2 = new MediatorLiveData<>();
        mediatorLiveData2.addSource(debugRepository.getMockDisplayLive(), new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DebugViewModel._mockBuildDisplayLive$lambda$5$lambda$4(MediatorLiveData.this, this, (String) obj);
            }
        });
        this._mockBuildDisplayLive = mediatorLiveData2;
        this.mockBuildDisplayLive = mediatorLiveData2;
        final MediatorLiveData<String> mediatorLiveData3 = new MediatorLiveData<>();
        mediatorLiveData3.addSource(debugRepository.getMockSkuLive(), new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DebugViewModel._mockBuildSkuLive$lambda$7$lambda$6(MediatorLiveData.this, (String) obj);
            }
        });
        this._mockBuildSkuLive = mediatorLiveData3;
        this.mockBuildSkuLive = mediatorLiveData3;
        this.printDebugLogLive = debugRepository.isPrintDebugLogLive();
        this.showScreenStateLive = debugRepository.getShowScreenStateLive();
    }

    public final LiveData<Boolean> isEnableDebugModeLive() {
        return this.isEnableDebugModeLive;
    }

    public final LiveData<Boolean> getApplyDevEnvironmentLive() {
        return this.applyDevEnvironmentLive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _mockBuildDeviceLive$lambda$2$lambda$1(MediatorLiveData this_apply, DebugViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            str2 = this$0.utils.getBuildNumberDevice();
        }
        this_apply.setValue(str2);
    }

    public final LiveData<String> getMockBuildDeviceLive() {
        return this.mockBuildDeviceLive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _mockBuildDisplayLive$lambda$5$lambda$4(MediatorLiveData this_apply, DebugViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            str2 = this$0.utils.getBuildNumberDisplay();
        }
        this_apply.setValue(str2);
    }

    public final LiveData<String> getMockBuildDisplayLive() {
        return this.mockBuildDisplayLive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _mockBuildSkuLive$lambda$7$lambda$6(MediatorLiveData this_apply, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setValue(str);
    }

    public final LiveData<String> getMockBuildSkuLive() {
        return this.mockBuildSkuLive;
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

    public final void setMockBuildNumber(String device, String display, String sku) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(sku, "sku");
        this.debugRepository.setMockBuildNumber(device, display, sku);
    }

    public final void applyMockBuildNumber() {
        String value = this._mockBuildDeviceLive.getValue();
        if (value == null) {
            value = "";
        }
        String value2 = this._mockBuildDisplayLive.getValue();
        if (value2 == null) {
            value2 = "";
        }
        String value3 = this._mockBuildSkuLive.getValue();
        setMockBuildNumber(value, value2, value3 != null ? value3 : "");
    }

    public final void updateBuildDevice(String device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this._mockBuildDeviceLive.setValue(device);
    }

    public final void updateBuildDisplay(String display) {
        Intrinsics.checkNotNullParameter(display, "display");
        this._mockBuildDisplayLive.setValue(display);
    }

    public final void updateBuildSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        this._mockBuildSkuLive.setValue(sku);
    }

    public final void resetBuildNumber() {
        this.debugRepository.resetMockBuildNumber();
    }

    public final void setPrintDebugLog(boolean z) {
        this.debugRepository.setPrintDebugLog(z);
    }

    public final void setShowScreenState(boolean z) {
        this.debugRepository.setShowScreenState(z);
    }

    public final void setApplyDevEnvironment(boolean z) {
        this.debugRepository.setApplyDevEnvironment(z);
    }
}
