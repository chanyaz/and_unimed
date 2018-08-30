package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.content.a;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

final class ae {
    ae() {
    }

    @Nullable
    private static af a(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(o.a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(o.a(str, "|K|"), null);
        return (string == null || string2 == null) ? null : new af(a(string, string2), b(sharedPreferences, str));
    }

    /* JADX WARNING: Missing block: B:20:0x0043, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x0044, code:
            r6 = r1;
            r1 = r0;
            r0 = r6;
     */
    @android.support.annotation.Nullable
    private static com.google.firebase.iid.af a(java.io.File r7) {
        /*
        r1 = 0;
        r2 = new java.io.FileInputStream;
        r2.<init>(r7);
        r0 = new java.util.Properties;	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r0.<init>();	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r0.load(r2);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r3 = "pub";
        r3 = r0.getProperty(r3);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r4 = "pri";
        r4 = r0.getProperty(r4);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        if (r3 == 0) goto L_0x001e;
    L_0x001c:
        if (r4 != 0) goto L_0x0023;
    L_0x001e:
        a(r1, r2);
        r0 = r1;
    L_0x0022:
        return r0;
    L_0x0023:
        r3 = a(r3, r4);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r4 = "cre";
        r0 = r0.getProperty(r4);	 Catch:{ NumberFormatException -> 0x003a }
        r4 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x003a }
        r0 = new com.google.firebase.iid.af;	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r0.<init>(r3, r4);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        a(r1, r2);
        goto L_0x0022;
    L_0x003a:
        r0 = move-exception;
        r3 = new com.google.firebase.iid.ag;	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
        throw r3;	 Catch:{ Throwable -> 0x0041, all -> 0x004b }
    L_0x0041:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0047:
        a(r1, r2);
        throw r0;
    L_0x004b:
        r0 = move-exception;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ae.a(java.io.File):com.google.firebase.iid.af");
    }

    private static KeyPair a(String str, String str2) {
        Exception e;
        String valueOf;
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (InvalidKeySpecException e2) {
                e = e2;
                valueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
                throw new ag(e);
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                valueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
                throw new ag(e);
            }
        } catch (Exception e4) {
            throw new ag(e4);
        }
    }

    static void a(Context context) {
        for (File file : b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            a(r1, r3);
     */
    private static void a(android.content.Context r6, java.lang.String r7, com.google.firebase.iid.af r8) {
        /*
        r1 = 0;
        r0 = "FirebaseInstanceId";
        r2 = 3;
        r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0051 }
        if (r0 == 0) goto L_0x0011;
    L_0x000a:
        r0 = "FirebaseInstanceId";
        r2 = "Writing key to properties file";
        android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0051 }
    L_0x0011:
        r0 = e(r6, r7);	 Catch:{ IOException -> 0x0051 }
        r0.createNewFile();	 Catch:{ IOException -> 0x0051 }
        r2 = new java.util.Properties;	 Catch:{ IOException -> 0x0051 }
        r2.<init>();	 Catch:{ IOException -> 0x0051 }
        r3 = "pub";
        r4 = r8.b();	 Catch:{ IOException -> 0x0051 }
        r2.setProperty(r3, r4);	 Catch:{ IOException -> 0x0051 }
        r3 = "pri";
        r4 = r8.c();	 Catch:{ IOException -> 0x0051 }
        r2.setProperty(r3, r4);	 Catch:{ IOException -> 0x0051 }
        r3 = "cre";
        r4 = r8.b;	 Catch:{ IOException -> 0x0051 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ IOException -> 0x0051 }
        r2.setProperty(r3, r4);	 Catch:{ IOException -> 0x0051 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0051 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0051 }
        r0 = 0;
        r2.store(r3, r0);	 Catch:{ Throwable -> 0x004a }
        r0 = 0;
        a(r0, r3);	 Catch:{ IOException -> 0x0051 }
    L_0x0049:
        return;
    L_0x004a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004c }
    L_0x004c:
        r0 = move-exception;
        a(r1, r3);	 Catch:{ IOException -> 0x0051 }
        throw r0;	 Catch:{ IOException -> 0x0051 }
    L_0x0051:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r0 = java.lang.String.valueOf(r0);
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 21;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Failed to write key: ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.w(r1, r0);
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ae.a(android.content.Context, java.lang.String, com.google.firebase.iid.af):void");
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(o.a(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    private static File b(Context context) {
        File b = a.b(context);
        if (b != null && b.isDirectory()) {
            return b;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final void b(Context context, String str, af afVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (afVar.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (ag e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(o.a(str, "|P|"), afVar.b());
        edit.putString(o.a(str, "|K|"), afVar.c());
        edit.putString(o.a(str, "cre"), String.valueOf(afVar.b));
        edit.commit();
    }

    @Nullable
    private final af c(Context context, String str) {
        ag agVar;
        ag e;
        try {
            af d = d(context, str);
            if (d != null) {
                b(context, str, d);
                return d;
            }
            agVar = null;
            try {
                d = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (d != null) {
                    a(context, str, d);
                    return d;
                }
                e = agVar;
                if (e == null) {
                    return null;
                }
                throw e;
            } catch (ag e2) {
                e = e2;
            }
        } catch (ag e3) {
            agVar = e3;
        }
    }

    @Nullable
    private final af d(Context context, String str) {
        File e = e(context, str);
        if (!e.exists()) {
            return null;
        }
        try {
            return a(e);
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf).toString());
            }
            try {
                return a(e);
            } catch (Exception e3) {
                String valueOf2 = String.valueOf(e3);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf2).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf2).toString());
                throw new ag(e3);
            }
        }
    }

    private static File e(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                str2 = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                str2 = new StringBuilder(String.valueOf(str2).length() + 33).append("com.google.InstanceId_").append(str2).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(b(context), str2);
    }

    @WorkerThread
    final af a(Context context, String str) {
        af c = c(context, str);
        return c != null ? c : b(context, str);
    }

    @WorkerThread
    final af b(Context context, String str) {
        af afVar = new af(b.a(), System.currentTimeMillis());
        try {
            af c = c(context, str);
            if (c != null) {
                if (!Log.isLoggable("FirebaseInstanceId", 3)) {
                    return c;
                }
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
                return c;
            }
        } catch (ag e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        a(context, str, afVar);
        b(context, str, afVar);
        return afVar;
    }
}
