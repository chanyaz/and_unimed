package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.ada;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.ako;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.hr;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzabc;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzke;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzkx;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzod;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ao extends ako {
    private final zzang a;
    private final zzjn b;
    private final Future<ada> c = hr.a(new ar(this));
    private final Context d;
    private final at e;
    @Nullable
    private WebView f = new WebView(this.d);
    @Nullable
    private zzkh g;
    @Nullable
    private ada h;
    private AsyncTask<Void, Void, String> i;

    public ao(Context context, zzjn zzjn, String str, zzang zzang) {
        this.d = context;
        this.a = zzang;
        this.b = zzjn;
        this.e = new at(str);
        a(0);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.setWebViewClient(new ap(this));
        this.f.setOnTouchListener(new aq(this));
    }

    private final String b(String str) {
        if (this.h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.h.a(parse, this.d, null, null);
        } catch (Throwable e) {
            kk.c("Unable to process ad data", e);
        }
        return parse.toString();
    }

    private final void c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.d.startActivity(intent);
    }

    @VisibleForTesting
    final int a(String str) {
        int i = 0;
        Object queryParameter = Uri.parse(str).getQueryParameter(VastIconXmlManager.HEIGHT);
        if (TextUtils.isEmpty(queryParameter)) {
            return i;
        }
        try {
            akc.a();
            return kb.a(this.d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    @VisibleForTesting
    final String a() {
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) akc.f().a(amn.cx));
        builder.appendQueryParameter("query", this.e.b());
        builder.appendQueryParameter("pubId", this.e.c());
        Map d = this.e.d();
        for (String str : d.keySet()) {
            builder.appendQueryParameter(str, (String) d.get(str));
        }
        Uri build = builder.build();
        if (this.h != null) {
            try {
                build = this.h.a(build, this.d);
            } catch (Throwable e) {
                kk.c("Unable to process ad data", e);
            }
        }
        String b = b();
        String str2 = build.getEncodedQuery();
        return new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(str2).length()).append(b).append("#").append(str2).toString();
    }

    @VisibleForTesting
    final void a(int i) {
        if (this.f != null) {
            this.f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    @VisibleForTesting
    final String b() {
        String str;
        CharSequence a = this.e.a();
        if (TextUtils.isEmpty(a)) {
            str = "www.google.com";
        } else {
            CharSequence str2 = a;
        }
        String str3 = (String) akc.f().a(amn.cx);
        return new StringBuilder((String.valueOf(str2).length() + 8) + String.valueOf(str3).length()).append("https://").append(str2).append(str3).toString();
    }

    public final void destroy() {
        ar.b("destroy must be called on the main UI thread.");
        this.i.cancel(true);
        this.c.cancel(true);
        this.f.destroy();
        this.f = null;
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Nullable
    public final zzlo getVideoController() {
        return null;
    }

    public final boolean isLoading() {
        return false;
    }

    public final boolean isReady() {
        return false;
    }

    public final void pause() {
        ar.b("pause must be called on the main UI thread.");
    }

    public final void resume() {
        ar.b("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    public final void stopLoading() {
    }

    public final void zza(zzaaw zzaaw) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzabc zzabc, String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzahe zzahe) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzjn zzjn) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzke zzke) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzkh zzkh) {
        this.g = zzkh;
    }

    public final void zza(zzkx zzkx) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzla zzla) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzlg zzlg) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzlu zzlu) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzmu zzmu) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzod zzod) {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzb(zzjj zzjj) {
        ar.a(this.f, (Object) "This Search Ad has already been torn down");
        this.e.a(zzjj, this.a);
        this.i = new as(this, null).execute(new Void[0]);
        return true;
    }

    public final Bundle zzba() {
        throw new IllegalStateException("Unused method");
    }

    public final IObjectWrapper zzbj() {
        ar.b("getAdFrame must be called on the main UI thread.");
        return c.a(this.f);
    }

    public final zzjn zzbk() {
        return this.b;
    }

    public final void zzbm() {
        throw new IllegalStateException("Unused method");
    }

    public final zzla zzbw() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzkh zzbx() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Nullable
    public final String zzck() {
        return null;
    }
}
