package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* compiled from: StateFlow.kt */
@Metadata(m41d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m40d2 = {"Lkotlinx/coroutines/flow/StateFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "value", "getValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m39k = 1, m38mv = {1, 6, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public interface StateFlow<T> extends SharedFlow<T> {
    T getValue();
}
