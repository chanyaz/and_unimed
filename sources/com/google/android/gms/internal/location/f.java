package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.zzal;
import java.util.List;

public final class f implements GeofencingApi {
    private final PendingResult<Status> a(GoogleApiClient googleApiClient, zzal zzal) {
        return googleApiClient.b(new h(this, googleApiClient, zzal));
    }

    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new g(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        c cVar = new c();
        cVar.a((List) list);
        cVar.a(5);
        return addGeofences(googleApiClient, cVar.a(), pendingIntent);
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return a(googleApiClient, zzal.a(pendingIntent));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return a(googleApiClient, zzal.a((List) list));
    }
}
