package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.unit.ConstraintsKt;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(m41d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aS\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00022\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010 \u001a\u008f\u0001\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2*\u0010$\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2$\u0010.\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\u001f\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001ax\u00101\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132#\u0010*\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a>\u00101\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a9\u0010;\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010<\u001a9\u0010=\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010>\u001aS\u0010?\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u0010@\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001ax\u0010A\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132#\u0010*\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u0010@\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a)\u0010B\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010C\u001a,\u0010D\u001a\u00020E*\u00020\u00042\u0006\u0010F\u001a\u00020G2\u0006\u0010\"\u001a\u00020#2\u0006\u0010H\u001a\u00020I2\u0006\u0010\u001f\u001a\u00020\u0002H\u0000\u001a\u001c\u0010J\u001a\u00020\u0002*\u00020K2\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u00020\u0002H\u0000\u001a\u0014\u0010*\u001a\u00020\u0002*\u00020L2\u0006\u0010\"\u001a\u00020#H\u0000\u001a\u001c\u0010M\u001a\u00020\u0002*\u00020K2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0000\u001a\u0014\u00105\u001a\u00020\u0002*\u00020L2\u0006\u0010\"\u001a\u00020#H\u0000\u001a2\u0010N\u001a\u00020\u0002*\u00020K2\u0006\u0010H\u001a\u00020I2\u0006\u0010\"\u001a\u00020#2\u0014\u0010O\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020\u00050\u0010H\u0002\",\u0010\u0000\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, m40d2 = {"crossAxisColumnArrangement", "Lkotlin/Function4;", "", "", "Landroidx/compose/ui/layout/MeasureScope;", "", "crossAxisRowArrangement", "FlowColumn", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/layout/MeasurePolicy;", "flowMeasurePolicy", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "mainAxisArrangement", "Lkotlin/Function5;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangement", "flowMeasurePolicy-942rkJo", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Lkotlin/jvm/functions/Function4;I)Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicCrossAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "mainAxisAvailable", "mainAxisSpacing", "mainAxisSizes", "crossAxisSizes", "mainAxisColumnArrangement", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function5;", "mainAxisRowArrangement", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function5;", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/layout/MeasurePolicy;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowResult;", "measureHelper", "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "crossAxisMin", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "mainAxisMin", "measureAndCache", "storePlaceable", "foundation-layout_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.layout.FlowLayoutKt */
/* loaded from: classes.dex */
public final class FlowLayout {
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisRowArrangement = new Function4<Integer, int[], MeasureScope, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$crossAxisRowArrangement$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, MeasureScope measureScope, int[] iArr2) {
            invoke(num.intValue(), iArr, measureScope, iArr2);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, int[] size, MeasureScope measureScope, int[] outPosition) {
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(measureScope, "measureScope");
            Intrinsics.checkNotNullParameter(outPosition, "outPosition");
            Arrangement.INSTANCE.getTop().arrange(measureScope, i, size, outPosition);
        }
    };
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisColumnArrangement = new Function4<Integer, int[], MeasureScope, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$crossAxisColumnArrangement$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, MeasureScope measureScope, int[] iArr2) {
            invoke(num.intValue(), iArr, measureScope, iArr2);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, int[] size, MeasureScope measureScope, int[] outPosition) {
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(measureScope, "measureScope");
            Intrinsics.checkNotNullParameter(outPosition, "outPosition");
            Arrangement.INSTANCE.getStart().arrange(measureScope, i, size, measureScope.getLayoutDirection(), outPosition);
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FlowRow(androidx.compose.p002ui.Modifier r16, androidx.compose.foundation.layout.Arrangement.Horizontal r17, androidx.compose.p002ui.Alignment.Vertical r18, int r19, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayout.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FlowColumn(androidx.compose.p002ui.Modifier r16, androidx.compose.foundation.layout.Arrangement.Vertical r17, androidx.compose.p002ui.Alignment.Horizontal r18, int r19, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayout.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement(final Arrangement.Horizontal horizontal, Composer composer, int i) {
        composer.startReplaceableGroup(746410833);
        ComposerKt.sourceInformation(composer, "C(mainAxisRowArrangement)125@4646L252:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(746410833, i, -1, "androidx.compose.foundation.layout.mainAxisRowArrangement (FlowLayout.kt:123)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(horizontal);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function5) new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$mainAxisRowArrangement$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
                    invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
                    Intrinsics.checkNotNullParameter(size, "size");
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                    Arrangement.Horizontal.this.arrange(density, i2, size, layoutDirection, outPosition);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function5;
    }

    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement(final Arrangement.Vertical vertical, Composer composer, int i) {
        composer.startReplaceableGroup(-1642644113);
        ComposerKt.sourceInformation(composer, "C(mainAxisColumnArrangement)136@5068L217:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1642644113, i, -1, "androidx.compose.foundation.layout.mainAxisColumnArrangement (FlowLayout.kt:134)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(vertical);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function5) new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$mainAxisColumnArrangement$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
                    invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
                    Intrinsics.checkNotNullParameter(size, "size");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                    Arrangement.Vertical.this.arrange(density, i2, size, outPosition);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function5;
    }

    private static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Alignment.Vertical vertical, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1479255111);
        ComposerKt.sourceInformation(composer, "C(rowMeasurementHelper)P(!1,2)163@6016L45,164@6091L90,167@6193L499:FlowLayout.kt#2w3rfo");
        if ((i3 & 1) != 0) {
            horizontal = Arrangement.INSTANCE.getEnd();
        }
        if ((i3 & 2) != 0) {
            vertical = Alignment.Companion.getTop();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:158)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement = mainAxisRowArrangement(horizontal, composer, i2 & 14);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(vertical);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = CrossAxisAlignment.Companion.vertical$foundation_layout_release(vertical);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed2 = composer.changed(vertical) | composer.changed(horizontal) | composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = m695flowMeasurePolicy942rkJo(LayoutOrientation.Horizontal, mainAxisRowArrangement, horizontal.mo666getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisRowArrangement, i);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    private static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-2013098357);
        ComposerKt.sourceInformation(composer, "C(columnMeasurementHelper)P(2)186@6953L46,187@7029L96,190@7137L497:FlowLayout.kt#2w3rfo");
        if ((i3 & 1) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 2) != 0) {
            horizontal = Alignment.Companion.getStart();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:181)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement = mainAxisColumnArrangement(vertical, composer, i2 & 14);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(horizontal);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(horizontal);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed2 = composer.changed(horizontal) | composer.changed(vertical) | composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = m695flowMeasurePolicy942rkJo(LayoutOrientation.Vertical, mainAxisColumnArrangement, vertical.mo666getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisColumnArrangement, i);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* renamed from: flowMeasurePolicy-942rkJo  reason: not valid java name */
    private static final MeasurePolicy m695flowMeasurePolicy942rkJo(final LayoutOrientation layoutOrientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, final float f, final SizeMode sizeMode, final CrossAxisAlignment crossAxisAlignment, final Function4<? super Integer, ? super int[], ? super MeasureScope, ? super int[], Unit> function4, final int i) {
        return new MeasurePolicy(function5, f, sizeMode, crossAxisAlignment, i, function4) { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1
            final /* synthetic */ float $arrangementSpacing;
            final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
            final /* synthetic */ Function4<Integer, int[], MeasureScope, int[], Unit> $crossAxisArrangement;
            final /* synthetic */ SizeMode $crossAxisSize;
            final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $mainAxisArrangement;
            final /* synthetic */ int $maxItemsInMainAxis;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$mainAxisArrangement = function5;
                this.$arrangementSpacing = f;
                this.$crossAxisSize = sizeMode;
                this.$crossAxisAlignment = crossAxisAlignment;
                this.$maxItemsInMainAxis = i;
                this.$crossAxisArrangement = function4;
                this.maxMainAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                    }
                };
                this.maxCrossAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                    }
                };
                this.minCrossAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                    }
                };
                this.minMainAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                    }
                };
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo313measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long j) {
                int crossAxisTotalSize;
                int mainAxisTotalSize;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                final RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(LayoutOrientation.this, this.$mainAxisArrangement, this.$arrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, measurables, new Placeable[measurables.size()], null);
                final FlowResult breakDownItems = FlowLayout.breakDownItems(measure, rowColumnMeasurementHelper, LayoutOrientation.this, new OrientationIndependentConstraints(j, LayoutOrientation.this, null), this.$maxItemsInMainAxis);
                int crossAxisTotalSize2 = breakDownItems.getCrossAxisTotalSize();
                MutableVector<RowColumnMeasureHelperResult> items = breakDownItems.getItems();
                int size = items.getSize();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = items.getContent()[i2].getCrossAxisSize();
                }
                final int[] iArr2 = new int[size];
                this.$crossAxisArrangement.invoke(Integer.valueOf(crossAxisTotalSize2), iArr, measure, iArr2);
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    crossAxisTotalSize = breakDownItems.getMainAxisTotalSize();
                    mainAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
                } else {
                    crossAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
                    mainAxisTotalSize = breakDownItems.getMainAxisTotalSize();
                }
                return MeasureScope.layout$default(measure, ConstraintsKt.m5321constrainWidthK40F9xA(j, crossAxisTotalSize), ConstraintsKt.m5320constrainHeightK40F9xA(j, mainAxisTotalSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$measure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        MutableVector<RowColumnMeasureHelperResult> items2 = FlowResult.this.getItems();
                        RowColumnMeasurementHelper rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
                        int[] iArr3 = iArr2;
                        MeasureScope measureScope = measure;
                        int size2 = items2.getSize();
                        if (size2 > 0) {
                            RowColumnMeasureHelperResult[] content = items2.getContent();
                            int i3 = 0;
                            do {
                                rowColumnMeasurementHelper2.placeHelper(layout, content[i3], iArr3[i3], measureScope.getLayoutDirection());
                                i3++;
                            } while (i3 < size2);
                        }
                    }
                }, 4, null);
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return minIntrinsicMainAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
                }
                return intrinsicCrossAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return intrinsicCrossAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
                }
                return minIntrinsicMainAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return intrinsicCrossAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
                }
                return maxIntrinsicMainAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return maxIntrinsicMainAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
                }
                return intrinsicCrossAxisSize(measurables, i2, intrinsicMeasureScope.mo597roundToPx0680j_4(this.$arrangementSpacing));
            }

            public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int i2, int i3) {
                int minIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                minIntrinsicMainAxisSize = FlowLayout.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return minIntrinsicMainAxisSize;
            }

            public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int i2, int i3) {
                int maxIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                maxIntrinsicMainAxisSize = FlowLayout.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return maxIntrinsicMainAxisSize;
            }

            public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int i2, int i3) {
                int intrinsicCrossAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                intrinsicCrossAxisSize = FlowLayout.intrinsicCrossAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return intrinsicCrossAxisSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
                return this.maxMainAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
                return this.maxCrossAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
                return this.minCrossAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
                return this.minMainAxisIntrinsicItemSize;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r12v2, types: [kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r3v4, types: [kotlin.collections.IntIterator] */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            iArr2[i5] = 0;
        }
        int size3 = list.size();
        for (int i6 = 0; i6 < size3; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i6);
            int intValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(i)).intValue();
            iArr[i6] = intValue;
            iArr2[i6] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(intValue)).intValue();
        }
        int sum = ArraysKt.sum(iArr);
        if (!(size2 == 0)) {
            int i7 = iArr2[0];
            ?? it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
            while (it.hasNext()) {
                int i8 = iArr2[it.nextInt()];
                if (i7 < i8) {
                    i7 = i8;
                }
            }
            if (!(size == 0)) {
                int i9 = iArr[0];
                ?? it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
                while (it2.hasNext()) {
                    int i10 = iArr[it2.nextInt()];
                    if (i9 < i10) {
                        i9 = i10;
                    }
                }
                int i11 = sum;
                while (i9 < sum && i7 != i) {
                    i11 = (i9 + sum) / 2;
                    i7 = intrinsicCrossAxisSize(list, iArr, iArr2, i11, i2, i3);
                    if (i7 == i) {
                        return i11;
                    }
                    if (i7 > i) {
                        i9 = i11 + 1;
                    } else {
                        sum = i11 - 1;
                    }
                }
                return i11;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] iArr, final int[] iArr2, int i, int i2, int i3) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicCrossAxisSize, int i4, int i5) {
                Intrinsics.checkNotNullParameter(intrinsicCrossAxisSize, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(iArr[i4]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicCrossAxisSize, int i4, int i5) {
                Intrinsics.checkNotNullParameter(intrinsicCrossAxisSize, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(iArr2[i4]);
            }
        }, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        Object orNull = CollectionsKt.getOrNull(list, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) orNull;
        int intValue = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue)).intValue() : 0;
        int size = list.size();
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < size) {
            list.get(i5);
            Intrinsics.checkNotNull(orNull);
            i4 -= intValue2;
            int max = Math.max(i7, intValue);
            i5++;
            Object orNull2 = CollectionsKt.getOrNull(list, i5);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) orNull2;
            int intValue3 = intrinsicMeasurable2 != null ? function32.invoke(intrinsicMeasurable2, Integer.valueOf(i5), Integer.valueOf(i)).intValue() : 0;
            int intValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i5), Integer.valueOf(intValue3)).intValue() + i2 : 0;
            if (i4 >= 0 && i5 != list.size()) {
                if (i5 - i8 != i3 && i4 - intValue4 >= 0) {
                    int i9 = intValue3;
                    i7 = max;
                    orNull = orNull2;
                    intValue2 = intValue4;
                    intValue = i9;
                }
            }
            i6 += max;
            intValue4 -= i2;
            i4 = i;
            max = 0;
            i8 = i5;
            int i92 = intValue3;
            i7 = max;
            orNull = orNull2;
            intValue2 = intValue4;
            intValue = i92;
        }
        return i6;
    }

    public static final int mainAxisMin(Measurable measurable, LayoutOrientation orientation, int i) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return measurable.minIntrinsicWidth(i);
        }
        return measurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(Measurable measurable, LayoutOrientation orientation, int i) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return measurable.minIntrinsicHeight(i);
        }
        return measurable.minIntrinsicWidth(i);
    }

    public static final int mainAxisSize(Placeable placeable, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public static final int crossAxisSize(Placeable placeable, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    private static final int measureAndCache(Measurable measurable, OrientationIndependentConstraints orientationIndependentConstraints, LayoutOrientation layoutOrientation, Function1<? super Placeable, Unit> function1) {
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) == 0.0f) {
            Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, 0, 0, 0, 14, null).m708toBoxConstraintsOenEA2s(layoutOrientation));
            function1.invoke(mo4376measureBRTryo0);
            return mainAxisSize(mo4376measureBRTryo0, layoutOrientation);
        }
        return mainAxisMin(measurable, layoutOrientation, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < size) {
            int intValue = function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i8 = i4 + 1;
            if (i8 - i6 == i3 || i8 == list.size()) {
                i5 = Math.max(i5, i7 + intValue);
                i7 = 0;
                i6 = i4;
            } else {
                i7 += intValue;
            }
            i4 = i8;
        }
        return i5;
    }

    public static final FlowResult breakDownItems(MeasureScope measureScope, RowColumnMeasurementHelper measureHelper, LayoutOrientation orientation, OrientationIndependentConstraints constraints, int i) {
        Intrinsics.checkNotNullParameter(measureScope, "<this>");
        Intrinsics.checkNotNullParameter(measureHelper, "measureHelper");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        MutableVector mutableVector = new MutableVector(new RowColumnMeasureHelperResult[16], 0);
        int mainAxisMax = constraints.getMainAxisMax();
        int mainAxisMin = constraints.getMainAxisMin();
        int crossAxisMax = constraints.getCrossAxisMax();
        List<Measurable> measurables = measureHelper.getMeasurables();
        final Placeable[] placeables = measureHelper.getPlaceables();
        int ceil = (int) Math.ceil(measureScope.mo603toPx0680j_4(measureHelper.m738getArrangementSpacingD9Ej5fM()));
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(mainAxisMin, mainAxisMax, 0, crossAxisMax);
        Measurable measurable = (Measurable) CollectionsKt.getOrNull(measurables, 0);
        Integer valueOf = measurable != null ? Integer.valueOf(measureAndCache(measurable, orientationIndependentConstraints, orientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                invoke2(placeable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable placeable) {
                placeables[0] = placeable;
            }
        })) : null;
        Integer[] numArr = new Integer[measurables.size()];
        int size = measurables.size();
        int i2 = mainAxisMax;
        final int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < size) {
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            int i7 = i4 + intValue;
            i2 -= intValue;
            int i8 = i3 + 1;
            int i9 = mainAxisMax;
            Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(measurables, i8);
            Integer valueOf2 = measurable2 != null ? Integer.valueOf(measureAndCache(measurable2, orientationIndependentConstraints, orientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable placeable) {
                    placeables[i3 + 1] = placeable;
                }
            }) + ceil) : null;
            if (i8 < measurables.size() && i8 - i5 < i) {
                if (i2 - (valueOf2 != null ? valueOf2.intValue() : 0) >= 0) {
                    i4 = i7;
                    i3 = i8;
                    valueOf = valueOf2;
                    mainAxisMax = i9;
                }
            }
            int max = Math.max(mainAxisMin, i7);
            numArr[i6] = Integer.valueOf(i8);
            i6++;
            valueOf2 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() - ceil) : null;
            mainAxisMin = max;
            i5 = i8;
            i2 = i9;
            i4 = 0;
            i3 = i8;
            valueOf = valueOf2;
            mainAxisMax = i9;
        }
        long m708toBoxConstraintsOenEA2s = OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, mainAxisMin, 0, 0, 0, 14, null).m708toBoxConstraintsOenEA2s(orientation);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Integer num = (Integer) ArraysKt.getOrNull(numArr, 0);
        int i13 = mainAxisMin;
        while (num != null) {
            RowColumnMeasureHelperResult m739measureWithoutPlacing_EkL_Y = measureHelper.m739measureWithoutPlacing_EkL_Y(measureScope, m708toBoxConstraintsOenEA2s, i10, num.intValue());
            i11 += m739measureWithoutPlacing_EkL_Y.getCrossAxisSize();
            i13 = Math.max(i13, m739measureWithoutPlacing_EkL_Y.getMainAxisSize());
            mutableVector.add(m739measureWithoutPlacing_EkL_Y);
            i10 = num.intValue();
            i12++;
            num = (Integer) ArraysKt.getOrNull(numArr, i12);
        }
        return new FlowResult(Math.max(i13, constraints.getMainAxisMin()), Math.max(i11, constraints.getCrossAxisMin()), mutableVector);
    }
}
