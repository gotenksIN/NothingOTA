package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.geometry.Size;
import kotlin.Metadata;

/* compiled from: ContentScale.kt */
@Metadata(m41d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006\u001a%\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m40d2 = {"computeFillHeight", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillHeight-iLBOSCw", "(JJ)F", "computeFillMaxDimension", "computeFillMaxDimension-iLBOSCw", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.ContentScaleKt */
/* loaded from: classes.dex */
public final class ContentScaleKt {
    /* renamed from: access$computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m4368access$computeFillHeightiLBOSCw(long j, long j2) {
        return m4372computeFillHeightiLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m4369access$computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return m4373computeFillMaxDimensioniLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m4370access$computeFillMinDimensioniLBOSCw(long j, long j2) {
        return m4374computeFillMinDimensioniLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m4371access$computeFillWidthiLBOSCw(long j, long j2) {
        return m4375computeFillWidthiLBOSCw(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final float m4373computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m4375computeFillWidthiLBOSCw(j, j2), m4372computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final float m4374computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m4375computeFillWidthiLBOSCw(j, j2), m4372computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final float m4375computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m2688getWidthimpl(j2) / Size.m2688getWidthimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final float m4372computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m2685getHeightimpl(j2) / Size.m2685getHeightimpl(j);
    }
}
