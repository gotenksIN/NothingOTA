package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010&\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, function1);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m5070getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5070getUnspecifiedD9Ej5fM() : f2, function1, null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m471getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m470getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    private UnspecifiedConstraintsModifier(float f, float f2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo25measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m5008getMinWidthimpl;
        int m5007getMinHeightimpl;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!Dp.m5055equalsimpl0(this.minWidth, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) && Constraints.m5008getMinWidthimpl(j) == 0) {
            m5008getMinWidthimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measure.mo296roundToPx0680j_4(this.minWidth), Constraints.m5006getMaxWidthimpl(j)), 0);
        } else {
            m5008getMinWidthimpl = Constraints.m5008getMinWidthimpl(j);
        }
        int m5006getMaxWidthimpl = Constraints.m5006getMaxWidthimpl(j);
        if (!Dp.m5055equalsimpl0(this.minHeight, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) && Constraints.m5007getMinHeightimpl(j) == 0) {
            m5007getMinHeightimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measure.mo296roundToPx0680j_4(this.minHeight), Constraints.m5005getMaxHeightimpl(j)), 0);
        } else {
            m5007getMinHeightimpl = Constraints.m5007getMinHeightimpl(j);
        }
        final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(ConstraintsKt.Constraints(m5008getMinWidthimpl, m5006getMaxWidthimpl, m5007getMinHeightimpl, Constraints.m5005getMaxHeightimpl(j)));
        return MeasureScope.layout$default(measure, mo4075measureBRTryo0.getWidth(), mo4075measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsModifier$measure$1
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

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(i), !Dp.m5055equalsimpl0(this.minWidth, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo296roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(i), !Dp.m5055equalsimpl0(this.minWidth, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo296roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(i), !Dp.m5055equalsimpl0(this.minHeight, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo296roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(i), !Dp.m5055equalsimpl0(this.minHeight, Dp.Companion.m5070getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo296roundToPx0680j_4(this.minHeight) : 0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof UnspecifiedConstraintsModifier) {
            UnspecifiedConstraintsModifier unspecifiedConstraintsModifier = (UnspecifiedConstraintsModifier) obj;
            return Dp.m5055equalsimpl0(this.minWidth, unspecifiedConstraintsModifier.minWidth) && Dp.m5055equalsimpl0(this.minHeight, unspecifiedConstraintsModifier.minHeight);
        }
        return false;
    }

    public int hashCode() {
        return (Dp.m5056hashCodeimpl(this.minWidth) * 31) + Dp.m5056hashCodeimpl(this.minHeight);
    }
}
