package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request<String> {
    private final Listener<String> a;

    public StringRequest(int i, String str, Listener<String> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.a = listener;
    }

    public StringRequest(String str, Listener<String> listener, ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    protected Response<String> a(NetworkResponse networkResponse) {
        Object str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException e) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* renamed from: a */
    protected void deliverResponse(String str) {
        this.a.onResponse(str);
    }
}
