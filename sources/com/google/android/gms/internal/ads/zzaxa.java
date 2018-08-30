package com.google.android.gms.internal.ads;

public enum zzaxa implements zzbbr {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzbbs<zzaxa> g = null;
    private final int h;

    static {
        g = new tg();
    }

    private zzaxa(int i) {
        this.h = i;
    }

    public static zzaxa a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA224;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
            default:
                return null;
        }
    }

    public final int zzhq() {
        if (this != UNRECOGNIZED) {
            return this.h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
