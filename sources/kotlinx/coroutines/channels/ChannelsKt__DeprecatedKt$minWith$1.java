package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m39k = 3, m38mv = {1, 6, 0}, m36xi = 48)
@DebugMetadata(m31c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m30f = "Deprecated.kt", m29i = {0, 0, 0, 1, 1, 1, 1}, m28l = {434, 436}, m27m = "minWith", m26n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, m25s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object minWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        minWith = Deprecated.minWith(null, null, this);
        return minWith;
    }
}
