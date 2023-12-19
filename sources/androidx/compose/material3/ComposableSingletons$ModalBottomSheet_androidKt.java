package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$ModalBottomSheet_androidKt {
    public static final ComposableSingletons$ModalBottomSheet_androidKt INSTANCE = new ComposableSingletons$ModalBottomSheet_androidKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f339lambda1 = ComposableLambdaKt.composableLambdaInstance(2103486466, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C131@6373L12:ModalBottomSheet.android.kt#uh7d8r");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2103486466, i, -1, "androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.lambda-1.<anonymous> (ModalBottomSheet.android.kt:131)");
            }
            SheetDefaults.INSTANCE.m1225DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, composer, ProfileVerifier.CompilationStatus.f184xf2722a21, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f340lambda2 = ComposableLambdaKt.composableLambdaInstance(1964472464, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C290@13368L12:ModalBottomSheet.android.kt#uh7d8r");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1964472464, i, -1, "androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.lambda-2.<anonymous> (ModalBottomSheet.android.kt:290)");
            }
            SheetDefaults.INSTANCE.m1225DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, composer, ProfileVerifier.CompilationStatus.f184xf2722a21, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f341lambda3 = ComposableLambdaKt.composableLambdaInstance(163832305, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ModalBottomSheet.android.kt#uh7d8r");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163832305, i, -1, "androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.lambda-3.<anonymous> (ModalBottomSheet.android.kt:513)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material3_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1350getLambda1$material3_release() {
        return f339lambda1;
    }

    /* renamed from: getLambda-2$material3_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1351getLambda2$material3_release() {
        return f340lambda2;
    }

    /* renamed from: getLambda-3$material3_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1352getLambda3$material3_release() {
        return f341lambda3;
    }
}
