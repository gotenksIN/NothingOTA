package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.RectangleShape;
import androidx.compose.p002ui.graphics.RenderEffectKt;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.TileMode;
import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, m40d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.draw.BlurKt */
/* loaded from: classes.dex */
public final class Blur {
    /* renamed from: blur-1fqS-gw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2516blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2519boximpl(BlurredEdgeTreatment.Companion.m2526getRectangleGoahg());
        }
        return m2515blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m2525unboximpl());
    }

    /* renamed from: blur-1fqS-gw  reason: not valid java name */
    public static final Modifier m2515blur1fqSgw(Modifier blur, final float f, final float f2, final Shape shape) {
        final boolean z;
        final int m3221getDecal3opZhB0;
        Intrinsics.checkNotNullParameter(blur, "$this$blur");
        if (shape != null) {
            m3221getDecal3opZhB0 = TileMode.Companion.m3220getClamp3opZhB0();
            z = true;
        } else {
            z = false;
            m3221getDecal3opZhB0 = TileMode.Companion.m3221getDecal3opZhB0();
        }
        float f3 = 0;
        return ((C0780Dp.m5350compareTo0680j_4(f, C0780Dp.m5351constructorimpl(f3)) <= 0 || C0780Dp.m5350compareTo0680j_4(f2, C0780Dp.m5351constructorimpl(f3)) <= 0) && !z) ? blur : GraphicsLayerModifierKt.graphicsLayer(blur, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
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
                float f4 = graphicsLayer.mo603toPx0680j_4(f);
                float f5 = graphicsLayer.mo603toPx0680j_4(f2);
                graphicsLayer.setRenderEffect((f4 <= 0.0f || f5 <= 0.0f) ? null : RenderEffectKt.m3155BlurEffect3YTHUZs(f4, f5, m3221getDecal3opZhB0));
                Shape shape2 = shape;
                if (shape2 == null) {
                    shape2 = RectangleShape.getRectangleShape();
                }
                graphicsLayer.setShape(shape2);
                graphicsLayer.setClip(z);
            }
        });
    }

    /* renamed from: blur-F8QBwvs$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2518blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2519boximpl(BlurredEdgeTreatment.Companion.m2526getRectangleGoahg());
        }
        return m2517blurF8QBwvs(modifier, f, blurredEdgeTreatment.m2525unboximpl());
    }

    /* renamed from: blur-F8QBwvs  reason: not valid java name */
    public static final Modifier m2517blurF8QBwvs(Modifier blur, float f, Shape shape) {
        Intrinsics.checkNotNullParameter(blur, "$this$blur");
        return m2515blur1fqSgw(blur, f, f, shape);
    }
}
