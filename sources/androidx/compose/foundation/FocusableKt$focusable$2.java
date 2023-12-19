package androidx.compose.foundation;

import androidx.appcompat.C0032R;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.focus.FocusChangedModifierKt;
import androidx.compose.p002ui.focus.FocusModifier;
import androidx.compose.p002ui.focus.FocusRequester;
import androidx.compose.p002ui.focus.FocusRequesterModifierKt;
import androidx.compose.p002ui.focus.FocusState;
import androidx.compose.p002ui.layout.PinnableContainer;
import androidx.compose.p002ui.layout.PinnableContainerKt;
import androidx.compose.p002ui.semantics.SemanticsModifierKt;
import androidx.compose.p002ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p002ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Focusable.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m40d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class FocusableKt$focusable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusableKt$focusable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        Modifier.Companion companion;
        Modifier.Companion companion2;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceableGroup(1871352361);
        ComposerKt.sourceInformation(composer, "C68@2856L24,69@2910L58,70@2990L34,71@3050L29,83@3823L37,84@3901L280,84@3865L316,93@4186L390,116@5029L7,117@5062L66,118@5173L215,118@5137L251,129@5430L185:Focusable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1871352361, i, -1, "androidx.compose.foundation.focusable.<anonymous> (Focusable.kt:67)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final SnapshotState snapshotState = (SnapshotState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        final SnapshotState snapshotState2 = (SnapshotState) rememberedValue3;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new FocusRequester();
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        final FocusRequester focusRequester = (FocusRequester) rememberedValue4;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = BringIntoViewRequesterKt.BringIntoViewRequester();
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) rememberedValue5;
        final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer.changed(snapshotState) | composer.changed(mutableInteractionSource);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed || rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final SnapshotState<FocusInteraction.Focus> snapshotState3 = snapshotState;
                    final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            FocusInteraction.Focus focus = (FocusInteraction.Focus) SnapshotState.this.getValue();
                            if (focus != null) {
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
                                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                if (mutableInteractionSource3 != null) {
                                    mutableInteractionSource3.tryEmit(unfocus);
                                }
                                SnapshotState.this.setValue(null);
                            }
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1) rememberedValue6, composer, 0);
        Boolean valueOf = Boolean.valueOf(this.$enabled);
        final boolean z = this.$enabled;
        final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        EffectsKt.DisposableEffect(valueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                if (!z) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01831(snapshotState, mutableInteractionSource2, null), 3, null);
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Focusable.kt */
            @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
            @DebugMetadata(m31c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", m30f = "Focusable.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_spinnerDropDownItemStyle}, m27m = "invokeSuspend", m26n = {}, m25s = {})
            /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1 */
            /* loaded from: classes.dex */
            public static final class C01831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SnapshotState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01831(SnapshotState<FocusInteraction.Focus> snapshotState, MutableInteractionSource mutableInteractionSource, Continuation<? super C01831> continuation) {
                    super(2, continuation);
                    this.$focusedInteraction = snapshotState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01831(this.$focusedInteraction, this.$interactionSource, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    SnapshotState<FocusInteraction.Focus> snapshotState;
                    SnapshotState<FocusInteraction.Focus> snapshotState2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                        if (value != null) {
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            snapshotState = this.$focusedInteraction;
                            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                            if (mutableInteractionSource != null) {
                                this.L$0 = snapshotState;
                                this.label = 1;
                                if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                snapshotState2 = snapshotState;
                            }
                            snapshotState.setValue(null);
                        }
                        return Unit.INSTANCE;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        snapshotState2 = (SnapshotState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    snapshotState = snapshotState2;
                    snapshotState.setValue(null);
                    return Unit.INSTANCE;
                }
            }
        }, composer, 0);
        if (this.$enabled) {
            composer.startReplaceableGroup(1407540673);
            ComposerKt.sourceInformation(composer, "108@4661L36");
            if (invoke$lambda$2(snapshotState2)) {
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new FocusedBoundsModifier();
                    composer.updateRememberedValue(rememberedValue7);
                }
                composer.endReplaceableGroup();
                companion2 = (Modifier) rememberedValue7;
            } else {
                companion2 = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(PinnableContainerKt.getLocalPinnableContainer());
            ComposerKt.sourceInformationMarkerEnd(composer);
            final PinnableContainer pinnableContainer = (PinnableContainer) consume;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue8);
            }
            composer.endReplaceableGroup();
            final SnapshotState snapshotState3 = (SnapshotState) rememberedValue8;
            composer.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed2 = composer.changed(snapshotState2) | composer.changed(snapshotState3) | composer.changed(pinnableContainer);
            Object rememberedValue9 = composer.rememberedValue();
            if (changed2 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        if (FocusableKt$focusable$2.invoke$lambda$2(snapshotState2)) {
                            SnapshotState<PinnableContainer.PinnedHandle> snapshotState4 = snapshotState3;
                            PinnableContainer pinnableContainer2 = PinnableContainer.this;
                            FocusableKt$focusable$2.invoke$lambda$10(snapshotState4, pinnableContainer2 != null ? pinnableContainer2.pin() : null);
                        }
                        final SnapshotState<PinnableContainer.PinnedHandle> snapshotState5 = snapshotState3;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                PinnableContainer.PinnedHandle invoke$lambda$9 = FocusableKt$focusable$2.invoke$lambda$9(SnapshotState.this);
                                if (invoke$lambda$9 != null) {
                                    invoke$lambda$9.release();
                                }
                                FocusableKt$focusable$2.invoke$lambda$10(SnapshotState.this, null);
                            }
                        };
                    }
                };
                composer.updateRememberedValue(rememberedValue9);
            }
            composer.endReplaceableGroup();
            EffectsKt.DisposableEffect(pinnableContainer, (Function1) rememberedValue9, composer, 0);
            Modifier.Companion companion3 = Modifier.Companion;
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed3 = composer.changed(snapshotState2) | composer.changed(focusRequester);
            Object rememberedValue10 = composer.rememberedValue();
            if (changed3 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$4$1
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
                        SemanticsPropertiesKt.setFocused(semantics, FocusableKt$focusable$2.invoke$lambda$2(snapshotState2));
                        final FocusRequester focusRequester2 = focusRequester;
                        final SnapshotState<Boolean> snapshotState4 = snapshotState2;
                        SemanticsPropertiesKt.requestFocus$default(semantics, null, new Functions<Boolean>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$4$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Functions
                            public final Boolean invoke() {
                                FocusRequester.this.requestFocus();
                                return Boolean.valueOf(FocusableKt$focusable$2.invoke$lambda$2(snapshotState4));
                            }
                        }, 1, null);
                    }
                };
                composer.updateRememberedValue(rememberedValue10);
            }
            composer.endReplaceableGroup();
            Modifier then = FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue10, 1, null), bringIntoViewRequester), focusRequester).then(companion2);
            final MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
            companion = FocusModifier.focusTarget(FocusChangedModifierKt.onFocusChanged(then, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FocusableKt$focusable$2.invoke$lambda$3(snapshotState2, it.isFocused());
                    if (!FocusableKt$focusable$2.invoke$lambda$2(snapshotState2)) {
                        PinnableContainer.PinnedHandle invoke$lambda$9 = FocusableKt$focusable$2.invoke$lambda$9(snapshotState3);
                        if (invoke$lambda$9 != null) {
                            invoke$lambda$9.release();
                        }
                        FocusableKt$focusable$2.invoke$lambda$10(snapshotState3, null);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01862(snapshotState, mutableInteractionSource3, null), 3, null);
                        return;
                    }
                    SnapshotState<PinnableContainer.PinnedHandle> snapshotState4 = snapshotState3;
                    PinnableContainer pinnableContainer2 = PinnableContainer.this;
                    FocusableKt$focusable$2.invoke$lambda$10(snapshotState4, pinnableContainer2 != null ? pinnableContainer2.pin() : null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01851(snapshotState, mutableInteractionSource3, bringIntoViewRequester, null), 3, null);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Focusable.kt */
                @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                @DebugMetadata(m31c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", m30f = "Focusable.kt", m29i = {1}, m28l = {147, 151, 154}, m27m = "invokeSuspend", m26n = {"interaction"}, m25s = {"L$0"})
                /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1 */
                /* loaded from: classes.dex */
                public static final class C01851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                    final /* synthetic */ SnapshotState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01851(SnapshotState<FocusInteraction.Focus> snapshotState, MutableInteractionSource mutableInteractionSource, BringIntoViewRequester bringIntoViewRequester, Continuation<? super C01851> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = snapshotState;
                        this.$interactionSource = mutableInteractionSource;
                        this.$bringIntoViewRequester = bringIntoViewRequester;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01851(this.$focusedInteraction, this.$interactionSource, this.$bringIntoViewRequester, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
                    /* JADX WARN: Removed duplicated region for block: B:29:0x0087 A[RETURN] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                        /*
                            r8 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r8.label
                            r2 = 3
                            r3 = 2
                            r4 = 1
                            r5 = 0
                            if (r1 == 0) goto L2f
                            if (r1 == r4) goto L27
                            if (r1 == r3) goto L1f
                            if (r1 != r2) goto L17
                            kotlin.ResultKt.throwOnFailure(r9)
                            goto L88
                        L17:
                            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r9.<init>(r0)
                            throw r9
                        L1f:
                            java.lang.Object r1 = r8.L$0
                            androidx.compose.foundation.interaction.FocusInteraction$Focus r1 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r1
                            kotlin.ResultKt.throwOnFailure(r9)
                            goto L73
                        L27:
                            java.lang.Object r1 = r8.L$0
                            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.SnapshotState) r1
                            kotlin.ResultKt.throwOnFailure(r9)
                            goto L55
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r9)
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r9 = r8.$focusedInteraction
                            java.lang.Object r9 = r9.getValue()
                            androidx.compose.foundation.interaction.FocusInteraction$Focus r9 = (androidx.compose.foundation.interaction.FocusInteraction.Focus) r9
                            if (r9 == 0) goto L59
                            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r8.$interactionSource
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r6 = r8.$focusedInteraction
                            androidx.compose.foundation.interaction.FocusInteraction$Unfocus r7 = new androidx.compose.foundation.interaction.FocusInteraction$Unfocus
                            r7.<init>(r9)
                            if (r1 == 0) goto L56
                            androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
                            r8.L$0 = r6
                            r8.label = r4
                            java.lang.Object r9 = r1.emit(r7, r8)
                            if (r9 != r0) goto L54
                            return r0
                        L54:
                            r1 = r6
                        L55:
                            r6 = r1
                        L56:
                            r6.setValue(r5)
                        L59:
                            androidx.compose.foundation.interaction.FocusInteraction$Focus r1 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
                            r1.<init>()
                            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r8.$interactionSource
                            if (r9 == 0) goto L73
                            r6 = r1
                            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                            r7 = r8
                            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                            r8.L$0 = r1
                            r8.label = r3
                            java.lang.Object r9 = r9.emit(r6, r7)
                            if (r9 != r0) goto L73
                            return r0
                        L73:
                            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r9 = r8.$focusedInteraction
                            r9.setValue(r1)
                            androidx.compose.foundation.relocation.BringIntoViewRequester r9 = r8.$bringIntoViewRequester
                            r1 = r8
                            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                            r8.L$0 = r5
                            r8.label = r2
                            java.lang.Object r9 = androidx.compose.foundation.relocation.BringIntoViewRequester.bringIntoView$default(r9, r5, r1, r4, r5)
                            if (r9 != r0) goto L88
                            return r0
                        L88:
                            kotlin.Unit r9 = kotlin.Unit.INSTANCE
                            return r9
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt$focusable$2.C01845.C01851.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Focusable.kt */
                @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                @DebugMetadata(m31c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", m30f = "Focusable.kt", m29i = {}, m28l = {162}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2 */
                /* loaded from: classes.dex */
                public static final class C01862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ SnapshotState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01862(SnapshotState<FocusInteraction.Focus> snapshotState, MutableInteractionSource mutableInteractionSource, Continuation<? super C01862> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = snapshotState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01862(this.$focusedInteraction, this.$interactionSource, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        SnapshotState<FocusInteraction.Focus> snapshotState;
                        SnapshotState<FocusInteraction.Focus> snapshotState2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                            if (value != null) {
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                snapshotState = this.$focusedInteraction;
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = snapshotState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    snapshotState2 = snapshotState;
                                }
                                snapshotState.setValue(null);
                            }
                            return Unit.INSTANCE;
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            snapshotState2 = (SnapshotState) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        snapshotState = snapshotState2;
                        snapshotState.setValue(null);
                        return Unit.INSTANCE;
                    }
                }
            }));
        } else {
            companion = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return companion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2(SnapshotState<Boolean> snapshotState) {
        return snapshotState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(SnapshotState<Boolean> snapshotState, boolean z) {
        snapshotState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PinnableContainer.PinnedHandle invoke$lambda$9(SnapshotState<PinnableContainer.PinnedHandle> snapshotState) {
        return snapshotState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$10(SnapshotState<PinnableContainer.PinnedHandle> snapshotState, PinnableContainer.PinnedHandle pinnedHandle) {
        snapshotState.setValue(pinnedHandle);
    }
}
