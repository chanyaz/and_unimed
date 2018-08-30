package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class fp extends ib {
    final Context a;

    @VisibleForTesting
    public fp(Context context) {
        ar.a((Object) context);
        Object applicationContext = context.getApplicationContext();
        ar.a(applicationContext);
        this.a = applicationContext;
    }
}
