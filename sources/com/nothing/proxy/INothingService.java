package com.nothing.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface INothingService extends IInterface {
    public static final String DESCRIPTOR = "com.nothing.proxy.INothingService";

    /* loaded from: classes2.dex */
    public static class Default implements INothingService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.nothing.proxy.INothingService
        public void deviceGoToSleep(long j) throws RemoteException {
        }

        @Override // com.nothing.proxy.INothingService
        public boolean isUninstallableSystemApp(String str) throws RemoteException {
            return false;
        }

        @Override // com.nothing.proxy.INothingService
        public void uninstallSystemApp(String str, int i) throws RemoteException {
        }
    }

    void deviceGoToSleep(long j) throws RemoteException;

    boolean isUninstallableSystemApp(String str) throws RemoteException;

    void uninstallSystemApp(String str, int i) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements INothingService {
        static final int TRANSACTION_deviceGoToSleep = 1;
        static final int TRANSACTION_isUninstallableSystemApp = 2;
        static final int TRANSACTION_uninstallSystemApp = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, INothingService.DESCRIPTOR);
        }

        public static INothingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INothingService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INothingService)) {
                return (INothingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INothingService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INothingService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                long readLong = parcel.readLong();
                parcel.enforceNoDataAvail();
                deviceGoToSleep(readLong);
                parcel2.writeNoException();
            } else if (i == 2) {
                String readString = parcel.readString();
                parcel.enforceNoDataAvail();
                boolean isUninstallableSystemApp = isUninstallableSystemApp(readString);
                parcel2.writeNoException();
                parcel2.writeBoolean(isUninstallableSystemApp);
            } else if (i == 3) {
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                parcel.enforceNoDataAvail();
                uninstallSystemApp(readString2, readInt);
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements INothingService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return INothingService.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.nothing.proxy.INothingService
            public void deviceGoToSleep(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INothingService.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nothing.proxy.INothingService
            public boolean isUninstallableSystemApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INothingService.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nothing.proxy.INothingService
            public void uninstallSystemApp(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INothingService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
