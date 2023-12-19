package com.nothing.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.nothing.proxy.INothingService;
import com.nothing.sdk.utils.Common;

/* loaded from: classes2.dex */
public class NothingCore {
    public static final int ERROR_NO_INIT = 2;
    public static final int ERROR_SERVICE_EXCEPTION = 1;
    private static final String TAG = "NothingCore";
    private static NothingCore mInstance;
    private Callback mCallback;
    private RemoteServiceConnection mConnection = new RemoteServiceConnection();
    private Context mContext;
    private INothingService mService;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onError(int i);

        void onServiceConnected(ComponentName componentName);

        void onServiceDisconnected(ComponentName componentName);
    }

    public static NothingCore getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NothingCore(context);
        }
        return mInstance;
    }

    private NothingCore(Context context) {
        Log.d(TAG, "SDK Version:" + Common.getSDKVersion());
        this.mContext = context;
    }

    public void init(Callback callback) {
        this.mCallback = callback;
        Intent intent = new Intent();
        intent.setPackage("com.nothing.proxy");
        intent.setAction("com.nothing.proxy.bind_nothing_service");
        intent.setComponent(new ComponentName("com.nothing.proxy", "com.nothing.proxy.NothingService"));
        this.mContext.bindService(intent, this.mConnection, 1);
    }

    public void unInit() {
        try {
            this.mContext.unbindService(this.mConnection);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void goToSleep(long j) {
        INothingService iNothingService = this.mService;
        if (iNothingService == null) {
            Log.e(TAG, "Service is null");
            this.mCallback.onError(2);
            return;
        }
        try {
            iNothingService.deviceGoToSleep(j);
        } catch (RemoteException unused) {
            this.mCallback.onError(1);
            Log.e(TAG, "goToSleep RemoteException error");
        }
    }

    public boolean isUninstallableSystemApp(String str) {
        INothingService iNothingService = this.mService;
        if (iNothingService == null) {
            Log.e(TAG, "Service is null");
            this.mCallback.onError(2);
            return false;
        }
        try {
            return iNothingService.isUninstallableSystemApp(str);
        } catch (RemoteException unused) {
            this.mCallback.onError(1);
            Log.e(TAG, "isUninstallableSystemApp RemoteException error");
            return false;
        }
    }

    public void uninstallSystemApp(String str, int i) {
        INothingService iNothingService = this.mService;
        if (iNothingService == null) {
            Log.e(TAG, "Service is null");
            this.mCallback.onError(2);
            return;
        }
        try {
            iNothingService.uninstallSystemApp(str, i);
        } catch (RemoteException unused) {
            this.mCallback.onError(1);
            Log.e(TAG, "UninstallSystemApp RemoteException error");
        }
    }

    /* loaded from: classes2.dex */
    private class RemoteServiceConnection implements ServiceConnection {
        private RemoteServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(NothingCore.TAG, "Service connected");
            NothingCore.this.mService = INothingService.Stub.asInterface(iBinder);
            if (NothingCore.this.mCallback != null) {
                NothingCore.this.mCallback.onServiceConnected(componentName);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(NothingCore.TAG, "Service disconnected");
            NothingCore.this.mService = null;
            if (NothingCore.this.mCallback != null) {
                NothingCore.this.mCallback.onServiceDisconnected(componentName);
            }
        }
    }
}
