package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class jg extends ContentObserver {
    jg(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        jf.e.set(true);
    }
}
