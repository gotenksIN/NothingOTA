package kotlin.collections;

import androidx.appcompat.C0032R;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m41d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, m40d2 = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, m39k = 5, m38mv = {1, 9, 0}, m36xi = C0032R.styleable.AppCompatTheme_checkedTextViewStyle, m35xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.CollectionsKt__IteratorsJVMKt */
/* loaded from: classes2.dex */
public class IteratorsJVM extends CollectionsKt__IterablesKt {
    public static final <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new CollectionsKt__IteratorsJVMKt$iterator$1(enumeration);
    }
}
