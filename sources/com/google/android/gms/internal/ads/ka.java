package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.au;

@zzadh
public final class ka {
    private final View a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private OnGlobalLayoutListener f;
    private OnScrollChangedListener g;

    public ka(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.b = activity;
        this.a = view;
        this.f = onGlobalLayoutListener;
        this.g = onScrollChangedListener;
    }

    private static ViewTreeObserver b(Activity activity) {
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        return decorView != null ? decorView.getViewTreeObserver() : null;
    }

    private final void e() {
        if (!this.c) {
            Activity activity;
            ViewTreeObserver b;
            if (this.f != null) {
                if (this.b != null) {
                    activity = this.b;
                    OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                    b = b(activity);
                    if (b != null) {
                        b.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                au.A();
                lp.a(this.a, this.f);
            }
            if (this.g != null) {
                if (this.b != null) {
                    activity = this.b;
                    OnScrollChangedListener onScrollChangedListener = this.g;
                    b = b(activity);
                    if (b != null) {
                        b.addOnScrollChangedListener(onScrollChangedListener);
                    }
                }
                au.A();
                lp.a(this.a, this.g);
            }
            this.c = true;
        }
    }

    private final void f() {
        if (this.b != null && this.c) {
            Activity activity;
            ViewTreeObserver b;
            if (this.f != null) {
                activity = this.b;
                OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                b = b(activity);
                if (b != null) {
                    au.g().a(b, onGlobalLayoutListener);
                }
            }
            if (this.g != null) {
                activity = this.b;
                OnScrollChangedListener onScrollChangedListener = this.g;
                b = b(activity);
                if (b != null) {
                    b.removeOnScrollChangedListener(onScrollChangedListener);
                }
            }
            this.c = false;
        }
    }

    public final void a() {
        this.e = true;
        if (this.d) {
            e();
        }
    }

    public final void a(Activity activity) {
        this.b = activity;
    }

    public final void b() {
        this.e = false;
        f();
    }

    public final void c() {
        this.d = true;
        if (this.e) {
            e();
        }
    }

    public final void d() {
        this.d = false;
        f();
    }
}
