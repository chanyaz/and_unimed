package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

public final class m extends a implements zzao {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final Location zza(String str) {
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(21, a);
        Location location = (Location) ag.a(a2, Location.CREATOR);
        a2.recycle();
        return location;
    }

    public final void zza(long j, boolean z, PendingIntent pendingIntent) {
        Parcel a = a();
        a.writeLong(j);
        ag.a(a, true);
        ag.a(a, (Parcelable) pendingIntent);
        b(5, a);
    }

    public final void zza(PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel a = a();
        ag.a(a, (Parcelable) pendingIntent);
        ag.a(a, (IInterface) iStatusCallback);
        b(73, a);
    }

    public final void zza(Location location) {
        Parcel a = a();
        ag.a(a, (Parcelable) location);
        b(13, a);
    }

    public final void zza(zzaj zzaj) {
        Parcel a = a();
        ag.a(a, (IInterface) zzaj);
        b(67, a);
    }

    public final void zza(zzbf zzbf) {
        Parcel a = a();
        ag.a(a, (Parcelable) zzbf);
        b(59, a);
    }

    public final void zza(zzo zzo) {
        Parcel a = a();
        ag.a(a, (Parcelable) zzo);
        b(75, a);
    }

    public final void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel a = a();
        ag.a(a, (Parcelable) activityTransitionRequest);
        ag.a(a, (Parcelable) pendingIntent);
        ag.a(a, (IInterface) iStatusCallback);
        b(72, a);
    }

    public final void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzam zzam) {
        Parcel a = a();
        ag.a(a, (Parcelable) geofencingRequest);
        ag.a(a, (Parcelable) pendingIntent);
        ag.a(a, (IInterface) zzam);
        b(57, a);
    }

    public final void zza(LocationSettingsRequest locationSettingsRequest, zzaq zzaq, String str) {
        Parcel a = a();
        ag.a(a, (Parcelable) locationSettingsRequest);
        ag.a(a, (IInterface) zzaq);
        a.writeString(str);
        b(63, a);
    }

    public final void zza(zzal zzal, zzam zzam) {
        Parcel a = a();
        ag.a(a, (Parcelable) zzal);
        ag.a(a, (IInterface) zzam);
        b(74, a);
    }

    public final void zza(boolean z) {
        Parcel a = a();
        ag.a(a, z);
        b(12, a);
    }

    public final LocationAvailability zzb(String str) {
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(34, a);
        LocationAvailability locationAvailability = (LocationAvailability) ag.a(a2, LocationAvailability.CREATOR);
        a2.recycle();
        return locationAvailability;
    }

    public final void zzb(PendingIntent pendingIntent) {
        Parcel a = a();
        ag.a(a, (Parcelable) pendingIntent);
        b(6, a);
    }
}
