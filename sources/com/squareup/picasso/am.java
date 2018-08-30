package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.appnext.base.b.c;
import com.squareup.picasso.Downloader.ResponseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class am implements Downloader {
    static volatile Object a;
    private static final Object b = new Object();
    private static final ThreadLocal<StringBuilder> c = new ThreadLocal<StringBuilder>() {
        /* renamed from: a */
        protected StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private final Context d;

    public am(Context context) {
        this.d = context.getApplicationContext();
    }

    private static void a(Context context) {
        if (a == null) {
            try {
                synchronized (b) {
                    if (a == null) {
                        a = an.a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected HttpURLConnection a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(c.jm);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    public m load(Uri uri, int i) {
        if (VERSION.SDK_INT >= 14) {
            a(this.d);
        }
        HttpURLConnection a = a(uri);
        a.setUseCaches(true);
        if (i != 0) {
            String str;
            if (NetworkPolicy.c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) c.get();
                stringBuilder.setLength(0);
                if (!NetworkPolicy.a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!NetworkPolicy.b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            a.setRequestProperty("Cache-Control", str);
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= 300) {
            a.disconnect();
            throw new ResponseException(responseCode + " " + a.getResponseMessage(), i, responseCode);
        }
        long headerFieldInt = (long) a.getHeaderFieldInt("Content-Length", -1);
        return new m(a.getInputStream(), ao.a(a.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }

    public void shutdown() {
        if (VERSION.SDK_INT >= 14 && a != null) {
            an.a(a);
        }
    }
}
