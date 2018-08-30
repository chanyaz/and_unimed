package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import org.json.JSONObject;

@zzadh
public final class afp implements zzfo {
    private final afh a;
    private final zzaqw b;
    private final zzv<zzaqw> c = new afq(this);
    private final zzv<zzaqw> d = new afr(this);
    private final zzv<zzaqw> e = new afs(this);

    public afp(afh afh, zzaqw zzaqw) {
        this.a = afh;
        this.b = zzaqw;
        zzaqw zzaqw2 = this.b;
        zzaqw2.zza("/updateActiveView", this.c);
        zzaqw2.zza("/untrackActiveViewUnit", this.d);
        zzaqw2.zza("/visibilityChanged", this.e);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.a.a.d());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public final void zzb(JSONObject jSONObject, boolean z) {
        if (z) {
            this.a.b((zzfo) this);
        } else {
            this.b.zzb("AFMA_updateActiveView", jSONObject);
        }
    }

    public final boolean zzgk() {
        return true;
    }

    public final void zzgl() {
        zzaqw zzaqw = this.b;
        zzaqw.zzb("/visibilityChanged", this.e);
        zzaqw.zzb("/untrackActiveViewUnit", this.d);
        zzaqw.zzb("/updateActiveView", this.c);
    }
}
