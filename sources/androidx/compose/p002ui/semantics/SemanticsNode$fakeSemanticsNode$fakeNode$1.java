package androidx.compose.p002ui.semantics;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SemanticsNode.kt */
@Metadata(m41d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m40d2 = {"androidx/compose/ui/semantics/SemanticsNode$fakeSemanticsNode$fakeNode$1", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.semantics.SemanticsNode$fakeSemanticsNode$fakeNode$1 */
/* loaded from: classes.dex */
public final class SemanticsNode$fakeSemanticsNode$fakeNode$1 extends Modifier.Node implements SemanticsModifierNode {
    private final SemanticsConfiguration semanticsConfiguration;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SemanticsNode$fakeSemanticsNode$fakeNode$1(Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        function1.invoke(semanticsConfiguration);
        this.semanticsConfiguration = semanticsConfiguration;
    }

    @Override // androidx.compose.p002ui.node.SemanticsModifierNode
    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }
}
