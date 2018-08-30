package com.mopub.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
class b extends BroadcastReceiver {
    final /* synthetic */ MraidController a;
    @Nullable
    private Context b;
    private int c = -1;

    b(MraidController mraidController) {
        this.a = mraidController;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.b != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
            int l = this.a.f();
            if (l != this.c) {
                this.c = l;
                this.a.a(this.c);
            }
        }
    }

    public void register(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        this.b = context.getApplicationContext();
        if (this.b != null) {
            this.b.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public void unregister() {
        if (this.b != null) {
            this.b.unregisterReceiver(this);
            this.b = null;
        }
    }
}
