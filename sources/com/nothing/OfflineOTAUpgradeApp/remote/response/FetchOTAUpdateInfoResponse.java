package com.nothing.OfflineOTAUpgradeApp.remote.response;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchOTAUpdateInfoResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0012J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoResponse;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "data", "Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoData;", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isSuccess", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FetchOTAUpdateInfoResponse {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String SUCCESS_CODE = "00000";
    @SerializedName("code")
    private final String code;
    @SerializedName("data")
    private final FetchOTAUpdateInfoData data;
    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private final String msg;

    public static /* synthetic */ FetchOTAUpdateInfoResponse copy$default(FetchOTAUpdateInfoResponse fetchOTAUpdateInfoResponse, String str, String str2, FetchOTAUpdateInfoData fetchOTAUpdateInfoData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fetchOTAUpdateInfoResponse.code;
        }
        if ((i & 2) != 0) {
            str2 = fetchOTAUpdateInfoResponse.msg;
        }
        if ((i & 4) != 0) {
            fetchOTAUpdateInfoData = fetchOTAUpdateInfoResponse.data;
        }
        return fetchOTAUpdateInfoResponse.copy(str, str2, fetchOTAUpdateInfoData);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final FetchOTAUpdateInfoData component3() {
        return this.data;
    }

    public final FetchOTAUpdateInfoResponse copy(String code, String msg, FetchOTAUpdateInfoData fetchOTAUpdateInfoData) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new FetchOTAUpdateInfoResponse(code, msg, fetchOTAUpdateInfoData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchOTAUpdateInfoResponse) {
            FetchOTAUpdateInfoResponse fetchOTAUpdateInfoResponse = (FetchOTAUpdateInfoResponse) obj;
            return Intrinsics.areEqual(this.code, fetchOTAUpdateInfoResponse.code) && Intrinsics.areEqual(this.msg, fetchOTAUpdateInfoResponse.msg) && Intrinsics.areEqual(this.data, fetchOTAUpdateInfoResponse.data);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.code.hashCode() * 31) + this.msg.hashCode()) * 31;
        FetchOTAUpdateInfoData fetchOTAUpdateInfoData = this.data;
        return hashCode + (fetchOTAUpdateInfoData == null ? 0 : fetchOTAUpdateInfoData.hashCode());
    }

    public String toString() {
        return "FetchOTAUpdateInfoResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    public FetchOTAUpdateInfoResponse(String code, String msg, FetchOTAUpdateInfoData fetchOTAUpdateInfoData) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.code = code;
        this.msg = msg;
        this.data = fetchOTAUpdateInfoData;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final FetchOTAUpdateInfoData getData() {
        return this.data;
    }

    /* compiled from: FetchOTAUpdateInfoResponse.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/response/FetchOTAUpdateInfoResponse$Companion;", "", "()V", "SUCCESS_CODE", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual(this.code, SUCCESS_CODE);
    }
}
