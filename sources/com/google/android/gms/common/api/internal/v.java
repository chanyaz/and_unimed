package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;

final class v implements OnCompleteListener<TResult> {
    private final /* synthetic */ b a;
    private final /* synthetic */ t b;

    v(t tVar, b bVar) {
        this.b = tVar;
        this.a = bVar;
    }

    public final void onComplete(@NonNull a<TResult> aVar) {
        this.b.b.remove(this.a);
    }
}
