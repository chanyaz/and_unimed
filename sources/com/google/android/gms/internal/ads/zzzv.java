package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.c;
import android.support.customtabs.d;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.p;

@zzadh
public final class zzzv implements MediationInterstitialAdapter {
    private Activity a;
    private MediationInterstitialListener b;
    private Uri c;

    public final void onDestroy() {
        kk.b("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        kk.b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        kk.b("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = mediationInterstitialListener;
        if (this.b == null) {
            kk.e("Listener not set for mediation. Returning.");
        } else if (context instanceof Activity) {
            int i = (p.c() && ani.a(context)) ? 1 : 0;
            if (i == 0) {
                kk.e("Default browser does not support custom tabs. Bailing out.");
                this.b.onAdFailedToLoad(this, 0);
                return;
            }
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                kk.e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.b.onAdFailedToLoad(this, 0);
                return;
            }
            this.a = (Activity) context;
            this.c = Uri.parse(string);
            this.b.onAdLoaded(this);
        } else {
            kk.e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.b.onAdFailedToLoad(this, 0);
        }
    }

    public final void showInterstitial() {
        c a = new d().a();
        a.a.setData(this.c);
        ht.a.post(new awt(this, new AdOverlayInfoParcel(new zzc(a.a), null, new aws(this), null, new zzang(0, 0, false))));
        au.i().f();
    }
}
