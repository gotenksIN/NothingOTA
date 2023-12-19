package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.appcompat.R;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.nothing.OfflineOTAUpgradeApp.state.DialogInfo;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageCurrentVersionContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageDownloadContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageLookingVersionContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageReadyInstallOTAContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageReadyToDownloadContentKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageUpToDateContentKt;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatingScreen.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aE\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a)\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a+\u0010\u001d\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001e¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"StageCurrentVersionPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "StageDownloadPausedContentPreview", "StageDownloadingContentPreview", "StageInstallingPreview", "StageLookingVersionPreview", "StageReadyInstallOTAPreview", "StageReadyToDownload", "StageReadyToInstallDownloadedContentPreview", "StageStageReadyToDownloadPreview", "StageUpToDatePreview", "UpdatingFooter", "modifier", "Landroidx/compose/ui/Modifier;", "stage", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "lockActions", "", "onFirstButtonClick", "Lkotlin/Function0;", "onSecondButtonClick", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "UpdatingScreen", "onClickUpdate", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "viewModel", "Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;", "(Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;Landroidx/compose/runtime/Composer;II)V", "UpdatingStageContent", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NothingOfflineOtaUpdate_nothingRelease", "showCancelInstallConfirmation", "showInstallSuccess", "showInstallError", "showCheckUpdateFail", "showDownloadError", "", "showCancelDownloadConfirmation", "showCheckDownloadWithCellular", "showScreenState", "showUnauthorizedUserTips"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatingScreenKt {
    public static final void UpdatingScreen(OTAUpdateViewModel oTAUpdateViewModel, Modifier modifier, final UpdateStage stage, Composer composer, final int i, final int i2) {
        Object obj;
        OTAUpdateViewModel oTAUpdateViewModel2;
        Modifier.Companion companion;
        int i3;
        final OTAUpdateViewModel oTAUpdateViewModel3;
        CreationExtras.Empty empty;
        final OTAUpdateViewModel oTAUpdateViewModel4;
        Composer composer2;
        int i4;
        final OTAUpdateViewModel oTAUpdateViewModel5;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(stage, "stage");
        Composer startRestartGroup = composer.startRestartGroup(1079834961);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdatingScreen)P(2)");
        int i5 = i2 & 1;
        int i6 = i5 != 0 ? i | 2 : i;
        int i7 = i2 & 2;
        if (i7 != 0) {
            i6 |= 48;
            obj = modifier;
        } else {
            obj = modifier;
            if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
                i6 |= startRestartGroup.changed(obj) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i6 |= 384;
        } else if ((i & 896) == 0) {
            i6 |= startRestartGroup.changed(stage) ? 256 : 128;
        }
        int i8 = i6;
        if (i5 != 1 || (i8 & 731) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    startRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        empty = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        empty = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel(OTAUpdateViewModel.class, current, null, null, empty, startRestartGroup, 36936, 0);
                    startRestartGroup.endReplaceableGroup();
                    oTAUpdateViewModel2 = (OTAUpdateViewModel) viewModel;
                    i8 &= -15;
                } else {
                    oTAUpdateViewModel2 = oTAUpdateViewModel;
                }
                companion = i7 != 0 ? Modifier.Companion : obj;
                i3 = i8;
                oTAUpdateViewModel3 = oTAUpdateViewModel2;
            } else {
                startRestartGroup.skipToGroupEnd();
                if (i5 != 0) {
                    i8 &= -15;
                }
                companion = obj;
                i3 = i8;
                oTAUpdateViewModel3 = oTAUpdateViewModel;
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1079834961, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreen (UpdatingScreen.kt:43)");
            }
            State observeAsState = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowCancelInstallConfirmationLive(), false, startRestartGroup, 56);
            State observeAsState2 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowInstallSuccessLive(), false, startRestartGroup, 56);
            State observeAsState3 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowInstallErrorLive(), false, startRestartGroup, 56);
            State observeAsState4 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowCheckUpdateFailLive(), false, startRestartGroup, 56);
            State observeAsState5 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowDownloadErrorLive(), false, startRestartGroup, 56);
            State observeAsState6 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowCancelDownloadConfirmationLive(), false, startRestartGroup, 56);
            State observeAsState7 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowCheckDownloadWithCellularLive(), false, startRestartGroup, 56);
            State observeAsState8 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowScreenStageLive(), false, startRestartGroup, 56);
            State observeAsState9 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getLockActionsLive(), false, startRestartGroup, 56);
            State observeAsState10 = LiveDataAdapterKt.observeAsState(oTAUpdateViewModel3.getShowUnauthorizedUserTipsLive(), false, startRestartGroup, 56);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            UpdatingScreen(BackgroundKt.m152backgroundbw27NRU$default(companion, ColorResources_androidKt.colorResource(com.nothing.OfflineOTAUpgradeApp.R.color.updating_screen_background, startRestartGroup, 6), null, 2, null), stage, UpdatingScreen$lambda$8(observeAsState9), new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    OTAUpdateViewModel.this.clickFirstButton();
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    OTAUpdateViewModel.this.clickSecondButton();
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    OTAUpdateViewModel.this.installOTAFile();
                }
            }, startRestartGroup, (i3 >> 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 0);
            startRestartGroup.startReplaceableGroup(483929372);
            if (UpdatingScreen$lambda$7(observeAsState8)) {
                i4 = 0;
                oTAUpdateViewModel4 = oTAUpdateViewModel3;
                composer2 = startRestartGroup;
                TextKt.m1484Text4IGK_g(stage.toString(), PaddingKt.m415padding3ABfNKs(BackgroundKt.m152backgroundbw27NRU$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Color.Companion.m2590getRed0d7_KjU(), null, 2, null), Dp.m5050constructorimpl(10)), ColorResources_androidKt.colorResource(com.nothing.OfflineOTAUpgradeApp.R.color.debug_stage_text, startRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, StylesKt.getDebugStageStyle(), composer2, 0, 1572864, 65528);
            } else {
                oTAUpdateViewModel4 = oTAUpdateViewModel3;
                composer2 = startRestartGroup;
                i4 = 0;
            }
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483929774);
            if (UpdatingScreen$lambda$0(observeAsState)) {
                InstallResultDialogKt.InstallCancelConfirmationDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelInstallConfirmation(false);
                        OTAUpdateViewModel.this.cancelInstallation();
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$3
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelInstallConfirmation(false);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$4
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelInstallConfirmation(false);
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483930235);
            if (UpdatingScreen$lambda$1(observeAsState2)) {
                InstallResultDialogKt.InstallSuccessDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$5
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showInstallSuccessDialog(false);
                        OTAUpdateViewModel.this.installOTAFileSuccess(true);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$6
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showInstallSuccessDialog(false);
                        OTAUpdateViewModel.this.installOTAFileSuccess(false);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$7
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showInstallSuccessDialog(false);
                        OTAUpdateViewModel.this.installOTAFileSuccess(false);
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483930785);
            if (UpdatingScreen$lambda$2(observeAsState3)) {
                InstallResultDialogKt.InstallFailureDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$8
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showInstallFailDialog(false);
                        OTAUpdateViewModel.this.installOTAFileFail();
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$9
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showInstallFailDialog(false);
                        OTAUpdateViewModel.this.installOTAFileFail();
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483931152);
            if (UpdatingScreen$lambda$3(observeAsState4)) {
                DownloadOTADialogKt.CheckUpdateFailDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$10
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCheckUpdateFailDialog(false);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$11
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCheckUpdateFailDialog(false);
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483931435);
            if (observeAsState5.getValue() instanceof DialogInfo.DialogBundle) {
                Object value = observeAsState5.getValue();
                DialogInfo.DialogBundle dialogBundle = value instanceof DialogInfo.DialogBundle ? (DialogInfo.DialogBundle) value : null;
                if (dialogBundle != null) {
                    DownloadOTADialogKt.DownloadFailDialog(dialogBundle, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$12$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            OTAUpdateViewModel.this.showDownloadErrorDialog(false);
                        }
                    }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$12$2
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            OTAUpdateViewModel.this.showDownloadErrorDialog(false);
                        }
                    }, composer2, 8);
                }
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483931898);
            if (UpdatingScreen$lambda$5(observeAsState6)) {
                DownloadOTADialogKt.StopDownloadConfirmationDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$13
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelDownloadConfirmationDialog(false);
                        OTAUpdateViewModel.this.cancelDownload();
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$14
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelDownloadConfirmationDialog(false);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$15
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCancelDownloadConfirmationDialog(false);
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(483932385);
            if (UpdatingScreen$lambda$6(observeAsState7)) {
                DownloadOTADialogKt.CheckDownloadWithCellularDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$16
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCheckDownloadWithCellularDialog(false);
                        OTAUpdateViewModel.this.onCallForDownload(true);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$17
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCheckDownloadWithCellularDialog(false);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$18
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.showCheckDownloadWithCellularDialog(false);
                    }
                }, composer2, i4);
            }
            composer2.endReplaceableGroup();
            if (UpdatingScreen$lambda$9(observeAsState10)) {
                UnauthorizedUserTipsDialogKt.UnauthorizedUserTipsDialog(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$19
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.setFinishActivity(true);
                    }
                }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$20
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        OTAUpdateViewModel.this.setFinishActivity(true);
                    }
                }, composer2, i4);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            oTAUpdateViewModel5 = oTAUpdateViewModel4;
            modifier2 = companion;
        } else {
            startRestartGroup.skipToGroupEnd();
            oTAUpdateViewModel5 = oTAUpdateViewModel;
            modifier2 = obj;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingScreen$21
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i9) {
                UpdatingScreenKt.UpdatingScreen(OTAUpdateViewModel.this, modifier2, stage, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void UpdatingScreen(androidx.compose.ui.Modifier r22, final com.nothing.OfflineOTAUpgradeApp.state.UpdateStage r23, boolean r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, final kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt.UpdatingScreen(androidx.compose.ui.Modifier, com.nothing.OfflineOTAUpgradeApp.state.UpdateStage, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void UpdatingStageContent(final Modifier modifier, final UpdateStage stage, final Function0<Unit> onClickUpdate, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(onClickUpdate, "onClickUpdate");
        Composer startRestartGroup = composer.startRestartGroup(995510961);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdatingStageContent)P(!1,2)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(stage) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickUpdate) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(995510961, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingStageContent (UpdatingScreen.kt:242)");
            }
            if (stage instanceof UpdateStage.StageCurrentVersion) {
                startRestartGroup.startReplaceableGroup(51669437);
                StageCurrentVersionContentKt.StageCurrentVersionContent(modifier, (UpdateStage.StageCurrentVersion) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyInstallOTA) {
                startRestartGroup.startReplaceableGroup(51669552);
                StageReadyInstallOTAContentKt.StageReadyInstallOTAContent(modifier, (UpdateStage.StageReadyInstallOTA) stage, onClickUpdate, startRestartGroup, (i2 & 14) | (i2 & 896), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallingRunning) {
                startRestartGroup.startReplaceableGroup(51669685);
                StageInstallingContentKt.StageInstallingRunningContent(modifier, (UpdateStage.StageInstallingRunning) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallingPaused) {
                startRestartGroup.startReplaceableGroup(51669833);
                StageInstallingContentKt.StageInstallingPausedContent(modifier, (UpdateStage.StageInstallingPaused) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageLookingVersion) {
                startRestartGroup.startReplaceableGroup(51669978);
                StageLookingVersionContentKt.StageLookingVersionContent(modifier, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageUpToDate) {
                startRestartGroup.startReplaceableGroup(51670090);
                StageUpToDateContentKt.StageUpToDateContent(modifier, (UpdateStage.StageUpToDate) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallComplete) {
                startRestartGroup.startReplaceableGroup(51670218);
                StageInstallingContentKt.StageInstallingCompleteContent(modifier, (UpdateStage.StageInstallComplete) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyToDownload) {
                startRestartGroup.startReplaceableGroup(51670366);
                StageReadyToDownloadContentKt.StageReadyToDownloadContent(modifier, (UpdateStage.StageReadyToDownload) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageDownloading) {
                startRestartGroup.startReplaceableGroup(51670497);
                StageDownloadContentKt.StageDownloadingContent(modifier, (UpdateStage.StageDownloading) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageDownloadPaused) {
                startRestartGroup.startReplaceableGroup(51670627);
                StageDownloadContentKt.StageDownloadPausedContent(modifier, (UpdateStage.StageDownloadPaused) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyInstallDownloaded) {
                startRestartGroup.startReplaceableGroup(51670768);
                StageDownloadContentKt.StageReadyToInstallDownloadedContent(modifier, (UpdateStage.StageReadyInstallDownloaded) stage, startRestartGroup, i2 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(51670881);
                startRestartGroup.endReplaceableGroup();
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$UpdatingStageContent$1
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

            public final void invoke(Composer composer2, int i3) {
                UpdatingScreenKt.UpdatingStageContent(Modifier.this, stage, onClickUpdate, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void UpdatingFooter(androidx.compose.ui.Modifier r32, final com.nothing.OfflineOTAUpgradeApp.state.UpdateStage r33, boolean r34, final kotlin.jvm.functions.Function0<kotlin.Unit> r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 911
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt.UpdatingFooter(androidx.compose.ui.Modifier, com.nothing.OfflineOTAUpgradeApp.state.UpdateStage, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void StageCurrentVersionPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(309345531);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageCurrentVersionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(309345531, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageCurrentVersionPreview (UpdatingScreen.kt:337)");
            }
            UpdatingScreen(null, new UpdateStage.StageCurrentVersion("Pong-U2.5-230824-0012"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$4
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
                UpdatingScreenKt.StageCurrentVersionPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyToDownload(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1752540062);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyToDownload)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752540062, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyToDownload (UpdatingScreen.kt:348)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyToDownload("Pong-U2.5-230824-0012", "2.6 GB"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$4
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
                UpdatingScreenKt.StageReadyToDownload(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyInstallOTAPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-130150272);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyInstallOTAPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-130150272, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyInstallOTAPreview (UpdatingScreen.kt:362)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyInstallOTA("Pong-U2.5-230824-0012", "Pong-U2.5-230824-0012"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$4
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
                UpdatingScreenKt.StageReadyInstallOTAPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageInstallingPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-358753213);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358753213, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageInstallingPreview (UpdatingScreen.kt:375)");
            }
            UpdatingScreen(null, new UpdateStage.StageInstallingRunning("Pong-U2.5-230824-0012", 0.45d), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$4
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
                UpdatingScreenKt.StageInstallingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageLookingVersionPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2090262703);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageLookingVersionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2090262703, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageLookingVersionPreview (UpdatingScreen.kt:389)");
            }
            UpdatingScreen(null, UpdateStage.StageLookingVersion.INSTANCE, false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224304, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$4
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
                UpdatingScreenKt.StageLookingVersionPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageUpToDatePreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1319714464);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageUpToDatePreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319714464, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageUpToDatePreview (UpdatingScreen.kt:400)");
            }
            UpdatingScreen(null, new UpdateStage.StageUpToDate("Pong-U2.5-230824-0012"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$4
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
                UpdatingScreenKt.StageUpToDatePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageStageReadyToDownloadPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-479574876);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageStageReadyToDownloadPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-479574876, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageStageReadyToDownloadPreview (UpdatingScreen.kt:413)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyToDownload("Pong-U2.5-230824-0012", "2.6 GB"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$4
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
                UpdatingScreenKt.StageStageReadyToDownloadPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageDownloadingContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2137048933);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageDownloadingContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2137048933, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageDownloadingContentPreview (UpdatingScreen.kt:427)");
            }
            UpdatingScreen(null, new UpdateStage.StageDownloading("Pong-U2.5-230824-0012", 0.16d), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$4
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
                UpdatingScreenKt.StageDownloadingContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageDownloadPausedContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(2107974975);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageDownloadPausedContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2107974975, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageDownloadPausedContentPreview (UpdatingScreen.kt:441)");
            }
            UpdatingScreen(null, new UpdateStage.StageDownloadPaused("Pong-U2.5-230824-0012", 0.16d), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$4
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
                UpdatingScreenKt.StageDownloadPausedContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyToInstallDownloadedContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1299296529);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyToInstallDownloadedContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1299296529, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyToInstallDownloadedContentPreview (UpdatingScreen.kt:455)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyInstallDownloaded("Pong-U2.5-230824-0012"), false, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 224256, 5);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$4
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
                UpdatingScreenKt.StageReadyToInstallDownloadedContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final boolean UpdatingScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean UpdatingScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
