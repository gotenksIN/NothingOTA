package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetector;
import androidx.compose.foundation.gestures.TapGestureDetector;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p002ui.platform.CompositionLocals;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m40d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt$clockDial$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$clockDial$2(TimePickerState timePickerState, boolean z) {
        super(3);
        this.$state = timePickerState;
        this.$autoSwitchToMinute = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1(SnapshotState<Float> snapshotState) {
        return snapshotState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(SnapshotState<Float> snapshotState, float f) {
        snapshotState.setValue(Float.valueOf(f));
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        float f;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceableGroup(-1645090088);
        ComposerKt.sourceInformation(composer, "C1245@47844L31,1246@47895L31,1247@47945L43,1248@48005L24,*1249@48066L7,1252@48143L28:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1645090088, i, -1, "androidx.compose.material3.clockDial.<anonymous> (TimePicker.kt:1244)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SnapshotState snapshotState = (SnapshotState) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        SnapshotState snapshotState2 = (SnapshotState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5460boximpl(IntOffset.Companion.m5479getZeronOccac()), null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        SnapshotState snapshotState3 = (SnapshotState) rememberedValue3;
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue4 = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocals.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        f = TimePickerKt.MaxDistance;
        float mo603toPx0680j_4 = ((Density) consume).mo603toPx0680j_4(f);
        Modifier.Companion companion = Modifier.Companion;
        final TimePickerState timePickerState = this.$state;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(timePickerState);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.TimePickerKt$clockDial$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                    m1811invokeozmzZPI(intSize.m5515unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI  reason: not valid java name */
                public final void m1811invokeozmzZPI(long j) {
                    TimePickerState.this.m1827setCentergyyYBs$material3_release(IntSizeKt.m5517getCenterozmzZPI(j));
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) rememberedValue5), new Object[]{this.$state, IntOffset.m5460boximpl(invoke$lambda$7(snapshotState3)), Float.valueOf(mo603toPx0680j_4)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C06452(snapshotState, snapshotState2, coroutineScope, this.$state, mo603toPx0680j_4, this.$autoSwitchToMinute, null)), new Object[]{this.$state, IntOffset.m5460boximpl(invoke$lambda$7(snapshotState3)), Float.valueOf(mo603toPx0680j_4)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C06493(coroutineScope, this.$state, this.$autoSwitchToMinute, mo603toPx0680j_4, snapshotState, snapshotState2, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$4(SnapshotState<Float> snapshotState) {
        return snapshotState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$5(SnapshotState<Float> snapshotState, float f) {
        snapshotState.setValue(Float.valueOf(f));
    }

    private static final long invoke$lambda$7(SnapshotState<IntOffset> snapshotState) {
        return snapshotState.getValue().m5478unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePicker.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$2", m30f = "TimePicker.kt", m29i = {}, m28l = {1255}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2 */
    /* loaded from: classes.dex */
    public static final class C06452 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ float $maxDist;
        final /* synthetic */ SnapshotState<Float> $offsetX$delegate;
        final /* synthetic */ SnapshotState<Float> $offsetY$delegate;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ TimePickerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06452(SnapshotState<Float> snapshotState, SnapshotState<Float> snapshotState2, CoroutineScope coroutineScope, TimePickerState timePickerState, float f, boolean z, Continuation<? super C06452> continuation) {
            super(2, continuation);
            this.$offsetX$delegate = snapshotState;
            this.$offsetY$delegate = snapshotState2;
            this.$scope = coroutineScope;
            this.$state = timePickerState;
            this.$maxDist = f;
            this.$autoSwitchToMinute = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06452 c06452 = new C06452(this.$offsetX$delegate, this.$offsetY$delegate, this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute, continuation);
            c06452.L$0 = obj;
            return c06452;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C06452) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TimePicker.kt */
        @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
        @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$1", m30f = "TimePicker.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
        /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$1 */
        /* loaded from: classes.dex */
        public static final class C06461 extends SuspendLambda implements Function3<TapGestureDetector, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ SnapshotState<Float> $offsetX$delegate;
            final /* synthetic */ SnapshotState<Float> $offsetY$delegate;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C06461(SnapshotState<Float> snapshotState, SnapshotState<Float> snapshotState2, Continuation<? super C06461> continuation) {
                super(3, continuation);
                this.$offsetX$delegate = snapshotState;
                this.$offsetY$delegate = snapshotState2;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(TapGestureDetector tapGestureDetector, Offset offset, Continuation<? super Unit> continuation) {
                return m1812invoked4ec7I(tapGestureDetector, offset.m2629unboximpl(), continuation);
            }

            /* renamed from: invoke-d-4ec7I  reason: not valid java name */
            public final Object m1812invoked4ec7I(TapGestureDetector tapGestureDetector, long j, Continuation<? super Unit> continuation) {
                C06461 c06461 = new C06461(this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                c06461.J$0 = j;
                return c06461.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.J$0;
                    TimePickerKt$clockDial$2.invoke$lambda$2(this.$offsetX$delegate, Offset.m2619getXimpl(j));
                    TimePickerKt$clockDial$2.invoke$lambda$5(this.$offsetY$delegate, Offset.m2620getYimpl(j));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = this.$scope;
                final TimePickerState timePickerState = this.$state;
                final float f = this.$maxDist;
                final boolean z = this.$autoSwitchToMinute;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, null, null, new C06461(this.$offsetX$delegate, this.$offsetY$delegate, null), new Function1<Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                        m1813invokek4lQ0M(offset.m2629unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m1813invokek4lQ0M(long j) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C06481(timePickerState, j, f, z, null), 3, null);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TimePicker.kt */
                    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                    @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1", m30f = "TimePicker.kt", m29i = {}, m28l = {1261}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1 */
                    /* loaded from: classes.dex */
                    public static final class C06481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ boolean $autoSwitchToMinute;
                        final /* synthetic */ long $it;
                        final /* synthetic */ float $maxDist;
                        final /* synthetic */ TimePickerState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C06481(TimePickerState timePickerState, long j, float f, boolean z, Continuation<? super C06481> continuation) {
                            super(2, continuation);
                            this.$state = timePickerState;
                            this.$it = j;
                            this.$maxDist = f;
                            this.$autoSwitchToMinute = z;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06481(this.$state, this.$it, this.$maxDist, this.$autoSwitchToMinute, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C06481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.onTap$material3_release(Offset.m2619getXimpl(this.$it), Offset.m2620getYimpl(this.$it), this.$maxDist, this.$autoSwitchToMinute, this) == coroutine_suspended) {
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
                }, this, 3, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePicker.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$3", m30f = "TimePicker.kt", m29i = {}, m28l = {1266}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3 */
    /* loaded from: classes.dex */
    public static final class C06493 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ float $maxDist;
        final /* synthetic */ SnapshotState<Float> $offsetX$delegate;
        final /* synthetic */ SnapshotState<Float> $offsetY$delegate;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ TimePickerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06493(CoroutineScope coroutineScope, TimePickerState timePickerState, boolean z, float f, SnapshotState<Float> snapshotState, SnapshotState<Float> snapshotState2, Continuation<? super C06493> continuation) {
            super(2, continuation);
            this.$scope = coroutineScope;
            this.$state = timePickerState;
            this.$autoSwitchToMinute = z;
            this.$maxDist = f;
            this.$offsetX$delegate = snapshotState;
            this.$offsetY$delegate = snapshotState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06493 c06493 = new C06493(this.$scope, this.$state, this.$autoSwitchToMinute, this.$maxDist, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
            c06493.L$0 = obj;
            return c06493;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C06493) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = this.$scope;
                final TimePickerState timePickerState = this.$state;
                final boolean z = this.$autoSwitchToMinute;
                final CoroutineScope coroutineScope2 = this.$scope;
                final TimePickerState timePickerState2 = this.$state;
                final float f = this.$maxDist;
                final SnapshotState<Float> snapshotState = this.$offsetX$delegate;
                final SnapshotState<Float> snapshotState2 = this.$offsetY$delegate;
                this.label = 1;
                if (DragGestureDetector.detectDragGestures$default((PointerInputScope) this.L$0, null, new Functions<Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C06511(timePickerState, z, null), 3, null);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TimePicker.kt */
                    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                    @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1", m30f = "TimePicker.kt", m29i = {}, m28l = {1270, 1272}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1 */
                    /* loaded from: classes.dex */
                    public static final class C06511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ boolean $autoSwitchToMinute;
                        final /* synthetic */ TimePickerState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C06511(TimePickerState timePickerState, boolean z, Continuation<? super C06511> continuation) {
                            super(2, continuation);
                            this.$state = timePickerState;
                            this.$autoSwitchToMinute = z;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06511(this.$state, this.$autoSwitchToMinute, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C06511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                if (Selection.m1608equalsimpl0(this.$state.m1825getSelectionJiIwxys$material3_release(), Selection.Companion.m1612getHourJiIwxys()) && this.$autoSwitchToMinute) {
                                    this.$state.m1828setSelectioniHAOin8$material3_release(Selection.Companion.m1613getMinuteJiIwxys());
                                    this.label = 1;
                                    if (this.$state.animateToCurrent$material3_release(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (Selection.m1608equalsimpl0(this.$state.m1825getSelectionJiIwxys$material3_release(), Selection.Companion.m1613getMinuteJiIwxys())) {
                                    this.label = 2;
                                    if (this.$state.settle(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i != 1 && i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.TimePickerKt.clockDial.2.3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                        m1814invokeUv8p0NA(pointerInputChange, offset.m2629unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
                    public final void m1814invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                        Intrinsics.checkNotNullParameter(pointerInputChange, "<anonymous parameter 0>");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C06531(j, timePickerState2, snapshotState, snapshotState2, null), 3, null);
                        timePickerState2.moveSelector$material3_release(TimePickerKt$clockDial$2.invoke$lambda$1(snapshotState), TimePickerKt$clockDial$2.invoke$lambda$4(snapshotState2), f);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TimePicker.kt */
                    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                    @DebugMetadata(m31c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1", m30f = "TimePicker.kt", m29i = {}, m28l = {1279}, m27m = "invokeSuspend", m26n = {}, m25s = {})
                    /* renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1 */
                    /* loaded from: classes.dex */
                    public static final class C06531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ long $dragAmount;
                        final /* synthetic */ SnapshotState<Float> $offsetX$delegate;
                        final /* synthetic */ SnapshotState<Float> $offsetY$delegate;
                        final /* synthetic */ TimePickerState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C06531(long j, TimePickerState timePickerState, SnapshotState<Float> snapshotState, SnapshotState<Float> snapshotState2, Continuation<? super C06531> continuation) {
                            super(2, continuation);
                            this.$dragAmount = j;
                            this.$state = timePickerState;
                            this.$offsetX$delegate = snapshotState;
                            this.$offsetY$delegate = snapshotState2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06531(this.$dragAmount, this.$state, this.$offsetX$delegate, this.$offsetY$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C06531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            float atan;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                SnapshotState<Float> snapshotState = this.$offsetX$delegate;
                                TimePickerKt$clockDial$2.invoke$lambda$2(snapshotState, TimePickerKt$clockDial$2.invoke$lambda$1(snapshotState) + Offset.m2619getXimpl(this.$dragAmount));
                                SnapshotState<Float> snapshotState2 = this.$offsetY$delegate;
                                TimePickerKt$clockDial$2.invoke$lambda$5(snapshotState2, TimePickerKt$clockDial$2.invoke$lambda$4(snapshotState2) + Offset.m2620getYimpl(this.$dragAmount));
                                TimePickerState timePickerState = this.$state;
                                atan = TimePickerKt.atan(TimePickerKt$clockDial$2.invoke$lambda$4(this.$offsetY$delegate) - IntOffset.m5470getYimpl(this.$state.m1824getCenternOccac$material3_release()), TimePickerKt$clockDial$2.invoke$lambda$1(this.$offsetX$delegate) - IntOffset.m5469getXimpl(this.$state.m1824getCenternOccac$material3_release()));
                                this.label = 1;
                                if (TimePickerState.update$material3_release$default(timePickerState, atan, false, this, 2, null) == coroutine_suspended) {
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
                }, this, 5, null) == coroutine_suspended) {
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
}
