package androidx.compose.p002ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.DrawModifierKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p002ui.graphics.Canvas;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p002ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.node.LayoutNode;
import androidx.compose.p002ui.node.Owner;
import androidx.compose.p002ui.platform.AndroidComposeView;
import androidx.compose.p002ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.p002ui.platform.WindowRecomposer_androidKt;
import androidx.compose.p002ui.semantics.SemanticsModifierKt;
import androidx.compose.p002ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.DensityKt;
import androidx.compose.p002ui.unit.VelocityKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.common.primitives.Ints;
import com.nothing.OfflineOTAUpgradeApp.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(m41d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010U\u001a\u00020\u00132\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u000e\u0010X\u001a\n\u0018\u00010Oj\u0004\u0018\u0001`YJ\n\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020\u0015H\u0016J\u001e\u0010]\u001a\u0004\u0018\u00010^2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020\u0013H\u0016J \u0010b\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u00152\u0006\u0010d\u001a\u00020\u00152\u0006\u0010e\u001a\u00020\u0015H\u0002J\b\u0010f\u001a\u00020-H\u0014J\b\u0010g\u001a\u00020-H\u0016J\u0018\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u00020O2\u0006\u0010j\u001a\u00020OH\u0016J\b\u0010k\u001a\u00020-H\u0014J0\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u00152\u0006\u0010p\u001a\u00020\u00152\u0006\u0010q\u001a\u00020\u0015H\u0014J\u0018\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020\u00152\u0006\u0010t\u001a\u00020\u0015H\u0014J(\u0010u\u001a\u00020\u00132\u0006\u0010j\u001a\u00020O2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020\u0013H\u0016J \u0010z\u001a\u00020\u00132\u0006\u0010j\u001a\u00020O2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020wH\u0016J0\u0010{\u001a\u00020-2\u0006\u0010j\u001a\u00020O2\u0006\u0010|\u001a\u00020\u00152\u0006\u0010}\u001a\u00020\u00152\u0006\u0010y\u001a\u00020\"2\u0006\u0010~\u001a\u00020\u0015H\u0016J<\u0010\u007f\u001a\u00020-2\u0006\u0010j\u001a\u00020O2\u0007\u0010\u0080\u0001\u001a\u00020\u00152\u0007\u0010\u0081\u0001\u001a\u00020\u00152\u0007\u0010\u0082\u0001\u001a\u00020\u00152\u0007\u0010\u0083\u0001\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u0015H\u0016JD\u0010\u007f\u001a\u00020-2\u0006\u0010j\u001a\u00020O2\u0007\u0010\u0080\u0001\u001a\u00020\u00152\u0007\u0010\u0081\u0001\u001a\u00020\u00152\u0007\u0010\u0082\u0001\u001a\u00020\u00152\u0007\u0010\u0083\u0001\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u00152\u0006\u0010y\u001a\u00020\"H\u0016J*\u0010\u0084\u0001\u001a\u00020-2\u0006\u0010i\u001a\u00020O2\u0006\u0010j\u001a\u00020O2\u0007\u0010\u0085\u0001\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u0015H\u0016J\t\u0010\u0086\u0001\u001a\u00020-H\u0016J\t\u0010\u0087\u0001\u001a\u00020-H\u0016J*\u0010\u0088\u0001\u001a\u00020\u00132\u0006\u0010i\u001a\u00020O2\u0006\u0010j\u001a\u00020O2\u0007\u0010\u0085\u0001\u001a\u00020\u00152\u0006\u0010~\u001a\u00020\u0015H\u0016J\u0019\u0010\u0089\u0001\u001a\u00020-2\u0006\u0010j\u001a\u00020O2\u0006\u0010~\u001a\u00020\u0015H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020-2\u0007\u0010\u008b\u0001\u001a\u00020\u0015H\u0014J\u0007\u0010\u008c\u0001\u001a\u00020-J\u0012\u0010\u008d\u0001\u001a\u00020-2\u0007\u0010\u008e\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0013H\u0016R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R(\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R0\u0010;\u001a\b\u0012\u0004\u0012\u00020-0:2\f\u00109\u001a\b\u0012\u0004\u0012\u00020-0:@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R0\u0010@\u001a\b\u0012\u0004\u0012\u00020-0:2\f\u00109\u001a\b\u0012\u0004\u0012\u00020-0:@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020-0:X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u000b\u001a\u0004\u0018\u00010D@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010L\u001a\b\u0012\u0004\u0012\u00020-0:2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020-0:@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010=\"\u0004\bN\u0010?R(\u0010P\u001a\u0004\u0018\u00010O2\b\u0010\u000b\u001a\u0004\u0018\u00010O@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006\u0090\u0001"}, m40d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "<set-?>", "Lkotlin/Function0;", BuildConfig.BUILD_TYPE, "getRelease", "()Lkotlin/jvm/functions/Function0;", "setRelease", "(Lkotlin/jvm/functions/Function0;)V", "reset", "getReset", "setReset", "runUpdate", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "setUpdate", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDeactivate", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onRelease", "onReuse", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder */
/* loaded from: classes.dex */
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback {
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private Functions<Unit> release;
    private Functions<Unit> reset;
    private final Functions<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private final SnapshotStateObserver snapshotObserver;
    private Functions<Unit> update;
    private View view;

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int i, int i2) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher dispatcher) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = new Functions<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.reset = new Functions<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.release = new Functions<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new Functions<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Functions
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z;
                SnapshotStateObserver snapshotStateObserver;
                Function1 function1;
                z = AndroidViewHolder.this.hasUpdateBlock;
                if (z) {
                    snapshotStateObserver = AndroidViewHolder.this.snapshotObserver;
                    AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                    function1 = androidViewHolder.onCommitAffectingUpdate;
                    snapshotStateObserver.observeReads(androidViewHolder, function1, AndroidViewHolder.this.getUpdate());
                }
            }
        };
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        final LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setInteropViewFactoryHolder$ui_release(this);
        final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(Modifier.Companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }), this), new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                LayoutNode layoutNode2 = LayoutNode.this;
                AndroidViewHolder androidViewHolder = this;
                Canvas canvas = drawBehind.getDrawContext().getCanvas();
                Owner owner$ui_release = layoutNode2.getOwner$ui_release();
                AndroidComposeView androidComposeView = owner$ui_release instanceof AndroidComposeView ? (AndroidComposeView) owner$ui_release : null;
                if (androidComposeView != null) {
                    androidComposeView.drawAndroidView(androidViewHolder, AndroidCanvas_androidKt.getNativeCanvas(canvas));
                }
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidViewHolder_androidKt.layoutAccordingTo(AndroidViewHolder.this, layoutNode);
            }
        });
        layoutNode.setModifier(this.modifier.then(onGloballyPositioned));
        this.onModifierChanged = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier) {
                invoke2(modifier);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Modifier it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setModifier(it.then(onGloballyPositioned));
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Density density) {
                invoke2(density);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Density it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setDensity(it);
            }
        };
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode.setOnAttach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner) {
                invoke2(owner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(AndroidViewHolder.this, layoutNode);
                }
                if (objectRef.element != null) {
                    AndroidViewHolder.this.setView$ui_release(objectRef.element);
                }
            }
        });
        layoutNode.setOnDetach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner) {
                invoke2(owner);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, android.view.View] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(AndroidViewHolder.this);
                }
                objectRef.element = AndroidViewHolder.this.getView();
                AndroidViewHolder.this.setView$ui_release(null);
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo313measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
                int obtainMeasureSpec;
                int obtainMeasureSpec2;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (AndroidViewHolder.this.getChildCount() == 0) {
                    return MeasureScope.layout$default(measure, Constraints.m5309getMinWidthimpl(j), Constraints.m5308getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
                if (Constraints.m5309getMinWidthimpl(j) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumWidth(Constraints.m5309getMinWidthimpl(j));
                }
                if (Constraints.m5308getMinHeightimpl(j) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumHeight(Constraints.m5308getMinHeightimpl(j));
                }
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                int m5309getMinWidthimpl = Constraints.m5309getMinWidthimpl(j);
                int m5307getMaxWidthimpl = Constraints.m5307getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(m5309getMinWidthimpl, m5307getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                int m5308getMinHeightimpl = Constraints.m5308getMinHeightimpl(j);
                int m5306getMaxHeightimpl = Constraints.m5306getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                obtainMeasureSpec2 = androidViewHolder2.obtainMeasureSpec(m5308getMinHeightimpl, m5306getMaxHeightimpl, layoutParams2.height);
                androidViewHolder.measure(obtainMeasureSpec, obtainMeasureSpec2);
                int measuredWidth = AndroidViewHolder.this.getMeasuredWidth();
                int measuredHeight = AndroidViewHolder.this.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder3 = AndroidViewHolder.this;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.layout$default(measure, measuredWidth, measuredHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
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
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        AndroidViewHolder_androidKt.layoutAccordingTo(AndroidViewHolder.this, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicWidth(i);
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicWidth(i);
            }

            private final int intrinsicWidth(int i) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder2.obtainMeasureSpec(0, i, layoutParams.height);
                androidViewHolder.measure(makeMeasureSpec, obtainMeasureSpec);
                return AndroidViewHolder.this.getMeasuredWidth();
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicHeight(i);
            }

            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicHeight(i);
            }

            private final int intrinsicHeight(int i) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(0, i, layoutParams.width);
                androidViewHolder.measure(obtainMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                return AndroidViewHolder.this.getMeasuredHeight();
            }
        });
        this.layoutNode = layoutNode;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView$ui_release(View view) {
        if (view != this.view) {
            this.view = view;
            removeAllViewsInLayout();
            if (view != null) {
                addView(view);
                this.runUpdate.invoke();
            }
        }
    }

    public final View getInteropView() {
        return this.view;
    }

    public final Functions<Unit> getUpdate() {
        return this.update;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUpdate(Functions<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Functions<Unit> getReset() {
        return this.reset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setReset(Functions<Unit> functions) {
        Intrinsics.checkNotNullParameter(functions, "<set-?>");
        this.reset = functions;
    }

    public final Functions<Unit> getRelease() {
        return this.release;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRelease(Functions<Unit> functions) {
        Intrinsics.checkNotNullParameter(functions, "<set-?>");
        this.release = functions;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.modifier) {
            this.modifier = value;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.density) {
            this.density = value;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        View view = this.view;
        Intrinsics.checkNotNull(view);
        if (view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        this.release.invoke();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.view;
        if ((view != null ? view.getParent() : null) != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            return;
        }
        View view2 = this.view;
        if (view2 != null) {
            view2.measure(i, i2);
        }
        View view3 = this.view;
        int measuredWidth = view3 != null ? view3.getMeasuredWidth() : 0;
        View view4 = this.view;
        setMeasuredDimension(measuredWidth, view4 != null ? view4.getMeasuredHeight() : 0);
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 == Integer.MIN_VALUE || (i = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i2, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.view;
        if (view != null) {
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.view;
        return (view == null || (layoutParams = view.getLayoutParams()) == null) ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onDescendantInvalidated(child, target);
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], i + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), Ints.MAX_POWER_OF_TWO);
        }
        if (i3 != -2 || i2 == Integer.MAX_VALUE) {
            if (i3 == -1 && i2 != Integer.MAX_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(i2, Ints.MAX_POWER_OF_TWO);
            }
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int i, int i2) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, i, i2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int i) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(target, i);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long m4146dispatchPostScrollDzOQY0M = this.dispatcher.m4146dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i3), AndroidViewHolder_androidKt.access$toComposeOffset(i4)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i5));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2619getXimpl(m4146dispatchPostScrollDzOQY0M));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2620getYimpl(m4146dispatchPostScrollDzOQY0M));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m4146dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i3), AndroidViewHolder_androidKt.access$toComposeOffset(i4)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i5));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int i, int i2, int[] consumed, int i3) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long m4148dispatchPreScrollOzD1aCk = this.dispatcher.m4148dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i3));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2619getXimpl(m4148dispatchPreScrollOzD1aCk));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2620getYimpl(m4148dispatchPreScrollOzD1aCk));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedFling$1(z, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(f), AndroidViewHolder_androidKt.access$toComposeVelocity(f2)), null), 3, null);
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float f, float f2) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(f), AndroidViewHolder_androidKt.access$toComposeVelocity(f2)), null), 3, null);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        View view = this.view;
        return view != null ? view.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }
}
