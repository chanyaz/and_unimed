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
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
@VisibleForTesting
final class ox extends pc implements OnGlobalLayoutListener, DownloadListener, zzaqw, zzuo {
    private WeakReference<OnClickListener> A;
    @GuardedBy("this")
    private c B;
    private ka C;
    private int D = -1;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private float H;
    private Map<String, nd> I;
    private final WindowManager J;
    @Nullable
    private final ada b;
    private final zzang c;
    private final zzbo d;
    private final br e;
    private oq f;
    @GuardedBy("this")
    private c g;
    @GuardedBy("this")
    private op h;
    @GuardedBy("this")
    private String i;
    @GuardedBy("this")
    private boolean j;
    @GuardedBy("this")
    private boolean k;
    @GuardedBy("this")
    private boolean l;
    @GuardedBy("this")
    private int m;
    @GuardedBy("this")
    private boolean n = true;
    @GuardedBy("this")
    private boolean o = false;
    @GuardedBy("this")
    private String p = "";
    @GuardedBy("this")
    private oe q;
    @GuardedBy("this")
    private boolean r;
    @GuardedBy("this")
    private boolean s;
    @GuardedBy("this")
    private zzox t;
    @GuardedBy("this")
    private int u;
    @GuardedBy("this")
    private int v;
    private amy w;
    private amy x;
    private amy y;
    private amz z;

    @VisibleForTesting
    private ox(oo ooVar, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        super(ooVar);
        this.h = opVar;
        this.i = str;
        this.k = z;
        this.m = -1;
        this.b = ada;
        this.c = zzang;
        this.d = zzbo;
        this.e = brVar;
        this.J = (WindowManager) getContext().getSystemService("window");
        this.C = new ka(a().a(), this, this, null);
        au.e().a((Context) ooVar, zzang.a, getSettings());
        setDownloadListener(this);
        this.H = a().getResources().getDisplayMetrics().density;
        e();
        if (p.e()) {
            addJavascriptInterface(oh.a(this), "googleAdsJsInterface");
        }
        i();
        this.z = new amz(new ana(true, "make_wv", this.i));
        this.z.a().a(ana);
        this.x = amt.a(this.z.a());
        this.z.a("native:view_create", this.x);
        this.y = null;
        this.w = null;
        au.g().b((Context) ooVar);
    }

    static ox a(Context context, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        return new ox(new oo(context), opVar, str, z, z2, ada, zzang, ana, zzbo, brVar, ahx);
    }

    private final void b(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        asl.a((zzuo) this, "onAdVisibilityChanged", hashMap);
    }

    private final boolean c() {
        if (!this.f.zzfz() && !this.f.a()) {
            return false;
        }
        int i;
        int i2;
        au.e();
        DisplayMetrics a = ht.a(this.J);
        akc.a();
        int b = kb.b(a, a.widthPixels);
        akc.a();
        int b2 = kb.b(a, a.heightPixels);
        Activity a2 = a().a();
        if (a2 == null || a2.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            au.e();
            int[] a3 = ht.a(a2);
            akc.a();
            i2 = kb.b(a, a3[0]);
            akc.a();
            i = kb.b(a, a3[1]);
        }
        if (this.E == b && this.D == b2 && this.F == i2 && this.G == i) {
            return false;
        }
        boolean z = (this.E == b && this.D == b2) ? false : true;
        this.E = b;
        this.D = b2;
        this.F = i2;
        this.G = i;
        new l(this).a(b, b2, i2, i, a.density, this.J.getDefaultDisplay().getRotation());
        return z;
    }

    private final void d() {
        amt.a(this.z.a(), this.x, "aeh2");
    }

