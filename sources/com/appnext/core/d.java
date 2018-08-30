package com.appnext.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class d {
    static a kX = null;

    public final class a {
        private final String kY;
        private final boolean kZ;

        a(String str, boolean z) {
            this.kY = str;
            this.kZ = z;
        }

        public boolean cW() {
            return this.kZ;
        }

        public String getId() {
            return this.kY;
        }
    }

    final class b implements ServiceConnection {
        boolean la;
        private final LinkedBlockingQueue<IBinder> lb;

        private b() {
            this.la = false;
            this.lb = new LinkedBlockingQueue(1);
        }

        public IBinder getBinder() {
            if (this.la) {
                throw new IllegalStateException();
            }
            this.la = true;
            return (IBinder) this.lb.take();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.lb.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    final class c implements IInterface {
        private IBinder lc;

        public c(IBinder iBinder) {
            this.lc = iBinder;
        }

        public IBinder asBinder() {
            return this.lc;
        }

        public boolean e(boolean z) {
            boolean z2 = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.lc.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public String getId() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.lc.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static a r(Context context) {
        if (kX != null) {
            return kX;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        ServiceConnection bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                c cVar = new c(bVar.getBinder());
                kX = new a(cVar.getId(), cVar.e(true));
                a aVar = kX;
                return aVar;
            } finally {
                context.unbindService(bVar);
            }
        } else {
            throw new IOException("Google Play connection failed");
        }
    }
}
