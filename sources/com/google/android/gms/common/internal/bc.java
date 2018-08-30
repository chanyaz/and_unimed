package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

final class bc extends s {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ LifecycleFragment b;
    private final /* synthetic */ int c;

    bc(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.a = intent;
        this.b = lifecycleFragment;
        this.c = i;
    }

    public final void a() {
        if (this.a != null) {
            this.b.startActivityForResult(this.a, this.c);
        }
    }
}
