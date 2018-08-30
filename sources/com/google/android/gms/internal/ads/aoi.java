package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class aoi extends aot implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    @VisibleForTesting
    private static final String[] a = new String[]{"2011", "1009", "3010"};
    private final Object b = new Object();
    private final FrameLayout c;
    @Nullable
    @VisibleForTesting
    private FrameLayout d;
    private View e;
    private final boolean f;
    @VisibleForTesting
    private Map<String, WeakReference<View>> g = Collections.synchronizedMap(new HashMap());
    @Nullable
    @VisibleForTesting
    private View h;
    @Nullable
    @VisibleForTesting
    private zzoz i;
    @VisibleForTesting
    private boolean j = false;
    @VisibleForTesting
    private Point k = new Point();
    @VisibleForTesting
    private Point l = new Point();
    @VisibleForTesting
    private WeakReference<agc> m = new WeakReference(null);

    @TargetApi(21)
    public aoi(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.c = frameLayout;
        this.d = frameLayout2;
        au.A();
        lp.a(this.c, (OnGlobalLayoutListener) this);
        au.A();
        lp.a(this.c, (OnScrollChangedListener) this);
        this.c.setOnTouchListener(this);
        this.c.setOnClickListener(this);
        if (frameLayout2 != null && p.i()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        amn.a(this.c.getContext());
        this.f = ((Boolean) akc.f().a(amn.ci)).booleanValue();
    }

    @VisibleForTesting
    private final int a(int i) {
        akc.a();
        return kb.b(this.i.getContext(), i);
    }

    private final void a() {
        synchronized (this.b) {
            if (!this.f && this.j) {
                int measuredWidth = this.c.getMeasuredWidth();
                int measuredHeight = this.c.getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.d == null)) {
                    this.d.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.j = false;
                }
            }
        }
    }

    private final void a(@Nullable View view) {
        if (this.i != null) {
            zzoz b = this.i instanceof anx ? ((anx) this.i).b() : this.i;
            if (b != null) {
                b.zzl(view);
            }
        }
    }

    public final void destroy() {
        synchronized (this.b) {
            if (this.d != null) {
                this.d.removeAllViews();
            }
            this.d = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.e = null;
        }
    }

    /* JADX WARNING: Missing block: B:23:?, code:
            return;
     */
    public final void onClick(android.view.View r8) {
        /*
        r7 = this;
        r6 = r7.b;
        monitor-enter(r6);
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x007b }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r0.cancelUnconfirmedClick();	 Catch:{ all -> 0x007b }
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x007b }
        r3.<init>();	 Catch:{ all -> 0x007b }
        r0 = "x";
        r1 = r7.k;	 Catch:{ all -> 0x007b }
        r1 = r1.x;	 Catch:{ all -> 0x007b }
        r1 = r7.a(r1);	 Catch:{ all -> 0x007b }
        r1 = (float) r1;	 Catch:{ all -> 0x007b }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x007b }
        r0 = "y";
        r1 = r7.k;	 Catch:{ all -> 0x007b }
        r1 = r1.y;	 Catch:{ all -> 0x007b }
        r1 = r7.a(r1);	 Catch:{ all -> 0x007b }
        r1 = (float) r1;	 Catch:{ all -> 0x007b }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x007b }
        r0 = "start_x";
        r1 = r7.l;	 Catch:{ all -> 0x007b }
        r1 = r1.x;	 Catch:{ all -> 0x007b }
        r1 = r7.a(r1);	 Catch:{ all -> 0x007b }
        r1 = (float) r1;	 Catch:{ all -> 0x007b }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x007b }
        r0 = "start_y";
        r1 = r7.l;	 Catch:{ all -> 0x007b }
        r1 = r1.y;	 Catch:{ all -> 0x007b }
        r1 = r7.a(r1);	 Catch:{ all -> 0x007b }
        r1 = (float) r1;	 Catch:{ all -> 0x007b }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x007b }
        r0 = r7.h;	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x008b;
    L_0x004f:
        r0 = r7.h;	 Catch:{ all -> 0x007b }
        r0 = r0.equals(r8);	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x008b;
    L_0x0057:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r0 = r0 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x007e;
    L_0x005d:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r0 = (com.google.android.gms.internal.ads.anx) r0;	 Catch:{ all -> 0x007b }
        r0 = r0.b();	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x0079;
    L_0x0067:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r0 = (com.google.android.gms.internal.ads.anx) r0;	 Catch:{ all -> 0x007b }
        r0 = r0.b();	 Catch:{ all -> 0x007b }
        r2 = "1007";
        r4 = r7.g;	 Catch:{ all -> 0x007b }
        r5 = r7.c;	 Catch:{ all -> 0x007b }
        r1 = r8;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x007b }
    L_0x0079:
        monitor-exit(r6);	 Catch:{ all -> 0x007b }
        goto L_0x0008;
    L_0x007b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x007b }
        throw r0;
    L_0x007e:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r2 = "1007";
        r4 = r7.g;	 Catch:{ all -> 0x007b }
        r5 = r7.c;	 Catch:{ all -> 0x007b }
        r1 = r8;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x007b }
        goto L_0x0079;
    L_0x008b:
        r0 = r7.i;	 Catch:{ all -> 0x007b }
        r1 = r7.g;	 Catch:{ all -> 0x007b }
        r2 = r7.c;	 Catch:{ all -> 0x007b }
        r0.zza(r8, r1, r3, r2);	 Catch:{ all -> 0x007b }
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoi.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.b) {
            a();
            if (this.i != null) {
                this.i.zzc(this.c, this.g);
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.b) {
            if (this.i != null) {
                this.i.zzc(this.c, this.g);
            }
            a();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.b) {
            if (this.i == null) {
            } else {
                int[] iArr = new int[2];
                this.c.getLocationOnScreen(iArr);
                Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
                this.k = point;
                if (motionEvent.getAction() == 0) {
                    this.l = point;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) point.x, (float) point.y);
                this.i.zzd(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121 A:{Catch:{ Exception -> 0x0241 }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014b A:{Catch:{ Exception -> 0x0241 }} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x017f A:{SYNTHETIC, Splitter: B:84:0x017f} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01cf A:{Catch:{ Exception -> 0x0241 }} */
    /* JADX WARNING: Missing block: B:148:?, code:
            return;
     */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r13) {
        /*
        r12 = this;
        r11 = 2;
        r3 = 1;
        r7 = 0;
        r8 = 0;
        r9 = r12.b;
        monitor-enter(r9);
        r1 = 0;
        r12.a(r1);	 Catch:{ all -> 0x00b0 }
        r1 = com.google.android.gms.dynamic.c.a(r13);	 Catch:{ all -> 0x00b0 }
        r2 = r1 instanceof com.google.android.gms.internal.ads.anz;	 Catch:{ all -> 0x00b0 }
        if (r2 != 0) goto L_0x001a;
    L_0x0013:
        r1 = "Not an instance of native engine. This is most likely a transient error";
        com.google.android.gms.internal.ads.kk.e(r1);	 Catch:{ all -> 0x00b0 }
        monitor-exit(r9);	 Catch:{ all -> 0x00b0 }
    L_0x0019:
        return;
    L_0x001a:
        r2 = r12.f;	 Catch:{ all -> 0x00b0 }
        if (r2 != 0) goto L_0x0033;
    L_0x001e:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0033;
    L_0x0022:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        r4 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x00b0 }
        r5 = 0;
        r6 = 0;
        r4.<init>(r5, r6);	 Catch:{ all -> 0x00b0 }
        r2.setLayoutParams(r4);	 Catch:{ all -> 0x00b0 }
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r2.requestLayout();	 Catch:{ all -> 0x00b0 }
    L_0x0033:
        r2 = 1;
        r12.j = r2;	 Catch:{ all -> 0x00b0 }
        r1 = (com.google.android.gms.internal.ads.anz) r1;	 Catch:{ all -> 0x00b0 }
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0057;
    L_0x003c:
        r2 = com.google.android.gms.internal.ads.amn.bZ;	 Catch:{ all -> 0x00b0 }
        r4 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x00b0 }
        r2 = r4.a(r2);	 Catch:{ all -> 0x00b0 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x00b0 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0057;
    L_0x004e:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r4 = r12.c;	 Catch:{ all -> 0x00b0 }
        r5 = r12.g;	 Catch:{ all -> 0x00b0 }
        r2.zzb(r4, r5);	 Catch:{ all -> 0x00b0 }
    L_0x0057:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = r2 instanceof com.google.android.gms.internal.ads.anz;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0092;
    L_0x005d:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = (com.google.android.gms.internal.ads.anz) r2;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0092;
    L_0x0063:
        r4 = r2.getContext();	 Catch:{ all -> 0x00b0 }
        if (r4 == 0) goto L_0x0092;
    L_0x0069:
        r4 = com.google.android.gms.ads.internal.au.B();	 Catch:{ all -> 0x00b0 }
        r5 = r12.c;	 Catch:{ all -> 0x00b0 }
        r5 = r5.getContext();	 Catch:{ all -> 0x00b0 }
        r4 = r4.c(r5);	 Catch:{ all -> 0x00b0 }
        if (r4 == 0) goto L_0x0092;
    L_0x0079:
        r4 = r2.d();	 Catch:{ all -> 0x00b0 }
        if (r4 == 0) goto L_0x0083;
    L_0x007f:
        r2 = 0;
        r4.a(r2);	 Catch:{ all -> 0x00b0 }
    L_0x0083:
        r2 = r12.m;	 Catch:{ all -> 0x00b0 }
        r2 = r2.get();	 Catch:{ all -> 0x00b0 }
        r2 = (com.google.android.gms.internal.ads.agc) r2;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0092;
    L_0x008d:
        if (r4 == 0) goto L_0x0092;
    L_0x008f:
        r2.b(r4);	 Catch:{ all -> 0x00b0 }
    L_0x0092:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = r2 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x00b3;
    L_0x0098:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = (com.google.android.gms.internal.ads.anx) r2;	 Catch:{ all -> 0x00b0 }
        r2 = r2.a();	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x00b3;
    L_0x00a2:
        r2 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = (com.google.android.gms.internal.ads.anx) r2;	 Catch:{ all -> 0x00b0 }
        r2.a(r1);	 Catch:{ all -> 0x00b0 }
    L_0x00a9:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        if (r2 != 0) goto L_0x00c2;
    L_0x00ad:
        monitor-exit(r9);	 Catch:{ all -> 0x00b0 }
        goto L_0x0019;
    L_0x00b0:
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00b0 }
        throw r1;
    L_0x00b3:
        r12.i = r1;	 Catch:{ all -> 0x00b0 }
        r2 = r1 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x00a9;
    L_0x00b9:
        r0 = r1;
        r0 = (com.google.android.gms.internal.ads.anx) r0;	 Catch:{ all -> 0x00b0 }
        r2 = r0;
        r4 = 0;
        r2.a(r4);	 Catch:{ all -> 0x00b0 }
        goto L_0x00a9;
    L_0x00c2:
        r2 = com.google.android.gms.internal.ads.amn.bZ;	 Catch:{ all -> 0x00b0 }
        r4 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x00b0 }
        r2 = r4.a(r2);	 Catch:{ all -> 0x00b0 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x00b0 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x00da;
    L_0x00d4:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        r4 = 0;
        r2.setClickable(r4);	 Catch:{ all -> 0x00b0 }
    L_0x00da:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        r2.removeAllViews();	 Catch:{ all -> 0x00b0 }
        r5 = r1.zzkj();	 Catch:{ all -> 0x00b0 }
        if (r5 == 0) goto L_0x0279;
    L_0x00e5:
        r2 = r12.g;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0218;
    L_0x00e9:
        r2 = 2;
        r6 = new java.lang.String[r2];	 Catch:{ all -> 0x00b0 }
        r2 = 0;
        r4 = "1098";
        r6[r2] = r4;	 Catch:{ all -> 0x00b0 }
        r2 = 1;
        r4 = "3011";
        r6[r2] = r4;	 Catch:{ all -> 0x00b0 }
        r4 = r8;
    L_0x00f7:
        if (r4 >= r11) goto L_0x0218;
    L_0x00f9:
        r2 = r6[r4];	 Catch:{ all -> 0x00b0 }
        r10 = r12.g;	 Catch:{ all -> 0x00b0 }
        r2 = r10.get(r2);	 Catch:{ all -> 0x00b0 }
        r2 = (java.lang.ref.WeakReference) r2;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0213;
    L_0x0105:
        r2 = r2.get();	 Catch:{ all -> 0x00b0 }
        r2 = (android.view.View) r2;	 Catch:{ all -> 0x00b0 }
    L_0x010b:
        r4 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x00b0 }
        if (r4 == 0) goto L_0x0279;
    L_0x010f:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x00b0 }
        r4 = r2;
    L_0x0112:
        if (r5 == 0) goto L_0x021b;
    L_0x0114:
        if (r4 == 0) goto L_0x021b;
    L_0x0116:
        r2 = r3;
    L_0x0117:
        r3 = r1.zza(r12, r2);	 Catch:{ all -> 0x00b0 }
        r12.h = r3;	 Catch:{ all -> 0x00b0 }
        r3 = r12.h;	 Catch:{ all -> 0x00b0 }
        if (r3 == 0) goto L_0x013d;
    L_0x0121:
        r3 = r12.g;	 Catch:{ all -> 0x00b0 }
        if (r3 == 0) goto L_0x0133;
    L_0x0125:
        r3 = r12.g;	 Catch:{ all -> 0x00b0 }
        r5 = "1007";
        r6 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00b0 }
        r10 = r12.h;	 Catch:{ all -> 0x00b0 }
        r6.<init>(r10);	 Catch:{ all -> 0x00b0 }
        r3.put(r5, r6);	 Catch:{ all -> 0x00b0 }
    L_0x0133:
        if (r2 == 0) goto L_0x021e;
    L_0x0135:
        r4.removeAllViews();	 Catch:{ all -> 0x00b0 }
        r2 = r12.h;	 Catch:{ all -> 0x00b0 }
        r4.addView(r2);	 Catch:{ all -> 0x00b0 }
    L_0x013d:
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r12.g;	 Catch:{ all -> 0x00b0 }
        r4 = 0;
        r5 = r12;
        r6 = r12;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00b0 }
        r2 = r12.f;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0179;
    L_0x014b:
        r2 = r12.e;	 Catch:{ all -> 0x00b0 }
        if (r2 != 0) goto L_0x0168;
    L_0x014f:
        r2 = new android.view.View;	 Catch:{ all -> 0x00b0 }
        r3 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r3.getContext();	 Catch:{ all -> 0x00b0 }
        r2.<init>(r3);	 Catch:{ all -> 0x00b0 }
        r12.e = r2;	 Catch:{ all -> 0x00b0 }
        r2 = r12.e;	 Catch:{ all -> 0x00b0 }
        r3 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x00b0 }
        r4 = -1;
        r5 = 0;
        r3.<init>(r4, r5);	 Catch:{ all -> 0x00b0 }
        r2.setLayoutParams(r3);	 Catch:{ all -> 0x00b0 }
    L_0x0168:
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r12.e;	 Catch:{ all -> 0x00b0 }
        r3 = r3.getParent();	 Catch:{ all -> 0x00b0 }
        if (r2 == r3) goto L_0x0179;
    L_0x0172:
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r12.e;	 Catch:{ all -> 0x00b0 }
        r2.addView(r3);	 Catch:{ all -> 0x00b0 }
    L_0x0179:
        r2 = r1.c();	 Catch:{ Exception -> 0x0241 }
    L_0x017d:
        if (r2 == 0) goto L_0x018c;
    L_0x017f:
        r3 = r12.d;	 Catch:{ all -> 0x00b0 }
        if (r3 == 0) goto L_0x018c;
    L_0x0183:
        r3 = r12.d;	 Catch:{ all -> 0x00b0 }
        r2 = r2.getView();	 Catch:{ all -> 0x00b0 }
        r3.addView(r2);	 Catch:{ all -> 0x00b0 }
    L_0x018c:
        r4 = r12.b;	 Catch:{ all -> 0x00b0 }
        monitor-enter(r4);	 Catch:{ all -> 0x00b0 }
        r2 = r12.g;	 Catch:{ all -> 0x0272 }
        r1.a(r2);	 Catch:{ all -> 0x0272 }
        r2 = r12.g;	 Catch:{ all -> 0x0272 }
        if (r2 == 0) goto L_0x0260;
    L_0x0198:
        r5 = a;	 Catch:{ all -> 0x0272 }
        r6 = r5.length;	 Catch:{ all -> 0x0272 }
        r3 = r8;
    L_0x019c:
        if (r3 >= r6) goto L_0x0260;
    L_0x019e:
        r2 = r5[r3];	 Catch:{ all -> 0x0272 }
        r8 = r12.g;	 Catch:{ all -> 0x0272 }
        r2 = r8.get(r2);	 Catch:{ all -> 0x0272 }
        r2 = (java.lang.ref.WeakReference) r2;	 Catch:{ all -> 0x0272 }
        if (r2 == 0) goto L_0x025b;
    L_0x01aa:
        r2 = r2.get();	 Catch:{ all -> 0x0272 }
        r2 = (android.view.View) r2;	 Catch:{ all -> 0x0272 }
    L_0x01b0:
        r3 = r2 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x0272 }
        if (r3 != 0) goto L_0x0263;
    L_0x01b4:
        r1.zzkq();	 Catch:{ all -> 0x0272 }
        monitor-exit(r4);	 Catch:{ all -> 0x0272 }
    L_0x01b8:
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r1.a(r2);	 Catch:{ all -> 0x00b0 }
        r1 = r12.c;	 Catch:{ all -> 0x00b0 }
        r12.a(r1);	 Catch:{ all -> 0x00b0 }
        r1 = r12.i;	 Catch:{ all -> 0x00b0 }
        r2 = r12.c;	 Catch:{ all -> 0x00b0 }
        r1.zzj(r2);	 Catch:{ all -> 0x00b0 }
        r1 = r12.i;	 Catch:{ all -> 0x00b0 }
        r1 = r1 instanceof com.google.android.gms.internal.ads.anz;	 Catch:{ all -> 0x00b0 }
        if (r1 == 0) goto L_0x0210;
    L_0x01cf:
        r1 = r12.i;	 Catch:{ all -> 0x00b0 }
        r1 = (com.google.android.gms.internal.ads.anz) r1;	 Catch:{ all -> 0x00b0 }
        if (r1 == 0) goto L_0x0210;
    L_0x01d5:
        r2 = r1.getContext();	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0210;
    L_0x01db:
        r2 = com.google.android.gms.ads.internal.au.B();	 Catch:{ all -> 0x00b0 }
        r3 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r3.getContext();	 Catch:{ all -> 0x00b0 }
        r2 = r2.c(r3);	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x0210;
    L_0x01eb:
        r2 = r12.m;	 Catch:{ all -> 0x00b0 }
        r2 = r2.get();	 Catch:{ all -> 0x00b0 }
        r2 = (com.google.android.gms.internal.ads.agc) r2;	 Catch:{ all -> 0x00b0 }
        if (r2 != 0) goto L_0x0209;
    L_0x01f5:
        r2 = new com.google.android.gms.internal.ads.agc;	 Catch:{ all -> 0x00b0 }
        r3 = r12.c;	 Catch:{ all -> 0x00b0 }
        r3 = r3.getContext();	 Catch:{ all -> 0x00b0 }
        r4 = r12.c;	 Catch:{ all -> 0x00b0 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00b0 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00b0 }
        r3.<init>(r2);	 Catch:{ all -> 0x00b0 }
        r12.m = r3;	 Catch:{ all -> 0x00b0 }
    L_0x0209:
        r1 = r1.d();	 Catch:{ all -> 0x00b0 }
        r2.a(r1);	 Catch:{ all -> 0x00b0 }
    L_0x0210:
        monitor-exit(r9);	 Catch:{ all -> 0x00b0 }
        goto L_0x0019;
    L_0x0213:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00f7;
    L_0x0218:
        r2 = r7;
        goto L_0x010b;
    L_0x021b:
        r2 = r8;
        goto L_0x0117;
    L_0x021e:
        r2 = r1.getContext();	 Catch:{ all -> 0x00b0 }
        r3 = new com.google.android.gms.ads.formats.AdChoicesView;	 Catch:{ all -> 0x00b0 }
        r3.<init>(r2);	 Catch:{ all -> 0x00b0 }
        r2 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x00b0 }
        r4 = -1;
        r5 = -1;
        r2.<init>(r4, r5);	 Catch:{ all -> 0x00b0 }
        r3.setLayoutParams(r2);	 Catch:{ all -> 0x00b0 }
        r2 = r12.h;	 Catch:{ all -> 0x00b0 }
        r3.addView(r2);	 Catch:{ all -> 0x00b0 }
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        if (r2 == 0) goto L_0x013d;
    L_0x023a:
        r2 = r12.d;	 Catch:{ all -> 0x00b0 }
        r2.addView(r3);	 Catch:{ all -> 0x00b0 }
        goto L_0x013d;
    L_0x0241:
        r2 = move-exception;
        com.google.android.gms.ads.internal.au.g();	 Catch:{ all -> 0x00b0 }
        r3 = com.google.android.gms.internal.ads.hz.e();	 Catch:{ all -> 0x00b0 }
        if (r3 == 0) goto L_0x0253;
    L_0x024b:
        r2 = "Privileged processes cannot create HTML overlays.";
        com.google.android.gms.internal.ads.kk.e(r2);	 Catch:{ all -> 0x00b0 }
        r2 = r7;
        goto L_0x017d;
    L_0x0253:
        r3 = "Error obtaining overlay.";
        com.google.android.gms.internal.ads.kk.b(r3, r2);	 Catch:{ all -> 0x00b0 }
        r2 = r7;
        goto L_0x017d;
    L_0x025b:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x019c;
    L_0x0260:
        r2 = r7;
        goto L_0x01b0;
    L_0x0263:
        r3 = new com.google.android.gms.internal.ads.aoj;	 Catch:{ all -> 0x0272 }
        r3.<init>(r12, r2);	 Catch:{ all -> 0x0272 }
        r5 = r1 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x0272 }
        if (r5 == 0) goto L_0x0275;
    L_0x026c:
        r1.a(r2, r3);	 Catch:{ all -> 0x0272 }
    L_0x026f:
        monitor-exit(r4);	 Catch:{ all -> 0x0272 }
        goto L_0x01b8;
    L_0x0272:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0272 }
        throw r1;	 Catch:{ all -> 0x00b0 }
    L_0x0275:
        r1.zza(r2, r3);	 Catch:{ all -> 0x0272 }
        goto L_0x026f;
    L_0x0279:
        r4 = r7;
        goto L_0x0112;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoi.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final IObjectWrapper zzak(String str) {
        Object obj = null;
        synchronized (this.b) {
            if (this.g == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.g.get(str);
            if (weakReference != null) {
                View obj2 = (View) weakReference.get();
            }
            IObjectWrapper a = c.a(obj2);
            return a;
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        if (au.B().c(this.c.getContext()) && this.m != null) {
            agc agc = (agc) this.m.get();
            if (agc != null) {
                agc.a();
            }
        }
        a();
    }

    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    public final void zzb(java.lang.String r5, com.google.android.gms.dynamic.IObjectWrapper r6) {
        /*
        r4 = this;
        r0 = com.google.android.gms.dynamic.c.a(r6);
        r0 = (android.view.View) r0;
        r1 = r4.b;
        monitor-enter(r1);
        r2 = r4.g;	 Catch:{ all -> 0x0018 }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x000e:
        return;
    L_0x000f:
        if (r0 != 0) goto L_0x001b;
    L_0x0011:
        r0 = r4.g;	 Catch:{ all -> 0x0018 }
        r0.remove(r5);	 Catch:{ all -> 0x0018 }
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x000e;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        r2 = r4.g;	 Catch:{ all -> 0x0018 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0018 }
        r3.<init>(r0);	 Catch:{ all -> 0x0018 }
        r2.put(r5, r3);	 Catch:{ all -> 0x0018 }
        r2 = "1098";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0018 }
        if (r2 != 0) goto L_0x0035;
    L_0x002d:
        r2 = "3011";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0018 }
        if (r2 == 0) goto L_0x0037;
    L_0x0035:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x000e;
    L_0x0037:
        r0.setOnTouchListener(r4);	 Catch:{ all -> 0x0018 }
        r2 = 1;
        r0.setClickable(r2);	 Catch:{ all -> 0x0018 }
        r0.setOnClickListener(r4);	 Catch:{ all -> 0x0018 }
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoi.zzb(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void zzc(IObjectWrapper iObjectWrapper) {
        this.i.setClickConfirmingView((View) c.a(iObjectWrapper));
    }
}
