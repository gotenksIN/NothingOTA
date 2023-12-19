package com.nothing.OfflineOTAUpgradeApp.util;

import android.graphics.Typeface;
import com.nothing.sdk.NothingUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NTFontUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getNdotExpectTextTypeface", "Landroid/graphics/Typeface;", "language", "", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NTFontUtilsKt {
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
