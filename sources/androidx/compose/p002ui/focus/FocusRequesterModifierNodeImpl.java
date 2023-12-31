package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
@Metadata(m41d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\f"}, m40d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierNodeImpl;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "onAttach", "", "onDetach", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.FocusRequesterModifierNodeImpl */
/* loaded from: classes.dex */
final class FocusRequesterModifierNodeImpl extends Modifier.Node implements FocusRequesterModifierNode {
    private FocusRequester focusRequester;

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.focusRequester = focusRequester;
    }

    public FocusRequesterModifierNodeImpl(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
    }

    @Override // androidx.compose.p002ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.focusRequester.getFocusRequesterNodes$ui_release().add(this);
    }

    @Override // androidx.compose.p002ui.Modifier.Node
    public void onDetach() {
        this.focusRequester.getFocusRequesterNodes$ui_release().remove(this);
        super.onDetach();
    }
}
