package com.nothing.OfflineOTAUpgradeApp.util;

import android.util.SparseArray;

/* loaded from: classes2.dex */
public final class UpdateEngineStatuses {
    private static final SparseArray<String> STATUS_MAP;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        STATUS_MAP = sparseArray;
        sparseArray.put(0, "IDLE");
        sparseArray.put(1, "CHECKING_FOR_UPDATE");
        sparseArray.put(2, "UPDATE_AVAILABLE");
        sparseArray.put(3, "DOWNLOADING");
        sparseArray.put(4, "VERIFYING");
        sparseArray.put(5, "FINALIZING");
        sparseArray.put(6, "UPDATED_NEED_REBOOT");
        sparseArray.put(7, "REPORTING_ERROR_EVENT");
        sparseArray.put(8, "ATTEMPTING_ROLLBACK");
        sparseArray.put(9, "DISABLED");
    }

    public static String getStatusText(int i) {
        return STATUS_MAP.get(i);
    }

    private UpdateEngineStatuses() {
    }
}
