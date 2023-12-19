package androidx.compose.material3;

import androidx.appcompat.C0032R;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Padding;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.node.ComposeUiNode;
import androidx.compose.p002ui.platform.CompositionLocals;
import androidx.compose.p002ui.platform.ViewConfiguration;
import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(m41d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a©\u0001\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a8\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m40d2 = {"DialogMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDialogMaxWidth", "()F", "F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m39k = 2, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.material3.AlertDialogKt */
/* loaded from: classes.dex */
public final class AlertDialog {
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    private static final float DialogMinWidth = C0780Dp.m5351constructorimpl(280);
    private static final float DialogMaxWidth = C0780Dp.m5351constructorimpl(560);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012f  */
    /* renamed from: AlertDialogContent-4hvqGtA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1206AlertDialogContent4hvqGtA(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.p002ui.Modifier r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, final androidx.compose.p002ui.graphics.Shape r30, final long r31, final float r33, final long r34, final long r36, final long r38, final long r40, androidx.compose.runtime.Composer r42, final int r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialog.m1206AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1207AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)129@4728L3185:AlertDialog.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:124)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1
                @Override // androidx.compose.p002ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo313measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    Ref.IntRef intRef;
                    Ref.IntRef intRef2;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    Ref.IntRef intRef4 = new Ref.IntRef();
                    ArrayList arrayList6 = new ArrayList();
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    for (Measurable measurable : measurables) {
                        Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(j);
                        Ref.IntRef intRef7 = intRef6;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList6, intRef5, Layout, f, j, mo4376measureBRTryo0)) {
                            intRef = intRef5;
                            intRef2 = intRef4;
                            arrayList = arrayList5;
                            arrayList2 = arrayList6;
                        } else {
                            intRef = intRef5;
                            ArrayList arrayList7 = arrayList5;
                            arrayList = arrayList5;
                            arrayList2 = arrayList6;
                            intRef2 = intRef4;
                            measure_3p2s80s$startNewSequence(arrayList3, intRef4, Layout, f2, arrayList6, arrayList4, intRef7, arrayList7, intRef3, intRef);
                        }
                        Ref.IntRef intRef8 = intRef;
                        if (!arrayList2.isEmpty()) {
                            intRef8.element += Layout.mo597roundToPx0680j_4(f);
                        }
                        arrayList2.add(mo4376measureBRTryo0);
                        intRef8.element += mo4376measureBRTryo0.getWidth();
                        intRef6 = intRef7;
                        intRef6.element = Math.max(intRef6.element, mo4376measureBRTryo0.getHeight());
                        intRef5 = intRef8;
                        arrayList6 = arrayList2;
                        arrayList5 = arrayList;
                        intRef4 = intRef2;
                    }
                    Ref.IntRef intRef9 = intRef4;
                    final ArrayList arrayList8 = arrayList5;
                    Ref.IntRef intRef10 = intRef5;
                    ArrayList arrayList9 = arrayList6;
                    if (!arrayList9.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList3, intRef9, Layout, f2, arrayList9, arrayList4, intRef6, arrayList8, intRef3, intRef10);
                    }
                    final int max = Math.max(intRef3.element, Constraints.m5309getMinWidthimpl(j));
                    int max2 = Math.max(intRef9.element, Constraints.m5308getMinHeightimpl(j));
                    final float f3 = f;
                    return MeasureScope.layout$default(Layout, max, max2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$measure$1
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
                            MeasureScope measureScope = Layout;
                            float f4 = f3;
                            int i3 = max;
                            List<Integer> list = arrayList8;
                            int i4 = 0;
                            for (Object obj : arrayList3) {
                                int i5 = i4 + 1;
                                if (i4 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                List list2 = (List) obj;
                                int size = list2.size();
                                int[] iArr = new int[size];
                                int i6 = 0;
                                while (i6 < size) {
                                    iArr[i6] = ((Placeable) list2.get(i6)).getWidth() + (i6 < CollectionsKt.getLastIndex(list2) ? measureScope.mo597roundToPx0680j_4(f4) : 0);
                                    i6++;
                                }
                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                int[] iArr2 = new int[size];
                                for (int i7 = 0; i7 < size; i7++) {
                                    iArr2[i7] = 0;
                                }
                                end.arrange(measureScope, i3, iArr, measureScope.getLayoutDirection(), iArr2);
                                int i8 = 0;
                                for (Object obj2 : list2) {
                                    int i9 = i8 + 1;
                                    if (i8 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Placeable.PlacementScope.place$default(layout, (Placeable) obj2, iArr2[i8], list.get(i4).intValue(), 0.0f, 4, null);
                                    i8 = i9;
                                }
                                i4 = i5;
                            }
                        }
                    }, 4, null);
                }

                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                    return list.isEmpty() || (intRef.element + measureScope.mo597roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m5307getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                    List<List<Placeable>> list5 = list;
                    if (!list5.isEmpty()) {
                        intRef.element += measureScope.mo597roundToPx0680j_4(f3);
                    }
                    list5.add(CollectionsKt.toList(list2));
                    list3.add(Integer.valueOf(intRef2.element));
                    list4.add(Integer.valueOf(intRef.element));
                    intRef.element += intRef2.element;
                    intRef3.element = Math.max(intRef3.element, intRef4.element);
                    list2.clear();
                    intRef4.element = 0;
                    intRef2.element = 0;
                }
            };
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocals.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocals.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocals.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Functions<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2496constructorimpl = Updater.m2496constructorimpl(startRestartGroup);
            Updater.m2503setimpl(m2496constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2503setimpl(m2496constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2503setimpl(m2496constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2503setimpl(m2496constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2487boximpl(SkippableUpdater.m2488constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & C0032R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            startRestartGroup.startReplaceableGroup(2058660585);
            content.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                AlertDialog.m1207AlertDialogFlowRowixp7dh8(f, f2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    static {
        float f = 24;
        DialogPadding = Padding.m709PaddingValues0680j_4(C0780Dp.m5351constructorimpl(f));
        float f2 = 16;
        IconPadding = Padding.m713PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C0780Dp.m5351constructorimpl(f2), 7, null);
        TitlePadding = Padding.m713PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C0780Dp.m5351constructorimpl(f2), 7, null);
        TextPadding = Padding.m713PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C0780Dp.m5351constructorimpl(f), 7, null);
    }
}
