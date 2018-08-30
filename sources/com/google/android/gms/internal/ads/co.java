package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public final class co extends BaseGmsClient<zzaen> {
    public co(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context.getApplicationContext() != null ? context.getApplicationContext() : context, looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    @VisibleForTesting
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof zzaen ? (zzaen) queryLocalInterface : new cv(iBinder);
    }

    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.service.START";
    }

    @VisibleForTesting
    protected final String d() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final zzaen r() {
        return (zzaen) super.o();
    }
}
