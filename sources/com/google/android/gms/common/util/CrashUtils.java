package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class CrashUtils {
    private static final String[] a = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager b = null;
    private static boolean c = false;
    private static boolean d;
    private static boolean e;
    private static int f = -1;
    @GuardedBy("CrashUtils.class")
    private static int g = 0;
    @GuardedBy("CrashUtils.class")
    private static int h = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorDialogData {
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0194 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:41:0x0144} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0197 A:{SYNTHETIC, Splitter: B:75:0x0197} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0194 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:41:0x0144} */
    /* JADX WARNING: Missing block: B:73:0x0194, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:76:?, code:
            r2.close();
     */
    @com.google.android.gms.common.util.VisibleForTesting
    private static synchronized java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10, int r11) {
        /*
        r3 = 0;
        r4 = com.google.android.gms.common.util.CrashUtils.class;
        monitor-enter(r4);
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0180 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5.<init>(r0);	 Catch:{ all -> 0x0180 }
        r0 = "Process: ";
        r0 = r5.append(r0);	 Catch:{ all -> 0x0180 }
        r1 = com.google.android.gms.common.util.r.a(r10);	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = "\n";
        r0.append(r1);	 Catch:{ all -> 0x0180 }
        r0 = "Package: com.google.android.gms";
        r5.append(r0);	 Catch:{ all -> 0x0180 }
        r2 = 12451009; // 0xbdfcc1 float:1.744758E-38 double:6.151616E-317;
        r0 = "12.4.51 (020308-{{cl}})";
        r1 = b();	 Catch:{ all -> 0x0180 }
        if (r1 == 0) goto L_0x0043;
    L_0x002e:
        r1 = com.google.android.gms.common.a.c.b(r8);	 Catch:{ Exception -> 0x0176 }
        r6 = r8.getPackageName();	 Catch:{ Exception -> 0x0176 }
        r7 = 0;
        r1 = r1.b(r6, r7);	 Catch:{ Exception -> 0x0176 }
        r2 = r1.versionCode;	 Catch:{ Exception -> 0x0176 }
        r6 = r1.versionName;	 Catch:{ Exception -> 0x0176 }
        if (r6 == 0) goto L_0x0043;
    L_0x0041:
        r0 = r1.versionName;	 Catch:{ Exception -> 0x0176 }
    L_0x0043:
        r1 = " v";
        r1 = r5.append(r1);	 Catch:{ all -> 0x0180 }
        r1.append(r2);	 Catch:{ all -> 0x0180 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0180 }
        if (r1 != 0) goto L_0x008d;
    L_0x0052:
        r1 = "(";
        r1 = r0.contains(r1);	 Catch:{ all -> 0x0180 }
        if (r1 == 0) goto L_0x007e;
    L_0x005a:
        r1 = ")";
        r1 = r0.contains(r1);	 Catch:{ all -> 0x0180 }
        if (r1 != 0) goto L_0x007e;
    L_0x0062:
        r1 = "-";
        r1 = r0.endsWith(r1);	 Catch:{ all -> 0x0180 }
        if (r1 == 0) goto L_0x0074;
    L_0x006a:
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0180 }
        r1 = "111111111";
        r0 = r0.concat(r1);	 Catch:{ all -> 0x0180 }
    L_0x0074:
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0180 }
        r1 = ")";
        r0 = r0.concat(r1);	 Catch:{ all -> 0x0180 }
    L_0x007e:
        r1 = " (";
        r1 = r5.append(r1);	 Catch:{ all -> 0x0180 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0180 }
        r1 = ")";
        r0.append(r1);	 Catch:{ all -> 0x0180 }
    L_0x008d:
        r0 = "\n";
        r5.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = "Build: ";
        r0 = r5.append(r0);	 Catch:{ all -> 0x0180 }
        r1 = android.os.Build.FINGERPRINT;	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = "\n";
        r0.append(r1);	 Catch:{ all -> 0x0180 }
        r0 = android.os.Debug.isDebuggerConnected();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x00ae;
    L_0x00a9:
        r0 = "Debugger: Connected\n";
        r5.append(r0);	 Catch:{ all -> 0x0180 }
    L_0x00ae:
        if (r11 == 0) goto L_0x00bf;
    L_0x00b0:
        r0 = "DD-EDD: ";
        r0 = r5.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r11);	 Catch:{ all -> 0x0180 }
        r1 = "\n";
        r0.append(r1);	 Catch:{ all -> 0x0180 }
    L_0x00bf:
        r0 = "\n";
        r5.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0180 }
        if (r0 != 0) goto L_0x00cd;
    L_0x00ca:
        r5.append(r9);	 Catch:{ all -> 0x0180 }
    L_0x00cd:
        r0 = b();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x01a9;
    L_0x00d3:
        r0 = "logcat_for_system_app_crash";
        r1 = f;	 Catch:{ all -> 0x0180 }
        if (r1 < 0) goto L_0x0183;
    L_0x00d9:
        r0 = f;	 Catch:{ all -> 0x0180 }
    L_0x00db:
        if (r0 <= 0) goto L_0x0170;
    L_0x00dd:
        r1 = "\n";
        r5.append(r1);	 Catch:{ all -> 0x0180 }
        r2 = 0;
        r1 = new java.lang.ProcessBuilder;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r3 = 13;
        r3 = new java.lang.String[r3];	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 0;
        r7 = "/system/bin/logcat";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 1;
        r7 = "-v";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 2;
        r7 = "time";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 3;
        r7 = "-b";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 4;
        r7 = "events";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 5;
        r7 = "-b";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 6;
        r7 = "system";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 7;
        r7 = "-b";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 8;
        r7 = "main";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 9;
        r7 = "-b";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 10;
        r7 = "crash";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 11;
        r7 = "-t";
        r3[r6] = r7;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r6 = 12;
        r0 = java.lang.String.valueOf(r0);	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r3[r6] = r0;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r1.<init>(r3);	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r0 = 1;
        r0 = r1.redirectErrorStream(r0);	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r0 = r0.start();	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r1 = r0.getOutputStream();	 Catch:{ IOException -> 0x01a7, all -> 0x0194 }
        r1.close();	 Catch:{ IOException -> 0x01a7, all -> 0x0194 }
    L_0x0144:
        r1 = r0.getErrorStream();	 Catch:{ IOException -> 0x01a5, all -> 0x0194 }
        r1.close();	 Catch:{ IOException -> 0x01a5, all -> 0x0194 }
    L_0x014b:
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r0 = r0.getInputStream();	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x01a2, all -> 0x0194 }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new char[r0];	 Catch:{ IOException -> 0x0163 }
    L_0x0158:
        r2 = r1.read(r0);	 Catch:{ IOException -> 0x0163 }
        if (r2 <= 0) goto L_0x018e;
    L_0x015e:
        r3 = 0;
        r5.append(r0, r3, r2);	 Catch:{ IOException -> 0x0163 }
        goto L_0x0158;
    L_0x0163:
        r0 = move-exception;
    L_0x0164:
        r2 = "CrashUtils";
        r3 = "Error running logcat";
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x019f }
        if (r1 == 0) goto L_0x0170;
    L_0x016d:
        r1.close();	 Catch:{ IOException -> 0x019b }
    L_0x0170:
        r0 = r5.toString();	 Catch:{ all -> 0x0180 }
        monitor-exit(r4);
        return r0;
    L_0x0176:
        r1 = move-exception;
        r6 = "CrashUtils";
        r7 = "Error while trying to get the package information! Using static version.";
        android.util.Log.w(r6, r7, r1);	 Catch:{ all -> 0x0180 }
        goto L_0x0043;
    L_0x0180:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0183:
        r1 = r8.getContentResolver();	 Catch:{ all -> 0x0180 }
        r2 = 0;
        r0 = android.provider.Settings.Secure.getInt(r1, r0, r2);	 Catch:{ all -> 0x0180 }
        goto L_0x00db;
    L_0x018e:
        r1.close();	 Catch:{ IOException -> 0x0192 }
        goto L_0x0170;
    L_0x0192:
        r0 = move-exception;
        goto L_0x0170;
    L_0x0194:
        r0 = move-exception;
    L_0x0195:
        if (r2 == 0) goto L_0x019a;
    L_0x0197:
        r2.close();	 Catch:{ IOException -> 0x019d }
    L_0x019a:
        throw r0;	 Catch:{ all -> 0x0180 }
    L_0x019b:
        r0 = move-exception;
        goto L_0x0170;
    L_0x019d:
        r1 = move-exception;
        goto L_0x019a;
    L_0x019f:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0195;
    L_0x01a2:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0164;
    L_0x01a5:
        r1 = move-exception;
        goto L_0x014b;
    L_0x01a7:
        r1 = move-exception;
        goto L_0x0144;
    L_0x01a9:
        r0 = r3;
        goto L_0x00db;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.CrashUtils.a(android.content.Context, java.lang.String, java.lang.String, int):java.lang.String");
    }

    @VisibleForTesting
    private static synchronized Throwable a(Throwable th) {
        Throwable th2;
        int i;
        synchronized (CrashUtils.class) {
            LinkedList linkedList = new LinkedList();
            while (th != null) {
                linkedList.push(th);
                th = th.getCause();
            }
            th2 = null;
            i = 0;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                int i2 = i;
                for (Object obj : stackTrace) {
                    Object obj2;
                    String className = obj2.getClassName();
                    Object fileName = obj2.getFileName();
                    i = (TextUtils.isEmpty(fileName) || !fileName.startsWith(":com.google.android.gms")) ? 0 : 1;
                    i2 |= i;
                    if (i == 0 && !a(className)) {
                        obj2 = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(obj2);
                }
                th2 = th2 == null ? new Throwable("<filtered>") : new Throwable("<filtered>", th2);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                i = i2;
            }
        }
        return i == 0 ? null : th2;
    }

    private static boolean a() {
        return c ? d : false;
    }

    private static synchronized boolean a(Context context, String str, String str2, int i, Throwable th) {
        boolean z;
        synchronized (CrashUtils.class) {
            ar.a((Object) context);
            if (!a() || r.b(str)) {
                z = false;
            } else {
                int hashCode = str.hashCode();
                int hashCode2 = th == null ? h : th.hashCode();
                if (g == hashCode && h == hashCode2) {
                    z = false;
                } else {
                    g = hashCode;
                    h = hashCode2;
                    DropBoxManager dropBoxManager = b != null ? b : (DropBoxManager) context.getSystemService("dropbox");
                    if (dropBoxManager == null || !dropBoxManager.isTagEnabled("system_app_crash")) {
                        z = false;
                    } else {
                        dropBoxManager.addText("system_app_crash", a(context, str, str2, i));
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    public static boolean a(Context context, Throwable th, int i) {
        boolean b;
        try {
            ar.a((Object) context);
            ar.a((Object) th);
            if (!a()) {
                return false;
            }
            if (!b()) {
                th = a(th);
                if (th == null) {
                    return false;
                }
            }
            return a(context, Log.getStackTraceString(th), ProcessUtils.a(), i, th);
        } catch (Throwable e) {
            try {
                b = b();
            } catch (Throwable e2) {
                Log.e("CrashUtils", "Error determining which process we're running in!", e2);
                b = false;
            }
            if (b) {
                throw e;
            }
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String startsWith : a) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        return c ? e : false;
    }
}
