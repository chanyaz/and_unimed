package android.support.v4.widget;

import android.support.v4.view.ViewCompat;

class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.e) {
            if (this.a.c) {
                this.a.c = false;
                this.a.a.a();
            }
            b bVar = this.a.a;
            if (bVar.c() || !this.a.a()) {
                this.a.e = false;
                return;
            }
            if (this.a.d) {
                this.a.d = false;
                this.a.b();
            }
            bVar.d();
            this.a.a(bVar.g(), bVar.h());
            ViewCompat.a(this.a.b, (Runnable) this);
        }
    }
}
