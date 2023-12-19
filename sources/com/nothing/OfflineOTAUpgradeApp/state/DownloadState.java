package com.nothing.OfflineOTAUpgradeApp.state;

import androidx.core.app.NotificationCompat;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "", "DownloadComplete", "DownloadFail", "DownloadPause", "Downloading", "FetchError", "Fetched", "Fetching", "Idle", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadComplete;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadFail;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadPause;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Downloading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$FetchError;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Fetched;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Fetching;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Idle;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DownloadState {

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Idle;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Idle implements DownloadState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1295903672;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Fetching;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Fetching implements DownloadState {
        public static final int $stable = 0;
        public static final Fetching INSTANCE = new Fetching();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fetching) {
                Fetching fetching = (Fetching) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1802467532;
        }

        public String toString() {
            return "Fetching";
        }

        private Fetching() {
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Fetched;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "info", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;)V", "getInfo", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Fetched implements DownloadState {
        public static final int $stable = 0;
        private final RemoteOTAUpdateInfo info;

        public Fetched(RemoteOTAUpdateInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        public final RemoteOTAUpdateInfo getInfo() {
            return this.info;
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$FetchError;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class FetchError implements DownloadState {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ FetchError copy$default(FetchError fetchError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fetchError.message;
            }
            return fetchError.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final FetchError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FetchError(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FetchError) && Intrinsics.areEqual(this.message, ((FetchError) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FetchError(message=" + this.message + ')';
        }

        public FetchError(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$Downloading;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "info", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", NotificationCompat.CATEGORY_PROGRESS, "", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;D)V", "getInfo", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "getProgress", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Downloading implements DownloadState {
        public static final int $stable = 0;
        private final RemoteOTAUpdateInfo info;
        private final double progress;

        public static /* synthetic */ Downloading copy$default(Downloading downloading, RemoteOTAUpdateInfo remoteOTAUpdateInfo, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteOTAUpdateInfo = downloading.info;
            }
            if ((i & 2) != 0) {
                d = downloading.progress;
            }
            return downloading.copy(remoteOTAUpdateInfo, d);
        }

        public final RemoteOTAUpdateInfo component1() {
            return this.info;
        }

        public final double component2() {
            return this.progress;
        }

        public final Downloading copy(RemoteOTAUpdateInfo info, double d) {
            Intrinsics.checkNotNullParameter(info, "info");
            return new Downloading(info, d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Downloading) {
                Downloading downloading = (Downloading) obj;
                return Intrinsics.areEqual(this.info, downloading.info) && Double.compare(this.progress, downloading.progress) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (this.info.hashCode() * 31) + Double.hashCode(this.progress);
        }

        public String toString() {
            return "Downloading(info=" + this.info + ", progress=" + this.progress + ')';
        }

        public Downloading(RemoteOTAUpdateInfo info, double d) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
            this.progress = d;
        }

        public final RemoteOTAUpdateInfo getInfo() {
            return this.info;
        }

        public final double getProgress() {
            return this.progress;
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadPause;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "info", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", NotificationCompat.CATEGORY_PROGRESS, "", "shouldCheckUnmeteredNetwork", "", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;DZ)V", "getInfo", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "getProgress", "()D", "getShouldCheckUnmeteredNetwork", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DownloadPause implements DownloadState {
        public static final int $stable = 0;
        private final RemoteOTAUpdateInfo info;
        private final double progress;
        private final boolean shouldCheckUnmeteredNetwork;

        public static /* synthetic */ DownloadPause copy$default(DownloadPause downloadPause, RemoteOTAUpdateInfo remoteOTAUpdateInfo, double d, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteOTAUpdateInfo = downloadPause.info;
            }
            if ((i & 2) != 0) {
                d = downloadPause.progress;
            }
            if ((i & 4) != 0) {
                z = downloadPause.shouldCheckUnmeteredNetwork;
            }
            return downloadPause.copy(remoteOTAUpdateInfo, d, z);
        }

        public final RemoteOTAUpdateInfo component1() {
            return this.info;
        }

        public final double component2() {
            return this.progress;
        }

        public final boolean component3() {
            return this.shouldCheckUnmeteredNetwork;
        }

        public final DownloadPause copy(RemoteOTAUpdateInfo info, double d, boolean z) {
            Intrinsics.checkNotNullParameter(info, "info");
            return new DownloadPause(info, d, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadPause) {
                DownloadPause downloadPause = (DownloadPause) obj;
                return Intrinsics.areEqual(this.info, downloadPause.info) && Double.compare(this.progress, downloadPause.progress) == 0 && this.shouldCheckUnmeteredNetwork == downloadPause.shouldCheckUnmeteredNetwork;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.info.hashCode() * 31) + Double.hashCode(this.progress)) * 31;
            boolean z = this.shouldCheckUnmeteredNetwork;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "DownloadPause(info=" + this.info + ", progress=" + this.progress + ", shouldCheckUnmeteredNetwork=" + this.shouldCheckUnmeteredNetwork + ')';
        }

        public DownloadPause(RemoteOTAUpdateInfo info, double d, boolean z) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
            this.progress = d;
            this.shouldCheckUnmeteredNetwork = z;
        }

        public /* synthetic */ DownloadPause(RemoteOTAUpdateInfo remoteOTAUpdateInfo, double d, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(remoteOTAUpdateInfo, d, (i & 4) != 0 ? false : z);
        }

        public final RemoteOTAUpdateInfo getInfo() {
            return this.info;
        }

        public final double getProgress() {
            return this.progress;
        }

        public final boolean getShouldCheckUnmeteredNetwork() {
            return this.shouldCheckUnmeteredNetwork;
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadComplete;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "buildNumber", "", "otaFileId", "(Ljava/lang/String;Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "getOtaFileId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DownloadComplete implements DownloadState {
        public static final int $stable = 0;
        private final String buildNumber;
        private final String otaFileId;

        public static /* synthetic */ DownloadComplete copy$default(DownloadComplete downloadComplete, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadComplete.buildNumber;
            }
            if ((i & 2) != 0) {
                str2 = downloadComplete.otaFileId;
            }
            return downloadComplete.copy(str, str2);
        }

        public final String component1() {
            return this.buildNumber;
        }

        public final String component2() {
            return this.otaFileId;
        }

        public final DownloadComplete copy(String buildNumber, String otaFileId) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            Intrinsics.checkNotNullParameter(otaFileId, "otaFileId");
            return new DownloadComplete(buildNumber, otaFileId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadComplete) {
                DownloadComplete downloadComplete = (DownloadComplete) obj;
                return Intrinsics.areEqual(this.buildNumber, downloadComplete.buildNumber) && Intrinsics.areEqual(this.otaFileId, downloadComplete.otaFileId);
            }
            return false;
        }

        public int hashCode() {
            return (this.buildNumber.hashCode() * 31) + this.otaFileId.hashCode();
        }

        public String toString() {
            return "DownloadComplete(buildNumber=" + this.buildNumber + ", otaFileId=" + this.otaFileId + ')';
        }

        public DownloadComplete(String buildNumber, String otaFileId) {
            Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
            Intrinsics.checkNotNullParameter(otaFileId, "otaFileId");
            this.buildNumber = buildNumber;
            this.otaFileId = otaFileId;
        }

        public final String getBuildNumber() {
            return this.buildNumber;
        }

        public final String getOtaFileId() {
            return this.otaFileId;
        }
    }

    /* compiled from: DownloadState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState$DownloadFail;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DownloadFail implements DownloadState {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ DownloadFail copy$default(DownloadFail downloadFail, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadFail.message;
            }
            return downloadFail.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final DownloadFail copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new DownloadFail(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DownloadFail) && Intrinsics.areEqual(this.message, ((DownloadFail) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "DownloadFail(message=" + this.message + ')';
        }

        public DownloadFail(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
