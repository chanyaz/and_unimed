package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class id implements Callable<Boolean> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ WebSettings b;

    id(ic icVar, Context context, WebSettings webSettings) {
        this.a = context;
        this.b = webSettings;
    }

    public final /* synthetic */ Object call() {
        if (this.a.getCacheDir() != null) {
            this.b.setAppCachePath(this.a.getCacheDir().getAbsolutePath());
            this.b.setAppCacheMaxSize(0);
            this.b.setAppCacheEnabled(true);
        }
        this.b.setDatabasePath(this.a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.b.setDatabaseEnabled(true);
        this.b.setDomStorageEnabled(true);
        this.b.setDisplayZoomControls(false);
        this.b.setBuiltInZoomControls(true);
        this.b.setSupportZoom(true);
        this.b.setAllowContentAccess(false);
        return Boolean.valueOf(true);
    }
}
