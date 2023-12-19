package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, m40d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.gestures.PressGestureScope */
/* loaded from: classes.dex */
public interface TapGestureDetector extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.PressGestureScope$DefaultImpls */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m584roundToPxR2X_6o(TapGestureDetector tapGestureDetector, long j) {
            return TapGestureDetector.super.mo596roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m585roundToPx0680j_4(TapGestureDetector tapGestureDetector, float f) {
            return TapGestureDetector.super.mo597roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m586toDpGaN1DYA(TapGestureDetector tapGestureDetector, long j) {
            return TapGestureDetector.super.mo598toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m587toDpu2uoSUM(TapGestureDetector tapGestureDetector, float f) {
            return TapGestureDetector.super.mo599toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m588toDpu2uoSUM(TapGestureDetector tapGestureDetector, int i) {
            return TapGestureDetector.super.mo600toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m589toDpSizekrfVVM(TapGestureDetector tapGestureDetector, long j) {
            return TapGestureDetector.super.mo601toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m590toPxR2X_6o(TapGestureDetector tapGestureDetector, long j) {
            return TapGestureDetector.super.mo602toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m591toPx0680j_4(TapGestureDetector tapGestureDetector, float f) {
            return TapGestureDetector.super.mo603toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(TapGestureDetector tapGestureDetector, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return TapGestureDetector.super.toRect(receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m592toSizeXkaWNTQ(TapGestureDetector tapGestureDetector, long j) {
            return TapGestureDetector.super.mo604toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m593toSp0xMU5do(TapGestureDetector tapGestureDetector, float f) {
            return TapGestureDetector.super.mo605toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m594toSpkPz2Gy4(TapGestureDetector tapGestureDetector, float f) {
            return TapGestureDetector.super.mo606toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m595toSpkPz2Gy4(TapGestureDetector tapGestureDetector, int i) {
            return TapGestureDetector.super.mo607toSpkPz2Gy4(i);
        }
    }
}
