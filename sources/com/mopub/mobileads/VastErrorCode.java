package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;

public enum VastErrorCode {
    XML_PARSING_ERROR("100"),
    WRAPPER_TIMEOUT("301"),
    NO_ADS_VAST_RESPONSE("303"),
    GENERAL_LINEAR_AD_ERROR("400"),
    GENERAL_COMPANION_AD_ERROR("600"),
    UNDEFINED_ERROR("900");
    
    @NonNull
    private final String a;

    private VastErrorCode(String str) {
        Preconditions.checkNotNull(str, "errorCode cannot be null");
        this.a = str;
    }

    @NonNull
    String a() {
        return this.a;
    }
}
