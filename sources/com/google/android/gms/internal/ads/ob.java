package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzbo;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import com.google.android.gms.internal.ads.zzhu.zza.zzb;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
@VisibleForTesting
final class ob extends WebView implements OnGlobalLayoutListener, DownloadListener, zzaqw {
    @GuardedBy("this")
    private int A;
    @GuardedBy("this")
    private int B;
    private amy C;
    private amy D;
    private amy E;
    private amz F;
    private WeakReference<OnClickListener> G;
    @GuardedBy("this")
    private c H;
    @GuardedBy("this")
    private boolean I;
    private ka J;
    private int K = -1;
    private int L = -1;
    private int M = -1;
    private int N = -1;
    private Map<String, nd> O;
    private final WindowManager P;
    private final ahx Q;
    private final oo a;
    @Nullable
    private final ada b;
    private final zzang c;
    private final zzbo d;
    private final br e;
    private final DisplayMetrics f;
    private final float g;
    private boolean h = false;
    private boolean i = false;
    private nr j;
    @GuardedBy("this")
    private c k;
    @GuardedBy("this")
    private op l;
    @GuardedBy("this")
    private String m;
    @GuardedBy("this")
    private boolean n;
    @GuardedBy("this")
    private boolean o;
    @GuardedBy("this")
    private boolean p;
    @GuardedBy("this")
    private boolean q;
    @GuardedBy("this")
    private Boolean r;
    @GuardedBy("this")
    private int s;
    @GuardedBy("this")
    private boolean t = true;
    @GuardedBy("this")
    private boolean u = false;
    @GuardedBy("this")
    private String v = "";
    @GuardedBy("this")
    private oe w;
    @GuardedBy("this")
    private boolean x;
    @GuardedBy("this")
    private boolean y;
    @GuardedBy("this")
    private zzox z;

