package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

class bu extends BroadcastReceiver {
    @VisibleForTesting
    private static final String a = bu.class.getName();
    private final ah b;
    private boolean c;
    private boolean d;

    bu(ah ahVar) {
        ar.a((Object) ahVar);
        this.b = ahVar;
    }

    private final void e() {
        this.b.e();
        this.b.h();
    }

    @VisibleForTesting
    private final boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.a().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public final void a() {
        e();
        if (!this.c) {
            Context a = this.b.a();
            a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(a.getPackageName());
            a.registerReceiver(this, intentFilter);
            this.d = f();
            this.b.e().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
            this.c = true;
        }
    }

    public final void b() {
        if (this.c) {
            this.b.e().b("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                this.b.a().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.b.e().e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @VisibleForTesting
    public final void c() {
        Context a = this.b.a();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(a.getPackageName());
        intent.putExtra(a, true);
        a.sendOrderedBroadcast(intent, null);
    }

    public final boolean d() {
        if (!this.c) {
            this.b.e().e("Connectivity unknown. Receiver not registered");
        }
        return this.d;
    }

    public void onReceive(Context context, Intent intent) {
        e();
        String action = intent.getAction();
        this.b.e().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = f();
            if (this.d != f) {
                this.d = f;
                ae h = this.b.h();
                h.a("Network connectivity status changed", Boolean.valueOf(f));
                h.m().a(new z(h, f));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.b.e().d("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(a)) {
            ae h2 = this.b.h();
            h2.b("Radio powered up");
            h2.c();
        }
    }
}
