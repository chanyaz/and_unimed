package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

class ag {
    private static ag a;
    private final Context b;
    private final LocationManager c;
    private final ah d = new ah();

    @VisibleForTesting
    ag(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
        } catch (Throwable e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
        }
        return null;
    }

    static ag a(@NonNull Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new ag(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    private void a(@NonNull Location location) {
        long j;
        ah ahVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        af a = af.a();
        a.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.a;
        a.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.c == 1;
        long j3 = a.b;
        long j4 = a.a;
        a.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        ahVar.a = z;
        ahVar.b = j2;
        ahVar.c = j3;
        ahVar.d = j4;
        ahVar.e = j5;
        ahVar.f = j;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a = PermissionChecker.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (PermissionChecker.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    boolean a() {
        ah ahVar = this.d;
        if (c()) {
            return ahVar.a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return ahVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
