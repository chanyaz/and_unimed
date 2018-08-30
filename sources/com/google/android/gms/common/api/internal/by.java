package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.b;

public final class by extends bn<Boolean> {
    private final m<?> b;

    public by(m<?> mVar, b<Boolean> bVar) {
        super(4, bVar);
        this.b = mVar;
    }

    public final /* bridge */ /* synthetic */ void a(@NonNull t tVar, boolean z) {
    }

    public final void b(f<?> fVar) {
        bi biVar = (bi) fVar.c().remove(this.b);
        if (biVar != null) {
            biVar.b.a(fVar.b(), this.a);
            biVar.a.a();
            return;
        }
        this.a.b(Boolean.valueOf(false));
    }
}
