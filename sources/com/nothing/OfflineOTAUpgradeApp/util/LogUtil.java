package com.nothing.OfflineOTAUpgradeApp.util;

import android.util.Log;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUtil.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0015\u0010\u0003\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/LogUtil;", "", "()V", "ENABLE", "", "getENABLE", "()Z", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "getDebugRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "setDebugRepository", "(Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "d", "", "tag", "", "message", "throwable", "", "e", "i", "v", "w", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LogUtil {
    private static DebugRepository debugRepository;
    public static final LogUtil INSTANCE = new LogUtil();
    public static final int $stable = 8;

    private LogUtil() {
    }

    public final DebugRepository getDebugRepository() {
        return debugRepository;
    }

    public final void setDebugRepository(DebugRepository debugRepository2) {
        debugRepository = debugRepository2;
    }

    private final boolean getENABLE() {
        DebugRepository debugRepository2 = debugRepository;
        return debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog();
    }

    public static /* synthetic */ void i$default(LogUtil logUtil, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logUtil.i(str, str2, th);
    }

    public static /* synthetic */ void v$default(LogUtil logUtil, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logUtil.v(str, str2, th);
    }

    public static /* synthetic */ void d$default(LogUtil logUtil, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logUtil.d(str, str2, th);
    }

    public static /* synthetic */ void w$default(LogUtil logUtil, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logUtil.w(str, str2, th);
    }

    public static /* synthetic */ void e$default(LogUtil logUtil, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logUtil.e(str, str2, th);
    }

    public final void i(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        DebugRepository debugRepository2 = debugRepository;
        boolean z = false;
        if (debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog()) {
            z = true;
        }
        if (z) {
            Log.i(tag, message, th);
        }
    }

    public final void v(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        DebugRepository debugRepository2 = debugRepository;
        boolean z = false;
        if (debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog()) {
            z = true;
        }
        if (z) {
            Log.v(tag, message, th);
        }
    }

    public final void d(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        DebugRepository debugRepository2 = debugRepository;
        boolean z = false;
        if (debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog()) {
            z = true;
        }
        if (z) {
            Log.d(tag, message, th);
        }
    }

    public final void w(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        DebugRepository debugRepository2 = debugRepository;
        boolean z = false;
        if (debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog()) {
            z = true;
        }
        if (z) {
            Log.w(tag, message, th);
        }
    }

    public final void e(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        DebugRepository debugRepository2 = debugRepository;
        boolean z = false;
        if (debugRepository2 != null && debugRepository2.isEnableDebugMode() && debugRepository2.isPrintDebugLog()) {
            z = true;
        }
        if (z) {
            Log.e(tag, message, th);
        }
    }
}
