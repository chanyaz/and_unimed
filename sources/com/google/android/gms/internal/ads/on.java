package com.google.android.gms.internal.ads;

import com.mopub.common.Constants;
import com.mopub.volley.toolbox.HttpClientStack.HttpPatch;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class on extends fr {
    private final zzat a;
    private final SSLSocketFactory b;

    public on() {
        this(null);
    }

    private on(zzat zzat) {
        this(null, null);
    }

    private on(zzat zzat, SSLSocketFactory sSLSocketFactory) {
        this.a = null;
        this.b = null;
    }

    private static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static List<akt> a(Map<String, List<String>> map) {
        List<akt> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String akt : (List) entry.getValue()) {
                    arrayList.add(new akt((String) entry.getKey(), akt));
                }
            }
        }
        return arrayList;
    }

    private static void a(HttpURLConnection httpURLConnection, apk<?> apk) {
        byte[] a = apk.a();
        if (a != null) {
            httpURLConnection.setDoOutput(true);
            String str = "Content-Type";
            String str2 = "application/x-www-form-urlencoded; charset=";
            String valueOf = String.valueOf("UTF-8");
            httpURLConnection.addRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(a);
            dataOutputStream.close();
        }
    }

    public final mw a(apk<?> apk, Map<String, String> map) {
        String zzg;
        String e = apk.e();
        HashMap hashMap = new HashMap();
        hashMap.putAll(apk.b());
        hashMap.putAll(map);
        if (this.a != null) {
            zzg = this.a.zzg(e);
            if (zzg == null) {
                String str = "URL blocked by rewriter: ";
                zzg = String.valueOf(e);
                throw new IOException(zzg.length() != 0 ? str.concat(zzg) : new String(str));
            }
        }
        zzg = e;
        URL url = new URL(zzg);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i = apk.i();
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        Constants.HTTPS.equals(url.getProtocol());
        for (String e2 : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(e2, (String) hashMap.get(e2));
        }
        switch (apk.c()) {
            case -1:
                break;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                break;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection, (apk) apk);
                break;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                a(httpURLConnection, (apk) apk);
                break;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                break;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                break;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                break;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                break;
            case 7:
                httpURLConnection.setRequestMethod(HttpPatch.METHOD_NAME);
                a(httpURLConnection, (apk) apk);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        i = httpURLConnection.getResponseCode();
        if (i == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        boolean z = (apk.c() == 4 || ((100 <= i && i < 200) || i == 204 || i == 304)) ? false : true;
        return !z ? new mw(i, a(httpURLConnection.getHeaderFields())) : new mw(i, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), a(httpURLConnection));
    }
}
