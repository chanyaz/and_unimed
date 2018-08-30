package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientStack implements HttpStack {
    protected final HttpClient a;

    public final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public String getMethod() {
            return METHOD_NAME;
        }
    }

    public HttpClientStack(HttpClient httpClient) {
        this.a = httpClient;
    }

    static HttpUriRequest a(Request<?> request, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody == null) {
                    return new HttpGet(request.getUrl());
                }
                HttpUriRequest httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader("Content-Type", request.getPostBodyContentType());
                httpPost2.setEntity(new ByteArrayEntity(postBody));
                return httpPost2;
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader("Content-Type", request.getBodyContentType());
                a(httpPost, (Request) request);
                return httpPost;
            case 2:
                httpPost = new HttpPut(request.getUrl());
                httpPost.addHeader("Content-Type", request.getBodyContentType());
                a(httpPost, (Request) request);
                return httpPost;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                httpPost = new HttpPatch(request.getUrl());
                httpPost.addHeader("Content-Type", request.getBodyContentType());
                a(httpPost, (Request) request);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }

    public HttpResponse performRequest(Request<?> request, Map<String, String> map) {
        HttpUriRequest a = a((Request) request, (Map) map);
        a(a, (Map) map);
        a(a, request.getHeaders());
        a(a);
        HttpParams params = a.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.a.execute(a);
    }
}
