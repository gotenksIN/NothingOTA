package com.nothing.OfflineOTAUpgradeApp.state;

import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState;", "", "Complete", "Fetching", "Idle", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Complete;", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Fetching;", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Idle;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface QueryState {

    /* compiled from: QueryState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Idle;", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Idle implements QueryState {
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
            return 1073800346;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: QueryState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Fetching;", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Fetching implements QueryState {
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
            return -530108242;
        }

        public String toString() {
            return "Fetching";
        }

        private Fetching() {
        }
    }

    /* compiled from: QueryState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState$Complete;", "Lcom/nothing/OfflineOTAUpgradeApp/state/QueryState;", "info", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "(Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;)V", "getInfo", "()Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Complete implements QueryState {
        public static final int $stable = 0;
        private final RemoteOTAUpdateInfo info;

        public Complete(RemoteOTAUpdateInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        public final RemoteOTAUpdateInfo getInfo() {
            return this.info;
        }
    }
}
