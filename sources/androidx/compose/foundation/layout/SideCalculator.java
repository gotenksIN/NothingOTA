package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.unit.LayoutDirection;
import androidx.compose.p002ui.unit.Velocity;
import androidx.compose.p002ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(m41d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bc\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, m40d2 = {"Landroidx/compose/foundation/layout/SideCalculator;", "", "adjustInsets", "Landroid/graphics/Insets;", "oldInsets", "newValue", "", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "", "consumedVelocity-QWom1Mo", "(JF)J", "hideMotion", "x", "y", "motionOf", "showMotion", "valueOf", "insets", "Companion", "foundation-layout_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
interface SideCalculator {
    public static final Companion Companion = Companion.$$INSTANCE;

    Insets adjustInsets(Insets insets, int i);

    /* renamed from: consumedOffsets-MK-Hz9U  reason: not valid java name */
    long mo740consumedOffsetsMKHz9U(long j);

    /* renamed from: consumedVelocity-QWom1Mo  reason: not valid java name */
    long mo741consumedVelocityQWom1Mo(long j, float f);

    float motionOf(float f, float f2);

    int valueOf(Insets insets);

    default float showMotion(float f, float f2) {
        return RangesKt.coerceAtLeast(motionOf(f, f2), 0.0f);
    }

    default float hideMotion(float f, float f2) {
        return RangesKt.coerceAtMost(motionOf(f, f2), 0.0f);
    }

    /* compiled from: WindowInsetsConnection.android.kt */
    @Metadata(m41d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0004\u0004\u0007\n\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, m40d2 = {"Landroidx/compose/foundation/layout/SideCalculator$Companion;", "", "()V", "BottomSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1;", "LeftSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1;", "RightSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1;", "TopSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1;", "chooseCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "chooseCalculator-ni1skBw", "(ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/layout/SideCalculator;", "foundation-layout_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return f;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.left;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets adjustInsets(Insets oldInsets, int i) {
                Intrinsics.checkNotNullParameter(oldInsets, "oldInsets");
                Insets of = Insets.of(i, oldInsets.top, oldInsets.right, oldInsets.bottom);
                Intrinsics.checkNotNullExpressionValue(of, "of(newValue, oldInsets.t….right, oldInsets.bottom)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo740consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p002ui.geometry.OffsetKt.Offset(Offset.m2619getXimpl(j), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo741consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(Velocity.m5576getXimpl(j) - f, 0.0f);
            }
        };
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return f2;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.top;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets adjustInsets(Insets oldInsets, int i) {
                Intrinsics.checkNotNullParameter(oldInsets, "oldInsets");
                Insets of = Insets.of(oldInsets.left, i, oldInsets.right, oldInsets.bottom);
                Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, newVa….right, oldInsets.bottom)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo740consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p002ui.geometry.OffsetKt.Offset(0.0f, Offset.m2620getYimpl(j));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo741consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(0.0f, Velocity.m5577getYimpl(j) - f);
            }
        };
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$RightSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return -f;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.right;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets adjustInsets(Insets oldInsets, int i) {
                Intrinsics.checkNotNullParameter(oldInsets, "oldInsets");
                Insets of = Insets.of(oldInsets.left, oldInsets.top, i, oldInsets.bottom);
                Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, oldIn…wValue, oldInsets.bottom)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo740consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p002ui.geometry.OffsetKt.Offset(Offset.m2619getXimpl(j), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo741consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(Velocity.m5576getXimpl(j) + f, 0.0f);
            }
        };
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return -f2;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.bottom;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets adjustInsets(Insets oldInsets, int i) {
                Intrinsics.checkNotNullParameter(oldInsets, "oldInsets");
                Insets of = Insets.of(oldInsets.left, oldInsets.top, oldInsets.right, i);
                Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, oldIn…ldInsets.right, newValue)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo740consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p002ui.geometry.OffsetKt.Offset(0.0f, Offset.m2620getYimpl(j));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo741consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(0.0f, Velocity.m5577getYimpl(j) + f);
            }
        };

        private Companion() {
        }

        /* renamed from: chooseCalculator-ni1skBw  reason: not valid java name */
        public final SideCalculator m742chooseCalculatorni1skBw(int i, LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m798getLeftJoeWqyM())) {
                return LeftSideCalculator;
            }
            if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m801getTopJoeWqyM())) {
                return TopSideCalculator;
            }
            if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m799getRightJoeWqyM())) {
                return RightSideCalculator;
            }
            if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m795getBottomJoeWqyM())) {
                return BottomSideCalculator;
            }
            if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m800getStartJoeWqyM())) {
                if (layoutDirection == LayoutDirection.Ltr) {
                    return LeftSideCalculator;
                }
                return RightSideCalculator;
            } else if (WindowInsetsSides.m784equalsimpl0(i, WindowInsetsSides.Companion.m796getEndJoeWqyM())) {
                if (layoutDirection == LayoutDirection.Ltr) {
                    return RightSideCalculator;
                }
                return LeftSideCalculator;
            } else {
                throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
            }
        }
    }
}
