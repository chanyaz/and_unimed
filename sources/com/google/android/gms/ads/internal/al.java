package com.google.android.gms.ads.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzjj;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class al {
    private final an a;
    private final Runnable b;
    @Nullable
    private zzjj c;
    private boolean d;
    private boolean e;
    private long f;

    public al(a aVar) {
        this(aVar, new an(ht.a));
    }

    @VisibleForTesting
    private al(a aVar, an anVar) {
        this.d = false;
        this.e = false;
        this.f = 0;
        this.a = anVar;
        this.b = new am(this, new WeakReference(aVar));
    }

    public final void a() {
        this.d = false;
        this.a.a(this.b);
    }

    public final void a(zzjj zzjj) {
        this.c = zzjj;
    }

    public final void a(zzjj zzjj, long j) {
        if (this.d) {
            kk.e("An ad refresh is already scheduled.");
            return;
        }
        this.c = zzjj;
        this.d = true;
        this.f = j;
        if (!this.e) {
            kk.d("Scheduling ad refresh " + j + " milliseconds from now.");
            this.a.a(this.b, j);
        }
    }

    public final void b() {
        this.e = true;
        if (this.d) {
            this.a.a(this.b);
        }
    }

    public final void b(zzjj zzjj) {
        a(zzjj, 60000);
    }

    public final void c() {
        this.e = false;
        if (this.d) {
            this.d = false;
            a(this.c, this.f);
        }
    }

    public final void d() {
        this.e = false;
        this.d = false;
        if (!(this.c == null || this.c.c == null)) {
            this.c.c.remove("_ad");
        }
        a(this.c, 0);
    }

    public final boolean e() {
        return this.d;
    }
}
