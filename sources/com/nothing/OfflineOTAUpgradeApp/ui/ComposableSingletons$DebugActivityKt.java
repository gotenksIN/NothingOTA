package com.nothing.OfflineOTAUpgradeApp.ui;

import android.text.TextUtils;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.nothing.OfflineOTAUpgradeApp.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DebugActivityKt {
    public static final ComposableSingletons$DebugActivityKt INSTANCE = new ComposableSingletons$DebugActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda1 = ComposableLambdaKt.composableLambdaInstance(1284864958, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1284864958, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt.lambda-1.<anonymous> (DebugActivity.kt:63)");
            }
            TextKt.m1484Text4IGK_g("Debug", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f46lambda2 = ComposableLambdaKt.composableLambdaInstance(-774502273, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-774502273, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$DebugActivityKt.lambda-2.<anonymous> (DebugActivity.kt:70)");
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                    scale = ScaleKt.scale(Modifier.Companion, -1.0f, 1.0f);
                } else {
                    scale = ScaleKt.scale(Modifier.Companion, 1.0f, 1.0f);
                }
                IconKt.m1168Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.INSTANCE.getDefault()), "Back", scale, ColorResources_androidKt.colorResource(R.color.ic_top_bar_navigation, composer, 6), composer, 48, 0);
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
    public final Function2<Composer, Integer, Unit> m5342getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f45lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5343getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f46lambda2;
    }
}
