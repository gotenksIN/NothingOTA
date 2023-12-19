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
@DebugMetadata(m31c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", m30f = "DragGestureDetector.kt", m29i = {0, 1, 2}, m28l = {235, 236, 241}, m27m = "invokeSuspend", m26n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, m25s = {"L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Functions<Unit> $onDragCancel;
    final /* synthetic */ Functions<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Functions<Unit> functions, Functions<Unit> functions2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = functions;
        this.$onDragCancel = functions2;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[Catch: CancellationException -> 0x00c5, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003c), top: B:46:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[Catch: CancellationException -> 0x00c5, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003c), top: B:46:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd A[Catch: CancellationException -> 0x00c5, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003c), top: B:46:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
            goto L8e
        L1a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L22:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
            goto L61
        L2a:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
            goto L4d
        L32:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r1
            r6 = 0
            r7 = 0
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.util.concurrent.CancellationException -> Lc5
            r9 = 2
            r10 = 0
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
            r11.label = r4     // Catch: java.util.concurrent.CancellationException -> Lc5
            r5 = r1
            java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r12 != r0) goto L4d
            return r0
        L4d:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
            long r4 = r12.m4257getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> Lc5
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> Lc5
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetector.m537awaitLongPressOrCancellationrnUCldI(r1, r4, r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r12 != r0) goto L61
            return r0
        L61:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r12 == 0) goto Lc2
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> Lc5
            long r4 = r12.m4258getPositionF1C5BW0()     // Catch: java.util.concurrent.CancellationException -> Lc5
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.p002ui.geometry.Offset.m2608boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> Lc5
            r3.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> Lc5
            long r3 = r12.m4257getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> Lc5
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> Lc5
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> Lc5
            r12.<init>()     // Catch: java.util.concurrent.CancellationException -> Lc5
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.util.concurrent.CancellationException -> Lc5
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> Lc5
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetector.m547dragjO51t88(r1, r3, r12, r5)     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r12 != r0) goto L8d
            return r0
        L8d:
            r0 = r1
        L8e:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
            boolean r12 = r12.booleanValue()     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r12 == 0) goto Lbd
            androidx.compose.ui.input.pointer.PointerEvent r12 = r0.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> Lc5
            java.util.List r12 = r12.getChanges()     // Catch: java.util.concurrent.CancellationException -> Lc5
            int r0 = r12.size()     // Catch: java.util.concurrent.CancellationException -> Lc5
            r1 = 0
        La3:
            if (r1 >= r0) goto Lb7
            java.lang.Object r2 = r12.get(r1)     // Catch: java.util.concurrent.CancellationException -> Lc5
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r2     // Catch: java.util.concurrent.CancellationException -> Lc5
            boolean r3 = androidx.compose.p002ui.input.pointer.PointerEventKt.changedToUp(r2)     // Catch: java.util.concurrent.CancellationException -> Lc5
            if (r3 == 0) goto Lb4
            r2.consume()     // Catch: java.util.concurrent.CancellationException -> Lc5
        Lb4:
            int r1 = r1 + 1
            goto La3
        Lb7:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> Lc5
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lc5
            goto Lc2
        Lbd:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> Lc5
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lc5
        Lc2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lc5:
            r12 = move-exception
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r11.$onDragCancel
            r0.invoke()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
