package com.google.android.gms.internal.ads;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzadh
public final class avl implements MediationAdRequest {
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final boolean g;

    public avl(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = z2;
    }

    public final Date getBirthday() {
        return this.a;
    }

    public final int getGender() {
        return this.b;
    }

    public final Set<String> getKeywords() {
        return this.c;
    }

    public final Location getLocation() {
        return this.e;
    }

    public final boolean isDesignedForFamilies() {
        return this.g;
    }

    public final boolean isTesting() {
        return this.d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f;
    }
}
