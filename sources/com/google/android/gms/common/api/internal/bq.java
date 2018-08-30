package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.ar;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public final class bq<R extends Result> extends l<R> implements ResultCallback<R> {
    private k<? super R, ? extends Result> a;
    private bq<? extends Result> b;
    private volatile j<? super R> c;
    private PendingResult<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<GoogleApiClient> g;
    private final bs h;
    private boolean i;

    private static void a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private final void a(Status status) {
        synchronized (this.e) {
            this.f = status;
            b(this.f);
        }
    }

    @GuardedBy("mSyncToken")
    private final void b() {
        if (this.a != null || this.c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.g.get();
            if (!(this.i || this.a == null || googleApiClient == null)) {
                googleApiClient.a(this);
                this.i = true;
            }
            if (this.f != null) {
                b(this.f);
            } else if (this.d != null) {
                this.d.a((ResultCallback) this);
            }
        }
    }

    private final void b(Status status) {
        synchronized (this.e) {
            if (this.a != null) {
                Status a = this.a.a(status);
                ar.a((Object) a, (Object) "onFailure must not return null");
                this.b.a(a);
            } else if (c()) {
                this.c.a(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean c() {
        return (this.c == null || ((GoogleApiClient) this.g.get()) == null) ? false : true;
    }

    final void a() {
        this.c = null;
    }

    public final void a(PendingResult<?> pendingResult) {
        synchronized (this.e) {
            this.d = pendingResult;
            b();
        }
    }

    public final void onResult(R r) {
        synchronized (this.e) {
            if (!r.getStatus().c()) {
                a(r.getStatus());
                a((Result) r);
            } else if (this.a != null) {
                bj.a().submit(new br(this, r));
            } else if (c()) {
                this.c.a((Result) r);
            }
        }
    }
}
