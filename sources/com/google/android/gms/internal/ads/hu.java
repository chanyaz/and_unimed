package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;

final class hu implements zzoi {
    private final /* synthetic */ List a;
    private final /* synthetic */ ani b;
    private final /* synthetic */ Context c;

    hu(ht htVar, List list, ani ani, Context context) {
        this.a = list;
        this.b = ani;
        this.c = context;
    }

    public final void zzjp() {
        for (String str : this.a) {
            String str2 = "Pinging url: ";
            String valueOf = String.valueOf(str);
            kk.d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.b.a(Uri.parse(str), null, null);
        }
        this.b.a((Activity) this.c);
    }

    public final void zzjq() {
    }
}
