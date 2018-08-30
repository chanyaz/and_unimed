package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class ip implements OnClickListener {
    private final im a;
    private final String b;

    ip(im imVar, String str) {
        this.a = imVar;
        this.b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a(this.b, dialogInterface, i);
    }
}
