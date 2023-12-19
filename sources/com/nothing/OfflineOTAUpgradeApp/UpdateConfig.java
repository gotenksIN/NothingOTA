package com.nothing.OfflineOTAUpgradeApp;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UpdateConfig implements Parcelable {
    public static final int AB_INSTALL_TYPE_NON_STREAMING = 0;
    private static final String AB_INSTALL_TYPE_NON_STREAMING_JSON = "NON_STREAMING";
    public static final int AB_INSTALL_TYPE_STREAMING = 1;
    private static final String AB_INSTALL_TYPE_STREAMING_JSON = "STREAMING";
    public static final Parcelable.Creator<UpdateConfig> CREATOR = new Parcelable.Creator<UpdateConfig>() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateConfig createFromParcel(Parcel parcel) {
            return new UpdateConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateConfig[] newArray(int i) {
            return new UpdateConfig[i];
        }
    };
    private AbConfig mAbConfig;
    private int mAbInstallType;
    private String mName;
    private String mRawJson;
    private String mUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static UpdateConfig fromJson(String str) throws JSONException {
        UpdateConfig updateConfig = new UpdateConfig();
        JSONObject jSONObject = new JSONObject(str);
        updateConfig.mName = jSONObject.getString(HintConstants.AUTOFILL_HINT_NAME);
        updateConfig.mUrl = jSONObject.getString("url");
        String string = jSONObject.getString("ab_install_type");
        string.hashCode();
        if (string.equals(AB_INSTALL_TYPE_STREAMING_JSON)) {
            updateConfig.mAbInstallType = 1;
        } else if (string.equals(AB_INSTALL_TYPE_NON_STREAMING_JSON)) {
            updateConfig.mAbInstallType = 0;
        } else {
            throw new JSONException("Invalid type, expected either NON_STREAMING or STREAMING, got " + jSONObject.getString("ab_install_type"));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("ab_config");
        boolean z = jSONObject2.getBoolean("force_switch_slot");
        boolean z2 = jSONObject2.getBoolean("verify_payload_metadata");
        ArrayList arrayList = new ArrayList();
        if (jSONObject2.has("property_files")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("property_files");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                arrayList.add(new PackageFile(jSONObject3.getString("filename"), jSONObject3.getLong("offset"), jSONObject3.getLong("size")));
            }
        }
        updateConfig.mAbConfig = new AbConfig(z, z2, (PackageFile[]) arrayList.toArray(new PackageFile[0]), jSONObject2.optString("authorization", null));
        updateConfig.mRawJson = str;
        return updateConfig;
    }

    protected UpdateConfig() {
    }

    protected UpdateConfig(Parcel parcel) {
        this.mName = parcel.readString();
        this.mUrl = parcel.readString();
        this.mAbInstallType = parcel.readInt();
        this.mAbConfig = (AbConfig) parcel.readSerializable();
        this.mRawJson = parcel.readString();
    }

    public UpdateConfig(String str, String str2, int i) {
        this.mName = str;
        this.mUrl = str2;
        this.mAbInstallType = i;
    }

    public String getName() {
        return this.mName;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getRawJson() {
        return this.mRawJson;
    }

    public int getInstallType() {
        return this.mAbInstallType;
    }

    public AbConfig getAbConfig() {
        return this.mAbConfig;
    }

    public File getUpdatePackageFile() {
        if (this.mAbInstallType != 0) {
            throw new RuntimeException("Expected non-streaming install type");
        }
        if (!this.mUrl.startsWith("file://")) {
            throw new RuntimeException("url is expected to start with file://");
        }
        String str = this.mUrl;
        return new File(str.substring(7, str.length()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mUrl);
        parcel.writeInt(this.mAbInstallType);
        parcel.writeSerializable(this.mAbConfig);
        parcel.writeString(this.mRawJson);
    }

    /* loaded from: classes2.dex */
    public static class PackageFile implements Serializable {
        private static final long serialVersionUID = 31043;
        private String mFilename;
        private long mOffset;
        private long mSize;

        public PackageFile(String str, long j, long j2) {
            this.mFilename = str;
            this.mOffset = j;
            this.mSize = j2;
        }

        public String getFilename() {
            return this.mFilename;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }
    }

    /* loaded from: classes2.dex */
    public static class AbConfig implements Serializable {
        private static final long serialVersionUID = 31044;
        private String mAuthorization;
        private boolean mForceSwitchSlot;
        private PackageFile[] mPropertyFiles;
        private boolean mVerifyPayloadMetadata;

        public AbConfig(boolean z, boolean z2, PackageFile[] packageFileArr, String str) {
            this.mForceSwitchSlot = z;
            this.mVerifyPayloadMetadata = z2;
            this.mPropertyFiles = packageFileArr;
            this.mAuthorization = str;
        }

        public boolean getForceSwitchSlot() {
            return this.mForceSwitchSlot;
        }

        public boolean getVerifyPayloadMetadata() {
            return this.mVerifyPayloadMetadata;
        }

        public PackageFile[] getPropertyFiles() {
            return this.mPropertyFiles;
        }

        public Optional<String> getAuthorization() {
            String str = this.mAuthorization;
            return str == null ? Optional.empty() : Optional.of(str);
        }
    }
}
