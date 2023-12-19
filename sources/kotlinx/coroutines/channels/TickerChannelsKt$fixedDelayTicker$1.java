package kotlinx.coroutines.channels;

import androidx.appcompat.C0032R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TickerChannels.kt */
@Metadata(m39k = 3, m38mv = {1, 6, 0}, m36xi = 48)
@DebugMetadata(m31c = "kotlinx.coroutines.channels.TickerChannelsKt", m30f = "TickerChannels.kt", m29i = {0, 0, 1, 1, 2, 2}, m28l = {C0032R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 108, 109}, m27m = "fixedDelayTicker", m26n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, m25s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes2.dex */
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fixedDelayTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedDelayTicker = TickerChannels.fixedDelayTicker(0L, 0L, null, this);
        return fixedDelayTicker;
    }
}
