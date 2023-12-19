package com.nothing.OfflineOTAUpgradeApp.remote;

import com.nothing.OfflineOTAUpgradeApp.remote.response.FetchOTAUpdateInfoData;
import com.nothing.OfflineOTAUpgradeApp.remote.response.FetchOTAUpdateInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteOTAUpdateInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "", "isUpToDate", "", "buildNumber", "", "bytes", "", "url", "(ZLjava/lang/String;JLjava/lang/String;)V", "getBuildNumber", "()Ljava/lang/String;", "getBytes", "()J", "()Z", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteOTAUpdateInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final RemoteOTAUpdateInfo UP_TO_DATE_INFO = new RemoteOTAUpdateInfo(true, "", 0, "");
    private final String buildNumber;
    private final long bytes;
    private final boolean isUpToDate;
    private final String url;

    public static /* synthetic */ RemoteOTAUpdateInfo copy$default(RemoteOTAUpdateInfo remoteOTAUpdateInfo, boolean z, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = remoteOTAUpdateInfo.isUpToDate;
        }
        if ((i & 2) != 0) {
            str = remoteOTAUpdateInfo.buildNumber;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            j = remoteOTAUpdateInfo.bytes;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str2 = remoteOTAUpdateInfo.url;
        }
        return remoteOTAUpdateInfo.copy(z, str3, j2, str2);
    }

    public final boolean component1() {
        return this.isUpToDate;
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

    public final RemoteOTAUpdateInfo copy(boolean z, String buildNumber, long j, String url) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        Intrinsics.checkNotNullParameter(url, "url");
        return new RemoteOTAUpdateInfo(z, buildNumber, j, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteOTAUpdateInfo) {
            RemoteOTAUpdateInfo remoteOTAUpdateInfo = (RemoteOTAUpdateInfo) obj;
            return this.isUpToDate == remoteOTAUpdateInfo.isUpToDate && Intrinsics.areEqual(this.buildNumber, remoteOTAUpdateInfo.buildNumber) && this.bytes == remoteOTAUpdateInfo.bytes && Intrinsics.areEqual(this.url, remoteOTAUpdateInfo.url);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.isUpToDate;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.buildNumber.hashCode()) * 31) + Long.hashCode(this.bytes)) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "RemoteOTAUpdateInfo(isUpToDate=" + this.isUpToDate + ", buildNumber=" + this.buildNumber + ", bytes=" + this.bytes + ", url=" + this.url + ')';
    }

    public RemoteOTAUpdateInfo(boolean z, String buildNumber, long j, String url) {
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        Intrinsics.checkNotNullParameter(url, "url");
        this.isUpToDate = z;
        this.buildNumber = buildNumber;
        this.bytes = j;
        this.url = url;
    }

    public final boolean isUpToDate() {
        return this.isUpToDate;
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo$Companion;", "", "()V", "UP_TO_DATE_INFO", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "convertFromResponse", "response", "Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoResponse;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RemoteOTAUpdateInfo convertFromResponse(FetchOTAUpdateInfoResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            FetchOTAUpdateInfoData data = response.getData();
            if (data == null) {
                return RemoteOTAUpdateInfo.UP_TO_DATE_INFO;
            }
            String downloadUrl = data.getDownloadUrl();
            return new RemoteOTAUpdateInfo(downloadUrl == null || downloadUrl.length() == 0, data.getBuildNumber(), data.getFileSize(), data.getDownloadUrl());
        }
    }
}
