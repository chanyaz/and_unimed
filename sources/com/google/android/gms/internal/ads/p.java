package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class p extends afa implements zzaap {
    p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Parcel a = a();
        a.writeInt(i);
        a.writeInt(i2);
        afc.a(a, (Parcelable) intent);
        b(12, a);
    }

    public final void onBackPressed() {
        b(10, a());
    }

    public final void onCreate(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        b(1, a);
    }

    public final void onDestroy() {
        b(8, a());
    }

    public final void onPause() {
        b(5, a());
    }

    public final void onRestart() {
        b(2, a());
    }

    public final void onResume() {
        b(4, a());
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        a = a(6, a);
        if (a.readInt() != 0) {
            bundle.readFromParcel(a);
        }
        a.recycle();
    }

    public final void onStart() {
        b(3, a());
    }

    public final void onStop() {
        b(7, a());
    }

    public final void zzax() {
        b(9, a());
    }

    public final boolean zznj() {
        Parcel a = a(11, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(13, a);
    }
}
