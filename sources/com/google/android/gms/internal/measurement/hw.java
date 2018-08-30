package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class hw implements zzec {
    em a;
    dt b;
    long c;
    private cv d;
    private dx e;
    private hs f;
    private cr g;
    private es h;
    private boolean i = false;
    private boolean j;
    @VisibleForTesting
    private long k;
    private List<Runnable> l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private FileLock r;
    private FileChannel s;
    private List<Long> t;
    private List<Long> u;

    @WorkerThread
    @VisibleForTesting
    private final int a(FileChannel fileChannel) {
        int i = 0;
        s();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().r().a("Bad channel to read from");
            return i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            } else if (read == -1) {
                return i;
            } else {
                zzge().u().a("Unexpected data length. Bytes read", Integer.valueOf(read));
                return i;
            }
        } catch (IOException e) {
            zzge().r().a("Failed to read from channel", e);
            return i;
        }
    }

    private final zzdz a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j) {
        Object charSequence;
        String str3 = "Unknown";
        String str4 = "Unknown";
        int i = Integer.MIN_VALUE;
        String str5 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzge().r().a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str3 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            zzge().r().a("Error retrieving installer package name. appId", dp.a(str));
        }
        if (str3 == null) {
            str3 = "manual_install";
        } else if ("com.android.vending".equals(str3)) {
            str3 = "";
        }
        try {
            PackageInfo b = c.b(context).b(str, 0);
            if (b != null) {
                CharSequence b2 = c.b(context).b(str);
                if (TextUtils.isEmpty(b2)) {
                    String charSequence2 = str5;
                } else {
                    charSequence2 = b2.toString();
                }
                try {
                    str4 = b.versionName;
                    i = b.versionCode;
                } catch (NameNotFoundException e2) {
                    zzge().r().a("Error retrieving newly installed package info. appId, appName", dp.a(str), charSequence2);
                    return null;
                }
            }
            long j2 = 0;
            if (b().j(str)) {
                j2 = j;
            }
            return new zzdz(str, str2, str4, (long) i, str3, 12451, k().b(context, str), null, z, false, "", 0, j2, 0, z2, z3, false);
        } catch (NameNotFoundException e3) {
            charSequence2 = str5;
            zzge().r().a("Error retrieving newly installed package info. appId, appName", dp.a(str), charSequence2);
            return null;
        }
    }

    @WorkerThread
    private final void a(cp cpVar) {
        s();
        if (TextUtils.isEmpty(cpVar.d())) {
            a(cpVar.b(), 204, null, null, null);
            return;
        }
        String d = cpVar.d();
        String c = cpVar.c();
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) dg.f.b()).encodedAuthority((String) dg.g.b());
        String str = "config/app/";
        String valueOf = String.valueOf(d);
        encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", c).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            Map map;
            URL url = new URL(uri);
            zzge().y().a("Fetching remote configuration", cpVar.b());
            io a = d().a(cpVar.b());
            CharSequence b = d().b(cpVar.b());
            if (a == null || TextUtils.isEmpty(b)) {
                map = null;
            } else {
                Map aVar = new a();
                aVar.put("If-Modified-Since", b);
                map = aVar;
            }
            this.o = true;
            fn y = y();
            c = cpVar.b();
            Object hyVar = new hy(this);
            y.c();
            y.J();
            ar.a((Object) url);
            ar.a(hyVar);
            y.zzgd().b(new dw(y, c, url, null, map, hyVar));
        } catch (MalformedURLException e) {
            zzge().r().a("Failed to parse config URL. Not fetching. appId", dp.a(cpVar.b()), uri);
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean a(int i, FileChannel fileChannel) {
        s();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().r().a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzge().r().a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzge().r().a("Failed to write to channel", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x0533 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0bb2 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0350 A:{Catch:{ IOException -> 0x02b5, all -> 0x01b8 }} */
    /* JADX WARNING: Missing block: B:139:0x0375, code:
            if (com.google.android.gms.internal.measurement.ie.k(r12.d) != false) goto L_0x0377;
     */
    @android.support.annotation.WorkerThread
    private final boolean a(java.lang.String r31, long r32) {
        /*
        r30 = this;
        r2 = r30.z();
        r2.q();
        r21 = new com.google.android.gms.internal.measurement.ia;	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r0 = r21;
        r1 = r30;
        r0.<init>(r1, r2);	 Catch:{ all -> 0x01b8 }
        r14 = r30.z();	 Catch:{ all -> 0x01b8 }
        r4 = 0;
        r0 = r30;
        r0 = r0.c;	 Catch:{ all -> 0x01b8 }
        r16 = r0;
        com.google.android.gms.common.internal.ar.a(r21);	 Catch:{ all -> 0x01b8 }
        r14.c();	 Catch:{ all -> 0x01b8 }
        r14.J();	 Catch:{ all -> 0x01b8 }
        r3 = 0;
        r2 = r14.t();	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = 0;
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        if (r5 == 0) goto L_0x01c1;
    L_0x0031:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x015a;
    L_0x0037:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r32);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = r5;
    L_0x0049:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x0167;
    L_0x004f:
        r5 = "rowid <= ? and ";
    L_0x0051:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = r7 + 148;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0bc6 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = "select app_id, metadata_fingerprint from raw_events where ";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0bc6 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0bc6 }
        if (r5 != 0) goto L_0x016b;
    L_0x007e:
        if (r3 == 0) goto L_0x0083;
    L_0x0080:
        r3.close();	 Catch:{ all -> 0x01b8 }
    L_0x0083:
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0093;
    L_0x0089:
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0354;
    L_0x0093:
        r2 = 1;
    L_0x0094:
        if (r2 != 0) goto L_0x0bb2;
    L_0x0096:
        r17 = 0;
        r0 = r21;
        r0 = r0.a;	 Catch:{ all -> 0x01b8 }
        r22 = r0;
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r2 = r2.size();	 Catch:{ all -> 0x01b8 }
        r2 = new com.google.android.gms.internal.measurement.ir[r2];	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.d = r2;	 Catch:{ all -> 0x01b8 }
        r13 = 0;
        r14 = 0;
        r2 = r30.b();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.q;	 Catch:{ all -> 0x01b8 }
        r18 = r2.e(r3);	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r16 = r2;
    L_0x00be:
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r2 = r2.size();	 Catch:{ all -> 0x01b8 }
        r0 = r16;
        if (r0 >= r2) goto L_0x05c0;
    L_0x00ca:
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r0 = r16;
        r2 = r2.get(r0);	 Catch:{ all -> 0x01b8 }
        r0 = r2;
        r0 = (com.google.android.gms.internal.measurement.ir) r0;	 Catch:{ all -> 0x01b8 }
        r12 = r0;
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r4 = r12.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x035a;
    L_0x00ea:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Dropping blacklisted raw event. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r5 = r30.l();	 Catch:{ all -> 0x01b8 }
        r6 = r12.d;	 Catch:{ all -> 0x01b8 }
        r5 = r5.a(r6);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4, r5);	 Catch:{ all -> 0x01b8 }
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r2 = r2.e(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x012b;
    L_0x011b:
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r2 = r2.f(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0357;
    L_0x012b:
        r2 = 1;
    L_0x012c:
        if (r2 != 0) goto L_0x0be6;
    L_0x012e:
        r2 = "_err";
        r3 = r12.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0be6;
    L_0x0138:
        r2 = r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r4 = 11;
        r5 = "_ev";
        r6 = r12.d;	 Catch:{ all -> 0x01b8 }
        r7 = 0;
        r2.a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x01b8 }
        r2 = r14;
        r4 = r13;
        r5 = r17;
    L_0x0150:
        r6 = r16 + 1;
        r16 = r6;
        r14 = r2;
        r13 = r4;
        r17 = r5;
        goto L_0x00be;
    L_0x015a:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r32);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = r5;
        goto L_0x0049;
    L_0x0167:
        r5 = "";
        goto L_0x0051;
    L_0x016b:
        r5 = 0;
        r4 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r3.close();	 Catch:{ SQLiteException -> 0x0bc6 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
    L_0x017b:
        r3 = "raw_events_metadata";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r5 = 0;
        r6 = "metadata";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 0;
        r6[r7] = r12;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 1;
        r6[r7] = r13;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = "2";
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        if (r3 != 0) goto L_0x022b;
    L_0x01a0:
        r2 = r14.zzge();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r2 = r2.r();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = "Raw event metadata record is missing. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r2.a(r3, r4);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        if (r11 == 0) goto L_0x0083;
    L_0x01b3:
        r11.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x01b8:
        r2 = move-exception;
        r3 = r30.z();
        r3.s();
        throw r2;
    L_0x01c1:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x0212;
    L_0x01c7:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = r5;
    L_0x01d6:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x021b;
    L_0x01dc:
        r5 = " and rowid <= ?";
    L_0x01de:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = r7 + 84;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0bc6 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = "select metadata_fingerprint from raw_events where app_id = ?";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r7 = " order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0bc6 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0bc6 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0bc6 }
        if (r5 != 0) goto L_0x021e;
    L_0x020b:
        if (r3 == 0) goto L_0x0083;
    L_0x020d:
        r3.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x0212:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0bc6 }
        r6 = r5;
        goto L_0x01d6;
    L_0x021b:
        r5 = "";
        goto L_0x01de;
    L_0x021e:
        r5 = 0;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0bc6 }
        r3.close();	 Catch:{ SQLiteException -> 0x0bc6 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
        goto L_0x017b;
    L_0x022b:
        r3 = 0;
        r3 = r11.getBlob(r3);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4 = 0;
        r5 = r3.length;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = com.google.android.gms.internal.measurement.h.a(r3, r4, r5);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4 = new com.google.android.gms.internal.measurement.iu;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4.a(r3);	 Catch:{ IOException -> 0x02b5 }
        r3 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        if (r3 == 0) goto L_0x0255;
    L_0x0244:
        r3 = r14.zzge();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = r3.u();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r5 = "Get multiple raw event metadata records, expected one. appId";
        r6 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3.a(r5, r6);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
    L_0x0255:
        r11.close();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r0 = r21;
        r0.zzb(r4);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4 = -1;
        r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r3 == 0) goto L_0x02ce;
    L_0x0263:
        r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r3 = 3;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = 2;
        r4 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r6[r3] = r4;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
    L_0x0275:
        r3 = "raw_events";
        r4 = 4;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 0;
        r8 = "rowid";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 1;
        r8 = "name";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 2;
        r8 = "timestamp";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 3;
        r8 = "data";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0bc9 }
        if (r2 != 0) goto L_0x02f5;
    L_0x029d:
        r2 = r14.zzge();	 Catch:{ SQLiteException -> 0x0bc9 }
        r2 = r2.u();	 Catch:{ SQLiteException -> 0x0bc9 }
        r4 = "Raw event data disappeared while in transaction. appId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x0bc9 }
        r2.a(r4, r5);	 Catch:{ SQLiteException -> 0x0bc9 }
        if (r3 == 0) goto L_0x0083;
    L_0x02b0:
        r3.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x02b5:
        r2 = move-exception;
        r3 = r14.zzge();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = r3.r();	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r4 = "Data loss. Failed to merge raw event metadata. appId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3.a(r4, r5, r2);	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        if (r11 == 0) goto L_0x0083;
    L_0x02c9:
        r11.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x02ce:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r3 = 2;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        goto L_0x0275;
    L_0x02da:
        r2 = move-exception;
        r3 = r11;
        r4 = r12;
    L_0x02dd:
        r5 = r14.zzge();	 Catch:{ all -> 0x034d }
        r5 = r5.r();	 Catch:{ all -> 0x034d }
        r6 = "Data loss. Error selecting raw event. appId";
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x034d }
        r5.a(r6, r4, r2);	 Catch:{ all -> 0x034d }
        if (r3 == 0) goto L_0x0083;
    L_0x02f0:
        r3.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x02f5:
        r2 = 0;
        r4 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0bc9 }
        r2 = 3;
        r2 = r3.getBlob(r2);	 Catch:{ SQLiteException -> 0x0bc9 }
        r6 = 0;
        r7 = r2.length;	 Catch:{ SQLiteException -> 0x0bc9 }
        r2 = com.google.android.gms.internal.measurement.h.a(r2, r6, r7);	 Catch:{ SQLiteException -> 0x0bc9 }
        r6 = new com.google.android.gms.internal.measurement.ir;	 Catch:{ SQLiteException -> 0x0bc9 }
        r6.<init>();	 Catch:{ SQLiteException -> 0x0bc9 }
        r6.a(r2);	 Catch:{ IOException -> 0x032e }
        r2 = 1;
        r2 = r3.getString(r2);	 Catch:{ SQLiteException -> 0x0bc9 }
        r6.d = r2;	 Catch:{ SQLiteException -> 0x0bc9 }
        r2 = 2;
        r8 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0bc9 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0bc9 }
        r6.e = r2;	 Catch:{ SQLiteException -> 0x0bc9 }
        r0 = r21;
        r2 = r0.zza(r4, r6);	 Catch:{ SQLiteException -> 0x0bc9 }
        if (r2 != 0) goto L_0x0340;
    L_0x0327:
        if (r3 == 0) goto L_0x0083;
    L_0x0329:
        r3.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x032e:
        r2 = move-exception;
        r4 = r14.zzge();	 Catch:{ SQLiteException -> 0x0bc9 }
        r4 = r4.r();	 Catch:{ SQLiteException -> 0x0bc9 }
        r5 = "Data loss. Failed to merge raw event. appId";
        r6 = com.google.android.gms.internal.measurement.dp.a(r12);	 Catch:{ SQLiteException -> 0x0bc9 }
        r4.a(r5, r6, r2);	 Catch:{ SQLiteException -> 0x0bc9 }
    L_0x0340:
        r2 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0bc9 }
        if (r2 != 0) goto L_0x02f5;
    L_0x0346:
        if (r3 == 0) goto L_0x0083;
    L_0x0348:
        r3.close();	 Catch:{ all -> 0x01b8 }
        goto L_0x0083;
    L_0x034d:
        r2 = move-exception;
    L_0x034e:
        if (r3 == 0) goto L_0x0353;
    L_0x0350:
        r3.close();	 Catch:{ all -> 0x01b8 }
    L_0x0353:
        throw r2;	 Catch:{ all -> 0x01b8 }
    L_0x0354:
        r2 = 0;
        goto L_0x0094;
    L_0x0357:
        r2 = 0;
        goto L_0x012c;
    L_0x035a:
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r4 = r12.d;	 Catch:{ all -> 0x01b8 }
        r19 = r2.b(r3, r4);	 Catch:{ all -> 0x01b8 }
        if (r19 != 0) goto L_0x0377;
    L_0x036c:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r2 = r12.d;	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.k(r2);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0590;
    L_0x0377:
        r4 = 0;
        r3 = 0;
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0382;
    L_0x037d:
        r2 = 0;
        r2 = new com.google.android.gms.internal.measurement.is[r2];	 Catch:{ all -> 0x01b8 }
        r12.c = r2;	 Catch:{ all -> 0x01b8 }
    L_0x0382:
        r6 = r12.c;	 Catch:{ all -> 0x01b8 }
        r7 = r6.length;	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r5 = r2;
    L_0x0387:
        if (r5 >= r7) goto L_0x03be;
    L_0x0389:
        r2 = r6[r5];	 Catch:{ all -> 0x01b8 }
        r8 = "_c";
        r9 = r2.c;	 Catch:{ all -> 0x01b8 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01b8 }
        if (r8 == 0) goto L_0x03a9;
    L_0x0395:
        r8 = 1;
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01b8 }
        r2.e = r4;	 Catch:{ all -> 0x01b8 }
        r2 = 1;
        r29 = r3;
        r3 = r2;
        r2 = r29;
    L_0x03a3:
        r4 = r5 + 1;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0387;
    L_0x03a9:
        r8 = "_r";
        r9 = r2.c;	 Catch:{ all -> 0x01b8 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01b8 }
        if (r8 == 0) goto L_0x0be2;
    L_0x03b3:
        r8 = 1;
        r3 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01b8 }
        r2.e = r3;	 Catch:{ all -> 0x01b8 }
        r2 = 1;
        r3 = r4;
        goto L_0x03a3;
    L_0x03be:
        if (r4 != 0) goto L_0x03fe;
    L_0x03c0:
        if (r19 == 0) goto L_0x03fe;
    L_0x03c2:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.y();	 Catch:{ all -> 0x01b8 }
        r4 = "Marking event as conversion";
        r5 = r30.l();	 Catch:{ all -> 0x01b8 }
        r6 = r12.d;	 Catch:{ all -> 0x01b8 }
        r5 = r5.a(r6);	 Catch:{ all -> 0x01b8 }
        r2.a(r4, r5);	 Catch:{ all -> 0x01b8 }
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        r4 = r12.c;	 Catch:{ all -> 0x01b8 }
        r4 = r4.length;	 Catch:{ all -> 0x01b8 }
        r4 = r4 + 1;
        r2 = java.util.Arrays.copyOf(r2, r4);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.is[]) r2;	 Catch:{ all -> 0x01b8 }
        r4 = new com.google.android.gms.internal.measurement.is;	 Catch:{ all -> 0x01b8 }
        r4.<init>();	 Catch:{ all -> 0x01b8 }
        r5 = "_c";
        r4.c = r5;	 Catch:{ all -> 0x01b8 }
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r4.e = r5;	 Catch:{ all -> 0x01b8 }
        r5 = r2.length;	 Catch:{ all -> 0x01b8 }
        r5 = r5 + -1;
        r2[r5] = r4;	 Catch:{ all -> 0x01b8 }
        r12.c = r2;	 Catch:{ all -> 0x01b8 }
    L_0x03fe:
        if (r3 != 0) goto L_0x043c;
    L_0x0400:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.y();	 Catch:{ all -> 0x01b8 }
        r3 = "Marking event as real-time";
        r4 = r30.l();	 Catch:{ all -> 0x01b8 }
        r5 = r12.d;	 Catch:{ all -> 0x01b8 }
        r4 = r4.a(r5);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        r3 = r12.c;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        r3 = r3 + 1;
        r2 = java.util.Arrays.copyOf(r2, r3);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.is[]) r2;	 Catch:{ all -> 0x01b8 }
        r3 = new com.google.android.gms.internal.measurement.is;	 Catch:{ all -> 0x01b8 }
        r3.<init>();	 Catch:{ all -> 0x01b8 }
        r4 = "_r";
        r3.c = r4;	 Catch:{ all -> 0x01b8 }
        r4 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01b8 }
        r3.e = r4;	 Catch:{ all -> 0x01b8 }
        r4 = r2.length;	 Catch:{ all -> 0x01b8 }
        r4 = r4 + -1;
        r2[r4] = r3;	 Catch:{ all -> 0x01b8 }
        r12.c = r2;	 Catch:{ all -> 0x01b8 }
    L_0x043c:
        r2 = 1;
        r3 = r30.z();	 Catch:{ all -> 0x01b8 }
        r4 = r30.g();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r6 = r0.a;	 Catch:{ all -> 0x01b8 }
        r6 = r6.q;	 Catch:{ all -> 0x01b8 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r3 = r3.a(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x01b8 }
        r4 = r3.e;	 Catch:{ all -> 0x01b8 }
        r3 = r30.b();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r6 = r0.a;	 Catch:{ all -> 0x01b8 }
        r6 = r6.q;	 Catch:{ all -> 0x01b8 }
        r3 = r3.a(r6);	 Catch:{ all -> 0x01b8 }
        r6 = (long) r3;	 Catch:{ all -> 0x01b8 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0bde;
    L_0x0469:
        r2 = 0;
    L_0x046a:
        r3 = r12.c;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        if (r2 >= r3) goto L_0x049b;
    L_0x046f:
        r3 = "_r";
        r4 = r12.c;	 Catch:{ all -> 0x01b8 }
        r4 = r4[r2];	 Catch:{ all -> 0x01b8 }
        r4 = r4.c;	 Catch:{ all -> 0x01b8 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x01b8 }
        if (r3 == 0) goto L_0x0506;
    L_0x047d:
        r3 = r12.c;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        r3 = r3 + -1;
        r3 = new com.google.android.gms.internal.measurement.is[r3];	 Catch:{ all -> 0x01b8 }
        if (r2 <= 0) goto L_0x048d;
    L_0x0486:
        r4 = r12.c;	 Catch:{ all -> 0x01b8 }
        r5 = 0;
        r6 = 0;
        java.lang.System.arraycopy(r4, r5, r3, r6, r2);	 Catch:{ all -> 0x01b8 }
    L_0x048d:
        r4 = r3.length;	 Catch:{ all -> 0x01b8 }
        if (r2 >= r4) goto L_0x0499;
    L_0x0490:
        r4 = r12.c;	 Catch:{ all -> 0x01b8 }
        r5 = r2 + 1;
        r6 = r3.length;	 Catch:{ all -> 0x01b8 }
        r6 = r6 - r2;
        java.lang.System.arraycopy(r4, r5, r3, r2, r6);	 Catch:{ all -> 0x01b8 }
    L_0x0499:
        r12.c = r3;	 Catch:{ all -> 0x01b8 }
    L_0x049b:
        r2 = r12.d;	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0590;
    L_0x04a3:
        if (r19 == 0) goto L_0x0590;
    L_0x04a5:
        r3 = r30.z();	 Catch:{ all -> 0x01b8 }
        r4 = r30.g();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r2 = r0.a;	 Catch:{ all -> 0x01b8 }
        r6 = r2.q;	 Catch:{ all -> 0x01b8 }
        r7 = 0;
        r8 = 0;
        r9 = 1;
        r10 = 0;
        r11 = 0;
        r2 = r3.a(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x01b8 }
        r2 = r2.c;	 Catch:{ all -> 0x01b8 }
        r4 = r30.b();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r5 = r0.a;	 Catch:{ all -> 0x01b8 }
        r5 = r5.q;	 Catch:{ all -> 0x01b8 }
        r6 = com.google.android.gms.internal.measurement.dg.o;	 Catch:{ all -> 0x01b8 }
        r4 = r4.b(r5, r6);	 Catch:{ all -> 0x01b8 }
        r4 = (long) r4;	 Catch:{ all -> 0x01b8 }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0590;
    L_0x04d3:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Too many conversions. Not logging as conversion. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        r4 = 0;
        r3 = 0;
        r6 = r12.c;	 Catch:{ all -> 0x01b8 }
        r7 = r6.length;	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r5 = r2;
    L_0x04f1:
        if (r5 >= r7) goto L_0x051b;
    L_0x04f3:
        r2 = r6[r5];	 Catch:{ all -> 0x01b8 }
        r8 = "_c";
        r9 = r2.c;	 Catch:{ all -> 0x01b8 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01b8 }
        if (r8 == 0) goto L_0x050a;
    L_0x04ff:
        r3 = r4;
    L_0x0500:
        r4 = r5 + 1;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x04f1;
    L_0x0506:
        r2 = r2 + 1;
        goto L_0x046a;
    L_0x050a:
        r8 = "_err";
        r2 = r2.c;	 Catch:{ all -> 0x01b8 }
        r2 = r8.equals(r2);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0bda;
    L_0x0514:
        r2 = 1;
        r29 = r3;
        r3 = r2;
        r2 = r29;
        goto L_0x0500;
    L_0x051b:
        if (r4 == 0) goto L_0x0568;
    L_0x051d:
        if (r3 == 0) goto L_0x0568;
    L_0x051f:
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        r4 = 1;
        r4 = new com.google.android.gms.internal.measurement.is[r4];	 Catch:{ all -> 0x01b8 }
        r5 = 0;
        r4[r5] = r3;	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.common.util.b.a(r2, r4);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.is[]) r2;	 Catch:{ all -> 0x01b8 }
        r12.c = r2;	 Catch:{ all -> 0x01b8 }
        r5 = r17;
    L_0x0531:
        if (r18 == 0) goto L_0x0bd7;
    L_0x0533:
        r2 = "_e";
        r3 = r12.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0bd7;
    L_0x053d:
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0546;
    L_0x0541:
        r2 = r12.c;	 Catch:{ all -> 0x01b8 }
        r2 = r2.length;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0593;
    L_0x0546:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Engagement event does not contain any parameters. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        r2 = r14;
    L_0x055e:
        r0 = r22;
        r6 = r0.d;	 Catch:{ all -> 0x01b8 }
        r4 = r13 + 1;
        r6[r13] = r12;	 Catch:{ all -> 0x01b8 }
        goto L_0x0150;
    L_0x0568:
        if (r3 == 0) goto L_0x0579;
    L_0x056a:
        r2 = "_err";
        r3.c = r2;	 Catch:{ all -> 0x01b8 }
        r4 = 10;
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01b8 }
        r3.e = r2;	 Catch:{ all -> 0x01b8 }
        r5 = r17;
        goto L_0x0531;
    L_0x0579:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.r();	 Catch:{ all -> 0x01b8 }
        r3 = "Did not find conversion parameter. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
    L_0x0590:
        r5 = r17;
        goto L_0x0531;
    L_0x0593:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r2 = "_et";
        r2 = com.google.android.gms.internal.measurement.ie.b(r12, r2);	 Catch:{ all -> 0x01b8 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x05b9;
    L_0x05a0:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Engagement event does not include duration. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        r2 = r14;
        goto L_0x055e;
    L_0x05b9:
        r2 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r14 = r14 + r2;
        r2 = r14;
        goto L_0x055e;
    L_0x05c0:
        r0 = r21;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r2 = r2.size();	 Catch:{ all -> 0x01b8 }
        if (r13 >= r2) goto L_0x05d8;
    L_0x05ca:
        r0 = r22;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = java.util.Arrays.copyOf(r2, r13);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.ir[]) r2;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.d = r2;	 Catch:{ all -> 0x01b8 }
    L_0x05d8:
        if (r18 == 0) goto L_0x0687;
    L_0x05da:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.q;	 Catch:{ all -> 0x01b8 }
        r4 = "_lte";
        r8 = r2.c(r3, r4);	 Catch:{ all -> 0x01b8 }
        if (r8 == 0) goto L_0x05ee;
    L_0x05ea:
        r2 = r8.e;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0763;
    L_0x05ee:
        r2 = new com.google.android.gms.internal.measurement.id;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.q;	 Catch:{ all -> 0x01b8 }
        r4 = "auto";
        r5 = "_lte";
        r6 = r30.zzbt();	 Catch:{ all -> 0x01b8 }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x01b8 }
        r8 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x01b8 }
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x01b8 }
        r4 = r2;
    L_0x0608:
        r5 = new com.google.android.gms.internal.measurement.iw;	 Catch:{ all -> 0x01b8 }
        r5.<init>();	 Catch:{ all -> 0x01b8 }
        r2 = "_lte";
        r5.d = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r30.zzbt();	 Catch:{ all -> 0x01b8 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x01b8 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r5.c = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r4.e;	 Catch:{ all -> 0x01b8 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01b8 }
        r5.f = r2;	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r3 = 0;
    L_0x0627:
        r0 = r22;
        r6 = r0.e;	 Catch:{ all -> 0x01b8 }
        r6 = r6.length;	 Catch:{ all -> 0x01b8 }
        if (r3 >= r6) goto L_0x0645;
    L_0x062e:
        r6 = "_lte";
        r0 = r22;
        r7 = r0.e;	 Catch:{ all -> 0x01b8 }
        r7 = r7[r3];	 Catch:{ all -> 0x01b8 }
        r7 = r7.d;	 Catch:{ all -> 0x01b8 }
        r6 = r6.equals(r7);	 Catch:{ all -> 0x01b8 }
        if (r6 == 0) goto L_0x0788;
    L_0x063e:
        r0 = r22;
        r2 = r0.e;	 Catch:{ all -> 0x01b8 }
        r2[r3] = r5;	 Catch:{ all -> 0x01b8 }
        r2 = 1;
    L_0x0645:
        if (r2 != 0) goto L_0x066b;
    L_0x0647:
        r0 = r22;
        r2 = r0.e;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.e;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        r3 = r3 + 1;
        r2 = java.util.Arrays.copyOf(r2, r3);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.iw[]) r2;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.e = r2;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r2 = r0.e;	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.e;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        r3 = r3 + -1;
        r2[r3] = r5;	 Catch:{ all -> 0x01b8 }
    L_0x066b:
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0687;
    L_0x0671:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2.a(r4);	 Catch:{ all -> 0x01b8 }
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.x();	 Catch:{ all -> 0x01b8 }
        r3 = "Updated lifetime engagement user property with value. Value";
        r4 = r4.e;	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
    L_0x0687:
        r0 = r22;
        r2 = r0.q;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.e;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r0 = r30;
        r2 = r0.a(r2, r3, r4);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.C = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r30.b();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r2 = r2.d(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x09c6;
    L_0x06ad:
        r23 = new java.util.HashMap;	 Catch:{ all -> 0x01b8 }
        r23.<init>();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.length;	 Catch:{ all -> 0x01b8 }
        r0 = new com.google.android.gms.internal.measurement.ir[r2];	 Catch:{ all -> 0x01b8 }
        r24 = r0;
        r18 = 0;
        r2 = r30.k();	 Catch:{ all -> 0x01b8 }
        r25 = r2.s();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0 = r0.d;	 Catch:{ all -> 0x01b8 }
        r26 = r0;
        r0 = r26;
        r0 = r0.length;	 Catch:{ all -> 0x01b8 }
        r27 = r0;
        r2 = 0;
        r19 = r2;
    L_0x06d3:
        r0 = r19;
        r1 = r27;
        if (r0 >= r1) goto L_0x098d;
    L_0x06d9:
        r28 = r26[r19];	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r3 = "_ep";
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x078c;
    L_0x06e7:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r2 = "_en";
        r0 = r28;
        r2 = com.google.android.gms.internal.measurement.ie.b(r0, r2);	 Catch:{ all -> 0x01b8 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r3 = r0.get(r2);	 Catch:{ all -> 0x01b8 }
        r3 = (com.google.android.gms.internal.measurement.dc) r3;	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x0711;
    L_0x06fe:
        r3 = r30.z();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r3 = r3.a(r4, r2);	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r0.put(r2, r3);	 Catch:{ all -> 0x01b8 }
    L_0x0711:
        r2 = r3.g;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0989;
    L_0x0715:
        r2 = r3.h;	 Catch:{ all -> 0x01b8 }
        r4 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r6 = 1;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0734;
    L_0x0721:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r4 = "_sr";
        r5 = r3.h;	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2, r4, r5);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r0.c = r2;	 Catch:{ all -> 0x01b8 }
    L_0x0734:
        r2 = r3.i;	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0757;
    L_0x0738:
        r2 = r3.i;	 Catch:{ all -> 0x01b8 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0757;
    L_0x0740:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r3 = "_efs";
        r4 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2, r3, r4);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r0.c = r2;	 Catch:{ all -> 0x01b8 }
    L_0x0757:
        r2 = r18 + 1;
        r24[r18] = r28;	 Catch:{ all -> 0x01b8 }
    L_0x075b:
        r3 = r19 + 1;
        r19 = r3;
        r18 = r2;
        goto L_0x06d3;
    L_0x0763:
        r2 = new com.google.android.gms.internal.measurement.id;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r3 = r0.q;	 Catch:{ all -> 0x01b8 }
        r4 = "auto";
        r5 = "_lte";
        r6 = r30.zzbt();	 Catch:{ all -> 0x01b8 }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x01b8 }
        r8 = r8.e;	 Catch:{ all -> 0x01b8 }
        r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x01b8 }
        r8 = r8.longValue();	 Catch:{ all -> 0x01b8 }
        r8 = r8 + r14;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01b8 }
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x01b8 }
        r4 = r2;
        goto L_0x0608;
    L_0x0788:
        r3 = r3 + 1;
        goto L_0x0627;
    L_0x078c:
        r2 = 1;
        r4 = "_dbg";
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r3 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x079d;
    L_0x079b:
        if (r5 != 0) goto L_0x07d0;
    L_0x079d:
        r3 = 0;
    L_0x079e:
        if (r3 != 0) goto L_0x0bd3;
    L_0x07a0:
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.c(r3, r4);	 Catch:{ all -> 0x01b8 }
        r20 = r2;
    L_0x07b4:
        if (r20 > 0) goto L_0x080f;
    L_0x07b6:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Sample rate must be positive. event, rate";
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r5 = java.lang.Integer.valueOf(r20);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4, r5);	 Catch:{ all -> 0x01b8 }
        r2 = r18 + 1;
        r24[r18] = r28;	 Catch:{ all -> 0x01b8 }
        goto L_0x075b;
    L_0x07d0:
        r0 = r28;
        r6 = r0.c;	 Catch:{ all -> 0x01b8 }
        r7 = r6.length;	 Catch:{ all -> 0x01b8 }
        r3 = 0;
    L_0x07d6:
        if (r3 >= r7) goto L_0x080d;
    L_0x07d8:
        r8 = r6[r3];	 Catch:{ all -> 0x01b8 }
        r9 = r8.c;	 Catch:{ all -> 0x01b8 }
        r9 = r4.equals(r9);	 Catch:{ all -> 0x01b8 }
        if (r9 == 0) goto L_0x080a;
    L_0x07e2:
        r3 = r5 instanceof java.lang.Long;	 Catch:{ all -> 0x01b8 }
        if (r3 == 0) goto L_0x07ee;
    L_0x07e6:
        r3 = r8.e;	 Catch:{ all -> 0x01b8 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x0806;
    L_0x07ee:
        r3 = r5 instanceof java.lang.String;	 Catch:{ all -> 0x01b8 }
        if (r3 == 0) goto L_0x07fa;
    L_0x07f2:
        r3 = r8.d;	 Catch:{ all -> 0x01b8 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x0806;
    L_0x07fa:
        r3 = r5 instanceof java.lang.Double;	 Catch:{ all -> 0x01b8 }
        if (r3 == 0) goto L_0x0808;
    L_0x07fe:
        r3 = r8.f;	 Catch:{ all -> 0x01b8 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01b8 }
        if (r3 == 0) goto L_0x0808;
    L_0x0806:
        r3 = 1;
        goto L_0x079e;
    L_0x0808:
        r3 = 0;
        goto L_0x079e;
    L_0x080a:
        r3 = r3 + 1;
        goto L_0x07d6;
    L_0x080d:
        r3 = 0;
        goto L_0x079e;
    L_0x080f:
        r0 = r28;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r2 = r0.get(r2);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.dc) r2;	 Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x0bd0;
    L_0x081d:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r3 = r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x0869;
    L_0x0831:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Event being bundled has no eventAggregate. appId, eventName";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r5 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4, r5);	 Catch:{ all -> 0x01b8 }
        r3 = new com.google.android.gms.internal.measurement.dc;	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r2 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r2.q;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r5 = r0.d;	 Catch:{ all -> 0x01b8 }
        r6 = 1;
        r8 = 1;
        r0 = r28;
        r2 = r0.e;	 Catch:{ all -> 0x01b8 }
        r10 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r12 = 0;
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16);	 Catch:{ all -> 0x01b8 }
    L_0x0869:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r2 = "_eid";
        r0 = r28;
        r2 = com.google.android.gms.internal.measurement.ie.b(r0, r2);	 Catch:{ all -> 0x01b8 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x08aa;
    L_0x0878:
        r4 = 1;
    L_0x0879:
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ all -> 0x01b8 }
        r5 = 1;
        r0 = r20;
        if (r0 != r5) goto L_0x08ac;
    L_0x0882:
        r2 = r18 + 1;
        r24[r18] = r28;	 Catch:{ all -> 0x01b8 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01b8 }
        if (r4 == 0) goto L_0x075b;
    L_0x088c:
        r4 = r3.g;	 Catch:{ all -> 0x01b8 }
        if (r4 != 0) goto L_0x0898;
    L_0x0890:
        r4 = r3.h;	 Catch:{ all -> 0x01b8 }
        if (r4 != 0) goto L_0x0898;
    L_0x0894:
        r4 = r3.i;	 Catch:{ all -> 0x01b8 }
        if (r4 == 0) goto L_0x075b;
    L_0x0898:
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r3 = r3.a(r4, r5, r6);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r0.put(r4, r3);	 Catch:{ all -> 0x01b8 }
        goto L_0x075b;
    L_0x08aa:
        r4 = 0;
        goto L_0x0879;
    L_0x08ac:
        r0 = r25;
        r1 = r20;
        r5 = r0.nextInt(r1);	 Catch:{ all -> 0x01b8 }
        if (r5 != 0) goto L_0x08fc;
    L_0x08b6:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r5 = "_sr";
        r0 = r20;
        r6 = (long) r0;	 Catch:{ all -> 0x01b8 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2, r5, r6);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r0.c = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r18 + 1;
        r24[r18] = r28;	 Catch:{ all -> 0x01b8 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01b8 }
        if (r4 == 0) goto L_0x08e5;
    L_0x08d8:
        r4 = 0;
        r0 = r20;
        r6 = (long) r0;	 Catch:{ all -> 0x01b8 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r6 = 0;
        r3 = r3.a(r4, r5, r6);	 Catch:{ all -> 0x01b8 }
    L_0x08e5:
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r5 = r0.e;	 Catch:{ all -> 0x01b8 }
        r6 = r5.longValue();	 Catch:{ all -> 0x01b8 }
        r3 = r3.b(r6);	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r0.put(r4, r3);	 Catch:{ all -> 0x01b8 }
        goto L_0x075b;
    L_0x08fc:
        r6 = r3.f;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r5 = r0.e;	 Catch:{ all -> 0x01b8 }
        r8 = r5.longValue();	 Catch:{ all -> 0x01b8 }
        r6 = r8 - r6;
        r6 = java.lang.Math.abs(r6);	 Catch:{ all -> 0x01b8 }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x0974;
    L_0x0913:
        r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r5 = "_efs";
        r6 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2, r5, r6);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r0.c = r2;	 Catch:{ all -> 0x01b8 }
        r30.k();	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r2 = r0.c;	 Catch:{ all -> 0x01b8 }
        r5 = "_sr";
        r0 = r20;
        r6 = (long) r0;	 Catch:{ all -> 0x01b8 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r2 = com.google.android.gms.internal.measurement.ie.a(r2, r5, r6);	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r0.c = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r18 + 1;
        r24[r18] = r28;	 Catch:{ all -> 0x01b8 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01b8 }
        if (r4 == 0) goto L_0x095d;
    L_0x094c:
        r4 = 0;
        r0 = r20;
        r6 = (long) r0;	 Catch:{ all -> 0x01b8 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r6 = 1;
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x01b8 }
        r3 = r3.a(r4, r5, r6);	 Catch:{ all -> 0x01b8 }
    L_0x095d:
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r0 = r28;
        r5 = r0.e;	 Catch:{ all -> 0x01b8 }
        r6 = r5.longValue();	 Catch:{ all -> 0x01b8 }
        r3 = r3.b(r6);	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r0.put(r4, r3);	 Catch:{ all -> 0x01b8 }
        goto L_0x075b;
    L_0x0974:
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01b8 }
        if (r4 == 0) goto L_0x0989;
    L_0x097a:
        r0 = r28;
        r4 = r0.d;	 Catch:{ all -> 0x01b8 }
        r5 = 0;
        r6 = 0;
        r2 = r3.a(r2, r5, r6);	 Catch:{ all -> 0x01b8 }
        r0 = r23;
        r0.put(r4, r2);	 Catch:{ all -> 0x01b8 }
    L_0x0989:
        r2 = r18;
        goto L_0x075b;
    L_0x098d:
        r0 = r22;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.length;	 Catch:{ all -> 0x01b8 }
        r0 = r18;
        if (r0 >= r2) goto L_0x09a4;
    L_0x0996:
        r0 = r24;
        r1 = r18;
        r2 = java.util.Arrays.copyOf(r0, r1);	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.ir[]) r2;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.d = r2;	 Catch:{ all -> 0x01b8 }
    L_0x09a4:
        r2 = r23.entrySet();	 Catch:{ all -> 0x01b8 }
        r3 = r2.iterator();	 Catch:{ all -> 0x01b8 }
    L_0x09ac:
        r2 = r3.hasNext();	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x09c6;
    L_0x09b2:
        r2 = r3.next();	 Catch:{ all -> 0x01b8 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x01b8 }
        r4 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2 = r2.getValue();	 Catch:{ all -> 0x01b8 }
        r2 = (com.google.android.gms.internal.measurement.dc) r2;	 Catch:{ all -> 0x01b8 }
        r4.a(r2);	 Catch:{ all -> 0x01b8 }
        goto L_0x09ac;
    L_0x09c6:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.g = r2;	 Catch:{ all -> 0x01b8 }
        r2 = -9223372036854775808;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.h = r2;	 Catch:{ all -> 0x01b8 }
        r2 = 0;
    L_0x09de:
        r0 = r22;
        r3 = r0.d;	 Catch:{ all -> 0x01b8 }
        r3 = r3.length;	 Catch:{ all -> 0x01b8 }
        if (r2 >= r3) goto L_0x0a1e;
    L_0x09e5:
        r0 = r22;
        r3 = r0.d;	 Catch:{ all -> 0x01b8 }
        r3 = r3[r2];	 Catch:{ all -> 0x01b8 }
        r4 = r3.e;	 Catch:{ all -> 0x01b8 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r6 = r0.g;	 Catch:{ all -> 0x01b8 }
        r6 = r6.longValue();	 Catch:{ all -> 0x01b8 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0a03;
    L_0x09fd:
        r4 = r3.e;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.g = r4;	 Catch:{ all -> 0x01b8 }
    L_0x0a03:
        r4 = r3.e;	 Catch:{ all -> 0x01b8 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r6 = r0.h;	 Catch:{ all -> 0x01b8 }
        r6 = r6.longValue();	 Catch:{ all -> 0x01b8 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0a1b;
    L_0x0a15:
        r3 = r3.e;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.h = r3;	 Catch:{ all -> 0x01b8 }
    L_0x0a1b:
        r2 = r2 + 1;
        goto L_0x09de;
    L_0x0a1e:
        r0 = r21;
        r2 = r0.a;	 Catch:{ all -> 0x01b8 }
        r6 = r2.q;	 Catch:{ all -> 0x01b8 }
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r7 = r2.b(r6);	 Catch:{ all -> 0x01b8 }
        if (r7 != 0) goto L_0x0ab9;
    L_0x0a2e:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.r();	 Catch:{ all -> 0x01b8 }
        r3 = "Bundling raw events w/o app info. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
    L_0x0a45:
        r0 = r22;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.length;	 Catch:{ all -> 0x01b8 }
        if (r2 <= 0) goto L_0x0a81;
    L_0x0a4c:
        r2 = r30.d();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r3 = r0.a;	 Catch:{ all -> 0x01b8 }
        r3 = r3.q;	 Catch:{ all -> 0x01b8 }
        r2 = r2.a(r3);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0a60;
    L_0x0a5c:
        r3 = r2.c;	 Catch:{ all -> 0x01b8 }
        if (r3 != 0) goto L_0x0b3e;
    L_0x0a60:
        r0 = r21;
        r2 = r0.a;	 Catch:{ all -> 0x01b8 }
        r2 = r2.A;	 Catch:{ all -> 0x01b8 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x01b8 }
        if (r2 == 0) goto L_0x0b25;
    L_0x0a6c:
        r2 = -1;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.G = r2;	 Catch:{ all -> 0x01b8 }
    L_0x0a76:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r1 = r17;
        r2.a(r0, r1);	 Catch:{ all -> 0x01b8 }
    L_0x0a81:
        r4 = r30.z();	 Catch:{ all -> 0x01b8 }
        r0 = r21;
        r5 = r0.b;	 Catch:{ all -> 0x01b8 }
        com.google.android.gms.common.internal.ar.a(r5);	 Catch:{ all -> 0x01b8 }
        r4.c();	 Catch:{ all -> 0x01b8 }
        r4.J();	 Catch:{ all -> 0x01b8 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b8 }
        r2 = "rowid in (";
        r7.<init>(r2);	 Catch:{ all -> 0x01b8 }
        r2 = 0;
        r3 = r2;
    L_0x0a9b:
        r2 = r5.size();	 Catch:{ all -> 0x01b8 }
        if (r3 >= r2) goto L_0x0b46;
    L_0x0aa1:
        if (r3 == 0) goto L_0x0aa8;
    L_0x0aa3:
        r2 = ",";
        r7.append(r2);	 Catch:{ all -> 0x01b8 }
    L_0x0aa8:
        r2 = r5.get(r3);	 Catch:{ all -> 0x01b8 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01b8 }
        r8 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r7.append(r8);	 Catch:{ all -> 0x01b8 }
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0a9b;
    L_0x0ab9:
        r0 = r22;
        r2 = r0.d;	 Catch:{ all -> 0x01b8 }
        r2 = r2.length;	 Catch:{ all -> 0x01b8 }
        if (r2 <= 0) goto L_0x0a45;
    L_0x0ac0:
        r2 = r7.h();	 Catch:{ all -> 0x01b8 }
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0b21;
    L_0x0aca:
        r4 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
    L_0x0ace:
        r0 = r22;
        r0.j = r4;	 Catch:{ all -> 0x01b8 }
        r4 = r7.g();	 Catch:{ all -> 0x01b8 }
        r8 = 0;
        r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r8 != 0) goto L_0x0bcd;
    L_0x0adc:
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0b23;
    L_0x0ae2:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01b8 }
    L_0x0ae6:
        r0 = r22;
        r0.i = r2;	 Catch:{ all -> 0x01b8 }
        r7.r();	 Catch:{ all -> 0x01b8 }
        r2 = r7.o();	 Catch:{ all -> 0x01b8 }
        r2 = (int) r2;	 Catch:{ all -> 0x01b8 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.y = r2;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r2 = r0.g;	 Catch:{ all -> 0x01b8 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r7.a(r2);	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r2 = r0.h;	 Catch:{ all -> 0x01b8 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01b8 }
        r7.b(r2);	 Catch:{ all -> 0x01b8 }
        r2 = r7.z();	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.z = r2;	 Catch:{ all -> 0x01b8 }
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2.a(r7);	 Catch:{ all -> 0x01b8 }
        goto L_0x0a45;
    L_0x0b21:
        r4 = 0;
        goto L_0x0ace;
    L_0x0b23:
        r2 = 0;
        goto L_0x0ae6;
    L_0x0b25:
        r2 = r30.zzge();	 Catch:{ all -> 0x01b8 }
        r2 = r2.u();	 Catch:{ all -> 0x01b8 }
        r3 = "Did not find measurement config or missing version info. appId";
        r0 = r21;
        r4 = r0.a;	 Catch:{ all -> 0x01b8 }
        r4 = r4.q;	 Catch:{ all -> 0x01b8 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x01b8 }
        r2.a(r3, r4);	 Catch:{ all -> 0x01b8 }
        goto L_0x0a76;
    L_0x0b3e:
        r2 = r2.c;	 Catch:{ all -> 0x01b8 }
        r0 = r22;
        r0.G = r2;	 Catch:{ all -> 0x01b8 }
        goto L_0x0a76;
    L_0x0b46:
        r2 = ")";
        r7.append(r2);	 Catch:{ all -> 0x01b8 }
        r2 = r4.t();	 Catch:{ all -> 0x01b8 }
        r3 = "raw_events";
        r7 = r7.toString();	 Catch:{ all -> 0x01b8 }
        r8 = 0;
        r2 = r2.delete(r3, r7, r8);	 Catch:{ all -> 0x01b8 }
        r3 = r5.size();	 Catch:{ all -> 0x01b8 }
        if (r2 == r3) goto L_0x0b79;
    L_0x0b60:
        r3 = r4.zzge();	 Catch:{ all -> 0x01b8 }
        r3 = r3.r();	 Catch:{ all -> 0x01b8 }
        r4 = "Deleted fewer rows from raw events table than expected";
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x01b8 }
        r5 = r5.size();	 Catch:{ all -> 0x01b8 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x01b8 }
        r3.a(r4, r2, r5);	 Catch:{ all -> 0x01b8 }
    L_0x0b79:
        r3 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2 = r3.t();	 Catch:{ all -> 0x01b8 }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0b9f }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x0b9f }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x0b9f }
        r2.execSQL(r4, r5);	 Catch:{ SQLiteException -> 0x0b9f }
    L_0x0b8f:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2.r();	 Catch:{ all -> 0x01b8 }
        r2 = r30.z();
        r2.s();
        r2 = 1;
    L_0x0b9e:
        return r2;
    L_0x0b9f:
        r2 = move-exception;
        r3 = r3.zzge();	 Catch:{ all -> 0x01b8 }
        r3 = r3.r();	 Catch:{ all -> 0x01b8 }
        r4 = "Failed to remove unused event metadata. appId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r6);	 Catch:{ all -> 0x01b8 }
        r3.a(r4, r5, r2);	 Catch:{ all -> 0x01b8 }
        goto L_0x0b8f;
    L_0x0bb2:
        r2 = r30.z();	 Catch:{ all -> 0x01b8 }
        r2.r();	 Catch:{ all -> 0x01b8 }
        r2 = r30.z();
        r2.s();
        r2 = 0;
        goto L_0x0b9e;
    L_0x0bc2:
        r2 = move-exception;
        r3 = r11;
        goto L_0x034e;
    L_0x0bc6:
        r2 = move-exception;
        goto L_0x02dd;
    L_0x0bc9:
        r2 = move-exception;
        r4 = r12;
        goto L_0x02dd;
    L_0x0bcd:
        r2 = r4;
        goto L_0x0adc;
    L_0x0bd0:
        r3 = r2;
        goto L_0x0869;
    L_0x0bd3:
        r20 = r2;
        goto L_0x07b4;
    L_0x0bd7:
        r2 = r14;
        goto L_0x055e;
    L_0x0bda:
        r2 = r3;
        r3 = r4;
        goto L_0x0500;
    L_0x0bde:
        r17 = r2;
        goto L_0x049b;
    L_0x0be2:
        r2 = r3;
        r3 = r4;
        goto L_0x03a3;
    L_0x0be6:
        r2 = r14;
        r4 = r13;
        r5 = r17;
        goto L_0x0150;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.hw.a(java.lang.String, long):boolean");
    }

    private final boolean a(String str, zzeu zzeu) {
        long round;
        Object d = zzeu.b.d("currency");
        if ("ecommerce_purchase".equals(zzeu.a)) {
            double doubleValue = zzeu.b.c("value").doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzeu.b.b("value").longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().u().a("Data lost. Currency value is too big. appId", dp.a(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = zzeu.b.b("value").longValue();
        }
        if (!TextUtils.isEmpty(d)) {
            String toUpperCase = d.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                id c = z().c(str, concat);
                if (c == null || !(c.e instanceof Long)) {
                    fn z = z();
                    int b = b().b(str, dg.F) - 1;
                    ar.a(str);
                    z.c();
                    z.J();
                    try {
                        z.t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(b)});
                    } catch (SQLiteException e) {
                        z.zzge().r().a("Error pruning currencies. appId", dp.a(str), e);
                    }
                    c = new id(str, zzeu.c, concat, zzbt().currentTimeMillis(), Long.valueOf(round));
                } else {
                    c = new id(str, zzeu.c, concat, zzbt().currentTimeMillis(), Long.valueOf(round + ((Long) c.e).longValue()));
                }
                if (!z().a(c)) {
                    zzge().r().a("Too many unique user properties are set. Ignoring user property. appId", dp.a(str), l().c(c.c), c.e);
                    k().a(str, 9, null, null, 0);
                }
            }
        }
        return true;
    }

    private final iq[] a(String str, iw[] iwVarArr, ir[] irVarArr) {
        ar.a(str);
        return A().a(str, irVarArr, iwVarArr);
    }

    @WorkerThread
    private final Boolean b(cp cpVar) {
        try {
            if (cpVar.j() != -2147483648L) {
                if (cpVar.j() == ((long) c.b(getContext()).b(cpVar.b(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            }
            String str = c.b(getContext()).b(cpVar.b(), 0).versionName;
            if (cpVar.i() != null && cpVar.i().equals(str)) {
                return Boolean.valueOf(true);
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static void b(hv hvVar) {
        if (hvVar == null) {
            throw new IllegalStateException("Upload component not created");
        } else if (!hvVar.I()) {
            String valueOf = String.valueOf(hvVar.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x05d3 A:{Catch:{ IOException -> 0x062b, all -> 0x057f }} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x05eb A:{Catch:{ IOException -> 0x062b, all -> 0x057f }} */
    @android.support.annotation.WorkerThread
    private final void b(com.google.android.gms.internal.measurement.zzeu r31, com.google.android.gms.internal.measurement.zzdz r32) {
        /*
        r30 = this;
        com.google.android.gms.common.internal.ar.a(r32);
        r0 = r32;
        r2 = r0.a;
        com.google.android.gms.common.internal.ar.a(r2);
        r28 = java.lang.System.nanoTime();
        r30.s();
        r30.B();
        r0 = r32;
        r3 = r0.a;
        r30.k();
        r2 = com.google.android.gms.internal.measurement.ie.a(r31, r32);
        if (r2 != 0) goto L_0x0022;
    L_0x0021:
        return;
    L_0x0022:
        r0 = r32;
        r2 = r0.h;
        if (r2 != 0) goto L_0x0030;
    L_0x0028:
        r0 = r30;
        r1 = r32;
        r0.e(r1);
        goto L_0x0021;
    L_0x0030:
        r2 = r30.d();
        r0 = r31;
        r4 = r0.a;
        r2 = r2.a(r3, r4);
        if (r2 == 0) goto L_0x00dc;
    L_0x003e:
        r2 = r30.zzge();
        r2 = r2.u();
        r4 = "Dropping blacklisted event. appId";
        r5 = com.google.android.gms.internal.measurement.dp.a(r3);
        r6 = r30.l();
        r0 = r31;
        r7 = r0.a;
        r6 = r6.a(r7);
        r2.a(r4, r5, r6);
        r2 = r30.d();
        r2 = r2.e(r3);
        if (r2 != 0) goto L_0x006f;
    L_0x0065:
        r2 = r30.d();
        r2 = r2.f(r3);
        if (r2 == 0) goto L_0x00d9;
    L_0x006f:
        r2 = 1;
        r8 = r2;
    L_0x0071:
        if (r8 != 0) goto L_0x008f;
    L_0x0073:
        r2 = "_err";
        r0 = r31;
        r4 = r0.a;
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x008f;
    L_0x007f:
        r2 = r30.k();
        r4 = 11;
        r5 = "_ev";
        r0 = r31;
        r6 = r0.a;
        r7 = 0;
        r2.a(r3, r4, r5, r6, r7);
    L_0x008f:
        if (r8 == 0) goto L_0x0021;
    L_0x0091:
        r2 = r30.z();
        r3 = r2.b(r3);
        if (r3 == 0) goto L_0x0021;
    L_0x009b:
        r4 = r3.q();
        r6 = r3.p();
        r4 = java.lang.Math.max(r4, r6);
        r2 = r30.zzbt();
        r6 = r2.currentTimeMillis();
        r4 = r6 - r4;
        r4 = java.lang.Math.abs(r4);
        r2 = com.google.android.gms.internal.measurement.dg.A;
        r2 = r2.b();
        r2 = (java.lang.Long) r2;
        r6 = r2.longValue();
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0021;
    L_0x00c5:
        r2 = r30.zzge();
        r2 = r2.x();
        r4 = "Fetching config for blacklisted app";
        r2.a(r4);
        r0 = r30;
        r0.a(r3);
        goto L_0x0021;
    L_0x00d9:
        r2 = 0;
        r8 = r2;
        goto L_0x0071;
    L_0x00dc:
        r2 = r30.zzge();
        r4 = 2;
        r2 = r2.a(r4);
        if (r2 == 0) goto L_0x00fe;
    L_0x00e7:
        r2 = r30.zzge();
        r2 = r2.y();
        r4 = "Logging event";
        r5 = r30.l();
        r0 = r31;
        r5 = r5.a(r0);
        r2.a(r4, r5);
    L_0x00fe:
        r2 = r30.z();
        r2.q();
        r0 = r30;
        r1 = r32;
        r0.e(r1);	 Catch:{ all -> 0x057f }
        r2 = "_iap";
        r0 = r31;
        r4 = r0.a;	 Catch:{ all -> 0x057f }
        r2 = r2.equals(r4);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x0124;
    L_0x0118:
        r2 = "ecommerce_purchase";
        r0 = r31;
        r4 = r0.a;	 Catch:{ all -> 0x057f }
        r2 = r2.equals(r4);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x013e;
    L_0x0124:
        r0 = r30;
        r1 = r31;
        r2 = r0.a(r3, r1);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x013e;
    L_0x012e:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.r();	 Catch:{ all -> 0x057f }
        r2 = r30.z();
        r2.s();
        goto L_0x0021;
    L_0x013e:
        r0 = r31;
        r2 = r0.a;	 Catch:{ all -> 0x057f }
        r10 = com.google.android.gms.internal.measurement.ie.a(r2);	 Catch:{ all -> 0x057f }
        r2 = "_err";
        r0 = r31;
        r4 = r0.a;	 Catch:{ all -> 0x057f }
        r12 = r2.equals(r4);	 Catch:{ all -> 0x057f }
        r5 = r30.z();	 Catch:{ all -> 0x057f }
        r6 = r30.g();	 Catch:{ all -> 0x057f }
        r9 = 1;
        r11 = 0;
        r13 = 0;
        r8 = r3;
        r4 = r5.a(r6, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x057f }
        r6 = r4.b;	 Catch:{ all -> 0x057f }
        r2 = com.google.android.gms.internal.measurement.dg.l;	 Catch:{ all -> 0x057f }
        r2 = r2.b();	 Catch:{ all -> 0x057f }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x057f }
        r2 = r2.intValue();	 Catch:{ all -> 0x057f }
        r8 = (long) r2;	 Catch:{ all -> 0x057f }
        r6 = r6 - r8;
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01a6;
    L_0x0176:
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 % r8;
        r8 = 1;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0196;
    L_0x017f:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.r();	 Catch:{ all -> 0x057f }
        r5 = "Data loss. Too many events logged. appId, count";
        r3 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ all -> 0x057f }
        r6 = r4.b;	 Catch:{ all -> 0x057f }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x057f }
        r2.a(r5, r3, r4);	 Catch:{ all -> 0x057f }
    L_0x0196:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.r();	 Catch:{ all -> 0x057f }
        r2 = r30.z();
        r2.s();
        goto L_0x0021;
    L_0x01a6:
        if (r10 == 0) goto L_0x01fe;
    L_0x01a8:
        r6 = r4.a;	 Catch:{ all -> 0x057f }
        r2 = com.google.android.gms.internal.measurement.dg.n;	 Catch:{ all -> 0x057f }
        r2 = r2.b();	 Catch:{ all -> 0x057f }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x057f }
        r2 = r2.intValue();	 Catch:{ all -> 0x057f }
        r8 = (long) r2;	 Catch:{ all -> 0x057f }
        r6 = r6 - r8;
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01fe;
    L_0x01be:
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 % r8;
        r8 = 1;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x01de;
    L_0x01c7:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.r();	 Catch:{ all -> 0x057f }
        r5 = "Data loss. Too many public events logged. appId, count";
        r6 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ all -> 0x057f }
        r8 = r4.a;	 Catch:{ all -> 0x057f }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x057f }
        r2.a(r5, r6, r4);	 Catch:{ all -> 0x057f }
    L_0x01de:
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r4 = 16;
        r5 = "_ev";
        r0 = r31;
        r6 = r0.a;	 Catch:{ all -> 0x057f }
        r7 = 0;
        r2.a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x057f }
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.r();	 Catch:{ all -> 0x057f }
        r2 = r30.z();
        r2.s();
        goto L_0x0021;
    L_0x01fe:
        if (r12 == 0) goto L_0x0251;
    L_0x0200:
        r6 = r4.d;	 Catch:{ all -> 0x057f }
        r2 = r30.b();	 Catch:{ all -> 0x057f }
        r0 = r32;
        r5 = r0.a;	 Catch:{ all -> 0x057f }
        r8 = com.google.android.gms.internal.measurement.dg.m;	 Catch:{ all -> 0x057f }
        r2 = r2.b(r5, r8);	 Catch:{ all -> 0x057f }
        r5 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = java.lang.Math.min(r5, r2);	 Catch:{ all -> 0x057f }
        r5 = 0;
        r2 = java.lang.Math.max(r5, r2);	 Catch:{ all -> 0x057f }
        r8 = (long) r2;	 Catch:{ all -> 0x057f }
        r6 = r6 - r8;
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0251;
    L_0x0224:
        r8 = 1;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0241;
    L_0x022a:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.r();	 Catch:{ all -> 0x057f }
        r5 = "Too many error events logged. appId, count";
        r3 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ all -> 0x057f }
        r6 = r4.d;	 Catch:{ all -> 0x057f }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x057f }
        r2.a(r5, r3, r4);	 Catch:{ all -> 0x057f }
    L_0x0241:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.r();	 Catch:{ all -> 0x057f }
        r2 = r30.z();
        r2.s();
        goto L_0x0021;
    L_0x0251:
        r0 = r31;
        r2 = r0.b;	 Catch:{ all -> 0x057f }
        r20 = r2.b();	 Catch:{ all -> 0x057f }
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r4 = "_o";
        r0 = r31;
        r5 = r0.c;	 Catch:{ all -> 0x057f }
        r0 = r20;
        r2.a(r0, r4, r5);	 Catch:{ all -> 0x057f }
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r2 = r2.i(r3);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0294;
    L_0x0272:
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r4 = "_dbg";
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x057f }
        r0 = r20;
        r2.a(r0, r4, r5);	 Catch:{ all -> 0x057f }
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r4 = "_r";
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x057f }
        r0 = r20;
        r2.a(r0, r4, r5);	 Catch:{ all -> 0x057f }
    L_0x0294:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r4 = r2.c(r3);	 Catch:{ all -> 0x057f }
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x02b7;
    L_0x02a2:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.u();	 Catch:{ all -> 0x057f }
        r6 = "Data lost. Too many events stored on disk, deleted. appId";
        r7 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ all -> 0x057f }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x057f }
        r2.a(r6, r7, r4);	 Catch:{ all -> 0x057f }
    L_0x02b7:
        r11 = new com.google.android.gms.internal.measurement.db;	 Catch:{ all -> 0x057f }
        r0 = r30;
        r12 = r0.h;	 Catch:{ all -> 0x057f }
        r0 = r31;
        r13 = r0.c;	 Catch:{ all -> 0x057f }
        r0 = r31;
        r15 = r0.a;	 Catch:{ all -> 0x057f }
        r0 = r31;
        r0 = r0.d;	 Catch:{ all -> 0x057f }
        r16 = r0;
        r18 = 0;
        r14 = r3;
        r11.<init>(r12, r13, r14, r15, r16, r18, r20);	 Catch:{ all -> 0x057f }
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r4 = r11.b;	 Catch:{ all -> 0x057f }
        r2 = r2.a(r3, r4);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x051a;
    L_0x02dd:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r4 = r2.f(r3);	 Catch:{ all -> 0x057f }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x0323;
    L_0x02eb:
        if (r10 == 0) goto L_0x0323;
    L_0x02ed:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.r();	 Catch:{ all -> 0x057f }
        r4 = "Too many event names used, ignoring event. appId, name, supported count";
        r5 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ all -> 0x057f }
        r6 = r30.l();	 Catch:{ all -> 0x057f }
        r7 = r11.b;	 Catch:{ all -> 0x057f }
        r6 = r6.a(r7);	 Catch:{ all -> 0x057f }
        r7 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x057f }
        r2.a(r4, r5, r6, r7);	 Catch:{ all -> 0x057f }
        r2 = r30.k();	 Catch:{ all -> 0x057f }
        r4 = 8;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2.a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x057f }
        r2 = r30.z();
        r2.s();
        goto L_0x0021;
    L_0x0323:
        r13 = new com.google.android.gms.internal.measurement.dc;	 Catch:{ all -> 0x057f }
        r15 = r11.b;	 Catch:{ all -> 0x057f }
        r16 = 0;
        r18 = 0;
        r0 = r11.c;	 Catch:{ all -> 0x057f }
        r20 = r0;
        r22 = 0;
        r24 = 0;
        r25 = 0;
        r26 = 0;
        r14 = r3;
        r13.<init>(r14, r15, r16, r18, r20, r22, r24, r25, r26);	 Catch:{ all -> 0x057f }
        r12 = r11;
    L_0x033c:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.a(r13);	 Catch:{ all -> 0x057f }
        r30.s();	 Catch:{ all -> 0x057f }
        r30.B();	 Catch:{ all -> 0x057f }
        com.google.android.gms.common.internal.ar.a(r12);	 Catch:{ all -> 0x057f }
        com.google.android.gms.common.internal.ar.a(r32);	 Catch:{ all -> 0x057f }
        r2 = r12.a;	 Catch:{ all -> 0x057f }
        com.google.android.gms.common.internal.ar.a(r2);	 Catch:{ all -> 0x057f }
        r2 = r12.a;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.a;	 Catch:{ all -> 0x057f }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x057f }
        com.google.android.gms.common.internal.ar.b(r2);	 Catch:{ all -> 0x057f }
        r4 = new com.google.android.gms.internal.measurement.iu;	 Catch:{ all -> 0x057f }
        r4.<init>();	 Catch:{ all -> 0x057f }
        r2 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x057f }
        r4.c = r2;	 Catch:{ all -> 0x057f }
        r2 = "android";
        r4.k = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.a;	 Catch:{ all -> 0x057f }
        r4.q = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.d;	 Catch:{ all -> 0x057f }
        r4.p = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.c;	 Catch:{ all -> 0x057f }
        r4.r = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.j;	 Catch:{ all -> 0x057f }
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x052d;
    L_0x038e:
        r2 = 0;
    L_0x038f:
        r4.E = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.e;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x057f }
        r4.s = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.b;	 Catch:{ all -> 0x057f }
        r4.A = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.f;	 Catch:{ all -> 0x057f }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0538;
    L_0x03ab:
        r2 = 0;
    L_0x03ac:
        r4.x = r2;	 Catch:{ all -> 0x057f }
        r2 = r30.c();	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.a;	 Catch:{ all -> 0x057f }
        r3 = r2.a(r3);	 Catch:{ all -> 0x057f }
        if (r3 == 0) goto L_0x0542;
    L_0x03bc:
        r2 = r3.first;	 Catch:{ all -> 0x057f }
        r2 = (java.lang.CharSequence) r2;	 Catch:{ all -> 0x057f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x0542;
    L_0x03c6:
        r0 = r32;
        r2 = r0.o;	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x03d8;
    L_0x03cc:
        r2 = r3.first;	 Catch:{ all -> 0x057f }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x057f }
        r4.u = r2;	 Catch:{ all -> 0x057f }
        r2 = r3.second;	 Catch:{ all -> 0x057f }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x057f }
        r4.v = r2;	 Catch:{ all -> 0x057f }
    L_0x03d8:
        r2 = r30.p();	 Catch:{ all -> 0x057f }
        r2.B();	 Catch:{ all -> 0x057f }
        r2 = android.os.Build.MODEL;	 Catch:{ all -> 0x057f }
        r4.m = r2;	 Catch:{ all -> 0x057f }
        r2 = r30.p();	 Catch:{ all -> 0x057f }
        r2.B();	 Catch:{ all -> 0x057f }
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x057f }
        r4.l = r2;	 Catch:{ all -> 0x057f }
        r2 = r30.p();	 Catch:{ all -> 0x057f }
        r2 = r2.q();	 Catch:{ all -> 0x057f }
        r2 = (int) r2;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x057f }
        r4.o = r2;	 Catch:{ all -> 0x057f }
        r2 = r30.p();	 Catch:{ all -> 0x057f }
        r2 = r2.r();	 Catch:{ all -> 0x057f }
        r4.n = r2;	 Catch:{ all -> 0x057f }
        r2 = 0;
        r4.t = r2;	 Catch:{ all -> 0x057f }
        r2 = 0;
        r4.f = r2;	 Catch:{ all -> 0x057f }
        r2 = 0;
        r4.g = r2;	 Catch:{ all -> 0x057f }
        r2 = 0;
        r4.h = r2;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r2 = r0.l;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x057f }
        r4.H = r2;	 Catch:{ all -> 0x057f }
        r0 = r30;
        r2 = r0.h;	 Catch:{ all -> 0x057f }
        r2 = r2.t();	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0430;
    L_0x0427:
        r2 = com.google.android.gms.internal.measurement.ct.u();	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0430;
    L_0x042d:
        r2 = 0;
        r4.I = r2;	 Catch:{ all -> 0x057f }
    L_0x0430:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.a;	 Catch:{ all -> 0x057f }
        r2 = r2.b(r3);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x04be;
    L_0x043e:
        r2 = new com.google.android.gms.internal.measurement.cp;	 Catch:{ all -> 0x057f }
        r0 = r30;
        r3 = r0.h;	 Catch:{ all -> 0x057f }
        r0 = r32;
        r5 = r0.a;	 Catch:{ all -> 0x057f }
        r2.<init>(r3, r5);	 Catch:{ all -> 0x057f }
        r0 = r30;
        r3 = r0.h;	 Catch:{ all -> 0x057f }
        r3 = r3.q();	 Catch:{ all -> 0x057f }
        r3 = r3.r();	 Catch:{ all -> 0x057f }
        r2.a(r3);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.k;	 Catch:{ all -> 0x057f }
        r2.d(r3);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.b;	 Catch:{ all -> 0x057f }
        r2.b(r3);	 Catch:{ all -> 0x057f }
        r3 = r30.c();	 Catch:{ all -> 0x057f }
        r0 = r32;
        r5 = r0.a;	 Catch:{ all -> 0x057f }
        r3 = r3.b(r5);	 Catch:{ all -> 0x057f }
        r2.c(r3);	 Catch:{ all -> 0x057f }
        r6 = 0;
        r2.f(r6);	 Catch:{ all -> 0x057f }
        r6 = 0;
        r2.a(r6);	 Catch:{ all -> 0x057f }
        r6 = 0;
        r2.b(r6);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.c;	 Catch:{ all -> 0x057f }
        r2.e(r3);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r6 = r0.j;	 Catch:{ all -> 0x057f }
        r2.c(r6);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.d;	 Catch:{ all -> 0x057f }
        r2.f(r3);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r6 = r0.e;	 Catch:{ all -> 0x057f }
        r2.d(r6);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r6 = r0.f;	 Catch:{ all -> 0x057f }
        r2.e(r6);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.h;	 Catch:{ all -> 0x057f }
        r2.a(r3);	 Catch:{ all -> 0x057f }
        r0 = r32;
        r6 = r0.l;	 Catch:{ all -> 0x057f }
        r2.o(r6);	 Catch:{ all -> 0x057f }
        r3 = r30.z();	 Catch:{ all -> 0x057f }
        r3.a(r2);	 Catch:{ all -> 0x057f }
    L_0x04be:
        r3 = r2.c();	 Catch:{ all -> 0x057f }
        r4.w = r3;	 Catch:{ all -> 0x057f }
        r2 = r2.f();	 Catch:{ all -> 0x057f }
        r4.D = r2;	 Catch:{ all -> 0x057f }
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r0 = r32;
        r3 = r0.a;	 Catch:{ all -> 0x057f }
        r5 = r2.a(r3);	 Catch:{ all -> 0x057f }
        r2 = r5.size();	 Catch:{ all -> 0x057f }
        r2 = new com.google.android.gms.internal.measurement.iw[r2];	 Catch:{ all -> 0x057f }
        r4.e = r2;	 Catch:{ all -> 0x057f }
        r2 = 0;
        r3 = r2;
    L_0x04e0:
        r2 = r5.size();	 Catch:{ all -> 0x057f }
        if (r3 >= r2) goto L_0x05a2;
    L_0x04e6:
        r6 = new com.google.android.gms.internal.measurement.iw;	 Catch:{ all -> 0x057f }
        r6.<init>();	 Catch:{ all -> 0x057f }
        r2 = r4.e;	 Catch:{ all -> 0x057f }
        r2[r3] = r6;	 Catch:{ all -> 0x057f }
        r2 = r5.get(r3);	 Catch:{ all -> 0x057f }
        r2 = (com.google.android.gms.internal.measurement.id) r2;	 Catch:{ all -> 0x057f }
        r2 = r2.c;	 Catch:{ all -> 0x057f }
        r6.d = r2;	 Catch:{ all -> 0x057f }
        r2 = r5.get(r3);	 Catch:{ all -> 0x057f }
        r2 = (com.google.android.gms.internal.measurement.id) r2;	 Catch:{ all -> 0x057f }
        r8 = r2.d;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x057f }
        r6.c = r2;	 Catch:{ all -> 0x057f }
        r7 = r30.k();	 Catch:{ all -> 0x057f }
        r2 = r5.get(r3);	 Catch:{ all -> 0x057f }
        r2 = (com.google.android.gms.internal.measurement.id) r2;	 Catch:{ all -> 0x057f }
        r2 = r2.e;	 Catch:{ all -> 0x057f }
        r7.a(r6, r2);	 Catch:{ all -> 0x057f }
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x04e0;
    L_0x051a:
        r0 = r30;
        r3 = r0.h;	 Catch:{ all -> 0x057f }
        r4 = r2.e;	 Catch:{ all -> 0x057f }
        r11 = r11.a(r3, r4);	 Catch:{ all -> 0x057f }
        r4 = r11.c;	 Catch:{ all -> 0x057f }
        r13 = r2.a(r4);	 Catch:{ all -> 0x057f }
        r12 = r11;
        goto L_0x033c;
    L_0x052d:
        r0 = r32;
        r2 = r0.j;	 Catch:{ all -> 0x057f }
        r2 = (int) r2;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x057f }
        goto L_0x038f;
    L_0x0538:
        r0 = r32;
        r2 = r0.f;	 Catch:{ all -> 0x057f }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x057f }
        goto L_0x03ac;
    L_0x0542:
        r2 = r30.p();	 Catch:{ all -> 0x057f }
        r3 = r30.getContext();	 Catch:{ all -> 0x057f }
        r2 = r2.a(r3);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x03d8;
    L_0x0550:
        r0 = r32;
        r2 = r0.p;	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x03d8;
    L_0x0556:
        r2 = r30.getContext();	 Catch:{ all -> 0x057f }
        r2 = r2.getContentResolver();	 Catch:{ all -> 0x057f }
        r3 = "android_id";
        r2 = android.provider.Settings.Secure.getString(r2, r3);	 Catch:{ all -> 0x057f }
        if (r2 != 0) goto L_0x0588;
    L_0x0566:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.u();	 Catch:{ all -> 0x057f }
        r3 = "null secure ID. appId";
        r5 = r4.q;	 Catch:{ all -> 0x057f }
        r5 = com.google.android.gms.internal.measurement.dp.a(r5);	 Catch:{ all -> 0x057f }
        r2.a(r3, r5);	 Catch:{ all -> 0x057f }
        r2 = "null";
    L_0x057b:
        r4.F = r2;	 Catch:{ all -> 0x057f }
        goto L_0x03d8;
    L_0x057f:
        r2 = move-exception;
        r3 = r30.z();
        r3.s();
        throw r2;
    L_0x0588:
        r3 = r2.isEmpty();	 Catch:{ all -> 0x057f }
        if (r3 == 0) goto L_0x057b;
    L_0x058e:
        r3 = r30.zzge();	 Catch:{ all -> 0x057f }
        r3 = r3.u();	 Catch:{ all -> 0x057f }
        r5 = "empty secure ID. appId";
        r6 = r4.q;	 Catch:{ all -> 0x057f }
        r6 = com.google.android.gms.internal.measurement.dp.a(r6);	 Catch:{ all -> 0x057f }
        r3.a(r5, r6);	 Catch:{ all -> 0x057f }
        goto L_0x057b;
    L_0x05a2:
        r2 = r30.z();	 Catch:{ IOException -> 0x062b }
        r14 = r2.a(r4);	 Catch:{ IOException -> 0x062b }
        r13 = r30.z();	 Catch:{ all -> 0x057f }
        r2 = r12.e;	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0675;
    L_0x05b2:
        r2 = r12.e;	 Catch:{ all -> 0x057f }
        r3 = r2.iterator();	 Catch:{ all -> 0x057f }
    L_0x05b8:
        r2 = r3.hasNext();	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0640;
    L_0x05be:
        r2 = r3.next();	 Catch:{ all -> 0x057f }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x057f }
        r4 = "_r";
        r2 = r4.equals(r2);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x05b8;
    L_0x05cc:
        r2 = 1;
    L_0x05cd:
        r2 = r13.a(r12, r14, r2);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x05d9;
    L_0x05d3:
        r2 = 0;
        r0 = r30;
        r0.k = r2;	 Catch:{ all -> 0x057f }
    L_0x05d9:
        r2 = r30.z();	 Catch:{ all -> 0x057f }
        r2.r();	 Catch:{ all -> 0x057f }
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r3 = 2;
        r2 = r2.a(r3);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0600;
    L_0x05eb:
        r2 = r30.zzge();	 Catch:{ all -> 0x057f }
        r2 = r2.y();	 Catch:{ all -> 0x057f }
        r3 = "Event recorded";
        r4 = r30.l();	 Catch:{ all -> 0x057f }
        r4 = r4.a(r12);	 Catch:{ all -> 0x057f }
        r2.a(r3, r4);	 Catch:{ all -> 0x057f }
    L_0x0600:
        r2 = r30.z();
        r2.s();
        r30.i();
        r2 = r30.zzge();
        r2 = r2.y();
        r3 = "Background event processing time, ms";
        r4 = java.lang.System.nanoTime();
        r4 = r4 - r28;
        r6 = 500000; // 0x7a120 float:7.00649E-40 double:2.47033E-318;
        r4 = r4 + r6;
        r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r4 / r6;
        r4 = java.lang.Long.valueOf(r4);
        r2.a(r3, r4);
        goto L_0x0021;
    L_0x062b:
        r2 = move-exception;
        r3 = r30.zzge();	 Catch:{ all -> 0x057f }
        r3 = r3.r();	 Catch:{ all -> 0x057f }
        r5 = "Data loss. Failed to insert raw event metadata. appId";
        r4 = r4.q;	 Catch:{ all -> 0x057f }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x057f }
        r3.a(r5, r4, r2);	 Catch:{ all -> 0x057f }
        goto L_0x05d9;
    L_0x0640:
        r2 = r30.d();	 Catch:{ all -> 0x057f }
        r3 = r12.a;	 Catch:{ all -> 0x057f }
        r4 = r12.b;	 Catch:{ all -> 0x057f }
        r2 = r2.b(r3, r4);	 Catch:{ all -> 0x057f }
        r3 = r30.z();	 Catch:{ all -> 0x057f }
        r4 = r30.g();	 Catch:{ all -> 0x057f }
        r6 = r12.a;	 Catch:{ all -> 0x057f }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r3 = r3.a(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x057f }
        if (r2 == 0) goto L_0x0675;
    L_0x0661:
        r2 = r3.e;	 Catch:{ all -> 0x057f }
        r4 = r30.b();	 Catch:{ all -> 0x057f }
        r5 = r12.a;	 Catch:{ all -> 0x057f }
        r4 = r4.a(r5);	 Catch:{ all -> 0x057f }
        r4 = (long) r4;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0675;
    L_0x0672:
        r2 = 1;
        goto L_0x05cd;
    L_0x0675:
        r2 = 0;
        goto L_0x05cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.hw.b(com.google.android.gms.internal.measurement.zzeu, com.google.android.gms.internal.measurement.zzdz):void");
    }

    private final em d() {
        b(this.a);
        return this.a;
    }

    @WorkerThread
    private final cp e(zzdz zzdz) {
        Object obj = 1;
        s();
        B();
        ar.a((Object) zzdz);
        ar.a(zzdz.a);
        cp b = z().b(zzdz.a);
        String b2 = c().b(zzdz.a);
        Object obj2 = null;
        if (b == null) {
            cp cpVar = new cp(this.h, zzdz.a);
            cpVar.a(this.h.q().r());
            cpVar.c(b2);
            b = cpVar;
            obj2 = 1;
        } else if (!b2.equals(b.e())) {
            b.c(b2);
            b.a(this.h.q().r());
            int obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.b) || zzdz.b.equals(b.d()))) {
            b.b(zzdz.b);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.k) || zzdz.k.equals(b.f()))) {
            b.d(zzdz.k);
            obj22 = 1;
        }
        if (!(zzdz.e == 0 || zzdz.e == b.l())) {
            b.d(zzdz.e);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.c) || zzdz.c.equals(b.i()))) {
            b.e(zzdz.c);
            obj22 = 1;
        }
        if (zzdz.j != b.j()) {
            b.c(zzdz.j);
            obj22 = 1;
        }
        if (!(zzdz.d == null || zzdz.d.equals(b.k()))) {
            b.f(zzdz.d);
            obj22 = 1;
        }
        if (zzdz.f != b.m()) {
            b.e(zzdz.f);
            obj22 = 1;
        }
        if (zzdz.h != b.n()) {
            b.a(zzdz.h);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.g) || zzdz.g.equals(b.y()))) {
            b.g(zzdz.g);
            obj22 = 1;
        }
        if (zzdz.l != b.A()) {
            b.o(zzdz.l);
            obj22 = 1;
        }
        if (zzdz.o != b.B()) {
            b.b(zzdz.o);
            obj22 = 1;
        }
        if (zzdz.p != b.C()) {
            b.c(zzdz.p);
        } else {
            obj = obj22;
        }
        if (obj != null) {
            z().a(b);
        }
        return b;
    }

    private final dx e() {
        if (this.e != null) {
            return this.e;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final hs f() {
        b(this.f);
        return this.f;
    }

    private final long g() {
        long currentTimeMillis = zzbt().currentTimeMillis();
        fn c = c();
        c.B();
        c.c();
        long a = c.g.a();
        if (a == 0) {
            a = 1 + ((long) c.l().s().nextInt(86400000));
            c.g.a(a);
        }
        return ((((a + currentTimeMillis) / 1000) / 60) / 60) / 24;
    }

    private final boolean h() {
        s();
        B();
        return z().z() || !TextUtils.isEmpty(z().u());
    }

    @WorkerThread
    private final void i() {
        s();
        B();
        if (n()) {
            long abs;
            if (this.k > 0) {
                abs = 3600000 - Math.abs(zzbt().elapsedRealtime() - this.k);
                if (abs > 0) {
                    zzge().y().a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    e().b();
                    f().q();
                    return;
                }
                this.k = 0;
            }
            if (this.h.x() && h()) {
                long currentTimeMillis = zzbt().currentTimeMillis();
                long max = Math.max(0, ((Long) dg.B.b()).longValue());
                Object obj = (z().A() || z().v()) ? 1 : null;
                if (obj != null) {
                    CharSequence t = b().t();
                    abs = (TextUtils.isEmpty(t) || ".none.".equals(t)) ? Math.max(0, ((Long) dg.v.b()).longValue()) : Math.max(0, ((Long) dg.w.b()).longValue());
                } else {
                    abs = Math.max(0, ((Long) dg.u.b()).longValue());
                }
                long a = c().c.a();
                long a2 = c().d.a();
                long max2 = Math.max(z().x(), z().y());
                if (max2 == 0) {
                    currentTimeMillis = 0;
                } else {
                    max2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                    a2 = currentTimeMillis - Math.abs(a2 - currentTimeMillis);
                    a = Math.max(currentTimeMillis - Math.abs(a - currentTimeMillis), a2);
                    currentTimeMillis = max2 + max;
                    if (obj != null && a > 0) {
                        currentTimeMillis = Math.min(max2, a) + abs;
                    }
                    if (!k().a(a, abs)) {
                        currentTimeMillis = a + abs;
                    }
                    if (a2 != 0 && a2 >= max2) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= Math.min(20, Math.max(0, ((Integer) dg.D.b()).intValue()))) {
                                currentTimeMillis = 0;
                                break;
                            }
                            currentTimeMillis += (1 << i2) * Math.max(0, ((Long) dg.C.b()).longValue());
                            if (currentTimeMillis > a2) {
                                break;
                            }
                            i = i2 + 1;
                        }
                    }
                }
                if (currentTimeMillis == 0) {
                    zzge().y().a("Next upload time is 0");
                    e().b();
                    f().q();
                    return;
                } else if (y().q()) {
                    long a3 = c().e.a();
                    abs = Math.max(0, ((Long) dg.s.b()).longValue());
                    abs = !k().a(a3, abs) ? Math.max(currentTimeMillis, abs + a3) : currentTimeMillis;
                    e().b();
                    abs -= zzbt().currentTimeMillis();
                    if (abs <= 0) {
                        abs = Math.max(0, ((Long) dg.x.b()).longValue());
                        c().c.a(zzbt().currentTimeMillis());
                    }
                    zzge().y().a("Upload scheduled in approximately ms", Long.valueOf(abs));
                    f().a(abs);
                    return;
                } else {
                    zzge().y().a("No network");
                    e().a();
                    f().q();
                    return;
                }
            }
            zzge().y().a("Nothing to upload or uploading impossible");
            e().b();
            f().q();
        }
    }

    @WorkerThread
    private final void j() {
        s();
        if (this.o || this.p || this.q) {
            zzge().y().a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.o), Boolean.valueOf(this.p), Boolean.valueOf(this.q));
            return;
        }
        zzge().y().a("Stopping uploading service(s)");
        if (this.l != null) {
            for (Runnable run : this.l) {
                run.run();
            }
            this.l.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean m() {
        s();
        try {
            this.s = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.r = this.s.tryLock();
            if (this.r != null) {
                zzge().y().a("Storage concurrent access okay");
                return true;
            }
            zzge().r().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzge().r().a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzge().r().a("Failed to access storage lock file", e2);
        }
    }

    @WorkerThread
    private final boolean n() {
        s();
        B();
        return this.j;
    }

    public final cr A() {
        b(this.g);
        return this.g;
    }

    final void B() {
        if (!this.i) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void C() {
        s();
        B();
        this.q = true;
        String u;
        String str;
        try {
            Boolean w = this.h.o().w();
            if (w == null) {
                zzge().u().a("Upload data called on the client side before use of service was decided");
                this.q = false;
                j();
            } else if (w.booleanValue()) {
                zzge().r().a("Upload called in the client side when service should be used");
                this.q = false;
                j();
            } else if (this.k > 0) {
                i();
                this.q = false;
                j();
            } else {
                s();
                if ((this.t != null ? 1 : null) != null) {
                    zzge().y().a("Uploading requested multiple times");
                    this.q = false;
                    j();
                } else if (y().q()) {
                    long currentTimeMillis = zzbt().currentTimeMillis();
                    a(null, currentTimeMillis - ct.s());
                    long a = c().c.a();
                    if (a != 0) {
                        zzge().x().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - a)));
                    }
                    u = z().u();
                    Object a2;
                    if (TextUtils.isEmpty(u)) {
                        this.c = -1;
                        a2 = z().a(currentTimeMillis - ct.s());
                        if (!TextUtils.isEmpty(a2)) {
                            cp b = z().b(a2);
                            if (b != null) {
                                a(b);
                            }
                        }
                    } else {
                        if (this.c == -1) {
                            this.c = z().B();
                        }
                        List<Pair> a3 = z().a(u, b().b(u, dg.h), Math.max(0, b().b(u, dg.i)));
                        if (!a3.isEmpty()) {
                            iu iuVar;
                            Object obj;
                            int i;
                            int i2;
                            List subList;
                            for (Pair pair : a3) {
                                iuVar = (iu) pair.first;
                                if (!TextUtils.isEmpty(iuVar.u)) {
                                    obj = iuVar.u;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                i = 0;
                                while (true) {
                                    i2 = i;
                                    if (i2 >= a3.size()) {
                                        break;
                                    }
                                    iuVar = (iu) ((Pair) a3.get(i2)).first;
                                    if (!TextUtils.isEmpty(iuVar.u) && !iuVar.u.equals(obj)) {
                                        subList = a3.subList(0, i2);
                                        break;
                                    }
                                    i = i2 + 1;
                                }
                            }
                            subList = a3;
                            it itVar = new it();
                            itVar.c = new iu[subList.size()];
                            Collection arrayList = new ArrayList(subList.size());
                            Object obj2 = (ct.u() && b().c(u)) ? 1 : null;
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= itVar.c.length) {
                                    break;
                                }
                                itVar.c[i2] = (iu) ((Pair) subList.get(i2)).first;
                                arrayList.add((Long) ((Pair) subList.get(i2)).second);
                                itVar.c[i2].t = Long.valueOf(12451);
                                itVar.c[i2].f = Long.valueOf(currentTimeMillis);
                                itVar.c[i2].B = Boolean.valueOf(false);
                                if (obj2 == null) {
                                    itVar.c[i2].I = null;
                                }
                                i = i2 + 1;
                            }
                            obj2 = zzge().a(2) ? l().a(itVar) : null;
                            obj = k().a(itVar);
                            str = (String) dg.r.b();
                            Object url = new URL(str);
                            ar.b(!arrayList.isEmpty());
                            if (this.t != null) {
                                zzge().r().a("Set uploading progress before finishing the previous upload");
                            } else {
                                this.t = new ArrayList(arrayList);
                            }
                            c().d.a(currentTimeMillis);
                            a2 = "?";
                            if (itVar.c.length > 0) {
                                a2 = itVar.c[0].q;
                            }
                            zzge().y().a("Uploading data. app, uncompressed size, data", a2, Integer.valueOf(obj.length), obj2);
                            this.p = true;
                            fn y = y();
                            Object hxVar = new hx(this, u);
                            y.c();
                            y.J();
                            ar.a(url);
                            ar.a(obj);
                            ar.a(hxVar);
                            y.zzgd().b(new dw(y, u, url, obj, null, hxVar));
                        }
                    }
                    this.q = false;
                    j();
                } else {
                    zzge().y().a("Network not connected, ignoring upload request");
                    i();
                    this.q = false;
                    j();
                }
            }
        } catch (MalformedURLException e) {
            zzge().r().a("Failed to parse upload URL. Not uploading. appId", dp.a(u), str);
        } catch (Throwable th) {
            this.q = false;
            j();
        }
    }

    @WorkerThread
    final void D() {
        s();
        B();
        if (!this.j) {
            zzge().w().a("This instance being marked as an uploader");
            s();
            B();
            if (n() && m()) {
                int a = a(this.s);
                int u = this.h.q().u();
                s();
                if (a > u) {
                    zzge().r().a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a), Integer.valueOf(u));
                } else if (a < u) {
                    if (a(u, this.s)) {
                        zzge().y().a("Storage version upgraded. Previous, current version", Integer.valueOf(a), Integer.valueOf(u));
                    } else {
                        zzge().r().a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a), Integer.valueOf(u));
                    }
                }
            }
            this.j = true;
            i();
        }
    }

    final void E() {
        this.n++;
    }

    final es F() {
        return this.h;
    }

    @WorkerThread
    final zzdz a(String str) {
        cp b = z().b(str);
        if (b == null || TextUtils.isEmpty(b.i())) {
            zzge().x().a("No app data available; dropping", str);
            return null;
        }
        Boolean b2 = b(b);
        if (b2 == null || b2.booleanValue()) {
            return new zzdz(str, b.d(), b.i(), b.j(), b.k(), b.l(), b.m(), null, b.n(), false, b.f(), b.A(), 0, 0, b.B(), b.C(), false);
        }
        zzge().r().a("App version does not match; dropping. appId", dp.a(str));
        return null;
    }

    @WorkerThread
    protected void a() {
        s();
        z().w();
        if (c().c.a() == 0) {
            c().c.a(zzbt().currentTimeMillis());
        }
        i();
    }

    @WorkerThread
    @VisibleForTesting
    protected final void a(int i, Throwable th, byte[] bArr, String str) {
        s();
        B();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.p = false;
                j();
            }
        }
        List<Long> list = this.t;
        this.t = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                c().c.a(zzbt().currentTimeMillis());
                c().d.a(0);
                i();
                zzge().y().a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                z().q();
                try {
                    for (Long l : list) {
                        fn z;
                        try {
                            z = z();
                            long longValue = l.longValue();
                            z.c();
                            z.J();
                            if (z.t().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            z.zzge().r().a("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.u == null || !this.u.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    z().r();
                    this.u = null;
                    if (y().q() && h()) {
                        C();
                    } else {
                        this.c = -1;
                        i();
                    }
                    this.k = 0;
                } finally {
                    z().s();
                }
            } catch (SQLiteException e3) {
                zzge().r().a("Database error while trying to delete uploaded bundles", e3);
                this.k = zzbt().elapsedRealtime();
                zzge().y().a("Disable upload, time", Long.valueOf(this.k));
            }
        } else {
            zzge().y().a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            c().d.a(zzbt().currentTimeMillis());
            boolean z2 = i == 503 || i == 429;
            if (z2) {
                c().e.a(zzbt().currentTimeMillis());
            }
            if (b().g(str)) {
                z().a((List) list);
            }
            i();
        }
        this.p = false;
        j();
    }

    final void a(es esVar) {
        this.h = esVar;
    }

    final void a(hv hvVar) {
        this.m++;
    }

    @WorkerThread
    final void a(ib ibVar) {
        s();
        hv cvVar = new cv(this.h);
        cvVar.K();
        this.d = cvVar;
        b().a(this.a);
        cvVar = new cr(this.h);
        cvVar.K();
        this.g = cvVar;
        cvVar = new hs(this.h);
        cvVar.K();
        this.f = cvVar;
        this.e = new dx(this.h);
        if (this.m != this.n) {
            zzge().r().a("Not all upload components initialized", Integer.valueOf(this.m), Integer.valueOf(this.n));
        }
        this.i = true;
    }

    final void a(zzdz zzdz) {
        s();
        B();
        ar.a(zzdz.a);
        e(zzdz);
    }

    @WorkerThread
    final void a(zzed zzed, zzdz zzdz) {
        boolean z = true;
        ar.a((Object) zzed);
        ar.a(zzed.a);
        ar.a(zzed.b);
        ar.a(zzed.c);
        ar.a(zzed.c.a);
        s();
        B();
        if (!TextUtils.isEmpty(zzdz.b)) {
            if (zzdz.h) {
                zzed zzed2 = new zzed(zzed);
                zzed2.e = false;
                z().q();
                try {
                    zzed d = z().d(zzed2.a, zzed2.c.a);
                    if (!(d == null || d.b.equals(zzed2.b))) {
                        zzge().u().a("Updating a conditional user property with different origin. name, origin, origin (from DB)", l().c(zzed2.c.a), zzed2.b, d.b);
                    }
                    if (d != null && d.e) {
                        zzed2.b = d.b;
                        zzed2.d = d.d;
                        zzed2.h = d.h;
                        zzed2.f = d.f;
                        zzed2.i = d.i;
                        zzed2.e = d.e;
                        zzed2.c = new zzjx(zzed2.c.a, d.c.b, zzed2.c.a(), d.c.c);
                        z = false;
                    } else if (TextUtils.isEmpty(zzed2.f)) {
                        zzed2.c = new zzjx(zzed2.c.a, zzed2.d, zzed2.c.a(), zzed2.c.c);
                        zzed2.e = true;
                    } else {
                        z = false;
                    }
                    if (zzed2.e) {
                        zzjx zzjx = zzed2.c;
                        id idVar = new id(zzed2.a, zzed2.b, zzjx.a, zzjx.b, zzjx.a());
                        if (z().a(idVar)) {
                            zzge().x().a("User property updated immediately", zzed2.a, l().c(idVar.c), idVar.e);
                        } else {
                            zzge().r().a("(2)Too many active user properties, ignoring", dp.a(zzed2.a), l().c(idVar.c), idVar.e);
                        }
                        if (z && zzed2.i != null) {
                            b(new zzeu(zzed2.i, zzed2.d), zzdz);
                        }
                    }
                    if (z().a(zzed2)) {
                        zzge().x().a("Conditional property added", zzed2.a, l().c(zzed2.c.a), zzed2.c.a());
                    } else {
                        zzge().r().a("Too many conditional properties, ignoring", dp.a(zzed2.a), l().c(zzed2.c.a), zzed2.c.a());
                    }
                    z().r();
                } finally {
                    z().s();
                }
            } else {
                e(zzdz);
            }
        }
    }

    @WorkerThread
    final void a(zzeu zzeu, zzdz zzdz) {
        ar.a((Object) zzdz);
        ar.a(zzdz.a);
        s();
        B();
        String str = zzdz.a;
        long j = zzeu.d;
        k();
        if (!ie.a(zzeu, zzdz)) {
            return;
        }
        if (zzdz.h) {
            z().q();
            try {
                List emptyList;
                Object obj;
                fn z = z();
                ar.a(str);
                z.c();
                z.J();
                if (j < 0) {
                    z.zzge().u().a("Invalid time querying timed out conditional properties", dp.a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = z.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzed zzed : emptyList) {
                    if (zzed != null) {
                        zzge().x().a("User property timed out", zzed.a, l().c(zzed.c.a), zzed.c.a());
                        if (zzed.g != null) {
                            b(new zzeu(zzed.g, j), zzdz);
                        }
                        z().e(str, zzed.c.a);
                    }
                }
                z = z();
                ar.a(str);
                z.c();
                z.J();
                if (j < 0) {
                    z.zzge().u().a("Invalid time querying expired conditional properties", dp.a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = z.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r2.size());
                for (zzed zzed2 : r2) {
                    if (zzed2 != null) {
                        zzge().x().a("User property expired", zzed2.a, l().c(zzed2.c.a), zzed2.c.a());
                        z().b(str, zzed2.c.a);
                        if (zzed2.k != null) {
                            arrayList.add(zzed2.k);
                        }
                        z().e(str, zzed2.c.a);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    obj = arrayList2.get(i);
                    i++;
                    b(new zzeu((zzeu) obj, j), zzdz);
                }
                z = z();
                String str2 = zzeu.a;
                ar.a(str);
                ar.a(str2);
                z.c();
                z.J();
                if (j < 0) {
                    z.zzge().u().a("Invalid time querying triggered conditional properties", dp.a(str), z.k().a(str2), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = z.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(r2.size());
                for (zzed zzed3 : r2) {
                    if (zzed3 != null) {
                        zzjx zzjx = zzed3.c;
                        id idVar = new id(zzed3.a, zzed3.b, zzjx.a, j, zzjx.a());
                        if (z().a(idVar)) {
                            zzge().x().a("User property triggered", zzed3.a, l().c(idVar.c), idVar.e);
                        } else {
                            zzge().r().a("Too many active user properties, ignoring", dp.a(zzed3.a), l().c(idVar.c), idVar.e);
                        }
                        if (zzed3.i != null) {
                            arrayList3.add(zzed3.i);
                        }
                        zzed3.c = new zzjx(idVar);
                        zzed3.e = true;
                        z().a(zzed3);
                    }
                }
                b(zzeu, zzdz);
                arrayList2 = (ArrayList) arrayList3;
                int size2 = arrayList2.size();
                i = 0;
                while (i < size2) {
                    obj = arrayList2.get(i);
                    i++;
                    b(new zzeu((zzeu) obj, j), zzdz);
                }
                z().r();
            } finally {
                z().s();
            }
        } else {
            e(zzdz);
        }
    }

    @WorkerThread
    final void a(zzeu zzeu, String str) {
        cp b = z().b(str);
        if (b == null || TextUtils.isEmpty(b.i())) {
            zzge().x().a("No app data available; dropping event", str);
            return;
        }
        Boolean b2 = b(b);
        if (b2 == null) {
            if (!"_ui".equals(zzeu.a)) {
                zzge().u().a("Could not find package. appId", dp.a(str));
            }
        } else if (!b2.booleanValue()) {
            zzge().r().a("App version does not match; dropping event. appId", dp.a(str));
            return;
        }
        zzeu zzeu2 = zzeu;
        a(zzeu2, new zzdz(str, b.d(), b.i(), b.j(), b.k(), b.l(), b.m(), null, b.n(), false, b.f(), b.A(), 0, 0, b.B(), b.C(), false));
    }

    @WorkerThread
    final void a(zzjx zzjx, zzdz zzdz) {
        int i = 0;
        s();
        B();
        if (!TextUtils.isEmpty(zzdz.b)) {
            if (zzdz.h) {
                int d = k().d(zzjx.a);
                String a;
                if (d != 0) {
                    k();
                    a = ie.a(zzjx.a, 24, true);
                    if (zzjx.a != null) {
                        i = zzjx.a.length();
                    }
                    k().a(zzdz.a, d, "_ev", a, i);
                    return;
                }
                d = k().b(zzjx.a, zzjx.a());
                if (d != 0) {
                    k();
                    a = ie.a(zzjx.a, 24, true);
                    Object a2 = zzjx.a();
                    if (a2 != null && ((a2 instanceof String) || (a2 instanceof CharSequence))) {
                        i = String.valueOf(a2).length();
                    }
                    k().a(zzdz.a, d, "_ev", a, i);
                    return;
                }
                Object c = k().c(zzjx.a, zzjx.a());
                if (c != null) {
                    id idVar = new id(zzdz.a, zzjx.c, zzjx.a, zzjx.b, c);
                    zzge().x().a("Setting user property", l().c(idVar.c), c);
                    z().q();
                    try {
                        e(zzdz);
                        boolean a3 = z().a(idVar);
                        z().r();
                        if (a3) {
                            zzge().x().a("User property set", l().c(idVar.c), idVar.e);
                        } else {
                            zzge().r().a("Too many unique user properties are set. Ignoring user property", l().c(idVar.c), idVar.e);
                            k().a(zzdz.a, 9, null, null, 0);
                        }
                        z().s();
                        return;
                    } catch (Throwable th) {
                        z().s();
                    }
                } else {
                    return;
                }
            }
            e(zzdz);
        }
    }

    @WorkerThread
    final void a(Runnable runnable) {
        s();
        if (this.l == null) {
            this.l = new ArrayList();
        }
        this.l.add(runnable);
    }

    @WorkerThread
    @VisibleForTesting
    final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        s();
        B();
        ar.a(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.o = false;
                j();
            }
        }
        zzge().y().a("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        z().q();
        cp b = z().b(str);
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (b == null) {
            zzge().u().a("App does not exist in onConfigFetched. appId", dp.a(str));
        } else if (z2 || i == 404) {
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i == 404 || i == 304) {
                if (d().a(str) == null && !d().a(str, null, null)) {
                    z().s();
                    this.o = false;
                    j();
                    return;
                }
            } else if (!d().a(str, bArr, str2)) {
                z().s();
                this.o = false;
                j();
                return;
            }
            b.g(zzbt().currentTimeMillis());
            z().a(b);
            if (i == 404) {
                zzge().v().a("Config not found. Using empty config. appId", str);
            } else {
                zzge().y().a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (y().q() && h()) {
                C();
            } else {
                i();
            }
        } else {
            b.h(zzbt().currentTimeMillis());
            z().a(b);
            zzge().y().a("Fetching config failed. code, error", Integer.valueOf(i), th);
            d().c(str);
            c().d.a(zzbt().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                c().e.a(zzbt().currentTimeMillis());
            }
            i();
        }
        z().r();
        z().s();
        this.o = false;
        j();
    }

    public final void a(boolean z) {
        i();
    }

    public ct b() {
        return this.h.b();
    }

    @WorkerThread
    @VisibleForTesting
    final void b(zzdz zzdz) {
        if (this.t != null) {
            this.u = new ArrayList();
            this.u.addAll(this.t);
        }
        fn z = z();
        String str = zzdz.a;
        ar.a(str);
        z.c();
        z.J();
        try {
            SQLiteDatabase t = z.t();
            String[] strArr = new String[]{str};
            int delete = t.delete("main_event_params", "app_id=?", strArr) + ((((((((t.delete("apps", "app_id=?", strArr) + 0) + t.delete("events", "app_id=?", strArr)) + t.delete("user_attributes", "app_id=?", strArr)) + t.delete("conditional_properties", "app_id=?", strArr)) + t.delete("raw_events", "app_id=?", strArr)) + t.delete("raw_events_metadata", "app_id=?", strArr)) + t.delete("queue", "app_id=?", strArr)) + t.delete("audience_filter_values", "app_id=?", strArr));
            if (delete > 0) {
                z.zzge().y().a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            z.zzge().r().a("Error resetting analytics data. appId, error", dp.a(str), e);
        }
        zzdz a = a(getContext(), zzdz.a, zzdz.b, zzdz.h, zzdz.o, zzdz.p, zzdz.m);
        if (!b().i(zzdz.a) || zzdz.h) {
            c(a);
        }
    }

    @WorkerThread
    final void b(zzed zzed, zzdz zzdz) {
        ar.a((Object) zzed);
        ar.a(zzed.a);
        ar.a(zzed.c);
        ar.a(zzed.c.a);
        s();
        B();
        if (!TextUtils.isEmpty(zzdz.b)) {
            if (zzdz.h) {
                z().q();
                try {
                    e(zzdz);
                    zzed d = z().d(zzed.a, zzed.c.a);
                    if (d != null) {
                        zzge().x().a("Removing conditional user property", zzed.a, l().c(zzed.c.a));
                        z().e(zzed.a, zzed.c.a);
                        if (d.e) {
                            z().b(zzed.a, zzed.c.a);
                        }
                        if (zzed.k != null) {
                            Bundle bundle = null;
                            if (zzed.k.b != null) {
                                bundle = zzed.k.b.b();
                            }
                            b(k().a(zzed.k.a, bundle, d.b, zzed.k.d, true, false), zzdz);
                        }
                    } else {
                        zzge().u().a("Conditional user property doesn't exist", dp.a(zzed.a), l().c(zzed.c.a));
                    }
                    z().r();
                } finally {
                    z().s();
                }
            } else {
                e(zzdz);
            }
        }
    }

    @WorkerThread
    final void b(zzjx zzjx, zzdz zzdz) {
        s();
        B();
        if (!TextUtils.isEmpty(zzdz.b)) {
            if (zzdz.h) {
                zzge().x().a("Removing user property", l().c(zzjx.a));
                z().q();
                try {
                    e(zzdz);
                    z().b(zzdz.a, zzjx.a);
                    z().r();
                    zzge().x().a("User property removed", l().c(zzjx.a));
                } finally {
                    z().s();
                }
            } else {
                e(zzdz);
            }
        }
    }

    @WorkerThread
    public final byte[] b(@NonNull zzeu zzeu, @Size(min = 1) String str) {
        B();
        s();
        es.v();
        ar.a((Object) zzeu);
        ar.a(str);
        p itVar = new it();
        z().q();
        try {
            cp b = z().b(str);
            byte[] bArr;
            if (b == null) {
                zzge().x().a("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (b.n()) {
                iw iwVar;
                long j;
                if (("_iap".equals(zzeu.a) || "ecommerce_purchase".equals(zzeu.a)) && !a(str, zzeu)) {
                    zzge().u().a("Failed to handle purchase event at single event bundle creation. appId", dp.a(str));
                }
                boolean e = b().e(str);
                Long valueOf = Long.valueOf(0);
                if (e && "_e".equals(zzeu.a)) {
                    if (zzeu.b == null || zzeu.b.a() == 0) {
                        zzge().u().a("The engagement event does not contain any parameters. appId", dp.a(str));
                    } else if (zzeu.b.b("_et") == null) {
                        zzge().u().a("The engagement event does not include duration. appId", dp.a(str));
                    } else {
                        valueOf = zzeu.b.b("_et");
                    }
                }
                iu iuVar = new iu();
                itVar.c = new iu[]{iuVar};
                iuVar.c = Integer.valueOf(1);
                iuVar.k = "android";
                iuVar.q = b.b();
                iuVar.p = b.k();
                iuVar.r = b.i();
                long j2 = b.j();
                iuVar.E = j2 == -2147483648L ? null : Integer.valueOf((int) j2);
                iuVar.s = Long.valueOf(b.l());
                iuVar.A = b.d();
                iuVar.x = Long.valueOf(b.m());
                if (this.h.t() && ct.u() && b().c(iuVar.q)) {
                    iuVar.I = null;
                }
                Pair a = c().a(b.b());
                if (!(!b.B() || a == null || TextUtils.isEmpty((CharSequence) a.first))) {
                    iuVar.u = (String) a.first;
                    iuVar.v = (Boolean) a.second;
                }
                p().B();
                iuVar.m = Build.MODEL;
                p().B();
                iuVar.l = VERSION.RELEASE;
                iuVar.o = Integer.valueOf((int) p().q());
                iuVar.n = p().r();
                iuVar.w = b.c();
                iuVar.D = b.f();
                List a2 = z().a(b.b());
                iuVar.e = new iw[a2.size()];
                id idVar = null;
                if (e) {
                    id c = z().c(iuVar.q, "_lte");
                    idVar = (c == null || c.e == null) ? new id(iuVar.q, "auto", "_lte", zzbt().currentTimeMillis(), valueOf) : valueOf.longValue() > 0 ? new id(iuVar.q, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) c.e).longValue() + valueOf.longValue())) : c;
                }
                iw iwVar2 = null;
                int i = 0;
                while (i < a2.size()) {
                    iw iwVar3;
                    iwVar = new iw();
                    iuVar.e[i] = iwVar;
                    iwVar.d = ((id) a2.get(i)).c;
                    iwVar.c = Long.valueOf(((id) a2.get(i)).d);
                    k().a(iwVar, ((id) a2.get(i)).e);
                    if (e && "_lte".equals(iwVar.d)) {
                        iwVar.f = (Long) idVar.e;
                        iwVar.c = Long.valueOf(zzbt().currentTimeMillis());
                        iwVar3 = iwVar;
                    } else {
                        iwVar3 = iwVar2;
                    }
                    i++;
                    iwVar2 = iwVar3;
                }
                if (e && iwVar2 == null) {
                    iwVar = new iw();
                    iwVar.d = "_lte";
                    iwVar.c = Long.valueOf(zzbt().currentTimeMillis());
                    iwVar.f = (Long) idVar.e;
                    iuVar.e = (iw[]) Arrays.copyOf(iuVar.e, iuVar.e.length + 1);
                    iuVar.e[iuVar.e.length - 1] = iwVar;
                }
                if (valueOf.longValue() > 0) {
                    z().a(idVar);
                }
                Bundle b2 = zzeu.b.b();
                if ("_iap".equals(zzeu.a)) {
                    b2.putLong("_c", 1);
                    zzge().x().a("Marking in-app purchase as real-time");
                    b2.putLong("_r", 1);
                }
                b2.putString("_o", zzeu.c);
                if (k().i(iuVar.q)) {
                    k().a(b2, "_dbg", Long.valueOf(1));
                    k().a(b2, "_r", Long.valueOf(1));
                }
                dc a3 = z().a(str, zzeu.a);
                if (a3 == null) {
                    z().a(new dc(str, zzeu.a, 1, 0, zzeu.d, 0, null, null, null));
                    j = 0;
                } else {
                    j = a3.e;
                    z().a(a3.a(zzeu.d).a());
                }
                db dbVar = new db(this.h, zzeu.c, str, zzeu.a, zzeu.d, j, b2);
                ir irVar = new ir();
                iuVar.d = new ir[]{irVar};
                irVar.e = Long.valueOf(dbVar.c);
                irVar.d = dbVar.b;
                irVar.f = Long.valueOf(dbVar.d);
                irVar.c = new is[dbVar.e.a()];
                Iterator it = dbVar.e.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    is isVar = new is();
                    i = i2 + 1;
                    irVar.c[i2] = isVar;
                    isVar.c = str2;
                    k().a(isVar, dbVar.e.a(str2));
                    i2 = i;
                }
                iuVar.C = a(b.b(), iuVar.e, iuVar.d);
                iuVar.g = irVar.e;
                iuVar.h = irVar.e;
                j2 = b.h();
                iuVar.j = j2 != 0 ? Long.valueOf(j2) : null;
                long g = b.g();
                if (g != 0) {
                    j2 = g;
                }
                iuVar.i = j2 != 0 ? Long.valueOf(j2) : null;
                b.r();
                iuVar.y = Integer.valueOf((int) b.o());
                iuVar.t = Long.valueOf(12451);
                iuVar.f = Long.valueOf(zzbt().currentTimeMillis());
                iuVar.B = Boolean.TRUE;
                b.a(iuVar.g.longValue());
                b.b(iuVar.h.longValue());
                z().a(b);
                z().r();
                z().s();
                try {
                    bArr = new byte[itVar.d()];
                    i a4 = i.a(bArr, 0, bArr.length);
                    itVar.a(a4);
                    a4.a();
                    return k().a(bArr);
                } catch (IOException e2) {
                    zzge().r().a("Data loss. Failed to bundle and serialize. appId", dp.a(str), e2);
                    return null;
                }
            } else {
                zzge().x().a("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                z().s();
                return bArr;
            }
        } finally {
            z().s();
        }
    }

    public dz c() {
        return this.h.c();
    }

    @WorkerThread
    public final void c(zzdz zzdz) {
        s();
        B();
        ar.a((Object) zzdz);
        ar.a(zzdz.a);
        if (!TextUtils.isEmpty(zzdz.b)) {
            cp b = z().b(zzdz.a);
            if (!(b == null || !TextUtils.isEmpty(b.d()) || TextUtils.isEmpty(zzdz.b))) {
                b.g(0);
                z().a(b);
                d().d(zzdz.a);
            }
            if (zzdz.h) {
                int i;
                Bundle bundle;
                long j = zzdz.m;
                if (j == 0) {
                    j = zzbt().currentTimeMillis();
                }
                int i2 = zzdz.n;
                if (i2 == 0 || i2 == 1) {
                    i = i2;
                } else {
                    zzge().u().a("Incorrect app type, assuming installed app. appId, appType", dp.a(zzdz.a), Integer.valueOf(i2));
                    i = 0;
                }
                z().q();
                fn z;
                String b2;
                try {
                    b = z().b(zzdz.a);
                    if (!(b == null || b.d() == null || b.d().equals(zzdz.b))) {
                        zzge().u().a("New GMP App Id passed in. Removing cached database data. appId", dp.a(b.b()));
                        z = z();
                        b2 = b.b();
                        z.J();
                        z.c();
                        ar.a(b2);
                        SQLiteDatabase t = z.t();
                        String[] strArr = new String[]{b2};
                        i2 = t.delete("audience_filter_values", "app_id=?", strArr) + ((((((((t.delete("events", "app_id=?", strArr) + 0) + t.delete("user_attributes", "app_id=?", strArr)) + t.delete("conditional_properties", "app_id=?", strArr)) + t.delete("apps", "app_id=?", strArr)) + t.delete("raw_events", "app_id=?", strArr)) + t.delete("raw_events_metadata", "app_id=?", strArr)) + t.delete("event_filters", "app_id=?", strArr)) + t.delete("property_filters", "app_id=?", strArr));
                        if (i2 > 0) {
                            z.zzge().y().a("Deleted application data. app, records", b2, Integer.valueOf(i2));
                        }
                        b = null;
                    }
                } catch (SQLiteException e) {
                    z.zzge().r().a("Error deleting application data. appId, error", dp.a(b2), e);
                } catch (Throwable th) {
                    z().s();
                }
                if (b != null) {
                    if (b.j() != -2147483648L) {
                        if (b.j() != zzdz.j) {
                            bundle = new Bundle();
                            bundle.putString("_pv", b.i());
                            a(new zzeu("_au", new zzer(bundle), "auto", j), zzdz);
                        }
                    } else if (!(b.i() == null || b.i().equals(zzdz.c))) {
                        bundle = new Bundle();
                        bundle.putString("_pv", b.i());
                        a(new zzeu("_au", new zzer(bundle), "auto", j), zzdz);
                    }
                }
                e(zzdz);
                dc dcVar = null;
                if (i == 0) {
                    dcVar = z().a(zzdz.a, "_f");
                } else if (i == 1) {
                    dcVar = z().a(zzdz.a, "_v");
                }
                if (dcVar == null) {
                    long j2 = (1 + (j / 3600000)) * 3600000;
                    if (i == 0) {
                        a(new zzjx("_fot", j, Long.valueOf(j2), "auto"), zzdz);
                        s();
                        B();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1);
                        bundle2.putLong("_r", 1);
                        bundle2.putLong("_uwa", 0);
                        bundle2.putLong("_pfo", 0);
                        bundle2.putLong("_sys", 0);
                        bundle2.putLong("_sysu", 0);
                        if (b().i(zzdz.a) && zzdz.q) {
                            bundle2.putLong("_dac", 1);
                        }
                        if (getContext().getPackageManager() == null) {
                            zzge().r().a("PackageManager is null, first open report might be inaccurate. appId", dp.a(zzdz.a));
                        } else {
                            ApplicationInfo a;
                            PackageInfo packageInfo = null;
                            try {
                                packageInfo = c.b(getContext()).b(zzdz.a, 0);
                            } catch (NameNotFoundException e2) {
                                zzge().r().a("Package info is null, first open report might be inaccurate. appId", dp.a(zzdz.a), e2);
                            }
                            if (packageInfo != null) {
                                if (packageInfo.firstInstallTime != 0) {
                                    Object obj = null;
                                    if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                        bundle2.putLong("_uwa", 1);
                                    } else {
                                        obj = 1;
                                    }
                                    a(new zzjx("_fi", j, Long.valueOf(obj != null ? 1 : 0), "auto"), zzdz);
                                }
                            }
                            try {
                                a = c.b(getContext()).a(zzdz.a, 0);
                            } catch (NameNotFoundException e22) {
                                zzge().r().a("Application info is null, first open report might be inaccurate. appId", dp.a(zzdz.a), e22);
                                a = null;
                            }
                            if (a != null) {
                                if ((a.flags & 1) != 0) {
                                    bundle2.putLong("_sys", 1);
                                }
                                if ((a.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", 1);
                                }
                            }
                        }
                        fn z2 = z();
                        String str = zzdz.a;
                        ar.a(str);
                        z2.c();
                        z2.J();
                        j2 = z2.h(str, "first_open_count");
                        if (j2 >= 0) {
                            bundle2.putLong("_pfo", j2);
                        }
                        a(new zzeu("_f", new zzer(bundle2), "auto", j), zzdz);
                    } else if (i == 1) {
                        a(new zzjx("_fvt", j, Long.valueOf(j2), "auto"), zzdz);
                        s();
                        B();
                        bundle = new Bundle();
                        bundle.putLong("_c", 1);
                        bundle.putLong("_r", 1);
                        if (b().i(zzdz.a) && zzdz.q) {
                            bundle.putLong("_dac", 1);
                        }
                        a(new zzeu("_v", new zzer(bundle), "auto", j), zzdz);
                    }
                    bundle = new Bundle();
                    bundle.putLong("_et", 1);
                    a(new zzeu("_e", new zzer(bundle), "auto", j), zzdz);
                } else if (zzdz.i) {
                    a(new zzeu("_cd", new zzer(new Bundle()), "auto", j), zzdz);
                }
                z().r();
                z().s();
                return;
            }
            e(zzdz);
        }
    }

    public final String d(zzdz zzdz) {
        Object e;
        try {
            return (String) zzgd().a(new hz(this, zzdz)).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        } catch (ExecutionException e4) {
            e = e4;
        }
        zzge().r().a("Failed to get app instance id. appId", dp.a(zzdz.a), e);
        return null;
    }

    public Context getContext() {
        return this.h.getContext();
    }

    public ie k() {
        return this.h.k();
    }

    public dn l() {
        return this.h.l();
    }

    public da p() {
        return this.h.p();
    }

    @WorkerThread
    public void s() {
        zzgd().c();
    }

    public final dt y() {
        b(this.b);
        return this.b;
    }

    public final cv z() {
        b(this.d);
        return this.d;
    }

    public Clock zzbt() {
        return this.h.zzbt();
    }

    public en zzgd() {
        return this.h.zzgd();
    }

    public dp zzge() {
        return this.h.zzge();
    }
}
