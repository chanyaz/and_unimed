package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.mopub.common.Constants;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest;
import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

public class MoPubConversionTracker {
    private Context a;
    private String b;
    private SharedPreferences c;
    private String d;

    private boolean a() {
        return this.c.getBoolean(this.b, false);
    }

    public void reportAppOpen(Context context) {
        if (context != null) {
            this.a = context;
            this.d = this.a.getPackageName();
            this.b = this.d + " tracked";
            this.c = SharedPreferencesHelper.getSharedPreferences(this.a);
            if (a()) {
                MoPubLog.d("Conversion already tracked");
            } else {
                TrackingRequest.makeTrackingHttpRequest(new l(this, null).generateUrlString(Constants.HOST), this.a, new Listener() {
                    public void onErrorResponse(VolleyError volleyError) {
                    }

                    public void onResponse(@NonNull String str) {
                        MoPubConversionTracker.this.c.edit().putBoolean(MoPubConversionTracker.this.b, true).commit();
                    }
                });
            }
        }
    }
}
