package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007\u001a\u0012\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\t0\u0002H\u0007\u001a\u0012\u0010\n\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\f0\u0002H\u0007¨\u0006\r"}, m40d2 = {"asDoubleState", "Landroidx/compose/runtime/DoubleState;", "Landroidx/compose/runtime/State;", "", "asFloatState", "Landroidx/compose/runtime/FloatState;", "", "asIntState", "Landroidx/compose/runtime/IntState;", "", "asLongState", "Landroidx/compose/runtime/LongState;", "", "runtime_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.runtime.SnapshotStateExtensionsKt */
/* loaded from: classes.dex */
public final class SnapshotStateExtensions {
    public static final SnapshotIntState asIntState(State<Integer> state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        return state instanceof SnapshotIntState ? (SnapshotIntState) state : new UnboxedIntState(state);
    }

    public static final SnapshotLongState asLongState(State<Long> state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        return state instanceof SnapshotLongState ? (SnapshotLongState) state : new UnboxedLongState(state);
    }

    public static final SnapshotFloatState asFloatState(State<Float> state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        return state instanceof SnapshotFloatState ? (SnapshotFloatState) state : new UnboxedFloatState(state);
    }

    public static final SnapshotDoubleState asDoubleState(State<Double> state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        return state instanceof SnapshotDoubleState ? (SnapshotDoubleState) state : new UnboxedDoubleState(state);
    }
}
