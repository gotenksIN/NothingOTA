package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.painter.Painter;
import androidx.compose.p002ui.layout.ContentScale;
import androidx.compose.p002ui.node.DrawModifierNodeKt;
import androidx.compose.p002ui.node.LayoutModifierNodeKt;
import androidx.compose.p002ui.node.ModifierNodeElement;
import androidx.compose.p002ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PainterModifier.kt */
@Metadata(m41d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\b\u0010%\u001a\u00020\u0002H\u0016J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0016J\f\u0010/\u001a\u000200*\u000201H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u00062"}, m40d2 = {"Landroidx/compose/ui/draw/PainterModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "autoInvalidate", "getAutoInvalidate", "()Z", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.draw.PainterModifierNodeElement */
/* loaded from: classes.dex */
final class PainterModifierNodeElement extends ModifierNodeElement<PainterModifierNode> {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public static /* synthetic */ PainterModifierNodeElement copy$default(PainterModifierNodeElement painterModifierNodeElement, Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = painterModifierNodeElement.painter;
        }
        if ((i & 2) != 0) {
            z = painterModifierNodeElement.sizeToIntrinsics;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            alignment = painterModifierNodeElement.alignment;
        }
        Alignment alignment2 = alignment;
        if ((i & 8) != 0) {
            contentScale = painterModifierNodeElement.contentScale;
        }
        ContentScale contentScale2 = contentScale;
        if ((i & 16) != 0) {
            f = painterModifierNodeElement.alpha;
        }
        float f2 = f;
        if ((i & 32) != 0) {
            colorFilter = painterModifierNodeElement.colorFilter;
        }
        return painterModifierNodeElement.copy(painter, z2, alignment2, contentScale2, f2, colorFilter);
    }

    public final Painter component1() {
        return this.painter;
    }

    public final boolean component2() {
        return this.sizeToIntrinsics;
    }

    public final Alignment component3() {
        return this.alignment;
    }

    public final ContentScale component4() {
        return this.contentScale;
    }

    public final float component5() {
        return this.alpha;
    }

    public final ColorFilter component6() {
        return this.colorFilter;
    }

    public final PainterModifierNodeElement copy(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        return new PainterModifierNodeElement(painter, z, alignment, contentScale, f, colorFilter);
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PainterModifierNodeElement) {
            PainterModifierNodeElement painterModifierNodeElement = (PainterModifierNodeElement) obj;
            return Intrinsics.areEqual(this.painter, painterModifierNodeElement.painter) && this.sizeToIntrinsics == painterModifierNodeElement.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterModifierNodeElement.alignment) && Intrinsics.areEqual(this.contentScale, painterModifierNodeElement.contentScale) && Float.compare(this.alpha, painterModifierNodeElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, painterModifierNodeElement.colorFilter);
        }
        return false;
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public boolean getAutoInvalidate() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = this.painter.hashCode() * 31;
        boolean z = this.sizeToIntrinsics;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((((((hashCode + i) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return hashCode2 + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    public String toString() {
        return "PainterModifierNodeElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public PainterModifierNodeElement(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public PainterModifierNode create() {
        return new PainterModifierNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public PainterModifierNode update(PainterModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        boolean sizeToIntrinsics = node.getSizeToIntrinsics();
        boolean z = this.sizeToIntrinsics;
        boolean z2 = sizeToIntrinsics != z || (z && !Size.m2684equalsimpl0(node.getPainter().mo3466getIntrinsicSizeNHjbRc(), this.painter.mo3466getIntrinsicSizeNHjbRc()));
        node.setPainter(this.painter);
        node.setSizeToIntrinsics(this.sizeToIntrinsics);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        if (z2) {
            LayoutModifierNodeKt.invalidateMeasurements(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
        return node;
    }

    @Override // androidx.compose.p002ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("paint");
        inspectorInfo.getProperties().set("painter", this.painter);
        inspectorInfo.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.sizeToIntrinsics));
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }
}
