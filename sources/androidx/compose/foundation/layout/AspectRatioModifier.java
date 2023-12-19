package androidx.compose.foundation.layout;

import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.LayoutModifier;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.p002ui.platform.InspectorValueInfo;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.ConstraintsKt;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AspectRatio.kt */
@Metadata(m41d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, m40d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
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

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo326measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m677findSizeToXhtMw = m677findSizeToXhtMw(j);
        if (!IntSize.m5509equalsimpl0(m677findSizeToXhtMw, IntSize.Companion.m5516getZeroYbymL2g())) {
            j = Constraints.Companion.m5315fixedJhjzzOo(IntSize.m5511getWidthimpl(m677findSizeToXhtMw), IntSize.m5510getHeightimpl(m677findSizeToXhtMw));
        }
        final Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(j);
        return MeasureScope.layout$default(measure, mo4376measureBRTryo0.getWidth(), mo4376measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioModifier$measure$1
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

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m677findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long m681tryMaxWidthJN0ABg$default = m681tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m681tryMaxWidthJN0ABg$default, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m681tryMaxWidthJN0ABg$default;
            }
            long m679tryMaxHeightJN0ABg$default = m679tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m679tryMaxHeightJN0ABg$default, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m679tryMaxHeightJN0ABg$default;
            }
            long m685tryMinWidthJN0ABg$default = m685tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m685tryMinWidthJN0ABg$default, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m685tryMinWidthJN0ABg$default;
            }
            long m683tryMinHeightJN0ABg$default = m683tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m683tryMinHeightJN0ABg$default, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m683tryMinHeightJN0ABg$default;
            }
            long m680tryMaxWidthJN0ABg = m680tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m680tryMaxWidthJN0ABg, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m680tryMaxWidthJN0ABg;
            }
            long m678tryMaxHeightJN0ABg = m678tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m678tryMaxHeightJN0ABg, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m678tryMaxHeightJN0ABg;
            }
            long m684tryMinWidthJN0ABg = m684tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m684tryMinWidthJN0ABg, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m684tryMinWidthJN0ABg;
            }
            long m682tryMinHeightJN0ABg = m682tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m682tryMinHeightJN0ABg, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m682tryMinHeightJN0ABg;
            }
        } else {
            long m679tryMaxHeightJN0ABg$default2 = m679tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m679tryMaxHeightJN0ABg$default2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m679tryMaxHeightJN0ABg$default2;
            }
            long m681tryMaxWidthJN0ABg$default2 = m681tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m681tryMaxWidthJN0ABg$default2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m681tryMaxWidthJN0ABg$default2;
            }
            long m683tryMinHeightJN0ABg$default2 = m683tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m683tryMinHeightJN0ABg$default2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m683tryMinHeightJN0ABg$default2;
            }
            long m685tryMinWidthJN0ABg$default2 = m685tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5509equalsimpl0(m685tryMinWidthJN0ABg$default2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m685tryMinWidthJN0ABg$default2;
            }
            long m678tryMaxHeightJN0ABg2 = m678tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m678tryMaxHeightJN0ABg2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m678tryMaxHeightJN0ABg2;
            }
            long m680tryMaxWidthJN0ABg2 = m680tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m680tryMaxWidthJN0ABg2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m680tryMaxWidthJN0ABg2;
            }
            long m682tryMinHeightJN0ABg2 = m682tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m682tryMinHeightJN0ABg2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m682tryMinHeightJN0ABg2;
            }
            long m684tryMinWidthJN0ABg2 = m684tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5509equalsimpl0(m684tryMinWidthJN0ABg2, IntSize.Companion.m5516getZeroYbymL2g())) {
                return m684tryMinWidthJN0ABg2;
            }
        }
        return IntSize.Companion.m5516getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m681tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m680tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m680tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5307getMaxWidthimpl = Constraints.m5307getMaxWidthimpl(j);
        if (m5307getMaxWidthimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5307getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m5307getMaxWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5322isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5516getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m679tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m678tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m678tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5306getMaxHeightimpl = Constraints.m5306getMaxHeightimpl(j);
        if (m5306getMaxHeightimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5306getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5306getMaxHeightimpl);
            if (!z || ConstraintsKt.m5322isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5516getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m685tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m684tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m684tryMinWidthJN0ABg(long j, boolean z) {
        int m5309getMinWidthimpl = Constraints.m5309getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(m5309getMinWidthimpl / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(m5309getMinWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5322isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5516getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m683tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m682tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m682tryMinHeightJN0ABg(long j, boolean z) {
        int m5308getMinHeightimpl = Constraints.m5308getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(m5308getMinHeightimpl * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5308getMinHeightimpl);
            if (!z || ConstraintsKt.m5322isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5516getZeroYbymL2g();
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
