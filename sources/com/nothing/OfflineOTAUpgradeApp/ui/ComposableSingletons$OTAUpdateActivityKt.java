package com.nothing.OfflineOTAUpgradeApp.ui;

import android.text.TextUtils;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.BuildKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.nothing.OfflineOTAUpgradeApp.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTAUpdateActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$OTAUpdateActivityKt {
    public static final ComposableSingletons$OTAUpdateActivityKt INSTANCE = new ComposableSingletons$OTAUpdateActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f47lambda1 = ComposableLambdaKt.composableLambdaInstance(283258366, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-1$1
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
                ComposerKt.traceEventStart(283258366, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-1.<anonymous> (OTAUpdateActivity.kt:201)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f48lambda2 = ComposableLambdaKt.composableLambdaInstance(1583042372, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1583042372, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-2.<anonymous> (OTAUpdateActivity.kt:238)");
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

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f49lambda3 = ComposableLambdaKt.composableLambdaInstance(913465744, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier scale;
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(913465744, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-3.<anonymous> (OTAUpdateActivity.kt:209)");
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                    scale = ScaleKt.scale(Modifier.Companion, -1.0f, 1.0f);
                } else {
                    scale = ScaleKt.scale(Modifier.Companion, 1.0f, 1.0f);
                }
                IconKt.m1167Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_menu_pp, composer, 6), "Privacy Policy", scale, ColorResources_androidKt.colorResource(R.color.ic_top_bar_navigation, composer, 6), composer, 56, 0);
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
    public static Function2<Composer, Integer, Unit> f50lambda4 = ComposableLambdaKt.composableLambdaInstance(-1470176853, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1470176853, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.ComposableSingletons$OTAUpdateActivityKt.lambda-4.<anonymous> (OTAUpdateActivity.kt:227)");
                }
                IconKt.m1168Iconww6aTOc(BuildKt.getBuild(Icons.INSTANCE.getDefault()), "Debug", (Modifier) null, ColorResources_androidKt.colorResource(R.color.ic_top_bar_navigation, composer, 6), composer, 48, 4);
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
    public final Function2<Composer, Integer, Unit> m5344getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f47lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5345getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f48lambda2;
    }

    /* renamed from: getLambda-3$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5346getLambda3$NothingOfflineOtaUpdate_nothingRelease() {
        return f49lambda3;
    }

    /* renamed from: getLambda-4$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5347getLambda4$NothingOfflineOtaUpdate_nothingRelease() {
        return f50lambda4;
    }
}
