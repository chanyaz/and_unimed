package com.nineoldandroids.animation;

import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    ArrayList<AnimatorListener> a = null;

    public interface AnimatorListener {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* renamed from: a */
    public Animator clone() {
        try {
            Animator animator = (Animator) super.clone();
            if (this.a != null) {
                ArrayList arrayList = this.a;
                animator.a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    animator.a.add(arrayList.get(i));
                }
            }
            return animator;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
