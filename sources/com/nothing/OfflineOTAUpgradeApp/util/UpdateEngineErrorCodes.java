package com.nothing.OfflineOTAUpgradeApp.util;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class UpdateEngineErrorCodes {
    private static final SparseArray<String> CODE_TO_NAME_MAP;
    private static final Set<Integer> SUCCEEDED_COMPLETION_CODES;
    public static final int UNKNOWN = -1;
    public static final int UPDATED_BUT_NOT_ACTIVE = 52;
    public static final int USER_CANCELLED = 48;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        CODE_TO_NAME_MAP = sparseArray;
        sparseArray.put(0, "SUCCESS");
        sparseArray.put(1, "ERROR");
        sparseArray.put(4, "FILESYSTEM_COPIER_ERROR");
        sparseArray.put(5, "POST_INSTALL_RUNNER_ERROR");
        sparseArray.put(6, "PAYLOAD_MISMATCHED_TYPE_ERROR");
        sparseArray.put(7, "INSTALL_DEVICE_OPEN_ERROR");
        sparseArray.put(8, "KERNEL_DEVICE_OPEN_ERROR");
        sparseArray.put(9, "DOWNLOAD_TRANSFER_ERROR");
        sparseArray.put(10, "PAYLOAD_HASH_MISMATCH_ERROR");
        sparseArray.put(11, "PAYLOAD_SIZE_MISMATCH_ERROR");
        sparseArray.put(12, "DOWNLOAD_PAYLOAD_VERIFICATION_ERROR");
        sparseArray.put(15, "NEW_ROOTFS_VERIFICATION_ERROR");
        sparseArray.put(20, "DOWNLOAD_STATE_INITIALIZATION_ERROR");
        sparseArray.put(26, "DOWNLOAD_METADATA_SIGNATURE_MISMATCH");
        sparseArray.put(48, "USER_CANCELLED");
        sparseArray.put(52, "UPDATED_BUT_NOT_ACTIVE");
        SUCCEEDED_COMPLETION_CODES = new HashSet(Arrays.asList(0, 52));
    }

    public static boolean isUpdateSucceeded(int i) {
        return SUCCEEDED_COMPLETION_CODES.contains(Integer.valueOf(i));
    }

    public static String getCodeName(int i) {
        return CODE_TO_NAME_MAP.get(i);
    }

    private UpdateEngineErrorCodes() {
    }
}
