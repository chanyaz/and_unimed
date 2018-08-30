package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.RemoteCreator;

@zzadh
public final class alo extends RemoteCreator<zzlm> {
    public alo() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzlm ? (zzlm) queryLocalInterface : new alc(iBinder);
    }
}
