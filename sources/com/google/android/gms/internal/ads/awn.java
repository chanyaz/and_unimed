package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.o;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.mopub.common.AdType;
import java.util.Iterator;
import org.json.JSONObject;

public final class awn extends awj {
    private final ph a;

    public awn(ph phVar) {
        this.a = phVar;
    }

    private static Bundle a(String str) {
        String str2 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        kk.e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                valueOf = (String) keys.next();
                bundle2.putString(valueOf, jSONObject.getString(valueOf));
            }
            return bundle2;
        } catch (Throwable e) {
            kk.b("", e);
            throw new RemoteException();
        }
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

    public final void showInterstitial() {
        zzate zzate = null;
        try {
            zzate.zzoy();
        } catch (Throwable th) {
            kk.b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, zzzm zzzm) {
        try {
            int i;
            Object awq = new awq(this, zzzm);
            ph phVar = this.a;
            Context context = (Context) c.a(iObjectWrapper);
            Object obj = -1;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals(AdType.INTERSTITIAL)) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    i = pi.a;
                    break;
                case 1:
                    i = pi.b;
                    break;
                case 2:
                    i = pi.c;
                    break;
                case 3:
                    i = pi.d;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            phVar.a(new pj(context, i, bundle), awq);
        } catch (Throwable th) {
            kk.b("Error generating signals for RTB", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzf zzzf, zzxt zzxt, zzjn zzjn) {
        try {
            zzatd awo = new awo(this, zzzf, zzxt);
            ph phVar = this.a;
            pg pgVar = new pg((Context) c.a(iObjectWrapper), bArr, a(str), bundle);
            o.a(zzjn.e, zzjn.b, zzjn.a);
            awo.zzau(String.valueOf(phVar.getClass().getSimpleName()).concat(" does not support banner."));
        } catch (Throwable th) {
            kk.b("Adapter failed to render banner ad.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzh zzzh, zzxt zzxt) {
        try {
            zzatd awp = new awp(this, zzzh, zzxt);
            ph phVar = this.a;
            pg pgVar = new pg((Context) c.a(iObjectWrapper), bArr, a(str), bundle);
            awp.zzau(String.valueOf(phVar.getClass().getSimpleName()).concat(" does not support interstitial."));
        } catch (Throwable th) {
            kk.b("Adapter failed to render interstitial ad.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final zzzt zznc() {
        return zzzt.a(this.a.b());
    }

    public final zzzt zznd() {
        return zzzt.a(this.a.a());
    }
}
