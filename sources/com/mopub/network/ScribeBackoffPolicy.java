package com.mopub.network;

import com.mopub.common.VisibleForTesting;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;

public class ScribeBackoffPolicy extends BackoffPolicy {
    public ScribeBackoffPolicy() {
        this(60000, 5, 2);
    }

    @VisibleForTesting
    ScribeBackoffPolicy(int i, int i2, int i3) {
        this.c = i;
        this.e = i2;
        this.b = i3;
    }

    private void a() {
        this.a = (int) (Math.pow((double) this.b, (double) this.d) * ((double) this.c));
        this.d++;
    }

    public void backoff(VolleyError volleyError) {
        if (!hasAttemptRemaining()) {
            throw volleyError;
        } else if (volleyError instanceof NoConnectionError) {
            a();
        } else {
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (networkResponse == null || !(networkResponse.statusCode == 503 || networkResponse.statusCode == 504)) {
                throw volleyError;
            }
            a();
        }
    }
}
