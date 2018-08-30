package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@zzadh
public final class ee {
    private WeakHashMap<Context, eg> a = new WeakHashMap();

    public final Future<ec> a(Context context) {
        return hr.a(new ef(this, context));
    }
}
