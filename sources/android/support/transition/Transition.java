package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.f;
import android.support.v4.util.a;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    private static final int[] g = new int[]{2, 1, 3, 4};
    private static final PathMotion h = new PathMotion() {
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<a<Animator, ag>> z = new ThreadLocal();
    private ViewGroup A = null;
    private ArrayList<Animator> B = new ArrayList();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<TransitionListener> F = null;
    private ArrayList<Animator> G = new ArrayList();
    private ah H;
    private a<String, String> I;
    private PathMotion J = h;
    long a = -1;
    ArrayList<Integer> b = new ArrayList();
    ArrayList<View> c = new ArrayList();
    TransitionSet d = null;
    boolean e = false;
    al f;
    private String i = getClass().getName();
    private long j = -1;
    private TimeInterpolator k = null;
    private ArrayList<String> l = null;
    private ArrayList<Class> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class> p = null;
    private ArrayList<String> q = null;
    private ArrayList<Integer> r = null;
    private ArrayList<View> s = null;
    private ArrayList<Class> t = null;
    private aq u = new aq();
    private aq v = new aq();
    private int[] w = g;
    private ArrayList<ap> x;
    private ArrayList<ap> y;

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.c);
        XmlPullParser xmlPullParser = (XmlResourceParser) attributeSet;
        long a = (long) f.a(obtainStyledAttributes, xmlPullParser, VastIconXmlManager.DURATION, 1, -1);
        if (a >= 0) {
            a(a);
        }
        a = (long) f.a(obtainStyledAttributes, xmlPullParser, "startDelay", 2, -1);
        if (a > 0) {
            b(a);
        }
        int c = f.c(obtainStyledAttributes, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            a(AnimationUtils.loadInterpolator(context, c));
        }
        String a2 = f.a(obtainStyledAttributes, xmlPullParser, "matchOrder", 3);
        if (a2 != null) {
            a(b(a2));
        }
        obtainStyledAttributes.recycle();
    }

    private void a(Animator animator, final a<Animator, ag> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    Transition.this.B.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.B.add(animator);
                }
            });
            a(animator);
        }
    }

    private void a(aq aqVar, aq aqVar2) {
        a aVar = new a(aqVar.a);
        a aVar2 = new a(aqVar2.a);
        for (int i : this.w) {
            switch (i) {
                case 1:
                    a(aVar, aVar2);
                    break;
                case 2:
                    a(aVar, aVar2, aqVar.d, aqVar2.d);
                    break;
                case 3:
                    a(aVar, aVar2, aqVar.b, aqVar2.b);
                    break;
                case 4:
                    a(aVar, aVar2, aqVar.c, aqVar2.c);
                    break;
                default:
                    break;
            }
        }
        b(aVar, aVar2);
    }

    private static void a(aq aqVar, View view, ap apVar) {
        aqVar.a.put(view, apVar);
        int id = view.getId();
        if (id >= 0) {
            if (aqVar.b.indexOfKey(id) >= 0) {
                aqVar.b.put(id, null);
            } else {
                aqVar.b.put(id, view);
            }
        }
        String o = ViewCompat.o(view);
        if (o != null) {
            if (aqVar.d.containsKey(o)) {
                aqVar.d.put(o, null);
            } else {
                aqVar.d.put(o, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (aqVar.c.c(itemIdAtPosition) >= 0) {
                    View view2 = (View) aqVar.c.a(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.a(view2, false);
                        aqVar.c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.a(view, true);
                aqVar.c.b(itemIdAtPosition, view);
            }
        }
    }

    private void a(a<View, ap> aVar, a<View, ap> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.b(size);
            if (view != null && b(view)) {
                ap apVar = (ap) aVar2.remove(view);
                if (!(apVar == null || apVar.b == null || !b(apVar.b))) {
                    this.x.add((ap) aVar.d(size));
                    this.y.add(apVar);
                }
            }
        }
    }

    private void a(a<View, ap> aVar, a<View, ap> aVar2, a<String, View> aVar3, a<String, View> aVar4) {
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar3.c(i);
            if (view != null && b(view)) {
                View view2 = (View) aVar4.get(aVar3.b(i));
                if (view2 != null && b(view2)) {
                    ap apVar = (ap) aVar.get(view);
                    ap apVar2 = (ap) aVar2.get(view2);
                    if (!(apVar == null || apVar2 == null)) {
                        this.x.add(apVar);
                        this.y.add(apVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void a(a<View, ap> aVar, a<View, ap> aVar2, android.support.v4.util.f<View> fVar, android.support.v4.util.f<View> fVar2) {
        int b = fVar.b();
        for (int i = 0; i < b; i++) {
            View view = (View) fVar.c(i);
            if (view != null && b(view)) {
                View view2 = (View) fVar2.a(fVar.b(i));
                if (view2 != null && b(view2)) {
                    ap apVar = (ap) aVar.get(view);
                    ap apVar2 = (ap) aVar2.get(view2);
                    if (!(apVar == null || apVar2 == null)) {
                        this.x.add(apVar);
                        this.y.add(apVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void a(a<View, ap> aVar, a<View, ap> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null && b(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && b(view2)) {
                    ap apVar = (ap) aVar.get(view);
                    ap apVar2 = (ap) aVar2.get(view2);
                    if (!(apVar == null || apVar2 == null)) {
                        this.x.add(apVar);
                        this.y.add(apVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private static boolean a(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean a(ap apVar, ap apVar2, String str) {
        Object obj = apVar.a.get(str);
        Object obj2 = apVar2.a.get(str);
        return (obj == null && obj2 == null) ? false : obj == null || obj2 == null || !obj.equals(obj2);
    }

    private static boolean a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void b(a<View, ap> aVar, a<View, ap> aVar2) {
        ap apVar;
        int i = 0;
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            apVar = (ap) aVar.c(i2);
            if (b(apVar.b)) {
                this.x.add(apVar);
                this.y.add(null);
            }
        }
        while (i < aVar2.size()) {
            apVar = (ap) aVar2.c(i);
            if (b(apVar.b)) {
                this.y.add(apVar);
                this.x.add(null);
            }
            i++;
        }
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Object obj = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                obj[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                obj[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                obj[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                obj[i] = 4;
            } else if (trim.isEmpty()) {
                Object obj2 = new int[(obj.length - 1)];
                System.arraycopy(obj, 0, obj2, 0, i);
                i--;
                obj = obj2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return obj;
    }

    private void c(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.n != null && this.n.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.o == null || !this.o.contains(view)) {
                int i;
                if (this.p != null) {
                    int size = this.p.size();
                    i = 0;
                    while (i < size) {
                        if (!((Class) this.p.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ap apVar = new ap();
                    apVar.b = view;
                    if (z) {
                        a(apVar);
                    } else {
                        b(apVar);
                    }
                    apVar.c.add(this);
                    c(apVar);
                    if (z) {
                        a(this.u, view, apVar);
                    } else {
                        a(this.v, view, apVar);
                    }
                }
                if (!(view instanceof ViewGroup)) {
                    return;
                }
                if (this.r != null && this.r.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.s == null || !this.s.contains(view)) {
                    if (this.t != null) {
                        id = this.t.size();
                        i = 0;
                        while (i < id) {
                            if (!((Class) this.t.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        c(viewGroup.getChildAt(i2), z);
                    }
                }
            }
        }
    }

    private static a<Animator, ag> p() {
        a<Animator, ag> aVar = (a) z.get();
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        z.set(aVar);
        return aVar;
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @Nullable ap apVar, @Nullable ap apVar2) {
        return null;
    }

    @NonNull
    public Transition a(long j) {
        this.a = j;
        return this;
    }

    @NonNull
    public Transition a(@Nullable TimeInterpolator timeInterpolator) {
        this.k = timeInterpolator;
        return this;
    }

    @NonNull
    public Transition a(@NonNull TransitionListener transitionListener) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        this.F.add(transitionListener);
        return this;
    }

    @Nullable
    public ap a(@NonNull View view, boolean z) {
        if (this.d != null) {
            return this.d.a(view, z);
        }
        return (ap) (z ? this.u : this.v).a.get(view);
    }

    String a(String str) {
        int i = 0;
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.a != -1) {
            str2 = str2 + "dur(" + this.a + ") ";
        }
        if (this.j != -1) {
            str2 = str2 + "dly(" + this.j + ") ";
        }
        if (this.k != null) {
            str2 = str2 + "interp(" + this.k + ") ";
        }
        if (this.b.size() <= 0 && this.c.size() <= 0) {
            return str2;
        }
        String str3;
        str2 = str2 + "tgts(";
        if (this.b.size() > 0) {
            str3 = str2;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.b.get(i2);
            }
        } else {
            str3 = str2;
        }
        if (this.c.size() > 0) {
            while (i < this.c.size()) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.c.get(i);
                i++;
            }
        }
        return str3 + ")";
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.k();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    public void a(@Nullable ah ahVar) {
        this.H = ahVar;
    }

    public void a(@Nullable al alVar) {
        this.f = alVar;
    }

    public abstract void a(@NonNull ap apVar);

    void a(ViewGroup viewGroup) {
        this.x = new ArrayList();
        this.y = new ArrayList();
        a(this.u, this.v);
        a p = p();
        int size = p.size();
        WindowIdImpl b = bb.b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) p.b(i);
            if (animator != null) {
                ag agVar = (ag) p.get(animator);
                if (!(agVar == null || agVar.a == null || !b.equals(agVar.d))) {
                    ap apVar = agVar.c;
                    View view = agVar.a;
                    ap a = a(view, true);
                    ap b2 = b(view, true);
                    boolean z = !(a == null && b2 == null) && agVar.e.a(apVar, b2);
                    if (z) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            p.remove(animator);
                        }
                    }
                }
            }
        }
        a(viewGroup, this.u, this.v, this.x, this.y);
        e();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void a(ViewGroup viewGroup, aq aqVar, aq aqVar2, ArrayList<ap> arrayList, ArrayList<ap> arrayList2) {
        int i;
        a p = p();
        long j = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            ap apVar = (ap) arrayList.get(i3);
            ap apVar2 = (ap) arrayList2.get(i3);
            ap apVar3 = (apVar == null || apVar.c.contains(this)) ? apVar : null;
            ap apVar4 = (apVar2 == null || apVar2.c.contains(this)) ? apVar2 : null;
            if (apVar3 != null || apVar4 != null) {
                Object obj = (apVar3 == null || apVar4 == null || a(apVar3, apVar4)) ? 1 : null;
                if (obj != null) {
                    Animator a = a(viewGroup, apVar3, apVar4);
                    if (a != null) {
                        ap apVar5;
                        Object obj2;
                        View view;
                        apVar = null;
                        if (apVar4 != null) {
                            Object obj3;
                            View view2 = apVar4.b;
                            String[] a2 = a();
                            Animator obj32;
                            if (view2 == null || a2 == null || a2.length <= 0) {
                                obj32 = a;
                            } else {
                                ap apVar6 = new ap();
                                apVar6.b = view2;
                                apVar = (ap) aqVar2.a.get(view2);
                                if (apVar != null) {
                                    for (i = 0; i < a2.length; i++) {
                                        apVar6.a.put(a2[i], apVar.a.get(a2[i]));
                                    }
                                }
                                int size2 = p.size();
                                for (i = 0; i < size2; i++) {
                                    ag agVar = (ag) p.get((Animator) p.b(i));
                                    if (agVar.c != null && agVar.a == view2 && agVar.b.equals(o()) && agVar.c.equals(apVar6)) {
                                        obj32 = null;
                                        apVar = apVar6;
                                        break;
                                    }
                                }
                                apVar = apVar6;
                                obj32 = a;
                            }
                            apVar5 = apVar;
                            obj2 = obj32;
                            view = view2;
                        } else {
                            view = apVar3.b;
                            apVar5 = null;
                            Animator obj22 = a;
                        }
                        if (obj22 != null) {
                            if (this.f != null) {
                                long a3 = this.f.a(viewGroup, this, apVar3, apVar4);
                                sparseIntArray.put(this.G.size(), (int) a3);
                                j = Math.min(a3, j);
                            }
                            p.put(obj22, new ag(view, o(), this, bb.b(viewGroup), apVar5));
                            this.G.add(obj22);
                        }
                    }
                }
            }
            i2 = i3 + 1;
        }
        if (j != 0) {
            i2 = 0;
            while (true) {
                i = i2;
                if (i < sparseIntArray.size()) {
                    Animator animator = (Animator) this.G.get(sparseIntArray.keyAt(i));
                    animator.setStartDelay((((long) sparseIntArray.valueAt(i)) - j) + animator.getStartDelay());
                    i2 = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    void a(ViewGroup viewGroup, boolean z) {
        int i;
        View findViewById;
        int i2 = 0;
        b(z);
        if ((this.b.size() > 0 || this.c.size() > 0) && ((this.l == null || this.l.isEmpty()) && (this.m == null || this.m.isEmpty()))) {
            ap apVar;
            for (i = 0; i < this.b.size(); i++) {
                findViewById = viewGroup.findViewById(((Integer) this.b.get(i)).intValue());
                if (findViewById != null) {
                    apVar = new ap();
                    apVar.b = findViewById;
                    if (z) {
                        a(apVar);
                    } else {
                        b(apVar);
                    }
                    apVar.c.add(this);
                    c(apVar);
                    if (z) {
                        a(this.u, findViewById, apVar);
                    } else {
                        a(this.v, findViewById, apVar);
                    }
                }
            }
            for (i = 0; i < this.c.size(); i++) {
                findViewById = (View) this.c.get(i);
                apVar = new ap();
                apVar.b = findViewById;
                if (z) {
                    a(apVar);
                } else {
                    b(apVar);
                }
                apVar.c.add(this);
                c(apVar);
                if (z) {
                    a(this.u, findViewById, apVar);
                } else {
                    a(this.v, findViewById, apVar);
                }
            }
        } else {
            c(viewGroup, z);
        }
        if (!z && this.I != null) {
            int size = this.I.size();
            ArrayList arrayList = new ArrayList(size);
            for (i = 0; i < size; i++) {
                arrayList.add(this.u.d.remove((String) this.I.b(i)));
            }
            while (i2 < size) {
                findViewById = (View) arrayList.get(i2);
                if (findViewById != null) {
                    this.u.d.put((String) this.I.c(i2), findViewById);
                }
                i2++;
            }
        }
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.w = g;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!a(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (a(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            } else {
                i++;
            }
        }
        this.w = (int[]) iArr.clone();
    }

    public boolean a(@Nullable ap apVar, @Nullable ap apVar2) {
        if (apVar == null || apVar2 == null) {
            return false;
        }
        String[] a = a();
        if (a != null) {
            boolean z;
            for (String a2 : a) {
                if (a(apVar, apVar2, a2)) {
                    z = true;
                    break;
                }
            }
            z = false;
            return z;
        }
        for (String a3 : apVar.a.keySet()) {
            if (a(apVar, apVar2, a3)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String[] a() {
        return null;
    }

    public long b() {
        return this.a;
    }

    @NonNull
    public Transition b(long j) {
        this.j = j;
        return this;
    }

    @NonNull
    public Transition b(@NonNull TransitionListener transitionListener) {
        if (this.F != null) {
            this.F.remove(transitionListener);
            if (this.F.size() == 0) {
                this.F = null;
            }
        }
        return this;
    }

    ap b(View view, boolean z) {
        if (this.d != null) {
            return this.d.b(view, z);
        }
        ArrayList arrayList = z ? this.x : this.y;
        if (arrayList == null) {
            return null;
        }
        ap apVar;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            apVar = (ap) arrayList.get(i);
            if (apVar == null) {
                return null;
            }
            if (apVar.b == view) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            apVar = (ap) (z ? this.y : this.x).get(i);
        } else {
            apVar = null;
        }
        return apVar;
    }

    public abstract void b(@NonNull ap apVar);

    void b(boolean z) {
        if (z) {
            this.u.a.clear();
            this.u.b.clear();
            this.u.c.c();
            return;
        }
        this.v.a.clear();
        this.v.b.clear();
        this.v.c.c();
    }

    boolean b(View view) {
        int id = view.getId();
        if (this.n != null && this.n.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.o != null && this.o.contains(view)) {
            return false;
        }
        int i;
        if (this.p != null) {
            int size = this.p.size();
            for (i = 0; i < size; i++) {
                if (((Class) this.p.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.q != null && ViewCompat.o(view) != null && this.q.contains(ViewCompat.o(view))) {
            return false;
        }
        if (this.b.size() == 0 && this.c.size() == 0 && ((this.m == null || this.m.isEmpty()) && (this.l == null || this.l.isEmpty()))) {
            return true;
        }
        if (this.b.contains(Integer.valueOf(id)) || this.c.contains(view)) {
            return true;
        }
        if (this.l != null && this.l.contains(ViewCompat.o(view))) {
            return true;
        }
        if (this.m == null) {
            return false;
        }
        for (i = 0; i < this.m.size(); i++) {
            if (((Class) this.m.get(i)).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public long c() {
        return this.j;
    }

    @NonNull
    public Transition c(@NonNull View view) {
        this.c.add(view);
        return this;
    }

    void c(ap apVar) {
        Object obj = null;
        if (this.f != null && !apVar.a.isEmpty()) {
            String[] a = this.f.a();
            if (a != null) {
                for (Object containsKey : a) {
                    if (!apVar.a.containsKey(containsKey)) {
                        break;
                    }
                }
                int obj2 = 1;
                if (obj2 == null) {
                    this.f.a(apVar);
                }
            }
        }
    }

    @Nullable
    public TimeInterpolator d() {
        return this.k;
    }

    @NonNull
    public Transition d(@NonNull View view) {
        this.c.remove(view);
        return this;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void e() {
        j();
        a p = p();
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (p.containsKey(animator)) {
                j();
                a(animator, p);
            }
        }
        this.G.clear();
        k();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void e(View view) {
        if (!this.E) {
            a p = p();
            int size = p.size();
            WindowIdImpl b = bb.b(view);
            for (int i = size - 1; i >= 0; i--) {
                ag agVar = (ag) p.c(i);
                if (agVar.a != null && b.equals(agVar.d)) {
                    a.a((Animator) p.b(i));
                }
            }
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
                }
            }
            this.D = true;
        }
    }

    @NonNull
    public List<Integer> f() {
        return this.b;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void f(View view) {
        if (this.D) {
            if (!this.E) {
                a p = p();
                int size = p.size();
                WindowIdImpl b = bb.b(view);
                for (int i = size - 1; i >= 0; i--) {
                    ag agVar = (ag) p.c(i);
                    if (agVar.a != null && b.equals(agVar.d)) {
                        a.b((Animator) p.b(i));
                    }
                }
                if (this.F != null && this.F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.F.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.D = false;
        }
    }

    @NonNull
    public List<View> g() {
        return this.c;
    }

    @Nullable
    public List<String> h() {
        return this.l;
    }

    @Nullable
    public List<Class> i() {
        return this.m;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void j() {
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void k() {
        this.C--;
        if (this.C == 0) {
            int i;
            View view;
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionEnd(this);
                }
            }
            for (i = 0; i < this.u.c.b(); i++) {
                view = (View) this.u.c.c(i);
                if (view != null) {
                    ViewCompat.a(view, false);
                }
            }
            for (i = 0; i < this.v.c.b(); i++) {
                view = (View) this.v.c.c(i);
                if (view != null) {
                    ViewCompat.a(view, false);
                }
            }
            this.E = true;
        }
    }

    @NonNull
    public PathMotion l() {
        return this.J;
    }

    @Nullable
    public Rect m() {
        return this.H == null ? null : this.H.a(this);
    }

    /* renamed from: n */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.G = new ArrayList();
            transition.u = new aq();
            transition.v = new aq();
            transition.x = null;
            transition.y = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @NonNull
    public String o() {
        return this.i;
    }

    public String toString() {
        return a("");
    }
}
