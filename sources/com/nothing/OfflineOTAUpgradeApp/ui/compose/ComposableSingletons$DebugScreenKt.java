package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugScreen.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DebugScreenKt {
    public static final ComposableSingletons$DebugScreenKt INSTANCE = new ComposableSingletons$DebugScreenKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f51lambda1 = ComposableLambdaKt.composableLambdaInstance(-1321153018, false, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1321153018, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-1.<anonymous> (DebugScreen.kt:99)");
            }
            TextKt.m1484Text4IGK_g("Enter debug build number", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f52lambda2 = ComposableLambdaKt.composableLambdaInstance(2012141292, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(2012141292, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.ComposableSingletons$DebugScreenKt.lambda-2.<anonymous> (DebugScreen.kt:111)");
            }
            TextKt.m1484Text4IGK_g("Apply debug build number", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5355getLambda1$NothingOfflineOtaUpdate_nothingRelease() {
        return f51lambda1;
    }

    /* renamed from: getLambda-2$NothingOfflineOtaUpdate_nothingRelease  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m5356getLambda2$NothingOfflineOtaUpdate_nothingRelease() {
        return f52lambda2;
    }
}
