package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.d;
import java.util.Map;

@zzadh
public final class auv extends auw {
    private static final awm b = new awm();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> a;

    private final <NetworkExtrasT extends com.google.ads.mediation.NetworkExtras, ServerParametersT extends MediationServerParameters> zzxq a(String str) {
        try {
            Class cls = Class.forName(str, false, auv.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new avr(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.a.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new avm((com.google.android.gms.ads.mediation.MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                kk.e(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return b(str);
        }
    }

    private final zzxq b(String str) {
        try {
            kk.b("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new avm(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new avm(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new avm(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                MediationAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new avr(customEventAdapter, (d) this.a.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            kk.c(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    public final void a(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.a = map;
    }

    public final zzxq zzbm(String str) {
        return a(str);
    }

    public final boolean zzbn(String str) {
        boolean z = false;
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, auv.class.getClassLoader()));
        } catch (Throwable th) {
            kk.e(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
            return z;
        }
    }

    public final zzzj zzbq(String str) {
        return awm.a(str);
    }
}
