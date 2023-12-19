package com.nothing.OfflineOTAUpgradeApp;

import android.util.SparseArray;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* loaded from: classes2.dex */
public class UpdaterState {
    public static final int ERROR = 1;
    public static final int IDLE = 0;
    public static final int PAUSED = 3;
    public static final int REBOOT_REQUIRED = 5;
    public static final int RUNNING = 2;
    public static final int SLOT_SWITCH_REQUIRED = 4;
    private static final SparseArray<String> STATE_MAP;
    private static final ImmutableMap<Integer, ImmutableSet<Integer>> TRANSITIONS;
    private AtomicInteger mState;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        STATE_MAP = sparseArray;
        sparseArray.put(0, "IDLE");
        sparseArray.put(1, "ERROR");
        sparseArray.put(2, DebugCoroutineInfoImplKt.RUNNING);
        sparseArray.put(3, "PAUSED");
        sparseArray.put(4, "SLOT_SWITCH_REQUIRED");
        sparseArray.put(5, "REBOOT_REQUIRED");
        TRANSITIONS = ImmutableMap.builder().put(0, ImmutableSet.m161of(0, 1, 2)).put(1, ImmutableSet.m163of(0)).put(2, ImmutableSet.m159of(0, 1, 3, 5, 4)).put(3, ImmutableSet.m161of(1, 2, 0)).put(4, ImmutableSet.m161of(1, 5, 0)).put(5, ImmutableSet.m163of(0)).build();
    }

    public UpdaterState(int i) {
        this.mState = new AtomicInteger(i);
    }

    public int get() {
        return this.mState.get();
    }

    public void set(int i) throws InvalidTransitionException {
        int i2 = this.mState.get();
        if (!TRANSITIONS.get(Integer.valueOf(i2)).contains(Integer.valueOf(i))) {
            throw new InvalidTransitionException("Can't transition from " + i2 + " to " + i);
        }
        this.mState.set(i);
    }

    public static String getStateText(int i) {
        return STATE_MAP.get(i);
    }

    /* loaded from: classes2.dex */
    public static class InvalidTransitionException extends Exception {
        public InvalidTransitionException(String str) {
            super(str);
        }
    }
}
