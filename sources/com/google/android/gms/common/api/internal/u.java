package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;

final class u implements StatusListener {
    private final /* synthetic */ BasePendingResult a;
    private final /* synthetic */ t b;

    u(t tVar, BasePendingResult basePendingResult) {
        this.b = tVar;
        this.a = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.b.a.remove(this.a);
    }
}
