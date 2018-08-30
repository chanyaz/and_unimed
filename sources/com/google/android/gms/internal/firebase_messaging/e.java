package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

public final class e extends a implements zze {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    public final void send(Message message) {
        Parcel a = a();
        c.a(a, message);
        a(1, a);
    }
}
