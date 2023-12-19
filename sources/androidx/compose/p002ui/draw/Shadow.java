package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p002ui.graphics.RectangleShape;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.platform.InspectableValueKt;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m40d2 = {"shadow", "Landroidx/compose/ui/Modifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.draw.ShadowKt */
/* loaded from: classes.dex */
public final class Shadow {
    /* renamed from: shadow-ziNgDLE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2538shadowziNgDLE$default(Modifier modifier, float f, Shape shape, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShape.getRectangleShape();
        }
        if ((i & 4) != 0) {
            z = false;
            if (C0780Dp.m5350compareTo0680j_4(f, C0780Dp.m5351constructorimpl(0)) > 0) {
                z = true;
            }
        }
        return m2537shadowziNgDLE(modifier, f, shape, z);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with shadow which accepts ambientColor and spotColor parameters", replaceWith = @ReplaceWith(expression = "Modifier.shadow(elevation, shape, clip, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.draw"}))
    /* renamed from: shadow-ziNgDLE  reason: not valid java name */
    public static final /* synthetic */ Modifier m2537shadowziNgDLE(Modifier shadow, float f, Shape shape, boolean z) {
        Intrinsics.checkNotNullParameter(shadow, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m2535shadows4CzXII(shadow, f, shape, z, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: shadow-s4CzXII$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2536shadows4CzXII$default(Modifier modifier, float f, Shape shape, boolean z, long j, long j2, int i, Object obj) {
        boolean z2;
        Shape rectangleShape = (i & 2) != 0 ? RectangleShape.getRectangleShape() : shape;
        if ((i & 4) != 0) {
            z2 = false;
            if (C0780Dp.m5350compareTo0680j_4(f, C0780Dp.m5351constructorimpl(0)) > 0) {
                z2 = true;
            }
        } else {
            z2 = z;
        }
        return m2535shadows4CzXII(modifier, f, rectangleShape, z2, (i & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j, (i & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j2);
    }

    /* renamed from: shadow-s4CzXII  reason: not valid java name */
    public static final Modifier m2535shadows4CzXII(Modifier shadow, final float f, final Shape shape, final boolean z, final long j, final long j2) {
        Intrinsics.checkNotNullParameter(shadow, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (C0780Dp.m5350compareTo0680j_4(f, C0780Dp.m5351constructorimpl(0)) > 0 || z) {
            return InspectableValueKt.inspectableWrapper(shadow, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                    inspectorInfo.setName("shadow");
                    inspectorInfo.getProperties().set("elevation", C0780Dp.m5349boximpl(f));
                    inspectorInfo.getProperties().set("shape", shape);
                    inspectorInfo.getProperties().set("clip", Boolean.valueOf(z));
                    inspectorInfo.getProperties().set("ambientColor", Color.m2847boximpl(j));
                    inspectorInfo.getProperties().set("spotColor", Color.m2847boximpl(j2));
                }
            } : InspectableValueKt.getNoInspectorInfo(), GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.ShadowKt$shadow$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayer) {
                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                    graphicsLayer.setShadowElevation(graphicsLayer.mo603toPx0680j_4(f));
                    graphicsLayer.setShape(shape);
                    graphicsLayer.setClip(z);
                    graphicsLayer.mo3042setAmbientShadowColor8_81llA(j);
                    graphicsLayer.mo3044setSpotShadowColor8_81llA(j2);
                }
            }));
        }
        return shadow;
    }
}
