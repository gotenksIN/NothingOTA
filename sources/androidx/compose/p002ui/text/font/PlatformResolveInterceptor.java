package androidx.compose.p002ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFamilyResolver.kt */
@Metadata(m41d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "", "interceptFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "interceptFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "interceptFontStyle-T2F_aPo", "(I)I", "interceptFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "interceptFontSynthesis-Mscr08Y", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Companion", "ui-text_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.font.PlatformResolveInterceptor */
/* loaded from: classes.dex */
public interface PlatformResolveInterceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    default FontFamily interceptFontFamily(FontFamily fontFamily) {
        return fontFamily;
    }

    /* renamed from: interceptFontStyle-T2F_aPo  reason: not valid java name */
    default int m4996interceptFontStyleT2F_aPo(int i) {
        return i;
    }

    /* renamed from: interceptFontSynthesis-Mscr08Y  reason: not valid java name */
    default int m4997interceptFontSynthesisMscr08Y(int i) {
        return i;
    }

    default FontWeight interceptFontWeight(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return fontWeight;
    }

    /* compiled from: FontFamilyResolver.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m40d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "getDefault$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "ui-text_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
        };

        private Companion() {
        }

        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }
}
