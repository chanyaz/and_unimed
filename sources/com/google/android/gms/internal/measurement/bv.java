package com.google.android.gms.internal.measurement;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.appnext.base.b.c;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map.Entry;

final class bv extends af {
    private static final byte[] c = "\n".getBytes();
    private final String a;
    private final cf b;

    bv(ah ahVar) {
        super(ahVar);
        String str = ag.a;
        String str2 = VERSION.RELEASE;
        String a = cj.a(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, a, str3, str4});
        this.b = new cf(ahVar.c());
    }

    private final int a(URL url) {
        ar.a((Object) url);
        b("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = b(url);
            httpURLConnection.connect();
            a(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                j().g();
            }
            b("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            d("Network GET connection error", e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074 A:{SYNTHETIC, Splitter: B:23:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089 A:{SYNTHETIC, Splitter: B:33:0x0089} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e  */
    private final int a(java.net.URL r6, byte[] r7) {
        /*
        r5 = this;
        r1 = 0;
        com.google.android.gms.common.internal.ar.a(r6);
        com.google.android.gms.common.internal.ar.a(r7);
        r0 = "POST bytes, url";
        r2 = r7.length;
        r2 = java.lang.Integer.valueOf(r2);
        r5.b(r0, r2, r6);
        r0 = com.google.android.gms.internal.measurement.ae.w();
        if (r0 == 0) goto L_0x0021;
    L_0x0017:
        r0 = "Post payload\n";
        r2 = new java.lang.String;
        r2.<init>(r7);
        r5.a(r0, r2);
    L_0x0021:
        r0 = r5.j();	 Catch:{ IOException -> 0x006b, all -> 0x0085 }
        r0.getPackageName();	 Catch:{ IOException -> 0x006b, all -> 0x0085 }
        r2 = r5.b(r6);	 Catch:{ IOException -> 0x006b, all -> 0x0085 }
        r0 = 1;
        r2.setDoOutput(r0);	 Catch:{ IOException -> 0x009b }
        r0 = r7.length;	 Catch:{ IOException -> 0x009b }
        r2.setFixedLengthStreamingMode(r0);	 Catch:{ IOException -> 0x009b }
        r2.connect();	 Catch:{ IOException -> 0x009b }
        r1 = r2.getOutputStream();	 Catch:{ IOException -> 0x009b }
        r1.write(r7);	 Catch:{ IOException -> 0x009b }
        r5.a(r2);	 Catch:{ IOException -> 0x009b }
        r0 = r2.getResponseCode();	 Catch:{ IOException -> 0x009b }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r3) goto L_0x0050;
    L_0x0049:
        r3 = r5.j();	 Catch:{ IOException -> 0x009b }
        r3.g();	 Catch:{ IOException -> 0x009b }
    L_0x0050:
        r3 = "POST status";
        r4 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x009b }
        r5.b(r3, r4);	 Catch:{ IOException -> 0x009b }
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.close();	 Catch:{ IOException -> 0x0064 }
    L_0x005e:
        if (r2 == 0) goto L_0x0063;
    L_0x0060:
        r2.disconnect();
    L_0x0063:
        return r0;
    L_0x0064:
        r1 = move-exception;
        r3 = "Error closing http post connection output stream";
        r5.e(r3, r1);
        goto L_0x005e;
    L_0x006b:
        r0 = move-exception;
        r2 = r1;
    L_0x006d:
        r3 = "Network POST connection error";
        r5.d(r3, r0);	 Catch:{ all -> 0x0099 }
        if (r1 == 0) goto L_0x0077;
    L_0x0074:
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x0077:
        if (r2 == 0) goto L_0x007c;
    L_0x0079:
        r2.disconnect();
    L_0x007c:
        r0 = 0;
        goto L_0x0063;
    L_0x007e:
        r0 = move-exception;
        r1 = "Error closing http post connection output stream";
        r5.e(r1, r0);
        goto L_0x0077;
    L_0x0085:
        r0 = move-exception;
        r2 = r1;
    L_0x0087:
        if (r1 == 0) goto L_0x008c;
    L_0x0089:
        r1.close();	 Catch:{ IOException -> 0x0092 }
    L_0x008c:
        if (r2 == 0) goto L_0x0091;
    L_0x008e:
        r2.disconnect();
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        r3 = "Error closing http post connection output stream";
        r5.e(r3, r1);
        goto L_0x008c;
    L_0x0099:
        r0 = move-exception;
        goto L_0x0087;
    L_0x009b:
        r0 = move-exception;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bv.a(java.net.URL, byte[]):int");
    }

    private final URL a(bp bpVar) {
        String valueOf;
        String valueOf2;
        if (bpVar.f()) {
            valueOf = String.valueOf(bd.h());
            valueOf2 = String.valueOf(bd.j());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(bd.i());
            valueOf2 = String.valueOf(bd.j());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL a(bp bpVar, String str) {
        String j;
        String h;
        if (bpVar.f()) {
            h = bd.h();
            j = bd.j();
            j = new StringBuilder(((String.valueOf(h).length() + 1) + String.valueOf(j).length()) + String.valueOf(str).length()).append(h).append(j).append("?").append(str).toString();
        } else {
            h = bd.i();
            j = bd.j();
            j = new StringBuilder(((String.valueOf(h).length() + 1) + String.valueOf(j).length()) + String.valueOf(str).length()).append(h).append(j).append("?").append(str).toString();
        }
        try {
            return new URL(j);
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private final void a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[c.jk]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e("Error closing http connection input stream", e2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3 A:{SYNTHETIC, Splitter: B:41:0x00d3} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3 A:{SYNTHETIC, Splitter: B:41:0x00d3} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3 A:{SYNTHETIC, Splitter: B:41:0x00d3} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    private final int b(java.net.URL r11, byte[] r12) {
        /*
        r10 = this;
        r1 = 0;
        com.google.android.gms.common.internal.ar.a(r11);
        com.google.android.gms.common.internal.ar.a(r12);
        r0 = r10.j();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0.getPackageName();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0.<init>();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2.<init>(r0);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2.write(r12);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2.close();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0.close();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r4 = r0.toByteArray();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0 = "POST compressed size, ratio %, url";
        r2 = r4.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r6 = 100;
        r3 = r4.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r8 = (long) r3;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r6 = r6 * r8;
        r3 = r12.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r8 = (long) r3;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r6 = r6 / r8;
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r10.a(r0, r2, r3, r11);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0 = r4.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2 = r12.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        if (r0 <= r2) goto L_0x004e;
    L_0x003f:
        r0 = "Compressed payload is larger then uncompressed. compressed, uncompressed";
        r2 = r4.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r3 = r12.length;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r10.c(r0, r2, r3);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
    L_0x004e:
        r0 = com.google.android.gms.internal.measurement.ae.w();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        if (r0 == 0) goto L_0x006e;
    L_0x0054:
        r2 = "Post payload";
        r3 = "\n";
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0.<init>(r12);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r5 = r0.length();	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        if (r5 == 0) goto L_0x00af;
    L_0x0067:
        r0 = r3.concat(r0);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
    L_0x006b:
        r10.a(r2, r0);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
    L_0x006e:
        r3 = r10.b(r11);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0 = 1;
        r3.setDoOutput(r0);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r0 = "Content-Encoding";
        r2 = "gzip";
        r3.addRequestProperty(r0, r2);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r0 = r4.length;	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r3.setFixedLengthStreamingMode(r0);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r3.connect();	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r2 = r3.getOutputStream();	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r2.write(r4);	 Catch:{ IOException -> 0x00ee, all -> 0x00e5 }
        r2.close();	 Catch:{ IOException -> 0x00ee, all -> 0x00e5 }
        r10.a(r3);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r0 = r3.getResponseCode();	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r2) goto L_0x00a0;
    L_0x0099:
        r2 = r10.j();	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r2.g();	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
    L_0x00a0:
        r2 = "POST status";
        r4 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        r10.b(r2, r4);	 Catch:{ IOException -> 0x00eb, all -> 0x00e3 }
        if (r3 == 0) goto L_0x00ae;
    L_0x00ab:
        r3.disconnect();
    L_0x00ae:
        return r0;
    L_0x00af:
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        r0.<init>(r3);	 Catch:{ IOException -> 0x00b5, all -> 0x00cf }
        goto L_0x006b;
    L_0x00b5:
        r0 = move-exception;
        r2 = r1;
    L_0x00b7:
        r3 = "Network compressed POST connection error";
        r10.d(r3, r0);	 Catch:{ all -> 0x00e8 }
        if (r1 == 0) goto L_0x00c1;
    L_0x00be:
        r1.close();	 Catch:{ IOException -> 0x00c8 }
    L_0x00c1:
        if (r2 == 0) goto L_0x00c6;
    L_0x00c3:
        r2.disconnect();
    L_0x00c6:
        r0 = 0;
        goto L_0x00ae;
    L_0x00c8:
        r0 = move-exception;
        r1 = "Error closing http compressed post connection output stream";
        r10.e(r1, r0);
        goto L_0x00c1;
    L_0x00cf:
        r0 = move-exception;
        r3 = r1;
    L_0x00d1:
        if (r1 == 0) goto L_0x00d6;
    L_0x00d3:
        r1.close();	 Catch:{ IOException -> 0x00dc }
    L_0x00d6:
        if (r3 == 0) goto L_0x00db;
    L_0x00d8:
        r3.disconnect();
    L_0x00db:
        throw r0;
    L_0x00dc:
        r1 = move-exception;
        r2 = "Error closing http compressed post connection output stream";
        r10.e(r2, r1);
        goto L_0x00d6;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x00d1;
    L_0x00e5:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00d1;
    L_0x00e8:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00d1;
    L_0x00eb:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00b7;
    L_0x00ee:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bv.b(java.net.URL, byte[]):int");
    }

    @VisibleForTesting
    private final HttpURLConnection b(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) bk.w.a()).intValue());
            httpURLConnection.setReadTimeout(((Integer) bk.x.a()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.a);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL d() {
        String valueOf = String.valueOf(bd.h());
        String valueOf2 = String.valueOf((String) bk.n.a());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    @VisibleForTesting
    final String a(bp bpVar, boolean z) {
        ar.a((Object) bpVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : bpVar.b().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    a(stringBuilder, str, (String) entry.getValue());
                }
            }
            a(stringBuilder, "ht", String.valueOf(bpVar.d()));
            a(stringBuilder, "qt", String.valueOf(i().currentTimeMillis() - bpVar.d()));
            if (z) {
                long g = bpVar.g();
                a(stringBuilder, "z", g != 0 ? String.valueOf(g) : String.valueOf(bpVar.c()));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            e("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0037  */
    public final java.util.List<java.lang.Long> a(java.util.List<com.google.android.gms.internal.measurement.bp> r10) {
        /*
        r9 = this;
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 0;
        r2 = 1;
        com.google.android.gms.analytics.t.d();
        r9.y();
        com.google.android.gms.common.internal.ar.a(r10);
        r0 = r9.l();
        r0 = r0.k();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0033;
    L_0x001b:
        r1 = r9.b;
        r0 = com.google.android.gms.internal.measurement.bk.v;
        r0 = r0.a();
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r4 = (long) r0;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r0 = r1.a(r4);
        if (r0 != 0) goto L_0x007d;
    L_0x0033:
        r1 = r3;
    L_0x0034:
        r4 = r3;
    L_0x0035:
        if (r1 == 0) goto L_0x0106;
    L_0x0037:
        r0 = r10.isEmpty();
        if (r0 != 0) goto L_0x00a2;
    L_0x003d:
        com.google.android.gms.common.internal.ar.b(r2);
        r0 = "Uploading batched hits. compression, count";
        r1 = java.lang.Boolean.valueOf(r4);
        r2 = r10.size();
        r2 = java.lang.Integer.valueOf(r2);
        r9.a(r0, r1, r2);
        r2 = new com.google.android.gms.internal.measurement.bw;
        r2.<init>(r9);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = r10.iterator();
    L_0x005f:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00a4;
    L_0x0065:
        r0 = r3.next();
        r0 = (com.google.android.gms.internal.measurement.bp) r0;
        r5 = r2.a(r0);
        if (r5 == 0) goto L_0x00a4;
    L_0x0071:
        r6 = r0.c();
        r0 = java.lang.Long.valueOf(r6);
        r1.add(r0);
        goto L_0x005f;
    L_0x007d:
        r0 = com.google.android.gms.internal.measurement.bk.p;
        r0 = r0.a();
        r0 = (java.lang.String) r0;
        r0 = com.google.android.gms.internal.measurement.zzbk.a(r0);
        r1 = com.google.android.gms.internal.measurement.zzbk.a;
        if (r0 == r1) goto L_0x00a0;
    L_0x008d:
        r1 = r2;
    L_0x008e:
        r0 = com.google.android.gms.internal.measurement.bk.q;
        r0 = r0.a();
        r0 = (java.lang.String) r0;
        r0 = com.google.android.gms.internal.measurement.zzbq.a(r0);
        r4 = com.google.android.gms.internal.measurement.zzbq.GZIP;
        if (r0 != r4) goto L_0x0034;
    L_0x009e:
        r4 = r2;
        goto L_0x0035;
    L_0x00a0:
        r1 = r3;
        goto L_0x008e;
    L_0x00a2:
        r2 = r3;
        goto L_0x003d;
    L_0x00a4:
        r0 = r2.a();
        if (r0 != 0) goto L_0x00ac;
    L_0x00aa:
        r0 = r1;
    L_0x00ab:
        return r0;
    L_0x00ac:
        r0 = r9.d();
        if (r0 != 0) goto L_0x00bc;
    L_0x00b2:
        r0 = "Failed to build batching endpoint url";
        r9.f(r0);
    L_0x00b7:
        r0 = java.util.Collections.emptyList();
        goto L_0x00ab;
    L_0x00bc:
        if (r4 == 0) goto L_0x00d7;
    L_0x00be:
        r3 = r2.b();
        r0 = r9.b(r0, r3);
    L_0x00c6:
        if (r8 != r0) goto L_0x00e0;
    L_0x00c8:
        r0 = "Batched upload completed. Hits batched";
        r2 = r2.a();
        r2 = java.lang.Integer.valueOf(r2);
        r9.a(r0, r2);
        r0 = r1;
        goto L_0x00ab;
    L_0x00d7:
        r3 = r2.b();
        r0 = r9.a(r0, r3);
        goto L_0x00c6;
    L_0x00e0:
        r1 = "Network error uploading hits. status code";
        r2 = java.lang.Integer.valueOf(r0);
        r9.a(r1, r2);
        r1 = r9.l();
        r1 = r1.k();
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x00fb:
        r0 = "Server instructed the client to stop batching";
        r9.e(r0);
        r0 = r9.b;
        r0.a();
        goto L_0x00b7;
    L_0x0106:
        r4 = new java.util.ArrayList;
        r0 = r10.size();
        r4.<init>(r0);
        r5 = r10.iterator();
    L_0x0113:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0150;
    L_0x0119:
        r0 = r5.next();
        r0 = (com.google.android.gms.internal.measurement.bp) r0;
        com.google.android.gms.common.internal.ar.a(r0);
        r1 = r0.f();
        if (r1 != 0) goto L_0x0153;
    L_0x0128:
        r1 = r2;
    L_0x0129:
        r6 = r9.a(r0, r1);
        if (r6 != 0) goto L_0x0155;
    L_0x012f:
        r1 = r9.h();
        r6 = "Error formatting hit for upload";
        r1.a(r0, r6);
        r1 = r2;
    L_0x0139:
        if (r1 == 0) goto L_0x0150;
    L_0x013b:
        r0 = r0.c();
        r0 = java.lang.Long.valueOf(r0);
        r4.add(r0);
        r0 = r4.size();
        r1 = com.google.android.gms.internal.measurement.bd.f();
        if (r0 < r1) goto L_0x0113;
    L_0x0150:
        r0 = r4;
        goto L_0x00ab;
    L_0x0153:
        r1 = r3;
        goto L_0x0129;
    L_0x0155:
        r7 = r6.length();
        r1 = com.google.android.gms.internal.measurement.bk.o;
        r1 = r1.a();
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r7 > r1) goto L_0x017e;
    L_0x0167:
        r1 = r9.a(r0, r6);
        if (r1 != 0) goto L_0x0174;
    L_0x016d:
        r1 = "Failed to build collect GET endpoint url";
        r9.f(r1);
    L_0x0172:
        r1 = r3;
        goto L_0x0139;
    L_0x0174:
        r1 = r9.a(r1);
        if (r1 != r8) goto L_0x017c;
    L_0x017a:
        r1 = r2;
        goto L_0x0139;
    L_0x017c:
        r1 = r3;
        goto L_0x0139;
    L_0x017e:
        r1 = r9.a(r0, r3);
        if (r1 != 0) goto L_0x018f;
    L_0x0184:
        r1 = r9.h();
        r6 = "Error formatting hit for POST upload";
        r1.a(r0, r6);
        r1 = r2;
        goto L_0x0139;
    L_0x018f:
        r6 = r1.getBytes();
        r7 = r6.length;
        r1 = com.google.android.gms.internal.measurement.bk.s;
        r1 = r1.a();
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r7 <= r1) goto L_0x01ad;
    L_0x01a2:
        r1 = r9.h();
        r6 = "Hit payload exceeds size limit";
        r1.a(r0, r6);
        r1 = r2;
        goto L_0x0139;
    L_0x01ad:
        r1 = r9.a(r0);
        if (r1 != 0) goto L_0x01b9;
    L_0x01b3:
        r1 = "Failed to build collect POST endpoint url";
        r9.f(r1);
        goto L_0x0172;
    L_0x01b9:
        r1 = r9.a(r1, r6);
        if (r1 != r8) goto L_0x0172;
    L_0x01bf:
        r1 = r2;
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bv.a(java.util.List):java.util.List<java.lang.Long>");
    }

    protected final void a() {
        a("Network initialized. User agent", this.a);
    }

    public final boolean b() {
        NetworkInfo activeNetworkInfo;
        t.d();
        y();
        try {
            activeNetworkInfo = ((ConnectivityManager) j().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        b("No network connectivity");
        return false;
    }
}
