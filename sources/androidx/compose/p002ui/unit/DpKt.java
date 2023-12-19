package androidx.compose.p002ui.unit;

import androidx.compose.p002ui.util.MathHelpers;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Dp.kt */
@Metadata(m41d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a%\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a%\u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00109\u001a-\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a-\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a-\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010C\u001a&\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a&\u0010J\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010I\u001a\"\u0010L\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010I\u001a\"\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010I\u001a*\u0010R\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010A\u001a+\u0010T\u001a\u00020\b*\u00020\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0VH\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a+\u0010T\u001a\u00020\u0001*\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010VH\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010T\u001a\u00020\u0002*\u00020\u00022\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020VH\u0086\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b[\u0010Z\u001a\"\u0010\\\u001a\u00020\b*\u00020\t2\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\"\u0010\\\u001a\u00020\b*\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010I\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\"\u0010\\\u001a\u00020\b*\u00020\u00112\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010c\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\b*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\"\u0010\u0007\u001a\u00020\b*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u000f\u001a\u0004\b\f\u0010\u0010\"\"\u0010\u0007\u001a\u00020\b*\u00020\u00118Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\"\u0010\u0014\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\"\u0010\u001a\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u001e\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$\"\"\u0010\u001f\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010$\"\"\u0010'\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u001e\"\"\u0010'\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010$\"\"\u0010'\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010$\"\"\u0010.\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b/\u0010\u0017\u001a\u0004\b0\u00101\"\"\u00102\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006d"}, m40d2 = {"center", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpSize;", "getCenter-EaSLcWc$annotations", "(J)V", "getCenter-EaSLcWc", "(J)J", "dp", "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isSpecified-jo-Fl9I$annotations", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "size", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "width", "getWidth$annotations", "getWidth", "DpOffset", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "DpSize", "DpSize-YgX7TsA", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "lerp-IDex15A", "max", "a", "b", "max-YgX7TsA", "(FF)F", "min", "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "takeOrElse-itqla9I", "times", "other", "times-3ABfNKs", "(DF)F", "times-6HolHcs", "(FJ)J", "(IF)F", "(IJ)J", "ui-unit_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.unit.DpKt */
/* loaded from: classes.dex */
public final class DpKt {
    /* renamed from: getCenter-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5378getCenterEaSLcWc$annotations(long j) {
    }

    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static /* synthetic */ void getDp$annotations(float f) {
    }

    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4  reason: not valid java name */
    public static final boolean m5379isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    /* renamed from: isFinite-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5380isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5382isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5384isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isSpecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m5386isSpecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isUnspecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m5388isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m5390isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isUnspecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m5392isUnspecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isSpecified-0680j_4  reason: not valid java name */
    public static final boolean m5381isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    /* renamed from: isUnspecified-0680j_4  reason: not valid java name */
    public static final boolean m5387isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    public static final float getDp(int i) {
        return C0780Dp.m5351constructorimpl(i);
    }

    public static final float getDp(double d) {
        return C0780Dp.m5351constructorimpl((float) d);
    }

    public static final float getDp(float f) {
        return C0780Dp.m5351constructorimpl(f);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5402times3ABfNKs(float f, float f2) {
        return C0780Dp.m5351constructorimpl(f * f2);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5401times3ABfNKs(double d, float f) {
        return C0780Dp.m5351constructorimpl(((float) d) * f);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m5403times3ABfNKs(int i, float f) {
        return C0780Dp.m5351constructorimpl(i * f);
    }

    /* renamed from: min-YgX7TsA  reason: not valid java name */
    public static final float m5397minYgX7TsA(float f, float f2) {
        return C0780Dp.m5351constructorimpl(Math.min(f, f2));
    }

    /* renamed from: max-YgX7TsA  reason: not valid java name */
    public static final float m5396maxYgX7TsA(float f, float f2) {
        return C0780Dp.m5351constructorimpl(Math.max(f, f2));
    }

    /* renamed from: coerceIn-2z7ARbQ  reason: not valid java name */
    public static final float m5376coerceIn2z7ARbQ(float f, float f2, float f3) {
        return C0780Dp.m5351constructorimpl(RangesKt.coerceIn(f, f2, f3));
    }

    /* renamed from: coerceAtLeast-YgX7TsA  reason: not valid java name */
    public static final float m5374coerceAtLeastYgX7TsA(float f, float f2) {
        return C0780Dp.m5351constructorimpl(RangesKt.coerceAtLeast(f, f2));
    }

    /* renamed from: coerceAtMost-YgX7TsA  reason: not valid java name */
    public static final float m5375coerceAtMostYgX7TsA(float f, float f2) {
        return C0780Dp.m5351constructorimpl(RangesKt.coerceAtMost(f, f2));
    }

    /* renamed from: lerp-Md-fbLM  reason: not valid java name */
    public static final float m5394lerpMdfbLM(float f, float f2, float f3) {
        return C0780Dp.m5351constructorimpl(MathHelpers.lerp(f, f2, f3));
    }

    /* renamed from: isSpecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m5385isSpecifiedjoFl9I(long j) {
        return j != DpOffset.Companion.m5421getUnspecifiedRKDOV3M();
    }

    /* renamed from: isUnspecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m5391isUnspecifiedjoFl9I(long j) {
        return j == DpOffset.Companion.m5421getUnspecifiedRKDOV3M();
    }

    /* renamed from: lerp-xhh869w  reason: not valid java name */
    public static final long m5395lerpxhh869w(long j, long j2, float f) {
        return m5372DpOffsetYgX7TsA(m5394lerpMdfbLM(DpOffset.m5412getXD9Ej5fM(j), DpOffset.m5412getXD9Ej5fM(j2), f), m5394lerpMdfbLM(DpOffset.m5414getYD9Ej5fM(j), DpOffset.m5414getYD9Ej5fM(j2), f));
    }

    /* renamed from: isSpecified-EaSLcWc  reason: not valid java name */
    public static final boolean m5383isSpecifiedEaSLcWc(long j) {
        return j != DpSize.Companion.m5458getUnspecifiedMYxV2XQ();
    }

    /* renamed from: isUnspecified-EaSLcWc  reason: not valid java name */
    public static final boolean m5389isUnspecifiedEaSLcWc(long j) {
        return j == DpSize.Companion.m5458getUnspecifiedMYxV2XQ();
    }

    /* renamed from: getCenter-EaSLcWc  reason: not valid java name */
    public static final long m5377getCenterEaSLcWc(long j) {
        return m5372DpOffsetYgX7TsA(C0780Dp.m5351constructorimpl(DpSize.m5449getWidthD9Ej5fM(j) / 2.0f), C0780Dp.m5351constructorimpl(DpSize.m5447getHeightD9Ej5fM(j) / 2.0f));
    }

    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m5405times6HolHcs(int i, long j) {
        return DpSize.m5455timesGh9hcWk(j, i);
    }

    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m5404times6HolHcs(float f, long j) {
        return DpSize.m5454timesGh9hcWk(j, f);
    }

    /* renamed from: lerp-IDex15A  reason: not valid java name */
    public static final long m5393lerpIDex15A(long j, long j2, float f) {
        return m5373DpSizeYgX7TsA(m5394lerpMdfbLM(DpSize.m5449getWidthD9Ej5fM(j), DpSize.m5449getWidthD9Ej5fM(j2), f), m5394lerpMdfbLM(DpSize.m5447getHeightD9Ej5fM(j), DpSize.m5447getHeightD9Ej5fM(j2), f));
    }

    public static final float getWidth(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return C0780Dp.m5351constructorimpl(dpRect.m5435getRightD9Ej5fM() - dpRect.m5434getLeftD9Ej5fM());
    }

    public static final float getHeight(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return C0780Dp.m5351constructorimpl(dpRect.m5433getBottomD9Ej5fM() - dpRect.m5436getTopD9Ej5fM());
    }

    /* renamed from: takeOrElse-D5KLDUw  reason: not valid java name */
    public static final float m5398takeOrElseD5KLDUw(float f, Functions<C0780Dp> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return Float.isNaN(f) ^ true ? f : block.invoke().m5365unboximpl();
    }

    /* renamed from: DpOffset-YgX7TsA  reason: not valid java name */
    public static final long m5372DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m5407constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: takeOrElse-gVKV90s  reason: not valid java name */
    public static final long m5399takeOrElsegVKV90s(long j, Functions<DpOffset> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return (j > DpOffset.Companion.m5421getUnspecifiedRKDOV3M() ? 1 : (j == DpOffset.Companion.m5421getUnspecifiedRKDOV3M() ? 0 : -1)) != 0 ? j : block.invoke().m5420unboximpl();
    }

    /* renamed from: DpSize-YgX7TsA  reason: not valid java name */
    public static final long m5373DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m5440constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: takeOrElse-itqla9I  reason: not valid java name */
    public static final long m5400takeOrElseitqla9I(long j, Functions<DpSize> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return (j > DpSize.Companion.m5458getUnspecifiedMYxV2XQ() ? 1 : (j == DpSize.Companion.m5458getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? j : block.invoke().m5457unboximpl();
    }

    public static final long getSize(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return m5373DpSizeYgX7TsA(C0780Dp.m5351constructorimpl(dpRect.m5435getRightD9Ej5fM() - dpRect.m5434getLeftD9Ej5fM()), C0780Dp.m5351constructorimpl(dpRect.m5433getBottomD9Ej5fM() - dpRect.m5436getTopD9Ej5fM()));
    }
}
