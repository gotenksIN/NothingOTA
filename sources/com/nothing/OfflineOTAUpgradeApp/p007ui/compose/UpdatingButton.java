package com.nothing.OfflineOTAUpgradeApp.p007ui.compose;

import androidx.appcompat.C0032R;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Padding;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.Button;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.Text;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.res.ColorResources_androidKt;
import androidx.compose.p002ui.text.PlatformTextStyle;
import androidx.compose.p002ui.text.TextLayoutResult;
import androidx.compose.p002ui.text.TextStyle;
import androidx.compose.p002ui.text.font.FontFamily;
import androidx.compose.p002ui.text.font.FontStyle;
import androidx.compose.p002ui.text.font.FontSynthesis;
import androidx.compose.p002ui.text.font.FontWeight;
import androidx.compose.p002ui.text.font.GenericFontFamily;
import androidx.compose.p002ui.text.intl.LocaleList;
import androidx.compose.p002ui.text.style.BaselineShift;
import androidx.compose.p002ui.text.style.Hyphens;
import androidx.compose.p002ui.text.style.LineBreak;
import androidx.compose.p002ui.text.style.LineHeightStyle;
import androidx.compose.p002ui.text.style.TextAlign;
import androidx.compose.p002ui.text.style.TextDecoration;
import androidx.compose.p002ui.text.style.TextDirection;
import androidx.compose.p002ui.text.style.TextGeometricTransform;
import androidx.compose.p002ui.text.style.TextIndent;
import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.TextUnitKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.nothing.OfflineOTAUpgradeApp.state.UpdatingButtonStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, m40d2 = {"UpdatingButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "buttonStyle", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "enabled", "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButtonKt */
/* loaded from: classes2.dex */
public final class UpdatingButton {
    public static final void UpdatingButton(Modifier modifier, final String text, final UpdatingButtonStyle buttonStyle, final boolean z, final Functions<Unit> onClick, Composer composer, final int i, final int i2) {
        Object obj;
        final int i3;
        Modifier.Companion companion;
        long colorResource;
        long colorResource2;
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
        } else if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
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
        if ((46811 & i3) != 9362 || !startRestartGroup.getSkipping()) {
            companion = i4 != 0 ? Modifier.Companion : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332842655, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButton (UpdatingButton.kt:27)");
            }
            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
            long colorResource3 = ColorResources_androidKt.colorResource(buttonStyle.getFillColorRes(), startRestartGroup, 0);
            if (buttonStyle.getFillColorDisableRes() != 0) {
                startRestartGroup.startReplaceableGroup(-1201105732);
                colorResource = ColorResources_androidKt.colorResource(buttonStyle.getFillColorDisableRes(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1201105643);
                colorResource = ColorResources_androidKt.colorResource(buttonStyle.getFillColorRes(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            Button m1235buttonColorsro_MJ88 = buttonDefaults.m1235buttonColorsro_MJ88(colorResource3, 0L, colorResource, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 10);
            float m5351constructorimpl = C0780Dp.m5351constructorimpl(1);
            if (!z && buttonStyle.getBorderColorDisableRes() != 0) {
                startRestartGroup.startReplaceableGroup(-1201105422);
                colorResource2 = ColorResources_androidKt.colorResource(buttonStyle.getBorderColorDisableRes(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1201105331);
                colorResource2 = ColorResources_androidKt.colorResource(buttonStyle.getBorderColorRes(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            composer2 = startRestartGroup;
            ButtonKt.Button(onClick, companion, z, RoundedCornerShapeKt.m990RoundedCornerShape0680j_4(C0780Dp.m5351constructorimpl(84)), m1235buttonColorsro_MJ88, null, BorderStrokeKt.m472BorderStrokecXLIe8U(m5351constructorimpl, colorResource2), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1725466799, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButtonKt$UpdatingButton$1
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

                public final void invoke(RowScope Button, Composer composer3, int i5) {
                    long colorResource4;
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725466799, i5, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.UpdatingButton.<anonymous> (UpdatingButton.kt:50)");
                        }
                        String str = text;
                        Modifier m716padding3ABfNKs = Padding.m716padding3ABfNKs(Modifier.Companion, C0780Dp.m5351constructorimpl(16));
                        long sp = TextUnitKt.getSp(16);
                        long sp2 = TextUnitKt.getSp(24);
                        GenericFontFamily sansSerif = FontFamily.Companion.getSansSerif();
                        FontWeight fontWeight = new FontWeight(500);
                        if (!z && buttonStyle.getTextColorDisableRes() != 0) {
                            composer3.startReplaceableGroup(-897418122);
                            colorResource4 = ColorResources_androidKt.colorResource(buttonStyle.getTextColorDisableRes(), composer3, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-897418025);
                            colorResource4 = ColorResources_androidKt.colorResource(buttonStyle.getTextColorRes(), composer3, 0);
                            composer3.endReplaceableGroup();
                        }
                        GenericFontFamily genericFontFamily = sansSerif;
                        Text.m1785Text4IGK_g(str, m716padding3ABfNKs, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(colorResource4, sp, fontWeight, (FontStyle) null, (FontSynthesis) null, genericFontFamily, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m5238boximpl(TextAlign.Companion.m5245getCentere0LSkKk()), (TextDirection) null, sp2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4112216, (DefaultConstructorMarker) null), composer3, ((i3 >> 3) & 14) | 48, 0, 65532);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, ((i3 >> 12) & 14) | 805306368 | ((i3 << 3) & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | ((i3 >> 3) & 896), 416);
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

            public final void invoke(Composer composer3, int i5) {
                UpdatingButton.UpdatingButton(Modifier.this, text, buttonStyle, z, onClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
