package com.google.android.gms.common.api.internal;

final class ck implements Runnable {
    private final /* synthetic */ cj a;

    ck(cj cjVar) {
        this.a = cjVar;
    }

    public final void run() {
        this.a.m.lock();
        try {
            this.a.a();
        } finally {
            this.a.m.unlock();
        }
    }
}
