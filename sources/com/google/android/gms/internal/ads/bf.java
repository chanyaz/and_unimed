package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ac;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.g;
import com.google.android.gms.ads.internal.gmsg.zzv;
import org.json.JSONObject;

@zzadh
public final class bf implements zzacm<zzaqw> {
    private zzanz<zzaqw> a;
    private final g b = new g(this.d);
    private final aoa c;
    private final Context d;
    private final zzang e;
    private final ac f;
    private final ada g;
    private String h;

    public bf(Context context, ac acVar, String str, ada ada, zzang zzang) {
        kk.d("Webview loading for native ads.");
        this.d = context;
        this.f = acVar;
        this.g = ada;
        this.e = zzang;
        this.h = str;
        au.f();
        zzanz a = nw.a(this.d, this.e, (String) akc.f().a(amn.bX), this.g, this.f.a());
        this.c = new aoa(acVar, str);
        this.a = kq.a(a, new bg(this), lf.b);
        ko.a(this.a, "WebViewNativeAdsUtil.constructor");
    }

    final /* synthetic */ zzanz a(JSONObject jSONObject, zzaqw zzaqw) {
        jSONObject.put("ads_id", this.h);
        zzaqw.zzb("google.afma.nativeAds.handleDownloadedImpressionPing", jSONObject);
        return kq.a(new JSONObject());
    }

    final /* synthetic */ zzanz b(JSONObject jSONObject, zzaqw zzaqw) {
        jSONObject.put("ads_id", this.h);
        zzaqw.zzb("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return kq.a(new JSONObject());
    }

    final /* synthetic */ zzanz c(JSONObject jSONObject, zzaqw zzaqw) {
        jSONObject.put("ads_id", this.h);
        zzaqw.zzb("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return kq.a(new JSONObject());
    }

    final /* synthetic */ zzanz d(JSONObject jSONObject, zzaqw zzaqw) {
        jSONObject.put("ads_id", this.h);
        zzanz lkVar = new lk();
        zzaqw.zza("/nativeAdPreProcess", new bl(this, zzaqw, lkVar));
        zzaqw.zzb("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return lkVar;
    }

    public final void zza(String str, zzv<? super zzaqw> zzv) {
        kq.a(this.a, new bm(this, str, zzv), lf.a);
    }

    public final void zza(String str, JSONObject jSONObject) {
        kq.a(this.a, new bo(this, str, jSONObject), lf.a);
    }

    public final void zzb(String str, zzv<? super zzaqw> zzv) {
        kq.a(this.a, new bn(this, str, zzv), lf.a);
    }

    public final zzanz<JSONObject> zzh(JSONObject jSONObject) {
        return kq.a(this.a, new bh(this, jSONObject), lf.a);
    }

    public final zzanz<JSONObject> zzi(JSONObject jSONObject) {
        return kq.a(this.a, new bi(this, jSONObject), lf.a);
    }

    public final zzanz<JSONObject> zzj(JSONObject jSONObject) {
        return kq.a(this.a, new bj(this, jSONObject), lf.a);
    }

    public final zzanz<JSONObject> zzk(JSONObject jSONObject) {
        return kq.a(this.a, new bk(this, jSONObject), lf.a);
    }

    public final void zzmc() {
        kq.a(this.a, new bp(this), lf.a);
    }
}
