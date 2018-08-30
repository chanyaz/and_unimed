package com.google.android.gms.internal.ads;

import java.util.Map;

public final class jj extends apk<any> {
    private final lk<any> a;
    private final Map<String, String> b;
    private final ke c;

    public jj(String str, lk<any> lkVar) {
        this(str, null, lkVar);
    }

    private jj(String str, Map<String, String> map, lk<any> lkVar) {
        super(0, str, new jk(lkVar));
        this.b = null;
        this.a = lkVar;
        this.c = new ke();
        this.c.a(str, "GET", null, null);
    }

    protected final auj<any> a(any any) {
        return auj.a(any, ly.a(any));
    }
}
