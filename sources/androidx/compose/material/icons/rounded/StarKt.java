package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Star.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$Rounded;", "getStar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StarKt {
    private static ImageVector _star;

    public static final ImageVector getStar(Icons.Rounded rounded) {
        ImageVector.Builder m3178addPathoIyEayM;
        Intrinsics.checkNotNullParameter(rounded, "<this>");
        ImageVector imageVector = _star;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Star", Dp.m5050constructorimpl(24.0f), Dp.m5050constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m2582getBlack0d7_KjU(), null);
        int m2899getButtKaPHkGw = StrokeCap.Companion.m2899getButtKaPHkGw();
        int m2909getBevelLxFBmk8 = StrokeJoin.Companion.m2909getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 17.27f);
        pathBuilder.lineToRelative(4.15f, 2.51f);
        pathBuilder.curveToRelative(0.76f, 0.46f, 1.69f, -0.22f, 1.49f, -1.08f);
        pathBuilder.lineToRelative(-1.1f, -4.72f);
        pathBuilder.lineToRelative(3.67f, -3.18f);
        pathBuilder.curveToRelative(0.67f, -0.58f, 0.31f, -1.68f, -0.57f, -1.75f);
        pathBuilder.lineToRelative(-4.83f, -0.41f);
        pathBuilder.lineToRelative(-1.89f, -4.46f);
        pathBuilder.curveToRelative(-0.34f, -0.81f, -1.5f, -0.81f, -1.84f, 0.0f);
        pathBuilder.lineTo(9.19f, 8.63f);
        pathBuilder.lineTo(4.36f, 9.04f);
        pathBuilder.curveToRelative(-0.88f, 0.07f, -1.24f, 1.17f, -0.57f, 1.75f);
        pathBuilder.lineToRelative(3.67f, 3.18f);
        pathBuilder.lineToRelative(-1.1f, 4.72f);
        pathBuilder.curveToRelative(-0.2f, 0.86f, 0.73f, 1.54f, 1.49f, 1.08f);
        pathBuilder.lineTo(12.0f, 17.27f);
        pathBuilder.close();
        m3178addPathoIyEayM = builder.m3178addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m2899getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m2909getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m3178addPathoIyEayM.build();
        _star = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
