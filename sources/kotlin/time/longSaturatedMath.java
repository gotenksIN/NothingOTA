package kotlin.time;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(m41d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m40d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", HttpHeaders.ReferrerPolicyValues.ORIGIN, "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: kotlin.time.LongSaturatedMathKt */
/* loaded from: classes2.dex */
public final class longSaturatedMath {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-NuflL3o  reason: not valid java name */
    public static final long m7103saturatingAddNuflL3o(long j, DurationUnitJvm unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long m7020toLongimpl = Duration.m7020toLongimpl(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m7102checkInfiniteSumDefinedPjuGub4(j, j2, m7020toLongimpl);
        }
        if ((1 | (m7020toLongimpl - 1)) == Long.MAX_VALUE) {
            return m7104saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + m7020toLongimpl;
        return ((j ^ j3) & (m7020toLongimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4  reason: not valid java name */
    private static final long m7102checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m7006isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-NuflL3o  reason: not valid java name */
    private static final long m7104saturatingAddInHalvesNuflL3o(long j, DurationUnitJvm durationUnitJvm, long j2) {
        long m6977divUwyO8pc = Duration.m6977divUwyO8pc(j2, 2);
        long m7020toLongimpl = Duration.m7020toLongimpl(m6977divUwyO8pc, durationUnitJvm);
        return ((1 | (m7020toLongimpl - 1)) > Long.MAX_VALUE ? 1 : ((1 | (m7020toLongimpl - 1)) == Long.MAX_VALUE ? 0 : -1)) == 0 ? m7020toLongimpl : m7103saturatingAddNuflL3o(m7103saturatingAddNuflL3o(j, durationUnitJvm, m6977divUwyO8pc), durationUnitJvm, Duration.m7009minusLRDsOJo(j2, m6977divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.Companion.m7076getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m7075getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, DurationUnitJvm unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m7027unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnitJvm unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.Companion.m7077getZEROUwyO8pc();
            }
            return Duration.m7027unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return infinityOfSign(j);
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnitJvm durationUnitJvm) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            if (durationUnitJvm.compareTo(DurationUnitJvm.MILLISECONDS) < 0) {
                long convertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnitJvm.MILLISECONDS, durationUnitJvm);
                long j4 = (j % convertDurationUnit) - (j2 % convertDurationUnit);
                Duration.Companion companion = Duration.Companion;
                return Duration.m7010plusLRDsOJo(DurationKt.toDuration((j / convertDurationUnit) - (j2 / convertDurationUnit), DurationUnitJvm.MILLISECONDS), DurationKt.toDuration(j4, durationUnitJvm));
            }
            return Duration.m7027unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnitJvm);
    }
}