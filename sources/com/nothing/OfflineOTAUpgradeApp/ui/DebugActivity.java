package com.nothing.OfflineOTAUpgradeApp.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.profileinstaller.ProfileVerifier;
import com.nothing.OfflineOTAUpgradeApp.MainApplication;
import com.nothing.OfflineOTAUpgradeApp.R;
import com.nothing.OfflineOTAUpgradeApp.ui.compose.DebugScreenKt;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModel;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.DebugViewModelFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/ui/DebugActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_viewModel", "Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/DebugViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpViewModel", "setView", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugActivity extends AppCompatActivity {
    private DebugViewModel _viewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DebugActivity";

    /* compiled from: DebugActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/ui/DebugActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "newIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, DebugActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setUpViewModel();
        setView();
    }

    private final void setUpViewModel() {
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.nothing.OfflineOTAUpgradeApp.MainApplication");
        this._viewModel = (DebugViewModel) new ViewModelProvider(this, new DebugViewModelFactory(Utils.INSTANCE, ((MainApplication) application).getDebugRepository())).get(DebugViewModel.class);
    }

    private final void setView() {
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1238620478, true, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity$setView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1238620478, i, -1, "com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.<anonymous> (DebugActivity.kt:59)");
                    }
                    final DebugActivity debugActivity = DebugActivity.this;
                    long colorResource = ColorResources_androidKt.colorResource(R.color.updating_screen_background, composer, 6);
                    final DebugActivity debugActivity2 = DebugActivity.this;
                    ScaffoldKt.m1288ScaffoldTvnljyQ(null, ComposableLambdaKt.composableLambda(composer, 1113097986, true, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity$setView$1.1
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
                                    ComposerKt.traceEventStart(1113097986, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.<anonymous>.<anonymous> (DebugActivity.kt:61)");
                                }
                                TopAppBarColors m1608topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m1608topAppBarColorszjMxDiM(ColorResources_androidKt.colorResource(R.color.updating_screen_background, composer2, 6), 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 15, 30);
                                Function2<Composer, Integer, Unit> m5342getLambda1$NothingOfflineOtaUpdate_nothingRelease = ComposableSingletons$DebugActivityKt.INSTANCE.m5342getLambda1$NothingOfflineOtaUpdate_nothingRelease();
                                final DebugActivity debugActivity3 = DebugActivity.this;
                                AppBarKt.TopAppBar(m5342getLambda1$NothingOfflineOtaUpdate_nothingRelease, null, ComposableLambdaKt.composableLambda(composer2, 412454396, true, new Function2<Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.1.1.1
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
                                                ComposerKt.traceEventStart(412454396, i3, -1, "com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.<anonymous>.<anonymous>.<anonymous> (DebugActivity.kt:69)");
                                            }
                                            final DebugActivity debugActivity4 = DebugActivity.this;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.1.1.1.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    DebugActivity.this.finish();
                                                }
                                            }, null, false, null, null, ComposableSingletons$DebugActivityKt.INSTANCE.m5343getLambda2$NothingOfflineOtaUpdate_nothingRelease(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), null, null, m1608topAppBarColorszjMxDiM, null, composer2, 390, 90);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), null, null, null, 0, colorResource, 0L, null, ComposableLambdaKt.composableLambda(composer, 344204941, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity$setView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                            invoke(paddingValues, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) {
                            DebugViewModel debugViewModel;
                            Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                            if ((i2 & 14) == 0) {
                                i2 |= composer2.changed(paddingValues) ? 4 : 2;
                            }
                            if ((i2 & 91) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(344204941, i2, -1, "com.nothing.OfflineOTAUpgradeApp.ui.DebugActivity.setView.<anonymous>.<anonymous> (DebugActivity.kt:86)");
                                }
                                debugViewModel = DebugActivity.this._viewModel;
                                if (debugViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("_viewModel");
                                    debugViewModel = null;
                                }
                                DebugScreenKt.DebugScreen(debugViewModel, PaddingKt.padding(Modifier.Companion, paddingValues), composer2, 8, 0);
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
        }), 1, null);
    }
}
