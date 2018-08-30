package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.ano;
import com.google.android.gms.internal.ads.anq;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzpb;
import java.util.List;

final class af implements Runnable {
    private final /* synthetic */ zzpb a;
    private final /* synthetic */ int b;
    private final /* synthetic */ List c;
    private final /* synthetic */ ac d;

    af(ac acVar, zzpb zzpb, int i, List list) {
        this.d = acVar;
        this.a = zzpb;
        this.b = i;
        this.c = list;
    }

    public final void run() {
        boolean z = true;
        try {
            ac acVar;
            Object a;
            if ((this.a instanceof anq) && this.d.e.t != null) {
                acVar = this.d;
                if (this.b == this.c.size() - 1) {
                    z = false;
                }
                acVar.c = z;
                a = ac.b(this.a);
                this.d.e.t.zza(a);
                this.d.a(a.zzka());
            } else if ((this.a instanceof anq) && this.d.e.s != null) {
                acVar = this.d;
                if (this.b == this.c.size() - 1) {
                    z = false;
                }
                acVar.c = z;
                anq anq = (anq) this.a;
                this.d.e.s.zza(anq);
                this.d.a(anq.zzka());
            } else if ((this.a instanceof ano) && this.d.e.t != null) {
                acVar = this.d;
                if (this.b == this.c.size() - 1) {
                    z = false;
                }
                acVar.c = z;
                a = ac.b(this.a);
                this.d.e.t.zza(a);
                this.d.a(a.zzka());
            } else if (!(this.a instanceof ano) || this.d.e.r == null) {
                a aVar = this.d;
                if (this.b == this.c.size() - 1) {
                    z = false;
                }
                aVar.a(3, z);
            } else {
                acVar = this.d;
                if (this.b == this.c.size() - 1) {
                    z = false;
                }
                acVar.c = z;
                ano ano = (ano) this.a;
                this.d.e.r.zza(ano);
                this.d.a(ano.zzka());
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
