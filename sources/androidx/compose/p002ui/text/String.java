package androidx.compose.p002ui.text;

import androidx.compose.p002ui.text.intl.PlatformLocale;
import kotlin.Metadata;

@Metadata(m41d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/text/PlatformStringDelegate;", "", "capitalize", "", "string", "locale", "Landroidx/compose/ui/text/intl/PlatformLocale;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.PlatformStringDelegate */
/* loaded from: classes.dex */
public interface String {
    java.lang.String capitalize(java.lang.String str, PlatformLocale platformLocale);

    java.lang.String decapitalize(java.lang.String str, PlatformLocale platformLocale);

    java.lang.String toLowerCase(java.lang.String str, PlatformLocale platformLocale);

    java.lang.String toUpperCase(java.lang.String str, PlatformLocale platformLocale);
}
