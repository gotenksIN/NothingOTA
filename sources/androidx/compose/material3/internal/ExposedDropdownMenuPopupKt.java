package androidx.compose.material3.internal;

import android.view.View;
import androidx.appcompat.R;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenuPopup.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0083\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);

    public static final void ExposedDropdownMenuPopup(Function0<Unit> function0, final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        final LayoutDirection layoutDirection;
        final String str;
        String str2;
        final Function0<Unit> function02;
        int i4;
        Composer composer2;
        PopupLayout popupLayout;
        final Function0<Unit> function03;
        Intrinsics.checkNotNullParameter(popupPositionProvider, "popupPositionProvider");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(187306684);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuPopup)P(1,2)85@3437L7,86@3476L7,87@3520L7,88@3575L7,89@3611L28,90@3666L29,91@3714L38,92@3775L907,119@4688L380,133@5074L192,141@5272L166,150@5616L647:ExposedDropdownMenuPopup.kt#mqatfk");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            obj = function0;
        } else if ((i & 14) == 0) {
            Object obj2 = function0;
            i3 = (startRestartGroup.changedInstance(obj2) ? 4 : 2) | i;
            obj = obj2;
        } else {
            obj = function0;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(popupPositionProvider) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        int i6 = i3;
        if ((i6 & 731) != 146 || !startRestartGroup.getSkipping()) {
            Object obj3 = i5 != 0 ? null : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(187306684, i6, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.kt:80)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(LocalPopupTestTag);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String str3 = (String) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, startRestartGroup, (i6 >> 6) & 14);
            UUID popupId = (UUID) RememberSaveableKt.m2208rememberSaveable(new Object[0], (Saver<Object, ? extends Object>) null, (String) null, (Function0<? extends Object>) new Function0<UUID>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, startRestartGroup, 3080, 6);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(popupId, "popupId");
                layoutDirection = layoutDirection2;
                str = str3;
                str2 = "CC:CompositionLocal.kt#9igjgp";
                function02 = obj3;
                i4 = i6;
                composer2 = startRestartGroup;
                final PopupLayout popupLayout2 = new PopupLayout(obj3, str, view, density, popupPositionProvider, popupId);
                popupLayout2.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(686046343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i7) {
                        ComposerKt.sourceInformation(composer3, "C102@4119L533:ExposedDropdownMenuPopup.kt#mqatfk");
                        if ((i7 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(686046343, i7, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:101)");
                            }
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.popup(semantics);
                                }
                            }, 1, null);
                            final PopupLayout popupLayout3 = PopupLayout.this;
                            Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m1610invokeozmzZPI(intSize.m5214unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-ozmzZPI  reason: not valid java name */
                                public final void m1610invokeozmzZPI(long j) {
                                    PopupLayout.this.m1612setPopupContentSizefhxjrPA(IntSize.m5202boximpl(j));
                                    PopupLayout.this.updatePosition();
                                }
                            }), PopupLayout.this.getCanCalculatePosition() ? 1.0f : 0.0f);
                            final State<Function2<Composer, Integer, Unit>> state = rememberUpdatedState;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, 588819933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i8) {
                                    Function2 ExposedDropdownMenuPopup$lambda$0;
                                    ComposerKt.sourceInformation(composer4, "C113@4618L16:ExposedDropdownMenuPopup.kt#mqatfk");
                                    if ((i8 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(588819933, i8, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:112)");
                                    }
                                    ExposedDropdownMenuPopup$lambda$0 = ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup$lambda$0(state);
                                    ExposedDropdownMenuPopup$lambda$0.invoke(composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            composer3.startReplaceableGroup(-483170785);
                            ComposerKt.sourceInformation(composer3, "CC(SimpleStack)P(1)179@6807L979:ExposedDropdownMenuPopup.kt#mqatfk");
                            ExposedDropdownMenuPopupKt$SimpleStack$1 exposedDropdownMenuPopupKt$SimpleStack$1 = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume5 = composer3.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density2 = (Density) consume5;
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume6 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            LayoutDirection layoutDirection3 = (LayoutDirection) consume6;
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume7 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) consume7;
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(alpha);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m2195constructorimpl = Updater.m2195constructorimpl(composer3);
                            Updater.m2202setimpl(m2195constructorimpl, exposedDropdownMenuPopupKt$SimpleStack$1, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m2202setimpl(m2195constructorimpl, density2, ComposeUiNode.Companion.getSetDensity());
                            Updater.m2202setimpl(m2195constructorimpl, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            composableLambda.invoke(composer3, 6);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }));
                composer2.updateRememberedValue(popupLayout2);
                popupLayout = popupLayout2;
            } else {
                layoutDirection = layoutDirection2;
                str = str3;
                str2 = "CC:CompositionLocal.kt#9igjgp";
                function02 = obj3;
                i4 = i6;
                composer2 = startRestartGroup;
                popupLayout = rememberedValue;
            }
            composer2.endReplaceableGroup();
            final PopupLayout popupLayout3 = (PopupLayout) popupLayout;
            EffectsKt.DisposableEffect(popupLayout3, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    PopupLayout.this.show();
                    PopupLayout.this.updateParameters(function02, str, layoutDirection);
                    final PopupLayout popupLayout4 = PopupLayout.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            PopupLayout.this.disposeComposition();
                            PopupLayout.this.dismiss();
                        }
                    };
                }
            }, composer2, 8);
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PopupLayout.this.updateParameters(function02, str, layoutDirection);
                }
            }, composer2, 0);
            EffectsKt.DisposableEffect(popupPositionProvider, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    PopupLayout.this.setPositionProvider(popupPositionProvider);
                    PopupLayout.this.updatePosition();
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            }, composer2, (i4 >> 3) & 14);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates childCoordinates) {
                    Intrinsics.checkNotNullParameter(childCoordinates, "childCoordinates");
                    LayoutCoordinates parentLayoutCoordinates = childCoordinates.getParentLayoutCoordinates();
                    Intrinsics.checkNotNull(parentLayoutCoordinates);
                    long mo4080getSizeYbymL2g = parentLayoutCoordinates.mo4080getSizeYbymL2g();
                    long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
                    PopupLayout.this.setParentBounds(IntRectKt.m5200IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2318getXimpl(positionInWindow)), MathKt.roundToInt(Offset.m2319getYimpl(positionInWindow))), mo4080getSizeYbymL2g));
                    PopupLayout.this.updatePosition();
                }
            });
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo12measure3p2s80s(MeasureScope Layout, List<? extends Measurable> list, long j) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                    PopupLayout.this.setParentLayoutDirection(layoutDirection);
                    return MeasureScope.layout$default(Layout, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
            };
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume5 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density2 = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume6 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume7 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(onGloballyPositioned);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m2195constructorimpl = Updater.m2195constructorimpl(composer2);
            Updater.m2202setimpl(m2195constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 571475810, "C:ExposedDropdownMenuPopup.kt#mqatfk");
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function03 = function02;
        } else {
            startRestartGroup.skipToGroupEnd();
            function03 = obj;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i7) {
                ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(function03, popupPositionProvider, content, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(-483170785);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)179@6807L979:ExposedDropdownMenuPopup.kt#mqatfk");
        ExposedDropdownMenuPopupKt$SimpleStack$1 exposedDropdownMenuPopupKt$SimpleStack$1 = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i2 = (((((i << 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m2195constructorimpl = Updater.m2195constructorimpl(composer);
        Updater.m2202setimpl(m2195constructorimpl, exposedDropdownMenuPopupKt$SimpleStack$1, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer)), composer, Integer.valueOf((i2 >> 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
