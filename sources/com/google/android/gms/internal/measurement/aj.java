package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.ar;

public final class aj {
    private final Context a;
    private final Context b;

    public aj(Context context) {
        ar.a((Object) context);
        Object applicationContext = context.getApplicationContext();
        ar.a(applicationContext, (Object) "Application context can't be null");
        this.a = applicationContext;
        this.b = applicationContext;
    }

    public final Context a() {
        return this.a;
    }

    public final Context b() {
        return this.b;
    }
}
