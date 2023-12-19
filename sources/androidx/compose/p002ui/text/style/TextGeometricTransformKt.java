package androidx.compose.p002ui.text.style;

import androidx.compose.p002ui.util.MathHelpers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextGeometricTransform.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m40d2 = {"lerp", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "start", "stop", "fraction", "", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.style.TextGeometricTransformKt */
/* loaded from: classes.dex */
public final class TextGeometricTransformKt {
    public static final TextGeometricTransform lerp(TextGeometricTransform start, TextGeometricTransform stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new TextGeometricTransform(MathHelpers.lerp(start.getScaleX(), stop.getScaleX(), f), MathHelpers.lerp(start.getSkewX(), stop.getSkewX(), f));
    }
}
