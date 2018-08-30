package com.google.android.gms.internal.ads;

enum ya {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);
    
    private final boolean e;

    private ya(boolean z) {
        this.e = z;
    }
}
