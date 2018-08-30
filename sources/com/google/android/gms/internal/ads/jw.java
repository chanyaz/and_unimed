package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class jw implements Callable<String> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Context b;

    jw(ju juVar, Context context, Context context2) {
        this.a = context;
        this.b = context2;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences;
        int i = 0;
        if (this.a != null) {
            hl.a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.a.getSharedPreferences("admob_user_agent", 0);
        } else {
            hl.a("Attempting to read user agent from local cache.");
            sharedPreferences = this.b.getSharedPreferences("admob_user_agent", 0);
            i = 1;
        }
        CharSequence string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            hl.a("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.b);
            if (i != 0) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                hl.a("Persisting user agent.");
            }
        }
        return string;
    }
}
