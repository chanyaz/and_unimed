package com.google.android.gms.internal.ads;

final class ads implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ adn c;

    ads(adn adn, int i, boolean z) {
        this.c = adn;
        this.a = i;
        this.b = z;
    }

    public final void run() {
        wr b = this.c.b(this.a, this.b);
        this.c.k = b;
        if (adn.b(this.a, b)) {
            this.c.a(this.a + 1, this.b);
        }
    }
}
