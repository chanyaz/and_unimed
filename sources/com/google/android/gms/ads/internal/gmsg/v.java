package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.HashMap;
import java.util.Map;

final class v implements zzv<zzaqw> {
    v() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        WindowManager windowManager = (WindowManager) zzaqw.getContext().getSystemService("window");
        au.e();
        View view = (View) zzaqw;
        DisplayMetrics a = ht.a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        Map hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzaqw.zza("locationReady", hashMap);
        kk.e("GET LOCATION COMPILED");
    }
}
