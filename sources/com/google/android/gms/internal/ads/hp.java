package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Iterator;

final class hp extends hq {
    private final /* synthetic */ Bundle a;
    private final /* synthetic */ hn b;

    hp(hn hnVar, Bundle bundle) {
        this.b = hnVar;
        this.a = bundle;
        super();
    }

    public final void a() {
        Iterator it = this.b.d.iterator();
        while (it.hasNext()) {
            ((zzakh) it.next()).zzd(this.a);
        }
    }
}
