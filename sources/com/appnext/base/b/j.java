package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.e;
import com.google.android.gms.location.g;

public class j {
    protected static final String TAG = j.class.getSimpleName();
    private static final long km = 1000;
    private static final long kn = 500;
    private GoogleApiClient iW;
    private a ko;
    private LocationSettingsRequest kp;
    private b kq;
    private boolean kr;
    private c ks;

    class a implements ConnectionCallbacks, OnConnectionFailedListener {
        private a() {
        }

        /* synthetic */ a(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @SuppressLint({"all"})
        public void onConnected(Bundle bundle) {
            synchronized (j.this) {
                j.this.cK();
            }
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            com.appnext.base.b.X("Connection failed: ConnectionResult.getErrorCode() = " + connectionResult.c());
            synchronized (j.this) {
                j.this.cM();
                j.this.aE(connectionResult.e());
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (j.this) {
                j.this.cM();
                j.this.aE("Connection suspended");
            }
        }
    }

    class b implements LocationListener {
        private b() {
        }

        /* synthetic */ b(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onLocationChanged(Location location) {
            synchronized (j.this) {
                j.this.cM();
                j.this.e(location);
            }
        }
    }

    public interface c {
        void a(Location location);

        void onError(String str);
    }

    private void a(Status status) {
        if (this.kr) {
            cM();
            return;
        }
        switch (status.d()) {
            case 0:
                cL();
                return;
            default:
                cM();
                aE(status.a());
                return;
        }
    }

    private void aE(String str) {
        if (this.ks != null) {
            this.ks.onError(str);
        }
    }

    private void b(Status status) {
        if (this.kr) {
            cM();
        } else if (!status.c()) {
            cM();
            aE(status.a());
        }
    }

    public static Location cG() {
        try {
            if (!hasPermission()) {
                return null;
            }
            LocationManager locationManager = (LocationManager) d.getContext().getSystemService("location");
            Location location = null;
            for (String lastKnownLocation : locationManager.getProviders(true)) {
                Location lastKnownLocation2 = locationManager.getLastKnownLocation(lastKnownLocation);
                if (lastKnownLocation2 != null) {
                    if (location != null && lastKnownLocation2.getAccuracy() >= location.getAccuracy()) {
                        lastKnownLocation2 = location;
                    }
                    location = lastKnownLocation2;
                }
            }
            return location;
        } catch (Throwable th) {
            return null;
        }
    }

    private void cH() {
        if (cr()) {
            this.iW.b();
        } else {
            aE(TAG + "  Google Api LocationServices not available");
        }
    }

    private static LocationRequest cI() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.a((long) km);
        locationRequest.b(kn);
        locationRequest.a(100);
        return locationRequest;
    }

    private void cJ() {
        g gVar = new g();
        gVar.a(cI());
        this.kp = gVar.a();
    }

    private void cK() {
        if (this.kr) {
            cM();
            return;
        }
        try {
            cJ();
            e.d.checkLocationSettings(this.iW, this.kp).a(new ResultCallback<LocationSettingsResult>() {
                public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {
                    synchronized (j.this) {
                        j.this.a(locationSettingsResult.getStatus());
                    }
                }
            });
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    @SuppressLint({"all"})
    private void cL() {
        if (this.kr) {
            cM();
            return;
        }
        try {
            this.kq = new b(this, null);
            e.b.requestLocationUpdates(this.iW, cI(), this.kq).a(new ResultCallback<Status>() {
                public void onResult(@NonNull Status status) {
                    synchronized (j.this) {
                        j.this.b(status);
                    }
                }
            });
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    private void cM() {
        try {
            if (this.kq != null) {
                e.b.removeLocationUpdates(this.iW, this.kq).a(new ResultCallback<Status>() {
                    public void onResult(@NonNull Status status) {
                        synchronized (j.this) {
                            try {
                                if (j.this.iW != null && j.this.iW.d()) {
                                    j.this.iW.c();
                                }
                                j.this.iW = null;
                                j.this.ko = null;
                                j.this.kq = null;
                            } catch (Throwable th) {
                                com.appnext.base.b.a(th);
                            }
                        }
                    }
                });
            } else if (this.iW != null) {
                this.iW.c();
                this.iW = null;
                this.ko = null;
            }
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    private boolean cr() {
        try {
            this.ko = new a(this, null);
            this.iW = new i(d.getContext()).a(this.ko).a(this.ko).a(e.a).b();
            return true;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return false;
        }
    }

    private void e(Location location) {
        if (this.ks != null) {
            this.ks.a(location);
        }
    }

    private static boolean hasPermission() {
        return f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION") || f.g(d.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    public void a(c cVar) {
        this.ks = cVar;
    }

    public void cF() {
        synchronized (this) {
            this.kr = true;
            if (this.kq != null) {
                cM();
            }
        }
    }

    public void init() {
        synchronized (this) {
            if (hasPermission()) {
                this.kr = false;
                cH();
                return;
            }
            aE("no location permissions");
        }
    }
}
