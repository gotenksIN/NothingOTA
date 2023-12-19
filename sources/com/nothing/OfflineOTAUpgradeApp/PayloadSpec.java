package com.nothing.OfflineOTAUpgradeApp;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class PayloadSpec implements Serializable {
    private static final long serialVersionUID = 41043;
    private long mOffset;
    private List<String> mProperties;
    private long mSize;
    private String mUrl;

    public static Builder newBuilder() {
        return new Builder();
    }

    public PayloadSpec(Builder builder) {
        this.mUrl = builder.mUrl;
        this.mOffset = builder.mOffset;
        this.mSize = builder.mSize;
        this.mProperties = builder.mProperties;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public long getOffset() {
        return this.mOffset;
    }

    public long getSize() {
        return this.mSize;
    }

    public List<String> getProperties() {
        return this.mProperties;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private long mOffset;
        private List<String> mProperties;
        private long mSize;
        private String mUrl;

        public Builder url(String str) {
            this.mUrl = str;
            return this;
        }

        public Builder offset(long j) {
            this.mOffset = j;
            return this;
        }

        public Builder size(long j) {
            this.mSize = j;
            return this;
        }

        public Builder properties(List<String> list) {
            this.mProperties = list;
            return this;
        }

        public PayloadSpec build() {
            return new PayloadSpec(this);
        }
    }
}
