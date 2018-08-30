package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.hz;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.l;
import com.google.android.gms.internal.ads.o;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaqw;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.Collections;

@zzadh
public class c extends o implements zzw {
    @VisibleForTesting
    private static final int e = Color.argb(0, 0, 0, 0);
    protected final Activity a;
    @VisibleForTesting
    AdOverlayInfoParcel b;
    @VisibleForTesting
    zzaqw c;
    @VisibleForTesting
    int d = 0;
    @VisibleForTesting
    private h f;
    @VisibleForTesting
    private m g;
    @VisibleForTesting
    private boolean h = false;
    @VisibleForTesting
    private FrameLayout i;
    @VisibleForTesting
    private CustomViewCallback j;
    @VisibleForTesting
    private boolean k = false;
    @VisibleForTesting
    private boolean l = false;
    @VisibleForTesting
    private g m;
    @VisibleForTesting
    private boolean n = false;
    private final Object o = new Object();
    private Runnable p;
    private boolean q;
    private boolean r;
    private boolean s = false;
    private boolean t = false;
    private boolean u = true;

    public c(Activity activity) {
        this.a = activity;
    }

    private final void a(boolean z) {
        int intValue = ((Integer) akc.f().a(amn.da)).intValue();
        n nVar = new n();
        nVar.e = 50;
        nVar.a = z ? intValue : 0;
        nVar.b = z ? 0 : intValue;
        nVar.c = 0;
        nVar.d = intValue;
        this.g = new m(this.a, nVar, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        a(z, this.b.g);
        this.m.addView(this.g, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0143 A:{SYNTHETIC, Splitter: B:51:0x0143} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0266  */
    private final void b(boolean r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r0.r;
        if (r1 != 0) goto L_0x000e;
    L_0x0006:
        r0 = r17;
        r1 = r0.a;
        r2 = 1;
        r1.requestWindowFeature(r2);
    L_0x000e:
        r0 = r17;
        r1 = r0.a;
        r3 = r1.getWindow();
        if (r3 != 0) goto L_0x0020;
    L_0x0018:
        r1 = new com.google.android.gms.ads.internal.overlay.f;
        r2 = "Invalid activity, no window available.";
        r1.<init>(r2);
        throw r1;
    L_0x0020:
        r2 = 1;
        r1 = com.google.android.gms.common.util.p.k();
        if (r1 == 0) goto L_0x0309;
    L_0x0027:
        r1 = com.google.android.gms.internal.ads.amn.cY;
        r4 = com.google.android.gms.internal.ads.akc.f();
        r1 = r4.a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0309;
    L_0x0039:
        com.google.android.gms.ads.internal.au.e();
        r0 = r17;
        r1 = r0.a;
        r0 = r17;
        r2 = r0.a;
        r2 = r2.getResources();
        r2 = r2.getConfiguration();
        r1 = com.google.android.gms.internal.ads.ht.a(r1, r2);
    L_0x0050:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.o;
        if (r2 == 0) goto L_0x026d;
    L_0x0058:
        r0 = r17;
        r2 = r0.b;
        r2 = r2.o;
        r2 = r2.b;
        if (r2 == 0) goto L_0x026d;
    L_0x0062:
        r2 = 1;
    L_0x0063:
        r0 = r17;
        r4 = r0.l;
        if (r4 == 0) goto L_0x006b;
    L_0x0069:
        if (r2 == 0) goto L_0x00a7;
    L_0x006b:
        if (r1 == 0) goto L_0x00a7;
    L_0x006d:
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.setFlags(r1, r2);
        r1 = com.google.android.gms.internal.ads.amn.aQ;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r1 = r2.a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x00a7;
    L_0x0086:
        r1 = com.google.android.gms.common.util.p.g();
        if (r1 == 0) goto L_0x00a7;
    L_0x008c:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.o;
        if (r1 == 0) goto L_0x00a7;
    L_0x0094:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.o;
        r1 = r1.f;
        if (r1 == 0) goto L_0x00a7;
    L_0x009e:
        r1 = r3.getDecorView();
        r2 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r1.setSystemUiVisibility(r2);
    L_0x00a7:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        if (r1 == 0) goto L_0x0270;
    L_0x00af:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        r1 = r1.zzuf();
    L_0x00b9:
        if (r1 == 0) goto L_0x0273;
    L_0x00bb:
        r5 = r1.zzfz();
    L_0x00bf:
        r1 = 0;
        r0 = r17;
        r0.n = r1;
        if (r5 == 0) goto L_0x00ec;
    L_0x00c6:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.j;
        r2 = com.google.android.gms.ads.internal.au.g();
        r2 = r2.a();
        if (r1 != r2) goto L_0x0279;
    L_0x00d6:
        r0 = r17;
        r1 = r0.a;
        r1 = r1.getResources();
        r1 = r1.getConfiguration();
        r1 = r1.orientation;
        r2 = 1;
        if (r1 != r2) goto L_0x0276;
    L_0x00e7:
        r1 = 1;
    L_0x00e8:
        r0 = r17;
        r0.n = r1;
    L_0x00ec:
        r0 = r17;
        r1 = r0.n;
        r2 = 46;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r2);
        r2 = "Delay onShow to next orientation change: ";
        r2 = r4.append(r2);
        r1 = r2.append(r1);
        r1 = r1.toString();
        com.google.android.gms.internal.ads.kk.b(r1);
        r0 = r17;
        r1 = r0.b;
        r1 = r1.j;
        r0 = r17;
        r0.a(r1);
        r1 = com.google.android.gms.ads.internal.au.g();
        r1 = r1.a(r3);
        if (r1 == 0) goto L_0x0122;
    L_0x011d:
        r1 = "Hardware acceleration on the AdActivity window enabled.";
        com.google.android.gms.internal.ads.kk.b(r1);
    L_0x0122:
        r0 = r17;
        r1 = r0.l;
        if (r1 != 0) goto L_0x02a3;
    L_0x0128:
        r0 = r17;
        r1 = r0.m;
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r1.setBackgroundColor(r2);
    L_0x0131:
        r0 = r17;
        r1 = r0.a;
        r0 = r17;
        r2 = r0.m;
        r1.setContentView(r2);
        r1 = 1;
        r0 = r17;
        r0.r = r1;
        if (r18 == 0) goto L_0x02f2;
    L_0x0143:
        com.google.android.gms.ads.internal.au.f();	 Catch:{ Exception -> 0x02b7 }
        r0 = r17;
        r1 = r0.a;	 Catch:{ Exception -> 0x02b7 }
        r0 = r17;
        r2 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r2 = r2.d;	 Catch:{ Exception -> 0x02b7 }
        if (r2 == 0) goto L_0x02ae;
    L_0x0152:
        r0 = r17;
        r2 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r2 = r2.d;	 Catch:{ Exception -> 0x02b7 }
        r2 = r2.zzud();	 Catch:{ Exception -> 0x02b7 }
    L_0x015c:
        r0 = r17;
        r3 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r3 = r3.d;	 Catch:{ Exception -> 0x02b7 }
        if (r3 == 0) goto L_0x02b1;
    L_0x0164:
        r0 = r17;
        r3 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r3 = r3.d;	 Catch:{ Exception -> 0x02b7 }
        r3 = r3.zzue();	 Catch:{ Exception -> 0x02b7 }
    L_0x016e:
        r4 = 1;
        r6 = 0;
        r0 = r17;
        r7 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r7 = r7.m;	 Catch:{ Exception -> 0x02b7 }
        r8 = 0;
        r9 = 0;
        r0 = r17;
        r10 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r10 = r10.d;	 Catch:{ Exception -> 0x02b7 }
        if (r10 == 0) goto L_0x02b4;
    L_0x0180:
        r0 = r17;
        r10 = r0.b;	 Catch:{ Exception -> 0x02b7 }
        r10 = r10.d;	 Catch:{ Exception -> 0x02b7 }
        r10 = r10.zzbi();	 Catch:{ Exception -> 0x02b7 }
    L_0x018a:
        r11 = com.google.android.gms.internal.ads.ahx.a();	 Catch:{ Exception -> 0x02b7 }
        r1 = com.google.android.gms.internal.ads.nw.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x02b7 }
        r0 = r17;
        r0.c = r1;	 Catch:{ Exception -> 0x02b7 }
        r0 = r17;
        r1 = r0.c;
        r6 = r1.zzuf();
        r7 = 0;
        r0 = r17;
        r1 = r0.b;
        r8 = r1.p;
        r9 = 0;
        r0 = r17;
        r1 = r0.b;
        r10 = r1.e;
        r0 = r17;
        r1 = r0.b;
        r11 = r1.i;
        r12 = 1;
        r13 = 0;
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        if (r1 == 0) goto L_0x02c5;
    L_0x01bc:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        r1 = r1.zzuf();
        r14 = r1.zzut();
    L_0x01ca:
        r15 = 0;
        r16 = 0;
        r6.zza(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r0 = r17;
        r1 = r0.c;
        r1 = r1.zzuf();
        r2 = new com.google.android.gms.ads.internal.overlay.d;
        r0 = r17;
        r2.<init>(r0);
        r1.zza(r2);
        r0 = r17;
        r1 = r0.b;
        r1 = r1.l;
        if (r1 == 0) goto L_0x02c8;
    L_0x01ea:
        r0 = r17;
        r1 = r0.c;
        r0 = r17;
        r2 = r0.b;
        r2 = r2.l;
        r1.loadUrl(r2);
    L_0x01f7:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        if (r1 == 0) goto L_0x020a;
    L_0x01ff:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        r0 = r17;
        r1.zzb(r0);
    L_0x020a:
        r0 = r17;
        r1 = r0.c;
        r0 = r17;
        r1.zza(r0);
        r0 = r17;
        r1 = r0.c;
        r1 = r1.getParent();
        if (r1 == 0) goto L_0x022e;
    L_0x021d:
        r2 = r1 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x022e;
    L_0x0221:
        r1 = (android.view.ViewGroup) r1;
        r0 = r17;
        r2 = r0.c;
        r2 = r2.getView();
        r1.removeView(r2);
    L_0x022e:
        r0 = r17;
        r1 = r0.l;
        if (r1 == 0) goto L_0x023b;
    L_0x0234:
        r0 = r17;
        r1 = r0.c;
        r1.zzur();
    L_0x023b:
        r0 = r17;
        r1 = r0.m;
        r0 = r17;
        r2 = r0.c;
        r2 = r2.getView();
        r3 = -1;
        r4 = -1;
        r1.addView(r2, r3, r4);
        if (r18 != 0) goto L_0x0257;
    L_0x024e:
        r0 = r17;
        r1 = r0.n;
        if (r1 != 0) goto L_0x0257;
    L_0x0254:
        r17.i();
    L_0x0257:
        r0 = r17;
        r0.a(r5);
        r0 = r17;
        r1 = r0.c;
        r1 = r1.zzuh();
        if (r1 == 0) goto L_0x026c;
    L_0x0266:
        r1 = 1;
        r0 = r17;
        r0.a(r5, r1);
    L_0x026c:
        return;
    L_0x026d:
        r2 = 0;
        goto L_0x0063;
    L_0x0270:
        r1 = 0;
        goto L_0x00b9;
    L_0x0273:
        r5 = 0;
        goto L_0x00bf;
    L_0x0276:
        r1 = 0;
        goto L_0x00e8;
    L_0x0279:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.j;
        r2 = com.google.android.gms.ads.internal.au.g();
        r2 = r2.b();
        if (r1 != r2) goto L_0x00ec;
    L_0x0289:
        r0 = r17;
        r1 = r0.a;
        r1 = r1.getResources();
        r1 = r1.getConfiguration();
        r1 = r1.orientation;
        r2 = 2;
        if (r1 != r2) goto L_0x02a1;
    L_0x029a:
        r1 = 1;
    L_0x029b:
        r0 = r17;
        r0.n = r1;
        goto L_0x00ec;
    L_0x02a1:
        r1 = 0;
        goto L_0x029b;
    L_0x02a3:
        r0 = r17;
        r1 = r0.m;
        r2 = e;
        r1.setBackgroundColor(r2);
        goto L_0x0131;
    L_0x02ae:
        r2 = 0;
        goto L_0x015c;
    L_0x02b1:
        r3 = 0;
        goto L_0x016e;
    L_0x02b4:
        r10 = 0;
        goto L_0x018a;
    L_0x02b7:
        r1 = move-exception;
        r2 = "Error obtaining webview.";
        com.google.android.gms.internal.ads.kk.b(r2, r1);
        r1 = new com.google.android.gms.ads.internal.overlay.f;
        r2 = "Could not obtain webview for the overlay.";
        r1.<init>(r2);
        throw r1;
    L_0x02c5:
        r14 = 0;
        goto L_0x01ca;
    L_0x02c8:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.h;
        if (r1 == 0) goto L_0x02ea;
    L_0x02d0:
        r0 = r17;
        r6 = r0.c;
        r0 = r17;
        r1 = r0.b;
        r7 = r1.f;
        r0 = r17;
        r1 = r0.b;
        r8 = r1.h;
        r9 = "text/html";
        r10 = "UTF-8";
        r11 = 0;
        r6.loadDataWithBaseURL(r7, r8, r9, r10, r11);
        goto L_0x01f7;
    L_0x02ea:
        r1 = new com.google.android.gms.ads.internal.overlay.f;
        r2 = "No URL or HTML to display in ad overlay.";
        r1.<init>(r2);
        throw r1;
    L_0x02f2:
        r0 = r17;
        r1 = r0.b;
        r1 = r1.d;
        r0 = r17;
        r0.c = r1;
        r0 = r17;
        r1 = r0.c;
        r0 = r17;
        r2 = r0.a;
        r1.zzbm(r2);
        goto L_0x020a;
    L_0x0309:
        r1 = r2;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.c.b(boolean):void");
    }

    private final void h() {
        if (this.a.isFinishing() && !this.s) {
            this.s = true;
            if (this.c != null) {
                this.c.zzai(this.d);
                synchronized (this.o) {
                    if (!this.q && this.c.zzun()) {
                        this.p = new e(this);
                        ht.a.postDelayed(this.p, ((Long) akc.f().a(amn.aP)).longValue());
                        return;
                    }
                }
            }
            d();
        }
    }

    private final void i() {
        this.c.zzno();
    }

    public final void a() {
        this.d = 2;
        this.a.finish();
    }

    public final void a(int i) {
        if (this.a.getApplicationInfo().targetSdkVersion >= ((Integer) akc.f().a(amn.dn)).intValue()) {
            if (this.a.getApplicationInfo().targetSdkVersion <= ((Integer) akc.f().a(amn.do)).intValue()) {
                if (VERSION.SDK_INT >= ((Integer) akc.f().a(amn.dp)).intValue()) {
                    if (VERSION.SDK_INT <= ((Integer) akc.f().a(amn.dq)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.a.setRequestedOrientation(i);
    }

    public final void a(View view, CustomViewCallback customViewCallback) {
        this.i = new FrameLayout(this.a);
        this.i.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        this.i.addView(view, -1, -1);
        this.a.setContentView(this.i);
        this.r = true;
        this.j = customViewCallback;
        this.h = true;
    }

    public final void a(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = ((Boolean) akc.f().a(amn.aR)).booleanValue() && this.b != null && this.b.o != null && this.b.o.g;
        boolean z5 = ((Boolean) akc.f().a(amn.aS)).booleanValue() && this.b != null && this.b.o != null && this.b.o.h;
        if (z && z2 && z4 && !z5) {
            new l(this.c, "useCustomClose").a("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.g != null) {
            m mVar = this.g;
            if (z5 || (z2 && !z4)) {
                z3 = true;
            }
            mVar.a(z3);
        }
    }

    public final void b() {
        if (this.b != null && this.h) {
            a(this.b.j);
        }
        if (this.i != null) {
            this.a.setContentView(this.m);
            this.r = true;
            this.i.removeAllViews();
            this.i = null;
        }
        if (this.j != null) {
            this.j.onCustomViewHidden();
            this.j = null;
        }
        this.h = false;
    }

    public final void c() {
        this.m.removeView(this.g);
        a(true);
    }

    @VisibleForTesting
    final void d() {
        if (!this.t) {
            this.t = true;
            if (this.c != null) {
                this.m.removeView(this.c.getView());
                if (this.f != null) {
                    this.c.zzbm(this.f.d);
                    this.c.zzai(false);
                    this.f.c.addView(this.c.getView(), this.f.a, this.f.b);
                    this.f = null;
                } else if (this.a.getApplicationContext() != null) {
                    this.c.zzbm(this.a.getApplicationContext());
                }
                this.c = null;
            }
            if (this.b != null && this.b.c != null) {
                this.b.c.zzcb();
            }
        }
    }

    public final void e() {
        if (this.n) {
            this.n = false;
            i();
        }
    }

    public final void f() {
        this.m.a = true;
    }

    public final void g() {
        synchronized (this.o) {
            this.q = true;
            if (this.p != null) {
                ht.a.removeCallbacks(this.p);
                ht.a.post(this.p);
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.d = 0;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        this.a.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.k = z;
        try {
            this.b = AdOverlayInfoParcel.a(this.a.getIntent());
            if (this.b == null) {
                throw new f("Could not get info for ad overlay.");
            }
            if (this.b.m.c > 7500000) {
                this.d = 3;
            }
            if (this.a.getIntent() != null) {
                this.u = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.o != null) {
                this.l = this.b.o.a;
            } else {
                this.l = false;
            }
            if (((Boolean) akc.f().a(amn.bR)).booleanValue() && this.l && this.b.o.e != -1) {
                new i(this, null).f();
            }
            if (bundle == null) {
                if (this.b.c != null && this.u) {
                    this.b.c.zzcc();
                }
                if (!(this.b.k == 1 || this.b.b == null)) {
                    this.b.b.onAdClicked();
                }
            }
            this.m = new g(this.a, this.b.n, this.b.m.a);
            this.m.setId(1000);
            switch (this.b.k) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.f = new h(this.b.d);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                default:
                    throw new f("Could not determine ad overlay type.");
            }
        } catch (f e) {
            kk.e(e.getMessage());
            this.d = 3;
            this.a.finish();
        }
    }

    public final void onDestroy() {
        if (this.c != null) {
            this.m.removeView(this.c.getView());
        }
        h();
    }

    public final void onPause() {
        b();
        if (this.b.c != null) {
            this.b.c.onPause();
        }
        if (!(((Boolean) akc.f().a(amn.cZ)).booleanValue() || this.c == null || (this.a.isFinishing() && this.f != null))) {
            au.g();
            hz.a(this.c);
        }
        h();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.b.c != null) {
            this.b.c.onResume();
        }
        if (!((Boolean) akc.f().a(amn.cZ)).booleanValue()) {
            if (this.c == null || this.c.isDestroyed()) {
                kk.e("The webview does not exist. Ignoring action.");
                return;
            }
            au.g();
            hz.b(this.c);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.k);
    }

    public final void onStart() {
        if (!((Boolean) akc.f().a(amn.cZ)).booleanValue()) {
            return;
        }
        if (this.c == null || this.c.isDestroyed()) {
            kk.e("The webview does not exist. Ignoring action.");
            return;
        }
        au.g();
        hz.b(this.c);
    }

    public final void onStop() {
        if (((Boolean) akc.f().a(amn.cZ)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.f == null)) {
            au.g();
            hz.a(this.c);
        }
        h();
    }

    public final void zzax() {
        this.r = true;
    }

    public final void zzni() {
        this.d = 1;
        this.a.finish();
    }

    public final boolean zznj() {
        this.d = 0;
        if (this.c == null) {
            return true;
        }
        boolean zzul = this.c.zzul();
        if (zzul) {
            return zzul;
        }
        this.c.zza("onbackblocked", Collections.emptyMap());
        return zzul;
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) akc.f().a(amn.cY)).booleanValue() && p.k()) {
            Configuration configuration = (Configuration) com.google.android.gms.dynamic.c.a(iObjectWrapper);
            au.e();
            if (ht.a(this.a, configuration)) {
                this.a.getWindow().addFlags(com.appnext.base.b.c.jk);
                this.a.getWindow().clearFlags(2048);
                return;
            }
            this.a.getWindow().addFlags(2048);
            this.a.getWindow().clearFlags(com.appnext.base.b.c.jk);
        }
    }
}
