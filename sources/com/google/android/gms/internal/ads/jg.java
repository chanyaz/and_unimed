package com.google.android.gms.internal.ads;

import java.util.Map;

final class jg extends qo {
    private final /* synthetic */ byte[] a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ ke c;

    jg(jb jbVar, int i, String str, zzz zzz, zzy zzy, byte[] bArr, Map map, ke keVar) {
        this.a = bArr;
        this.b = map;
        this.c = keVar;
        super(i, str, zzz, zzy);
    }

    protected final void a(String str) {
        this.c.a(str);
        super.a(str);
    }

    public final byte[] a() {
        return this.a == null ? super.a() : this.a;
    }

    public final Map<String, String> b() {
        return this.b == null ? super.b() : this.b;
    }
}
