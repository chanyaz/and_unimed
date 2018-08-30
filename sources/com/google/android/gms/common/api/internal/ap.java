package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;

final class ap implements GmsClientEventState {
    private final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return this.a.d();
    }
}
