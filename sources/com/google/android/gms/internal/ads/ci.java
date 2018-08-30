package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.g;

final class ci implements zzady {
    private final /* synthetic */ Context a;

    ci(Context context) {
        this.a = context;
    }

    public final boolean zza(zzang zzang) {
        akc.a();
        boolean c = kb.c(this.a);
        boolean z = ((Boolean) akc.f().a(amn.dd)).booleanValue() && zzang.d;
        if (ch.b(this.a, zzang.d) && c && !z) {
            if (!g.c(this.a)) {
                return false;
            }
            if (((Boolean) akc.f().a(amn.H)).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
