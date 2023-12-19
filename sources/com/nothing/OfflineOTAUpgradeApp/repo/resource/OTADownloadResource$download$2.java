package com.nothing.OfflineOTAUpgradeApp.repo.resource;

import androidx.appcompat.C0032R;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import java.io.File;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTADownloadResource.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2", m30f = "OTADownloadResource.kt", m29i = {1}, m28l = {C0032R.styleable.AppCompatTheme_windowActionBarOverlay, 127, 131}, m27m = "invokeSuspend", m26n = {"file"}, m25s = {"L$0"})
/* loaded from: classes2.dex */
public final class OTADownloadResource$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $append;
    final /* synthetic */ RemoteOTAUpdateInfo $info;
    Object L$0;
    int label;
    final /* synthetic */ OTADownloadResource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTADownloadResource$download$2(OTADownloadResource oTADownloadResource, RemoteOTAUpdateInfo remoteOTAUpdateInfo, boolean z, Continuation<? super OTADownloadResource$download$2> continuation) {
        super(2, continuation);
        this.this$0 = oTADownloadResource;
        this.$info = remoteOTAUpdateInfo;
        this.$append = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OTADownloadResource$download$2(this.this$0, this.$info, this.$append, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OTADownloadResource$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bc A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L2d
            if (r2 == r6) goto L29
            if (r2 == r5) goto L21
            if (r2 != r4) goto L19
            kotlin.ResultKt.throwOnFailure(r17)
            goto Lbd
        L19:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L21:
            java.lang.Object r2 = r0.L$0
            java.io.File r2 = (java.io.File) r2
            kotlin.ResultKt.throwOnFailure(r17)
            goto L78
        L29:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L4f
        L2d:
            kotlin.ResultKt.throwOnFailure(r17)
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r2 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r2 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$get_downloadStateFlow$p(r2)
            com.nothing.OfflineOTAUpgradeApp.state.DownloadState$Downloading r7 = new com.nothing.OfflineOTAUpgradeApp.state.DownloadState$Downloading
            com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo r8 = r0.$info
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r9 = r0.this$0
            double r9 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getProgressPercentage(r9)
            r7.<init>(r8, r9)
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.label = r6
            java.lang.Object r2 = r2.emit(r7, r8)
            if (r2 != r1) goto L4f
            return r1
        L4f:
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r2 = r0.this$0
            com.nothing.OfflineOTAUpgradeApp.util.Utils r2 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getUtils$p(r2)
            java.io.File r2 = r2.getDownloadedOTAFile()
            boolean r7 = r0.$append
            if (r7 != 0) goto L78
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2$1 r8 = new com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2$1
            r8.<init>(r2, r3)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r5 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r9)
            if (r5 != r1) goto L78
            return r1
        L78:
            r10 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "bytes="
            r2.<init>(r5)
            long r7 = r10.length()
            java.lang.StringBuilder r2 = r2.append(r7)
            r5 = 45
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r11 = r2.toString()
            com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource r7 = r0.this$0
            com.nothing.OfflineOTAUpgradeApp.remote.RemoteServiceHost r2 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$getRemoteHost$p(r7)
            com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService r8 = r2.getDownloadService()
            com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo r2 = r0.$info
            java.lang.String r9 = r2.getUrl()
            long r12 = r10.length()
            r14 = 0
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 <= 0) goto Lad
            goto Lae
        Lad:
            r6 = 0
        Lae:
            r12 = r6
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r2 = com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource.access$downloadFile(r7, r8, r9, r10, r11, r12, r13)
            if (r2 != r1) goto Lbd
            return r1
        Lbd:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTADownloadResource.kt */
    @Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
    @DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2$1", m30f = "OTADownloadResource.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.repo.resource.OTADownloadResource$download$2$1 */
    /* loaded from: classes2.dex */
    public static final class C16491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ File $file;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16491(File file, Continuation<? super C16491> continuation) {
            super(2, continuation);
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16491(this.$file, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C16491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return boxing.boxBoolean(this.$file.delete());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
