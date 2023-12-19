package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0003\u001a\u00020\u0004X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0012\u0013\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/Brush;", "", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Brush {
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI  reason: not valid java name */
    public abstract void mo2503applyToPq9zytI(long j, Paint paint, float f);

    private Brush() {
        this.intrinsicSize = Size.Companion.m2395getUnspecifiedNHjbRc();
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long mo2504getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    /* compiled from: Brush.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J_\u0010\u0003\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0003\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0012J_\u0010\u0013\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0019J_\u0010\u001a\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010\u001a\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001fJK\u0010 \u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J-\u0010 \u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010#J_\u0010$\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u000fJA\u0010$\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", "", "()V", "horizontalGradient", "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "startX", "endX", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "horizontalGradient-8A-3gB4", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "linearGradient", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "radialGradient", "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: linearGradient-mHitzGk$default  reason: not valid java name */
        public static /* synthetic */ Brush m2508linearGradientmHitzGk$default(Companion companion, Pair[] pairArr, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2334getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2332getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2518linearGradientmHitzGk(pairArr, j3, j4, i);
        }

        /* renamed from: linearGradient-mHitzGk  reason: not valid java name */
        public final Brush m2518linearGradientmHitzGk(Pair<Float, Color>[] colorStops, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m2546boximpl(pair.getSecond().m2566unboximpl()));
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList3.add(Float.valueOf(pair2.getFirst().floatValue()));
            }
            return new LinearGradient(arrayList2, arrayList3, j, j2, i, null);
        }

        /* renamed from: linearGradient-mHitzGk$default  reason: not valid java name */
        public static /* synthetic */ Brush m2507linearGradientmHitzGk$default(Companion companion, List list, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2334getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2332getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2517linearGradientmHitzGk(list, j3, j4, i);
        }

        /* renamed from: linearGradient-mHitzGk  reason: not valid java name */
        public final Brush m2517linearGradientmHitzGk(List<Color> colors, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new LinearGradient(colors, null, j, j2, i, null);
        }

        /* renamed from: horizontalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2505horizontalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2515horizontalGradient8A3gB4(list, f, f2, i);
        }

        /* renamed from: horizontalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2515horizontalGradient8A3gB4(List<Color> colors, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return m2517linearGradientmHitzGk(colors, OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        /* renamed from: horizontalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2506horizontalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2516horizontalGradient8A3gB4(pairArr, f, f2, i);
        }

        /* renamed from: horizontalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2516horizontalGradient8A3gB4(Pair<Float, Color>[] colorStops, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(colorStops, "colorStops");
            return m2518linearGradientmHitzGk((Pair[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        /* renamed from: verticalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2513verticalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2523verticalGradient8A3gB4(list, f, f2, i);
        }

        /* renamed from: verticalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2523verticalGradient8A3gB4(List<Color> colors, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return m2517linearGradientmHitzGk(colors, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        /* renamed from: verticalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2514verticalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2524verticalGradient8A3gB4(pairArr, f, f2, i);
        }

        /* renamed from: verticalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2524verticalGradient8A3gB4(Pair<Float, Color>[] colorStops, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(colorStops, "colorStops");
            return m2518linearGradientmHitzGk((Pair[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default  reason: not valid java name */
        public static /* synthetic */ Brush m2510radialGradientP_VxKs$default(Companion companion, Pair[] pairArr, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2333getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                f = Float.POSITIVE_INFINITY;
            }
            float f2 = f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2520radialGradientP_VxKs(pairArr, j2, f2, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks  reason: not valid java name */
        public final Brush m2520radialGradientP_VxKs(Pair<Float, Color>[] colorStops, long j, float f, int i) {
            Intrinsics.checkNotNullParameter(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m2546boximpl(pair.getSecond().m2566unboximpl()));
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList3.add(Float.valueOf(pair2.getFirst().floatValue()));
            }
            return new RadialGradient(arrayList2, arrayList3, j, f, i, null);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default  reason: not valid java name */
        public static /* synthetic */ Brush m2509radialGradientP_VxKs$default(Companion companion, List list, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2333getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                f = Float.POSITIVE_INFINITY;
            }
            float f2 = f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m2919getClamp3opZhB0();
            }
            return companion.m2519radialGradientP_VxKs(list, j2, f2, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks  reason: not valid java name */
        public final Brush m2519radialGradientP_VxKs(List<Color> colors, long j, float f, int i) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new RadialGradient(colors, null, j, f, i, null);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default  reason: not valid java name */
        public static /* synthetic */ Brush m2512sweepGradientUv8p0NA$default(Companion companion, Pair[] pairArr, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2333getUnspecifiedF1C5BW0();
            }
            return companion.m2522sweepGradientUv8p0NA(pairArr, j);
        }

        /* renamed from: sweepGradient-Uv8p0NA  reason: not valid java name */
        public final Brush m2522sweepGradientUv8p0NA(Pair<Float, Color>[] colorStops, long j) {
            Intrinsics.checkNotNullParameter(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m2546boximpl(pair.getSecond().m2566unboximpl()));
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList3.add(Float.valueOf(pair2.getFirst().floatValue()));
            }
            return new SweepGradient(j, arrayList2, arrayList3, null);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default  reason: not valid java name */
        public static /* synthetic */ Brush m2511sweepGradientUv8p0NA$default(Companion companion, List list, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2333getUnspecifiedF1C5BW0();
            }
            return companion.m2521sweepGradientUv8p0NA(list, j);
        }

        /* renamed from: sweepGradient-Uv8p0NA  reason: not valid java name */
        public final Brush m2521sweepGradientUv8p0NA(List<Color> colors, long j) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new SweepGradient(j, colors, null, null);
        }
    }
}
