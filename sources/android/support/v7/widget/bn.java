package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class bn {
    protected final LayoutManager a;
    final Rect b;
    private int c;

    private bn(LayoutManager layoutManager) {
        this.c = Integer.MIN_VALUE;
        this.b = new Rect();
        this.a = layoutManager;
    }

    /* synthetic */ bn(LayoutManager layoutManager, AnonymousClass1 anonymousClass1) {
        this(layoutManager);
    }

    public static bn a(LayoutManager layoutManager) {
        return new bn(layoutManager) {
            public int a(View view) {
                return this.a.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public void a(int i) {
                this.a.i(i);
            }

            public int b(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.a.j(view);
            }

            public int c() {
                return this.a.B();
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            public int d() {
                return this.a.z() - this.a.D();
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            public int e() {
                return this.a.z();
            }

            public int e(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (this.a.f(view) + layoutParams.leftMargin);
            }

            public int f() {
                return (this.a.z() - this.a.B()) - this.a.D();
            }

            public int f(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (this.a.g(view) + layoutParams.topMargin);
            }

            public int g() {
                return this.a.D();
            }

            public int h() {
                return this.a.x();
            }

            public int i() {
                return this.a.y();
            }
        };
    }

    public static bn a(LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return a(layoutManager);
            case 1:
                return b(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static bn b(LayoutManager layoutManager) {
        return new bn(layoutManager) {
            public int a(View view) {
                return this.a.i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public void a(int i) {
                this.a.j(i);
            }

            public int b(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.a.k(view);
            }

            public int c() {
                return this.a.C();
            }

            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            public int d() {
                return this.a.A() - this.a.E();
            }

            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            public int e() {
                return this.a.A();
            }

            public int e(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (this.a.g(view) + layoutParams.topMargin);
            }

            public int f() {
                return (this.a.A() - this.a.C()) - this.a.E();
            }

            public int f(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (this.a.f(view) + layoutParams.leftMargin);
            }

            public int g() {
                return this.a.E();
            }

            public int h() {
                return this.a.y();
            }

            public int i() {
                return this.a.x();
            }
        };
    }

    public abstract int a(View view);

    public void a() {
        this.c = f();
    }

    public abstract void a(int i);

    public int b() {
        return Integer.MIN_VALUE == this.c ? 0 : f() - this.c;
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();
}
