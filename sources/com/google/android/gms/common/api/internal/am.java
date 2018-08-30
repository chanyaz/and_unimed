package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;

abstract class am implements Runnable {
    private final /* synthetic */ ac a;

    private am(ac acVar) {
        this.a = acVar;
    }

    /* synthetic */ am(ac acVar, ad adVar) {
        this(acVar);
    }

    @WorkerThread
    protected abstract void a();

    @WorkerThread
    public void run() {
        this.a.b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
                this.a.b.unlock();
            }
        } catch (RuntimeException e) {
            this.a.a.a(e);
        } finally {
            this.a.b.unlock();
        }
    }
}
