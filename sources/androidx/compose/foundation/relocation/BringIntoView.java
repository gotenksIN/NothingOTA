package androidx.compose.foundation.relocation;

import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.OnPlacedModifier;
import androidx.compose.p002ui.modifier.ModifierLocalConsumer;
import androidx.compose.p002ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078D@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m40d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewChildModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "defaultParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "(Landroidx/compose/foundation/relocation/BringIntoViewParent;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "localParent", "parent", "getParent", "()Landroidx/compose/foundation/relocation/BringIntoViewParent;", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPlaced", "coordinates", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.relocation.BringIntoViewChildModifier */
/* loaded from: classes.dex */
public abstract class BringIntoView implements ModifierLocalConsumer, OnPlacedModifier {
    private final BringIntoViewParent defaultParent;
    private LayoutCoordinates layoutCoordinates;
    private BringIntoViewParent localParent;

    public BringIntoView(BringIntoViewParent defaultParent) {
        Intrinsics.checkNotNullParameter(defaultParent, "defaultParent");
        this.defaultParent = defaultParent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BringIntoViewParent getParent() {
        BringIntoViewParent bringIntoViewParent = this.localParent;
        return bringIntoViewParent == null ? this.defaultParent : bringIntoViewParent;
    }

    @Override // androidx.compose.p002ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.localParent = (BringIntoViewParent) scope.getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    @Override // androidx.compose.p002ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
    }
}
