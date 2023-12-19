package com.nothing.OfflineOTAUpgradeApp.repo;

import androidx.appcompat.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository", f = "RemoteRepository.kt", i = {0, 0, 1, 1}, l = {R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_windowActionBarOverlay}, m = "generateQueryRequestBody", n = {"this", "aesSecret", "this", "data"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
public final class RemoteRepository$generateQueryRequestBody$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteRepository$generateQueryRequestBody$1(RemoteRepository remoteRepository, Continuation<? super RemoteRepository$generateQueryRequestBody$1> continuation) {
        super(continuation);
        this.this$0 = remoteRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object generateQueryRequestBody;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        generateQueryRequestBody = this.this$0.generateQueryRequestBody(this);
        return generateQueryRequestBody;
    }
}
