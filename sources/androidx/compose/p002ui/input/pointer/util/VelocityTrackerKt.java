package androidx.compose.p002ui.input.pointer.util;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.HistoricalChange;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VelocityTracker.kt */
@Metadata(m41d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a,\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002\u001a2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016\u001a1\u0010\u0017\u001a\u00020\u0013*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m40d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "calculateImpulseVelocity", "dataPoints", "", "time", "isDataDifferential", "", "kineticEnergyToVelocity", "kineticEnergy", "polyFitLeastSquares", "x", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/pointer/PointerInputChange;", "set", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "", "dataPoint", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.input.pointer.util.VelocityTrackerKt */
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i, long j, float f) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i] = new DataPointAtTime(j, f);
            return;
        }
        dataPointAtTime.setTime(j);
        dataPointAtTime.setDataPoint(f);
    }

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange event) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            velocityTracker.m4352setCurrentPointerPositionAccumulatork4lQ0M$ui_release(event.m4258getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long m4259getPreviousPositionF1C5BW0 = event.m4259getPreviousPositionF1C5BW0();
        List<HistoricalChange> historical = event.getHistorical();
        int size = historical.size();
        int i = 0;
        while (i < size) {
            HistoricalChange historicalChange = historical.get(i);
            long m2623minusMKHz9U = Offset.m2623minusMKHz9U(historicalChange.m4188getPositionF1C5BW0(), m4259getPreviousPositionF1C5BW0);
            long m4188getPositionF1C5BW0 = historicalChange.m4188getPositionF1C5BW0();
            velocityTracker.m4352setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2624plusMKHz9U(velocityTracker.m4351getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), m2623minusMKHz9U));
            velocityTracker.m4349addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m4351getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i++;
            m4259getPreviousPositionF1C5BW0 = m4188getPositionF1C5BW0;
        }
        velocityTracker.m4352setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2624plusMKHz9U(velocityTracker.m4351getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m2623minusMKHz9U(event.m4258getPositionF1C5BW0(), m4259getPreviousPositionF1C5BW0)));
        velocityTracker.m4349addPositionUv8p0NA(event.getUptimeMillis(), velocityTracker.m4351getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    public static final List<Float> polyFitLeastSquares(List<Float> x, List<Float> y, int i) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        if (i < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        }
        if (x.isEmpty()) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        int size = i >= x.size() ? x.size() - 1 : i;
        int i2 = i + 1;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(0.0f));
        }
        ArrayList arrayList2 = arrayList;
        int size2 = x.size();
        int i4 = size + 1;
        Matrix matrix = new Matrix(i4, size2);
        for (int i5 = 0; i5 < size2; i5++) {
            matrix.set(0, i5, 1.0f);
            for (int i6 = 1; i6 < i4; i6++) {
                matrix.set(i6, i5, matrix.get(i6 - 1, i5) * x.get(i5).floatValue());
            }
        }
        Matrix matrix2 = new Matrix(i4, size2);
        Matrix matrix3 = new Matrix(i4, i4);
        int i7 = 0;
        while (i7 < i4) {
            for (int i8 = 0; i8 < size2; i8++) {
                matrix2.set(i7, i8, matrix.get(i7, i8));
            }
            for (int i9 = 0; i9 < i7; i9++) {
                float times = matrix2.getRow(i7).times(matrix2.getRow(i9));
                for (int i10 = 0; i10 < size2; i10++) {
                    matrix2.set(i7, i10, matrix2.get(i7, i10) - (matrix2.get(i9, i10) * times));
                }
            }
            float norm = matrix2.getRow(i7).norm();
            if (norm < 1.0E-6d) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float f = 1.0f / norm;
            for (int i11 = 0; i11 < size2; i11++) {
                matrix2.set(i7, i11, matrix2.get(i7, i11) * f);
            }
            int i12 = 0;
            while (i12 < i4) {
                matrix3.set(i7, i12, i12 < i7 ? 0.0f : matrix2.getRow(i7).times(matrix.getRow(i12)));
                i12++;
            }
            i7++;
        }
        Vector vector = new Vector(size2);
        for (int i13 = 0; i13 < size2; i13++) {
            vector.set(i13, y.get(i13).floatValue() * 1.0f);
        }
        int i14 = i4 - 1;
        for (int i15 = i14; -1 < i15; i15--) {
            arrayList2.set(i15, Float.valueOf(matrix2.getRow(i15).times(vector)));
            int i16 = i15 + 1;
            if (i16 <= i14) {
                int i17 = i14;
                while (true) {
                    arrayList2.set(i15, Float.valueOf(((Number) arrayList2.get(i15)).floatValue() - (matrix3.get(i15, i17) * ((Number) arrayList2.get(i17)).floatValue())));
                    if (i17 != i16) {
                        i17--;
                    }
                }
            }
            arrayList2.set(i15, Float.valueOf(((Number) arrayList2.get(i15)).floatValue() / matrix3.get(i15, i15)));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(List<Float> list, List<Float> list2, boolean z) {
        float floatValue;
        float floatValue2;
        int size = list.size();
        float f = 0.0f;
        if (size < 2) {
            return 0.0f;
        }
        if (size == 2) {
            if (list2.get(0).floatValue() == list2.get(1).floatValue()) {
                return 0.0f;
            }
            if (z) {
                floatValue2 = list.get(0).floatValue();
            } else {
                floatValue2 = list.get(0).floatValue() - list.get(1).floatValue();
            }
            return floatValue2 / (list2.get(0).floatValue() - list2.get(1).floatValue());
        }
        int i = size - 1;
        for (int i2 = i; i2 > 0; i2--) {
            int i3 = i2 - 1;
            if (!(list2.get(i2).floatValue() == list2.get(i3).floatValue())) {
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f);
                if (z) {
                    floatValue = -list.get(i3).floatValue();
                } else {
                    floatValue = list.get(i2).floatValue() - list.get(i3).floatValue();
                }
                float floatValue3 = floatValue / (list2.get(i2).floatValue() - list2.get(i3).floatValue());
                f += (floatValue3 - kineticEnergyToVelocity) * Math.abs(floatValue3);
                if (i2 == i) {
                    f *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static final float kineticEnergyToVelocity(float f) {
        return Math.signum(f) * ((float) Math.sqrt(2 * Math.abs(f)));
    }
}
