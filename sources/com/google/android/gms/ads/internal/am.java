package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzjj;
import java.lang.ref.WeakReference;

final class am implements Runnable {
    private final /* synthetic */ WeakReference a;
    private final /* synthetic */ al b;

    am(al alVar, WeakReference weakReference) {
        this.b = alVar;
        this.a = weakReference;
    }

    public final void run() {
        this.b.d = false;
        a aVar = (a) this.a.get();
        if (aVar != null) {
            zzjj a = this.b.c;
            if (aVar.b(a)) {
                aVar.zzb(a);
                return;
            }
            kk.d("Ad is not visible. Not refreshing ad.");
            aVar.d.b(a);
        }
    }
}
