package com.nothing.OfflineOTAUpgradeApp.util;

import android.graphics.Typeface;
import com.nothing.sdk.NothingUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m40d2 = {"getNdotExpectTextTypeface", "Landroid/graphics/Typeface;", "language", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.util.NTFontUtilsKt */
/* loaded from: classes2.dex */
public final class NTFontUtils {
    public static /* synthetic */ Typeface getNdotExpectTextTypeface$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(str, "getLanguage(...)");
        }
        return getNdotExpectTextTypeface(str);
    }

    public static final Typeface getNdotExpectTextTypeface(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        if (NothingUtils.isSupportNdot(language)) {
            Typeface create = Typeface.create("NDot57", 0);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        return DEFAULT;
    }
}
