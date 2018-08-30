package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.m;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class bv implements DeathRecipient, zzcn {
    private final WeakReference<BasePendingResult<?>> a;
    private final WeakReference<m> b;
    private final WeakReference<IBinder> c;

    private bv(BasePendingResult<?> basePendingResult, m mVar, IBinder iBinder) {
        this.b = new WeakReference(mVar);
        this.a = new WeakReference(basePendingResult);
        this.c = new WeakReference(iBinder);
    }

    /* synthetic */ bv(BasePendingResult basePendingResult, m mVar, IBinder iBinder, bu buVar) {
        this(basePendingResult, null, iBinder);
    }

    private final void a() {
        BasePendingResult basePendingResult = (BasePendingResult) this.a.get();
        m mVar = (m) this.b.get();
        if (!(mVar == null || basePendingResult == null)) {
            mVar.a(basePendingResult.c().intValue());
        }
        IBinder iBinder = (IBinder) this.c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException e) {
            }
        }
    }

    public final void binderDied() {
        a();
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        a();
    }
}
