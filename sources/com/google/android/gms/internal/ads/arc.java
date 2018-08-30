package com.google.android.gms.internal.ads;

final class arc implements zzts {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;

    arc(arb arb, String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void zzb(arr arr) {
        if (arr.c != null) {
            arr.c.onAppEvent(this.a, this.b);
        }
    }
}
