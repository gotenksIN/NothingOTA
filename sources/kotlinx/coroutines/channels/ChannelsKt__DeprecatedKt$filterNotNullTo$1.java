package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m39k = 3, m38mv = {1, 6, 0}, m36xi = 48)
@DebugMetadata(m31c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m30f = "Deprecated.kt", m29i = {0, 0}, m28l = {487}, m27m = "filterNotNullTo", m26n = {"destination", "$this$consume$iv$iv"}, m25s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class ChannelsKt__DeprecatedKt$filterNotNullTo$1<E, C extends Collection<? super E>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$filterNotNullTo$1(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNullTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object filterNotNullTo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        filterNotNullTo = Deprecated.filterNotNullTo((ReceiveChannel) null, (Collection) null, this);
        return filterNotNullTo;
    }
}
