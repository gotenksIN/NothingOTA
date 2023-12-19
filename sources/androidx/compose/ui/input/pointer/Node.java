package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputNode", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputNode", "()Landroidx/compose/ui/node/PointerInputModifierNode;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;
    private final PointerInputModifierNode pointerInputNode;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(PointerInputModifierNode pointerInputNode) {
        Intrinsics.checkNotNullParameter(pointerInputNode, "pointerInputNode");
        this.pointerInputNode = pointerInputNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    public final PointerInputModifierNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        PointerInputChange pointerInputChange;
        boolean z2;
        LayoutCoordinates layoutCoordinates;
        int m3914getExit7fucELk;
        PointerInputChange m3954copyOHpmEuE;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, z);
        if (PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates(this.pointerInputNode);
            Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<PointerId, PointerInputChange> next = it.next();
                long m3945unboximpl = next.getKey().m3945unboximpl();
                PointerInputChange value = next.getValue();
                if (this.pointerIds.contains(PointerId.m3939boximpl(m3945unboximpl))) {
                    ArrayList arrayList = new ArrayList();
                    List<HistoricalChange> historical = value.getHistorical();
                    for (int size = historical.size(); i < size; size = size) {
                        HistoricalChange historicalChange = historical.get(i);
                        long uptimeMillis = historicalChange.getUptimeMillis();
                        LayoutCoordinates layoutCoordinates2 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates2);
                        arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates2.mo4081localPositionOfR5De75A(parentCoordinates, historicalChange.m3887getPositionF1C5BW0()), null));
                        i++;
                        historical = historical;
                    }
                    Map<PointerId, PointerInputChange> map = this.relevantChanges;
                    PointerId m3939boximpl = PointerId.m3939boximpl(m3945unboximpl);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    long mo4081localPositionOfR5De75A = layoutCoordinates3.mo4081localPositionOfR5De75A(parentCoordinates, value.m3958getPreviousPositionF1C5BW0());
                    LayoutCoordinates layoutCoordinates4 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates4);
                    m3954copyOHpmEuE = value.m3954copyOHpmEuE((r34 & 1) != 0 ? value.id : 0L, (r34 & 2) != 0 ? value.uptimeMillis : 0L, (r34 & 4) != 0 ? value.position : layoutCoordinates4.mo4081localPositionOfR5De75A(parentCoordinates, value.m3957getPositionF1C5BW0()), (r34 & 8) != 0 ? value.pressed : false, (r34 & 16) != 0 ? value.previousUptimeMillis : 0L, (r34 & 32) != 0 ? value.previousPosition : mo4081localPositionOfR5De75A, (r34 & 64) != 0 ? value.previousPressed : false, (r34 & 128) != 0 ? value.type : 0, arrayList, (r34 & 512) != 0 ? value.scrollDelta : 0L);
                    map.put(m3939boximpl, m3954copyOHpmEuE);
                }
            }
            if (this.relevantChanges.isEmpty()) {
                this.pointerIds.clear();
                getChildren().clear();
                return true;
            }
            for (int size2 = this.pointerIds.getSize() - 1; -1 < size2; size2--) {
                if (!changes.containsKey(PointerId.m3939boximpl(this.pointerIds.getContent()[size2].m3945unboximpl()))) {
                    this.pointerIds.removeAt(size2);
                }
            }
            PointerEvent pointerEvent = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent);
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size3 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size3) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i2);
                if (internalPointerEvent.m3889issuesEnterExitEvent0FcD4WY(pointerInputChange.m3956getIdJ3iCeTQ())) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                if (!z) {
                    this.isIn = false;
                } else if (!this.isIn && (pointerInputChange2.getPressed() || pointerInputChange2.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    z2 = true;
                    this.isIn = !PointerEventKt.m3904isOutOfBoundsO0kMr_c(pointerInputChange2, layoutCoordinates.mo4080getSizeYbymL2g());
                    if (this.isIn == this.wasIn && (PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3915getMove7fucELk()) || PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3913getEnter7fucELk()) || PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3914getExit7fucELk()))) {
                        if (this.isIn) {
                            m3914getExit7fucELk = PointerEventType.Companion.m3913getEnter7fucELk();
                        } else {
                            m3914getExit7fucELk = PointerEventType.Companion.m3914getExit7fucELk();
                        }
                        pointerEvent.m3903setTypeEhbLWgg$ui_release(m3914getExit7fucELk);
                    } else if (!PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3913getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                        pointerEvent.m3903setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3915getMove7fucELk());
                    } else if (PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3914getExit7fucELk()) && this.isIn && pointerInputChange2.getPressed()) {
                        pointerEvent.m3903setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3915getMove7fucELk());
                    }
                }
                z2 = true;
                if (this.isIn == this.wasIn) {
                }
                if (!PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3913getEnter7fucELk())) {
                }
                if (PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3914getExit7fucELk())) {
                    pointerEvent.m3903setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3915getMove7fucELk());
                }
            } else {
                z2 = true;
            }
            boolean z3 = (buildCache || !PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3915getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z2 : false;
            this.pointerEvent = pointerEvent;
            return z3;
        }
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m2315equalsimpl0(pointerEvent.getChanges().get(i).m3957getPositionF1C5BW0(), pointerEvent2.getChanges().get(i).m3957getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (!this.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            function0.invoke();
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size <= 0) {
            this.pointerInputNode.onCancelPointerInput();
        }
        Node[] content = children.getContent();
        int i = 0;
        do {
            content[i].dispatchCancel();
            i++;
        } while (i < size);
        this.pointerInputNode.onCancelPointerInput();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if ((pointerInputChange.getPressed() || (internalPointerEvent.m3889issuesEnterExitEvent0FcD4WY(pointerInputChange.m3956getIdJ3iCeTQ()) && this.isIn)) ? false : true) {
                this.pointerIds.remove(PointerId.m3939boximpl(pointerInputChange.m3956getIdJ3iCeTQ()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m3909equalsimpl0(pointerEvent.m3902getType7fucELk(), PointerEventType.Companion.m3914getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchMainEventPass(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9, androidx.compose.ui.layout.LayoutCoordinates r10, androidx.compose.ui.input.pointer.InternalPointerEvent r11, boolean r12) {
        /*
            r8 = this;
            java.lang.String r0 = "changes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r9 = "parentCoordinates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9 = r8.relevantChanges
            boolean r9 = r9.isEmpty()
            r10 = 0
            if (r9 == 0) goto L19
            goto L6f
        L19:
            androidx.compose.ui.node.PointerInputModifierNode r9 = r8.pointerInputNode
            boolean r9 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r9)
            if (r9 != 0) goto L22
            goto L6f
        L22:
            androidx.compose.ui.input.pointer.PointerEvent r9 = r8.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.ui.layout.LayoutCoordinates r0 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r0 = r0.mo4080getSizeYbymL2g()
            androidx.compose.ui.node.PointerInputModifierNode r2 = r8.pointerInputNode
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r2.mo4162onPointerEventH0pRuoY(r9, r3, r0)
            androidx.compose.ui.node.PointerInputModifierNode r2 = r8.pointerInputNode
            boolean r2 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r2)
            r3 = 1
            if (r2 == 0) goto L5f
            androidx.compose.runtime.collection.MutableVector r2 = r8.getChildren()
            int r4 = r2.getSize()
            if (r4 <= 0) goto L5f
            java.lang.Object[] r2 = r2.getContent()
        L4e:
            r5 = r2[r10]
            androidx.compose.ui.input.pointer.Node r5 = (androidx.compose.ui.input.pointer.Node) r5
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r6 = r8.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r7 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.dispatchMainEventPass(r6, r7, r11, r12)
            int r10 = r10 + r3
            if (r10 < r4) goto L4e
        L5f:
            androidx.compose.ui.node.PointerInputModifierNode r10 = r8.pointerInputNode
            boolean r10 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r10)
            if (r10 == 0) goto L6e
            androidx.compose.ui.node.PointerInputModifierNode r10 = r8.pointerInputNode
            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r10.mo4162onPointerEventH0pRuoY(r9, r11, r0)
        L6e:
            r10 = r3
        L6f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            this.pointerInputNode.mo4162onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, layoutCoordinates.mo4080getSizeYbymL2g());
            if (!PointerInputModifierNodeKt.isAttached(this.pointerInputNode) || (size = (children = getChildren()).getSize()) <= 0) {
                z = true;
            } else {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
                z = true;
            }
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
