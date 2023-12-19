package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(m41d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, m39k = 4, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateKt {
    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        return SnapshotFlow.collectAsState(flow, r, coroutineContext, composer, i, i2);
    }

    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        return SnapshotFlow.collectAsState(stateFlow, coroutineContext, composer, i, i2);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, Functions<? extends T> functions) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(snapshotMutationPolicy, functions);
    }

    public static final <T> State<T> derivedStateOf(Functions<? extends T> functions) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(functions);
    }

    public static final <T> T getValue(State<? extends T> state, Object obj, KProperty<?> kProperty) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(state, obj, kProperty);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Tuples<? extends K, ? extends V>... tuplesArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(tuplesArr);
    }

    public static final <T> SnapshotState<T> mutableStateOf(T t, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t, snapshotMutationPolicy);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver derivedStateObserver, Functions<? extends R> functions) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(derivedStateObserver, functions);
    }

    public static final <T> State<T> produceState(T t, Object obj, Object obj2, Object obj3, Function2<? super ProduceState<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, obj2, obj3, function2, composer, i);
    }

    public static final <T> State<T> produceState(T t, Object obj, Object obj2, Function2<? super ProduceState<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, obj2, function2, composer, i);
    }

    public static final <T> State<T> produceState(T t, Object obj, Function2<? super ProduceState<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, function2, composer, i);
    }

    public static final <T> State<T> produceState(T t, Function2<? super ProduceState<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, function2, composer, i);
    }

    public static final <T> State<T> produceState(T t, Object[] objArr, Function2<? super ProduceState<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState((Object) t, objArr, (Function2) function2, composer, i);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final <T> State<T> rememberUpdatedState(T t, Composer composer, int i) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t, composer, i);
    }

    public static final <T> void setValue(SnapshotState<T> snapshotState, Object obj, KProperty<?> kProperty, T t) {
        SnapshotStateKt__SnapshotStateKt.setValue(snapshotState, obj, kProperty, t);
    }

    public static final <T> Flow<T> snapshotFlow(Functions<? extends T> functions) {
        return SnapshotFlow.snapshotFlow(functions);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Tuples<? extends K, ? extends V>> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }
}
