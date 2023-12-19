package androidx.compose.p002ui.node;

import kotlin.Metadata;

/* compiled from: ObserverNode.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, m40d2 = {"Landroidx/compose/ui/node/ObserverNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onObservedReadsChanged", "", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.node.ObserverNode */
/* loaded from: classes.dex */
public interface ObserverNode extends DelegatableNode {
    void onObservedReadsChanged();
}
