package com.google.android.gms.internal.ads;

final /* synthetic */ class qx {
    static final /* synthetic */ int[] a = new int[zzaxa.values().length];
    static final /* synthetic */ int[] b = new int[zzawy.values().length];
    static final /* synthetic */ int[] c = new int[zzawk.values().length];

    static {
        try {
            c[zzawk.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            c[zzawk.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[zzawy.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[zzawy.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            b[zzawy.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[zzaxa.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[zzaxa.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[zzaxa.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}
