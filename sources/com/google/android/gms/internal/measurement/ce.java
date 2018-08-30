package com.google.android.gms.internal.measurement;

final class ce implements zzca {
    private final /* synthetic */ Runnable a;
    private final /* synthetic */ cb b;

    ce(cb cbVar, Runnable runnable) {
        this.b = cbVar;
        this.a = runnable;
    }

    public final void zza(Throwable th) {
        this.b.a.post(this.a);
    }
}
