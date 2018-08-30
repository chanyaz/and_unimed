package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.ads.h;
import com.google.android.gms.ads.k;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.a;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzatm;
import com.google.android.gms.internal.ads.zzlo;
import java.util.Date;
import java.util.Set;

@zzadh
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzatm {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzgw;
    private h zzgx;
    private b zzgy;
    private Context zzgz;
    private h zzha;
    private MediationRewardedVideoAdListener zzhb;
    @VisibleForTesting
    private final RewardedVideoAdListener zzhc = new h(this);

    private final d zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        e eVar = new e();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            eVar.a(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            eVar.a(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String a : keywords) {
                eVar.a(a);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            eVar.a(location);
        }
        if (mediationAdRequest.isTesting()) {
            akc.a();
            eVar.b(kb.a(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            eVar.a(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        eVar.b(mediationAdRequest.isDesignedForFamilies());
        eVar.a(AdMobAdapter.class, zza(bundle, bundle2));
        return eVar.a();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzgw;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new a().a(1).a();
    }

    public zzlo getVideoController() {
        if (this.zzgw != null) {
            k videoController = this.zzgw.getVideoController();
            if (videoController != null) {
                return videoController.a();
            }
        }
        return null;
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzgz = context.getApplicationContext();
        this.zzhb = mediationRewardedVideoAdListener;
        this.zzhb.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzhb != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzgz == null || this.zzhb == null) {
            kk.c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzha = new h(this.zzgz);
        this.zzha.a(true);
        this.zzha.a(getAdUnitId(bundle));
        this.zzha.a(this.zzhc);
        this.zzha.a(new i(this));
        this.zzha.a(zza(this.zzgz, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzgw != null) {
            this.zzgw.c();
            this.zzgw = null;
        }
        if (this.zzgx != null) {
            this.zzgx = null;
        }
        if (this.zzgy != null) {
            this.zzgy = null;
        }
        if (this.zzha != null) {
            this.zzha = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgx != null) {
            this.zzgx.b(z);
        }
        if (this.zzha != null) {
            this.zzha.b(z);
        }
    }

    public void onPause() {
        if (this.zzgw != null) {
            this.zzgw.b();
        }
    }

    public void onResume() {
        if (this.zzgw != null) {
            this.zzgw.a();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, f fVar, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgw = new AdView(context);
        this.zzgw.setAdSize(new f(fVar.b(), fVar.a()));
        this.zzgw.setAdUnitId(getAdUnitId(bundle));
        this.zzgw.setAdListener(new d(this, mediationBannerListener));
        this.zzgw.a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgx = new h(context);
        this.zzgx.a(getAdUnitId(bundle));
        this.zzgx.a(new e(this, mediationInterstitialListener));
        this.zzgx.a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener fVar = new f(this, mediationNativeListener);
        c a = new c(context, bundle.getString(AD_UNIT_ID_PARAMETER)).a((com.google.android.gms.ads.a) fVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            a.a(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            a.a((OnUnifiedNativeAdLoadedListener) fVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            a.a((OnAppInstallAdLoadedListener) fVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            a.a(fVar);
        }
        if (nativeMediationAdRequest.zzna()) {
            for (String str : nativeMediationAdRequest.zznb().keySet()) {
                a.a(str, fVar, ((Boolean) nativeMediationAdRequest.zznb().get(str)).booleanValue() ? fVar : null);
            }
        }
        this.zzgy = a.a();
        this.zzgy.a(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzgx.b();
    }

    public void showVideo() {
        this.zzha.b();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
