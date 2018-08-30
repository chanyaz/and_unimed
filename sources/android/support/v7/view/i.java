package android.support.v7.view;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ap;
import android.support.v4.view.ar;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({Scope.LIBRARY_GROUP})
public class i {
    final ArrayList<ap> a = new ArrayList();
    ViewPropertyAnimatorListener b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final ar f = new ar() {
        private boolean b = false;
        private int c = 0;

        void a() {
            this.c = 0;
            this.b = false;
            i.this.b();
        }

        public void onAnimationEnd(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == i.this.a.size()) {
                if (i.this.b != null) {
                    i.this.b.onAnimationEnd(null);
                }
                a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.b) {
                this.b = true;
                if (i.this.b != null) {
                    i.this.b.onAnimationStart(null);
                }
            }
        }
    };

    public i a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public i a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.e) {
            this.b = viewPropertyAnimatorListener;
        }
        return this;
    }

    public i a(ap apVar) {
        if (!this.e) {
            this.a.add(apVar);
        }
        return this;
    }

    public i a(ap apVar, ap apVar2) {
        this.a.add(apVar);
        apVar2.b(apVar.a());
        this.a.add(apVar2);
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ap apVar = (ap) it.next();
                if (this.c >= 0) {
                    apVar.a(this.c);
                }
                if (this.d != null) {
                    apVar.a(this.d);
                }
                if (this.b != null) {
                    apVar.a(this.f);
                }
                apVar.c();
            }
            this.e = true;
        }
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ap) it.next()).b();
            }
            this.e = false;
        }
    }
}
