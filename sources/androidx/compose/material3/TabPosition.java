package androidx.compose.material3;

import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TabRow.kt */
@Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001a\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, m40d2 = {"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "right", "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class TabPosition {
    public static final int $stable = 0;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private TabPosition(float f, float f2) {
        this.left = f;
        this.width = f2;
    }

    /* renamed from: getLeft-D9Ej5fM  reason: not valid java name */
    public final float m1737getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m1739getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: getRight-D9Ej5fM  reason: not valid java name */
    public final float m1738getRightD9Ej5fM() {
        return C0780Dp.m5351constructorimpl(this.left + this.width);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TabPosition) {
            TabPosition tabPosition = (TabPosition) obj;
            return C0780Dp.m5356equalsimpl0(this.left, tabPosition.left) && C0780Dp.m5356equalsimpl0(this.width, tabPosition.width);
        }
        return false;
    }

    public int hashCode() {
        return (C0780Dp.m5357hashCodeimpl(this.left) * 31) + C0780Dp.m5357hashCodeimpl(this.width);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C0780Dp.m5362toStringimpl(this.left)) + ", right=" + ((Object) C0780Dp.m5362toStringimpl(m1738getRightD9Ej5fM())) + ", width=" + ((Object) C0780Dp.m5362toStringimpl(this.width)) + ')';
    }
}
