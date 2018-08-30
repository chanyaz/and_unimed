package com.google.android.gms.location;

import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private final List<zzbh> a = new ArrayList();
    private int b = 5;
    private String c = "";

    public final GeofencingRequest a() {
        ar.b(!this.a.isEmpty(), "No geofence has been added to this request.");
        return new GeofencingRequest(this.a, this.b, this.c);
    }

    public final c a(int i) {
        this.b = i & 7;
        return this;
    }

    public final c a(Geofence geofence) {
        ar.a((Object) geofence, (Object) "geofence can't be null.");
        ar.b(geofence instanceof zzbh, "Geofence must be created using Geofence.Builder.");
        this.a.add((zzbh) geofence);
        return this;
    }

    public final c a(List<Geofence> list) {
        if (!(list == null || list.isEmpty())) {
            for (Geofence geofence : list) {
                if (geofence != null) {
                    a(geofence);
                }
            }
        }
        return this;
    }
}
