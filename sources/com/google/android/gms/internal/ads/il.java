package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@zzadh
public final class il {
    private boolean a = false;
    private float b = 1.0f;

    public static float a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? 0.0f : ((float) audioManager.getStreamVolume(3)) / ((float) streamMaxVolume);
    }

    private final synchronized boolean c() {
        return this.b >= 0.0f;
    }

    public final synchronized float a() {
        return c() ? this.b : 1.0f;
    }

    public final synchronized void a(float f) {
        this.b = f;
    }

    public final synchronized void a(boolean z) {
        this.a = z;
    }

    public final synchronized boolean b() {
        return this.a;
    }
}
