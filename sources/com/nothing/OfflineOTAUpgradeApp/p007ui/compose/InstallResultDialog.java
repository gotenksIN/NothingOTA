package com.nothing.OfflineOTAUpgradeApp.p007ui.compose;

import androidx.appcompat.C0032R;
import androidx.compose.p002ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\b\u001a7\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m40d2 = {"InstallCancelConfirmationDialog", "", "onConfirmClicked", "Lkotlin/Function0;", "onCancelClicked", "onDismiss", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InstallFailureDialog", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InstallSuccessDialog", "InstallSuccessDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt */
/* loaded from: classes2.dex */
public final class InstallResultDialog {
    public static final void InstallSuccessDialog(final Functions<Unit> onConfirmClicked, final Functions<Unit> onCancelClicked, final Functions<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-968661398);
        ComposerKt.sourceInformation(startRestartGroup, "C(InstallSuccessDialog)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onCancelClicked) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-968661398, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallSuccessDialog (InstallResultDialog.kt:12)");
            }
            int i3 = i2 << 12;
            BaseDialog.BaseDialog(StringResources_androidKt.stringResource(C1640R.string.update_ota_success_reboot_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.update_ota_success_reboot_dialog_title_message, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.confirm, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.cancel, startRestartGroup, 6), onConfirmClicked, onCancelClicked, false, onDismiss, startRestartGroup, (i3 & 458752) | (57344 & i3) | 1572864 | ((i2 << 15) & 29360128), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallSuccessDialog$1
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
                InstallResultDialog.InstallSuccessDialog(onConfirmClicked, onCancelClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void InstallFailureDialog(final Functions<Unit> onConfirmClicked, final Functions<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(257475855);
        ComposerKt.sourceInformation(startRestartGroup, "C(InstallFailureDialog)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(257475855, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallFailureDialog (InstallResultDialog.kt:29)");
            }
            BaseDialog.BaseDialog(StringResources_androidKt.stringResource(C1640R.string.update_ota_failure_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.update_ota_failure_dialog_message, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.confirm, startRestartGroup, 6), null, onConfirmClicked, null, false, onDismiss, startRestartGroup, ((i2 << 12) & 57344) | 1572864 | ((i2 << 18) & 29360128), 40);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallFailureDialog$1
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
                InstallResultDialog.InstallFailureDialog(onConfirmClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void InstallCancelConfirmationDialog(final Functions<Unit> onConfirmClicked, final Functions<Unit> onCancelClicked, final Functions<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1871425636);
        ComposerKt.sourceInformation(startRestartGroup, "C(InstallCancelConfirmationDialog)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onCancelClicked) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1871425636, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallCancelConfirmationDialog (InstallResultDialog.kt:45)");
            }
            int i3 = i2 << 12;
            BaseDialog.BaseDialog(StringResources_androidKt.stringResource(C1640R.string.reset_ota_update_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.reset_ota_update_dialog_message, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.confirm, startRestartGroup, 6), StringResources_androidKt.stringResource(C1640R.string.cancel, startRestartGroup, 6), onConfirmClicked, onCancelClicked, true, onDismiss, startRestartGroup, (i3 & 458752) | (57344 & i3) | 1572864 | ((i2 << 15) & 29360128), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallCancelConfirmationDialog$1
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
                InstallResultDialog.InstallCancelConfirmationDialog(onConfirmClicked, onCancelClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void InstallSuccessDialogPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1363362706);
        ComposerKt.sourceInformation(startRestartGroup, "C(InstallSuccessDialogPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1363362706, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallSuccessDialogPreview (InstallResultDialog.kt:60)");
            }
            InstallSuccessDialog(new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallSuccessDialogPreview$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallSuccessDialogPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallSuccessDialogPreview$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Functions
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 438);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.InstallResultDialogKt$InstallSuccessDialogPreview$4
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
                InstallResultDialog.InstallSuccessDialogPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
