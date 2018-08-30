package com.mopub.network;

import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventSerializer;
import com.mopub.network.RequestManager.RequestFactory;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class ScribeRequest extends Request<Void> {
    @NonNull
    private final List<BaseEvent> a;
    @NonNull
    private final EventSerializer b;
    @NonNull
    private final Listener c;

    public interface ScribeRequestFactory extends RequestFactory {
        ScribeRequest createRequest(Listener listener);
    }

    public interface Listener extends ErrorListener {
        void onResponse();
    }

    public ScribeRequest(@NonNull String str, @NonNull List<BaseEvent> list, @NonNull EventSerializer eventSerializer, @NonNull Listener listener) {
        super(1, str, listener);
        this.a = list;
        this.b = eventSerializer;
        this.c = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy());
    }

    protected Response<Void> a(NetworkResponse networkResponse) {
        return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    protected Map<String, String> a() {
        JSONArray serializeAsJson = this.b.serializeAsJson(this.a);
        Map<String, String> hashMap = new HashMap();
        hashMap.put("log", serializeAsJson.toString());
        return hashMap;
    }

    /* renamed from: a */
    protected void deliverResponse(Void voidR) {
        this.c.onResponse();
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public List<BaseEvent> getEvents() {
        return this.a;
    }
}
