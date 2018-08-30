package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.ah;

final class t extends ah {
    private final ListenerHolder<LocationListener> a;

    t(ListenerHolder<LocationListener> listenerHolder) {
        this.a = listenerHolder;
    }

    public final synchronized void a() {
        this.a.a();
    }

    public final synchronized void onLocationChanged(Location location) {
        this.a.a(new u(this, location));
    }
}
