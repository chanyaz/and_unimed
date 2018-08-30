package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ajo {
    private long a;
    private Bundle b;
    private int c;
    private List<String> d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private zzmq i;
    private Location j;
    private String k;
    private Bundle l;
    private Bundle m;
    private List<String> n;
    private String o;
    private String p;
    private boolean q;

    public ajo() {
        this.a = -1;
        this.b = new Bundle();
        this.c = -1;
        this.d = new ArrayList();
        this.e = false;
        this.f = -1;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new Bundle();
        this.m = new Bundle();
        this.n = new ArrayList();
        this.o = null;
        this.p = null;
        this.q = false;
    }

    public ajo(zzjj zzjj) {
        this.a = zzjj.b;
        this.b = zzjj.c;
        this.c = zzjj.d;
        this.d = zzjj.e;
        this.e = zzjj.f;
        this.f = zzjj.g;
        this.g = zzjj.h;
        this.h = zzjj.i;
        this.i = zzjj.j;
        this.j = zzjj.k;
        this.k = zzjj.l;
        this.l = zzjj.m;
        this.m = zzjj.n;
        this.n = zzjj.o;
        this.o = zzjj.p;
        this.p = zzjj.q;
    }

    public final ajo a(@Nullable Location location) {
        this.j = null;
        return this;
    }

    public final zzjj a() {
        return new zzjj(7, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, false);
    }
}
