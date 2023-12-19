package com.nothing.OfflineOTAUpgradeApp.util;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public final class FileDownloader {
    private File mDestination;
    private long mOffset;
    private long mSize;
    private String mUrl;

    public FileDownloader(String str, long j, long j2, File file) {
        this.mUrl = str;
        this.mOffset = j;
        this.mSize = j2;
        this.mDestination = file;
    }

    public void download() throws IOException {
        int read;
        Log.d("FileDownloader", "downloading " + this.mDestination.getName() + " from " + this.mUrl + " to " + this.mDestination.getAbsolutePath());
        URLConnection openConnection = new URL(this.mUrl).openConnection();
        openConnection.connect();
        InputStream inputStream = openConnection.getInputStream();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mDestination);
            if (inputStream.skip(this.mOffset) != this.mOffset) {
                throw new IOException("Can't download file " + this.mUrl + " with given offset " + this.mOffset);
            }
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                long j2 = this.mSize;
                if (j >= j2 || (read = inputStream.read(bArr, 0, (int) Math.min(4096L, j2 - j))) <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                j += read;
            }
            if (j != this.mSize) {
                throw new IOException("Can't download file " + this.mUrl + " with given size " + this.mSize);
            }
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
