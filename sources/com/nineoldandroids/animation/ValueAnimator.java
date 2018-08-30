package com.nineoldandroids.animation;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class ValueAnimator extends Animator {
    private static ThreadLocal<Object> g = new ThreadLocal();
    private static final ThreadLocal<ArrayList<ValueAnimator>> h = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> i = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> j = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> k = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> l = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final Interpolator m = new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator n = new b();
    private static final TypeEvaluator o = new a();
    private static long x = 10;
    private Interpolator A = m;
    private ArrayList<AnimatorUpdateListener> B = null;
    long b = -1;
    int c = 0;
    boolean d = false;
    e[] e;
    HashMap<String, e> f;
    private boolean p = false;
    private int q = 0;
    private float r = 0.0f;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private long v = 300;
    private long w = 0;
    private int y = 0;
    private int z = 1;

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    /* renamed from: b */
    public ValueAnimator clone() {
        int i = 0;
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        if (this.B != null) {
            ArrayList arrayList = this.B;
            valueAnimator.B = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                valueAnimator.B.add(arrayList.get(i2));
            }
        }
        valueAnimator.b = -1;
        valueAnimator.p = false;
        valueAnimator.q = 0;
        valueAnimator.d = false;
        valueAnimator.c = 0;
        valueAnimator.s = false;
        e[] eVarArr = this.e;
        if (eVarArr != null) {
            int length = eVarArr.length;
            valueAnimator.e = new e[length];
            valueAnimator.f = new HashMap(length);
            while (i < length) {
                e a = eVarArr[i].clone();
                valueAnimator.e[i] = a;
                valueAnimator.f.put(a.b(), a);
                i++;
            }
        }
        return valueAnimator;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.e != null) {
            for (e eVar : this.e) {
                str = str + "\n    " + eVar.toString();
            }
        }
        return str;
    }
}
