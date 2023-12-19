package androidx.compose.p002ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Offset.kt */
@Metadata(m41d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 92\u00020\u0001:\u00019B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ*\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\b(\u0010)J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001e\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J!\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019J!\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, m40d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
@JvmInline
/* renamed from: androidx.compose.ui.geometry.Offset */
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Offset m2608boximpl(long j) {
        return new Offset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2611constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2615equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m2629unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2616equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2621hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2615equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2621hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2629unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m2619getXimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m2620getYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m2609component1impl(long j) {
        return m2619getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2610component2impl(long j) {
        return m2620getYimpl(j);
    }

    /* renamed from: copy-dBAh8RU  reason: not valid java name */
    public static final long m2612copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: copy-dBAh8RU$default  reason: not valid java name */
    public static /* synthetic */ long m2613copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2619getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2620getYimpl(j);
        }
        return m2612copydBAh8RU(j, f, f2);
    }

    /* compiled from: Offset.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R'\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, m40d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.geometry.Offset$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getInfinite-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2630getInfiniteF1C5BW0$annotations() {
        }

        /* renamed from: getUnspecified-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2631getUnspecifiedF1C5BW0$annotations() {
        }

        /* renamed from: getZero-F1C5BW0$annotations  reason: not valid java name */
        public static /* synthetic */ void m2632getZeroF1C5BW0$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-F1C5BW0  reason: not valid java name */
        public final long m2635getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* renamed from: getInfinite-F1C5BW0  reason: not valid java name */
        public final long m2633getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0  reason: not valid java name */
        public final long m2634getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* renamed from: isValid-impl  reason: not valid java name */
    public static final boolean m2622isValidimpl(long j) {
        if ((Float.isNaN(m2619getXimpl(j)) || Float.isNaN(m2620getYimpl(j))) ? false : true) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m2617getDistanceimpl(long j) {
        return (float) Math.sqrt((m2619getXimpl(j) * m2619getXimpl(j)) + (m2620getYimpl(j) * m2620getYimpl(j)));
    }

    /* renamed from: getDistanceSquared-impl  reason: not valid java name */
    public static final float m2618getDistanceSquaredimpl(long j) {
        return (m2619getXimpl(j) * m2619getXimpl(j)) + (m2620getYimpl(j) * m2620getYimpl(j));
    }

    /* renamed from: unaryMinus-F1C5BW0  reason: not valid java name */
    public static final long m2628unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m2619getXimpl(j), -m2620getYimpl(j));
    }

    /* renamed from: minus-MK-Hz9U  reason: not valid java name */
    public static final long m2623minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2619getXimpl(j) - m2619getXimpl(j2), m2620getYimpl(j) - m2620getYimpl(j2));
    }

    /* renamed from: plus-MK-Hz9U  reason: not valid java name */
    public static final long m2624plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2619getXimpl(j) + m2619getXimpl(j2), m2620getYimpl(j) + m2620getYimpl(j2));
    }

    /* renamed from: times-tuRUvjQ  reason: not valid java name */
    public static final long m2626timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2619getXimpl(j) * f, m2620getYimpl(j) * f);
    }

    /* renamed from: div-tuRUvjQ  reason: not valid java name */
    public static final long m2614divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2619getXimpl(j) / f, m2620getYimpl(j) / f);
    }

    /* renamed from: rem-tuRUvjQ  reason: not valid java name */
    public static final long m2625remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2619getXimpl(j) % f, m2620getYimpl(j) % f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2627toStringimpl(long j) {
        return OffsetKt.m2638isSpecifiedk4lQ0M(j) ? "Offset(" + GeometryUtils.toStringAsFixed(m2619getXimpl(j), 1) + ", " + GeometryUtils.toStringAsFixed(m2620getYimpl(j), 1) + ')' : "Offset.Unspecified";
    }

    public String toString() {
        return m2627toStringimpl(this.packedValue);
    }
}
