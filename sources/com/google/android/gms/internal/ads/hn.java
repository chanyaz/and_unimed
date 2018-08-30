package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.common.util.p;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzadh
public final class hn {
    @GuardedBy("mLock")
    @Nullable
    Editor a;
    private final Object b = new Object();
    private zzanz<?> c;
    private CopyOnWriteArraySet<zzakh> d = new CopyOnWriteArraySet();
    @GuardedBy("mLock")
    @Nullable
    private SharedPreferences e;
    @GuardedBy("mLock")
    private boolean f = false;
    @GuardedBy("mLock")
    private boolean g = true;
    @GuardedBy("mLock")
    @Nullable
    private String h;
    @GuardedBy("mLock")
    @Nullable
    private String i;
    @GuardedBy("mLock")
    private boolean j = false;
    @GuardedBy("mLock")
    private String k = "";
    @GuardedBy("mLock")
    private long l = 0;
    @GuardedBy("mLock")
    private long m = 0;
    @GuardedBy("mLock")
    private long n = 0;
    @GuardedBy("mLock")
    private int o = -1;
    @GuardedBy("mLock")
    private int p = 0;
    @GuardedBy("mLock")
    private Set<String> q = Collections.emptySet();
    @GuardedBy("mLock")
    private JSONObject r = new JSONObject();
    @GuardedBy("mLock")
    private boolean s = true;
    @GuardedBy("mLock")
    private boolean t = true;

    private final void a(Bundle bundle) {
        new hp(this, bundle).zznt();
    }

