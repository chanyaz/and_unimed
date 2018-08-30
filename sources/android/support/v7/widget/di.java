package android.support.v7.widget;

class di {
    int a = 0;
    int b;
    int c;
    int d;
    int e;

    di() {
    }

    int a(int i, int i2) {
        return i > i2 ? 1 : i == i2 ? 2 : 4;
    }

    void a() {
        this.a = 0;
    }

    void a(int i) {
        this.a |= i;
    }

    void a(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    boolean b() {
        return ((this.a & 7) == 0 || (this.a & (a(this.d, this.b) << 0)) != 0) ? ((this.a & 112) == 0 || (this.a & (a(this.d, this.c) << 4)) != 0) ? ((this.a & 1792) == 0 || (this.a & (a(this.e, this.b) << 8)) != 0) ? (this.a & 28672) == 0 || (this.a & (a(this.e, this.c) << 12)) != 0 : false : false : false;
    }
}
