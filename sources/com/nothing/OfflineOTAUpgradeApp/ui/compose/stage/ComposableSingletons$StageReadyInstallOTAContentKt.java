package com.nothing.OfflineOTAUpgradeApp.ui.compose.stage;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnitKt;
import com.nothing.OfflineOTAUpgradeApp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StageReadyInstallOTAContent.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$StageReadyInstallOTAContentKt {
    public static final ComposableSingletons$StageReadyInstallOTAContentKt INSTANCE = new ComposableSingletons$StageReadyInstallOTAContentKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f53lambda1 = ComposableLambdaKt.composableLambdaInstance(804760611, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.ComposableSingletons$StageReadyInstallOTAContentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(804760611, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.ComposableSingletons$StageReadyInstallOTAContentKt.lambda-1.<anonymous> (StageReadyInstallOTAContent.kt:89)");
                }
                long sp = TextUnitKt.getSp(14);
                long sp2 = TextUnitKt.getSp(20);
                GenericFontFamily sansSerif = FontFamily.Companion.getSansSerif();
                FontWeight fontWeight = new FontWeight(500);
                GenericFontFamily genericFontFamily = sansSerif;
                TextKt.m1484Text4IGK_g(StringResources_androidKt.stringResource(R.string.stage_ready_install_ota_update, composer, 6), (Modifier) Modifier.Companion, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(ColorResources_androidKt.colorResource(R.color.ready_install_ota_update_text, composer, 6), sp, fontWeight, (FontStyle) null, (FontSynthesis) null, genericFontFamily, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (TextDirection) null, sp2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4112216, (DefaultConstructorMarker) null), composer, 48, 0, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m5357getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f53lambda1;
    }
}
