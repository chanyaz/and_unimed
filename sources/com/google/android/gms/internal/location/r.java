package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.d;

final class r implements Notifier<d> {
    private final /* synthetic */ LocationAvailability a;

    r(p pVar, LocationAvailability locationAvailability) {
        this.a = locationAvailability;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((d) obj).a(this.a);
    }

    public final void onNotifyListenerFailed() {
    }
}
