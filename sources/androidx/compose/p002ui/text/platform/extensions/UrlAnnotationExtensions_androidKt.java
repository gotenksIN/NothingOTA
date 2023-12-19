package androidx.compose.p002ui.text.platform.extensions;

import android.text.style.URLSpan;
import androidx.compose.p002ui.text.UrlAnnotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlAnnotationExtensions.android.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m40d2 = {"toSpan", "Landroid/text/style/URLSpan;", "Landroidx/compose/ui/text/UrlAnnotation;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.platform.extensions.UrlAnnotationExtensions_androidKt */
/* loaded from: classes.dex */
public final class UrlAnnotationExtensions_androidKt {
    public static final URLSpan toSpan(UrlAnnotation urlAnnotation) {
        Intrinsics.checkNotNullParameter(urlAnnotation, "<this>");
        return new URLSpan(urlAnnotation.getUrl());
    }
}
