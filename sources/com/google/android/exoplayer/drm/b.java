package com.google.android.exoplayer.drm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class b extends a {
    private final Map<UUID, byte[]> b = new HashMap();

    public b(String str) {
        super(str);
    }

    public void a(UUID uuid, byte[] bArr) {
        this.b.put(uuid, bArr);
    }

    public byte[] a(UUID uuid) {
        return (byte[]) this.b.get(uuid);
    }
}
