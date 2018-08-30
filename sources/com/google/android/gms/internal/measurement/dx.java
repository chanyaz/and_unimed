package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

class dx extends BroadcastReceiver {
    @VisibleForTesting
    private static final String a = dx.class.getName();
    private final hw b;
    private boolean c;
    private boolean d;

    dx(hw hwVar) {
        ar.a((Object) hwVar);
        this.b = hwVar;
    }

    @WorkerThread
    public final void a() {
        this.b.B();
        this.b.s();
        if (!this.c) {
            this.b.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = this.b.y().q();
            this.b.zzge().y().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
            this.c = true;
        }
    }

    @WorkerThread
    public final void b() {
        this.b.B();
        this.b.s();
        this.b.s();
        if (this.c) {
            this.b.zzge().y().a("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                this.b.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.b.zzge().r().a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.b.B();
        String action = intent.getAction();
        this.b.zzge().y().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean q = this.b.y().q();
            if (this.d != q) {
                this.d = q;
                this.b.zzgd().a(new dy(this, q));
                return;
            }
            return;
        }
        this.b.zzge().u().a("NetworkBroadcastReceiver received unknown action", action);
    }
}
