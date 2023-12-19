package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVectors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(m41d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004R\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m40d2 = {"Landroidx/compose/animation/core/TwoWayConverter;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "convertFromVector", "Lkotlin/Function1;", "getConvertFromVector", "()Lkotlin/jvm/functions/Function1;", "convertToVector", "getConvertToVector", "animation-core_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.animation.core.TwoWayConverter */
/* loaded from: classes.dex */
public interface VectorConverters<T, V extends AnimationVectors> {
    Function1<V, T> getConvertFromVector();

    Function1<T, V> getConvertToVector();
}
