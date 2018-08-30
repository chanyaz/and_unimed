package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

final class nk implements OnCancelListener {
    private final /* synthetic */ JsResult a;

    nk(JsResult jsResult) {
        this.a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
