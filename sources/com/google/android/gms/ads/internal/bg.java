package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.ad;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.anb;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzoa;

final class bg implements Runnable {
    final /* synthetic */ gs a;
    final /* synthetic */ zzait b;
    final /* synthetic */ bd c;
    private final /* synthetic */ ana d;

    bg(bd bdVar, gs gsVar, zzait zzait, ana ana) {
        this.c = bdVar;
        this.a = gsVar;
        this.b = zzait;
        this.d = ana;
    }

    public final void run() {
        if (this.a.b.r && this.c.e.B != null) {
            String str = null;
            if (this.a.b.a != null) {
                au.e();
                str = ht.a(this.a.b.a);
            }
            zzoa anb = new anb(this.c, str, this.a.b.b);
            this.c.e.I = 1;
            try {
                this.c.c = false;
                this.c.e.B.zza(anb);
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                this.c.c = true;
            }
        }
        bs bsVar = new bs(this.c.e.c, this.b, this.a.b.E);
        try {
            zzaqw a = this.c.a(this.a, bsVar, this.b);
            a.setOnTouchListener(new bi(this, bsVar));
            a.setOnClickListener(new bj(this, bsVar));
            this.c.e.I = 0;
            av avVar = this.c.e;
            au.d();
            avVar.h = ad.a(this.c.e.c, this.c, this.a, this.c.e.d, a, this.c.j, this.c, this.d);
        } catch (Throwable e2) {
            kk.b("Could not obtain webview.", e2);
            ht.a.post(new bh(this));
        }
    }
}
