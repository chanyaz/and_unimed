package com.mopub.common;

import android.support.annotation.NonNull;

public final class MoPubReward {
    public static final int DEFAULT_REWARD_AMOUNT = 0;
    public static final int NO_REWARD_AMOUNT = -123;
    public static final String NO_REWARD_LABEL = "";
    private final boolean a;
    @NonNull
    private final String b;
    private final int c;

    private MoPubReward(boolean z, @NonNull String str, int i) {
        this.a = z;
        this.b = str;
        this.c = i;
    }

    @NonNull
    public static MoPubReward failure() {
        return new MoPubReward(false, "", 0);
    }

    @NonNull
    public static MoPubReward success(@NonNull String str, int i) {
        return new MoPubReward(true, str, i);
    }

    public final int getAmount() {
        return this.c;
    }

    @NonNull
    public final String getLabel() {
        return this.b;
    }

    public final boolean isSuccessful() {
        return this.a;
    }
}
