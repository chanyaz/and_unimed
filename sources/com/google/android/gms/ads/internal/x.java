package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.ala;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.auh;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.er;
import com.google.android.gms.internal.ads.fs;
import com.google.android.gms.internal.ads.im;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzxq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class x extends ala {
    private static final Object b = new Object();
    @Nullable
    @GuardedBy("sLock")
    private static x c;
    private final Context a;
    private final Object d = new Object();
    private boolean e;
    private zzang f;

    @VisibleForTesting
    private x(Context context, zzang zzang) {
        this.a = context;
        this.f = zzang;
        this.e = false;
    }

    public static x a(Context context, zzang zzang) {
        x xVar;
        synchronized (b) {
            if (c == null) {
                c = new x(context.getApplicationContext(), zzang);
            }
            xVar = c;
        }
        return xVar;
    }

    final /* synthetic */ void a(Runnable runnable) {
        Object obj = this.a;
        ar.b("Adapters must be initialized on the main thread.");
        Map e = au.i().l().h().e();
        if (e != null && !e.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    kk.c("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            er j = er.j();
            if (j != null) {
                String valueOf;
                Collection<aui> values = e.values();
                Map hashMap = new HashMap();
                IObjectWrapper a = c.a(obj);
                for (aui aui : values) {
                    for (auh auh : aui.a) {
                        String str = auh.k;
                        for (String valueOf2 : auh.c) {
                            if (!hashMap.containsKey(valueOf2)) {
                                hashMap.put(valueOf2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(valueOf2)).add(str);
                            }
                        }
                    }
                }
                for (Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        fs a2 = j.a(str2);
                        if (a2 != null) {
                            zzxq a3 = a2.a();
                            if (!a3.isInitialized() && a3.zzms()) {
                                a3.zza(a, a2.b(), (List) entry.getValue());
                                String str3 = "Initialized rewarded video mediation adapter ";
                                valueOf2 = String.valueOf(str2);
                                kk.b(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                            }
                        }
                    } catch (Throwable th2) {
                        kk.c(new StringBuilder(String.valueOf(str2).length() + 56).append("Failed to initialize rewarded video mediation adapter \"").append(str2).append("\"").toString(), th2);
                    }
                }
            }
        }
    }

    public final void setAppMuted(boolean z) {
        au.D().a(z);
    }

    public final void setAppVolume(float f) {
        au.D().a(f);
    }

    public final void zza() {
        synchronized (b) {
            if (this.e) {
                kk.e("Mobile ads is initialized already.");
                return;
            }
            this.e = true;
            amn.a(this.a);
            au.i().a(this.a, this.f);
            au.k().a(this.a);
        }
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        if (!TextUtils.isEmpty(str)) {
            Runnable yVar;
            int i;
            amn.a(this.a);
            int booleanValue = ((Boolean) akc.f().a(amn.cs)).booleanValue() | ((Boolean) akc.f().a(amn.aD)).booleanValue();
            if (((Boolean) akc.f().a(amn.aD)).booleanValue()) {
                yVar = new y(this, (Runnable) c.a(iObjectWrapper));
                i = 1;
            } else {
                yVar = null;
                i = booleanValue;
            }
            if (i != 0) {
                au.m().a(this.a, this.f, str, yVar);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            kk.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) c.a(iObjectWrapper);
        if (context == null) {
            kk.c("Context is null. Failed to open debug menu.");
            return;
        }
        im imVar = new im(context);
        imVar.a(str);
        imVar.b(this.f.a);
        imVar.a();
    }

    public final float zzdo() {
        return au.D().a();
    }

    public final boolean zzdp() {
        return au.D().b();
    }

    public final void zzt(String str) {
        amn.a(this.a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) akc.f().a(amn.cs)).booleanValue()) {
                au.m().a(this.a, this.f, str, null);
            }
        }
    }
}
