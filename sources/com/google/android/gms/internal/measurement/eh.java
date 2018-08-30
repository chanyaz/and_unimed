package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.MainThread;

final class eh implements ServiceConnection {
    final /* synthetic */ ef a;

    private eh(ef efVar) {
        this.a = efVar;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.a.b.zzge().u().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            this.a.a = ja.a(iBinder);
            if (this.a.a == null) {
                this.a.b.zzge().u().a("Install Referrer Service implementation was not found");
                return;
            }
            this.a.b.zzge().w().a("Install Referrer Service connected");
            this.a.b.zzgd().a(new ei(this));
        } catch (Exception e) {
            this.a.b.zzge().u().a("Exception occurred while calling Install Referrer API", e);
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
        this.a.b.zzge().w().a("Install Referrer Service disconnected");
    }
}
