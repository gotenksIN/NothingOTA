package androidx.compose.p002ui.platform;

import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidViewConfiguration.android.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m40d2 = {"Landroidx/compose/ui/platform/AndroidViewConfiguration;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "(Landroid/view/ViewConfiguration;)V", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "touchSlop", "", "getTouchSlop", "()F", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.platform.AndroidViewConfiguration */
/* loaded from: classes.dex */
public final class AndroidViewConfiguration implements ViewConfiguration {
    public static final int $stable = 8;
    private final ViewConfiguration viewConfiguration;

    @Override // androidx.compose.p002ui.platform.ViewConfiguration
    public long getDoubleTapMinTimeMillis() {
        return 40L;
    }

    public AndroidViewConfiguration(ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.p002ui.platform.ViewConfiguration
    public long getLongPressTimeoutMillis() {
        return ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.p002ui.platform.ViewConfiguration
    public long getDoubleTapTimeoutMillis() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.p002ui.platform.ViewConfiguration
    public float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }
}
