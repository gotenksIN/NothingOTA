package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: SwipeableV2.kt */
@Metadata(m41d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 s*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001sB\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010V\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u00002\b\b\u0002\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ%\u0010Z\u001a\u00028\u00002\u0006\u0010@\u001a\u00020\u00062\u0006\u0010(\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006J\u0013\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00028\u0000¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u000fH\u0002J\u0006\u0010b\u001a\u00020\u0006J\u0019\u0010c\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0019\u0010f\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010gJ9\u0010h\u001a\u00020W2\b\b\u0002\u0010i\u001a\u00020j2\u001c\u0010k\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0l\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010mJ\u0017\u0010n\u001a\u00020\f2\u0006\u0010Q\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u0010`J!\u0010p\u001a\u00020\f2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0002\brRC\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00168@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00109\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u00105R\u001b\u0010=\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b>\u00105R/\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bI\u00105R\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bR\u0010\"R\u001f\u0010\u0012\u001a\u00020\u0013X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010U\u001a\u0004\bT\u00105\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, m40d2 = {"Landroidx/compose/material3/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$material3_release", "()Ljava/util/Map;", "setAnchors$material3_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material3_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "getPositionalThreshold$material3_release", "()Lkotlin/jvm/functions/Function2;", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "progress$delegate", "swipeDraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getSwipeDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "swipeMutex", "Landroidx/compose/material3/InternalMutatorMutex;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$material3_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snap", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swipe", "swipePriority", "Landroidx/compose/foundation/MutatePriority;", "action", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material3_release", "updateAnchors", "newAnchors", "updateAnchors$material3_release", "Companion", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class SwipeableV2State<T> {
    public static final Companion Companion = new Companion(null);
    private final SnapshotState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final SnapshotState animationTarget$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final SnapshotState currentValue$delegate;
    private Density density;
    private final SnapshotState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final SnapshotState offset$delegate;
    private final Function2<Density, Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final DraggableState swipeDraggableState;
    private final InternalMutatorMutex swipeMutex;
    private final State targetValue$delegate;
    private final float velocityThreshold;

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, Function2 function2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec, function1, function2, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SwipeableV2State(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, float f) {
        SnapshotState mutableStateOf$default;
        SnapshotState mutableStateOf$default2;
        SnapshotState mutableStateOf$default3;
        SnapshotState mutableStateOf$default4;
        SnapshotState mutableStateOf$default5;
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = f;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue$delegate = mutableStateOf$default;
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new Functions<T>(this) { // from class: androidx.compose.material3.SwipeableV2State$targetValue$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Functions
            public final T invoke() {
                Object animationTarget;
                Object computeTarget;
                animationTarget = this.this$0.getAnimationTarget();
                T t2 = (T) animationTarget;
                if (t2 == null) {
                    SwipeableV2State<T> swipeableV2State = this.this$0;
                    Float offset = swipeableV2State.getOffset();
                    if (offset != null) {
                        computeTarget = swipeableV2State.computeTarget(offset.floatValue(), swipeableV2State.getCurrentValue(), 0.0f);
                        return (T) computeTarget;
                    }
                    return swipeableV2State.getCurrentValue();
                }
                return t2;
            }
        });
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.offset$delegate = mutableStateOf$default2;
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new Functions<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final Float invoke() {
                Float f2 = (Float) this.this$0.getAnchors$material3_release().get(this.this$0.getCurrentValue());
                float f3 = 0.0f;
                float floatValue = f2 != null ? f2.floatValue() : 0.0f;
                Float f4 = (Float) this.this$0.getAnchors$material3_release().get(this.this$0.getTargetValue());
                float floatValue2 = (f4 != null ? f4.floatValue() : 0.0f) - floatValue;
                if (Math.abs(floatValue2) > 1.0E-6f) {
                    float requireOffset = (this.this$0.requireOffset() - floatValue) / floatValue2;
                    if (requireOffset >= 1.0E-6f) {
                        if (requireOffset <= 0.999999f) {
                            f3 = requireOffset;
                        }
                    }
                    return Float.valueOf(f3);
                }
                f3 = 1.0f;
                return Float.valueOf(f3);
            }
        });
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.lastVelocity$delegate = mutableStateOf$default3;
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new Functions<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$minOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final Float invoke() {
                Float minOrNull;
                minOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new Functions<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$maxOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final Float invoke() {
                Float maxOrNull;
                maxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        this.anchors$delegate = mutableStateOf$default5;
    }

    public /* synthetic */ SwipeableV2State(Object obj, SpringSpec<Float> springSpec, C06251 c06251, Function2<Density, Float, Float> function2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableV2Defaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableV2State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                return invoke((C06251) obj2);
            }
        } : c06251, (i & 8) != 0 ? SwipeableV2Defaults.INSTANCE.getPositionalThreshold() : function2, (i & 16) != 0 ? SwipeableV2Defaults.INSTANCE.m1722getVelocityThresholdD9Ej5fM() : f, null);
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material3_release() {
        return this.confirmValueChange;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$material3_release() {
        return this.positionalThreshold;
    }

    /* renamed from: getVelocityThreshold-D9Ej5fM$material3_release  reason: not valid java name */
    public final float m1725getVelocityThresholdD9Ej5fM$material3_release() {
        return this.velocityThreshold;
    }

    public final DraggableState getSwipeDraggableState$material3_release() {
        return this.swipeDraggableState;
    }

    private final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset$delegate.setValue(f);
    }

    public final Float getOffset() {
        return (Float) this.offset$delegate.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity$delegate.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget$delegate.setValue(t);
    }

    public final Map<T, Float> getAnchors$material3_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$material3_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public final void setDensity$material3_release(Density density) {
        this.density = density;
    }

    public final boolean updateAnchors$material3_release(Map<T, Float> newAnchors) {
        boolean z;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean isEmpty = getAnchors$material3_release().isEmpty();
        setAnchors$material3_release(newAnchors);
        if (isEmpty) {
            T currentValue = getCurrentValue();
            z = getAnchors$material3_release().get(currentValue) != null;
            if (z) {
                trySnapTo$material3_release(currentValue);
            }
        } else {
            z = true;
        }
        return (z && isEmpty) ? false : true;
    }

    public final boolean hasAnchorForValue(T t) {
        return getAnchors$material3_release().containsKey(t);
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object swipe$default = swipe$default(this, null, new SwipeableV2State$snapTo$2(this, t, null), continuation, 1, null);
        return swipe$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? swipe$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateTo(T r16, float r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    public final Object settle(float f, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T computeTarget = computeTarget(requireOffset(), currentValue, f);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            Object animateTo = animateTo(computeTarget, f, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(currentValue, f, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float f) {
        Float offset = getOffset();
        float floatValue = offset != null ? offset.floatValue() : 0.0f;
        float coerceIn = RangesKt.coerceIn(f + floatValue, getMinOffset(), getMaxOffset()) - floatValue;
        if (Math.abs(coerceIn) >= 0.0f) {
            Float offset2 = getOffset();
            setOffset(Float.valueOf(RangesKt.coerceIn((offset2 != null ? offset2.floatValue() : 0.0f) + coerceIn, getMinOffset(), getMaxOffset())));
        }
        return coerceIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float f, T t, float f2) {
        Object access$closestAnchor;
        Map<T, Float> anchors$material3_release = getAnchors$material3_release();
        Float f3 = anchors$material3_release.get(t);
        Density requireDensity = requireDensity();
        float mo603toPx0680j_4 = requireDensity.mo603toPx0680j_4(this.velocityThreshold);
        if (Intrinsics.areEqual(f3, f) || f3 == null) {
            return t;
        }
        if (f3.floatValue() < f) {
            if (f2 >= mo603toPx0680j_4) {
                return (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, f, true);
            }
            access$closestAnchor = SwipeableV2Kt.access$closestAnchor(anchors$material3_release, f, true);
            if (f < Math.abs(f3.floatValue() + Math.abs(this.positionalThreshold.invoke(requireDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(anchors$material3_release, access$closestAnchor)).floatValue() - f3.floatValue()))).floatValue()))) {
                return t;
            }
        } else if (f2 <= (-mo603toPx0680j_4)) {
            return (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, f, false);
        } else {
            access$closestAnchor = SwipeableV2Kt.access$closestAnchor(anchors$material3_release, f, false);
            float abs = Math.abs(f3.floatValue() - Math.abs(this.positionalThreshold.invoke(requireDensity, Float.valueOf(Math.abs(f3.floatValue() - ((Number) MapsKt.getValue(anchors$material3_release, access$closestAnchor)).floatValue()))).floatValue()));
            if (f < 0.0f) {
                if (Math.abs(f) < abs) {
                    return t;
                }
            } else if (f > abs) {
                return t;
            }
        }
        return (T) access$closestAnchor;
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object swipe(MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new SwipeableV2State$swipe$2(this, mutatePriority, function1, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material3_release(final T t) {
        return this.swipeMutex.tryMutate(new Functions<Unit>(this) { // from class: androidx.compose.material3.SwipeableV2State$trySnapTo$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.snap(t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snap(T t) {
        Float f = getAnchors$material3_release().get(t);
        if (f != null) {
            float floatValue = f.floatValue();
            Float offset = getOffset();
            dispatchRawDelta(floatValue - (offset != null ? offset.floatValue() : 0.0f));
            setCurrentValue(t);
            setAnimationTarget(null);
            return;
        }
        setCurrentValue(t);
    }

    /* compiled from: SwipeableV2.kt */
    @Metadata(m41d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0089\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, m40d2 = {"Landroidx/compose/material3/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Saver-eqLRuRQ  reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m1726SavereqLRuRQ(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmValueChange, final Function2<? super Density, ? super Float, Float> positionalThreshold, final float f) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Object obj) {
                    return invoke(saverScope, (SwipeableV2State) ((SwipeableV2State) obj));
                }

                public final T invoke(SaverScope Saver, SwipeableV2State<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((SwipeableV2State$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SwipeableV2State<T> invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableV2State<>(it, animationSpec, confirmValueChange, positionalThreshold, f, null);
                }
            });
        }
    }
}
