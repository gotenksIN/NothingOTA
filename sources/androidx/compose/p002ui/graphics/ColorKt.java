package androidx.compose.p002ui.graphics;

import androidx.compose.p002ui.graphics.colorspace.ColorModel;
import androidx.compose.p002ui.graphics.colorspace.ColorSpace;
import androidx.compose.p002ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p002ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p002ui.graphics.colorspace.Rgb;
import androidx.compose.p002ui.util.MathHelpers;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
@Metadata(m41d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a2\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0082\b\u001a-\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a!\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010+\u001a\u00020,*\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006:"}, m40d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.ColorKt */
/* loaded from: classes.dex */
public final class ColorKt {
    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m2905isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m2907isUnspecified8_81llA$annotations(long j) {
    }

    private static final float saturate(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = 1.0f;
            if (f < 1.0f) {
                return f;
            }
        }
        return f2;
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long Color(float r9, float r10, float r11, float r12, androidx.compose.p002ui.graphics.colorspace.ColorSpace r13) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m2853constructorimpl(ULong.m5823constructorimpl(ULong.m5823constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m2853constructorimpl(ULong.m5823constructorimpl(ULong.m5823constructorimpl(ULong.m5823constructorimpl(j) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m2908lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m2854convertvNxB06k = Color.m2854convertvNxB06k(j, oklab);
        long m2854convertvNxB06k2 = Color.m2854convertvNxB06k(j2, oklab);
        float m2859getAlphaimpl = Color.m2859getAlphaimpl(m2854convertvNxB06k);
        float m2863getRedimpl = Color.m2863getRedimpl(m2854convertvNxB06k);
        float m2862getGreenimpl = Color.m2862getGreenimpl(m2854convertvNxB06k);
        float m2860getBlueimpl = Color.m2860getBlueimpl(m2854convertvNxB06k);
        float m2859getAlphaimpl2 = Color.m2859getAlphaimpl(m2854convertvNxB06k2);
        float m2863getRedimpl2 = Color.m2863getRedimpl(m2854convertvNxB06k2);
        float m2862getGreenimpl2 = Color.m2862getGreenimpl(m2854convertvNxB06k2);
        float m2860getBlueimpl2 = Color.m2860getBlueimpl(m2854convertvNxB06k2);
        return Color.m2854convertvNxB06k(Color(MathHelpers.lerp(m2863getRedimpl, m2863getRedimpl2, f), MathHelpers.lerp(m2862getGreenimpl, m2862getGreenimpl2, f), MathHelpers.lerp(m2860getBlueimpl, m2860getBlueimpl2, f), MathHelpers.lerp(m2859getAlphaimpl, m2859getAlphaimpl2, f), oklab), Color.m2861getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m2902compositeOverOWjLjI(long j, long j2) {
        long m2854convertvNxB06k = Color.m2854convertvNxB06k(j, Color.m2861getColorSpaceimpl(j2));
        float m2859getAlphaimpl = Color.m2859getAlphaimpl(j2);
        float m2859getAlphaimpl2 = Color.m2859getAlphaimpl(m2854convertvNxB06k);
        float f = 1.0f - m2859getAlphaimpl2;
        float f2 = (m2859getAlphaimpl * f) + m2859getAlphaimpl2;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        return Color(i == 0 ? 0.0f : ((Color.m2863getRedimpl(m2854convertvNxB06k) * m2859getAlphaimpl2) + ((Color.m2863getRedimpl(j2) * m2859getAlphaimpl) * f)) / f2, i == 0 ? 0.0f : ((Color.m2862getGreenimpl(m2854convertvNxB06k) * m2859getAlphaimpl2) + ((Color.m2862getGreenimpl(j2) * m2859getAlphaimpl) * f)) / f2, i == 0 ? 0.0f : ((Color.m2860getBlueimpl(m2854convertvNxB06k) * m2859getAlphaimpl2) + ((Color.m2860getBlueimpl(j2) * m2859getAlphaimpl) * f)) / f2, f2, Color.m2861getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    private static final float[] m2903getComponents8_81llA(long j) {
        return new float[]{Color.m2863getRedimpl(j), Color.m2862getGreenimpl(j), Color.m2860getBlueimpl(j), Color.m2859getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m2909luminance8_81llA(long j) {
        ColorSpace m2861getColorSpaceimpl = Color.m2861getColorSpaceimpl(j);
        if (!ColorModel.m3254equalsimpl0(m2861getColorSpaceimpl.m3263getModelxdoWZVw(), ColorModel.Companion.m3261getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m3257toStringimpl(m2861getColorSpaceimpl.m3263getModelxdoWZVw()))).toString());
        }
        Intrinsics.checkNotNull(m2861getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) m2861getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m2863getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m2862getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m2860getBlueimpl(j)) * 0.0722d)));
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m2911toArgb8_81llA(long j) {
        return (int) ULong.m5823constructorimpl(Color.m2854convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m2904isSpecified8_81llA(long j) {
        return j != Color.Companion.m2893getUnspecified0d7_KjU();
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m2906isUnspecified8_81llA(long j) {
        return j == Color.Companion.m2893getUnspecified0d7_KjU();
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m2910takeOrElseDxMtmZc(long j, Functions<Color> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return (j > Color.Companion.m2893getUnspecified0d7_KjU() ? 1 : (j == Color.Companion.m2893getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? j : block.invoke().m2867unboximpl();
    }
}
