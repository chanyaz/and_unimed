package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
    @KeepForSdk
    protected final LifecycleFragment a;

    @KeepForSdk
    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.a = lifecycleFragment;
    }

    @KeepForSdk
    protected static LifecycleFragment a(l lVar) {
        if (lVar.a()) {
            return zzcc.a(lVar.d());
        }
        if (lVar.b()) {
            return bf.a(lVar.c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(l lVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public final Activity a() {
        return this.a.getLifecycleActivity();
    }

    @MainThread
    public void a(int i, int i2, Intent intent) {
    }

    @MainThread
    public void a(Bundle bundle) {
    }

    @MainThread
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @MainThread
    public void b() {
    }

    @MainThread
    public void b(Bundle bundle) {
    }

    @MainThread
    public void c() {
    }

    @KeepForSdk
    @MainThread
    public void d() {
    }

    @MainThread
    public void e() {
    }
}
