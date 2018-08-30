package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api.SimpleClient;

public class aw<T extends IInterface> extends u<T> {
    private final SimpleClient<T> e;

    protected T a(IBinder iBinder) {
        return this.e.createServiceInterface(iBinder);
    }

    protected String a() {
        return this.e.getStartServiceAction();
    }

    protected void a(int i, T t) {
        this.e.setState(i, t);
    }

    protected String d() {
        return this.e.getServiceDescriptor();
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public SimpleClient<T> r() {
        return this.e;
    }
}
