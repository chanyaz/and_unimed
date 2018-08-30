package android.support.v7.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
final class r {
    final /* synthetic */ p a;
    private ag b;
    private boolean c;
    private BroadcastReceiver d;
    private IntentFilter e;

    r(p pVar, @NonNull ag agVar) {
        this.a = pVar;
        this.b = agVar;
        this.c = agVar.a();
    }

    final int a() {
        this.c = this.b.a();
        return this.c ? 2 : 1;
    }

    final void b() {
        boolean a = this.b.a();
        if (a != this.c) {
            this.c = a;
            this.a.j();
        }
    }

    final void c() {
        d();
        if (this.d == null) {
            this.d = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    r.this.b();
                }
            };
        }
        if (this.e == null) {
            this.e = new IntentFilter();
            this.e.addAction("android.intent.action.TIME_SET");
            this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
            this.e.addAction("android.intent.action.TIME_TICK");
        }
        this.a.a.registerReceiver(this.d, this.e);
    }

    final void d() {
        if (this.d != null) {
            this.a.a.unregisterReceiver(this.d);
            this.d = null;
        }
    }
}
