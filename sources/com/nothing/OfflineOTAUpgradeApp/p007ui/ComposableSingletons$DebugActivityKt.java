package com.nothing.OfflineOTAUpgradeApp.p007ui;

import android.text.TextUtils;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBack;
import androidx.compose.material3.Icon;
import androidx.compose.material3.Text;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.Scale;
import androidx.compose.p002ui.res.ColorResources_androidKt;
import androidx.compose.p002ui.text.TextLayoutResult;
import androidx.compose.p002ui.text.TextStyle;
import androidx.compose.p002ui.text.font.FontFamily;
import androidx.compose.p002ui.text.font.FontStyle;
import androidx.compose.p002ui.text.font.FontWeight;
import androidx.compose.p002ui.text.style.TextAlign;
import androidx.compose.p002ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugActivity.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt */
/* loaded from: classes2.dex */
public final class ComposableSingletons$DebugActivityKt {
    public static final ComposableSingletons$DebugActivityKt INSTANCE = new ComposableSingletons$DebugActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f361lambda1 = ComposableLambdaKt.composableLambdaInstance(1284864958, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1284864958, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt.lambda-1.<anonymous> (DebugActivity.kt:63)");
                }
                Text.m1785Text4IGK_g("Debug", (Modifier) null, ColorResources_androidKt.colorResource(C1640R.color.debug_title_text, composer, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f362lambda2 = ComposableLambdaKt.composableLambdaInstance(-774502273, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-774502273, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt.lambda-2.<anonymous> (DebugActivity.kt:72)");
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                    scale = Scale.scale(Modifier.Companion, -1.0f, 1.0f);
                } else {
                    scale = Scale.scale(Modifier.Companion, 1.0f, 1.0f);
                }
                Icon.m1469Iconww6aTOc(ArrowBack.getArrowBack(Icons.INSTANCE.getDefault()), "Back", scale, ColorResources_androidKt.colorResource(C1640R.color.ic_top_bar_navigation, composer, 6), composer, 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5620getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f361lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5621getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f362lambda2;
    }
}
