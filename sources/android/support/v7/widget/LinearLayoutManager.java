package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends LayoutManager implements ScrollVectorProvider, ViewDropHandler {
    private be a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final bd g;
    private int h;
    int i;
    bn j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final bc o;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        boolean c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new bc();
        this.g = new bd();
        this.h = 2;
        b(i);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = 1;
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new bc();
        this.g = new bd();
        this.h = 2;
        bu a = LayoutManager.a(context, attributeSet, i, i2);
        b(a.a);
        b(a.c);
        a(a.d);
    }

    private void L() {
        boolean z = true;
        if (this.i == 1 || !i()) {
            this.k = this.c;
            return;
        }
        if (this.c) {
            z = false;
        }
        this.k = z;
    }

    private View M() {
        return h(this.k ? w() - 1 : 0);
    }

    private View N() {
        return h(this.k ? 0 : w() - 1);
    }

    private int a(int i, bz bzVar, State state, boolean z) {
        int d = this.j.d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -c(-d, bzVar, state);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.j.d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.j.a(i2);
        return d + i2;
    }

    private View a(boolean z, boolean z2) {
        return this.k ? a(w() - 1, -1, z, z2) : a(0, w(), z, z2);
    }

    private void a(int i, int i2) {
        this.a.c = this.j.d() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void a(int i, int i2, boolean z, State state) {
        int i3 = -1;
        int i4 = 1;
        this.a.l = l();
        this.a.h = b(state);
        this.a.f = i;
        View N;
        be beVar;
        if (i == 1) {
            be beVar2 = this.a;
            beVar2.h += this.j.g();
            N = N();
            beVar = this.a;
            if (!this.k) {
                i3 = 1;
            }
            beVar.e = i3;
            this.a.d = d(N) + this.a.e;
            this.a.b = this.j.b(N);
            i3 = this.j.b(N) - this.j.d();
        } else {
            N = M();
            beVar = this.a;
            beVar.h += this.j.c();
            beVar = this.a;
            if (!this.k) {
                i4 = -1;
            }
            beVar.e = i4;
            this.a.d = d(N) + this.a.e;
            this.a.b = this.j.a(N);
            i3 = (-this.j.a(N)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            be beVar3 = this.a;
            beVar3.c -= i3;
        }
        this.a.g = i3;
    }

    private void a(bc bcVar) {
        a(bcVar.b, bcVar.c);
    }

    private void a(bz bzVar, int i) {
        if (i >= 0) {
            int w = w();
            int i2;
            if (this.k) {
                for (i2 = w - 1; i2 >= 0; i2--) {
                    View h = h(i2);
                    if (this.j.b(h) > i || this.j.c(h) > i) {
                        a(bzVar, w - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < w; i2++) {
                View h2 = h(i2);
                if (this.j.b(h2) > i || this.j.c(h2) > i) {
                    a(bzVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void a(bz bzVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, bzVar);
                }
                return;
            }
            while (i > i2) {
                a(i, bzVar);
                i--;
            }
        }
    }

    private void a(bz bzVar, State state, bc bcVar) {
        if (!a(state, bcVar) && !b(bzVar, state, bcVar)) {
            bcVar.b();
            bcVar.b = this.d ? state.e() - 1 : 0;
        }
    }

    private void a(bz bzVar, be beVar) {
        if (beVar.a && !beVar.l) {
            if (beVar.f == -1) {
                b(bzVar, beVar.g);
            } else {
                a(bzVar, beVar.g);
            }
        }
    }

    private boolean a(State state, bc bcVar) {
        boolean z = false;
        if (state.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= state.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        bcVar.b = this.l;
        if (this.n != null && this.n.a()) {
            bcVar.d = this.n.c;
            if (bcVar.d) {
                bcVar.c = this.j.d() - this.n.b;
                return true;
            }
            bcVar.c = this.j.c() + this.n.b;
            return true;
        } else if (this.m == Integer.MIN_VALUE) {
            View c = c(this.l);
            if (c == null) {
                if (w() > 0) {
                    if ((this.l < d(h(0))) == this.k) {
                        z = true;
                    }
                    bcVar.d = z;
                }
                bcVar.b();
                return true;
            } else if (this.j.e(c) > this.j.f()) {
                bcVar.b();
                return true;
            } else if (this.j.a(c) - this.j.c() < 0) {
                bcVar.c = this.j.c();
                bcVar.d = false;
                return true;
            } else if (this.j.d() - this.j.b(c) < 0) {
                bcVar.c = this.j.d();
                bcVar.d = true;
                return true;
            } else {
                bcVar.c = bcVar.d ? this.j.b(c) + this.j.b() : this.j.a(c);
                return true;
            }
        } else {
            bcVar.d = this.k;
            if (this.k) {
                bcVar.c = this.j.d() - this.m;
                return true;
            }
            bcVar.c = this.j.c() + this.m;
            return true;
        }
    }

    private int b(int i, bz bzVar, State state, boolean z) {
        int c = i - this.j.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, bzVar, state);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.j.c();
        if (i2 <= 0) {
            return c;
        }
        this.j.a(-i2);
        return c - i2;
    }

    private View b(boolean z, boolean z2) {
        return this.k ? a(0, w(), z, z2) : a(w() - 1, -1, z, z2);
    }

    private void b(bc bcVar) {
        h(bcVar.b, bcVar.c);
    }

    private void b(bz bzVar, int i) {
        int w = w();
        if (i >= 0) {
            int e = this.j.e() - i;
            int i2;
            if (this.k) {
                for (i2 = 0; i2 < w; i2++) {
                    View h = h(i2);
                    if (this.j.a(h) < e || this.j.d(h) < e) {
                        a(bzVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = w - 1; i2 >= 0; i2--) {
                View h2 = h(i2);
                if (this.j.a(h2) < e || this.j.d(h2) < e) {
                    a(bzVar, w - 1, i2);
                    return;
                }
            }
        }
    }

    private void b(bz bzVar, State state, int i, int i2) {
        if (state.b() && w() != 0 && !state.a() && b()) {
            int i3 = 0;
            int i4 = 0;
            List c = bzVar.c();
            int size = c.size();
            int d = d(h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                ce ceVar = (ce) c.get(i5);
                if (ceVar.l()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((ceVar.getLayoutPosition() < d) != this.k ? -1 : 1) == -1) {
                        i7 = this.j.e(ceVar.itemView) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.j.e(ceVar.itemView) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.a.k = c;
            if (i3 > 0) {
                h(d(M()), i);
                this.a.h = i3;
                this.a.c = 0;
                this.a.a();
                a(bzVar, this.a, state, false);
            }
            if (i4 > 0) {
                a(d(N()), i2);
                this.a.h = i4;
                this.a.c = 0;
                this.a.a();
                a(bzVar, this.a, state, false);
            }
            this.a.k = null;
        }
    }

    private boolean b(bz bzVar, State state, bc bcVar) {
        boolean z = false;
        if (w() == 0) {
            return false;
        }
        View F = F();
        if (F != null && bcVar.a(F, state)) {
            bcVar.a(F, d(F));
            return true;
        } else if (this.b != this.d) {
            return false;
        } else {
            F = bcVar.d ? f(bzVar, state) : g(bzVar, state);
            if (F == null) {
                return false;
            }
            bcVar.b(F, d(F));
            if (!state.a() && b()) {
                if (this.j.a(F) >= this.j.d() || this.j.b(F) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    bcVar.c = bcVar.d ? this.j.d() : this.j.c();
                }
            }
            return true;
        }
    }

    private View f(bz bzVar, State state) {
        return this.k ? h(bzVar, state) : i(bzVar, state);
    }

    private View g(bz bzVar, State state) {
        return this.k ? i(bzVar, state) : h(bzVar, state);
    }

    private View h(bz bzVar, State state) {
        return a(bzVar, state, 0, w(), state.e());
    }

    private void h(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private int i(State state) {
        boolean z = false;
        if (w() == 0) {
            return 0;
        }
        j();
        bn bnVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return ck.a(state, bnVar, a, b(z, true), this, this.e, this.k);
    }

    private View i(bz bzVar, State state) {
        return a(bzVar, state, w() - 1, -1, state.e());
    }

    private int j(State state) {
        boolean z = false;
        if (w() == 0) {
            return 0;
        }
        j();
        bn bnVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return ck.a(state, bnVar, a, b(z, true), this, this.e);
    }

    private View j(bz bzVar, State state) {
        return this.k ? l(bzVar, state) : m(bzVar, state);
    }

    private int k(State state) {
        boolean z = false;
        if (w() == 0) {
            return 0;
        }
        j();
        bn bnVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return ck.b(state, bnVar, a, b(z, true), this, this.e);
    }

    private View k(bz bzVar, State state) {
        return this.k ? m(bzVar, state) : l(bzVar, state);
    }

    private View l(bz bzVar, State state) {
        return c(0, w());
    }

    private View m(bz bzVar, State state) {
        return c(w() - 1, -1);
    }

    public int a(int i, bz bzVar, State state) {
        return this.i == 1 ? 0 : c(i, bzVar, state);
    }

    int a(bz bzVar, be beVar, State state, boolean z) {
        int i = beVar.c;
        if (beVar.g != Integer.MIN_VALUE) {
            if (beVar.c < 0) {
                beVar.g += beVar.c;
            }
            a(bzVar, beVar);
        }
        int i2 = beVar.c + beVar.h;
        bd bdVar = this.g;
        while (true) {
            if ((!beVar.l && i2 <= 0) || !beVar.a(state)) {
                break;
            }
            bdVar.a();
            a(bzVar, state, beVar, bdVar);
            if (!bdVar.b) {
                beVar.b += bdVar.a * beVar.f;
                if (!(bdVar.c && this.a.k == null && state.a())) {
                    beVar.c -= bdVar.a;
                    i2 -= bdVar.a;
                }
                if (beVar.g != Integer.MIN_VALUE) {
                    beVar.g += bdVar.a;
                    if (beVar.c < 0) {
                        beVar.g += beVar.c;
                    }
                    a(bzVar, beVar);
                }
                if (z && bdVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - beVar.c;
    }

    public LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        int i3 = 320;
        j();
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return this.i == 0 ? this.r.a(i, i2, i4, i3) : this.s.a(i, i2, i4, i3);
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
                if (((LayoutParams) h.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.j.a(h) < d && this.j.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
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
        L();
        if (w() == 0) {
            return null;
        }
        int e = e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        j();
        j();
        a(e, (int) (0.33333334f * ((float) this.j.f())), false, state);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(bzVar, this.a, state, true);
        View k = e == -1 ? k(bzVar, state) : j(bzVar, state);
        View M = e == -1 ? M() : N();
        return M.hasFocusable() ? k == null ? null : M : k;
    }

    public void a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.i != 0) {
            i = i2;
        }
        if (w() != 0 && i != 0) {
            j();
            a(i > 0 ? 1 : -1, Math.abs(i), true, state);
            a(state, this.a, layoutPrefetchRegistry);
        }
    }

    public void a(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2;
        boolean z;
        if (this.n == null || !this.n.a()) {
            L();
            boolean z2 = this.k;
            if (this.l == -1) {
                i2 = z2 ? i - 1 : 0;
                z = z2;
            } else {
                i2 = this.l;
                z = z2;
            }
        } else {
            z = this.n.c;
            i2 = this.n.a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            p();
        }
    }

    public void a(State state) {
        super.a(state);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(State state, be beVar, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = beVar.d;
        if (i >= 0 && i < state.e()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(0, beVar.g));
        }
    }

    public void a(RecyclerView recyclerView, State state, int i) {
        SmoothScroller bfVar = new bf(recyclerView.getContext());
        bfVar.d(i);
        a(bfVar);
    }

    public void a(RecyclerView recyclerView, bz bzVar) {
        super.a(recyclerView, bzVar);
        if (this.f) {
            c(bzVar);
            bzVar.a();
        }
    }

    void a(bz bzVar, State state, bc bcVar, int i) {
    }

    void a(bz bzVar, State state, be beVar, bd bdVar) {
        View a = beVar.a(bzVar);
        if (a == null) {
            bdVar.b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (beVar.k == null) {
            if (this.k == (beVar.f == -1)) {
                b(a);
            } else {
                b(a, 0);
            }
        } else {
            if (this.k == (beVar.f == -1)) {
                a(a);
            } else {
                a(a, 0);
            }
        }
        a(a, 0, 0);
        bdVar.a = this.j.e(a);
        if (this.i == 1) {
            int z;
            if (i()) {
                z = z() - D();
                f = z - this.j.f(a);
            } else {
                f = B();
                z = this.j.f(a) + f;
            }
            if (beVar.f == -1) {
                i = beVar.b;
                i2 = beVar.b - bdVar.a;
                i3 = z;
            } else {
                i2 = beVar.b;
                i = bdVar.a + beVar.b;
                i3 = z;
            }
        } else {
            i2 = C();
            i = i2 + this.j.f(a);
            if (beVar.f == -1) {
                f = beVar.b - bdVar.a;
                i3 = beVar.b;
            } else {
                f = beVar.b;
                i3 = beVar.b + bdVar.a;
            }
        }
        a(a, f, i2, i3, i);
        if (layoutParams.d() || layoutParams.e()) {
            bdVar.c = true;
        }
        bdVar.d = a.hasFocusable();
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (w() > 0) {
            accessibilityEvent.setFromIndex(n());
            accessibilityEvent.setToIndex(o());
        }
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (this.d != z) {
            this.d = z;
            p();
        }
    }

    public int b(int i, bz bzVar, State state) {
        return this.i == 0 ? 0 : c(i, bzVar, state);
    }

    protected int b(State state) {
        return state.d() ? this.j.f() : 0;
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i || this.j == null) {
                this.j = bn.a(this, i);
                this.o.a = this.j;
                this.i = i;
                p();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void b(int i, int i2) {
        this.l = i;
        this.m = i2;
        if (this.n != null) {
            this.n.b();
        }
        p();
    }

    public void b(boolean z) {
        a(null);
        if (z != this.c) {
            this.c = z;
            p();
        }
    }

    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    int c(int i, bz bzVar, State state) {
        if (w() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        j();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        int a = this.a.g + a(bzVar, this.a, state, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    public int c(State state) {
        return i(state);
    }

    public View c(int i) {
        int w = w();
        if (w == 0) {
            return null;
        }
        int d = i - d(h(0));
        if (d >= 0 && d < w) {
            View h = h(d);
            if (d(h) == i) {
                return h;
            }
        }
        return super.c(i);
    }

    View c(int i, int i2) {
        j();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return h(i);
        }
        int i3;
        int i4;
        if (this.j.a(h(i)) < this.j.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.i == 0 ? this.r.a(i, i2, i3, i4) : this.s.a(i, i2, i3, i4);
    }

    public void c(bz bzVar, State state) {
        int i = -1;
        if (!(this.n == null && this.l == -1) && state.e() == 0) {
            c(bzVar);
            return;
        }
        int i2;
        int d;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        j();
        this.a.a = false;
        L();
        View F = F();
        if (!this.o.e || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.d = this.k ^ this.d;
            a(bzVar, state, this.o);
            this.o.e = true;
        } else if (F != null && (this.j.a(F) >= this.j.d() || this.j.b(F) <= this.j.c())) {
            this.o.a(F, d(F));
        }
        int b = b(state);
        if (this.a.j >= 0) {
            i2 = 0;
        } else {
            i2 = b;
            b = 0;
        }
        i2 += this.j.c();
        b += this.j.g();
        if (!(!state.a() || this.l == -1 || this.m == Integer.MIN_VALUE)) {
            View c = c(this.l);
            if (c != null) {
                if (this.k) {
                    d = (this.j.d() - this.j.b(c)) - this.m;
                } else {
                    d = this.m - (this.j.a(c) - this.j.c());
                }
                if (d > 0) {
                    i2 += d;
                } else {
                    b -= d;
                }
            }
        }
        if (this.o.d) {
            if (this.k) {
                i = 1;
            }
        } else if (!this.k) {
            i = 1;
        }
        a(bzVar, state, this.o, i);
        a(bzVar);
        this.a.l = l();
        this.a.i = state.a();
        if (this.o.d) {
            b(this.o);
            this.a.h = i2;
            a(bzVar, this.a, state, false);
            i2 = this.a.b;
            d = this.a.d;
            if (this.a.c > 0) {
                b += this.a.c;
            }
            a(this.o);
            this.a.h = b;
            be beVar = this.a;
            beVar.d += this.a.e;
            a(bzVar, this.a, state, false);
            i = this.a.b;
            if (this.a.c > 0) {
                b = this.a.c;
                h(d, i2);
                this.a.h = b;
                a(bzVar, this.a, state, false);
                b = this.a.b;
            } else {
                b = i2;
            }
            i2 = b;
            b = i;
        } else {
            a(this.o);
            this.a.h = b;
            a(bzVar, this.a, state, false);
            b = this.a.b;
            i = this.a.d;
            if (this.a.c > 0) {
                i2 += this.a.c;
            }
            b(this.o);
            this.a.h = i2;
            be beVar2 = this.a;
            beVar2.d += this.a.e;
            a(bzVar, this.a, state, false);
            i2 = this.a.b;
            if (this.a.c > 0) {
                d = this.a.c;
                a(i, b);
                this.a.h = d;
                a(bzVar, this.a, state, false);
                b = this.a.b;
            }
        }
        if (w() > 0) {
            int b2;
            if ((this.k ^ this.d) != 0) {
                i = a(b, bzVar, state, true);
                i2 += i;
                b += i;
                b2 = b(i2, bzVar, state, false);
                i2 += b2;
                b += b2;
            } else {
                i = b(i2, bzVar, state, true);
                i2 += i;
                b += i;
                b2 = a(b, bzVar, state, false);
                i2 += b2;
                b += b2;
            }
        }
        b(bzVar, state, i2, b);
        if (state.a()) {
            this.o.a();
        } else {
            this.j.a();
        }
        this.b = this.d;
    }

    public boolean c() {
        return true;
    }

    public PointF computeScrollVectorForPosition(int i) {
        int i2 = 1;
        boolean z = false;
        if (w() == 0) {
            return null;
        }
        if (i < d(h(0))) {
            z = true;
        }
        if (z != this.k) {
            i2 = -1;
        }
        return this.i == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public int d(State state) {
        return i(state);
    }

    public Parcelable d() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        Parcelable savedState = new SavedState();
        if (w() > 0) {
            j();
            boolean z = this.b ^ this.k;
            savedState.c = z;
            View N;
            if (z) {
                N = N();
                savedState.b = this.j.d() - this.j.b(N);
                savedState.a = d(N);
                return savedState;
            }
            N = M();
            savedState.a = d(N);
            savedState.b = this.j.a(N) - this.j.c();
            return savedState;
        }
        savedState.b();
        return savedState;
    }

    public void d(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        p();
    }

    int e(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.i == 1 || !i()) ? -1 : 1;
            case 2:
                return this.i == 1 ? 1 : !i() ? 1 : -1;
            case 17:
                return this.i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int e(State state) {
        return j(state);
    }

    public boolean e() {
        return this.i == 0;
    }

    public int f(State state) {
        return j(state);
    }

    public boolean f() {
        return this.i == 1;
    }

    public int g(State state) {
        return k(state);
    }

    public boolean g() {
        return this.d;
    }

    public int h() {
        return this.i;
    }

    public int h(State state) {
        return k(state);
    }

    protected boolean i() {
        return u() == 1;
    }

    void j() {
        if (this.a == null) {
            this.a = k();
        }
    }

    be k() {
        return new be();
    }

    boolean l() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    boolean m() {
        return (y() == 1073741824 || x() == 1073741824 || !K()) ? false : true;
    }

    public int n() {
        View a = a(0, w(), false, true);
        return a == null ? -1 : d(a);
    }

    public int o() {
        View a = a(w() - 1, -1, false, true);
        return a == null ? -1 : d(a);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void prepareForDrop(View view, View view2, int i, int i2) {
        Object obj;
        a("Cannot drop a view during a scroll or layout calculation");
        j();
        L();
        int d = d(view);
        int d2 = d(view2);
        if (d < d2) {
            obj = 1;
        } else {
            d = -1;
        }
        if (this.k) {
            if (obj == 1) {
                b(d2, this.j.d() - (this.j.a(view2) + this.j.e(view)));
            } else {
                b(d2, this.j.d() - this.j.b(view2));
            }
        } else if (obj == -1) {
            b(d2, this.j.a(view2));
        } else {
            b(d2, this.j.b(view2) - this.j.e(view));
        }
    }
}
