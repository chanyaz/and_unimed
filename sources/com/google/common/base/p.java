package com.google.common.base;

import javax.annotation.Nullable;

public final class p {
    private final String a;
    private q b;
    private q c;
    private boolean d;

    private p(String str) {
        this.b = new q();
        this.c = this.b;
        this.d = false;
        this.a = (String) s.a((Object) str);
    }

    private q a() {
        q qVar = new q();
        this.c.c = qVar;
        this.c = qVar;
        return qVar;
    }

    private p b(@Nullable Object obj) {
        a().b = obj;
        return this;
    }

    private p b(String str, @Nullable Object obj) {
        q a = a();
        a.b = obj;
        a.a = (String) s.a((Object) str);
        return this;
    }

    public p a(@Nullable Object obj) {
        return b(obj);
    }

    public p a(String str, int i) {
        return b(str, String.valueOf(i));
    }

    public p a(String str, long j) {
        return b(str, String.valueOf(j));
    }

    public p a(String str, @Nullable Object obj) {
        return b(str, obj);
    }

    public String toString() {
        boolean z = this.d;
        StringBuilder append = new StringBuilder(32).append(this.a).append('{');
        String str = "";
        q qVar = this.b.c;
        while (qVar != null) {
            if (!z || qVar.b != null) {
                append.append(str);
                str = ", ";
                if (qVar.a != null) {
                    append.append(qVar.a).append('=');
                }
                append.append(qVar.b);
            }
            qVar = qVar.c;
        }
        return append.append('}').toString();
    }
}