    private final synchronized void e() {
        if (this.k || this.h.d()) {
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
        if (!this.l) {
            au.g().c((View) this);
        }
        this.l = true;
    }

    private final synchronized void g() {
        if (this.l) {
            au.g().b((View) this);
        }
        this.l = false;
    }

    private final synchronized void h() {
        this.I = null;
    }

    private final void i() {
        if (this.z != null) {
            ana a = this.z.a();
            if (a != null && au.i().b() != null) {
                au.i().b().a(a);
            }
        }
    }

    public final void a(oq oqVar) {
        this.f = oqVar;
    }

    protected final synchronized void a(boolean z) {
        if (!z) {
            i();
            this.C.b();
            if (this.g != null) {
                this.g.a();
                this.g.onDestroy();
                this.g = null;
            }
        }
        this.f.d();
        au.z();
        nc.a((zzapw) this);
        h();
    }

    public final OnClickListener getOnClickListener() {
        return (OnClickListener) this.A.get();
    }

    public final synchronized int getRequestedOrientation() {
        return this.m;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    protected final synchronized void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.C.c();
        }
        boolean z2 = this.r;
        if (this.f == null || !this.f.a()) {
            z = z2;
        } else {
            if (!this.s) {
                OnGlobalLayoutListener b = this.f.b();
                if (b != null) {
                    au.A();
                    if (this == null) {
                        throw null;
                    }
                    lp.a((View) this, b);
                }
                OnScrollChangedListener c = this.f.c();
                if (c != null) {
                    au.A();
                    if (this == null) {
                        throw null;
                    }
                    lp.a((View) this, c);
                }
                this.s = true;
            }
            c();
            z = true;
        }
        b(z);
    }

    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.C.d();
            }
            super.onDetachedFromWindow();
            if (this.s && this.f != null && this.f.a() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener b = this.f.b();
                if (b != null) {
                    au.g().a(getViewTreeObserver(), b);
                }
                OnScrollChangedListener c = this.f.c();
                if (c != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(c);
                }
                this.s = false;
            }
        }
        b(false);
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
        if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
            if (this.f != null && this.f.e() != null) {
                this.f.e().zzda();
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
        boolean c = c();
        c zzub = zzub();
        if (zzub != null && c) {
            zzub.e();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
        } else if (isInEditMode() || this.k || this.h.e()) {
            super.onMeasure(i, i2);
        } else if (this.h.f()) {
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
        } else if (this.h.c()) {
            if (((Boolean) akc.f().a(amn.cm)).booleanValue() || !p.e()) {
                super.onMeasure(i, i2);
            } else {
                zza("/contentHeight", new oy(this));
                zzbe("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                i3 = MeasureSpec.getSize(i);
                switch (this.v) {
                    case -1:
                        i4 = MeasureSpec.getSize(i2);
                        break;
                    default:
                        i4 = (int) (((float) this.v) * this.H);
                        break;
                }
                setMeasuredDimension(i3, i4);
            }
        } else if (this.h.d()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.J.getDefaultDisplay().getMetrics(displayMetrics);
            setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            Object obj;
            i3 = MeasureSpec.getMode(i);
            int size3 = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i2);
            int size4 = MeasureSpec.getSize(i2);
            int i5 = (i3 == Integer.MIN_VALUE || i3 == 1073741824) ? size3 : MoPubClientPositioning.NO_REPEAT;
            mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : MoPubClientPositioning.NO_REPEAT;
            Object obj2 = (this.h.b > i5 || this.h.a > mode) ? 1 : null;
            if (((Boolean) akc.f().a(amn.dh)).booleanValue()) {
                obj = (((float) this.h.b) / this.H > ((float) i5) / this.H || ((float) this.h.a) / this.H > ((float) mode) / this.H) ? null : 1;
                if (obj2 == null) {
                    obj = obj2;
                }
            } else {
                obj = obj2;
            }
            if (obj != null) {
                kk.e("Not enough space to show ad. Needs " + ((int) (((float) this.h.b) / this.H)) + "x" + ((int) (((float) this.h.a) / this.H)) + " dp, but only has " + ((int) (((float) size3) / this.H)) + "x" + ((int) (((float) size4) / this.H)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.h.b, this.h.a);
            }
        }
    }

    public final void onPause() {
        try {
            if (p.a()) {
                super.onPause();
            }
        } catch (Throwable e) {
            kk.b("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            if (p.a()) {
                super.onResume();
            }
        } catch (Throwable e) {
            kk.b("Could not resume webview.", e);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f.a()) {
            synchronized (this) {
                if (this.t != null) {
                    this.t.zzc(motionEvent);
                }
            }
        } else if (this.b != null) {
            this.b.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.A = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.m = i;
        if (this.g != null) {
            this.g.a(this.m);
        }
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable e) {
            kk.b("Could not stop loading webview.", e);
        }
    }

    public final synchronized void zza(c cVar) {
        this.g = cVar;
    }

    public final void zza(zzc zzc) {
        this.f.a(zzc);
    }

    public final void zza(agf agf) {
        synchronized (this) {
            this.r = agf.a;
        }
        b(agf.a);
    }

    public final synchronized void zza(oe oeVar) {
        if (this.q != null) {
            kk.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.q = oeVar;
        }
    }

    public final synchronized void zza(op opVar) {
        this.h = opVar;
        requestLayout();
    }

    public final void zza(String str, zzv<? super zzaqw> zzv) {
        if (this.f != null) {
            this.f.zza(str, zzv);
        }
    }

    public final void zza(String str, Predicate<zzv<? super zzaqw>> predicate) {
        if (this.f != null) {
            this.f.a(str, (Predicate) predicate);
        }
    }

    public final void zza(String str, Map map) {
        asl.a((zzuo) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        asl.b(this, str, jSONObject);
    }

    public final void zza(boolean z, int i) {
        this.f.a(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.f.a(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.f.a(z, i, str, str2);
    }

    public final void zzah(boolean z) {
        this.f.a(z);
    }

    public final void zzai(int i) {
        if (i == 0) {
            amt.a(this.z.a(), this.x, "aebb2");
        }
        d();
        if (this.z.a() != null) {
            this.z.a().a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.c.a);
        asl.a((zzuo) this, "onhide", hashMap);
    }

    public final synchronized void zzai(boolean z) {
        Object obj = z != this.k ? 1 : null;
        this.k = z;
        e();
        if (obj != null) {
            new l(this).c(z ? "expanded" : RewardedVideo.VIDEO_MODE_DEFAULT);
        }
    }

    public final synchronized void zzaj(boolean z) {
        this.n = z;
    }

    public final synchronized void zzak(boolean z) {
        this.u = (z ? 1 : -1) + this.u;
        if (this.u <= 0 && this.g != null) {
            this.g.g();
        }
    }

    public final synchronized void zzb(c cVar) {
        this.B = cVar;
    }

    public final synchronized void zzb(zzox zzox) {
        this.t = zzox;
    }

    public final void zzb(String str, zzv<? super zzaqw> zzv) {
        if (this.f != null) {
            this.f.zzb(str, zzv);
        }
    }

    public final void zzb(String str, JSONObject jSONObject) {
        asl.a((zzuo) this, str, jSONObject);
    }

    public final synchronized void zzbe(String str) {
        if (isDestroyed()) {
            kk.e("The webview is destroyed. Ignoring action.");
        } else {
            super.zzbe(str);
        }
    }

    public final br zzbi() {
        return this.e;
    }

    public final void zzbm(Context context) {
        a().setBaseContext(context);
        this.C.a(a().a());
    }

    public final synchronized void zzc(String str, String str2, @Nullable String str3) {
        String a;
        if (((Boolean) akc.f().a(amn.aB)).booleanValue()) {
            a = om.a(str2, om.a());
        } else {
            a = str2;
        }
        super.loadDataWithBaseURL(str, a, "text/html", "UTF-8", str3);
    }

    public final synchronized void zzcl() {
        this.o = true;
        if (this.d != null) {
            this.d.zzcl();
        }
    }

    public final synchronized void zzcm() {
        this.o = false;
        if (this.d != null) {
            this.d.zzcm();
        }
    }

    public final synchronized void zzdr(String str) {
        if (str == null) {
            str = "";
        }
        this.p = str;
    }

    public final void zzf(String str, String str2) {
        asl.a((zzuo) this, str, str2);
    }

    public final void zzno() {
        if (this.w == null) {
            amt.a(this.z.a(), this.x, "aes2");
            this.w = amt.a(this.z.a());
            this.z.a("native:view_show", this.w);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.c.a);
        asl.a((zzuo) this, "onshow", hashMap);
    }

    public final void zznp() {
        c zzub = zzub();
        if (zzub != null) {
            zzub.f();
        }
    }

    public final synchronized String zzol() {
        return this.p;
    }

    public final ml zztl() {
        return null;
    }

    public final synchronized oe zztm() {
        return this.q;
    }

    public final amy zztn() {
        return this.x;
    }

    public final Activity zzto() {
        return a().a();
    }

    public final amz zztp() {
        return this.z;
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
        asl.a((zzuo) this, "onhide", hashMap);
    }

    public final void zztz() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(au.D().b()));
        hashMap.put("app_volume", String.valueOf(au.D().a()));
        hashMap.put("device_volume", String.valueOf(il.a(getContext())));
        asl.a((zzuo) this, "volume", hashMap);
    }

    public final synchronized void zzu(boolean z) {
        if (this.g != null) {
            this.g.a(this.f.zzfz(), z);
        } else {
            this.j = z;
        }
    }

    public final Context zzua() {
        return a().b();
    }

    public final synchronized c zzub() {
        return this.g;
    }

    public final synchronized c zzuc() {
        return this.B;
    }

    public final synchronized op zzud() {
        return this.h;
    }

    public final synchronized String zzue() {
        return this.i;
    }

    public final /* synthetic */ zzasc zzuf() {
        return this.f;
    }

    public final WebViewClient zzug() {
        return this.a;
    }

    public final synchronized boolean zzuh() {
        return this.j;
    }

    public final ada zzui() {
        return this.b;
    }

    public final synchronized boolean zzuj() {
        return this.k;
    }

    public final synchronized boolean zzul() {
        return this.n;
    }

    public final synchronized boolean zzum() {
        return this.o;
    }

    public final synchronized boolean zzun() {
        return this.u > 0;
    }

    public final void zzuo() {
        this.C.a();
    }

    public final void zzup() {
        if (this.y == null) {
            this.y = amt.a(this.z.a());
            this.z.a("native:view_load", this.y);
        }
    }

    public final synchronized zzox zzuq() {
        return this.t;
    }

    public final void zzur() {
        setBackgroundColor(0);
    }

    public final void zzus() {
        hl.a("Cannot add text view to inner AdWebView");
    }
}
