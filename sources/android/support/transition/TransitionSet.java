package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.f;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    private ArrayList<Transition> g = new ArrayList();
    private boolean h = true;
    private int i;
    private boolean j = false;

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.i);
        a(f.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void q() {
        TransitionListener amVar = new am(this);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).a(amVar);
        }
        this.i = this.g.size();
    }

    @NonNull
    public TransitionSet a(int i) {
        switch (i) {
            case 0:
                this.h = true;
                break;
            case 1:
                this.h = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    @NonNull
    /* renamed from: a */
    public TransitionSet c(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return (TransitionSet) super.c(view);
            }
            ((Transition) this.g.get(i2)).c(view);
            i = i2 + 1;
        }
    }

    String a(String str) {
        String a = super.a(str);
        int i = 0;
        while (i < this.g.size()) {
            String str2 = a + "\n" + ((Transition) this.g.get(i)).a(str + "  ");
            i++;
            a = str2;
        }
        return a;
    }

    public void a(ah ahVar) {
        super.a(ahVar);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.g.get(i)).a(ahVar);
        }
    }

    public void a(al alVar) {
        super.a(alVar);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.g.get(i)).a(alVar);
        }
    }

    public void a(@NonNull ap apVar) {
        if (b(apVar.b)) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.b(apVar.b)) {
                    transition.a(apVar);
                    apVar.c.add(transition);
                }
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void a(ViewGroup viewGroup, aq aqVar, aq aqVar2, ArrayList<ap> arrayList, ArrayList<ap> arrayList2) {
        long c = c();
        int size = this.g.size();
        int i = 0;
        while (i < size) {
            Transition transition = (Transition) this.g.get(i);
            if (c > 0 && (this.h || i == 0)) {
                long c2 = transition.c();
                if (c2 > 0) {
                    transition.b(c2 + c);
                } else {
                    transition.b(c);
                }
            }
            transition.a(viewGroup, aqVar, aqVar2, arrayList, arrayList2);
            i++;
        }
    }

    public Transition b(int i) {
        return (i < 0 || i >= this.g.size()) ? null : (Transition) this.g.get(i);
    }

    @NonNull
    /* renamed from: b */
    public TransitionSet a(@Nullable TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.a(timeInterpolator);
    }

    @NonNull
    public TransitionSet b(@NonNull Transition transition) {
        this.g.add(transition);
        transition.d = this;
        if (this.a >= 0) {
            transition.a(this.a);
        }
        return this;
    }

    public void b(@NonNull ap apVar) {
        if (b(apVar.b)) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.b(apVar.b)) {
                    transition.b(apVar);
                    apVar.c.add(transition);
                }
            }
        }
    }

    @NonNull
    /* renamed from: c */
    public TransitionSet a(long j) {
        super.a(j);
        if (this.a >= 0) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.g.get(i)).a(j);
            }
        }
        return this;
    }

    @NonNull
    /* renamed from: c */
    public TransitionSet a(@NonNull TransitionListener transitionListener) {
        return (TransitionSet) super.a(transitionListener);
    }

    void c(ap apVar) {
        super.c(apVar);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.g.get(i)).c(apVar);
        }
    }

    @NonNull
    /* renamed from: d */
    public TransitionSet b(long j) {
        return (TransitionSet) super.b(j);
    }

    @NonNull
    /* renamed from: d */
    public TransitionSet b(@NonNull TransitionListener transitionListener) {
        return (TransitionSet) super.b(transitionListener);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void e() {
        if (this.g.isEmpty()) {
            j();
            k();
            return;
        }
        q();
        if (this.h) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).e();
            }
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                break;
            }
            final Transition transition = (Transition) this.g.get(i2);
            ((Transition) this.g.get(i2 - 1)).a(new ai() {
                public void onTransitionEnd(@NonNull Transition transition) {
                    transition.e();
                    transition.b((TransitionListener) this);
                }
            });
            i = i2 + 1;
        }
        Transition transition2 = (Transition) this.g.get(0);
        if (transition2 != null) {
            transition2.e();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void e(View view) {
        super.e(view);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.g.get(i)).e(view);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void f(View view) {
        super.f(view);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.g.get(i)).f(view);
        }
    }

    @NonNull
    /* renamed from: g */
    public TransitionSet d(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return (TransitionSet) super.d(view);
            }
            ((Transition) this.g.get(i2)).d(view);
            i = i2 + 1;
        }
    }

    /* renamed from: n */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.g = new ArrayList();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            transitionSet.b(((Transition) this.g.get(i)).clone());
        }
        return transitionSet;
    }

    public int p() {
        return this.g.size();
    }
}
