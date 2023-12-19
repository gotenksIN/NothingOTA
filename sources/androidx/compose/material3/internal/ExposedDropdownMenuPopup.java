package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt */
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopup {
    public static final ExposedDropdownMenuPopup INSTANCE = new ExposedDropdownMenuPopup();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f353lambda1 = ComposableLambdaKt.composableLambdaInstance(1584933307, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ExposedDropdownMenuPopup.kt#mqatfk");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584933307, i, -1, "androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt.lambda-1.<anonymous> (ExposedDropdownMenuPopup.kt:286)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1910getLambda1$material3_release() {
        return f353lambda1;
    }
}
