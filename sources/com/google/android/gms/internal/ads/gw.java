package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.GuardedBy;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class gw implements zzakh {
    private final Object a = new Object();
    private afg b;
    private final hc c = new hc();
    private final hn d = new hn();
    private boolean e = false;
    private Context f;
    private zzang g;
    @Nullable
    private amq h = null;
    @Nullable
    private agt i = null;
    @Nullable
    private agp j = null;
    @Nullable
    private Boolean k = null;
    private String l;
    private final AtomicInteger m = new AtomicInteger(0);
    private final gz n = new gz();
    private final Object o = new Object();
    @GuardedBy("mGrantedPermissionLock")
    private zzanz<ArrayList<String>> p;

    /* JADX WARNING: Missing block: B:37:?, code:
            return null;
     */
    @javax.annotation.Nullable
    private final com.google.android.gms.internal.ads.agt a(@javax.annotation.Nullable android.content.Context r5, boolean r6, boolean r7) {
        /*
        r4 = this;
        r1 = 0;
        r0 = com.google.android.gms.internal.ads.amn.Q;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r0 = r2.a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        r0 = r1;
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = com.google.android.gms.common.util.p.b();
        if (r0 != 0) goto L_0x001d;
    L_0x001b:
        r0 = r1;
        goto L_0x0014;
    L_0x001d:
        r0 = com.google.android.gms.internal.ads.amn.Y;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r0 = r2.a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0043;
    L_0x002f:
        r0 = com.google.android.gms.internal.ads.amn.W;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r0 = r2.a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0043;
    L_0x0041:
        r0 = r1;
        goto L_0x0014;
    L_0x0043:
        if (r6 == 0) goto L_0x0049;
    L_0x0045:
        if (r7 == 0) goto L_0x0049;
    L_0x0047:
        r0 = r1;
        goto L_0x0014;
    L_0x0049:
        r2 = r4.a;
        monitor-enter(r2);
        r0 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0054;
    L_0x0052:
        if (r5 != 0) goto L_0x0057;
    L_0x0054:
        monitor-exit(r2);	 Catch:{ all -> 0x0083 }
        r0 = r1;
        goto L_0x0014;
    L_0x0057:
        r0 = r4.j;	 Catch:{ all -> 0x0083 }
        if (r0 != 0) goto L_0x0062;
    L_0x005b:
        r0 = new com.google.android.gms.internal.ads.agp;	 Catch:{ all -> 0x0083 }
        r0.<init>();	 Catch:{ all -> 0x0083 }
        r4.j = r0;	 Catch:{ all -> 0x0083 }
    L_0x0062:
        r0 = r4.i;	 Catch:{ all -> 0x0083 }
        if (r0 != 0) goto L_0x0075;
    L_0x0066:
        r0 = new com.google.android.gms.internal.ads.agt;	 Catch:{ all -> 0x0083 }
        r1 = r4.j;	 Catch:{ all -> 0x0083 }
        r3 = r4.g;	 Catch:{ all -> 0x0083 }
        r3 = com.google.android.gms.internal.ads.bq.a(r5, r3);	 Catch:{ all -> 0x0083 }
        r0.<init>(r1, r3);	 Catch:{ all -> 0x0083 }
        r4.i = r0;	 Catch:{ all -> 0x0083 }
    L_0x0075:
        r0 = r4.i;	 Catch:{ all -> 0x0083 }
        r0.a();	 Catch:{ all -> 0x0083 }
        r0 = "start fetching content...";
        com.google.android.gms.internal.ads.kk.d(r0);	 Catch:{ all -> 0x0083 }
        r0 = r4.i;	 Catch:{ all -> 0x0083 }
        monitor-exit(r2);	 Catch:{ all -> 0x0083 }
        goto L_0x0014;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0083 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gw.a(android.content.Context, boolean, boolean):com.google.android.gms.internal.ads.agt");
    }

    @TargetApi(16)
    private static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        try {
            PackageInfo b = c.b(context).b(context.getApplicationInfo().packageName, 4096);
            if (b.requestedPermissions == null || b.requestedPermissionsFlags == null) {
                return arrayList;
            }
            for (int i = 0; i < b.requestedPermissions.length; i++) {
                if ((b.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(b.requestedPermissions[i]);
                }
            }
            return arrayList;
        } catch (NameNotFoundException e) {
            return arrayList;
        }
    }

    @Nullable
    public final agt a(@Nullable Context context) {
        return a(context, this.d.b(), this.d.d());
    }

    public final hc a() {
        return this.c;
    }

    @TargetApi(23)
    public final void a(Context context, zzang zzang) {
        synchronized (this.a) {
            if (!this.e) {
                amq amq;
                this.f = context.getApplicationContext();
                this.g = zzang;
                au.h().a(au.j());
                this.d.a(this.f);
                this.d.a((zzakh) this);
                bq.a(this.f, this.g);
                this.l = au.e().b(context, zzang.a);
                this.b = new afg(context.getApplicationContext(), this.g);
                au.n();
                if (((Boolean) akc.f().a(amn.N)).booleanValue()) {
                    amq = new amq();
                } else {
                    hl.a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    amq = null;
                }
                this.h = amq;
                ko.a((zzanz) new gy(this).zznt(), "AppState.registerCsiReporter");
                this.e = true;
                n();
            }
        }
    }

    public final void a(Boolean bool) {
        synchronized (this.a) {
            this.k = bool;
        }
    }

    public final void a(Throwable th, String str) {
        bq.a(this.f, this.g).zza(th, str);
    }

    public final void a(boolean z) {
        this.n.a(z);
    }

    @Nullable
    public final amq b() {
        amq amq;
        synchronized (this.a) {
            amq = this.h;
        }
        return amq;
    }

    public final void b(Throwable th, String str) {
        bq.a(this.f, this.g).zza(th, str, ((Float) akc.f().a(amn.f)).floatValue());
    }

    public final Boolean c() {
        Boolean bool;
        synchronized (this.a) {
            bool = this.k;
        }
        return bool;
    }

    public final boolean d() {
        return this.n.a();
    }

    public final boolean e() {
        return this.n.b();
    }

    public final void f() {
        this.n.c();
    }

    public final afg g() {
        return this.b;
    }

    @Nullable
    public final Resources h() {
        if (this.g.d) {
            return this.f.getResources();
        }
        try {
            DynamiteModule a = DynamiteModule.a(this.f, DynamiteModule.a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.a().getResources() : null;
        } catch (Throwable e) {
            kk.c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void i() {
        this.m.incrementAndGet();
    }

    public final void j() {
        this.m.decrementAndGet();
    }

    public final int k() {
        return this.m.get();
    }

    public final hn l() {
        hn hnVar;
        synchronized (this.a) {
            hnVar = this.d;
        }
        return hnVar;
    }

    @Nullable
    public final Context m() {
        return this.f;
    }

    public final zzanz<ArrayList<String>> n() {
        if (this.f != null && p.d()) {
            if (!((Boolean) akc.f().a(amn.bH)).booleanValue()) {
                synchronized (this.o) {
                    zzanz<ArrayList<String>> zzanz;
                    if (this.p != null) {
                        zzanz = this.p;
                        return zzanz;
                    }
                    zzanz = hr.a(new gx(this));
                    this.p = zzanz;
                    return zzanz;
                }
            }
        }
        return kq.a(new ArrayList());
    }

    final /* synthetic */ ArrayList o() {
        return b(this.f);
    }

    public final void zzd(Bundle bundle) {
        if (bundle.containsKey("content_url_opted_out") && bundle.containsKey("content_vertical_opted_out")) {
            a(this.f, bundle.getBoolean("content_url_opted_out"), bundle.getBoolean("content_vertical_opted_out"));
        }
    }
}
