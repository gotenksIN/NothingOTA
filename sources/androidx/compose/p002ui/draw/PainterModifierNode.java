package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.painter.Painter;
import androidx.compose.p002ui.layout.ContentScale;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.ScaleFactorKt;
import androidx.compose.p002ui.node.DrawModifierNode;
import androidx.compose.p002ui.node.LayoutModifierNode;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.ConstraintsKt;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(m41d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010/J\b\u00104\u001a\u000205H\u0016J\f\u00106\u001a\u000207*\u000208H\u0016J\u0019\u00109\u001a\u00020\u0007*\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u0007*\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010;J\u001c\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020?H\u0016J\u001c\u0010D\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020?H\u0016J)\u0010F\u001a\u00020G*\u00020H2\u0006\u0010A\u001a\u00020I2\u0006\u00102\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010KJ\u001c\u0010L\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020?H\u0016J\u001c\u0010M\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020?H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006N"}, m40d2 = {"Landroidx/compose/ui/draw/PainterModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.draw.PainterModifierNode */
/* loaded from: classes.dex */
final class PainterModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterModifierNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterModifierNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            return (this.painter.mo3466getIntrinsicSizeNHjbRc() > Size.Companion.m2696getUnspecifiedNHjbRc() ? 1 : (this.painter.mo3466getIntrinsicSizeNHjbRc() == Size.Companion.m2696getUnspecifiedNHjbRc() ? 0 : -1)) != 0;
        }
        return false;
    }

    @Override // androidx.compose.p002ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult mo2534measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(m2533modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measure, mo4376measureBRTryo0.getWidth(), mo4376measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifierNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p002ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2533modifyConstraintsZezNO4M = m2533modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m5309getMinWidthimpl(m2533modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p002ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2533modifyConstraintsZezNO4M = m2533modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m5309getMinWidthimpl(m2533modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p002ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2533modifyConstraintsZezNO4M = m2533modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m5308getMinHeightimpl(m2533modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p002ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2533modifyConstraintsZezNO4M = m2533modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m5308getMinHeightimpl(m2533modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m2530calculateScaledSizeE7KxVPU(long j) {
        float m2688getWidthimpl;
        float m2685getHeightimpl;
        if (getUseIntrinsicSize()) {
            if (!m2532hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo3466getIntrinsicSizeNHjbRc())) {
                m2688getWidthimpl = Size.m2688getWidthimpl(j);
            } else {
                m2688getWidthimpl = Size.m2688getWidthimpl(this.painter.mo3466getIntrinsicSizeNHjbRc());
            }
            if (!m2531hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo3466getIntrinsicSizeNHjbRc())) {
                m2685getHeightimpl = Size.m2685getHeightimpl(j);
            } else {
                m2685getHeightimpl = Size.m2685getHeightimpl(this.painter.mo3466getIntrinsicSizeNHjbRc());
            }
            long Size = SizeKt.Size(m2688getWidthimpl, m2685getHeightimpl);
            if (!(Size.m2688getWidthimpl(j) == 0.0f)) {
                if (!(Size.m2685getHeightimpl(j) == 0.0f)) {
                    return ScaleFactorKt.m4458timesUQTWf7w(Size, this.contentScale.mo4367computeScaleFactorH7hwNQA(Size, j));
                }
            }
            return Size.Companion.m2697getZeroNHjbRc();
        }
        return j;
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m2533modifyConstraintsZezNO4M(long j) {
        int m5309getMinWidthimpl;
        int m5308getMinHeightimpl;
        boolean z = true;
        boolean z2 = Constraints.m5303getHasBoundedWidthimpl(j) && Constraints.m5302getHasBoundedHeightimpl(j);
        if (!Constraints.m5305getHasFixedWidthimpl(j) || !Constraints.m5304getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m5298copyZbe2FdA$default(j, Constraints.m5307getMaxWidthimpl(j), 0, Constraints.m5306getMaxHeightimpl(j), 0, 10, null);
        }
        long mo3466getIntrinsicSizeNHjbRc = this.painter.mo3466getIntrinsicSizeNHjbRc();
        if (m2532hasSpecifiedAndFiniteWidthuvyYCjk(mo3466getIntrinsicSizeNHjbRc)) {
            m5309getMinWidthimpl = MathKt.roundToInt(Size.m2688getWidthimpl(mo3466getIntrinsicSizeNHjbRc));
        } else {
            m5309getMinWidthimpl = Constraints.m5309getMinWidthimpl(j);
        }
        if (m2531hasSpecifiedAndFiniteHeightuvyYCjk(mo3466getIntrinsicSizeNHjbRc)) {
            m5308getMinHeightimpl = MathKt.roundToInt(Size.m2685getHeightimpl(mo3466getIntrinsicSizeNHjbRc));
        } else {
            m5308getMinHeightimpl = Constraints.m5308getMinHeightimpl(j);
        }
        long m2530calculateScaledSizeE7KxVPU = m2530calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m5321constrainWidthK40F9xA(j, m5309getMinWidthimpl), ConstraintsKt.m5320constrainHeightK40F9xA(j, m5308getMinHeightimpl)));
        return Constraints.m5298copyZbe2FdA$default(j, ConstraintsKt.m5321constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m2688getWidthimpl(m2530calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5320constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m2685getHeightimpl(m2530calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.p002ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float m2688getWidthimpl;
        float m2685getHeightimpl;
        long m2697getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo3466getIntrinsicSizeNHjbRc = this.painter.mo3466getIntrinsicSizeNHjbRc();
        if (m2532hasSpecifiedAndFiniteWidthuvyYCjk(mo3466getIntrinsicSizeNHjbRc)) {
            m2688getWidthimpl = Size.m2688getWidthimpl(mo3466getIntrinsicSizeNHjbRc);
        } else {
            m2688getWidthimpl = Size.m2688getWidthimpl(contentDrawScope.mo3397getSizeNHjbRc());
        }
        if (m2531hasSpecifiedAndFiniteHeightuvyYCjk(mo3466getIntrinsicSizeNHjbRc)) {
            m2685getHeightimpl = Size.m2685getHeightimpl(mo3466getIntrinsicSizeNHjbRc);
        } else {
            m2685getHeightimpl = Size.m2685getHeightimpl(contentDrawScope.mo3397getSizeNHjbRc());
        }
        long Size = SizeKt.Size(m2688getWidthimpl, m2685getHeightimpl);
        if (!(Size.m2688getWidthimpl(contentDrawScope.mo3397getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m2685getHeightimpl(contentDrawScope.mo3397getSizeNHjbRc()) == 0.0f)) {
                m2697getZeroNHjbRc = ScaleFactorKt.m4458timesUQTWf7w(Size, this.contentScale.mo4367computeScaleFactorH7hwNQA(Size, contentDrawScope.mo3397getSizeNHjbRc()));
                long j = m2697getZeroNHjbRc;
                long mo2513alignKFBX0sM = this.alignment.mo2513alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2688getWidthimpl(j)), MathKt.roundToInt(Size.m2685getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2688getWidthimpl(contentDrawScope.mo3397getSizeNHjbRc())), MathKt.roundToInt(Size.m2685getHeightimpl(contentDrawScope.mo3397getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float m5469getXimpl = IntOffset.m5469getXimpl(mo2513alignKFBX0sM);
                float m5470getYimpl = IntOffset.m5470getYimpl(mo2513alignKFBX0sM);
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                contentDrawScope2.getDrawContext().getTransform().translate(m5469getXimpl, m5470getYimpl);
                this.painter.m3472drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
                contentDrawScope2.getDrawContext().getTransform().translate(-m5469getXimpl, -m5470getYimpl);
                contentDrawScope.drawContent();
            }
        }
        m2697getZeroNHjbRc = Size.Companion.m2697getZeroNHjbRc();
        long j2 = m2697getZeroNHjbRc;
        long mo2513alignKFBX0sM2 = this.alignment.mo2513alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2688getWidthimpl(j2)), MathKt.roundToInt(Size.m2685getHeightimpl(j2))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2688getWidthimpl(contentDrawScope.mo3397getSizeNHjbRc())), MathKt.roundToInt(Size.m2685getHeightimpl(contentDrawScope.mo3397getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m5469getXimpl2 = IntOffset.m5469getXimpl(mo2513alignKFBX0sM2);
        float m5470getYimpl2 = IntOffset.m5470getYimpl(mo2513alignKFBX0sM2);
        ContentDrawScope contentDrawScope22 = contentDrawScope;
        contentDrawScope22.getDrawContext().getTransform().translate(m5469getXimpl2, m5470getYimpl2);
        this.painter.m3472drawx_KDEd0(contentDrawScope22, j2, this.alpha, this.colorFilter);
        contentDrawScope22.getDrawContext().getTransform().translate(-m5469getXimpl2, -m5470getYimpl2);
        contentDrawScope.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m2532hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m2684equalsimpl0(j, Size.Companion.m2696getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2688getWidthimpl = Size.m2688getWidthimpl(j);
        return !Float.isInfinite(m2688getWidthimpl) && !Float.isNaN(m2688getWidthimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m2531hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m2684equalsimpl0(j, Size.Companion.m2696getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2685getHeightimpl = Size.m2685getHeightimpl(j);
        return !Float.isInfinite(m2685getHeightimpl) && !Float.isNaN(m2685getHeightimpl);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
