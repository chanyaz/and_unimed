package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.d;
import com.google.android.gms.location.zzal;
import javax.annotation.Nullable;

public final class v extends an {
    private final o f;

    public v(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, n.a(context));
    }

    public v(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, @Nullable n nVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, nVar);
        this.f = new o(context, this.e);
    }

    public final void a(long j, PendingIntent pendingIntent) {
        a();
        ar.a((Object) pendingIntent);
        ar.b(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzao) o()).zza(j, true, pendingIntent);
    }

    public final void a(PendingIntent pendingIntent) {
        a();
        ar.a((Object) pendingIntent);
        ((zzao) o()).zzb(pendingIntent);
    }

    public final void a(PendingIntent pendingIntent, ResultHolder<Status> resultHolder) {
        a();
        ar.a((Object) resultHolder, (Object) "ResultHolder not provided.");
        ((zzao) o()).zza(pendingIntent, new q(resultHolder));
    }

    public final void a(PendingIntent pendingIntent, zzaj zzaj) {
        this.f.a(pendingIntent, zzaj);
    }

    public final void a(Location location) {
        this.f.a(location);
    }

    public final void a(m<LocationListener> mVar, zzaj zzaj) {
        this.f.a((m) mVar, zzaj);
    }

    public final void a(zzaj zzaj) {
        this.f.a(zzaj);
    }

    public final void a(zzbd zzbd, ListenerHolder<d> listenerHolder, zzaj zzaj) {
        synchronized (this.f) {
            this.f.a(zzbd, (ListenerHolder) listenerHolder, zzaj);
        }
    }

    public final void a(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, ResultHolder<Status> resultHolder) {
        a();
        ar.a((Object) resultHolder, (Object) "ResultHolder not provided.");
        ((zzao) o()).zza(activityTransitionRequest, pendingIntent, new q(resultHolder));
    }

    public final void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, ResultHolder<Status> resultHolder) {
        a();
        ar.a((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        ar.a((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        ar.a((Object) resultHolder, (Object) "ResultHolder not provided.");
        ((zzao) o()).zza(geofencingRequest, pendingIntent, new x(resultHolder));
    }

    public final void a(LocationRequest locationRequest, PendingIntent pendingIntent, zzaj zzaj) {
        this.f.a(locationRequest, pendingIntent, zzaj);
    }

    public final void a(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzaj zzaj) {
        synchronized (this.f) {
            this.f.a(locationRequest, (ListenerHolder) listenerHolder, zzaj);
        }
    }

    public final void a(LocationSettingsRequest locationSettingsRequest, ResultHolder<LocationSettingsResult> resultHolder, @Nullable String str) {
        boolean z = true;
        a();
        ar.b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (resultHolder == null) {
            z = false;
        }
        ar.b(z, "listener can't be null.");
        ((zzao) o()).zza(locationSettingsRequest, new z(resultHolder), str);
    }

    public final void a(zzal zzal, ResultHolder<Status> resultHolder) {
        a();
        ar.a((Object) zzal, (Object) "removeGeofencingRequest can't be null.");
        ar.a((Object) resultHolder, (Object) "ResultHolder not provided.");
        ((zzao) o()).zza(zzal, new y(resultHolder));
    }

    public final void a(boolean z) {
        this.f.a(z);
    }

    public final void b(m<d> mVar, zzaj zzaj) {
        this.f.b(mVar, zzaj);
    }

    public final void disconnect() {
        synchronized (this.f) {
            if (isConnected()) {
                try {
                    this.f.c();
                    this.f.d();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public final Location r() {
        return this.f.a();
    }

    public final LocationAvailability s() {
        return this.f.b();
    }
}
