package com.google.android.gms.internal.ads;

import android.content.Context;

@zzadh
public final class asm {
    private Context a;

    public final void a(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = context;
        }
    }
}
