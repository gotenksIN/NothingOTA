package kotlin.system;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

@Metadata(m41d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, m40d2 = {"exitProcess", "", NotificationCompat.CATEGORY_STATUS, "", "kotlin-stdlib"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: kotlin.system.ProcessKt */
/* loaded from: classes2.dex */
public final class Process {
    private static final Void exitProcess(int i) {
        System.exit(i);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
