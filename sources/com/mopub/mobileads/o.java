package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;

abstract class o implements Runnable {
    @NonNull
    private final Class<? extends CustomEventRewardedVideo> a;
    @NonNull
    private final String b;

    o(@NonNull Class<? extends CustomEventRewardedVideo> cls, @NonNull String str) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        this.a = cls;
        this.b = str;
    }

    protected abstract void a(@NonNull String str);

    public void run() {
        for (String a : MoPubRewardedVideoManager.a.f.a(this.a, this.b)) {
            a(a);
        }
    }
}
