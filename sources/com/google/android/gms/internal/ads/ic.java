package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
public class ic extends ib {
    public nr a(zzaqw zzaqw, boolean z) {
        return new oj(zzaqw, z);
    }

    public final Set<String> a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    public final boolean a(Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    public boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        return ((Boolean) js.a(context, new id(this, context, webSettings))).booleanValue();
    }

    public final boolean a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    public final boolean b(View view) {
        view.setLayerType(0, null);
        return true;
    }

    public final boolean c(View view) {
        view.setLayerType(1, null);
        return true;
    }
}
