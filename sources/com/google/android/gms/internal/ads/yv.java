package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

final class yv extends ys {
    private yv() {
        super();
    }

    private static <E> zzbbt<E> c(Object obj, long j) {
        return (zzbbt) aal.f(obj, j);
    }

    final <L> List<L> a(Object obj, long j) {
        zzbbt c = c(obj, j);
        if (c.zzaay()) {
            return c;
        }
        int size = c.size();
        Object zzbm = c.zzbm(size == 0 ? 10 : size << 1);
        aal.a(obj, j, zzbm);
        return zzbm;
    }

    final <E> void a(Object obj, Object obj2, long j) {
        Object c = c(obj, j);
        Collection c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.zzaay()) {
                c = c.zzbm(size2 + size);
            }
            c.addAll(c2);
        }
        if (size <= 0) {
            Collection collection = c2;
        }
        aal.a(obj, j, c);
    }

    final void b(Object obj, long j) {
        c(obj, j).zzaaz();
    }
}
