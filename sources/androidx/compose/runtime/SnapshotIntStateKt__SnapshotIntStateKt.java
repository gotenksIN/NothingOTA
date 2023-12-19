package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: SnapshotIntState.kt */
@Metadata(m41d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, m40d2 = {"mutableIntStateOf", "Landroidx/compose/runtime/MutableIntState;", "value", "", "getValue", "Landroidx/compose/runtime/IntState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, m39k = 5, m38mv = {1, 8, 0}, m36xi = 48, m35xs = "androidx/compose/runtime/SnapshotIntStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotIntStateKt__SnapshotIntStateKt {
    public static final MutableIntState mutableIntStateOf(int i) {
        return ActualAndroid_androidKt.createSnapshotMutableIntState(i);
    }

    public static final int getValue(SnapshotIntState snapshotIntState, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(snapshotIntState, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return snapshotIntState.getIntValue();
    }

    public static final void setValue(MutableIntState mutableIntState, Object obj, KProperty<?> property, int i) {
        Intrinsics.checkNotNullParameter(mutableIntState, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        mutableIntState.setIntValue(i);
    }
}
