package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationListener;

final class u implements Notifier<LocationListener> {
    private final /* synthetic */ Location a;

    u(t tVar, Location location) {
        this.a = location;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.a);
    }

    public final void onNotifyListenerFailed() {
    }
}
