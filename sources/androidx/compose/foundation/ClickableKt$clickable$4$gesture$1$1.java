package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetector;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntSizeKt;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clickable.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1", m30f = "Clickable.kt", m29i = {}, m28l = {156}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes.dex */
public final class ClickableKt$clickable$4$gesture$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotState<Offset> $centreOffset;
    final /* synthetic */ State<Functions<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Functions<Unit>> $onClickState;
    final /* synthetic */ SnapshotState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClickableKt$clickable$4$gesture$1$1(SnapshotState<Offset> snapshotState, boolean z, MutableInteractionSource mutableInteractionSource, SnapshotState<PressInteraction.Press> snapshotState2, State<? extends Functions<Boolean>> state, State<? extends Functions<Unit>> state2, Continuation<? super ClickableKt$clickable$4$gesture$1$1> continuation) {
        super(2, continuation);
        this.$centreOffset = snapshotState;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = snapshotState2;
        this.$delayPressInteraction = state;
        this.$onClickState = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$clickable$4$gesture$1$1 clickableKt$clickable$4$gesture$1$1 = new ClickableKt$clickable$4$gesture$1$1(this.$centreOffset, this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, continuation);
        clickableKt$clickable$4$gesture$1$1.L$0 = obj;
        return clickableKt$clickable$4$gesture$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$clickable$4$gesture$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Clickable.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    @DebugMetadata(m31c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1", m30f = "Clickable.kt", m29i = {}, m28l = {159}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1 */
    /* loaded from: classes.dex */
    public static final class C01701 extends SuspendLambda implements Function3<TapGestureDetector, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Functions<Boolean>> $delayPressInteraction;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ SnapshotState<PressInteraction.Press> $pressedInteraction;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01701(boolean z, MutableInteractionSource mutableInteractionSource, SnapshotState<PressInteraction.Press> snapshotState, State<? extends Functions<Boolean>> state, Continuation<? super C01701> continuation) {
            super(3, continuation);
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$pressedInteraction = snapshotState;
            this.$delayPressInteraction = state;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(TapGestureDetector tapGestureDetector, Offset offset, Continuation<? super Unit> continuation) {
            return m485invoked4ec7I(tapGestureDetector, offset.m2629unboximpl(), continuation);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m485invoked4ec7I(TapGestureDetector tapGestureDetector, long j, Continuation<? super Unit> continuation) {
            C01701 c01701 = new C01701(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, continuation);
            c01701.L$0 = tapGestureDetector;
            c01701.J$0 = j;
            return c01701.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapGestureDetector tapGestureDetector = (TapGestureDetector) this.L$0;
                long j = this.J$0;
                if (this.$enabled) {
                    this.label = 1;
                    if (Clickable.m484handlePressInteractionEPk0efs(tapGestureDetector, j, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            SnapshotState<Offset> snapshotState = this.$centreOffset;
            long m5517getCenterozmzZPI = IntSizeKt.m5517getCenterozmzZPI(pointerInputScope.m4294getSizeYbymL2g());
            snapshotState.setValue(Offset.m2608boximpl(OffsetKt.Offset(IntOffset.m5469getXimpl(m5517getCenterozmzZPI), IntOffset.m5470getYimpl(m5517getCenterozmzZPI))));
            final boolean z = this.$enabled;
            final State<Functions<Unit>> state = this.$onClickState;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new C01701(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m486invokek4lQ0M(offset.m2629unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m486invokek4lQ0M(long j) {
                    if (z) {
                        state.getValue().invoke();
                    }
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
