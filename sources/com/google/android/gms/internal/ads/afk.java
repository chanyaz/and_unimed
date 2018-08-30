package com.google.android.gms.internal.ads;

import android.database.ContentObserver;
import android.os.Handler;

final class afk extends ContentObserver {
    private final /* synthetic */ afh a;

    public afk(afh afh, Handler handler) {
        this.a = afh;
        super(handler);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        this.a.a();
    }
}
