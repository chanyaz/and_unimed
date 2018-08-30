package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class io implements OnClickListener {
    private final im a;
    private final int b;
    private final int c;
    private final int d;

    io(im imVar, int i, int i2, int i3) {
        this.a = imVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a(this.b, this.c, this.d, dialogInterface, i);
    }
}
