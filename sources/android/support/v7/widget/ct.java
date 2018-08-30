package android.support.v7.widget;

import java.util.Arrays;

class ct {
    int a;
    int b;
    boolean c;
    boolean d;
    boolean e;
    int[] f;
    final /* synthetic */ StaggeredGridLayoutManager g;

    ct(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.g = staggeredGridLayoutManager;
        a();
    }

    void a() {
        this.a = -1;
        this.b = Integer.MIN_VALUE;
        this.c = false;
        this.d = false;
        this.e = false;
        if (this.f != null) {
            Arrays.fill(this.f, -1);
        }
    }

    void a(int i) {
        if (this.c) {
            this.b = this.g.b.d() - i;
        } else {
            this.b = this.g.b.c() + i;
        }
    }

    void a(cu[] cuVarArr) {
        int length = cuVarArr.length;
        if (this.f == null || this.f.length < length) {
            this.f = new int[this.g.a.length];
        }
        for (int i = 0; i < length; i++) {
            this.f[i] = cuVarArr[i].a(Integer.MIN_VALUE);
        }
    }

    void b() {
        this.b = this.c ? this.g.b.d() : this.g.b.c();
    }
}
