package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyDsl.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m40d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 176)
/* loaded from: classes.dex */
public final class LazyDslKt$items$7 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Function1<T, Object> $contentType;
    final /* synthetic */ T[] $items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyDslKt$items$7(Function1<? super T, ? extends Object> function1, T[] tArr) {
        super(1);
        this.$contentType = function1;
        this.$items = tArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int i) {
        return this.$contentType.invoke(this.$items[i]);
    }
}
