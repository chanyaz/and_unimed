package com.fasterxml.jackson.core;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class Base64Variants {
    public static final Base64Variant MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final Base64Variant MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", MoPubClientPositioning.NO_REPEAT);
    public static final Base64Variant MODIFIED_FOR_URL;
    public static final Base64Variant PEM = new Base64Variant(MIME, "PEM", true, '=', 64);

    static {
        StringBuilder stringBuilder = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuilder.setCharAt(stringBuilder.indexOf("+"), '-');
        stringBuilder.setCharAt(stringBuilder.indexOf("/"), '_');
        MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", stringBuilder.toString(), false, 0, MoPubClientPositioning.NO_REPEAT);
    }

    public static Base64Variant getDefaultVariant() {
        return MIME_NO_LINEFEEDS;
    }

    public static Base64Variant valueOf(String str) {
        if (MIME._name.equals(str)) {
            return MIME;
        }
        if (MIME_NO_LINEFEEDS._name.equals(str)) {
            return MIME_NO_LINEFEEDS;
        }
        if (PEM._name.equals(str)) {
            return PEM;
        }
        if (MODIFIED_FOR_URL._name.equals(str)) {
            return MODIFIED_FOR_URL;
        }
        throw new IllegalArgumentException("No Base64Variant with name " + (str == null ? "<null>" : "'" + str + "'"));
    }
}
