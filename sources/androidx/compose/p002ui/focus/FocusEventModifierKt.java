package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusEventModifier.kt */
@Metadata(m41d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0005"}, m40d2 = {"onFocusEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.FocusEventModifierKt */
/* loaded from: classes.dex */
public final class FocusEventModifierKt {
    public static final Modifier onFocusEvent(Modifier modifier, Function1<? super FocusState, Unit> onFocusEvent) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onFocusEvent, "onFocusEvent");
        return modifier.then(new FocusEventElement(onFocusEvent));
    }
}
