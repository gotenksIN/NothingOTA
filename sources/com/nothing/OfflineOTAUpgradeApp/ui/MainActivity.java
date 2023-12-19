package com.nothing.OfflineOTAUpgradeApp.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.os.UpdateEngine;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.nothing.OfflineOTAUpgradeApp.R;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
import com.nothing.OfflineOTAUpgradeApp.UpdaterState;
import com.nothing.OfflineOTAUpgradeApp.util.PackageFiles;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateConfigs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateEngineErrorCodes;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateEngineStatuses;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* loaded from: classes2.dex */
public class MainActivity extends Activity {
    private static final int PICK_FILE_REQUEST = 15;
    public static final String SDCARD_DATA_PATH = "/data/media/0/ota/";
    public static final String TAG = "NothingOfflineOtaUpdate";
    private Handler displayButtonHandler;
    private Button mButtonDirectOTA;
    private Button mButtonReset;
    private Button mButtonStop;
    private ProgressBar mProgressBar;
    private Spinner mSpinnerSdcardFilePath;
    private TextView mTextVerifyStatus;
    private TextView mTextViewBuild;
    private TextView mTextViewEngineErrorCode;
    private TextView mTextViewEngineStatus;
    private TextView mTextViewSelectPath;
    private TextView mTextViewUpdaterState;
    private PowerManager.WakeLock wakeLock;
    private final UpdateManager mUpdateManager = new UpdateManager(new UpdateEngine(), new Handler());
    private Boolean isBackFromBrowseCopyFile = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.mTextViewBuild = (TextView) findViewById(R.id.textViewBuild);
        this.mButtonStop = (Button) findViewById(R.id.buttonStop);
        this.mButtonReset = (Button) findViewById(R.id.buttonReset);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.mTextViewUpdaterState = (TextView) findViewById(R.id.textViewUpdaterState);
        this.mTextViewEngineStatus = (TextView) findViewById(R.id.textViewEngineStatus);
        this.mTextViewEngineErrorCode = (TextView) findViewById(R.id.textViewEngineErrorCode);
        this.mSpinnerSdcardFilePath = (Spinner) findViewById(R.id.spinnerSdcardFilePath);
        this.mButtonDirectOTA = (Button) findViewById(R.id.buttonDirectOTA);
        this.mTextViewSelectPath = (TextView) findViewById(R.id.textSelectPath);
        this.mTextVerifyStatus = (TextView) findViewById(R.id.textVerifyStatus);
        this.mTextViewSelectPath.setText("");
        this.displayButtonHandler = new Handler();
        loadSdcardFilePathsToSpinner();
        this.mUpdateManager.setOnStateChangeCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                MainActivity.this.onUpdaterStateChange(i);
            }
        });
        this.mUpdateManager.setOnEngineStatusUpdateCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                MainActivity.this.onEngineStatusUpdate(i);
            }
        });
        this.mUpdateManager.setOnEngineCompleteCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                MainActivity.this.onEnginePayloadApplicationComplete(i);
            }
        });
        this.mUpdateManager.setOnProgressUpdateCallback(new DoubleConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda6
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                MainActivity.this.onProgressUpdate(d);
            }
        });
        updateOtaStateBySharePreference();
        if (this.mUpdateManager.getUpdaterState() == 2) {
            acquireWakeLock();
        }
        this.mUpdateManager.bind();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        releaseWakeLock();
        this.mUpdateManager.setOnEngineStatusUpdateCallback(null);
        this.mUpdateManager.setOnProgressUpdateCallback(null);
        this.mUpdateManager.setOnEngineCompleteCallback(null);
        this.mUpdateManager.unbind();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        updateOtaStateBySharePreference();
        Log.d(TAG, "onResume state=" + this.mUpdateManager.getUpdaterState());
        if (this.mUpdateManager.getUpdaterState() == 2) {
            uiStateRunning();
        } else {
            uiResetWidgets();
        }
        if (this.isBackFromBrowseCopyFile.booleanValue()) {
            this.mButtonDirectOTA.setEnabled(false);
            this.isBackFromBrowseCopyFile = false;
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        saveOtaStateBySharePreference();
        super.onPause();
    }

    private void acquireWakeLock() {
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "NothingOfflineOtaUpdate:wakelock");
        }
        Log.d(TAG, "acquireWakeLock wakeLock isHeld=" + this.wakeLock.isHeld() + " ,state=" + this.mUpdateManager.getUpdaterState());
        if (this.wakeLock.isHeld()) {
            return;
        }
        this.wakeLock.acquire();
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            wakeLock.release();
            Log.d(TAG, "releaseWakeLock wakeLock isHeld=" + this.wakeLock.isHeld());
            this.wakeLock = null;
        }
    }

    public void onStopClick(View view) {
        new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.stop_ota_update_dialog_title)).setMessage(getResources().getString(R.string.stop_ota_update_dialog_message)).setIcon(17301543).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m5353xfaad39ec(dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onStopClick$0$com-nothing-OfflineOTAUpgradeApp-ui-MainActivity  reason: not valid java name */
    public /* synthetic */ void m5353xfaad39ec(DialogInterface dialogInterface, int i) {
        releaseWakeLock();
        if (this.mUpdateManager.getUpdaterState() == 2) {
            cancelRunningUpdate();
        }
    }

    private void cancelRunningUpdate() {
        this.mButtonDirectOTA.setEnabled(false);
        new Thread(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                Runnable runnable;
                try {
                    try {
                        MainActivity.this.mUpdateManager.cancelRunningUpdate();
                        handler = MainActivity.this.displayButtonHandler;
                        runnable = new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.mButtonDirectOTA.setEnabled(true);
                            }
                        };
                    } catch (Exception e) {
                        Log.e(MainActivity.TAG, "Failed to cancel running update", e);
                        handler = MainActivity.this.displayButtonHandler;
                        runnable = new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.mButtonDirectOTA.setEnabled(true);
                            }
                        };
                    }
                    handler.post(runnable);
                } catch (Throwable th) {
                    MainActivity.this.displayButtonHandler.post(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainActivity.this.mButtonDirectOTA.setEnabled(true);
                        }
                    });
                    throw th;
                }
            }
        }).start();
    }

    public void onResetClick(View view) {
        new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.reset_ota_update_dialog_title)).setMessage(getResources().getString(R.string.reset_ota_update_dialog_message)).setIcon(17301543).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m5352x10e435e0(dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResetClick$1$com-nothing-OfflineOTAUpgradeApp-ui-MainActivity  reason: not valid java name */
    public /* synthetic */ void m5352x10e435e0(DialogInterface dialogInterface, int i) {
        releaseWakeLock();
        resetUpdate();
    }

    private void resetUpdate() {
        this.mButtonDirectOTA.setEnabled(false);
        new Thread(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                Runnable runnable;
                try {
                    try {
                        MainActivity.this.mUpdateManager.resetUpdate();
                        handler = MainActivity.this.displayButtonHandler;
                        runnable = new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.mButtonDirectOTA.setEnabled(true);
                            }
                        };
                    } catch (Exception e) {
                        Log.e(MainActivity.TAG, "Failed to cancel running update", e);
                        handler = MainActivity.this.displayButtonHandler;
                        runnable = new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MainActivity.this.mButtonDirectOTA.setEnabled(true);
                            }
                        };
                    }
                    handler.post(runnable);
                } catch (Throwable th) {
                    MainActivity.this.displayButtonHandler.post(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainActivity.this.mButtonDirectOTA.setEnabled(true);
                        }
                    });
                    throw th;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdaterStateChange(final int i) {
        Log.i(TAG, "UpdaterStateChange state= " + UpdaterState.getStateText(i) + "/" + i);
        runOnUiThread(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m5354x75a51800(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onUpdaterStateChange$2$com-nothing-OfflineOTAUpgradeApp-ui-MainActivity  reason: not valid java name */
    public /* synthetic */ void m5354x75a51800(int i) {
        setUiUpdaterState(i);
        if (i == 0) {
            uiStateIdle();
        } else if (i == 2) {
            uiStateRunning();
        } else if (i == 3) {
            uiStatePaused();
        } else if (i == 1) {
            uiStateError();
        } else if (i == 4) {
            uiStateSlotSwitchRequired();
        } else if (i == 5) {
            try {
                try {
                    this.mUpdateManager.setUpdaterStateIdle();
                    releaseWakeLock();
                    if (!deleteOtaFile()) {
                        return;
                    }
                } catch (Exception unused) {
                    Log.e(TAG, "onUpdaterStateChange error");
                    releaseWakeLock();
                    if (!deleteOtaFile()) {
                        return;
                    }
                }
                createDialogToReboot();
            } catch (Throwable th) {
                releaseWakeLock();
                if (deleteOtaFile()) {
                    createDialogToReboot();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEngineStatusUpdate(final int i) {
        Log.i(TAG, "StatusUpdate - status=" + UpdateEngineStatuses.getStatusText(i) + "/" + i);
        runOnUiThread(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m5351x2d311e5a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnginePayloadApplicationComplete(final int i) {
        Log.i(TAG, "PayloadApplicationCompleted - errorCode=" + UpdateEngineErrorCodes.getCodeName(i) + "/" + i + " " + (UpdateEngineErrorCodes.isUpdateSucceeded(i) ? "SUCCESS" : "FAILURE"));
        runOnUiThread(new Runnable() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m5350xa93d2219(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressUpdate(double d) {
        this.mProgressBar.setProgress((int) (d * 100.0d));
    }

    private void uiResetWidgets() {
        this.mTextViewBuild.setText(getBuildNumber());
        this.mButtonStop.setEnabled(false);
        this.mButtonReset.setEnabled(false);
        this.mButtonDirectOTA.setEnabled(true);
    }

    private String getBuildNumber() {
        StringBuilder append = new StringBuilder(SystemProperties.get("ro.product.vendor.device", "")).append("-").append(Build.DISPLAY);
        String str = SystemProperties.get("ro.boot.hardware.sku", "");
        if (!new String[]{"ROW"}[0].equals(str)) {
            append.append("-").append(str);
        }
        return append.toString();
    }

    private void uiResetEngineText() {
        this.mTextViewEngineStatus.setText(R.string.unknown);
        this.mTextViewEngineErrorCode.setText(R.string.unknown);
    }

    private void uiStateIdle() {
        uiResetWidgets();
        this.mButtonStop.setEnabled(true);
        this.mButtonReset.setEnabled(true);
    }

    private void uiStateRunning() {
        uiResetWidgets();
        this.mProgressBar.setEnabled(true);
        this.mButtonStop.setEnabled(true);
        this.mButtonDirectOTA.setEnabled(false);
    }

    private void uiStatePaused() {
        uiResetWidgets();
        this.mButtonReset.setEnabled(true);
        this.mProgressBar.setEnabled(true);
    }

    private void uiStateSlotSwitchRequired() {
        uiResetWidgets();
        this.mButtonReset.setEnabled(true);
        this.mProgressBar.setEnabled(true);
    }

    private void uiStateError() {
        uiResetWidgets();
        this.mButtonReset.setEnabled(true);
        this.mProgressBar.setEnabled(true);
    }

    private void uiStateRebootRequired() {
        uiResetWidgets();
        this.mButtonReset.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUiEngineStatus */
    public void m5351x2d311e5a(int i) {
        this.mTextViewEngineStatus.setText(UpdateEngineStatuses.getStatusText(i) + "/" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUiEngineErrorCode */
    public void m5350xa93d2219(int i) {
        this.mTextViewEngineErrorCode.setText(UpdateEngineErrorCodes.getCodeName(i) + "/" + i);
        if (i == 0) {
            try {
                this.mUpdateManager.setUpdaterStateIdle();
            } catch (Exception e) {
                Log.e(TAG, "setUiEngineErrorCode" + e);
            }
            releaseWakeLock();
            if (deleteOtaFile()) {
                createDialogToReboot();
            }
        }
    }

    private void setUiUpdaterState(int i) {
        this.mTextViewUpdaterState.setText(UpdaterState.getStateText(i) + "/" + i);
    }

    private void loadSdcardFilePathsToSpinner() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, UpdateConfigs.getSdcardFilePath());
        arrayAdapter.setDropDownViewResource(17367049);
        this.mSpinnerSdcardFilePath.setAdapter((SpinnerAdapter) arrayAdapter);
        this.mSpinnerSdcardFilePath.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.mTextVerifyStatus.setText("");
                MainActivity.this.mTextViewSelectPath.setText((String) MainActivity.this.mSpinnerSdcardFilePath.getItemAtPosition(i));
            }
        });
    }

    private void createDialogToReboot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.update_ota_success_reboot_dialog_title));
        builder.setMessage(getResources().getString(R.string.update_ota_success_reboot_dialog_title_message));
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.resetOtaStateBySharePreference();
                ((PowerManager) MainActivity.this.getSystemService("power")).reboot(null);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    private boolean deleteOtaFile() {
        Boolean bool = false;
        File file = new File(getOtaFilePathBySharePreference());
        if (file.exists() && file.isFile()) {
            file.delete();
            bool = true;
        }
        Log.d(TAG, "deleteOtaFile delete file:" + getOtaFilePathBySharePreference() + " ,status= " + bool);
        return bool.booleanValue();
    }

    private void saveOtaStateBySharePreference() {
        SharedPreferences.Editor edit = getSharedPreferences("ota_prefs", 0).edit();
        edit.putString("update_state", this.mTextViewUpdaterState.getText().toString());
        edit.putString("engine_state", this.mTextViewEngineStatus.getText().toString());
        edit.putString("engine_error_state", this.mTextViewEngineErrorCode.getText().toString());
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetOtaStateBySharePreference() {
        SharedPreferences.Editor edit = getSharedPreferences("ota_prefs", 0).edit();
        edit.putString("update_state", getResources().getString(R.string.unknown));
        edit.putString("engine_state", getResources().getString(R.string.unknown));
        edit.putString("engine_error_state", getResources().getString(R.string.unknown));
        edit.apply();
    }

    private void updateOtaStateBySharePreference() {
        SharedPreferences sharedPreferences = getSharedPreferences("ota_prefs", 0);
        String string = sharedPreferences.getString("update_state", getResources().getString(R.string.unknown));
        String str = string.split("/")[0];
        this.mTextViewUpdaterState.setText(string);
        this.mTextViewEngineStatus.setText(sharedPreferences.getString("engine_state", getResources().getString(R.string.unknown)));
        this.mTextViewEngineErrorCode.setText(sharedPreferences.getString("engine_error_state", getResources().getString(R.string.unknown)));
        Log.d(TAG, "updateOtaStateBySharePreference state=" + str);
        try {
            if (str.equals(DebugCoroutineInfoImplKt.RUNNING)) {
                this.mUpdateManager.setUpdaterStateRunning();
                saveOtaStateBySharePreference();
            } else {
                this.mUpdateManager.setUpdaterStateIdle();
                saveOtaStateBySharePreference();
            }
        } catch (Exception unused) {
            Log.e(TAG, "updateOtaStateText error:");
        }
    }

    private String getOtaFilePathBySharePreference() {
        return getSharedPreferences("ota_prefs", 0).getString("file_path", "");
    }

    private void setOtaFilePathBySharePreference(String str) {
        SharedPreferences.Editor edit = getSharedPreferences("ota_prefs", 0).edit();
        edit.putString("file_path", str);
        edit.apply();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mUpdateManager.getUpdaterState() == 2) {
            Toast.makeText(this, getResources().getString(R.string.back_press_running_toast), 0).show();
        } else {
            super.onBackPressed();
        }
    }

    public void onDirectApplyOTAClick(View view) {
        new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.select_ota_file_dialog_title)).setMessage(getResources().getString(R.string.select_ota_file_dialog_message)).setIcon(17301543).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m5349x902d7a5c(dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onDirectApplyOTAClick$5$com-nothing-OfflineOTAUpgradeApp-ui-MainActivity  reason: not valid java name */
    public /* synthetic */ void m5349x902d7a5c(DialogInterface dialogInterface, int i) {
        uiResetWidgets();
        uiResetEngineText();
        uiStateRunning();
        directlyApplyUpdate();
    }

    public void onSdcardFileReloadClick(View view) {
        loadSdcardFilePathsToSpinner();
        if (isSdcardPathContainFiles()) {
            return;
        }
        this.mTextViewSelectPath.setText("");
    }

    private boolean isSdcardPathContainFiles() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ota/";
        File[] listFiles = new File(str).listFiles();
        boolean z = true;
        Log.d(TAG, "isSdcardPathContainFiles path=" + str + ", contains=" + (listFiles != null && listFiles.length > 0));
        if (listFiles == null || listFiles.length <= 0) {
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getResources().getString(R.string.verify_sdcard_ota_patch_contain_file_fail), 0).show();
        }
        return z;
    }

    private void copyFile(File file, File file2) throws IOException {
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (file2.exists()) {
            return;
        }
        file2.createNewFile();
        new CopyFileTask(file, file2).execute(new Void[0]);
    }

    public void onBrowseClick(View view) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/Documents"), "*/*");
        startActivityForResult(intent, 15);
    }

    private void directlyApplyUpdate() {
        UpdateEngine updateEngine;
        CharSequence charSequence;
        long j;
        int i;
        long j2;
        long j3;
        ZipFile zipFile;
        ZipFile zipFile2;
        Throwable th;
        ZipEntry nextElement;
        String name;
        ZipFile zipFile3;
        long length;
        UpdateEngine updateEngine2;
        CharSequence charSequence2;
        Enumeration<? extends ZipEntry> enumeration;
        boolean z;
        Enumeration<? extends ZipEntry> enumeration2;
        UpdateEngine updateEngine3 = new UpdateEngine();
        CharSequence text = this.mTextViewSelectPath.getText();
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> hashMap = new HashMap<>();
        Log.i(TAG, "directlyApplyUpdate select path= " + ((Object) text));
        String[] split = this.mTextViewSelectPath.getText().toString().split("/");
        String str = split[split.length - 1];
        try {
            zipFile = new ZipFile(Paths.get(text.toString(), new String[0]).toFile());
        } catch (Exception e) {
            e = e;
            updateEngine = updateEngine3;
            charSequence = text;
            j = 0;
            i = 0;
            j2 = 0;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            i = 0;
            long j4 = 0;
            long j5 = 0;
            j2 = 0;
            while (entries.hasMoreElements()) {
                try {
                    nextElement = entries.nextElement();
                    name = nextElement.getName();
                    if (nextElement.getExtra() == null) {
                        zipFile3 = zipFile;
                        length = 0;
                    } else {
                        zipFile3 = zipFile;
                        length = nextElement.getExtra().length;
                    }
                    try {
                        updateEngine2 = updateEngine3;
                        charSequence2 = text;
                        j4 += name.length() + 30 + length;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipFile2 = zipFile;
                }
                try {
                    if (nextElement.isDirectory()) {
                        zipFile = zipFile3;
                        updateEngine3 = updateEngine2;
                        text = charSequence2;
                    } else {
                        long compressedSize = nextElement.getCompressedSize();
                        if (PackageFiles.PAYLOAD_BINARY_FILE_NAME.equals(name)) {
                            try {
                                if (nextElement.getMethod() != 0) {
                                    throw new IOException("Invalid compression method.");
                                }
                                j2 = compressedSize;
                                enumeration = entries;
                                j5 = j4;
                                zipFile2 = zipFile3;
                            } catch (Throwable th4) {
                                th = th4;
                                zipFile2 = zipFile3;
                                try {
                                    zipFile2.close();
                                    throw th;
                                }
                            }
                        } else {
                            if (PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME.equals(name)) {
                                zipFile2 = zipFile3;
                                try {
                                    InputStream inputStream = zipFile2.getInputStream(nextElement);
                                    if (inputStream != null) {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                        while (true) {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            arrayList.add(readLine);
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    th = th;
                                    zipFile2.close();
                                    throw th;
                                }
                            } else {
                                zipFile2 = zipFile3;
                                if (PackageFiles.METADATA_FILE_PATH.equals(name)) {
                                    InputStream inputStream2 = zipFile2.getInputStream(nextElement);
                                    if (inputStream2 != null) {
                                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
                                        while (true) {
                                            String readLine2 = bufferedReader2.readLine();
                                            if (readLine2 == null) {
                                                break;
                                            }
                                            String[] split2 = readLine2.split("=");
                                            if (split2.length > 1) {
                                                enumeration2 = entries;
                                                hashMap.put(split2[0], split2[1]);
                                            } else {
                                                enumeration2 = entries;
                                            }
                                            entries = enumeration2;
                                        }
                                    }
                                    enumeration = entries;
                                    z = true;
                                    hashMap.forEach(new BiConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity$$ExternalSyntheticLambda9
                                        @Override // java.util.function.BiConsumer
                                        public final void accept(Object obj, Object obj2) {
                                            MainActivity.lambda$directlyApplyUpdate$6((String) obj, (String) obj2);
                                        }
                                    });
                                    int verifyMetaDataFile = verifyMetaDataFile(hashMap);
                                    try {
                                        Log.i(TAG, "meta verify state= " + verifyMetaDataFile);
                                        i = verifyMetaDataFile;
                                        j4 += compressedSize;
                                        zipFile = zipFile2;
                                        entries = enumeration;
                                        updateEngine3 = updateEngine2;
                                        text = charSequence2;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        zipFile2.close();
                                        throw th;
                                    }
                                }
                            }
                            enumeration = entries;
                        }
                        z = true;
                        j4 += compressedSize;
                        zipFile = zipFile2;
                        entries = enumeration;
                        updateEngine3 = updateEngine2;
                        text = charSequence2;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    zipFile2 = zipFile3;
                    th = th;
                    zipFile2.close();
                    throw th;
                }
            }
            updateEngine = updateEngine3;
            charSequence = text;
            try {
                try {
                    zipFile.close();
                } catch (Exception e2) {
                    e = e2;
                    j = j5;
                    Log.e(TAG, "Failed to unzip file " + e);
                    j5 = j;
                    j3 = j2;
                    Log.i(TAG, "directlyApplyUpdate applyPayload path=/data/media/0/ota/" + str);
                    if (!isSdcardPathContainFiles()) {
                    }
                    uiStateError();
                    Log.e(TAG, "Failed to verify metadata config error code=" + i);
                    return;
                }
                Log.i(TAG, "directlyApplyUpdate applyPayload path=/data/media/0/ota/" + str);
                if (!isSdcardPathContainFiles() && !str.isEmpty() && i == 0) {
                    setOtaFilePathBySharePreference(charSequence.toString());
                    this.mUpdateManager.setUpdaterStateRunning();
                    acquireWakeLock();
                    updateEngine.applyPayload("file:///data/media/0/ota/" + str, j5, j3, (String[]) arrayList.toArray(new String[0]));
                    this.mButtonDirectOTA.setEnabled(false);
                } else {
                    uiStateError();
                    Log.e(TAG, "Failed to verify metadata config error code=" + i);
                }
                return;
            } catch (Exception e3) {
                Log.e(TAG, "Failed to apply update " + e3);
                uiStateError();
                return;
            }
            j3 = j2;
        } catch (Throwable th8) {
            zipFile2 = zipFile;
            th = th8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$directlyApplyUpdate$6(String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -548067136:
                if (str.equals("pre-device")) {
                    c = 0;
                    break;
                }
                break;
            case 12290830:
                if (str.equals("post-build-incremental")) {
                    c = 1;
                    break;
                }
                break;
            case 1043679825:
                if (str.equals("pre-build-incremental")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Log.i(TAG, "metaMap pre-device=" + str2);
                return;
            case 1:
                Log.i(TAG, "metaMap post-build-incremental=" + str2);
                return;
            case 2:
                Log.i(TAG, "metaMap pre-build-incremental=" + str2);
                return;
            default:
                return;
        }
    }

    private int verifyMetaDataFile(HashMap<String, String> hashMap) {
        int i;
        String str = SystemProperties.get("ro.product.device", "");
        String str2 = SystemProperties.get("ro.build.version.incremental", "");
        Log.i(TAG, "verifyMetaDataFile productProp=" + str + " ,dateUtcProp= " + str2);
        if (!hashMap.getOrDefault("pre-device", " ").equals(str)) {
            this.mTextVerifyStatus.setText(getResources().getString(R.string.verify_error_1));
            i = -1;
        } else if (hashMap.containsKey("pre-build-incremental") && str2.compareTo(hashMap.get("pre-build-incremental")) != 0) {
            this.mTextVerifyStatus.setText(getResources().getString(R.string.verify_error_2));
            i = -2;
        } else if (isHardwareAndVersionVerifyFail(hashMap)) {
            this.mTextVerifyStatus.setText(getResources().getString(R.string.verify_error_3));
            i = -3;
        } else {
            i = 0;
        }
        if (i == 0) {
            this.mTextVerifyStatus.setText(getResources().getString(R.string.verify_success));
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[EDGE_INSN: B:34:0x0083->B:19:0x0083 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isHardwareAndVersionVerifyFail(java.util.HashMap<java.lang.String, java.lang.String> r11) {
        /*
            r10 = this;
            java.lang.String r0 = "NothingOfflineOtaUpdate"
            java.lang.String r1 = "post-build"
            java.lang.String r2 = "isHardwareAndVersionVerify hardwareProp="
            java.lang.String r3 = "ro.boot.hardware.sku"
            java.lang.String r4 = ""
            java.lang.String r3 = android.os.SystemProperties.get(r3, r4)
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            java.lang.String r6 = "EEA"
            java.lang.String r7 = "IND"
            java.lang.String r8 = "ROW"
            java.lang.String[] r6 = new java.lang.String[]{r8, r6, r7}
            r7 = 1
            boolean r8 = r11.containsKey(r1)     // Catch: java.lang.NumberFormatException -> L6e
            if (r8 == 0) goto L6e
            java.lang.Object r11 = r11.get(r1)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r1 = "/"
            java.lang.String[] r11 = r11.split(r1)     // Catch: java.lang.NumberFormatException -> L6e
            r1 = 2
            r11 = r11[r1]     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r1 = ":"
            java.lang.String[] r1 = r11.split(r1)     // Catch: java.lang.NumberFormatException -> L6e
            r1 = r1[r7]     // Catch: java.lang.NumberFormatException -> L6e
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L6e
            r8 = 13
            if (r1 < r8) goto L48
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.NumberFormatException -> L6e
            goto L49
        L48:
            r8 = r5
        L49:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L6e
            r9.<init>(r2)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.StringBuilder r2 = r9.append(r3)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r9 = " ,post-build="
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.StringBuilder r11 = r2.append(r11)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r2 = " ,metaDataAndroidVersion="
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.StringBuilder r11 = r11.append(r1)     // Catch: java.lang.NumberFormatException -> L6e
            java.lang.String r11 = r11.toString()     // Catch: java.lang.NumberFormatException -> L6e
            android.util.Log.d(r0, r11)     // Catch: java.lang.NumberFormatException -> L6e
            goto L6f
        L6e:
            r8 = r5
        L6f:
            r11 = r4
        L70:
            r1 = 3
            if (r11 >= r1) goto L83
            r1 = r6[r11]
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L80
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)
            goto L83
        L80:
            int r11 = r11 + 1
            goto L70
        L83:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "isHardwareAndVersionVerify state="
            r11.<init>(r1)
            boolean r1 = r5.booleanValue()
            if (r1 != 0) goto L98
            boolean r1 = r8.booleanValue()
            if (r1 == 0) goto L98
            r1 = r7
            goto L99
        L98:
            r1 = r4
        L99:
            java.lang.StringBuilder r11 = r11.append(r1)
            java.lang.String r11 = r11.toString()
            android.util.Log.d(r0, r11)
            boolean r11 = r5.booleanValue()
            if (r11 != 0) goto Lb1
            boolean r11 = r8.booleanValue()
            if (r11 == 0) goto Lb1
            r4 = r7
        Lb1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.isHardwareAndVersionVerifyFail(java.util.HashMap):boolean");
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String[] split;
        super.onActivityResult(i, i2, intent);
        if (i != 15 || i2 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        String str = "primary".equalsIgnoreCase(DocumentsContract.getDocumentId(intent.getData()).split(":")[0]) ? Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + split[1] : "";
        if (!str.startsWith(Environment.getExternalStorageDirectory().getPath() + "/ota") && !str.isEmpty()) {
            String str2 = Environment.getExternalStorageDirectory().getPath() + "/ota/" + new File(str).getName();
            try {
                copyFile(new File(str), new File(str2));
                this.mTextViewSelectPath.setText(str2);
            } catch (IOException e) {
                Log.e(TAG, "copy file fail " + e);
            }
        } else {
            this.mTextViewSelectPath.setText(str);
        }
        this.mTextVerifyStatus.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CopyFileTask extends AsyncTask<Void, Void, Void> {
        private static final int BUFFER_SIZE = 262144;
        private File mDestFile;
        private File mSourceFile;

        public CopyFileTask(File file, File file2) {
            this.mSourceFile = file;
            this.mDestFile = file2;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity.this.isBackFromBrowseCopyFile = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
            if (r3 != null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
            if (r3 != null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
            r3.close();
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #1 {IOException -> 0x0068, blocks: (B:31:0x005f, B:33:0x0064), top: B:38:0x005f }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                java.lang.String r9 = "close file fail"
                java.lang.String r0 = "NothingOfflineOtaUpdate"
                r1 = 0
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46
                java.io.File r3 = r8.mSourceFile     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46
                java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                java.io.File r4 = r8.mDestFile     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                java.nio.channels.FileChannel r3 = r3.getChannel()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
                r4 = 262144(0x40000, float:3.67342E-40)
                java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L5c
            L21:
                int r5 = r2.read(r4)     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L5c
                r6 = -1
                if (r5 == r6) goto L32
                r4.flip()     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L5c
                r3.write(r4)     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L5c
                r4.clear()     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L5c
                goto L21
            L32:
                if (r2 == 0) goto L37
                r2.close()     // Catch: java.io.IOException -> L58
            L37:
                if (r3 == 0) goto L5b
                goto L54
            L3a:
                r3 = move-exception
                r7 = r3
                r3 = r1
                r1 = r7
                goto L5d
            L3f:
                r3 = r1
                goto L48
            L41:
                r2 = move-exception
                r3 = r1
                r1 = r2
                r2 = r3
                goto L5d
            L46:
                r2 = r1
                r3 = r2
            L48:
                java.lang.String r4 = "copy file fail"
                android.util.Log.e(r0, r4)     // Catch: java.lang.Throwable -> L5c
                if (r2 == 0) goto L52
                r2.close()     // Catch: java.io.IOException -> L58
            L52:
                if (r3 == 0) goto L5b
            L54:
                r3.close()     // Catch: java.io.IOException -> L58
                goto L5b
            L58:
                android.util.Log.e(r0, r9)
            L5b:
                return r1
            L5c:
                r1 = move-exception
            L5d:
                if (r2 == 0) goto L62
                r2.close()     // Catch: java.io.IOException -> L68
            L62:
                if (r3 == 0) goto L6b
                r3.close()     // Catch: java.io.IOException -> L68
                goto L6b
            L68:
                android.util.Log.e(r0, r9)
            L6b:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.ui.MainActivity.CopyFileTask.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r3) {
            super.onPostExecute((CopyFileTask) r3);
            MainActivity.this.mButtonDirectOTA.setEnabled(true);
            Toast.makeText(MainActivity.this.getApplicationContext(), MainActivity.this.getResources().getString(R.string.copy_success_text), 0).show();
            MainActivity.this.isBackFromBrowseCopyFile = false;
        }
    }
}
