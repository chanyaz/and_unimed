package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

public interface zzao extends IInterface {
    Location zza(String str);

    void zza(long j, boolean z, PendingIntent pendingIntent);

    void zza(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zza(Location location);

    void zza(zzaj zzaj);

    void zza(zzbf zzbf);

    void zza(zzo zzo);

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzam zzam);

    void zza(LocationSettingsRequest locationSettingsRequest, zzaq zzaq, String str);

    void zza(zzal zzal, zzam zzam);

    void zza(boolean z);

    LocationAvailability zzb(String str);

    void zzb(PendingIntent pendingIntent);
}
