package androidx.compose.p002ui.text.input;

import androidx.compose.p002ui.text.TextRange;
import androidx.compose.p002ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, m40d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.EditingBufferKt */
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m5020updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m4884getLengthimpl;
        int m4886getMinimpl = TextRange.m4886getMinimpl(j);
        int m4885getMaximpl = TextRange.m4885getMaximpl(j);
        if (TextRange.m4890intersects5zctL8(j2, j)) {
            if (TextRange.m4878contains5zctL8(j2, j)) {
                m4886getMinimpl = TextRange.m4886getMinimpl(j2);
                m4885getMaximpl = m4886getMinimpl;
            } else {
                if (TextRange.m4878contains5zctL8(j, j2)) {
                    m4884getLengthimpl = TextRange.m4884getLengthimpl(j2);
                } else if (TextRange.m4879containsimpl(j2, m4886getMinimpl)) {
                    m4886getMinimpl = TextRange.m4886getMinimpl(j2);
                    m4884getLengthimpl = TextRange.m4884getLengthimpl(j2);
                } else {
                    m4885getMaximpl = TextRange.m4886getMinimpl(j2);
                }
                m4885getMaximpl -= m4884getLengthimpl;
            }
        } else if (m4885getMaximpl > TextRange.m4886getMinimpl(j2)) {
            m4886getMinimpl -= TextRange.m4884getLengthimpl(j2);
            m4884getLengthimpl = TextRange.m4884getLengthimpl(j2);
            m4885getMaximpl -= m4884getLengthimpl;
        }
        return TextRangeKt.TextRange(m4886getMinimpl, m4885getMaximpl);
    }
}
