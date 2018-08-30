package com.mopub.volley;

public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private int a;
    private int b;
    private final int c;
    private final float d;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    protected boolean a() {
        return this.b <= this.c;
    }

    public float getBackoffMultiplier() {
        return this.d;
    }

    public int getCurrentRetryCount() {
        return this.b;
    }

    public int getCurrentTimeout() {
        return this.a;
    }

    public void retry(VolleyError volleyError) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if (!a()) {
            throw volleyError;
        }
    }
}
