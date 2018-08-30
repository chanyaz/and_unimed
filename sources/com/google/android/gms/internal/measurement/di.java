package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import java.util.List;

public abstract class di extends iy implements zzey {
    public di() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        List zza;
        switch (i) {
            case 1:
                zza((zzeu) iz.a(parcel, zzeu.CREATOR), (zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zza((zzjx) iz.a(parcel, zzjx.CREATOR), (zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zza((zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                zza((zzeu) iz.a(parcel, zzeu.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb((zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                zza = zza((zzdz) iz.a(parcel, zzdz.CREATOR), iz.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 9:
                byte[] zza2 = zza((zzeu) iz.a(parcel, zzeu.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String zzc = zzc((zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            case 12:
                zza((zzed) iz.a(parcel, zzed.CREATOR), (zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzb((zzed) iz.a(parcel, zzed.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zza = zza(parcel.readString(), parcel.readString(), iz.a(parcel), (zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 15:
                zza = zza(parcel.readString(), parcel.readString(), parcel.readString(), iz.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 16:
                zza = zza(parcel.readString(), parcel.readString(), (zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 17:
                zza = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 18:
                zzd((zzdz) iz.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
