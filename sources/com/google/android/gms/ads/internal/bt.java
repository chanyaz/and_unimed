package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.a;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import com.google.android.gms.ads.f;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.agc;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.gi;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.op;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class bt extends bd implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean k;
    private boolean l;
    private WeakReference<Object> m = new WeakReference(null);

    public bt(Context context, zzjn zzjn, String str, zzxn zzxn, zzang zzang, br brVar) {
        super(context, zzjn, str, zzxn, zzang, brVar);
    }

    private final boolean b(@Nullable gr grVar, gr grVar2) {
        if (grVar2.n) {
            View a = r.a(grVar2);
            if (a == null) {
                kk.e("Could not get mediation view");
                return false;
            }
            View nextView = this.e.f.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzaqw) {
                    ((zzaqw) nextView).destroy();
                }
                this.e.f.removeView(nextView);
            }
            if (!r.b(grVar2)) {
                try {
                    if (au.B().b(this.e.c)) {
                        new agc(this.e.c, a).a(new gi(this.e.c, this.e.b));
                    }
                    if (grVar2.u != null) {
                        this.e.f.setMinimumWidth(grVar2.u.f);
                        this.e.f.setMinimumHeight(grVar2.u.c);
                    }
                    a(a);
                } catch (Throwable e) {
                    au.i().a(e, "BannerAdManager.swapViews");
                    kk.c("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (!(grVar2.u == null || grVar2.b == null)) {
            grVar2.b.zza(op.a(grVar2.u));
            this.e.f.removeAllViews();
            this.e.f.setMinimumWidth(grVar2.u.f);
            this.e.f.setMinimumHeight(grVar2.u.c);
            a(grVar2.b.getView());
        }
        if (this.e.f.getChildCount() > 1) {
            this.e.f.showNext();
        }
        if (grVar != null) {
            View nextView2 = this.e.f.getNextView();
            if (nextView2 instanceof zzaqw) {
                ((zzaqw) nextView2).destroy();
            } else if (nextView2 != null) {
                this.e.f.removeView(nextView2);
            }
            this.e.c();
        }
        this.e.f.setVisibility(0);
        return true;
    }

    private final void c(zzaqw zzaqw) {
        if (l()) {
            WebView webView = zzaqw.getWebView();
            if (webView != null) {
                View view = zzaqw.getView();
                if (view != null && au.u().a(this.e.c)) {
                    int i = this.e.e.b;
                    this.h = au.u().a(i + "." + this.e.e.c, webView, "", "javascript", i());
                    if (this.h != null) {
                        au.u().a(this.h, view);
                        au.u().a(this.h);
                        this.l = true;
                    }
                }
            }
        }
    }

    protected final zzaqw a(gs gsVar, @Nullable bs bsVar, @Nullable zzait zzait) {
        if (this.e.i.g == null && this.e.i.i) {
            zzjn zzjn;
            av avVar = this.e;
            if (gsVar.b.y) {
                zzjn = this.e.i;
            } else {
                f fVar;
                String str = gsVar.b.l;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    fVar = new f(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    fVar = this.e.i.b();
                }
                zzjn = new zzjn(this.e.c, fVar);
            }
            avVar.i = zzjn;
        }
        return super.a(gsVar, bsVar, zzait);
    }

    protected final void a(@Nullable gr grVar, boolean z) {
        zzyc zzyc = null;
        if (l()) {
            zzaqw zzaqw = grVar != null ? grVar.b : null;
            if (zzaqw != null) {
                if (!this.l) {
                    c(zzaqw);
                }
                if (this.h != null) {
                    zzaqw.zza("onSdkImpression", new a());
                }
            }
        }
        super.a(grVar, z);
        if (r.b(grVar)) {
            d dVar = new d(this);
            if (grVar != null && r.b(grVar)) {
                zzaqw zzaqw2 = grVar.b;
                Object view = zzaqw2 != null ? zzaqw2.getView() : null;
                if (view == null) {
                    kk.e("AdWebView is null");
                    return;
                }
                try {
                    List list = grVar.o != null ? grVar.o.r : null;
                    if (list == null || list.isEmpty()) {
                        kk.e("No template ids present in mediation response");
                        return;
                    }
                    zzxz zzmo = grVar.p != null ? grVar.p.zzmo() : null;
                    if (grVar.p != null) {
                        zzyc = grVar.p.zzmp();
                    }
                    if (list.contains("2") && zzmo != null) {
                        zzmo.zzk(c.a(view));
                        if (!zzmo.getOverrideImpressionRecording()) {
                            zzmo.recordImpression();
                        }
                        zzaqw2.zza("/nativeExpressViewClicked", r.a(zzmo, null, dVar));
                    } else if (!list.contains("1") || zzyc == null) {
                        kk.e("No matching template id and mapper");
                    } else {
                        zzyc.zzk(c.a(view));
                        if (!zzyc.getOverrideImpressionRecording()) {
                            zzyc.recordImpression();
                        }
                        zzaqw2.zza("/nativeExpressViewClicked", r.a(null, zzyc, dVar));
                    }
                } catch (Throwable e) {
                    kk.c("Error occurred while recording impression and registering for clicks", e);
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:56:0x0117, code:
            if (((java.lang.Boolean) com.google.android.gms.internal.ads.akc.f().a(com.google.android.gms.internal.ads.amn.bW)).booleanValue() != false) goto L_0x0119;
     */
    public final boolean a(@android.support.annotation.Nullable com.google.android.gms.internal.ads.gr r6, com.google.android.gms.internal.ads.gr r7) {
        /*
        r5 = this;
        r1 = 0;
        r2 = 0;
        r0 = super.a(r6, r7);
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = r2;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r5.e;
        r0 = r0.d();
        if (r0 == 0) goto L_0x0028;
    L_0x0012:
        r0 = r5.b(r6, r7);
        if (r0 != 0) goto L_0x0028;
    L_0x0018:
        r0 = r7.K;
        if (r0 == 0) goto L_0x0023;
    L_0x001c:
        r0 = r7.K;
        r1 = com.google.android.gms.internal.ads.zzhu.zza.zzb.AD_FAILED_TO_LOAD;
        r0.a(r1);
    L_0x0023:
        r5.a(r2);
        r0 = r2;
        goto L_0x0009;
    L_0x0028:
        r5.b(r7, r2);
        r0 = r7.l;
        if (r0 == 0) goto L_0x00ff;
    L_0x002f:
        r5.c(r7);
        com.google.android.gms.ads.internal.au.A();
        r0 = r5.e;
        r0 = r0.f;
        com.google.android.gms.internal.ads.lp.a(r0, r5);
        com.google.android.gms.ads.internal.au.A();
        r0 = r5.e;
        r0 = r0.f;
        com.google.android.gms.internal.ads.lp.a(r0, r5);
        r0 = r7.m;
        if (r0 != 0) goto L_0x0063;
    L_0x004a:
        r2 = new com.google.android.gms.ads.internal.c;
        r2.<init>(r5);
        r0 = r7.b;
        if (r0 == 0) goto L_0x00fc;
    L_0x0053:
        r0 = r7.b;
        r0 = r0.zzuf();
    L_0x0059:
        if (r0 == 0) goto L_0x0063;
    L_0x005b:
        r3 = new com.google.android.gms.ads.internal.bu;
        r3.<init>(r7, r2);
        r0.zza(r3);
    L_0x0063:
        r0 = r7.b;
        if (r0 == 0) goto L_0x0087;
    L_0x0067:
        r0 = r7.b;
        r0 = r0.zztm();
        r2 = r7.b;
        r2 = r2.zzuf();
        if (r2 == 0) goto L_0x0078;
    L_0x0075:
        r2.zzuz();
    L_0x0078:
        r2 = r5.e;
        r2 = r2.x;
        if (r2 == 0) goto L_0x0087;
    L_0x007e:
        if (r0 == 0) goto L_0x0087;
    L_0x0080:
        r2 = r5.e;
        r2 = r2.x;
        r0.a(r2);
    L_0x0087:
        r0 = com.google.android.gms.common.util.p.b();
        if (r0 == 0) goto L_0x00f9;
    L_0x008d:
        r0 = r5.e;
        r0 = r0.d();
        if (r0 == 0) goto L_0x012d;
    L_0x0095:
        r0 = r7.b;
        if (r0 == 0) goto L_0x0149;
    L_0x0099:
        r0 = r7.k;
        if (r0 == 0) goto L_0x00a6;
    L_0x009d:
        r0 = r5.g;
        r1 = r5.e;
        r1 = r1.i;
        r0.a(r1, r7);
    L_0x00a6:
        r0 = r7.b;
        r0 = r0.getView();
        r1 = new com.google.android.gms.internal.ads.agc;
        r2 = r5.e;
        r2 = r2.c;
        r1.<init>(r2, r0);
        r2 = com.google.android.gms.ads.internal.au.B();
        r3 = r5.e;
        r3 = r3.c;
        r2 = r2.b(r3);
        if (r2 == 0) goto L_0x00e5;
    L_0x00c3:
        r2 = r7.a;
        r2 = com.google.android.gms.ads.internal.a.a(r2);
        if (r2 == 0) goto L_0x00e5;
    L_0x00cb:
        r2 = r5.e;
        r2 = r2.b;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x00e5;
    L_0x00d5:
        r2 = new com.google.android.gms.internal.ads.gi;
        r3 = r5.e;
        r3 = r3.c;
        r4 = r5.e;
        r4 = r4.b;
        r2.<init>(r3, r4);
        r1.a(r2);
    L_0x00e5:
        r2 = r7.a();
        if (r2 == 0) goto L_0x011e;
    L_0x00eb:
        r2 = r7.b;
        r1.a(r2);
    L_0x00f0:
        r1 = r7.n;
        if (r1 != 0) goto L_0x00f9;
    L_0x00f4:
        r1 = r5.e;
        r1.a(r0);
    L_0x00f9:
        r0 = 1;
        goto L_0x0009;
    L_0x00fc:
        r0 = r1;
        goto L_0x0059;
    L_0x00ff:
        r0 = r5.e;
        r0 = r0.e();
        if (r0 == 0) goto L_0x0119;
    L_0x0107:
        r0 = com.google.android.gms.internal.ads.amn.bW;
        r3 = com.google.android.gms.internal.ads.akc.f();
        r0 = r3.a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0063;
    L_0x0119:
        r5.a(r7, r2);
        goto L_0x0063;
    L_0x011e:
        r2 = r7.b;
        r2 = r2.zzuf();
        r3 = new com.google.android.gms.ads.internal.b;
        r3.<init>(r1, r7);
        r2.zza(r3);
        goto L_0x00f0;
    L_0x012d:
        r0 = r5.e;
        r0 = r0.H;
        if (r0 == 0) goto L_0x0149;
    L_0x0133:
        r0 = r7.k;
        if (r0 == 0) goto L_0x0149;
    L_0x0137:
        r0 = r5.g;
        r1 = r5.e;
        r1 = r1.i;
        r2 = r5.e;
        r2 = r2.H;
        r0.a(r1, r7, r2);
        r0 = r5.e;
        r0 = r0.H;
        goto L_0x00f0;
    L_0x0149:
        r0 = r1;
        goto L_0x00f0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bt.a(com.google.android.gms.internal.ads.gr, com.google.android.gms.internal.ads.gr):boolean");
    }

    @VisibleForTesting
    final void c(@Nullable gr grVar) {
        if (grVar != null && !grVar.m && this.e.f != null && au.e().a(this.e.f, this.e.c) && this.e.f.getGlobalVisibleRect(new Rect(), null)) {
            if (!(grVar == null || grVar.b == null || grVar.b.zzuf() == null)) {
                grVar.b.zzuf().zza(null);
            }
            a(grVar, false);
            grVar.m = true;
        }
    }

    protected final void e() {
        zzaqw zzaqw = this.e.j != null ? this.e.j.b : null;
        if (!(this.l || zzaqw == null)) {
            c(zzaqw);
        }
        super.e();
    }

    @Nullable
    public final zzlo getVideoController() {
        ar.b("getVideoController must be called from the main thread.");
        return (this.e.j == null || this.e.j.b == null) ? null : this.e.j.b.zztm();
    }

    public final void onGlobalLayout() {
        c(this.e.j);
    }

    public final void onScrollChanged() {
        c(this.e.j);
    }

    protected final boolean r() {
        boolean z = true;
        au.e();
        if (!ht.a(this.e.c, "android.permission.INTERNET")) {
            akc.a().a(this.e.f, this.e.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        au.e();
        if (!ht.a(this.e.c)) {
            akc.a().a(this.e.f, this.e.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.e.f == null)) {
            this.e.f.setVisibility(0);
        }
        return z;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        ar.b("setManualImpressionsEnabled must be called from the main thread.");
        this.k = z;
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public final boolean zzb(zzjj zzjj) {
        if (zzjj.h != this.k) {
            int i = zzjj.a;
            long j = zzjj.b;
            Bundle bundle = zzjj.c;
            int i2 = zzjj.d;
            List list = zzjj.e;
            boolean z = zzjj.f;
            int i3 = zzjj.g;
            boolean z2 = zzjj.h || this.k;
            zzjj = new zzjj(i, j, bundle, i2, list, z, i3, z2, zzjj.i, zzjj.j, zzjj.k, zzjj.l, zzjj.m, zzjj.n, zzjj.o, zzjj.p, zzjj.q, zzjj.r);
        }
        return super.zzb(zzjj);
    }

    public final void zzcz() {
        this.d.d();
    }
}
