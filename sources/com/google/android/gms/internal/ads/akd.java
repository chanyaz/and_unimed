package com.google.android.gms.internal.ads;

import java.util.Random;

@zzadh
public final class akd extends aky {
    private final Random a = new Random();
    private long b;
    private Object c = new Object();

    public akd() {
        a();
    }

    public final void a() {
        synchronized (this.c) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.a.nextInt()) + 2147483648L;
                if (j != this.b && j != 0) {
                    break;
                }
            }
            this.b = j;
        }
    }

    public final long getValue() {
        return this.b;
    }
}
