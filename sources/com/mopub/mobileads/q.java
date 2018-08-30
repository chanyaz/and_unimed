package com.mopub.mobileads;

import android.support.annotation.NonNull;
import android.util.Pair;

class q extends Pair<Class<? extends CustomEventRewardedVideo>, String> {
    @NonNull
    final Class<? extends CustomEventRewardedVideo> a;
    @NonNull
    final String b;

    public q(@NonNull Class<? extends CustomEventRewardedVideo> cls, @NonNull String str) {
        super(cls, str);
        this.a = cls;
        this.b = str;
    }
}
