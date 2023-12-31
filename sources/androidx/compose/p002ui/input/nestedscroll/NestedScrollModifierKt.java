package androidx.compose.p002ui.input.nestedscroll;

import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.platform.InspectableValueKt;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollModifier.kt */
@Metadata(m41d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, m40d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt */
/* loaded from: classes.dex */
public final class NestedScrollModifierKt {
    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollModifier nestedScrollModifier, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollModifier, nestedScrollDispatcher);
    }

    public static final Modifier nestedScroll(Modifier modifier, final NestedScrollModifier connection, final NestedScrollDispatcher nestedScrollDispatcher) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(connection, "connection");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("nestedScroll");
                inspectorInfo.getProperties().set("connection", NestedScrollModifier.this);
                inspectorInfo.getProperties().set("dispatcher", nestedScrollDispatcher);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v8 */
            /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.runtime.Composer] */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(410346167);
                ComposerKt.sourceInformation(composer, "C336@15461L24,339@15612L180:NestedScrollModifier.kt#kpqmsf");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(410346167, i, -1, "androidx.compose.ui.input.nestedscroll.nestedScroll.<anonymous> (NestedScrollModifier.kt:335)");
                }
                composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                composer.endReplaceableGroup();
                NestedScrollDispatcher nestedScrollDispatcher2 = NestedScrollDispatcher.this;
                composer.startReplaceableGroup(100475956);
                ComposerKt.sourceInformation(composer, "338@15570L37");
                if (nestedScrollDispatcher2 == null) {
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                    Object rememberedValue2 = composer.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new NestedScrollDispatcher();
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    nestedScrollDispatcher2 = rememberedValue2;
                }
                composer.endReplaceableGroup();
                NestedScrollModifier nestedScrollModifier = connection;
                composer.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                boolean changed = composer.changed(nestedScrollModifier) | composer.changed(nestedScrollDispatcher2) | composer.changed(coroutineScope);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                    nestedScrollDispatcher2.setOriginNestedScrollScope$ui_release(coroutineScope);
                    rememberedValue3 = new NestedScrollModifierLocal(nestedScrollDispatcher2, nestedScrollModifier);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                NestedScrollModifierLocal nestedScrollModifierLocal = (NestedScrollModifierLocal) rememberedValue3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return nestedScrollModifierLocal;
            }
        });
    }
}
