package com.nothing.OfflineOTAUpgradeApp.util;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTAPrefs.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMockBuildNumber", "", "getOtaFilePath", "getSharedPreferences", "Landroid/content/SharedPreferences;", "getUpdatingBuildNumber", "isEnableDebugMode", "", "isPrintDebugLog", "isShowScreenState", "resetMock", "", "resetOtaFilePath", "resetUpdatingBuildNumber", "setEnableDebugMode", "enable", "setMockBuildNumber", "buildNumber", "setOtaFilePath", "path", "setPrintDebugLog", "print", "setShowScreenState", "show", "setUpdatingBuildNumber", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OTAPrefs {
    private static final String KEY_ENABLE_MOCK_BUILD = "prefEnableMockBuild";
    private static final String KEY_FILE_PATH = "file_path";
    private static final String KEY_MOCK_BUILD_NUMBER = "prefMockBuildNumber";
    private static final String KEY_PRINT_DEBUG_LOG = "prefPrintDebugLog";
    private static final String KEY_SHOW_SCREEN_STATE = "prefShowScreenState";
    private static final String KEY_UPDATING_BUILD_NUMBER = "prefsUpdatingBuildNumber";
    private static final String SHARED_PREFERENCES_NAME = "ota_prefs";
    private final Context appContext;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "OTAPrefs";

    public OTAPrefs(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    /* compiled from: OTAPrefs.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs$Companion;", "", "()V", "KEY_ENABLE_MOCK_BUILD", "", "KEY_FILE_PATH", "KEY_MOCK_BUILD_NUMBER", "KEY_PRINT_DEBUG_LOG", "KEY_SHOW_SCREEN_STATE", "KEY_UPDATING_BUILD_NUMBER", "SHARED_PREFERENCES_NAME", "TAG", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = this.appContext.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void setOtaFilePath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(KEY_FILE_PATH, path);
        edit.apply();
    }

    public final void resetOtaFilePath() {
        getSharedPreferences().edit().remove(KEY_FILE_PATH).apply();
    }

    public final String getOtaFilePath() {
        String string = getSharedPreferences().getString(KEY_FILE_PATH, "");
        return string == null ? "" : string;
    }

    public final void setUpdatingBuildNumber(String buildNumber) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(KEY_UPDATING_BUILD_NUMBER, buildNumber);
        edit.apply();
    }

    public final void resetUpdatingBuildNumber() {
        getSharedPreferences().edit().remove(KEY_UPDATING_BUILD_NUMBER).apply();
    }

    public final String getUpdatingBuildNumber() {
        String string = getSharedPreferences().getString(KEY_UPDATING_BUILD_NUMBER, "");
        return string == null ? "" : string;
    }

    public final void resetMock() {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.remove(KEY_ENABLE_MOCK_BUILD);
        edit.remove(KEY_MOCK_BUILD_NUMBER);
        edit.apply();
    }

    public final void setEnableDebugMode(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(KEY_ENABLE_MOCK_BUILD, z);
        edit.apply();
    }

    public final boolean isEnableDebugMode() {
        return getSharedPreferences().getBoolean(KEY_ENABLE_MOCK_BUILD, false);
    }

    public final void setMockBuildNumber(String buildNumber) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(KEY_MOCK_BUILD_NUMBER, buildNumber);
        edit.apply();
    }

    public final String getMockBuildNumber() {
        String string = getSharedPreferences().getString(KEY_MOCK_BUILD_NUMBER, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final void setPrintDebugLog(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(KEY_PRINT_DEBUG_LOG, z);
        edit.apply();
    }

    public final boolean isPrintDebugLog() {
        return getSharedPreferences().getBoolean(KEY_PRINT_DEBUG_LOG, false);
    }

    public final void setShowScreenState(boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(KEY_SHOW_SCREEN_STATE, z);
        edit.apply();
    }

    public final boolean isShowScreenState() {
        return getSharedPreferences().getBoolean(KEY_SHOW_SCREEN_STATE, false);
    }
}
