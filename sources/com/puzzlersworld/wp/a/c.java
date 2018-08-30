package com.puzzlersworld.wp.a;

import com.puzzlersworld.android.FullscreenActivity;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ag;

public class c implements Interceptor {
    public ag intercept(Chain chain) {
        return chain.proceed(chain.request().e().b("Authorization", "Basic " + FullscreenActivity.s).a());
    }
}
