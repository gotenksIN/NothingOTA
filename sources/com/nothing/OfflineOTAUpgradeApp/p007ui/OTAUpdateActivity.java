package com.nothing.OfflineOTAUpgradeApp.p007ui;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
import com.nothing.OfflineOTAUpgradeApp.MainApplication;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
import com.nothing.OfflineOTAUpgradeApp.state.ToastBundle;
import com.nothing.OfflineOTAUpgradeApp.util.Event;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel;
import com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModelFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: OTAUpdateActivity.kt */
@Metadata(m41d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002*\u0001\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/ui/OTAUpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "browserResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onBackPressedCallback", "com/nothing/OfflineOTAUpgradeApp/ui/OTAUpdateActivity$onBackPressedCallback$1", "Lcom/nothing/OfflineOTAUpgradeApp/ui/OTAUpdateActivity$onBackPressedCallback$1;", "viewModel", "Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;", "checkIsAuthorizedUser", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setUpStatusBar", "setUpViewModel", "setView", "Companion", "NothingOfflineOtaUpdate_nothingRelease", "updateStage", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity */
/* loaded from: classes2.dex */
public final class OTAUpdateActivity extends AppCompatActivity {
    public static final String SETTINGS_SEARCH_INTENT = "com.nothing.settings.search.action.OTAUpdate";
    private final ActivityResultLauncher<Intent> browserResultLauncher;
    private final OTAUpdateActivity$onBackPressedCallback$1 onBackPressedCallback;
    private OTAUpdateViewModel viewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "OTAUpdateActivity";

    /* JADX WARN: Type inference failed for: r0v3, types: [com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$onBackPressedCallback$1] */
    public OTAUpdateActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OTAUpdateActivity.browserResultLauncher$lambda$1(OTAUpdateActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.browserResultLauncher = registerForActivityResult;
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$onBackPressedCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                OTAUpdateViewModel oTAUpdateViewModel;
                String str;
                oTAUpdateViewModel = OTAUpdateActivity.this.viewModel;
                if (oTAUpdateViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    oTAUpdateViewModel = null;
                }
                if (oTAUpdateViewModel.isInstalling()) {
                    try {
                        OTAUpdateActivity.this.startActivity(Utils.INSTANCE.getHomeIntent());
                        return;
                    } catch (Exception e) {
                        str = OTAUpdateActivity.TAG;
                        Log.w(str, "Fail to go to home", e);
                        return;
                    }
                }
                OTAUpdateActivity.this.finish();
            }
        };
    }

    /* compiled from: OTAUpdateActivity.kt */
    @Metadata(m41d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/ui/OTAUpdateActivity$Companion;", "", "()V", "SETTINGS_SEARCH_INTENT", "", "TAG", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$Companion */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void browserResultLauncher$lambda$1(OTAUpdateActivity this$0, ActivityResult activityResult) {
        Intent data;
        Uri data2;
        String str = "";
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (data2 = data.getData()) == null) {
            return;
        }
        try {
            String documentId = DocumentsContract.getDocumentId(data2);
            Intrinsics.checkNotNull(documentId);
            List<String> split = new Regex(":").split(documentId, 0);
            if (StringsKt.equals("primary", split.get(0), true)) {
                str = split.get(1);
            }
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Fail to parse OTA file id", e);
        }
        OTAUpdateViewModel oTAUpdateViewModel = this$0.viewModel;
        if (oTAUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel = null;
        }
        oTAUpdateViewModel.onBrowseOTAFile(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, this.onBackPressedCallback);
        setUpStatusBar();
        setUpViewModel();
        setView();
        OTAUpdateViewModel oTAUpdateViewModel = this.viewModel;
        if (oTAUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel = null;
        }
        oTAUpdateViewModel.init();
        checkIsAuthorizedUser();
    }

    private final void setUpStatusBar() {
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(getColor(C1640R.color.updating_screen_background));
            window.setNavigationBarColor(getColor(C1640R.color.updating_screen_background));
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(findViewById);
        if (windowInsetsController != null) {
            boolean isSystemInDarkTheme = Utils.INSTANCE.isSystemInDarkTheme(this);
            windowInsetsController.setAppearanceLightStatusBars(!isSystemInDarkTheme);
            windowInsetsController.setAppearanceLightNavigationBars(!isSystemInDarkTheme);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OTAUpdateViewModel oTAUpdateViewModel = this.viewModel;
        if (oTAUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel = null;
        }
        oTAUpdateViewModel.deInit();
    }

    private final void setUpViewModel() {
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.nothing.OfflineOTAUpgradeApp.MainApplication");
        MainApplication mainApplication = (MainApplication) application;
        UpdateManager updateManager = mainApplication.getUpdateManager();
        final Utils utils = Utils.INSTANCE;
        OTAUpdateViewModel oTAUpdateViewModel = (OTAUpdateViewModel) new ViewModelProvider(this, new OTAUpdateViewModelFactory(updateManager, mainApplication.getUpdateUtils(), utils, mainApplication.getOtaPrefs(), mainApplication.getRepoContainer().getRemoteRepository(), mainApplication.getDebugRepository())).get(OTAUpdateViewModel.class);
        this.viewModel = oTAUpdateViewModel;
        OTAUpdateViewModel oTAUpdateViewModel2 = null;
        if (oTAUpdateViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel = null;
        }
        OTAUpdateActivity oTAUpdateActivity = this;
        oTAUpdateViewModel.getLaunchBrowseEventLive().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$6(OTAUpdateActivity.this, (Event) obj);
            }
        });
        OTAUpdateViewModel oTAUpdateViewModel3 = this.viewModel;
        if (oTAUpdateViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel3 = null;
        }
        oTAUpdateViewModel3.getShowToastEventList().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$8(OTAUpdateActivity.this, (Event) obj);
            }
        });
        OTAUpdateViewModel oTAUpdateViewModel4 = this.viewModel;
        if (oTAUpdateViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel4 = null;
        }
        oTAUpdateViewModel4.getRebootEventLive().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$10(OTAUpdateActivity.this, (Event) obj);
            }
        });
        OTAUpdateViewModel oTAUpdateViewModel5 = this.viewModel;
        if (oTAUpdateViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel5 = null;
        }
        oTAUpdateViewModel5.getCheckNetworkLive().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$12(Utils.this, this, (Event) obj);
            }
        });
        OTAUpdateViewModel oTAUpdateViewModel6 = this.viewModel;
        if (oTAUpdateViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel6 = null;
        }
        oTAUpdateViewModel6.getFinishActivityEventLive().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$14(OTAUpdateActivity.this, (Event) obj);
            }
        });
        OTAUpdateViewModel oTAUpdateViewModel7 = this.viewModel;
        if (oTAUpdateViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            oTAUpdateViewModel2 = oTAUpdateViewModel7;
        }
        oTAUpdateViewModel2.isInstallingLive().observe(oTAUpdateActivity, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.OTAUpdateActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateActivity.setUpViewModel$lambda$15(OTAUpdateActivity.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$6(OTAUpdateActivity this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) event.getContentIfNotHandled();
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/Documents"), "*/*");
        this$0.browserResultLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$8(OTAUpdateActivity this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ToastBundle toastBundle = (ToastBundle) event.getContentIfNotHandled();
        if (toastBundle != null) {
            OTAUpdateActivity oTAUpdateActivity = this$0;
            Toast.makeText(oTAUpdateActivity, toastBundle.getMessage(oTAUpdateActivity), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$10(OTAUpdateActivity this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) event.getContentIfNotHandled();
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        Object systemService = this$0.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        ((PowerManager) systemService).reboot(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$12(Utils utils, OTAUpdateActivity this$0, Event event) {
        Intrinsics.checkNotNullParameter(utils, "$utils");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) event.getContentIfNotHandled();
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        OTAUpdateActivity oTAUpdateActivity = this$0;
        boolean isNetworkAvailable = utils.isNetworkAvailable(oTAUpdateActivity);
        boolean isNetworkNotMetered = utils.isNetworkNotMetered(oTAUpdateActivity);
        Log.d(TAG, "isNetworkAvailable: " + isNetworkAvailable + ", isNetworkNotMetered: " + isNetworkNotMetered);
        if (!isNetworkAvailable) {
            Toast.makeText(oTAUpdateActivity, (int) C1640R.string.no_network_toast, 0).show();
            return;
        }
        OTAUpdateViewModel oTAUpdateViewModel = null;
        if (!isNetworkNotMetered) {
            OTAUpdateViewModel oTAUpdateViewModel2 = this$0.viewModel;
            if (oTAUpdateViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                oTAUpdateViewModel = oTAUpdateViewModel2;
            }
            oTAUpdateViewModel.showCheckDownloadWithCellularDialog(true);
            return;
        }
        OTAUpdateViewModel oTAUpdateViewModel3 = this$0.viewModel;
        if (oTAUpdateViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            oTAUpdateViewModel3 = null;
        }
        OTAUpdateViewModel.onCallForDownload$default(oTAUpdateViewModel3, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$14(OTAUpdateActivity this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) event.getContentIfNotHandled();
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpViewModel$lambda$15(OTAUpdateActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressedCallback.setEnabled(Intrinsics.areEqual((Object) bool, (Object) true));
    }

    private final void setView() {
        ComponentActivity.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-290780290, true, new OTAUpdateActivity$setView$1(this)), 1, null);
    }

    private final void checkIsAuthorizedUser() {
        if (getUserId() != 0) {
            OTAUpdateViewModel oTAUpdateViewModel = this.viewModel;
            if (oTAUpdateViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                oTAUpdateViewModel = null;
            }
            oTAUpdateViewModel.showUnauthorizedUserTips(true);
        }
    }
}
