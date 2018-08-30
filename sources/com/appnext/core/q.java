package com.appnext.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public abstract class q {
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            q.this.mMessenger = new Messenger(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            q.this.mMessenger = null;
        }
    };
    private Messenger mMessenger;

    protected Class<?> B() {
        return AdsService.class;
    }

    public void C(Context context) {
        Intent intent = new Intent(context, B());
        a(intent);
        try {
            context.bindService(intent, this.mConnection, 1);
            Message obtain = Message.obtain(null, AdsService.ADD_PACK, 0, 0);
            obtain.setData(intent.getExtras());
            this.mMessenger.send(obtain);
        } catch (Throwable th) {
            context.startService(intent);
        }
    }

    protected abstract void a(Intent intent);

    public void d(Context context) {
        try {
            context.unbindService(this.mConnection);
            this.mMessenger = null;
            this.mConnection = null;
        } catch (Throwable th) {
        }
    }
}
