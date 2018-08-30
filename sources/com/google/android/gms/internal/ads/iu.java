package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

final class iu implements Runnable {
    final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ boolean d;

    iu(it itVar, Context context, String str, boolean z, boolean z2) {
        this.a = context;
        this.b = str;
        this.c = z;
        this.d = z2;
    }

    public final void run() {
        Builder builder = new Builder(this.a);
        builder.setMessage(this.b);
        if (this.c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.d) {
            builder.setNeutralButton("Dismiss", null);
        } else {
            builder.setPositiveButton(CtaButton.DEFAULT_CTA_TEXT, new iv(this));
            builder.setNegativeButton("Dismiss", null);
        }
        builder.create().show();
    }
}
