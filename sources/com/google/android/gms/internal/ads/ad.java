package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.ac;
import com.google.android.gms.common.util.p;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ad {
    public static zzalc a(Context context, a aVar, gs gsVar, ada ada, @Nullable zzaqw zzaqw, zzxn zzxn, zzabm zzabm, ana ana) {
        zzalc aiVar;
        zzaej zzaej = gsVar.b;
        if (zzaej.g) {
            aiVar = new ai(context, gsVar, zzxn, zzabm, ana, zzaqw);
        } else if (zzaej.s || (aVar instanceof ac)) {
            aiVar = (zzaej.s && (aVar instanceof ac)) ? new ak(context, (ac) aVar, gsVar, ada, zzabm, ana) : new af(gsVar, zzabm);
        } else {
            aiVar = (((Boolean) akc.f().a(amn.ah)).booleanValue() && p.g() && !p.i() && zzaqw != null && zzaqw.zzud().d()) ? new ah(context, gsVar, zzaqw, zzabm) : new ae(context, gsVar, zzaqw, zzabm);
        }
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(aiVar.getClass().getName());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        aiVar.zznt();
        return aiVar;
    }
}
