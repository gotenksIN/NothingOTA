package androidx.compose.material.icons.twotone;

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

/* compiled from: Send.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m40d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSend", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class SendKt {
    private static ImageVector _send;

    public static final ImageVector getSend(Icons.TwoTone twoTone) {
        ImageVector.Builder m3479addPathoIyEayM;
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _send;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Send", C0780Dp.m5351constructorimpl(24.0f), C0780Dp.m5351constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m2883getBlack0d7_KjU(), null);
        int m3200getButtKaPHkGw = StrokeCap.Companion.m3200getButtKaPHkGw();
        int m3210getBevelLxFBmk8 = StrokeJoin.Companion.m3210getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(4.0f, 8.25f);
        pathBuilder.lineToRelative(7.51f, 1.0f);
        pathBuilder.lineToRelative(-7.5f, -3.22f);
        pathBuilder.close();
        pathBuilder.moveTo(4.01f, 17.97f);
        pathBuilder.lineToRelative(7.5f, -3.22f);
        pathBuilder.lineToRelative(-7.51f, 1.0f);
        pathBuilder.close();
        builder.m3479addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3200getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3210getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.Companion.m2883getBlack0d7_KjU(), null);
        int m3200getButtKaPHkGw2 = StrokeCap.Companion.m3200getButtKaPHkGw();
        int m3210getBevelLxFBmk82 = StrokeJoin.Companion.m3210getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(2.01f, 3.0f);
        pathBuilder2.lineTo(2.0f, 10.0f);
        pathBuilder2.lineToRelative(15.0f, 2.0f);
        pathBuilder2.lineToRelative(-15.0f, 2.0f);
        pathBuilder2.lineToRelative(0.01f, 7.0f);
        pathBuilder2.lineTo(23.0f, 12.0f);
        pathBuilder2.lineTo(2.01f, 3.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(4.0f, 8.25f);
        pathBuilder2.lineTo(4.0f, 6.03f);
        pathBuilder2.lineToRelative(7.51f, 3.22f);
        pathBuilder2.lineToRelative(-7.51f, -1.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(4.01f, 17.97f);
        pathBuilder2.verticalLineToRelative(-2.22f);
        pathBuilder2.lineToRelative(7.51f, -1.0f);
        pathBuilder2.lineToRelative(-7.51f, 3.22f);
        pathBuilder2.close();
        m3479addPathoIyEayM = builder.m3479addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m3200getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m3210getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m3479addPathoIyEayM.build();
        _send = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
