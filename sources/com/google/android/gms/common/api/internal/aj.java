package com.google.android.gms.common.api.internal;

import android.support.annotation.BinderThread;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

final class aj extends b {
    private final WeakReference<ac> a;

    aj(ac acVar) {
        this.a = new WeakReference(acVar);
    }

    @BinderThread
    public final void onSignInComplete(SignInResponse signInResponse) {
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            acVar.a.a(new ak(this, acVar, acVar, signInResponse));
        }
    }
}
