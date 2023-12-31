package androidx.compose.p002ui.text.input;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.p002ui.window.DialogWindowProvider;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputMethodManager.kt */
@Metadata(m41d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0082\u0010J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0003H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m40d2 = {"Landroidx/compose/ui/text/input/ImmHelper30;", "Landroidx/compose/ui/text/input/ImmHelper;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "_immHelper21", "Landroidx/compose/ui/text/input/ImmHelper21;", "immHelper21", "getImmHelper21", "()Landroidx/compose/ui/text/input/ImmHelper21;", "insetsControllerCompat", "Landroidx/core/view/WindowInsetsControllerCompat;", "getInsetsControllerCompat", "()Landroidx/core/view/WindowInsetsControllerCompat;", "hideSoftInput", "", "imm", "Landroid/view/inputmethod/InputMethodManager;", "showSoftInput", "findWindow", "Landroid/view/Window;", "Landroid/content/Context;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.ImmHelper30 */
/* loaded from: classes.dex */
final class ImmHelper30 implements ImmHelper {
    private ImmHelper21 _immHelper21;
    private final View view;

    public ImmHelper30(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    private final WindowInsetsControllerCompat getInsetsControllerCompat() {
        Window findWindow = findWindow(this.view);
        if (findWindow != null) {
            return new WindowInsetsControllerCompat(findWindow, this.view);
        }
        return null;
    }

    private final ImmHelper21 getImmHelper21() {
        ImmHelper21 immHelper21 = this._immHelper21;
        if (immHelper21 == null) {
            ImmHelper21 immHelper212 = new ImmHelper21(this.view);
            this._immHelper21 = immHelper212;
            return immHelper212;
        }
        return immHelper21;
    }

    @Override // androidx.compose.p002ui.text.input.ImmHelper
    public void showSoftInput(InputMethodManager imm) {
        Intrinsics.checkNotNullParameter(imm, "imm");
        WindowInsetsControllerCompat insetsControllerCompat = getInsetsControllerCompat();
        if (insetsControllerCompat != null) {
            insetsControllerCompat.show(WindowInsetsCompat.Type.ime());
        } else {
            getImmHelper21().showSoftInput(imm);
        }
    }

    @Override // androidx.compose.p002ui.text.input.ImmHelper
    public void hideSoftInput(InputMethodManager imm) {
        Intrinsics.checkNotNullParameter(imm, "imm");
        WindowInsetsControllerCompat insetsControllerCompat = getInsetsControllerCompat();
        if (insetsControllerCompat != null) {
            insetsControllerCompat.hide(WindowInsetsCompat.Type.ime());
        } else {
            getImmHelper21().hideSoftInput(imm);
        }
    }

    private final Window findWindow(View view) {
        while (!(view instanceof DialogWindowProvider)) {
            ViewParent parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 == null) {
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                Window findWindow = findWindow(context);
                if (findWindow == null) {
                    return null;
                }
                View decorView = findWindow.getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "windowFromContext.decorView");
                if (decorView == view) {
                    return findWindow;
                }
                return null;
            }
            view = view2;
        }
        return ((DialogWindowProvider) view).getWindow();
    }

    private final Window findWindow(Context baseContext) {
        while (!(baseContext instanceof Activity)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        }
        return ((Activity) baseContext).getWindow();
    }
}
