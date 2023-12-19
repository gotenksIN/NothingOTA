package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.appcompat.R;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.res.ColorResources_androidKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.nothing.OfflineOTAUpgradeApp.state.UpdatingButtonStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatingButton.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"UpdatingButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "buttonStyle", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "enabled", "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatingButtonKt {
    public static final void UpdatingButton(Modifier modifier, final String text, final UpdatingButtonStyle buttonStyle, final boolean z, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(332842655);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdatingButton)P(2,4)");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 14) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(buttonStyle) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        final int i5 = i3;
        if ((46811 & i5) != 9362 || !startRestartGroup.getSkipping()) {
            companion = i4 != 0 ? Modifier.Companion : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332842655, i5, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButton (UpdatingButton.kt:35)");
            }
            composer2 = startRestartGroup;
            ButtonKt.Button(onClick, companion, z, RoundedCornerShapeKt.m689RoundedCornerShape0680j_4(Dp.m5050constructorimpl(84)), ButtonDefaults.INSTANCE.m934buttonColorsro_MJ88(ColorResources_androidKt.colorResource(buttonStyle.getFillColorRes(), startRestartGroup, 0), 0L, 0L, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 14), null, BorderStrokeKt.m171BorderStrokecXLIe8U(Dp.m5050constructorimpl(1), ColorResources_androidKt.colorResource(buttonStyle.getBorderColorRes(), startRestartGroup, 0)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1725466799, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButtonKt$UpdatingButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer composer3, int i6) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i6 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725466799, i6, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButton.<anonymous> (UpdatingButton.kt:49)");
                        }
                        String str = text;
                        Modifier m415padding3ABfNKs = PaddingKt.m415padding3ABfNKs(Modifier.Companion, Dp.m5050constructorimpl(16));
                        long sp = TextUnitKt.getSp(16);
                        long sp2 = TextUnitKt.getSp(24);
                        GenericFontFamily sansSerif = FontFamily.Companion.getSansSerif();
                        FontWeight fontWeight = new FontWeight(500);
                        GenericFontFamily genericFontFamily = sansSerif;
                        TextKt.m1484Text4IGK_g(str, m415padding3ABfNKs, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(ColorResources_androidKt.colorResource(buttonStyle.getTextColorRes(), composer3, 0), sp, fontWeight, (FontStyle) null, (FontSynthesis) null, genericFontFamily, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (TextDirection) null, sp2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4112216, (DefaultConstructorMarker) null), composer3, ((i5 >> 3) & 14) | 48, 0, 65532);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, ((i5 >> 12) & 14) | 805306368 | ((i5 << 3) & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | ((i5 >> 3) & 896), 416);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            companion = obj;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = companion;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButtonKt$UpdatingButton$2
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

            public final void invoke(Composer composer3, int i6) {
                UpdatingButtonKt.UpdatingButton(Modifier.this, text, buttonStyle, z, onClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
