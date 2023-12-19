package androidx.compose.p002ui.graphics;

import kotlin.Metadata;

/* compiled from: Float16.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, m40d2 = {"max", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "ui-graphics_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.Float16Kt */
/* loaded from: classes.dex */
public final class Float16Kt {
    /* renamed from: min-AoSsdG0  reason: not valid java name */
    public static final short m2999minAoSsdG0(short s, short s2) {
        if (Float16.m2971isNaNimpl(s) || Float16.m2971isNaNimpl(s2)) {
            return Float16.Companion.m2993getNaNslo4al4();
        }
        return Float16.m2958compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }

    /* renamed from: max-AoSsdG0  reason: not valid java name */
    public static final short m2998maxAoSsdG0(short s, short s2) {
        if (Float16.m2971isNaNimpl(s) || Float16.m2971isNaNimpl(s2)) {
            return Float16.Companion.m2993getNaNslo4al4();
        }
        return Float16.m2958compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }
}
