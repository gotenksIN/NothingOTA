package androidx.compose.p002ui.input.pointer;

import androidx.appcompat.C0032R;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.platform.CompositionLocals;
import androidx.compose.p002ui.platform.InspectableValueKt;
import androidx.compose.p002ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerIcon.kt */
@Metadata(m41d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m40d2 = {"pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "ui_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.input.pointer.PointerIconKt */
/* loaded from: classes.dex */
public final class PointerIconKt {
    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z);
    }

    public static final Modifier pointerHoverIcon(Modifier modifier, final PointerIcon icon, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("pointerHoverIcon");
                inspectorInfo.getProperties().set("icon", PointerIcon.this);
                inspectorInfo.getProperties().set("overrideDescendants", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Modifier.Companion pointerInput;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(811087536);
                ComposerKt.sourceInformation(composer, "C79@2743L7:PointerIcon.kt#a556rk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(811087536, i, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:78)");
                }
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocals.getLocalPointerIconService());
                ComposerKt.sourceInformationMarkerEnd(composer);
                PointerIconService pointerIconService = (PointerIconService) consume;
                if (pointerIconService == null) {
                    pointerInput = Modifier.Companion;
                } else {
                    pointerInput = SuspendingPointerInputFilterKt.pointerInput(composed, PointerIcon.this, Boolean.valueOf(z), new C06911(z, pointerIconService, PointerIcon.this, null));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return pointerInput;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: PointerIcon.kt */
            @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
            @DebugMetadata(m31c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", m30f = "PointerIcon.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_listPreferredItemPaddingStart}, m27m = "invokeSuspend", m26n = {}, m25s = {})
            /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1 */
            /* loaded from: classes.dex */
            public static final class C06911 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerIcon $icon;
                final /* synthetic */ boolean $overrideDescendants;
                final /* synthetic */ PointerIconService $pointerIconService;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C06911(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super C06911> continuation) {
                    super(2, continuation);
                    this.$overrideDescendants = z;
                    this.$pointerIconService = pointerIconService;
                    this.$icon = pointerIcon;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C06911 c06911 = new C06911(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
                    c06911.L$0 = obj;
                    return c06911;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C06911) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: PointerIcon.kt */
                @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
                @DebugMetadata(m31c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1", m30f = "PointerIcon.kt", m29i = {0}, m28l = {C0032R.styleable.AppCompatTheme_radioButtonStyle}, m27m = "invokeSuspend", m26n = {"$this$awaitPointerEventScope"}, m25s = {"L$0"})
                /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1 */
                /* loaded from: classes.dex */
                public static final class C06921 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PointerIcon $icon;
                    final /* synthetic */ boolean $overrideDescendants;
                    final /* synthetic */ PointerIconService $pointerIconService;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C06921(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super C06921> continuation) {
                        super(2, continuation);
                        this.$overrideDescendants = z;
                        this.$pointerIconService = pointerIconService;
                        this.$icon = pointerIcon;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C06921 c06921 = new C06921(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
                        c06921.L$0 = obj;
                        return c06921;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C06921) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003e -> B:17:0x0043). Please submit an issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                        /*
                            r11 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r11.label
                            r2 = 1
                            if (r1 == 0) goto L1e
                            if (r1 != r2) goto L16
                            java.lang.Object r1 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r1
                            kotlin.ResultKt.throwOnFailure(r12)
                            r3 = r1
                            r1 = r0
                            r0 = r11
                            goto L43
                        L16:
                            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r12.<init>(r0)
                            throw r12
                        L1e:
                            kotlin.ResultKt.throwOnFailure(r12)
                            java.lang.Object r12 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r12
                            r1 = r12
                            r12 = r11
                        L27:
                            boolean r3 = r12.$overrideDescendants
                            if (r3 == 0) goto L2e
                            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.p002ui.input.pointer.PointerEventPass.Main
                            goto L30
                        L2e:
                            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.p002ui.input.pointer.PointerEventPass.Initial
                        L30:
                            r4 = r12
                            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                            r12.L$0 = r1
                            r12.label = r2
                            java.lang.Object r3 = r1.awaitPointerEvent(r3, r4)
                            if (r3 != r0) goto L3e
                            return r0
                        L3e:
                            r10 = r0
                            r0 = r12
                            r12 = r3
                            r3 = r1
                            r1 = r10
                        L43:
                            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.p002ui.input.pointer.PointerEvent) r12
                            int r4 = r12.m4203getType7fucELk()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.p002ui.input.pointer.PointerEventType.Companion
                            int r5 = r5.m4218getRelease7fucELk()
                            boolean r4 = androidx.compose.p002ui.input.pointer.PointerEventType.m4210equalsimpl0(r4, r5)
                            r5 = 0
                            if (r4 == 0) goto L71
                            java.util.List r4 = r12.getChanges()
                            java.lang.Object r4 = r4.get(r5)
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r4
                            long r6 = r3.mo4174getSizeYbymL2g()
                            androidx.compose.ui.geometry.Size$Companion r8 = androidx.compose.p002ui.geometry.Size.Companion
                            long r8 = r8.m2697getZeroNHjbRc()
                            boolean r4 = androidx.compose.p002ui.input.pointer.PointerEventKt.m4206isOutOfBoundsjwHxaWs(r4, r6, r8)
                            if (r4 == 0) goto L71
                            r5 = r2
                        L71:
                            int r12 = r12.m4203getType7fucELk()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.p002ui.input.pointer.PointerEventType.Companion
                            int r4 = r4.m4215getExit7fucELk()
                            boolean r12 = androidx.compose.p002ui.input.pointer.PointerEventType.m4210equalsimpl0(r12, r4)
                            if (r12 != 0) goto L8a
                            if (r5 != 0) goto L8a
                            androidx.compose.ui.input.pointer.PointerIconService r12 = r0.$pointerIconService
                            androidx.compose.ui.input.pointer.PointerIcon r4 = r0.$icon
                            r12.setCurrent(r4)
                        L8a:
                            r12 = r0
                            r0 = r1
                            r1 = r3
                            goto L27
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.input.pointer.PointerIconKt$pointerHoverIcon$2.C06911.C06921.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (((PointerInputScope) this.L$0).awaitPointerEventScope(new C06921(this.$overrideDescendants, this.$pointerIconService, this.$icon, null), this) == coroutine_suspended) {
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
        });
    }
}
