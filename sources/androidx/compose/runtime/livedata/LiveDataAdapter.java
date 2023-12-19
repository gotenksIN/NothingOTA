package androidx.compose.runtime.livedata;

import androidx.compose.p002ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0002*\u0002H\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m40d2 = {"observeAsState", "Landroidx/compose/runtime/State;", "T", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "R", "initial", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-livedata_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.runtime.livedata.LiveDataAdapterKt */
/* loaded from: classes.dex */
public final class LiveDataAdapter {
    public static final <T> State<T> observeAsState(LiveData<T> liveData, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(-2027206144);
        ComposerKt.sourceInformation(composer, "C(observeAsState)40@1624L21:LiveDataAdapter.kt#drcai5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2027206144, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:40)");
        }
        State<T> observeAsState = observeAsState(liveData, liveData.getValue(), composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return observeAsState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T extends R> State<R> observeAsState(final LiveData<T> liveData, R r, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(411178300);
        ComposerKt.sourceInformation(composer, "C(observeAsState)58@2504L7,59@2528L173,63@2706L191:LiveDataAdapter.kt#drcai5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(411178300, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:57)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            R r2 = r;
            if (liveData.isInitialized()) {
                r2 = liveData.getValue();
            }
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final SnapshotState snapshotState = (SnapshotState) rememberedValue;
        EffectsKt.DisposableEffect(liveData, lifecycleOwner, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$observeAsState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final SnapshotState<R> snapshotState2 = snapshotState;
                final Observer observer = new Observer<T>() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$observeAsState$1$observer$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(T t) {
                        snapshotState2.setValue(t);
                    }
                };
                liveData.observe(lifecycleOwner, observer);
                final LiveData<T> liveData2 = liveData;
                return new DisposableEffectResult() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        LiveData.this.removeObserver(observer);
                    }
                };
            }
        }, composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapshotState;
    }
}
