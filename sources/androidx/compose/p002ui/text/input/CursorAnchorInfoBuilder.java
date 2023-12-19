package androidx.compose.p002ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.text.TextLayoutResult;
import androidx.compose.p002ui.text.TextRange;
import androidx.compose.p002ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\f"}, m40d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "setInsertionMarker", "selectionStart", "", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.CursorAnchorInfoBuilderKt */
/* loaded from: classes.dex */
public final class CursorAnchorInfoBuilder {
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, TextLayoutResult textLayoutResult, Matrix matrix) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int m4886getMinimpl = TextRange.m4886getMinimpl(textFieldValue.m5097getSelectiond9O1mEE());
        builder.setSelectionRange(m4886getMinimpl, TextRange.m4885getMaximpl(textFieldValue.m5097getSelectiond9O1mEE()));
        setInsertionMarker(builder, m4886getMinimpl, textLayoutResult);
        TextRange m5096getCompositionMzsxiRA = textFieldValue.m5096getCompositionMzsxiRA();
        int m4886getMinimpl2 = m5096getCompositionMzsxiRA != null ? TextRange.m4886getMinimpl(m5096getCompositionMzsxiRA.m4892unboximpl()) : -1;
        TextRange m5096getCompositionMzsxiRA2 = textFieldValue.m5096getCompositionMzsxiRA();
        int m4885getMaximpl = m5096getCompositionMzsxiRA2 != null ? TextRange.m4885getMaximpl(m5096getCompositionMzsxiRA2.m4892unboximpl()) : -1;
        boolean z = false;
        if (m4886getMinimpl2 >= 0 && m4886getMinimpl2 < m4885getMaximpl) {
            z = true;
        }
        if (z) {
            builder.setComposingText(m4886getMinimpl2, textFieldValue.getText().subSequence(m4886getMinimpl2, m4885getMaximpl));
        }
        CursorAnchorInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return build;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl ? 4 : 0);
        return builder;
    }
}
