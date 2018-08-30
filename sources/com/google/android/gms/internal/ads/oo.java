package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzadh
public final class oo extends MutableContextWrapper {
    private Activity a;
    private Context b;
    private Context c;

    public oo(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Activity a() {
        return this.a;
    }

    public final Context b() {
        return this.c;
    }

    public final Object getSystemService(String str) {
        return this.c.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.b = context.getApplicationContext();
        this.a = context instanceof Activity ? (Activity) context : null;
        this.c = context;
        super.setBaseContext(this.b);
    }

    public final void startActivity(Intent intent) {
        if (this.a != null) {
            this.a.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.b.startActivity(intent);
    }
}
