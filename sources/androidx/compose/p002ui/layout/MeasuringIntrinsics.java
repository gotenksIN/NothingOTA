package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.ConstraintsKt;
import androidx.compose.p002ui.unit.IntSizeKt;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifier.kt */
@Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013¨\u0006\u0018"}, m40d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics;", "", "()V", "maxHeight", "", "modifier", "Landroidx/compose/ui/layout/LayoutModifier;", "instrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "w", "maxHeight$ui_release", "maxWidth", "h", "maxWidth$ui_release", "minHeight", "minHeight$ui_release", "minWidth", "minWidth$ui_release", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.MeasuringIntrinsics */
/* loaded from: classes.dex */
final class MeasuringIntrinsics {
    public static final MeasuringIntrinsics INSTANCE = new MeasuringIntrinsics();

    /* compiled from: LayoutModifier.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m40d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.layout.MeasuringIntrinsics$IntrinsicMinMax */
    /* loaded from: classes.dex */
    private enum IntrinsicMinMax {
        Min,
        Max
    }

    /* compiled from: LayoutModifier.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m40d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "", "(Ljava/lang/String;I)V", HttpHeaders.WIDTH, "Height", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.layout.MeasuringIntrinsics$IntrinsicWidthHeight */
    /* loaded from: classes.dex */
    private enum IntrinsicWidthHeight {
        Width,
        Height
    }

    private MeasuringIntrinsics() {
    }

    public final int minWidth$ui_release(LayoutModifier modifier, IntrinsicMeasureScope instrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(instrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo326measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int minHeight$ui_release(LayoutModifier modifier, IntrinsicMeasureScope instrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(instrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo326measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int maxWidth$ui_release(LayoutModifier modifier, IntrinsicMeasureScope instrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(instrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo326measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int maxHeight$ui_release(LayoutModifier modifier, IntrinsicMeasureScope instrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(instrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return modifier.mo326measure3p2s80s(new IntrinsicsMeasureScope(instrinsicMeasureScope, instrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    /* compiled from: LayoutModifier.kt */
    @Metadata(m41d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, m40d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWidthHeight", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.layout.MeasuringIntrinsics$DefaultIntrinsicMeasurable */
    /* loaded from: classes.dex */
    private static final class DefaultIntrinsicMeasurable implements Measurable {
        private final IntrinsicMeasurable measurable;
        private final IntrinsicMinMax minMax;
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable measurable, IntrinsicMinMax minMax, IntrinsicWidthHeight widthHeight) {
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            Intrinsics.checkNotNullParameter(minMax, "minMax");
            Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
            this.measurable = measurable;
            this.minMax = minMax;
            this.widthHeight = widthHeight;
        }

        public final IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        public final IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        public final IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        @Override // androidx.compose.p002ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @Override // androidx.compose.p002ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo4376measureBRTryo0(long j) {
            int minIntrinsicHeight;
            int minIntrinsicWidth;
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                if (this.minMax == IntrinsicMinMax.Max) {
                    minIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.m5306getMaxHeightimpl(j));
                } else {
                    minIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.m5306getMaxHeightimpl(j));
                }
                return new EmptyPlaceable(minIntrinsicWidth, Constraints.m5306getMaxHeightimpl(j));
            }
            if (this.minMax == IntrinsicMinMax.Max) {
                minIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.m5307getMaxWidthimpl(j));
            } else {
                minIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.m5307getMaxWidthimpl(j));
            }
            return new EmptyPlaceable(Constraints.m5307getMaxWidthimpl(j), minIntrinsicHeight);
        }

        @Override // androidx.compose.p002ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            return this.measurable.minIntrinsicWidth(i);
        }

        @Override // androidx.compose.p002ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            return this.measurable.maxIntrinsicWidth(i);
        }

        @Override // androidx.compose.p002ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            return this.measurable.minIntrinsicHeight(i);
        }

        @Override // androidx.compose.p002ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            return this.measurable.maxIntrinsicHeight(i);
        }
    }

    /* compiled from: LayoutModifier.kt */
    @Metadata(m41d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0002J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0019\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010¢\u0006\u0002\b\u0012H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, m40d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "width", "", "height", "(II)V", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.layout.MeasuringIntrinsics$EmptyPlaceable */
    /* loaded from: classes.dex */
    private static final class EmptyPlaceable extends Placeable {
        @Override // androidx.compose.p002ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            return Integer.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.p002ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo4377placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        }

        public EmptyPlaceable(int i, int i2) {
            m4422setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        }
    }
}
