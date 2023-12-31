package androidx.compose.foundation.relocation;

import androidx.compose.p002ui.modifier.ModifierLocalKt;
import androidx.compose.p002ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;

/* compiled from: BringIntoView.kt */
@Metadata(m41d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\"\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m40d2 = {"ModifierLocalBringIntoViewParent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "getModifierLocalBringIntoViewParent$annotations", "()V", "getModifierLocalBringIntoViewParent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewKt {
    private static final ProvidableModifierLocal<BringIntoViewParent> ModifierLocalBringIntoViewParent = ModifierLocalKt.modifierLocalOf(new Functions<BringIntoViewParent>() { // from class: androidx.compose.foundation.relocation.BringIntoViewKt$ModifierLocalBringIntoViewParent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Functions
        public final BringIntoViewParent invoke() {
            return null;
        }
    });

    public static /* synthetic */ void getModifierLocalBringIntoViewParent$annotations() {
    }

    public static final ProvidableModifierLocal<BringIntoViewParent> getModifierLocalBringIntoViewParent() {
        return ModifierLocalBringIntoViewParent;
    }
}
