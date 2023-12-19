package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B0\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0011\u0010;\u001a\u000208H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010<J\f\u0010=\u001a\u000208*\u00020>H\u0016J)\u0010?\u001a\u00020@*\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GR4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R+\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020+8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0016\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00102\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b3\u0010\u0012R\u0019\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/foundation/MarqueeModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/focus/FocusEventModifier;", "iterations", "", "delayMillis", "initialDelayMillis", "velocity", "Landroidx/compose/ui/unit/Dp;", "density", "Landroidx/compose/ui/unit/Density;", "(IIIFLandroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "Landroidx/compose/foundation/MarqueeAnimationMode;", "animationMode", "getAnimationMode-ZbEOnfQ", "()I", "setAnimationMode-97h66l8", "(I)V", "animationMode$delegate", "Landroidx/compose/runtime/MutableState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "contentWidth", "getContentWidth", "setContentWidth", "contentWidth$delegate", "direction", "", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/MarqueeSpacing;", "spacing", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "F", "onFocusEvent", "", "focusState", "Landroidx/compose/ui/focus/FocusState;", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MarqueeModifier implements Modifier.Element, LayoutModifier, DrawModifier, FocusEventModifier {
    private final MutableState animationMode$delegate;
    private final MutableState containerWidth$delegate;
    private final MutableState contentWidth$delegate;
    private final int delayMillis;
    private final Density density;
    private final float direction;
    private final MutableState hasFocus$delegate;
    private final int initialDelayMillis;
    private final int iterations;
    private final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    private final float velocity;

    public /* synthetic */ MarqueeModifier(int i, int i2, int i3, float f, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, f, density);
    }

    private MarqueeModifier(int i, int i2, int i3, float f, Density density) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        this.iterations = i;
        this.delayMillis = i2;
        this.initialDelayMillis = i3;
        this.velocity = f;
        this.density = density;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.contentWidth$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.containerWidth$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.hasFocus$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BasicMarqueeKt.getDefaultMarqueeSpacing(), null, 2, null);
        this.spacing$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m202boximpl(MarqueeAnimationMode.Companion.m211getImmediatelyZbEOnfQ()), null, 2, null);
        this.animationMode$delegate = mutableStateOf$default5;
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.direction = Math.signum(f);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.MarqueeModifier$spacingPx$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Density density2;
                int contentWidth;
                int containerWidth;
                MarqueeSpacing spacing = MarqueeModifier.this.getSpacing();
                MarqueeModifier marqueeModifier = MarqueeModifier.this;
                density2 = marqueeModifier.density;
                contentWidth = marqueeModifier.getContentWidth();
                containerWidth = marqueeModifier.getContainerWidth();
                return Integer.valueOf(spacing.calculateSpacing(density2, contentWidth, containerWidth));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContentWidth() {
        return ((Number) this.contentWidth$delegate.getValue()).intValue();
    }

    private final void setContentWidth(int i) {
        this.contentWidth$delegate.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContainerWidth() {
        return ((Number) this.containerWidth$delegate.getValue()).intValue();
    }

    private final void setContainerWidth(int i) {
        this.containerWidth$delegate.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    public final void setSpacing(MarqueeSpacing marqueeSpacing) {
        Intrinsics.checkNotNullParameter(marqueeSpacing, "<set-?>");
        this.spacing$delegate.setValue(marqueeSpacing);
    }

    /* renamed from: getAnimationMode-ZbEOnfQ  reason: not valid java name */
    public final int m213getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m208unboximpl();
    }

    /* renamed from: setAnimationMode-97h66l8  reason: not valid java name */
    public final void m214setAnimationMode97h66l8(int i) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m202boximpl(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo25measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(Constraints.m4997copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.m5020constrainWidthK40F9xA(j, mo4075measureBRTryo0.getWidth()));
        setContentWidth(mo4075measureBRTryo0.getWidth());
        return MeasureScope.layout$default(measure, getContainerWidth(), mo4075measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.MarqueeModifier$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Animatable animatable;
                float f;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable = Placeable.this;
                animatable = this.offset;
                f = this.direction;
                Placeable.PlacementScope.placeWithLayer$default(layout, placeable, MathKt.roundToInt((-((Number) animatable.getValue()).floatValue()) * f), 0, 0.0f, null, 12, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        int spacingPx;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float floatValue = this.offset.getValue().floatValue();
        float f = this.direction;
        float f2 = floatValue * f;
        boolean z = !((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0) ? this.offset.getValue().floatValue() >= ((float) getContainerWidth()) : this.offset.getValue().floatValue() >= ((float) getContentWidth());
        boolean z2 = !((this.direction > 1.0f ? 1 : (this.direction == 1.0f ? 0 : -1)) == 0) ? this.offset.getValue().floatValue() <= ((float) getSpacingPx()) : this.offset.getValue().floatValue() <= ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        if (this.direction == 1.0f) {
            spacingPx = getContentWidth() + getSpacingPx();
        } else {
            spacingPx = (-getContentWidth()) - getSpacingPx();
        }
        float f3 = spacingPx;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float m2384getHeightimpl = Size.m2384getHeightimpl(contentDrawScope2.mo3096getSizeNHjbRc());
        int m2545getIntersectrtfAjoo = ClipOp.Companion.m2545getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long mo3021getSizeNHjbRc = drawContext.mo3021getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3024clipRectN_I0leg(f2, 0.0f, f2 + getContainerWidth(), m2384getHeightimpl, m2545getIntersectrtfAjoo);
        if (z) {
            contentDrawScope.drawContent();
        }
        if (z2) {
            contentDrawScope2.getDrawContext().getTransform().translate(f3, 0.0f);
            contentDrawScope.drawContent();
            contentDrawScope2.getDrawContext().getTransform().translate(-f3, -0.0f);
        }
        drawContext.getCanvas().restore();
        drawContext.mo3022setSizeuvyYCjk(mo3021getSizeNHjbRc);
    }

    @Override // androidx.compose.ui.focus.FocusEventModifier
    public void onFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        setHasFocus(focusState.getHasFocus());
    }

    public final Object runAnimation(Continuation<? super Unit> continuation) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new MarqueeModifier$runAnimation$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
