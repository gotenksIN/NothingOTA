package com.nothing.OfflineOTAUpgradeApp.p007ui.compose;

import androidx.appcompat.C0032R;
import androidx.compose.p002ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageCurrentVersionContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageDownloadContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageInstallingContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageLookingVersionContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageReadyInstallOTAContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageReadyToDownloadContent;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.stage.StageUpToDateContent;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.state.UpdatingButtonStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aE\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a)\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a5\u0010\u001d\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001e¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u0012X\u008a\u0084\u0002"}, m40d2 = {"StageCurrentVersionPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "StageDownloadPausedContentPreview", "StageDownloadingContentPreview", "StageInstallingPreview", "StageLookingVersionPreview", "StageReadyInstallOTAPreview", "StageReadyToDownload", "StageReadyToInstallDownloadedContentPreview", "StageStageReadyToDownloadPreview", "StageUpToDatePreview", "UpdatingFooter", "modifier", "Landroidx/compose/ui/Modifier;", "stage", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "lockActions", "", "onFirstButtonClick", "Lkotlin/Function0;", "onSecondButtonClick", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "UpdatingScreen", "onClickUpdate", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "viewModel", "Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;", "(Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;Landroidx/compose/runtime/Composer;II)V", "UpdatingStageContent", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NothingOfflineOtaUpdate_nothingRelease", "showCancelInstallConfirmation", "showInstallSuccess", "showInstallError", "showCheckUpdateFail", "showDownloadError", "", "showCancelDownloadConfirmation", "showCheckDownloadWithCellular", "showScreenState", "showUnauthorizedUserTips", "showBuildTooOld"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt */
/* loaded from: classes2.dex */
public final class UpdatingScreen {
    /* JADX WARN: Removed duplicated region for block: B:101:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void UpdatingScreen(com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r46, androidx.compose.p002ui.Modifier r47, final com.nothing.OfflineOTAUpgradeApp.state.UpdateStage r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1157
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.p007ui.compose.UpdatingScreen.UpdatingScreen(com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel, androidx.compose.ui.Modifier, com.nothing.OfflineOTAUpgradeApp.state.UpdateStage, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void UpdatingScreen(androidx.compose.p002ui.Modifier r19, final com.nothing.OfflineOTAUpgradeApp.state.UpdateStage r20, boolean r21, final kotlin.jvm.functions.Functions<kotlin.Unit> r22, final kotlin.jvm.functions.Functions<kotlin.Unit> r23, final kotlin.jvm.functions.Functions<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.p007ui.compose.UpdatingScreen.UpdatingScreen(androidx.compose.ui.Modifier, com.nothing.OfflineOTAUpgradeApp.state.UpdateStage, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void UpdatingStageContent(final Modifier modifier, final UpdateStage stage, boolean z, final Functions<Unit> onClickUpdate, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(onClickUpdate, "onClickUpdate");
        Composer startRestartGroup = composer.startRestartGroup(1486368525);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdatingStageContent)P(1,3)");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(stage) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickUpdate) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                z = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1486368525, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingStageContent (UpdatingScreen.kt:257)");
            }
            if (stage instanceof UpdateStage.StageCurrentVersion) {
                startRestartGroup.startReplaceableGroup(51669918);
                StageCurrentVersionContent.StageCurrentVersionContent(modifier, (UpdateStage.StageCurrentVersion) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageCurrentVersion.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyInstallOTA) {
                startRestartGroup.startReplaceableGroup(51670033);
                int i5 = i3 << 3;
                StageReadyInstallOTAContent.StageReadyInstallOTAContent(modifier, (UpdateStage.StageReadyInstallOTA) stage, UpdatingButtonStyle.Filled.INSTANCE, z, onClickUpdate, startRestartGroup, (i3 & 14) | (UpdateStage.StageReadyInstallOTA.$stable << 3) | (UpdatingButtonStyle.Filled.$stable << 6) | (i5 & 7168) | (i5 & 57344), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallingRunning) {
                startRestartGroup.startReplaceableGroup(51670207);
                StageInstallingContent.StageInstallingRunningContent(modifier, (UpdateStage.StageInstallingRunning) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageInstallingRunning.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallingPaused) {
                startRestartGroup.startReplaceableGroup(51670355);
                StageInstallingContent.StageInstallingPausedContent(modifier, (UpdateStage.StageInstallingPaused) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageInstallingPaused.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageLookingVersion) {
                startRestartGroup.startReplaceableGroup(51670500);
                StageLookingVersionContent.StageLookingVersionContent(modifier, startRestartGroup, i3 & 14, 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageUpToDate) {
                startRestartGroup.startReplaceableGroup(51670612);
                StageUpToDateContent.StageUpToDateContent(modifier, (UpdateStage.StageUpToDate) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageUpToDate.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageInstallComplete) {
                startRestartGroup.startReplaceableGroup(51670740);
                StageInstallingContent.StageInstallingCompleteContent(modifier, (UpdateStage.StageInstallComplete) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageInstallComplete.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyToDownload) {
                startRestartGroup.startReplaceableGroup(51670888);
                StageReadyToDownloadContent.StageReadyToDownloadContent(modifier, (UpdateStage.StageReadyToDownload) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageReadyToDownload.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageDownloading) {
                startRestartGroup.startReplaceableGroup(51671019);
                StageDownloadContent.StageDownloadingContent(modifier, (UpdateStage.StageDownloading) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageDownloading.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageDownloadPaused) {
                startRestartGroup.startReplaceableGroup(51671149);
                StageDownloadContent.StageDownloadPausedContent(modifier, (UpdateStage.StageDownloadPaused) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageDownloadPaused.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else if (stage instanceof UpdateStage.StageReadyInstallDownloaded) {
                startRestartGroup.startReplaceableGroup(51671290);
                StageDownloadContent.StageReadyToInstallDownloadedContent(modifier, (UpdateStage.StageReadyInstallDownloaded) stage, startRestartGroup, (i3 & 14) | (UpdateStage.StageReadyInstallDownloaded.$stable << 3), 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(51671403);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final boolean z2 = z;
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

            public final void invoke(Composer composer2, int i6) {
                UpdatingScreen.UpdatingStageContent(Modifier.this, stage, z2, onClickUpdate, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0381  */
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
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void UpdatingFooter(androidx.compose.p002ui.Modifier r25, final com.nothing.OfflineOTAUpgradeApp.state.UpdateStage r26, boolean r27, final kotlin.jvm.functions.Functions<kotlin.Unit> r28, final kotlin.jvm.functions.Functions<kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 920
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.p007ui.compose.UpdatingScreen.UpdatingFooter(androidx.compose.ui.Modifier, com.nothing.OfflineOTAUpgradeApp.state.UpdateStage, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void StageCurrentVersionPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(309345531);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageCurrentVersionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(309345531, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageCurrentVersionPreview (UpdatingScreen.kt:352)");
            }
            UpdatingScreen(null, new UpdateStage.StageCurrentVersion("Pong-U2.5-230824-0012"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageCurrentVersionPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageCurrentVersion.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageCurrentVersionPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyToDownload(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1752540062);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyToDownload)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752540062, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyToDownload (UpdatingScreen.kt:363)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyToDownload("Pong-U2.5-230824-0012", "2.6 GB"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToDownload$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageReadyToDownload.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageReadyToDownload(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyInstallOTAPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-130150272);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyInstallOTAPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-130150272, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyInstallOTAPreview (UpdatingScreen.kt:377)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyInstallOTA("Pong-U2.5-230824-0012", "Pong-U2.5-230824-0012"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyInstallOTAPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageReadyInstallOTA.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageReadyInstallOTAPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageInstallingPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-358753213);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358753213, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageInstallingPreview (UpdatingScreen.kt:390)");
            }
            UpdatingScreen(null, new UpdateStage.StageInstallingRunning("Pong-U2.5-230824-0012", 0.45d), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageInstallingPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageInstallingRunning.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageInstallingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageLookingVersionPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2090262703);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageLookingVersionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2090262703, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageLookingVersionPreview (UpdatingScreen.kt:404)");
            }
            UpdatingScreen(null, UpdateStage.StageLookingVersion.INSTANCE, false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageLookingVersionPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageLookingVersion.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageLookingVersionPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageUpToDatePreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1319714464);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageUpToDatePreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319714464, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageUpToDatePreview (UpdatingScreen.kt:415)");
            }
            UpdatingScreen(null, new UpdateStage.StageUpToDate("Pong-U2.5-230824-0012"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageUpToDatePreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageUpToDate.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageUpToDatePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageStageReadyToDownloadPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-479574876);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageStageReadyToDownloadPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-479574876, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageStageReadyToDownloadPreview (UpdatingScreen.kt:428)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyToDownload("Pong-U2.5-230824-0012", "2.6 GB"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageStageReadyToDownloadPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageReadyToDownload.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageStageReadyToDownloadPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageDownloadingContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2137048933);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageDownloadingContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2137048933, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageDownloadingContentPreview (UpdatingScreen.kt:442)");
            }
            UpdatingScreen(null, new UpdateStage.StageDownloading("Pong-U2.5-230824-0012", 0.16d), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadingContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageDownloading.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageDownloadingContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageDownloadPausedContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(2107974975);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageDownloadPausedContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2107974975, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageDownloadPausedContentPreview (UpdatingScreen.kt:456)");
            }
            UpdatingScreen(null, new UpdateStage.StageDownloadPaused("Pong-U2.5-230824-0012", 0.16d), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageDownloadPausedContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageDownloadPaused.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageDownloadPausedContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StageReadyToInstallDownloadedContentPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1299296529);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageReadyToInstallDownloadedContentPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1299296529, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StageReadyToInstallDownloadedContentPreview (UpdatingScreen.kt:470)");
            }
            UpdatingScreen(null, new UpdateStage.StageReadyInstallDownloaded("Pong-U2.5-230824-0012"), false, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingScreenKt$StageReadyToInstallDownloadedContentPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, (UpdateStage.StageReadyInstallDownloaded.$stable << 3) | 224256, 5);
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
                UpdatingScreen.StageReadyToInstallDownloadedContentPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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

    private static final boolean UpdatingScreen$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
