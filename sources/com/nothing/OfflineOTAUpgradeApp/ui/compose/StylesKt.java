package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.PlatformTextStyle;
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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Styles.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003¨\u0006\u0010"}, d2 = {"DebugStageStyle", "Landroidx/compose/ui/text/TextStyle;", "getDebugStageStyle", "()Landroidx/compose/ui/text/TextStyle;", "DialogButtonStyle", "getDialogButtonStyle", "DialogMessageStyle", "getDialogMessageStyle", "DialogTitleStyle", "getDialogTitleStyle", "Subtitle1Style", "getSubtitle1Style", "Subtitle2Style", "getSubtitle2Style", "UpToDateContentStyle", "getUpToDateContentStyle", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StylesKt {
    private static final TextStyle DebugStageStyle;
    private static final TextStyle DialogButtonStyle;
    private static final TextStyle DialogMessageStyle;
    private static final TextStyle DialogTitleStyle;
    private static final TextStyle Subtitle1Style;
    private static final TextStyle Subtitle2Style;
    private static final TextStyle UpToDateContentStyle;

    public static final TextStyle getSubtitle1Style() {
        return Subtitle1Style;
    }

    static {
        long sp = TextUnitKt.getSp(20);
        long sp2 = TextUnitKt.getSp(28);
        Subtitle1Style = new TextStyle(0L, sp, new FontWeight(400), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getSansSerif(), (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4128601, (DefaultConstructorMarker) null);
        long sp3 = TextUnitKt.getSp(14);
        long sp4 = TextUnitKt.getSp(20);
        Subtitle2Style = new TextStyle(0L, sp3, new FontWeight(400), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getSansSerif(), (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp4, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4128601, (DefaultConstructorMarker) null);
        long sp5 = TextUnitKt.getSp(16);
        long sp6 = TextUnitKt.getSp(24);
        UpToDateContentStyle = new TextStyle(0L, sp5, new FontWeight(400), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getSansSerif(), (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp6, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4128601, (DefaultConstructorMarker) null);
        long sp7 = TextUnitKt.getSp(24);
        long sp8 = TextUnitKt.getSp(32);
        DialogTitleStyle = new TextStyle(0L, sp7, new FontWeight(400), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getSansSerif(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp8, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4128729, (DefaultConstructorMarker) null);
        long sp9 = TextUnitKt.getSp(14);
        long sp10 = TextUnitKt.getSp(20);
        DialogMessageStyle = new TextStyle(0L, sp9, new FontWeight(400), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getSansSerif(), (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp10, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4128601, (DefaultConstructorMarker) null);
        long sp11 = TextUnitKt.getSp(14);
        long sp12 = TextUnitKt.getSp(20);
        GenericFontFamily sansSerif = FontFamily.Companion.getSansSerif();
        GenericFontFamily genericFontFamily = sansSerif;
        DialogButtonStyle = new TextStyle(0L, sp11, new FontWeight(500), (FontStyle) null, (FontSynthesis) null, genericFontFamily, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (TextDirection) null, sp12, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4112217, (DefaultConstructorMarker) null);
        long sp13 = TextUnitKt.getSp(14);
        long sp14 = TextUnitKt.getSp(20);
        GenericFontFamily sansSerif2 = FontFamily.Companion.getSansSerif();
        GenericFontFamily genericFontFamily2 = sansSerif2;
        DebugStageStyle = new TextStyle(0L, sp13, new FontWeight(500), (FontStyle) null, (FontSynthesis) null, genericFontFamily2, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (TextDirection) null, sp14, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4112217, (DefaultConstructorMarker) null);
    }

    public static final TextStyle getSubtitle2Style() {
        return Subtitle2Style;
    }

    public static final TextStyle getUpToDateContentStyle() {
        return UpToDateContentStyle;
    }

    public static final TextStyle getDialogTitleStyle() {
        return DialogTitleStyle;
    }

    public static final TextStyle getDialogMessageStyle() {
        return DialogMessageStyle;
    }

    public static final TextStyle getDialogButtonStyle() {
        return DialogButtonStyle;
    }

    public static final TextStyle getDebugStageStyle() {
        return DebugStageStyle;
    }
}
