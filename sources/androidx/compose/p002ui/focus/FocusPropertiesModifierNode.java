package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.node.DelegatableNode;
import kotlin.Metadata;

/* compiled from: FocusPropertiesModifierNode.kt */
@Metadata(m41d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "modifyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.FocusPropertiesModifierNode */
/* loaded from: classes.dex */
public interface FocusPropertiesModifierNode extends DelegatableNode {
    void modifyFocusProperties(FocusProperties focusProperties);
}