    @TargetApi(23)
    private static boolean n() {
        return p.j() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    private final void o() {
        Throwable e;
        if (this.c != null && !this.c.isDone()) {
            try {
                this.c.get(1, TimeUnit.SECONDS);
            } catch (Throwable e2) {
                Thread.currentThread().interrupt();
                kk.c("Interrupted while waiting for preferences loaded.", e2);
            } catch (CancellationException e3) {
                e2 = e3;
                kk.b("Fail to initialize AdSharedPreferenceManager.", e2);
            } catch (ExecutionException e4) {
                e2 = e4;
                kk.b("Fail to initialize AdSharedPreferenceManager.", e2);
            } catch (TimeoutException e5) {
                e2 = e5;
                kk.b("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle p() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.b) {
            bundle.putBoolean("use_https", this.g);
            bundle.putBoolean("content_url_opted_out", this.s);
            bundle.putBoolean("content_vertical_opted_out", this.t);
            bundle.putBoolean("auto_collect_location", this.j);
            bundle.putInt("version_code", this.p);
            bundle.putStringArray("never_pool_slots", (String[]) this.q.toArray(new String[this.q.size()]));
            bundle.putString("app_settings_json", this.k);
            bundle.putLong("app_settings_last_update_ms", this.l);
            bundle.putLong("app_last_background_time_ms", this.m);
            bundle.putInt("request_in_session_count", this.o);
            bundle.putLong("first_ad_req_time_ms", this.n);
            bundle.putString("native_advanced_settings", this.r.toString());
            if (this.h != null) {
                bundle.putString("content_url_hashes", this.h);
            }
            if (this.i != null) {
                bundle.putString("content_vertical_hashes", this.i);
            }
        }
        return bundle;
    }

    public final void a(int i) {
        o();
        synchronized (this.b) {
            if (this.p == i) {
                return;
            }
            this.p = i;
            if (this.a != null) {
                this.a.putInt("version_code", i);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            a(bundle);
        }
    }

    public final void a(long j) {
        o();
        synchronized (this.b) {
            if (this.m == j) {
                return;
            }
            this.m = j;
            if (this.a != null) {
                this.a.putLong("app_last_background_time_ms", j);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            a(bundle);
        }
    }

    public final void a(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = (zzanz) new ho(this, context).zznt();
    }

    public final void a(zzakh zzakh) {
        synchronized (this.b) {
            if (this.c != null && this.c.isDone()) {
                zzakh.zzd(p());
            }
            this.d.add(zzakh);
        }
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return;
     */
    public final void a(@javax.annotation.Nullable java.lang.String r4) {
        /*
        r3 = this;
        r3.o();
        r1 = r3.b;
        monitor-enter(r1);
        if (r4 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r3.h;	 Catch:{ all -> 0x0033 }
        r0 = r4.equals(r0);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
    L_0x0011:
        return;
    L_0x0012:
        r3.h = r4;	 Catch:{ all -> 0x0033 }
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0024;
    L_0x0018:
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        r2 = "content_url_hashes";
        r0.putString(r2, r4);	 Catch:{ all -> 0x0033 }
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        r0.apply();	 Catch:{ all -> 0x0033 }
    L_0x0024:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x0033 }
        r0.<init>();	 Catch:{ all -> 0x0033 }
        r2 = "content_url_hashes";
        r0.putString(r2, r4);	 Catch:{ all -> 0x0033 }
        r3.a(r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        goto L_0x0011;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hn.a(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A:{Catch:{ JSONException -> 0x0097 }} */
    public final void a(java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
        r8 = this;
        r0 = 0;
        r8.o();
        r3 = r8.b;
        monitor-enter(r3);
        r1 = r8.r;	 Catch:{ all -> 0x0041 }
        r1 = r1.optJSONArray(r9);	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x009e;
    L_0x000f:
        r1 = new org.json.JSONArray;	 Catch:{ all -> 0x0041 }
        r1.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r1;
    L_0x0015:
        r1 = r2.length();	 Catch:{ all -> 0x0041 }
    L_0x0019:
        r4 = r2.length();	 Catch:{ all -> 0x0041 }
        if (r0 >= r4) goto L_0x0047;
    L_0x001f:
        r4 = r2.optJSONObject(r0);	 Catch:{ all -> 0x0041 }
        if (r4 != 0) goto L_0x0027;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
    L_0x0026:
        return;
    L_0x0027:
        r5 = "template_id";
        r5 = r4.optString(r5);	 Catch:{ all -> 0x0041 }
        r5 = r10.equals(r5);	 Catch:{ all -> 0x0041 }
        if (r5 == 0) goto L_0x0044;
    L_0x0033:
        r1 = 1;
        if (r11 != r1) goto L_0x0048;
    L_0x0036:
        r1 = "uses_media_view";
        r5 = 0;
        r1 = r4.optBoolean(r1, r5);	 Catch:{ all -> 0x0041 }
        if (r1 != r11) goto L_0x0048;
    L_0x003f:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0026;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x0044:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0047:
        r0 = r1;
    L_0x0048:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0097 }
        r1.<init>();	 Catch:{ JSONException -> 0x0097 }
        r4 = "template_id";
        r1.put(r4, r10);	 Catch:{ JSONException -> 0x0097 }
        r4 = "uses_media_view";
        r1.put(r4, r11);	 Catch:{ JSONException -> 0x0097 }
        r4 = "timestamp_ms";
        r5 = com.google.android.gms.ads.internal.au.l();	 Catch:{ JSONException -> 0x0097 }
        r6 = r5.currentTimeMillis();	 Catch:{ JSONException -> 0x0097 }
        r1.put(r4, r6);	 Catch:{ JSONException -> 0x0097 }
        r2.put(r0, r1);	 Catch:{ JSONException -> 0x0097 }
        r0 = r8.r;	 Catch:{ JSONException -> 0x0097 }
        r0.put(r9, r2);	 Catch:{ JSONException -> 0x0097 }
    L_0x006c:
        r0 = r8.a;	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x0082;
    L_0x0070:
        r0 = r8.a;	 Catch:{ all -> 0x0041 }
        r1 = "native_advanced_settings";
        r2 = r8.r;	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r0.putString(r1, r2);	 Catch:{ all -> 0x0041 }
        r0 = r8.a;	 Catch:{ all -> 0x0041 }
        r0.apply();	 Catch:{ all -> 0x0041 }
    L_0x0082:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x0041 }
        r0.<init>();	 Catch:{ all -> 0x0041 }
        r1 = "native_advanced_settings";
        r2 = r8.r;	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r0.putString(r1, r2);	 Catch:{ all -> 0x0041 }
        r8.a(r0);	 Catch:{ all -> 0x0041 }
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0026;
    L_0x0097:
        r0 = move-exception;
        r1 = "Could not update native advanced settings";
        com.google.android.gms.internal.ads.kk.c(r1, r0);	 Catch:{ all -> 0x0041 }
        goto L_0x006c;
    L_0x009e:
        r2 = r1;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hn.a(java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            return;
     */
    public final void a(boolean r4) {
        /*
        r3 = this;
        r3.o();
        r1 = r3.b;
        monitor-enter(r1);
        r0 = r3.g;	 Catch:{ all -> 0x0031 }
        if (r0 != r4) goto L_0x000c;
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
    L_0x000b:
        return;
    L_0x000c:
        r3.g = r4;	 Catch:{ all -> 0x0031 }
        r0 = r3.a;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r3.a;	 Catch:{ all -> 0x0031 }
        r2 = "use_https";
        r0.putBoolean(r2, r4);	 Catch:{ all -> 0x0031 }
        r0 = r3.a;	 Catch:{ all -> 0x0031 }
        r0.apply();	 Catch:{ all -> 0x0031 }
    L_0x001e:
        r0 = r3.f;	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x002f;
    L_0x0022:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x0031 }
        r0.<init>();	 Catch:{ all -> 0x0031 }
        r2 = "use_https";
        r0.putBoolean(r2, r4);	 Catch:{ all -> 0x0031 }
        r3.a(r0);	 Catch:{ all -> 0x0031 }
    L_0x002f:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        goto L_0x000b;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hn.a(boolean):void");
    }

    public final boolean a() {
        boolean z;
        o();
        synchronized (this.b) {
            z = this.g || this.f;
        }
        return z;
    }

    public final void b(int i) {
        o();
        synchronized (this.b) {
            if (this.o == i) {
                return;
            }
            this.o = i;
            if (this.a != null) {
                this.a.putInt("request_in_session_count", i);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            a(bundle);
        }
    }

    public final void b(long j) {
        o();
        synchronized (this.b) {
            if (this.n == j) {
                return;
            }
            this.n = j;
            if (this.a != null) {
                this.a.putLong("first_ad_req_time_ms", j);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            a(bundle);
        }
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return;
     */
    public final void b(@javax.annotation.Nullable java.lang.String r4) {
        /*
        r3 = this;
        r3.o();
        r1 = r3.b;
        monitor-enter(r1);
        if (r4 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r3.i;	 Catch:{ all -> 0x0033 }
        r0 = r4.equals(r0);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
    L_0x0011:
        return;
    L_0x0012:
        r3.i = r4;	 Catch:{ all -> 0x0033 }
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0024;
    L_0x0018:
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        r2 = "content_vertical_hashes";
        r0.putString(r2, r4);	 Catch:{ all -> 0x0033 }
        r0 = r3.a;	 Catch:{ all -> 0x0033 }
        r0.apply();	 Catch:{ all -> 0x0033 }
    L_0x0024:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x0033 }
        r0.<init>();	 Catch:{ all -> 0x0033 }
        r2 = "content_vertical_hashes";
        r0.putString(r2, r4);	 Catch:{ all -> 0x0033 }
        r3.a(r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        goto L_0x0011;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hn.b(java.lang.String):void");
    }

    public final void b(boolean z) {
        o();
        synchronized (this.b) {
            if (this.s == z) {
                return;
            }
            this.s = z;
            if (this.a != null) {
                this.a.putBoolean("content_url_opted_out", z);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.s);
            bundle.putBoolean("content_vertical_opted_out", this.t);
            a(bundle);
        }
    }

    public final boolean b() {
        boolean z;
        o();
        synchronized (this.b) {
            z = this.s;
        }
        return z;
    }

    @Nullable
    public final String c() {
        String str;
        o();
        synchronized (this.b) {
            str = this.h;
        }
        return str;
    }

    public final void c(String str) {
        o();
        synchronized (this.b) {
            if (this.q.contains(str)) {
                return;
            }
            this.q.add(str);
            if (this.a != null) {
                this.a.putStringSet("never_pool_slots", this.q);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("never_pool_slots", (String[]) this.q.toArray(new String[this.q.size()]));
            a(bundle);
        }
    }

    public final void c(boolean z) {
        o();
        synchronized (this.b) {
            if (this.t == z) {
                return;
            }
            this.t = z;
            if (this.a != null) {
                this.a.putBoolean("content_vertical_opted_out", z);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.s);
            bundle.putBoolean("content_vertical_opted_out", this.t);
            a(bundle);
        }
    }

    public final void d(String str) {
        o();
        synchronized (this.b) {
            if (this.q.contains(str)) {
                this.q.remove(str);
                if (this.a != null) {
                    this.a.putStringSet("never_pool_slots", this.q);
                    this.a.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("never_pool_slots", (String[]) this.q.toArray(new String[this.q.size()]));
                a(bundle);
                return;
            }
        }
    }

    public final void d(boolean z) {
        o();
        synchronized (this.b) {
            if (this.j == z) {
                return;
            }
            this.j = z;
            if (this.a != null) {
                this.a.putBoolean("auto_collect_location", z);
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            a(bundle);
        }
    }

    public final boolean d() {
        boolean z;
        o();
        synchronized (this.b) {
            z = this.t;
        }
        return z;
    }

    @Nullable
    public final String e() {
        String str;
        o();
        synchronized (this.b) {
            str = this.i;
        }
        return str;
    }

    public final boolean e(String str) {
        boolean contains;
        o();
        synchronized (this.b) {
            contains = this.q.contains(str);
        }
        return contains;
    }

    /* JADX WARNING: Missing block: B:16:?, code:
            return;
     */
    public final void f(java.lang.String r6) {
        /*
        r5 = this;
        r5.o();
        r1 = r5.b;
        monitor-enter(r1);
        r0 = com.google.android.gms.ads.internal.au.l();	 Catch:{ all -> 0x0049 }
        r2 = r0.currentTimeMillis();	 Catch:{ all -> 0x0049 }
        r5.l = r2;	 Catch:{ all -> 0x0049 }
        if (r6 == 0) goto L_0x001a;
    L_0x0012:
        r0 = r5.k;	 Catch:{ all -> 0x0049 }
        r0 = r6.equals(r0);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r1);	 Catch:{ all -> 0x0049 }
    L_0x001b:
        return;
    L_0x001c:
        r5.k = r6;	 Catch:{ all -> 0x0049 }
        r0 = r5.a;	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0035;
    L_0x0022:
        r0 = r5.a;	 Catch:{ all -> 0x0049 }
        r4 = "app_settings_json";
        r0.putString(r4, r6);	 Catch:{ all -> 0x0049 }
        r0 = r5.a;	 Catch:{ all -> 0x0049 }
        r4 = "app_settings_last_update_ms";
        r0.putLong(r4, r2);	 Catch:{ all -> 0x0049 }
        r0 = r5.a;	 Catch:{ all -> 0x0049 }
        r0.apply();	 Catch:{ all -> 0x0049 }
    L_0x0035:
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x0049 }
        r0.<init>();	 Catch:{ all -> 0x0049 }
        r4 = "app_settings_json";
        r0.putString(r4, r6);	 Catch:{ all -> 0x0049 }
        r4 = "app_settings_last_update_ms";
        r0.putLong(r4, r2);	 Catch:{ all -> 0x0049 }
        r5.a(r0);	 Catch:{ all -> 0x0049 }
        monitor-exit(r1);	 Catch:{ all -> 0x0049 }
        goto L_0x001b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0049 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hn.f(java.lang.String):void");
    }

    public final boolean f() {
        boolean z;
        o();
        synchronized (this.b) {
            z = this.j;
        }
        return z;
    }

    public final int g() {
        int i;
        o();
        synchronized (this.b) {
            i = this.p;
        }
        return i;
    }

    public final gv h() {
        gv gvVar;
        o();
        synchronized (this.b) {
            gvVar = new gv(this.k, this.l);
        }
        return gvVar;
    }

    public final long i() {
        long j;
        o();
        synchronized (this.b) {
            j = this.m;
        }
        return j;
    }

    public final int j() {
        int i;
        o();
        synchronized (this.b) {
            i = this.o;
        }
        return i;
    }

    public final long k() {
        long j;
        o();
        synchronized (this.b) {
            j = this.n;
        }
        return j;
    }

    public final JSONObject l() {
        JSONObject jSONObject;
        o();
        synchronized (this.b) {
            jSONObject = this.r;
        }
        return jSONObject;
    }

    public final void m() {
        o();
        synchronized (this.b) {
            this.r = new JSONObject();
            if (this.a != null) {
                this.a.remove("native_advanced_settings");
                this.a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            a(bundle);
        }
    }
}
