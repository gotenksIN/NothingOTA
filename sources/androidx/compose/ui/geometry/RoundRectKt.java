package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a#\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a;\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001f\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    /* renamed from: RoundRect-gG7oq9Y  reason: not valid java name */
    public static final RoundRect m2372RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m2293getXimpl(j), CornerRadius.m2294getYimpl(j));
    }

    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* renamed from: RoundRect-sniSvfs  reason: not valid java name */
    public static final RoundRect m2373RoundRectsniSvfs(Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m2293getXimpl(j), CornerRadius.m2294getYimpl(j));
    }

    /* renamed from: RoundRect-ZAM2FJo  reason: not valid java name */
    public static final RoundRect m2370RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* renamed from: translate-Uv8p0NA  reason: not valid java name */
    public static final RoundRect m2374translateUv8p0NA(RoundRect translate, long j) {
        Intrinsics.checkNotNullParameter(translate, "$this$translate");
        return new RoundRect(translate.getLeft() + Offset.m2318getXimpl(j), translate.getTop() + Offset.m2319getYimpl(j), translate.getRight() + Offset.m2318getXimpl(j), translate.getBottom() + Offset.m2319getYimpl(j), translate.m2368getTopLeftCornerRadiuskKHJgLs(), translate.m2369getTopRightCornerRadiuskKHJgLs(), translate.m2367getBottomRightCornerRadiuskKHJgLs(), translate.m2366getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m2293getXimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m2294getYimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2294getYimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m2293getXimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2293getXimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m2294getYimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2294getYimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        float left = roundRect.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = roundRect.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = roundRect.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = roundRect.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r6.m2368getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r6.m2369getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r6.m2366getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m2368getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2293getXimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            if (r0 != 0) goto L2a
            long r4 = r6.m2368getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L27
            r0 = r2
            goto L28
        L27:
            r0 = r3
        L28:
            if (r0 == 0) goto L91
        L2a:
            long r4 = r6.m2369getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2293getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = r3
        L39:
            if (r0 != 0) goto L4c
            long r4 = r6.m2369getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
            r0 = r2
            goto L4a
        L49:
            r0 = r3
        L4a:
            if (r0 == 0) goto L91
        L4c:
            long r4 = r6.m2366getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2293getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5a
            r0 = r2
            goto L5b
        L5a:
            r0 = r3
        L5b:
            if (r0 != 0) goto L6e
            long r4 = r6.m2366getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6b
            r0 = r2
            goto L6c
        L6b:
            r0 = r3
        L6c:
            if (r0 == 0) goto L91
        L6e:
            long r4 = r6.m2367getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2293getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L7c
            r0 = r2
            goto L7d
        L7c:
            r0 = r3
        L7d:
            if (r0 != 0) goto L92
            long r4 = r6.m2367getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m2294getYimpl(r4)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L8d
            r6 = r2
            goto L8e
        L8d:
            r6 = r3
        L8e:
            if (r6 == 0) goto L91
            goto L92
        L91:
            r2 = r3
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2294getYimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2293getXimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2294getYimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2293getXimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m2294getYimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs())) && roundRect.getWidth() <= CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) * 2.0d && roundRect.getHeight() <= CornerRadius.m2294getYimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isCircle(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final float getMinDimension(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2369getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2367getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2293getXimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m2293getXimpl(roundRect.m2368getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2294getYimpl(roundRect.m2366getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect start, RoundRect stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f), CornerRadiusKt.m2304lerp3Ry4LBc(start.m2368getTopLeftCornerRadiuskKHJgLs(), stop.m2368getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2304lerp3Ry4LBc(start.m2369getTopRightCornerRadiuskKHJgLs(), stop.m2369getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2304lerp3Ry4LBc(start.m2367getBottomRightCornerRadiuskKHJgLs(), stop.m2367getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2304lerp3Ry4LBc(start.m2366getBottomLeftCornerRadiuskKHJgLs(), stop.m2366getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }
}
