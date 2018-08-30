package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class i extends k {
    public final IBinder a;
    private final /* synthetic */ BaseGmsClient d;

    @BinderThread
    public i(BaseGmsClient baseGmsClient, int i, IBinder iBinder, Bundle bundle) {
        this.d = baseGmsClient;
        super(baseGmsClient, i, bundle);
        this.a = iBinder;
    }

    protected final void a(ConnectionResult connectionResult) {
        if (this.d.x != null) {
            this.d.x.onConnectionFailed(connectionResult);
        }
        this.d.a(connectionResult);
    }

    protected final boolean e() {
        try {
            String interfaceDescriptor = this.a.getInterfaceDescriptor();
            if (this.d.d().equals(interfaceDescriptor)) {
                IInterface a = this.d.a(this.a);
                if (a == null) {
                    return false;
                }
                if (!this.d.a(2, 4, a) && !this.d.a(3, 4, a)) {
                    return false;
                }
                this.d.A = null;
                Bundle connectionHint = this.d.getConnectionHint();
                if (this.d.w != null) {
                    this.d.w.onConnected(connectionHint);
                }
                return true;
            }
            String d = this.d.d();
            Log.e("GmsClient", new StringBuilder((String.valueOf(d).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(d).append(" vs. ").append(interfaceDescriptor).toString());
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
