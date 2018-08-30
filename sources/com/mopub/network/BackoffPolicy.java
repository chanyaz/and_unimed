package com.mopub.network;

import com.mopub.volley.VolleyError;

public abstract class BackoffPolicy {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;

    public abstract void backoff(VolleyError volleyError);

    public int getBackoffMs() {
        return this.a;
    }

    public int getRetryCount() {
        return this.d;
    }

    public boolean hasAttemptRemaining() {
        return this.d < this.e;
    }
}
