package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class afg implements zzfa {
    private final Object a = new Object();
    private final WeakHashMap<gr, afh> b = new WeakHashMap();
    private final ArrayList<afh> c = new ArrayList();
    private final Context d;
    private final zzang e;
    private final asy f;

    public afg(Context context, zzang zzang) {
        this.d = context.getApplicationContext();
        this.e = zzang;
        this.f = new asy(context.getApplicationContext(), zzang, (String) akc.f().a(amn.a));
    }

    private final boolean e(gr grVar) {
        boolean z;
        synchronized (this.a) {
            afh afh = (afh) this.b.get(grVar);
            z = afh != null && afh.c();
        }
        return z;
    }

    public final void a(gr grVar) {
        synchronized (this.a) {
            afh afh = (afh) this.b.get(grVar);
            if (afh != null) {
                afh.b();
            }
        }
    }

    public final void a(zzjn zzjn, gr grVar) {
        a(zzjn, grVar, grVar.b.getView());
    }

    public final void a(zzjn zzjn, gr grVar, View view) {
        a(zzjn, grVar, new afn(view, grVar), null);
    }

    public final void a(zzjn zzjn, gr grVar, View view, zzaqw zzaqw) {
        a(zzjn, grVar, new afn(view, grVar), zzaqw);
    }

    public final void a(zzjn zzjn, gr grVar, zzgd zzgd, @Nullable zzaqw zzaqw) {
        synchronized (this.a) {
            afh afh;
            if (e(grVar)) {
                afh = (afh) this.b.get(grVar);
            } else {
                afh = new afh(this.d, zzjn, grVar, this.e, zzgd);
                afh.a((zzfa) this);
                this.b.put(grVar, afh);
                this.c.add(afh);
            }
            if (zzaqw != null) {
                afh.a(new afp(afh, zzaqw));
            } else {
                afh.a(new aft(afh, this.f, this.d));
            }
        }
    }

    public final void b(gr grVar) {
        synchronized (this.a) {
            afh afh = (afh) this.b.get(grVar);
            if (afh != null) {
                afh.d();
            }
        }
    }

    public final void c(gr grVar) {
        synchronized (this.a) {
            afh afh = (afh) this.b.get(grVar);
            if (afh != null) {
                afh.e();
            }
        }
    }

    public final void d(gr grVar) {
        synchronized (this.a) {
            afh afh = (afh) this.b.get(grVar);
            if (afh != null) {
                afh.f();
            }
        }
    }

    public final void zza(afh afh) {
        synchronized (this.a) {
            if (!afh.c()) {
                this.c.remove(afh);
                Iterator it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == afh) {
                        it.remove();
                    }
                }
            }
        }
    }
}
