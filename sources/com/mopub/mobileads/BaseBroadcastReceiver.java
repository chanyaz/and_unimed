package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.c;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    private final long a;
    @Nullable
    private Context b;

    public BaseBroadcastReceiver(long j) {
        this.a = j;
    }

    static void a(@NonNull Context context, long j, @NonNull String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "action cannot be null");
        Intent intent = new Intent(str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        c.a(context.getApplicationContext()).a(intent);
    }

    @NonNull
    public abstract IntentFilter getIntentFilter();

    public void register(@NonNull BroadcastReceiver broadcastReceiver, Context context) {
        this.b = context;
        c.a(this.b).a(broadcastReceiver, getIntentFilter());
    }

    public boolean shouldConsumeBroadcast(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent, "intent cannot be null");
        return this.a == intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1);
    }

    public void unregister(@Nullable BroadcastReceiver broadcastReceiver) {
        if (this.b != null && broadcastReceiver != null) {
            c.a(this.b).a(broadcastReceiver);
            this.b = null;
        }
    }
}
