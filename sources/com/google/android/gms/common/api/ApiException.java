package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class ApiException extends Exception {
    protected final Status a;

    public ApiException(@NonNull Status status) {
        int d = status.d();
        String a = status.a() != null ? status.a() : "";
        super(new StringBuilder(String.valueOf(a).length() + 13).append(d).append(": ").append(a).toString());
        this.a = status;
    }
}
