package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;

final class bb implements SignOutCallbacks {
    final /* synthetic */ f a;

    bb(f fVar) {
        this.a = fVar;
    }

    public final void onSignOutComplete() {
        this.a.a.q.post(new bc(this));
    }
}
