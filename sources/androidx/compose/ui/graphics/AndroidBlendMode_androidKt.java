package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;

/* compiled from: AndroidBlendMode.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m2409isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2500getSrcOver0nO6VwU()) || m2411toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m2411toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2473getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2496getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2479getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2500getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2483getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2498getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2481getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2499getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2482getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2497getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2480getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2501getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2492getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2494getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2491getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2477getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2487getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2489getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final android.graphics.BlendMode m2410toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2473getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2496getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2479getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2500getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2483getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2498getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2481getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2499getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2482getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2497getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2480getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2501getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2492getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2489getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2494getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2491getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2477getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2487getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2476getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2475getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2485getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2495getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2478getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2484getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2490getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2486getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2493getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2474getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m2469equalsimpl0(i, BlendMode.Companion.m2488getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }
}
