package com.google.android.gms.internal.ads;

public final class auj<T> {
    public final T a;
    public final acs b;
    public final zzae c;
    public boolean d;

    private auj(zzae zzae) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = zzae;
    }

    private auj(T t, acs acs) {
        this.d = false;
        this.a = t;
        this.b = acs;
        this.c = null;
    }

    public static <T> auj<T> a(zzae zzae) {
        return new auj(zzae);
    }

    public static <T> auj<T> a(T t, acs acs) {
        return new auj(t, acs);
    }
}
