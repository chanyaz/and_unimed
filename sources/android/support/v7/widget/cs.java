package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;

public abstract class cs extends ItemAnimator {
    boolean h = true;

    public final void a(ce ceVar, boolean z) {
        d(ceVar, z);
        f(ceVar);
    }

    public abstract boolean a(ce ceVar);

    public abstract boolean a(ce ceVar, int i, int i2, int i3, int i4);

    public boolean a(@NonNull ce ceVar, @NonNull br brVar, @Nullable br brVar2) {
        int i = brVar.a;
        int i2 = brVar.b;
        View view = ceVar.itemView;
        int left = brVar2 == null ? view.getLeft() : brVar2.a;
        int top = brVar2 == null ? view.getTop() : brVar2.b;
        if (ceVar.l() || (i == left && i2 == top)) {
            return a(ceVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(ceVar, i, i2, left, top);
    }

    public abstract boolean a(ce ceVar, ce ceVar2, int i, int i2, int i3, int i4);

    public boolean a(@NonNull ce ceVar, @NonNull ce ceVar2, @NonNull br brVar, @NonNull br brVar2) {
        int i;
        int i2;
        int i3 = brVar.a;
        int i4 = brVar.b;
        if (ceVar2.c()) {
            i = brVar.a;
            i2 = brVar.b;
        } else {
            i = brVar2.a;
            i2 = brVar2.b;
        }
        return a(ceVar, ceVar2, i3, i4, i, i2);
    }

    public final void b(ce ceVar, boolean z) {
        c(ceVar, z);
    }

    public abstract boolean b(ce ceVar);

    public boolean b(@NonNull ce ceVar, @Nullable br brVar, @NonNull br brVar2) {
        if (brVar == null || (brVar.a == brVar2.a && brVar.b == brVar2.b)) {
            return b(ceVar);
        }
        return a(ceVar, brVar.a, brVar.b, brVar2.a, brVar2.b);
    }

    public void c(ce ceVar, boolean z) {
    }

    public boolean c(@NonNull ce ceVar, @NonNull br brVar, @NonNull br brVar2) {
        if (brVar.a == brVar2.a && brVar.b == brVar2.b) {
            j(ceVar);
            return false;
        }
        return a(ceVar, brVar.a, brVar.b, brVar2.a, brVar2.b);
    }

    public void d(ce ceVar, boolean z) {
    }

    public boolean h(@NonNull ce ceVar) {
        return !this.h || ceVar.i();
    }

    public final void i(ce ceVar) {
        p(ceVar);
        f(ceVar);
    }

    public final void j(ce ceVar) {
        t(ceVar);
        f(ceVar);
    }

    public final void k(ce ceVar) {
        r(ceVar);
        f(ceVar);
    }

    public final void l(ce ceVar) {
        o(ceVar);
    }

    public final void m(ce ceVar) {
        s(ceVar);
    }

    public final void n(ce ceVar) {
        q(ceVar);
    }

    public void o(ce ceVar) {
    }

    public void p(ce ceVar) {
    }

    public void q(ce ceVar) {
    }

    public void r(ce ceVar) {
    }

    public void s(ce ceVar) {
    }

    public void t(ce ceVar) {
    }
}
