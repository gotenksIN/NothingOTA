package androidx.compose.foundation.text;

import androidx.compose.p002ui.text.AnnotatedString;
import androidx.compose.p002ui.text.Placeholder;
import androidx.compose.p002ui.text.TextLayoutInput;
import androidx.compose.p002ui.text.TextLayoutResult;
import androidx.compose.p002ui.text.TextStyle;
import androidx.compose.p002ui.text.font.FontFamily;
import androidx.compose.p002ui.text.style.TextOverflow;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, m40d2 = {"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Z", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.text.TextLayoutHelperKt */
/* loaded from: classes.dex */
public final class TextLayoutHelper {
    /* renamed from: canReuse-7_7YC6M  reason: not valid java name */
    public static final boolean m1090canReuse7_7YC6M(TextLayoutResult canReuse, AnnotatedString text, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long j) {
        Intrinsics.checkNotNullParameter(canReuse, "$this$canReuse");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = canReuse.getLayoutInput();
        if (!canReuse.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() && Intrinsics.areEqual(layoutInput.getText(), text) && layoutInput.getStyle().hasSameLayoutAffectingAttributes(style) && Intrinsics.areEqual(layoutInput.getPlaceholders(), placeholders) && layoutInput.getMaxLines() == i && layoutInput.getSoftWrap() == z && TextOverflow.m5285equalsimpl0(layoutInput.m4857getOverflowgIe3tQ8(), i2) && Intrinsics.areEqual(layoutInput.getDensity(), density) && layoutInput.getLayoutDirection() == layoutDirection && Intrinsics.areEqual(layoutInput.getFontFamilyResolver(), fontFamilyResolver) && Constraints.m5309getMinWidthimpl(j) == Constraints.m5309getMinWidthimpl(layoutInput.m4856getConstraintsmsEJaDk())) {
            if (z || TextOverflow.m5285equalsimpl0(i2, TextOverflow.Companion.m5293getEllipsisgIe3tQ8())) {
                return Constraints.m5307getMaxWidthimpl(j) == Constraints.m5307getMaxWidthimpl(layoutInput.m4856getConstraintsmsEJaDk()) && Constraints.m5306getMaxHeightimpl(j) == Constraints.m5306getMaxHeightimpl(layoutInput.m4856getConstraintsmsEJaDk());
            }
            return true;
        }
        return false;
    }
}
