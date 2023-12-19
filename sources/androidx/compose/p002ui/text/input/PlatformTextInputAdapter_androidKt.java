package androidx.compose.p002ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformTextInputAdapter.android.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m40d2 = {"dispose", "", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.PlatformTextInputAdapter_androidKt */
/* loaded from: classes.dex */
public final class PlatformTextInputAdapter_androidKt {
    public static final void dispose(PlatformTextInputAdapter platformTextInputAdapter) {
        Intrinsics.checkNotNullParameter(platformTextInputAdapter, "<this>");
        platformTextInputAdapter.onDisposed();
    }
}
