package androidx.compose.p002ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CanvasUtils.android.kt */
@Metadata(m41d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m40d2 = {"Landroidx/compose/ui/graphics/CanvasZHelper;", "", "()V", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "", "ui-graphics_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.CanvasZHelper */
/* loaded from: classes.dex */
final class CanvasZHelper {
    public static final CanvasZHelper INSTANCE = new CanvasZHelper();

    private CanvasZHelper() {
    }

    public final void enableZ(Canvas canvas, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
