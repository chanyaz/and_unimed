package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class asp implements zzuo, zzuu {
    private final zzaqw a;
    private final Context b;

    public asp(Context context, zzang zzang, @Nullable ada ada, br brVar) {
        this.b = context;
        au.f();
        this.a = nw.a(context, op.a(), "", false, false, ada, zzang, null, null, null, ahx.a());
        this.a.getView().setWillNotDraw(true);
    }

    private static void a(Runnable runnable) {
        akc.a();
        if (kb.b()) {
            runnable.run();
        } else {
            ht.a.post(runnable);
        }
    }

    public final void destroy() {
        this.a.destroy();
    }

    public final void zza(zzuv zzuv) {
        zzasc zzuf = this.a.zzuf();
        zzuv.getClass();
        zzuf.zza(ass.a(zzuv));
    }

    public final void zza(String str, zzv<? super zzwb> zzv) {
        this.a.zza(str, new asx(this, zzv));
    }

    public final void zza(String str, Map map) {
        asl.a((zzuo) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        asl.b(this, str, jSONObject);
    }

    public final void zzb(String str, zzv<? super zzwb> zzv) {
        this.a.zza(str, new asr(zzv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        asl.a((zzuo) this, str, jSONObject);
    }

    public final void zzbb(String str) {
        a(new asu(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzbc(String str) {
        a(new asv(this, str));
    }

    public final void zzbd(String str) {
        a(new asw(this, str));
    }

    public final void zzbe(String str) {
        a(new asq(this, str));
    }

    public final void zzf(String str, String str2) {
        asl.a((zzuo) this, str, str2);
    }

    public final zzwc zzlw() {
        return new atu(this);
    }
}
