package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.p;

public abstract class aq {
    private final int a;

    public aq(int i) {
        this.a = i;
    }

    private static Status b(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (p.c() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void a(@NonNull Status status);

    public abstract void a(f<?> fVar);

    public abstract void a(@NonNull t tVar, boolean z);

    public abstract void a(@NonNull RuntimeException runtimeException);
}
