package androidx.compose.material.icons.rounded;

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

/* compiled from: LocationOn.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m40d2 = {"_locationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocationOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class LocationOnKt {
    private static ImageVector _locationOn;

    public static final ImageVector getLocationOn(Icons.Rounded rounded) {
        ImageVector.Builder m3479addPathoIyEayM;
        Intrinsics.checkNotNullParameter(rounded, "<this>");
        ImageVector imageVector = _locationOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.LocationOn", C0780Dp.m5351constructorimpl(24.0f), C0780Dp.m5351constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m2883getBlack0d7_KjU(), null);
        int m3200getButtKaPHkGw = StrokeCap.Companion.m3200getButtKaPHkGw();
        int m3210getBevelLxFBmk8 = StrokeJoin.Companion.m3210getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveToRelative(-4.2f, 0.0f, -8.0f, 3.22f, -8.0f, 8.2f);
        pathBuilder.curveToRelative(0.0f, 3.18f, 2.45f, 6.92f, 7.34f, 11.23f);
        pathBuilder.curveToRelative(0.38f, 0.33f, 0.95f, 0.33f, 1.33f, 0.0f);
        pathBuilder.curveTo(17.55f, 17.12f, 20.0f, 13.38f, 20.0f, 10.2f);
        pathBuilder.curveTo(20.0f, 5.22f, 16.2f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 12.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        pathBuilder.curveToRelative(0.0f, -1.1f, 0.9f, -2.0f, 2.0f, -2.0f);
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder.curveTo(14.0f, 11.1f, 13.1f, 12.0f, 12.0f, 12.0f);
        pathBuilder.close();
        m3479addPathoIyEayM = builder.m3479addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3200getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3210getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m3479addPathoIyEayM.build();
        _locationOn = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