    @VisibleForTesting
    private ob(oo ooVar, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        super(ooVar);
        this.a = ooVar;
        this.l = opVar;
        this.m = str;
        this.p = z;
        this.s = -1;
        this.b = ada;
        this.c = zzang;
        this.d = zzbo;
        this.e = brVar;
        this.P = (WindowManager) getContext().getSystemService("window");
        au.e();
        this.f = ht.a(this.P);
        this.g = this.f.density;
        this.Q = ahx;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable e) {
            kk.b("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        au.e().a((Context) ooVar, zzang.a, settings);
        au.g().a(getContext(), settings);
        setDownloadListener(this);
        e();
        if (p.e()) {
            addJavascriptInterface(oh.a(this), "googleAdsJsInterface");
        }
        if (p.a()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.J = new ka(this.a.a(), this, this, null);
        j();
        this.F = new amz(new ana(true, "make_wv", this.m));
        this.F.a().a(ana);
        this.D = amt.a(this.F.a());
        this.F.a("native:view_create", this.D);
        this.E = null;
        this.C = null;
        au.g().b((Context) ooVar);
        au.i().i();
    }

    static ob a(Context context, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        return new ob(new oo(context), opVar, str, z, z2, ada, zzang, ana, zzbo, brVar, ahx);
    }

    @VisibleForTesting
    private final void a(Boolean bool) {
        synchronized (this) {
            this.r = bool;
        }
        au.i().a(bool);
    }

    private final synchronized void a(String str) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    @TargetApi(19)
    private final synchronized void a(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    private final void a(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    private final boolean a() {
        if (!this.j.zzfz() && !this.j.a()) {
            return false;
        }
        int i;
        int i2;
        akc.a();
        int b = kb.b(this.f, this.f.widthPixels);
        akc.a();
        int b2 = kb.b(this.f, this.f.heightPixels);
        Activity a = this.a.a();
        if (a == null || a.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            au.e();
            int[] a2 = ht.a(a);
            akc.a();
            i2 = kb.b(this.f, a2[0]);
            akc.a();
            i = kb.b(this.f, a2[1]);
        }
        if (this.L == b && this.K == b2 && this.M == i2 && this.N == i) {
            return false;
        }
        boolean z = (this.L == b && this.K == b2) ? false : true;
        this.L = b;
        this.K = b2;
        this.M = i2;
        this.N = i;
        new l(this).a(b, b2, i2, i, this.f.density, this.P.getDefaultDisplay().getRotation());
        return z;
    }

    private final synchronized void b() {
        this.r = au.i().c();
        if (this.r == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                a(Boolean.valueOf(true));
            } catch (IllegalStateException e) {
                a(Boolean.valueOf(false));
            }
        }
        return;
    }

    private final synchronized void b(String str) {
        Throwable e;
        try {
            super.loadUrl(str);
        } catch (Exception e2) {
            e = e2;
            au.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            kk.c("Could not call loadUrl. ", e);
        } catch (NoClassDefFoundError e3) {
            e = e3;
            au.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            kk.c("Could not call loadUrl. ", e);
        } catch (IncompatibleClassChangeError e4) {
            e = e4;
            au.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            kk.c("Could not call loadUrl. ", e);
        } catch (UnsatisfiedLinkError e5) {
            e = e5;
            au.i().a(e, "AdWebViewImpl.loadUrlUnsafe");
            kk.c("Could not call loadUrl. ", e);
        }
    }

    @VisibleForTesting
    private final synchronized Boolean c() {
        return this.r;
    }

    private final void c(String str) {
        String str2;
        String valueOf;
        if (p.g()) {
            if (c() == null) {
                b();
            }
            if (c().booleanValue()) {
                a(str, null);
                return;
            }
            str2 = "javascript:";
            valueOf = String.valueOf(str);
            a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    private final void d() {
        amt.a(this.F.a(), this.D, "aeh2");
    }

    private final synchronized void e() {
        if (this.p || this.l.d()) {
            kk.b("Enabling hardware acceleration on an overlay.");
            g();
        } else if (VERSION.SDK_INT < 18) {
            kk.b("Disabling hardware acceleration on an AdView.");
            f();
        } else {
            kk.b("Enabling hardware acceleration on an AdView.");
            g();
        }
    }

    private final synchronized void f() {
        if (!this.q) {
            au.g().c((View) this);
        }
        this.q = true;
    }

    private final synchronized void g() {
        if (this.q) {
            au.g().b((View) this);
        }
        this.q = false;
    }

    private final synchronized void h() {
        if (!this.I) {
            this.I = true;
            au.i().j();
        }
    }

    private final synchronized void i() {
        this.O = null;
    }

    private final void j() {
        if (this.F != null) {
            ana a = this.F.a();
            if (a != null && au.i().b() != null) {
                au.i().b().a(a);
            }
        }
    }

    public final synchronized void destroy() {
        j();
        this.J.b();
        if (this.k != null) {
            this.k.a();
            this.k.onDestroy();
            this.k = null;
        }
        this.j.d();
        if (!this.o) {
            au.z();
            nc.a((zzapw) this);
            i();
            this.o = true;
            hl.a("Initiating WebView self destruct sequence in 3...");
            hl.a("Loading blank page in WebView, 2...");
            b("about:blank");
        }
    }

    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            kk.f("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else {
            super.evaluateJavascript(str, valueCallback);
        }
    }

    protected final void finalize() {
        try {
            synchronized (this) {
                if (!this.o) {
                    this.j.d();
                    au.z();
                    nc.a((zzapw) this);
                    i();
                    h();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final OnClickListener getOnClickListener() {
        return (OnClickListener) this.G.get();
    }

    public final synchronized int getRequestedOrientation() {
        return this.s;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final synchronized boolean isDestroyed() {
        return this.o;
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public final synchronized void loadUrl(String str) {
        Throwable e;
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            try {
                super.loadUrl(str);
            } catch (Exception e2) {
                e = e2;
                au.i().a(e, "AdWebViewImpl.loadUrl");
                kk.c("Could not call loadUrl. ", e);
            } catch (NoClassDefFoundError e3) {
                e = e3;
                au.i().a(e, "AdWebViewImpl.loadUrl");
                kk.c("Could not call loadUrl. ", e);
            } catch (IncompatibleClassChangeError e4) {
                e = e4;
                au.i().a(e, "AdWebViewImpl.loadUrl");
                kk.c("Could not call loadUrl. ", e);
            }
        }
    }

    protected final synchronized void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.J.c();
        }
        boolean z2 = this.x;
        if (this.j == null || !this.j.a()) {
            z = z2;
        } else {
            if (!this.y) {
                OnGlobalLayoutListener b = this.j.b();
                if (b != null) {
                    au.A();
                    if (this == null) {
                        throw null;
                    }
                    lp.a((View) this, b);
                }
                OnScrollChangedListener c = this.j.c();
                if (c != null) {
                    au.A();
                    if (this == null) {
                        throw null;
                    }
                    lp.a((View) this, c);
                }
                this.y = true;
            }
            a();
            z = true;
        }
        a(z);
    }

    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.J.d();
            }
            super.onDetachedFromWindow();
            if (this.y && this.j != null && this.j.a() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener b = this.j.b();
                if (b != null) {
                    au.g().a(getViewTreeObserver(), b);
                }
                OnScrollChangedListener c = this.j.c();
                if (c != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(c);
                }
                this.y = false;
            }
        }
        a(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            au.e();
            ht.a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            kk.b(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (this.j != null && this.j.e() != null) {
                    this.j.e().zzda();
                }
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) akc.f().a(amn.ay)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean a = a();
        c zzub = zzub();
        if (zzub != null && a) {
            zzub.e();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
        } else if (isInEditMode() || this.p || this.l.e()) {
            super.onMeasure(i, i2);
        } else if (this.l.f()) {
            oe zztm = zztm();
            float aspectRatio = zztm != null ? zztm.getAspectRatio() : 0.0f;
            if (aspectRatio == 0.0f) {
                super.onMeasure(i, i2);
            } else {
                int size = MeasureSpec.getSize(i);
                int size2 = MeasureSpec.getSize(i2);
                i3 = (int) (((float) size2) * aspectRatio);
                i4 = (int) (((float) size) / aspectRatio);
                if (size2 == 0 && i4 != 0) {
                    i3 = (int) (((float) i4) * aspectRatio);
                    size2 = i4;
                } else if (size == 0 && i3 != 0) {
                    i4 = (int) (((float) i3) / aspectRatio);
                    size = i3;
                }
                setMeasuredDimension(Math.min(i3, size), Math.min(i4, size2));
            }
        } else if (this.l.c()) {
            if (((Boolean) akc.f().a(amn.cm)).booleanValue() || !p.e()) {
                super.onMeasure(i, i2);
            } else {
                zza("/contentHeight", new oc(this));
                c("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f = this.f.density;
                i3 = MeasureSpec.getSize(i);
                switch (this.B) {
                    case -1:
                        i4 = MeasureSpec.getSize(i2);
                        break;
                    default:
                        i4 = (int) (f * ((float) this.B));
                        break;
                }
                setMeasuredDimension(i3, i4);
            }
        } else if (this.l.d()) {
            setMeasuredDimension(this.f.widthPixels, this.f.heightPixels);
        } else {
            Object obj;
            i3 = MeasureSpec.getMode(i);
            int size3 = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i2);
            int size4 = MeasureSpec.getSize(i2);
            int i5 = (i3 == Integer.MIN_VALUE || i3 == 1073741824) ? size3 : MoPubClientPositioning.NO_REPEAT;
            mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : MoPubClientPositioning.NO_REPEAT;
            Object obj2 = (this.l.b > i5 || this.l.a > mode) ? 1 : null;
            if (((Boolean) akc.f().a(amn.dh)).booleanValue()) {
                obj = (((float) this.l.b) / this.g > ((float) i5) / this.g || ((float) this.l.a) / this.g > ((float) mode) / this.g) ? null : 1;
                if (obj2 == null) {
                    obj = obj2;
                }
            } else {
                obj = obj2;
            }
            if (obj != null) {
                kk.e("Not enough space to show ad. Needs " + ((int) (((float) this.l.b) / this.g)) + "x" + ((int) (((float) this.l.a) / this.g)) + " dp, but only has " + ((int) (((float) size3) / this.g)) + "x" + ((int) (((float) size4) / this.g)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
                if (!this.h) {
                    this.Q.a(zzb.BANNER_SIZE_INVALID);
                    this.h = true;
                }
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                if (!this.i) {
                    this.Q.a(zzb.BANNER_SIZE_VALID);
                    this.i = true;
                }
                setMeasuredDimension(this.l.b, this.l.a);
            }
        }
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                if (p.a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                kk.b("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                if (p.a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                kk.b("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j.a()) {
            synchronized (this) {
                if (this.z != null) {
                    this.z.zzc(motionEvent);
                }
            }
        } else if (this.b != null) {
            this.b.a(motionEvent);
        }
        return isDestroyed() ? false : super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.G = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.s = i;
        if (this.k != null) {
            this.k.a(this.s);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof nr) {
            this.j = (nr) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                kk.b("Could not stop loading webview.", e);
            }
        }
    }

    public final synchronized void zza(c cVar) {
        this.k = cVar;
    }

    public final void zza(zzc zzc) {
        this.j.a(zzc);
    }

    public final void zza(agf agf) {
        synchronized (this) {
            this.x = agf.a;
        }
        a(agf.a);
    }

    public final synchronized void zza(oe oeVar) {
        if (this.w != null) {
            kk.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.w = oeVar;
        }
    }

    public final synchronized void zza(op opVar) {
        this.l = opVar;
        requestLayout();
    }

    public final void zza(String str, zzv<? super zzaqw> zzv) {
        if (this.j != null) {
            this.j.a(str, (zzv) zzv);
        }
    }

    public final void zza(String str, Predicate<zzv<? super zzaqw>> predicate) {
        if (this.j != null) {
            this.j.a(str, (Predicate) predicate);
        }
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, au.e().a((Map) map));
        } catch (JSONException e) {
            kk.e("Could not convert parameters to JSON.");
        }
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        kk.b(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        c(stringBuilder.toString());
    }

    public final void zza(boolean z, int i) {
        this.j.a(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.j.a(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.j.a(z, i, str, str2);
    }

    public final void zzah(boolean z) {
        this.j.a(z);
    }

    public final void zzai(int i) {
        if (i == 0) {
            amt.a(this.F.a(), this.D, "aebb2");
        }
        d();
        if (this.F.a() != null) {
            this.F.a().a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.c.a);
        zza("onhide", hashMap);
    }

    public final synchronized void zzai(boolean z) {
        Object obj = z != this.p ? 1 : null;
        this.p = z;
        e();
        if (obj != null) {
            new l(this).c(z ? "expanded" : RewardedVideo.VIDEO_MODE_DEFAULT);
        }
    }

    public final synchronized void zzaj(boolean z) {
        this.t = z;
    }

    public final synchronized void zzak(boolean z) {
        this.A = (z ? 1 : -1) + this.A;
        if (this.A <= 0 && this.k != null) {
            this.k.g();
        }
    }

    public final synchronized void zzb(c cVar) {
        this.H = cVar;
    }

    public final synchronized void zzb(zzox zzox) {
        this.z = zzox;
    }

    public final void zzb(String str, zzv<? super zzaqw> zzv) {
        if (this.j != null) {
            this.j.b(str, (zzv) zzv);
        }
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        c(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(jSONObject2).length()).append(str).append("(").append(jSONObject2).append(");").toString());
    }

    public final void zzbe(String str) {
        c(str);
    }

    public final br zzbi() {
        return this.e;
    }

    public final void zzbm(Context context) {
        this.a.setBaseContext(context);
        this.J.a(this.a.a());
    }

    public final synchronized void zzc(String str, String str2, @Nullable String str3) {
        if (isDestroyed()) {
            kk.e("#004 The webview is destroyed. Ignoring action.");
        } else {
            String a;
            if (((Boolean) akc.f().a(amn.aB)).booleanValue()) {
                a = om.a(str2, om.a());
            } else {
                a = str2;
            }
            super.loadDataWithBaseURL(str, a, "text/html", "UTF-8", str3);
        }
    }

    public final synchronized void zzcl() {
        this.u = true;
        if (this.d != null) {
            this.d.zzcl();
        }
    }

    public final synchronized void zzcm() {
        this.u = false;
        if (this.d != null) {
            this.d.zzcm();
        }
    }

    public final synchronized void zzdr(String str) {
        if (str == null) {
            str = "";
        }
        this.v = str;
    }

    public final void zzno() {
        if (this.C == null) {
            amt.a(this.F.a(), this.D, "aes2");
            this.C = amt.a(this.F.a());
            this.F.a("native:view_show", this.C);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.c.a);
        zza("onshow", hashMap);
    }

    public final void zznp() {
        c zzub = zzub();
        if (zzub != null) {
            zzub.f();
        }
    }

    public final synchronized String zzol() {
        return this.v;
    }

    public final ml zztl() {
        return null;
    }

    public final synchronized oe zztm() {
        return this.w;
    }

    public final amy zztn() {
        return this.D;
    }

    public final Activity zzto() {
        return this.a.a();
    }

    public final amz zztp() {
        return this.F;
    }

    public final zzang zztq() {
        return this.c;
    }

    public final int zztr() {
        return getMeasuredHeight();
    }

    public final int zzts() {
        return getMeasuredWidth();
    }

    public final void zzty() {
        d();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.c.a);
        zza("onhide", hashMap);
    }

    public final void zztz() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(au.D().b()));
        hashMap.put("app_volume", String.valueOf(au.D().a()));
        hashMap.put("device_volume", String.valueOf(il.a(getContext())));
        zza("volume", hashMap);
    }

    public final synchronized void zzu(boolean z) {
        if (this.k != null) {
            this.k.a(this.j.zzfz(), z);
        } else {
            this.n = z;
        }
    }

    public final Context zzua() {
        return this.a.b();
    }

    public final synchronized c zzub() {
        return this.k;
    }

    public final synchronized c zzuc() {
        return this.H;
    }

    public final synchronized op zzud() {
        return this.l;
    }

    public final synchronized String zzue() {
        return this.m;
    }

    public final /* synthetic */ zzasc zzuf() {
        return this.j;
    }

    public final WebViewClient zzug() {
        return this.j;
    }

    public final synchronized boolean zzuh() {
        return this.n;
    }

    public final ada zzui() {
        return this.b;
    }

    public final synchronized boolean zzuj() {
        return this.p;
    }

    public final synchronized void zzuk() {
        hl.a("Destroying WebView!");
        h();
        ht.a.post(new od(this));
    }

    public final synchronized boolean zzul() {
        return this.t;
    }

    public final synchronized boolean zzum() {
        return this.u;
    }

    public final synchronized boolean zzun() {
        return this.A > 0;
    }

    public final void zzuo() {
        this.J.a();
    }

    public final void zzup() {
        if (this.E == null) {
            this.E = amt.a(this.F.a());
            this.F.a("native:view_load", this.E);
        }
    }

    public final synchronized zzox zzuq() {
        return this.z;
    }

    public final void zzur() {
        setBackgroundColor(0);
    }

    public final void zzus() {
        hl.a("Cannot add text view to inner AdWebView");
    }
}
