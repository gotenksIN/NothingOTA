package androidx.compose.p002ui.node;

import kotlin.Metadata;

/* compiled from: MyersDiff.kt */
@Metadata(m41d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/node/DiffCallback;", "", "areItemsTheSame", "", "oldIndex", "", "newIndex", "insert", "", "atIndex", "remove", "same", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.node.DiffCallback */
/* loaded from: classes.dex */
public interface DiffCallback {
    boolean areItemsTheSame(int i, int i2);

    void insert(int i, int i2);

    void remove(int i);

    void same(int i, int i2);
}
