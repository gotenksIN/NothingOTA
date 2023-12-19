package androidx.compose.p002ui.input.nestedscroll;

import androidx.appcompat.C0032R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NestedScrollModifierLocal.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal", m30f = "NestedScrollModifierLocal.kt", m29i = {0, 0, 1}, m28l = {C0032R.styleable.AppCompatTheme_panelMenuListWidth, C0032R.styleable.AppCompatTheme_popupMenuStyle}, m27m = "onPreFling-QWom1Mo", m26n = {"this", "available", "parentPreConsumed"}, m25s = {"L$0", "J$0", "J$0"})
/* renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1 */
/* loaded from: classes.dex */
public final class NestedScrollModifierLocal$onPreFling$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedScrollModifierLocal this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollModifierLocal$onPreFling$1(NestedScrollModifierLocal nestedScrollModifierLocal, Continuation<? super NestedScrollModifierLocal$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = nestedScrollModifierLocal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo780onPreFlingQWom1Mo(0L, this);
    }
}
