package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzadh
public final class he implements zzgj {
    private final Object a;
    @VisibleForTesting
    private final hb b;
    @VisibleForTesting
    private final HashSet<gt> c;
    @VisibleForTesting
    private final HashSet<hd> d;

    public he() {
        this(akc.c());
    }

    private he(String str) {
        this.a = new Object();
        this.c = new HashSet();
        this.d = new HashSet();
        this.b = new hb(str);
    }

    public final Bundle a(Context context, zzajs zzajs, String str) {
        Bundle bundle;
        synchronized (this.a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.b.a(context, str));
            Bundle bundle2 = new Bundle();
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                hd hdVar = (hd) it.next();
                bundle2.putBundle(hdVar.a(), hdVar.b());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(((gt) it.next()).d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzajs.zza(this.c);
            this.c.clear();
        }
        return bundle;
    }

    public final void a() {
        synchronized (this.a) {
            this.b.a();
        }
    }

    public final void a(gt gtVar) {
        synchronized (this.a) {
            this.c.add(gtVar);
        }
    }

    public final void a(hd hdVar) {
        synchronized (this.a) {
            this.d.add(hdVar);
        }
    }

    public final void a(zzjj zzjj, long j) {
        synchronized (this.a) {
            this.b.a(zzjj, j);
        }
    }

    public final void a(HashSet<gt> hashSet) {
        synchronized (this.a) {
            this.c.addAll(hashSet);
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.b.b();
        }
    }

    public final void zzh(boolean z) {
        long currentTimeMillis = au.l().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - au.i().l().i() > ((Long) akc.f().a(amn.aI)).longValue()) {
                this.b.a = -1;
                return;
            }
            this.b.a = au.i().l().j();
            return;
        }
        au.i().l().a(currentTimeMillis);
        au.i().l().b(this.b.a);
    }
}
