package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.o;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class auc<I, O> implements zzwf<I, O> {
    private final zzwh<O> a;
    private final zzwi<I> b;
    private final asy c;
    private final String d;

    auc(asy asy, String str, zzwi<I> zzwi, zzwh<O> zzwh) {
        this.c = asy;
        this.d = str;
        this.b = zzwi;
        this.a = zzwh;
    }

    private final void a(atl atl, zzwb zzwb, I i, lk<O> lkVar) {
        try {
            au.e();
            String a = ht.a();
            o.o.a(a, new auf(this, atl, lkVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", a);
            jSONObject.put("args", this.b.zzg(i));
            zzwb.zzb(this.d, jSONObject);
        } catch (Throwable e) {
            lkVar.a(e);
            kk.b("Unable to invokeJavaScript", e);
        } finally {
            atl.c();
        }
    }

    public final zzanz<O> zzc(@Nullable I i) {
        return zzf(i);
    }

    public final zzanz<O> zzf(I i) {
        zzanz lkVar = new lk();
        ln b = this.c.b(null);
        b.zza(new aud(this, b, i, lkVar), new aue(this, lkVar, b));
        return lkVar;
    }
}
