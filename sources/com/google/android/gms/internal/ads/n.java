package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.c;

@zzadh
public final class n extends RemoteCreator<zzaas> {
    public n() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzaap a(Activity activity) {
        try {
            IBinder zzp = ((zzaas) a(activity)).zzp(c.a((Object) activity));
            if (zzp == null) {
                return null;
            }
            IInterface queryLocalInterface = zzp.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return queryLocalInterface instanceof zzaap ? (zzaap) queryLocalInterface : new p(zzp);
        } catch (Throwable e) {
            kk.c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            kk.c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return queryLocalInterface instanceof zzaas ? (zzaas) queryLocalInterface : new q(iBinder);
    }
}
