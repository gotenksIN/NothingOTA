package androidx.activity.compose;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveable;
import androidx.compose.runtime.saveable.Saver;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultRegistry.kt */
@Metadata(m41d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m40d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultRegistryKt {
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(final ActivityResultContract<I, O> contract, Function1<? super O, Unit> onResult, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        composer.startReplaceableGroup(-1408504823);
        ComposerKt.sourceInformation(composer, "C(rememberLauncherForActivityResult)86@3568L30,87@3625L30,91@3794L49,*93@3924L7,96@4078L46,97@4152L85,103@4364L260:ActivityResultRegistry.kt#q1dkbc");
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contract, composer, 8);
        final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onResult, composer, (i >> 3) & 14);
        Object m2509rememberSaveable = RememberSaveable.m2509rememberSaveable(new Object[0], (Saver<Object, ? extends Object>) null, (String) null, (Functions<? extends Object>) new Functions<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Functions
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, composer, 3080, 6);
        Intrinsics.checkNotNullExpressionValue(m2509rememberSaveable, "rememberSaveable { UUID.randomUUID().toString() }");
        final String str = (String) m2509rememberSaveable;
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        }
        final ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ActivityResultRegistry();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final ActivityResultRegistry activityResultRegistry2 = (ActivityResultRegistry) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ManagedActivityResultLauncher(activityResultRegistry2, rememberUpdatedState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) rememberedValue2;
        EffectsKt.DisposableEffect(activityResultRegistry, str, contract, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                ActivityResultRegistry<I> activityResultRegistry3 = activityResultRegistry2;
                ActivityResultRegistry activityResultRegistry4 = activityResultRegistry;
                String str2 = str;
                Object obj = contract;
                final State<Function1<O, Unit>> state = rememberUpdatedState2;
                activityResultRegistry3.setLauncher(activityResultRegistry4.register(str2, obj, new ActivityResultCallback<O>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1.1
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(O o) {
                        state.getValue().invoke(o);
                    }
                }));
                final ActivityResultRegistry<I> activityResultRegistry5 = activityResultRegistry2;
                return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        ActivityResultRegistry.this.unregister();
                    }
                };
            }
        }, composer, 520);
        composer.endReplaceableGroup();
        return managedActivityResultLauncher;
    }
}
