package com.mopub.common.util;

import android.os.Build.VERSION;

public enum VersionCode {
    BASE(1),
    BASE_1_1(2),
    CUPCAKE(3),
    DONUT(4),
    ECLAIR(5),
    ECLAIR_0_1(6),
    ECLAIR_MR1(7),
    FROYO(8),
    GINGERBREAD(9),
    GINGERBREAD_MR1(10),
    HONEYCOMB(11),
    HONEYCOMB_MR1(12),
    HONEYCOMB_MR2(13),
    ICE_CREAM_SANDWICH(14),
    ICE_CREAM_SANDWICH_MR1(15),
    JELLY_BEAN(16),
    JELLY_BEAN_MR1(17),
    JELLY_BEAN_MR2(18),
    KITKAT(19),
    CUR_DEVELOPMENT(10000);
    
    private int a;

    private VersionCode(int i) {
        this.a = i;
    }

    private static VersionCode a(int i) {
        for (VersionCode versionCode : values()) {
            if (versionCode.getApiLevel() == i) {
                return versionCode;
            }
        }
        return CUR_DEVELOPMENT;
    }

    public static VersionCode currentApiLevel() {
        return a(VERSION.SDK_INT);
    }

    public int getApiLevel() {
        return this.a;
    }

    public boolean isAtLeast(VersionCode versionCode) {
        return getApiLevel() >= versionCode.getApiLevel();
    }

    public boolean isAtMost(VersionCode versionCode) {
        return getApiLevel() <= versionCode.getApiLevel();
    }

    public boolean isBelow(VersionCode versionCode) {
        return getApiLevel() < versionCode.getApiLevel();
    }
}
