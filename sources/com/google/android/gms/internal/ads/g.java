package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class g implements OnClickListener {
    private final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("User canceled the download.");
    }
}
