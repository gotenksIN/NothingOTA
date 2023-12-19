package androidx.compose.p002ui.modifier;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.node.BackwardsCompatNode;
import androidx.compose.p002ui.node.DelegatableNodeKt;
import androidx.compose.p002ui.node.LayoutNode;
import androidx.compose.p002ui.node.NodeKind;
import androidx.compose.p002ui.node.Owner;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalManager.kt */
@Metadata(m41d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m40d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.modifier.ModifierLocalManager */
/* loaded from: classes.dex */
public final class ModifierLocalManager {
    private final MutableVector<BackwardsCompatNode> inserted;
    private final MutableVector<ModifierLocal<?>> insertedLocal;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<LayoutNode> removed;
    private final MutableVector<ModifierLocal<?>> removedLocal;

    public ModifierLocalManager(Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
        this.insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
        this.removed = new MutableVector<>(new LayoutNode[16], 0);
        this.removedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (this.invalidated) {
            return;
        }
        this.invalidated = true;
        this.owner.registerOnEndApplyChangesListener(new Functions<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ModifierLocalManager.this.triggerUpdates();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f A[LOOP:2: B:19:0x0089->B:21:0x008f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void triggerUpdates() {
        /*
            r8 = this;
            r0 = 0
            r8.invalidated = r0
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r2 = r8.removed
            int r3 = r2.getSize()
            if (r3 <= 0) goto L43
            java.lang.Object[] r2 = r2.getContent()
            r4 = r0
        L15:
            r5 = r2[r4]
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.p002ui.node.LayoutNode) r5
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> r6 = r8.removedLocal
            java.lang.Object[] r6 = r6.getContent()
            r6 = r6[r4]
            androidx.compose.ui.modifier.ModifierLocal r6 = (androidx.compose.p002ui.modifier.ModifierLocal) r6
            androidx.compose.ui.node.NodeChain r7 = r5.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r7 = r7.getHead$ui_release()
            boolean r7 = r7.isAttached()
            if (r7 == 0) goto L3f
            androidx.compose.ui.node.NodeChain r5 = r5.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r5 = r5.getHead$ui_release()
            r7 = r1
            java.util.Set r7 = (java.util.Set) r7
            r8.invalidateConsumersOfNodeForKey(r5, r6, r7)
        L3f:
            int r4 = r4 + 1
            if (r4 < r3) goto L15
        L43:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r2 = r8.removed
            r2.clear()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> r2 = r8.removedLocal
            r2.clear()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.BackwardsCompatNode> r2 = r8.inserted
            int r3 = r2.getSize()
            if (r3 <= 0) goto L79
            java.lang.Object[] r2 = r2.getContent()
        L59:
            r4 = r2[r0]
            androidx.compose.ui.node.BackwardsCompatNode r4 = (androidx.compose.p002ui.node.BackwardsCompatNode) r4
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> r5 = r8.insertedLocal
            java.lang.Object[] r5 = r5.getContent()
            r5 = r5[r0]
            androidx.compose.ui.modifier.ModifierLocal r5 = (androidx.compose.p002ui.modifier.ModifierLocal) r5
            boolean r6 = r4.isAttached()
            if (r6 == 0) goto L75
            androidx.compose.ui.Modifier$Node r4 = (androidx.compose.p002ui.Modifier.Node) r4
            r6 = r1
            java.util.Set r6 = (java.util.Set) r6
            r8.invalidateConsumersOfNodeForKey(r4, r5, r6)
        L75:
            int r0 = r0 + 1
            if (r0 < r3) goto L59
        L79:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.BackwardsCompatNode> r0 = r8.inserted
            r0.clear()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> r0 = r8.insertedLocal
            r0.clear()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L89:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L99
            java.lang.Object r1 = r0.next()
            androidx.compose.ui.node.BackwardsCompatNode r1 = (androidx.compose.p002ui.node.BackwardsCompatNode) r1
            r1.updateModifierLocalConsumer()
            goto L89
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.modifier.ModifierLocalManager.triggerUpdates():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> modifierLocal, Set<BackwardsCompatNode> set) {
        boolean z;
        Modifier.Node node2 = node;
        int m4578constructorimpl = NodeKind.m4578constructorimpl(32);
        if (!node2.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = node2.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node2.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node3.getAggregateChildKindSet$ui_release() & m4578constructorimpl) != 0) {
                for (Modifier.Node node4 = node3; node4 != null; node4 = node4.getChild$ui_release()) {
                    if ((node4.getKindSet$ui_release() & m4578constructorimpl) != 0) {
                        if (node4 instanceof ModifierLocalNode) {
                            ModifierLocalNode modifierLocalNode = (ModifierLocalNode) node4;
                            if (modifierLocalNode instanceof BackwardsCompatNode) {
                                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalNode;
                                if ((backwardsCompatNode.getElement() instanceof ModifierLocalConsumer) && backwardsCompatNode.getReadValues().contains(modifierLocal)) {
                                    set.add(modifierLocalNode);
                                }
                            }
                            z = !modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal);
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node3);
        }
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.removed.add(DelegatableNodeKt.requireLayoutNode(node));
        this.removedLocal.add(key);
        invalidate();
    }
}
