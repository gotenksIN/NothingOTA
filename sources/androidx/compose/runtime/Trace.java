package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActualAndroid.android.kt */
@Metadata(m41d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001¨\u0006\t"}, m40d2 = {"Landroidx/compose/runtime/Trace;", "", "()V", "beginSection", HintConstants.AUTOFILL_HINT_NAME, "", "endSection", "", "token", "runtime_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class Trace {
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    public final Object beginSection(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        android.os.Trace.beginSection(name);
        return null;
    }

    public final void endSection(Object obj) {
        android.os.Trace.endSection();
    }
}
