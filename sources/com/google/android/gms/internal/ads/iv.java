package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.google.android.gms.ads.internal.au;

final class iv implements OnClickListener {
    private final /* synthetic */ iu a;

    iv(iu iuVar) {
        this.a = iuVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.e();
        ht.a(this.a.a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
