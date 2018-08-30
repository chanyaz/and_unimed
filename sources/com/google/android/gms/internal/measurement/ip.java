package com.google.android.gms.internal.measurement;

public final class ip extends j<ip> {
    private static volatile ip[] e;
    public String c;
    public String d;

    public ip() {
        this.c = null;
        this.d = null;
        this.a = null;
        this.b = -1;
    }

    public static ip[] e() {
        if (e == null) {
            synchronized (o.b) {
                if (e == null) {
                    e = new ip[0];
                }
            }
        }
        return e;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c);
        }
        return this.d != null ? a + i.b(2, this.d) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c);
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ip)) {
            return false;
        }
        ip ipVar = (ip) obj;
        if (this.c == null) {
            if (ipVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ipVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (ipVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(ipVar.d)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? ipVar.a == null || ipVar.a.b() : this.a.equals(ipVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
