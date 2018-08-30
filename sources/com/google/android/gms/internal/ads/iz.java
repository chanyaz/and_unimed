package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ap;

public final class iz {
    public final String a;
    public final double b;
    public final int c;
    private final double d;
    private final double e;

    public iz(String str, double d, double d2, double d3, int i) {
        this.a = str;
        this.e = d;
        this.d = d2;
        this.b = d3;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof iz)) {
            return false;
        }
        iz izVar = (iz) obj;
        return ap.a(this.a, izVar.a) && this.d == izVar.d && this.e == izVar.e && this.c == izVar.c && Double.compare(this.b, izVar.b) == 0;
    }

    public final int hashCode() {
        return ap.a(this.a, Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final String toString() {
        return ap.a((Object) this).a("name", this.a).a("minBound", Double.valueOf(this.e)).a("maxBound", Double.valueOf(this.d)).a("percent", Double.valueOf(this.b)).a("count", Integer.valueOf(this.c)).toString();
    }
}
