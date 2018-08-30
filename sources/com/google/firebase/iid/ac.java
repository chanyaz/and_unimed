package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.b;

final /* synthetic */ class ac implements Runnable {
    private final ab a;
    private final Bundle b;
    private final b c;

    ac(ab abVar, Bundle bundle, b bVar) {
        this.a = abVar;
        this.b = bundle;
        this.c = bVar;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
