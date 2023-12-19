package com.nothing.OfflineOTAUpgradeApp.p007ui.compose;

import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DotLiner.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.ui.compose.DotLinerKt$DotLiner$1$1", m30f = "DotLiner.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.DotLinerKt$DotLiner$1$1 */
/* loaded from: classes2.dex */
public final class DotLinerKt$DotLiner$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $pendingDot$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotLinerKt$DotLiner$1$1(MutableIntState mutableIntState, Continuation<? super DotLinerKt$DotLiner$1$1> continuation) {
        super(2, continuation);
        this.$pendingDot$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DotLinerKt$DotLiner$1$1 dotLinerKt$DotLiner$1$1 = new DotLinerKt$DotLiner$1$1(this.$pendingDot$delegate, continuation);
        dotLinerKt$DotLiner$1$1.L$0 = obj;
        return dotLinerKt$DotLiner$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DotLinerKt$DotLiner$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DotLiner.kt */
    @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
    @DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.ui.compose.DotLinerKt$DotLiner$1$1$1", m30f = "DotLiner.kt", m29i = {0}, m28l = {41}, m27m = "invokeSuspend", m26n = {"$this$launch"}, m25s = {"L$0"})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.compose.DotLinerKt$DotLiner$1$1$1 */
    /* loaded from: classes2.dex */
    public static final class C16701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableIntState $pendingDot$delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16701(MutableIntState mutableIntState, Continuation<? super C16701> continuation) {
            super(2, continuation);
            this.$pendingDot$delegate = mutableIntState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16701 c16701 = new C16701(this.$pendingDot$delegate, continuation);
            c16701.L$0 = obj;
            return c16701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0038 -> B:14:0x003b). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r6
                goto L3b
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                r1 = r7
                r7 = r6
            L25:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r3 == 0) goto L4a
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.L$0 = r1
                r7.label = r2
                r4 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
                if (r3 != r0) goto L3b
                return r0
            L3b:
                androidx.compose.runtime.MutableIntState r3 = r7.$pendingDot$delegate
                int r4 = com.nothing.OfflineOTAUpgradeApp.p007ui.compose.DotLiner.access$DotLiner$lambda$1(r3)
                if (r4 != 0) goto L45
                r4 = r2
                goto L46
            L45:
                r4 = 0
            L46:
                com.nothing.OfflineOTAUpgradeApp.p007ui.compose.DotLiner.access$DotLiner$lambda$2(r3, r4)
                goto L25
            L4a:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.p007ui.compose.DotLinerKt$DotLiner$1$1.C16701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C16701(this.$pendingDot$delegate, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
