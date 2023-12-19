package androidx.compose.p002ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.p002ui.text.AnnotatedString;
import androidx.compose.p002ui.text.SpanStyle;
import androidx.compose.p002ui.text.TtsAnnotation;
import androidx.compose.p002ui.text.UrlAnnotation;
import androidx.compose.p002ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.p002ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.p002ui.text.font.Font;
import androidx.compose.p002ui.text.font.FontFamily;
import androidx.compose.p002ui.text.font.FontStyle;
import androidx.compose.p002ui.text.font.FontSynthesis;
import androidx.compose.p002ui.text.font.FontWeight;
import androidx.compose.p002ui.text.font.GenericFontFamily;
import androidx.compose.p002ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p002ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.p002ui.text.platform.extensions.UrlAnnotationExtensions_androidKt;
import androidx.compose.p002ui.text.style.TextDecoration;
import androidx.compose.p002ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAccessibilitySpannableString.android.kt */
@Metadata(m41d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, m40d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt */
/* loaded from: classes.dex */
public final class AndroidAccessibilitySpannableString_androidKt {
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString(annotatedString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, FontFamily.Resolver fontFamilyResolver) {
        SpanStyle m4844copyIuqyXdg;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i);
                int component2 = range.component2();
                int component3 = range.component3();
                m4844copyIuqyXdg = r14.m4844copyIuqyXdg((r35 & 1) != 0 ? r14.m4848getColor0d7_KjU() : 0L, (r35 & 2) != 0 ? r14.fontSize : 0L, (r35 & 4) != 0 ? r14.fontWeight : null, (r35 & 8) != 0 ? r14.fontStyle : null, (r35 & 16) != 0 ? r14.fontSynthesis : null, (r35 & 32) != 0 ? r14.fontFamily : null, (r35 & 64) != 0 ? r14.fontFeatureSettings : null, (r35 & 128) != 0 ? r14.letterSpacing : 0L, (r35 & 256) != 0 ? r14.baselineShift : null, (r35 & 512) != 0 ? r14.textGeometricTransform : null, (r35 & 1024) != 0 ? r14.localeList : null, (r35 & 2048) != 0 ? r14.background : 0L, (r35 & 4096) != 0 ? r14.textDecoration : null, (r35 & 8192) != 0 ? range.component1().shadow : null);
                setSpanStyle(spannableString, m4844copyIuqyXdg, component2, component3, density, fontFamilyResolver);
            }
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range<TtsAnnotation> range2 = ttsAnnotations.get(i2);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(range2.component1()), range2.component2(), range2.component3(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i3 = 0; i3 < size3; i3++) {
            AnnotatedString.Range<UrlAnnotation> range3 = urlAnnotations.get(i3);
            spannableString.setSpan(UrlAnnotationExtensions_androidKt.toSpan(range3.component1()), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, FontFamily.Resolver resolver) {
        SpannableString spannableString2 = spannableString;
        SpannableExtensions_androidKt.m5125setColorRPmYEkk(spannableString2, spanStyle.m4848getColor0d7_KjU(), i, i2);
        SpannableExtensions_androidKt.m5126setFontSizeKmRG4DE(spannableString2, spanStyle.m4849getFontSizeXSAIIZE(), density, i, i2);
        if (spanStyle.getFontWeight() != null || spanStyle.m4850getFontStyle4Lr2A7w() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m4850getFontStyle4Lr2A7w = spanStyle.m4850getFontStyle4Lr2A7w();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m4927getAndroidTypefaceStyleFO1MlWM(fontWeight, m4850getFontStyle4Lr2A7w != null ? m4850getFontStyle4Lr2A7w.m4976unboximpl() : FontStyle.Companion.m4978getNormal_LCdwA())), i, i2, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i, i2, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis m4851getFontSynthesisZQGJjVo = spanStyle.m4851getFontSynthesisZQGJjVo();
                Object value = FontFamily.Resolver.m4947resolveDPcqOEQ$default(resolver, fontFamily, null, 0, m4851getFontSynthesisZQGJjVo != null ? m4851getFontSynthesisZQGJjVo.m4987unboximpl() : FontSynthesis.Companion.m4988getAllGVVA2EU(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i, i2, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i, i2, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString2, spanStyle.getLocaleList(), i, i2);
        SpannableExtensions_androidKt.m5123setBackgroundRPmYEkk(spannableString2, spanStyle.m4846getBackground0d7_KjU(), i, i2);
    }
}
