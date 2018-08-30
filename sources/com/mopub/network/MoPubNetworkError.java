package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError {
    @NonNull
    private final Reason a;
    @Nullable
    private final Integer b;

    public enum Reason {
        WARMING_UP,
        NO_FILL,
        BAD_HEADER_DATA,
        BAD_BODY,
        TRACKING_FAILURE,
        UNSPECIFIED
    }

    public MoPubNetworkError(@NonNull Reason reason) {
        this.a = reason;
        this.b = null;
    }

    public MoPubNetworkError(@NonNull NetworkResponse networkResponse, @NonNull Reason reason) {
        super(networkResponse);
        this.a = reason;
        this.b = null;
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Reason reason) {
        this(str, reason, null);
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Reason reason, @Nullable Integer num) {
        super(str);
        this.a = reason;
        this.b = num;
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Throwable th, @NonNull Reason reason) {
        super(str, th);
        this.a = reason;
        this.b = null;
    }

    public MoPubNetworkError(@NonNull Throwable th, @NonNull Reason reason) {
        super(th);
        this.a = reason;
        this.b = null;
    }

    @NonNull
    public Reason getReason() {
        return this.a;
    }

    @Nullable
    public Integer getRefreshTimeMillis() {
        return this.b;
    }
}
