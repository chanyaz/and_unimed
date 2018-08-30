package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.a;
import java.util.ArrayList;

class d extends ConstantState {
    int a;
    l b;
    AnimatorSet c;
    a<Animator, String> d;
    private ArrayList<Animator> e;

    public d(Context context, d dVar, Callback callback, Resources resources) {
        int i = 0;
        if (dVar != null) {
            this.a = dVar.a;
            if (dVar.b != null) {
                ConstantState constantState = dVar.b.getConstantState();
                if (resources != null) {
                    this.b = (l) constantState.newDrawable(resources);
                } else {
                    this.b = (l) constantState.newDrawable();
                }
                this.b = (l) this.b.mutate();
                this.b.setCallback(callback);
                this.b.setBounds(dVar.b.getBounds());
                this.b.a(false);
            }
            if (dVar.e != null) {
                int size = dVar.e.size();
                this.e = new ArrayList(size);
                this.d = new a(size);
                while (i < size) {
                    Animator animator = (Animator) dVar.e.get(i);
                    Animator clone = animator.clone();
                    String str = (String) dVar.d.get(animator);
                    clone.setTarget(this.b.a(str));
                    this.e.add(clone);
                    this.d.put(clone, str);
                    i++;
                }
                a();
            }
        }
    }

    public void a() {
        if (this.c == null) {
            this.c = new AnimatorSet();
        }
        this.c.playTogether(this.e);
    }

    public int getChangingConfigurations() {
        return this.a;
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
