package com.nothing.OfflineOTAUpgradeApp.remote.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchOTAUpdateInfoResponse.kt */
@Metadata(m41d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData;", "", "fileSize", "", "downloadUrl", "", "buildNumber", "otaType", "", "compareResult", "(JLjava/lang/String;Ljava/lang/String;II)V", "getBuildNumber", "()Ljava/lang/String;", "getCompareResult", "()I", "getDownloadUrl", "getFileSize", "()J", "getOtaType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class FetchOTAUpdateInfoData {
    public static final int $stable = 0;
    public static final int COMPARE_RESULT_DIFF_AVAILABLE = 3;
    public static final int COMPARE_RESULT_DIFF_TOO_OLD = 2;
    public static final int COMPARE_RESULT_DIFF_UNAVAILABLE = 4;
    public static final int COMPARE_RESULT_FULL_AVAILABLE = 0;
    public static final int COMPARE_RESULT_FULL_UNAVAILABLE = 1;
    public static final int COMPARE_RESULT_UNKNOWN = -1;
    public static final Companion Companion = new Companion(null);
    @SerializedName("build_number")
    private final String buildNumber;
    @SerializedName("compare_result")
    private final int compareResult;
    @SerializedName("download_url")
    private final String downloadUrl;
    @SerializedName("file_size")
    private final long fileSize;
    @SerializedName("ota_type")
    private final int otaType;

    public static /* synthetic */ FetchOTAUpdateInfoData copy$default(FetchOTAUpdateInfoData fetchOTAUpdateInfoData, long j, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = fetchOTAUpdateInfoData.fileSize;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            str = fetchOTAUpdateInfoData.downloadUrl;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = fetchOTAUpdateInfoData.buildNumber;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i = fetchOTAUpdateInfoData.otaType;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = fetchOTAUpdateInfoData.compareResult;
        }
        return fetchOTAUpdateInfoData.copy(j2, str3, str4, i4, i2);
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

    public final int component4() {
        return this.otaType;
    }

    public final int component5() {
        return this.compareResult;
    }

    public final FetchOTAUpdateInfoData copy(long j, String downloadUrl, String buildNumber, int i, int i2) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        return new FetchOTAUpdateInfoData(j, downloadUrl, buildNumber, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchOTAUpdateInfoData) {
            FetchOTAUpdateInfoData fetchOTAUpdateInfoData = (FetchOTAUpdateInfoData) obj;
            return this.fileSize == fetchOTAUpdateInfoData.fileSize && Intrinsics.areEqual(this.downloadUrl, fetchOTAUpdateInfoData.downloadUrl) && Intrinsics.areEqual(this.buildNumber, fetchOTAUpdateInfoData.buildNumber) && this.otaType == fetchOTAUpdateInfoData.otaType && this.compareResult == fetchOTAUpdateInfoData.compareResult;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.fileSize) * 31) + this.downloadUrl.hashCode()) * 31) + this.buildNumber.hashCode()) * 31) + Integer.hashCode(this.otaType)) * 31) + Integer.hashCode(this.compareResult);
    }

    public String toString() {
        return "FetchOTAUpdateInfoData(fileSize=" + this.fileSize + ", downloadUrl=" + this.downloadUrl + ", buildNumber=" + this.buildNumber + ", otaType=" + this.otaType + ", compareResult=" + this.compareResult + ')';
    }

    public FetchOTAUpdateInfoData(long j, String downloadUrl, String buildNumber, int i, int i2) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        this.fileSize = j;
        this.downloadUrl = downloadUrl;
        this.buildNumber = buildNumber;
        this.otaType = i;
        this.compareResult = i2;
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

    public final int getOtaType() {
        return this.otaType;
    }

    public final int getCompareResult() {
        return this.compareResult;
    }

    /* compiled from: FetchOTAUpdateInfoResponse.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData$Companion;", "", "()V", "COMPARE_RESULT_DIFF_AVAILABLE", "", "COMPARE_RESULT_DIFF_TOO_OLD", "COMPARE_RESULT_DIFF_UNAVAILABLE", "COMPARE_RESULT_FULL_AVAILABLE", "COMPARE_RESULT_FULL_UNAVAILABLE", "COMPARE_RESULT_UNKNOWN", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
