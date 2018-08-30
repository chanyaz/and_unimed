package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.af;
import com.google.android.gms.location.d;

final class p extends af {
    private final ListenerHolder<d> a;

    p(ListenerHolder<d> listenerHolder) {
        this.a = listenerHolder;
    }

    public final synchronized void a() {
        this.a.a();
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        this.a.a(new r(this, locationAvailability));
    }

    public final void onLocationResult(LocationResult locationResult) {
        this.a.a(new q(this, locationResult));
    }
}
