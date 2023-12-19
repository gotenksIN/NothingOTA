package com.nothing.OfflineOTAUpgradeApp.p007ui;

import android.text.TextUtils;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBack;
import androidx.compose.material.icons.filled.Build;
import androidx.compose.material3.Icon;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.Scale;
import androidx.compose.p002ui.res.ColorResources_androidKt;
import androidx.compose.p002ui.res.PainterResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTAUpdateActivity.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt */
/* loaded from: classes2.dex */
public final class ComposableSingletons$OTAUpdateActivityKt {
    public static final ComposableSingletons$OTAUpdateActivityKt INSTANCE = new ComposableSingletons$OTAUpdateActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f363lambda1 = ComposableLambdaKt.composableLambdaInstance(283258366, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-1$1
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
                ComposerKt.traceEventStart(283258366, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-1.<anonymous> (OTAUpdateActivity.kt:212)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f364lambda2 = ComposableLambdaKt.composableLambdaInstance(1583042372, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1583042372, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-2.<anonymous> (OTAUpdateActivity.kt:249)");
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

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f365lambda3 = ComposableLambdaKt.composableLambdaInstance(913465744, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(913465744, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-3.<anonymous> (OTAUpdateActivity.kt:220)");
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                    scale = Scale.scale(Modifier.Companion, -1.0f, 1.0f);
                } else {
                    scale = Scale.scale(Modifier.Companion, 1.0f, 1.0f);
                }
                Icon.m1468Iconww6aTOc(PainterResources_androidKt.painterResource(C1640R.C1641drawable.ic_menu_pp, composer, 6), "Privacy Policy", scale, ColorResources_androidKt.colorResource(C1640R.color.ic_top_bar_navigation, composer, 6), composer, 56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-4  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f366lambda4 = ComposableLambdaKt.composableLambdaInstance(-1470176853, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1470176853, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-4.<anonymous> (OTAUpdateActivity.kt:238)");
                }
                Icon.m1469Iconww6aTOc(Build.getBuild(Icons.INSTANCE.getDefault()), "Debug", (Modifier) null, ColorResources_androidKt.colorResource(C1640R.color.ic_top_bar_navigation, composer, 6), composer, 48, 4);
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
    public final Function2<Composer, Integer, Unit> m5622getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f363lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5623getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f364lambda2;
    }

    /* renamed from: getLambda-3$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5624getLambda3$NothingOfflineOtaUpdate_nothingRelease() {
        return f365lambda3;
    }

    /* renamed from: getLambda-4$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5625getLambda4$NothingOfflineOtaUpdate_nothingRelease() {
        return f366lambda4;
    }
}
