package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1", f = "OTADownloadResource.kt", i = {}, l = {280, 286, 292, 294}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTADownloadResource$cancelDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OTADownloadResource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTADownloadResource$cancelDownload$1(OTADownloadResource oTADownloadResource, Continuation<? super OTADownloadResource$cancelDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = oTADownloadResource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTADownloadResource$cancelDownload$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTADownloadResource$cancelDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = "access$getTAG$cp(...)"
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L30
            if (r1 == r6) goto L2c
            if (r1 == r5) goto L28
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lb1
        L1b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L23:
            kotlin.ResultKt.throwOnFailure(r14)
            goto La2
        L28:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L82
        L2c:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L52
        L30:
            kotlin.ResultKt.throwOnFailure(r14)
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r7 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE
            java.lang.String r8 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getTAG$cp()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            java.lang.String r9 = "cancelDownload.launch+"
            r10 = 0
            r11 = 4
            r12 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r7, r8, r9, r10, r11, r12)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            r1 = r13
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r13.label = r6
            java.lang.Object r14 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$setIsProcessingSuspend(r14, r6, r1)
            if (r14 != r0) goto L52
            return r0
        L52:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            kotlinx.coroutines.flow.MutableStateFlow r14 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r14)
            java.lang.Object r14 = r14.getValue()
            com.nothing.OfflineOTAUpgradeApp.state.DownloadState r14 = (com.nothing.OfflineOTAUpgradeApp.state.DownloadState) r14
            boolean r1 = r14 instanceof com.nothing.OfflineOTAUpgradeApp.state.DownloadState.Downloading
            if (r1 != 0) goto L66
            boolean r14 = r14 instanceof com.nothing.OfflineOTAUpgradeApp.state.DownloadState.DownloadPause
            if (r14 == 0) goto L82
        L66:
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1$1 r1 = new com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1$1
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r6 = r13.this$0
            r7 = 0
            r1.<init>(r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = r13
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r13.label = r5
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r1, r6)
            if (r14 != r0) goto L82
            return r0
        L82:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            r5 = 0
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$set_maxProgress$p(r14, r5)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$set_progress$p(r14, r5)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            kotlinx.coroutines.flow.MutableStateFlow r14 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r14)
            com.nothing.OfflineOTAUpgradeApp.state.DownloadState$Idle r1 = com.nothing.OfflineOTAUpgradeApp.state.DownloadState.Idle.INSTANCE
            r5 = r13
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r13.label = r4
            java.lang.Object r14 = r14.emit(r1, r5)
            if (r14 != r0) goto La2
            return r0
        La2:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r14 = r13.this$0
            r1 = r13
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r13.label = r3
            r3 = 0
            java.lang.Object r14 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$setIsProcessingSuspend(r14, r3, r1)
            if (r14 != r0) goto Lb1
            return r0
        Lb1:
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r3 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE
            java.lang.String r4 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getTAG$cp()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.lang.String r5 = "cancelDownload.launch-"
            r6 = 0
            r7 = 4
            r8 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r3, r4, r5, r6, r7, r8)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTADownloadResource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1$1", f = "OTADownloadResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$cancelDownload$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ OTADownloadResource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OTADownloadResource oTADownloadResource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = oTADownloadResource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            File oTAFile;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                oTAFile = this.this$0.getOTAFile();
                return Boxing.boxBoolean(oTAFile.delete());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
