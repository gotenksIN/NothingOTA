package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VertexMode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class VertexMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Triangles = m2939constructorimpl(0);
    private static final int TriangleStrip = m2939constructorimpl(1);
    private static final int TriangleFan = m2939constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ VertexMode m2938boximpl(int i) {
        return new VertexMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2939constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2940equalsimpl(int i, Object obj) {
        return (obj instanceof VertexMode) && i == ((VertexMode) obj).m2944unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2941equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2942hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2940equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2942hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2944unboximpl() {
        return this.value;
    }

    private /* synthetic */ VertexMode(int i) {
        this.value = i;
    }

    /* compiled from: VertexMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode$Companion;", "", "()V", "TriangleFan", "Landroidx/compose/ui/graphics/VertexMode;", "getTriangleFan-c2xauaI", "()I", "I", "TriangleStrip", "getTriangleStrip-c2xauaI", "Triangles", "getTriangles-c2xauaI", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTriangles-c2xauaI  reason: not valid java name */
        public final int m2947getTrianglesc2xauaI() {
            return VertexMode.Triangles;
        }

        /* renamed from: getTriangleStrip-c2xauaI  reason: not valid java name */
        public final int m2946getTriangleStripc2xauaI() {
            return VertexMode.TriangleStrip;
        }

        /* renamed from: getTriangleFan-c2xauaI  reason: not valid java name */
        public final int m2945getTriangleFanc2xauaI() {
            return VertexMode.TriangleFan;
        }
    }

    public String toString() {
        return m2943toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2943toStringimpl(int i) {
        return m2941equalsimpl0(i, Triangles) ? "Triangles" : m2941equalsimpl0(i, TriangleStrip) ? "TriangleStrip" : m2941equalsimpl0(i, TriangleFan) ? "TriangleFan" : "Unknown";
    }
}