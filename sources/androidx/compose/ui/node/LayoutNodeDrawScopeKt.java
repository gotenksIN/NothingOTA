package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"nextDrawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawModifierNode nextDrawNode(DelegatableNode delegatableNode) {
        int m4277constructorimpl = NodeKind.m4277constructorimpl(4);
        int m4277constructorimpl2 = NodeKind.m4277constructorimpl(2);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & m4277constructorimpl) == 0) {
            return null;
        }
        while (child$ui_release != null && (child$ui_release.getKindSet$ui_release() & m4277constructorimpl2) == 0) {
            if ((child$ui_release.getKindSet$ui_release() & m4277constructorimpl) != 0) {
                return (DrawModifierNode) child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }
}