package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import android.content.Context;
import androidx.appcompat.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.nothing.OfflineOTAUpgradeApp.state.DialogInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadOTADialog.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\b\u001a1\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\f\u001a7\u0010\r\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"CheckDownloadWithCellularDialog", "", "onConfirmClicked", "Lkotlin/Function0;", "onCancelClicked", "onDismiss", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CheckUpdateFailDialog", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DownloadFailDialog", "dialogInfo", "Lcom/nothing/OfflineOTAUpgradeApp/state/DialogInfo$DialogBundle;", "(Lcom/nothing/OfflineOTAUpgradeApp/state/DialogInfo$DialogBundle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StopDownloadConfirmationDialog", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloadOTADialogKt {
    public static final void CheckUpdateFailDialog(final Function0<Unit> onCancelClicked, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1381173617);
        ComposerKt.sourceInformation(startRestartGroup, "C(CheckUpdateFailDialog)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onCancelClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1381173617, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.CheckUpdateFailDialog (DownloadOTADialog.kt:12)");
            }
            BaseDialogKt.BaseDialog(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.check_update_version_fail_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.check_update_version_fail_dialog_message, startRestartGroup, 6), null, StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.cancel, startRestartGroup, 6), null, onCancelClicked, true, onDismiss, startRestartGroup, ((i2 << 15) & 458752) | 1572864 | ((i2 << 18) & 29360128), 20);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DownloadOTADialogKt$CheckUpdateFailDialog$1
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
                DownloadOTADialogKt.CheckUpdateFailDialog(onCancelClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void DownloadFailDialog(final DialogInfo.DialogBundle dialogInfo, final Function0<Unit> onConfirmClicked, final Function0<Unit> onDismiss, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(dialogInfo, "dialogInfo");
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(23116678);
        ComposerKt.sourceInformation(startRestartGroup, "C(DownloadFailDialog)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(23116678, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.DownloadFailDialog (DownloadOTADialog.kt:28)");
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume;
        startRestartGroup.startReplaceableGroup(908218834);
        String title = dialogInfo.getTitle(context);
        if (title.length() == 0) {
            title = StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.download_fail_dialog_title, startRestartGroup, 6);
        }
        String str = title;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(908218964);
        String message = dialogInfo.getMessage(context);
        if (message.length() == 0) {
            message = StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.download_fail_dialog_message, startRestartGroup, 6);
        }
        startRestartGroup.endReplaceableGroup();
        BaseDialogKt.BaseDialog(str, message, StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.confirm, startRestartGroup, 6), null, onConfirmClicked, null, true, onDismiss, startRestartGroup, ((i << 9) & 57344) | 1572864 | ((i << 15) & 29360128), 40);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DownloadOTADialogKt$DownloadFailDialog$1
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
                DownloadOTADialogKt.DownloadFailDialog(DialogInfo.DialogBundle.this, onConfirmClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void StopDownloadConfirmationDialog(final Function0<Unit> onConfirmClicked, final Function0<Unit> onCancelClicked, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-492890921);
        ComposerKt.sourceInformation(startRestartGroup, "C(StopDownloadConfirmationDialog)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onCancelClicked) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-492890921, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.StopDownloadConfirmationDialog (DownloadOTADialog.kt:52)");
            }
            int i3 = i2 << 12;
            BaseDialogKt.BaseDialog(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.stop_download_confirmation_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.stop_download_confirmation_dialog_message, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.confirm, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.cancel, startRestartGroup, 6), onConfirmClicked, onCancelClicked, true, onDismiss, startRestartGroup, (i3 & 458752) | (57344 & i3) | 1572864 | ((i2 << 15) & 29360128), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DownloadOTADialogKt$StopDownloadConfirmationDialog$1
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

            public final void invoke(Composer composer2, int i4) {
                DownloadOTADialogKt.StopDownloadConfirmationDialog(onConfirmClicked, onCancelClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void CheckDownloadWithCellularDialog(final Function0<Unit> onConfirmClicked, final Function0<Unit> onCancelClicked, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(199965234);
        ComposerKt.sourceInformation(startRestartGroup, "C(CheckDownloadWithCellularDialog)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onCancelClicked) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(199965234, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.CheckDownloadWithCellularDialog (DownloadOTADialog.kt:70)");
            }
            int i3 = i2 << 12;
            BaseDialogKt.BaseDialog(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.check_download_with_cellular_title, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.check_download_with_cellular_message, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.download, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.cancel, startRestartGroup, 6), onConfirmClicked, onCancelClicked, false, onDismiss, startRestartGroup, (i3 & 458752) | (57344 & i3) | 1572864 | ((i2 << 15) & 29360128), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DownloadOTADialogKt$CheckDownloadWithCellularDialog$1
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

            public final void invoke(Composer composer2, int i4) {
                DownloadOTADialogKt.CheckDownloadWithCellularDialog(onConfirmClicked, onCancelClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
