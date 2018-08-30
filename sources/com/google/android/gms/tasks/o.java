package com.google.android.gms.tasks;

final class o implements Runnable {
    private final /* synthetic */ a a;
    private final /* synthetic */ n b;

    o(n nVar, a aVar) {
        this.b = nVar;
        this.a = aVar;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onSuccess(this.a.d());
            }
        }
    }
}
