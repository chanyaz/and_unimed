package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzcc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<FragmentActivity, WeakReference<zzcc>> a = new WeakHashMap();
    private Map<String, LifecycleCallback> b = new a();
    private int c = 0;
    private Bundle d;

    /* JADX WARNING: Missing block: B:3:0x0010, code:
            if (r0 != null) goto L_0x0012;
     */
    public static com.google.android.gms.common.api.internal.zzcc a(android.support.v4.app.FragmentActivity r3) {
        /*
        r0 = a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.zzcc) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.e();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.a(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.common.api.internal.zzcc) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.q();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.common.api.internal.zzcc;
        r0.<init>();
        r1 = r3.e();
        r1 = r1.a();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.a(r0, r2);
        r1.d();
    L_0x003d:
        r1 = a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzcc.a(android.support.v4.app.FragmentActivity):com.google.android.gms.common.api.internal.zzcc");
    }

    public final void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        for (LifecycleCallback a : this.b.values()) {
            a.a(i, i2, intent);
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.b.values()) {
            a.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (this.b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.b.put(str, lifecycleCallback);
        if (this.c > 0) {
            new Handler(Looper.getMainLooper()).post(new bp(this, lifecycleCallback, str));
        }
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        this.c = 1;
        this.d = bundle;
        for (Entry entry : this.b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void c() {
        super.c();
        this.c = 2;
        for (LifecycleCallback b : this.b.values()) {
            b.b();
        }
    }

    public final void d() {
        super.d();
        this.c = 4;
        for (LifecycleCallback d : this.b.values()) {
            d.d();
        }
    }

    public final void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            for (Entry entry : this.b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.b.get(str));
    }

    public final boolean isCreated() {
        return this.c > 0;
    }

    public final boolean isStarted() {
        return this.c >= 2;
    }

    public final void t() {
        super.t();
        this.c = 3;
        for (LifecycleCallback c : this.b.values()) {
            c.c();
        }
    }

    public final void v() {
        super.v();
        this.c = 5;
        for (LifecycleCallback e : this.b.values()) {
            e.e();
        }
    }
}
