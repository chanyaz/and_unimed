package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardItem;

@zzadh
public final class fd implements RewardItem {
    private final zzagu a;

    public fd(zzagu zzagu) {
        this.a = zzagu;
    }

    public final int getAmount() {
        int i = 0;
        if (this.a == null) {
            return i;
        }
        try {
            return this.a.getAmount();
        } catch (Throwable e) {
            kk.c("Could not forward getAmount to RewardItem", e);
            return i;
        }
    }

    public final String getType() {
        String str = null;
        if (this.a == null) {
            return str;
        }
        try {
            return this.a.getType();
        } catch (Throwable e) {
            kk.c("Could not forward getType to RewardItem", e);
            return str;
        }
    }
}
