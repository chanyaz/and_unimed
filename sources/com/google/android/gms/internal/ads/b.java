package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.e;
import java.util.Set;

@zzadh
public final class b extends l {
    private static final Set<String> a = e.b("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String b = "top-right";
    private boolean c = true;
    private int d = 0;
    private int e = 0;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = -1;
    private final Object j = new Object();
    private final zzaqw k;
    private final Activity l;
    private op m;
    private ImageView n;
    private LinearLayout o;
    private zzaam p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public b(zzaqw zzaqw, zzaam zzaam) {
        super(zzaqw, "resize");
        this.k = zzaqw;
        this.l = zzaqw.zzto();
        this.p = zzaam;
    }

    private final void b(int i, int i2) {
        a(i, i2 - au.e().c(this.l)[0], this.i, this.f);
    }

    private final int[] b() {
        int i;
        int[] b = au.e().b(this.l);
        int[] c = au.e().c(this.l);
        int i2 = b[0];
        int i3 = b[1];
        if (this.i < 50 || this.i > i2) {
            kk.e("Width is too small or too large.");
            i3 = 0;
        } else if (this.f < 50 || this.f > i3) {
            kk.e("Height is too small or too large.");
            i3 = 0;
        } else if (this.f == i3 && this.i == i2) {
            kk.e("Cannot resize to a full-screen ad.");
            i3 = 0;
        } else {
            if (this.c) {
                String str = this.b;
                i3 = -1;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            i3 = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            i3 = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            i3 = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            i3 = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            i3 = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            i3 = 1;
                            break;
                        }
                        break;
                }
                switch (i3) {
                    case 0:
                        i = this.g + this.d;
                        i3 = this.e + this.h;
                        break;
                    case 1:
                        i = ((this.d + this.g) + (this.i / 2)) - 25;
                        i3 = this.e + this.h;
                        break;
                    case 2:
                        i = ((this.d + this.g) + (this.i / 2)) - 25;
                        i3 = ((this.e + this.h) + (this.f / 2)) - 25;
                        break;
                    case 3:
                        i = this.g + this.d;
                        i3 = ((this.e + this.h) + this.f) - 50;
                        break;
                    case 4:
                        i = ((this.d + this.g) + (this.i / 2)) - 25;
                        i3 = ((this.e + this.h) + this.f) - 50;
                        break;
                    case 5:
                        i = ((this.d + this.g) + this.i) - 50;
                        i3 = ((this.e + this.h) + this.f) - 50;
                        break;
                    default:
                        i = ((this.d + this.g) + this.i) - 50;
                        i3 = this.e + this.h;
                        break;
                }
                if (i < 0 || i + 50 > i2 || r0 < c[0] || r0 + 50 > c[1]) {
                    i3 = 0;
                }
            }
            i3 = 1;
        }
        if (i3 == 0) {
            return null;
        }
        if (this.c) {
            return new int[]{this.d + this.g, this.e + this.h};
        }
        b = au.e().b(this.l);
        c = au.e().c(this.l);
        i2 = b[0];
        i3 = this.d + this.g;
        i = this.e + this.h;
        if (i3 < 0) {
            i3 = 0;
        } else if (this.i + i3 > i2) {
            i3 = i2 - this.i;
        }
        if (i < c[0]) {
            i = c[0];
        } else if (this.f + i > c[1]) {
            i = c[1] - this.f;
        }
        return new int[]{i3, i};
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public final void a(int i, int i2, boolean z) {
        synchronized (this.j) {
            this.d = i;
            this.e = i2;
            if (this.q != null && z) {
                int[] b = b();
                if (b != null) {
                    PopupWindow popupWindow = this.q;
                    akc.a();
                    int a = kb.a(this.l, b[0]);
                    akc.a();
                    popupWindow.update(a, kb.a(this.l, b[1]), this.q.getWidth(), this.q.getHeight());
                    b(b[0], b[1]);
                } else {
                    a(true);
                }
            }
        }
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
        r13 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r13.j;
        monitor-enter(r6);
        r1 = r13.l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzud();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzud();	 Catch:{ all -> 0x0020 }
        r1 = r1.d();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0036;
    L_0x002f:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0036:
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzuj();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0045;
    L_0x003e:
        r1 = "Cannot resize an expanded banner.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0045:
        r1 = "width";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0020 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0064;
    L_0x0053:
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = "width";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ads.ht.b(r1);	 Catch:{ all -> 0x0020 }
        r13.i = r1;	 Catch:{ all -> 0x0020 }
    L_0x0064:
        r1 = "height";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0020 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0083;
    L_0x0072:
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = "height";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ads.ht.b(r1);	 Catch:{ all -> 0x0020 }
        r13.f = r1;	 Catch:{ all -> 0x0020 }
    L_0x0083:
        r1 = "offsetX";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0020 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x00a2;
    L_0x0091:
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = "offsetX";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ads.ht.b(r1);	 Catch:{ all -> 0x0020 }
        r13.g = r1;	 Catch:{ all -> 0x0020 }
    L_0x00a2:
        r1 = "offsetY";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0020 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x00c1;
    L_0x00b0:
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = "offsetY";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ads.ht.b(r1);	 Catch:{ all -> 0x0020 }
        r13.h = r1;	 Catch:{ all -> 0x0020 }
    L_0x00c1:
        r1 = "allowOffscreen";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0020 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x00dd;
    L_0x00cf:
        r1 = "allowOffscreen";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r1 = java.lang.Boolean.parseBoolean(r1);	 Catch:{ all -> 0x0020 }
        r13.c = r1;	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = "customClosePosition";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0020 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0020 }
        if (r2 != 0) goto L_0x00ed;
    L_0x00eb:
        r13.b = r1;	 Catch:{ all -> 0x0020 }
    L_0x00ed:
        r1 = r13.i;	 Catch:{ all -> 0x0020 }
        if (r1 < 0) goto L_0x0100;
    L_0x00f1:
        r1 = r13.f;	 Catch:{ all -> 0x0020 }
        if (r1 < 0) goto L_0x0100;
    L_0x00f5:
        r1 = r5;
    L_0x00f6:
        if (r1 != 0) goto L_0x0102;
    L_0x00f8:
        r1 = "Invalid width and height options. Cannot resize.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0100:
        r1 = r3;
        goto L_0x00f6;
    L_0x0102:
        r1 = r13.l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0110;
    L_0x010a:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0118;
    L_0x0110:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0118:
        r8 = r13.b();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0126;
    L_0x011e:
        r1 = "Resize location out of screen or close button is not visible.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0126:
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ all -> 0x0020 }
        r1 = r13.l;	 Catch:{ all -> 0x0020 }
        r2 = r13.i;	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.internal.ads.kb.a(r1, r2);	 Catch:{ all -> 0x0020 }
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ all -> 0x0020 }
        r1 = r13.l;	 Catch:{ all -> 0x0020 }
        r2 = r13.f;	 Catch:{ all -> 0x0020 }
        r10 = com.google.android.gms.internal.ads.kb.a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.getView();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x027c;
    L_0x0148:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x027c;
    L_0x014c:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r13.k;	 Catch:{ all -> 0x0020 }
        r11 = r11.getView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r13.q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0275;
    L_0x015d:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r13.s = r2;	 Catch:{ all -> 0x0020 }
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.getView();	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ads.ht.a(r1);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r13.l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r13.n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r13.n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzud();	 Catch:{ all -> 0x0020 }
        r13.m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r13.s;	 Catch:{ all -> 0x0020 }
        r2 = r13.n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x018b:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r13.l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r13.r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1 = com.google.android.gms.internal.ads.ht.a(r1, r9, r10, r2);	 Catch:{ all -> 0x0020 }
        r13.q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r13.q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r13.q;	 Catch:{ all -> 0x0020 }
        r1 = r13.c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0284;
    L_0x01c2:
        r1 = r5;
    L_0x01c3:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r2 = r13.k;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r11 = -1;
        r12 = -1;
        r1.addView(r2, r11, r12);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r13.l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r13.o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ all -> 0x0020 }
        r1 = r13.l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r1 = com.google.android.gms.internal.ads.kb.a(r1, r11);	 Catch:{ all -> 0x0020 }
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ all -> 0x0020 }
        r11 = r13.l;	 Catch:{ all -> 0x0020 }
        r12 = 50;
        r11 = com.google.android.gms.internal.ads.kb.a(r11, r12);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r11);	 Catch:{ all -> 0x0020 }
        r1 = r13.b;	 Catch:{ all -> 0x0020 }
        r11 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r11) {
            case -1364013995: goto L_0x029d;
            case -1012429441: goto L_0x0287;
            case -655373719: goto L_0x02a8;
            case 1163912186: goto L_0x02be;
            case 1288627767: goto L_0x02b3;
            case 1755462605: goto L_0x0292;
            default: goto L_0x0200;
        };	 Catch:{ all -> 0x0020 }
    L_0x0200:
        r1 = r4;
    L_0x0201:
        switch(r1) {
            case 0: goto L_0x02c9;
            case 1: goto L_0x02d5;
            case 2: goto L_0x02e1;
            case 3: goto L_0x02e8;
            case 4: goto L_0x02f4;
            case 5: goto L_0x0300;
            default: goto L_0x0204;
        };	 Catch:{ all -> 0x0020 }
    L_0x0204:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x020e:
        r1 = r13.o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.ads.c;	 Catch:{ all -> 0x0020 }
        r3.<init>(r13);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r13.o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r3 = r13.o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.q;	 Catch:{ RuntimeException -> 0x030c }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x030c }
        r3 = 0;
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ RuntimeException -> 0x030c }
        r4 = r13.l;	 Catch:{ RuntimeException -> 0x030c }
        r5 = 0;
        r5 = r8[r5];	 Catch:{ RuntimeException -> 0x030c }
        r4 = com.google.android.gms.internal.ads.kb.a(r4, r5);	 Catch:{ RuntimeException -> 0x030c }
        com.google.android.gms.internal.ads.akc.a();	 Catch:{ RuntimeException -> 0x030c }
        r5 = r13.l;	 Catch:{ RuntimeException -> 0x030c }
        r7 = 1;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x030c }
        r5 = com.google.android.gms.internal.ads.kb.a(r5, r7);	 Catch:{ RuntimeException -> 0x030c }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x030c }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r3 = r13.p;	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x025b;
    L_0x0252:
        r3 = r13.p;	 Catch:{ all -> 0x0020 }
        r4 = r13.i;	 Catch:{ all -> 0x0020 }
        r5 = r13.f;	 Catch:{ all -> 0x0020 }
        r3.zza(r1, r2, r4, r5);	 Catch:{ all -> 0x0020 }
    L_0x025b:
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r2 = com.google.android.gms.internal.ads.op.a(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r13.b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r13.c(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0275:
        r1 = r13.q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x018b;
    L_0x027c:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0284:
        r1 = r3;
        goto L_0x01c3;
    L_0x0287:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x028f:
        r1 = r3;
        goto L_0x0201;
    L_0x0292:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x029a:
        r1 = r5;
        goto L_0x0201;
    L_0x029d:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x02a5:
        r1 = 2;
        goto L_0x0201;
    L_0x02a8:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x02b0:
        r1 = 3;
        goto L_0x0201;
    L_0x02b3:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x02bb:
        r1 = 4;
        goto L_0x0201;
    L_0x02be:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0200;
    L_0x02c6:
        r1 = 5;
        goto L_0x0201;
    L_0x02c9:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x02d5:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x02e1:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x02e8:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x02f4:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x0300:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x020e;
    L_0x030c:
        r1 = move-exception;
        r2 = "Cannot show popup window: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0020 }
        r3 = r1.length();	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x034f;
    L_0x031d:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0020 }
    L_0x0321:
        r13.a(r1);	 Catch:{ all -> 0x0020 }
        r1 = r13.r;	 Catch:{ all -> 0x0020 }
        r2 = r13.k;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x034c;
    L_0x0333:
        r1 = r13.s;	 Catch:{ all -> 0x0020 }
        r2 = r13.n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.s;	 Catch:{ all -> 0x0020 }
        r2 = r13.k;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r13.k;	 Catch:{ all -> 0x0020 }
        r2 = r13.m;	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
    L_0x034c:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x034f:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x0321;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.b.a(java.util.Map):void");
    }

    public final void a(boolean z) {
        synchronized (this.j) {
            if (this.q != null) {
                this.q.dismiss();
                this.r.removeView(this.k.getView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getView());
                    this.k.zza(this.m);
                }
                if (z) {
                    c(RewardedVideo.VIDEO_MODE_DEFAULT);
                    if (this.p != null) {
                        this.p.zzcq();
                    }
                }
                this.q = null;
                this.r = null;
                this.s = null;
                this.o = null;
            }
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.j) {
            z = this.q != null;
        }
        return z;
    }
}
