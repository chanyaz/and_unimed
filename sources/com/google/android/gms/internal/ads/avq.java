package com.google.android.gms.internal.ads;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.d;
import com.google.android.gms.ads.m;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzadh
public final class avq implements NativeMediationAdRequest {
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final zzpl g;
    private final List<String> h = new ArrayList();
    private final boolean i;
    private final Map<String, Boolean> j = new HashMap();

    public avq(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzpl zzpl, List<String> list, boolean z2) {
        this.a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = zzpl;
        this.i = z2;
        String str = "custom:";
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith(str)) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.j.put(split[1], Boolean.valueOf(true));
                        } else if ("false".equals(split[2])) {
                            this.j.put(split[1], Boolean.valueOf(false));
                        }
                    }
                } else {
                    this.h.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return aln.a().b();
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

    public final NativeAdOptions getNativeAdOptions() {
        if (this.g == null) {
            return null;
        }
        d b = new d().a(this.g.b).a(this.g.c).b(this.g.d);
        if (this.g.a >= 2) {
            b.b(this.g.e);
        }
        if (this.g.a >= 3 && this.g.f != null) {
            b.a(new m(this.g.f));
        }
        return b.a();
    }

    public final boolean isAdMuted() {
        return aln.a().c();
    }

    public final boolean isAppInstallAdRequested() {
        return this.h != null && (this.h.contains("2") || this.h.contains("6"));
    }

    public final boolean isContentAdRequested() {
        return this.h != null && (this.h.contains("1") || this.h.contains("6"));
    }

    public final boolean isDesignedForFamilies() {
        return this.i;
    }

    public final boolean isTesting() {
        return this.d;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.h != null && this.h.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f;
    }

    public final boolean zzna() {
        return this.h != null && this.h.contains("3");
    }

    public final Map<String, Boolean> zznb() {
        return this.j;
    }
}
