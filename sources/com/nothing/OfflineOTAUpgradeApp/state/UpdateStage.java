package com.nothing.OfflineOTAUpgradeApp.state;

import androidx.core.app.NotificationCompat;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import com.nothing.OfflineOTAUpgradeApp.state.UpdatingButtonStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateStage.kt */
@Metadata(m41d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\r\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB/\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u0082\u0001\t\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "", "firstBtnStyle", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "firstBtnTextRes", "", "secondBtnStyle", "secondBtnTextRes", "(Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;ILcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;I)V", "getFirstBtnStyle", "()Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "getFirstBtnTextRes", "()I", "getSecondBtnStyle", "getSecondBtnTextRes", "StageCurrentVersion", "StageDownloadPaused", "StageDownloading", "StageInstallComplete", "StageInstalling", "StageInstallingPaused", "StageInstallingRunning", "StageLoading", "StageLookingVersion", "StageReadyInstallDownloaded", "StageReadyInstallOTA", "StageReadyToDownload", "StageUpToDate", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageCurrentVersion;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageDownloadPaused;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageDownloading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstalling;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageLoading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyInstallDownloaded;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyInstallOTA;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyToDownload;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageUpToDate;", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public abstract class UpdateStage {
    public static final int $stable = UpdatingButtonStyle.$stable | UpdatingButtonStyle.$stable;
    private final UpdatingButtonStyle firstBtnStyle;
    private final int firstBtnTextRes;
    private final UpdatingButtonStyle secondBtnStyle;
    private final int secondBtnTextRes;

    public /* synthetic */ UpdateStage(UpdatingButtonStyle updatingButtonStyle, int i, UpdatingButtonStyle updatingButtonStyle2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(updatingButtonStyle, i, updatingButtonStyle2, i2);
    }

    private UpdateStage(UpdatingButtonStyle updatingButtonStyle, int i, UpdatingButtonStyle updatingButtonStyle2, int i2) {
        this.firstBtnStyle = updatingButtonStyle;
        this.firstBtnTextRes = i;
        this.secondBtnStyle = updatingButtonStyle2;
        this.secondBtnTextRes = i2;
    }

    public /* synthetic */ UpdateStage(UpdatingButtonStyle.Hidden hidden, int i, UpdatingButtonStyle.Hidden hidden2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UpdatingButtonStyle.Hidden.INSTANCE : hidden, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? UpdatingButtonStyle.Hidden.INSTANCE : hidden2, (i3 & 8) != 0 ? 0 : i2, null);
    }

    public final UpdatingButtonStyle getFirstBtnStyle() {
        return this.firstBtnStyle;
    }

    public final int getFirstBtnTextRes() {
        return this.firstBtnTextRes;
    }

    public final UpdatingButtonStyle getSecondBtnStyle() {
        return this.secondBtnStyle;
    }

    public final int getSecondBtnTextRes() {
        return this.secondBtnTextRes;
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageCurrentVersion;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", "(Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageCurrentVersion extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;

        public static /* synthetic */ StageCurrentVersion copy$default(StageCurrentVersion stageCurrentVersion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageCurrentVersion.buildNumber;
            }
            return stageCurrentVersion.copy(str);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final StageCurrentVersion copy(String buildNumber) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new StageCurrentVersion(buildNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StageCurrentVersion) && Intrinsics.areEqual(this.buildNumber, ((StageCurrentVersion) obj).buildNumber);
        }

        public int hashCode() {
            return this.buildNumber.hashCode();
        }

        public String toString() {
            return "StageCurrentVersion(buildNumber=" + this.buildNumber + ')';
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageCurrentVersion(String buildNumber) {
            super(UpdatingButtonStyle.Filled.INSTANCE, C1640R.string.ota_update_button_check_new_version, UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_import_file, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.buildNumber = buildNumber;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageLoading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "()V", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static class StageLoading extends UpdateStage {
        public static final int $stable = 0;

        public StageLoading() {
            super(null, 0, null, 0, 15, null);
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageLookingVersion;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageLoading;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageLookingVersion extends StageLoading {
        public static final int $stable = 0;
        public static final StageLookingVersion INSTANCE = new StageLookingVersion();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StageLookingVersion) {
                StageLookingVersion stageLookingVersion = (StageLookingVersion) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1545895355;
        }

        public String toString() {
            return "StageLookingVersion";
        }

        private StageLookingVersion() {
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyToDownload;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", "size", "(Ljava/lang/String;Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "getSize", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageReadyToDownload extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;
        private final String size;

        public static /* synthetic */ StageReadyToDownload copy$default(StageReadyToDownload stageReadyToDownload, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageReadyToDownload.buildNumber;
            }
            if ((i & 2) != 0) {
                str2 = stageReadyToDownload.size;
            }
            return stageReadyToDownload.copy(str, str2);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final String component2() {
            return this.size;
        }

        public final StageReadyToDownload copy(String buildNumber, String size) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            Intrinsics.checkNotNullParameter(size, "size");
            return new StageReadyToDownload(buildNumber, size);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StageReadyToDownload) {
                StageReadyToDownload stageReadyToDownload = (StageReadyToDownload) obj;
                return Intrinsics.areEqual(this.buildNumber, stageReadyToDownload.buildNumber) && Intrinsics.areEqual(this.size, stageReadyToDownload.size);
            }
            return false;
        }

        public int hashCode() {
            return (this.buildNumber.hashCode() * 31) + this.size.hashCode();
        }

        public String toString() {
            return "StageReadyToDownload(buildNumber=" + this.buildNumber + ", size=" + this.size + ')';
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        public final String getSize() {
            return this.size;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageReadyToDownload(String buildNumber, String size) {
            super(UpdatingButtonStyle.Filled.INSTANCE, C1640R.string.ota_update_button_download_ota, UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_import_file, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            Intrinsics.checkNotNullParameter(size, "size");
            this.buildNumber = buildNumber;
            this.size = size;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageDownloading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Ljava/lang/String;D)V", "getBuildNumber", "()Ljava/lang/String;", "getProgress", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageDownloading extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;
        private final double progress;

        public static /* synthetic */ StageDownloading copy$default(StageDownloading stageDownloading, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageDownloading.buildNumber;
            }
            if ((i & 2) != 0) {
                d = stageDownloading.progress;
            }
            return stageDownloading.copy(str, d);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final double component2() {
            return this.progress;
        }

        public final StageDownloading copy(String buildNumber, double d) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new StageDownloading(buildNumber, d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StageDownloading) {
                StageDownloading stageDownloading = (StageDownloading) obj;
                return Intrinsics.areEqual(this.buildNumber, stageDownloading.buildNumber) && Double.compare(this.progress, stageDownloading.progress) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (this.buildNumber.hashCode() * 31) + Double.hashCode(this.progress);
        }

        public String toString() {
            return "StageDownloading(buildNumber=" + this.buildNumber + ", progress=" + this.progress + ')';
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        public final double getProgress() {
            return this.progress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageDownloading(String buildNumber, double d) {
            super(UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_pause_download, UpdatingButtonStyle.Transparent.INSTANCE, C1640R.string.ota_update_button_cancel, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.buildNumber = buildNumber;
            this.progress = d;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageDownloadPaused;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Ljava/lang/String;D)V", "getBuildNumber", "()Ljava/lang/String;", "getProgress", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageDownloadPaused extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;
        private final double progress;

        public static /* synthetic */ StageDownloadPaused copy$default(StageDownloadPaused stageDownloadPaused, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageDownloadPaused.buildNumber;
            }
            if ((i & 2) != 0) {
                d = stageDownloadPaused.progress;
            }
            return stageDownloadPaused.copy(str, d);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final double component2() {
            return this.progress;
        }

        public final StageDownloadPaused copy(String buildNumber, double d) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new StageDownloadPaused(buildNumber, d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StageDownloadPaused) {
                StageDownloadPaused stageDownloadPaused = (StageDownloadPaused) obj;
                return Intrinsics.areEqual(this.buildNumber, stageDownloadPaused.buildNumber) && Double.compare(this.progress, stageDownloadPaused.progress) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (this.buildNumber.hashCode() * 31) + Double.hashCode(this.progress);
        }

        public String toString() {
            return "StageDownloadPaused(buildNumber=" + this.buildNumber + ", progress=" + this.progress + ')';
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        public final double getProgress() {
            return this.progress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageDownloadPaused(String buildNumber, double d) {
            super(UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_resume_download, UpdatingButtonStyle.Transparent.INSTANCE, C1640R.string.ota_update_button_cancel, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.buildNumber = buildNumber;
            this.progress = d;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyInstallDownloaded;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", "(Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageReadyInstallDownloaded extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;

        public static /* synthetic */ StageReadyInstallDownloaded copy$default(StageReadyInstallDownloaded stageReadyInstallDownloaded, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageReadyInstallDownloaded.buildNumber;
            }
            return stageReadyInstallDownloaded.copy(str);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final StageReadyInstallDownloaded copy(String buildNumber) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new StageReadyInstallDownloaded(buildNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StageReadyInstallDownloaded) && Intrinsics.areEqual(this.buildNumber, ((StageReadyInstallDownloaded) obj).buildNumber);
        }

        public int hashCode() {
            return this.buildNumber.hashCode();
        }

        public String toString() {
            return "StageReadyInstallDownloaded(buildNumber=" + this.buildNumber + ')';
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageReadyInstallDownloaded(String buildNumber) {
            super(UpdatingButtonStyle.Filled.INSTANCE, C1640R.string.ota_update_button_install, UpdatingButtonStyle.Transparent.INSTANCE, C1640R.string.ota_update_button_cancel, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.buildNumber = buildNumber;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0003\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstalling;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", "firstBtnStyle", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "firstBtnTextRes", "", "secondBtnStyle", "secondBtnTextRes", "(Ljava/lang/String;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;ILcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;I)V", "getBuildNumber", "()Ljava/lang/String;", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class StageInstalling extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        public /* synthetic */ StageInstalling(String str, UpdatingButtonStyle.Hidden hidden, int i, UpdatingButtonStyle.Hidden hidden2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? UpdatingButtonStyle.Hidden.INSTANCE : hidden, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? UpdatingButtonStyle.Hidden.INSTANCE : hidden2, (i3 & 16) != 0 ? 0 : i2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageInstalling(String buildNumber, UpdatingButtonStyle firstBtnStyle, int i, UpdatingButtonStyle secondBtnStyle, int i2) {
            super(firstBtnStyle, i, secondBtnStyle, i2, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            Intrinsics.checkNotNullParameter(firstBtnStyle, "firstBtnStyle");
            Intrinsics.checkNotNullParameter(secondBtnStyle, "secondBtnStyle");
            this.buildNumber = buildNumber;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingRunning;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstalling;", "buildNumber", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Ljava/lang/String;D)V", "getProgress", "()D", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageInstallingRunning extends StageInstalling {
        public static final int $stable = 0;
        private final double progress;

        public final double getProgress() {
            return this.progress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageInstallingRunning(String buildNumber, double d) {
            super(buildNumber, UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_pause_install, UpdatingButtonStyle.Transparent.INSTANCE, C1640R.string.ota_update_button_cancel);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.progress = d;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingPaused;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstalling;", "buildNumber", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Ljava/lang/String;D)V", "getProgress", "()D", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageInstallingPaused extends StageInstalling {
        public static final int $stable = 0;
        private final double progress;

        public final double getProgress() {
            return this.progress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageInstallingPaused(String buildNumber, double d) {
            super(buildNumber, UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_resume_install, UpdatingButtonStyle.Transparent.INSTANCE, C1640R.string.ota_update_button_cancel);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.progress = d;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallComplete;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstalling;", "buildNumber", "", "(Ljava/lang/String;)V", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageInstallComplete extends StageInstalling {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageInstallComplete(String buildNumber) {
            super(buildNumber, null, 0, null, 0, 30, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageReadyInstallOTA;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "currentNumber", "", "otaNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentNumber", "()Ljava/lang/String;", "getOtaNumber", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageReadyInstallOTA extends UpdateStage {
        public static final int $stable = 0;
        private final String currentNumber;
        private final String otaNumber;

        public static /* synthetic */ StageReadyInstallOTA copy$default(StageReadyInstallOTA stageReadyInstallOTA, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageReadyInstallOTA.currentNumber;
            }
            if ((i & 2) != 0) {
                str2 = stageReadyInstallOTA.otaNumber;
            }
            return stageReadyInstallOTA.copy(str, str2);
        }

        public final String component1() {
            return this.currentNumber;
        }

        public final String component2() {
            return this.otaNumber;
        }

        public final StageReadyInstallOTA copy(String currentNumber, String otaNumber) {
            Intrinsics.checkNotNullParameter(currentNumber, "currentNumber");
            Intrinsics.checkNotNullParameter(otaNumber, "otaNumber");
            return new StageReadyInstallOTA(currentNumber, otaNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StageReadyInstallOTA) {
                StageReadyInstallOTA stageReadyInstallOTA = (StageReadyInstallOTA) obj;
                return Intrinsics.areEqual(this.currentNumber, stageReadyInstallOTA.currentNumber) && Intrinsics.areEqual(this.otaNumber, stageReadyInstallOTA.otaNumber);
            }
            return false;
        }

        public int hashCode() {
            return (this.currentNumber.hashCode() * 31) + this.otaNumber.hashCode();
        }

        public String toString() {
            return "StageReadyInstallOTA(currentNumber=" + this.currentNumber + ", otaNumber=" + this.otaNumber + ')';
        }

        public final String getCurrentNumber() {
            return this.currentNumber;
        }

        public final String getOtaNumber() {
            return this.otaNumber;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageReadyInstallOTA(String currentNumber, String otaNumber) {
            super(UpdatingButtonStyle.Filled.INSTANCE, C1640R.string.ota_update_button_check_new_version, UpdatingButtonStyle.Border.INSTANCE, C1640R.string.ota_update_button_import_file, null);
            Intrinsics.checkNotNullParameter(currentNumber, "currentNumber");
            Intrinsics.checkNotNullParameter(otaNumber, "otaNumber");
            this.currentNumber = currentNumber;
            this.otaNumber = otaNumber;
        }
    }

    /* compiled from: UpdateStage.kt */
    @Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageUpToDate;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "buildNumber", "", "(Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class StageUpToDate extends UpdateStage {
        public static final int $stable = 0;
        private final String buildNumber;

        public static /* synthetic */ StageUpToDate copy$default(StageUpToDate stageUpToDate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stageUpToDate.buildNumber;
            }
            return stageUpToDate.copy(str);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final StageUpToDate copy(String buildNumber) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            return new StageUpToDate(buildNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StageUpToDate) && Intrinsics.areEqual(this.buildNumber, ((StageUpToDate) obj).buildNumber);
        }

        public int hashCode() {
            return this.buildNumber.hashCode();
        }

        public String toString() {
            return "StageUpToDate(buildNumber=" + this.buildNumber + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StageUpToDate(String buildNumber) {
            super(null, 0, null, 0, 15, null);
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            this.buildNumber = buildNumber;
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }
    }
}
