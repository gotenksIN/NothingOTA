package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.C0032R;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.semantics.CollectionInfo;
import androidx.compose.p002ui.semantics.ScrollAxisRange;
import androidx.compose.p002ui.semantics.SemanticsModifierKt;
import androidx.compose.p002ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p002ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutSemantics.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m40d2 = {"lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutSemanticsKt {
    public static final Modifier lazyLayoutSemantics(Modifier modifier, final LazyLayoutItemProvider itemProvider, final LazyLayoutSemantics state, Orientation orientation, boolean z, boolean z2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        composer.startReplaceableGroup(290103779);
        ComposerKt.sourceInformation(composer, "C(lazyLayoutSemantics)P(!1,3!1,4)46@1895L24,48@1950L3445:LazyLayoutSemantics.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290103779, i, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:39)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Object[] objArr = {itemProvider, state, orientation, Boolean.valueOf(z)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z3 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            final boolean z4 = orientation == Orientation.Vertical;
            final Function1<Object, Integer> function1 = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object needle) {
                    Intrinsics.checkNotNullParameter(needle, "needle");
                    int itemCount = LazyLayoutItemProvider.this.getItemCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= itemCount) {
                            i3 = -1;
                            break;
                        } else if (Intrinsics.areEqual(LazyLayoutItemProvider.this.getKey(i3), needle)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    return Integer.valueOf(i3);
                }
            };
            final ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Functions<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Functions
                public final Float invoke() {
                    return Float.valueOf(LazyLayoutSemantics.this.getCurrentPosition());
                }
            }, new Functions<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Functions
                public final Float invoke() {
                    float currentPosition;
                    if (LazyLayoutSemantics.this.getCanScrollForward()) {
                        currentPosition = itemProvider.getItemCount() + 1.0f;
                    } else {
                        currentPosition = LazyLayoutSemantics.this.getCurrentPosition();
                    }
                    return Float.valueOf(currentPosition);
                }
            }, z2);
            final Function2<Float, Float, Boolean> function2 = z ? new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                public final Boolean invoke(float f, float f2) {
                    if (z4) {
                        f = f2;
                    }
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03511(state, f, null), 3, null);
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: LazyLayoutSemantics.kt */
                @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                @DebugMetadata(m31c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1", m30f = "LazyLayoutSemantics.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_seekBarStyle}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1 */
                /* loaded from: classes.dex */
                public static final class C03511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $delta;
                    final /* synthetic */ LazyLayoutSemantics $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03511(LazyLayoutSemantics lazyLayoutSemantics, float f, Continuation<? super C03511> continuation) {
                        super(2, continuation);
                        this.$state = lazyLayoutSemantics;
                        this.$delta = f;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C03511(this.$state, this.$delta, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C03511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$state.animateScrollBy(this.$delta, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
            } : null;
            final Function1<Integer, Boolean> function12 = z ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Boolean invoke(int i3) {
                    boolean z5 = i3 >= 0 && i3 < LazyLayoutItemProvider.this.getItemCount();
                    LazyLayoutItemProvider lazyLayoutItemProvider = LazyLayoutItemProvider.this;
                    if (z5) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03532(state, i3, null), 3, null);
                        return true;
                    }
                    throw new IllegalArgumentException(("Can't scroll to index " + i3 + ", it is out of bounds [0, " + lazyLayoutItemProvider.getItemCount() + ')').toString());
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: LazyLayoutSemantics.kt */
                @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                @DebugMetadata(m31c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", m30f = "LazyLayoutSemantics.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2 */
                /* loaded from: classes.dex */
                public static final class C03532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $index;
                    final /* synthetic */ LazyLayoutSemantics $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03532(LazyLayoutSemantics lazyLayoutSemantics, int i, Continuation<? super C03532> continuation) {
                        super(2, continuation);
                        this.$state = lazyLayoutSemantics;
                        this.$index = i;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C03532(this.$state, this.$index, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C03532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$state.scrollToItem(this.$index, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
            } : null;
            final CollectionInfo collectionInfo = state.collectionInfo();
            rememberedValue2 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.indexForKey(semantics, function1);
                    if (z4) {
                        SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, scrollAxisRange);
                    } else {
                        SemanticsPropertiesKt.setHorizontalScrollAxisRange(semantics, scrollAxisRange);
                    }
                    Function2<Float, Float, Boolean> function22 = function2;
                    if (function22 != null) {
                        SemanticsPropertiesKt.scrollBy$default(semantics, null, function22, 1, null);
                    }
                    Function1<Integer, Boolean> function13 = function12;
                    if (function13 != null) {
                        SemanticsPropertiesKt.scrollToIndex$default(semantics, null, function13, 1, null);
                    }
                    SemanticsPropertiesKt.setCollectionInfo(semantics, collectionInfo);
                }
            }, 1, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
