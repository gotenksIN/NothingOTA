package androidx.compose.foundation.text.selection;

import androidx.appcompat.R;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionContainer.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionContainerKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    public static final void SelectionContainer(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1075498320);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1)42@1737L45,46@1895L38,43@1787L180:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075498320, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:41)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            Selection SelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                        invoke2(selection);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Selection selection) {
                        mutableState.setValue(selection);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionContainer(modifier, SelectionContainer$lambda$1, rememberedValue2, content, startRestartGroup, (i3 & 14) | ((i3 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                SelectionContainerKt.SelectionContainer(Modifier.this, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(336063542);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableSelection)61@2258L104:SelectionContainer.kt#eksfi3");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:60)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null)}, content, startRestartGroup, ((i2 << 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                SelectionContainerKt.DisableSelection(content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void SelectionContainer(Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> onSelectionChange, final Function2<? super Composer, ? super Integer, Unit> children, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(onSelectionChange, "onSelectionChange");
        Intrinsics.checkNotNullParameter(children, "children");
        Composer startRestartGroup = composer.startRestartGroup(2078139907);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1,3,2)84@2963L37,85@3019L44,87@3114L7,88@3175L7,89@3226L7,94@3361L1952,137@5319L106:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(onSelectionChange) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(children) ? 2048 : 1024;
        }
        final int i5 = i3;
        if ((i5 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i5, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:75)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SelectionRegistrarImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final SelectionManager selectionManager = (SelectionManager) rememberedValue2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) consume);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setClipboardManager((ClipboardManager) consume2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) consume3);
            selectionManager.setOnSelectionChange(onSelectionChange);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            final Modifier modifier2 = modifier;
            ContextMenu_androidKt.ContextMenuArea(selectionManager, ComposableLambdaKt.composableLambda(startRestartGroup, -123806316, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C95@3396L1911:SelectionContainer.kt#eksfi3");
                    if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-123806316, i6, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:94)");
                        }
                        ProvidedValue[] providedValueArr = {SelectionRegistrarKt.getLocalSelectionRegistrar().provides(SelectionRegistrarImpl.this)};
                        final Modifier modifier3 = modifier2;
                        final SelectionManager selectionManager2 = selectionManager;
                        final Function2<Composer, Integer, Unit> function2 = children;
                        final int i7 = i5;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.composableLambda(composer2, 935424596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3.1
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

                            public final void invoke(Composer composer3, int i8) {
                                ComposerKt.sourceInformation(composer3, "C98@3620L1677:SelectionContainer.kt#eksfi3");
                                if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(935424596, i8, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:95)");
                                    }
                                    Modifier then = Modifier.this.then(selectionManager2.getModifier());
                                    final Function2<Composer, Integer, Unit> function22 = function2;
                                    final int i9 = i7;
                                    final SelectionManager selectionManager3 = selectionManager2;
                                    SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer3, 1375295262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.3.1.1
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

                                        public final void invoke(Composer composer4, int i10) {
                                            Selection selection2;
                                            Offset m850getEndHandlePosition_m7T9E;
                                            ResolvedTextDirection direction;
                                            ComposerKt.sourceInformation(composer4, "C99@3695L10,*103@3926L129,119@4623L564:SelectionContainer.kt#eksfi3");
                                            if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1375295262, i10, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:98)");
                                                }
                                                function22.invoke(composer4, Integer.valueOf((i9 >> 9) & 14));
                                                if (TouchMode_androidKt.isInTouchMode() && selectionManager3.getHasFocus() && (selection2 = selectionManager3.getSelection()) != null) {
                                                    SelectionManager selectionManager4 = selectionManager3;
                                                    List listOf = CollectionsKt.listOf((Object[]) new Boolean[]{true, false});
                                                    int size = listOf.size();
                                                    for (int i11 = 0; i11 < size; i11++) {
                                                        boolean booleanValue = ((Boolean) listOf.get(i11)).booleanValue();
                                                        Boolean valueOf = Boolean.valueOf(booleanValue);
                                                        composer4.startReplaceableGroup(1157296644);
                                                        ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                                        boolean changed = composer4.changed(valueOf);
                                                        Object rememberedValue3 = composer4.rememberedValue();
                                                        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                            rememberedValue3 = selectionManager4.handleDragObserver(booleanValue);
                                                            composer4.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        TextDragObserver textDragObserver = (TextDragObserver) rememberedValue3;
                                                        if (booleanValue) {
                                                            m850getEndHandlePosition_m7T9E = selectionManager4.m851getStartHandlePosition_m7T9E();
                                                        } else {
                                                            m850getEndHandlePosition_m7T9E = selectionManager4.m850getEndHandlePosition_m7T9E();
                                                        }
                                                        if (booleanValue) {
                                                            direction = selection2.getStart().getDirection();
                                                        } else {
                                                            direction = selection2.getEnd().getDirection();
                                                        }
                                                        if (m850getEndHandlePosition_m7T9E != null) {
                                                            AndroidSelectionHandles_androidKt.m802SelectionHandle8fL75g(m850getEndHandlePosition_m7T9E.m2328unboximpl(), booleanValue, direction, selection2.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, textDragObserver, new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, null)), null, composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                        }
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 56);
            EffectsKt.DisposableEffect(selectionManager, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final SelectionManager selectionManager2 = SelectionManager.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            SelectionManager.this.hideSelectionToolbar$foundation_release();
                        }
                    };
                }
            }, startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier3 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                SelectionContainerKt.SelectionContainer(Modifier.this, selection, onSelectionChange, children, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
