package androidx.compose.foundation;

import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Background.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u000e*\u00020 H\u0016J\f\u0010!\u001a\u00020\u000e*\u00020 H\u0002J\f\u0010\"\u001a\u00020\u000e*\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/foundation/Background;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "equals", "", "other", "", "hashCode", "", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Background extends InspectorValueInfo implements DrawModifier {
    private final float alpha;
    private final Brush brush;
    private final Color color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;
    private final Shape shape;

    public /* synthetic */ Background(Color color, Brush brush, float f, Shape shape, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, brush, f, shape, function1);
    }

    public /* synthetic */ Background(Color color, Brush brush, float f, Shape shape, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : brush, (i & 4) != 0 ? 1.0f : f, shape, function1, null);
    }

    private Background(Color color, Brush brush, float f, Shape shape, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.color = color;
        this.brush = brush;
        this.alpha = f;
        this.shape = shape;
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        Color color = this.color;
        if (color != null) {
            DrawScope.m3091drawRectnJ9OG0$default(contentDrawScope, color.m2566unboximpl(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            DrawScope.m3090drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, this.alpha, null, null, 0, androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, null);
        }
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline mo194createOutlinePq9zytI;
        if (Size.m2382equalsimpl(contentDrawScope.mo3096getSizeNHjbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection) {
            mo194createOutlinePq9zytI = this.lastOutline;
            Intrinsics.checkNotNull(mo194createOutlinePq9zytI);
        } else {
            mo194createOutlinePq9zytI = this.shape.mo194createOutlinePq9zytI(contentDrawScope.mo3096getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        Color color = this.color;
        if (color != null) {
            color.m2566unboximpl();
            OutlineKt.m2807drawOutlinewDX37Ww(contentDrawScope, mo194createOutlinePq9zytI, this.color.m2566unboximpl(), (r17 & 4) != 0 ? 1.0f : 0.0f, (r17 & 8) != 0 ? Fill.INSTANCE : null, (r17 & 16) != 0 ? null : null, (r17 & 32) != 0 ? DrawScope.Companion.m3097getDefaultBlendMode0nO6VwU() : 0);
        }
        Brush brush = this.brush;
        if (brush != null) {
            OutlineKt.m2806drawOutlinehn5TExg$default(contentDrawScope, mo194createOutlinePq9zytI, brush, this.alpha, null, null, 0, 56, null);
        }
        this.lastOutline = mo194createOutlinePq9zytI;
        this.lastSize = Size.m2375boximpl(contentDrawScope.mo3096getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
    }

    public int hashCode() {
        Color color = this.color;
        int m2563hashCodeimpl = (color != null ? Color.m2563hashCodeimpl(color.m2566unboximpl()) : 0) * 31;
        Brush brush = this.brush;
        return ((((m2563hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(this.alpha)) * 31) + this.shape.hashCode();
    }

    public boolean equals(Object obj) {
        Background background = obj instanceof Background ? (Background) obj : null;
        if (background != null && Intrinsics.areEqual(this.color, background.color) && Intrinsics.areEqual(this.brush, background.brush)) {
            return ((this.alpha > background.alpha ? 1 : (this.alpha == background.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.shape, background.shape);
        }
        return false;
    }

    public String toString() {
        return "Background(color=" + this.color + ", brush=" + this.brush + ", alpha = " + this.alpha + ", shape=" + this.shape + ')';
    }
}
