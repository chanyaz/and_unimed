package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzxq extends IInterface {
    void destroy();

    Bundle getInterstitialAdapterInfo();

    zzlo getVideoController();

    IObjectWrapper getView();

    boolean isInitialized();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void showInterstitial();

    void showVideo();

    void zza(IObjectWrapper iObjectWrapper, zzaic zzaic, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzaic zzaic, String str2);

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzxt zzxt);

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt);

    void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt, zzpl zzpl, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, zzxt zzxt);

    void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, String str2, zzxt zzxt);

    void zza(zzjj zzjj, String str, String str2);

    void zzc(zzjj zzjj, String str);

    void zzi(IObjectWrapper iObjectWrapper);

    zzxz zzmo();

    zzyc zzmp();

    Bundle zzmq();

    Bundle zzmr();

    boolean zzms();

    zzqs zzmt();

    zzyf zzmu();
}
