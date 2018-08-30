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
public final class ahs extends BaseGmsClient<zzho> {
    ahs(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 123, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    @VisibleForTesting
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return queryLocalInterface instanceof zzho ? (zzho) queryLocalInterface : new ahu(iBinder);
    }

    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    @VisibleForTesting
    protected final String d() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public final zzho r() {
        return (zzho) super.o();
    }
}
