package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(m41d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m40d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Landroidx/lifecycle/LiveData;", "asLiveData", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "timeoutInMs", "", "lifecycle-livedata-ktx_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.lifecycle.FlowLiveDataConversions */
/* loaded from: classes.dex */
public final class FlowLiveData {
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, long j) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        LiveData<T> liveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j, new FlowLiveDataConversions$asLiveData$1(flow, null));
        if (flow instanceof StateFlow) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                liveData.setValue(((StateFlow) flow).getValue());
            } else {
                liveData.postValue(((StateFlow) flow).getValue());
            }
        }
        return liveData;
    }

    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, Duration timeout) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        return asLiveData(flow, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
