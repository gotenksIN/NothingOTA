package com.nothing.OfflineOTAUpgradeApp.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.nothing.OfflineOTAUpgradeApp.UpdateConfig;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final class UpdateConfigs {
    public static final String UPDATE_CONFIGS_ROOT = "configs/";

    public static String[] configsToNames(List<UpdateConfig> list) {
        return (String[]) list.stream().map(new Function() { // from class: com.nothing.OfflineOTAUpgradeApp.util.UpdateConfigs$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((UpdateConfig) obj).getName();
            }
        }).toArray(new IntFunction() { // from class: com.nothing.OfflineOTAUpgradeApp.util.UpdateConfigs$$ExternalSyntheticLambda2
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return UpdateConfigs.lambda$configsToNames$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String[] lambda$configsToNames$0(int i) {
        return new String[i];
    }

    public static String getConfigsRoot(Context context) {
        return Paths.get(context.getFilesDir().toString(), UPDATE_CONFIGS_ROOT).toString();
    }

    public static List<UpdateConfig> getUpdateConfigs(Context context) {
        File[] listFiles;
        File file = new File(getConfigsRoot(context));
        ArrayList arrayList = new ArrayList();
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory() && file2.getName().endsWith(".json")) {
                    try {
                        arrayList.add(UpdateConfig.fromJson(new String(Files.readAllBytes(file2.toPath()), StandardCharsets.UTF_8)));
                    } catch (Exception e) {
                        Log.e("UpdateConfigs", "Can't read/parse config file " + file2.getName(), e);
                        throw new RuntimeException("Can't read/parse config file " + file2.getName(), e);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static Optional<UpdateConfig.PackageFile> getPropertyFile(final String str, UpdateConfig updateConfig) {
        return Arrays.stream(updateConfig.getAbConfig().getPropertyFiles()).filter(new Predicate() { // from class: com.nothing.OfflineOTAUpgradeApp.util.UpdateConfigs$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = str.equals(((UpdateConfig.PackageFile) obj).getFilename());
                return equals;
            }
        }).findFirst();
    }

    public static String[] getSdcardFilePath() {
        File[] listFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ota").listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null) {
            for (File file : listFiles) {
                Log.d("File Path", file.getAbsolutePath());
                if (!file.getAbsolutePath().isEmpty()) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private UpdateConfigs() {
    }
}
