package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ak extends cs {
    private static TimeInterpolator i;
    ArrayList<ArrayList<ce>> a = new ArrayList();
    ArrayList<ArrayList<am>> b = new ArrayList();
    ArrayList<ArrayList<al>> c = new ArrayList();
    ArrayList<ce> d = new ArrayList();
    ArrayList<ce> e = new ArrayList();
    ArrayList<ce> f = new ArrayList();
    ArrayList<ce> g = new ArrayList();
    private ArrayList<ce> j = new ArrayList();
    private ArrayList<ce> k = new ArrayList();
    private ArrayList<am> l = new ArrayList();
    private ArrayList<al> m = new ArrayList();

    private void a(List<al> list, ce ceVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            al alVar = (al) list.get(size);
            if (a(alVar, ceVar) && alVar.a == null && alVar.b == null) {
                list.remove(alVar);
            }
        }
    }

    private boolean a(al alVar, ce ceVar) {
        boolean z = false;
        if (alVar.b == ceVar) {
            alVar.b = null;
        } else if (alVar.a != ceVar) {
            return false;
        } else {
            alVar.a = null;
            z = true;
        }
        ceVar.itemView.setAlpha(1.0f);
        ceVar.itemView.setTranslationX(0.0f);
        ceVar.itemView.setTranslationY(0.0f);
        a(ceVar, z);
        return true;
    }

    private void b(al alVar) {
        if (alVar.a != null) {
            a(alVar, alVar.a);
        }
        if (alVar.b != null) {
            a(alVar, alVar.b);
        }
    }

    private void u(final ce ceVar) {
        final View view = ceVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(ceVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                ak.this.i(ceVar);
                ak.this.f.remove(ceVar);
                ak.this.c();
            }

            public void onAnimationStart(Animator animator) {
                ak.this.l(ceVar);
            }
        }).start();
    }

    private void v(ce ceVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        ceVar.itemView.animate().setInterpolator(i);
        d(ceVar);
    }

    public void a() {
        int i = !this.j.isEmpty() ? 1 : 0;
        int i2 = !this.l.isEmpty() ? 1 : 0;
        int i3 = !this.m.isEmpty() ? 1 : 0;
        int i4 = !this.k.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                u((ce) it.next());
            }
            this.j.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                anonymousClass1 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            am amVar = (am) it.next();
                            ak.this.b(amVar.a, amVar.b, amVar.c, amVar.d, amVar.e);
                        }
                        arrayList.clear();
                        ak.this.b.remove(arrayList);
                    }
                };
                if (i != 0) {
                    ViewCompat.a(((am) arrayList.get(0)).a.itemView, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.m);
                this.c.add(arrayList);
                this.m.clear();
                anonymousClass1 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ak.this.a((al) it.next());
                        }
                        arrayList.clear();
                        ak.this.c.remove(arrayList);
                    }
                };
                if (i != 0) {
                    ViewCompat.a(((al) arrayList.get(0)).a.itemView, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.a.add(arrayList2);
                this.k.clear();
                Runnable anonymousClass3 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            ak.this.c((ce) it.next());
                        }
                        arrayList2.clear();
                        ak.this.a.remove(arrayList2);
                    }
                };
                if (i == 0 && i2 == 0 && i3 == 0) {
                    anonymousClass3.run();
                } else {
                    ViewCompat.a(((ce) arrayList2.get(0)).itemView, anonymousClass3, (i != 0 ? g() : 0) + Math.max(i2 != 0 ? e() : 0, i3 != 0 ? h() : 0));
                }
            }
        }
    }

    void a(final al alVar) {
        View view = null;
        ce ceVar = alVar.a;
        final View view2 = ceVar == null ? null : ceVar.itemView;
        ce ceVar2 = alVar.b;
        if (ceVar2 != null) {
            view = ceVar2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(h());
            this.g.add(alVar.a);
            duration.translationX((float) (alVar.e - alVar.c));
            duration.translationY((float) (alVar.f - alVar.d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    ak.this.a(alVar.a, true);
                    ak.this.g.remove(alVar.a);
                    ak.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    ak.this.b(alVar.a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.g.add(alVar.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    ak.this.a(alVar.b, false);
                    ak.this.g.remove(alVar.b);
                    ak.this.c();
                }

                public void onAnimationStart(Animator animator) {
                    ak.this.b(alVar.b, false);
                }
            }).start();
        }
    }

    void a(List<ce> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((ce) list.get(size)).itemView.animate().cancel();
        }
    }

    public boolean a(ce ceVar) {
        v(ceVar);
        this.j.add(ceVar);
        return true;
    }

    public boolean a(ce ceVar, int i, int i2, int i3, int i4) {
        View view = ceVar.itemView;
        int translationX = i + ((int) ceVar.itemView.getTranslationX());
        int translationY = i2 + ((int) ceVar.itemView.getTranslationY());
        v(ceVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            j(ceVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.l.add(new am(ceVar, translationX, translationY, i3, i4));
        return true;
    }

    public boolean a(ce ceVar, ce ceVar2, int i, int i2, int i3, int i4) {
        if (ceVar == ceVar2) {
            return a(ceVar, i, i2, i3, i4);
        }
        float translationX = ceVar.itemView.getTranslationX();
        float translationY = ceVar.itemView.getTranslationY();
        float alpha = ceVar.itemView.getAlpha();
        v(ceVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ceVar.itemView.setTranslationX(translationX);
        ceVar.itemView.setTranslationY(translationY);
        ceVar.itemView.setAlpha(alpha);
        if (ceVar2 != null) {
            v(ceVar2);
            ceVar2.itemView.setTranslationX((float) (-i5));
            ceVar2.itemView.setTranslationY((float) (-i6));
            ceVar2.itemView.setAlpha(0.0f);
        }
        this.m.add(new al(ceVar, ceVar2, i, i2, i3, i4));
        return true;
    }

    public boolean a(@NonNull ce ceVar, @NonNull List<Object> list) {
        return !list.isEmpty() || super.a(ceVar, (List) list);
    }

    void b(ce ceVar, int i, int i2, int i3, int i4) {
        final View view = ceVar.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(ceVar);
        final ce ceVar2 = ceVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                ak.this.j(ceVar2);
                ak.this.e.remove(ceVar2);
                ak.this.c();
            }

            public void onAnimationStart(Animator animator) {
                ak.this.m(ceVar2);
            }
        }).start();
    }

    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public boolean b(ce ceVar) {
        v(ceVar);
        ceVar.itemView.setAlpha(0.0f);
        this.k.add(ceVar);
        return true;
    }

    void c() {
        if (!b()) {
            i();
        }
    }

    void c(final ce ceVar) {
        final View view = ceVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(ceVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                ak.this.k(ceVar);
                ak.this.d.remove(ceVar);
                ak.this.c();
            }

            public void onAnimationStart(Animator animator) {
                ak.this.n(ceVar);
            }
        }).start();
    }

    public void d() {
        int size;
        for (size = this.l.size() - 1; size >= 0; size--) {
            am amVar = (am) this.l.get(size);
            View view = amVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(amVar.a);
            this.l.remove(size);
        }
        for (size = this.j.size() - 1; size >= 0; size--) {
            i((ce) this.j.get(size));
            this.j.remove(size);
        }
        for (size = this.k.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) this.k.get(size);
            ceVar.itemView.setAlpha(1.0f);
            k(ceVar);
            this.k.remove(size);
        }
        for (size = this.m.size() - 1; size >= 0; size--) {
            b((al) this.m.get(size));
        }
        this.m.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.b.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.b.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    am amVar2 = (am) arrayList.get(size3);
                    View view2 = amVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(amVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (size2 = this.a.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.a.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ce ceVar2 = (ce) arrayList.get(size3);
                    ceVar2.itemView.setAlpha(1.0f);
                    k(ceVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.a.remove(arrayList);
                    }
                }
            }
            for (size2 = this.c.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.c.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b((al) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.c.remove(arrayList);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    public void d(ce ceVar) {
        int size;
        ArrayList arrayList;
        View view = ceVar.itemView;
        view.animate().cancel();
        for (size = this.l.size() - 1; size >= 0; size--) {
            if (((am) this.l.get(size)).a == ceVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(ceVar);
                this.l.remove(size);
            }
        }
        a(this.m, ceVar);
        if (this.j.remove(ceVar)) {
            view.setAlpha(1.0f);
            i(ceVar);
        }
        if (this.k.remove(ceVar)) {
            view.setAlpha(1.0f);
            k(ceVar);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.c.get(size);
            a(list, ceVar);
            if (list.isEmpty()) {
                this.c.remove(size);
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.b.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((am) arrayList.get(size3)).a == ceVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(ceVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.a.get(size);
            if (arrayList.remove(ceVar)) {
                view.setAlpha(1.0f);
                k(ceVar);
                if (arrayList.isEmpty()) {
                    this.a.remove(size);
                }
            }
        }
        if (this.f.remove(ceVar)) {
        }
        if (this.d.remove(ceVar)) {
        }
        if (this.g.remove(ceVar)) {
        }
        if (this.e.remove(ceVar)) {
        }
        c();
    }
}
