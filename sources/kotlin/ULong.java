package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: ULong.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010JJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u001dJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000bJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\"J\u001e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010\u001fJ\u001e\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u001dJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bY\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bZ\u0010\u000bJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\b¢\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0016\u0010t\u001a\u00020\u000eH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010_J\u0016\u0010v\u001a\u00020\u0011H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010/J\u0016\u0010x\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010\u0005J\u0016\u0010z\u001a\u00020\u0016H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010oJ\u001b\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u007f"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* renamed from: box-impl */
    public static final /* synthetic */ ULong m5541boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl */
    public static long m5547constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m5553equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m5599unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m5554equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m5559hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toByte-impl */
    private static final byte m5587toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toInt-impl */
    private static final int m5590toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl */
    private static final long m5591toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl */
    private static final short m5592toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toULong-s-VKNKU */
    private static final long m5596toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m5553equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5559hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ long m5599unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(m5599unboximpl(), uLong.m5599unboximpl());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* compiled from: ULong.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU */
    private static final int m5542compareTo7apg3OU(long j, byte b) {
        return Long.compareUnsigned(j, m5547constructorimpl(b & 255));
    }

    /* renamed from: compareTo-xj2QHRw */
    private static final int m5546compareToxj2QHRw(long j, short s) {
        return Long.compareUnsigned(j, m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m5545compareToWZ4Q5Ns(long j, int i) {
        return Long.compareUnsigned(j, m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-VKZWuLQ */
    private int m5543compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(m5599unboximpl(), j);
    }

    /* renamed from: compareTo-VKZWuLQ */
    private static int m5544compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: plus-7apg3OU */
    private static final long m5571plus7apg3OU(long j, byte b) {
        return m5547constructorimpl(j + m5547constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw */
    private static final long m5574plusxj2QHRw(long j, short s) {
        return m5547constructorimpl(j + m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: plus-WZ4Q5Ns */
    private static final long m5573plusWZ4Q5Ns(long j, int i) {
        return m5547constructorimpl(j + m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: plus-VKZWuLQ */
    private static final long m5572plusVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j + j2);
    }

    /* renamed from: minus-7apg3OU */
    private static final long m5562minus7apg3OU(long j, byte b) {
        return m5547constructorimpl(j - m5547constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw */
    private static final long m5565minusxj2QHRw(long j, short s) {
        return m5547constructorimpl(j - m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: minus-WZ4Q5Ns */
    private static final long m5564minusWZ4Q5Ns(long j, int i) {
        return m5547constructorimpl(j - m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: minus-VKZWuLQ */
    private static final long m5563minusVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j - j2);
    }

    /* renamed from: times-7apg3OU */
    private static final long m5583times7apg3OU(long j, byte b) {
        return m5547constructorimpl(j * m5547constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw */
    private static final long m5586timesxj2QHRw(long j, short s) {
        return m5547constructorimpl(j * m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: times-WZ4Q5Ns */
    private static final long m5585timesWZ4Q5Ns(long j, int i) {
        return m5547constructorimpl(j * m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: times-VKZWuLQ */
    private static final long m5584timesVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j * j2);
    }

    /* renamed from: div-7apg3OU */
    private static final long m5549div7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m5547constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw */
    private static final long m5552divxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: div-WZ4Q5Ns */
    private static final long m5551divWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-VKZWuLQ */
    private static final long m5550divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m5726ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: rem-7apg3OU */
    private static final long m5577rem7apg3OU(long j, byte b) {
        return Long.remainderUnsigned(j, m5547constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw */
    private static final long m5580remxj2QHRw(long j, short s) {
        return Long.remainderUnsigned(j, m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: rem-WZ4Q5Ns */
    private static final long m5579remWZ4Q5Ns(long j, int i) {
        return Long.remainderUnsigned(j, m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-VKZWuLQ */
    private static final long m5578remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m5727ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: floorDiv-7apg3OU */
    private static final long m5555floorDiv7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m5547constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw */
    private static final long m5558floorDivxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: floorDiv-WZ4Q5Ns */
    private static final long m5557floorDivWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m5547constructorimpl(i & 4294967295L));
    }

    /* renamed from: floorDiv-VKZWuLQ */
    private static final long m5556floorDivVKZWuLQ(long j, long j2) {
        return Long.divideUnsigned(j, j2);
    }

    /* renamed from: mod-7apg3OU */
    private static final byte m5566mod7apg3OU(long j, byte b) {
        return UByte.m5391constructorimpl((byte) Long.remainderUnsigned(j, m5547constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw */
    private static final short m5569modxj2QHRw(long j, short s) {
        return UShort.m5654constructorimpl((short) Long.remainderUnsigned(j, m5547constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    /* renamed from: mod-WZ4Q5Ns */
    private static final int m5568modWZ4Q5Ns(long j, int i) {
        return UInt.m5468constructorimpl((int) Long.remainderUnsigned(j, m5547constructorimpl(i & 4294967295L)));
    }

    /* renamed from: mod-VKZWuLQ */
    private static final long m5567modVKZWuLQ(long j, long j2) {
        return Long.remainderUnsigned(j, j2);
    }

    /* renamed from: inc-s-VKNKU */
    private static final long m5560incsVKNKU(long j) {
        return m5547constructorimpl(j + 1);
    }

    /* renamed from: dec-s-VKNKU */
    private static final long m5548decsVKNKU(long j) {
        return m5547constructorimpl(j - 1);
    }

    /* renamed from: rangeTo-VKZWuLQ */
    private static final ULongRange m5575rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* renamed from: rangeUntil-VKZWuLQ */
    private static final ULongRange m5576rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt.m6643untileb3DHEI(j, j2);
    }

    /* renamed from: shl-s-VKNKU */
    private static final long m5581shlsVKNKU(long j, int i) {
        return m5547constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU */
    private static final long m5582shrsVKNKU(long j, int i) {
        return m5547constructorimpl(j >>> i);
    }

    /* renamed from: and-VKZWuLQ */
    private static final long m5540andVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j & j2);
    }

    /* renamed from: or-VKZWuLQ */
    private static final long m5570orVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j | j2);
    }

    /* renamed from: xor-VKZWuLQ */
    private static final long m5598xorVKZWuLQ(long j, long j2) {
        return m5547constructorimpl(j ^ j2);
    }

    /* renamed from: inv-s-VKNKU */
    private static final long m5561invsVKNKU(long j) {
        return m5547constructorimpl(~j);
    }

    /* renamed from: toUByte-w2LRezQ */
    private static final byte m5594toUBytew2LRezQ(long j) {
        return UByte.m5391constructorimpl((byte) j);
    }

    /* renamed from: toUShort-Mh2AYeg */
    private static final short m5597toUShortMh2AYeg(long j) {
        return UShort.m5654constructorimpl((short) j);
    }

    /* renamed from: toUInt-pVg5ArA */
    private static final int m5595toUIntpVg5ArA(long j) {
        return UInt.m5468constructorimpl((int) j);
    }

    /* renamed from: toFloat-impl */
    private static final float m5589toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toDouble-impl */
    private static final double m5588toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl */
    public static String m5593toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    public String toString() {
        return m5593toStringimpl(this.data);
    }
}
