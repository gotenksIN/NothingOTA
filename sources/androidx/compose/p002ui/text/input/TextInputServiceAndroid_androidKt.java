package androidx.compose.p002ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.p002ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.google.common.primitives.Ints;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(m41d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m40d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt */
/* loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int m5047getImeActioneUduSuo = imeOptions.m5047getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5036getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5040getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5038getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5039getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5041getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5042getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5043getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m5024equalsimpl0(m5047getImeActioneUduSuo, ImeAction.Companion.m5037getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int m5048getKeyboardTypePjHm6EE = imeOptions.m5048getKeyboardTypePjHm6EE();
        if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5090getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5083getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5086getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5089getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5091getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5085getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5088getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5087getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m5070equalsimpl0(m5048getKeyboardTypePjHm6EE, KeyboardType.Companion.m5084getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m5024equalsimpl0(imeOptions.m5047getImeActioneUduSuo(), ImeAction.Companion.m5036getDefaulteUduSuo())) {
                editorInfo.imeOptions |= Ints.MAX_POWER_OF_TWO;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m5046getCapitalizationIUNYP9k = imeOptions.m5046getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m5055equalsimpl0(m5046getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m5063getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m5055equalsimpl0(m5046getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m5066getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m5055equalsimpl0(m5046getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m5065getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m4888getStartimpl(textFieldValue.m5097getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m4883getEndimpl(textFieldValue.m5097getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        Intrinsics.checkNotNullParameter(choreographer, "<this>");
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$1(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$1(Choreographer this_asExecutor, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this_asExecutor, "$this_asExecutor");
        this_asExecutor.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
