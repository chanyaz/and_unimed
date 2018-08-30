package com.google.common.base;

abstract class z extends a<String> {
    final CharSequence b;
    final d c;
    final boolean d;
    int e = 0;
    int f;

    protected z(Splitter splitter, CharSequence charSequence) {
        this.c = splitter.a;
        this.d = splitter.b;
        this.f = splitter.d;
        this.b = charSequence;
    }

    abstract int a(int i);

    abstract int b(int i);

    /* renamed from: c */
    protected String a() {
        int i = this.e;
        while (this.e != -1) {
            int a = a(this.e);
            if (a == -1) {
                a = this.b.length();
                this.e = -1;
            } else {
                this.e = b(a);
            }
            if (this.e == i) {
                this.e++;
                if (this.e >= this.b.length()) {
                    this.e = -1;
                }
            } else {
                int i2 = i;
                while (i2 < a && this.c.b(this.b.charAt(i2))) {
                    i2++;
                }
                i = a;
                while (i > i2 && this.c.b(this.b.charAt(i - 1))) {
                    i--;
                }
                if (this.d && i2 == i) {
                    i = this.e;
                } else {
                    if (this.f == 1) {
                        i = this.b.length();
                        this.e = -1;
                        while (i > i2 && this.c.b(this.b.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.f--;
                    }
                    return this.b.subSequence(i2, i).toString();
                }
            }
        }
        return (String) b();
    }
}
