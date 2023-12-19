package com.nothing.OfflineOTAUpgradeApp.p007ui.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.Text;
import androidx.compose.p002ui.Modifier;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt */
/* loaded from: classes2.dex */
public final class DebugScreen {
    public static final DebugScreen INSTANCE = new DebugScreen();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f367lambda1 = ComposableLambdaKt.composableLambdaInstance(176457291, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(176457291, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-1.<anonymous> (DebugScreen.kt:199)");
            }
            Text.m1785Text4IGK_g("Enter debug build device, eg: Pong", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f368lambda2 = ComposableLambdaKt.composableLambdaInstance(742597506, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(742597506, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-2.<anonymous> (DebugScreen.kt:221)");
            }
            Text.m1785Text4IGK_g("Enter debug build display, eg: T2.0-230902-0109", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f369lambda3 = ComposableLambdaKt.composableLambdaInstance(1006294531, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-3$1
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
                ComposerKt.traceEventStart(1006294531, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-3.<anonymous> (DebugScreen.kt:243)");
            }
            Text.m1785Text4IGK_g("Enter debug build sku, eg: EEA", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4  reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f370lambda4 = ComposableLambdaKt.composableLambdaInstance(-1637282247, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1637282247, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-4.<anonymous> (DebugScreen.kt:257)");
            }
            Text.m1785Text4IGK_g("Apply build number", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5  reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f371lambda5 = ComposableLambdaKt.composableLambdaInstance(-1421696720, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1421696720, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-5.<anonymous> (DebugScreen.kt:267)");
            }
            Text.m1785Text4IGK_g("Reset build number", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5628getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f367lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5629getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f368lambda2;
    }

    /* renamed from: getLambda-3$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5630getLambda3$NothingOfflineOtaUpdate_nothingRelease() {
        return f369lambda3;
    }

    /* renamed from: getLambda-4$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m5631getLambda4$NothingOfflineOtaUpdate_nothingRelease() {
        return f370lambda4;
    }

    /* renamed from: getLambda-5$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m5632getLambda5$NothingOfflineOtaUpdate_nothingRelease() {
        return f371lambda5;
    }
}
