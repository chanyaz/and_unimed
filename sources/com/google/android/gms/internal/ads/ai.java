package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzadh
public final class ai extends aa {
    protected auo g;
    private zzxn h;
    @VisibleForTesting
    private zzww i;
    private aui j;
    private final ana k;
    private final zzaqw l;
    private boolean m;

    ai(Context context, gs gsVar, zzxn zzxn, zzabm zzabm, ana ana, zzaqw zzaqw) {
        super(context, gsVar, zzabm);
        this.h = zzxn;
        this.j = gsVar.c;
        this.k = ana;
        this.l = zzaqw;
    }

    protected final gr a(int i) {
        String str;
        zzaef zzaef = this.e.a;
        zzjj zzjj = zzaef.c;
        zzaqw zzaqw = this.l;
        List list = this.f.c;
        List list2 = this.f.e;
        List list3 = this.f.i;
        int i2 = this.f.k;
        long j = this.f.j;
        String str2 = zzaef.i;
        boolean z = this.f.g;
        auh auh = this.g != null ? this.g.b : null;
        zzxq zzxq = this.g != null ? this.g.c : null;
        String name = this.g != null ? this.g.d : AdMobAdapter.class.getName();
        aui aui = this.j;
        auk auk = this.g != null ? this.g.e : null;
        long j2 = this.f.h;
        zzjn zzjn = this.e.d;
        long j3 = this.f.f;
        long j4 = this.e.f;
        long j5 = this.f.m;
        String str3 = this.f.n;
        JSONObject jSONObject = this.e.h;
        zzaig zzaig = this.f.A;
        List list4 = this.f.B;
        List list5 = this.f.C;
        boolean z2 = this.j != null ? this.j.o : false;
        zzael zzael = this.f.E;
        if (this.i != null) {
            List<auo> zzme = this.i.zzme();
            String str4 = "";
            if (zzme == null) {
                str = str4.toString();
            } else {
                str = str4;
                for (auo auo : zzme) {
                    if (!(auo == null || auo.b == null || TextUtils.isEmpty(auo.b.d))) {
                        int i3;
                        String valueOf = String.valueOf(str);
                        String str5 = auo.b.d;
                        switch (auo.a) {
                            case -1:
                                i3 = 4;
                                break;
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 1;
                                break;
                            case 3:
                                i3 = 2;
                                break;
                            case 4:
                                i3 = 3;
                                break;
                            case 5:
                                i3 = 5;
                                break;
                            default:
                                i3 = 6;
                                break;
                        }
                        str4 = new StringBuilder(String.valueOf(str5).length() + 33).append(str5).append(".").append(i3).append(".").append(auo.g).toString();
                        str = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str4).length()).append(valueOf).append(str4).append("_").toString();
                    }
                }
                str = str.substring(0, Math.max(0, str.length() - 1));
            }
        } else {
            str = null;
        }
        return new gr(zzjj, zzaqw, list, i, list2, list3, i2, j, str2, z, auh, zzxq, name, aui, auk, j2, zzjn, j3, j4, j5, str3, jSONObject, null, zzaig, list4, list5, z2, zzael, str, this.f.H, this.f.L, this.e.i, this.f.O, this.e.j, this.f.Q, this.f.R, this.f.S, this.f.T);
    }

    protected final void a(long j) {
        synchronized (this.d) {
            zzww auq;
            if (this.j.m != -1) {
                auq = new auq(this.b, this.e.a, this.h, this.j, this.f.s, this.f.z, this.f.J, j, ((Long) akc.f().a(amn.bB)).longValue(), 2, this.e.j);
            } else {
                auq = new aut(this.b, this.e.a, this.h, this.j, this.f.s, this.f.z, this.f.J, j, ((Long) akc.f().a(amn.bB)).longValue(), this.k, this.e.j);
            }
            this.i = auq;
        }
        List arrayList = new ArrayList(this.j.a);
        boolean z = false;
        Bundle bundle = this.e.a.c.m;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
            }
        }
        if (z) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((auh) listIterator.next()).c.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.g = this.i.zzh(arrayList);
        switch (this.g.a) {
            case 0:
                if (this.g.b != null && this.g.b.o != null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    ht.a.post(new aj(this, countDownLatch));
                    try {
                        countDownLatch.await(10, TimeUnit.SECONDS);
                        synchronized (this.d) {
                            if (!this.m) {
                                throw new zzabk("View could not be prepared", 0);
                            } else if (this.l.isDestroyed()) {
                                throw new zzabk("Assets not loaded, web view is destroyed", 0);
                            }
                        }
                        return;
                    } catch (InterruptedException e) {
                        String valueOf = String.valueOf(e);
                        throw new zzabk(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
                    }
                }
                return;
            case 1:
                throw new zzabk("No fill from any mediation ad networks.", 3);
            default:
                throw new zzabk("Unexpected mediation result: " + this.g.a, 0);
        }
    }

    public final void b() {
        synchronized (this.d) {
            super.b();
            if (this.i != null) {
                this.i.cancel();
            }
        }
    }
}
