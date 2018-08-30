package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.alj;
import java.util.Date;

@VisibleForTesting
public final class e {
    private final alj a = new alj();

    public e() {
        this.a.b("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final d a() {
        return new d(this, null);
    }

    public final e a(int i) {
        this.a.a(i);
        return this;
    }

    public final e a(Location location) {
        this.a.a(location);
        return this;
    }

    public final e a(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.a.a(cls, bundle);
        if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            this.a.c("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return this;
    }

    public final e a(String str) {
        this.a.a(str);
        return this;
    }

    public final e a(Date date) {
        this.a.a(date);
        return this;
    }

    public final e a(boolean z) {
        this.a.a(z);
        return this;
    }

    public final e b(String str) {
        this.a.b(str);
        return this;
    }

    public final e b(boolean z) {
        this.a.b(z);
        return this;
    }

    public final e c(String str) {
        this.a.d(str);
        return this;
    }
}
