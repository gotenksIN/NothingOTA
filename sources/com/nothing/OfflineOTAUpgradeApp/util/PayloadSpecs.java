package com.nothing.OfflineOTAUpgradeApp.util;

import com.nothing.OfflineOTAUpgradeApp.PayloadSpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public class PayloadSpecs {
    public PayloadSpec forNonStreaming(File file) throws IOException {
        InputStream inputStream;
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            boolean z = false;
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                Enumeration<? extends ZipEntry> enumeration = entries;
                j3 += name.length() + 30 + (nextElement.getExtra() == null ? 0L : nextElement.getExtra().length);
                if (!nextElement.isDirectory()) {
                    long compressedSize = nextElement.getCompressedSize();
                    if (PackageFiles.PAYLOAD_BINARY_FILE_NAME.equals(name)) {
                        if (nextElement.getMethod() != 0) {
                            throw new IOException("Invalid compression method.");
                        }
                        z = true;
                        j2 = compressedSize;
                        j = j3;
                    } else if (PackageFiles.PAYLOAD_PROPERTIES_FILE_NAME.equals(name) && (inputStream = zipFile.getInputStream(nextElement)) != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(readLine);
                        }
                    }
                    j3 += compressedSize;
                }
                entries = enumeration;
            }
            zipFile.close();
            if (!z) {
                throw new IOException("Failed to find payload entry in the given package.");
            }
            return PayloadSpec.newBuilder().url("file://" + file.getAbsolutePath()).offset(j).size(j2).properties(arrayList).build();
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public PayloadSpec forStreaming(String str, long j, long j2, File file) throws IOException {
        return PayloadSpec.newBuilder().url(str).offset(j).size(j2).properties(Files.readAllLines(file.toPath())).build();
    }

    public String specToString(PayloadSpec payloadSpec) {
        return "<PayloadSpec url=" + payloadSpec.getUrl() + ", offset=" + payloadSpec.getOffset() + ", size=" + payloadSpec.getSize() + ", properties=" + Arrays.toString(payloadSpec.getProperties().toArray(new String[0])) + ">";
    }
}
