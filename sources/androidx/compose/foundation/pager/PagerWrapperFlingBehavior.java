package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pager.kt */
@Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m40d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "(Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final SnapFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    public PagerWrapperFlingBehavior(SnapFlingBehavior originalFlingBehavior, PagerState pagerState) {
        Intrinsics.checkNotNullParameter(originalFlingBehavior, "originalFlingBehavior");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        this.originalFlingBehavior = originalFlingBehavior;
        this.pagerState = pagerState;
    }

    public final SnapFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r7 = r4.originalFlingBehavior
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$2$1 r2 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$2$1
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.label = r3
            java.lang.Object r7 = r7.performFling(r5, r6, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            java.lang.Number r7 = (java.lang.Number) r7
            float r5 = r7.floatValue()
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerWrapperFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
