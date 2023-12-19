package androidx.compose.p002ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.text.SpanStyle;
import androidx.compose.p002ui.text.font.FontFamily;
import androidx.compose.p002ui.text.font.FontStyle;
import androidx.compose.p002ui.text.font.FontSynthesis;
import androidx.compose.p002ui.text.font.FontWeight;
import androidx.compose.p002ui.text.intl.LocaleList;
import androidx.compose.p002ui.text.platform.AndroidTextPaint;
import androidx.compose.p002ui.text.style.TextGeometricTransform;
import androidx.compose.p002ui.text.style.TextMotion;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.TextUnit;
import androidx.compose.p002ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPaintExtensions.android.kt */
@Metadata(m41d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a9\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001aS\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0001\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, m40d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt */
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density, boolean z) {
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long m5531getTypeUIouoOA = TextUnit.m5531getTypeUIouoOA(style.m4849getFontSizeXSAIIZE());
        if (TextUnitType.m5560equalsimpl0(m5531getTypeUIouoOA, TextUnitType.Companion.m5565getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo602toPxR2X_6o(style.m4849getFontSizeXSAIIZE()));
        } else if (TextUnitType.m5560equalsimpl0(m5531getTypeUIouoOA, TextUnitType.Companion.m5564getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m5532getValueimpl(style.m4849getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m4850getFontStyle4Lr2A7w = style.m4850getFontStyle4Lr2A7w();
            FontStyle m4970boximpl = FontStyle.m4970boximpl(m4850getFontStyle4Lr2A7w != null ? m4850getFontStyle4Lr2A7w.m4976unboximpl() : FontStyle.Companion.m4978getNormal_LCdwA());
            FontSynthesis m4851getFontSynthesisZQGJjVo = style.m4851getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface(resolveTypeface.invoke(fontFamily, fontWeight, m4970boximpl, FontSynthesis.m4979boximpl(m4851getFontSynthesisZQGJjVo != null ? m4851getFontSynthesisZQGJjVo.m4987unboximpl() : FontSynthesis.Companion.m4988getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.Companion.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, style.getLocaleList());
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m5115setColor8_81llA(style.m4848getColor0d7_KjU());
        androidTextPaint.m5114setBrush12SF9DM(style.getBrush(), Size.Companion.m2696getUnspecifiedNHjbRc(), style.getAlpha());
        androidTextPaint.setShadow(style.getShadow());
        androidTextPaint.setTextDecoration(style.getTextDecoration());
        androidTextPaint.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.m5560equalsimpl0(TextUnit.m5531getTypeUIouoOA(style.m4852getLetterSpacingXSAIIZE()), TextUnitType.Companion.m5565getSpUIouoOA())) {
            if (!(TextUnit.m5532getValueimpl(style.m4852getLetterSpacingXSAIIZE()) == 0.0f)) {
                float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
                float mo602toPxR2X_6o = density.mo602toPxR2X_6o(style.m4852getLetterSpacingXSAIIZE());
                if (!(textSize == 0.0f)) {
                    androidTextPaint.setLetterSpacing(mo602toPxR2X_6o / textSize);
                }
                return m5129generateFallbackSpanStyle62GTOB8(style.m4852getLetterSpacingXSAIIZE(), z, style.m4846getBackground0d7_KjU(), style.m4847getBaselineShift5SSeXJ0());
            }
        }
        if (TextUnitType.m5560equalsimpl0(TextUnit.m5531getTypeUIouoOA(style.m4852getLetterSpacingXSAIIZE()), TextUnitType.Companion.m5564getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m5532getValueimpl(style.m4852getLetterSpacingXSAIIZE()));
        }
        return m5129generateFallbackSpanStyle62GTOB8(style.m4852getLetterSpacingXSAIIZE(), z, style.m4846getBackground0d7_KjU(), style.m4847getBaselineShift5SSeXJ0());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (androidx.compose.p002ui.text.style.BaselineShift.m5137equalsimpl0(r34.m5140unboximpl(), androidx.compose.p002ui.text.style.BaselineShift.Companion.m5144getNoney9eOQZs()) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* renamed from: generateFallbackSpanStyle-62GTOB8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.p002ui.text.SpanStyle m5129generateFallbackSpanStyle62GTOB8(long r29, boolean r31, long r32, androidx.compose.p002ui.text.style.BaselineShift r34) {
        /*
            r0 = r32
            r2 = 1
            r3 = 0
            if (r31 == 0) goto L26
            long r4 = androidx.compose.p002ui.unit.TextUnit.m5531getTypeUIouoOA(r29)
            androidx.compose.ui.unit.TextUnitType$Companion r6 = androidx.compose.p002ui.unit.TextUnitType.Companion
            long r6 = r6.m5565getSpUIouoOA()
            boolean r4 = androidx.compose.p002ui.unit.TextUnitType.m5560equalsimpl0(r4, r6)
            if (r4 == 0) goto L26
            float r4 = androidx.compose.p002ui.unit.TextUnit.m5532getValueimpl(r29)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L21
            r4 = r2
            goto L22
        L21:
            r4 = r3
        L22:
            if (r4 != 0) goto L26
            r4 = r2
            goto L27
        L26:
            r4 = r3
        L27:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.p002ui.graphics.Color.Companion
            long r5 = r5.m2893getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.p002ui.graphics.Color.m2858equalsimpl0(r0, r5)
            if (r5 != 0) goto L41
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.p002ui.graphics.Color.Companion
            long r5 = r5.m2892getTransparent0d7_KjU()
            boolean r5 = androidx.compose.p002ui.graphics.Color.m2858equalsimpl0(r0, r5)
            if (r5 != 0) goto L41
            r5 = r2
            goto L42
        L41:
            r5 = r3
        L42:
            if (r34 == 0) goto L55
            androidx.compose.ui.text.style.BaselineShift$Companion r6 = androidx.compose.p002ui.text.style.BaselineShift.Companion
            float r6 = r6.m5144getNoney9eOQZs()
            float r7 = r34.m5140unboximpl()
            boolean r6 = androidx.compose.p002ui.text.style.BaselineShift.m5137equalsimpl0(r7, r6)
            if (r6 != 0) goto L55
            goto L56
        L55:
            r2 = r3
        L56:
            r3 = 0
            if (r4 != 0) goto L5e
            if (r5 != 0) goto L5e
            if (r2 != 0) goto L5e
            goto L9a
        L5e:
            if (r4 == 0) goto L63
            r18 = r29
            goto L6b
        L63:
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.p002ui.unit.TextUnit.Companion
            long r6 = r4.m5543getUnspecifiedXSAIIZE()
            r18 = r6
        L6b:
            if (r5 == 0) goto L6e
            goto L74
        L6e:
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.p002ui.graphics.Color.Companion
            long r0 = r0.m2893getUnspecified0d7_KjU()
        L74:
            r23 = r0
            if (r2 == 0) goto L7b
            r20 = r34
            goto L7d
        L7b:
            r20 = r3
        L7d:
            androidx.compose.ui.text.SpanStyle r3 = new androidx.compose.ui.text.SpanStyle
            r8 = r3
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r27 = 13951(0x367f, float:1.955E-41)
            r28 = 0
            r8.<init>(r9, r11, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r27, r28)
        L9a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.text.platform.extensions.TextPaintExtensions_androidKt.m5129generateFallbackSpanStyle62GTOB8(long, boolean, long, androidx.compose.ui.text.style.BaselineShift):androidx.compose.ui.text.SpanStyle");
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        int flags;
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning$ui_text_release()) {
            flags = androidTextPaint.getFlags() | 128;
        } else {
            flags = androidTextPaint.getFlags() & (-129);
        }
        androidTextPaint.setFlags(flags);
        int m5271getLinearity4e0Vf04$ui_text_release = textMotion.m5271getLinearity4e0Vf04$ui_text_release();
        if (TextMotion.Linearity.m5275equalsimpl0(m5271getLinearity4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.m5280getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m5275equalsimpl0(m5271getLinearity4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.m5279getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m5275equalsimpl0(m5271getLinearity4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.m5281getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m4850getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
