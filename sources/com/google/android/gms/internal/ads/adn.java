package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.g;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class adn {
    private static final String b = adn.class.getSimpleName();
    protected Context a;
    private ExecutorService c;
    private DexClassLoader d;
    private adb e;
    private byte[] f;
    private volatile AdvertisingIdClient g = null;
    private volatile boolean h = false;
    private Future i = null;
    private boolean j;
    private volatile wr k = null;
    private Future l = null;
    private acv m;
    private boolean n = false;
    private boolean o = false;
    private Map<Pair<String, String>, aex> p;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;

    private adn(Context context) {
        boolean z = true;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            z = false;
        }
        this.j = z;
        if (this.j) {
            context = applicationContext;
        }
        this.a = context;
        this.p = new HashMap();
    }

    public static adn a(Context context, String str, String str2, boolean z) {
        boolean z2 = true;
        adn adn = new adn(context);
        File file;
        String str3;
        File file2;
        try {
            adn.c = Executors.newCachedThreadPool(new adq());
            adn.h = z;
            if (z) {
                adn.i = adn.c.submit(new adr(adn));
            }
            adn.c.execute(new adt(adn));
            try {
                g b = g.b();
                adn.n = b.b(adn.a) > 0;
                if (b.a(adn.a) != 0) {
                    z2 = false;
                }
                adn.o = z2;
            } catch (Throwable th) {
            }
            adn.a(0, true);
            if (adw.a()) {
                if (((Boolean) akc.f().a(amn.bM)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            adn.e = new adb(null);
            adn.f = adn.e.a(str);
            File cacheDir = adn.a.getCacheDir();
            if (cacheDir == null) {
                cacheDir = adn.a.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new zzcw();
                }
            }
            file = cacheDir;
            str3 = "1521499837408";
            file2 = new File(String.format("%s/%s.jar", new Object[]{file, str3}));
            if (!file2.exists()) {
                byte[] a = adn.e.a(adn.f, str2);
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(a, 0, a.length);
                fileOutputStream.close();
            }
            adn.b(file, str3);
            adn.d = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, adn.a.getClassLoader());
            a(file2);
            adn.a(file, str3);
            a(String.format("%s/%s.dex", new Object[]{file, str3}));
            if (!adn.s) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                adn.a.registerReceiver(new ado(adn, null), intentFilter);
                adn.s = true;
            }
            adn.m = new acv(adn);
            adn.q = true;
        } catch (Throwable e) {
            throw new zzcw(e);
        } catch (Throwable e2) {
            throw new zzcw(e2);
        } catch (Throwable e22) {
            throw new zzcw(e22);
        } catch (Throwable e222) {
            throw new zzcw(e222);
        } catch (Throwable e2222) {
            throw new zzcw(e2222);
        } catch (zzcw e3) {
        } catch (Throwable th2) {
            a(file2);
            adn.a(file, str3);
            a(String.format("%s/%s.dex", new Object[]{file, str3}));
        }
        return adn;
    }

    private static void a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(b, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A:{SYNTHETIC, Splitter: B:27:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A:{SYNTHETIC, Splitter: B:27:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A:{SYNTHETIC, Splitter: B:36:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A:{SYNTHETIC, Splitter: B:39:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A:{SYNTHETIC, Splitter: B:27:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A:{SYNTHETIC, Splitter: B:27:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A:{SYNTHETIC, Splitter: B:27:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0 A:{SYNTHETIC, Splitter: B:30:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A:{SYNTHETIC, Splitter: B:36:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A:{SYNTHETIC, Splitter: B:39:0x00b1} */
    private final void a(java.io.File r12, java.lang.String r13) {
        /*
        r11 = this;
        r1 = 0;
        r7 = 2;
        r6 = 1;
        r5 = 0;
        r3 = new java.io.File;
        r0 = "%s/%s.tmp";
        r2 = new java.lang.Object[r7];
        r2[r5] = r12;
        r2[r6] = r13;
        r0 = java.lang.String.format(r0, r2);
        r3.<init>(r0);
        r0 = r3.exists();
        if (r0 == 0) goto L_0x001c;
    L_0x001b:
        return;
    L_0x001c:
        r4 = new java.io.File;
        r0 = "%s/%s.dex";
        r2 = new java.lang.Object[r7];
        r2[r5] = r12;
        r2[r6] = r13;
        r0 = java.lang.String.format(r0, r2);
        r4.<init>(r0);
        r0 = r4.exists();
        if (r0 == 0) goto L_0x001b;
    L_0x0033:
        r6 = r4.length();
        r8 = 0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x001b;
    L_0x003d:
        r0 = (int) r6;
        r0 = new byte[r0];
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00d4, NoSuchAlgorithmException -> 0x0097, zzcl -> 0x00de, all -> 0x00a8 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00d4, NoSuchAlgorithmException -> 0x0097, zzcl -> 0x00de, all -> 0x00a8 }
        r5 = r2.read(r0);	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        if (r5 > 0) goto L_0x0052;
    L_0x004b:
        r2.close();	 Catch:{ IOException -> 0x00b8 }
    L_0x004e:
        a(r4);
        goto L_0x001b;
    L_0x0052:
        r5 = new com.google.android.gms.internal.ads.aac;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r5.<init>();	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r6 = r6.getBytes();	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r5.d = r6;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r6 = r13.getBytes();	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r5.c = r6;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r6 = r11.e;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r7 = r11.f;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r0 = r6.a(r7, r0);	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r5.a = r0;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r0 = com.google.android.gms.internal.ads.acd.a(r0);	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r5.b = r0;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r3.createNewFile();	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00cd, zzcl -> 0x00e1, all -> 0x00c6 }
        r1 = com.google.android.gms.internal.ads.abj.a(r5);	 Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x00d1, zzcl -> 0x00e5, all -> 0x00c8 }
        r3 = 0;
        r5 = r1.length;	 Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x00d1, zzcl -> 0x00e5, all -> 0x00c8 }
        r0.write(r1, r3, r5);	 Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x00d1, zzcl -> 0x00e5, all -> 0x00c8 }
        r0.close();	 Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x00d1, zzcl -> 0x00e5, all -> 0x00c8 }
        r2.close();	 Catch:{ IOException -> 0x00ba }
    L_0x0090:
        r0.close();	 Catch:{ IOException -> 0x00bc }
    L_0x0093:
        a(r4);
        goto L_0x001b;
    L_0x0097:
        r0 = move-exception;
        r0 = r1;
    L_0x0099:
        if (r1 == 0) goto L_0x009e;
    L_0x009b:
        r1.close();	 Catch:{ IOException -> 0x00be }
    L_0x009e:
        if (r0 == 0) goto L_0x00a3;
    L_0x00a0:
        r0.close();	 Catch:{ IOException -> 0x00c0 }
    L_0x00a3:
        a(r4);
        goto L_0x001b;
    L_0x00a8:
        r0 = move-exception;
        r2 = r1;
    L_0x00aa:
        if (r2 == 0) goto L_0x00af;
    L_0x00ac:
        r2.close();	 Catch:{ IOException -> 0x00c2 }
    L_0x00af:
        if (r1 == 0) goto L_0x00b4;
    L_0x00b1:
        r1.close();	 Catch:{ IOException -> 0x00c4 }
    L_0x00b4:
        a(r4);
        throw r0;
    L_0x00b8:
        r0 = move-exception;
        goto L_0x004e;
    L_0x00ba:
        r1 = move-exception;
        goto L_0x0090;
    L_0x00bc:
        r0 = move-exception;
        goto L_0x0093;
    L_0x00be:
        r1 = move-exception;
        goto L_0x009e;
    L_0x00c0:
        r0 = move-exception;
        goto L_0x00a3;
    L_0x00c2:
        r2 = move-exception;
        goto L_0x00af;
    L_0x00c4:
        r1 = move-exception;
        goto L_0x00b4;
    L_0x00c6:
        r0 = move-exception;
        goto L_0x00aa;
    L_0x00c8:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x00aa;
    L_0x00cd:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0099;
    L_0x00d1:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0099;
    L_0x00d4:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0099;
    L_0x00d7:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0099;
    L_0x00db:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0099;
    L_0x00de:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0099;
    L_0x00e1:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0099;
    L_0x00e5:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adn.a(java.io.File, java.lang.String):void");
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static boolean b(int i, wr wrVar) {
        if (i < 4) {
            if (wrVar == null) {
                return true;
            }
            if (((Boolean) akc.f().a(amn.bP)).booleanValue() && (wrVar.n == null || wrVar.n.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) akc.f().a(amn.bQ)).booleanValue() && (wrVar.X == null || wrVar.X.a == null || wrVar.X.a.longValue() == -2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8 A:{SYNTHETIC, Splitter: B:51:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A:{SYNTHETIC, Splitter: B:54:0x00dd} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A:{SYNTHETIC, Splitter: B:42:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A:{SYNTHETIC, Splitter: B:45:0x00ce} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8 A:{SYNTHETIC, Splitter: B:51:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A:{SYNTHETIC, Splitter: B:54:0x00dd} */
    private final boolean b(java.io.File r13, java.lang.String r14) {
        /*
        r12 = this;
        r3 = 0;
        r7 = 2;
        r1 = 1;
        r2 = 0;
        r5 = new java.io.File;
        r0 = "%s/%s.tmp";
        r4 = new java.lang.Object[r7];
        r4[r2] = r13;
        r4[r1] = r14;
        r0 = java.lang.String.format(r0, r4);
        r5.<init>(r0);
        r0 = r5.exists();
        if (r0 != 0) goto L_0x001d;
    L_0x001b:
        r0 = r2;
    L_0x001c:
        return r0;
    L_0x001d:
        r6 = new java.io.File;
        r0 = "%s/%s.dex";
        r4 = new java.lang.Object[r7];
        r4[r2] = r13;
        r4[r1] = r14;
        r0 = java.lang.String.format(r0, r4);
        r6.<init>(r0);
        r0 = r6.exists();
        if (r0 == 0) goto L_0x0036;
    L_0x0034:
        r0 = r2;
        goto L_0x001c;
    L_0x0036:
        r8 = r5.length();	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r10 = 0;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x0045;
    L_0x0040:
        a(r5);	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r0 = r2;
        goto L_0x001c;
    L_0x0045:
        r0 = (int) r8;	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r0 = new byte[r0];	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00ff, NoSuchAlgorithmException -> 0x00c4, zzcl -> 0x010a, all -> 0x00d4 }
        r7 = r4.read(r0);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        if (r7 > 0) goto L_0x0062;
    L_0x0053:
        r0 = b;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r1 = "Cannot read the cache data.";
        android.util.Log.d(r0, r1);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        a(r5);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r4.close();	 Catch:{ IOException -> 0x00e1 }
    L_0x0060:
        r0 = r2;
        goto L_0x001c;
    L_0x0062:
        r7 = new com.google.android.gms.internal.ads.aac;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7.<init>();	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r0 = com.google.android.gms.internal.ads.abj.a(r7, r0);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r0 = (com.google.android.gms.internal.ads.aac) r0;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7 = new java.lang.String;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = r0.c;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7 = r14.equals(r7);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        if (r7 == 0) goto L_0x0096;
    L_0x007a:
        r7 = r0.b;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = r0.a;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = com.google.android.gms.internal.ads.acd.a(r8);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7 = java.util.Arrays.equals(r7, r8);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        if (r7 == 0) goto L_0x0096;
    L_0x0088:
        r7 = r0.d;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = r8.getBytes();	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7 = java.util.Arrays.equals(r7, r8);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        if (r7 != 0) goto L_0x009f;
    L_0x0096:
        a(r5);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r4.close();	 Catch:{ IOException -> 0x00e4 }
    L_0x009c:
        r0 = r2;
        goto L_0x001c;
    L_0x009f:
        r5 = r12.e;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r7 = r12.f;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8 = new java.lang.String;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r0 = r0.a;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r8.<init>(r0);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r5 = r5.a(r7, r8);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r6.createNewFile();	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0103, NoSuchAlgorithmException -> 0x00f8, zzcl -> 0x010e, all -> 0x00f2 }
        r3 = 0;
        r6 = r5.length;	 Catch:{ IOException -> 0x0107, NoSuchAlgorithmException -> 0x00fc, zzcl -> 0x0112, all -> 0x00f4 }
        r0.write(r5, r3, r6);	 Catch:{ IOException -> 0x0107, NoSuchAlgorithmException -> 0x00fc, zzcl -> 0x0112, all -> 0x00f4 }
        r4.close();	 Catch:{ IOException -> 0x00e6 }
    L_0x00be:
        r0.close();	 Catch:{ IOException -> 0x00e8 }
    L_0x00c1:
        r0 = r1;
        goto L_0x001c;
    L_0x00c4:
        r0 = move-exception;
        r0 = r3;
        r1 = r3;
    L_0x00c7:
        if (r1 == 0) goto L_0x00cc;
    L_0x00c9:
        r1.close();	 Catch:{ IOException -> 0x00ea }
    L_0x00cc:
        if (r0 == 0) goto L_0x00d1;
    L_0x00ce:
        r0.close();	 Catch:{ IOException -> 0x00ec }
    L_0x00d1:
        r0 = r2;
        goto L_0x001c;
    L_0x00d4:
        r0 = move-exception;
        r4 = r3;
    L_0x00d6:
        if (r4 == 0) goto L_0x00db;
    L_0x00d8:
        r4.close();	 Catch:{ IOException -> 0x00ee }
    L_0x00db:
        if (r3 == 0) goto L_0x00e0;
    L_0x00dd:
        r3.close();	 Catch:{ IOException -> 0x00f0 }
    L_0x00e0:
        throw r0;
    L_0x00e1:
        r0 = move-exception;
        goto L_0x0060;
    L_0x00e4:
        r0 = move-exception;
        goto L_0x009c;
    L_0x00e6:
        r2 = move-exception;
        goto L_0x00be;
    L_0x00e8:
        r0 = move-exception;
        goto L_0x00c1;
    L_0x00ea:
        r1 = move-exception;
        goto L_0x00cc;
    L_0x00ec:
        r0 = move-exception;
        goto L_0x00d1;
    L_0x00ee:
        r1 = move-exception;
        goto L_0x00db;
    L_0x00f0:
        r1 = move-exception;
        goto L_0x00e0;
    L_0x00f2:
        r0 = move-exception;
        goto L_0x00d6;
    L_0x00f4:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
        goto L_0x00d6;
    L_0x00f8:
        r0 = move-exception;
        r0 = r3;
        r1 = r4;
        goto L_0x00c7;
    L_0x00fc:
        r1 = move-exception;
        r1 = r4;
        goto L_0x00c7;
    L_0x00ff:
        r0 = move-exception;
        r0 = r3;
        r1 = r3;
        goto L_0x00c7;
    L_0x0103:
        r0 = move-exception;
        r0 = r3;
        r1 = r4;
        goto L_0x00c7;
    L_0x0107:
        r1 = move-exception;
        r1 = r4;
        goto L_0x00c7;
    L_0x010a:
        r0 = move-exception;
        r0 = r3;
        r1 = r3;
        goto L_0x00c7;
    L_0x010e:
        r0 = move-exception;
        r0 = r3;
        r1 = r4;
        goto L_0x00c7;
    L_0x0112:
        r1 = move-exception;
        r1 = r4;
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adn.b(java.io.File, java.lang.String):boolean");
    }

    private final void o() {
        try {
            if (this.g == null && this.j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.a);
                advertisingIdClient.start();
                this.g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            this.g = null;
        } catch (IOException e2) {
            this.g = null;
        } catch (GooglePlayServicesRepairableException e3) {
            this.g = null;
        }
    }

    @VisibleForTesting
    private final wr p() {
        wr wrVar = null;
        try {
            return pn.a(this.a, this.a.getPackageName(), Integer.toString(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode));
        } catch (Throwable th) {
            return wrVar;
        }
    }

    public final Context a() {
        return this.a;
    }

    public final Method a(String str, String str2) {
        aex aex = (aex) this.p.get(new Pair(str, str2));
        return aex == null ? null : aex.a();
    }

    @VisibleForTesting
    final void a(int i, boolean z) {
        if (this.o) {
            Future submit = this.c.submit(new ads(this, i, z));
            if (i == 0) {
                this.l = submit;
            }
        }
    }

    public final boolean a(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair(str, str2), new aex(this, str, str2, clsArr));
        return true;
    }

    @VisibleForTesting
    final wr b(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException e) {
            }
        }
        return p();
    }

    public final boolean b() {
        return this.q;
    }

    public final ExecutorService c() {
        return this.c;
    }

    public final DexClassLoader d() {
        return this.d;
    }

    public final adb e() {
        return this.e;
    }

    public final byte[] f() {
        return this.f;
    }

    public final boolean g() {
        return this.n;
    }

    public final acv h() {
        return this.m;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.r;
    }

    public final wr k() {
        return this.k;
    }

    public final Future l() {
        return this.l;
    }

    public final AdvertisingIdClient m() {
        if (!this.h) {
            return null;
        }
        if (this.g != null) {
            return this.g;
        }
        if (this.i != null) {
            try {
                this.i.get(2000, TimeUnit.MILLISECONDS);
                this.i = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.i.cancel(true);
            }
        }
        return this.g;
    }

    public final int n() {
        return this.m != null ? acv.a() : Integer.MIN_VALUE;
    }
}
