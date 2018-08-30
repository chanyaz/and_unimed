package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.b;

abstract class bn<T> extends aq {
    protected final b<T> a;

    public bn(int i, b<T> bVar) {
        super(i);
        this.a = bVar;
    }

    public void a(@NonNull Status status) {
        this.a.b(new ApiException(status));
    }

    public final void a(f<?> fVar) {
        try {
            b(fVar);
        } catch (RemoteException e) {
            a(aq.b(e));
            throw e;
        } catch (RemoteException e2) {
            a(aq.b(e2));
        } catch (RuntimeException e3) {
            a(e3);
        }
    }

    public void a(@NonNull t tVar, boolean z) {
    }

    public void a(@NonNull RuntimeException runtimeException) {
        this.a.b((Exception) runtimeException);
    }

    protected abstract void b(f<?> fVar);
}
