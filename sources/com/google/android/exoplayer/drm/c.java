package com.google.android.exoplayer.drm;

import java.util.UUID;

public final class c extends a {
    private byte[] b;

    public c(String str, byte[] bArr) {
        super(str);
        this.b = bArr;
    }

    public byte[] a(UUID uuid) {
        return this.b;
    }
}
