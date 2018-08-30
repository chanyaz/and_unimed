package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzadh
public final class nc implements Iterable<na> {
    private final List<na> a = new ArrayList();

    public static boolean a(zzapw zzapw) {
        na b = b(zzapw);
        if (b == null) {
            return false;
        }
        b.b.a();
        return true;
    }

    static na b(zzapw zzapw) {
        Iterator it = au.z().iterator();
        while (it.hasNext()) {
            na naVar = (na) it.next();
            if (naVar.a == zzapw) {
                return naVar;
            }
        }
        return null;
    }

    public final int a() {
        return this.a.size();
    }

    public final void a(na naVar) {
        this.a.add(naVar);
    }

    public final void b(na naVar) {
        this.a.remove(naVar);
    }

    public final Iterator<na> iterator() {
        return this.a.iterator();
    }
}
