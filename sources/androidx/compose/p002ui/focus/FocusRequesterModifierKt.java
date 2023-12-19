package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, m40d2 = {"focusRequester", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.FocusRequesterModifierKt */
/* loaded from: classes.dex */
public final class FocusRequesterModifierKt {
    public static final Modifier focusRequester(Modifier modifier, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return modifier.then(new FocusRequesterElement(focusRequester));
    }
}
