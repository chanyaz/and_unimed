package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class xx<FieldDescriptorType extends zzbbi<FieldDescriptorType>> {
    private static final xx d = new xx(true);
    private final zr<FieldDescriptorType, Object> a = zr.a(16);
    private boolean b;
    private boolean c = false;

    private xx() {
    }

    private xx(boolean z) {
        c();
    }

    static int a(zzbes zzbes, int i, Object obj) {
        int i2;
        int e = zzbav.e(i);
        if (zzbes == zzbes.GROUP) {
            yk.a((zzbcu) obj);
            i2 = e << 1;
        } else {
            i2 = e;
        }
        return i2 + b(zzbes, obj);
    }

    public static <T extends zzbbi<T>> xx<T> a() {
        return d;
    }

    private final Object a(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.a.get(fieldDescriptorType);
        return obj instanceof yl ? yl.a() : obj;
    }

    private static Object a(Object obj) {
        if (obj instanceof zzbdb) {
            return ((zzbdb) obj).zzaek();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    static void a(zzbav zzbav, zzbes zzbes, int i, Object obj) {
        if (zzbes == zzbes.GROUP) {
            yk.a((zzbcu) obj);
            zzbcu zzbcu = (zzbcu) obj;
            zzbav.a(i, 3);
            zzbcu.zzb(zzbav);
            zzbav.a(i, 4);
            return;
        }
        zzbav.a(i, zzbes.b());
        switch (xy.b[zzbes.ordinal()]) {
            case 1:
                zzbav.a(((Double) obj).doubleValue());
                return;
            case 2:
                zzbav.a(((Float) obj).floatValue());
                return;
            case 3:
                zzbav.a(((Long) obj).longValue());
                return;
            case 4:
                zzbav.a(((Long) obj).longValue());
                return;
            case 5:
                zzbav.a(((Integer) obj).intValue());
                return;
            case 6:
                zzbav.c(((Long) obj).longValue());
                return;
            case 7:
                zzbav.d(((Integer) obj).intValue());
                return;
            case 8:
                zzbav.a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzbcu) obj).zzb(zzbav);
                return;
            case 10:
                zzbav.a((zzbcu) obj);
                return;
            case 11:
                if (obj instanceof zzbah) {
                    zzbav.a((zzbah) obj);
                    return;
                } else {
                    zzbav.a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbah) {
                    zzbav.a((zzbah) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzbav.c(bArr, 0, bArr.length);
                return;
            case 13:
                zzbav.b(((Integer) obj).intValue());
                return;
            case 14:
                zzbav.d(((Integer) obj).intValue());
                return;
            case 15:
                zzbav.c(((Long) obj).longValue());
                return;
            case 16:
                zzbav.c(((Integer) obj).intValue());
                return;
            case 17:
                zzbav.b(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbbr) {
                    zzbav.a(((zzbbr) obj).zzhq());
                    return;
                } else {
                    zzbav.a(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void a(FieldDescriptorType fieldDescriptorType, Object obj) {
        Object obj2;
        if (!fieldDescriptorType.zzada()) {
            a(fieldDescriptorType.zzacy(), obj);
            obj2 = obj;
        } else if (obj instanceof List) {
            obj2 = new ArrayList();
            obj2.addAll((List) obj);
            ArrayList arrayList = (ArrayList) obj2;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                a(fieldDescriptorType.zzacy(), obj3);
            }
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj2 instanceof yl) {
            this.c = true;
        }
        this.a.put((Comparable) fieldDescriptorType, obj2);
    }

    private static void a(zzbes zzbes, Object obj) {
        boolean z = false;
        yk.a(obj);
        switch (xy.a[zzbes.a().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzbah) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzbbr)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzbcu) || (obj instanceof yl)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static boolean a(Entry<FieldDescriptorType, Object> entry) {
        zzbbi zzbbi = (zzbbi) entry.getKey();
        if (zzbbi.zzacz() == zzbex.MESSAGE) {
            if (zzbbi.zzada()) {
                for (zzbcu isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof zzbcu) {
                if (!((zzbcu) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof yl) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static int b(zzbbi<?> zzbbi, Object obj) {
        int i = 0;
        zzbes zzacy = zzbbi.zzacy();
        int zzhq = zzbbi.zzhq();
        if (!zzbbi.zzada()) {
            return a(zzacy, zzhq, obj);
        }
        if (zzbbi.zzadb()) {
            for (Object b : (List) obj) {
                i += b(zzacy, b);
            }
            return zzbav.l(i) + (zzbav.e(zzhq) + i);
        }
        for (Object b2 : (List) obj) {
            i += a(zzacy, zzhq, b2);
        }
        return i;
    }

    private static int b(zzbes zzbes, Object obj) {
        switch (xy.b[zzbes.ordinal()]) {
            case 1:
                return zzbav.b(((Double) obj).doubleValue());
            case 2:
                return zzbav.b(((Float) obj).floatValue());
            case 3:
                return zzbav.d(((Long) obj).longValue());
            case 4:
                return zzbav.e(((Long) obj).longValue());
            case 5:
                return zzbav.f(((Integer) obj).intValue());
            case 6:
                return zzbav.g(((Long) obj).longValue());
            case 7:
                return zzbav.i(((Integer) obj).intValue());
            case 8:
                return zzbav.b(((Boolean) obj).booleanValue());
            case 9:
                return zzbav.c((zzbcu) obj);
            case 10:
                return obj instanceof yl ? zzbav.a((yl) obj) : zzbav.b((zzbcu) obj);
            case 11:
                return obj instanceof zzbah ? zzbav.b((zzbah) obj) : zzbav.b((String) obj);
            case 12:
                return obj instanceof zzbah ? zzbav.b((zzbah) obj) : zzbav.b((byte[]) obj);
            case 13:
                return zzbav.g(((Integer) obj).intValue());
            case 14:
                return zzbav.j(((Integer) obj).intValue());
            case 15:
                return zzbav.h(((Long) obj).longValue());
            case 16:
                return zzbav.h(((Integer) obj).intValue());
            case 17:
                return zzbav.f(((Long) obj).longValue());
            case 18:
                return obj instanceof zzbbr ? zzbav.k(((zzbbr) obj).zzhq()) : zzbav.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void b(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (zzbbi) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof yl) {
            value = yl.a();
        }
        Object a;
        if (comparable.zzada()) {
            a = a((zzbbi) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(a(a2));
            }
            this.a.put(comparable, a);
        } else if (comparable.zzacz() == zzbex.MESSAGE) {
            a = a((zzbbi) comparable);
            if (a == null) {
                this.a.put(comparable, a(value));
            } else {
                this.a.put(comparable, a instanceof zzbdb ? comparable.zza((zzbdb) a, (zzbdb) value) : comparable.zza(((zzbcu) a).zzade(), (zzbcu) value).zzadk());
            }
        } else {
            this.a.put(comparable, a(value));
        }
    }

    private static int c(Entry<FieldDescriptorType, Object> entry) {
        zzbbi zzbbi = (zzbbi) entry.getKey();
        Object value = entry.getValue();
        return (zzbbi.zzacz() != zzbex.MESSAGE || zzbbi.zzada() || zzbbi.zzadb()) ? b(zzbbi, value) : value instanceof yl ? zzbav.b(((zzbbi) entry.getKey()).zzhq(), (yl) value) : zzbav.b(((zzbbi) entry.getKey()).zzhq(), (zzbcu) value);
    }

    public final void a(xx<FieldDescriptorType> xxVar) {
        for (int i = 0; i < xxVar.a.c(); i++) {
            b(xxVar.a.b(i));
        }
        for (Entry b : xxVar.a.d()) {
            b(b);
        }
    }

    final boolean b() {
        return this.a.isEmpty();
    }

    public final void c() {
        if (!this.b) {
            this.a.a();
            this.b = true;
        }
    }

    public final /* synthetic */ Object clone() {
        xx xxVar = new xx();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.c()) {
                break;
            }
            Entry b = this.a.b(i2);
            xxVar.a((zzbbi) b.getKey(), b.getValue());
            i = i2 + 1;
        }
        for (Entry entry : this.a.d()) {
            xxVar.a((zzbbi) entry.getKey(), entry.getValue());
        }
        xxVar.c = this.c;
        return xxVar;
    }

    public final boolean d() {
        return this.b;
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> e() {
        return this.c ? new yp(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xx)) {
            return false;
        }
        return this.a.equals(((xx) obj).a);
    }

    final Iterator<Entry<FieldDescriptorType, Object>> f() {
        return this.c ? new yp(this.a.e().iterator()) : this.a.e().iterator();
    }

    public final boolean g() {
        for (int i = 0; i < this.a.c(); i++) {
            if (!a(this.a.b(i))) {
                return false;
            }
        }
        for (Entry a : this.a.d()) {
            if (!a(a)) {
                return false;
            }
        }
        return true;
    }

    public final int h() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i3 >= this.a.c()) {
                break;
            }
            Entry b = this.a.b(i3);
            i += b((zzbbi) b.getKey(), b.getValue());
            i2 = i3 + 1;
        }
        for (Entry entry : this.a.d()) {
            i += b((zzbbi) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final int i() {
        int i = 0;
        int i2 = 0;
        while (i < this.a.c()) {
            i2 += c(this.a.b(i));
            i++;
        }
        for (Entry c : this.a.d()) {
            i2 += c(c);
        }
        return i2;
    }
}
