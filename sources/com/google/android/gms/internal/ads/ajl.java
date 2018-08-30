package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.c;

@zzadh
public final class ajl extends RemoteCreator<zzkq> {
    public ajl() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzkn a(Context context, String str, zzxn zzxn) {
        Throwable e;
        try {
            IBinder zza = ((zzkq) a(context)).zza(c.a((Object) context), str, zzxn, 12451000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new akm(zza);
        } catch (RemoteException e2) {
            e = e2;
            kk.c("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (RemoteCreatorException e3) {
            e = e3;
            kk.c("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzkq ? (zzkq) queryLocalInterface : new akn(iBinder);
    }
}
