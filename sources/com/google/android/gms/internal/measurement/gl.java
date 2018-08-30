package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class gl extends fo {
    @VisibleForTesting
    protected gk a;
    private volatile gk b;
    private gk c;
    private long d;
    private final Map<Activity, gk> e = new a();
    private gk f;
    private String g;

    public gl(es esVar) {
        super(esVar);
    }

    @VisibleForTesting
    private static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final void a(Activity activity, gk gkVar, boolean z) {
        gk gkVar2 = this.b == null ? this.c : this.b;
        if (gkVar.b == null) {
            gkVar = new gk(gkVar.a, a(activity.getClass().getCanonicalName()), gkVar.c);
        }
        this.c = this.b;
        this.d = zzbt().elapsedRealtime();
        this.b = gkVar;
        zzgd().a(new gm(this, z, gkVar2, gkVar));
    }

    @WorkerThread
    private final void a(@NonNull gk gkVar) {
        d().a(zzbt().elapsedRealtime());
        if (m().a(gkVar.d)) {
            gkVar.d = false;
        }
    }

    public static void a(gk gkVar, Bundle bundle, boolean z) {
        if (bundle != null && gkVar != null && (!bundle.containsKey("_sc") || z)) {
            if (gkVar.a != null) {
                bundle.putString("_sn", gkVar.a);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", gkVar.b);
            bundle.putLong("_si", gkVar.c);
        } else if (bundle != null && gkVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @MainThread
    private final gk d(@NonNull Activity activity) {
        ar.a((Object) activity);
        gk gkVar = (gk) this.e.get(activity);
        if (gkVar != null) {
            return gkVar;
        }
        gkVar = new gk(null, a(activity.getClass().getCanonicalName()), l().r());
        this.e.put(activity, gkVar);
        return gkVar;
    }

    @MainThread
    public final void a(Activity activity) {
        a(activity, d(activity), false);
        fn d = d();
        d.zzgd().a(new co(d, d.zzbt().elapsedRealtime()));
    }

    @MainThread
    public final void a(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service");
            if (bundle2 != null) {
                this.e.put(activity, new gk(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
            }
        }
    }

    @MainThread
    public final void a(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        zzgd();
        if (!en.r()) {
            zzge().u().a("setCurrentScreen must be called from the main thread");
        } else if (this.b == null) {
            zzge().u().a("setCurrentScreen cannot be called while no activity active");
        } else if (this.e.get(activity) == null) {
            zzge().u().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = a(activity.getClass().getCanonicalName());
            }
            boolean equals = this.b.b.equals(str2);
            boolean b = ie.b(this.b.a, str);
            if (equals && b) {
                zzge().v().a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzge().u().a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                Object obj;
                dr y = zzge().y();
                String str3 = "Setting current screen to name, class";
                if (str == null) {
                    obj = "null";
                } else {
                    String obj2 = str;
                }
                y.a(str3, obj2, str2);
                gk gkVar = new gk(str, str2, l().r());
                this.e.put(activity, gkVar);
                a(activity, gkVar, true);
            } else {
                zzge().u().a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @WorkerThread
    public final void a(String str, gk gkVar) {
        c();
        synchronized (this) {
            if (this.g == null || this.g.equals(str) || gkVar != null) {
                this.g = str;
                this.f = gkVar;
            }
        }
    }

    @MainThread
    public final void b(Activity activity) {
        gk d = d(activity);
        this.c = this.b;
        this.d = zzbt().elapsedRealtime();
        this.b = null;
        zzgd().a(new gn(this, d));
    }

    @MainThread
    public final void b(Activity activity, Bundle bundle) {
        if (bundle != null) {
            gk gkVar = (gk) this.e.get(activity);
            if (gkVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", gkVar.c);
                bundle2.putString("name", gkVar.a);
                bundle2.putString("referrer_name", gkVar.b);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }

    @MainThread
    public final void c(Activity activity) {
        this.e.remove(activity);
    }

    protected final boolean p() {
        return false;
    }

    @WorkerThread
    public final gk r() {
        B();
        c();
        return this.a;
    }

    public final gk s() {
        return this.b;
    }
}
