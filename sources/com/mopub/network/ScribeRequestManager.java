package com.mopub.network;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeRequest.Listener;
import com.mopub.network.ScribeRequest.ScribeRequestFactory;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;

public class ScribeRequestManager extends RequestManager<ScribeRequestFactory> implements Listener {
    public ScribeRequestManager(Looper looper) {
        super(looper);
    }

    @NonNull
    Request<?> a() {
        return ((ScribeRequestFactory) this.b).createRequest(this);
    }

    public void onErrorResponse(final VolleyError volleyError) {
        this.d.post(new Runnable() {
            public void run() {
                try {
                    ScribeRequestManager.this.c.backoff(volleyError);
                    ScribeRequestManager.this.b();
                } catch (VolleyError e) {
                    MoPubLog.d("Failed to Scribe events: " + volleyError);
                    ScribeRequestManager.this.c();
                }
            }
        });
    }

    public void onResponse() {
        MoPubLog.d("Successfully scribed events");
        this.d.post(new Runnable() {
            public void run() {
                ScribeRequestManager.this.c();
            }
        });
    }
}
