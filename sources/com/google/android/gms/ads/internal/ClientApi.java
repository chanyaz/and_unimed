package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.ads.internal.overlay.p;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.overlay.u;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.akw;
import com.google.android.gms.internal.ads.aoi;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.eq;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.zzaap;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzagz;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzkn;
import com.google.android.gms.internal.ads.zzks;
import com.google.android.gms.internal.ads.zzlj;
import com.google.android.gms.internal.ads.zzqa;
import com.google.android.gms.internal.ads.zzqf;
import com.google.android.gms.internal.ads.zzxn;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@Keep
@KeepForSdkWithMembers
@DynamiteApi
@RetainForClient
@zzadh
@ParametersAreNonnullByDefault
public class ClientApi extends akw {
    public zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzxn zzxn, int i) {
        Context context = (Context) c.a(iObjectWrapper);
        au.e();
        return new k(context, str, zzxn, new zzang(12451000, i, true, ht.k(context)), br.a(context));
    }

    public zzaap createAdOverlay(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) c.a(iObjectWrapper);
        AdOverlayInfoParcel a = AdOverlayInfoParcel.a(activity.getIntent());
        if (a == null) {
            return new p(activity);
        }
        switch (a.k) {
            case 1:
                return new o(activity);
            case 2:
                return new t(activity);
            case 3:
                return new u(activity);
            case 4:
                return new q(activity, a);
            default:
                return new p(activity);
        }
    }

    public zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, zzxn zzxn, int i) {
        Context context = (Context) c.a(iObjectWrapper);
        au.e();
        return new bt(context, zzjn, str, zzxn, new zzang(12451000, i, true, ht.k(context)), br.a(context));
    }

    public zzaaz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARNING: Missing block: B:3:0x0035, code:
            if (((java.lang.Boolean) com.google.android.gms.internal.ads.akc.f().a(com.google.android.gms.internal.ads.amn.aT)).booleanValue() == false) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:6:0x0049, code:
            if (((java.lang.Boolean) com.google.android.gms.internal.ads.akc.f().a(com.google.android.gms.internal.ads.amn.aU)).booleanValue() != false) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:7:0x004b, code:
            r1 = 1;
     */
    public com.google.android.gms.internal.ads.zzks createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r14, com.google.android.gms.internal.ads.zzjn r15, java.lang.String r16, com.google.android.gms.internal.ads.zzxn r17, int r18) {
        /*
        r13 = this;
        r2 = com.google.android.gms.dynamic.c.a(r14);
        r2 = (android.content.Context) r2;
        com.google.android.gms.internal.ads.amn.a(r2);
        r5 = new com.google.android.gms.internal.ads.zzang;
        r1 = 12451000; // 0xbdfcb8 float:1.7447567E-38 double:6.1516114E-317;
        r3 = 1;
        com.google.android.gms.ads.internal.au.e();
        r4 = com.google.android.gms.internal.ads.ht.k(r2);
        r0 = r18;
        r5.<init>(r1, r0, r3, r4);
        r1 = "reward_mb";
        r3 = r15.a;
        r3 = r1.equals(r3);
        if (r3 != 0) goto L_0x0037;
    L_0x0025:
        r1 = com.google.android.gms.internal.ads.amn.aT;
        r4 = com.google.android.gms.internal.ads.akc.f();
        r1 = r4.a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x004b;
    L_0x0037:
        if (r3 == 0) goto L_0x005c;
    L_0x0039:
        r1 = com.google.android.gms.internal.ads.amn.aU;
        r3 = com.google.android.gms.internal.ads.akc.f();
        r1 = r3.a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x005c;
    L_0x004b:
        r1 = 1;
    L_0x004c:
        if (r1 == 0) goto L_0x005e;
    L_0x004e:
        r1 = new com.google.android.gms.internal.ads.arz;
        r6 = com.google.android.gms.ads.internal.br.a(r2);
        r3 = r16;
        r4 = r17;
        r1.<init>(r2, r3, r4, r5, r6);
    L_0x005b:
        return r1;
    L_0x005c:
        r1 = 0;
        goto L_0x004c;
    L_0x005e:
        r6 = new com.google.android.gms.ads.internal.l;
        r12 = com.google.android.gms.ads.internal.br.a(r2);
        r7 = r2;
        r8 = r15;
        r9 = r16;
        r10 = r17;
        r11 = r5;
        r6.<init>(r7, r8, r9, r10, r11, r12);
        r1 = r6;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzjn, java.lang.String, com.google.android.gms.internal.ads.zzxn, int):com.google.android.gms.internal.ads.zzks");
    }

    public zzqa createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new aoi((FrameLayout) c.a(iObjectWrapper), (FrameLayout) c.a(iObjectWrapper2));
    }

    public zzqf createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new aok((View) c.a(iObjectWrapper), (HashMap) c.a(iObjectWrapper2), (HashMap) c.a(iObjectWrapper3));
    }

    public zzagz createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzxn zzxn, int i) {
        Context context = (Context) c.a(iObjectWrapper);
        au.e();
        return new eq(context, br.a(context), zzxn, new zzang(12451000, i, true, ht.k(context)));
    }

    public zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, int i) {
        Context context = (Context) c.a(iObjectWrapper);
        au.e();
        return new ao(context, zzjn, str, new zzang(12451000, i, true, ht.k(context)));
    }

    @Nullable
    public zzlj getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public zzlj getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) c.a(iObjectWrapper);
        au.e();
        return x.a(context, new zzang(12451000, i, true, ht.k(context)));
    }
}
