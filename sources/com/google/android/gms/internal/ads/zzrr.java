package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzrr extends IInterface {
    void cancelUnconfirmedClick();

    void destroy();

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    String getMediationAdapterClassName();

    String getPrice();

    double getStarRating();

    String getStore();

    zzlo getVideoController();

    void performClick(Bundle bundle);

    boolean recordImpression(Bundle bundle);

    void reportTouchEvent(Bundle bundle);

    void zza(zzro zzro);

    zzpw zzjz();

    IObjectWrapper zzka();

    IObjectWrapper zzke();

    zzps zzkf();
}
