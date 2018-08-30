package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.d;

final class q implements Notifier<d> {
    private final /* synthetic */ LocationResult a;

    q(p pVar, LocationResult locationResult) {
        this.a = locationResult;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((d) obj).a(this.a);
    }

    public final void onNotifyListenerFailed() {
    }
}
