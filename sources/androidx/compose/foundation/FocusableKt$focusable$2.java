package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Focusable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
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
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue3;
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
        boolean changed = composer.changed(mutableState) | composer.changed(mutableInteractionSource);
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
                    final MutableState<FocusInteraction.Focus> mutableState3 = mutableState;
                    final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            FocusInteraction.Focus focus = (FocusInteraction.Focus) MutableState.this.getValue();
                            if (focus != null) {
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
                                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                if (mutableInteractionSource3 != null) {
                                    mutableInteractionSource3.tryEmit(unfocus);
                                }
                                MutableState.this.setValue(null);
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
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutableState, mutableInteractionSource2, null), 3, null);
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Focusable.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", f = "Focusable.kt", i = {}, l = {androidx.appcompat.R.styleable.AppCompatTheme_spinnerDropDownItemStyle}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$focusedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    MutableState<FocusInteraction.Focus> mutableState;
                    MutableState<FocusInteraction.Focus> mutableState2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                        if (value != null) {
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            mutableState = this.$focusedInteraction;
                            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                            if (mutableInteractionSource != null) {
                                this.L$0 = mutableState;
                                this.label = 1;
                                if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutableState2 = mutableState;
                            }
                            mutableState.setValue(null);
                        }
                        return Unit.INSTANCE;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        mutableState2 = (MutableState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    mutableState = mutableState2;
                    mutableState.setValue(null);
                    return Unit.INSTANCE;
                }
            }
        }, composer, 0);
        if (this.$enabled) {
            composer.startReplaceableGroup(1407540673);
            ComposerKt.sourceInformation(composer, "108@4661L36");
            if (invoke$lambda$2(mutableState2)) {
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
            final MutableState mutableState3 = (MutableState) rememberedValue8;
            composer.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed2 = composer.changed(mutableState2) | composer.changed(mutableState3) | composer.changed(pinnableContainer);
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
                        if (FocusableKt$focusable$2.invoke$lambda$2(mutableState2)) {
                            MutableState<PinnableContainer.PinnedHandle> mutableState4 = mutableState3;
                            PinnableContainer pinnableContainer2 = PinnableContainer.this;
                            FocusableKt$focusable$2.invoke$lambda$10(mutableState4, pinnableContainer2 != null ? pinnableContainer2.pin() : null);
                        }
                        final MutableState<PinnableContainer.PinnedHandle> mutableState5 = mutableState3;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                PinnableContainer.PinnedHandle invoke$lambda$9 = FocusableKt$focusable$2.invoke$lambda$9(MutableState.this);
                                if (invoke$lambda$9 != null) {
                                    invoke$lambda$9.release();
                                }
                                FocusableKt$focusable$2.invoke$lambda$10(MutableState.this, null);
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
            boolean changed3 = composer.changed(mutableState2) | composer.changed(focusRequester);
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
                        SemanticsPropertiesKt.setFocused(semantics, FocusableKt$focusable$2.invoke$lambda$2(mutableState2));
                        final FocusRequester focusRequester2 = focusRequester;
                        final MutableState<Boolean> mutableState4 = mutableState2;
                        SemanticsPropertiesKt.requestFocus$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$4$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                FocusRequester.this.requestFocus();
                                return Boolean.valueOf(FocusableKt$focusable$2.invoke$lambda$2(mutableState4));
                            }
                        }, 1, null);
                    }
                };
                composer.updateRememberedValue(rememberedValue10);
            }
            composer.endReplaceableGroup();
            Modifier then = FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue10, 1, null), bringIntoViewRequester), focusRequester).then(companion2);
            final MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
            companion = FocusModifierKt.focusTarget(FocusChangedModifierKt.onFocusChanged(then, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.5
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
                    FocusableKt$focusable$2.invoke$lambda$3(mutableState2, it.isFocused());
                    if (!FocusableKt$focusable$2.invoke$lambda$2(mutableState2)) {
                        PinnableContainer.PinnedHandle invoke$lambda$9 = FocusableKt$focusable$2.invoke$lambda$9(mutableState3);
                        if (invoke$lambda$9 != null) {
                            invoke$lambda$9.release();
                        }
                        FocusableKt$focusable$2.invoke$lambda$10(mutableState3, null);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(mutableState, mutableInteractionSource3, null), 3, null);
                        return;
                    }
                    MutableState<PinnableContainer.PinnedHandle> mutableState4 = mutableState3;
                    PinnableContainer pinnableContainer2 = PinnableContainer.this;
                    FocusableKt$focusable$2.invoke$lambda$10(mutableState4, pinnableContainer2 != null ? pinnableContainer2.pin() : null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutableState, mutableInteractionSource3, bringIntoViewRequester, null), 3, null);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Focusable.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", f = "Focusable.kt", i = {1}, l = {147, 151, 154}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"})
                /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1  reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                    final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, BringIntoViewRequester bringIntoViewRequester, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                        this.$bringIntoViewRequester = bringIntoViewRequester;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, this.$bringIntoViewRequester, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
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
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt$focusable$2.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Focusable.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", f = "Focusable.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2  reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$focusedInteraction, this.$interactionSource, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        MutableState<FocusInteraction.Focus> mutableState;
                        MutableState<FocusInteraction.Focus> mutableState2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            FocusInteraction.Focus value = this.$focusedInteraction.getValue();
                            if (value != null) {
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                mutableState = this.$focusedInteraction;
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    mutableState2 = mutableState;
                                }
                                mutableState.setValue(null);
                            }
                            return Unit.INSTANCE;
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            mutableState2 = (MutableState) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        mutableState = mutableState2;
                        mutableState.setValue(null);
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
    public static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PinnableContainer.PinnedHandle invoke$lambda$9(MutableState<PinnableContainer.PinnedHandle> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$10(MutableState<PinnableContainer.PinnedHandle> mutableState, PinnableContainer.PinnedHandle pinnedHandle) {
        mutableState.setValue(pinnedHandle);
    }
}
