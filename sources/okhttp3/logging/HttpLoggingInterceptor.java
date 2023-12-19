package okhttp3.logging;

import androidx.autofill.HintConstants;
import com.google.common.net.HttpHeaders;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

/* compiled from: HttpLoggingInterceptor.kt */
@Metadata(m41d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m40d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", HintConstants.AUTOFILL_HINT_NAME, "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m40d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m40d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(String str);

        /* compiled from: HttpLoggingInterceptor.kt */
        @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, m40d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* compiled from: HttpLoggingInterceptor.kt */
            @Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m40d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "okhttp-logging-interceptor"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
            /* loaded from: classes2.dex */
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
                }
            }
        }
    }

    public final void redactHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        TreeSet treeSet2 = treeSet;
        CollectionsKt.addAll(treeSet2, this.headersToRedact);
        treeSet2.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        level(level);
        return this;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m7352deprecated_level() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c0  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private final void logHeader(Headers headers, int i) {
        this.logger.log(headers.name(i) + ": " + (this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i)));
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) ? false : true;
    }
}
