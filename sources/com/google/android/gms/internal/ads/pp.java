package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public final class pp extends BaseGmsClient<zzatx> {
    public pp(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof zzatx ? (zzatx) queryLocalInterface : new ps(iBinder);
    }

    protected final String a() {
        return "com.google.android.gms.gass.START";
    }

    protected final String d() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public final zzatx r() {
        return (zzatx) super.o();
    }
}
