package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzks extends IInterface {
    void destroy();

    String getAdUnitId();

    String getMediationAdapterClassName();

    zzlo getVideoController();

    boolean isLoading();

    boolean isReady();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void setManualImpressionsEnabled(boolean z);

    void setUserId(String str);

    void showInterstitial();

    void stopLoading();

    void zza(zzaaw zzaaw);

    void zza(zzabc zzabc, String str);

    void zza(zzahe zzahe);

    void zza(zzjn zzjn);

    void zza(zzke zzke);

    void zza(zzkh zzkh);

    void zza(zzkx zzkx);

    void zza(zzla zzla);

    void zza(zzlg zzlg);

    void zza(zzlu zzlu);

    void zza(zzmu zzmu);

    void zza(zzod zzod);

    boolean zzb(zzjj zzjj);

    Bundle zzba();

    IObjectWrapper zzbj();

    zzjn zzbk();

    void zzbm();

    zzla zzbw();

    zzkh zzbx();

    String zzck();
}
