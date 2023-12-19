package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m4719updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m4583getLengthimpl;
        int m4585getMinimpl = TextRange.m4585getMinimpl(j);
        int m4584getMaximpl = TextRange.m4584getMaximpl(j);
        if (TextRange.m4589intersects5zctL8(j2, j)) {
            if (TextRange.m4577contains5zctL8(j2, j)) {
                m4585getMinimpl = TextRange.m4585getMinimpl(j2);
                m4584getMaximpl = m4585getMinimpl;
            } else {
                if (TextRange.m4577contains5zctL8(j, j2)) {
                    m4583getLengthimpl = TextRange.m4583getLengthimpl(j2);
                } else if (TextRange.m4578containsimpl(j2, m4585getMinimpl)) {
                    m4585getMinimpl = TextRange.m4585getMinimpl(j2);
                    m4583getLengthimpl = TextRange.m4583getLengthimpl(j2);
                } else {
                    m4584getMaximpl = TextRange.m4585getMinimpl(j2);
                }
                m4584getMaximpl -= m4583getLengthimpl;
            }
        } else if (m4584getMaximpl > TextRange.m4585getMinimpl(j2)) {
            m4585getMinimpl -= TextRange.m4583getLengthimpl(j2);
            m4583getLengthimpl = TextRange.m4583getLengthimpl(j2);
            m4584getMaximpl -= m4583getLengthimpl;
        }
        return TextRangeKt.TextRange(m4585getMinimpl, m4584getMaximpl);
    }
}
