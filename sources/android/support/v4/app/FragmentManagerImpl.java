package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.k;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.b;
import android.support.v4.util.d;
import android.support.v4.util.e;
import android.support.v4.util.o;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q = null;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    ArrayList<x> C;
    y D;
    Runnable E = new Runnable() {
        public void run() {
            FragmentManagerImpl.this.i();
        }
    };
    private final CopyOnWriteArrayList<o<p, Boolean>> J = new CopyOnWriteArrayList();
    ArrayList<OpGenerator> b;
    boolean c;
    int d = 0;
    final ArrayList<Fragment> e = new ArrayList();
    SparseArray<Fragment> f;
    ArrayList<d> g;
    ArrayList<Fragment> h;
    ArrayList<d> i;
    ArrayList<Integer> j;
    ArrayList<OnBackStackChangedListener> k;
    int l = 0;
    o m;
    m n;
    Fragment o;
    Fragment p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<d> x;
    ArrayList<Boolean> y;
    ArrayList<Fragment> z;

    interface OpGenerator {
        boolean generateOps(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2);
    }

    FragmentManagerImpl() {
    }

    private void B() {
        if (g()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    private void C() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.C == null || this.C.isEmpty()) ? null : 1;
            if (this.b == null || this.b.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && obj == null)) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
        }
    }

    private void D() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    private void E() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                ((x) this.C.remove(0)).b();
            }
        }
    }

    private void F() {
        int size = this.f == null ? 0 : this.f.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) this.f.valueAt(i);
            if (fragment != null) {
                if (fragment.X() != null) {
                    int Z = fragment.Z();
                    View X = fragment.X();
                    Animation animation = X.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        X.clearAnimation();
                    }
                    fragment.a(null);
                    a(fragment, Z, 0, 0, false);
                } else if (fragment.Y() != null) {
                    fragment.Y().end();
                }
            }
        }
    }

    private void G() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, b<Fragment> bVar) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            int i5;
            d dVar = (d) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            boolean z = dVar.g() && !dVar.a((ArrayList) arrayList, i3 + 1, i2);
            if (z) {
                if (this.C == null) {
                    this.C = new ArrayList();
                }
                OnStartEnterTransitionListener xVar = new x(dVar, booleanValue);
                this.C.add(xVar);
                dVar.a(xVar);
                if (booleanValue) {
                    dVar.f();
                } else {
                    dVar.b(false);
                }
                int i6 = i4 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, dVar);
                }
                b((b) bVar);
                i5 = i6;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    static s a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        return new s(alphaAnimation, null);
    }

    static s a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(G);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return new s(animationSet, null);
    }

    private static AnimationListener a(Animation animation) {
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (AnimationListener) q.get(animation);
        } catch (Throwable e) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    private void a(@NonNull final Fragment fragment, @NonNull s sVar, int i) {
        final View view = fragment.S;
        final ViewGroup viewGroup = fragment.R;
        viewGroup.startViewTransition(view);
        fragment.c(i);
        if (sVar.a != null) {
            Animation uVar = new u(sVar.a, viewGroup, view);
            fragment.a(fragment.S);
            uVar.setAnimationListener(new r(a(uVar)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (fragment.X() != null) {
                                fragment.a(null);
                                FragmentManagerImpl.this.a(fragment, fragment.Z(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, sVar);
            fragment.S.startAnimation(uVar);
            return;
        }
        Animator animator = sVar.b;
        fragment.a(sVar.b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator Y = fragment.Y();
                fragment.a(null);
                if (Y != null && viewGroup.indexOfChild(view) < 0) {
                    FragmentManagerImpl.this.a(fragment, fragment.Z(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.S);
        b(fragment.S, sVar);
        animator.start();
    }

    private void a(d dVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            dVar.b(z3);
        } else {
            dVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(dVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            ac.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.f.valueAt(i);
                if (fragment != null && fragment.S != null && fragment.Y && dVar.b(fragment.I)) {
                    if (fragment.aa > 0.0f) {
                        fragment.S.setAlpha(fragment.aa);
                    }
                    if (z3) {
                        fragment.aa = 0.0f;
                    } else {
                        fragment.aa = -1.0f;
                        fragment.Y = false;
                    }
                }
            }
        }
    }

    private static void a(y yVar) {
        if (yVar != null) {
            List<Fragment> a = yVar.a();
            if (a != null) {
                for (Fragment fragment : a) {
                    fragment.N = true;
                }
            }
            List<y> b = yVar.b();
            if (b != null) {
                for (y a2 : b) {
                    a(a2);
                }
            }
        }
    }

    private void a(b<Fragment> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) bVar.b(i);
            if (!fragment.u) {
                View s = fragment.s();
                fragment.aa = s.getAlpha();
                s.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    private void a(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        int size = this.C == null ? 0 : this.C.size();
        while (i < size) {
            int indexOf;
            x xVar = (x) this.C.get(i);
            if (!(arrayList == null || xVar.a)) {
                indexOf = arrayList.indexOf(xVar.b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    xVar.c();
                    i++;
                    size = size;
                }
            }
            if (xVar.a() || (arrayList != null && xVar.b.a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.C.remove(i);
                i--;
                size--;
                if (!(arrayList == null || xVar.a)) {
                    indexOf = arrayList.indexOf(xVar.b);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        xVar.c();
                    }
                }
                xVar.b();
            }
            i++;
            size = size;
        }
    }

    private void a(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        d dVar;
        int a;
        boolean z = ((d) arrayList.get(i)).t;
        if (this.z == null) {
            this.z = new ArrayList();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        int i3 = i;
        Fragment z2 = z();
        boolean z3 = false;
        while (i3 < i2) {
            dVar = (d) arrayList.get(i3);
            Fragment a2 = !((Boolean) arrayList2.get(i3)).booleanValue() ? dVar.a(this.z, z2) : dVar.b(this.z, z2);
            boolean z4 = z3 || dVar.i;
            i3++;
            z2 = a2;
            z3 = z4;
        }
        this.z.clear();
        if (!z) {
            ac.a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            b bVar = new b();
            b(bVar);
            a = a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, bVar);
            a(bVar);
        } else {
            a = i2;
        }
        if (a != i && z) {
            ac.a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, a, true);
            a(this.l, true);
        }
        while (i < i2) {
            dVar = (d) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && dVar.m >= 0) {
                c(dVar.m);
                dVar.m = -1;
            }
            dVar.b();
            i++;
        }
        if (z3) {
            k();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean a(s sVar) {
        if (sVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(sVar.a instanceof AnimationSet)) {
            return a(sVar.b);
        }
        List animations = ((AnimationSet) sVar.a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, s sVar) {
        return view != null && sVar != null && VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.s(view) && a(sVar);
    }

    private boolean a(String str, int i, int i2) {
        i();
        c(true);
        if (this.p != null && i < 0 && str == null) {
            FragmentManager n = this.p.n();
            if (n != null && n.d()) {
                return true;
            }
        }
        boolean a = a(this.x, this.y, str, i, i2);
        if (a) {
            this.c = true;
            try {
                b(this.x, this.y);
            } finally {
                D();
            }
        }
        j();
        G();
        return a;
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void b(b<Fragment> bVar) {
        if (this.l >= 1) {
            int min = Math.min(this.l, 4);
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.e.get(i);
                if (fragment.k < min) {
                    a(fragment, min, fragment.S(), fragment.T(), false);
                    if (!(fragment.S == null || fragment.K || !fragment.Y)) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    private static void b(View view, s sVar) {
        if (view != null && sVar != null && a(view, sVar)) {
            if (sVar.b != null) {
                sVar.b.addListener(new t(view));
                return;
            }
            AnimationListener a = a(sVar.a);
            view.setLayerType(2, null);
            sVar.a.setAnimationListener(new q(view, a));
        }
    }

    private void b(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((d) arrayList.get(i)).t) {
                    i3 = i;
                } else {
                    if (i2 != i) {
                        a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((d) arrayList.get(i2)).t) {
                            i2++;
                        }
                    }
                    i3 = i2;
                    a((ArrayList) arrayList, (ArrayList) arrayList2, i, i3);
                    i2 = i3;
                    i3--;
                }
                i = i3 + 1;
            }
            if (i2 != size) {
                a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    private static void b(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            d dVar = (d) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                dVar.a(-1);
                dVar.b(i == i2 + -1);
            } else {
                dVar.a(1);
                dVar.f();
            }
            i++;
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                B();
            }
            if (this.x == null) {
                this.x = new ArrayList();
                this.y = new ArrayList();
            }
            this.c = true;
            try {
                a(null, null);
            } finally {
                this.c = false;
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:?, code:
            return false;
     */
    private boolean c(java.util.ArrayList<android.support.v4.app.d> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        r0 = 0;
        monitor-enter(r4);
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        r1 = r1.size();	 Catch:{ all -> 0x003e }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        r3 = r1.size();	 Catch:{ all -> 0x003e }
        r2 = r0;
        r1 = r0;
    L_0x0018:
        if (r2 >= r3) goto L_0x002b;
    L_0x001a:
        r0 = r4.b;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) r0;	 Catch:{ all -> 0x003e }
        r0 = r0.generateOps(r5, r6);	 Catch:{ all -> 0x003e }
        r1 = r1 | r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x002b:
        r0 = r4.b;	 Catch:{ all -> 0x003e }
        r0.clear();	 Catch:{ all -> 0x003e }
        r0 = r4.m;	 Catch:{ all -> 0x003e }
        r0 = r0.h();	 Catch:{ all -> 0x003e }
        r2 = r4.E;	 Catch:{ all -> 0x003e }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x000f;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public static int d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void e(int i) {
        try {
            this.c = true;
            a(i, false);
            i();
        } finally {
            this.c = false;
        }
    }

    private Fragment q(Fragment fragment) {
        ViewGroup viewGroup = fragment.R;
        View view = fragment.S;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.e.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = (Fragment) this.e.get(indexOf);
            if (fragment2.R == viewGroup && fragment2.S != null) {
                return fragment2;
            }
        }
        return null;
    }

    Factory2 A() {
        return this;
    }

    public int a(d dVar) {
        int size;
        synchronized (this) {
            if (this.j == null || this.j.size() <= 0) {
                if (this.i == null) {
                    this.i = new ArrayList();
                }
                size = this.i.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + dVar);
                }
                this.i.add(dVar);
            } else {
                size = ((Integer) this.j.remove(this.j.size() - 1)).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + dVar);
                }
                this.i.set(size, dVar);
            }
        }
        return size;
    }

    public SavedState a(Fragment fragment) {
        if (fragment.o < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.k <= 0) {
            return null;
        }
        Bundle o = o(fragment);
        return o != null ? new SavedState(o) : null;
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.f.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment a(String str) {
        int size;
        Fragment fragment;
        if (str != null) {
            for (size = this.e.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.e.get(size);
                if (fragment != null && str.equals(fragment.J)) {
                    return fragment;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.valueAt(size);
                if (fragment != null && str.equals(fragment.J)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public FragmentTransaction a() {
        return new d(this);
    }

    s a(Fragment fragment, int i, boolean z, int i2) {
        int S = fragment.S();
        Animation a = fragment.a(i, z, S);
        if (a != null) {
            return new s(a, null);
        }
        Animator b = fragment.b(i, z, S);
        if (b != null) {
            return new s(b, null);
        }
        if (S != 0) {
            Object obj;
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(S));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), S);
                    if (loadAnimation != null) {
                        return new s(loadAnimation, null);
                    }
                    obj = 1;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                    obj = null;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    b = AnimatorInflater.loadAnimator(this.m.g(), S);
                    if (b != null) {
                        return new s(b, null);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    a = AnimationUtils.loadAnimation(this.m.g(), S);
                    if (a != null) {
                        return new s(a, null);
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        int b2 = b(i, z);
        if (b2 < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.g(), 0.0f, 1.0f);
            case 6:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.m.d()) {
                    i2 = this.m.e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new w(this, null, i, i2), false);
    }

    public void a(int i, d dVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList();
            }
            int size = this.i.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + dVar);
                }
                this.i.set(i, dVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + dVar);
                }
                this.i.add(dVar);
            }
        }
    }

    void a(int i, boolean z) {
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.l) {
            this.l = i;
            if (this.f != null) {
                int i2;
                int size = this.e.size();
                for (i2 = 0; i2 < size; i2++) {
                    f((Fragment) this.e.get(i2));
                }
                size = this.f.size();
                for (i2 = 0; i2 < size; i2++) {
                    Fragment fragment = (Fragment) this.f.valueAt(i2);
                    if (fragment != null && ((fragment.v || fragment.L) && !fragment.Y)) {
                        f(fragment);
                    }
                }
                h();
                if (this.r && this.m != null && this.l == 5) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                Fragment fragment = (Fragment) this.e.get(i2);
                if (fragment != null) {
                    fragment.a(configuration);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.o < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.o);
    }

    void a(Parcelable parcelable, y yVar) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                List a;
                List b;
                int size;
                Fragment fragment;
                int i;
                List list;
                if (yVar != null) {
                    a = yVar.a();
                    b = yVar.b();
                    List c = yVar.c();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean size2 = false;
                    }
                    for (int i2 = 0; i2 < size2; i2++) {
                        fragment = (Fragment) a.get(i2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        i = 0;
                        while (i < fragmentManagerState.a.length && fragmentManagerState.a[i].b != fragment.o) {
                            i++;
                        }
                        if (i == fragmentManagerState.a.length) {
                            a(new IllegalStateException("Could not find active fragment with index " + fragment.o));
                        }
                        FragmentState fragmentState = fragmentManagerState.a[i];
                        fragmentState.l = fragment;
                        fragment.m = null;
                        fragment.A = 0;
                        fragment.x = false;
                        fragment.u = false;
                        fragment.r = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.m.g().getClassLoader());
                            fragment.m = fragmentState.k.getSparseParcelableArray("android:view_state");
                            fragment.l = fragmentState.k;
                        }
                    }
                    a = c;
                    list = b;
                } else {
                    a = null;
                    list = null;
                }
                this.f = new SparseArray(fragmentManagerState.a.length);
                int i3 = 0;
                while (i3 < fragmentManagerState.a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i3];
                    if (fragmentState2 != null) {
                        y yVar2 = (list == null || i3 >= list.size()) ? null : (y) list.get(i3);
                        k kVar = (a == null || i3 >= a.size()) ? null : (k) a.get(i3);
                        Fragment a2 = fragmentState2.a(this.m, this.n, this.o, yVar2, kVar);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + a2);
                        }
                        this.f.put(a2.o, a2);
                        fragmentState2.l = null;
                    }
                    i3++;
                }
                if (yVar != null) {
                    b = yVar.a();
                    if (b != null) {
                        i = b.size();
                    } else {
                        boolean z = false;
                    }
                    for (int i4 = 0; i4 < i; i4++) {
                        fragment = (Fragment) b.get(i4);
                        if (fragment.s >= 0) {
                            fragment.r = (Fragment) this.f.get(fragment.s);
                            if (fragment.r == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.s);
                            }
                        }
                    }
                }
                this.e.clear();
                if (fragmentManagerState.b != null) {
                    for (size2 = 0; size2 < fragmentManagerState.b.length; size2++) {
                        fragment = (Fragment) this.f.get(fragmentManagerState.b[size2]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[size2]));
                        }
                        fragment.u = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size2 + ": " + fragment);
                        }
                        if (this.e.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.e) {
                            this.e.add(fragment);
                        }
                    }
                }
                if (fragmentManagerState.c != null) {
                    this.g = new ArrayList(fragmentManagerState.c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.c.length; i5++) {
                        d a3 = fragmentManagerState.c[i5].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a3.m + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a3);
                        if (a3.m >= 0) {
                            a(a3.m, a3);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.d >= 0) {
                    this.p = (Fragment) this.f.get(fragmentManagerState.d);
                }
                this.d = fragmentManagerState.e;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:215:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARNING: Missing block: B:80:0x01d1, code:
            d(r11);
     */
    /* JADX WARNING: Missing block: B:81:0x01d4, code:
            if (r12 <= 1) goto L_0x02cf;
     */
    /* JADX WARNING: Missing block: B:83:0x01d8, code:
            if (a == false) goto L_0x01f2;
     */
    /* JADX WARNING: Missing block: B:84:0x01da, code:
            android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Missing block: B:86:0x01f4, code:
            if (r11.w != false) goto L_0x02ba;
     */
    /* JADX WARNING: Missing block: B:88:0x01f8, code:
            if (r11.I == 0) goto L_0x04b0;
     */
    /* JADX WARNING: Missing block: B:90:0x01fd, code:
            if (r11.I != -1) goto L_0x0220;
     */
    /* JADX WARNING: Missing block: B:91:0x01ff, code:
            a(new java.lang.IllegalArgumentException("Cannot create fragment " + r11 + " for a container view with no id"));
     */
    /* JADX WARNING: Missing block: B:92:0x0220, code:
            r0 = (android.view.ViewGroup) r10.n.a(r11.I);
     */
    /* JADX WARNING: Missing block: B:93:0x022a, code:
            if (r0 != null) goto L_0x026f;
     */
    /* JADX WARNING: Missing block: B:95:0x022e, code:
            if (r11.y != false) goto L_0x026f;
     */
    /* JADX WARNING: Missing block: B:97:?, code:
            r1 = r11.k().getResourceName(r11.I);
     */
    /* JADX WARNING: Missing block: B:132:0x0333, code:
            r1 = "unknown";
     */
    /* JADX WARNING: Missing block: B:139:0x0348, code:
            if (r12 >= 1) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:141:0x034c, code:
            if (r10.u == false) goto L_0x035e;
     */
    /* JADX WARNING: Missing block: B:143:0x0352, code:
            if (r11.X() == null) goto L_0x045a;
     */
    /* JADX WARNING: Missing block: B:144:0x0354, code:
            r0 = r11.X();
            r11.a(null);
            r0.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:146:0x0362, code:
            if (r11.X() != null) goto L_0x036a;
     */
    /* JADX WARNING: Missing block: B:148:0x0368, code:
            if (r11.Y() == null) goto L_0x046c;
     */
    /* JADX WARNING: Missing block: B:149:0x036a, code:
            r11.c(r12);
            r12 = 1;
     */
    /* JADX WARNING: Missing block: B:156:0x0395, code:
            if (r12 >= 4) goto L_0x03b9;
     */
    /* JADX WARNING: Missing block: B:158:0x0399, code:
            if (a == false) goto L_0x03b3;
     */
    /* JADX WARNING: Missing block: B:159:0x039b, code:
            android.util.Log.v("FragmentManager", "movefrom STARTED: " + r11);
     */
    /* JADX WARNING: Missing block: B:160:0x03b3, code:
            r11.N();
            e(r11, false);
     */
    /* JADX WARNING: Missing block: B:161:0x03b9, code:
            if (r12 >= 3) goto L_0x03da;
     */
    /* JADX WARNING: Missing block: B:163:0x03bd, code:
            if (a == false) goto L_0x03d7;
     */
    /* JADX WARNING: Missing block: B:164:0x03bf, code:
            android.util.Log.v("FragmentManager", "movefrom STOPPED: " + r11);
     */
    /* JADX WARNING: Missing block: B:165:0x03d7, code:
            r11.O();
     */
    /* JADX WARNING: Missing block: B:167:0x03db, code:
            if (r12 >= 2) goto L_0x0348;
     */
    /* JADX WARNING: Missing block: B:169:0x03df, code:
            if (a == false) goto L_0x03f9;
     */
    /* JADX WARNING: Missing block: B:170:0x03e1, code:
            android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Missing block: B:172:0x03fb, code:
            if (r11.S == null) goto L_0x040c;
     */
    /* JADX WARNING: Missing block: B:174:0x0403, code:
            if (r10.m.a(r11) == false) goto L_0x040c;
     */
    /* JADX WARNING: Missing block: B:176:0x0407, code:
            if (r11.m != null) goto L_0x040c;
     */
    /* JADX WARNING: Missing block: B:177:0x0409, code:
            n(r11);
     */
    /* JADX WARNING: Missing block: B:178:0x040c, code:
            r11.P();
            f(r11, false);
     */
    /* JADX WARNING: Missing block: B:179:0x0414, code:
            if (r11.S == null) goto L_0x0450;
     */
    /* JADX WARNING: Missing block: B:181:0x0418, code:
            if (r11.R == null) goto L_0x0450;
     */
    /* JADX WARNING: Missing block: B:182:0x041a, code:
            r11.R.endViewTransition(r11.S);
            r11.S.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:183:0x0428, code:
            if (r10.l <= 0) goto L_0x04ae;
     */
    /* JADX WARNING: Missing block: B:185:0x042c, code:
            if (r10.u != false) goto L_0x04ae;
     */
    /* JADX WARNING: Missing block: B:187:0x0434, code:
            if (r11.S.getVisibility() != 0) goto L_0x04ae;
     */
    /* JADX WARNING: Missing block: B:189:0x043b, code:
            if (r11.aa < 0.0f) goto L_0x04ae;
     */
    /* JADX WARNING: Missing block: B:190:0x043d, code:
            r0 = a(r11, r13, false, r14);
     */
    /* JADX WARNING: Missing block: B:191:0x0441, code:
            r11.aa = 0.0f;
     */
    /* JADX WARNING: Missing block: B:192:0x0444, code:
            if (r0 == null) goto L_0x0449;
     */
    /* JADX WARNING: Missing block: B:193:0x0446, code:
            a(r11, r0, r12);
     */
    /* JADX WARNING: Missing block: B:194:0x0449, code:
            r11.R.removeView(r11.S);
     */
    /* JADX WARNING: Missing block: B:195:0x0450, code:
            r11.R = null;
            r11.S = null;
            r11.T = null;
            r11.x = false;
     */
    /* JADX WARNING: Missing block: B:197:0x045e, code:
            if (r11.Y() == null) goto L_0x035e;
     */
    /* JADX WARNING: Missing block: B:198:0x0460, code:
            r0 = r11.Y();
            r11.a(null);
            r0.cancel();
     */
    /* JADX WARNING: Missing block: B:200:0x046e, code:
            if (a == false) goto L_0x0488;
     */
    /* JADX WARNING: Missing block: B:201:0x0470, code:
            android.util.Log.v("FragmentManager", "movefrom CREATED: " + r11);
     */
    /* JADX WARNING: Missing block: B:203:0x048a, code:
            if (r11.N != false) goto L_0x04a3;
     */
    /* JADX WARNING: Missing block: B:204:0x048c, code:
            r11.Q();
            g(r11, false);
     */
    /* JADX WARNING: Missing block: B:205:0x0492, code:
            r11.R();
            h(r11, false);
     */
    /* JADX WARNING: Missing block: B:206:0x0498, code:
            if (r15 != false) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:208:0x049c, code:
            if (r11.N != false) goto L_0x04a6;
     */
    /* JADX WARNING: Missing block: B:209:0x049e, code:
            h(r11);
     */
    /* JADX WARNING: Missing block: B:210:0x04a3, code:
            r11.k = 0;
     */
    /* JADX WARNING: Missing block: B:211:0x04a6, code:
            r11.C = null;
            r11.G = null;
            r11.B = null;
     */
    /* JADX WARNING: Missing block: B:212:0x04ae, code:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:213:0x04b0, code:
            r0 = null;
     */
    void a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.u;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.L;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.v;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r11.k;
        if (r12 <= r0) goto L_0x0023;
    L_0x0018:
        r0 = r11.k;
        if (r0 != 0) goto L_0x003b;
    L_0x001c:
        r0 = r11.f();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r12 = r5;
    L_0x0023:
        r0 = r11.U;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r11.k;
        if (r0 >= r9) goto L_0x002e;
    L_0x002b:
        if (r12 <= r6) goto L_0x002e;
    L_0x002d:
        r12 = r6;
    L_0x002e:
        r0 = r11.k;
        if (r0 > r12) goto L_0x033d;
    L_0x0032:
        r0 = r11.w;
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r11.x;
        if (r0 != 0) goto L_0x003e;
    L_0x003a:
        return;
    L_0x003b:
        r12 = r11.k;
        goto L_0x0023;
    L_0x003e:
        r0 = r11.X();
        if (r0 != 0) goto L_0x004a;
    L_0x0044:
        r0 = r11.Y();
        if (r0 == 0) goto L_0x005a;
    L_0x004a:
        r11.a(r7);
        r11.a(r7);
        r2 = r11.Z();
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x005a:
        r0 = r11.k;
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01d1;
            case 2: goto L_0x02cf;
            case 3: goto L_0x02d4;
            case 4: goto L_0x02f8;
            default: goto L_0x005f;
        };
    L_0x005f:
        r0 = r11.k;
        if (r0 == r12) goto L_0x003a;
    L_0x0063:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.k = r12;
        goto L_0x003a;
    L_0x009a:
        if (r12 <= 0) goto L_0x01d1;
    L_0x009c:
        r0 = a;
        if (r0 == 0) goto L_0x00b8;
    L_0x00a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00b8:
        r0 = r11.l;
        if (r0 == 0) goto L_0x0104;
    L_0x00bc:
        r0 = r11.l;
        r1 = r10.m;
        r1 = r1.g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.l;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.m = r0;
        r0 = r11.l;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.r = r0;
        r0 = r11.r;
        if (r0 == 0) goto L_0x00ed;
    L_0x00e3:
        r0 = r11.l;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.t = r0;
    L_0x00ed:
        r0 = r11.n;
        if (r0 == 0) goto L_0x0153;
    L_0x00f1:
        r0 = r11.n;
        r0 = r0.booleanValue();
        r11.V = r0;
        r11.n = r7;
    L_0x00fb:
        r0 = r11.V;
        if (r0 != 0) goto L_0x0104;
    L_0x00ff:
        r11.U = r5;
        if (r12 <= r6) goto L_0x0104;
    L_0x0103:
        r12 = r6;
    L_0x0104:
        r0 = r10.m;
        r11.C = r0;
        r0 = r10.o;
        r11.G = r0;
        r0 = r10.o;
        if (r0 == 0) goto L_0x015e;
    L_0x0110:
        r0 = r10.o;
        r0 = r0.D;
    L_0x0114:
        r11.B = r0;
        r0 = r11.r;
        if (r0 == 0) goto L_0x0173;
    L_0x011a:
        r0 = r10.f;
        r1 = r11.r;
        r1 = r1.o;
        r0 = r0.get(r1);
        r1 = r11.r;
        if (r0 == r1) goto L_0x0165;
    L_0x0128:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " declared target fragment ";
        r1 = r1.append(r2);
        r2 = r11.r;
        r1 = r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0153:
        r0 = r11.l;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.V = r0;
        goto L_0x00fb;
    L_0x015e:
        r0 = r10.m;
        r0 = r0.i();
        goto L_0x0114;
    L_0x0165:
        r0 = r11.r;
        r0 = r0.k;
        if (r0 >= r5) goto L_0x0173;
    L_0x016b:
        r1 = r11.r;
        r0 = r10;
        r2 = r5;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0173:
        r0 = r10.m;
        r0 = r0.g();
        r10.a(r11, r0, r3);
        r11.Q = r3;
        r0 = r10.m;
        r0 = r0.g();
        r11.a(r0);
        r0 = r11.Q;
        if (r0 != 0) goto L_0x01aa;
    L_0x018b:
        r0 = new android.support.v4.app.av;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01aa:
        r0 = r11.G;
        if (r0 != 0) goto L_0x0322;
    L_0x01ae:
        r0 = r10.m;
        r0.b(r11);
    L_0x01b3:
        r0 = r10.m;
        r0 = r0.g();
        r10.b(r11, r0, r3);
        r0 = r11.ac;
        if (r0 != 0) goto L_0x0329;
    L_0x01c0:
        r0 = r11.l;
        r10.a(r11, r0, r3);
        r0 = r11.l;
        r11.l(r0);
        r0 = r11.l;
        r10.b(r11, r0, r3);
    L_0x01cf:
        r11.N = r3;
    L_0x01d1:
        r10.d(r11);
        if (r12 <= r5) goto L_0x02cf;
    L_0x01d6:
        r0 = a;
        if (r0 == 0) goto L_0x01f2;
    L_0x01da:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01f2:
        r0 = r11.w;
        if (r0 != 0) goto L_0x02ba;
    L_0x01f6:
        r0 = r11.I;
        if (r0 == 0) goto L_0x04b0;
    L_0x01fa:
        r0 = r11.I;
        r1 = -1;
        if (r0 != r1) goto L_0x0220;
    L_0x01ff:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.a(r0);
    L_0x0220:
        r0 = r10.n;
        r1 = r11.I;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x026f;
    L_0x022c:
        r1 = r11.y;
        if (r1 != 0) goto L_0x026f;
    L_0x0230:
        r1 = r11.k();	 Catch:{ NotFoundException -> 0x0332 }
        r2 = r11.I;	 Catch:{ NotFoundException -> 0x0332 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0332 }
    L_0x023a:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.I;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.a(r2);
    L_0x026f:
        r11.R = r0;
        r1 = r11.l;
        r1 = r11.h(r1);
        r2 = r11.l;
        r1 = r11.b(r1, r0, r2);
        r11.S = r1;
        r1 = r11.S;
        if (r1 == 0) goto L_0x0339;
    L_0x0283:
        r1 = r11.S;
        r11.T = r1;
        r1 = r11.S;
        r1.setSaveFromParentEnabled(r3);
        if (r0 == 0) goto L_0x0293;
    L_0x028e:
        r1 = r11.S;
        r0.addView(r1);
    L_0x0293:
        r0 = r11.K;
        if (r0 == 0) goto L_0x029e;
    L_0x0297:
        r0 = r11.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x029e:
        r0 = r11.S;
        r1 = r11.l;
        r11.a(r0, r1);
        r0 = r11.S;
        r1 = r11.l;
        r10.a(r11, r0, r1, r3);
        r0 = r11.S;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0337;
    L_0x02b4:
        r0 = r11.R;
        if (r0 == 0) goto L_0x0337;
    L_0x02b8:
        r11.Y = r5;
    L_0x02ba:
        r0 = r11.l;
        r11.m(r0);
        r0 = r11.l;
        r10.c(r11, r0, r3);
        r0 = r11.S;
        if (r0 == 0) goto L_0x02cd;
    L_0x02c8:
        r0 = r11.l;
        r11.f(r0);
    L_0x02cd:
        r11.l = r7;
    L_0x02cf:
        r0 = 2;
        if (r12 <= r0) goto L_0x02d4;
    L_0x02d2:
        r11.k = r6;
    L_0x02d4:
        if (r12 <= r6) goto L_0x02f8;
    L_0x02d6:
        r0 = a;
        if (r0 == 0) goto L_0x02f2;
    L_0x02da:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f2:
        r11.I();
        r10.b(r11, r3);
    L_0x02f8:
        if (r12 <= r9) goto L_0x005f;
    L_0x02fa:
        r0 = a;
        if (r0 == 0) goto L_0x0316;
    L_0x02fe:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0316:
        r11.J();
        r10.c(r11, r3);
        r11.l = r7;
        r11.m = r7;
        goto L_0x005f;
    L_0x0322:
        r0 = r11.G;
        r0.a(r11);
        goto L_0x01b3;
    L_0x0329:
        r0 = r11.l;
        r11.j(r0);
        r11.k = r5;
        goto L_0x01cf;
    L_0x0332:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x023a;
    L_0x0337:
        r5 = r3;
        goto L_0x02b8;
    L_0x0339:
        r11.T = r7;
        goto L_0x02ba;
    L_0x033d:
        r0 = r11.k;
        if (r0 <= r12) goto L_0x005f;
    L_0x0341:
        r0 = r11.k;
        switch(r0) {
            case 1: goto L_0x0348;
            case 2: goto L_0x03da;
            case 3: goto L_0x03b9;
            case 4: goto L_0x0395;
            case 5: goto L_0x0370;
            default: goto L_0x0346;
        };
    L_0x0346:
        goto L_0x005f;
    L_0x0348:
        if (r12 >= r5) goto L_0x005f;
    L_0x034a:
        r0 = r10.u;
        if (r0 == 0) goto L_0x035e;
    L_0x034e:
        r0 = r11.X();
        if (r0 == 0) goto L_0x045a;
    L_0x0354:
        r0 = r11.X();
        r11.a(r7);
        r0.clearAnimation();
    L_0x035e:
        r0 = r11.X();
        if (r0 != 0) goto L_0x036a;
    L_0x0364:
        r0 = r11.Y();
        if (r0 == 0) goto L_0x046c;
    L_0x036a:
        r11.c(r12);
        r12 = r5;
        goto L_0x005f;
    L_0x0370:
        r0 = 5;
        if (r12 >= r0) goto L_0x0395;
    L_0x0373:
        r0 = a;
        if (r0 == 0) goto L_0x038f;
    L_0x0377:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x038f:
        r11.M();
        r10.d(r11, r3);
    L_0x0395:
        if (r12 >= r9) goto L_0x03b9;
    L_0x0397:
        r0 = a;
        if (r0 == 0) goto L_0x03b3;
    L_0x039b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03b3:
        r11.N();
        r10.e(r11, r3);
    L_0x03b9:
        if (r12 >= r6) goto L_0x03da;
    L_0x03bb:
        r0 = a;
        if (r0 == 0) goto L_0x03d7;
    L_0x03bf:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03d7:
        r11.O();
    L_0x03da:
        r0 = 2;
        if (r12 >= r0) goto L_0x0348;
    L_0x03dd:
        r0 = a;
        if (r0 == 0) goto L_0x03f9;
    L_0x03e1:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03f9:
        r0 = r11.S;
        if (r0 == 0) goto L_0x040c;
    L_0x03fd:
        r0 = r10.m;
        r0 = r0.a(r11);
        if (r0 == 0) goto L_0x040c;
    L_0x0405:
        r0 = r11.m;
        if (r0 != 0) goto L_0x040c;
    L_0x0409:
        r10.n(r11);
    L_0x040c:
        r11.P();
        r10.f(r11, r3);
        r0 = r11.S;
        if (r0 == 0) goto L_0x0450;
    L_0x0416:
        r0 = r11.R;
        if (r0 == 0) goto L_0x0450;
    L_0x041a:
        r0 = r11.R;
        r1 = r11.S;
        r0.endViewTransition(r1);
        r0 = r11.S;
        r0.clearAnimation();
        r0 = r10.l;
        if (r0 <= 0) goto L_0x04ae;
    L_0x042a:
        r0 = r10.u;
        if (r0 != 0) goto L_0x04ae;
    L_0x042e:
        r0 = r11.S;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x04ae;
    L_0x0436:
        r0 = r11.aa;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x04ae;
    L_0x043d:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x0441:
        r1 = 0;
        r11.aa = r1;
        if (r0 == 0) goto L_0x0449;
    L_0x0446:
        r10.a(r11, r0, r12);
    L_0x0449:
        r0 = r11.R;
        r1 = r11.S;
        r0.removeView(r1);
    L_0x0450:
        r11.R = r7;
        r11.S = r7;
        r11.T = r7;
        r11.x = r3;
        goto L_0x0348;
    L_0x045a:
        r0 = r11.Y();
        if (r0 == 0) goto L_0x035e;
    L_0x0460:
        r0 = r11.Y();
        r11.a(r7);
        r0.cancel();
        goto L_0x035e;
    L_0x046c:
        r0 = a;
        if (r0 == 0) goto L_0x0488;
    L_0x0470:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0488:
        r0 = r11.N;
        if (r0 != 0) goto L_0x04a3;
    L_0x048c:
        r11.Q();
        r10.g(r11, r3);
    L_0x0492:
        r11.R();
        r10.h(r11, r3);
        if (r15 != 0) goto L_0x005f;
    L_0x049a:
        r0 = r11.N;
        if (r0 != 0) goto L_0x04a6;
    L_0x049e:
        r10.h(r11);
        goto L_0x005f;
    L_0x04a3:
        r11.k = r3;
        goto L_0x0492;
    L_0x04a6:
        r11.C = r7;
        r11.G = r7;
        r11.B = r7;
        goto L_0x005f;
    L_0x04ae:
        r0 = r7;
        goto L_0x0441;
    L_0x04b0:
        r0 = r7;
        goto L_0x026f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void a(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).a(fragment, context, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).a((FragmentManager) this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).a(fragment, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).a((FragmentManager) this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).a(fragment, view, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).a(this, fragment, view, bundle);
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        g(fragment);
        if (!fragment.L) {
            if (this.e.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            synchronized (this.e) {
                this.e.add(fragment);
            }
            fragment.u = true;
            fragment.v = false;
            if (fragment.S == null) {
                fragment.Z = false;
            }
            if (fragment.O && fragment.P) {
                this.r = true;
            }
            if (z) {
                c(fragment);
            }
        }
    }

    public void a(OpGenerator opGenerator, boolean z) {
        if (!z) {
            B();
        }
        synchronized (this) {
            if (!this.u && this.m != null) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                this.b.add(opGenerator);
                C();
            } else if (z) {
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(o oVar, m mVar, Fragment fragment) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = oVar;
        this.n = mVar;
        this.o = fragment;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        d dVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                fragment = (Fragment) this.e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.h != null) {
            size = this.h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    dVar = (d) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(dVar.toString());
                    dVar.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.i != null) {
                int size2 = this.i.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        dVar = (d) this.i.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(dVar);
                    }
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null) {
            i = this.b.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    OpGenerator opGenerator = (OpGenerator) this.b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.e.get(size);
            if (fragment != null) {
                fragment.i(z);
            }
        }
    }

    boolean a(int i) {
        return this.l >= i;
    }

    public boolean a(Menu menu) {
        boolean z = false;
        if (this.l < 1) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i >= this.e.size()) {
                return z2;
            }
            Fragment fragment = (Fragment) this.e.get(i);
            if (fragment != null && fragment.c(menu)) {
                int i2 = 1;
            }
            z = i + 1;
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.l < 1) {
            return false;
        }
        Fragment fragment;
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.e.size()) {
            boolean z2;
            fragment = (Fragment) this.e.get(i2);
            if (fragment == null || !fragment.b(menu, menuInflater)) {
                z2 = z;
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
            i2++;
            z = z2;
        }
        if (this.h != null) {
            while (i < this.h.size()) {
                fragment = (Fragment) this.h.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.x();
                }
                i++;
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = (Fragment) this.e.get(i);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<d> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.g == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                d dVar;
                size2 = this.g.size() - 1;
                while (size2 >= 0) {
                    dVar = (d) this.g.get(size2);
                    if ((str != null && str.equals(dVar.getName())) || (i >= 0 && i == dVar.m)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        dVar = (d) this.g.get(size2);
                        if ((str == null || !str.equals(dVar.getName())) && (i < 0 || i != dVar.m)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (size2 = this.g.size() - 1; size2 > size; size2--) {
                arrayList.add(this.g.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public Fragment b(int i) {
        int size;
        Fragment fragment;
        for (size = this.e.size() - 1; size >= 0; size--) {
            fragment = (Fragment) this.e.get(size);
            if (fragment != null && fragment.H == i) {
                return fragment;
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.valueAt(size);
                if (fragment != null && fragment.H == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.a(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    public void b(Fragment fragment) {
        if (!fragment.U) {
            return;
        }
        if (this.c) {
            this.w = true;
            return;
        }
        fragment.U = false;
        a(fragment, this.l, 0, 0, false);
    }

    void b(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).b(fragment, context, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).b((FragmentManager) this, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).b(fragment, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).b((FragmentManager) this, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).b(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).a(this, fragment);
            }
        }
    }

    public void b(OpGenerator opGenerator, boolean z) {
        if (!z || (this.m != null && !this.u)) {
            c(z);
            if (opGenerator.generateOps(this.x, this.y)) {
                this.c = true;
                try {
                    b(this.x, this.y);
                } finally {
                    D();
                }
            }
            j();
            G();
        }
    }

    void b(d dVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(dVar);
    }

    public void b(Menu menu) {
        if (this.l >= 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.e.size()) {
                    Fragment fragment = (Fragment) this.e.get(i2);
                    if (fragment != null) {
                        fragment.d(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.e.get(size);
            if (fragment != null) {
                fragment.j(z);
            }
        }
    }

    public boolean b() {
        boolean i = i();
        E();
        return i;
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = (Fragment) this.e.get(i);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        a(new w(this, null, -1, 0), false);
    }

    public void c(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void c(Fragment fragment) {
        a(fragment, this.l, 0, 0, false);
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).c(fragment, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).c(this, fragment, bundle);
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).c(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).b(this, fragment);
            }
        }
    }

    void d(Fragment fragment) {
        if (fragment.w && !fragment.z) {
            fragment.S = fragment.b(fragment.h(fragment.l), null, fragment.l);
            if (fragment.S != null) {
                fragment.T = fragment.S;
                fragment.S.setSaveFromParentEnabled(false);
                if (fragment.K) {
                    fragment.S.setVisibility(8);
                }
                fragment.a(fragment.S, fragment.l);
                a(fragment, fragment.S, fragment.l, false);
                return;
            }
            fragment.T = null;
        }
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).d(fragment, bundle, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).d(this, fragment, bundle);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).d(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).c(this, fragment);
            }
        }
    }

    public boolean d() {
        B();
        return a(null, -1, 0);
    }

    public int e() {
        return this.g != null ? this.g.size() : 0;
    }

    void e(final Fragment fragment) {
        if (fragment.S != null) {
            s a = a(fragment, fragment.T(), !fragment.K, fragment.U());
            if (a == null || a.b == null) {
                if (a != null) {
                    b(fragment.S, a);
                    fragment.S.startAnimation(a.a);
                    a.a.start();
                }
                int i = (!fragment.K || fragment.ab()) ? 0 : 8;
                fragment.S.setVisibility(i);
                if (fragment.ab()) {
                    fragment.k(false);
                }
            } else {
                a.b.setTarget(fragment.S);
                if (!fragment.K) {
                    fragment.S.setVisibility(0);
                } else if (fragment.ab()) {
                    fragment.k(false);
                } else {
                    final ViewGroup viewGroup = fragment.R;
                    final View view = fragment.S;
                    viewGroup.startViewTransition(view);
                    a.b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.S != null) {
                                fragment.S.setVisibility(8);
                            }
                        }
                    });
                }
                b(fragment.S, a);
                a.b.start();
            }
        }
        if (fragment.u && fragment.O && fragment.P) {
            this.r = true;
        }
        fragment.Z = false;
        fragment.c(fragment.K);
    }

    void e(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).e(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).d(this, fragment);
            }
        }
    }

    public List<Fragment> f() {
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Fragment> list;
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    void f(Fragment fragment) {
        if (fragment != null) {
            int i = this.l;
            if (fragment.v) {
                i = fragment.f() ? Math.min(i, 1) : Math.min(i, 0);
            }
            a(fragment, i, fragment.T(), fragment.U(), false);
            if (fragment.S != null) {
                Fragment q = q(fragment);
                if (q != null) {
                    View view = q.S;
                    ViewGroup viewGroup = fragment.R;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(fragment.S);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(fragment.S, indexOfChild);
                    }
                }
                if (fragment.Y && fragment.R != null) {
                    if (fragment.aa > 0.0f) {
                        fragment.S.setAlpha(fragment.aa);
                    }
                    fragment.aa = 0.0f;
                    fragment.Y = false;
                    s a = a(fragment, fragment.T(), true, fragment.U());
                    if (a != null) {
                        b(fragment.S, a);
                        if (a.a != null) {
                            fragment.S.startAnimation(a.a);
                        } else {
                            a.b.setTarget(fragment.S);
                            a.b.start();
                        }
                    }
                }
            }
            if (fragment.Z) {
                e(fragment);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).f(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).e(this, fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (fragment.o < 0) {
            int i = this.d;
            this.d = i + 1;
            fragment.a(i, this.o);
            if (this.f == null) {
                this.f = new SparseArray();
            }
            this.f.put(fragment.o, fragment);
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).g(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).f(this, fragment);
            }
        }
    }

    public boolean g() {
        return this.s || this.t;
    }

    void h() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    Fragment fragment = (Fragment) this.f.valueAt(i2);
                    if (fragment != null) {
                        b(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void h(Fragment fragment) {
        if (fragment.o >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f.put(fragment.o, null);
            fragment.w();
        }
    }

    void h(Fragment fragment, boolean z) {
        if (this.o != null) {
            FragmentManager l = this.o.l();
            if (l instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) l).h(fragment, true);
            }
        }
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z || ((Boolean) oVar.b).booleanValue()) {
                ((p) oVar.a).g(this, fragment);
            }
        }
    }

    public void i(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.A);
        }
        boolean z = !fragment.f();
        if (!fragment.L || z) {
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (fragment.O && fragment.P) {
                this.r = true;
            }
            fragment.u = false;
            fragment.v = true;
        }
    }

    public boolean i() {
        c(true);
        boolean z = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                D();
                z = true;
            } catch (Throwable th) {
                D();
                throw th;
            }
        }
        j();
        G();
        return z;
    }

    void j() {
        if (this.w) {
            this.w = false;
            h();
        }
    }

    public void j(Fragment fragment) {
        boolean z = true;
        if (a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.K) {
            fragment.K = true;
            if (fragment.Z) {
                z = false;
            }
            fragment.Z = z;
        }
    }

    void k() {
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.size()) {
                    ((OnBackStackChangedListener) this.k.get(i2)).onBackStackChanged();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void k(Fragment fragment) {
        boolean z = false;
        if (a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            if (!fragment.Z) {
                z = true;
            }
            fragment.Z = z;
        }
    }

    y l() {
        a(this.D);
        return this.D;
    }

    public void l(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.L) {
            fragment.L = true;
            if (fragment.u) {
                if (a) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                synchronized (this.e) {
                    this.e.remove(fragment);
                }
                if (fragment.O && fragment.P) {
                    this.r = true;
                }
                fragment.u = false;
            }
        }
    }

    void m() {
        List list;
        List list2;
        List list3;
        if (this.f != null) {
            int i = 0;
            list = null;
            list2 = null;
            list3 = null;
            while (i < this.f.size()) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Fragment fragment = (Fragment) this.f.valueAt(i);
                if (fragment != null) {
                    Object obj;
                    int i2;
                    if (fragment.M) {
                        if (list3 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        fragment.s = fragment.r != null ? fragment.r.o : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                        }
                    }
                    if (fragment.D != null) {
                        fragment.D.m();
                        obj = fragment.D.D;
                    } else {
                        y obj2 = fragment.E;
                    }
                    if (list2 == null && obj2 != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(obj2);
                    }
                    if (list == null && fragment.F != null) {
                        arrayList3 = new ArrayList(this.f.size());
                        for (i2 = 0; i2 < i; i2++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(fragment.F);
                    }
                }
                ArrayList arrayList4 = arrayList3;
                i++;
                Object list32 = arrayList;
                Object list22 = arrayList2;
                Object list4 = arrayList4;
            }
        } else {
            list4 = null;
            list22 = null;
            list32 = null;
        }
        if (list32 == null && list22 == null && list4 == null) {
            this.D = null;
        } else {
            this.D = new y(list32, list22, list4);
        }
    }

    public void m(Fragment fragment) {
        if (a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.L) {
            fragment.L = false;
            if (!fragment.u) {
                if (this.e.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.e) {
                    this.e.add(fragment);
                }
                fragment.u = true;
                if (fragment.O && fragment.P) {
                    this.r = true;
                }
            }
        }
    }

    Parcelable n() {
        BackStackState[] backStackStateArr = null;
        E();
        F();
        i();
        this.s = true;
        this.D = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f.valueAt(i);
            if (fragment != null) {
                if (fragment.o < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.o));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.k <= 0 || fragmentState.k != null) {
                    fragmentState.k = fragment.l;
                } else {
                    fragmentState.k = o(fragment);
                    if (fragment.r != null) {
                        if (fragment.r.o < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.r));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        a(fragmentState.k, "android:target_state", fragment.r);
                        if (fragment.t != 0) {
                            fragmentState.k.putInt("android:target_req_state", fragment.t);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            i = this.e.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((Fragment) this.e.get(i2)).o;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.e.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.e.get(i2));
                    }
                }
            } else {
                iArr = null;
            }
            if (this.g != null) {
                i = this.g.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((d) this.g.get(i2));
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.g.get(i2));
                        }
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            if (this.p != null) {
                fragmentManagerState.d = this.p.o;
            }
            fragmentManagerState.e = this.d;
            m();
            return fragmentManagerState;
        } else if (!a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void n(Fragment fragment) {
        if (fragment.T != null) {
            if (this.B == null) {
                this.B = new SparseArray();
            } else {
                this.B.clear();
            }
            fragment.T.saveHierarchyState(this.B);
            if (this.B.size() > 0) {
                fragment.m = this.B;
                this.B = null;
            }
        }
    }

    Bundle o(Fragment fragment) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        fragment.n(this.A);
        d(fragment, this.A, false);
        if (this.A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.A;
            this.A = null;
        }
        if (fragment.S != null) {
            n(fragment);
        }
        if (fragment.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.m);
        }
        if (!fragment.V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.V);
        }
        return bundle;
    }

    public void o() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) this.e.get(i);
            if (fragment != null) {
                fragment.K();
            }
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.a(this.m.g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment b = resourceId != -1 ? b(resourceId) : null;
        if (b == null && string2 != null) {
            b = a(string2);
        }
        if (b == null && id != -1) {
            b = b(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            Fragment a = this.n.a(context, string, null);
            a.w = true;
            a.H = resourceId != 0 ? resourceId : id;
            a.I = id;
            a.J = string2;
            a.x = true;
            a.B = this;
            a.C = this.m;
            a.a(this.m.g(), attributeSet, a.l);
            a(a, true);
            fragment = a;
        } else if (b.x) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.x = true;
            b.C = this.m;
            if (!b.N) {
                b.a(this.m.g(), attributeSet, b.l);
            }
            fragment = b;
        }
        if (this.l >= 1 || !fragment.w) {
            c(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.S.setId(resourceId);
        }
        if (fragment.S.getTag() == null) {
            fragment.S.setTag(string2);
        }
        return fragment.S;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void p() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void p(Fragment fragment) {
        if (fragment == null || (this.f.get(fragment.o) == fragment && (fragment.C == null || fragment.l() == this))) {
            this.p = fragment;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void q() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void r() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void s() {
        this.s = false;
        this.t = false;
        e(5);
    }

    public void t() {
        e(4);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.o != null) {
            d.a(this.o, stringBuilder);
        } else {
            d.a(this.m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        this.t = true;
        e(3);
    }

    public void v() {
        e(2);
    }

    public void w() {
        e(1);
    }

    public void x() {
        this.u = true;
        i();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void y() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                Fragment fragment = (Fragment) this.e.get(i2);
                if (fragment != null) {
                    fragment.L();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public Fragment z() {
        return this.p;
    }
}
