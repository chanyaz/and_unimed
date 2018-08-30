package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.ad;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.nw;
import com.google.android.gms.internal.ads.op;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzxn;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public abstract class bd extends ay implements zzaf, zzaam {
    private boolean k;

    public bd(Context context, zzjn zzjn, String str, zzxn zzxn, zzang zzang, br brVar) {
        super(context, zzjn, str, zzxn, zzang, brVar);
    }

    protected zzaqw a(gs gsVar, @Nullable bs bsVar, @Nullable zzait zzait) {
        View nextView = this.e.f.getNextView();
        if (nextView instanceof zzaqw) {
            ((zzaqw) nextView).destroy();
        }
        if (nextView != null) {
            this.e.f.removeView(nextView);
        }
        au.f();
        zzaqw a = nw.a(this.e.c, op.a(this.e.i), this.e.i.a, false, false, this.e.d, this.e.e, this.a, this, this.i, gsVar.i);
        if (this.e.i.g == null) {
            a(a.getView());
        }
        a.zzuf().zza(this, this, this, this, this, false, null, bsVar, this, zzait);
        a(a);
        a.zzdr(gsVar.a.v);
        return a;
    }

    protected void a(gs gsVar, ana ana) {
        if (gsVar.e != -2) {
            ht.a.post(new bf(this, gsVar));
            return;
        }
        if (gsVar.d != null) {
            this.e.i = gsVar.d;
        }
        if (!gsVar.b.g || gsVar.b.z) {
            ht.a.post(new bg(this, gsVar, this.i.c.zza(this.e.c, this.e.e, gsVar.b), ana));
            return;
        }
        this.e.I = 0;
        av avVar = this.e;
        au.d();
        avVar.h = ad.a(this.e.c, this, gsVar, this.e.d, null, this.j, this, ana);
    }

    protected final void a(zzaqw zzaqw) {
        zzaqw.zza("/trackActiveViewUnit", new be(this));
    }

    protected boolean a(@Nullable gr grVar, gr grVar2) {
        if (this.e.d() && this.e.f != null) {
            this.e.f.a().c(grVar2.A);
        }
        try {
            if (!(grVar2.b == null || grVar2.n || !grVar2.M)) {
                if (((Boolean) akc.f().a(amn.dl)).booleanValue() && !grVar2.a.c.containsKey("sdk_less_server_data")) {
                    try {
                        grVar2.b.zzus();
                    } catch (Throwable th) {
                        hl.a("Could not render test Ad label.");
                    }
                }
            }
        } catch (RuntimeException e) {
            hl.a("Could not render test AdLabel.");
        }
        return super.a(grVar, grVar2);
    }

    @VisibleForTesting
    final void b(zzaqw zzaqw) {
        if (this.e.j != null) {
            this.g.a(this.e.i, this.e.j, zzaqw.getView(), zzaqw);
            this.k = false;
            return;
        }
        this.k = true;
        kk.e("Request to enable ActiveView before adState is available.");
    }

    protected void e() {
        super.e();
        if (this.k) {
            if (((Boolean) akc.f().a(amn.cg)).booleanValue()) {
                b(this.e.j.b);
            }
        }
    }

    protected final boolean l() {
        return (this.e.k == null || this.e.k.b == null || !this.e.k.b.Q) ? false : true;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        d();
    }

    public final void zza(zzod zzod) {
        ar.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.e.B = zzod;
    }

    public final void zzcn() {
        onAdClicked();
    }

    public final void zzco() {
        recordImpression();
        zzbm();
    }

    public final void zzcq() {
        b();
    }

    public final void zzh(View view) {
        this.e.H = view;
        zzb(new gr(this.e.k, null, null, null, null, null, null, null));
    }
}
