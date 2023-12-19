package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001d\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001d\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000203H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u001d\u00105\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010.J\u000e\u00107\u001a\u0004\u0018\u000108*\u000209H\u0002J\\\u0010:\u001a\u00020\u0005\"\n\b\u0000\u0010;\u0018\u0001*\u000209*\u0002H;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00020\u00050\u0003H\u0083\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier$annotations", "()V", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getRootFocusNode$ui_release$annotations", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetModifierNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetModifierNode rootFocusNode;

    /* compiled from: FocusOwnerImpl.kt */
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
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getModifier$annotations() {
    }

    public static /* synthetic */ void getRootFocusNode$ui_release$annotations() {
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.rootFocusNode = new FocusTargetModifierNode();
        this.focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener);
        this.modifier = new ModifierNodeElement<FocusTargetModifierNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object obj) {
                return obj == this;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusTargetModifierNode update(FocusTargetModifierNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
                return node;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusTargetModifierNode create() {
                return FocusOwnerImpl.this.getRootFocusNode$ui_release();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
                inspectorInfo.setName("RootFocusTarget");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return FocusOwnerImpl.this.getRootFocusNode$ui_release().hashCode();
            }
        };
    }

    public final FocusTargetModifierNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<set-?>");
        this.rootFocusNode = focusTargetModifierNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusStateImpl$ui_release() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearFocus(boolean z, boolean z2) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusStateImpl$ui_release = this.rootFocusNode.getFocusStateImpl$ui_release();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2)) {
            FocusTargetModifierNode focusTargetModifierNode = this.rootFocusNode;
            int i = WhenMappings.$EnumSwitchMapping$0[focusStateImpl$ui_release.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                focusStateImpl = FocusStateImpl.Active;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                focusStateImpl = FocusStateImpl.Inactive;
            }
            focusTargetModifierNode.setFocusStateImpl$ui_release(focusStateImpl);
        }
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo2260moveFocus3ESFkO8(int i) {
        final FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester m2270customFocusSearchOMvw8 = FocusTraversalKt.m2270customFocusSearchOMvw8(findActiveFocusNode, i, getLayoutDirection());
        if (Intrinsics.areEqual(m2270customFocusSearchOMvw8, FocusRequester.Companion.getCancel())) {
            return false;
        }
        if (Intrinsics.areEqual(m2270customFocusSearchOMvw8, FocusRequester.Companion.getDefault())) {
            return FocusTraversalKt.m2271focusSearchsMXa3k8(this.rootFocusNode, i, getLayoutDirection(), new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetModifierNode destination) {
                    Intrinsics.checkNotNullParameter(destination, "destination");
                    if (Intrinsics.areEqual(destination, FocusTargetModifierNode.this)) {
                        return false;
                    }
                    Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(destination, NodeKind.m4277constructorimpl(1024));
                    if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
                        nearestAncestor = null;
                    }
                    if (((FocusTargetModifierNode) nearestAncestor) == null) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    return Boolean.valueOf(FocusTransactionsKt.requestFocus(destination));
                }
            }) || m2263wrapAroundFocus3ESFkO8(i);
        }
        return m2270customFocusSearchOMvw8.findFocusTarget$ui_release(new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetModifierNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(it));
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo2261dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        int i;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
        }
        FocusTargetModifierNode focusTargetModifierNode = findActiveFocusNode;
        KeyInputModifierNode lastLocalKeyInputNode = lastLocalKeyInputNode(focusTargetModifierNode);
        if (lastLocalKeyInputNode == null) {
            Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m4277constructorimpl(8192));
            if (!(nearestAncestor instanceof KeyInputModifierNode)) {
                nearestAncestor = null;
            }
            lastLocalKeyInputNode = (KeyInputModifierNode) nearestAncestor;
        }
        if (lastLocalKeyInputNode != null) {
            KeyInputModifierNode keyInputModifierNode = lastLocalKeyInputNode;
            List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(keyInputModifierNode, NodeKind.m4277constructorimpl(8192));
            List<Modifier.Node> list = ancestors instanceof List ? ancestors : null;
            if (list != null && list.size() - 1 >= 0) {
                while (true) {
                    int i2 = i - 1;
                    if (((KeyInputModifierNode) list.get(i)).mo3832onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    i = i2;
                }
            }
            KeyInputModifierNode keyInputModifierNode2 = keyInputModifierNode;
            if (keyInputModifierNode2.mo3832onPreKeyEventZmokQxo(keyEvent) || keyInputModifierNode2.mo3831onKeyEventZmokQxo(keyEvent)) {
                return true;
            }
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((KeyInputModifierNode) list.get(i3)).mo3831onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(findActiveFocusNode, NodeKind.m4277constructorimpl(16384));
            if (!(nearestAncestor instanceof RotaryInputModifierNode)) {
                nearestAncestor = null;
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) nearestAncestor;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(rotaryInputModifierNode2, NodeKind.m4277constructorimpl(16384));
            List<Modifier.Node> list = ancestors instanceof List ? ancestors : null;
            if (list != null && list.size() - 1 >= 0) {
                while (true) {
                    int i2 = i - 1;
                    if (((RotaryInputModifierNode) list.get(i)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    i = i2;
                }
            }
            RotaryInputModifierNode rotaryInputModifierNode3 = rotaryInputModifierNode2;
            if (rotaryInputModifierNode3.onPreRotaryScrollEvent(event) || rotaryInputModifierNode3.onRotaryScrollEvent(event)) {
                return true;
            }
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((RotaryInputModifierNode) list.get(i3)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m2263wrapAroundFocus3ESFkO8(int i) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2255getNextdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2257getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.rootFocusNode.getFocusState().isFocused()) {
                    return mo2260moveFocus3ESFkO8(i);
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: traverseAncestors-Y-YKmho  reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m2262traverseAncestorsYYKmho(T t, int i, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        int i2;
        List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(t, i);
        if (!(ancestors instanceof List)) {
            ancestors = null;
        }
        if (ancestors != null && ancestors.size() - 1 >= 0) {
            while (true) {
                int i3 = i2 - 1;
                function1.invoke(ancestors.get(i2));
                if (i3 < 0) {
                    break;
                }
                i2 = i3;
            }
        }
        function1.invoke(t);
        function12.invoke(t);
        if (ancestors != null) {
            int size = ancestors.size();
            for (int i4 = 0; i4 < size; i4++) {
                function12.invoke(ancestors.get(i4));
            }
        }
    }

    private final KeyInputModifierNode lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m4277constructorimpl = NodeKind.m4277constructorimpl(1024) | NodeKind.m4277constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        KeyInputModifierNode keyInputModifierNode = null;
        if ((node.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m4277constructorimpl) != 0) {
                    if ((NodeKind.m4277constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return keyInputModifierNode;
                    }
                    if (!(child$ui_release instanceof KeyInputModifierNode)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    keyInputModifierNode = child$ui_release;
                }
            }
        }
        return keyInputModifierNode;
    }
}