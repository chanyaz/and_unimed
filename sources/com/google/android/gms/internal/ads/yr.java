package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class yr extends wt<String> implements zzbcd, RandomAccess {
    private static final yr a;
    private static final zzbcd b = a;
    private final List<Object> c;

    static {
        wt yrVar = new yr();
        a = yrVar;
        yrVar.zzaaz();
    }

    public yr() {
        this(10);
    }

    public yr(int i) {
        this(new ArrayList(i));
    }

    private yr(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    private static String a(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzbah ? ((zzbah) obj).c() : yk.b((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        a();
        this.c.add(i, str);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        Collection collection2;
        a();
        if (collection2 instanceof zzbcd) {
            collection2 = ((zzbcd) collection2).zzadw();
        }
        boolean addAll = this.c.addAll(i, collection2);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        a();
        this.c.clear();
        this.modCount++;
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String c;
        if (obj instanceof zzbah) {
            zzbah zzbah = (zzbah) obj;
            c = zzbah.c();
            if (zzbah.d()) {
                this.c.set(i, c);
            }
            return c;
        }
        byte[] bArr = (byte[]) obj;
        c = yk.b(bArr);
        if (yk.a(bArr)) {
            this.c.set(i, c);
        }
        return c;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        a();
        return a(this.c.set(i, str));
    }

    public final int size() {
        return this.c.size();
    }

    public final List<?> zzadw() {
        return Collections.unmodifiableList(this.c);
    }

    public final zzbcd zzadx() {
        return zzaay() ? new aai(this) : this;
    }

    public final void zzap(zzbah zzbah) {
        a();
        this.c.add(zzbah);
        this.modCount++;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new yr(arrayList);
    }

    public final Object zzcp(int i) {
        return this.c.get(i);
    }
}
