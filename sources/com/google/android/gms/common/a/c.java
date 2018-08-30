package com.google.android.gms.common.a;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

public class c {
    private static c b = new c();
    private b a = null;

    public static b b(Context context) {
        return b.a(context);
    }

    @VisibleForTesting
    public synchronized b a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new b(context);
        }
        return this.a;
    }
}
