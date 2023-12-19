package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, m40d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.focus.BeyondBoundsLayoutKt */
/* loaded from: classes.dex */
public final class BeyondBoundsLayout {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m2539searchBeyondBoundsOMvw8(FocusTargetModifierNode searchBeyondBounds, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int m4362getBeforehoxUOeE;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        androidx.compose.p002ui.layout.BeyondBoundsLayout beyondBoundsLayoutParent$ui_release = searchBeyondBounds.getBeyondBoundsLayoutParent$ui_release();
        if (beyondBoundsLayoutParent$ui_release != null) {
            if (FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2560getUpdhqQ8s())) {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4360getAbovehoxUOeE();
            } else if (FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2551getDowndhqQ8s())) {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4363getBelowhoxUOeE();
            } else if (FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2555getLeftdhqQ8s())) {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4364getLefthoxUOeE();
            } else if (FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2559getRightdhqQ8s())) {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4365getRighthoxUOeE();
            } else if (FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2556getNextdhqQ8s())) {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4361getAfterhoxUOeE();
            } else if (!FocusDirection.m2543equalsimpl0(i, FocusDirection.Companion.m2558getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            } else {
                m4362getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4362getBeforehoxUOeE();
            }
            return (T) beyondBoundsLayoutParent$ui_release.mo917layouto7g1Pn8(m4362getBeforehoxUOeE, block);
        }
        return null;
    }
}
