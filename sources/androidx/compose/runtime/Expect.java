package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, m40d2 = {"ThreadLocal", "Landroidx/compose/runtime/ThreadLocal;", "T", "postIncrement", "", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.runtime.ExpectKt */
/* loaded from: classes.dex */
public final class Expect {
    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(new Functions<T>() { // from class: androidx.compose.runtime.ExpectKt$ThreadLocal$1
            @Override // kotlin.jvm.functions.Functions
            public final T invoke() {
                return null;
            }
        });
    }

    public static final int postIncrement(AtomicInt atomicInt) {
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        return atomicInt.add(1) - 1;
    }
}
