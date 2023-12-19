package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoDimensionalFocusSearch.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0003\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0003\u001a1\u0010\u001a\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a5\u0010\u001e\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a=\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a=\u0010'\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010&\u001a\f\u0010)\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a7\u0010*\u001a\u0004\u0018\u00010\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: TwoDimensionalFocusSearch.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
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

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final Boolean m2283twoDimensionalFocusSearchOMvw8(FocusTargetModifierNode twoDimensionalFocusSearch, int i, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(twoDimensionalFocusSearch, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        int i2 = WhenMappings.$EnumSwitchMapping$0[twoDimensionalFocusSearch.getFocusStateImpl$ui_release().ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return Boolean.valueOf(m2279findChildCorrespondingToFocusEnterOMvw8(twoDimensionalFocusSearch, i, onFound));
            }
            if (i2 == 4) {
                if (twoDimensionalFocusSearch.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke(twoDimensionalFocusSearch);
                }
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(twoDimensionalFocusSearch);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild.toString());
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[activeChild.getFocusStateImpl$ui_release().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                return Boolean.valueOf(m2280generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeChild, i, onFound));
            }
            if (i3 == 4) {
                throw new IllegalStateException(NoActiveChild.toString());
            }
            throw new NoWhenBranchMatchedException();
        }
        Boolean m2283twoDimensionalFocusSearchOMvw8 = m2283twoDimensionalFocusSearchOMvw8(activeChild, i, onFound);
        if (Intrinsics.areEqual((Object) m2283twoDimensionalFocusSearchOMvw8, (Object) false)) {
            FocusRequester invoke = activeChild.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2239boximpl(i));
            if (Intrinsics.areEqual(invoke, FocusRequester.Companion.getDefault())) {
                invoke = null;
            }
            FocusRequester focusRequester = invoke;
            if (focusRequester != null) {
                if (Intrinsics.areEqual(focusRequester, FocusRequester.Companion.getCancel())) {
                    return null;
                }
                return Boolean.valueOf(focusRequester.findFocusTarget$ui_release(onFound));
            }
            return Boolean.valueOf(m2280generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeNode(activeChild), i, onFound));
        }
        return m2283twoDimensionalFocusSearchOMvw8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object[]] */
    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    public static final boolean m2279findChildCorrespondingToFocusEnterOMvw8(FocusTargetModifierNode findChildCorrespondingToFocusEnter, int i, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        Rect bottomRight;
        Intrinsics.checkNotNullParameter(findChildCorrespondingToFocusEnter, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        FocusRequester invoke = findChildCorrespondingToFocusEnter.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2239boximpl(i));
        if (Intrinsics.areEqual(invoke, FocusRequester.Companion.getDefault())) {
            invoke = null;
        }
        FocusRequester focusRequester = invoke;
        if (focusRequester != null) {
            if (Intrinsics.areEqual(focusRequester, FocusRequester.Companion.getCancel())) {
                return false;
            }
            return focusRequester.findFocusTarget$ui_release(onFound);
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        collectAccessibleChildren(findChildCorrespondingToFocusEnter, mutableVector);
        if (mutableVector.getSize() > 1) {
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2251getEnterdhqQ8s())) {
                i = FocusDirection.Companion.m2258getRightdhqQ8s();
            }
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
                bottomRight = topLeft(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
            } else {
                if (!(FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s()))) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                bottomRight = bottomRight(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
            }
            FocusTargetModifierNode m2278findBestCandidate4WY_MpI = m2278findBestCandidate4WY_MpI(mutableVector, bottomRight, i);
            if (m2278findBestCandidate4WY_MpI != null) {
                return onFound.invoke(m2278findBestCandidate4WY_MpI).booleanValue();
            }
            return false;
        }
        FocusTargetModifierNode focusTargetModifierNode = mutableVector.isEmpty() ? null : mutableVector.getContent()[0];
        if (focusTargetModifierNode != null) {
            return onFound.invoke(focusTargetModifierNode).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2280generateAndSearchChildren4C6V_qg(final FocusTargetModifierNode focusTargetModifierNode, final FocusTargetModifierNode focusTargetModifierNode2, final int i, final Function1<? super FocusTargetModifierNode, Boolean> function1) {
        if (m2282searchChildren4C6V_qg(focusTargetModifierNode, focusTargetModifierNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2238searchBeyondBoundsOMvw8(focusTargetModifierNode, i, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m2282searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m2282searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m2282searchChildren4C6V_qg(FocusTargetModifierNode.this, focusTargetModifierNode2, i, function1);
                Boolean valueOf = Boolean.valueOf(m2282searchChildren4C6V_qg);
                if (valueOf.booleanValue() || !searchBeyondBounds.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusTargetModifierNode m2278findBestCandidate4WY_MpI(MutableVector<FocusTargetModifierNode> mutableVector, Rect rect, int i) {
        Rect translate;
        if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            translate = rect.translate(rect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
            translate = rect.translate(-(rect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
            translate = rect.translate(0.0f, rect.getHeight() + 1);
        } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else {
            translate = rect.translate(0.0f, -(rect.getHeight() + 1));
        }
        int size = mutableVector.getSize();
        FocusTargetModifierNode focusTargetModifierNode = null;
        if (size > 0) {
            FocusTargetModifierNode[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                FocusTargetModifierNode focusTargetModifierNode2 = content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusTargetModifierNode2);
                    if (m2281isBetterCandidateI7lrPNg(focusRect, translate, rect, i)) {
                        focusTargetModifierNode = focusTargetModifierNode2;
                        translate = focusRect;
                    }
                }
                i2++;
            } while (i2 < size);
            return focusTargetModifierNode;
        }
        return focusTargetModifierNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else {
            if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
                return true;
            }
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            } else {
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float left;
        float left2;
        float width;
        if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
            f = 2;
            left = rect2.getTop() + (rect2.getHeight() / f);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!(FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = 2;
            left = rect2.getLeft() + (rect2.getWidth() / f);
            left2 = rect.getLeft();
            width = rect.getWidth();
        }
        return left - (left2 + (width / f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long abs = Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect));
        long abs2 = Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect));
        return (13 * abs * abs) + (abs2 * abs2);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m2281isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            return !isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) || m2277beamBeatsI7lrPNg(rect3, rect, rect2, i) || (!m2277beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2));
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i, Rect rect2) {
        if (!(FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s()))) {
            if (!(FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s()) ? true : FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight()) {
                return true;
            }
        } else if (rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom()) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else {
            if (rect2.getBottom() <= rect.getTop()) {
                return true;
            }
        }
        return false;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$15(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            } else {
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i, Rect rect2) {
        float bottom;
        float bottom2;
        float top;
        float top2;
        float f;
        if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s())) {
            if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2259getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else if (!FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2250getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            } else {
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            }
            f = bottom - bottom2;
            return Math.max(1.0f, f);
        }
        top = rect2.getLeft();
        top2 = rect.getLeft();
        f = top - top2;
        return Math.max(1.0f, f);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m2277beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        return !beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect) || FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2254getLeftdhqQ8s()) || FocusDirection.m2242equalsimpl0(i, FocusDirection.Companion.m2258getRightdhqQ8s()) || beamBeats_I7lrPNg$majorAxisDistance$15(rect2, i, rect) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect);
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final FocusTargetModifierNode activeNode(FocusTargetModifierNode focusTargetModifierNode) {
        if (!(focusTargetModifierNode.getFocusState() == FocusStateImpl.ActiveParent)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetModifierNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2282searchChildren4C6V_qg(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2, int i, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        FocusTargetModifierNode m2278findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        FocusTargetModifierNode focusTargetModifierNode3 = focusTargetModifierNode;
        int m4277constructorimpl = NodeKind.m4277constructorimpl(1024);
        if (!focusTargetModifierNode3.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetModifierNode3.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetModifierNode3.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m4277constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m4277constructorimpl) != 0) {
                        if (node instanceof FocusTargetModifierNode) {
                            mutableVector.add((FocusTargetModifierNode) node);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
        while (mutableVector.isNotEmpty() && (m2278findBestCandidate4WY_MpI = m2278findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusTargetModifierNode2), i)) != null) {
            if (m2278findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return function1.invoke(m2278findBestCandidate4WY_MpI).booleanValue();
            }
            FocusRequester invoke = m2278findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2239boximpl(i));
            if (Intrinsics.areEqual(invoke, FocusRequester.Companion.getDefault())) {
                invoke = null;
            }
            FocusRequester focusRequester = invoke;
            if (focusRequester != null) {
                if (Intrinsics.areEqual(focusRequester, FocusRequester.Companion.getCancel())) {
                    return false;
                }
                return focusRequester.findFocusTarget$ui_release(function1);
            } else if (m2280generateAndSearchChildren4C6V_qg(m2278findBestCandidate4WY_MpI, focusTargetModifierNode2, i, function1)) {
                return true;
            } else {
                mutableVector.remove(m2278findBestCandidate4WY_MpI);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void collectAccessibleChildren(androidx.compose.ui.node.DelegatableNode r9, androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusTargetModifierNode> r10) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m4277constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto Ld1
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r2 = 16
            androidx.compose.ui.Modifier$Node[] r2 = new androidx.compose.ui.Modifier.Node[r2]
            r3 = 0
            r1.<init>(r2, r3)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getChild$ui_release()
            if (r2 != 0) goto L2c
            androidx.compose.ui.Modifier$Node r9 = r9.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r9)
            goto L2f
        L2c:
            r1.add(r2)
        L2f:
            boolean r9 = r1.isNotEmpty()
            if (r9 == 0) goto Ld0
            int r9 = r1.getSize()
            r2 = 1
            int r9 = r9 - r2
            java.lang.Object r9 = r1.removeAt(r9)
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            int r4 = r9.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto Lcb
            r4 = r9
        L49:
            if (r4 == 0) goto Lcb
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto Lc5
            boolean r5 = r4 instanceof androidx.compose.ui.focus.FocusTargetModifierNode
            if (r5 == 0) goto Lc2
            r5 = r4
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.ui.focus.FocusTargetModifierNode) r5
            boolean r6 = r5.isAttached()
            if (r6 != 0) goto L61
        L5f:
            r5 = r3
            goto Lc3
        L61:
            androidx.compose.ui.focus.FocusProperties r6 = r5.fetchFocusProperties$ui_release()
            boolean r6 = r6.getCanFocus()
            if (r6 == 0) goto L6f
            r10.add(r5)
            goto L5f
        L6f:
            androidx.compose.ui.focus.FocusProperties r5 = r5.fetchFocusProperties$ui_release()
            kotlin.jvm.functions.Function1 r5 = r5.getEnter()
            androidx.compose.ui.focus.FocusDirection$Companion r6 = androidx.compose.ui.focus.FocusDirection.Companion
            int r6 = r6.m2251getEnterdhqQ8s()
            androidx.compose.ui.focus.FocusDirection r6 = androidx.compose.ui.focus.FocusDirection.m2239boximpl(r6)
            java.lang.Object r5 = r5.invoke(r6)
            r6 = r5
            androidx.compose.ui.focus.FocusRequester r6 = (androidx.compose.ui.focus.FocusRequester) r6
            androidx.compose.ui.focus.FocusRequester$Companion r7 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r7 = r7.getDefault()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 != 0) goto L95
            goto L96
        L95:
            r5 = 0
        L96:
            androidx.compose.ui.focus.FocusRequester r5 = (androidx.compose.ui.focus.FocusRequester) r5
            if (r5 == 0) goto Lc2
            androidx.compose.ui.focus.FocusRequester$Companion r6 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r6 = r6.getCancel()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r6 != 0) goto L5f
            androidx.compose.runtime.collection.MutableVector r5 = r5.getFocusRequesterNodes$ui_release()
            int r6 = r5.getSize()
            if (r6 <= 0) goto L5f
            java.lang.Object[] r5 = r5.getContent()
            r7 = r3
        Lb5:
            r8 = r5[r7]
            androidx.compose.ui.focus.FocusRequesterModifierNode r8 = (androidx.compose.ui.focus.FocusRequesterModifierNode) r8
            androidx.compose.ui.node.DelegatableNode r8 = (androidx.compose.ui.node.DelegatableNode) r8
            collectAccessibleChildren(r8, r10)
            int r7 = r7 + r2
            if (r7 < r6) goto Lb5
            goto L5f
        Lc2:
            r5 = r2
        Lc3:
            if (r5 == 0) goto L2f
        Lc5:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L49
        Lcb:
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r9)
            goto L2f
        Ld0:
            return
        Ld1:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Check failed."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.collectAccessibleChildren(androidx.compose.ui.node.DelegatableNode, androidx.compose.runtime.collection.MutableVector):void");
    }
}
