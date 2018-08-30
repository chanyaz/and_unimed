package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
final class arw {
    private final LinkedList<arx> a = new LinkedList();
    private zzjj b;
    private final String c;
    private final int d;
    private boolean e;

    arw(zzjj zzjj, String str, int i) {
        ar.a((Object) zzjj);
        ar.a((Object) str);
        this.b = zzjj;
        this.c = str;
        this.d = i;
    }

    final arx a(@Nullable zzjj zzjj) {
        if (zzjj != null) {
            this.b = zzjj;
        }
        return (arx) this.a.remove();
    }

    final zzjj a() {
        return this.b;
    }

    final void a(aqr aqr, zzjj zzjj) {
        this.a.add(new arx(this, aqr, zzjj));
    }

    final boolean a(aqr aqr) {
        arx arx = new arx(this, aqr);
        this.a.add(arx);
        return arx.a();
    }

    final int b() {
        return this.d;
    }

    final String c() {
        return this.c;
    }

    final int d() {
        return this.a.size();
    }

    final int e() {
        int i = 0;
        Iterator it = this.a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((arx) it.next()).e ? i2 + 1 : i2;
        }
    }

    final int f() {
        int i = 0;
        Iterator it = this.a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((arx) it.next()).a() ? i2 + 1 : i2;
        }
    }

    final void g() {
        this.e = true;
    }

    final boolean h() {
        return this.e;
    }
}
