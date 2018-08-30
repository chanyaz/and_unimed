package com.google.android.gms.internal.ads;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzqs extends IInterface {
    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomTemplateId();

    zzlo getVideoController();

    void performClick(String str);

    void recordImpression();

    String zzao(String str);

    zzpw zzap(String str);

    boolean zzh(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzka();

    IObjectWrapper zzkh();
}
