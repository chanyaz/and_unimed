package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import java.util.ArrayList;

class cu {
    ArrayList<View> a = new ArrayList();
    int b = Integer.MIN_VALUE;
    int c = Integer.MIN_VALUE;
    int d = 0;
    final int e;
    final /* synthetic */ StaggeredGridLayoutManager f;

    cu(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f = staggeredGridLayoutManager;
        this.e = i;
    }

    int a(int i) {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        if (this.a.size() == 0) {
            return i;
        }
        a();
        return this.b;
    }

    int a(int i, int i2, boolean z) {
        return a(i, i2, false, false, z);
    }

    int a(int i, int i2, boolean z, boolean z2, boolean z3) {
        int c = this.f.b.c();
        int d = this.f.b.d();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            Object obj;
            View view = (View) this.a.get(i);
            int a = this.f.b.a(view);
            int b = this.f.b.b(view);
            if (z3) {
                obj = a <= d ? 1 : null;
            } else if (a < d) {
                int obj2 = 1;
            } else {
                obj2 = null;
            }
            Object obj3 = z3 ? b >= c ? 1 : null : b > c ? 1 : null;
            if (!(obj2 == null || obj3 == null)) {
                if (z && z2) {
                    if (a >= c && b <= d) {
                        return this.f.d(view);
                    }
                } else if (z2) {
                    return this.f.d(view);
                } else {
                    if (a < c || b > d) {
                        return this.f.d(view);
                    }
                }
            }
            i += i3;
        }
        return -1;
    }

    public View a(int i, int i2) {
        View view = null;
        int i3;
        View view2;
        if (i2 == -1) {
            int size = this.a.size();
            i3 = 0;
            while (i3 < size) {
                view2 = (View) this.a.get(i3);
                if ((this.f.d && this.f.d(view2) <= i) || ((!this.f.d && this.f.d(view2) >= i) || !view2.hasFocusable())) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        i3 = this.a.size() - 1;
        while (i3 >= 0) {
            view2 = (View) this.a.get(i3);
            if (this.f.d && this.f.d(view2) >= i) {
                break;
            } else if (this.f.d || this.f.d(view2) > i) {
                if (!view2.hasFocusable()) {
                    break;
                }
                i3--;
                view = view2;
            } else {
                return view;
            }
        }
        return view;
    }

    void a() {
        View view = (View) this.a.get(0);
        LayoutParams c = c(view);
        this.b = this.f.b.a(view);
        if (c.b) {
            FullSpanItem f = this.f.h.f(c.f());
            if (f != null && f.b == -1) {
                this.b -= f.a(this.e);
            }
        }
    }

    void a(View view) {
        LayoutParams c = c(view);
        c.a = this;
        this.a.add(0, view);
        this.b = Integer.MIN_VALUE;
        if (this.a.size() == 1) {
            this.c = Integer.MIN_VALUE;
        }
        if (c.d() || c.e()) {
            this.d += this.f.b.e(view);
        }
    }

    void a(boolean z, int i) {
        int b = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
        e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.f.b.d()) {
                return;
            }
            if (z || b <= this.f.b.c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.c = b;
                this.b = b;
            }
        }
    }

    int b() {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        a();
        return this.b;
    }

    int b(int i) {
        if (this.c != Integer.MIN_VALUE) {
            return this.c;
        }
        if (this.a.size() == 0) {
            return i;
        }
        c();
        return this.c;
    }

    void b(View view) {
        LayoutParams c = c(view);
        c.a = this;
        this.a.add(view);
        this.c = Integer.MIN_VALUE;
        if (this.a.size() == 1) {
            this.b = Integer.MIN_VALUE;
        }
        if (c.d() || c.e()) {
            this.d += this.f.b.e(view);
        }
    }

    LayoutParams c(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    void c() {
        View view = (View) this.a.get(this.a.size() - 1);
        LayoutParams c = c(view);
        this.c = this.f.b.b(view);
        if (c.b) {
            FullSpanItem f = this.f.h.f(c.f());
            if (f != null && f.b == 1) {
                this.c = f.a(this.e) + this.c;
            }
        }
    }

    void c(int i) {
        this.b = i;
        this.c = i;
    }

    int d() {
        if (this.c != Integer.MIN_VALUE) {
            return this.c;
        }
        c();
        return this.c;
    }

    void d(int i) {
        if (this.b != Integer.MIN_VALUE) {
            this.b += i;
        }
        if (this.c != Integer.MIN_VALUE) {
            this.c += i;
        }
    }

    void e() {
        this.a.clear();
        f();
        this.d = 0;
    }

    void f() {
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
    }

    void g() {
        int size = this.a.size();
        View view = (View) this.a.remove(size - 1);
        LayoutParams c = c(view);
        c.a = null;
        if (c.d() || c.e()) {
            this.d -= this.f.b.e(view);
        }
        if (size == 1) {
            this.b = Integer.MIN_VALUE;
        }
        this.c = Integer.MIN_VALUE;
    }

    void h() {
        View view = (View) this.a.remove(0);
        LayoutParams c = c(view);
        c.a = null;
        if (this.a.size() == 0) {
            this.c = Integer.MIN_VALUE;
        }
        if (c.d() || c.e()) {
            this.d -= this.f.b.e(view);
        }
        this.b = Integer.MIN_VALUE;
    }

    public int i() {
        return this.d;
    }

    public int j() {
        return this.f.d ? a(this.a.size() - 1, -1, true) : a(0, this.a.size(), true);
    }

    public int k() {
        return this.f.d ? a(0, this.a.size(), true) : a(this.a.size() - 1, -1, true);
    }
}
