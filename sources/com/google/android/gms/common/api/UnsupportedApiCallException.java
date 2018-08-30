package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature a;

    public UnsupportedApiCallException(Feature feature) {
        this.a = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.a);
        return new StringBuilder(String.valueOf(valueOf).length() + 8).append("Missing ").append(valueOf).toString();
    }
}
