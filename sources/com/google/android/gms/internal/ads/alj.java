package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class alj {
    private final HashSet<String> a = new HashSet();
    private final Bundle b = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> c = new HashMap();
    private final HashSet<String> d = new HashSet();
    private final Bundle e = new Bundle();
    private final HashSet<String> f = new HashSet();
    private Date g;
    private String h;
    private int i = -1;
    private Location j;
    private boolean k = false;
    private String l;
    private String m;
    private int n = -1;
    private boolean o;

    public final void a(int i) {
        this.i = i;
    }

    public final void a(Location location) {
        this.j = location;
    }

    public final void a(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.b.putBundle(cls.getName(), bundle);
    }

    public final void a(String str) {
        this.a.add(str);
    }

    public final void a(Date date) {
        this.g = date;
    }

    public final void a(boolean z) {
        this.n = z ? 1 : 0;
    }

    public final void b(String str) {
        this.d.add(str);
    }

    public final void b(boolean z) {
        this.o = z;
    }

    public final void c(String str) {
        this.d.remove(str);
    }

    public final void d(String str) {
        this.m = str;
    }
}
