package androidx.compose.foundation;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.RectangleShape;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.platform.InspectableValueKt;
import androidx.compose.p002ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Background.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, m40d2 = {"background", "Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class BackgroundKt {
    /* renamed from: background-bw27NRU$default */
    public static /* synthetic */ Modifier m453backgroundbw27NRU$default(Modifier modifier, long j, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShape.getRectangleShape();
        }
        return m452backgroundbw27NRU(modifier, j, shape);
    }

    /* renamed from: background-bw27NRU */
    public static final Modifier m452backgroundbw27NRU(Modifier background, final long j, final Shape shape) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return background.then(new Background(Color.m2847boximpl(j), null, 0.0f, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("background");
                inspectorInfo.setValue(Color.m2847boximpl(j));
                inspectorInfo.getProperties().set("color", Color.m2847boximpl(j));
                inspectorInfo.getProperties().set("shape", shape);
            }
        } : InspectableValueKt.getNoInspectorInfo(), 6, null));
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, Brush brush, Shape shape, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShape.getRectangleShape();
        }
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        return background(modifier, brush, shape, f);
    }

    public static final Modifier background(Modifier modifier, final Brush brush, final Shape shape, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return modifier.then(new Background(null, brush, f, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.BackgroundKt$background$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("background");
                inspectorInfo.getProperties().set("alpha", Float.valueOf(f));
                inspectorInfo.getProperties().set("brush", brush);
                inspectorInfo.getProperties().set("shape", shape);
            }
        } : InspectableValueKt.getNoInspectorInfo(), 1, null));
    }
}
