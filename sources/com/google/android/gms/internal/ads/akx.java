package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class akx extends afa implements zzld {
    akx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzxn zzxn, int i) {
        zzkn zzkn;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(i);
        Parcel a2 = a(3, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzkn = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzkn = queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new akm(readStrongBinder);
        }
        a2.recycle();
        return zzkn;
    }

    public final zzaap createAdOverlay(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a = a(8, a);
        zzaap a2 = o.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, zzxn zzxn, int i) {
        zzks zzks;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        a.writeString(str);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(i);
        Parcel a2 = a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new akp(readStrongBinder);
        }
        a2.recycle();
        return zzks;
    }

    public final zzaaz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a = a(7, a);
        zzaaz a2 = u.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, zzxn zzxn, int i) {
        zzks zzks;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        a.writeString(str);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(i);
        Parcel a2 = a(2, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new akp(readStrongBinder);
        }
        a2.recycle();
        return zzks;
    }

    public final zzqa createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) iObjectWrapper2);
        a = a(5, a);
        zzqa a2 = aot.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzqf createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) iObjectWrapper2);
        afc.a(a, (IInterface) iObjectWrapper3);
        a = a(11, a);
        zzqf a2 = aow.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzagz createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzxn zzxn, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(i);
        a = a(6, a);
        zzagz a2 = ey.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, int i) {
        zzks zzks;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        a.writeString(str);
        a.writeInt(i);
        Parcel a2 = a(10, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new akp(readStrongBinder);
        }
        a2.recycle();
        return zzks;
    }

    public final zzlj getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        zzlj zzlj;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        Parcel a2 = a(4, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzlj = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzlj = queryLocalInterface instanceof zzlj ? (zzlj) queryLocalInterface : new alb(readStrongBinder);
        }
        a2.recycle();
        return zzlj;
    }

    public final zzlj getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        zzlj zzlj;
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        Parcel a2 = a(9, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzlj = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzlj = queryLocalInterface instanceof zzlj ? (zzlj) queryLocalInterface : new alb(readStrongBinder);
        }
        a2.recycle();
        return zzlj;
    }
}
