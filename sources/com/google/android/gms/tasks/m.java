package com.google.android.gms.tasks;

final class m implements Runnable {
    private final /* synthetic */ a a;
    private final /* synthetic */ l b;

    m(l lVar, a aVar) {
        this.b = lVar;
        this.a = aVar;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onFailure(this.a.e());
            }
        }
    }
}
