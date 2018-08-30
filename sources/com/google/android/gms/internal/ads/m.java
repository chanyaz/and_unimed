package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class m {
    private static final Object a = new Object();
    @GuardedBy("sLock")
    @VisibleForTesting
    private static boolean b = false;
    @GuardedBy("sLock")
    @VisibleForTesting
    private static boolean c = false;
    @VisibleForTesting
    private zzatn d;

    @VisibleForTesting
    private final void c(Context context) {
        synchronized (a) {
            if (((Boolean) akc.f().a(amn.dg)).booleanValue() && !c) {
                try {
                    c = true;
                    this.d = pl.a(DynamiteModule.a(context, DynamiteModule.a, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.ads.omid.DynamiteOmid"));
                } catch (Throwable e) {
                    kk.d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:22:?, code:
            return null;
     */
    @android.support.annotation.Nullable
    public final com.google.android.gms.dynamic.IObjectWrapper a(java.lang.String r8, android.webkit.WebView r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
        r7 = this;
        r6 = 0;
        r1 = a;
        monitor-enter(r1);
        r0 = com.google.android.gms.internal.ads.amn.dg;	 Catch:{ all -> 0x002d }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x002d }
        r0 = r2.a(r0);	 Catch:{ all -> 0x002d }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x002d }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x001a;
    L_0x0016:
        r0 = b;	 Catch:{ all -> 0x002d }
        if (r0 != 0) goto L_0x001d;
    L_0x001a:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        r0 = r6;
    L_0x001c:
        return r0;
    L_0x001d:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        r0 = r7.d;	 Catch:{ RemoteException -> 0x0038, NullPointerException -> 0x0030 }
        r2 = com.google.android.gms.dynamic.c.a(r9);	 Catch:{ RemoteException -> 0x0038, NullPointerException -> 0x0030 }
        r1 = r8;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r0 = r0.zza(r1, r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x0038, NullPointerException -> 0x0030 }
        goto L_0x001c;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        throw r0;
    L_0x0030:
        r0 = move-exception;
    L_0x0031:
        r1 = "#007 Could not call remote method.";
        com.google.android.gms.internal.ads.kk.d(r1, r0);
        r0 = r6;
        goto L_0x001c;
    L_0x0038:
        r0 = move-exception;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.m.a(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    public final void a(com.google.android.gms.dynamic.IObjectWrapper r4) {
        /*
        r3 = this;
        r1 = a;
        monitor-enter(r1);
        r0 = com.google.android.gms.internal.ads.amn.dg;	 Catch:{ all -> 0x0029 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0029 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0029 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x0029 }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0019;
    L_0x0015:
        r0 = b;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x001a:
        return;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        r0 = r3.d;	 Catch:{ RemoteException -> 0x0022, NullPointerException -> 0x002c }
        r0.zzm(r4);	 Catch:{ RemoteException -> 0x0022, NullPointerException -> 0x002c }
        goto L_0x001a;
    L_0x0022:
        r0 = move-exception;
    L_0x0023:
        r1 = "#007 Could not call remote method.";
        com.google.android.gms.internal.ads.kk.d(r1, r0);
        goto L_0x001a;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.m.a(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    public final void a(com.google.android.gms.dynamic.IObjectWrapper r4, android.view.View r5) {
        /*
        r3 = this;
        r1 = a;
        monitor-enter(r1);
        r0 = com.google.android.gms.internal.ads.amn.dg;	 Catch:{ all -> 0x002d }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x002d }
        r0 = r2.a(r0);	 Catch:{ all -> 0x002d }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x002d }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x0019;
    L_0x0015:
        r0 = b;	 Catch:{ all -> 0x002d }
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
    L_0x001a:
        return;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        r0 = r3.d;	 Catch:{ RemoteException -> 0x0026, NullPointerException -> 0x0030 }
        r1 = com.google.android.gms.dynamic.c.a(r5);	 Catch:{ RemoteException -> 0x0026, NullPointerException -> 0x0030 }
        r0.zza(r4, r1);	 Catch:{ RemoteException -> 0x0026, NullPointerException -> 0x0030 }
        goto L_0x001a;
    L_0x0026:
        r0 = move-exception;
    L_0x0027:
        r1 = "#007 Could not call remote method.";
        com.google.android.gms.internal.ads.kk.d(r1, r0);
        goto L_0x001a;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        throw r0;
    L_0x0030:
        r0 = move-exception;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.m.a(com.google.android.gms.dynamic.IObjectWrapper, android.view.View):void");
    }

    public final boolean a(Context context) {
        Throwable e;
        synchronized (a) {
            if (!((Boolean) akc.f().a(amn.dg)).booleanValue()) {
                return false;
            } else if (b) {
                return true;
            } else {
                try {
                    c(context);
                    boolean zzy = this.d.zzy(c.a((Object) context));
                    b = zzy;
                    return zzy;
                } catch (RemoteException e2) {
                    e = e2;
                    kk.d("#007 Could not call remote method.", e);
                    return false;
                } catch (NullPointerException e3) {
                    e = e3;
                    kk.d("#007 Could not call remote method.", e);
                    return false;
                }
            }
        }
    }

    @Nullable
    public final String b(Context context) {
        Throwable e;
        if (!((Boolean) akc.f().a(amn.dg)).booleanValue()) {
            return null;
        }
        try {
            c(context);
            String str = "a.";
            String valueOf = String.valueOf(this.d.getVersion());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (RemoteException e2) {
            e = e2;
            kk.d("#007 Could not call remote method.", e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            kk.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    public final void b(com.google.android.gms.dynamic.IObjectWrapper r4) {
        /*
        r3 = this;
        r1 = a;
        monitor-enter(r1);
        r0 = com.google.android.gms.internal.ads.amn.dg;	 Catch:{ all -> 0x0029 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0029 }
        r0 = r2.a(r0);	 Catch:{ all -> 0x0029 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x0029 }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0019;
    L_0x0015:
        r0 = b;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x001a:
        return;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        r0 = r3.d;	 Catch:{ RemoteException -> 0x0022, NullPointerException -> 0x002c }
        r0.zzn(r4);	 Catch:{ RemoteException -> 0x0022, NullPointerException -> 0x002c }
        goto L_0x001a;
    L_0x0022:
        r0 = move-exception;
    L_0x0023:
        r1 = "#007 Could not call remote method.";
        com.google.android.gms.internal.ads.kk.d(r1, r0);
        goto L_0x001a;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.m.b(com.google.android.gms.dynamic.IObjectWrapper):void");
    }
}
