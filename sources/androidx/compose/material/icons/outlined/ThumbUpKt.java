package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.StrokeJoin;
import androidx.compose.p002ui.graphics.vector.ImageVector;
import androidx.compose.p002ui.graphics.vector.PathBuilder;
import androidx.compose.p002ui.graphics.vector.VectorKt;
import androidx.compose.p002ui.unit.C0780Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThumbUp.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m40d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$Outlined;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class ThumbUpKt {
    private static ImageVector _thumbUp;

    public static final ImageVector getThumbUp(Icons.Outlined outlined) {
        ImageVector.Builder m3479addPathoIyEayM;
        Intrinsics.checkNotNullParameter(outlined, "<this>");
        ImageVector imageVector = _thumbUp;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.ThumbUp", C0780Dp.m5351constructorimpl(24.0f), C0780Dp.m5351constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m2883getBlack0d7_KjU(), null);
        int m3200getButtKaPHkGw = StrokeCap.Companion.m3200getButtKaPHkGw();
        int m3210getBevelLxFBmk8 = StrokeJoin.Companion.m3210getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(9.0f, 21.0f);
        pathBuilder.horizontalLineToRelative(9.0f);
        pathBuilder.curveToRelative(0.83f, 0.0f, 1.54f, -0.5f, 1.84f, -1.22f);
        pathBuilder.lineToRelative(3.02f, -7.05f);
        pathBuilder.curveToRelative(0.09f, -0.23f, 0.14f, -0.47f, 0.14f, -0.73f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder.horizontalLineToRelative(-6.31f);
        pathBuilder.lineToRelative(0.95f, -4.57f);
        pathBuilder.lineToRelative(0.03f, -0.32f);
        pathBuilder.curveToRelative(0.0f, -0.41f, -0.17f, -0.79f, -0.44f, -1.06f);
        pathBuilder.lineTo(14.17f, 1.0f);
        pathBuilder.lineTo(7.58f, 7.59f);
        pathBuilder.curveTo(7.22f, 7.95f, 7.0f, 8.45f, 7.0f, 9.0f);
        pathBuilder.verticalLineToRelative(10.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(9.0f, 9.0f);
        pathBuilder.lineToRelative(4.34f, -4.34f);
        pathBuilder.lineTo(12.0f, 10.0f);
        pathBuilder.horizontalLineToRelative(9.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.lineToRelative(-3.0f, 7.0f);
        pathBuilder.horizontalLineTo(9.0f);
        pathBuilder.verticalLineTo(9.0f);
        pathBuilder.close();
        pathBuilder.moveTo(1.0f, 9.0f);
        pathBuilder.horizontalLineToRelative(4.0f);
        pathBuilder.verticalLineToRelative(12.0f);
        pathBuilder.horizontalLineTo(1.0f);
        pathBuilder.close();
        m3479addPathoIyEayM = builder.m3479addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3200getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3210getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m3479addPathoIyEayM.build();
        _thumbUp = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
