package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.e;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    ba g = new az();
    final Rect h = new Rect();

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        int a = -1;
        int b = 0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(LayoutManager.a(context, attributeSet, i, i2).b);
    }

    private void L() {
        this.e.clear();
        this.f.clear();
    }

    private void M() {
        int w = w();
        for (int i = 0; i < w; i++) {
            LayoutParams layoutParams = (LayoutParams) h(i).getLayoutParams();
            int f = layoutParams.f();
            this.e.put(f, layoutParams.b());
            this.f.put(f, layoutParams.a());
        }
    }

    private void N() {
        l(h() == 1 ? (z() - D()) - B() : (A() - E()) - C());
    }

    private void O() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    private int a(bz bzVar, State state, int i) {
        if (!state.a()) {
            return this.g.c(i, this.b);
        }
        int b = bzVar.b(i);
        if (b != -1) {
            return this.g.c(b, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(float f, int i) {
        l(Math.max(Math.round(((float) this.b) * f), i));
    }

    private void a(bz bzVar, State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = i - 1;
            i = -1;
            i4 = i3;
            i3 = -1;
        }
        int i5 = 0;
        for (int i6 = i4; i6 != i; i6 += i3) {
            View view = this.d[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.b = c(bzVar, state, d(view));
            layoutParams.a = i5;
            i5 += layoutParams.b;
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? a(view, i, i2, layoutParams) : b(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int a;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.d;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = layoutParams.rightMargin + ((rect.right + rect.left) + layoutParams.leftMargin);
        int a2 = a(layoutParams.a, layoutParams.b);
        if (this.i == 1) {
            a2 = LayoutManager.a(a2, i, i3, layoutParams.width, false);
            a = LayoutManager.a(this.j.f(), y(), i2, layoutParams.height, true);
        } else {
            int a3 = LayoutManager.a(a2, i, i2, layoutParams.height, false);
            a2 = LayoutManager.a(this.j.f(), x(), i3, layoutParams.width, true);
            a = a3;
        }
        a(view, a2, a, z);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int b(bz bzVar, State state, int i) {
        if (!state.a()) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = bzVar.b(i);
        if (i2 != -1) {
            return this.g.b(i2, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void b(bz bzVar, State state, bc bcVar, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = b(bzVar, state, bcVar.b);
        if (obj != null) {
            while (b > 0 && bcVar.b > 0) {
                bcVar.b--;
                b = b(bzVar, state, bcVar.b);
            }
            return;
        }
        int e = state.e() - 1;
        int i2 = bcVar.b;
        int i3 = b;
        while (i2 < e) {
            b = b(bzVar, state, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        bcVar.b = i2;
    }

    private int c(bz bzVar, State state, int i) {
        if (!state.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = bzVar.b(i);
        if (i2 != -1) {
            return this.g.a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void l(int i) {
        this.c = a(this.c, this.b, i);
    }

    int a(int i, int i2) {
        return (this.i == 1 && i()) ? this.c[this.b - i] - this.c[(this.b - i) - i2] : this.c[i + i2] - this.c[i];
    }

    public int a(int i, bz bzVar, State state) {
        N();
        O();
        return super.a(i, bzVar, state);
    }

    public int a(bz bzVar, State state) {
        return this.i == 0 ? this.b : state.e() < 1 ? 0 : a(bzVar, state, state.e() - 1) + 1;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a() {
        return this.i == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    View a(bz bzVar, State state, int i, int i2, int i3) {
        View view = null;
        j();
        int c = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = h(i);
            int d2 = d(h);
            if (d2 >= 0 && d2 < i3) {
                if (b(bzVar, state, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((android.support.v7.widget.RecyclerView.LayoutParams) h.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.a(h) < d && this.j.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View a(View view, int i, bz bzVar, State state) {
        View e = e(view);
        if (e == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
        int i2 = layoutParams.a;
        int i3 = layoutParams.a + layoutParams.b;
        if (super.a(view, i, bzVar, state) == null) {
            return null;
        }
        int w;
        int i4;
        int i5;
        if (((e(i) == 1) != this.k ? 1 : null) != null) {
            w = w() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            w = 0;
            i4 = 1;
            i5 = w();
        }
        Object obj = (this.i == 1 && i()) ? 1 : null;
        View view2 = null;
        int i6 = -1;
        int i7 = 0;
        View view3 = null;
        int i8 = -1;
        int i9 = 0;
        int a = a(bzVar, state, w);
        while (true) {
            int i10 = w;
            if (i10 == i5) {
                break;
            }
            w = a(bzVar, state, i10);
            View h = h(i10);
            if (h == e) {
                break;
            }
            View view4;
            int min;
            View view5;
            int i11;
            if (h.hasFocusable() && w != a) {
                if (view2 != null) {
                    break;
                }
            }
            layoutParams = (LayoutParams) h.getLayoutParams();
            int i12 = layoutParams.a;
            int i13 = layoutParams.a + layoutParams.b;
            if (h.hasFocusable() && i12 == i2 && i13 == i3) {
                return h;
            }
            Object obj2 = null;
            if (!(h.hasFocusable() && view2 == null) && (h.hasFocusable() || view3 != null)) {
                int min2 = Math.min(i13, i3) - Math.max(i12, i2);
                if (h.hasFocusable()) {
                    if (min2 > i7) {
                        obj2 = 1;
                    } else if (min2 == i7) {
                        if (obj == (i12 > i6 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                } else if (view2 == null && a(h, false, true)) {
                    if (min2 > i9) {
                        obj2 = 1;
                    } else if (min2 == i9) {
                        if (obj == (i12 > i8 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (h.hasFocusable()) {
                    i7 = layoutParams.a;
                    int i14 = i9;
                    i9 = i8;
                    view4 = view3;
                    min = Math.min(i13, i3) - Math.max(i12, i2);
                    w = i14;
                    int i15 = i7;
                    view5 = h;
                    i11 = i15;
                } else {
                    i9 = layoutParams.a;
                    w = Math.min(i13, i3) - Math.max(i12, i2);
                    view4 = h;
                    min = i7;
                    i11 = i6;
                    view5 = view2;
                }
                i10 += i4;
                view2 = view5;
                i7 = min;
                i6 = i11;
                view3 = view4;
                i8 = i9;
            }
            w = i9;
            i11 = i6;
            i9 = i8;
            view4 = view3;
            min = i7;
            view5 = view2;
            i10 += i4;
            view2 = view5;
            i7 = min;
            i6 = i11;
            view3 = view4;
            i8 = i9;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    public void a(int i) {
        if (i != this.b) {
            this.a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.b = i;
            this.g.a();
            p();
        }
    }

    public void a(Rect rect, int i, int i2) {
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int D = D() + B();
        int C = C() + E();
        if (this.i == 1) {
            C = LayoutManager.a(i2, C + rect.height(), H());
            D = LayoutManager.a(i, D + this.c[this.c.length - 1], G());
        } else {
            D = LayoutManager.a(i, D + rect.width(), G());
            C = LayoutManager.a(i2, C + this.c[this.c.length - 1], H());
        }
        g(D, C);
    }

    public void a(State state) {
        super.a(state);
        this.a = false;
    }

    void a(State state, be beVar, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && beVar.a(state) && i > 0; i2++) {
            int i3 = beVar.d;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, beVar.g));
            i -= this.g.a(i3);
            beVar.d += beVar.e;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    void a(bz bzVar, State state, bc bcVar, int i) {
        super.a(bzVar, state, bcVar, i);
        N();
        if (state.e() > 0 && !state.a()) {
            b(bzVar, state, bcVar, i);
        }
        O();
    }

    void a(bz bzVar, State state, be beVar, bd bdVar) {
        int i;
        int c;
        int i2 = this.j.i();
        Object obj = i2 != 1073741824 ? 1 : null;
        int i3 = w() > 0 ? this.c[this.b] : 0;
        if (obj != null) {
            N();
        }
        boolean z = beVar.e == 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = this.b;
        if (!z) {
            i6 = b(bzVar, state, beVar.d) + c(bzVar, state, beVar.d);
        }
        while (i4 < this.b && beVar.a(state) && i6 > 0) {
            i = beVar.d;
            c = c(bzVar, state, i);
            if (c <= this.b) {
                i6 -= c;
                if (i6 >= 0) {
                    View a = beVar.a(bzVar);
                    if (a == null) {
                        break;
                    }
                    i5 += c;
                    this.d[i4] = a;
                    i4++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i + " requires " + c + " spans but GridLayoutManager has only " + this.b + " spans.");
        }
        if (i4 == 0) {
            bdVar.b = true;
            return;
        }
        View view;
        LayoutParams layoutParams;
        int i7;
        int a2;
        a(bzVar, state, i4, i5, z);
        i5 = 0;
        float f = 0.0f;
        i = 0;
        while (i5 < i4) {
            View view2 = this.d[i5];
            if (beVar.k == null) {
                if (z) {
                    b(view2);
                } else {
                    b(view2, 0);
                }
            } else if (z) {
                a(view2);
            } else {
                a(view2, 0);
            }
            b(view2, this.h);
            a(view2, i2, false);
            i6 = this.j.e(view2);
            if (i6 > i) {
                i = i6;
            }
            float f2 = (((float) this.j.f(view2)) * 1.0f) / ((float) ((LayoutParams) view2.getLayoutParams()).b);
            if (f2 <= f) {
                f2 = f;
            }
            i5++;
            f = f2;
        }
        if (obj != null) {
            a(f, i3);
            i = 0;
            c = 0;
            while (c < i4) {
                View view3 = this.d[c];
                a(view3, 1073741824, true);
                i6 = this.j.e(view3);
                if (i6 <= i) {
                    i6 = i;
                }
                c++;
                i = i6;
            }
        }
        for (i5 = 0; i5 < i4; i5++) {
            view = this.d[i5];
            if (this.j.e(view) != i) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                Rect rect = layoutParams.d;
                i7 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                c = ((rect.right + rect.left) + layoutParams.leftMargin) + layoutParams.rightMargin;
                a2 = a(layoutParams.a, layoutParams.b);
                if (this.i == 1) {
                    c = LayoutManager.a(a2, 1073741824, c, layoutParams.width, false);
                    i6 = MeasureSpec.makeMeasureSpec(i - i7, 1073741824);
                } else {
                    c = MeasureSpec.makeMeasureSpec(i - c, 1073741824);
                    i6 = LayoutManager.a(a2, 1073741824, i7, layoutParams.height, false);
                }
                a(view, c, i6, true);
            }
        }
        bdVar.a = i;
        i6 = 0;
        if (this.i == 1) {
            if (beVar.f == -1) {
                i6 = beVar.b;
                i = i6 - i;
                c = 0;
                i5 = 0;
            } else {
                c = beVar.b;
                i6 = c + i;
                i = c;
                c = 0;
                i5 = 0;
            }
        } else if (beVar.f == -1) {
            i5 = beVar.b;
            c = i5;
            i5 -= i;
            i = 0;
        } else {
            i5 = beVar.b;
            c = i + i5;
            i = 0;
        }
        i3 = i6;
        a2 = i;
        int i8 = c;
        i7 = i5;
        for (i = 0; i < i4; i++) {
            view = this.d[i];
            layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.i != 1) {
                a2 = C() + this.c[layoutParams.a];
                i3 = a2 + this.j.f(view);
            } else if (i()) {
                i8 = B() + this.c[this.b - layoutParams.a];
                i7 = i8 - this.j.f(view);
            } else {
                i7 = B() + this.c[layoutParams.a];
                i8 = i7 + this.j.f(view);
            }
            a(view, i7, a2, i8, i3);
            if (layoutParams.d() || layoutParams.e()) {
                bdVar.c = true;
            }
            bdVar.d |= view.hasFocusable();
        }
        Arrays.fill(this.d, null);
    }

    public void a(bz bzVar, State state, View view, b bVar) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(bzVar, state, layoutParams2.f());
            if (this.i == 0) {
                int a2 = layoutParams2.a();
                int b = layoutParams2.b();
                boolean z = this.b > 1 && layoutParams2.b() == this.b;
                bVar.b(e.a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = layoutParams2.a();
            int b2 = layoutParams2.b();
            boolean z2 = this.b > 1 && layoutParams2.b() == this.b;
            bVar.b(e.a(a, 1, a3, b2, z2, false));
            return;
        }
        super.a(view, bVar);
    }

    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int b(int i, bz bzVar, State state) {
        N();
        O();
        return super.b(i, bzVar, state);
    }

    public int b(bz bzVar, State state) {
        return this.i == 1 ? this.b : state.e() < 1 ? 0 : a(bzVar, state, state.e() - 1) + 1;
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    public boolean b() {
        return this.n == null && !this.a;
    }

    public void c(bz bzVar, State state) {
        if (state.a()) {
            M();
        }
        super.c(bzVar, state);
        L();
    }
}
