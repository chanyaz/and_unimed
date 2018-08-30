package com.puzzlersworld.wp.a;

import android.app.Activity;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.util.InjectibleApplication;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;

public class e implements Interceptor {
    Activity a;

    public e(Activity activity) {
        this.a = activity;
    }

    public ag intercept(Chain chain) {
        ad request = chain.request();
        if (this.a == null) {
            this.a = InjectibleApplication.j();
        }
        ListeningExecutorService x = ((FullscreenActivity) this.a).x();
        x.execute(new Runnable() {
            public void run() {
                try {
                    if (e.this.a instanceof FullscreenActivity) {
                        ((FullscreenActivity) e.this.a).a("Please wait !!", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            ag proceed = chain.proceed(request);
            x.execute(new Runnable() {
                public void run() {
                    if (e.this.a instanceof FullscreenActivity) {
                        ((FullscreenActivity) e.this.a).C();
                    }
                }
            });
            return proceed;
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            x.execute(/* anonymous class already generated */);
        }
    }
}
