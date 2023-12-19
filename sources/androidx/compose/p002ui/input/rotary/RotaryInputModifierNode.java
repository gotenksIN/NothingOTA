package androidx.compose.p002ui.input.rotary;

import androidx.compose.p002ui.node.DelegatableNode;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: RotaryInputModifierNode.kt */
@Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onPreRotaryScrollEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "onRotaryScrollEvent", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.input.rotary.RotaryInputModifierNode */
/* loaded from: classes.dex */
public interface RotaryInputModifierNode extends DelegatableNode {
    boolean onPreRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent);

    boolean onRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent);
}
