package com.nothing.OfflineOTAUpgradeApp.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "formatSize", "bytes", "", "getBuildNumber", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "getBuildNumberDate", "getBuildNumberDevice", "getHomeIntent", "Landroid/content/Intent;", "goToUrl", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "isNetworkAvailable", "", "isNetworkNotMetered", "isSystemInDarkTheme", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Utils {
    public static final int $stable = 0;
    public static final Utils INSTANCE = new Utils();
    private static final String TAG = "Utils";

    private Utils() {
    }

    public final String getBuildNumber(DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        if (debugRepository.isEnableDebugMode()) {
            String mockBuildNumber = debugRepository.getMockBuildNumber();
            if (StringsKt.isBlank(mockBuildNumber)) {
                mockBuildNumber = INSTANCE.getBuildNumber();
            }
            return mockBuildNumber;
        }
        return getBuildNumber();
    }

    public final String getBuildNumber() {
        StringBuilder append = new StringBuilder(SystemProperties.get("ro.product.vendor.device", "")).append("-").append(Build.DISPLAY);
        String str = SystemProperties.get("ro.boot.hardware.sku", "");
        if (!Intrinsics.areEqual(new String[]{"ROW"}[0], str)) {
            append.append("-").append(str);
        }
        String sb = append.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public final String getBuildNumberDevice(DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        if (debugRepository.isEnableDebugMode()) {
            boolean z = false;
            String str = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) debugRepository.getMockBuildNumber(), new String[]{"-"}, false, 0, 6, (Object) null), 0);
            String str2 = str;
            return (str2 == null || StringsKt.isBlank(str2)) ? true : true ? getBuildNumberDevice() : str;
        }
        return getBuildNumberDevice();
    }

    public final String getBuildNumberDevice() {
        String str = SystemProperties.get("ro.product.vendor.device", "");
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    public final String getBuildNumberDate(DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        if (debugRepository.isEnableDebugMode()) {
            List split$default = StringsKt.split$default((CharSequence) debugRepository.getMockBuildNumber(), new String[]{"-"}, false, 0, 6, (Object) null);
            boolean z = true;
            String str = (String) CollectionsKt.getOrNull(split$default, CollectionsKt.getLastIndex(split$default) - 1);
            String str2 = (String) CollectionsKt.getOrNull(split$default, CollectionsKt.getLastIndex(split$default));
            String str3 = str;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                String str4 = str2;
                if (str4 != null && !StringsKt.isBlank(str4)) {
                    z = false;
                }
                if (!z) {
                    return str + '-' + str2;
                }
            }
            return getBuildNumberDate();
        }
        return getBuildNumberDate();
    }

    public final String getBuildNumberDate() {
        List split$default;
        String DISPLAY = Build.DISPLAY;
        Intrinsics.checkNotNullExpressionValue(DISPLAY, "DISPLAY");
        if (StringsKt.split$default((CharSequence) DISPLAY, new String[]{"-"}, false, 0, 6, (Object) null).size() < 2) {
            return "";
        }
        String str = ((String) split$default.get(CollectionsKt.getLastIndex(split$default) - 1)) + "-" + ((String) split$default.get(CollectionsKt.getLastIndex(split$default)));
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    public final Intent getHomeIntent() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        return intent;
    }

    public final void goToUrl(Context context, String uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri parse = Uri.parse(uri);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        goToUrl(context, parse);
    }

    public final void goToUrl(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logUtil.w(TAG2, "Fail to go to url: " + uri, e);
        }
    }

    public final String formatSize(long j) {
        double d;
        if (j <= 0) {
            return "0";
        }
        int log10 = (int) (Math.log10(j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, log10)) + ' ' + new String[]{"B", "kB", "MB", "GB", "TB", "PB", "EB"}[log10];
    }

    public final boolean isSystemInDarkTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final boolean isNetworkAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "context");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final boolean isNetworkNotMetered(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            Boolean valueOf = networkCapabilities != null ? Boolean.valueOf(networkCapabilities.hasCapability(11)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        return false;
    }
}
