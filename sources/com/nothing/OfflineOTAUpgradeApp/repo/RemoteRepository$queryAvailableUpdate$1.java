package com.nothing.OfflineOTAUpgradeApp.repo;

import androidx.appcompat.C0032R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteRepository.kt */
@Metadata(m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository", m30f = "RemoteRepository.kt", m29i = {0, 0, 1, 1, 2}, m28l = {C0032R.styleable.AppCompatTheme_colorControlActivated, C0032R.styleable.AppCompatTheme_colorSwitchThumbNormal, C0032R.styleable.AppCompatTheme_listPreferredItemPaddingRight}, m27m = "queryAvailableUpdate", m26n = {"this", "startTime", "this", "startTime", "fetchResult"}, m25s = {"L$0", "J$0", "L$0", "J$0", "L$0"})
/* loaded from: classes2.dex */
public final class RemoteRepository$queryAvailableUpdate$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteRepository$queryAvailableUpdate$1(RemoteRepository remoteRepository, Continuation<? super RemoteRepository$queryAvailableUpdate$1> continuation) {
        super(continuation);
        this.this$0 = remoteRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queryAvailableUpdate(this);
    }
}
