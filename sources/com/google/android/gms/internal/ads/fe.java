package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.RemoteCreator;

@zzadh
public final class fe extends RemoteCreator<zzahc> {
    public fe() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    protected final /* synthetic */ Object b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof zzahc ? (zzahc) queryLocalInterface : new fa(iBinder);
    }
}
