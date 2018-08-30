package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
@VisibleForTesting
public class nr extends WebViewClient implements zzasc {
    private static final String[] b = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] c = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private boolean A;
    private boolean B;
    private int C;
    private OnAttachStateChangeListener D;
    @Nullable
    protected zzait a;
    private zzaqw d;
    private final HashMap<String, List<zzv<? super zzaqw>>> e;
    private final Object f;
    private zzjd g;
    private zzn h;
    private zzasd i;
    private zzase j;
    private zzb k;
    private zzd l;
    private zzasf m;
    private boolean n;
    private zzz o;
    @GuardedBy("mLock")
    private boolean p;
    @GuardedBy("mLock")
    private boolean q;
    @GuardedBy("mLock")
    private OnGlobalLayoutListener r;
    @GuardedBy("mLock")
    private OnScrollChangedListener s;
    @GuardedBy("mLock")
    private boolean t;
    private zzt u;
    private final k v;
    private bs w;
    private b x;
    private zzaam y;
    private zzasg z;

    public nr(zzaqw zzaqw, boolean z) {
        this(zzaqw, z, new k(zzaqw, zzaqw.zzua(), new alz(zzaqw.getContext())), null);
    }

    @VisibleForTesting
    private nr(zzaqw zzaqw, boolean z, k kVar, b bVar) {
        this.e = new HashMap();
        this.f = new Object();
        this.n = false;
        this.d = zzaqw;
        this.p = z;
        this.v = kVar;
        this.x = null;
    }

    private final void a(Context context, String str, String str2, String str3) {
        if (((Boolean) akc.f().a(amn.bs)).booleanValue()) {
            String host;
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            String str4 = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    host = parse.getHost();
                    bundle.putString(str4, host);
                    au.e().a(context, this.d.zztq().a, "gmob-apps", bundle, true);
                }
            }
            host = "";
            bundle.putString(str4, host);
            au.e().a(context, this.d.zztq().a, "gmob-apps", bundle, true);
        }
    }

    private final void a(Uri uri) {
        String path = uri.getPath();
        List<zzv> list = (List) this.e.get(path);
        if (list != null) {
            au.e();
            Map a = ht.a(uri);
            if (kk.a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                hl.a(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : a.keySet()) {
                    str = (String) a.get(path2);
                    hl.a(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (zzv zza : list) {
                zza.zza(this.d, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        hl.a(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    private final void a(View view, zzait zzait, int i) {
        if (zzait.zzph() && i > 0) {
            zzait.zzr(view);
            if (zzait.zzph()) {
                ht.a.postDelayed(new nt(this, view, zzait, i), 100);
            }
        }
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean a = this.x != null ? this.x.a() : false;
        au.c();
        Context context = this.d.getContext();
        if (!a) {
            z = true;
        }
        k.a(context, adOverlayInfoParcel, z);
        if (this.a != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.a != null) {
                str = adOverlayInfoParcel.a.a;
            }
            this.a.zzcf(str);
        }
    }

    private final WebResourceResponse b(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : map.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    au.e().a(this.d.getContext(), this.d.zztq().a, false, httpURLConnection);
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

    private final void g() {
        if (this.D != null) {
            this.d.getView().removeOnAttachStateChangeListener(this.D);
        }
    }

    private final void h() {
        if (this.i != null && ((this.A && this.C <= 0) || this.B)) {
            this.i.zze(!this.B);
            this.i = null;
        }
        this.d.zzup();
    }

    @Nullable
    protected final WebResourceResponse a(String str, Map<String, String> map) {
        Throwable e;
        try {
            String a = gn.a(str, this.d.getContext());
            if (!a.equals(str)) {
                return b(a, (Map) map);
            }
            zzhl a2 = zzhl.a(str);
            if (a2 != null) {
                zzhi a3 = au.k().a(a2);
                if (a3 != null && a3.a()) {
                    return new WebResourceResponse("", "", a3.b());
                }
            }
            if (ke.c()) {
                if (((Boolean) akc.f().a(amn.bi)).booleanValue()) {
                    return b(str, (Map) map);
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

    public final void a(zzc zzc) {
        zzn zzn = null;
        boolean zzuj = this.d.zzuj();
        zzjd zzjd = (!zzuj || this.d.zzud().d()) ? this.g : null;
        if (!zzuj) {
            zzn = this.h;
        }
        a(new AdOverlayInfoParcel(zzc, zzjd, zzn, this.u, this.d.zztq()));
    }

    public final void a(String str, zzv<? super zzaqw> zzv) {
        synchronized (this.f) {
            List list = (List) this.e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.e.put(str, list);
            }
            list.add(zzv);
        }
    }

    public final void a(String str, Predicate<zzv<? super zzaqw>> predicate) {
        synchronized (this.f) {
            List<zzv> list = (List) this.e.get(str);
            if (list == null) {
                return;
            }
            Collection arrayList = new ArrayList();
            for (zzv zzv : list) {
                if (predicate.apply(zzv)) {
                    arrayList.add(zzv);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public final void a(boolean z, int i) {
        zzjd zzjd = (!this.d.zzuj() || this.d.zzud().d()) ? this.g : null;
        a(new AdOverlayInfoParcel(zzjd, this.h, this.u, this.d, z, i, this.d.zztq()));
    }

    public final void a(boolean z, int i, String str) {
        zzn zzn = null;
        boolean zzuj = this.d.zzuj();
        zzjd zzjd = (!zzuj || this.d.zzud().d()) ? this.g : null;
        if (!zzuj) {
            zzn = new nv(this.d, this.h);
        }
        a(new AdOverlayInfoParcel(zzjd, zzn, this.k, this.l, this.u, this.d, z, i, str, this.d.zztq()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean zzuj = this.d.zzuj();
        zzjd zzjd = (!zzuj || this.d.zzud().d()) ? this.g : null;
        a(new AdOverlayInfoParcel(zzjd, zzuj ? null : new nv(this.d, this.h), this.k, this.l, this.u, this.d, z, i, str, str2, this.d.zztq()));
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f) {
            z = this.q;
        }
        return z;
    }

    public final OnGlobalLayoutListener b() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f) {
            onGlobalLayoutListener = this.r;
        }
        return onGlobalLayoutListener;
    }

    public final void b(String str, zzv<? super zzaqw> zzv) {
        synchronized (this.f) {
            List list = (List) this.e.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzv);
        }
    }

    public final OnScrollChangedListener c() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f) {
            onScrollChangedListener = this.s;
        }
        return onScrollChangedListener;
    }

    public final void d() {
        if (this.a != null) {
            this.a.zzpj();
            this.a = null;
        }
        g();
        synchronized (this.f) {
            this.e.clear();
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.n = false;
            this.p = false;
            this.q = false;
            this.t = false;
            this.u = null;
            this.m = null;
            if (this.x != null) {
                this.x.a(true);
                this.x = null;
            }
        }
    }

    public final zzasg e() {
        return this.z;
    }

    final /* synthetic */ void f() {
        this.d.zzuo();
        c zzub = this.d.zzub();
        if (zzub != null) {
            zzub.c();
        }
        if (this.m != null) {
            this.m.zzdb();
            this.m = null;
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        hl.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0018, code:
            r2.A = true;
     */
    /* JADX WARNING: Missing block: B:9:0x001d, code:
            if (r2.j == null) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:10:0x001f, code:
            r2.j.zzly();
            r2.j = null;
     */
    /* JADX WARNING: Missing block: B:11:0x0027, code:
            h();
     */
    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    public final void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
        /*
        r2 = this;
        r1 = r2.f;
        monitor-enter(r1);
        r0 = r2.d;	 Catch:{ all -> 0x002b }
        r0 = r0.isDestroyed();	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r0 = "Blank page loaded, 1...";
        com.google.android.gms.internal.ads.hl.a(r0);	 Catch:{ all -> 0x002b }
        r0 = r2.d;	 Catch:{ all -> 0x002b }
        r0.zzuk();	 Catch:{ all -> 0x002b }
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
    L_0x0016:
        return;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        r0 = 1;
        r2.A = r0;
        r0 = r2.j;
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r0 = r2.j;
        r0.zzly();
        r0 = 0;
        r2.j = r0;
    L_0x0027:
        r2.h();
        goto L_0x0016;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nr.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= b.length) ? String.valueOf(i) : b[(-i) - 1];
        a(this.d.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= c.length) ? String.valueOf(primaryError) : c[primaryError];
            a(this.d.getContext(), "ssl_err", valueOf, au.g().a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Nullable
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(str, Collections.emptyMap());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        hl.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        } else {
            if (this.n && webView == this.d.getWebView()) {
                str2 = parse.getScheme();
                Object obj = (Constants.HTTP.equalsIgnoreCase(str2) || Constants.HTTPS.equalsIgnoreCase(str2)) ? 1 : null;
                if (obj != null) {
                    if (this.g != null) {
                        if (((Boolean) akc.f().a(amn.aj)).booleanValue()) {
                            this.g.onAdClicked();
                            if (this.a != null) {
                                this.a.zzcf(str);
                            }
                            this.g = null;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.d.getWebView().willNotDraw()) {
                str2 = "AdWebView unable to handle URL: ";
                valueOf = String.valueOf(str);
                kk.e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            } else {
                Uri uri;
                try {
                    ada zzui = this.d.zzui();
                    if (zzui != null && zzui.a(parse)) {
                        parse = zzui.a(parse, this.d.getContext(), this.d.getView(), this.d.zzto());
                    }
                    uri = parse;
                } catch (zzcj e) {
                    String str3 = "Unable to append parameter to URL: ";
                    str2 = String.valueOf(str);
                    kk.e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                    uri = parse;
                }
                if (this.w == null || this.w.b()) {
                    a(new zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.w.a(str);
                }
            }
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.v.a(i, i2);
        if (this.x != null) {
            this.x.a(i, i2, z);
        }
    }

    public final void zza(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f) {
            this.q = true;
            this.d.zzuo();
            this.r = onGlobalLayoutListener;
            this.s = onScrollChangedListener;
        }
    }

    public final void zza(zzasd zzasd) {
        this.i = zzasd;
    }

    public final void zza(zzase zzase) {
        this.j = zzase;
    }

    public final void zza(zzasf zzasf) {
        this.m = zzasf;
    }

    public final void zza(zzasg zzasg) {
        this.z = zzasg;
    }

    public final void zza(zzjd zzjd, zzb zzb, zzn zzn, zzd zzd, zzt zzt, boolean z, @Nullable zzz zzz, bs bsVar, zzaam zzaam, @Nullable zzait zzait) {
        bs bsVar2 = bsVar == null ? new bs(this.d.getContext(), zzait, null) : bsVar;
        this.x = new b(this.d, zzaam);
        this.a = zzait;
        if (((Boolean) akc.f().a(amn.aF)).booleanValue()) {
            a("/adMetadata", new e(zzb));
        }
        a("/appEvent", new m(zzd));
        a("/backButton", o.j);
        a("/refresh", o.k);
        a("/canOpenURLs", o.a);
        a("/canOpenIntents", o.b);
        a("/click", o.c);
        a("/close", o.d);
        a("/customClose", o.e);
        a("/instrument", o.n);
        a("/delayPageLoaded", o.p);
        a("/delayPageClosed", o.q);
        a("/getLocationInfo", o.r);
        a("/httpTrack", o.f);
        a("/log", o.g);
        a("/mraid", new h(bsVar2, this.x, zzaam));
        a("/mraidLoaded", this.v);
        a("/open", new i(this.d.getContext(), this.d.zztq(), this.d.zzui(), zzt, zzjd, zzb, zzd, zzn, bsVar2, this.x));
        a("/precache", new nh());
        a("/touch", o.i);
        a("/video", o.l);
        a("/videoMeta", o.m);
        if (au.B().a(this.d.getContext())) {
            a("/logScionEvent", new g(this.d.getContext()));
        }
        if (zzz != null) {
            a("/setInterstitialProperties", new ag(zzz));
        }
        this.g = zzjd;
        this.h = zzn;
        this.k = zzb;
        this.l = zzd;
        this.u = zzt;
        this.w = bsVar2;
        this.y = zzaam;
        this.o = zzz;
        this.n = z;
    }

    public final void zzb(int i, int i2) {
        if (this.x != null) {
            this.x.a(i, i2);
        }
    }

    public final boolean zzfz() {
        boolean z;
        synchronized (this.f) {
            z = this.p;
        }
        return z;
    }

    public final void zznk() {
        synchronized (this.f) {
            this.n = false;
            this.p = true;
            lf.a.execute(new ns(this));
        }
    }

    public final bs zzut() {
        return this.w;
    }

    public final boolean zzux() {
        boolean z;
        synchronized (this.f) {
            z = this.t;
        }
        return z;
    }

    public final void zzuz() {
        zzait zzait = this.a;
        if (zzait != null) {
            View webView = this.d.getWebView();
            if (ViewCompat.B(webView)) {
                a(webView, zzait, 10);
                return;
            }
            g();
            this.D = new nu(this, zzait);
            this.d.getView().addOnAttachStateChangeListener(this.D);
        }
    }

    public final void zzva() {
        synchronized (this.f) {
            this.t = true;
        }
        this.C++;
        h();
    }

    public final void zzvb() {
        this.C--;
        h();
    }

    public final void zzvc() {
        this.B = true;
        h();
    }

    public final zzait zzvf() {
        return this.a;
    }
}
