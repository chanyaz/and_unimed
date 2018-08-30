package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class s implements Runnable {
    private final /* synthetic */ r a;
    private final /* synthetic */ Callable b;

    s(r rVar, Callable callable) {
        this.a = rVar;
        this.b = callable;
    }

    public final void run() {
        try {
            this.a.a(this.b.call());
        } catch (Exception e) {
            this.a.a(e);
        }
    }
}
