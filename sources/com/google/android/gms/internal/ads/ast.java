package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ast {
    private final AtomicInteger a;
    private final Set<apk<?>> b;
    private final PriorityBlockingQueue<apk<?>> c;
    private final PriorityBlockingQueue<apk<?>> d;
    private final zzb e;
    private final zzm f;
    private final zzaa g;
    private final amc[] h;
    private adp i;
    private final List<zzw> j;

    public ast(zzb zzb, zzm zzm) {
        this(zzb, zzm, 4);
    }

    private ast(zzb zzb, zzm zzm, int i) {
        this(zzb, zzm, 4, new aie(new Handler(Looper.getMainLooper())));
    }

    private ast(zzb zzb, zzm zzm, int i, zzaa zzaa) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.j = new ArrayList();
        this.e = zzb;
        this.f = zzm;
        this.h = new amc[4];
        this.g = zzaa;
    }

    public final <T> apk<T> a(apk<T> apk) {
        apk.a(this);
        synchronized (this.b) {
            this.b.add(apk);
        }
        apk.a(this.a.incrementAndGet());
        apk.b("add-to-queue");
        if (apk.h()) {
            this.c.add(apk);
        } else {
            this.d.add(apk);
        }
        return apk;
    }

    public final void a() {
        int i = 0;
        if (this.i != null) {
            this.i.a();
        }
        for (amc amc : this.h) {
            if (amc != null) {
                amc.a();
            }
        }
        this.i = new adp(this.c, this.d, this.e, this.g);
        this.i.start();
        while (i < this.h.length) {
            amc amc2 = new amc(this.d, this.f, this.e, this.g);
            this.h[i] = amc2;
            amc2.start();
            i++;
        }
    }

    final <T> void b(apk<T> apk) {
        synchronized (this.b) {
            this.b.remove(apk);
        }
        synchronized (this.j) {
            for (zzw zzg : this.j) {
                zzg.zzg(apk);
            }
        }
    }
}
