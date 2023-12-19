package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.appcompat.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnauthorizedUserTipsDialog.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"UnauthorizedUserTipsDialog", "", "onConfirmClicked", "Lkotlin/Function0;", "onDismiss", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnauthorizedUserTipsDialogKt {
    public static final void UnauthorizedUserTipsDialog(final Function0<Unit> onConfirmClicked, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onConfirmClicked, "onConfirmClicked");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-390584664);
        ComposerKt.sourceInformation(startRestartGroup, "C(UnauthorizedUserTipsDialog)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirmClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390584664, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UnauthorizedUserTipsDialog (UnauthorizedUserTipsDialog.kt:10)");
            }
            BaseDialogKt.BaseDialog(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.unauthorized_user_tips_dialog_title, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.unauthorized_user_tips_dialog_message, startRestartGroup, 6), StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.ok, startRestartGroup, 6), null, onConfirmClicked, null, false, onDismiss, startRestartGroup, ((i2 << 12) & 57344) | 1572864 | ((i2 << 18) & 29360128), 40);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UnauthorizedUserTipsDialogKt$UnauthorizedUserTipsDialog$1
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
                UnauthorizedUserTipsDialogKt.UnauthorizedUserTipsDialog(onConfirmClicked, onDismiss, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
