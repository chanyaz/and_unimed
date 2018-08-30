package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final class aej implements Callable {
    private final adn a;
    private final wr b;

    public aej(adn adn, wr wrVar) {
        this.a = adn;
        this.b = wrVar;
    }

    private final Void a() {
        if (this.a.l() != null) {
            this.a.l().get();
        }
        abj k = this.a.k();
        if (k != null) {
            try {
                synchronized (this.b) {
                    abj.a(this.b, abj.a(k));
                }
            } catch (zzbfh e) {
            }
        }
        return null;
    }
}
