package com.google.android.gms.dynamic;

import java.util.Iterator;

final class d implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper a;

    d(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.a = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(T t) {
        this.a.a = t;
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zza(this.a.a);
        }
        this.a.c.clear();
        this.a.b = null;
    }
}
