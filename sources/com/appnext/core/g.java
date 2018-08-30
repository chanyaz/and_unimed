package com.appnext.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.appnext.base.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.h;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
    private static final boolean DEBUG = false;
    public static final String VID = "2.3.0.469";
    static final int jm = 8000;
    private static final String lA = "expiredTimems";
    private static double lB = -1.0d;
    private static HashMap<String, Bitmap> lC = new HashMap();
    private static String lD = "";
    private static String lE = "";
    private static String lF = "";
    public static final Executor lG = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, (Runtime.getRuntime().availableProcessors() * 2) + 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactory() {
        private final AtomicInteger lH = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.lH.getAndIncrement());
        }
    });
    private static final String lz = "encryptKeys";

    static {
        CookieHandler.setDefault(new CookieManager());
        dd();
    }

    public static String A(Context context) {
        String u = u(context);
        return u.equals("") ? g(32) : aP(u + "_" + (System.currentTimeMillis() / 1000));
    }

    public static boolean B(Context context) {
        try {
            if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                a("http://www.appnext.com/myid.html", null);
            } else {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    throw new IOException();
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String O(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring.contains("?")) {
            substring = substring.substring(0, substring.indexOf("?"));
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("rnd");
            return (queryParameter == null || queryParameter.equals("")) ? substring : substring.substring(0, substring.lastIndexOf(46)) + "_" + queryParameter + substring.substring(substring.lastIndexOf(46));
        } catch (Throwable th) {
            return substring;
        }
    }

    public static void X(String str) {
    }

    public static int a(Context context, float f) {
        return (int) ((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f);
    }

    public static String a(String str, ArrayList<Pair<String, String>> arrayList, int i) {
        return new String(b(str, arrayList, true, i, a.ArrayList), "UTF-8");
    }

    public static String a(String str, HashMap<String, String> hashMap) {
        return a(str, (HashMap) hashMap, true, (int) jm);
    }

    public static String a(String str, HashMap<String, String> hashMap, int i) {
        return a(str, (HashMap) hashMap, true, i);
    }

    public static String a(String str, HashMap<String, String> hashMap, boolean z) {
        return a(str, (HashMap) hashMap, z, (int) jm);
    }

    public static String a(String str, HashMap<String, String> hashMap, boolean z, int i) {
        return new String(b(str, hashMap, z, i, a.HashMap), "UTF-8");
    }

    private static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            final Context context2 = context;
            final String str9 = str;
            final String str10 = str2;
            final String str11 = str3;
            final String str12 = str4;
            final String str13 = str5;
            final String str14 = str6;
            final String str15 = str7;
            final String str16 = str8;
            new Thread(new Runnable() {
                public void run() {
                    String str = "";
                    try {
                        str = g.z(context2);
                    } catch (Throwable th) {
                    }
                    g.a(str9, str10, str11, str12, str, str13, str14, str15, str16);
                }
            }).start();
        } catch (Throwable th) {
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        try {
            final String str10 = str5;
            final String str11 = str6;
            final String str12 = str;
            final String str13 = str2;
            final String str14 = str3;
            final String str15 = str4;
            final String str16 = str7;
            final String str17 = str8;
            final String str18 = str9;
            new Thread(new Runnable() {
                public void run() {
                    String str = "";
                    String str2 = "";
                    try {
                        str = URLEncoder.encode(str10.replace(" ", "_"), "UTF-8");
                    } catch (Throwable th) {
                    }
                    try {
                        str2 = URLEncoder.encode(str11.replace(" ", "_"), "UTF-8");
                    } catch (Throwable th2) {
                    }
                    String str3 = "https://admin.appnext.com/tp12.aspx?tid=%s&vid=%s&osid=%s&auid=%s&session_id=%s&pid=%s&ref=%s&ads_type=%s&bid=%s&cid=%s";
                    Object[] objArr = new Object[10];
                    objArr[0] = str12;
                    objArr[1] = str13;
                    objArr[2] = "100";
                    objArr[3] = str14;
                    objArr[4] = str;
                    objArr[5] = str15;
                    objArr[6] = str2;
                    objArr[7] = str16;
                    objArr[8] = str17.equals("") ? "0" : str17;
                    objArr[9] = str18.equals("") ? "0" : str18;
                    str2 = String.format(str3, objArr);
                    try {
                        g.X("report: " + str2);
                        g.a(str2, null);
                    } catch (Throwable th3) {
                        g.X("report error: " + th3.getMessage());
                    }
                }
            }).start();
        } catch (Throwable th) {
        }
    }

    public static byte[] a(String str, Object obj, boolean z, int i) {
        return b(str, obj, z, i, a.HashMap);
    }

    public static byte[] a(String str, Object obj, boolean z, int i, a aVar) {
        byte[] b;
        JSONObject jSONObject;
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        String str2 = "";
        str2 = "";
        str2 = i.cE().getString(lz, inputStream);
        if (TextUtils.isEmpty(str2) || !aL(str2) || aM(str2)) {
            l.k("encrypted", "go to server for secret");
            HashMap hashMap = new HashMap();
            hashMap.put("aid", h.cD().aD(u(d.getContext())));
            try {
                b = b(c.cw() + "/api/token", hashMap, false, c.jm, a.HashMap);
                if (b == null) {
                    return inputStream;
                }
                str2 = new String(b, "UTF-8");
                l.k("encrypted", str2);
                jSONObject = new JSONObject(str2);
                jSONObject.put("aid", u(d.getContext()));
                jSONObject.put(lA, (System.currentTimeMillis() + (jSONObject.getLong("expire") * 1000)) - 10000);
                i.cE().putString(lz, jSONObject.toString());
            } catch (Throwable th2) {
                Exception exception = new Exception(th2.getMessage());
            }
        }
        jSONObject = new JSONObject(str2);
        if (!jSONObject.has("secret") || !jSONObject.has("rnd")) {
            return inputStream;
        }
        String string = jSONObject.getString("rnd");
        String string2 = jSONObject.getString("secret");
        URL url = new URL(str);
        X("encryptedHttpRequest " + str);
        Object u;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setReadTimeout(i);
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection2.setRequestProperty("User-Agent", cZ());
                httpURLConnection2.setRequestProperty("rnd", string);
                u = u(d.getContext());
                if (TextUtils.isEmpty(u)) {
                    u = k.a(c.jP, a.String);
                    if (u == null || !(u instanceof String)) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return inputStream;
                    }
                    u = (String) u;
                } else {
                    k.e(c.jP, u, a.String);
                }
                if (TextUtils.isEmpty(u)) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return inputStream;
                }
                httpURLConnection2.setRequestProperty("aid", h.cD().aD(u));
                if (obj != null) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    if (aVar == a.JSONObject || aVar == a.JSONArray) {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                        X("report params " + obj.toString());
                    }
                    String str3 = "";
                    if (aVar == a.JSONArray) {
                        str3 = ((JSONArray) obj).toString();
                    } else if (aVar == a.JSONObject) {
                        str3 = ((JSONObject) obj).toString();
                    } else if (aVar == a.HashMap) {
                        HashMap hashMap2 = (HashMap) obj;
                        List arrayList = new ArrayList();
                        for (Entry entry : hashMap2.entrySet()) {
                            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                        }
                        str3 = b(arrayList, z);
                    } else if (aVar == a.ArrayList) {
                        str3 = b((List) (ArrayList) obj, z);
                    }
                    b = h.cD().h(str3, string2);
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    if (b != null) {
                        outputStream.write(b);
                    }
                    outputStream.close();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    b = c(b(inputStream));
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return b;
                } else if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    b = b(httpURLConnection2.getHeaderField("Location"), obj, z, i, aVar);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return b;
                } else {
                    throw new HttpRetryException(new String(c(httpURLConnection2.getErrorStream()), "UTF-8"), responseCode);
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection = httpURLConnection2;
                th2 = th4;
            }
        } catch (Throwable th5) {
            th2 = th5;
            u = inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    private static void aK(String str) {
        lD = str;
    }

    private static boolean aL(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("aid")) {
                return false;
            }
            Object string = jSONObject.getString("aid");
            return !TextUtils.isEmpty(string) && string.equals(u(d.getContext()));
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean aM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(lA)) {
                return true;
            }
            return System.currentTimeMillis() >= jSONObject.getLong(lA);
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    public static android.graphics.Bitmap aN(java.lang.String r5) {
        /*
        r1 = 0;
        r0 = lC;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0 = r0.get(r5);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        if (r0 == 0) goto L_0x0017;
    L_0x0009:
        r0 = lC;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0 = r0.get(r5);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r1.disconnect();
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = new java.net.URL;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r2.<init>();	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r3 = "performURLCall ";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r2 = r2.append(r5);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        X(r2);	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0 = r0.openConnection();	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Throwable -> 0x0067, all -> 0x0070 }
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r0.connect();	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r3 = r0.getInputStream();	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r2 = android.graphics.BitmapFactory.decodeStream(r3);	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r3.close();	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        if (r2 != 0) goto L_0x0053;
    L_0x004c:
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.disconnect();
    L_0x0051:
        r0 = r1;
        goto L_0x0016;
    L_0x0053:
        r3 = lC;	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r3 = r3.containsKey(r5);	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        if (r3 != 0) goto L_0x0060;
    L_0x005b:
        r3 = lC;	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
        r3.put(r5, r2);	 Catch:{ Throwable -> 0x007c, all -> 0x0077 }
    L_0x0060:
        if (r0 == 0) goto L_0x0065;
    L_0x0062:
        r0.disconnect();
    L_0x0065:
        r0 = r2;
        goto L_0x0016;
    L_0x0067:
        r0 = move-exception;
        r0 = r1;
    L_0x0069:
        if (r0 == 0) goto L_0x006e;
    L_0x006b:
        r0.disconnect();
    L_0x006e:
        r0 = r1;
        goto L_0x0016;
    L_0x0070:
        r0 = move-exception;
    L_0x0071:
        if (r1 == 0) goto L_0x0076;
    L_0x0073:
        r1.disconnect();
    L_0x0076:
        throw r0;
    L_0x0077:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0071;
    L_0x007c:
        r2 = move-exception;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.aN(java.lang.String):android.graphics.Bitmap");
    }

    public static int aO(java.lang.String r7) {
        /*
        r3 = 3;
        r2 = 2;
        r1 = 1;
        r0 = 0;
        r4 = -1;
        r5 = java.util.Locale.US;
        r5 = r7.toLowerCase(r5);
        r6 = r5.hashCode();
        switch(r6) {
            case 1653: goto L_0x0018;
            case 1684: goto L_0x0022;
            case 1715: goto L_0x002c;
            case 3649301: goto L_0x0036;
            default: goto L_0x0012;
        };
    L_0x0012:
        r5 = r4;
    L_0x0013:
        switch(r5) {
            case 0: goto L_0x0017;
            case 1: goto L_0x0040;
            case 2: goto L_0x0042;
            case 3: goto L_0x0044;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r4;
    L_0x0017:
        return r0;
    L_0x0018:
        r6 = "2g";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0012;
    L_0x0020:
        r5 = r0;
        goto L_0x0013;
    L_0x0022:
        r6 = "3g";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0012;
    L_0x002a:
        r5 = r1;
        goto L_0x0013;
    L_0x002c:
        r6 = "4g";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0012;
    L_0x0034:
        r5 = r2;
        goto L_0x0013;
    L_0x0036:
        r6 = "wifi";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0012;
    L_0x003e:
        r5 = r3;
        goto L_0x0013;
    L_0x0040:
        r0 = r1;
        goto L_0x0017;
    L_0x0042:
        r0 = r2;
        goto L_0x0017;
    L_0x0044:
        r0 = r3;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.aO(java.lang.String):int");
    }

    private static String aP(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder stringBuilder = new StringBuilder(length << 1);
            for (int i = 0; i < length; i++) {
                stringBuilder.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                stringBuilder.append(Character.forDigit(digest[i] & 15, 16));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return g(32);
        }
    }

    public static InputStream b(InputStream inputStream) {
        InputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
        byte[] bArr = new byte[2];
        try {
            pushbackInputStream.unread(bArr, 0, pushbackInputStream.read(bArr));
            return (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
        } catch (Throwable th) {
            return inputStream;
        }
    }

    public static String b(String str, JSONObject jSONObject) {
        return new String(b(str, jSONObject, true, jm, a.JSONObject), "UTF-8");
    }

    public static String b(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        return obj.length() > 512 ? obj.substring(0, 512) : obj;
    }

    private static String b(List<Pair<String, String>> list, boolean z) {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        Object obj2 = 1;
        for (Pair pair : list) {
            Object obj3;
            try {
                if (!(pair.first == null || pair.second == null)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if (obj2 != null) {
                        obj = null;
                    } else {
                        stringBuilder2.append("&");
                        obj = obj2;
                    }
                    if (z) {
                        try {
                            stringBuilder2.append(URLEncoder.encode(URLDecoder.decode((String) pair.first, "UTF-8"), "UTF-8"));
                            stringBuilder2.append("=");
                            stringBuilder2.append(URLEncoder.encode(URLDecoder.decode((String) pair.second, "UTF-8"), "UTF-8"));
                        } catch (Throwable th) {
                            obj3 = obj;
                        }
                    } else {
                        stringBuilder2.append(URLEncoder.encode((String) pair.first, "UTF-8"));
                        stringBuilder2.append("=");
                        stringBuilder2.append(URLEncoder.encode((String) pair.second, "UTF-8"));
                    }
                    X("params: key: " + ((String) pair.first) + " value: " + ((String) pair.second));
                    stringBuilder.append(stringBuilder2);
                    obj3 = obj;
                    obj2 = obj3;
                }
            } catch (Throwable th2) {
                obj3 = obj2;
            }
        }
        X("raw params: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void b(File file) {
        if (file.isDirectory()) {
            for (File b : file.listFiles()) {
                b(b);
            }
        }
        file.delete();
    }

    public static byte[] b(String str, Object obj, boolean z, int i, a aVar) {
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        HttpURLConnection httpURLConnection = null;
        URL url = new URL(str);
        X("performURLCall " + str);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setReadTimeout(i);
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection2.setRequestProperty("User-Agent", cZ());
                if (obj != null) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    if (aVar == a.JSONObject || aVar == a.JSONArray) {
                        httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                        X("report params " + obj.toString());
                    }
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    if (aVar == a.JSONArray) {
                        bufferedWriter.write(((JSONArray) obj).toString());
                    } else if (aVar == a.JSONObject) {
                        bufferedWriter.write(((JSONObject) obj).toString());
                    } else if (aVar == a.HashMap) {
                        HashMap hashMap = (HashMap) obj;
                        List arrayList = new ArrayList();
                        for (Entry entry : hashMap.entrySet()) {
                            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                        }
                        bufferedWriter.write(b(arrayList, z));
                    } else if (aVar == a.ArrayList) {
                        bufferedWriter.write(b((List) (ArrayList) obj, z));
                    }
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                byte[] c;
                if (responseCode == 200) {
                    InputStream inputStream2 = httpURLConnection2.getInputStream();
                    try {
                        c = c(b(inputStream2));
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return c;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                    }
                } else if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    c = b(httpURLConnection2.getHeaderField("Location"), obj, z, i, aVar);
                    if (httpURLConnection != null) {
                        httpURLConnection.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return c;
                } else {
                    throw new HttpRetryException(new String(c(httpURLConnection2.getErrorStream()), "UTF-8"), responseCode);
                }
            } catch (Throwable th32) {
                th = th32;
                inputStream = httpURLConnection;
                httpURLConnection = httpURLConnection2;
                th2 = th;
            }
        } catch (Throwable th4) {
            th2 = th4;
            Object inputStream3 = httpURLConnection;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0020, code:
            if (r0.equals("") != false) goto L_0x0022;
     */
    public static java.lang.String c(android.content.Context r2, boolean r3) {
        /*
        if (r2 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r2.getApplicationContext();
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        r0 = "";
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x004f }
        r0 = r2.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x004f }
        r0 = com.appnext.core.AdsIDHelper.a(r0, r3);	 Catch:{ ClassNotFoundException -> 0x004f }
    L_0x0018:
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Throwable -> 0x005c }
        if (r1 == 0) goto L_0x0059;
    L_0x0022:
        r0 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x005c }
        r0 = com.appnext.core.f.b(r0, r3);	 Catch:{ Throwable -> 0x005c }
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Throwable -> 0x005c }
        if (r1 == 0) goto L_0x0059;
    L_0x0032:
        if (r3 == 0) goto L_0x0042;
    L_0x0034:
        r0 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x0056 }
        r0 = com.appnext.core.d.r(r0);	 Catch:{ Throwable -> 0x0056 }
        r0 = r0.cW();	 Catch:{ Throwable -> 0x0056 }
        if (r0 != 0) goto L_0x0053;
    L_0x0042:
        r0 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x0056 }
        r0 = com.appnext.core.d.r(r0);	 Catch:{ Throwable -> 0x0056 }
        r0 = r0.getId();	 Catch:{ Throwable -> 0x0056 }
        goto L_0x000a;
    L_0x004f:
        r0 = move-exception;
        r0 = "";
        goto L_0x0018;
    L_0x0053:
        r0 = "";
        goto L_0x000a;
    L_0x0056:
        r0 = move-exception;
        r0 = "";
    L_0x0059:
        lE = r0;	 Catch:{ Throwable -> 0x005c }
        goto L_0x000a;
    L_0x005c:
        r0 = move-exception;
        r0 = lE;
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x006a;
    L_0x0067:
        r0 = lE;
        goto L_0x000a;
    L_0x006a:
        r0 = "";
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.c(android.content.Context, boolean):java.lang.String");
    }

    public static void c(Throwable th) {
    }

    private static byte[] c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[c.jk];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String cB() {
        return Locale.getDefault().getLanguage();
    }

    static String cZ() {
        return lD;
    }

    public static String da() {
        try {
            return URLEncoder.encode("android " + VERSION.SDK_INT + " " + Build.MANUFACTURER + " " + Build.MODEL, "UTF-8");
        } catch (Throwable th) {
            c(th);
            return "android";
        }
    }

    public static int db() {
        Runtime runtime = Runtime.getRuntime();
        return (int) ((runtime.maxMemory() / c.jl) - ((runtime.totalMemory() - runtime.freeMemory()) / c.jl));
    }

    public static double dc() {
        return lB;
    }

    private static synchronized double dd() {
        double d = -1.0d;
        synchronized (g.class) {
            if (lB > -1.0d) {
                d = lB;
            } else if (lB > 0.0d) {
                d = lB;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long totalRxBytes = TrafficStats.getTotalRxBytes();
                InputStream inputStream;
                try {
                    URLConnection openConnection = new URL("https://cdn.appnext.com/banner/appnext.mp4").openConnection();
                    openConnection.setUseCaches(false);
                    openConnection.setReadTimeout(4000);
                    openConnection.setConnectTimeout(4000);
                    openConnection.connect();
                    inputStream = openConnection.getInputStream();
                    do {
                    } while (inputStream.read(new byte[c.jk]) != -1);
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                    }
                    d = (((double) (TrafficStats.getTotalRxBytes() - totalRxBytes)) / (((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d)) / 1024.0d;
                    lB = d;
                } catch (Throwable th2) {
                }
            }
        }
        return d;
    }

    public static String e(String str, ArrayList<Pair<String, String>> arrayList) {
        return a(str, (ArrayList) arrayList, (int) jm);
    }

    public static String f(AppnextAd appnextAd) {
        return "https://www.appnext.com/privacy_policy/index.html?z=" + new Random().nextInt(10) + appnextAd.getZoneID() + new Random().nextInt(10) + (appnextAd.isGdpr() ? "&edda=1&geo=" + appnextAd.getCountry() : "");
    }

    private static String g(int i) {
        char[] toCharArray = "0123456789abcdef".toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(toCharArray[random.nextInt(toCharArray.length)]);
        }
        return stringBuilder.toString();
    }

    public static boolean g(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    public static boolean h(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String p(String str, String str2) {
        String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return "";
        }
        cookie = null;
        for (String str3 : cookie.split(";")) {
            if (str3.contains(str2)) {
                cookie = str3.split("=")[1];
            }
        }
        return cookie;
    }

    public static String u(Context context) {
        return c(context, true);
    }

    static void v(Context context) {
        try {
            WebView webView = new WebView(context);
            aK(webView.getSettings().getUserAgentString());
            webView.destroy();
        } catch (Throwable th) {
        }
    }

    public static String w(Context context) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return "Unknown";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? "-" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? "" + activeNetworkInfo.getSubtype() : "Unknown";
    }

    public static String x(Context context) {
        if (context == null) {
            return "Unknown";
        }
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return "Unknown";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "-";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "Unknown";
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static String y(Context context) {
        String str = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager.getSimState() != 5) {
            return str;
        }
        String simOperator = telephonyManager.getSimOperator();
        return simOperator.substring(0, 3) + "_" + simOperator.substring(3);
    }

    public static String z(Context context) {
        if (lF.equals("")) {
            synchronized ("2.3.0.469") {
                if (lF.equals("")) {
                    lF = A(context);
                }
            }
        }
        return lF;
    }
}
