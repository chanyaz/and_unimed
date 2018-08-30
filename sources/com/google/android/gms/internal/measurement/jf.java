package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class jf {
    public static final Pattern a = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern b = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri c = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri d = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final AtomicBoolean e = new AtomicBoolean();
    private static HashMap<String, String> f;
    private static final HashMap<String, Boolean> g = new HashMap();
    private static final HashMap<String, Integer> h = new HashMap();
    private static final HashMap<String, Long> i = new HashMap();
    private static final HashMap<String, Float> j = new HashMap();
    private static Object k;
    private static boolean l;
    private static String[] m = new String[0];

    /* JADX WARNING: Missing block: B:14:?, code:
            return r0;
     */
    private static <T> T a(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
        r1 = com.google.android.gms.internal.measurement.jf.class;
        monitor-enter(r1);
        r0 = r2.containsKey(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r0 = r2.get(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = r4;
        goto L_0x000f;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        r0 = 0;
        goto L_0x0010;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.jf.a(java.util.HashMap, java.lang.String, java.lang.Object):T");
    }

    public static String a(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        synchronized (jf.class) {
            a(contentResolver);
            Object obj = k;
            String str4;
            if (f.containsKey(str)) {
                str4 = (String) f.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
            } else {
                String[] strArr = m;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (str.startsWith(strArr[i])) {
                        if (!l || f.isEmpty()) {
                            f.putAll(a(contentResolver, m));
                            l = true;
                            if (f.containsKey(str)) {
                                str4 = (String) f.get(str);
                                if (str4 != null) {
                                    str3 = str4;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
                Cursor query = contentResolver.query(c, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str4 = query.getString(1);
                            if (str4 != null && str4.equals(null)) {
                                str4 = null;
                            }
                            a(obj, str, str4);
                            if (str4 != null) {
                                str3 = str4;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                a(obj, str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str3;
    }

    private static Map<String, String> a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(d, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void a(ContentResolver contentResolver) {
        if (f == null) {
            e.set(false);
            f = new HashMap();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(c, true, new jg(null));
        } else if (e.getAndSet(false)) {
            f.clear();
            g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    private static void a(Object obj, String str, String str2) {
        synchronized (jf.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        Object b = b(contentResolver);
        Object obj = (Boolean) a(g, str, Boolean.valueOf(z));
        if (obj != null) {
            return obj.booleanValue();
        }
        Object a = a(contentResolver, str, null);
        if (!(a == null || a.equals(""))) {
            if (a.matcher(a).matches()) {
                obj = Boolean.valueOf(true);
                z = true;
            } else if (b.matcher(a).matches()) {
                obj = Boolean.valueOf(false);
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + a + "\") as boolean");
            }
        }
        HashMap hashMap = g;
        synchronized (jf.class) {
            if (b == k) {
                hashMap.put(str, obj);
                f.remove(str);
            }
        }
        return z;
    }

    private static Object b(ContentResolver contentResolver) {
        Object obj;
        synchronized (jf.class) {
            a(contentResolver);
            obj = k;
        }
        return obj;
    }
}
