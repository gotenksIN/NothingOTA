package androidx.compose.p002ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ColorModel.kt */
@Metadata(m41d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m40d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
@JvmInline
/* renamed from: androidx.compose.ui.graphics.colorspace.ColorModel */
/* loaded from: classes.dex */
public final class ColorModel {
    private static final long Cmyk;
    public static final Companion Companion = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorModel m3251boximpl(long j) {
        return new ColorModel(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3252constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3253equalsimpl(long j, Object obj) {
        return (obj instanceof ColorModel) && j == ((ColorModel) obj).m3258unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3254equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* renamed from: getComponentCount-impl  reason: not valid java name */
    public static final int m3255getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3256hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m3253equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3256hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3258unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ColorModel(long j) {
        this.packedValue = j;
    }

    /* compiled from: ColorModel.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m40d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "()V", "Cmyk", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getCmyk-xdoWZVw", "()J", "J", "Lab", "getLab-xdoWZVw", "Rgb", "getRgb-xdoWZVw", "Xyz", "getXyz-xdoWZVw", "ui-graphics_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.graphics.colorspace.ColorModel$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getRgb-xdoWZVw  reason: not valid java name */
        public final long m3261getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw  reason: not valid java name */
        public final long m3262getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }

        /* renamed from: getLab-xdoWZVw  reason: not valid java name */
        public final long m3260getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* renamed from: getCmyk-xdoWZVw  reason: not valid java name */
        public final long m3259getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m3252constructorimpl((0 & 4294967295L) | j2);
        Xyz = m3252constructorimpl((1 & 4294967295L) | j2);
        Lab = m3252constructorimpl(j2 | (2 & 4294967295L));
        Cmyk = m3252constructorimpl((j & 4294967295L) | (4 << 32));
    }

    public String toString() {
        return m3257toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3257toStringimpl(long j) {
        return m3254equalsimpl0(j, Rgb) ? "Rgb" : m3254equalsimpl0(j, Xyz) ? "Xyz" : m3254equalsimpl0(j, Lab) ? "Lab" : m3254equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }
}
