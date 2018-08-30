package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class g implements ServiceConnection {
    private final int a;
    private final /* synthetic */ BaseGmsClient b;

    public g(BaseGmsClient baseGmsClient, int i) {
        this.b = baseGmsClient;
        this.a = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.b.c(16);
            return;
        }
        synchronized (this.b.q) {
            this.b.r = ag.a(iBinder);
        }
        this.b.a(0, null, this.a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.b.q) {
            this.b.r = null;
        }
        this.b.a.sendMessage(this.b.a.obtainMessage(6, this.a, 1));
    }
}
