package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m40d2 = {"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: kotlin.coroutines.intrinsics.CoroutineSingletons */
/* loaded from: classes2.dex */
public final class Intrinsics {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Intrinsics[] $VALUES;
    public static final Intrinsics COROUTINE_SUSPENDED = new Intrinsics("COROUTINE_SUSPENDED", 0);
    public static final Intrinsics UNDECIDED = new Intrinsics("UNDECIDED", 1);
    public static final Intrinsics RESUMED = new Intrinsics("RESUMED", 2);

    private static final /* synthetic */ Intrinsics[] $values() {
        return new Intrinsics[]{COROUTINE_SUSPENDED, UNDECIDED, RESUMED};
    }

    public static EnumEntries<Intrinsics> getEntries() {
        return $ENTRIES;
    }

    public static Intrinsics valueOf(String str) {
        return (Intrinsics) Enum.valueOf(Intrinsics.class, str);
    }

    public static Intrinsics[] values() {
        return (Intrinsics[]) $VALUES.clone();
    }

    private Intrinsics(String str, int i) {
    }

    static {
        Intrinsics[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
