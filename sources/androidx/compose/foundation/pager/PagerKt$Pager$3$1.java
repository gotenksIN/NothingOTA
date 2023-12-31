package androidx.compose.foundation.pager;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Pager.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.foundation.pager.PagerKt$Pager$3$1", m30f = "Pager.kt", m29i = {}, m28l = {287}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes.dex */
final class PagerKt$Pager$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerKt$Pager$3$1(PagerState pagerState, Continuation<? super PagerKt$Pager$3$1> continuation) {
        super(2, continuation);
        this.$state = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerKt$Pager$3$1(this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagerKt$Pager$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PagerState pagerState = this.$state;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Functions<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$Pager$3$1.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Functions
                public final Boolean invoke() {
                    return Boolean.valueOf(PagerState.this.isScrollInProgress());
                }
            });
            Flow drop = FlowKt.drop(new Flow<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new C03702(flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m40d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                /* renamed from: androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2 */
                /* loaded from: classes.dex */
                public static final class C03702<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                    @DebugMetadata(m31c = "androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2", m30f = "Pager.kt", m29i = {}, m28l = {223}, m27m = "emit", m26n = {}, m25s = {})
                    /* renamed from: androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1 */
                    /* loaded from: classes.dex */
                    public static final class C03711 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public C03711(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return C03702.this.emit(null, this);
                        }
                    }

                    public C03702(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.C03702.C03711
                            if (r0 == 0) goto L14
                            r0 = r6
                            androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.C03702.C03711) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 - r2
                            r0.label = r6
                            goto L19
                        L14:
                            androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L19:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L4d
                        L2a:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L32:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            r2 = r5
                            java.lang.Boolean r2 = (java.lang.Boolean) r2
                            boolean r2 = r2.booleanValue()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L4d
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L4d
                            return r1
                        L4d:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1.C03702.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }, 1);
            final PagerState pagerState2 = this.$state;
            this.label = 1;
            if (drop.collect(new FlowCollector<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$Pager$3$1.3
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Boolean bool, Continuation continuation) {
                    return emit(bool.booleanValue(), continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    PagerState.this.updateOnScrollStopped$foundation_release();
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
