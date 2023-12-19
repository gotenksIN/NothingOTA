package androidx.compose.material3.tokens;

import androidx.compose.material3.DefaultPlatformTextStyle_androidKt;
import androidx.compose.p002ui.text.TextStyle;
import kotlin.Metadata;

/* compiled from: TypographyTokens.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m40d2 = {"DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "material3_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class TypographyTokensKt {
    private static final TextStyle DefaultTextStyle;

    static {
        TextStyle m4901copyCXVQc50;
        m4901copyCXVQc50 = r1.m4901copyCXVQc50((r46 & 1) != 0 ? r1.spanStyle.m4848getColor0d7_KjU() : 0L, (r46 & 2) != 0 ? r1.spanStyle.m4849getFontSizeXSAIIZE() : 0L, (r46 & 4) != 0 ? r1.spanStyle.getFontWeight() : null, (r46 & 8) != 0 ? r1.spanStyle.m4850getFontStyle4Lr2A7w() : null, (r46 & 16) != 0 ? r1.spanStyle.m4851getFontSynthesisZQGJjVo() : null, (r46 & 32) != 0 ? r1.spanStyle.getFontFamily() : null, (r46 & 64) != 0 ? r1.spanStyle.getFontFeatureSettings() : null, (r46 & 128) != 0 ? r1.spanStyle.m4852getLetterSpacingXSAIIZE() : 0L, (r46 & 256) != 0 ? r1.spanStyle.m4847getBaselineShift5SSeXJ0() : null, (r46 & 512) != 0 ? r1.spanStyle.getTextGeometricTransform() : null, (r46 & 1024) != 0 ? r1.spanStyle.getLocaleList() : null, (r46 & 2048) != 0 ? r1.spanStyle.m4846getBackground0d7_KjU() : 0L, (r46 & 4096) != 0 ? r1.spanStyle.getTextDecoration() : null, (r46 & 8192) != 0 ? r1.spanStyle.getShadow() : null, (r46 & 16384) != 0 ? r1.paragraphStyle.m4805getTextAlignbuA522U() : null, (r46 & 32768) != 0 ? r1.paragraphStyle.m4807getTextDirectionmmuk1to() : null, (r46 & 65536) != 0 ? r1.paragraphStyle.m4804getLineHeightXSAIIZE() : 0L, (r46 & 131072) != 0 ? r1.paragraphStyle.getTextIndent() : null, (r46 & 262144) != 0 ? r1.platformStyle : DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), (r46 & 524288) != 0 ? r1.paragraphStyle.getLineHeightStyle() : null, (r46 & 1048576) != 0 ? r1.paragraphStyle.m4802getLineBreakLgCVezo() : null, (r46 & 2097152) != 0 ? TextStyle.Companion.getDefault().paragraphStyle.m4800getHyphensEaSxIns() : null);
        DefaultTextStyle = m4901copyCXVQc50;
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }
}
