package androidx.compose.p002ui.text.font;

import android.graphics.Typeface;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontSynthesis.android.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, m40d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.font.FontSynthesis_androidKt */
/* loaded from: classes.dex */
public final class FontSynthesis_androidKt {
    /* renamed from: synthesizeTypeface-FxwP2eA  reason: not valid java name */
    public static final Object m4992synthesizeTypefaceFxwP2eA(int i, Object typeface, Font font, FontWeight requestedWeight, int i2) {
        int weight;
        boolean m4973equalsimpl0;
        Typeface create;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(requestedWeight, "requestedWeight");
        if (typeface instanceof Typeface) {
            boolean z = true;
            boolean z2 = FontSynthesis.m4985isWeightOnimpl$ui_text_release(i) && !Intrinsics.areEqual(font.getWeight(), requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) < 0;
            boolean z3 = FontSynthesis.m4984isStyleOnimpl$ui_text_release(i) && !FontStyle.m4973equalsimpl0(i2, font.mo4928getStyle_LCdwA());
            if (z3 || z2) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (!z3 || !FontStyle.m4973equalsimpl0(i2, FontStyle.Companion.m4977getItalic_LCdwA())) {
                        z = false;
                    }
                    create = Typeface.create((Typeface) typeface, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z2, z));
                } else {
                    if (z2) {
                        weight = requestedWeight.getWeight();
                    } else {
                        weight = font.getWeight().getWeight();
                    }
                    if (z3) {
                        m4973equalsimpl0 = FontStyle.m4973equalsimpl0(i2, FontStyle.Companion.m4977getItalic_LCdwA());
                    } else {
                        m4973equalsimpl0 = FontStyle.m4973equalsimpl0(font.mo4928getStyle_LCdwA(), FontStyle.Companion.m4977getItalic_LCdwA());
                    }
                    create = TypefaceHelperMethodsApi28.INSTANCE.create((Typeface) typeface, weight, m4973equalsimpl0);
                }
                Intrinsics.checkNotNullExpressionValue(create, "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }");
                return create;
            }
            return typeface;
        }
        return typeface;
    }
}
