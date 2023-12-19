package com.nothing.OfflineOTAUpgradeApp.p007ui;

import androidx.compose.foundation.layout.Padding;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AppBar;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.res.ColorResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapter;
import androidx.profileinstaller.ProfileVerifier;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import com.nothing.OfflineOTAUpgradeApp.p007ui.compose.UpdatingScreen;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import com.nothing.OfflineOTAUpgradeApp.util.UtilsKt;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OTAUpdateActivity.kt */
@Metadata(m41d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m40d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$setView$1 */
/* loaded from: classes2.dex */
public final class OTAUpdateActivity$setView$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ OTAUpdateActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTAUpdateActivity$setView$1(OTAUpdateActivity oTAUpdateActivity) {
        super(2);
        this.this$0 = oTAUpdateActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        OTAUpdateViewModel oTAUpdateViewModel;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290780290, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.<anonymous> (OTAUpdateActivity.kt:208)");
            }
            oTAUpdateViewModel = this.this$0.viewModel;
            if (oTAUpdateViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                oTAUpdateViewModel = null;
            }
            final State observeAsState = LiveDataAdapter.observeAsState(oTAUpdateViewModel.getUpdateStageLive(), new UpdateStage.StageCurrentVersion(""), composer, (UpdateStage.StageCurrentVersion.$stable << 3) | 8);
            final OTAUpdateActivity oTAUpdateActivity = this.this$0;
            ScaffoldKt.m1589ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(composer, -426265278, true, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$setView$1.1
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

                public final void invoke(Composer composer2, int i2) {
                    if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-426265278, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.<anonymous>.<anonymous> (OTAUpdateActivity.kt:211)");
                        }
                        TopAppBarColors m1909topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m1909topAppBarColorszjMxDiM(ColorResources_androidKt.colorResource(C1640R.color.updating_screen_background, composer2, 6), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 15, 30);
                        Function2<Composer, Integer, Unit> m5622getLambda1$NothingOfflineOtaUpdate_nothingRelease = ComposableSingletons$OTAUpdateActivityKt.INSTANCE.m5622getLambda1$NothingOfflineOtaUpdate_nothingRelease();
                        final State<UpdateStage> state = observeAsState;
                        final OTAUpdateActivity oTAUpdateActivity2 = oTAUpdateActivity;
                        final OTAUpdateActivity oTAUpdateActivity3 = oTAUpdateActivity;
                        final State<UpdateStage> state2 = observeAsState;
                        AppBar.TopAppBar(m5622getLambda1$NothingOfflineOtaUpdate_nothingRelease, null, ComposableLambdaKt.composableLambda(composer2, -1790762436, true, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i3) {
                                if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1790762436, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.<anonymous>.<anonymous>.<anonymous> (OTAUpdateActivity.kt:247)");
                                    }
                                    if (OTAUpdateActivity$setView$1.invoke$lambda$0(state) instanceof UpdateStage.StageUpToDate) {
                                        final OTAUpdateActivity oTAUpdateActivity4 = oTAUpdateActivity2;
                                        IconButtonKt.IconButton(new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.1.1.1.1
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
                                                OTAUpdateViewModel oTAUpdateViewModel2;
                                                oTAUpdateViewModel2 = OTAUpdateActivity.this.viewModel;
                                                if (oTAUpdateViewModel2 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                    oTAUpdateViewModel2 = null;
                                                }
                                                oTAUpdateViewModel2.navigateUp();
                                            }
                                        }, null, false, null, null, ComposableSingletons$OTAUpdateActivityKt.INSTANCE.m5623getLambda2$NothingOfflineOtaUpdate_nothingRelease(), composer3, ProfileVerifier.CompilationStatus.f184xf2722a21, 30);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(composer2, 726197683, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                invoke(rowScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TopAppBar, Composer composer3, int i3) {
                                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                                if ((i3 & 81) != 16 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(726197683, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.<anonymous>.<anonymous>.<anonymous> (OTAUpdateActivity.kt:217)");
                                    }
                                    final OTAUpdateActivity oTAUpdateActivity4 = OTAUpdateActivity.this;
                                    IconButtonKt.IconButton(new Functions<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.1.1.2.1
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
                                            Utils.INSTANCE.goToUrl(OTAUpdateActivity.this, UtilsKt.NOTHING_PRIVACY_POLICY_URL);
                                        }
                                    }, null, false, null, null, ComposableSingletons$OTAUpdateActivityKt.INSTANCE.m5624getLambda3$NothingOfflineOtaUpdate_nothingRelease(), composer3, ProfileVerifier.CompilationStatus.f184xf2722a21, 30);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }

                            /* compiled from: OTAUpdateActivity.kt */
                            @Metadata(m41d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m40d2 = {"<anonymous>", "", "invoke"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
                            /* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$setView$1$1$2$2 */
                            /* loaded from: classes2.dex */
                            static final class C16662 extends Lambda implements Functions<Unit> {
                                final /* synthetic */ OTAUpdateActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C16662(OTAUpdateActivity oTAUpdateActivity) {
                                    super(0);
                                    this.this$0 = oTAUpdateActivity;
                                }

                                @Override // kotlin.jvm.functions.Functions
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.this$0.startActivity(DebugActivity.Companion.newIntent(this.this$0));
                                }
                            }
                        }), null, m1909topAppBarColorszjMxDiM, null, composer2, 3462, 82);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), null, null, null, 0, ColorResources_androidKt.colorResource(C1640R.color.updating_screen_background, composer, 6), 0L, null, ComposableLambdaKt.composableLambda(composer, 1608292813, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$setView$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                    invoke(paddingValues, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                    if ((i2 & 14) == 0) {
                        i2 |= composer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((i2 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1608292813, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity.setView.<anonymous>.<anonymous> (OTAUpdateActivity.kt:268)");
                        }
                        UpdatingScreen.UpdatingScreen(null, Padding.padding(Modifier.Companion, paddingValues), OTAUpdateActivity$setView$1.invoke$lambda$0(observeAsState), composer2, UpdateStage.$stable << 6, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composer, 805306416, 445);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateStage invoke$lambda$0(State<? extends UpdateStage> state) {
        return state.getValue();
    }
}
