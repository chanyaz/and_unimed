package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import android.util.Log;
import com.appnext.core.Ad;
import com.google.android.gms.analytics.r;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.AdType;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@VisibleForTesting
public final class u extends r<u> {
    private String a;
    private int b;
    private int c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;

    public u() {
        this(false);
    }

    private u(boolean z) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                Log.e("GAv4", "UUID.randomUUID() returned 0.");
                leastSignificantBits = MoPubClientPositioning.NO_REPEAT;
            }
        }
        this(false, leastSignificantBits);
    }

    @VisibleForTesting
    private u(boolean z, int i) {
        ar.a(i);
        this.b = i;
        this.g = false;
    }

    public final String a() {
        return this.a;
    }

    public final /* synthetic */ void a(r rVar) {
        u uVar = (u) rVar;
        if (!TextUtils.isEmpty(this.a)) {
            uVar.a = this.a;
        }
        if (this.b != 0) {
            uVar.b = this.b;
        }
        if (this.c != 0) {
            uVar.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            uVar.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            Object obj = this.e;
            if (TextUtils.isEmpty(obj)) {
                uVar.e = null;
            } else {
                uVar.e = obj;
            }
        }
        if (this.f) {
            uVar.f = this.f;
        }
        if (this.g) {
            uVar.g = this.g;
        }
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.e;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.a);
        hashMap.put(AdType.INTERSTITIAL, Boolean.valueOf(this.f));
        hashMap.put(Ad.ORIENTATION_AUTO, Boolean.valueOf(this.g));
        hashMap.put("screenId", Integer.valueOf(this.b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.c));
        hashMap.put("referrerScreenName", this.d);
        hashMap.put("referrerUri", this.e);
        return r.a((Object) hashMap);
    }
}
