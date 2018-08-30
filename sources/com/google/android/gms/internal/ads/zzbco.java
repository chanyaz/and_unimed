package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzbco<K, V> extends LinkedHashMap<K, V> {
    private static final zzbco b;
    private boolean a = true;

    static {
        zzbco zzbco = new zzbco();
        b = zzbco;
        zzbco.a = false;
    }

    private zzbco() {
    }

    private zzbco(Map<K, V> map) {
        super(map);
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return yk.c((byte[]) obj);
        }
        if (!(obj instanceof zzbbr)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> zzbco<K, V> a() {
        return b;
    }

    private final void e() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void a(zzbco<K, V> zzbco) {
        e();
        if (!zzbco.isEmpty()) {
            putAll(zzbco);
        }
    }

    public final zzbco<K, V> b() {
        return isEmpty() ? new zzbco() : new zzbco(this);
    }

    public final void c() {
        this.a = false;
    }

    public final void clear() {
        e();
        super.clear();
    }

    public final boolean d() {
        return this.a;
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    public final boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7 instanceof java.util.Map;
        if (r0 == 0) goto L_0x0062;
    L_0x0006:
        r7 = (java.util.Map) r7;
        if (r6 == r7) goto L_0x0060;
    L_0x000a:
        r0 = r6.size();
        r1 = r7.size();
        if (r0 == r1) goto L_0x0019;
    L_0x0014:
        r0 = r4;
    L_0x0015:
        if (r0 == 0) goto L_0x0062;
    L_0x0017:
        r0 = r3;
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = r6.entrySet();
        r5 = r0.iterator();
    L_0x0021:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0060;
    L_0x0027:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = r7.containsKey(r1);
        if (r1 != 0) goto L_0x0039;
    L_0x0037:
        r0 = r4;
        goto L_0x0015;
    L_0x0039:
        r1 = r0.getValue();
        r0 = r0.getKey();
        r2 = r7.get(r0);
        r0 = r1 instanceof byte[];
        if (r0 == 0) goto L_0x005b;
    L_0x0049:
        r0 = r2 instanceof byte[];
        if (r0 == 0) goto L_0x005b;
    L_0x004d:
        r0 = r1;
        r0 = (byte[]) r0;
        r1 = r2;
        r1 = (byte[]) r1;
        r0 = java.util.Arrays.equals(r0, r1);
    L_0x0057:
        if (r0 != 0) goto L_0x0021;
    L_0x0059:
        r0 = r4;
        goto L_0x0015;
    L_0x005b:
        r0 = r1.equals(r2);
        goto L_0x0057;
    L_0x0060:
        r0 = r3;
        goto L_0x0015;
    L_0x0062:
        r0 = r4;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbco.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        Iterator it = entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            Entry entry = (Entry) it.next();
            i = (a(entry.getValue()) ^ a(entry.getKey())) + i2;
        }
    }

    public final V put(K k, V v) {
        e();
        yk.a((Object) k);
        yk.a((Object) v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        e();
        for (Object next : map.keySet()) {
            yk.a(next);
            yk.a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        e();
        return super.remove(obj);
    }
}
