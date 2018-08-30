package com.google.android.exoplayer.drm;

import java.util.UUID;

public abstract class a {
    public final String a;

    public a(String str) {
        this.a = str;
    }

    public abstract byte[] a(UUID uuid);
}
