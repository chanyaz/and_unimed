package com.google.android.gms.tasks;

final class k implements Runnable {
    private final /* synthetic */ a a;
    private final /* synthetic */ j b;

    k(j jVar, a aVar) {
        this.b = jVar;
        this.a = aVar;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onComplete(this.a);
            }
        }
    }
}
