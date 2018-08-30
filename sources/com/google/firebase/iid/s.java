package com.google.firebase.iid;

import android.content.Intent;

final class s implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Intent b;
    private final /* synthetic */ zzb c;

    s(zzb zzb, Intent intent, Intent intent2) {
        this.c = zzb;
        this.a = intent;
        this.b = intent2;
    }

    public final void run() {
        this.c.b(this.a);
        this.c.d(this.b);
    }
}
