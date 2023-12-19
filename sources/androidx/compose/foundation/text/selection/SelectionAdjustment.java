package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.p002ui.text.TextLayoutResult;
import androidx.compose.p002ui.text.TextRange;
import androidx.compose.p002ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: SelectionAdjustment.kt */
@Metadata(m41d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, m40d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelectionRange", "previousHandleOffset", "", "isStartHandle", "", "previousSelectionRange", "adjust-ZXO7KMw", "(Landroidx/compose/ui/text/TextLayoutResult;JIZLandroidx/compose/ui/text/TextRange;)J", "Companion", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public interface SelectionAdjustment {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange);

    /* compiled from: SelectionAdjustment.kt */
    @Metadata(m41d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0015H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, m40d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "()V", "Character", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getCharacter", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "None", "getNone", "Paragraph", "getParagraph", "Word", "getWord", "adjustByBoundary", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelection", "boundaryFun", "Lkotlin/Function1;", "", "adjustByBoundary--Dv-ylE", "(Landroidx/compose/ui/text/TextLayoutResult;JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                return j;
            }
        };
        private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (TextRange.m4882getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(textLayoutResult.getLayoutInput().getText().getText(), TextRange.m4888getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, textRange != null ? TextRange.m4887getReversedimpl(textRange.m4892unboximpl()) : false);
                }
                return j;
            }
        };
        private static final SelectionAdjustment Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                long m1120adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m1120adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m1120adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
                return m1120adjustByBoundaryDvylE;
            }
        };
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                long m1120adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m1120adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m1120adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(textLayoutResult.getLayoutInput().getText()));
                return m1120adjustByBoundaryDvylE;
            }
        };
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$CharacterWithWordAccelerate$1
            private final boolean isExpanding(int i, int i2, boolean z, boolean z2) {
                if (i2 == -1) {
                    return true;
                }
                if (i == i2) {
                    return false;
                }
                if (z ^ z2) {
                    if (i < i2) {
                        return true;
                    }
                } else if (i > i2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1118adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                int updateSelectionBoundary;
                int i2;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (textRange == null) {
                    return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo1118adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
                }
                if (TextRange.m4882getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(textLayoutResult.getLayoutInput().getText().getText(), TextRange.m4888getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, TextRange.m4887getReversedimpl(textRange.m4892unboximpl()));
                }
                if (z) {
                    i2 = updateSelectionBoundary(textLayoutResult, TextRange.m4888getStartimpl(j), i, TextRange.m4888getStartimpl(textRange.m4892unboximpl()), TextRange.m4883getEndimpl(j), true, TextRange.m4887getReversedimpl(j));
                    updateSelectionBoundary = TextRange.m4883getEndimpl(j);
                } else {
                    int m4888getStartimpl = TextRange.m4888getStartimpl(j);
                    updateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m4883getEndimpl(j), i, TextRange.m4883getEndimpl(textRange.m4892unboximpl()), TextRange.m4888getStartimpl(j), false, TextRange.m4887getReversedimpl(j));
                    i2 = m4888getStartimpl;
                }
                return TextRangeKt.TextRange(i2, updateSelectionBoundary);
            }

            private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, int i4, boolean z, boolean z2) {
                if (i == i2) {
                    return i3;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(i);
                if (lineForOffset != textLayoutResult.getLineForOffset(i3)) {
                    return snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2);
                }
                return (isExpanding(i, i2, z, z2) && isAtWordBoundary(textLayoutResult, i3)) ? snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2) : i;
            }

            private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, boolean z, boolean z2) {
                int lineStart;
                int lineEnd$default;
                long m4862getWordBoundaryjx7JFs = textLayoutResult.m4862getWordBoundaryjx7JFs(i);
                if (textLayoutResult.getLineForOffset(TextRange.m4888getStartimpl(m4862getWordBoundaryjx7JFs)) == i2) {
                    lineStart = TextRange.m4888getStartimpl(m4862getWordBoundaryjx7JFs);
                } else {
                    lineStart = textLayoutResult.getLineStart(i2);
                }
                if (textLayoutResult.getLineForOffset(TextRange.m4883getEndimpl(m4862getWordBoundaryjx7JFs)) == i2) {
                    lineEnd$default = TextRange.m4883getEndimpl(m4862getWordBoundaryjx7JFs);
                } else {
                    lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, null);
                }
                if (lineStart == i3) {
                    return lineEnd$default;
                }
                if (lineEnd$default == i3) {
                    return lineStart;
                }
                int i4 = (lineStart + lineEnd$default) / 2;
                if (z ^ z2) {
                    if (i <= i4) {
                        return lineStart;
                    }
                } else if (i < i4) {
                    return lineStart;
                }
                return lineEnd$default;
            }

            private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
                long m4862getWordBoundaryjx7JFs = textLayoutResult.m4862getWordBoundaryjx7JFs(i);
                return i == TextRange.m4888getStartimpl(m4862getWordBoundaryjx7JFs) || i == TextRange.m4883getEndimpl(m4862getWordBoundaryjx7JFs);
            }
        };

        private Companion() {
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: adjustByBoundary--Dv-ylE  reason: not valid java name */
        public final long m1120adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, Function1<? super Integer, TextRange> function1) {
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                return TextRange.Companion.m4893getZerod9O1mEE();
            }
            int lastIndex = StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
            long m4892unboximpl = function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m4888getStartimpl(j), 0, lastIndex))).m4892unboximpl();
            long m4892unboximpl2 = function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m4883getEndimpl(j), 0, lastIndex))).m4892unboximpl();
            return TextRangeKt.TextRange(TextRange.m4887getReversedimpl(j) ? TextRange.m4883getEndimpl(m4892unboximpl) : TextRange.m4888getStartimpl(m4892unboximpl), TextRange.m4887getReversedimpl(j) ? TextRange.m4888getStartimpl(m4892unboximpl2) : TextRange.m4883getEndimpl(m4892unboximpl2));
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }
    }
}
