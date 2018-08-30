package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.e;

@VisibleForTesting
public final class ar implements FusedLocationProviderApi {
    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.b(new aw(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return e.a(googleApiClient).r();
        } catch (Exception e) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return e.a(googleApiClient).s();
        } catch (Exception e) {
            return null;
        }
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new b(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.b(new ba(this, googleApiClient, locationListener));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, d dVar) {
        return googleApiClient.b(new at(this, googleApiClient, dVar));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new az(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        com.google.android.gms.common.internal.ar.a(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return googleApiClient.b(new as(this, googleApiClient, locationRequest, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.b(new ax(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, d dVar, Looper looper) {
        return googleApiClient.b(new ay(this, googleApiClient, locationRequest, dVar, looper));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.b(new av(this, googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.b(new au(this, googleApiClient, z));
    }
}
