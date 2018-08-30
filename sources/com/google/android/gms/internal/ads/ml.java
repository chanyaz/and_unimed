package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public final class ml {
    private final Context a;
    private final zzapw b;
    private final ViewGroup c;
    private mg d;

    @VisibleForTesting
    private ml(Context context, ViewGroup viewGroup, zzapw zzapw, mg mgVar) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.a = context;
        this.c = viewGroup;
        this.b = zzapw;
        this.d = null;
    }

    public ml(Context context, ViewGroup viewGroup, zzaqw zzaqw) {
        this(context, viewGroup, zzaqw, null);
    }

    public final mg a() {
        ar.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }

    public final void a(int i, int i2, int i3, int i4) {
        ar.b("The underlay may only be modified from the UI thread.");
        if (this.d != null) {
            this.d.a(i, i2, i3, i4);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, boolean z, ms msVar) {
        if (this.d == null) {
            amt.a(this.b.zztp().a(), this.b.zztn(), "vpr2");
            this.d = new mg(this.a, this.b, i5, z, this.b.zztp().a(), msVar);
            this.c.addView(this.d, 0, new LayoutParams(-1, -1));
            this.d.a(i, i2, i3, i4);
            this.b.zzah(false);
        }
    }

    public final void b() {
        ar.b("onPause must be called from the UI thread.");
        if (this.d != null) {
            this.d.b();
        }
    }

    public final void c() {
        ar.b("onDestroy must be called from the UI thread.");
        if (this.d != null) {
            this.d.g();
            this.c.removeView(this.d);
            this.d = null;
        }
    }
}
