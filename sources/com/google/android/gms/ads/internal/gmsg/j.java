package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.ada;
import java.util.ArrayList;
import java.util.Collection;

@VisibleForTesting
public final class j {
    private final Context a;
    private final ada b;
    private final View c;

    public j(Context context, ada ada, View view) {
        this.a = context;
        this.b = ada;
        this.c = view;
    }

    private static Intent a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    private static Intent a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    @VisibleForTesting
    private final ResolveInfo a(Intent intent) {
        return a(intent, new ArrayList());
    }

    @VisibleForTesting
    private final ResolveInfo a(Intent intent, ArrayList<ResolveInfo> arrayList) {
        Throwable th;
        ResolveInfo resolveInfo;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
                arrayList.addAll(queryIntentActivities);
                return resolveInfo;
            }
            resolveInfo = null;
            try {
                arrayList.addAll(queryIntentActivities);
                return resolveInfo;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            resolveInfo = null;
            th = th4;
            au.i().a(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
            return resolveInfo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a3  */
    @com.google.android.gms.common.util.VisibleForTesting
    public final android.content.Intent a(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r3 = 0;
        r4 = 0;
        r0 = r12.a;
        r1 = "activity";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.ActivityManager) r0;
        r1 = "u";
        r1 = r13.get(r1);
        r1 = (java.lang.String) r1;
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x001b;
    L_0x001a:
        return r3;
    L_0x001b:
        r2 = r12.a;
        r5 = r12.b;
        r6 = r12.c;
        r1 = com.google.android.gms.ads.internal.gmsg.i.a(r2, r5, r1, r6, r3);
        r5 = android.net.Uri.parse(r1);
        r1 = "use_first_package";
        r1 = r13.get(r1);
        r1 = (java.lang.String) r1;
        r7 = java.lang.Boolean.parseBoolean(r1);
        r1 = "use_running_process";
        r1 = r13.get(r1);
        r1 = (java.lang.String) r1;
        r6 = java.lang.Boolean.parseBoolean(r1);
        r1 = "use_custom_tabs";
        r1 = r13.get(r1);
        r1 = (java.lang.String) r1;
        r1 = java.lang.Boolean.parseBoolean(r1);
        if (r1 != 0) goto L_0x0061;
    L_0x004f:
        r1 = com.google.android.gms.internal.ads.amn.cM;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r1 = r2.a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x00a9;
    L_0x0061:
        r1 = 1;
        r2 = r1;
    L_0x0063:
        r1 = "http";
        r8 = r5.getScheme();
        r1 = r1.equalsIgnoreCase(r8);
        if (r1 == 0) goto L_0x00ab;
    L_0x006f:
        r1 = r5.buildUpon();
        r3 = "https";
        r1 = r1.scheme(r3);
        r1 = r1.build();
        r3 = r1;
    L_0x007e:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r5 = a(r5);
        r3 = a(r3);
        if (r2 == 0) goto L_0x009d;
    L_0x008d:
        com.google.android.gms.ads.internal.au.e();
        r2 = r12.a;
        com.google.android.gms.internal.ads.ht.b(r2, r5);
        com.google.android.gms.ads.internal.au.e();
        r2 = r12.a;
        com.google.android.gms.internal.ads.ht.b(r2, r3);
    L_0x009d:
        r2 = r12.a(r5, r1);
        if (r2 == 0) goto L_0x00c7;
    L_0x00a3:
        r3 = a(r5, r2);
        goto L_0x001a;
    L_0x00a9:
        r2 = r4;
        goto L_0x0063;
    L_0x00ab:
        r1 = "https";
        r8 = r5.getScheme();
        r1 = r1.equalsIgnoreCase(r8);
        if (r1 == 0) goto L_0x007e;
    L_0x00b7:
        r1 = r5.buildUpon();
        r3 = "http";
        r1 = r1.scheme(r3);
        r1 = r1.build();
        r3 = r1;
        goto L_0x007e;
    L_0x00c7:
        if (r3 == 0) goto L_0x00d9;
    L_0x00c9:
        r2 = r12.a(r3);
        if (r2 == 0) goto L_0x00d9;
    L_0x00cf:
        r3 = a(r5, r2);
        r2 = r12.a(r3);
        if (r2 != 0) goto L_0x001a;
    L_0x00d9:
        r2 = r1.size();
        if (r2 != 0) goto L_0x00e2;
    L_0x00df:
        r3 = r5;
        goto L_0x001a;
    L_0x00e2:
        if (r6 == 0) goto L_0x0122;
    L_0x00e4:
        if (r0 == 0) goto L_0x0122;
    L_0x00e6:
        r8 = r0.getRunningAppProcesses();
        if (r8 == 0) goto L_0x0122;
    L_0x00ec:
        r0 = r1;
        r0 = (java.util.ArrayList) r0;
        r9 = r0.size();
        r3 = r4;
    L_0x00f4:
        if (r3 >= r9) goto L_0x0122;
    L_0x00f6:
        r2 = r0.get(r3);
        r6 = r3 + 1;
        r2 = (android.content.pm.ResolveInfo) r2;
        r10 = r8.iterator();
    L_0x0102:
        r3 = r10.hasNext();
        if (r3 == 0) goto L_0x0120;
    L_0x0108:
        r3 = r10.next();
        r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3;
        r3 = r3.processName;
        r11 = r2.activityInfo;
        r11 = r11.packageName;
        r3 = r3.equals(r11);
        if (r3 == 0) goto L_0x0102;
    L_0x011a:
        r3 = a(r5, r2);
        goto L_0x001a;
    L_0x0120:
        r3 = r6;
        goto L_0x00f4;
    L_0x0122:
        if (r7 == 0) goto L_0x0130;
    L_0x0124:
        r0 = r1.get(r4);
        r0 = (android.content.pm.ResolveInfo) r0;
        r3 = a(r5, r0);
        goto L_0x001a;
    L_0x0130:
        r3 = r5;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.j.a(java.util.Map):android.content.Intent");
    }
}
