package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTransactions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0001\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean requestFocus(FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus()) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
            boolean z = true;
            if (i == 1 || i == 2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                return true;
            }
            if (i == 3) {
                if (!clearChildFocus$default(focusTargetModifierNode, false, false, 3, null) || !grantFocus(focusTargetModifierNode)) {
                    z = false;
                }
                if (z) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                }
                return z;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m4277constructorimpl(1024));
                FocusTargetModifierNode focusTargetModifierNode2 = nearestAncestor instanceof FocusTargetModifierNode ? nearestAncestor : null;
                if (focusTargetModifierNode2 != null) {
                    return requestFocusForChild(focusTargetModifierNode2, focusTargetModifierNode);
                }
                if (!requestFocusForOwner(focusTargetModifierNode) || !grantFocus(focusTargetModifierNode)) {
                    z = false;
                }
                if (z) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                }
                return z;
            }
        }
        return TwoDimensionalFocusSearchKt.m2279findChildCorrespondingToFocusEnterOMvw8(focusTargetModifierNode, FocusDirection.Companion.m2251getEnterdhqQ8s(), new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetModifierNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(it));
            }
        });
    }

    public static final boolean captureFocus(FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Captured);
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
            return true;
        } else if (i != 2) {
            if (i == 3 || i == 4) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        } else {
            return true;
        }
    }

    public static final boolean freeFocus(FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i != 1) {
            if (i == 2) {
                focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                return true;
            } else if (i == 3 || i == 4) {
                return false;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return true;
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetModifierNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
            }
        } else if (i == 2) {
            if (z) {
                focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                    return z;
                }
                return z;
            }
            return z;
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!clearChildFocus(focusTargetModifierNode, z, z2)) {
            return false;
        } else {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
            }
        }
        return true;
    }

    private static final boolean grantFocus(final FocusTargetModifierNode focusTargetModifierNode) {
        ObserverNodeKt.observeReads(focusTargetModifierNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTargetModifierNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 3 || i == 4) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
            return true;
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetModifierNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2) {
        FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(focusTargetModifierNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2) {
        Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode2, NodeKind.m4277constructorimpl(1024));
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        if (Intrinsics.areEqual((FocusTargetModifierNode) nearestAncestor, focusTargetModifierNode)) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
            if (i == 1) {
                boolean grantFocus = grantFocus(focusTargetModifierNode2);
                if (grantFocus) {
                    focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.ActiveParent);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode2);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                    return grantFocus;
                }
                return grantFocus;
            } else if (i != 2) {
                if (i == 3) {
                    if (FocusTraversalKt.getActiveChild(focusTargetModifierNode) == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    if (!clearChildFocus$default(focusTargetModifierNode, false, false, 3, null) || !grantFocus(focusTargetModifierNode2)) {
                        r2 = false;
                    }
                    if (r2) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode2);
                    }
                    return r2;
                } else if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    Modifier.Node nearestAncestor2 = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m4277constructorimpl(1024));
                    FocusTargetModifierNode focusTargetModifierNode3 = nearestAncestor2 instanceof FocusTargetModifierNode ? nearestAncestor2 : null;
                    if (focusTargetModifierNode3 == null && requestFocusForOwner(focusTargetModifierNode)) {
                        focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetModifierNode);
                        return requestFocusForChild(focusTargetModifierNode, focusTargetModifierNode2);
                    } else if (focusTargetModifierNode3 == null || !requestFocusForChild(focusTargetModifierNode3, focusTargetModifierNode)) {
                        return false;
                    } else {
                        boolean requestFocusForChild = requestFocusForChild(focusTargetModifierNode, focusTargetModifierNode2);
                        if (focusTargetModifierNode.getFocusState() == FocusStateImpl.ActiveParent) {
                            return requestFocusForChild;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            } else {
                return false;
            }
        }
        throw new IllegalStateException("Non child node cannot request focus.".toString());
    }

    private static final boolean requestFocusForOwner(FocusTargetModifierNode focusTargetModifierNode) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = focusTargetModifierNode.getCoordinator$ui_release();
        if (coordinator$ui_release == null || (layoutNode = coordinator$ui_release.getLayoutNode()) == null || (owner$ui_release = layoutNode.getOwner$ui_release()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner$ui_release.requestFocus();
    }
}
