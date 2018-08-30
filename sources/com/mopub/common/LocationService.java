package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import java.math.BigDecimal;

public class LocationService {

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED;

        @Deprecated
        public static LocationAwareness fromMoPubLocationAwareness(com.mopub.common.MoPub.LocationAwareness locationAwareness) {
            return locationAwareness == com.mopub.common.MoPub.LocationAwareness.DISABLED ? DISABLED : locationAwareness == com.mopub.common.MoPub.LocationAwareness.TRUNCATED ? TRUNCATED : NORMAL;
        }

        @Deprecated
        public com.mopub.common.MoPub.LocationAwareness getNewLocationAwareness() {
            return this == TRUNCATED ? com.mopub.common.MoPub.LocationAwareness.TRUNCATED : this == DISABLED ? com.mopub.common.MoPub.LocationAwareness.DISABLED : com.mopub.common.MoPub.LocationAwareness.NORMAL;
        }
    }

    public enum ValidLocationProvider {
        NETWORK("network"),
        GPS("gps");
        
        @NonNull
        final String a;

        private ValidLocationProvider(String str) {
            this.a = str;
        }

        private boolean a(@NonNull Context context) {
            switch (this) {
                case NETWORK:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION") || DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
                case GPS:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
                default:
                    return false;
            }
        }

        public String toString() {
            return this.a;
        }
    }

    @Nullable
    @VisibleForTesting
    static Location a(@NonNull Context context, @NonNull ValidLocationProvider validLocationProvider) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(validLocationProvider);
        if (!validLocationProvider.a(context)) {
            return null;
        }
        try {
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(validLocationProvider.toString());
        } catch (SecurityException e) {
            MoPubLog.d("Failed to retrieve location from " + validLocationProvider.toString() + " provider: access appears to be disabled.");
        } catch (IllegalArgumentException e2) {
            MoPubLog.d("Failed to retrieve location: device has no " + validLocationProvider.toString() + " location provider.");
        } catch (NullPointerException e3) {
            MoPubLog.d("Failed to retrieve location: device has no " + validLocationProvider.toString() + " location provider.");
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    static Location a(@Nullable Location location, @Nullable Location location2) {
        return location == null ? location2 : (location2 == null || location.getTime() > location2.getTime()) ? location : location2;
    }

    @Nullable
    @VisibleForTesting
    static void a(@Nullable Location location, int i) {
        if (location != null && i >= 0) {
            location.setLatitude(BigDecimal.valueOf(location.getLatitude()).setScale(i, 5).doubleValue());
            location.setLongitude(BigDecimal.valueOf(location.getLongitude()).setScale(i, 5).doubleValue());
        }
    }

    @Nullable
    public static Location getLastKnownLocation(@NonNull Context context, int i, @NonNull com.mopub.common.MoPub.LocationAwareness locationAwareness) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(locationAwareness);
        if (locationAwareness == com.mopub.common.MoPub.LocationAwareness.DISABLED) {
            return null;
        }
        Location a = a(a(context, ValidLocationProvider.GPS), a(context, ValidLocationProvider.NETWORK));
        if (locationAwareness != com.mopub.common.MoPub.LocationAwareness.TRUNCATED) {
            return a;
        }
        a(a, i);
        return a;
    }
}
