package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;

@TargetApi(9)
public class ib extends hz {
    public ib() {
        super();
    }

    public final int a() {
        return 6;
    }

    public boolean a(Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    public final int b() {
        return 7;
    }
}
