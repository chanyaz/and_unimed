package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

final class ax implements BackgroundStateChangeListener {
    private final /* synthetic */ e a;

    ax(e eVar) {
        this.a = eVar;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.a.q.sendMessage(this.a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
