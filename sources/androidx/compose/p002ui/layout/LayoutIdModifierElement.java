package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.node.ModifierNodeElement;
import androidx.compose.p002ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutId.kt */
@Metadata(m41d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m40d2 = {"Landroidx/compose/ui/layout/LayoutIdModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutIdModifier;", "layoutId", "", "(Ljava/lang/Object;)V", "component1", "copy", "create", "equals", "", "other", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.LayoutIdModifierElement */
/* loaded from: classes.dex */
final class LayoutIdModifierElement extends ModifierNodeElement<LayoutIdModifier> {
    private final Object layoutId;

    private final Object component1() {
        return this.layoutId;
    }

    public static /* synthetic */ LayoutIdModifierElement copy$default(LayoutIdModifierElement layoutIdModifierElement, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = layoutIdModifierElement.layoutId;
        }
        return layoutIdModifierElement.copy(obj);
    }

    public final LayoutIdModifierElement copy(Object layoutId) {
        Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        return new LayoutIdModifierElement(layoutId);
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutIdModifierElement) && Intrinsics.areEqual(this.layoutId, ((LayoutIdModifierElement) obj).layoutId);
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public int hashCode() {
        return this.layoutId.hashCode();
    }

    public String toString() {
        return "LayoutIdModifierElement(layoutId=" + this.layoutId + ')';
    }

    public LayoutIdModifierElement(Object layoutId) {
        Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        this.layoutId = layoutId;
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public LayoutIdModifier create() {
        return new LayoutIdModifier(this.layoutId);
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public LayoutIdModifier update(LayoutIdModifier node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setLayoutId$ui_release(this.layoutId);
        return node;
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("layoutId");
        inspectorInfo.setValue(this.layoutId);
    }
}
