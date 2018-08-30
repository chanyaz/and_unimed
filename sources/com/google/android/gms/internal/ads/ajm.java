package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.c;

@zzadh
public final class ajm extends RemoteCreator<zzkv> {
    @VisibleForTesting
    public ajm() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzks a(Context context, zzjn zzjn, String str, zzxn zzxn, int i) {
        Throwable e;
        try {
            IBinder zza = ((zzkv) a(context)).zza(c.a((Object) context), zzjn, str, zzxn, 12451000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new akp(zza);
        } catch (RemoteException e2) {
            e = e2;
            kk.a("Could not create remote AdManager.", e);
            return null;
        } catch (RemoteCreatorException e3) {
            e = e3;
            kk.a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzkv ? (zzkv) queryLocalInterface : new akq(iBinder);
    }
}
