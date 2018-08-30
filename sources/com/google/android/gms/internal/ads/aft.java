package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.g;
import com.google.android.gms.ads.internal.gmsg.zzv;
import org.json.JSONObject;

@zzadh
public final class aft implements zzfo {
    private final afh a;
    private final Context b;
    private final g c;
    private atl d;
    private boolean e;
    private final zzv<zzwb> f = new afy(this);
    private final zzv<zzwb> g = new afz(this);
    private final zzv<zzwb> h = new aga(this);
    private final zzv<zzwb> i = new agb(this);

    public aft(afh afh, asy asy, Context context) {
        this.a = afh;
        this.b = context;
        this.c = new g(this.b);
        this.d = asy.b(null);
        this.d.zza(new afu(this), new afv(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.a.a.d());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    final void a(zzwb zzwb) {
        zzwb.zza("/updateActiveView", this.f);
        zzwb.zza("/untrackActiveViewUnit", this.g);
        zzwb.zza("/visibilityChanged", this.h);
        if (au.B().a(this.b)) {
            zzwb.zza("/logScionEvent", this.i);
        }
    }

    final void b(zzwb zzwb) {
        zzwb.zzb("/visibilityChanged", this.h);
        zzwb.zzb("/untrackActiveViewUnit", this.g);
        zzwb.zzb("/updateActiveView", this.f);
        if (au.B().a(this.b)) {
            zzwb.zzb("/logScionEvent", this.i);
        }
    }

    public final void zzb(JSONObject jSONObject, boolean z) {
        this.d.zza(new afw(this, jSONObject), new lm());
    }

    public final boolean zzgk() {
        return this.e;
    }

    public final void zzgl() {
        this.d.zza(new afx(this), new lm());
        this.d.c();
    }
}
