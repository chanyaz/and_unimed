package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.firebase_messaging.d;
import com.google.android.gms.internal.firebase_messaging.zze;

public class zzi implements Parcelable {
    public static final Creator<zzi> CREATOR = new z();
    private Messenger a;
    private zze b;

    public zzi(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.a = new Messenger(iBinder);
        } else {
            this.b = d.a(iBinder);
        }
    }

    private final IBinder a() {
        return this.a != null ? this.a.getBinder() : this.b.asBinder();
    }

    public final void a(Message message) {
        if (this.a != null) {
            this.a.send(message);
        } else {
            this.b.send(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return z;
        }
        try {
            return a().equals(((zzi) obj).a());
        } catch (ClassCastException e) {
            return z;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a != null) {
            parcel.writeStrongBinder(this.a.getBinder());
        } else {
            parcel.writeStrongBinder(this.b.asBinder());
        }
    }
}
