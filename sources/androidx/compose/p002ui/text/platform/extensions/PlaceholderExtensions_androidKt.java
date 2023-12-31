package androidx.compose.p002ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.p002ui.text.AnnotatedString;
import androidx.compose.p002ui.text.Placeholder;
import androidx.compose.p002ui.text.PlaceholderVerticalAlign;
import androidx.compose.p002ui.text.android.style.PlaceholderSpan;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.TextUnit;
import androidx.compose.p002ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderExtensions.android.kt */
@Metadata(m41d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0082\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m40d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt */
/* loaded from: classes.dex */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o$annotations  reason: not valid java name */
    private static /* synthetic */ void m5118getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations  reason: not valid java name */
    private static /* synthetic */ void m5120getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        Object[] spans = spannable.getSpans(i, i2, EmojiSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, EmojiSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m5532getValueimpl(placeholder.m4812getWidthXSAIIZE()), m5117getSpanUnitR2X_6o(placeholder.m4812getWidthXSAIIZE()), TextUnit.m5532getValueimpl(placeholder.m4810getHeightXSAIIZE()), m5117getSpanUnitR2X_6o(placeholder.m4810getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m5119getSpanVerticalAligndo9XGg(placeholder.m4811getPlaceholderVerticalAlignJ6kI3mc())), i, i2);
    }

    /* renamed from: getSpanUnit--R2X_6o  reason: not valid java name */
    private static final int m5117getSpanUnitR2X_6o(long j) {
        long m5531getTypeUIouoOA = TextUnit.m5531getTypeUIouoOA(j);
        if (TextUnitType.m5560equalsimpl0(m5531getTypeUIouoOA, TextUnitType.Companion.m5565getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m5560equalsimpl0(m5531getTypeUIouoOA, TextUnitType.Companion.m5564getEmUIouoOA()) ? 1 : 2;
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg  reason: not valid java name */
    private static final int m5119getSpanVerticalAligndo9XGg(int i) {
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4820getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4826getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4821getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4822getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4825getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4823getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m4816equalsimpl0(i, PlaceholderVerticalAlign.Companion.m4824getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    public static final void setPlaceholders(Spannable spannable, List<AnnotatedString.Range<Placeholder>> placeholders, Density density) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        int size = placeholders.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = placeholders.get(i);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }
}
