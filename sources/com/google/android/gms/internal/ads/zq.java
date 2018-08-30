package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zq {
    private static final Class<?> a = d();
    private static final aaf<?, ?> b = a(false);
    private static final aaf<?, ?> c = a(true);
    private static final aaf<?, ?> d = new aah();

    static int a(int i, Object obj, zzbdm zzbdm) {
        return obj instanceof yq ? zzbav.a(i, (yq) obj) : zzbav.b(i, (zzbcu) obj, zzbdm);
    }

    static int a(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = zzbav.e(i) * size;
        int i2;
        Object zzcp;
        if (list instanceof zzbcd) {
            zzbcd zzbcd = (zzbcd) list;
            i2 = 0;
            while (i2 < size) {
                zzcp = zzbcd.zzcp(i2);
                i2++;
                e = (zzcp instanceof zzbah ? zzbav.b((zzbah) zzcp) : zzbav.b((String) zzcp)) + e;
            }
            return e;
        }
        i2 = 0;
        while (i2 < size) {
            zzcp = list.get(i2);
            i2++;
            e = (zzcp instanceof zzbah ? zzbav.b((zzbah) zzcp) : zzbav.b((String) zzcp)) + e;
        }
        return e;
    }

    static int a(int i, List<?> list, zzbdm zzbdm) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = zzbav.e(i) * size;
        int i2 = 0;
        while (i2 < size) {
            Object obj = list.get(i2);
            i2++;
            e = (obj instanceof yq ? zzbav.a((yq) obj) : zzbav.a((zzbcu) obj, zzbdm)) + e;
        }
        return e;
    }

    static int a(int i, List<Long> list, boolean z) {
        return list.size() == 0 ? 0 : a((List) list) + (list.size() * zzbav.e(i));
    }

    static int a(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int d;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            i2 = 0;
            while (i2 < size) {
                d = zzbav.d(ywVar.a(i2)) + i;
                i2++;
                i = d;
            }
            return i;
        }
        i2 = 0;
        for (d = 0; d < size; d++) {
            i2 += zzbav.d(((Long) list.get(d)).longValue());
        }
        return i2;
    }

    public static aaf<?, ?> a() {
        return b;
    }

    private static aaf<?, ?> a(boolean z) {
        try {
            Class e = e();
            if (e == null) {
                return null;
            }
            return (aaf) e.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    static <UT, UB> UB a(int i, int i2, UB ub, aaf<UT, UB> aaf) {
        Object ub2;
        if (ub2 == null) {
            ub2 = aaf.a();
        }
        aaf.a(ub2, i, (long) i2);
        return ub2;
    }

    static <UT, UB> UB a(int i, List<Integer> list, zzbbs<?> zzbbs, UB ub, aaf<UT, UB> aaf) {
        if (zzbbs == null) {
            return ub;
        }
        UB ub2;
        int intValue;
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            ub2 = ub;
            while (i2 < size) {
                UB ub3;
                intValue = ((Integer) list.get(i2)).intValue();
                if (zzbbs.zzq(intValue) != null) {
                    if (i2 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    intValue = i3 + 1;
                    ub3 = ub2;
                } else {
                    int i4 = i3;
                    ub3 = a(i, intValue, (Object) ub2, (aaf) aaf);
                    intValue = i4;
                }
                i2++;
                ub2 = ub3;
                i3 = intValue;
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Object ub4;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                intValue = ((Integer) it.next()).intValue();
                if (zzbbs.zzq(intValue) == null) {
                    ub4 = a(i, intValue, ub4, (aaf) aaf);
                    it.remove();
                }
            }
            ub2 = ub4;
        }
        return ub2;
    }

    public static void a(int i, List<String> list, zzbey zzbey) {
        if (list != null && !list.isEmpty()) {
            zzbey.zza(i, (List) list);
        }
    }

    public static void a(int i, List<?> list, zzbey zzbey, zzbdm zzbdm) {
        if (list != null && !list.isEmpty()) {
            zzbey.zza(i, (List) list, zzbdm);
        }
    }

    public static void a(int i, List<Double> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzg(i, list, z);
        }
    }

    static <T, UT, UB> void a(aaf<UT, UB> aaf, T t, T t2) {
        aaf.a((Object) t, aaf.c(aaf.b(t), aaf.b(t2)));
    }

    static <T, FT extends zzbbi<FT>> void a(xu<FT> xuVar, T t, T t2) {
        xx a = xuVar.a((Object) t2);
        if (!a.b()) {
            xuVar.b(t).a(a);
        }
    }

    static <T> void a(zzbcp zzbcp, T t, T t2, long j) {
        aal.a((Object) t, j, zzbcp.zzb(aal.f(t, j), aal.f(t2, j)));
    }

    public static void a(Class<?> cls) {
        if (!yd.class.isAssignableFrom(cls) && a != null && !a.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean a(int i, int i2, int i3) {
        return i2 < 40 || ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * ((long) i3)) + 3) + ((((long) i3) + 3) * 3);
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int b(int i, List<zzbah> list) {
        int i2 = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = size * zzbav.e(i);
        while (true) {
            size = i2;
            if (size >= list.size()) {
                return e;
            }
            e += zzbav.b((zzbah) list.get(size));
            i2 = size + 1;
        }
    }

    static int b(int i, List<zzbcu> list, zzbdm zzbdm) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzbav.c(i, (zzbcu) list.get(i3), zzbdm);
        }
        return i2;
    }

    static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + b(list);
    }

    static int b(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int e;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            i2 = 0;
            while (i2 < size) {
                e = zzbav.e(ywVar.a(i2)) + i;
                i2++;
                i = e;
            }
            return i;
        }
        i2 = 0;
        for (e = 0; e < size; e++) {
            i2 += zzbav.e(((Long) list.get(e)).longValue());
        }
        return i2;
    }

    public static aaf<?, ?> b() {
        return c;
    }

    public static void b(int i, List<zzbah> list, zzbey zzbey) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzb(i, (List) list);
        }
    }

    public static void b(int i, List<?> list, zzbey zzbey, zzbdm zzbdm) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzb(i, (List) list, zzbdm);
        }
    }

    public static void b(int i, List<Float> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzf(i, list, z);
        }
    }

    static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + c(list);
    }

    static int c(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int f;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            i2 = 0;
            while (i2 < size) {
                f = zzbav.f(ywVar.a(i2)) + i;
                i2++;
                i = f;
            }
            return i;
        }
        i2 = 0;
        for (f = 0; f < size; f++) {
            i2 += zzbav.f(((Long) list.get(f)).longValue());
        }
        return i2;
    }

    public static aaf<?, ?> c() {
        return d;
    }

    public static void c(int i, List<Long> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzc(i, list, z);
        }
    }

    static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + d(list);
    }

    static int d(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int k;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            i2 = 0;
            while (i2 < size) {
                k = zzbav.k(yjVar.a(i2)) + i;
                i2++;
                i = k;
            }
            return i;
        }
        i2 = 0;
        for (k = 0; k < size; k++) {
            i2 += zzbav.k(((Integer) list.get(k)).intValue());
        }
        return i2;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    public static void d(int i, List<Long> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzd(i, list, z);
        }
    }

    static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + e(list);
    }

    static int e(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int f;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            i2 = 0;
            while (i2 < size) {
                f = zzbav.f(yjVar.a(i2)) + i;
                i2++;
                i = f;
            }
            return i;
        }
        i2 = 0;
        for (f = 0; f < size; f++) {
            i2 += zzbav.f(((Integer) list.get(f)).intValue());
        }
        return i2;
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    public static void e(int i, List<Long> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzn(i, list, z);
        }
    }

    static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + f(list);
    }

    static int f(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int g;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            i2 = 0;
            while (i2 < size) {
                g = zzbav.g(yjVar.a(i2)) + i;
                i2++;
                i = g;
            }
            return i;
        }
        i2 = 0;
        for (g = 0; g < size; g++) {
            i2 += zzbav.g(((Integer) list.get(g)).intValue());
        }
        return i2;
    }

    public static void f(int i, List<Long> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zze(i, list, z);
        }
    }

    static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzbav.e(i)) + g(list);
    }

    static int g(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2;
        int h;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            i2 = 0;
            while (i2 < size) {
                h = zzbav.h(yjVar.a(i2)) + i;
                i2++;
                i = h;
            }
            return i;
        }
        i2 = 0;
        for (h = 0; h < size; h++) {
            i2 += zzbav.h(((Integer) list.get(h)).intValue());
        }
        return i2;
    }

    public static void g(int i, List<Long> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzl(i, list, z);
        }
    }

    static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzbav.i(i, 0) * size;
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    public static void h(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zza(i, (List) list, z);
        }
    }

    static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * zzbav.g(i, 0);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    public static void i(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzj(i, list, z);
        }
    }

    static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * zzbav.b(i, true);
    }

    static int j(List<?> list) {
        return list.size();
    }

    public static void j(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzm(i, list, z);
        }
    }

    public static void k(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzb(i, (List) list, z);
        }
    }

    public static void l(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzk(i, list, z);
        }
    }

    public static void m(int i, List<Integer> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzh(i, list, z);
        }
    }

    public static void n(int i, List<Boolean> list, zzbey zzbey, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzbey.zzi(i, list, z);
        }
    }
}
