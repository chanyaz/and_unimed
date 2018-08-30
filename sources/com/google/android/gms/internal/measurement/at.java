package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.k;
import com.google.android.gms.analytics.q;
import com.google.android.gms.analytics.r;
import com.google.android.gms.analytics.s;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.ar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class at extends af {
    private boolean a;
    private final aq b;
    private final bv c;
    private final bu d;
    private final al e;
    private long f = Long.MIN_VALUE;
    private final bf g;
    private final bf h;
    private final cf i;
    private long j;
    private boolean k;

    protected at(ah ahVar, aj ajVar) {
        super(ahVar);
        ar.a((Object) ajVar);
        this.d = new bu(ahVar);
        this.b = new aq(ahVar);
        this.c = new bv(ahVar);
        this.e = new al(ahVar);
        this.i = new cf(i());
        this.g = new au(this, ahVar);
        this.h = new av(this, ahVar);
    }

    private final void A() {
        a(new ax(this));
    }

    private final void B() {
        try {
            this.b.f();
            g();
        } catch (SQLiteException e) {
            d("Failed to delete stale hits", e);
        }
        this.h.a(86400000);
    }

    private final void C() {
        if (!this.k && bd.b() && !this.e.b()) {
            if (this.i.a(((Long) bk.C.a()).longValue())) {
                this.i.a();
                b("Connecting to service");
                if (this.e.c()) {
                    b("Connected to service");
                    this.i.b();
                    e();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:30:0x0096, code:
            d("Database contains successfully uploaded hit", java.lang.Long.valueOf(r4), java.lang.Integer.valueOf(r8.size()));
            G();
     */
    private final boolean D() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.t.d();
        r12.y();
        r0 = "Dispatching a batch of local hits";
        r12.b(r0);
        r0 = r12.e;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0028;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r3 = r12.c;
        r3 = r3.b();
        if (r3 != 0) goto L_0x002a;
    L_0x001e:
        if (r0 == 0) goto L_0x002c;
    L_0x0020:
        if (r1 == 0) goto L_0x002c;
    L_0x0022:
        r0 = "No network or service available. Will retry later";
        r12.b(r0);
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = r2;
        goto L_0x0016;
    L_0x002a:
        r1 = r2;
        goto L_0x001e;
    L_0x002c:
        r0 = com.google.android.gms.internal.measurement.bd.f();
        r1 = com.google.android.gms.internal.measurement.bd.g();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0040:
        r0 = r12.b;	 Catch:{ all -> 0x01cf }
        r0.b();	 Catch:{ all -> 0x01cf }
        r3.clear();	 Catch:{ all -> 0x01cf }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x00c1 }
        r8 = r0.a(r6);	 Catch:{ SQLiteException -> 0x00c1 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00c1 }
        if (r0 == 0) goto L_0x0071;
    L_0x0054:
        r0 = "Store is empty, nothing to dispatch";
        r12.b(r0);	 Catch:{ SQLiteException -> 0x00c1 }
        r12.G();	 Catch:{ SQLiteException -> 0x00c1 }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x0067 }
        r0.c();	 Catch:{ SQLiteException -> 0x0067 }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x0067 }
        r0.d();	 Catch:{ SQLiteException -> 0x0067 }
        goto L_0x0027;
    L_0x0067:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x0071:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00c1 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00c1 }
        r12.a(r0, r1);	 Catch:{ SQLiteException -> 0x00c1 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01cf }
    L_0x0082:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x00e1;
    L_0x0088:
        r0 = r1.next();	 Catch:{ all -> 0x01cf }
        r0 = (com.google.android.gms.internal.measurement.bp) r0;	 Catch:{ all -> 0x01cf }
        r10 = r0.c();	 Catch:{ all -> 0x01cf }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0082;
    L_0x0096:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01cf }
        r3 = r8.size();	 Catch:{ all -> 0x01cf }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01cf }
        r12.d(r0, r1, r3);	 Catch:{ all -> 0x01cf }
        r12.G();	 Catch:{ all -> 0x01cf }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x00b6 }
        r0.c();	 Catch:{ SQLiteException -> 0x00b6 }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x00b6 }
        r0.d();	 Catch:{ SQLiteException -> 0x00b6 }
        goto L_0x0027;
    L_0x00b6:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x00c1:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.d(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.G();	 Catch:{ all -> 0x01cf }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x00d6 }
        r0.c();	 Catch:{ SQLiteException -> 0x00d6 }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x00d6 }
        r0.d();	 Catch:{ SQLiteException -> 0x00d6 }
        goto L_0x0027;
    L_0x00d6:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x00e1:
        r0 = r12.e;	 Catch:{ all -> 0x01cf }
        r0 = r0.b();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x0148;
    L_0x00e9:
        r0 = "Service connected, sending hits to the service";
        r12.b(r0);	 Catch:{ all -> 0x01cf }
    L_0x00ee:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01cf }
        if (r0 != 0) goto L_0x0148;
    L_0x00f4:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01cf }
        r0 = (com.google.android.gms.internal.measurement.bp) r0;	 Catch:{ all -> 0x01cf }
        r1 = r12.e;	 Catch:{ all -> 0x01cf }
        r1 = r1.a(r0);	 Catch:{ all -> 0x01cf }
        if (r1 == 0) goto L_0x0148;
    L_0x0103:
        r10 = r0.c();	 Catch:{ all -> 0x01cf }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01cf }
        r8.remove(r0);	 Catch:{ all -> 0x01cf }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.b(r1, r0);	 Catch:{ all -> 0x01cf }
        r1 = r12.b;	 Catch:{ SQLiteException -> 0x0128 }
        r10 = r0.c();	 Catch:{ SQLiteException -> 0x0128 }
        r1.b(r10);	 Catch:{ SQLiteException -> 0x0128 }
        r0 = r0.c();	 Catch:{ SQLiteException -> 0x0128 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0128 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0128 }
        goto L_0x00ee;
    L_0x0128:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.e(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.G();	 Catch:{ all -> 0x01cf }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x013d }
        r0.c();	 Catch:{ SQLiteException -> 0x013d }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x013d }
        r0.d();	 Catch:{ SQLiteException -> 0x013d }
        goto L_0x0027;
    L_0x013d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x0148:
        r0 = r4;
        r4 = r12.c;	 Catch:{ all -> 0x01cf }
        r4 = r4.b();	 Catch:{ all -> 0x01cf }
        if (r4 == 0) goto L_0x017a;
    L_0x0151:
        r4 = r12.c;	 Catch:{ all -> 0x01cf }
        r8 = r4.a(r8);	 Catch:{ all -> 0x01cf }
        r9 = r8.iterator();	 Catch:{ all -> 0x01cf }
        r4 = r0;
    L_0x015c:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x0171;
    L_0x0162:
        r0 = r9.next();	 Catch:{ all -> 0x01cf }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01cf }
        r0 = r0.longValue();	 Catch:{ all -> 0x01cf }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01cf }
        goto L_0x015c;
    L_0x0171:
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x0197 }
        r0.a(r8);	 Catch:{ SQLiteException -> 0x0197 }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x0197 }
        r0 = r4;
    L_0x017a:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01cf }
        if (r4 == 0) goto L_0x01b7;
    L_0x0180:
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x018c }
        r0.c();	 Catch:{ SQLiteException -> 0x018c }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x018c }
        r0.d();	 Catch:{ SQLiteException -> 0x018c }
        goto L_0x0027;
    L_0x018c:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x0197:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.e(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.G();	 Catch:{ all -> 0x01cf }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x01ac }
        r0.c();	 Catch:{ SQLiteException -> 0x01ac }
        r0 = r12.b;	 Catch:{ SQLiteException -> 0x01ac }
        r0.d();	 Catch:{ SQLiteException -> 0x01ac }
        goto L_0x0027;
    L_0x01ac:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x01b7:
        r4 = r12.b;	 Catch:{ SQLiteException -> 0x01c4 }
        r4.c();	 Catch:{ SQLiteException -> 0x01c4 }
        r4 = r12.b;	 Catch:{ SQLiteException -> 0x01c4 }
        r4.d();	 Catch:{ SQLiteException -> 0x01c4 }
        r4 = r0;
        goto L_0x0040;
    L_0x01c4:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
    L_0x01cf:
        r0 = move-exception;
        r1 = r12.b;	 Catch:{ SQLiteException -> 0x01db }
        r1.c();	 Catch:{ SQLiteException -> 0x01db }
        r1 = r12.b;	 Catch:{ SQLiteException -> 0x01db }
        r1.d();	 Catch:{ SQLiteException -> 0x01db }
        throw r0;
    L_0x01db:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.e(r1, r0);
        r12.G();
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.at.D():boolean");
    }

    private final long E() {
        t.d();
        y();
        try {
            return this.b.g();
        } catch (SQLiteException e) {
            e("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private final void F() {
        bi p = p();
        if (p.b() && !p.c()) {
            long E = E();
            if (E != 0 && Math.abs(i().currentTimeMillis() - E) <= ((Long) bk.h.a()).longValue()) {
                a("Dispatch alarm scheduled (ms)", Long.valueOf(bd.e()));
                p.d();
            }
        }
    }

    private final void G() {
        if (this.g.c()) {
            b("All hits dispatched or no network/service. Going to power save mode");
        }
        this.g.d();
        bi p = p();
        if (p.c()) {
            p.e();
        }
    }

    private final long H() {
        if (this.f != Long.MIN_VALUE) {
            return this.f;
        }
        long longValue = ((Long) bk.e.a()).longValue();
        af q = q();
        q.y();
        if (!q.a) {
            return longValue;
        }
        af q2 = q();
        q2.y();
        return ((long) q2.b) * 1000;
    }

    private final void I() {
        y();
        t.d();
        this.k = true;
        this.e.d();
        g();
    }

    private final void a(ak akVar, jd jdVar) {
        ar.a((Object) akVar);
        ar.a((Object) jdVar);
        s kVar = new k(h());
        kVar.a(akVar.c());
        kVar.b(akVar.d());
        q h = kVar.h();
        t tVar = (t) h.b(t.class);
        tVar.a("data");
        tVar.b(true);
        h.a((r) jdVar);
        ju juVar = (ju) h.b(ju.class);
        jc jcVar = (jc) h.b(jc.class);
        for (Entry entry : akVar.f().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                jcVar.a(str2);
            } else if ("av".equals(str)) {
                jcVar.b(str2);
            } else if ("aid".equals(str)) {
                jcVar.c(str2);
            } else if ("aiid".equals(str)) {
                jcVar.d(str2);
            } else if ("uid".equals(str)) {
                tVar.c(str2);
            } else {
                juVar.a(str, str2);
            }
        }
        b("Sending installation campaign to", akVar.c(), jdVar);
        h.a(r().b());
        h.e();
    }

    private final boolean g(String str) {
        return c.b(j()).a(str) == 0;
    }

    public final long a(ak akVar, boolean z) {
        ar.a((Object) akVar);
        y();
        t.d();
        try {
            this.b.b();
            ae aeVar = this.b;
            long a = akVar.a();
            ar.a(akVar.b());
            aeVar.y();
            t.d();
            int delete = aeVar.A().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(a), r1});
            if (delete > 0) {
                aeVar.a("Deleted property records", Integer.valueOf(delete));
            }
            a = this.b.a(akVar.a(), akVar.b(), akVar.c());
            akVar.a(1 + a);
            ae aeVar2 = this.b;
            ar.a((Object) akVar);
            aeVar2.y();
            t.d();
            SQLiteDatabase A = aeVar2.A();
            Object f = akVar.f();
            ar.a(f);
            Builder builder = new Builder();
            for (Entry entry : f.entrySet()) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            String str = encodedQuery == null ? "" : encodedQuery;
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(akVar.a()));
            contentValues.put("cid", akVar.b());
            contentValues.put("tid", akVar.c());
            contentValues.put("adid", Integer.valueOf(akVar.d() ? 1 : 0));
            contentValues.put("hits_count", Long.valueOf(akVar.e()));
            contentValues.put("params", str);
            try {
                if (A.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    aeVar2.f("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e) {
                aeVar2.e("Error storing a property", e);
            }
            this.b.c();
            try {
                this.b.d();
            } catch (SQLiteException e2) {
                e("Failed to end transaction", e2);
            }
            return a;
        } catch (SQLiteException e22) {
            e("Failed to update Analytics property", e22);
            try {
                this.b.d();
            } catch (SQLiteException e222) {
                e("Failed to end transaction", e222);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.b.d();
            } catch (SQLiteException e3) {
                e("Failed to end transaction", e3);
            }
            throw th;
        }
    }

    protected final void a() {
        this.b.z();
        this.c.z();
        this.e.z();
    }

    protected final void a(ak akVar) {
        t.d();
        b("Sending first hit to property", akVar.c());
        if (!r().c().a(bd.l())) {
            String f = r().f();
            if (!TextUtils.isEmpty(f)) {
                jd a = cj.a(h(), f);
                b("Found relevant installation campaign", a);
                a(akVar, a);
            }
        }
    }

    public final void a(bp bpVar) {
        ar.a((Object) bpVar);
        t.d();
        y();
        if (this.k) {
            c("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            a("Delivering hit", bpVar);
        }
        if (TextUtils.isEmpty(bpVar.h())) {
            Pair a = r().g().a();
            if (a != null) {
                Long l = (Long) a.second;
                String str = (String) a.first;
                String valueOf = String.valueOf(l);
                valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
                Map hashMap = new HashMap(bpVar.b());
                hashMap.put("_m", valueOf);
                bpVar = new bp(this, hashMap, bpVar.d(), bpVar.f(), bpVar.c(), bpVar.a(), bpVar.e());
            }
        }
        C();
        if (this.e.a(bpVar)) {
            c("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.b.a(bpVar);
            g();
        } catch (SQLiteException e) {
            e("Delivery failed to save hit to a database", e);
            h().a(bpVar, "deliver: failed to insert hit to database");
        }
    }

    public final void a(zzca zzca) {
        long j = this.j;
        t.d();
        y();
        long j2 = -1;
        long d = r().d();
        if (d != 0) {
            j2 = Math.abs(i().currentTimeMillis() - d);
        }
        b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        C();
        try {
            D();
            r().e();
            g();
            if (zzca != null) {
                zzca.zza(null);
            }
            if (this.j != j) {
                this.d.c();
            }
        } catch (Throwable e) {
            e("Local dispatch failed", e);
            r().e();
            g();
            if (zzca != null) {
                zzca.zza(e);
            }
        }
    }

    public final void a(String str) {
        ar.a(str);
        t.d();
        jd a = cj.a(h(), str);
        if (a == null) {
            d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence f = r().f();
        if (str.equals(f)) {
            e("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(f)) {
            r().a(str);
            if (r().c().a(bd.l())) {
                d("Campaign received too late, ignoring", a);
                return;
            }
            b("Received installation campaign", a);
            for (ak a2 : this.b.c(0)) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", f, str);
        }
    }

    final void b() {
        y();
        ar.a(!this.a, (Object) "Analytics backend already started");
        this.a = true;
        m().a(new aw(this));
    }

    protected final void c() {
        y();
        t.d();
        Context a = h().a();
        if (!ca.a(a)) {
            e("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!cb.a(a)) {
            f("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.a(a)) {
            e("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        r().b();
        if (!g("android.permission.ACCESS_NETWORK_STATE")) {
            f("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            I();
        }
        if (!g("android.permission.INTERNET")) {
            f("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            I();
        }
        if (cb.a(j())) {
            b("AnalyticsService registered in the app manifest and enabled");
        } else {
            e("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.k || this.b.e())) {
            C();
        }
        g();
    }

    final void d() {
        t.d();
        this.j = i().currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A:{LOOP_START, LOOP:1: B:18:0x005a->B:17:?} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A:{SYNTHETIC} */
    protected final void e() {
        /*
        r6 = this;
        com.google.android.gms.analytics.t.d();
        com.google.android.gms.analytics.t.d();
        r6.y();
        r0 = com.google.android.gms.internal.measurement.bd.b();
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.e(r0);
    L_0x0014:
        r0 = r6.e;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r0 = "Service not connected";
        r6.b(r0);
    L_0x0021:
        return;
    L_0x0022:
        r0 = r6.b;
        r0 = r0.e();
        if (r0 != 0) goto L_0x0021;
    L_0x002a:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.b(r0);
    L_0x002f:
        r0 = r6.b;	 Catch:{ SQLiteException -> 0x0044 }
        r1 = com.google.android.gms.internal.measurement.bd.f();	 Catch:{ SQLiteException -> 0x0044 }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x0044 }
        r1 = r0.a(r2);	 Catch:{ SQLiteException -> 0x0044 }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x0044 }
        if (r0 == 0) goto L_0x005a;
    L_0x0040:
        r6.g();	 Catch:{ SQLiteException -> 0x0044 }
        goto L_0x0021;
    L_0x0044:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.e(r1, r0);
        r6.G();
        goto L_0x0021;
    L_0x004e:
        r1.remove(r0);
        r2 = r6.b;	 Catch:{ SQLiteException -> 0x0073 }
        r4 = r0.c();	 Catch:{ SQLiteException -> 0x0073 }
        r2.b(r4);	 Catch:{ SQLiteException -> 0x0073 }
    L_0x005a:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x002f;
    L_0x0060:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.internal.measurement.bp) r0;
        r2 = r6.e;
        r2 = r2.a(r0);
        if (r2 != 0) goto L_0x004e;
    L_0x006f:
        r6.g();
        goto L_0x0021;
    L_0x0073:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.e(r1, r0);
        r6.G();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.at.e():void");
    }

    public final void f() {
        t.d();
        y();
        c("Sync dispatching local hits");
        long j = this.j;
        C();
        try {
            D();
            r().e();
            g();
            if (this.j != j) {
                this.d.c();
            }
        } catch (Exception e) {
            e("Sync local dispatch failed", e);
            g();
        }
    }

    public final void g() {
        t.d();
        y();
        Object obj = (this.k || H() <= 0) ? null : 1;
        if (obj == null) {
            this.d.b();
            G();
        } else if (this.b.e()) {
            this.d.b();
            G();
        } else {
            boolean z;
            if (((Boolean) bk.z.a()).booleanValue()) {
                z = true;
            } else {
                this.d.a();
                z = this.d.d();
            }
            if (z) {
                F();
                long H = H();
                long d = r().d();
                if (d != 0) {
                    d = H - Math.abs(i().currentTimeMillis() - d);
                    if (d <= 0) {
                        d = Math.min(bd.d(), H);
                    }
                } else {
                    d = Math.min(bd.d(), H);
                }
                a("Dispatch scheduled (ms)", Long.valueOf(d));
                if (this.g.c()) {
                    this.g.b(Math.max(1, d + this.g.b()));
                    return;
                } else {
                    this.g.a(d);
                    return;
                }
            }
            G();
            F();
        }
    }
}
