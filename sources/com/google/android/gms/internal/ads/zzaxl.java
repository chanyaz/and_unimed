package com.google.android.gms.internal.ads;

public enum zzaxl implements zzbbr {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final zzbbs<zzaxl> f = null;
    private final int g;

    static {
        f = new tt();
    }

    private zzaxl(int i) {
        this.g = i;
    }

    public static zzaxl a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
            default:
                return null;
        }
    }

    public final int zzhq() {
        if (this != UNRECOGNIZED) {
            return this.g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
