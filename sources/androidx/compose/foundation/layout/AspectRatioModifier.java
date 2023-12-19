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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f, boolean z, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        if (!(f > 0.0f)) {
            throw new IllegalArgumentException(("aspectRatio " + f + " must be > 0").toString());
        }
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo25measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m376findSizeToXhtMw = m376findSizeToXhtMw(j);
        if (!IntSize.m5208equalsimpl0(m376findSizeToXhtMw, IntSize.Companion.m5215getZeroYbymL2g())) {
            j = Constraints.Companion.m5014fixedJhjzzOo(IntSize.m5210getWidthimpl(m376findSizeToXhtMw), IntSize.m5209getHeightimpl(m376findSizeToXhtMw));
        }
        final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(j);
        return MeasureScope.layout$default(measure, mo4075measureBRTryo0.getWidth(), mo4075measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioModifier$measure$1
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
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m376findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long m380tryMaxWidthJN0ABg$default = m380tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m380tryMaxWidthJN0ABg$default, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m380tryMaxWidthJN0ABg$default;
            }
            long m378tryMaxHeightJN0ABg$default = m378tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m378tryMaxHeightJN0ABg$default, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m378tryMaxHeightJN0ABg$default;
            }
            long m384tryMinWidthJN0ABg$default = m384tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m384tryMinWidthJN0ABg$default, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m384tryMinWidthJN0ABg$default;
            }
            long m382tryMinHeightJN0ABg$default = m382tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m382tryMinHeightJN0ABg$default, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m382tryMinHeightJN0ABg$default;
            }
            long m379tryMaxWidthJN0ABg = m379tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m379tryMaxWidthJN0ABg, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m379tryMaxWidthJN0ABg;
            }
            long m377tryMaxHeightJN0ABg = m377tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m377tryMaxHeightJN0ABg, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m377tryMaxHeightJN0ABg;
            }
            long m383tryMinWidthJN0ABg = m383tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m383tryMinWidthJN0ABg, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m383tryMinWidthJN0ABg;
            }
            long m381tryMinHeightJN0ABg = m381tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m381tryMinHeightJN0ABg, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m381tryMinHeightJN0ABg;
            }
        } else {
            long m378tryMaxHeightJN0ABg$default2 = m378tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m378tryMaxHeightJN0ABg$default2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m378tryMaxHeightJN0ABg$default2;
            }
            long m380tryMaxWidthJN0ABg$default2 = m380tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m380tryMaxWidthJN0ABg$default2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m380tryMaxWidthJN0ABg$default2;
            }
            long m382tryMinHeightJN0ABg$default2 = m382tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m382tryMinHeightJN0ABg$default2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m382tryMinHeightJN0ABg$default2;
            }
            long m384tryMinWidthJN0ABg$default2 = m384tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5208equalsimpl0(m384tryMinWidthJN0ABg$default2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m384tryMinWidthJN0ABg$default2;
            }
            long m377tryMaxHeightJN0ABg2 = m377tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m377tryMaxHeightJN0ABg2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m377tryMaxHeightJN0ABg2;
            }
            long m379tryMaxWidthJN0ABg2 = m379tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m379tryMaxWidthJN0ABg2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m379tryMaxWidthJN0ABg2;
            }
            long m381tryMinHeightJN0ABg2 = m381tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m381tryMinHeightJN0ABg2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m381tryMinHeightJN0ABg2;
            }
            long m383tryMinWidthJN0ABg2 = m383tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5208equalsimpl0(m383tryMinWidthJN0ABg2, IntSize.Companion.m5215getZeroYbymL2g())) {
                return m383tryMinWidthJN0ABg2;
            }
        }
        return IntSize.Companion.m5215getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m380tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m379tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m379tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5006getMaxWidthimpl = Constraints.m5006getMaxWidthimpl(j);
        if (m5006getMaxWidthimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5006getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m5006getMaxWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5021isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5215getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m378tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m377tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m377tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5005getMaxHeightimpl = Constraints.m5005getMaxHeightimpl(j);
        if (m5005getMaxHeightimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5005getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5005getMaxHeightimpl);
            if (!z || ConstraintsKt.m5021isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5215getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m384tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m383tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m383tryMinWidthJN0ABg(long j, boolean z) {
        int m5008getMinWidthimpl = Constraints.m5008getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(m5008getMinWidthimpl / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(m5008getMinWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5021isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5215getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m382tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m381tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m381tryMinHeightJN0ABg(long j, boolean z) {
        int m5007getMinHeightimpl = Constraints.m5007getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(m5007getMinHeightimpl * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5007getMinHeightimpl);
            if (!z || ConstraintsKt.m5021isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5215getZeroYbymL2g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = obj instanceof AspectRatioModifier ? (AspectRatioModifier) obj : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        return ((this.aspectRatio > aspectRatioModifier.aspectRatio ? 1 : (this.aspectRatio == aspectRatioModifier.aspectRatio ? 0 : -1)) == 0) && this.matchHeightConstraintsFirst == ((AspectRatioModifier) obj).matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.hashCode(this.aspectRatio) * 31) + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
