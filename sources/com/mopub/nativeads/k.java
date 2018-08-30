package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import java.util.Map;

@TargetApi(16)
@VisibleForTesting
class k {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    k(@NonNull Map<String, String> map) {
        try {
            this.b = Integer.parseInt((String) map.get(DataKeys.PLAY_VISIBLE_PERCENT));
            this.c = Integer.parseInt((String) map.get(DataKeys.PAUSE_VISIBLE_PERCENT));
            this.d = Integer.parseInt((String) map.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT));
            this.e = Integer.parseInt((String) map.get(DataKeys.IMPRESSION_VISIBLE_MS));
            this.f = Integer.parseInt((String) map.get(DataKeys.MAX_BUFFER_MS));
            this.a = true;
        } catch (NumberFormatException e) {
            this.a = false;
        }
    }

    boolean a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    int d() {
        return this.d;
    }

    int e() {
        return this.e;
    }
}
