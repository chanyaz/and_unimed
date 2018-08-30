package com.google.android.gms.tasks;

final class g implements Runnable {
    private final /* synthetic */ a a;
    private final /* synthetic */ f b;

    g(f fVar, a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    public final void run() {
        if (this.a.c()) {
            this.b.c.f();
            return;
        }
        try {
            this.b.c.a(this.b.b.then(this.a));
        } catch (Exception e) {
            if (e.getCause() instanceof Exception) {
                this.b.c.a((Exception) e.getCause());
            } else {
                this.b.c.a(e);
            }
        } catch (Exception e2) {
            this.b.c.a(e2);
        }
    }
}
