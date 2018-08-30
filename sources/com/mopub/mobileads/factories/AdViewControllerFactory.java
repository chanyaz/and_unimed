package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory {
    protected static AdViewControllerFactory a = new AdViewControllerFactory();

    public static AdViewController create(Context context, MoPubView moPubView) {
        return a.a(context, moPubView);
    }

    @Deprecated
    public static void setInstance(AdViewControllerFactory adViewControllerFactory) {
        a = adViewControllerFactory;
    }

    protected AdViewController a(Context context, MoPubView moPubView) {
        return new AdViewController(context, moPubView);
    }
}
