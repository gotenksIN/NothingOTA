package com.nothing.OfflineOTAUpgradeApp.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.RecoverySystem;
import android.os.ResultReceiver;
import android.os.UpdateEngine;
import android.util.Log;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.nothing.OfflineOTAUpgradeApp.PayloadSpec;
import com.nothing.OfflineOTAUpgradeApp.UpdateConfig;
import com.nothing.OfflineOTAUpgradeApp.util.FileDownloader;
import com.nothing.OfflineOTAUpgradeApp.util.PackageFiles;
import com.nothing.OfflineOTAUpgradeApp.util.PayloadSpecs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateConfigs;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class PrepareUpdateService extends IntentService {
    public static final String EXTRA_PARAM_CONFIG = "config";
    public static final String EXTRA_PARAM_RESULT_RECEIVER = "result-receiver";
    private static final ImmutableSet<String> PRE_STREAMING_FILES_SET = ImmutableSet.of(PackageFiles.CARE_MAP_FILE_NAME, PackageFiles.COMPATIBILITY_ZIP_FILE_NAME, PackageFiles.METADATA_FILE_NAME, PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME);
    public static final int RESULT_CODE_ERROR = 1;
    public static final int RESULT_CODE_SUCCESS = 0;
    private static final String TAG = "PrepareUpdateService";
    private final PayloadSpecs mPayloadSpecs;
    private final UpdateEngine mUpdateEngine;

    /* loaded from: classes2.dex */
    public interface UpdateResultCallback {
        void onReceiveResult(int i, PayloadSpec payloadSpec);
    }

    public static void startService(Context context, UpdateConfig updateConfig, Handler handler, UpdateResultCallback updateResultCallback) {
        Log.d(TAG, "Starting PrepareUpdateService");
        CallbackResultReceiver callbackResultReceiver = new CallbackResultReceiver(handler, updateResultCallback);
        Intent intent = new Intent(context, PrepareUpdateService.class);
        intent.putExtra(EXTRA_PARAM_CONFIG, updateConfig);
        intent.putExtra(EXTRA_PARAM_RESULT_RECEIVER, callbackResultReceiver);
        context.startService(intent);
    }

    public PrepareUpdateService() {
        super(TAG);
        this.mPayloadSpecs = new PayloadSpecs();
        this.mUpdateEngine = new UpdateEngine();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "On handle intent is called");
        UpdateConfig updateConfig = (UpdateConfig) intent.getParcelableExtra(EXTRA_PARAM_CONFIG);
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(EXTRA_PARAM_RESULT_RECEIVER);
        try {
            resultReceiver.send(0, CallbackResultReceiver.createBundle(execute(updateConfig)));
        } catch (Exception e) {
            Log.e(TAG, "Failed to prepare streaming update", e);
            resultReceiver.send(1, null);
        }
    }

    private PayloadSpec execute(UpdateConfig updateConfig) throws IOException, PreparationFailedException {
        if (updateConfig.getAbConfig().getVerifyPayloadMetadata()) {
            Log.i(TAG, "Verifying payload metadata with UpdateEngine.");
            if (!verifyPayloadMetadata(updateConfig)) {
                throw new PreparationFailedException("Payload metadata is not compatible");
            }
        }
        if (updateConfig.getInstallType() == 0) {
            return this.mPayloadSpecs.forNonStreaming(updateConfig.getUpdatePackageFile());
        }
        downloadPreStreamingFiles(updateConfig, PackageFiles.OTA_PACKAGE_DIR);
        Optional<UpdateConfig.PackageFile> propertyFile = UpdateConfigs.getPropertyFile(PackageFiles.PAYLOAD_BINARY_FILE_NAME, updateConfig);
        if (!propertyFile.isPresent()) {
            throw new PreparationFailedException("Failed to find payload.bin in config");
        }
        if (!UpdateConfigs.getPropertyFile(PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME, updateConfig).isPresent() || !Paths.get(PackageFiles.OTA_PACKAGE_DIR, PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME).toFile().exists()) {
            throw new IOException("payload_properties.txt not found");
        }
        File file = Paths.get(PackageFiles.OTA_PACKAGE_DIR, PackageFiles.COMPATIBILITY_ZIP_FILE_NAME).toFile();
        if (file.isFile()) {
            Log.i(TAG, "Verifying OTA package for compatibility with the device");
            if (!verifyPackageCompatibility(file)) {
                throw new PreparationFailedException("OTA package is not compatible with this device");
            }
        }
        return this.mPayloadSpecs.forStreaming(updateConfig.getUrl(), propertyFile.get().getOffset(), propertyFile.get().getSize(), Paths.get(PackageFiles.OTA_PACKAGE_DIR, PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME).toFile());
    }

    private boolean verifyPayloadMetadata(UpdateConfig updateConfig) {
        Optional findFirst = Arrays.stream(updateConfig.getAbConfig().getPropertyFiles()).filter(new Predicate() { // from class: com.nothing.OfflineOTAUpgradeApp.services.PrepareUpdateService$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((UpdateConfig.PackageFile) obj).getFilename().equals(PackageFiles.PAYLOAD_METADATA_FILE_NAME);
                return equals;
            }
        }).findFirst();
        if (!findFirst.isPresent()) {
            Log.w(TAG, String.format("ab_config.property_files doesn't contain %s", PackageFiles.PAYLOAD_METADATA_FILE_NAME));
            return true;
        }
        Path path = Paths.get(PackageFiles.OTA_PACKAGE_DIR, PackageFiles.PAYLOAD_METADATA_FILE_NAME);
        try {
            Files.deleteIfExists(path);
            new FileDownloader(updateConfig.getUrl(), ((UpdateConfig.PackageFile) findFirst.get()).getOffset(), ((UpdateConfig.PackageFile) findFirst.get()).getSize(), path.toFile()).download();
            try {
                return this.mUpdateEngine.verifyPayloadMetadata(path.toAbsolutePath().toString());
            } catch (Exception e) {
                Log.w(TAG, "UpdateEngine#verifyPayloadMetadata failed", e);
                return true;
            }
        } catch (IOException e2) {
            Log.w(TAG, String.format("Downloading %s from %s failed", PackageFiles.PAYLOAD_METADATA_FILE_NAME, updateConfig.getUrl()), e2);
            return true;
        }
    }

    private void downloadPreStreamingFiles(UpdateConfig updateConfig, String str) throws IOException {
        UpdateConfig.PackageFile[] propertyFiles;
        Log.d(TAG, "Deleting existing files from " + str);
        UnmodifiableIterator<String> it = PRE_STREAMING_FILES_SET.iterator();
        while (it.hasNext()) {
            Files.deleteIfExists(Paths.get(PackageFiles.OTA_PACKAGE_DIR, it.next()));
        }
        Log.d(TAG, "Downloading files to " + str);
        for (UpdateConfig.PackageFile packageFile : updateConfig.getAbConfig().getPropertyFiles()) {
            if (PRE_STREAMING_FILES_SET.contains(packageFile.getFilename())) {
                Log.d(TAG, "Downloading file " + packageFile.getFilename());
                new FileDownloader(updateConfig.getUrl(), packageFile.getOffset(), packageFile.getSize(), Paths.get(str, packageFile.getFilename()).toFile()).download();
            }
        }
    }

    private boolean verifyPackageCompatibility(File file) {
        try {
            return RecoverySystem.verifyPackageCompatibility(file);
        } catch (IOException e) {
            Log.e(TAG, "Failed to verify package compatibility", e);
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class CallbackResultReceiver extends ResultReceiver {
        private static final String BUNDLE_PARAM_PAYLOAD_SPEC = "payload-spec";
        private UpdateResultCallback mUpdateResultCallback;

        static Bundle createBundle(PayloadSpec payloadSpec) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BUNDLE_PARAM_PAYLOAD_SPEC, payloadSpec);
            return bundle;
        }

        CallbackResultReceiver(Handler handler, UpdateResultCallback updateResultCallback) {
            super(handler);
            this.mUpdateResultCallback = updateResultCallback;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            this.mUpdateResultCallback.onReceiveResult(i, i == 0 ? (PayloadSpec) bundle.getSerializable(BUNDLE_PARAM_PAYLOAD_SPEC) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PreparationFailedException extends Exception {
        PreparationFailedException(String str) {
            super(str);
        }
    }
}
