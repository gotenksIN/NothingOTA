package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.focus.FocusDirection;
import androidx.compose.p002ui.focus.FocusManager;
import androidx.compose.p002ui.input.key.KeyEvent;
import androidx.compose.p002ui.input.key.KeyEventType;
import androidx.compose.p002ui.input.key.KeyEvent_androidKt;
import androidx.compose.p002ui.input.key.KeyInputModifier;
import androidx.compose.p002ui.input.key.Key_androidKt;
import androidx.compose.p002ui.text.input.TextInputSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldFocusModifier.android.kt */
@Metadata(m41d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m40d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final TextFieldState state, final FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(focusManager, "focusManager");
        return KeyInputModifier.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1073invokeZmokQxo(keyEvent.m4114unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m1073invokeZmokQxo(android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device == null) {
                    return false;
                }
                if (!(device.getKeyboardType() == 2 && device.isVirtual()) && KeyEventType.m4118equalsimpl0(KeyEvent_androidKt.m4126getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4122getKeyDownCS__XNY())) {
                    switch (Key_androidKt.m4134getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4125getKeyZmokQxo(keyEvent))) {
                        case 19:
                            z = FocusManager.this.mo2561moveFocus3ESFkO8(FocusDirection.Companion.m2560getUpdhqQ8s());
                            break;
                        case 20:
                            z = FocusManager.this.mo2561moveFocus3ESFkO8(FocusDirection.Companion.m2551getDowndhqQ8s());
                            break;
                        case 21:
                            z = FocusManager.this.mo2561moveFocus3ESFkO8(FocusDirection.Companion.m2555getLeftdhqQ8s());
                            break;
                        case 22:
                            z = FocusManager.this.mo2561moveFocus3ESFkO8(FocusDirection.Companion.m2559getRightdhqQ8s());
                            break;
                        case 23:
                            TextInputSession inputSession = state.getInputSession();
                            if (inputSession != null) {
                                inputSession.showSoftwareKeyboard();
                            }
                            z = true;
                            break;
                    }
                    return Boolean.valueOf(z);
                }
                return false;
            }
        });
    }
}
