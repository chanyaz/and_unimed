package android.support.v7.widget;

class al {
    public ce a;
    public ce b;
    public int c;
    public int d;
    public int e;
    public int f;

    private al(ce ceVar, ce ceVar2) {
        this.a = ceVar;
        this.b = ceVar2;
    }

    al(ce ceVar, ce ceVar2, int i, int i2, int i3, int i4) {
        this(ceVar, ceVar2);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}
