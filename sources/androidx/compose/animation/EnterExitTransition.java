package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003ø\u0001\u0000J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003ø\u0001\u0000J\t\u0010\u001a\u001a\u00020\rHÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001ø\u0001\u0000J\u0013\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m40d2 = {"Landroidx/compose/animation/ChangeSize;", "", "alignment", "Landroidx/compose/ui/Alignment;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "fullSize", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "clip", "", "(Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getClip", "()Z", "getSize", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.animation.ChangeSize */
/* loaded from: classes.dex */
public final class EnterExitTransition {
    private final Alignment alignment;
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final boolean clip;
    private final Function1<IntSize, IntSize> size;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnterExitTransition copy$default(EnterExitTransition enterExitTransition, Alignment alignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = enterExitTransition.alignment;
        }
        if ((i & 2) != 0) {
            function1 = enterExitTransition.size;
        }
        if ((i & 4) != 0) {
            finiteAnimationSpec = enterExitTransition.animationSpec;
        }
        if ((i & 8) != 0) {
            z = enterExitTransition.clip;
        }
        return enterExitTransition.copy(alignment, function1, finiteAnimationSpec, z);
    }

    public final Alignment component1() {
        return this.alignment;
    }

    public final Function1<IntSize, IntSize> component2() {
        return this.size;
    }

    public final FiniteAnimationSpec<IntSize> component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.clip;
    }

    public final EnterExitTransition copy(Alignment alignment, Function1<? super IntSize, IntSize> size, FiniteAnimationSpec<IntSize> animationSpec, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterExitTransition(alignment, size, animationSpec, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnterExitTransition) {
            EnterExitTransition enterExitTransition = (EnterExitTransition) obj;
            return Intrinsics.areEqual(this.alignment, enterExitTransition.alignment) && Intrinsics.areEqual(this.size, enterExitTransition.size) && Intrinsics.areEqual(this.animationSpec, enterExitTransition.animationSpec) && this.clip == enterExitTransition.clip;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.alignment.hashCode() * 31) + this.size.hashCode()) * 31) + this.animationSpec.hashCode()) * 31;
        boolean z = this.clip;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnterExitTransition(Alignment alignment, Function1<? super IntSize, IntSize> size, FiniteAnimationSpec<IntSize> animationSpec, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.alignment = alignment;
        this.size = size;
        this.animationSpec = animationSpec;
        this.clip = z;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public /* synthetic */ EnterExitTransition(Alignment alignment, C01451 c01451, FiniteAnimationSpec finiteAnimationSpec, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, (i & 2) != 0 ? new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.ChangeSize.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m5503boximpl(m341invokemzRDjE0(intSize.m5515unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m341invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(0, 0);
            }
        } : c01451, finiteAnimationSpec, (i & 8) != 0 ? true : z);
    }

    public final Function1<IntSize, IntSize> getSize() {
        return this.size;
    }

    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }
}
