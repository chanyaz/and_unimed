package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class o extends afb implements zzaap {
    public o() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzaap a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof zzaap ? (zzaap) queryLocalInterface : new p(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onCreate((Bundle) afc.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                onRestart();
                parcel2.writeNoException();
                break;
            case 3:
                onStart();
                parcel2.writeNoException();
                break;
            case 4:
                onResume();
                parcel2.writeNoException();
                break;
            case 5:
                onPause();
                parcel2.writeNoException();
                break;
            case 6:
                Bundle bundle = (Bundle) afc.a(parcel, Bundle.CREATOR);
                onSaveInstanceState(bundle);
                parcel2.writeNoException();
                afc.b(parcel2, bundle);
                break;
            case 7:
                onStop();
                parcel2.writeNoException();
                break;
            case 8:
                onDestroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzax();
                parcel2.writeNoException();
                break;
            case 10:
                onBackPressed();
                parcel2.writeNoException();
                break;
            case 11:
                boolean zznj = zznj();
                parcel2.writeNoException();
                afc.a(parcel2, zznj);
                break;
            case 12:
                onActivityResult(parcel.readInt(), parcel.readInt(), (Intent) afc.a(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzo(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
