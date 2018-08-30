package com.google.android.gms.internal.ads;

final class aah extends aaf<aag, aag> {
    aah() {
    }

    private static void a(Object obj, aag aag) {
        ((yd) obj).zzdtt = aag;
    }

    final boolean a(zzbdl zzbdl) {
        return false;
    }

    final /* synthetic */ Object b(Object obj) {
        return ((yd) obj).zzdtt;
    }

    final /* synthetic */ void b(Object obj, int i, long j) {
        ((aag) obj).a((i << 3) | 1, Long.valueOf(j));
    }

    final /* synthetic */ Object c(Object obj) {
        aag aag = ((yd) obj).zzdtt;
        if (aag != aag.a()) {
            return aag;
        }
        aag = aag.b();
        a(obj, aag);
        return aag;
    }

    final /* synthetic */ Object c(Object obj, Object obj2) {
        aag aag = (aag) obj;
        aag aag2 = (aag) obj2;
        return aag2.equals(aag.a()) ? aag : aag.a(aag, aag2);
    }

    final void d(Object obj) {
        ((yd) obj).zzdtt.c();
    }
}
