package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
final class r extends BroadcastReceiver {
    @Nullable
    private q a;

    public r(q qVar) {
        this.a = qVar;
    }

    public final void a() {
        if (FirebaseInstanceId.i()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a != null && this.a.b()) {
            if (FirebaseInstanceId.i()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.a, 0);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
