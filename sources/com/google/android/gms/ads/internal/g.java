package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.acz;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.hr;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzce;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzadh
public final class g implements zzce, Runnable {
    private final List<Object[]> a;
    private final AtomicReference<zzce> b;
    private Context c;
    private zzang d;
    private CountDownLatch e;

    private g(Context context, zzang zzang) {
        this.a = new Vector();
        this.b = new AtomicReference();
        this.e = new CountDownLatch(1);
        this.c = context;
        this.d = zzang;
        akc.a();
        if (kb.b()) {
            hr.a((Runnable) this);
        } else {
            run();
        }
    }

    public g(av avVar) {
        this(avVar.c, avVar.e);
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean a() {
        try {
            this.e.await();
            return true;
        } catch (Throwable e) {
            kk.c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void b() {
        if (!this.a.isEmpty()) {
            for (Object[] objArr : this.a) {
                if (objArr.length == 1) {
                    ((zzce) this.b.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzce) this.b.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.a.clear();
        }
    }

    public final void run() {
        try {
            boolean z = (((Boolean) akc.f().a(amn.aL)).booleanValue() || (this.d.d ? 1 : null) == null) ? false : true;
            this.b.set(acz.a(this.d.a, a(this.c), z));
        } finally {
            this.e.countDown();
            this.c = null;
            this.d = null;
        }
    }

    public final String zza(Context context) {
        if (a()) {
            zzce zzce = (zzce) this.b.get();
            if (zzce != null) {
                b();
                return zzce.zza(a(context));
            }
        }
        return "";
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        if (a()) {
            zzce zzce = (zzce) this.b.get();
            if (zzce != null) {
                b();
                return zzce.zza(a(context), str, view, activity);
            }
        }
        return "";
    }

    public final void zza(int i, int i2, int i3) {
        zzce zzce = (zzce) this.b.get();
        if (zzce != null) {
            b();
            zzce.zza(i, i2, i3);
            return;
        }
        this.a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zza(MotionEvent motionEvent) {
        zzce zzce = (zzce) this.b.get();
        if (zzce != null) {
            b();
            zzce.zza(motionEvent);
            return;
        }
        this.a.add(new Object[]{motionEvent});
    }

    public final void zzb(View view) {
        zzce zzce = (zzce) this.b.get();
        if (zzce != null) {
            zzce.zzb(view);
        }
    }
}
