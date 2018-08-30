package com.google.android.gms.internal.measurement;

public enum zzbq {
    NONE,
    GZIP;

    public static zzbq a(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
