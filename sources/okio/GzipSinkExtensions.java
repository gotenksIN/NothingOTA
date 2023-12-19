package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GzipSink.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m40d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m39k = 2, m38mv = {1, 6, 0}, m36xi = 48)
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* loaded from: classes2.dex */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new GzipSink(sink);
    }
}
