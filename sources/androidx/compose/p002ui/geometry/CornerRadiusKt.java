package androidx.compose.p002ui.geometry;

import androidx.compose.p002ui.util.MathHelpers;
import kotlin.Metadata;

/* compiled from: CornerRadius.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m40d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.geometry.CornerRadiusKt */
/* loaded from: classes.dex */
public final class CornerRadiusKt {
    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }

    /* renamed from: lerp-3Ry4LBc  reason: not valid java name */
    public static final long m2605lerp3Ry4LBc(long j, long j2, float f) {
        return CornerRadius(MathHelpers.lerp(CornerRadius.m2594getXimpl(j), CornerRadius.m2594getXimpl(j2), f), MathHelpers.lerp(CornerRadius.m2595getYimpl(j), CornerRadius.m2595getYimpl(j2), f));
    }

    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.m2588constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }
}
