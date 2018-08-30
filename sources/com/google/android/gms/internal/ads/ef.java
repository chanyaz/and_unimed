package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import java.util.concurrent.Callable;

final class ef implements Callable<ec> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ ee b;

    ef(ee eeVar, Context context) {
        this.b = eeVar;
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        ec a;
        eg egVar = (eg) this.b.a.get(this.a);
        if (egVar != null) {
            if ((egVar.a + ((Long) akc.f().a(amn.bq)).longValue() < au.l().currentTimeMillis() ? 1 : null) == null) {
                if (((Boolean) akc.f().a(amn.bp)).booleanValue()) {
                    a = new ed(this.a, egVar.b).a();
                    this.b.a.put(this.a, new eg(this.b, a));
                    return a;
                }
            }
        }
        a = new ed(this.a).a();
        this.b.a.put(this.a, new eg(this.b, a));
        return a;
    }
}
