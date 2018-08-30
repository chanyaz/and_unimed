package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.Networking;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;

class t implements PositioningSource {
    private int a = 300000;
    @NonNull
    private final Context b;
    @NonNull
    private final Handler c;
    @NonNull
    private final Runnable d;
    private final Listener<MoPubClientPositioning> e;
    private final ErrorListener f;
    @Nullable
    private PositioningListener g;
    private int h;
    @Nullable
    private String i;
    @Nullable
    private PositioningRequest j;

    t(@NonNull Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler();
        this.d = new Runnable() {
            public void run() {
                t.this.a();
            }
        };
        this.e = new Listener<MoPubClientPositioning>() {
            public void onResponse(MoPubClientPositioning moPubClientPositioning) {
                t.this.a(moPubClientPositioning);
            }
        };
        this.f = new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (!(volleyError instanceof MoPubNetworkError) || ((MoPubNetworkError) volleyError).getReason().equals(Reason.WARMING_UP)) {
                    MoPubLog.e("Failed to load positioning data", volleyError);
                    if (volleyError.networkResponse == null && !DeviceUtils.isNetworkAvailable(t.this.b)) {
                        MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
                    }
                }
                t.this.b();
            }
        };
    }

    private void a() {
        MoPubLog.d("Loading positioning from: " + this.i);
        this.j = new PositioningRequest(this.i, this.e, this.f);
        Networking.getRequestQueue(this.b).add(this.j);
    }

    private void a(@NonNull MoPubClientPositioning moPubClientPositioning) {
        if (this.g != null) {
            this.g.onLoad(moPubClientPositioning);
        }
        this.g = null;
        this.h = 0;
    }

    private void b() {
        int pow = (int) (Math.pow(2.0d, (double) (this.h + 1)) * 1000.0d);
        if (pow >= this.a) {
            MoPubLog.d("Error downloading positioning information");
            if (this.g != null) {
                this.g.onFailed();
            }
            this.g = null;
            return;
        }
        this.h++;
        this.c.postDelayed(this.d, (long) pow);
    }

    public void loadPositions(@NonNull String str, @NonNull PositioningListener positioningListener) {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.h > 0) {
            this.c.removeCallbacks(this.d);
            this.h = 0;
        }
        this.g = positioningListener;
        this.i = new s(this.b).withAdUnitId(str).generateUrlString(Constants.HOST);
        a();
    }
}
