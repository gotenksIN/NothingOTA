package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.node.LayoutNode;
import androidx.compose.p002ui.node.NodeCoordinator;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, m40d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Lkotlin/Comparator;", "()V", "compare", "", "focusTarget1", "focusTarget2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.FocusableChildrenComparator */
/* loaded from: classes.dex */
final class OneDimensionalFocusSearch implements Comparator<FocusTargetModifierNode> {
    public static final OneDimensionalFocusSearch INSTANCE = new OneDimensionalFocusSearch();

    private OneDimensionalFocusSearch() {
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2) {
        if (focusTargetModifierNode != null) {
            if (focusTargetModifierNode2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int i = 0;
            if (!FocusTraversal.isEligibleForFocusSearch(focusTargetModifierNode) || !FocusTraversal.isEligibleForFocusSearch(focusTargetModifierNode2)) {
                if (FocusTraversal.isEligibleForFocusSearch(focusTargetModifierNode)) {
                    return -1;
                }
                return FocusTraversal.isEligibleForFocusSearch(focusTargetModifierNode2) ? 1 : 0;
            }
            NodeCoordinator coordinator$ui_release = focusTargetModifierNode.getCoordinator$ui_release();
            LayoutNode layoutNode = coordinator$ui_release != null ? coordinator$ui_release.getLayoutNode() : null;
            if (layoutNode == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            NodeCoordinator coordinator$ui_release2 = focusTargetModifierNode2.getCoordinator$ui_release();
            LayoutNode layoutNode2 = coordinator$ui_release2 != null ? coordinator$ui_release2.getLayoutNode() : null;
            if (layoutNode2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (Intrinsics.areEqual(layoutNode, layoutNode2)) {
                return 0;
            }
            MutableVector<LayoutNode> pathFromRoot = pathFromRoot(layoutNode);
            MutableVector<LayoutNode> pathFromRoot2 = pathFromRoot(layoutNode2);
            int min = Math.min(pathFromRoot.getSize() - 1, pathFromRoot2.getSize() - 1);
            if (min >= 0) {
                while (Intrinsics.areEqual(pathFromRoot.getContent()[i], pathFromRoot2.getContent()[i])) {
                    if (i != min) {
                        i++;
                    }
                }
                return Intrinsics.compare(pathFromRoot.getContent()[i].getPlaceOrder$ui_release(), pathFromRoot2.getContent()[i].getPlaceOrder$ui_release());
            }
            throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = new MutableVector<>(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.add(0, layoutNode);
            layoutNode = layoutNode.getParent$ui_release();
        }
        return mutableVector;
    }
}
