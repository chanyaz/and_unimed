package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.b;

public final class bx<ResultT> extends aq {
    private final r<AnyClient, ResultT> a;
    private final b<ResultT> b;
    private final StatusExceptionMapper c;

    public final void a(@NonNull Status status) {
        this.b.b(this.c.getException(status));
    }

    public final void a(f<?> fVar) {
        try {
            this.a.a(fVar.b(), this.b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            a(aq.b(e2));
        } catch (RuntimeException e3) {
            a(e3);
        }
    }

    public final void a(@NonNull t tVar, boolean z) {
        tVar.a(this.b, z);
    }

    public final void a(@NonNull RuntimeException runtimeException) {
        this.b.b((Exception) runtimeException);
    }

    @Nullable
    public final Feature[] a() {
        return this.a.a();
    }

    public final boolean b() {
        return this.a.b();
    }
}
