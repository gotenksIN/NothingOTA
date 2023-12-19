package androidx.compose.p002ui.semantics;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: SemanticsProperties.kt */
@Metadata(m41d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0004H\u0016R*\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, m40d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", HintConstants.AUTOFILL_HINT_NAME, "", "mergePolicy", "Lkotlin/Function2;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "getName", "()Ljava/lang/String;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.semantics.SemanticsPropertyKey */
/* loaded from: classes.dex */
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 0;
    private final Function2<T, T, T> mergePolicy;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String name, Function2<? super T, ? super T, ? extends T> mergePolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mergePolicy, "mergePolicy");
        this.name = name;
        this.mergePolicy = mergePolicy;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, C07721 c07721, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function2<T, T, T>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Override // kotlin.jvm.functions.Function2
            public final T invoke(T t, T t2) {
                return t == null ? t2 : t;
            }
        } : c07721);
    }

    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    public final T merge(T t, T t2) {
        return this.mergePolicy.invoke(t, t2);
    }

    public final T getValue(SemanticsPropertyReceiver thisRef, KProperty<?> property) {
        Object throwSemanticsGetNotSupported;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        throwSemanticsGetNotSupported = SemanticsPropertiesKt.throwSemanticsGetNotSupported();
        return (T) throwSemanticsGetNotSupported;
    }

    public final void setValue(SemanticsPropertyReceiver thisRef, KProperty<?> property, T t) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        thisRef.set(this, t);
    }

    public String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }
}
