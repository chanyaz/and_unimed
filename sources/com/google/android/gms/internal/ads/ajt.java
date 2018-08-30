package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.appnext.base.b.c;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public class ajt {
    @GuardedBy("mLock")
    private zzld a;
    private final Object b = new Object();
    private final ajm c;
    private final ajl d;
    private final alo e;
    private final apz f;
    private final fe g;
    private final n h;
    private final aqa i;

    public ajt(ajm ajm, ajl ajl, alo alo, apz apz, fe feVar, n nVar, aqa aqa) {
        this.c = ajm;
        this.d = ajl;
        this.e = alo;
        this.f = apz;
        this.g = feVar;
        this.h = nVar;
        this.i = aqa;
    }

    @Nullable
    private static zzld a() {
        try {
            Object newInstance = ajt.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return akw.asInterface((IBinder) newInstance);
            }
            kk.e("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            kk.c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    @VisibleForTesting
    static <T> T a(Context context, boolean z, aju<T> aju) {
        Object obj = 1;
        Object obj2 = z ? 1 : null;
        if (obj2 == null) {
            akc.a();
            if (!kb.c(context)) {
                kk.b("Google Play Services is not available");
                obj2 = 1;
            }
        }
        akc.a();
        int e = kb.e(context);
        akc.a();
        if (e <= kb.d(context)) {
            obj = obj2;
        }
        amn.a(context);
        if (((Boolean) akc.f().a(amn.de)).booleanValue()) {
            obj = null;
        }
        T b;
        if (obj != null) {
            b = aju.b();
            return b == null ? aju.c() : b;
        } else {
            b = aju.c();
            return b == null ? aju.b() : b;
        }
    }

    private static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(c.jD, "no_ads_fallback");
        bundle.putString("flow", str);
        akc.a().a(context, null, "gmob-apps", bundle, true);
    }

    @Nullable
    private final zzld b() {
        zzld zzld;
        synchronized (this.b) {
            if (this.a == null) {
                this.a = a();
            }
            zzld = this.a;
        }
        return zzld;
    }

    @Nullable
    public final zzaap a(Activity activity) {
        boolean z = false;
        String str = "com.google.android.gms.ads.internal.overlay.useClientJar";
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            z = intent.getBooleanExtra(str, false);
        } else {
            kk.c("useClientJar flag not found in activity intent extras.");
        }
        return (zzaap) a((Context) activity, z, new akb(this, activity));
    }

    public final zzkn a(Context context, String str, zzxn zzxn) {
        return (zzkn) a(context, false, new ajy(this, context, str, zzxn));
    }

    public final zzqa a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzqa) a(context, false, new ajz(this, frameLayout, frameLayout2, context));
    }
}
