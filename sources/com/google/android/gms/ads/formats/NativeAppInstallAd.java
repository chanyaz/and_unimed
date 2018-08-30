package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.k;
import java.util.List;

public abstract class NativeAppInstallAd extends a {

    public interface OnAppInstallAdLoadedListener {
        void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd);
    }

    public abstract CharSequence b();

    public abstract List<c> c();

    public abstract CharSequence d();

    public abstract c e();

    public abstract CharSequence f();

    public abstract Double g();

    public abstract CharSequence h();

    public abstract CharSequence i();

    public abstract k j();
}
