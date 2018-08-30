package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class ji extends ContentObserver {
    private final /* synthetic */ jh a;

    ji(jh jhVar, Handler handler) {
        this.a = jhVar;
        super(null);
    }

    public final void onChange(boolean z) {
        this.a.b();
        this.a.d();
    }
}
