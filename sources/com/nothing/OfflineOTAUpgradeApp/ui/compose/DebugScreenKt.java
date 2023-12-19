package com.nothing.OfflineOTAUpgradeApp.ui.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugScreen.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\b\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\t\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"DebugScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "isEnableMockBuild", "", "mockBuildNumber", "", "printDebugLog", "showScreenState", "onEnableDebugMode", "Lkotlin/Function1;", "onApplyBuildNumber", "onPrintDebugLog", "onShowScreenState", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "viewModel", "Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModel;", "(Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DebugScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "NothingOfflineOtaUpdate_nothingRelease", "buildNumber", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DebugScreen(com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt.DebugScreen(com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DebugScreen(androidx.compose.ui.Modifier r46, final boolean r47, final java.lang.String r48, final boolean r49, final boolean r50, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r51, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r52, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r53, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 2330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt.DebugScreen(androidx.compose.ui.Modifier, boolean, java.lang.String, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue DebugScreen$lambda$5(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final void DebugScreenPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1772320448);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebugScreenPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772320448, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenPreview (DebugScreen.kt:147)");
            }
            DebugScreen(null, false, "Spacewar-T2.0-230902-0109", false, false, new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt$DebugScreenPreview$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }, new Function1<String, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt$DebugScreenPreview$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            }, new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt$DebugScreenPreview$3
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }, new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt$DebugScreenPreview$4
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }, startRestartGroup, 115043760, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt$DebugScreenPreview$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                DebugScreenKt.DebugScreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final boolean DebugScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String DebugScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final boolean DebugScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean DebugScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
