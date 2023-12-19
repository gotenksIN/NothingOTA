package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$pauseDownload$1", f = "OTADownloadResource.kt", i = {}, l = {251, InputDeviceCompat.SOURCE_KEYBOARD, 267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class OTADownloadResource$pauseDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $byNetworkIssue;
    int label;
    final /* synthetic */ OTADownloadResource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTADownloadResource$pauseDownload$1(OTADownloadResource oTADownloadResource, boolean z, Continuation<? super OTADownloadResource$pauseDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = oTADownloadResource;
        this.$byNetworkIssue = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTADownloadResource$pauseDownload$1(this.this$0, this.$byNetworkIssue, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTADownloadResource$pauseDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        r12 = r11.this$0._downloadingInfo;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[RETURN] */
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
            java.lang.String r2 = "access$getTAG$cp(...)"
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L28
            if (r1 == r5) goto L24
            if (r1 == r4) goto L20
            if (r1 != r3) goto L18
            kotlin.ResultKt.throwOnFailure(r12)
            goto La2
        L18:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L20:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L93
        L24:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L39
        L28:
            kotlin.ResultKt.throwOnFailure(r12)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r12 = r11.this$0
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r5
            java.lang.Object r12 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$setIsProcessingSuspend(r12, r5, r1)
            if (r12 != r0) goto L39
            return r0
        L39:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r12 = r11.this$0
            kotlinx.coroutines.flow.MutableStateFlow r12 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r12)
            java.lang.Object r12 = r12.getValue()
            com.nothing.OfflineOTAUpgradeApp.state.DownloadState r12 = (com.nothing.OfflineOTAUpgradeApp.state.DownloadState) r12
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r5 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE
            java.lang.String r6 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getTAG$cp()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r7 = "pauseDownload.launch+, currentState: "
            r1.<init>(r7)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r7 = r11.this$0
            kotlinx.coroutines.flow.MutableStateFlow r7 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r7)
            java.lang.Object r7 = r7.getValue()
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r7 = r1.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r5, r6, r7, r8, r9, r10)
            boolean r12 = r12 instanceof com.nothing.OfflineOTAUpgradeApp.state.DownloadState.DownloadPause
            if (r12 != 0) goto L93
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r12 = r11.this$0
            com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo r12 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadingInfo$p(r12)
            if (r12 == 0) goto L93
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r1 = r11.this$0
            boolean r5 = r11.$byNetworkIssue
            kotlinx.coroutines.flow.MutableStateFlow r6 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r1)
            com.nothing.OfflineOTAUpgradeApp.state.DownloadState$DownloadPause r7 = new com.nothing.OfflineOTAUpgradeApp.state.DownloadState$DownloadPause
            double r8 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getProgressPercentage(r1)
            r7.<init>(r12, r8, r5)
            r11.label = r4
            java.lang.Object r12 = r6.emit(r7, r11)
            if (r12 != r0) goto L93
            return r0
        L93:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r12 = r11.this$0
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r3
            r3 = 0
            java.lang.Object r12 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$setIsProcessingSuspend(r12, r3, r1)
            if (r12 != r0) goto La2
            return r0
        La2:
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil r3 = com.nothing.OfflineOTAUpgradeApp.util.LogUtil.INSTANCE
            java.lang.String r4 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getTAG$cp()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.lang.String r5 = "pauseDownload.launch-"
            r6 = 0
            r7 = 4
            r8 = 0
            com.nothing.OfflineOTAUpgradeApp.util.LogUtil.d$default(r3, r4, r5, r6, r7, r8)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$pauseDownload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
