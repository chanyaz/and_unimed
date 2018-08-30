package com.google.android.gms.internal.ads;

public enum zzawk implements zzbbr {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    UNRECOGNIZED(-1);
    
    private static final zzbbs<zzawk> e = null;
    private final int f;

    static {
        e = new sl();
    }

    private zzawk(int i) {
        this.f = i;
    }

    public static zzawk a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
            default:
                return null;
        }
    }

    public final int zzhq() {
        if (this != UNRECOGNIZED) {
            return this.f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
