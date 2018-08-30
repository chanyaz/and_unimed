package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.c;

@zzadh
public final class apz extends RemoteCreator<zzqd> {
    @VisibleForTesting
    public apz() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzqa a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            IBinder zza = ((zzqd) a(context)).zza(c.a((Object) context), c.a((Object) frameLayout), c.a((Object) frameLayout2), 12451000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return queryLocalInterface instanceof zzqa ? (zzqa) queryLocalInterface : new aou(zza);
        } catch (RemoteException e2) {
            e = e2;
            kk.c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (RemoteCreatorException e3) {
            e = e3;
            kk.c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return queryLocalInterface instanceof zzqd ? (zzqd) queryLocalInterface : new aov(iBinder);
    }
}
