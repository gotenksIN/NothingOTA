package androidx.compose.p002ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutableRect.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m40d2 = {"toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "ui-geometry_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.geometry.MutableRectKt */
/* loaded from: classes.dex */
public final class MutableRectKt {
    public static final Rect toRect(MutableRect mutableRect) {
        Intrinsics.checkNotNullParameter(mutableRect, "<this>");
        return new Rect(mutableRect.getLeft(), mutableRect.getTop(), mutableRect.getRight(), mutableRect.getBottom());
    }
}
