package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.tasks.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class ah {
    @GuardedBy("MessengerIpcClient.class")
    private static ah a;
    private final Context b;
    private final ScheduledExecutorService c;
    @GuardedBy("this")
    private aj d = new aj(this);
    @GuardedBy("this")
    private int e = 1;

    @VisibleForTesting
    private ah(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
        this.b = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i;
        i = this.e;
        this.e = i + 1;
        return i;
    }

    private final synchronized <T> a<T> a(d<T> dVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(dVar);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf).toString());
        }
        if (!this.d.a((d) dVar)) {
            this.d = new aj(this);
            this.d.a((d) dVar);
        }
        return dVar.b.a();
    }

    public static synchronized ah a(Context context) {
        ah ahVar;
        synchronized (ah.class) {
            if (a == null) {
                a = new ah(context, Executors.newSingleThreadScheduledExecutor());
            }
            ahVar = a;
        }
        return ahVar;
    }

    public final a<Void> a(int i, Bundle bundle) {
        return a(new c(a(), 2, bundle));
    }

    public final a<Bundle> b(int i, Bundle bundle) {
        return a(new e(a(), 1, bundle));
    }
}
