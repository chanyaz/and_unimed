package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class p extends c {
    public p(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        hl.a("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = 3;
        this.a.finish();
    }
}
