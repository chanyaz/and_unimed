package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class acx implements zzce {
    protected static volatile adn a = null;
    protected MotionEvent b;
    protected LinkedList<MotionEvent> c = new LinkedList();
    protected long d = 0;
    protected long e = 0;
    protected long f = 0;
    protected long g = 0;
    protected long h = 0;
    protected long i = 0;
    protected long j = 0;
    protected double k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected boolean p = false;
    protected DisplayMetrics q;
    private double r;
    private double s;
    private boolean t = false;

    protected acx(Context context) {
        try {
            if (((Boolean) akc.f().a(amn.bL)).booleanValue()) {
                acd.a();
            } else {
                adu.a(a);
            }
            this.q = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    private final String a(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        wr a;
        if (z) {
            try {
                a = a(context, view, activity);
                this.t = true;
            } catch (GeneralSecurityException e) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        }
        a = a(context, null);
        return (a == null || a.d() == 0) ? Integer.toString(5) : acd.a(a, str);
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr);

    protected abstract adv a(MotionEvent motionEvent);

    protected abstract wr a(Context context, View view, Activity activity);

    protected abstract wr a(Context context, tf tfVar);

    public final String zza(Context context) {
        if (adw.a()) {
            if (((Boolean) akc.f().a(amn.bN)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return a(context, null, false, null, null, null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return a(context, str, true, view, activity, null);
    }

    public final void zza(int i, int i2, int i3) {
        if (this.b != null) {
            this.b.recycle();
        }
        if (this.q != null) {
            this.b = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.q.density, ((float) i2) * this.q.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.b = null;
        }
        this.p = false;
    }

    public final void zza(MotionEvent motionEvent) {
        if (this.t) {
            this.g = 0;
            this.f = 0;
            this.e = 0;
            this.d = 0;
            this.h = 0;
            this.j = 0;
            this.i = 0;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.c.clear();
            this.b = null;
            this.t = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.k = 0.0d;
                this.r = (double) motionEvent.getRawX();
                this.s = (double) motionEvent.getRawY();
                break;
            case 1:
            case 2:
                double rawX = (double) motionEvent.getRawX();
                double rawY = (double) motionEvent.getRawY();
                double d = rawX - this.r;
                double d2 = rawY - this.s;
                this.k = Math.sqrt((d * d) + (d2 * d2)) + this.k;
                this.r = rawX;
                this.s = rawY;
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.l = motionEvent.getX();
                this.m = motionEvent.getY();
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                this.d++;
                break;
            case 1:
                this.b = MotionEvent.obtain(motionEvent);
                this.c.add(this.b);
                if (this.c.size() > 6) {
                    ((MotionEvent) this.c.remove()).recycle();
                }
                this.f++;
                try {
                    this.h = a(new Throwable().getStackTrace());
                    break;
                } catch (zzcw e) {
                    break;
                }
            case 2:
                this.e += (long) (motionEvent.getHistorySize() + 1);
                try {
                    adv a = a(motionEvent);
                    Object obj = (a == null || a.d == null || a.g == null) ? null : 1;
                    if (obj != null) {
                        this.i += a.d.longValue() + a.g.longValue();
                    }
                    obj = (this.q == null || a == null || a.e == null || a.h == null) ? null : 1;
                    if (obj != null) {
                        this.j = (a.h.longValue() + a.e.longValue()) + this.j;
                        break;
                    }
                } catch (zzcw e2) {
                    break;
                }
                break;
            case 3:
                this.g++;
                break;
        }
        this.p = true;
    }

    public void zzb(View view) {
    }
}
