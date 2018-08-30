package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.bs;
import com.google.android.gms.ads.internal.gmsg.ag;
import com.google.android.gms.ads.internal.gmsg.e;
import com.google.android.gms.ads.internal.gmsg.g;
import com.google.android.gms.ads.internal.gmsg.h;
import com.google.android.gms.ads.internal.gmsg.i;
import com.google.android.gms.ads.internal.gmsg.m;
import com.google.android.gms.ads.internal.gmsg.o;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.Constants;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
@VisibleForTesting
public final class oq extends asn<zzaqw> implements zzasc, zzasx, zzasz, zzata, zzatb {
    private OnAttachStateChangeListener A;
    private zzaqw a;
    private final Object b;
    private zzjd c;
    private zzn d;
    private zzasd e;
    private zzase f;
    private zzb g;
    private zzd h;
    private zzasf i;
    private boolean j;
    private zzz k;
    private boolean l;
    private boolean m;
    private OnGlobalLayoutListener n;
    private OnScrollChangedListener o;
    private boolean p;
    private zzt q;
    private final k r;
    private bs s;
    private b t;
    private zzaam u;
    private zzasg v;
    @Nullable
    private zzait w;
    private boolean x;
    private boolean y;
    private int z;

    public oq(zzaqw zzaqw, boolean z) {
        this(zzaqw, z, new k(zzaqw, zzaqw.zzua(), new alz(zzaqw.getContext())), null);
    }

    @VisibleForTesting
    private oq(zzaqw zzaqw, boolean z, k kVar, b bVar) {
        this.b = new Object();
        this.j = false;
        this.a = zzaqw;
        this.l = z;
        this.r = kVar;
        this.t = null;
    }

