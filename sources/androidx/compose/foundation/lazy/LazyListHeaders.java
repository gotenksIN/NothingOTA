package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, m40d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.lazy.LazyListHeadersKt */
/* loaded from: classes.dex */
public final class LazyListHeaders {
    public static final LazyListPositionedItem findOrComposeLazyListHeader(List<LazyListPositionedItem> composedVisibleItems, LazyMeasuredItemProvider itemProvider, List<Integer> headerIndexes, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(composedVisibleItems, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        int index = ((LazyListPositionedItem) CollectionsKt.first((List<? extends Object>) composedVisibleItems)).getIndex();
        int size = headerIndexes.size();
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i6 < size && headerIndexes.get(i6).intValue() <= index) {
            i4 = headerIndexes.get(i6).intValue();
            i6++;
            i5 = ((i6 < 0 || i6 > CollectionsKt.getLastIndex(headerIndexes)) ? -1 : headerIndexes.get(i6)).intValue();
        }
        int size2 = composedVisibleItems.size();
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MIN_VALUE;
        int i9 = -1;
        for (int i10 = 0; i10 < size2; i10++) {
            LazyListPositionedItem lazyListPositionedItem = composedVisibleItems.get(i10);
            if (lazyListPositionedItem.getIndex() == i4) {
                i7 = lazyListPositionedItem.getOffset();
                i9 = i10;
            } else if (lazyListPositionedItem.getIndex() == i5) {
                i8 = lazyListPositionedItem.getOffset();
            }
        }
        if (i4 == -1) {
            return null;
        }
        LazyMeasuredItem m837getAndMeasureZjPyQlc = itemProvider.m837getAndMeasureZjPyQlc(DataIndex.m805constructorimpl(i4));
        int max = i7 != Integer.MIN_VALUE ? Math.max(-i, i7) : -i;
        if (i8 != Integer.MIN_VALUE) {
            max = Math.min(max, i8 - m837getAndMeasureZjPyQlc.getSize());
        }
        LazyListPositionedItem position = m837getAndMeasureZjPyQlc.position(max, i2, i3);
        if (i9 != -1) {
            composedVisibleItems.set(i9, position);
        } else {
            composedVisibleItems.add(0, position);
        }
        return position;
    }
}
