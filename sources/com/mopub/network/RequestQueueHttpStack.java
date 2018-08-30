package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HurlStack;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpResponse;

public class RequestQueueHttpStack extends HurlStack {
    @NonNull
    private final String a;

    public RequestQueueHttpStack(@NonNull String str) {
        this(str, null);
    }

    public RequestQueueHttpStack(@NonNull String str, @Nullable UrlRewriter urlRewriter) {
        this(str, urlRewriter, null);
    }

    public RequestQueueHttpStack(@NonNull String str, @Nullable UrlRewriter urlRewriter, @Nullable SSLSocketFactory sSLSocketFactory) {
        super(urlRewriter, sSLSocketFactory);
        this.a = str;
    }

    public HttpResponse performRequest(@NonNull Request<?> request, @Nullable Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new TreeMap();
        }
        map2.put(ResponseHeader.USER_AGENT.getKey(), this.a);
        return super.performRequest(request, map2);
    }
}
