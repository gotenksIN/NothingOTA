package androidx.compose.p002ui;

import androidx.compose.p002ui.node.ModifierNodeElement;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.p002ui.platform.ValueElementSequence;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0000¨\u0006\n"}, m40d2 = {"areObjectsOfSameType", "", "a", "", "b", "tryPopulateReflectively", "", "Landroidx/compose/ui/platform/InspectorInfo;", "element", "Landroidx/compose/ui/node/ModifierNodeElement;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.ActualKt */
/* loaded from: classes.dex */
public final class Actual {
    public static final boolean areObjectsOfSameType(Object a, Object b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a.getClass() == b.getClass();
    }

    public static final void tryPopulateReflectively(InspectorInfo inspectorInfo, ModifierNodeElement<?> element) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Field[] declaredFields = element.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "element.javaClass.declaredFields");
        List sortedWith = ArraysKt.sortedWith(declaredFields, new Comparator() { // from class: androidx.compose.ui.ActualKt$tryPopulateReflectively$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Field) t).getName(), ((Field) t2).getName());
            }
        });
        int size = sortedWith.size();
        for (int i = 0; i < size; i++) {
            Field field = (Field) sortedWith.get(i);
            if (!field.getDeclaringClass().isAssignableFrom(ModifierNodeElement.class)) {
                try {
                    field.setAccessible(true);
                    ValueElementSequence properties = inspectorInfo.getProperties();
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "field.name");
                    properties.set(name, field.get(element));
                } catch (IllegalAccessException | SecurityException unused) {
                }
            }
        }
    }
}
