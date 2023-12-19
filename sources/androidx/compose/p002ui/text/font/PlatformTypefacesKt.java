package androidx.compose.p002ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.autofill.HintConstants;
import androidx.compose.p002ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformTypefaces.kt */
@Metadata(m41d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, m40d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", HintConstants.AUTOFILL_HINT_NAME, "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.font.PlatformTypefacesKt */
/* loaded from: classes.dex */
public final class PlatformTypefacesKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }
        return new PlatformTypefacesApi();
    }

    public static final Typeface setFontVariationSettings(Typeface typeface, FontVariation.Settings variationSettings, Context context) {
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        return TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, variationSettings, context);
    }

    public static final String getWeightSuffixForFallbackFamilyName(String name, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        int weight = fontWeight.getWeight() / 100;
        boolean z = true;
        if (weight >= 0 && weight < 2) {
            return name + "-thin";
        }
        if (2 <= weight && weight < 4) {
            return name + "-light";
        }
        if (weight == 4) {
            return name;
        }
        if (weight == 5) {
            return name + "-medium";
        }
        if (6 <= weight && weight < 8) {
            return name;
        }
        if (8 > weight || weight >= 11) {
            z = false;
        }
        return z ? name + "-black" : name;
    }
}
