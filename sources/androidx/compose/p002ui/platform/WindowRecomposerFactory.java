package androidx.compose.p002ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory;", "", "createRecomposer", "Landroidx/compose/runtime/Recomposer;", "windowRootView", "Landroid/view/View;", "Companion", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.platform.WindowRecomposerFactory */
/* loaded from: classes.dex */
public interface WindowRecomposerFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    Recomposer createRecomposer(View view);

    /* compiled from: WindowRecomposer.android.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m40d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory$Companion;", "", "()V", "LifecycleAware", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getLifecycleAware$annotations", "getLifecycleAware", "()Landroidx/compose/ui/platform/WindowRecomposerFactory;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.platform.WindowRecomposerFactory$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final WindowRecomposerFactory LifecycleAware = new WindowRecomposerFactory() { // from class: androidx.compose.ui.platform.WindowRecomposerFactory$Companion$LifecycleAware$1
            @Override // androidx.compose.p002ui.platform.WindowRecomposerFactory
            public final Recomposer createRecomposer(View rootView) {
                Intrinsics.checkNotNullParameter(rootView, "rootView");
                return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(rootView, null, null, 3, null);
            }
        };

        public static /* synthetic */ void getLifecycleAware$annotations() {
        }

        private Companion() {
        }

        public final WindowRecomposerFactory getLifecycleAware() {
            return LifecycleAware;
        }
    }
}
