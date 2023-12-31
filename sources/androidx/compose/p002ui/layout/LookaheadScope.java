package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.node.LayoutNode;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadScope.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m40d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "disposableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "withDisposableSnapshot", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.LookaheadScope */
/* loaded from: classes.dex */
public final class LookaheadScope {
    private MutableSnapshot disposableSnapshot;
    private final LayoutNode root;

    public LookaheadScope(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    public final <T> T withDisposableSnapshot(Functions<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!(this.disposableSnapshot == null)) {
            throw new IllegalStateException("Disposable snapshot is already active".toString());
        }
        MutableSnapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);
        this.disposableSnapshot = takeMutableSnapshot$default;
        try {
            MutableSnapshot mutableSnapshot = takeMutableSnapshot$default;
            Snapshot makeCurrent = mutableSnapshot.makeCurrent();
            T invoke = block.invoke();
            mutableSnapshot.restoreCurrent(makeCurrent);
            return invoke;
        } finally {
            takeMutableSnapshot$default.dispose();
            this.disposableSnapshot = null;
        }
    }
}
