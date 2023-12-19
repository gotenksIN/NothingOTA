package com.nothing.OfflineOTAUpgradeApp.remote.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchOTAUpdateInfoResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData;", "", "fileSize", "", "downloadUrl", "", "buildNumber", "(JLjava/lang/String;Ljava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "getDownloadUrl", "getFileSize", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FetchOTAUpdateInfoData {
    public static final int $stable = 0;
    @SerializedName("build_number")
    private final String buildNumber;
    @SerializedName("download_url")
    private final String downloadUrl;
    @SerializedName("file_size")
    private final long fileSize;

    public static /* synthetic */ FetchOTAUpdateInfoData copy$default(FetchOTAUpdateInfoData fetchOTAUpdateInfoData, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fetchOTAUpdateInfoData.fileSize;
        }
        if ((i & 2) != 0) {
            str = fetchOTAUpdateInfoData.downloadUrl;
        }
        if ((i & 4) != 0) {
            str2 = fetchOTAUpdateInfoData.buildNumber;
        }
        return fetchOTAUpdateInfoData.copy(j, str, str2);
    }

    public final long component1() {
        return this.fileSize;
    }

    public final String component2() {
        return this.downloadUrl;
    }

    public final String component3() {
        return this.buildNumber;
    }

    public final FetchOTAUpdateInfoData copy(long j, String downloadUrl, String buildNumber) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        return new FetchOTAUpdateInfoData(j, downloadUrl, buildNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchOTAUpdateInfoData) {
            FetchOTAUpdateInfoData fetchOTAUpdateInfoData = (FetchOTAUpdateInfoData) obj;
            return this.fileSize == fetchOTAUpdateInfoData.fileSize && Intrinsics.areEqual(this.downloadUrl, fetchOTAUpdateInfoData.downloadUrl) && Intrinsics.areEqual(this.buildNumber, fetchOTAUpdateInfoData.buildNumber);
        }
        return false;
    }

    public int hashCode() {
        return (((Long.hashCode(this.fileSize) * 31) + this.downloadUrl.hashCode()) * 31) + this.buildNumber.hashCode();
    }

    public String toString() {
        return "FetchOTAUpdateInfoData(fileSize=" + this.fileSize + ", downloadUrl=" + this.downloadUrl + ", buildNumber=" + this.buildNumber + ')';
    }

    public FetchOTAUpdateInfoData(long j, String downloadUrl, String buildNumber) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        this.fileSize = j;
        this.downloadUrl = downloadUrl;
        this.buildNumber = buildNumber;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getBuildNumber() {
        return this.buildNumber;
    }
}
