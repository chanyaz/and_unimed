package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.d;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.o;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzadh
public final class avm extends auy {
    private final MediationAdapter a;
    private avn b;

    public avm(MediationAdapter mediationAdapter) {
        this.a = mediationAdapter;
    }

    private final Bundle a(String str, zzjj zzjj, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzjj != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzjj.g);
                }
            }
            return bundle;
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    private static boolean a(zzjj zzjj) {
        if (!zzjj.f) {
            akc.a();
            if (!kb.a()) {
                return false;
            }
        }
        return true;
    }

    public final void destroy() {
        try {
            this.a.onDestroy();
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        if (this.a instanceof zzatm) {
            return ((zzatm) this.a).getInterstitialAdapterInfo();
        }
        String str = "Not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
        kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public final zzlo getVideoController() {
        if (!(this.a instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.a).getVideoController();
        } catch (Throwable th) {
            kk.b("", th);
            return null;
        }
    }

    public final IObjectWrapper getView() {
        if (this.a instanceof MediationBannerAdapter) {
            try {
                return c.a(((MediationBannerAdapter) this.a).getBannerView());
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            kk.b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.a).isInitialized();
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void pause() {
        try {
            this.a.onPause();
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void resume() {
        try {
            this.a.onResume();
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) {
        if (this.a instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) this.a).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                kk.b("", th);
                return;
            }
        }
        String str = "Not an OnImmersiveModeUpdatedListener: ";
        String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
        kk.d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public final void showInterstitial() {
        if (this.a instanceof MediationInterstitialAdapter) {
            kk.b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.a).showInterstitial();
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void showVideo() {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            kk.b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.a).showVideo();
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaic zzaic, List<String> list) {
        String str;
        if (this.a instanceof InitializableMediationRewardedVideoAdAdapter) {
            kk.b("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.a;
                List arrayList = new ArrayList();
                for (String str2 : list) {
                    arrayList.add(a(str2, null, null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) c.a(iObjectWrapper), new fv(zzaic), arrayList);
            } catch (Throwable th) {
                kk.c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            str2 = "Not an InitializableMediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzaic zzaic, String str2) {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            kk.b("Initialize rewarded video adapter.");
            try {
                Bundle bundle;
                MediationAdRequest mediationAdRequest;
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.a;
                Bundle a = a(str2, zzjj, null);
                if (zzjj != null) {
                    avl avl = new avl(zzjj.b == -1 ? null : new Date(zzjj.b), zzjj.d, zzjj.e != null ? new HashSet(zzjj.e) : null, zzjj.k, a(zzjj), zzjj.g, zzjj.r);
                    if (zzjj.m != null) {
                        bundle = zzjj.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                        mediationAdRequest = avl;
                    } else {
                        bundle = null;
                        Object mediationAdRequest2 = avl;
                    }
                } else {
                    bundle = null;
                    mediationAdRequest2 = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) c.a(iObjectWrapper), mediationAdRequest2, str, new fv(zzaic), a, bundle);
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzxt zzxt) {
        zza(iObjectWrapper, zzjj, str, null, zzxt);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt) {
        if (this.a instanceof MediationInterstitialAdapter) {
            kk.b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.a;
                mediationInterstitialAdapter.requestInterstitialAd((Context) c.a(iObjectWrapper), new avn(zzxt), a(str, zzjj, str2), new avl(zzjj.b == -1 ? null : new Date(zzjj.b), zzjj.d, zzjj.e != null ? new HashSet(zzjj.e) : null, zzjj.k, a(zzjj), zzjj.g, zzjj.r), zzjj.m != null ? zzjj.m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt, zzpl zzpl, List<String> list) {
        if (this.a instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.a;
                avq avq = new avq(zzjj.b == -1 ? null : new Date(zzjj.b), zzjj.d, zzjj.e != null ? new HashSet(zzjj.e) : null, zzjj.k, a(zzjj), zzjj.g, zzpl, list, zzjj.r);
                Bundle bundle = zzjj.m != null ? zzjj.m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.b = new avn(zzxt);
                mediationNativeAdapter.requestNativeAd((Context) c.a(iObjectWrapper), this.b, a(str, zzjj, str2), avq, bundle);
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, zzxt zzxt) {
        zza(iObjectWrapper, zzjn, zzjj, str, null, zzxt);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, String str2, zzxt zzxt) {
        if (this.a instanceof MediationBannerAdapter) {
            kk.b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.a;
                mediationBannerAdapter.requestBannerAd((Context) c.a(iObjectWrapper), new avn(zzxt), a(str, zzjj, str2), o.a(zzjn.e, zzjn.b, zzjn.a), new avl(zzjj.b == -1 ? null : new Date(zzjj.b), zzjj.d, zzjj.e != null ? new HashSet(zzjj.e) : null, zzjj.k, a(zzjj), zzjj.g, zzjj.r), zzjj.m != null ? zzjj.m.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void zza(zzjj zzjj, String str, String str2) {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            kk.b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.a;
                mediationRewardedVideoAdAdapter.loadAd(new avl(zzjj.b == -1 ? null : new Date(zzjj.b), zzjj.d, zzjj.e != null ? new HashSet(zzjj.e) : null, zzjj.k, a(zzjj), zzjj.g, zzjj.r), a(str, zzjj, str2), zzjj.m != null ? zzjj.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            kk.e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void zzc(zzjj zzjj, String str) {
        zza(zzjj, str, null);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        try {
            ((OnContextChangedListener) this.a).onContextChanged((Context) c.a(iObjectWrapper));
        } catch (Throwable th) {
            kk.c("Failed", th);
        }
    }

    public final zzxz zzmo() {
        b a = this.b.a();
        return a instanceof com.google.android.gms.ads.mediation.c ? new avo((com.google.android.gms.ads.mediation.c) a) : null;
    }

    public final zzyc zzmp() {
        b a = this.b.a();
        return a instanceof d ? new avp((d) a) : null;
    }

    public final Bundle zzmq() {
        if (this.a instanceof zzatl) {
            return ((zzatl) this.a).zzmq();
        }
        String str = "Not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
        kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public final Bundle zzmr() {
        return new Bundle();
    }

    public final boolean zzms() {
        return this.a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzqs zzmt() {
        NativeCustomTemplateAd c = this.b.c();
        return c instanceof aph ? ((aph) c).a() : null;
    }

    public final zzyf zzmu() {
        e b = this.b.b();
        return b != null ? new awg(b) : null;
    }
}
