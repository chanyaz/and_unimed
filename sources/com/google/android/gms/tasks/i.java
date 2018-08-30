package com.google.android.gms.tasks;

final class i implements Runnable {
    private final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        synchronized (this.a.b) {
            if (this.a.c != null) {
                this.a.c.onCanceled();
            }
        }
    }
}
