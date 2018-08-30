package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.k;
import com.google.android.gms.ads.m;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.util.concurrent.atomic.AtomicBoolean;

@zzadh
public final class alk {
    private final auv a;
    private final ajq b;
    private final AtomicBoolean c;
    private final k d;
    @VisibleForTesting
    private final ake e;
    private zzjd f;
    private a g;
    private f[] h;
    private AppEventListener i;
    private g j;
    private zzks k;
    private OnCustomRenderedAdLoadedListener l;
    private m m;
    private String n;
    private ViewGroup o;
    private int p;
    private boolean q;

    public alk(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, ajq.a, i);
    }

    public alk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, ajq.a, 0);
    }

    public alk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, ajq.a, i);
    }

    @VisibleForTesting
    private alk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, ajq ajq, int i) {
        this(viewGroup, attributeSet, z, ajq, null, i);
    }

    @VisibleForTesting
    private alk(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, ajq ajq, zzks zzks, int i) {
        this.a = new auv();
        this.d = new k();
        this.e = new all(this);
        this.o = viewGroup;
        this.b = ajq;
        this.k = null;
        this.c = new AtomicBoolean(false);
        this.p = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzjq zzjq = new zzjq(context, attributeSet);
                this.h = zzjq.a(z);
                this.n = zzjq.a();
                if (viewGroup.isInEditMode()) {
                    kb a = akc.a();
                    f fVar = this.h[0];
                    int i2 = this.p;
                    zzjn zzjn = new zzjn(context, fVar);
                    zzjn.j = a(i2);
                    a.a(viewGroup, zzjn, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                akc.a().a(viewGroup, new zzjn(context, f.a), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzjn a(Context context, f[] fVarArr, int i) {
        zzjn zzjn = new zzjn(context, fVarArr);
        zzjn.j = a(i);
        return zzjn;
    }

    private static boolean a(int i) {
        return i == 1;
    }

    public final void a() {
        try {
            if (this.k != null) {
                this.k.destroy();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(a aVar) {
        this.g = aVar;
        this.e.a(aVar);
    }

    public final void a(AppEventListener appEventListener) {
        try {
            this.i = appEventListener;
            if (this.k != null) {
                this.k.zza(appEventListener != null ? new ajs(appEventListener) : null);
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.l = onCustomRenderedAdLoadedListener;
        try {
            if (this.k != null) {
                this.k.zza(onCustomRenderedAdLoadedListener != null ? new anh(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(g gVar) {
        this.j = gVar;
        try {
            if (this.k != null) {
                this.k.zza(this.j == null ? null : this.j.a());
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(m mVar) {
        this.m = mVar;
        try {
            if (this.k != null) {
                this.k.zza(mVar == null ? null : new zzmu(mVar));
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(ali ali) {
        try {
            if (this.k == null) {
                if ((this.h == null || this.n == null) && this.k == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.o.getContext();
                zzjn a = a(context, this.h, this.p);
                this.k = "search_v2".equals(a.a) ? (zzks) ajt.a(context, false, new ajw(akc.b(), context, a, this.n)) : (zzks) ajt.a(context, false, new ajv(akc.b(), context, a, this.n, this.a));
                this.k.zza(new ajk(this.e));
                if (this.f != null) {
                    this.k.zza(new ajj(this.f));
                }
                if (this.i != null) {
                    this.k.zza(new ajs(this.i));
                }
                if (this.l != null) {
                    this.k.zza(new anh(this.l));
                }
                if (this.j != null) {
                    this.k.zza(this.j.a());
                }
                if (this.m != null) {
                    this.k.zza(new zzmu(this.m));
                }
                this.k.setManualImpressionsEnabled(this.q);
                try {
                    IObjectWrapper zzbj = this.k.zzbj();
                    if (zzbj != null) {
                        this.o.addView((View) c.a(zzbj));
                    }
                } catch (Throwable e) {
                    kk.d("#007 Could not call remote method.", e);
                }
            }
            if (this.k.zzb(ajq.a(this.o.getContext(), ali))) {
                this.a.a(ali.j());
            }
        } catch (Throwable e2) {
            kk.d("#007 Could not call remote method.", e2);
        }
    }

    public final void a(zzjd zzjd) {
        try {
            this.f = zzjd;
            if (this.k != null) {
                this.k.zza(zzjd != null ? new ajj(zzjd) : null);
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(String str) {
        if (this.n != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.n = str;
    }

    public final void a(boolean z) {
        this.q = z;
        try {
            if (this.k != null) {
                this.k.setManualImpressionsEnabled(this.q);
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(f... fVarArr) {
        if (this.h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(fVarArr);
    }

    public final a b() {
        return this.g;
    }

    public final void b(f... fVarArr) {
        this.h = fVarArr;
        try {
            if (this.k != null) {
                this.k.zza(a(this.o.getContext(), this.h, this.p));
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        this.o.requestLayout();
    }

    public final f c() {
        try {
            if (this.k != null) {
                zzjn zzbk = this.k.zzbk();
                if (zzbk != null) {
                    return zzbk.b();
                }
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        return this.h != null ? this.h[0] : null;
    }

    public final f[] d() {
        return this.h;
    }

    public final String e() {
        if (this.n == null && this.k != null) {
            try {
                this.n = this.k.getAdUnitId();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        return this.n;
    }

    public final AppEventListener f() {
        return this.i;
    }

    public final OnCustomRenderedAdLoadedListener g() {
        return this.l;
    }

    public final void h() {
        try {
            if (this.k != null) {
                this.k.pause();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void i() {
        try {
            if (this.k != null) {
                this.k.resume();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final String j() {
        try {
            if (this.k != null) {
                return this.k.zzck();
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
        return null;
    }

    public final k k() {
        return this.d;
    }

    public final zzlo l() {
        zzlo zzlo = null;
        if (this.k == null) {
            return zzlo;
        }
        try {
            return this.k.getVideoController();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            return zzlo;
        }
    }

    public final m m() {
        return this.m;
    }
}
