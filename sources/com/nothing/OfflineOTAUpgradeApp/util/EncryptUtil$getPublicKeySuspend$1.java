package com.nothing.OfflineOTAUpgradeApp.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncryptUtil.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil", m30f = "EncryptUtil.kt", m29i = {}, m28l = {41}, m27m = "getPublicKeySuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class EncryptUtil$getPublicKeySuspend$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EncryptUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptUtil$getPublicKeySuspend$1(EncryptUtil encryptUtil, Continuation<? super EncryptUtil$getPublicKeySuspend$1> continuation) {
        super(continuation);
        this.this$0 = encryptUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object publicKeySuspend;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        publicKeySuspend = this.this$0.getPublicKeySuspend(null, this);
        return publicKeySuspend;
    }
}
