package com.puzzlersworld.a;

import com.google.android.gms.ads.f;
import com.puzzlersworld.wp.dto.AdType;

public class a {
    public static f a(AdType adType) {
        return adType == AdType.BANNER ? f.a : adType == AdType.MEDIUM_RECTANGLE ? f.e : adType == AdType.FULL_BANNER ? f.b : adType == AdType.LARGE_BANNER ? f.c : adType == AdType.LEADERBOARD ? f.d : adType == AdType.WIDE_SKYSCRAPER ? f.f : adType == AdType.SMART_BANNER ? f.g : adType == AdType.FULL_WIDTH ? f.b : f.a;
    }
}
