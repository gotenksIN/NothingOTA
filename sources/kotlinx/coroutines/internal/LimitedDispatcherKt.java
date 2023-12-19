package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* compiled from: LimitedDispatcher.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m40d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, m39k = 2, m38mv = {1, 6, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int i) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i).toString());
        }
    }
}
