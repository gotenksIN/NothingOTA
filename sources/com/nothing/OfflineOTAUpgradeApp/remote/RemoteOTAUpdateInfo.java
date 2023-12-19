package com.nothing.OfflineOTAUpgradeApp.remote;

import com.nothing.OfflineOTAUpgradeApp.remote.response.FetchOTAUpdateInfoData;
import com.nothing.OfflineOTAUpgradeApp.remote.response.FetchOTAUpdateInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteOTAUpdateInfo.kt */
@Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "", "buildCompareResult", "", "buildNumber", "", "bytes", "", "url", "(ILjava/lang/String;JLjava/lang/String;)V", "getBuildCompareResult", "()I", "getBuildNumber", "()Ljava/lang/String;", "getBytes", "()J", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class RemoteOTAUpdateInfo {
    public static final int $stable = 0;
    public static final int BUILD_CAN_UPDATE = 1;
    public static final int BUILD_TOO_OLD = 0;
    public static final int BUILD_UNKNOWN = -1;
    public static final int BUILD_UP_TO_DATE = 2;
    public static final Companion Companion = new Companion(null);
    private static final RemoteOTAUpdateInfo UNKNOWN_INFO = new RemoteOTAUpdateInfo(-1, "", 0, "");
    private final int buildCompareResult;
    private final String buildNumber;
    private final long bytes;
    private final String url;

    public static /* synthetic */ RemoteOTAUpdateInfo copy$default(RemoteOTAUpdateInfo remoteOTAUpdateInfo, int i, String str, long j, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = remoteOTAUpdateInfo.buildCompareResult;
        }
        if ((i2 & 2) != 0) {
            str = remoteOTAUpdateInfo.buildNumber;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            j = remoteOTAUpdateInfo.bytes;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str2 = remoteOTAUpdateInfo.url;
        }
        return remoteOTAUpdateInfo.copy(i, str3, j2, str2);
    }

    public final int component1() {
        return this.buildCompareResult;
    }

    public final String component2() {
        return this.buildNumber;
    }

    public final long component3() {
        return this.bytes;
    }

    public final String component4() {
        return this.url;
    }

    public final RemoteOTAUpdateInfo copy(int i, String buildNumber, long j, String url) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        Intrinsics.checkNotNullParameter(url, "url");
        return new RemoteOTAUpdateInfo(i, buildNumber, j, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteOTAUpdateInfo) {
            RemoteOTAUpdateInfo remoteOTAUpdateInfo = (RemoteOTAUpdateInfo) obj;
            return this.buildCompareResult == remoteOTAUpdateInfo.buildCompareResult && Intrinsics.areEqual(this.buildNumber, remoteOTAUpdateInfo.buildNumber) && this.bytes == remoteOTAUpdateInfo.bytes && Intrinsics.areEqual(this.url, remoteOTAUpdateInfo.url);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.buildCompareResult) * 31) + this.buildNumber.hashCode()) * 31) + Long.hashCode(this.bytes)) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "RemoteOTAUpdateInfo(buildCompareResult=" + this.buildCompareResult + ", buildNumber=" + this.buildNumber + ", bytes=" + this.bytes + ", url=" + this.url + ')';
    }

    public RemoteOTAUpdateInfo(int i, String buildNumber, long j, String url) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        Intrinsics.checkNotNullParameter(url, "url");
        this.buildCompareResult = i;
        this.buildNumber = buildNumber;
        this.bytes = j;
        this.url = url;
    }

    public final int getBuildCompareResult() {
        return this.buildCompareResult;
    }

    public final String getBuildNumber() {
        return this.buildNumber;
    }

    public final long getBytes() {
        return this.bytes;
    }

    public final String getUrl() {
        return this.url;
    }

    /* compiled from: RemoteOTAUpdateInfo.kt */
    @Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo$Companion;", "", "()V", "BUILD_CAN_UPDATE", "", "BUILD_TOO_OLD", "BUILD_UNKNOWN", "BUILD_UP_TO_DATE", "UNKNOWN_INFO", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "convertFromResponse", "response", "Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoResponse;", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RemoteOTAUpdateInfo convertFromResponse(FetchOTAUpdateInfoResponse response) {
            int i;
            Intrinsics.checkNotNullParameter(response, "response");
            FetchOTAUpdateInfoData data = response.getData();
            if (data == null) {
                return RemoteOTAUpdateInfo.UNKNOWN_INFO;
            }
            int compareResult = data.getCompareResult();
            int i2 = 1;
            if (compareResult != 0) {
                if (compareResult != 1) {
                    if (compareResult == 2) {
                        i2 = 0;
                    } else if (compareResult != 3) {
                        if (compareResult != 4) {
                            i2 = -1;
                        }
                    }
                }
                i = 2;
                return new RemoteOTAUpdateInfo(i, data.getBuildNumber(), data.getFileSize(), data.getDownloadUrl());
            }
            i = i2;
            return new RemoteOTAUpdateInfo(i, data.getBuildNumber(), data.getFileSize(), data.getDownloadUrl());
        }
    }
}
