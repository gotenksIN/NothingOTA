package com.nothing.OfflineOTAUpgradeApp.ui.compose.stage;

import androidx.appcompat.R;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.DotLinerKt;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.StylesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StageInstallingContent.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"StageInstallingCompleteContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "stageInstalling", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallComplete;", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallComplete;Landroidx/compose/runtime/Composer;II)V", "StageInstallingContent", "buildNumber", "", NotificationCompat.CATEGORY_PROGRESS, "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;DLandroidx/compose/runtime/Composer;II)V", "StageInstallingPausedContent", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingPaused;", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingPaused;Landroidx/compose/runtime/Composer;II)V", "StageInstallingRunningContent", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingRunning;", "(Landroidx/compose/ui/Modifier;Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage$StageInstallingRunning;Landroidx/compose/runtime/Composer;II)V", "NothingOfflineOtaUpdate_nothingRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StageInstallingContentKt {
    public static final void StageInstallingRunningContent(final Modifier modifier, final UpdateStage.StageInstallingRunning stageInstalling, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(stageInstalling, "stageInstalling");
        Composer startRestartGroup = composer.startRestartGroup(-24975566);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingRunningContent)");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(stageInstalling) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-24975566, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingRunningContent (StageInstallingContent.kt:22)");
            }
            StageInstallingContent(modifier, stageInstalling.getBuildNumber(), stageInstalling.getProgress(), startRestartGroup, i3 & 14, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContentKt$StageInstallingRunningContent$1
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

            public final void invoke(Composer composer2, int i5) {
                StageInstallingContentKt.StageInstallingRunningContent(Modifier.this, stageInstalling, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void StageInstallingPausedContent(final Modifier modifier, final UpdateStage.StageInstallingPaused stageInstalling, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(stageInstalling, "stageInstalling");
        Composer startRestartGroup = composer.startRestartGroup(177849676);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingPausedContent)");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(stageInstalling) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(177849676, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingPausedContent (StageInstallingContent.kt:30)");
            }
            StageInstallingContent(modifier, stageInstalling.getBuildNumber(), stageInstalling.getProgress(), startRestartGroup, i3 & 14, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContentKt$StageInstallingPausedContent$1
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

            public final void invoke(Composer composer2, int i5) {
                StageInstallingContentKt.StageInstallingPausedContent(Modifier.this, stageInstalling, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void StageInstallingCompleteContent(final Modifier modifier, final UpdateStage.StageInstallComplete stageInstalling, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(stageInstalling, "stageInstalling");
        Composer startRestartGroup = composer.startRestartGroup(1937148934);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingCompleteContent)");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(stageInstalling) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1937148934, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingCompleteContent (StageInstallingContent.kt:38)");
            }
            StageInstallingContent(modifier, stageInstalling.getBuildNumber(), 100.0d, startRestartGroup, (i3 & 14) | 384, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContentKt$StageInstallingCompleteContent$1
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

            public final void invoke(Composer composer2, int i5) {
                StageInstallingContentKt.StageInstallingCompleteContent(Modifier.this, stageInstalling, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    public static final void StageInstallingContent(Modifier modifier, final String buildNumber, final double d, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Intrinsics.checkNotNullParameter(buildNumber, "buildNumber");
        Composer startRestartGroup = composer.startRestartGroup(424737623);
        ComposerKt.sourceInformation(startRestartGroup, "C(StageInstallingContent)P(1)");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 14) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(buildNumber) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(d) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424737623, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContent (StageInstallingContent.kt:47)");
            }
            Modifier m416paddingVpY3zN4 = PaddingKt.m416paddingVpY3zN4(companion, Dp.m5050constructorimpl(24), Dp.m5050constructorimpl(16));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m416paddingVpY3zN4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifier2 = companion;
            TextKt.m1484Text4IGK_g(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.stage_installing_title, startRestartGroup, 6), (Modifier) null, ColorResources_androidKt.colorResource(com.nothing.OfflineOTAUpgradeApp.R.color.subtitle1_text, startRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, StylesKt.getSubtitle1Style(), startRestartGroup, 0, 1572864, 65530);
            TextKt.m1484Text4IGK_g(StringResources_androidKt.stringResource(com.nothing.OfflineOTAUpgradeApp.R.string.stage_installing_content_format, new Object[]{buildNumber}, startRestartGroup, 70), (Modifier) null, ColorResources_androidKt.colorResource(com.nothing.OfflineOTAUpgradeApp.R.color.subtitle2_text, startRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, StylesKt.getSubtitle2Style(), startRestartGroup, 0, 1572864, 65530);
            int i5 = (int) (23 * d);
            DotLinerKt.DotLiner(PaddingKt.m419paddingqDBjuR0$default(Modifier.Companion, 0.0f, PrimitiveResources_androidKt.dimensionResource(com.nothing.OfflineOTAUpgradeApp.R.dimen.updating_dot_liner_top_padding, startRestartGroup, 6), 0.0f, 0.0f, 13, null), 23, 0, i5, i5 == 22, startRestartGroup, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj = modifier2;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = obj;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.compose.stage.StageInstallingContentKt$StageInstallingContent$2
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

            public final void invoke(Composer composer2, int i6) {
                StageInstallingContentKt.StageInstallingContent(Modifier.this, buildNumber, d, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
