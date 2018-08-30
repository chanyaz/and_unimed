package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

public class WebViewAdUrlGenerator extends AdUrlGenerator {
    private final boolean e;

    public WebViewAdUrlGenerator(Context context, boolean z) {
        super(context);
        this.e = z;
    }

    public String generateUrlString(String str) {
        a(str, Constants.AD_HANDLER);
        k("6");
        a(ClientMetadata.getInstance(this.a));
        a(true);
        b(this.e);
        return a();
    }
}
