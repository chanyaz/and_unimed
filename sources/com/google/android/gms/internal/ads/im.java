package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@zzadh
public final class im {
    private final Context a;
    private String b;
    private String c;
    private String d;
    @Nullable
    private String e;
    private final float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private float o;
    private Handler p;
    private Runnable q;

    public im(Context context) {
        this.j = 0;
        this.q = new in(this);
        this.a = context;
        this.f = context.getResources().getDisplayMetrics().density;
        this.k = ViewConfiguration.get(this.a).getScaledTouchSlop();
        au.t().a();
        this.p = au.t().b();
    }

    public im(Context context, String str) {
        this(context);
        this.b = str;
    }

    private static int a(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    @VisibleForTesting
    private final void a(int i, float f, float f2) {
        if (i == 0) {
            this.j = 0;
            this.g = f;
            this.h = f2;
            this.i = f2;
        } else if (this.j == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.h) {
                    this.h = f2;
                } else if (f2 < this.i) {
                    this.i = f2;
                }
                if (this.h - this.i > 30.0f * this.f) {
                    this.j = -1;
                    return;
                }
                if (this.j == 0 || this.j == 2) {
                    if (f - this.g >= 50.0f * this.f) {
                        this.g = f;
                        this.j++;
                    }
                } else if ((this.j == 1 || this.j == 3) && f - this.g <= -50.0f * this.f) {
                    this.g = f;
                    this.j++;
                }
                if (this.j == 1 || this.j == 3) {
                    if (f > this.g) {
                        this.g = f;
                    }
                } else if (this.j == 2 && f < this.g) {
                    this.g = f;
                }
            } else if (i == 1 && this.j == 4) {
                a();
            }
        }
    }

    private final boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(this.l - f) < ((float) this.k) && Math.abs(this.m - f2) < ((float) this.k) && Math.abs(this.n - f3) < ((float) this.k) && Math.abs(this.o - f4) < ((float) this.k);
    }

    /* JADX WARNING: Missing block: B:10:0x006f, code:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0071;
     */
    private final void e() {
        /*
        r6 = this;
        r0 = r6.a;
        r0 = r0 instanceof android.app.Activity;
        if (r0 != 0) goto L_0x000c;
    L_0x0006:
        r0 = "Can not create dialog without Activity Context";
        com.google.android.gms.internal.ads.kk.d(r0);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r6.b;
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x009a;
    L_0x0014:
        r1 = "\\+";
        r2 = "%20";
        r0 = r0.replaceAll(r1, r2);
        r1 = new android.net.Uri$Builder;
        r1.<init>();
        r0 = r1.encodedQuery(r0);
        r0 = r0.build();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        com.google.android.gms.ads.internal.au.e();
        r2 = com.google.android.gms.internal.ads.ht.a(r0);
        r0 = r2.keySet();
        r3 = r0.iterator();
    L_0x003d:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0063;
    L_0x0043:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r4 = r1.append(r0);
        r5 = " = ";
        r4 = r4.append(r5);
        r0 = r2.get(r0);
        r0 = (java.lang.String) r0;
        r0 = r4.append(r0);
        r4 = "\n\n";
        r0.append(r4);
        goto L_0x003d;
    L_0x0063:
        r0 = r1.toString();
        r0 = r0.trim();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x009a;
    L_0x0071:
        r1 = new android.app.AlertDialog$Builder;
        r2 = r6.a;
        r1.<init>(r2);
        r1.setMessage(r0);
        r2 = "Ad Information";
        r1.setTitle(r2);
        r2 = "Share";
        r3 = new com.google.android.gms.internal.ads.ip;
        r3.<init>(r6, r0);
        r1.setPositiveButton(r2, r3);
        r0 = "Close";
        r2 = com.google.android.gms.internal.ads.iq.a;
        r1.setNegativeButton(r0, r2);
        r0 = r1.create();
        r0.show();
        goto L_0x000b;
    L_0x009a:
        r0 = "No debug information";
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.im.e():void");
    }

    public final void a() {
        String str;
        try {
            if (!((Boolean) akc.f().a(amn.cP)).booleanValue()) {
                if (!((Boolean) akc.f().a(amn.cO)).booleanValue()) {
                    e();
                    return;
                }
            }
            if (this.a instanceof Activity) {
                String str2 = !TextUtils.isEmpty(au.o().a()) ? "Creative Preview (Enabled)" : "Creative Preview";
                str = au.o().b() ? "Troubleshooting (Enabled)" : "Troubleshooting";
                List arrayList = new ArrayList();
                int a = a(arrayList, "Ad Information", true);
                int a2 = a(arrayList, str2, ((Boolean) akc.f().a(amn.cO)).booleanValue());
                int a3 = a(arrayList, str, ((Boolean) akc.f().a(amn.cP)).booleanValue());
                Builder builder = new Builder(this.a, au.g().f());
                builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new io(this, a, a2, a3));
                builder.create().show();
                return;
            }
            kk.d("Can not create dialog without Activity Context");
        } catch (Throwable e) {
            str = "";
            if (hl.a()) {
                Log.v("Ads", str, e);
            }
        }
    }

    final /* synthetic */ void a(int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (i4 == i) {
            e();
            return;
        }
        if (i4 == i2) {
            if (((Boolean) akc.f().a(amn.cO)).booleanValue()) {
                kk.b("Debug mode [Creative Preview] selected.");
                hr.a(new ir(this));
                return;
            }
        }
        if (i4 == i3) {
            if (((Boolean) akc.f().a(amn.cP)).booleanValue()) {
                kk.b("Debug mode [Troubleshooting] selected.");
                hr.a(new is(this));
            }
        }
    }

    public final void a(MotionEvent motionEvent) {
        int i = 1;
        int actionMasked;
        if (((Boolean) akc.f().a(amn.cQ)).booleanValue()) {
            actionMasked = motionEvent.getActionMasked();
            int historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 0) {
                this.j = 0;
                this.l = motionEvent.getX();
                this.m = motionEvent.getY();
                return;
            } else if (this.j == -1) {
                return;
            } else {
                if (this.j == 0 && actionMasked == 5) {
                    this.j = 5;
                    this.n = motionEvent.getX(1);
                    this.o = motionEvent.getY(1);
                    this.p.postDelayed(this.q, ((Long) akc.f().a(amn.cR)).longValue());
                    return;
                } else if (this.j == 5) {
                    if (pointerCount == 2) {
                        if (actionMasked == 2) {
                            actionMasked = 0;
                            for (pointerCount = 0; pointerCount < historySize; pointerCount++) {
                                if (!a(motionEvent.getHistoricalX(0, pointerCount), motionEvent.getHistoricalY(0, pointerCount), motionEvent.getHistoricalX(1, pointerCount), motionEvent.getHistoricalY(1, pointerCount))) {
                                    actionMasked = 1;
                                }
                            }
                            if (a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                                i = actionMasked;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        this.j = -1;
                        this.p.removeCallbacks(this.q);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        i = motionEvent.getHistorySize();
        for (actionMasked = 0; actionMasked < i; actionMasked++) {
            a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, actionMasked), motionEvent.getHistoricalY(0, actionMasked));
        }
        a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public final void a(String str) {
        this.c = str;
    }

    final /* synthetic */ void b() {
        au.o().a(this.a, this.c, this.d, this.e);
    }

    public final void b(String str) {
        this.d = str;
    }

    final /* synthetic */ void c() {
        au.o().a(this.a, this.c, this.d);
    }

    public final void c(String str) {
        this.b = str;
    }

    final /* synthetic */ void d() {
        this.j = 4;
        a();
    }

    public final void d(String str) {
        this.e = str;
    }
}
