package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.appnext.base.b.c;
import com.google.android.gms.common.util.e;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class oe extends ald {
    private final zzapw a;
    private final Object b = new Object();
    private final boolean c;
    private final boolean d;
    private final float e;
    @GuardedBy("lock")
    private int f;
    @GuardedBy("lock")
    private zzlr g;
    @GuardedBy("lock")
    private boolean h;
    @GuardedBy("lock")
    private boolean i = true;
    @GuardedBy("lock")
    private float j;
    @GuardedBy("lock")
    private float k;
    @GuardedBy("lock")
    private boolean l = true;
    @GuardedBy("lock")
    private boolean m;
    @GuardedBy("lock")
    private boolean n;

    public oe(zzapw zzapw, float f, boolean z, boolean z2) {
        this.a = zzapw;
        this.e = f;
        this.c = z;
        this.d = z2;
    }

    private final void a(String str, @Nullable Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(c.jD, str);
        lf.a.execute(new of(this, hashMap));
    }

    public final void a(float f, int i, boolean z, float f2) {
        boolean z2;
        int i2;
        synchronized (this.b) {
            this.j = f;
            z2 = this.i;
            this.i = z;
            i2 = this.f;
            this.f = i;
            float f3 = this.k;
            this.k = f2;
            if (Math.abs(this.k - f3) > 1.0E-4f) {
                this.a.getView().invalidate();
            }
        }
        lf.a.execute(new og(this, i2, i, z2, z));
    }

    public final void a(zzmu zzmu) {
        synchronized (this.b) {
            this.l = zzmu.a;
            this.m = zzmu.b;
            this.n = zzmu.c;
        }
        a("initialState", e.a("muteStart", zzmu.a ? "1" : "0", "customControlsRequested", zzmu.b ? "1" : "0", "clickToExpandRequested", zzmu.c ? "1" : "0"));
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.b) {
            f = this.k;
        }
        return f;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.b) {
            i = this.f;
        }
        return i;
    }

    public final boolean isClickToExpandEnabled() {
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.b) {
            if (!isCustomControlsEnabled) {
                if (this.n && this.d) {
                    isCustomControlsEnabled = true;
                }
            }
            isCustomControlsEnabled = false;
        }
        return isCustomControlsEnabled;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.b) {
            z = this.c && this.m;
        }
        return z;
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.b) {
            z = this.i;
        }
        return z;
    }

    public final void mute(boolean z) {
        a(z ? "mute" : "unmute", null);
    }

    public final void pause() {
        a("pause", null);
    }

    public final void play() {
        a("play", null);
    }

    public final void zza(zzlr zzlr) {
        synchronized (this.b) {
            this.g = zzlr;
        }
    }

    public final float zzim() {
        return this.e;
    }

    public final float zzin() {
        float f;
        synchronized (this.b) {
            f = this.j;
        }
        return f;
    }

    public final zzlr zzio() {
        zzlr zzlr;
        synchronized (this.b) {
            zzlr = this.g;
        }
        return zzlr;
    }
}
