package androidx.compose.p002ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontFamilyResolver.kt */
@Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", m30f = "FontFamilyResolver.kt", m29i = {0, 0}, m28l = {45}, m27m = "preload", m26n = {"this", "fontFamily"}, m25s = {"L$0", "L$1"})
/* renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 */
/* loaded from: classes.dex */
public final class FontFamilyResolverImpl$preload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FontFamilyResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$preload$1(FontFamilyResolver fontFamilyResolver, Continuation<? super FontFamilyResolverImpl$preload$1> continuation) {
        super(continuation);
        this.this$0 = fontFamilyResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.preload(null, this);
    }
}