    private final WebResourceResponse a(pb pbVar) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(pbVar.a);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : pbVar.c.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    au.e().a(this.a.getContext(), this.a.zztq().a, false, httpURLConnection);
                    ke keVar = new ke();
                    keVar.a(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    keVar.a(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        au.e();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        }
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            kk.e("Protocol is null");
                            return null;
                        } else if (protocol.equals(Constants.HTTP) || protocol.equals(Constants.HTTPS)) {
                            protocol = "Redirecting to ";
                            headerField = String.valueOf(headerField);
                            kk.b(headerField.length() != 0 ? protocol.concat(headerField) : new String(protocol));
                            httpURLConnection.disconnect();
                            i = i2;
                            url = url2;
                        } else {
                            headerField = "Unsupported scheme: ";
                            String valueOf = String.valueOf(protocol);
                            kk.e(valueOf.length() != 0 ? headerField.concat(valueOf) : new String(headerField));
                            return null;
                        }
                    }
                }
                throw new IOException("Invalid protocol.");
            }
            throw new IOException("Too many redirects (20)");
        }
        au.e();
        return ht.a(httpURLConnection);
    }

    private final void a(View view, zzait zzait, int i) {
        if (zzait.zzph() && i > 0) {
            zzait.zzr(view);
            if (zzait.zzph()) {
                ht.a.postDelayed(new os(this, view, zzait, i), 100);
            }
        }
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean a = this.t != null ? this.t.a() : false;
        au.c();
        Context context = this.a.getContext();
        if (!a) {
            z = true;
        }
        k.a(context, adOverlayInfoParcel, z);
        if (this.w != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.a != null) {
                str = adOverlayInfoParcel.a.a;
            }
            this.w.zzcf(str);
        }
    }

    private final void h() {
        if (this.A != null) {
            this.a.getView().removeOnAttachStateChangeListener(this.A);
        }
    }

    private final void i() {
        if (this.e != null && ((this.x && this.z <= 0) || this.y)) {
            this.e.zze(!this.y);
            this.e = null;
        }
        this.a.zzup();
    }

    public final void a(zzc zzc) {
        zzn zzn = null;
        boolean zzuj = this.a.zzuj();
        zzjd zzjd = (!zzuj || this.a.zzud().d()) ? this.c : null;
        if (!zzuj) {
            zzn = this.d;
        }
        a(new AdOverlayInfoParcel(zzc, zzjd, zzn, this.q, this.a.zztq()));
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a(boolean z, int i) {
        zzjd zzjd = (!this.a.zzuj() || this.a.zzud().d()) ? this.c : null;
        a(new AdOverlayInfoParcel(zzjd, this.d, this.q, this.a, z, i, this.a.zztq()));
    }

    public final void a(boolean z, int i, String str) {
        zzn zzn = null;
        boolean zzuj = this.a.zzuj();
        zzjd zzjd = (!zzuj || this.a.zzud().d()) ? this.c : null;
        if (!zzuj) {
            zzn = new ou(this.a, this.d);
        }
        a(new AdOverlayInfoParcel(zzjd, zzn, this.g, this.h, this.q, this.a, z, i, str, this.a.zztq()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean zzuj = this.a.zzuj();
        zzjd zzjd = (!zzuj || this.a.zzud().d()) ? this.c : null;
        a(new AdOverlayInfoParcel(zzjd, zzuj ? null : new ou(this.a, this.d), this.g, this.h, this.q, this.a, z, i, str, str2, this.a.zztq()));
    }

    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.m;
        }
        return z;
    }

    public final OnGlobalLayoutListener b() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.b) {
            onGlobalLayoutListener = this.n;
        }
        return onGlobalLayoutListener;
    }

    public final OnScrollChangedListener c() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.b) {
            onScrollChangedListener = this.o;
        }
        return onScrollChangedListener;
    }

    public final void d() {
        if (this.w != null) {
            this.w.zzpj();
            this.w = null;
        }
        h();
        super.d();
        synchronized (this.b) {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.j = false;
            this.l = false;
            this.m = false;
            this.p = false;
            this.q = null;
            this.i = null;
            if (this.t != null) {
                this.t.a(true);
                this.t = null;
            }
        }
    }

    public final zzasg e() {
        return this.v;
    }

    public final /* synthetic */ Object f() {
        return this.a;
    }

    final /* synthetic */ void g() {
        this.a.zzuo();
        c zzub = this.a.zzub();
        if (zzub != null) {
            zzub.c();
        }
        if (this.i != null) {
            this.i.zzdb();
            this.i = null;
        }
    }

    public final void zza(int i, int i2, boolean z) {
        this.r.a(i, i2);
        if (this.t != null) {
            this.t.a(i, i2, z);
        }
    }

    public final void zza(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.b) {
            this.m = true;
            this.a.zzuo();
            this.n = onGlobalLayoutListener;
            this.o = onScrollChangedListener;
        }
    }

    public final void zza(zzasd zzasd) {
        this.e = zzasd;
    }

    public final void zza(zzase zzase) {
        this.f = zzase;
    }

    public final void zza(zzasf zzasf) {
        this.i = zzasf;
    }

    public final void zza(zzasg zzasg) {
        this.v = zzasg;
    }

    public final void zza(zzjd zzjd, zzb zzb, zzn zzn, zzd zzd, zzt zzt, boolean z, @Nullable zzz zzz, bs bsVar, zzaam zzaam, @Nullable zzait zzait) {
        bs bsVar2 = bsVar == null ? new bs(this.a.getContext(), zzait, null) : bsVar;
        this.t = new b(this.a, zzaam);
        this.w = zzait;
        if (((Boolean) akc.f().a(amn.aF)).booleanValue()) {
            zza("/adMetadata", new e(zzb));
        }
        zza("/appEvent", new m(zzd));
        zza("/backButton", o.j);
        zza("/refresh", o.k);
        zza("/canOpenURLs", o.a);
        zza("/canOpenIntents", o.b);
        zza("/click", o.c);
        zza("/close", o.d);
        zza("/customClose", o.e);
        zza("/instrument", o.n);
        zza("/delayPageLoaded", o.p);
        zza("/delayPageClosed", o.q);
        zza("/getLocationInfo", o.r);
        zza("/httpTrack", o.f);
        zza("/log", o.g);
        zza("/mraid", new h(bsVar2, this.t, zzaam));
        zza("/mraidLoaded", this.r);
        zza("/open", new i(this.a.getContext(), this.a.zztq(), this.a.zzui(), zzt, zzjd, zzb, zzd, zzn, bsVar2, this.t));
        zza("/precache", new nh());
        zza("/touch", o.i);
        zza("/video", o.l);
        zza("/videoMeta", o.m);
        if (au.B().a(this.a.getContext())) {
            zza("/logScionEvent", new g(this.a.getContext()));
        }
        if (zzz != null) {
            zza("/setInterstitialProperties", new ag(zzz));
        }
        this.c = zzjd;
        this.d = zzn;
        this.g = zzb;
        this.h = zzd;
        this.q = zzt;
        this.s = bsVar2;
        this.u = zzaam;
        this.k = zzz;
        this.j = z;
    }

    public final boolean zza(pb pbVar) {
        String str = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(pbVar.a);
        hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        Uri uri = pbVar.b;
        if (a(uri)) {
            return true;
        }
        if (this.j) {
            str = uri.getScheme();
            Object obj = (Constants.HTTP.equalsIgnoreCase(str) || Constants.HTTPS.equalsIgnoreCase(str)) ? 1 : null;
            if (obj != null) {
                if (this.c != null) {
                    if (((Boolean) akc.f().a(amn.aj)).booleanValue()) {
                        this.c.onAdClicked();
                        if (this.w != null) {
                            this.w.zzcf(pbVar.a);
                        }
                        this.c = null;
                    }
                }
                return false;
            }
        }
        String str2;
        if (this.a.getWebView().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(pbVar.a);
            kk.e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri2;
            try {
                ada zzui = this.a.zzui();
                if (zzui != null && zzui.a(uri)) {
                    uri = zzui.a(uri, this.a.getContext(), this.a.getView(), this.a.zzto());
                }
                uri2 = uri;
            } catch (zzcj e) {
                str = "Unable to append parameter to URL: ";
                str2 = String.valueOf(pbVar.a);
                kk.e(str2.length() != 0 ? str.concat(str2) : new String(str));
                uri2 = uri;
            }
            if (this.s == null || this.s.b()) {
                a(new zzc("android.intent.action.VIEW", uri2.toString(), null, null, null, null, null));
            } else {
                this.s.a(pbVar.a);
            }
        }
        return true;
    }

    public final void zzb(int i, int i2) {
        if (this.t != null) {
            this.t.a(i, i2);
        }
    }

    public final void zzb(pb pbVar) {
        a(pbVar.b);
    }

    public final void zzc(pb pbVar) {
        this.x = true;
        if (this.f != null) {
            this.f.zzly();
            this.f = null;
        }
        i();
    }

    @Nullable
    public final WebResourceResponse zzd(pb pbVar) {
        WebResourceResponse c;
        Throwable e;
        if (this.w != null) {
            this.w.zza(pbVar.a, pbVar.c, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(pbVar.a).getName())) {
            String str;
            zznk();
            if (this.a.zzud().d()) {
                str = (String) akc.f().a(amn.K);
            } else if (this.a.zzuj()) {
                str = (String) akc.f().a(amn.J);
            } else {
                str = (String) akc.f().a(amn.I);
            }
            au.e();
            c = ht.c(this.a.getContext(), this.a.zztq().a, str);
        } else {
            c = null;
        }
        if (c != null) {
            return c;
        }
        try {
            if (!gn.a(pbVar.a, this.a.getContext()).equals(pbVar.a)) {
                return a(pbVar);
            }
            zzhl a = zzhl.a(pbVar.a);
            if (a != null) {
                zzhi a2 = au.k().a(a);
                if (a2 != null && a2.a()) {
                    return new WebResourceResponse("", "", a2.b());
                }
            }
            if (ke.c()) {
                if (((Boolean) akc.f().a(amn.bi)).booleanValue()) {
                    return a(pbVar);
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
            au.i().a(e, "AdWebViewClient.interceptRequest");
            return null;
        } catch (NoClassDefFoundError e3) {
            e = e3;
            au.i().a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    public final boolean zzfz() {
        boolean z;
        synchronized (this.b) {
            z = this.l;
        }
        return z;
    }

    public final void zznk() {
        synchronized (this.b) {
            this.j = false;
            this.l = true;
            lf.a.execute(new or(this));
        }
    }

    public final bs zzut() {
        return this.s;
    }

    public final boolean zzux() {
        boolean z;
        synchronized (this.b) {
            z = this.p;
        }
        return z;
    }

    public final void zzuz() {
        zzait zzait = this.w;
        if (zzait != null) {
            View webView = this.a.getWebView();
            if (ViewCompat.B(webView)) {
                a(webView, zzait, 10);
                return;
            }
            h();
            this.A = new ot(this, zzait);
            this.a.getView().addOnAttachStateChangeListener(this.A);
        }
    }

    public final void zzva() {
        synchronized (this.b) {
            this.p = true;
        }
        this.z++;
        i();
    }

    public final void zzvb() {
        this.z--;
        i();
    }

    public final void zzvc() {
        this.y = true;
        i();
    }

    public final zzait zzvf() {
        return this.w;
    }
}
