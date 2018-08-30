package com.google.android.gms.internal.ads;

final /* synthetic */ class vn {
    static final /* synthetic */ int[] a = new int[zzayw.values().length];
    static final /* synthetic */ int[] b = new int[zzayv.values().length];

    static {
        try {
            b[zzayv.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[zzayv.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[zzayv.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[zzayw.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[zzayw.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
