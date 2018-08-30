package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Response.ErrorListener;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class Request<T> implements Comparable<Request<T>> {
    private final b a;
    private final int b;
    private final String c;
    private final int d;
    private final ErrorListener e;
    private Integer f;
    private RequestQueue g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private RetryPolicy l;
    private Entry m;
    private Object n;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i, String str, ErrorListener errorListener) {
        this.a = b.ENABLED ? new b() : null;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = 0;
        this.m = null;
        this.b = i;
        this.c = str;
        this.e = errorListener;
        setRetryPolicy(new DefaultRetryPolicy());
        this.d = a(str);
    }

    @Deprecated
    public Request(String str, ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    private static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    protected abstract Response<T> a(NetworkResponse networkResponse);

    protected VolleyError a(VolleyError volleyError) {
        return volleyError;
    }

    protected Map<String, String> a() {
        return null;
    }

    public void addMarker(String str) {
        if (b.ENABLED) {
            this.a.add(str, Thread.currentThread().getId());
        } else if (this.k == 0) {
            this.k = SystemClock.elapsedRealtime();
        }
    }

    @Deprecated
    protected Map<String, String> b() {
        return a();
    }

    void b(final String str) {
        if (this.g != null) {
            this.g.a(this);
        }
        if (b.ENABLED) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        Request.this.a.add(str, id);
                        Request.this.a.finish(toString());
                    }
                });
                return;
            }
            this.a.add(str, id);
            this.a.finish(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.k >= 3000) {
            VolleyLog.d("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.k), toString());
        }
    }

    @Deprecated
    protected String c() {
        return d();
    }

    public void cancel() {
        this.i = true;
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        return priority == priority2 ? this.f.intValue() - request.f.intValue() : priority2.ordinal() - priority.ordinal();
    }

    protected String d() {
        return "UTF-8";
    }

    public void deliverError(VolleyError volleyError) {
        if (this.e != null) {
            this.e.onErrorResponse(volleyError);
        }
    }

    protected abstract void deliverResponse(T t);

    public byte[] getBody() {
        Map a = a();
        return (a == null || a.size() <= 0) ? null : a(a, d());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public Entry getCacheEntry() {
        return this.m;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public ErrorListener getErrorListener() {
        return this.e;
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.b;
    }

    @Deprecated
    public byte[] getPostBody() {
        Map b = b();
        return (b == null || b.size() <= 0) ? null : a(b, c());
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public RetryPolicy getRetryPolicy() {
        return this.l;
    }

    public final int getSequence() {
        if (this.f != null) {
            return this.f.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object getTag() {
        return this.n;
    }

    public final int getTimeoutMs() {
        return this.l.getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.d;
    }

    public String getUrl() {
        return this.c;
    }

    public boolean hasHadResponseDelivered() {
        return this.j;
    }

    public boolean isCanceled() {
        return this.i;
    }

    public void markDelivered() {
        this.j = true;
    }

    public Request<?> setCacheEntry(Entry entry) {
        this.m = entry;
        return this;
    }

    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.g = requestQueue;
        return this;
    }

    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.l = retryPolicy;
        return this;
    }

    public final Request<?> setSequence(int i) {
        this.f = Integer.valueOf(i);
        return this;
    }

    public final Request<?> setShouldCache(boolean z) {
        this.h = z;
        return this;
    }

    public Request<?> setTag(Object obj) {
        this.n = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.h;
    }

    public String toString() {
        return (this.i ? "[X] " : "[ ] ") + getUrl() + " " + ("0x" + Integer.toHexString(getTrafficStatsTag())) + " " + getPriority() + " " + this.f;
    }
}
