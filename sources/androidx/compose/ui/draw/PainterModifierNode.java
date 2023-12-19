package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010/J\b\u00104\u001a\u000205H\u0016J\f\u00106\u001a\u000207*\u000208H\u0016J\u0019\u00109\u001a\u00020\u0007*\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u0007*\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010;J\u001c\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020?H\u0016J\u001c\u0010D\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020?H\u0016J)\u0010F\u001a\u00020G*\u00020H2\u0006\u0010A\u001a\u00020I2\u0006\u00102\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010KJ\u001c\u0010L\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020?H\u0016J\u001c\u0010M\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020?H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006N"}, d2 = {"Landroidx/compose/ui/draw/PainterModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            return (this.painter.mo3165getIntrinsicSizeNHjbRc() > Size.Companion.m2395getUnspecifiedNHjbRc() ? 1 : (this.painter.mo3165getIntrinsicSizeNHjbRc() == Size.Companion.m2395getUnspecifiedNHjbRc() ? 0 : -1)) != 0;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult mo2233measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(m2232modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measure, mo4075measureBRTryo0.getWidth(), mo4075measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifierNode$measure$1
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

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2232modifyConstraintsZezNO4M = m2232modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m5008getMinWidthimpl(m2232modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2232modifyConstraintsZezNO4M = m2232modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m5008getMinWidthimpl(m2232modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2232modifyConstraintsZezNO4M = m2232modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m5007getMinHeightimpl(m2232modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2232modifyConstraintsZezNO4M = m2232modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m5007getMinHeightimpl(m2232modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m2229calculateScaledSizeE7KxVPU(long j) {
        float m2387getWidthimpl;
        float m2384getHeightimpl;
        if (getUseIntrinsicSize()) {
            if (!m2231hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo3165getIntrinsicSizeNHjbRc())) {
                m2387getWidthimpl = Size.m2387getWidthimpl(j);
            } else {
                m2387getWidthimpl = Size.m2387getWidthimpl(this.painter.mo3165getIntrinsicSizeNHjbRc());
            }
            if (!m2230hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo3165getIntrinsicSizeNHjbRc())) {
                m2384getHeightimpl = Size.m2384getHeightimpl(j);
            } else {
                m2384getHeightimpl = Size.m2384getHeightimpl(this.painter.mo3165getIntrinsicSizeNHjbRc());
            }
            long Size = SizeKt.Size(m2387getWidthimpl, m2384getHeightimpl);
            if (!(Size.m2387getWidthimpl(j) == 0.0f)) {
                if (!(Size.m2384getHeightimpl(j) == 0.0f)) {
                    return ScaleFactorKt.m4157timesUQTWf7w(Size, this.contentScale.mo4066computeScaleFactorH7hwNQA(Size, j));
                }
            }
            return Size.Companion.m2396getZeroNHjbRc();
        }
        return j;
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m2232modifyConstraintsZezNO4M(long j) {
        int m5008getMinWidthimpl;
        int m5007getMinHeightimpl;
        boolean z = true;
        boolean z2 = Constraints.m5002getHasBoundedWidthimpl(j) && Constraints.m5001getHasBoundedHeightimpl(j);
        if (!Constraints.m5004getHasFixedWidthimpl(j) || !Constraints.m5003getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m4997copyZbe2FdA$default(j, Constraints.m5006getMaxWidthimpl(j), 0, Constraints.m5005getMaxHeightimpl(j), 0, 10, null);
        }
        long mo3165getIntrinsicSizeNHjbRc = this.painter.mo3165getIntrinsicSizeNHjbRc();
        if (m2231hasSpecifiedAndFiniteWidthuvyYCjk(mo3165getIntrinsicSizeNHjbRc)) {
            m5008getMinWidthimpl = MathKt.roundToInt(Size.m2387getWidthimpl(mo3165getIntrinsicSizeNHjbRc));
        } else {
            m5008getMinWidthimpl = Constraints.m5008getMinWidthimpl(j);
        }
        if (m2230hasSpecifiedAndFiniteHeightuvyYCjk(mo3165getIntrinsicSizeNHjbRc)) {
            m5007getMinHeightimpl = MathKt.roundToInt(Size.m2384getHeightimpl(mo3165getIntrinsicSizeNHjbRc));
        } else {
            m5007getMinHeightimpl = Constraints.m5007getMinHeightimpl(j);
        }
        long m2229calculateScaledSizeE7KxVPU = m2229calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m5020constrainWidthK40F9xA(j, m5008getMinWidthimpl), ConstraintsKt.m5019constrainHeightK40F9xA(j, m5007getMinHeightimpl)));
        return Constraints.m4997copyZbe2FdA$default(j, ConstraintsKt.m5020constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m2387getWidthimpl(m2229calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5019constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m2384getHeightimpl(m2229calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float m2387getWidthimpl;
        float m2384getHeightimpl;
        long m2396getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo3165getIntrinsicSizeNHjbRc = this.painter.mo3165getIntrinsicSizeNHjbRc();
        if (m2231hasSpecifiedAndFiniteWidthuvyYCjk(mo3165getIntrinsicSizeNHjbRc)) {
            m2387getWidthimpl = Size.m2387getWidthimpl(mo3165getIntrinsicSizeNHjbRc);
        } else {
            m2387getWidthimpl = Size.m2387getWidthimpl(contentDrawScope.mo3096getSizeNHjbRc());
        }
        if (m2230hasSpecifiedAndFiniteHeightuvyYCjk(mo3165getIntrinsicSizeNHjbRc)) {
            m2384getHeightimpl = Size.m2384getHeightimpl(mo3165getIntrinsicSizeNHjbRc);
        } else {
            m2384getHeightimpl = Size.m2384getHeightimpl(contentDrawScope.mo3096getSizeNHjbRc());
        }
        long Size = SizeKt.Size(m2387getWidthimpl, m2384getHeightimpl);
        if (!(Size.m2387getWidthimpl(contentDrawScope.mo3096getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m2384getHeightimpl(contentDrawScope.mo3096getSizeNHjbRc()) == 0.0f)) {
                m2396getZeroNHjbRc = ScaleFactorKt.m4157timesUQTWf7w(Size, this.contentScale.mo4066computeScaleFactorH7hwNQA(Size, contentDrawScope.mo3096getSizeNHjbRc()));
                long j = m2396getZeroNHjbRc;
                long mo2212alignKFBX0sM = this.alignment.mo2212alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2387getWidthimpl(j)), MathKt.roundToInt(Size.m2384getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2387getWidthimpl(contentDrawScope.mo3096getSizeNHjbRc())), MathKt.roundToInt(Size.m2384getHeightimpl(contentDrawScope.mo3096getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float m5168getXimpl = IntOffset.m5168getXimpl(mo2212alignKFBX0sM);
                float m5169getYimpl = IntOffset.m5169getYimpl(mo2212alignKFBX0sM);
                ContentDrawScope contentDrawScope2 = contentDrawScope;
                contentDrawScope2.getDrawContext().getTransform().translate(m5168getXimpl, m5169getYimpl);
                this.painter.m3171drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
                contentDrawScope2.getDrawContext().getTransform().translate(-m5168getXimpl, -m5169getYimpl);
                contentDrawScope.drawContent();
            }
        }
        m2396getZeroNHjbRc = Size.Companion.m2396getZeroNHjbRc();
        long j2 = m2396getZeroNHjbRc;
        long mo2212alignKFBX0sM2 = this.alignment.mo2212alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2387getWidthimpl(j2)), MathKt.roundToInt(Size.m2384getHeightimpl(j2))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2387getWidthimpl(contentDrawScope.mo3096getSizeNHjbRc())), MathKt.roundToInt(Size.m2384getHeightimpl(contentDrawScope.mo3096getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m5168getXimpl2 = IntOffset.m5168getXimpl(mo2212alignKFBX0sM2);
        float m5169getYimpl2 = IntOffset.m5169getYimpl(mo2212alignKFBX0sM2);
        ContentDrawScope contentDrawScope22 = contentDrawScope;
        contentDrawScope22.getDrawContext().getTransform().translate(m5168getXimpl2, m5169getYimpl2);
        this.painter.m3171drawx_KDEd0(contentDrawScope22, j2, this.alpha, this.colorFilter);
        contentDrawScope22.getDrawContext().getTransform().translate(-m5168getXimpl2, -m5169getYimpl2);
        contentDrawScope.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m2231hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m2383equalsimpl0(j, Size.Companion.m2395getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2387getWidthimpl = Size.m2387getWidthimpl(j);
        return !Float.isInfinite(m2387getWidthimpl) && !Float.isNaN(m2387getWidthimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m2230hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m2383equalsimpl0(j, Size.Companion.m2395getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2384getHeightimpl = Size.m2384getHeightimpl(j);
        return !Float.isInfinite(m2384getHeightimpl) && !Float.isNaN(m2384getHeightimpl);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
