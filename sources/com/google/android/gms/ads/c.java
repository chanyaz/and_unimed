package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.ads.ajk;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.aqb;
import com.google.android.gms.internal.ads.aqc;
import com.google.android.gms.internal.ads.aqd;
import com.google.android.gms.internal.ads.aqf;
import com.google.android.gms.internal.ads.aqg;
import com.google.android.gms.internal.ads.auv;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzkn;
import com.google.android.gms.internal.ads.zzpl;

public class c {
    private final Context a;
    private final zzkn b;

    private c(Context context, zzkn zzkn) {
        this.a = context;
        this.b = zzkn;
    }

    public c(Context context, String str) {
        this((Context) ar.a((Object) context, (Object) "context cannot be null"), akc.b().a(context, str, new auv()));
    }

    public b a() {
        try {
            return new b(this.a, this.b.zzdh());
        } catch (Throwable e) {
            kk.b("Failed to build AdLoader.", e);
            return null;
        }
    }

    public c a(a aVar) {
        try {
            this.b.zzb(new ajk(aVar));
        } catch (Throwable e) {
            kk.c("Failed to set AdListener.", e);
        }
        return this;
    }

    public c a(NativeAdOptions nativeAdOptions) {
        try {
            this.b.zza(new zzpl(nativeAdOptions));
        } catch (Throwable e) {
            kk.c("Failed to specify native ad options", e);
        }
        return this;
    }

    public c a(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        try {
            this.b.zza(new aqb(onAppInstallAdLoadedListener));
        } catch (Throwable e) {
            kk.c("Failed to add app install ad listener", e);
        }
        return this;
    }

    public c a(OnContentAdLoadedListener onContentAdLoadedListener) {
        try {
            this.b.zza(new aqc(onContentAdLoadedListener));
        } catch (Throwable e) {
            kk.c("Failed to add content ad listener", e);
        }
        return this;
    }

    public c a(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        try {
            this.b.zza(new aqg(onUnifiedNativeAdLoadedListener));
        } catch (Throwable e) {
            kk.c("Failed to add google native ad listener", e);
        }
        return this;
    }

    public c a(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
        try {
            this.b.zza(str, new aqf(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new aqd(onCustomClickListener));
        } catch (Throwable e) {
            kk.c("Failed to add custom template ad listener", e);
        }
        return this;
    }
}
