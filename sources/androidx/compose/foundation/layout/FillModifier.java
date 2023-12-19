package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FillModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;FLkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FillModifier extends InspectorValueInfo implements LayoutModifier {
    private final Direction direction;
    private final float fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillModifier(Direction direction, float f, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo25measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int m5008getMinWidthimpl;
        int m5006getMaxWidthimpl;
        int m5005getMaxHeightimpl;
        int i;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (Constraints.m5002getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            m5008getMinWidthimpl = RangesKt.coerceIn(MathKt.roundToInt(Constraints.m5006getMaxWidthimpl(j) * this.fraction), Constraints.m5008getMinWidthimpl(j), Constraints.m5006getMaxWidthimpl(j));
            m5006getMaxWidthimpl = m5008getMinWidthimpl;
        } else {
            m5008getMinWidthimpl = Constraints.m5008getMinWidthimpl(j);
            m5006getMaxWidthimpl = Constraints.m5006getMaxWidthimpl(j);
        }
        if (Constraints.m5001getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            i = RangesKt.coerceIn(MathKt.roundToInt(Constraints.m5005getMaxHeightimpl(j) * this.fraction), Constraints.m5007getMinHeightimpl(j), Constraints.m5005getMaxHeightimpl(j));
            m5005getMaxHeightimpl = i;
        } else {
            int m5007getMinHeightimpl = Constraints.m5007getMinHeightimpl(j);
            m5005getMaxHeightimpl = Constraints.m5005getMaxHeightimpl(j);
            i = m5007getMinHeightimpl;
        }
        final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(ConstraintsKt.Constraints(m5008getMinWidthimpl, m5006getMaxWidthimpl, i, m5005getMaxHeightimpl));
        return MeasureScope.layout$default(measure, mo4075measureBRTryo0.getWidth(), mo4075measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillModifier$measure$1
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

    public boolean equals(Object obj) {
        if (obj instanceof FillModifier) {
            FillModifier fillModifier = (FillModifier) obj;
            if (this.direction == fillModifier.direction) {
                return (this.fraction > fillModifier.fraction ? 1 : (this.fraction == fillModifier.fraction ? 0 : -1)) == 0;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.direction.hashCode() * 31) + Float.hashCode(this.fraction);
    }
}
