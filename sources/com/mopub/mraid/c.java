package com.mopub.mraid;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
class c {
    @NonNull
    private final Handler a = new Handler();
    @Nullable
    private d b;

    c() {
    }

    d a(@NonNull View... viewArr) {
        this.b = new d(this.a, viewArr, null);
        return this.b;
    }

    void a() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }
}
