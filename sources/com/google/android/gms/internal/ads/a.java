package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class a implements OnClickListener {
    private final /* synthetic */ awu a;

    a(awu awu) {
        this.a = awu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("Operation denied by user.");
    }
}
