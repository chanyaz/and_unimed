package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class amq {
    @VisibleForTesting
    private BlockingQueue<ana> a = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private ExecutorService b;
    @VisibleForTesting
    private LinkedHashMap<String, String> c = new LinkedHashMap();
    @VisibleForTesting
    private Map<String, amu> d = new HashMap();
    @VisibleForTesting
    private String e;
    @VisibleForTesting
    private Context f;
    @VisibleForTesting
    private String g;
    private AtomicBoolean h;
    private File i;

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0000 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    private final void a() {
        /*
        r5 = this;
    L_0x0000:
        r0 = r5.a;	 Catch:{ InterruptedException -> 0x004a }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x004a }
        r0 = (com.google.android.gms.internal.ads.ana) r0;	 Catch:{ InterruptedException -> 0x004a }
        r2 = r0.b();	 Catch:{ InterruptedException -> 0x004a }
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x0000;
    L_0x0012:
        r1 = r5.c;
        r0 = r0.c();
        r0 = r5.a(r1, r0);
        r1 = r5.e;
        r1 = android.net.Uri.parse(r1);
        r3 = r1.buildUpon();
        r0 = r0.entrySet();
        r4 = r0.iterator();
    L_0x002e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0051;
    L_0x0034:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r3.appendQueryParameter(r1, r0);
        goto L_0x002e;
    L_0x004a:
        r0 = move-exception;
        r1 = "CsiReporter:reporter interrupted";
        com.google.android.gms.internal.ads.kk.c(r1, r0);
        return;
    L_0x0051:
        r0 = new java.lang.StringBuilder;
        r1 = r3.build();
        r1 = r1.toString();
        r0.<init>(r1);
        r1 = "&it=";
        r1 = r0.append(r1);
        r1.append(r2);
        r0 = r0.toString();
        r1 = r5.h;
        r1 = r1.get();
        if (r1 == 0) goto L_0x00c3;
    L_0x0073:
        r3 = r5.i;
        if (r3 == 0) goto L_0x00bc;
    L_0x0077:
        r2 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0097, all -> 0x00ad }
        r4 = 1;
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x0097, all -> 0x00ad }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x00d1 }
        r1.write(r0);	 Catch:{ IOException -> 0x00d1 }
        r0 = 10;
        r1.write(r0);	 Catch:{ IOException -> 0x00d1 }
        r1.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0000;
    L_0x008f:
        r0 = move-exception;
        r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
        com.google.android.gms.internal.ads.kk.c(r1, r0);
        goto L_0x0000;
    L_0x0097:
        r0 = move-exception;
        r1 = r2;
    L_0x0099:
        r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt.";
        com.google.android.gms.internal.ads.kk.c(r2, r0);	 Catch:{ all -> 0x00cf }
        if (r1 == 0) goto L_0x0000;
    L_0x00a0:
        r1.close();	 Catch:{ IOException -> 0x00a5 }
        goto L_0x0000;
    L_0x00a5:
        r0 = move-exception;
        r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
        com.google.android.gms.internal.ads.kk.c(r1, r0);
        goto L_0x0000;
    L_0x00ad:
        r0 = move-exception;
        r1 = r2;
    L_0x00af:
        if (r1 == 0) goto L_0x00b4;
    L_0x00b1:
        r1.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b4:
        throw r0;
    L_0x00b5:
        r1 = move-exception;
        r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
        com.google.android.gms.internal.ads.kk.c(r2, r1);
        goto L_0x00b4;
    L_0x00bc:
        r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file.";
        com.google.android.gms.internal.ads.kk.e(r0);
        goto L_0x0000;
    L_0x00c3:
        com.google.android.gms.ads.internal.au.e();
        r1 = r5.f;
        r2 = r5.g;
        com.google.android.gms.internal.ads.ht.a(r1, r2, r0);
        goto L_0x0000;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x00af;
    L_0x00d1:
        r0 = move-exception;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amq.a():void");
    }

    public final amu a(String str) {
        amu amu = (amu) this.d.get(str);
        return amu != null ? amu : amu.a;
    }

    final Map<String, String> a(Map<String, String> map, @Nullable Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, a(str).a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        this.f = context;
        this.g = str;
        this.e = str2;
        this.h = new AtomicBoolean(false);
        this.h.set(((Boolean) akc.f().a(amn.P)).booleanValue());
        if (this.h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.b = Executors.newSingleThreadExecutor();
        this.b.execute(new amr(this));
        this.d.put(c.jD, amu.b);
        this.d.put("ad_format", amu.b);
        this.d.put("e", amu.c);
    }

    public final void a(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.c.put("e", TextUtils.join(",", list));
        }
    }

    public final boolean a(ana ana) {
        return this.a.offer(ana);
    }
}
