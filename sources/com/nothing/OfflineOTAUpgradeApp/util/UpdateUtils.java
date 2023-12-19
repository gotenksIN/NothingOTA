package com.nothing.OfflineOTAUpgradeApp.util;

import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.util.Log;
import com.nothing.OfflineOTAUpgradeApp.PayloadSpec;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
import com.nothing.OfflineOTAUpgradeApp.ui.MainActivity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateUtils.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u001c\u0010\u0015\u001a\u00020\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u001c\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;", "", "appContext", "Landroid/content/Context;", "updateManager", "Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "(Landroid/content/Context;Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;)V", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "acquireWakeLock", "", "applyOTAFile", "", "otaFileId", "", "otaApplyMetadata", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$OTAApplyMetadata;", "deleteOtaFile", "isHardwareAndVersionVerifyFail", "metaFileMap", "", "releaseWakeLock", "verifyMetaDataFile", "", "Ljava/util/HashMap;", "verifyOTAFile", "Companion", "OTAApplyMetadata", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdateUtils {
    public static final String KEY_POST_OTA_VERSION = "POST_OTA_VERSION";
    public static final int METADATA_VERIFY_STATE_ERROR_1 = -1;
    public static final int METADATA_VERIFY_STATE_ERROR_2 = -2;
    public static final int METADATA_VERIFY_STATE_ERROR_3 = -3;
    public static final int METADATA_VERIFY_STATE_ERROR_FILE = -4;
    public static final int METADATA_VERIFY_STATE_SUCCESS = 0;
    public static final String SDCARD_DATA_PATH = "/data/media/0/";
    private final Context appContext;
    private final OTAPrefs otaPrefs;
    private final UpdateManager updateManager;
    private PowerManager.WakeLock wakeLock;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "UpdateUtils";

    public UpdateUtils(Context appContext, UpdateManager updateManager, OTAPrefs otaPrefs) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(updateManager, "updateManager");
        Intrinsics.checkNotNullParameter(otaPrefs, "otaPrefs");
        this.appContext = appContext;
        this.updateManager = updateManager;
        this.otaPrefs = otaPrefs;
    }

    /* compiled from: UpdateUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$Companion;", "", "()V", "KEY_POST_OTA_VERSION", "", "METADATA_VERIFY_STATE_ERROR_1", "", "METADATA_VERIFY_STATE_ERROR_2", "METADATA_VERIFY_STATE_ERROR_3", "METADATA_VERIFY_STATE_ERROR_FILE", "METADATA_VERIFY_STATE_SUCCESS", "SDCARD_DATA_PATH", "TAG", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: UpdateUtils.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$OTAApplyMetadata;", "", "verifyState", "", "payloadOffset", "", "payloadSize", "properties", "", "", "buildNumber", "(IJJLjava/util/List;Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "getPayloadOffset", "()J", "getPayloadSize", "getProperties", "()Ljava/util/List;", "getVerifyState", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OTAApplyMetadata {
        private final String buildNumber;
        private final long payloadOffset;
        private final long payloadSize;
        private final List<String> properties;
        private final int verifyState;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ OTAApplyMetadata copy$default(OTAApplyMetadata oTAApplyMetadata, int i, long j, long j2, List list, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oTAApplyMetadata.verifyState;
            }
            if ((i2 & 2) != 0) {
                j = oTAApplyMetadata.payloadOffset;
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = oTAApplyMetadata.payloadSize;
            }
            long j4 = j2;
            List<String> list2 = list;
            if ((i2 & 8) != 0) {
                list2 = oTAApplyMetadata.properties;
            }
            List list3 = list2;
            if ((i2 & 16) != 0) {
                str = oTAApplyMetadata.buildNumber;
            }
            return oTAApplyMetadata.copy(i, j3, j4, list3, str);
        }

        public final int component1() {
            return this.verifyState;
        }

        public final long component2() {
            return this.payloadOffset;
        }

        public final long component3() {
            return this.payloadSize;
        }

        public final List<String> component4() {
            return this.properties;
        }

        public final String component5() {
            return this.buildNumber;
        }

        public final OTAApplyMetadata copy(int i, long j, long j2, List<String> properties, String buildNumber) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new OTAApplyMetadata(i, j, j2, properties, buildNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OTAApplyMetadata) {
                OTAApplyMetadata oTAApplyMetadata = (OTAApplyMetadata) obj;
                return this.verifyState == oTAApplyMetadata.verifyState && this.payloadOffset == oTAApplyMetadata.payloadOffset && this.payloadSize == oTAApplyMetadata.payloadSize && Intrinsics.areEqual(this.properties, oTAApplyMetadata.properties) && Intrinsics.areEqual(this.buildNumber, oTAApplyMetadata.buildNumber);
            }
            return false;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.verifyState) * 31) + Long.hashCode(this.payloadOffset)) * 31) + Long.hashCode(this.payloadSize)) * 31) + this.properties.hashCode()) * 31) + this.buildNumber.hashCode();
        }

        public String toString() {
            return "OTAApplyMetadata(verifyState=" + this.verifyState + ", payloadOffset=" + this.payloadOffset + ", payloadSize=" + this.payloadSize + ", properties=" + this.properties + ", buildNumber=" + this.buildNumber + ')';
        }

        public OTAApplyMetadata(int i, long j, long j2, List<String> properties, String buildNumber) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.verifyState = i;
            this.payloadOffset = j;
            this.payloadSize = j2;
            this.properties = properties;
            this.buildNumber = buildNumber;
        }

        public final int getVerifyState() {
            return this.verifyState;
        }

        public final long getPayloadOffset() {
            return this.payloadOffset;
        }

        public final long getPayloadSize() {
            return this.payloadSize;
        }

        public /* synthetic */ OTAApplyMetadata(int i, long j, long j2, List list, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? "" : str);
        }

        public final List<String> getProperties() {
            return this.properties;
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        /* compiled from: UpdateUtils.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$OTAApplyMetadata$Companion;", "", "()V", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.OTAApplyMetadata verifyOTAFile(java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.verifyOTAFile(java.lang.String):com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils$OTAApplyMetadata");
    }

    private final int verifyMetaDataFile(HashMap<String, String> hashMap) {
        String str = SystemProperties.get("ro.product.device", "");
        String str2 = SystemProperties.get("ro.build.version.incremental", "");
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.i$default(logUtil, TAG2, "verifyMetaDataFile productProp=" + str + " ,dateUtcProp= " + str2, null, 4, null);
        if (Intrinsics.areEqual(hashMap.getOrDefault("pre-device", " "), str)) {
            if (hashMap.containsKey("pre-build-incremental")) {
                String str3 = hashMap.get("pre-build-incremental");
                Intrinsics.checkNotNull(str3);
                if (str2.compareTo(str3) != 0) {
                    return -2;
                }
            }
            return isHardwareAndVersionVerifyFail(hashMap) ? -3 : 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isHardwareAndVersionVerifyFail(java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "TAG"
            java.lang.String r1 = "post-build"
            java.lang.String r2 = "isHardwareAndVersionVerify hardwareProp="
            java.lang.String r3 = "ro.boot.hardware.sku"
            java.lang.String r4 = ""
            java.lang.String r3 = android.os.SystemProperties.get(r3, r4)
            java.lang.String r4 = "EEA"
            java.lang.String r5 = "IND"
            java.lang.String r6 = "ROW"
            java.lang.String[] r4 = new java.lang.String[]{r6, r4, r5}
            r5 = 1
            r6 = 0
            boolean r7 = r14.containsKey(r1)     // Catch: java.lang.NumberFormatException -> L87
            if (r7 == 0) goto L87
            java.lang.Object r14 = r14.get(r1)     // Catch: java.lang.NumberFormatException -> L87
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch: java.lang.NumberFormatException -> L87
            kotlin.text.Regex r1 = new kotlin.text.Regex     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r7 = "/"
            r1.<init>(r7)     // Catch: java.lang.NumberFormatException -> L87
            java.util.List r14 = r1.split(r14, r6)     // Catch: java.lang.NumberFormatException -> L87
            r1 = 2
            java.lang.Object r14 = r14.get(r1)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.NumberFormatException -> L87
            r1 = r14
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.NumberFormatException -> L87
            kotlin.text.Regex r7 = new kotlin.text.Regex     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r8 = ":"
            r7.<init>(r8)     // Catch: java.lang.NumberFormatException -> L87
            java.util.List r1 = r7.split(r1, r6)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.NumberFormatException -> L87
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L87
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r7 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r8 = com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.TAG     // Catch: java.lang.NumberFormatException -> L87
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L87
            r9.<init>(r2)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.StringBuilder r2 = r9.append(r3)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r9 = " ,post-build="
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.StringBuilder r14 = r2.append(r14)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r2 = " ,metaDataAndroidVersion="
            java.lang.StringBuilder r14 = r14.append(r2)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.StringBuilder r14 = r14.append(r1)     // Catch: java.lang.NumberFormatException -> L87
            java.lang.String r9 = r14.toString()     // Catch: java.lang.NumberFormatException -> L87
            r10 = 0
            r11 = 4
            r12 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.NumberFormatException -> L87
            r14 = 13
            if (r1 < r14) goto L87
            r14 = r5
            goto L88
        L87:
            r14 = r6
        L88:
            r1 = r6
        L89:
            r2 = 3
            if (r1 >= r2) goto L99
            r2 = r4[r1]
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r2 == 0) goto L96
            r1 = r5
            goto L9a
        L96:
            int r1 = r1 + 1
            goto L89
        L99:
            r1 = r6
        L9a:
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r7 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE
            java.lang.String r8 = com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "isHardwareAndVersionVerify state="
            r0.<init>(r2)
            if (r1 != 0) goto Lae
            if (r14 == 0) goto Lae
            r2 = r5
            goto Laf
        Lae:
            r2 = r6
        Laf:
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r9 = r0.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r7, r8, r9, r10, r11, r12)
            if (r1 != 0) goto Lc2
            if (r14 == 0) goto Lc2
            goto Lc3
        Lc2:
            r5 = r6
        Lc3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.isHardwareAndVersionVerifyFail(java.util.Map):boolean");
    }

    public final boolean applyOTAFile(String otaFileId, OTAApplyMetadata otaApplyMetadata) {
        Intrinsics.checkNotNullParameter(otaFileId, "otaFileId");
        Intrinsics.checkNotNullParameter(otaApplyMetadata, "otaApplyMetadata");
        boolean z = false;
        try {
            String str = TAG;
            Log.i(str, "applyOTAFile applyPayload path=" + otaFileId);
            if ((otaFileId.length() > 0) && otaApplyMetadata.getVerifyState() == 0) {
                this.otaPrefs.setOtaFilePath(otaFileId);
                this.otaPrefs.setUpdatingBuildNumber(otaApplyMetadata.getBuildNumber());
                acquireWakeLock();
                this.updateManager.applyUpdate(new UpdateManager.UpdateData.Builder().setExtraProperties(CollectionsKt.emptyList()).setPayload(PayloadSpec.newBuilder().url("file:///data/media/0/" + otaFileId).offset(otaApplyMetadata.getPayloadOffset()).size(otaApplyMetadata.getPayloadSize()).properties(otaApplyMetadata.getProperties()).build()).build());
                z = true;
            } else {
                Log.e(str, "Failed to verify metadata config error code=" + otaApplyMetadata.getVerifyState());
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to apply update " + e, e);
        }
        return z;
    }

    public final void acquireWakeLock() {
        String str = TAG;
        Log.d(str, "acquireWakeLock");
        if (this.wakeLock == null) {
            Object systemService = this.appContext.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            this.wakeLock = ((PowerManager) systemService).newWakeLock(1, "NothingOfflineOtaUpdate:wakelock");
        }
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            Log.d(str, "acquireWakeLock wakeLock isHeld=" + wakeLock.isHeld() + " ,state=" + this.updateManager.getUpdaterState());
            if (wakeLock.isHeld()) {
                return;
            }
            wakeLock.acquire();
        }
    }

    public final void releaseWakeLock() {
        Log.d(TAG, "releaseWakeLock");
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            wakeLock.release();
            Log.d(MainActivity.TAG, "releaseWakeLock wakeLock isHeld=" + wakeLock.isHeld());
        }
        this.wakeLock = null;
    }

    public final boolean deleteOtaFile() {
        boolean z;
        File file = new File(Environment.getExternalStorageDirectory(), this.otaPrefs.getOtaFilePath());
        if (file.exists() && file.isFile()) {
            file.delete();
            z = true;
        } else {
            z = false;
        }
        Log.d(TAG, "deleteOtaFile delete file:" + file.getAbsolutePath() + " ,status = " + z);
        return z;
    }
}
