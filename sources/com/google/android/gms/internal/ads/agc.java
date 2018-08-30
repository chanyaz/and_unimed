package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzadh
@TargetApi(14)
public final class agc implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long a = ((Long) akc.f().a(amn.bn)).longValue();
    private final Context b;
    private Application c;
    private final WindowManager d;
    private final PowerManager e;
    private final KeyguardManager f;
    @Nullable
    @VisibleForTesting
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private agg j;
    private jq k = new jq(a);
    private boolean l = false;
    private int m = -1;
    private final HashSet<zzft> n = new HashSet();
    private final DisplayMetrics o;
    private final Rect p;

    public agc(Context context, View view) {
        this.b = context.getApplicationContext();
        this.d = (WindowManager) context.getSystemService("window");
        this.e = (PowerManager) this.b.getSystemService("power");
        this.f = (KeyguardManager) context.getSystemService("keyguard");
        if (this.b instanceof Application) {
            this.c = (Application) this.b;
            this.j = new agg((Application) this.b, this);
        }
        this.o = context.getResources().getDisplayMetrics();
        this.p = new Rect();
        this.p.right = this.d.getDefaultDisplay().getWidth();
        this.p.bottom = this.d.getDefaultDisplay().getHeight();
        View view2 = this.i != null ? (View) this.i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            b(view2);
        }
        this.i = new WeakReference(view);
        if (view != null) {
            if (au.g().a(view)) {
                a(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect a(Rect rect) {
        return new Rect(b(rect.left), b(rect.top), b(rect.right), b(rect.bottom));
    }

    private final void a(int i) {
        if (this.n.size() != 0 && this.i != null) {
            View view = (View) this.i.get();
            Object obj = i == 1 ? 1 : null;
            Object obj2 = view == null ? 1 : null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean z = false;
            Rect rect3 = new Rect();
            boolean z2 = false;
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                z = view.getGlobalVisibleRect(rect2);
                z2 = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    kk.b("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.m != -1) {
                windowVisibility = this.m;
            }
            boolean z3 = obj2 == null && au.e().a(view, this.e, this.f) && z && z2 && windowVisibility == 0;
            if (obj != null && !this.k.a() && z3 == this.l) {
                return;
            }
            if (z3 || this.l || i != 1) {
                agf agf = new agf(au.l().elapsedRealtime(), this.e.isScreenOn(), view != null ? au.g().a(view) : false, view != null ? view.getWindowVisibility() : 8, a(this.p), a(rect), a(rect2), z, a(rect3), z2, a(rect4), this.o.density, z3);
                Iterator it = this.n.iterator();
                while (it.hasNext()) {
                    ((zzft) it.next()).zza(agf);
                }
                this.l = z3;
            }
        }
    }

    private final void a(Activity activity, int i) {
        if (this.i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.i.get();
                if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                    this.m = i;
                }
            }
        }
    }

    private final void a(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.g = new age(this);
            au.E().a(this.b, this.g, intentFilter);
        }
        if (this.c != null) {
            try {
                this.c.registerActivityLifecycleCallbacks(this.j);
            } catch (Throwable e) {
                kk.b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final int b(int i) {
        return (int) (((float) i) / this.o.density);
    }

    private final void b() {
        au.e();
        ht.a.post(new agd(this));
    }

    private final void b(View view) {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.h != null) {
                viewTreeObserver = (ViewTreeObserver) this.h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Throwable e) {
            kk.b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this);
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            kk.b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.g != null) {
            try {
                au.E().a(this.b, this.g);
            } catch (Throwable e22) {
                kk.b("Failed trying to unregister the receiver", e22);
            } catch (Throwable e222) {
                au.i().a(e222, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.g = null;
        }
        if (this.c != null) {
            try {
                this.c.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Throwable e2222) {
                kk.b("Error registering activity lifecycle callbacks.", e2222);
            }
        }
    }

    public final void a() {
        a(4);
    }

    public final void a(zzft zzft) {
        this.n.add(zzft);
        a(3);
    }

    public final void b(zzft zzft) {
        this.n.remove(zzft);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        a(3);
        b();
    }

    public final void onActivityDestroyed(Activity activity) {
        a(3);
        b();
    }

    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        a(3);
        b();
    }

    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        a(3);
        b();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(3);
        b();
    }

    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        a(3);
        b();
    }

    public final void onActivityStopped(Activity activity) {
        a(3);
        b();
    }

    public final void onGlobalLayout() {
        a(2);
        b();
    }

    public final void onScrollChanged() {
        a(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.m = -1;
        a(view);
        a(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.m = -1;
        a(3);
        b();
        b(view);
    }
}
