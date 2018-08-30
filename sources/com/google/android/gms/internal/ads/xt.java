package com.google.android.gms.internal.ads;

final class xt {
    private final Object a;
    private final int b;

    xt(Object obj, int i) {
        this.a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xt)) {
            return false;
        }
        xt xtVar = (xt) obj;
        return this.a == xtVar.a && this.b == xtVar.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 65535) + this.b;
    }
}
