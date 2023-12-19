package androidx.compose.p002ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;

/* compiled from: AndroidBlendMode.android.kt */
@Metadata(m41d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m40d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.AndroidBlendMode_androidKt */
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m2710isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2801getSrcOver0nO6VwU()) || m2712toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m2712toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2774getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2797getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2780getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2801getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2784getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2799getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2782getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2800getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2783getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2798getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2781getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2802getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2793getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2795getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2792getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2778getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2788getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2790getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m2711toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2774getClear0nO6VwU()) ? BlendMode.CLEAR : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2797getSrc0nO6VwU()) ? BlendMode.SRC : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2780getDst0nO6VwU()) ? BlendMode.DST : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2801getSrcOver0nO6VwU()) ? BlendMode.SRC_OVER : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2784getDstOver0nO6VwU()) ? BlendMode.DST_OVER : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2799getSrcIn0nO6VwU()) ? BlendMode.SRC_IN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2782getDstIn0nO6VwU()) ? BlendMode.DST_IN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2800getSrcOut0nO6VwU()) ? BlendMode.SRC_OUT : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2783getDstOut0nO6VwU()) ? BlendMode.DST_OUT : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2798getSrcAtop0nO6VwU()) ? BlendMode.SRC_ATOP : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2781getDstAtop0nO6VwU()) ? BlendMode.DST_ATOP : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2802getXor0nO6VwU()) ? BlendMode.XOR : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2793getPlus0nO6VwU()) ? BlendMode.PLUS : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2790getModulate0nO6VwU()) ? BlendMode.MODULATE : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2795getScreen0nO6VwU()) ? BlendMode.SCREEN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2792getOverlay0nO6VwU()) ? BlendMode.OVERLAY : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2778getDarken0nO6VwU()) ? BlendMode.DARKEN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2788getLighten0nO6VwU()) ? BlendMode.LIGHTEN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2777getColorDodge0nO6VwU()) ? BlendMode.COLOR_DODGE : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2776getColorBurn0nO6VwU()) ? BlendMode.COLOR_BURN : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2786getHardlight0nO6VwU()) ? BlendMode.HARD_LIGHT : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2796getSoftlight0nO6VwU()) ? BlendMode.SOFT_LIGHT : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2779getDifference0nO6VwU()) ? BlendMode.DIFFERENCE : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2785getExclusion0nO6VwU()) ? BlendMode.EXCLUSION : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2791getMultiply0nO6VwU()) ? BlendMode.MULTIPLY : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2787getHue0nO6VwU()) ? BlendMode.HUE : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2794getSaturation0nO6VwU()) ? BlendMode.SATURATION : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2775getColor0nO6VwU()) ? BlendMode.COLOR : BlendMode.m2770equalsimpl0(i, BlendMode.Companion.m2789getLuminosity0nO6VwU()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }
}
