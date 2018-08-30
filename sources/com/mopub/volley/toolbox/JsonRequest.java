package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T> {
    private static final String a = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    private final Listener<T> b;
    private final String c;

    public JsonRequest(int i, String str, String str2, Listener<T> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.b = listener;
        this.c = str2;
    }

    public JsonRequest(String str, String str2, Listener<T> listener, ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    protected abstract Response<T> a(NetworkResponse networkResponse);

    protected void deliverResponse(T t) {
        this.b.onResponse(t);
    }

    public byte[] getBody() {
        try {
            return this.c == null ? null : this.c.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.c, "utf-8");
            return null;
        }
    }

    public String getBodyContentType() {
        return a;
    }

    public byte[] getPostBody() {
        return getBody();
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }
}
