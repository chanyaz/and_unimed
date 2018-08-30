package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class akw extends afb implements zzld {
    public akw() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzld asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof zzld ? (zzld) queryLocalInterface : new akx(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface createBannerAdManager;
        switch (i) {
            case 1:
                createBannerAdManager = createBannerAdManager(a.a(parcel.readStrongBinder()), (zzjn) afc.a(parcel, zzjn.CREATOR), parcel.readString(), auw.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 2:
                createBannerAdManager = createInterstitialAdManager(a.a(parcel.readStrongBinder()), (zzjn) afc.a(parcel, zzjn.CREATOR), parcel.readString(), auw.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 3:
                createBannerAdManager = createAdLoaderBuilder(a.a(parcel.readStrongBinder()), parcel.readString(), auw.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 4:
                createBannerAdManager = getMobileAdsSettingsManager(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 5:
                createBannerAdManager = createNativeAdViewDelegate(a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 6:
                createBannerAdManager = createRewardedVideoAd(a.a(parcel.readStrongBinder()), auw.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 7:
                createBannerAdManager = createInAppPurchaseManager(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 8:
                createBannerAdManager = createAdOverlay(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 9:
                createBannerAdManager = getMobileAdsSettingsManagerWithClientJarVersion(a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 10:
                createBannerAdManager = createSearchAdManager(a.a(parcel.readStrongBinder()), (zzjn) afc.a(parcel, zzjn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            case 11:
                createBannerAdManager = createNativeAdViewHolderDelegate(a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                afc.a(parcel2, createBannerAdManager);
                break;
            default:
                return false;
        }
        return true;
    }
}
