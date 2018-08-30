package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.a;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.ads.alm;
import com.google.android.gms.internal.ads.zzjd;

public final class h {
    private final alm a;

    public h(Context context) {
        this.a = new alm(context);
        ar.a((Object) context, (Object) "Context cannot be null");
    }

    public final void a(a aVar) {
        this.a.a(aVar);
        if (aVar != null && (aVar instanceof zzjd)) {
            this.a.a((zzjd) aVar);
        } else if (aVar == null) {
            this.a.a(null);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void a(d dVar) {
        this.a.a(dVar.a());
    }

    public final void a(RewardedVideoAdListener rewardedVideoAdListener) {
        this.a.a(rewardedVideoAdListener);
    }

    public final void a(a aVar) {
        this.a.a(aVar);
    }

    public final void a(String str) {
        this.a.a(str);
    }

    public final void a(boolean z) {
        this.a.a(true);
    }

    public final boolean a() {
        return this.a.a();
    }

    public final void b() {
        this.a.c();
    }

    public final void b(boolean z) {
        this.a.b(z);
    }

    public final Bundle c() {
        return this.a.b();
    }
}
