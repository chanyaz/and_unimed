package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzagz extends IInterface {
    void destroy();

    String getMediationAdapterClassName();

    boolean isLoaded();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void setUserId(String str);

    void show();

    void zza(zzagx zzagx);

    void zza(zzahe zzahe);

    void zza(zzahk zzahk);

    void zza(zzkx zzkx);

    Bundle zzba();

    void zzd(IObjectWrapper iObjectWrapper);

    void zze(IObjectWrapper iObjectWrapper);

    void zzf(IObjectWrapper iObjectWrapper);
}
