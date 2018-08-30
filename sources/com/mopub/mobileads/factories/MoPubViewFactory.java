package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory {
    protected static MoPubViewFactory a = new MoPubViewFactory();

    public static MoPubView create(Context context) {
        return a.a(context);
    }

    @Deprecated
    @VisibleForTesting
    public static void setInstance(MoPubViewFactory moPubViewFactory) {
        a = moPubViewFactory;
    }

    protected MoPubView a(Context context) {
        return new MoPubView(context);
    }
}
