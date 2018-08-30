package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class afh implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final aff a;
    private final Object b = new Object();
    private final WeakReference<gr> c;
    private WeakReference<ViewTreeObserver> d;
    private final zzgd e;
    private final Context f;
    private final WindowManager g;
    private final PowerManager h;
    private final KeyguardManager i;
    private final DisplayMetrics j;
    @Nullable
    private zzfa k;
    private boolean l;
    private boolean m = false;
    private boolean n = false;
    private boolean o;
    private boolean p;
    private boolean q;
    @Nullable
    @VisibleForTesting
    private BroadcastReceiver r;
    private final HashSet<zzeq> s = new HashSet();
    private jq t;
    private final HashSet<zzfo> u = new HashSet();
    private final Rect v = new Rect();
    private final afk w;
    private float x;

    public afh(Context context, zzjn zzjn, gr grVar, zzang zzang, zzgd zzgd) {
        this.c = new WeakReference(grVar);
        this.e = zzgd;
        this.d = new WeakReference(null);
        this.o = true;
        this.q = false;
        this.t = new jq(200);
        this.a = new aff(UUID.randomUUID().toString(), zzang, zzjn.a, grVar.k, grVar.a(), zzjn.h);
        this.g = (WindowManager) context.getSystemService("window");
        this.h = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.i = (KeyguardManager) context.getSystemService("keyguard");
        this.f = context;
        this.w = new afk(this, new Handler());
        this.f.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.w);
        this.j = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.g.getDefaultDisplay();
        this.v.right = defaultDisplay.getWidth();
        this.v.bottom = defaultDisplay.getHeight();
        a();
    }

    private static int a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    private final JSONObject a(@Nullable View view, @Nullable Boolean bool) {
        if (view == null) {
            return i().put("isAttachedToWindow", false).put("isScreenOn", j()).put("isVisible", false);
        }
        boolean a = au.g().a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            kk.b("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject i = i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", a(this.v.top, this.j)).put("bottom", a(this.v.bottom, this.j)).put("left", a(this.v.left, this.j)).put("right", a(this.v.right, this.j))).put("adBox", new JSONObject().put("top", a(rect.top, this.j)).put("bottom", a(rect.bottom, this.j)).put("left", a(rect.left, this.j)).put("right", a(rect.right, this.j))).put("globalVisibleBox", new JSONObject().put("top", a(rect2.top, this.j)).put("bottom", a(rect2.bottom, this.j)).put("left", a(rect2.left, this.j)).put("right", a(rect2.right, this.j))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", a(rect3.top, this.j)).put("bottom", a(rect3.bottom, this.j)).put("left", a(rect3.left, this.j)).put("right", a(rect3.right, this.j))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", a(rect4.top, this.j)).put("bottom", a(rect4.bottom, this.j)).put("left", a(rect4.left, this.j)).put("right", a(rect4.right, this.j))).put("screenDensity", (double) this.j.density);
        if (bool == null) {
            bool = Boolean.valueOf(au.e().a(view, this.h, this.i));
        }
        i.put("isVisible", bool.booleanValue());
        return i;
    }

    private static JSONObject a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void a(JSONObject jSONObject, boolean z) {
        try {
            JSONObject a = a(jSONObject);
            ArrayList arrayList = new ArrayList(this.u);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzfo) obj).zzb(a, z);
            }
        } catch (Throwable th) {
            kk.b("Skipping active view message.", th);
        }
    }

    private final void g() {
        if (this.k != null) {
            this.k.zza(this);
        }
    }

    private final void h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.d.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    private final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.a.b()).put("activeViewJSON", this.a.c()).put("timestamp", au.l().elapsedRealtime()).put("adFormat", this.a.a()).put("hashCode", this.a.d()).put("isMraid", this.a.e()).put("isStopped", this.n).put("isPaused", this.m).put("isNative", this.a.f()).put("isScreenOn", j()).put("appMuted", au.D().b()).put("appVolume", (double) au.D().a()).put("deviceVolume", (double) this.x);
        return jSONObject;
    }

    @VisibleForTesting
    private final boolean j() {
        return VERSION.SDK_INT >= 20 ? this.h.isInteractive() : this.h.isScreenOn();
    }

    public final void a() {
        this.x = il.a(this.f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A:{Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A:{Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }} */
    /* JADX WARNING: Missing block: B:66:?, code:
            return;
     */
    protected final void a(int r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r4 = r7.b;
        monitor-enter(r4);
        r0 = r7.u;	 Catch:{ all -> 0x005d }
        r3 = r0.iterator();	 Catch:{ all -> 0x005d }
    L_0x000b:
        r0 = r3.hasNext();	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x0026;
    L_0x0011:
        r0 = r3.next();	 Catch:{ all -> 0x005d }
        r0 = (com.google.android.gms.internal.ads.zzfo) r0;	 Catch:{ all -> 0x005d }
        r0 = r0.zzgk();	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x000b;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r0 = r7.o;	 Catch:{ all -> 0x005d }
        if (r0 != 0) goto L_0x0028;
    L_0x0024:
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
    L_0x0025:
        return;
    L_0x0026:
        r0 = r2;
        goto L_0x001e;
    L_0x0028:
        r0 = r7.e;	 Catch:{ all -> 0x005d }
        r5 = r0.zzgh();	 Catch:{ all -> 0x005d }
        if (r5 == 0) goto L_0x0060;
    L_0x0030:
        r0 = com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x005d }
        r3 = r7.h;	 Catch:{ all -> 0x005d }
        r6 = r7.i;	 Catch:{ all -> 0x005d }
        r0 = r0.a(r5, r3, r6);	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x0060;
    L_0x003e:
        r3 = r1;
    L_0x003f:
        if (r5 == 0) goto L_0x0062;
    L_0x0041:
        if (r3 == 0) goto L_0x0062;
    L_0x0043:
        r0 = new android.graphics.Rect;	 Catch:{ all -> 0x005d }
        r0.<init>();	 Catch:{ all -> 0x005d }
        r6 = 0;
        r0 = r5.getGlobalVisibleRect(r0, r6);	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x0062;
    L_0x004f:
        r0 = r1;
    L_0x0050:
        r2 = r7.e;	 Catch:{ all -> 0x005d }
        r2 = r2.zzgi();	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x0064;
    L_0x0058:
        r7.b();	 Catch:{ all -> 0x005d }
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
        goto L_0x0025;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
        throw r0;
    L_0x0060:
        r3 = r2;
        goto L_0x003f;
    L_0x0062:
        r0 = r2;
        goto L_0x0050;
    L_0x0064:
        if (r8 != r1) goto L_0x0074;
    L_0x0066:
        r2 = r7.t;	 Catch:{ all -> 0x005d }
        r2 = r2.a();	 Catch:{ all -> 0x005d }
        if (r2 != 0) goto L_0x0074;
    L_0x006e:
        r2 = r7.q;	 Catch:{ all -> 0x005d }
        if (r0 != r2) goto L_0x0074;
    L_0x0072:
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
        goto L_0x0025;
    L_0x0074:
        if (r0 != 0) goto L_0x007e;
    L_0x0076:
        r2 = r7.q;	 Catch:{ all -> 0x005d }
        if (r2 != 0) goto L_0x007e;
    L_0x007a:
        if (r8 != r1) goto L_0x007e;
    L_0x007c:
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
        goto L_0x0025;
    L_0x007e:
        r1 = java.lang.Boolean.valueOf(r3);	 Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
        r1 = r7.a(r5, r1);	 Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
        r2 = 0;
        r7.a(r1, r2);	 Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
        r7.q = r0;	 Catch:{ JSONException -> 0x00d2, RuntimeException -> 0x00cb }
    L_0x008c:
        r0 = r7.e;	 Catch:{ all -> 0x005d }
        r0 = r0.zzgj();	 Catch:{ all -> 0x005d }
        r1 = r0.zzgh();	 Catch:{ all -> 0x005d }
        if (r1 == 0) goto L_0x00c5;
    L_0x0098:
        r0 = r7.d;	 Catch:{ all -> 0x005d }
        r0 = r0.get();	 Catch:{ all -> 0x005d }
        r0 = (android.view.ViewTreeObserver) r0;	 Catch:{ all -> 0x005d }
        r1 = r1.getViewTreeObserver();	 Catch:{ all -> 0x005d }
        if (r1 == r0) goto L_0x00c5;
    L_0x00a6:
        r7.h();	 Catch:{ all -> 0x005d }
        r2 = r7.l;	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x00b5;
    L_0x00ad:
        if (r0 == 0) goto L_0x00be;
    L_0x00af:
        r0 = r0.isAlive();	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x00be;
    L_0x00b5:
        r0 = 1;
        r7.l = r0;	 Catch:{ all -> 0x005d }
        r1.addOnScrollChangedListener(r7);	 Catch:{ all -> 0x005d }
        r1.addOnGlobalLayoutListener(r7);	 Catch:{ all -> 0x005d }
    L_0x00be:
        r0 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x005d }
        r0.<init>(r1);	 Catch:{ all -> 0x005d }
        r7.d = r0;	 Catch:{ all -> 0x005d }
    L_0x00c5:
        r7.g();	 Catch:{ all -> 0x005d }
        monitor-exit(r4);	 Catch:{ all -> 0x005d }
        goto L_0x0025;
    L_0x00cb:
        r0 = move-exception;
    L_0x00cc:
        r1 = "Active view update failed.";
        com.google.android.gms.internal.ads.kk.a(r1, r0);	 Catch:{ all -> 0x005d }
        goto L_0x008c;
    L_0x00d2:
        r0 = move-exception;
        goto L_0x00cc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afh.a(int):void");
    }

    public final void a(zzfa zzfa) {
        synchronized (this.b) {
            this.k = zzfa;
        }
    }

    public final void a(zzfo zzfo) {
        if (this.u.isEmpty()) {
            synchronized (this.b) {
                if (this.r != null) {
                } else {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.r = new afi(this);
                    au.E().a(this.f, this.r, intentFilter);
                }
            }
            a(3);
        }
        this.u.add(zzfo);
        try {
            zzfo.zzb(a(a(this.e.zzgh(), null)), false);
        } catch (Throwable e) {
            kk.b("Skipping measurement update for new client.", e);
        }
    }

    final void a(zzfo zzfo, Map<String, String> map) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.a.d());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        b(zzfo);
    }

    final boolean a(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.a.d());
    }

    public final void b() {
        synchronized (this.b) {
            if (this.o) {
                this.p = true;
                try {
                    JSONObject i = i();
                    i.put("doneReasonCode", "u");
                    a(i, true);
                } catch (Throwable e) {
                    kk.b("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    kk.b("Failure while processing active view data.", e2);
                }
                String str = "Untracking ad unit: ";
                String valueOf = String.valueOf(this.a.d());
                kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    public final void b(zzfo zzfo) {
        this.u.remove(zzfo);
        zzfo.zzgl();
        if (this.u.isEmpty()) {
            synchronized (this.b) {
                h();
                synchronized (this.b) {
                    if (this.r != null) {
                        try {
                            au.E().a(this.f, this.r);
                        } catch (Throwable e) {
                            kk.b("Failed trying to unregister the receiver", e);
                        } catch (Throwable e2) {
                            au.i().a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.r = null;
                    }
                }
                this.f.getContentResolver().unregisterContentObserver(this.w);
                this.o = false;
                g();
                ArrayList arrayList = new ArrayList(this.u);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    b((zzfo) obj);
                }
            }
            return;
        }
        return;
    }

    final void b(Map<String, String> map) {
        a(3);
    }

    final void c(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            Iterator it = this.s.iterator();
            while (it.hasNext()) {
                ((zzeq) it.next()).zza(this, z);
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.b) {
            z = this.o;
        }
        return z;
    }

    public final void d() {
        synchronized (this.b) {
            this.n = true;
            a(3);
        }
    }

    public final void e() {
        synchronized (this.b) {
            this.m = true;
            a(3);
        }
    }

    public final void f() {
        synchronized (this.b) {
            this.m = false;
            a(3);
        }
    }

    public final void onGlobalLayout() {
        a(2);
    }

    public final void onScrollChanged() {
        a(1);
    }
}
