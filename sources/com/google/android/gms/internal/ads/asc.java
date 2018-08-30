package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class asc extends asn<zzwb> implements zzuo, zzuu {
    private final pc a;

    public asc(Context context, zzang zzang) {
        try {
            this.a = new pc(new oo(context));
            this.a.setWillNotDraw(true);
            this.a.a(new asd(this));
            this.a.a(new ase(this));
            this.a.addJavascriptInterface(new ask(this), "GoogleJsInterface");
            au.e().a(context, zzang.a, this.a.getSettings());
        } catch (Throwable th) {
            zzarg zzarg = new zzarg("Init failed.", th);
        }
    }

    final /* synthetic */ void a(String str) {
        this.a.zzbe(str);
    }

    final /* synthetic */ void b(String str) {
        this.a.loadUrl(str);
    }

    final /* synthetic */ void c(String str) {
        this.a.loadData(str, "text/html", "UTF-8");
    }

    public final void destroy() {
        this.a.destroy();
    }

    public final /* bridge */ /* synthetic */ Object f() {
        if (this != null) {
            return this;
        }
        throw null;
    }

    public final void zza(zzuv zzuv) {
        this.a.a(new ash(zzuv));
    }

    public final void zza(String str, Map map) {
        asl.a((zzuo) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        asl.b(this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        asl.a((zzuo) this, str, jSONObject);
    }

    public final void zzbb(String str) {
        zzbc(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzbc(String str) {
        lf.a.execute(new asf(this, str));
    }

    public final void zzbd(String str) {
        lf.a.execute(new asg(this, str));
    }

    public final void zzbe(String str) {
        lf.a.execute(new asi(this, str));
    }

    public final void zzf(String str, String str2) {
        asl.a((zzuo) this, str, str2);
    }

    public final zzwc zzlw() {
        return new atu(this);
    }
}
