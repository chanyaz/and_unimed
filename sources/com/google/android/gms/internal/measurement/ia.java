package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import java.util.ArrayList;
import java.util.List;

final class ia implements zzek {
    iu a;
    List<Long> b;
    List<ir> c;
    private long d;
    private final /* synthetic */ hw e;

    private ia(hw hwVar) {
        this.e = hwVar;
    }

    /* synthetic */ ia(hw hwVar, hx hxVar) {
        this(hwVar);
    }

    private static long a(ir irVar) {
        return ((irVar.e.longValue() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, ir irVar) {
        ar.a((Object) irVar);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.c.size() > 0 && a((ir) this.c.get(0)) != a(irVar)) {
            return false;
        }
        long d = this.d + ((long) irVar.d());
        if (d >= ((long) Math.max(0, ((Integer) dg.j.b()).intValue()))) {
            return false;
        }
        this.d = d;
        this.c.add(irVar);
        this.b.add(Long.valueOf(j));
        return this.c.size() < Math.max(1, ((Integer) dg.k.b()).intValue());
    }

    public final void zzb(iu iuVar) {
        ar.a((Object) iuVar);
        this.a = iuVar;
    }
}
