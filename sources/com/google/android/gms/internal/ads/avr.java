package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.a;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.o;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzadh
public final class avr<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends auy {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> a;
    private final NETWORK_EXTRAS b;

    public avr(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.a = mediationAdapter;
        this.b = network_extras;
    }

    private final SERVER_PARAMETERS a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                kk.b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.a(hashMap);
        return mediationServerParameters;
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
            this.a.destroy();
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final zzlo getVideoController() {
        return null;
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
        return true;
    }

    public final void pause() {
        throw new RemoteException();
    }

    public final void resume() {
        throw new RemoteException();
    }

    public final void setImmersiveMode(boolean z) {
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
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaic zzaic, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzaic zzaic, String str2) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzxt zzxt) {
        zza(iObjectWrapper, zzjj, str, null, zzxt);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt) {
        if (this.a instanceof MediationInterstitialAdapter) {
            kk.b("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.a).requestInterstitialAd(new avs(zzxt), (Activity) c.a(iObjectWrapper), a(str, zzjj.g, str2), awe.a(zzjj, a(zzjj)), this.b);
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
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, zzxt zzxt) {
        zza(iObjectWrapper, zzjn, zzjj, str, null, zzxt);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, String str2, zzxt zzxt) {
        int i = 0;
        if (this.a instanceof MediationBannerAdapter) {
            kk.b("Requesting banner ad from adapter.");
            try {
                a aVar;
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.a;
                MediationBannerListener avs = new avs(zzxt);
                Activity activity = (Activity) c.a(iObjectWrapper);
                MediationServerParameters a = a(str, zzjj.g, str2);
                a[] aVarArr = new a[]{a.a, a.b, a.c, a.d, a.e, a.f};
                while (i < 6) {
                    if (aVarArr[i].a() == zzjn.e && aVarArr[i].b() == zzjn.b) {
                        aVar = aVarArr[i];
                        break;
                    }
                    i++;
                }
                aVar = new a(o.a(zzjn.e, zzjn.b, zzjn.a));
                mediationBannerAdapter.requestBannerAd(avs, activity, a, aVar, awe.a(zzjj, a(zzjj)), this.b);
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
    }

    public final void zzc(zzjj zzjj, String str) {
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    public final zzxz zzmo() {
        return null;
    }

    public final zzyc zzmp() {
        return null;
    }

    public final Bundle zzmq() {
        return new Bundle();
    }

    public final Bundle zzmr() {
        return new Bundle();
    }

    public final boolean zzms() {
        return false;
    }

    public final zzqs zzmt() {
        return null;
    }

    public final zzyf zzmu() {
        return null;
    }
}
