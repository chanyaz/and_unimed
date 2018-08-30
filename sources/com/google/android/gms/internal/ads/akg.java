package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final class akg extends afa implements zzke {
    akg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    public final void onAdClicked() {
        b(1, a());
    }
}
