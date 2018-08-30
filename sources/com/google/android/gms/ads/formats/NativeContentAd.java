package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.k;
import java.util.List;

public abstract class NativeContentAd extends a {

    public interface OnContentAdLoadedListener {
        void onContentAdLoaded(NativeContentAd nativeContentAd);
    }

    public abstract CharSequence b();

    public abstract List<c> c();

    public abstract CharSequence d();

    public abstract c e();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public abstract k h();
}
