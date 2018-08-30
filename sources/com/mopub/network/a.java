package com.mopub.network;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Request;

class a {
    final int a;
    @NonNull
    final Handler b;
    @NonNull
    final Runnable c;
    final /* synthetic */ MoPubRequestQueue d;

    a(MoPubRequestQueue moPubRequestQueue, @NonNull Request<?> request, int i) {
        this(moPubRequestQueue, request, i, new Handler());
    }

    @VisibleForTesting
    a(final MoPubRequestQueue moPubRequestQueue, @NonNull final Request<?> request, int i, @NonNull Handler handler) {
        this.d = moPubRequestQueue;
        this.a = i;
        this.b = handler;
        this.c = new Runnable() {
            public void run() {
                a.this.d.a.remove(request);
                a.this.d.add(request);
            }
        };
    }

    void a() {
        this.b.postDelayed(this.c, (long) this.a);
    }

    void b() {
        this.b.removeCallbacks(this.c);
    }
}
