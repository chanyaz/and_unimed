package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.au;

final class awv implements OnClickListener {
    private final /* synthetic */ awu a;

    awv(awu awu) {
        this.a = awu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent b = this.a.b();
        au.e();
        ht.a(this.a.b, b);
    }
}
