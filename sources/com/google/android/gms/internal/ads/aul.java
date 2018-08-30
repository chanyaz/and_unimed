package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.appnext.core.Ad;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.d;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.c;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class aul implements zzxf {
    private final String a;
    private final zzxn b;
    private final long c;
    private final aui d;
    private final auh e;
    private zzjj f;
    private final zzjn g;
    private final Context h;
    private final Object i = new Object();
    private final zzang j;
    private final boolean k;
    private final zzpl l;
    private final List<String> m;
    private final List<String> n;
    private final List<String> o;
    private final boolean p;
    private final boolean q;
    @GuardedBy("mLock")
    private zzxq r;
    @GuardedBy("mLock")
    private int s = -2;
    private zzxw t;

    public aul(Context context, String str, zzxn zzxn, aui aui, auh auh, zzjj zzjj, zzjn zzjn, zzang zzang, boolean z, boolean z2, zzpl zzpl, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        this.h = context;
        this.b = zzxn;
        this.e = auh;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.a = b();
        } else {
            this.a = str;
        }
        this.d = aui;
        if (auh.t != -1) {
            this.c = auh.t;
        } else if (aui.b != -1) {
            this.c = aui.b;
        } else {
            this.c = 10000;
        }
        this.f = zzjj;
        this.g = zzjn;
        this.j = zzang;
        this.k = z;
        this.p = z2;
        this.l = zzpl;
        this.m = list;
        this.n = list2;
        this.o = list3;
        this.q = z3;
    }

    @VisibleForTesting
    private static zzxq a(MediationAdapter mediationAdapter) {
        return new avm(mediationAdapter);
    }

    @GuardedBy("mLock")
    private final String a(String str) {
        if (str == null || !e() || a(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            kk.e("Could not remove field. Returning the original value");
            return str;
        }
    }

    @GuardedBy("mLock")
    private final void a(auk auk) {
        String a = a(this.e.k);
        try {
            if (this.j.c < 4100000) {
                if (this.g.d) {
                    this.r.zza(c.a(this.h), this.f, a, auk);
                } else {
                    this.r.zza(c.a(this.h), this.g, this.f, a, (zzxt) auk);
                }
            } else if (this.k || this.e.b()) {
                List arrayList = new ArrayList(this.m);
                if (this.n != null) {
                    for (String str : this.n) {
                        String str2 = ":false";
                        if (this.o != null && this.o.contains(str)) {
                            str2 = ":true";
                        }
                        arrayList.add(new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("custom:").append(str).append(str2).toString());
                    }
                }
                this.r.zza(c.a(this.h), this.f, a, this.e.a, auk, this.l, arrayList);
            } else if (this.g.d) {
                this.r.zza(c.a(this.h), this.f, a, this.e.a, (zzxt) auk);
            } else if (!this.p) {
                this.r.zza(c.a(this.h), this.g, this.f, a, this.e.a, auk);
            } else if (this.e.o != null) {
                this.r.zza(c.a(this.h), this.f, a, this.e.a, auk, new zzpl(b(this.e.s)), this.e.r);
            } else {
                this.r.zza(c.a(this.h), this.g, this.f, a, this.e.a, auk);
            }
        } catch (Throwable e) {
            kk.c("Could not request ad from mediation adapter.", e);
            zzx(5);
        }
    }

    @GuardedBy("mLock")
    private final boolean a(int i) {
        try {
            Bundle zzmr = this.k ? this.r.zzmr() : this.g.d ? this.r.getInterstitialAdapterInfo() : this.r.zzmq();
            return zzmr != null && (zzmr.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            kk.e("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static NativeAdOptions b(String str) {
        int i = 0;
        d dVar = new d();
        if (str == null) {
            return dVar.a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.b(jSONObject.optBoolean("multiple_images", false));
            dVar.a(jSONObject.optBoolean("only_urls", false));
            String optString = jSONObject.optString("native_image_orientation", "any");
            if (Ad.ORIENTATION_LANDSCAPE.equals(optString)) {
                i = 2;
            } else if (Ad.ORIENTATION_PORTRAIT.equals(optString)) {
                i = 1;
            } else if (!"any".equals(optString)) {
                i = -1;
            }
            dVar.a(i);
        } catch (Throwable e) {
            kk.c("Exception occurred when creating native ad options", e);
        }
        return dVar.a();
    }

    private final String b() {
        try {
            if (!TextUtils.isEmpty(this.e.e)) {
                return this.b.zzbn(this.e.e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            kk.e("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    @GuardedBy("mLock")
    private final zzxw c() {
        if (this.s != 0 || !e()) {
            return null;
        }
        try {
            if (!(!a(4) || this.t == null || this.t.zzmm() == 0)) {
                return this.t;
            }
        } catch (RemoteException e) {
            kk.e("Could not get cpm value from MediationResponseMetadata");
        }
        return new aun(f());
    }

    @GuardedBy("mLock")
    private final zzxq d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.a);
        kk.d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!(this.k || this.e.b())) {
            if (((Boolean) akc.f().a(amn.bw)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.a)) {
                return a(new AdMobAdapter());
            }
            if (((Boolean) akc.f().a(amn.bx)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.a)) {
                return a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.a)) {
                return new avm(new zzzv());
            }
        }
        try {
            return this.b.zzbm(this.a);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Could not instantiate mediation adapter: ";
            valueOf = String.valueOf(this.a);
            kk.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    private final boolean e() {
        return this.d.m != -1;
    }

    @GuardedBy("mLock")
    private final int f() {
        if (this.e.k == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.e.k);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = a(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            kk.e("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public final auo a(long j, long j2) {
        auo auo;
        synchronized (this.i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            auk auk = new auk();
            ht.a.post(new aum(this, auk));
            long j3 = this.c;
            while (this.s == -2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (elapsedRealtime2 - elapsedRealtime);
                elapsedRealtime2 = j2 - (elapsedRealtime2 - j);
                if (j4 <= 0 || elapsedRealtime2 <= 0) {
                    kk.d("Timed out waiting for adapter.");
                    this.s = 3;
                } else {
                    try {
                        this.i.wait(Math.min(j4, elapsedRealtime2));
                    } catch (InterruptedException e) {
                        this.s = 5;
                    }
                }
            }
            auo = new auo(this.e, this.r, this.a, auk, this.s, c(), au.l().elapsedRealtime() - elapsedRealtime);
        }
        return auo;
    }

    public final void a() {
        synchronized (this.i) {
            try {
                if (this.r != null) {
                    this.r.destroy();
                }
            } catch (Throwable e) {
                kk.c("Could not destroy mediation adapter.", e);
            }
            this.s = -1;
            this.i.notify();
        }
    }

    public final void zza(int i, zzxw zzxw) {
        synchronized (this.i) {
            this.s = 0;
            this.t = zzxw;
            this.i.notify();
        }
    }

    public final void zzx(int i) {
        synchronized (this.i) {
            this.s = i;
            this.i.notify();
        }
    }
}
