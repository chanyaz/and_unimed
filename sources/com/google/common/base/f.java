package com.google.common.base;

class f extends d {
    final d p;
    final d q;

    f(d dVar, d dVar2) {
        this(dVar, dVar2, "CharMatcher.or(" + dVar + ", " + dVar2 + ")");
    }

    f(d dVar, d dVar2, String str) {
        super(str);
        this.p = (d) s.a((Object) dVar);
        this.q = (d) s.a((Object) dVar2);
    }

    d a(String str) {
        return new f(this.p, this.q, str);
    }

    public boolean b(char c) {
        return this.p.b(c) || this.q.b(c);
    }
}
