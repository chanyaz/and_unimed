package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.measurement.ag;
import com.google.android.gms.internal.measurement.ak;
import com.google.android.gms.internal.measurement.bp;
import com.google.android.gms.internal.measurement.cj;
import com.google.android.gms.internal.measurement.jc;
import com.google.android.gms.internal.measurement.x;
import java.util.HashMap;
import java.util.Map;

final class z implements Runnable {
    private final /* synthetic */ Map a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ boolean f;
    private final /* synthetic */ String g;
    private final /* synthetic */ i h;

    z(i iVar, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.h = iVar;
        this.a = map;
        this.b = z;
        this.c = str;
        this.d = j;
        this.e = z2;
        this.f = z3;
        this.g = str2;
    }

    public final void run() {
        boolean z = true;
        if (this.h.e.b()) {
            this.a.put("sc", "start");
        }
        k n = this.h.n();
        ar.c("getClientId can not be called from the main thread");
        cj.b(this.a, "cid", n.g().o().b());
        String str = (String) this.a.get("sf");
        if (str != null) {
            double a = cj.a(str, 100.0d);
            if (cj.a(a, (String) this.a.get("cid"))) {
                this.h.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(a));
                return;
            }
        }
        x b = this.h.b();
        if (this.b) {
            cj.a(this.a, "ate", b.b());
            cj.a(this.a, "adid", b.c());
        } else {
            this.a.remove("ate");
            this.a.remove("adid");
        }
        jc b2 = this.h.c().b();
        cj.a(this.a, "an", b2.a());
        cj.a(this.a, "av", b2.b());
        cj.a(this.a, "aid", b2.c());
        cj.a(this.a, "aiid", b2.d());
        this.a.put("v", "1");
        this.a.put("_v", ag.b);
        cj.a(this.a, "ul", this.h.e().b().a());
        cj.a(this.a, "sr", this.h.e().c());
        boolean z2 = this.c.equals("transaction") || this.c.equals("item");
        if (z2 || this.h.d.a()) {
            long a2 = cj.a((String) this.a.get("ht"));
            if (a2 == 0) {
                a2 = this.d;
            }
            if (this.e) {
                this.h.h().c("Dry run enabled. Would have sent hit", new bp(this.h, this.a, a2, this.f));
                return;
            }
            String str2 = (String) this.a.get("cid");
            Map hashMap = new HashMap();
            cj.a(hashMap, "uid", this.a);
            cj.a(hashMap, "an", this.a);
            cj.a(hashMap, "aid", this.a);
            cj.a(hashMap, "av", this.a);
            cj.a(hashMap, "aiid", this.a);
            String str3 = this.g;
            if (TextUtils.isEmpty((CharSequence) this.a.get("adid"))) {
                z = false;
            }
            this.a.put("_s", String.valueOf(this.h.j().a(new ak(0, str2, str3, z, 0, hashMap))));
            this.h.j().a(new bp(this.h, this.a, a2, this.f));
            return;
        }
        this.h.h().a(this.a, "Too many hits sent too quickly, rate limiting invoked");
    }
}
