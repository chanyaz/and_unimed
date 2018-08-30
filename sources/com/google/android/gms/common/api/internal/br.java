package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

final class br implements Runnable {
    private final /* synthetic */ Result a;
    private final /* synthetic */ bq b;

    br(bq bqVar, Result result) {
        this.b = bqVar;
        this.a = result;
    }

    @WorkerThread
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            BasePendingResult.a.set(Boolean.valueOf(true));
            this.b.h.sendMessage(this.b.h.obtainMessage(0, this.b.a.a(this.a)));
            BasePendingResult.a.set(Boolean.valueOf(false));
            bq.a(this.a);
            googleApiClient = (GoogleApiClient) this.b.g.get();
            if (googleApiClient != null) {
                googleApiClient.b(this.b);
            }
        } catch (RuntimeException e) {
            this.b.h.sendMessage(this.b.h.obtainMessage(1, e));
            BasePendingResult.a.set(Boolean.valueOf(false));
            bq.a(this.a);
            googleApiClient = (GoogleApiClient) this.b.g.get();
            if (googleApiClient != null) {
                googleApiClient.b(this.b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            BasePendingResult.a.set(Boolean.valueOf(false));
            bq.a(this.a);
            googleApiClient = (GoogleApiClient) this.b.g.get();
            if (googleApiClient != null) {
                googleApiClient.b(this.b);
            }
        }
    }
}
