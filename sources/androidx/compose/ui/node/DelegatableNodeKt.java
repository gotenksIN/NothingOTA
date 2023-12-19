package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatableNode.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a8\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a6\u0010\u000f\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0010*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a%\u0010\u0013\u001a\u00020\u0014*\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\bH\u0007\u001a2\u0010\u0018\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0012\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a2\u0010\u001a\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0012\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a6\u0010\u001c\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0010*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0012\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a%\u0010\u001e\u001a\u00020\u001f*\u00020\b2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a\f\u0010#\u001a\u00020$*\u00020\bH\u0001\u001a\f\u0010%\u001a\u00020&*\u00020\bH\u0001\u001aG\u0010'\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001a,\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002\u001aG\u0010,\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a,\u0010,\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002\u001aG\u0010.\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010+\u001a,\u0010.\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002\u001aG\u00100\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010+\u001a,\u00100\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002\u001aG\u00102\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010+\u001a,\u00102\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\u0081\bø\u0001\u0002\u001aG\u00104\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00140)H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010+\u001a,\u00104\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140)H\u0081\bø\u0001\u0002\u0082\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "mask", "", "firstChild", "", "firstChild-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "has", "", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "localChild", "localChild-64DMado", "localParent", "localParent-64DMado", "nearestAncestor", "nearestAncestor-64DMado", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "block", "Lkotlin/Function1;", "visitAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "visitLocalChildren", "visitLocalChildren-6rFNWt0", "visitLocalParents", "visitLocalParents-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DelegatableNodeKt {
    public static final Modifier.Node localChild(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
            return null;
        }
        while (child$ui_release != null) {
            if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }

    public static final Modifier.Node localParent(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final void visitAncestors(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> block) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        block.invoke(parent$ui_release);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }

    public static final List<Modifier.Node> ancestors(DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(parent$ui_release);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return arrayList;
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        return parent$ui_release;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return null;
    }

    public static final Modifier.Node firstChild(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, node);
            } else {
                while (node != null) {
                    if ((node.getKindSet$ui_release() & i) != 0) {
                        return node;
                    }
                    node = node.getChild$ui_release();
                }
                continue;
            }
        }
        return null;
    }

    public static final void visitSubtree(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
            }
            if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        block.invoke(child$ui_release);
                    }
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
                child$ui_release = null;
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
        }
    }

    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = size - 1;
            LayoutNode[] content = mutableVector2.getContent();
            do {
                mutableVector.add(content[i].getNodes$ui_release().getHead$ui_release());
                i--;
            } while (i >= 0);
        }
    }

    public static final void visitChildren(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & i) != 0) {
                        block.invoke(node);
                        break;
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    public static final void visitSubtreeIf(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Boolean> block) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild$ui_release()) {
                    if ((node2.getKindSet$ui_release() & i) == 0 || block.invoke(node2).booleanValue()) {
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node);
        }
    }

    public static final void visitLocalChildren(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
            return;
        }
        for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                block.invoke(child$ui_release);
            }
        }
    }

    public static final void visitLocalParents(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                block.invoke(parent$ui_release);
            }
        }
    }

    /* renamed from: localParent-64DMado */
    public static final /* synthetic */ <T> T m4179localParent64DMado(DelegatableNode localParent, int i) {
        Intrinsics.checkNotNullParameter(localParent, "$this$localParent");
        Modifier.Node localParent2 = localParent(localParent, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) localParent2;
    }

    /* renamed from: localChild-64DMado */
    public static final /* synthetic */ <T> T m4178localChild64DMado(DelegatableNode localChild, int i) {
        Intrinsics.checkNotNullParameter(localChild, "$this$localChild");
        Modifier.Node localChild2 = localChild(localChild, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) localChild2;
    }

    /* renamed from: ancestors-64DMado */
    public static final /* synthetic */ <T> List<T> m4175ancestors64DMado(DelegatableNode ancestors, int i) {
        Intrinsics.checkNotNullParameter(ancestors, "$this$ancestors");
        List<T> list = (List<T>) ancestors(ancestors, i);
        if (list instanceof List) {
            return list;
        }
        return null;
    }

    /* renamed from: nearestAncestor-64DMado */
    public static final /* synthetic */ <T> T m4180nearestAncestor64DMado(DelegatableNode nearestAncestor, int i) {
        Intrinsics.checkNotNullParameter(nearestAncestor, "$this$nearestAncestor");
        Modifier.Node nearestAncestor2 = nearestAncestor(nearestAncestor, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) nearestAncestor2;
    }

    /* renamed from: firstChild-64DMado */
    public static final /* synthetic */ <T> T m4176firstChild64DMado(DelegatableNode firstChild, int i) {
        Intrinsics.checkNotNullParameter(firstChild, "$this$firstChild");
        Modifier.Node firstChild2 = firstChild(firstChild, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) firstChild2;
    }

    /* renamed from: has-64DMado */
    public static final boolean m4177has64DMado(DelegatableNode has, int i) {
        Intrinsics.checkNotNullParameter(has, "$this$has");
        return (has.getNode().getAggregateChildKindSet$ui_release() & i) != 0;
    }

    /* renamed from: requireCoordinator-64DMado */
    public static final NodeCoordinator m4181requireCoordinator64DMado(DelegatableNode requireCoordinator, int i) {
        Intrinsics.checkNotNullParameter(requireCoordinator, "$this$requireCoordinator");
        NodeCoordinator coordinator$ui_release = requireCoordinator.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() == requireCoordinator && NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(i)) {
            NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(wrapped$ui_release);
            return wrapped$ui_release;
        }
        return coordinator$ui_release;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Owner owner$ui_release = requireLayoutNode(delegatableNode).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final void invalidateSubtree(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (delegatableNode.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, null);
        }
    }

    /* renamed from: visitLocalChildren-6rFNWt0 */
    public static final /* synthetic */ <T> void m4184visitLocalChildren6rFNWt0(DelegatableNode visitLocalChildren, int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitLocalChildren, "$this$visitLocalChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitLocalChildren.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = visitLocalChildren.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (child$ui_release instanceof Object) {
                        block.invoke(child$ui_release);
                    }
                }
            }
        }
    }

    /* renamed from: visitLocalParents-6rFNWt0 */
    public static final /* synthetic */ <T> void m4185visitLocalParents6rFNWt0(DelegatableNode visitLocalParents, int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitLocalParents, "$this$visitLocalParents");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitLocalParents.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier.Node parent$ui_release = visitLocalParents.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (parent$ui_release instanceof Object) {
                    block.invoke(parent$ui_release);
                }
            }
        }
    }

    /* renamed from: visitAncestors-6rFNWt0 */
    public static final /* synthetic */ <T> void m4182visitAncestors6rFNWt0(DelegatableNode visitAncestors, int i, Function1<? super T, Unit> block) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(visitAncestors, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitAncestors.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = visitAncestors.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(visitAncestors);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (parent$ui_release instanceof Object) {
                            block.invoke(parent$ui_release);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }

    /* renamed from: visitSubtree-6rFNWt0 */
    public static final /* synthetic */ <T> void m4186visitSubtree6rFNWt0(DelegatableNode visitSubtree, int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitSubtree, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitSubtree.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node child$ui_release = visitSubtree.getNode().getChild$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(visitSubtree);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
            }
            if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (child$ui_release instanceof Object) {
                            block.invoke(child$ui_release);
                        }
                    }
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
                child$ui_release = null;
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
        }
    }

    /* renamed from: visitChildren-6rFNWt0 */
    public static final /* synthetic */ <T> void m4183visitChildren6rFNWt0(DelegatableNode visitChildren, int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitChildren, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitChildren.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = visitChildren.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, visitChildren.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node instanceof Object) {
                            block.invoke(node);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    /* renamed from: visitSubtreeIf-6rFNWt0 */
    public static final /* synthetic */ <T> void m4187visitSubtreeIf6rFNWt0(DelegatableNode visitSubtreeIf, int i, Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(visitSubtreeIf, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitSubtreeIf.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = visitSubtreeIf.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, visitSubtreeIf.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild$ui_release()) {
                    if ((node2.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node2 instanceof Object ? block.invoke(node2).booleanValue() : true) {
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node);
        }
    }
}
