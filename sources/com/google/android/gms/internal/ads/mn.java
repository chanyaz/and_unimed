package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@zzadh
@TargetApi(14)
public final class mn {
    private final long a = TimeUnit.MILLISECONDS.toNanos(((Long) akc.f().a(amn.x)).longValue());
    private long b;
    private boolean c = true;

    mn() {
    }

    public final void a() {
        this.c = true;
    }

    public final void a(SurfaceTexture surfaceTexture, zzapf zzapf) {
        if (zzapf != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.c || Math.abs(timestamp - this.b) >= this.a) {
                this.c = false;
                this.b = timestamp;
                ht.a.post(new mo(this, zzapf));
            }
        }
    }
}
