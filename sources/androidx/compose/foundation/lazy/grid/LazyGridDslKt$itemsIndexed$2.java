package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyGridDsl.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m40d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 176)
/* loaded from: classes.dex */
public final class LazyGridDslKt$itemsIndexed$2 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function2<Integer, T, Object> $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridDslKt$itemsIndexed$2(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
        super(1);
        this.$key = function2;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int i) {
        return this.$key.invoke(Integer.valueOf(i), this.$items.get(i));
    }
}
