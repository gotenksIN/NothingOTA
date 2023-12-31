package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetector;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.key.Key;
import androidx.compose.p002ui.input.key.KeyEvent;
import androidx.compose.p002ui.input.key.KeyEvent_androidKt;
import androidx.compose.p002ui.input.key.KeyInputModifier;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.modifier.ModifierLocalConsumer;
import androidx.compose.p002ui.modifier.ModifierLocalReadScope;
import androidx.compose.p002ui.platform.InspectableValueKt;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.p002ui.semantics.Role;
import androidx.compose.p002ui.semantics.SemanticsModifierKt;
import androidx.compose.p002ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p002ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(m41d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aE\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018\u001a\u0089\u0001\u0010\u0019\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001d\u001aw\u0010\u0019\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a©\u0001\u0010\u001f\u001a\u00020\f*\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&\u001aQ\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160$H\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m40d2 = {"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Ljava/util/Map;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-bdNGguI", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.ClickableKt */
/* loaded from: classes.dex */
public final class Clickable {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m477clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Functions functions, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m476clickableXHw0xAI(modifier, z, str, role, functions);
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m475clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Functions functions, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m474clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, functions);
    }

    public static final void PressedInteractionSourceDisposableEffect(final MutableInteractionSource interactionSource, final SnapshotState<PressInteraction.Press> pressedInteraction, final Map<Key, PressInteraction.Press> currentKeyPressInteractions, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(pressedInteraction, "pressedInteraction");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Composer startRestartGroup = composer.startRestartGroup(1297229208);
        ComposerKt.sourceInformation(startRestartGroup, "C(PressedInteractionSourceDisposableEffect)P(1,2)414@17663L504:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, i, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:409)");
        }
        EffectsKt.DisposableEffect(interactionSource, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final SnapshotState<PressInteraction.Press> snapshotState = pressedInteraction;
                final Map<Key, PressInteraction.Press> map = currentKeyPressInteractions;
                final MutableInteractionSource mutableInteractionSource = interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        PressInteraction.Press press = (PressInteraction.Press) SnapshotState.this.getValue();
                        if (press != null) {
                            mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press));
                            SnapshotState.this.setValue(null);
                        }
                        for (PressInteraction.Press press2 : map.values()) {
                            mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press2));
                        }
                        map.clear();
                    }
                };
            }
        }, startRestartGroup, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                Clickable.PressedInteractionSourceDisposableEffect(MutableInteractionSource.this, pressedInteraction, currentKeyPressInteractions, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m484handlePressInteractionEPk0efs(TapGestureDetector tapGestureDetector, long j, MutableInteractionSource mutableInteractionSource, SnapshotState<PressInteraction.Press> snapshotState, State<? extends Functions<Boolean>> state, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2(tapGestureDetector, j, mutableInteractionSource, snapshotState, state, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier modifier, final Role role, final String str, final Functions<Unit> functions, final String str2, final boolean z, final Functions<Unit> functions2) {
        return SemanticsModifierKt.semantics(modifier, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                Role role2 = Role.this;
                if (role2 != null) {
                    SemanticsPropertiesKt.m4746setRolekuIjeqM(semantics, role2.m4731unboximpl());
                }
                String str3 = str;
                final Functions<Unit> functions3 = functions2;
                SemanticsPropertiesKt.onClick(semantics, str3, new Functions<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Functions
                    public final Boolean invoke() {
                        functions3.invoke();
                        return true;
                    }
                });
                if (functions != null) {
                    String str4 = str2;
                    final Functions<Unit> functions4 = functions;
                    SemanticsPropertiesKt.onLongClick(semantics, str4, new Functions<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Functions
                        public final Boolean invoke() {
                            functions4.invoke();
                            return true;
                        }
                    });
                }
                if (z) {
                    return;
                }
                SemanticsPropertiesKt.disabled(semantics);
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey */
    private static final Modifier m291x602ad71b(Modifier modifier, final boolean z, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final CoroutineScope coroutineScope, final Functions<Unit> functions, final MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifier.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m491invokeZmokQxo(keyEvent.m4114unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m491invokeZmokQxo(android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                boolean z2 = true;
                if (z && Clickable_androidKt.m494isPressZmokQxo(keyEvent)) {
                    if (!map.containsKey(Key.m3527boximpl(KeyEvent_androidKt.m4125getKeyZmokQxo(keyEvent)))) {
                        PressInteraction.Press press = new PressInteraction.Press(state.getValue().m2629unboximpl(), null);
                        map.put(Key.m3527boximpl(KeyEvent_androidKt.m4125getKeyZmokQxo(keyEvent)), press);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01791(mutableInteractionSource, press, null), 3, null);
                    }
                    z2 = false;
                } else {
                    if (z && Clickable_androidKt.m492isClickZmokQxo(keyEvent)) {
                        PressInteraction.Press remove = map.remove(Key.m3527boximpl(KeyEvent_androidKt.m4125getKeyZmokQxo(keyEvent)));
                        if (remove != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0180x8f00ca0b(mutableInteractionSource, remove, null), 3, null);
                        }
                        functions.invoke();
                    }
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Clickable.kt */
            @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
            @DebugMetadata(m31c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", m30f = "Clickable.kt", m29i = {}, m28l = {540}, m27m = "invokeSuspend", m26n = {}, m25s = {})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1 */
            /* loaded from: classes.dex */
            public static final class C01791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01791(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super C01791> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01791(this.$interactionSource, this.$press, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$interactionSource.emit(this.$press, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture-bdNGguI  reason: not valid java name */
    public static final Modifier m482genericClickableWithoutGesturebdNGguI(Modifier genericClickableWithoutGesture, Modifier gestureModifiers, MutableInteractionSource interactionSource, Indication indication, CoroutineScope indicationScope, Map<Key, PressInteraction.Press> currentKeyPressInteractions, State<Offset> keyClickOffset, boolean z, String str, Role role, String str2, Functions<Unit> functions, Functions<Unit> onClick) {
        Intrinsics.checkNotNullParameter(genericClickableWithoutGesture, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(gestureModifiers, "gestureModifiers");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(indicationScope, "indicationScope");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(keyClickOffset, "keyClickOffset");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return Focusable.focusableInNonTouchMode(Hoverable.hoverable(IndicationKt.indication(m291x602ad71b(genericClickableWithoutGesture_bdNGguI$clickSemantics(genericClickableWithoutGesture, role, str, functions, str2, z, onClick), z, currentKeyPressInteractions, keyClickOffset, indicationScope, onClick, interactionSource), interactionSource, indication), interactionSource, z), z, interactionSource).then(gestureModifiers);
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m476clickableXHw0xAI(Modifier clickable, final boolean z, final String str, final Role role, final Functions<Unit> onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", onClick);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-756081143);
                ComposerKt.sourceInformation(composer, "C98@4098L7,99@4135L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:92)");
                }
                Modifier.Companion companion = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(IndicationKt.getLocalIndication());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m474clickableO2vRcR0 = Clickable.m474clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m474clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m474clickableO2vRcR0(Modifier clickable, final MutableInteractionSource interactionSource, final Indication indication, final boolean z, final String str, final Role role, final Functions<Unit> onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", onClick);
                inspectorInfo.getProperties().set("indication", indication);
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Map map;
                MutableInteractionSource mutableInteractionSource;
                SnapshotState snapshotState;
                Boolean bool;
                Modifier.Companion companion;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(92076020);
                ComposerKt.sourceInformation(composer, "C136@5787L29,137@5850L58,138@5951L56,146@6266L36,147@6350L33,148@6441L95,148@6420L116,151@6564L40,153@6678L550,171@7281L445,186@7960L24:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(92076020, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:135)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onClick, composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                SnapshotState snapshotState2 = (SnapshotState) rememberedValue;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = (Map) new LinkedHashMap();
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Map map2 = (Map) rememberedValue2;
                composer.startReplaceableGroup(1841981561);
                ComposerKt.sourceInformation(composer, "140@6043L170");
                if (z) {
                    Clickable.PressedInteractionSourceDisposableEffect(interactionSource, snapshotState2, map2, composer, 560);
                }
                composer.endReplaceableGroup();
                final Functions<Boolean> isComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                final SnapshotState snapshotState3 = (SnapshotState) rememberedValue3;
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed = composer.changed(snapshotState3) | composer.changed(isComposeRootInScrollableContainer);
                Object rememberedValue4 = composer.rememberedValue();
                if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = (Functions) new Functions<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$delayPressInteraction$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Functions
                        public final Boolean invoke() {
                            return Boolean.valueOf(snapshotState3.getValue().booleanValue() || isComposeRootInScrollableContainer.invoke().booleanValue());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceableGroup();
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(rememberedValue4, composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2608boximpl(Offset.Companion.m2635getZeroF1C5BW0()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceableGroup();
                SnapshotState snapshotState4 = (SnapshotState) rememberedValue5;
                Modifier.Companion companion2 = Modifier.Companion;
                MutableInteractionSource mutableInteractionSource2 = interactionSource;
                Boolean valueOf = Boolean.valueOf(z);
                MutableInteractionSource mutableInteractionSource3 = interactionSource;
                Object[] objArr = {snapshotState4, Boolean.valueOf(z), mutableInteractionSource3, snapshotState2, rememberUpdatedState2, rememberUpdatedState};
                boolean z2 = z;
                composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                int i2 = 0;
                boolean z3 = false;
                for (int i3 = 6; i2 < i3; i3 = 6) {
                    z3 |= composer.changed(objArr[i2]);
                    i2++;
                }
                Object rememberedValue6 = composer.rememberedValue();
                if (z3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    map = map2;
                    mutableInteractionSource = mutableInteractionSource2;
                    snapshotState = snapshotState4;
                    bool = valueOf;
                    companion = companion2;
                    rememberedValue6 = (Function2) new ClickableKt$clickable$4$gesture$1$1(snapshotState4, z2, mutableInteractionSource3, snapshotState2, rememberUpdatedState2, rememberUpdatedState, null);
                    composer.updateRememberedValue(rememberedValue6);
                } else {
                    companion = companion2;
                    snapshotState = snapshotState4;
                    bool = valueOf;
                    map = map2;
                    mutableInteractionSource = mutableInteractionSource2;
                }
                composer.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, mutableInteractionSource, bool, (Function2) rememberedValue6);
                Modifier.Companion companion3 = Modifier.Companion;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$1$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.compose.p002ui.modifier.ModifierLocalConsumer
                        public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
                            Intrinsics.checkNotNullParameter(scope, "scope");
                            snapshotState3.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue7);
                }
                composer.endReplaceableGroup();
                Modifier then = companion3.then((Modifier) rememberedValue7);
                MutableInteractionSource mutableInteractionSource4 = interactionSource;
                Indication indication2 = indication;
                composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue8 = composer.rememberedValue();
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue8 = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                composer.endReplaceableGroup();
                Modifier m482genericClickableWithoutGesturebdNGguI = Clickable.m482genericClickableWithoutGesturebdNGguI(then, pointerInput, mutableInteractionSource4, indication2, coroutineScope, map, snapshotState, z, str, role, null, null, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m482genericClickableWithoutGesturebdNGguI;
            }
        });
    }

    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m480combinedClickablecJG_KMw(Modifier combinedClickable, final boolean z, final String str, final Role role, final String str2, final Functions<Unit> functions, final Functions<Unit> functions2, final Functions<Unit> onClick) {
        Intrinsics.checkNotNullParameter(combinedClickable, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", onClick);
                inspectorInfo.getProperties().set("onDoubleClick", functions2);
                inspectorInfo.getProperties().set("onLongClick", functions);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1969174843);
                ComposerKt.sourceInformation(composer, "C261@10940L7,262@10977L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:252)");
                }
                Modifier.Companion companion = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(IndicationKt.getLocalIndication());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m478combinedClickableXVZzFYc = Clickable.m478combinedClickableXVZzFYc(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, str2, functions, functions2, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m478combinedClickableXVZzFYc;
            }
        });
    }

    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m478combinedClickableXVZzFYc(Modifier combinedClickable, final MutableInteractionSource interactionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Functions<Unit> functions, final Functions<Unit> functions2, final Functions<Unit> onClick) {
        Intrinsics.checkNotNullParameter(combinedClickable, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", onClick);
                inspectorInfo.getProperties().set("onDoubleClick", functions2);
                inspectorInfo.getProperties().set("onLongClick", functions);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
                inspectorInfo.getProperties().set("indication", indication);
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Object[] objArr;
                Map map;
                Modifier.Companion companion;
                final SnapshotState snapshotState;
                String str3;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1841718000);
                ComposerKt.sourceInformation(composer, "C307@13021L29,308@13082L33,309@13149L35,312@13316L58,313@13417L56,332@14268L36,333@14352L33,334@14443L95,334@14422L116,337@14566L40,340@14722L1028,368@15803L445,383@16482L24:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1841718000, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:306)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onClick, composer, 0);
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(functions, composer, 0);
                State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(functions2, composer, 0);
                boolean z2 = functions != null;
                boolean z3 = functions2 != null;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                final SnapshotState snapshotState2 = (SnapshotState) rememberedValue;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = (Map) new LinkedHashMap();
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Map map2 = (Map) rememberedValue2;
                composer.startReplaceableGroup(1321107720);
                ComposerKt.sourceInformation(composer, "317@13690L342,317@13659L373,326@14045L170");
                if (z) {
                    Boolean valueOf = Boolean.valueOf(z2);
                    final MutableInteractionSource mutableInteractionSource = interactionSource;
                    composer.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed = composer.changed(snapshotState2) | composer.changed(mutableInteractionSource);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final SnapshotState<PressInteraction.Press> snapshotState3 = snapshotState2;
                                final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        PressInteraction.Press press = (PressInteraction.Press) SnapshotState.this.getValue();
                                        if (press != null) {
                                            mutableInteractionSource2.tryEmit(new PressInteraction.Cancel(press));
                                            SnapshotState.this.setValue(null);
                                        }
                                    }
                                };
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    EffectsKt.DisposableEffect(valueOf, (Function1) rememberedValue3, composer, 0);
                    Clickable.PressedInteractionSourceDisposableEffect(interactionSource, snapshotState2, map2, composer, 560);
                }
                composer.endReplaceableGroup();
                final Functions<Boolean> isComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceableGroup();
                final SnapshotState snapshotState3 = (SnapshotState) rememberedValue4;
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed2 = composer.changed(snapshotState3) | composer.changed(isComposeRootInScrollableContainer);
                Object rememberedValue5 = composer.rememberedValue();
                if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = (Functions) new Functions<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Functions
                        public final Boolean invoke() {
                            return Boolean.valueOf(snapshotState3.getValue().booleanValue() || isComposeRootInScrollableContainer.invoke().booleanValue());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceableGroup();
                State rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(rememberedValue5, composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2608boximpl(Offset.Companion.m2635getZeroF1C5BW0()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceableGroup();
                SnapshotState snapshotState4 = (SnapshotState) rememberedValue6;
                Modifier.Companion companion2 = Modifier.Companion;
                Object[] objArr2 = {interactionSource, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z)};
                MutableInteractionSource mutableInteractionSource2 = interactionSource;
                Object[] objArr3 = {snapshotState4, Boolean.valueOf(z3), Boolean.valueOf(z), rememberUpdatedState3, Boolean.valueOf(z2), rememberUpdatedState2, mutableInteractionSource2, snapshotState2, rememberUpdatedState4, rememberUpdatedState};
                boolean z4 = z;
                composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                int i2 = 0;
                boolean z5 = false;
                for (int i3 = 10; i2 < i3; i3 = 10) {
                    z5 |= composer.changed(objArr3[i2]);
                    i2++;
                }
                Object rememberedValue7 = composer.rememberedValue();
                if (z5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    objArr = objArr2;
                    map = map2;
                    companion = companion2;
                    snapshotState = snapshotState3;
                    str3 = "CC(remember):Composables.kt#9igjgp";
                    rememberedValue7 = (Function2) new ClickableKt$combinedClickable$4$gesture$1$1(snapshotState4, z3, z4, z2, rememberUpdatedState3, rememberUpdatedState2, mutableInteractionSource2, snapshotState2, rememberUpdatedState4, rememberUpdatedState, null);
                    composer.updateRememberedValue(rememberedValue7);
                } else {
                    map = map2;
                    companion = companion2;
                    snapshotState = snapshotState3;
                    str3 = "CC(remember):Composables.kt#9igjgp";
                    objArr = objArr2;
                }
                composer.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7);
                Modifier.Companion companion3 = Modifier.Companion;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, str3);
                Object rememberedValue8 = composer.rememberedValue();
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.compose.p002ui.modifier.ModifierLocalConsumer
                        public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
                            Intrinsics.checkNotNullParameter(scope, "scope");
                            snapshotState.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue8);
                }
                composer.endReplaceableGroup();
                Modifier then = companion3.then((Modifier) rememberedValue8);
                MutableInteractionSource mutableInteractionSource3 = interactionSource;
                Indication indication2 = indication;
                composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, str3);
                Object rememberedValue9 = composer.rememberedValue();
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue9 = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue9).getCoroutineScope();
                composer.endReplaceableGroup();
                Modifier m482genericClickableWithoutGesturebdNGguI = Clickable.m482genericClickableWithoutGesturebdNGguI(then, pointerInput, mutableInteractionSource3, indication2, coroutineScope, map, snapshotState4, z, str, role, str2, functions, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m482genericClickableWithoutGesturebdNGguI;
            }
        });
    }
}
