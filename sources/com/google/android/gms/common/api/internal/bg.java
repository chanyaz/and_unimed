package com.google.android.gms.common.api.internal;

final class bg implements Runnable {
    private final /* synthetic */ LifecycleCallback a;
    private final /* synthetic */ String b;
    private final /* synthetic */ bf c;

    bg(bf bfVar, LifecycleCallback lifecycleCallback, String str) {
        this.c = bfVar;
        this.a = lifecycleCallback;
        this.b = str;
    }

    public final void run() {
        if (this.c.c > 0) {
            this.a.a(this.c.d != null ? this.c.d.getBundle(this.b) : null);
        }
        if (this.c.c >= 2) {
            this.a.b();
        }
        if (this.c.c >= 3) {
            this.a.c();
        }
        if (this.c.c >= 4) {
            this.a.d();
        }
        if (this.c.c >= 5) {
            this.a.e();
        }
    }
}
