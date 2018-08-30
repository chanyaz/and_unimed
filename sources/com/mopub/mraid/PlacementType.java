package com.mopub.mraid;

import java.util.Locale;

public enum PlacementType {
    INLINE,
    INTERSTITIAL;

    String a() {
        return toString().toLowerCase(Locale.US);
    }
}
