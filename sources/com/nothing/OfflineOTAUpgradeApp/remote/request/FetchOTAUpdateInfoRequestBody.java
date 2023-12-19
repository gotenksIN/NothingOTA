package com.nothing.OfflineOTAUpgradeApp.remote.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchOTAUpdateInfoRequestBody.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/request/FetchOTAUpdateInfoRequestBody;", "", "keyPairId", "", FetchOTAUpdateInfoRequestBody.KEY_VERSION, "", FetchOTAUpdateInfoRequestBody.KEY_DATA, FetchOTAUpdateInfoRequestBody.KEY_TIMESTAMP, "", FetchOTAUpdateInfoRequestBody.KEY_CIPHER, FetchOTAUpdateInfoRequestBody.KEY_SIGN, "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getCipher", "()Ljava/lang/String;", "getData", "getKeyPairId", "getSign", "getTimestamp", "()J", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FetchOTAUpdateInfoRequestBody {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String KEY_CIPHER = "cipher";
    private static final String KEY_DATA = "data";
    public static final String KEY_DATA_OLD_VERSION = "old_version";
    public static final String KEY_DATA_OLD_VERSION_DATE = "old_version_date";
    public static final String KEY_DATA_VERSION_KEY = "version_key";
    private static final String KEY_KEY_PAIR_ID = "key_pair_id";
    private static final String KEY_SIGN = "sign";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_VERSION = "version";
    @SerializedName(KEY_CIPHER)
    private final String cipher;
    @SerializedName(KEY_DATA)
    private final String data;
    @SerializedName(KEY_KEY_PAIR_ID)
    private final String keyPairId;
    @SerializedName(KEY_SIGN)
    private final String sign;
    @SerializedName(KEY_TIMESTAMP)
    private final long timestamp;
    @SerializedName(KEY_VERSION)
    private final int version;

    public static /* synthetic */ FetchOTAUpdateInfoRequestBody copy$default(FetchOTAUpdateInfoRequestBody fetchOTAUpdateInfoRequestBody, String str, int i, String str2, long j, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fetchOTAUpdateInfoRequestBody.keyPairId;
        }
        if ((i2 & 2) != 0) {
            i = fetchOTAUpdateInfoRequestBody.version;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = fetchOTAUpdateInfoRequestBody.data;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            j = fetchOTAUpdateInfoRequestBody.timestamp;
        }
        long j2 = j;
        if ((i2 & 16) != 0) {
            str3 = fetchOTAUpdateInfoRequestBody.cipher;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = fetchOTAUpdateInfoRequestBody.sign;
        }
        return fetchOTAUpdateInfoRequestBody.copy(str, i3, str5, j2, str6, str4);
    }

    public final String component1() {
        return this.keyPairId;
    }

    public final int component2() {
        return this.version;
    }

    public final String component3() {
        return this.data;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.cipher;
    }

    public final String component6() {
        return this.sign;
    }

    public final FetchOTAUpdateInfoRequestBody copy(String keyPairId, int i, String data, long j, String cipher, String sign) {
        Intrinsics.checkNotNullParameter(keyPairId, "keyPairId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(sign, "sign");
        return new FetchOTAUpdateInfoRequestBody(keyPairId, i, data, j, cipher, sign);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchOTAUpdateInfoRequestBody) {
            FetchOTAUpdateInfoRequestBody fetchOTAUpdateInfoRequestBody = (FetchOTAUpdateInfoRequestBody) obj;
            return Intrinsics.areEqual(this.keyPairId, fetchOTAUpdateInfoRequestBody.keyPairId) && this.version == fetchOTAUpdateInfoRequestBody.version && Intrinsics.areEqual(this.data, fetchOTAUpdateInfoRequestBody.data) && this.timestamp == fetchOTAUpdateInfoRequestBody.timestamp && Intrinsics.areEqual(this.cipher, fetchOTAUpdateInfoRequestBody.cipher) && Intrinsics.areEqual(this.sign, fetchOTAUpdateInfoRequestBody.sign);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.keyPairId.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.data.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.cipher.hashCode()) * 31) + this.sign.hashCode();
    }

    public String toString() {
        return "FetchOTAUpdateInfoRequestBody(keyPairId=" + this.keyPairId + ", version=" + this.version + ", data=" + this.data + ", timestamp=" + this.timestamp + ", cipher=" + this.cipher + ", sign=" + this.sign + ')';
    }

    public FetchOTAUpdateInfoRequestBody(String keyPairId, int i, String data, long j, String cipher, String sign) {
        Intrinsics.checkNotNullParameter(keyPairId, "keyPairId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(sign, "sign");
        this.keyPairId = keyPairId;
        this.version = i;
        this.data = data;
        this.timestamp = j;
        this.cipher = cipher;
        this.sign = sign;
    }

    public final String getKeyPairId() {
        return this.keyPairId;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getData() {
        return this.data;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getCipher() {
        return this.cipher;
    }

    public final String getSign() {
        return this.sign;
    }

    /* compiled from: FetchOTAUpdateInfoRequestBody.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/remote/request/FetchOTAUpdateInfoRequestBody$Companion;", "", "()V", "KEY_CIPHER", "", "KEY_DATA", "KEY_DATA_OLD_VERSION", "KEY_DATA_OLD_VERSION_DATE", "KEY_DATA_VERSION_KEY", "KEY_KEY_PAIR_ID", "KEY_SIGN", "KEY_TIMESTAMP", "KEY_VERSION", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
