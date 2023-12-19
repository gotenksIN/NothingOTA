package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

/* compiled from: TimeSources.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m40d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnitJvm unit;
    private final Lazy zero$delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long read();

    public AbstractLongTimeSource(DurationUnitJvm unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero$delegate = LazyKt.lazy(new Functions<Long>() { // from class: kotlin.time.AbstractLongTimeSource$zero$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final Long invoke() {
                return Long.valueOf(AbstractLongTimeSource.this.read());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DurationUnitJvm getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimeSources.kt */
    @Metadata(m41d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, m40d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo6965minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m6969minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo6964elapsedNowUwyO8pc() {
            return Duration.m7009minusLRDsOJo(longSaturatedMath.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo6967plusLRDsOJo(long j) {
            DurationUnitJvm unit = this.timeSource.getUnit();
            if (Duration.m7006isInfiniteimpl(j)) {
                return new LongTimeMark(longSaturatedMath.m7103saturatingAddNuflL3o(this.startedAt, unit, j), this.timeSource, Duration.Companion.m7077getZEROUwyO8pc(), null);
            }
            long m7026truncateToUwyO8pc$kotlin_stdlib = Duration.m7026truncateToUwyO8pc$kotlin_stdlib(j, unit);
            long m7010plusLRDsOJo = Duration.m7010plusLRDsOJo(Duration.m7009minusLRDsOJo(j, m7026truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long m7103saturatingAddNuflL3o = longSaturatedMath.m7103saturatingAddNuflL3o(this.startedAt, unit, m7026truncateToUwyO8pc$kotlin_stdlib);
            long m7026truncateToUwyO8pc$kotlin_stdlib2 = Duration.m7026truncateToUwyO8pc$kotlin_stdlib(m7010plusLRDsOJo, unit);
            long m7103saturatingAddNuflL3o2 = longSaturatedMath.m7103saturatingAddNuflL3o(m7103saturatingAddNuflL3o, unit, m7026truncateToUwyO8pc$kotlin_stdlib2);
            long m7009minusLRDsOJo = Duration.m7009minusLRDsOJo(m7010plusLRDsOJo, m7026truncateToUwyO8pc$kotlin_stdlib2);
            long m6994getInWholeNanosecondsimpl = Duration.m6994getInWholeNanosecondsimpl(m7009minusLRDsOJo);
            if (m7103saturatingAddNuflL3o2 != 0 && m6994getInWholeNanosecondsimpl != 0 && (m7103saturatingAddNuflL3o2 ^ m6994getInWholeNanosecondsimpl) < 0) {
                long duration = DurationKt.toDuration(MathKt.getSign(m6994getInWholeNanosecondsimpl), unit);
                m7103saturatingAddNuflL3o2 = longSaturatedMath.m7103saturatingAddNuflL3o(m7103saturatingAddNuflL3o2, unit, duration);
                m7009minusLRDsOJo = Duration.m7009minusLRDsOJo(m7009minusLRDsOJo, duration);
            }
            if ((1 | (m7103saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                m7009minusLRDsOJo = Duration.Companion.m7077getZEROUwyO8pc();
            }
            return new LongTimeMark(m7103saturatingAddNuflL3o2, this.timeSource, m7009minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo6966minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m7010plusLRDsOJo(longSaturatedMath.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m7009minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) obj).timeSource) && Duration.m6979equalsimpl0(mo6966minusUwyO8pc((ComparableTimeMark) obj), Duration.Companion.m7077getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m7002hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m7023toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m7077getZEROUwyO8pc(), null);
    }
}
