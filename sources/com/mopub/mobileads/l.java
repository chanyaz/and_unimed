package com.mopub.mobileads;

import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.mobileads.MoPubConversionTracker.AnonymousClass1;

class l extends BaseUrlGenerator {
    final /* synthetic */ MoPubConversionTracker a;

    private l(MoPubConversionTracker moPubConversionTracker) {
        this.a = moPubConversionTracker;
    }

    /* synthetic */ l(MoPubConversionTracker moPubConversionTracker, AnonymousClass1 anonymousClass1) {
        this(moPubConversionTracker);
    }

    private void a(String str) {
        b("id", str);
    }

    public String generateUrlString(String str) {
        a(str, Constants.CONVERSION_TRACKING_HANDLER);
        k("6");
        a(this.a.d);
        l(ClientMetadata.getInstance(this.a.a).getAppVersion());
        b();
        return a();
    }
}
