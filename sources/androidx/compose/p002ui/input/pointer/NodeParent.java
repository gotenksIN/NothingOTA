package androidx.compose.p002ui.input.pointer;

import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(m41d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016ø\u0001\u0000J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J7\u0010\u0018\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016ø\u0001\u0000J\u0006\u0010\u0019\u001a\u00020\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m40d2 = {"Landroidx/compose/ui/input/pointer/NodeParent;", "", "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "buildCache", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clear", "dispatchCancel", "dispatchFinalEventPass", "dispatchMainEventPass", "removeDetachedPointerInputFilters", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.input.pointer.NodeParent */
/* loaded from: classes.dex */
public class NodeParent {
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].buildCache(changes, parentCoordinates, internalPointerEvent, z) || z2;
                i++;
            } while (i < size);
            return z2;
        }
        return false;
    }

    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, z) || z2;
                i++;
            } while (i < size);
            return z2;
        }
        return false;
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z = false;
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].dispatchFinalEventPass(internalPointerEvent) || z2;
                i++;
            } while (i < size);
            z = z2;
        }
        cleanUpHits(internalPointerEvent);
        return z;
    }

    public void dispatchCancel() {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        int i = 0;
        while (i < this.children.getSize()) {
            Node node = this.children.getContent()[i];
            if (!PointerInputModifierNodeKt.isAttached(node.getPointerInputNode())) {
                this.children.removeAt(i);
                node.dispatchCancel();
            } else {
                i++;
                node.removeDetachedPointerInputFilters();
            }
        }
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (this.children.getContent()[size].getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }
}
