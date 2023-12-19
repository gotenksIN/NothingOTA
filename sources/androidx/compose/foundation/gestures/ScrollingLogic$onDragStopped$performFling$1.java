package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(m41d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m40d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", m30f = "Scrollable.kt", m29i = {0, 1, 1, 2, 2}, m28l = {406, 408, 410}, m27m = "invokeSuspend", m26n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, m25s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* loaded from: classes.dex */
public final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).m5585unboximpl();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m625invokesFctU(velocity.m5585unboximpl(), continuation);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m625invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m5567boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L37
            if (r2 == r4) goto L28
            if (r2 != r3) goto L20
            long r1 = r0.J$1
            long r3 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r5 = r3
            r3 = r1
            r2 = r19
            goto La5
        L20:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L28:
            long r4 = r0.J$1
            long r6 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r19
            r16 = r4
            r5 = r6
            r7 = r16
            goto L7b
        L37:
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r19
            goto L5f
        L3f:
            kotlin.ResultKt.throwOnFailure(r19)
            long r6 = r0.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.runtime.State r2 = r2.getNestedScrollDispatcher()
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r2 = (androidx.compose.p002ui.input.nestedscroll.NestedScrollDispatcher) r2
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r2 = r2.m4147dispatchPreFlingQWom1Mo(r6, r8)
            if (r2 != r1) goto L5e
            return r1
        L5e:
            r5 = r6
        L5f:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.p002ui.unit.Velocity) r2
            long r7 = r2.m5585unboximpl()
            long r7 = androidx.compose.p002ui.unit.Velocity.m5579minusAH228Gc(r5, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.J$0 = r5
            r0.J$1 = r7
            r0.label = r4
            java.lang.Object r2 = r2.m613doFlingAnimationQWom1Mo(r7, r9)
            if (r2 != r1) goto L7b
            return r1
        L7b:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.p002ui.unit.Velocity) r2
            long r14 = r2.m5585unboximpl()
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.runtime.State r2 = r2.getNestedScrollDispatcher()
            java.lang.Object r2 = r2.getValue()
            r9 = r2
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r9 = (androidx.compose.p002ui.input.nestedscroll.NestedScrollDispatcher) r9
            long r10 = androidx.compose.p002ui.unit.Velocity.m5579minusAH228Gc(r7, r14)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.J$0 = r5
            r0.J$1 = r14
            r0.label = r3
            r12 = r14
            r3 = r14
            r14 = r2
            java.lang.Object r2 = r9.m4145dispatchPostFlingRZ2iAVY(r10, r12, r14)
            if (r2 != r1) goto La5
            return r1
        La5:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.p002ui.unit.Velocity) r2
            long r1 = r2.m5585unboximpl()
            long r1 = androidx.compose.p002ui.unit.Velocity.m5579minusAH228Gc(r3, r1)
            long r1 = androidx.compose.p002ui.unit.Velocity.m5579minusAH228Gc(r5, r1)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.p002ui.unit.Velocity.m5567boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
