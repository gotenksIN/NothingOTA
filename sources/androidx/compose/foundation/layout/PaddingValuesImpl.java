package androidx.compose.foundation.layout;

import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
@Metadata(m41d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R'\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR'\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR'\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR'\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m40d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class PaddingValuesImpl implements PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m729getBottomD9Ej5fM$annotations() {
    }

    /* renamed from: getEnd-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m730getEndD9Ej5fM$annotations() {
    }

    /* renamed from: getStart-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m731getStartD9Ej5fM$annotations() {
    }

    /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m732getTopD9Ej5fM$annotations() {
    }

    private PaddingValuesImpl(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m735getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m736getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m734getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m733getBottomD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateLeftPadding-u2uoSUM */
    public float mo697calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateTopPadding-D9Ej5fM */
    public float mo699calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateRightPadding-u2uoSUM */
    public float mo698calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateBottomPadding-D9Ej5fM */
    public float mo696calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PaddingValuesImpl) {
            PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
            return C0780Dp.m5356equalsimpl0(this.start, paddingValuesImpl.start) && C0780Dp.m5356equalsimpl0(this.top, paddingValuesImpl.top) && C0780Dp.m5356equalsimpl0(this.end, paddingValuesImpl.end) && C0780Dp.m5356equalsimpl0(this.bottom, paddingValuesImpl.bottom);
        }
        return false;
    }

    public int hashCode() {
        return (((((C0780Dp.m5357hashCodeimpl(this.start) * 31) + C0780Dp.m5357hashCodeimpl(this.top)) * 31) + C0780Dp.m5357hashCodeimpl(this.end)) * 31) + C0780Dp.m5357hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) C0780Dp.m5362toStringimpl(this.start)) + ", top=" + ((Object) C0780Dp.m5362toStringimpl(this.top)) + ", end=" + ((Object) C0780Dp.m5362toStringimpl(this.end)) + ", bottom=" + ((Object) C0780Dp.m5362toStringimpl(this.bottom)) + ')';
    }

    public /* synthetic */ PaddingValuesImpl(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0780Dp.m5351constructorimpl(0) : f, (i & 2) != 0 ? C0780Dp.m5351constructorimpl(0) : f2, (i & 4) != 0 ? C0780Dp.m5351constructorimpl(0) : f3, (i & 8) != 0 ? C0780Dp.m5351constructorimpl(0) : f4, null);
    }
}
