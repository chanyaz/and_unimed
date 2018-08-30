package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class aok extends aow implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    @VisibleForTesting
    static final String[] a = new String[]{"2011", "1009", "3010"};
    private final Object b = new Object();
    private final WeakReference<View> c;
    private final Map<String, WeakReference<View>> d = new HashMap();
    private final Map<String, WeakReference<View>> e = new HashMap();
    private final Map<String, WeakReference<View>> f = new HashMap();
    @Nullable
    @GuardedBy("mLock")
    @VisibleForTesting
    private zzoz g;
    @Nullable
    @VisibleForTesting
    private View h;
    @VisibleForTesting
    private Point i = new Point();
    @VisibleForTesting
    private Point j = new Point();
    @Nullable
    @VisibleForTesting
    private WeakReference<agc> k = new WeakReference(null);

    public aok(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        au.A();
        lp.a(view, (OnGlobalLayoutListener) this);
        au.A();
        lp.a(view, (OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.c = new WeakReference(view);
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.d.put(str, new WeakReference(view2));
                if (!("1098".equals(str) || "3011".equals(str))) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.f.putAll(this.d);
        for (Entry entry2 : hashMap2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.e.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
            }
        }
        this.f.putAll(this.e);
        amn.a(view.getContext());
    }

    @VisibleForTesting
    private final int a(int i) {
        int b;
        synchronized (this.b) {
            akc.a();
            b = kb.b(this.g.getContext(), i);
        }
        return b;
    }

    private final void a(@Nullable View view) {
        synchronized (this.b) {
            if (this.g != null) {
                zzoz b = this.g instanceof anx ? ((anx) this.g).b() : this.g;
                if (b != null) {
                    b.zzl(view);
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:26:?, code:
            return;
     */
    private final void a(com.google.android.gms.internal.ads.anz r7) {
        /*
        r6 = this;
        r2 = r6.b;
        monitor-enter(r2);
        r3 = a;	 Catch:{ all -> 0x0039 }
        r4 = r3.length;	 Catch:{ all -> 0x0039 }
        r0 = 0;
        r1 = r0;
    L_0x0008:
        if (r1 >= r4) goto L_0x0029;
    L_0x000a:
        r0 = r3[r1];	 Catch:{ all -> 0x0039 }
        r5 = r6.f;	 Catch:{ all -> 0x0039 }
        r0 = r5.get(r0);	 Catch:{ all -> 0x0039 }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x0025;
    L_0x0016:
        r0 = r0.get();	 Catch:{ all -> 0x0039 }
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x0039 }
    L_0x001c:
        r1 = r0 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x0039 }
        if (r1 != 0) goto L_0x002b;
    L_0x0020:
        r7.zzkq();	 Catch:{ all -> 0x0039 }
        monitor-exit(r2);	 Catch:{ all -> 0x0039 }
    L_0x0024:
        return;
    L_0x0025:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0008;
    L_0x0029:
        r0 = 0;
        goto L_0x001c;
    L_0x002b:
        r1 = new com.google.android.gms.internal.ads.aom;	 Catch:{ all -> 0x0039 }
        r1.<init>(r6, r0);	 Catch:{ all -> 0x0039 }
        r3 = r7 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x0039 }
        if (r3 == 0) goto L_0x003c;
    L_0x0034:
        r7.a(r0, r1);	 Catch:{ all -> 0x0039 }
    L_0x0037:
        monitor-exit(r2);	 Catch:{ all -> 0x0039 }
        goto L_0x0024;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        r7.zza(r0, r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aok.a(com.google.android.gms.internal.ads.anz):void");
    }

    private final boolean a(String[] strArr) {
        for (Object obj : strArr) {
            if (this.d.get(obj) != null) {
                return true;
            }
        }
        for (Object obj2 : strArr) {
            if (this.e.get(obj2) != null) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:27:?, code:
            return;
     */
    public final void onClick(android.view.View r8) {
        /*
        r7 = this;
        r6 = r7.b;
        monitor-enter(r6);
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x0015 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r7.c;	 Catch:{ all -> 0x0015 }
        r5 = r0.get();	 Catch:{ all -> 0x0015 }
        r5 = (android.view.View) r5;	 Catch:{ all -> 0x0015 }
        if (r5 != 0) goto L_0x0018;
    L_0x0013:
        monitor-exit(r6);	 Catch:{ all -> 0x0015 }
        goto L_0x0008;
    L_0x0015:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0015 }
        throw r0;
    L_0x0018:
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x0015 }
        r3.<init>();	 Catch:{ all -> 0x0015 }
        r0 = "x";
        r1 = r7.i;	 Catch:{ all -> 0x0015 }
        r1 = r1.x;	 Catch:{ all -> 0x0015 }
        r1 = r7.a(r1);	 Catch:{ all -> 0x0015 }
        r1 = (float) r1;	 Catch:{ all -> 0x0015 }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x0015 }
        r0 = "y";
        r1 = r7.i;	 Catch:{ all -> 0x0015 }
        r1 = r1.y;	 Catch:{ all -> 0x0015 }
        r1 = r7.a(r1);	 Catch:{ all -> 0x0015 }
        r1 = (float) r1;	 Catch:{ all -> 0x0015 }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x0015 }
        r0 = "start_x";
        r1 = r7.j;	 Catch:{ all -> 0x0015 }
        r1 = r1.x;	 Catch:{ all -> 0x0015 }
        r1 = r7.a(r1);	 Catch:{ all -> 0x0015 }
        r1 = (float) r1;	 Catch:{ all -> 0x0015 }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x0015 }
        r0 = "start_y";
        r1 = r7.j;	 Catch:{ all -> 0x0015 }
        r1 = r1.y;	 Catch:{ all -> 0x0015 }
        r1 = r7.a(r1);	 Catch:{ all -> 0x0015 }
        r1 = (float) r1;	 Catch:{ all -> 0x0015 }
        r3.putFloat(r0, r1);	 Catch:{ all -> 0x0015 }
        r0 = r7.h;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x008e;
    L_0x0059:
        r0 = r7.h;	 Catch:{ all -> 0x0015 }
        r0 = r0.equals(r8);	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x008e;
    L_0x0061:
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        r0 = r0 instanceof com.google.android.gms.internal.ads.anx;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0083;
    L_0x0067:
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        r0 = (com.google.android.gms.internal.ads.anx) r0;	 Catch:{ all -> 0x0015 }
        r0 = r0.b();	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0081;
    L_0x0071:
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        r0 = (com.google.android.gms.internal.ads.anx) r0;	 Catch:{ all -> 0x0015 }
        r0 = r0.b();	 Catch:{ all -> 0x0015 }
        r2 = "1007";
        r4 = r7.f;	 Catch:{ all -> 0x0015 }
        r1 = r8;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0015 }
    L_0x0081:
        monitor-exit(r6);	 Catch:{ all -> 0x0015 }
        goto L_0x0008;
    L_0x0083:
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        r2 = "1007";
        r4 = r7.f;	 Catch:{ all -> 0x0015 }
        r1 = r8;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0015 }
        goto L_0x0081;
    L_0x008e:
        r0 = r7.g;	 Catch:{ all -> 0x0015 }
        r1 = r7.f;	 Catch:{ all -> 0x0015 }
        r0.zza(r8, r1, r3, r5);	 Catch:{ all -> 0x0015 }
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aok.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.b) {
            if (this.g != null) {
                View view = (View) this.c.get();
                if (view != null) {
                    this.g.zzc(view, this.f);
                }
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.b) {
            if (this.g != null) {
                View view = (View) this.c.get();
                if (view != null) {
                    this.g.zzc(view, this.f);
                }
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.b) {
            if (this.g == null) {
            } else {
                View view2 = (View) this.c.get();
                if (view2 == null) {
                } else {
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
                    this.i = point;
                    if (motionEvent.getAction() == 0) {
                        this.j = point;
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setLocation((float) point.x, (float) point.y);
                    this.g.zzd(obtain);
                    obtain.recycle();
                }
            }
        }
        return false;
    }

    public final void unregisterNativeAd() {
        synchronized (this.b) {
            this.h = null;
            this.g = null;
            this.i = null;
            this.j = null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        synchronized (this.b) {
            a(null);
            Object a = c.a(iObjectWrapper);
            if (a instanceof anz) {
                anz anz = (anz) a;
                if (anz.zzkk()) {
                    agc agc;
                    View view;
                    View view2 = (View) this.c.get();
                    if (!(this.g == null || view2 == null)) {
                        if (((Boolean) akc.f().a(amn.bZ)).booleanValue()) {
                            this.g.zzb(view2, this.f);
                        }
                    }
                    synchronized (this.b) {
                        if (this.g instanceof anz) {
                            anz anz2 = (anz) this.g;
                            View view3 = (View) this.c.get();
                            if (!(anz2 == null || anz2.getContext() == null || view3 == null || !au.B().c(view3.getContext()))) {
                                zzft d = anz2.d();
                                if (d != null) {
                                    d.a(false);
                                }
                                agc = (agc) this.k.get();
                                if (!(agc == null || d == null)) {
                                    agc.b(d);
                                }
                            }
                        }
                    }
                    if ((this.g instanceof anx) && ((anx) this.g).a()) {
                        ((anx) this.g).a(anz);
                    } else {
                        this.g = anz;
                        if (anz instanceof anx) {
                            ((anx) anz).a(null);
                        }
                    }
                    String[] strArr = new String[]{"1098", "3011"};
                    for (int i = 0; i < 2; i++) {
                        WeakReference weakReference = (WeakReference) this.f.get(strArr[i]);
                        if (weakReference != null) {
                            view = (View) weakReference.get();
                            break;
                        }
                    }
                    view = null;
                    if (view == null) {
                        kk.e("Ad choices asset view is not provided.");
                    } else {
                        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                        if (viewGroup != null) {
                            this.h = anz.zza((OnClickListener) this, true);
                            if (this.h != null) {
                                this.f.put("1007", new WeakReference(this.h));
                                this.d.put("1007", new WeakReference(this.h));
                                viewGroup.removeAllViews();
                                viewGroup.addView(this.h);
                            }
                        }
                    }
                    anz.a(view2, this.d, this.e, (OnTouchListener) this, (OnClickListener) this);
                    ht.a.post(new aol(this, anz));
                    a(view2);
                    this.g.zzj(view2);
                    synchronized (this.b) {
                        if (this.g instanceof anz) {
                            anz = (anz) this.g;
                            view2 = (View) this.c.get();
                            if (!(anz == null || anz.getContext() == null || view2 == null || !au.B().c(view2.getContext()))) {
                                agc = (agc) this.k.get();
                                if (agc == null) {
                                    agc = new agc(view2.getContext(), view2);
                                    this.k = new WeakReference(agc);
                                }
                                agc.a(anz.d());
                            }
                        }
                    }
                    return;
                }
                kk.c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            kk.e("Not an instance of native engine. This is most likely a transient error");
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper) {
        synchronized (this.b) {
            this.g.setClickConfirmingView((View) c.a(iObjectWrapper));
        }
    }
}
