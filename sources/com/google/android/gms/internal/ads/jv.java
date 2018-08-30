package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.q;
import java.util.concurrent.Callable;

final class jv implements Callable<String> {
    private final /* synthetic */ Context a;

    jv(ju juVar, Context context) {
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("admob_user_agent", 0);
        CharSequence string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            hl.a("User agent is not initialized on Google Play Services. Initializing.");
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.a);
            q.a(this.a, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
            return defaultUserAgent;
        }
        hl.a("User agent is already initialized on Google Play Services.");
        return string;
    }
}
