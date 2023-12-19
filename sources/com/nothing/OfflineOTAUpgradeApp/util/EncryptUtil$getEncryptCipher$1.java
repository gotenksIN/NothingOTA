package com.nothing.OfflineOTAUpgradeApp.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncryptUtil.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil", m30f = "EncryptUtil.kt", m29i = {0}, m28l = {34}, m27m = "getEncryptCipher", m26n = {"secretKey"}, m25s = {"L$0"})
/* loaded from: classes2.dex */
public final class EncryptUtil$getEncryptCipher$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EncryptUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptUtil$getEncryptCipher$1(EncryptUtil encryptUtil, Continuation<? super EncryptUtil$getEncryptCipher$1> continuation) {
        super(continuation);
        this.this$0 = encryptUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getEncryptCipher(null, null, this);
    }
}
