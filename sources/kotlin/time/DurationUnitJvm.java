package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m41d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m40d2 = {"Lkotlin/time/DurationUnit;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "getTimeUnit$kotlin_stdlib", "()Ljava/util/concurrent/TimeUnit;", "NANOSECONDS", "MICROSECONDS", "MILLISECONDS", "SECONDS", "MINUTES", "HOURS", "DAYS", "kotlin-stdlib"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: kotlin.time.DurationUnit */
/* loaded from: classes2.dex */
public final class DurationUnitJvm {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DurationUnitJvm[] $VALUES;
    private final TimeUnit timeUnit;
    public static final DurationUnitJvm NANOSECONDS = new DurationUnitJvm("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
    public static final DurationUnitJvm MICROSECONDS = new DurationUnitJvm("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
    public static final DurationUnitJvm MILLISECONDS = new DurationUnitJvm("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
    public static final DurationUnitJvm SECONDS = new DurationUnitJvm("SECONDS", 3, TimeUnit.SECONDS);
    public static final DurationUnitJvm MINUTES = new DurationUnitJvm("MINUTES", 4, TimeUnit.MINUTES);
    public static final DurationUnitJvm HOURS = new DurationUnitJvm("HOURS", 5, TimeUnit.HOURS);
    public static final DurationUnitJvm DAYS = new DurationUnitJvm("DAYS", 6, TimeUnit.DAYS);

    private static final /* synthetic */ DurationUnitJvm[] $values() {
        return new DurationUnitJvm[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS};
    }

    public static EnumEntries<DurationUnitJvm> getEntries() {
        return $ENTRIES;
    }

    public static DurationUnitJvm valueOf(String str) {
        return (DurationUnitJvm) Enum.valueOf(DurationUnitJvm.class, str);
    }

    public static DurationUnitJvm[] values() {
        return (DurationUnitJvm[]) $VALUES.clone();
    }

    private DurationUnitJvm(String str, int i, TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }

    static {
        DurationUnitJvm[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
