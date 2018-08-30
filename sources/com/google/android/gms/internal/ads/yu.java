package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class yu extends ys {
    private static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private yu() {
        super();
    }

    private static <L> List<L> a(Object obj, long j, int i) {
        List<L> c = c(obj, j);
        List<L> arrayList;
        if (c.isEmpty()) {
            Object yrVar = c instanceof zzbcd ? new yr(i) : new ArrayList(i);
            aal.a(obj, j, yrVar);
            return yrVar;
        } else if (a.isAssignableFrom(c.getClass())) {
            arrayList = new ArrayList(c.size() + i);
            arrayList.addAll(c);
            aal.a(obj, j, (Object) arrayList);
            return arrayList;
        } else if (!(c instanceof aai)) {
            return c;
        } else {
            arrayList = new yr(c.size() + i);
            arrayList.addAll((aai) c);
            aal.a(obj, j, (Object) arrayList);
            return arrayList;
        }
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) aal.f(obj, j);
    }

    final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    final <E> void a(Object obj, Object obj2, long j) {
        Collection c = c(obj2, j);
        Object a = a(obj, j, c.size());
        int size = a.size();
        int size2 = c.size();
        if (size > 0 && size2 > 0) {
            a.addAll(c);
        }
        if (size <= 0) {
            Collection a2 = c;
        }
        aal.a(obj, j, a2);
    }

    final void b(Object obj, long j) {
        Object zzadx;
        List list = (List) aal.f(obj, j);
        if (list instanceof zzbcd) {
            zzadx = ((zzbcd) list).zzadx();
        } else if (!a.isAssignableFrom(list.getClass())) {
            zzadx = Collections.unmodifiableList(list);
        } else {
            return;
        }
        aal.a(obj, j, zzadx);
    }
}
