package com.google.android.gms.common.api.internal;

final class d {
    private final /* synthetic */ BasePendingResult a;

    private d(BasePendingResult basePendingResult) {
        this.a = basePendingResult;
    }

    /* synthetic */ d(BasePendingResult basePendingResult, ch chVar) {
        this(basePendingResult);
    }

    protected final void finalize() {
        BasePendingResult.c(this.a.i);
        super.finalize();
    }
}
