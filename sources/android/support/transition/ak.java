package android.support.transition;

import android.support.annotation.NonNull;
import android.support.v4.util.a;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;

class ak implements OnAttachStateChangeListener, OnPreDrawListener {
    Transition a;
    ViewGroup b;

    ak(Transition transition, ViewGroup viewGroup) {
        this.a = transition;
        this.b = viewGroup;
    }

    private void a() {
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        this.b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        a();
        if (aj.e.remove(this.b)) {
            ArrayList arrayList;
            final a a = aj.a();
            ArrayList arrayList2 = (ArrayList) a.get(this.b);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                a.put(this.b, arrayList2);
                arrayList = arrayList2;
                arrayList2 = null;
            } else if (arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList(arrayList2);
                arrayList = arrayList2;
                arrayList2 = arrayList3;
            } else {
                arrayList = arrayList2;
                arrayList2 = null;
            }
            arrayList.add(this.a);
            this.a.a(new ai() {
                public void onTransitionEnd(@NonNull Transition transition) {
                    ((ArrayList) a.get(ak.this.b)).remove(transition);
                }
            });
            this.a.a(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).f(this.b);
                }
            }
            this.a.a(this.b);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
        aj.e.remove(this.b);
        ArrayList arrayList = (ArrayList) aj.a().get(this.b);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).f(this.b);
            }
        }
        this.a.b(true);
    }
}
