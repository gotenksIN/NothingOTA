package com.nothing.OfflineOTAUpgradeApp.util;

import androidx.appcompat.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncryptUtil.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil", f = "EncryptUtil.kt", i = {}, l = {R.styleable.AppCompatTheme_colorSwitchThumbNormal}, m = "encryptData", n = {}, s = {})
/* loaded from: classes2.dex */
public final class EncryptUtil$encryptData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EncryptUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptUtil$encryptData$1(EncryptUtil encryptUtil, Continuation<? super EncryptUtil$encryptData$1> continuation) {
        super(continuation);
        this.this$0 = encryptUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.encryptData(null, null, this);
    }
}
