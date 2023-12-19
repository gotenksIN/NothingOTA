package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", m30f = "DragGestureDetector.kt", m29i = {0, 1, 1}, m28l = {539, 541, 552}, m27m = "invokeSuspend", m26n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m25s = {"L$0", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectHorizontalDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Functions<Unit> $onDragCancel;
    final /* synthetic */ Functions<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectHorizontalDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Functions<Unit> functions, Functions<Unit> functions2, Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onHorizontalDrag = function2;
        this.$onDragEnd = functions;
        this.$onDragCancel = functions2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectHorizontalDragGestures$5 dragGestureDetectorKt$detectHorizontalDragGestures$5 = new DragGestureDetectorKt$detectHorizontalDragGestures$5(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
        dragGestureDetectorKt$detectHorizontalDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectHorizontalDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectHorizontalDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lb3
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1e:
            java.lang.Object r1 = r12.L$1
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r3 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L79
        L2a:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L4f
        L32:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r13
            r6 = 0
            r7 = 0
            r8 = r12
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9 = 2
            r10 = 0
            r12.L$0 = r13
            r12.label = r4
            r5 = r13
            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r1 != r0) goto L4c
            return r0
        L4c:
            r11 = r1
            r1 = r13
            r13 = r11
        L4f:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r13
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            long r5 = r13.m4257getIdJ3iCeTQ()
            int r7 = r13.m4261getTypeT8wyACA()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
            r13.<init>()
            r8 = r13
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.L$0 = r1
            r12.L$1 = r10
            r12.label = r3
            r4 = r1
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetector.m535awaitHorizontalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
            if (r13 != r0) goto L77
            return r0
        L77:
            r3 = r1
            r1 = r10
        L79:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r13
            if (r13 == 0) goto Lc6
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r12.$onDragStart
            long r5 = r13.m4258getPositionF1C5BW0()
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.p002ui.geometry.Offset.m2608boximpl(r5)
            r4.invoke(r5)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r12.$onHorizontalDrag
            float r1 = r1.element
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.boxing.boxFloat(r1)
            r4.invoke(r13, r1)
            long r4 = r13.m4257getIdJ3iCeTQ()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r1 = r12.$onHorizontalDrag
            r13.<init>()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r1 = r12
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6 = 0
            r12.L$0 = r6
            r12.L$1 = r6
            r12.label = r2
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetector.m548horizontalDragjO51t88(r3, r4, r13, r1)
            if (r13 != r0) goto Lb3
            return r0
        Lb3:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto Lc1
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragEnd
            r13.invoke()
            goto Lc6
        Lc1:
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragCancel
            r13.invoke()
        Lc6:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
