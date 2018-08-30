package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

@zzadh
final class aqs {
    private final List<zzts> a = new ArrayList();

    aqs() {
    }

    final void a(arr arr) {
        Handler handler = ht.a;
        for (zzts arq : this.a) {
            handler.post(new arq(this, arq, arr));
        }
        this.a.clear();
    }
}
