package androidx.compose.foundation.interaction;

import androidx.appcompat.C0032R;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.runtime.SnapshotState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DragInteraction.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.interaction.DragInteractionKt$collectIsDraggedAsState$1$1", m30f = "DragInteraction.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_listPreferredItemPaddingRight}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes.dex */
final class DragInteractionKt$collectIsDraggedAsState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotState<Boolean> $isDragged;
    final /* synthetic */ InteractionSource $this_collectIsDraggedAsState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragInteractionKt$collectIsDraggedAsState$1$1(InteractionSource interactionSource, SnapshotState<Boolean> snapshotState, Continuation<? super DragInteractionKt$collectIsDraggedAsState$1$1> continuation) {
        super(2, continuation);
        this.$this_collectIsDraggedAsState = interactionSource;
        this.$isDragged = snapshotState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DragInteractionKt$collectIsDraggedAsState$1$1(this.$this_collectIsDraggedAsState, this.$isDragged, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DragInteractionKt$collectIsDraggedAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ArrayList arrayList = new ArrayList();
            Flow<Interaction> interactions = this.$this_collectIsDraggedAsState.getInteractions();
            final SnapshotState<Boolean> snapshotState = this.$isDragged;
            this.label = 1;
            if (interactions.collect(new FlowCollector<Interaction>() { // from class: androidx.compose.foundation.interaction.DragInteractionKt$collectIsDraggedAsState$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Interaction interaction, Continuation continuation) {
                    return emit2(interaction, (Continuation<? super Unit>) continuation);
                }

                /* renamed from: emit  reason: avoid collision after fix types in other method */
                public final Object emit2(Interaction interaction, Continuation<? super Unit> continuation) {
                    if (interaction instanceof DragInteraction.Start) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof DragInteraction.Stop) {
                        arrayList.remove(((DragInteraction.Stop) interaction).getStart());
                    } else if (interaction instanceof DragInteraction.Cancel) {
                        arrayList.remove(((DragInteraction.Cancel) interaction).getStart());
                    }
                    snapshotState.setValue(boxing.boxBoolean(!arrayList.isEmpty()));
                    return Unit.INSTANCE;
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
